package restassuredapi;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class TestPutRequest {
@Test	
public void put_test_01(){
		
		baseURI="http://localhost:8080/";
		basePath="/student";
	
		//2nd approach
		given().contentType(ContentType.JSON).body(new File("C:\\Users\\Acer\\Desktop\\StudentApplication\\reqBody.json"))
		.when().put("/103")
		.then().statusCode(201).and().body("msg", equalTo("Student Updated"));
	}

}
