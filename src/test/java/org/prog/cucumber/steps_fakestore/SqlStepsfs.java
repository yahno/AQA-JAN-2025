package org.prog.cucumber.steps_fakestore;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.prog.dto_fs.GoodsDto;
import org.prog.dto_fs.ResultsDtoGoods;
import org.testng.annotations.Test;

import java.sql.*;
import java.util.List;

public class SqlStepsfs {
    //записуємо в базу даних

    @When("I store good title, price and good category to DB")
    public void sqlWrite() throws SQLException, ClassNotFoundException {
        //List<GoodsDto> goods = getGoods();
        List<GoodsDto> goods = RestStepsfs.getGoods();
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection =
                DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "user", "password");

        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO Goods (Title, Price, Category) VALUES " + "(?, ?, ?)");
        for (GoodsDto good : goods) {
            preparedStatement.setString(1, good.getTitle());
            preparedStatement.setFloat(2, good.getPrice());
            preparedStatement.setString(3, good.getCategory());
            preparedStatement.executeUpdate();
        }
        connection.close();
    }

    @Then("I print that good title, price and specific category to console")
    public void sqlRead() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection =
                DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "user", "password");

        PreparedStatement preparedStatement = connection.prepareStatement("select * from Goods where Category= ?");
        preparedStatement.setString(1, "jewelery");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString("Title") + " " + resultSet.getFloat("Price"));
        }
        connection.close();
    }
}
