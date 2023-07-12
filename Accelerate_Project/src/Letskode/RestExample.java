package Letskode;

import org.openqa.selenium.remote.Response;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

public class RestExample {
  @Test
  public void f() {
	  Response response ;
	  
      response = (Response) RestAssured.get("http://10.82.180.36:8080/rest-session-demo/api/webpage");     
	  String responseBody= response.getStatus().toString();
	  System.out.println("Response Status code is" +responseBody);
  
  }
  
  
  @Test
  public void f2() {
	  RestAssured.baseURI="http://localhost:8080/InfyClinicV2/APP_V2/getDoctor?Specialization=Cardiologist";
	  
	  RequestSpecification httprequest = RestAssured.given();
	  
	  Response response = (Response) httprequest.request(Method.GET,"getDoctor?Specialization=Cardiologist");
     
	  String responsebody = ((ResponseOptions<io.restassured.response.Response>) response).getBody().toString();
	  
	  System.out.println(responsebody);
  
  }
}
