package com.google.stepdefinations;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import pojoclass.AppResponse;
import pojoclass.location;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.pojo.java.Response;
public class GoogleMapApi {
	
	
	@Test
	public void addMap() {
		RestAssured.baseURI="https://rahulshettyacademy.com";
		AppResponse app=new AppResponse();
		app.setAccuracy(50);
		app.setAddress("No:95 ponneri,TamilNadu");
		app.setLanguage("Tamil");
		app.setName("Barath");
		app.setPhone_number("987654321");
		app.setWebsite("www.houseforrent.com");
		location lc=new location();
		lc.setLat(33.7676);
		lc.setLng(67.7766);
		app.setLocation(lc);
		List<String> l=new ArrayList<String>();
		l.add("Shoe park");
		l.add("Park");
		app.setTypes(l);
		
		
		Response as= given().log().all().headers("Content-Type","application/json")
	.queryParam("key","qaclick123").body(app)
	        .when().post("/maps/api/place/add/json")
	        .then().assertThat().statusCode(200).extract().response().as(Response.class);
		System.out.println(as.getId());
	    System.out.println(as.getPlace_id());
	    System.out.println(as.getReference());
	    System.out.println(as.getScope());
	    System.out.println(as.getStatus());
		
		
	}

}
