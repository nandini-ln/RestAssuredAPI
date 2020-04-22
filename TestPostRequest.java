package restassuredapi;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class TestPostRequest {

	@Test
	public void post_test_01(){
		
		baseURI="http://localhost:8080/";
		basePath="/student";
		
		/*
		 * given().contentType(ContentType.JSON).body("{\r\n" +
		 * "    \"firstName\": \"Vinay\",\r\n" + "    \"lastName\": \"Choudry\",\r\n" +
		 * "    \"email\": \"Vinay1234@gmail.com\",\r\n" +
		 * "    \"programme\": \"Computer Science\",\r\n" + "    \"courses\": [\r\n" +
		 * "        \"JAVA\"\r\n" + "    ]\r\n" + "}") .when().post("/")
		 * .then().statusCode(201).and().body("msg", equalTo("Student added"));
		 */
		
		//2nd approach
		given().contentType(ContentType.JSON).body(new File("C:\\Users\\Acer\\Desktop\\StudentApplication\\reqBody.json"))
		.when().post("/")
		.then().statusCode(201).and().body("msg", equalTo("Student added"));
	}
}
