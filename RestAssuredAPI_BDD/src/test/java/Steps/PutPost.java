package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import utilities.RestAssuredExtension;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import java.util.HashMap;
import java.util.Map;
import io.cucumber.datatable.*;


public class PutPost {

	private static ResponseOptions<Response> response;
	
	@Given("I perform post operation for {string} with body to test PUT")
	public void i_perform_post_operation_for_with_body_to_test_put(String url, DataTable dataTable) {

		//Set body
		Map<String, String> body = new HashMap();
		body.put("id", dataTable.cell(1, 0));
		body.put("title", dataTable.cell(1, 1));
		body.put("author", dataTable.cell(1, 2));

		//Perform POST Operation
		RestAssuredExtension.PostopsWithBody(url, body);
		
	}

	@Given("I perform PUT operation for {string}")
	public void i_perform_put_operation_for(String url, DataTable dataTable) {
		//Set body
		Map<String, String> body = new HashMap();
		body.put("id", dataTable.cell(1, 0));
		body.put("title", dataTable.cell(1, 1));
		body.put("author", dataTable.cell(1, 2));

		//Set PathParams
		Map<String, String> pathParams = new HashMap();
		pathParams.put("postid", dataTable.cell(1, 0));
		
		//Perform PUT Operation
		RestAssuredExtension.PutopsWithBodyAndPathParams(url, pathParams, body);
	}

	@Given("I perform GET operation with path parameters for {string}")
	public void i_perform_get_operation_with_path_parameters_for(String url, DataTable dataTable) {
	
		//Get pathparams
		Map<String, String> pathParams = new HashMap();
		pathParams.put("postid", dataTable.cell(1, 0));
		
		//Perform GET operation
		response = RestAssuredExtension.GetopsWithPathParams(url, pathParams);

	}

	@Then("I should see the body with title {string}")
	public void i_should_see_the_body_with_title(String title) {
		assertThat(response.getBody().jsonPath().get("title"), is(title));
	}



	
}
