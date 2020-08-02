package Steps;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.containsStringIgnoringCase;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;

import java.util.HashMap;

import io.restassured.http.ContentType;

public class BDDStyleMethods {

	public static void getPostData(String PostNumber) {
		given().
			contentType(ContentType.JSON).
		when().
			get(String.format("http://localhost:3000/posts/%s", PostNumber)).
		then().
			body("author", is("Apurva"));
	}
	
	public static void PerformContainsCollection() {
		given().
			contentType(ContentType.JSON).
		when().
			get("http://localhost:3000/posts").
		then().
			body("author",containsString("Apurva"));
	}
	
	public static void PerformPathParameters() {
		given().
			contentType(ContentType.JSON).
		with().
			pathParams("post", 1).
		when().
			get("http://localhost:3000/posts/{post}").
		then().
			body("author", containsString("Apurva"));
	}
	
	public static void PerformQueryParameters() {
		given().
			contentType(ContentType.JSON).
		with().
			queryParams("id",3).
		when().
			get("http://localhost:3000/posts").
		then().
			body("author", containsStringIgnoringCase("Pawan"));
	}
	
	public static void perfornPostWithBodyparameter() {
		HashMap<String, String> postContent = new HashMap<>();
		postContent.put("id", "5");
		postContent.put("title", "Robotics");
		postContent.put("author", "Ruchi");
		
		given().
			contentType(ContentType.JSON).
		with().
			body(postContent).
		when().
			post("http://localhost:3000/posts").
		then().
			body("author", is("Ruchi"));		
	}

}
