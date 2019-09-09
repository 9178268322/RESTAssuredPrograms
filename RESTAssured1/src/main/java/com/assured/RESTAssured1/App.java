package com.assured.RESTAssured1;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class App {

	// @Test
	public void get() {

		RestAssured.baseURI = "https://reqres.in";
		String endURL = "/api/users?page=2";
		RequestSpecification req = RestAssured.given();
		Response res = req.request(Method.GET, endURL);

		int statusCode = res.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		System.out.println("Response status code is :" + statusCode);

		System.out.println("Response payload is :" + res.asString());

		System.out.println("Response header is :" + res.getHeaders());

	}

	// @Test
	public void post() {

		RestAssured.baseURI = "https://reqres.in";
		String endURI = "/api/users";

		RequestSpecification req = RestAssured.given();

		req.header("Content-Type", "application/json");
		JSONObject jsonobj = new JSONObject();
		jsonobj.put("name", "Allen");
		jsonobj.put("job", "Tester");
		jsonobj.put("id", 45);
		String strJsonFormat = jsonobj.toJSONString();

		req.body(strJsonFormat);

		Response res = req.request(Method.POST, endURI);

		int statusCode = res.getStatusCode();
		Assert.assertEquals(statusCode, 201);
		System.out.println("Response status code is :" + statusCode);

		System.out.println("Response payload is :" + res.asString());

		System.out.println("Response header is :" + res.getHeaders());

	}

	// @Test
	public void put() {

		RestAssured.baseURI = "https://reqres.in";
		String endURI = "/api/users/2";

		RequestSpecification req = RestAssured.given();
		req.header("Content-Type", "application/json");

		JSONObject jsonobj = new JSONObject();
		jsonobj.put("name", "Samir");
		jsonobj.put("job", "Developer");
		jsonobj.put("id", 45);
		String strJsonFormat = jsonobj.toJSONString();

		req.body(strJsonFormat);

		Response res = req.request(Method.PUT, endURI);
		int statusCode = res.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		System.out.println("Response status code is :" + statusCode);

		System.out.println("Response payload is :" + res.asString());

		System.out.println("Response header is :" + res.getHeaders());

	}

	@Test
	public void delete() {

		RestAssured.baseURI = "https://reqres.in";
		String endURI = "/api/users/2";

		RequestSpecification req = RestAssured.given();
		Response res = req.request(Method.DELETE, endURI);

		int statusCode = res.getStatusCode();
		Assert.assertEquals(statusCode, 204);
		System.out.println("Response status code is :" + statusCode);

		System.out.println("Response payload is :" + res.asString());

		System.out.println("Response header is :" + res.getHeaders());
	}

}
