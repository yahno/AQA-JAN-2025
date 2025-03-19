package org.prog.cucumber.steps_fakestore;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.prog.dto_fs.GoodsDto;

import java.util.List;

public class RestStepsfs {
    @Given("Given I using restapi go to fakestore to request goods")
    // метод getGoods, який повертає продкти з https://fakestoreapi за допомогою RestAssured
    private List<GoodsDto> getGoods() {
        RequestSpecification requestSpecification = RestAssured.given()
                .baseUri("https://fakestoreapi.com/products")
                .queryParam("inc", "title,price,category")
                .queryParam("results3", "3")
                .queryParam("limit", "3");
        Response response = requestSpecification.get();

        // спосіб десеріалізації масиву JSON у список
        return response.jsonPath().getList(".", GoodsDto.class);
    }
}
