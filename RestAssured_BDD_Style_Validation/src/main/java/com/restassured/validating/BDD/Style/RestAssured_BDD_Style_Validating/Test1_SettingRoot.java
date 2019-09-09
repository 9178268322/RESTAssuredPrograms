package com.restassured.validating.BDD.Style.RestAssured_BDD_Style_Validating;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Test1_SettingRoot {

	    // test case without using root
	   //@Test
	    public void testWithoutRoot() {
	    	
	    	given().
	    	when().
	    	   		get("http://www.groupkt.com/country/get/iso2code/IN").
	    	then().
	    	body("RestResponse.result.name", is("India")).
	        body("RestResponse.result.alpha2_code", is("IN")).
	        body("RestResponse.result.alpha3_code", is("IND"));
	    }
	    
	    // Recommended way to test all parameters using root feature
	  // @Test
	    public void testWithRoot() {
	    	
	        given().
	        when().
	        
	        		get("http://www.groupkt.com/country/get/iso2code/IN").
	        then().
	        root("RestResponse.result").
	        body("alpha2_code", is("IN")).
	        body("name", is("India")).
	        body("alpha3_code", is("IND"));	
	    }
	    
	    // We can detach root path in between
	  // @Test
	    public void testDetachRoot() {
	    	
	    	given().
	        when().
	        
	        		get("http://www.groupkt.com/country/get/iso2code/IN").
	        then().
	        root("RestResponse.result").
	        body("alpha2_code", is("IN")).
	        body("name", is("India")).
	        detachRoot("result").
	        body("result.alpha3_code", is("IND"));
	    }
}
