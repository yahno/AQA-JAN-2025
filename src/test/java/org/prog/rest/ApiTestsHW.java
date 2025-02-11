package org.prog.rest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.prog.dto.ResultsDto;
import org.testng.annotations.Test;

public class ApiTestsHW {
    @Test
    public void apiTestHW() {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://randomuser.me/");
        requestSpecification.basePath("/api");
        requestSpecification.queryParam("inc", "gender,name,nat,location");
        requestSpecification.queryParam("noinfo");
        requestSpecification.queryParam("results", "3");

        Response response = requestSpecification.get();

        ResultsDto results = response.as(ResultsDto.class);
        System.out.println(results.getResults().get(0).getName().getFirst());
        System.out.println(results.getResults().get(0).getName().getLast());
        response.prettyPrint();
    }
}
