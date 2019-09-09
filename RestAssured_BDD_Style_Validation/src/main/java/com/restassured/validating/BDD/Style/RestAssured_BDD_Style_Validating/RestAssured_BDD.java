package com.restassured.validating.BDD.Style.RestAssured_BDD_Style_Validating;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class RestAssured_BDD {

				// simply checking status code
				//@Test
				public void testStatusCode() {
			
					given().
					when().
						get("https://jsonplaceholder.typicode.com/posts").
					then().
			        statusCode(200);
				}
				
				// it will verify code and print complete response on console
				//@Test
				public void testLogging() {
			
					given().
					when().
					    get("https://jsonplaceholder.typicode.com/posts").
					then().
			            log().all();
				}
			
				// verifying single content using org.hamcrest.Matchers library's equal
				// method
				//@Test
				public void testEqualToFunction() {
			
					given().
					when().
					    get("https://jsonplaceholder.typicode.com/posts/4").
					then()
						.body("id", equalTo(4));
				}
			
				//@Test
				public void test() {
			
					given().
					when().
					    get("https://reqres.in/api/users").
					then()
					//.log().all();
					.body("data.id", hasItems(1,2,3,4,5,6));
					//.body("data[3].id", equalTo(4));
					//.body("data[0].email", equalTo("george.bluth@reqres.in"));
					//.body("data[0].first_name", equalTo("George"));
					//.body("data[5].first_name", equalTo("Tracey"));
					//.body("data[5].first_name", equalTo("Tracey"), "data[4].first_name", equalTo("Charles"));
				}
				
				// verifying multiple content by using org.hamcrest.Matchers
				//@Test
				public void testHasItemFunction() {
			
					given().
					when().
					   get("http://services.groupkt.com/country/get/all").
					then().
					assertThat()
							.body("RestResponse.result.alpha2_code", hasItems("DZ", "AO"));
				}
			
				// Parameters and headers can be set
				//@Test
				public void testParametersAndHeaders() {
			
					given().
					   param("key1", "value1").
					   header("HeadA", "ValueA").
					when()
						.get("http://services.groupkt.com/country/get/iso2code/GB").
					then().
					statusCode(200).
					log().all();
				}
			
				/*
				 * using 'and' to increase code redability generaly it is used when writing
				 * in one line like xpath style
				 */
				//@Test
				public void testAndFeatureForReadability() {
		  	
					given().param("Key1", "value1").and().header("header1", "value2").when().get("http://services.groupkt.com/country/get/iso2code/GB").then().statusCode(200).and().body("RestResponse.result.name", equalTo("United Kingdom of Great Britain and Northern Ireland"));
				}

}
