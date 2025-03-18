package org.prog.cucumber.steps_fakestore;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.prog.dto_fs.GoodsDto;
import org.prog.dto_fs.ResultsDtoGoods;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class SqlStepsfs {
    //записуємо в базу даних
    @Test
    public void sqlWrite() throws SQLException, ClassNotFoundException {
        List<GoodsDto> goods = getGoods();
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
    // метод getGoods, який повертає продкти з https://fakestoreapi за допомогою RestAssured
        private List<GoodsDto> getGoods() {
        RequestSpecification requestSpecification = RestAssured.given()
                .baseUri("https://fakestoreapi.com/products")
                .queryParam("inc", "title,price,category")
                .queryParam("results3", "3")
                .queryParam("limit", "3");



        Response response = requestSpecification.get();

        // Ось правильний спосіб десеріалізації масиву JSON у список
        return response.jsonPath().getList(".", GoodsDto.class);
    }
}
