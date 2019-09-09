package com.restassured.validating.BDD.Style.RestAssured_BDD_Style_Validating;

import static io.restassured.RestAssured.get;

import java.io.IOException;
import java.io.InputStream;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Test5_ReadResponseInDiffWays {

	/*
	 * To get all response as string
	 */
	//@Test
	public void testGetResponseAsString() {
		
		String responseAsString = get("http://www.groupkt.com/country/search?text=lands").asString();
		System.out.println("My Response"+responseAsString);
	}

	
	// To get response as length using asByteArray
	//@Test
	public void testGetResponseAsByteArray() {
		
		byte[] byteArray = get("http://www.groupkt.com/country/get/iso2code/IN").asByteArray();
		
		System.out.println(byteArray.length);
	}
	
	/*
	 * Extract details using path
	 */
	//@Test
	public void testExtractDetailsUsingPath() {
		
		String href = 
		
		given().
		when().
		     get("https://jsonplaceholder.typicode.com/photos/1").
		then().
		contentType(ContentType.JSON).
		body("albumId", equalTo(1)).
		extract().
		path("url");
		
		System.out.println(href);
		
	    given().
		when().
		   get(href).
		then().
		statusCode(200);
	}
	
	/*
	 * Extract details using response for further use
	 */
	//@Test
	public void testExtractDetailsUsingRespnse() {
		
		Response res =  
		
		         get("https://jsonplaceholder.typicode.com/photos/1").
		then().
		extract().
		response();
		
		
		System.out.println("Content Type = "+res.contentType());
		System.out.println("Href = "+res.path("url"));
		System.out.println("Status Code = "+res.getStatusCode());
	}
}
