package Steps;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.HashMap;
import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import pojo.Address;
import pojo.Location;
import pojo.Posts;
import utilities.RestAssuredExtension;
import utilities.RestAssuredExtensionv2;


public class GetPostSteps {

	private static ResponseOptions<Response> response;
	private static RestAssuredExtensionv2 restAssuredExtensionv2;
	
	@Given("I perform GET operation for {string}")
	public void i_perform_get_operation_for(String url) {
	   response =RestAssuredExtension.Getops(url);
	}

	@Then("I should see the author name as {string}")
	public void i_should_see_the_author_name_as(String authorName) {
		
		var posts = response.getBody().as(Posts.class);
		
		assertThat(posts.getAuthor(), equalTo(authorName));
		
		//assertThat(response.getStatusCode(), is(200));
		System.out.println("Author Name is: " + posts.getAuthor());

	}

	@Then("I should see the author name as")
	public void i_should_see_the_author_name_as() {
		BDDStyleMethods.PerformContainsCollection();
	}

	@Then("I should verify GET path parameters")
	public void i_should_verify_get_path_parameters() {
	    BDDStyleMethods.PerformPathParameters();
	}
	
	@Then("I should verify GET query parameters")
	public void i_should_verify_get_query_parameters() {
		BDDStyleMethods.PerformQueryParameters();
	}
	
	@Given("I perform GET opeation with path param for address {string}")
	public void i_perform_get_opeation_with_path_param_for_address(String uri, DataTable dataTable) {
		
		
		Map<String, String> queryParams = new HashMap<>();
		queryParams.put("id", dataTable.cell(1, 0));
		
		//Response
		//response = RestAssuredExtension.GetopsWithQueryParams(url, queryParams);

	//	restAssuredExtensionv2 = new RestAssuredExtensionv2(uri, "GET");
	
		
	}

	
	@Then("I should see the street name as {string} for the {string} address")
	public void i_should_see_the_street_name_as_for_the_address(String streetName, String addressType) {

		  var location = response.getBody().as(Location[].class);
		  
		  
		  //stream.filter is similar to Lamda function
		  Address address = location[0].getAddress().stream().filter(x -> x.getType().equalsIgnoreCase(addressType)).findFirst().orElse(null);
		  
		  assertThat(address.getStreet(), equalTo(streetName)); 
		
	}




}
