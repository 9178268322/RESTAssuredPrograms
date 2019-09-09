package com.restassured.validating.BDD.Style.RestAssured_BDD_Style_Validating;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TestXmlBasedResponse {

	    // to test xml response for single body content
		//@Test
		public void testSingleContent() {
			
			given().
			when().
			   get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/10").
			then().
			
			body("CUSTOMER.ID", equalTo("10")).
			log().all();
		}
		
		// To test xml response for multiple body content
		//@Test
		public void testMultipleContent() {
			
			given().
			when().
			     get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/10").
			then().body("CUSTOMER.FIRSTNAME", equalTo("Sue")).body("CUSTOMER.LASTNAME", equalTo("Fuller")).
			       body("CUSTOMER.STREET", equalTo("135 Upland Pl.")).body("CUSTOMER.CITY", equalTo("Dallas")).log().all();

		}
		
		// compare complete text in one go
		//@Test
		public void testCompleteTestInOneGo() {
			
			given().
			when().
				get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/10").
			then().body("CUSTOMER.text()", equalTo("10SueFuller135 Upland Pl.Dallas")).
			log().
			all();
		}
		
		// finding value by using xpath
		//@Test
		public void testUsingXpath() {
			
			given().
			when().
			   get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/10").
			then().
			body(hasXPath("/CUSTOMER/FIRSTNAME", containsString("Sue")));
			
		}
		
}
