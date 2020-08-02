package Steps;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import utilities.RestAssuredExtension;
import io.cucumber.datatable.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import java.util.HashMap;


public class PostProfileSteps {

	private static ResponseOptions<Response> response;
	
	
	@Given("I perform the post operation")
	public void i_perform_the_post_operation() {
		BDDStyleMethods.perfornPostWithBodyparameter();
	}

	@Given("I perform post operation for {string} with body")
	public void i_perform_post_operation_for_with_body(String url, DataTable dataTable) {
		
		//var data = dataTable.cell(row, column)
		
		//Set Body
		HashMap<String, String> body = new HashMap();
		body.put("name", dataTable.cell(1, 0));
				
		//Set path parameters
		HashMap<String, String> pathParam = new HashMap();
		pathParam.put("profileNo", dataTable.cell(1, 1));	
		
		// Perform post operation
		response = RestAssuredExtension.PostopsWithBodyAndPathParams(url, pathParam, body);
		
	}

	@Then("I should see the body has name as {string}")
	public void i_should_see_the_body_has_name_as(String name) {
	assertThat(response.getBody().jsonPath().get("name"), is(name));
	}

}
