package org.prog.rest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.core.IsEqual;
import org.prog.dto.ResultsDto;
import org.testng.annotations.Test;

import static com.google.common.base.Predicates.equalTo;

public class ApiTestsHW {
    @Test
    public void apiTestHW() {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://randomuser.me/");
        requestSpecification.basePath("/api");
        requestSpecification.queryParam("inc", "gender,name,nat,location");
        requestSpecification.queryParam("noinfo");
        requestSpecification.queryParam("results", "2");

        Response response = requestSpecification.get();

        ResultsDto results = response.as(ResultsDto.class);
        System.out.println(results.getResults().get(0).getName().getFirst());
        System.out.println(results.getResults().get(0).getName().getLast());

        response.prettyPrint();
        ValidatableResponse validatableResponse = response.then();
        validatableResponse.statusCode(200);
        validatableResponse.contentType(ContentType.JSON);
        validatableResponse.body("results[0].location.city", Matchers.notNullValue());

    }
}
