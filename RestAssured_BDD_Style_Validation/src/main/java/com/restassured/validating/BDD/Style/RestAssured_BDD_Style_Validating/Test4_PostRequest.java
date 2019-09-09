package com.restassured.validating.BDD.Style.RestAssured_BDD_Style_Validating;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Test4_PostRequest {

	@Test
	public void testPostRequest() {
		
		given().
		   headers("AllenKey","AllenValue").
		   param("wfifrst", "first").
		   param("wlast","khat").
		when().
		   get("http://api.fonts.com/rest/json/Accounts").
		then().
		statusCode(400).
		log().all();
	}
}
