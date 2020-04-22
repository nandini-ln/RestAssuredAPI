package restassuredapi;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.List;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TestCase_2 {
	@Test
	public void tc_02(){
		
		//1st approach
		given().get("http://localhost:8080/student/list")
		.then().statusCode(200);
		
		//2nd approach
		given().baseUri("http://localhost:8080/").and().basePath("/student")
		.when().get("/list")
		.then().statusCode(200).and().time(lessThan(5000L));
		
		//3rd approach
		baseURI="http://localhost:8080/";
		basePath="/student";
		
		given()
		.when().get("/list")
		.then().statusCode(200).and().time(lessThan(5000L))
		.and().header("Content-Type", "application/json;charset=UTF-8")
		.and().body("[0].firstName", equalTo("Vernon"));
		
		JsonPath jp = given().when().get("/list").jsonPath();
		System.out.println(jp.get());
		System.out.println("Name :" + jp.get("[6].firstName"));
		List<String> data = jp.get("[6].courses");
		System.out.println("Courses :" + data.get(0) + "," + data.get(1)+ "," + data.get(2));
		
		
		//One more scenario
		/*
		 * baseURI = "https://reqres.in/"; basePath = "/api"; when().get("users?page=2")
		 * .then().statusCode(200);
		 */
		 
		
	}

	@Test
	public void tc_03(){
		baseURI="http://localhost:8080/";
		basePath="/student";
		
		given()
		.when().get("/50")
		.then().statusCode(200).and().body("firstName", equalTo("Yoshio"));
	}
	
	@Test
	public void tc_04(){
		baseURI="http://localhost:8080/";
		basePath="/student";
		
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("programme","Computer Science");
		
		JsonPath  jp = given().params(hm).get("/list").jsonPath();
		System.out.println(jp.get());
		
				
		
		
	}
}
