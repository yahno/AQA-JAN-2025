    package org.prog.sql;

//TODO: usual Homework: Create table Addresses, where you write
// Person's Name, LastName, City Name, Street Name, Address

//TODO: usual homework + : re-write this test using BeforeSuite and AfterSuite

//TODO: Homework * : Create table Phones : PhoneId, PhoneName, PhonePrice
// - using selenium go to allo.ua, search for a phone
// - get phone name
// - get phone price
// - store phone name and phone price to DB

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.prog.dto.PersonDto;
import org.prog.dto.ResultsDto;
import org.testng.annotations.Test;

import java.sql.*;
import java.util.List;

public class SQLHomeWork {
    //підключення
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
        List<PersonDto> persons2 = getRandomPeople();
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection =
                DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "user", "password");

        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO Persons2(FirstName, LastName, City, StreetName, StreetNumber) VALUES" +
                "(?, ?, ?, ?, ?)");

        for (PersonDto person : persons2) {
            preparedStatement.setString(1, person.getName().getFirst());
            preparedStatement.setString(2, person.getName().getLast());
            preparedStatement.setString(3, person.getLocation().getCity());
            preparedStatement.setString(4, person.getLocation().getStreet().getName());
            preparedStatement.setString(5, person.getLocation().getStreet().getNumber());
            try {
                preparedStatement.execute();
            } catch (SQLException e) {
                System.out.println("Failed to store in DB : " + person.getName().getFirst() + " " + person.getName().getLast());
            }
        }
        connection.close();
    }
    //
    private List<PersonDto> getRandomPeople(){
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://randomuser.me/");
        requestSpecification.basePath("/api");
        requestSpecification.queryParam("inc", "gender,name,nat,location");
        requestSpecification.queryParam("noinfo");
        requestSpecification.queryParam("results", "10  ");
        Response response = requestSpecification.get();

        return response.as(ResultsDto.class).getResults();

    }

}


