package org.prog.cucumber.steps_amazon;

import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.prog.dto.PersonDto;
import org.prog.dto.ProductsDto;
import org.prog.dto.ResultsDto;
import org.prog.dto.ResultsDtoPr;
import org.prog.util.Container;
import org.testng.annotations.Test;

import java.sql.*;
import java.util.List;

public class SqlStepsAmazon {

    @Test
    public void sqlRead() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection =
                DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "user", "password");

        PreparedStatement preparedStatement = connection.prepareStatement("select * from Persons where Gender= ?");
        preparedStatement.setString(1, "female");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString("FirstName") + " " + resultSet.getString("LastName"));
        }
        connection.close();
    }

    @Test
    public void sqlWrite() throws SQLException, ClassNotFoundException {
        List<ProductsDto> products = getProducts();
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection =
                DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "user", "password");

        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO Persons (Title, Currency, Cost) VALUES " +
                        "(?, ?, ?)");

        for (ProductsDto product : products) {
            preparedStatement.setString(1, product.getTitle().getDisplayValue());
            preparedStatement.setString(2, product.getCost().getPrice().getCurrency());
            preparedStatement.setString(3, product.getCost().getPrice().getDisplayAmount());
            try {
                preparedStatement.execute();
            } catch (SQLException e) {
                System.out.println("Failed to store in DB : " + product.getTitle().getDisplayValue() + " " + product.getCost().getPrice());
            }
        }
        connection.close();
    }

    private List<ProductsDto> getProducts() {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://www.amazon.com");
        requestSpecification.basePath("/api");
        requestSpecification.queryParam("inc", "title,cost");
        requestSpecification.queryParam("noinfo");
        requestSpecification.queryParam("results2", "3");

        Response response = requestSpecification.get();
        return response.as(ResultsDtoPr.class).getResults2();
    }
}
