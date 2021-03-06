package restassuredapi;


import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

public class TestCase_1 {
	
	@Test
	public void tc_01(){
		Response response = RestAssured.get("http://localhost:8080/student/list");
		System.out.println(response.asString()); //1st way of printing the response
		
		System.out.println(response.getBody().asString());
		
		//Testing status code
		int actualResponseCode = response.getStatusCode();
		System.out.println(actualResponseCode);
		Assert.assertEquals(actualResponseCode, 200);
		
		//Testing response time
		long actualResponseTime = response.getTime();
		System.out.println(actualResponseTime);
		System.out.println(actualResponseTime<5000L);
		
		String actualheader = response.getHeader("Content-Type");
		System.out.println(actualheader);
		
		String Data = response.getBody().asString(); 
		String actualData = response.jsonPath().get("[5].firstName");
		System.out.println(actualData);
		Assert.assertEquals(actualData, "Harper");
		 
			
	}

}
