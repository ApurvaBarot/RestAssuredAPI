package utilities;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;


public class RestAssuredExtension {

	public static RequestSpecification request;
	
	public RestAssuredExtension(){
	//Arrange
	RequestSpecBuilder builder = new RequestSpecBuilder();
	builder.setBaseUri("http://localhost:3000");
	builder.setContentType(ContentType.JSON);
	 request = RestAssured.given().spec(builder.build());
	}
	
	public static void GetopsWithPathParameter(String url, Map<String, String> pathParam) {
		//Act
		request.pathParams(pathParam);
		
		try {
			request.get(new URI(url));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
	
	public static ResponseOptions<Response> Getops(String url) {
		try {
			return request.get(new URI(url));
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static ResponseOptions<Response> PostopsWithBodyAndPathParams(String url, Map<String, String> pathParam, Map<String, String> body){
	
		request.pathParams(pathParam);
		request.body(body);
		return request.post(url);
		
	}
	
	public static ResponseOptions<Response> PostopsWithBody(String url, Map<String, String> body){
		request.body(body);
		return request.post(url);
	}
	
	public static ResponseOptions<Response> DeleteopsWithPathParams(String url, Map<String, String> pathParams){
		request.pathParams(pathParams);
		return request.delete(url);
	}
	
	public static ResponseOptions<Response> GetopsWithPathParams(String url, Map<String, String> pathParams){
		request.pathParams(pathParams);
		return request.get(url);
	}
	
	public static ResponseOptions<Response>  PutopsWithBodyAndPathParams(String url, Map<String, String> pathParam, Map<String, String> body) {
		request.pathParams(pathParam);
		request.body(body);
		return request.put(url);
	}
	
	public static ResponseOptions<Response> GetopsWithQueryParams(String url, Map<String, String> queryParams){
		request.queryParams(queryParams);
		return request.get(url);
	}
}
