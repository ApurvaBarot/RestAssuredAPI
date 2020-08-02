package utilities;

import java.util.Map;

import io.restassured.builder.RequestSpecBuilder;

public class RestAssuredExtensionv2 {

	private RequestSpecBuilder builder = new RequestSpecBuilder();
	private String method;
	private String url;
	
	public RestAssuredExtensionv2(String uri, String method) {
		
		//Formulate the API url
		this.url = "http://localhost:3000" + uri;
		this.method = method;
		
	}

	public void ExecuteAPIWithQueryParam(Map<String, String> queryParams) {
		// TODO Auto-generated method stub
		
	}
	
}
