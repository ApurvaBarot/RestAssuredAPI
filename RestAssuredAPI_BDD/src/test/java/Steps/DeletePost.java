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

import org.hamcrest.core.IsNot;

import io.cucumber.datatable.*;
public class DeletePost {

	private static ResponseOptions<Response> response;
	
	@Given("I perform post operation for {string} with body as")
	public void i_perform_post_operation_for_with_body_as(String url, DataTable dataTable) {

		//Set body
		Map<String, String> body = new HashMap();
		body.put("id", dataTable.cell(1, 0));
		body.put("tittle", dataTable.cell(1, 1));
		body.put("author", dataTable.cell(1, 2));
		
		//Perform Post operation
		RestAssuredExtension.PostopsWithBody(url, body);
	}

	@Given("I perform DELETE operation for {string}")
	public void i_perform_delete_operation_for(String url, DataTable dataTable) {
		
		//Set body
		Map<String, String> pathParams = new HashMap();
		pathParams.put("postid", dataTable.cell(1, 0));
			
		//Perform Delete operation
		RestAssuredExtension.DeleteopsWithPathParams(url, pathParams);
	}

	@Given("I perform GET operation with path parameter for {string}")
	public void i_perform_get_operation_with_path_parameter_for(String url, DataTable dataTable) {
		
		//Set body
		Map<String, String> pathParams = new HashMap();
		pathParams.put("postid", dataTable.cell(1, 0));
		
		//Perform Delete operation
		response = RestAssuredExtension.GetopsWithPathParams(url, pathParams);

		
	}

	@Then("I should not  see the body with title as {string}")
	public void i_should_not_see_the_body_with_title_as(String tittle) {
		assertThat(response.getBody().jsonPath().get("title"), IsNot.not(tittle) );
	}



}
