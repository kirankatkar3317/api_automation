package endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payload.User;
import static io.restassured.RestAssured.*;

import java.util.ResourceBundle;


public class UserendPoints1 {

	
	public static ResourceBundle getUrl() {
		ResourceBundle routes = ResourceBundle.getBundle("routes");
		return routes;
	}
	
	
	public static Response createUser(User payLoad) {
		
		String postUrl = getUrl().getString("POST_URL");
		
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payLoad)
				
		.when()
		.post(postUrl);
		
		return response;
		
	}

	
	
	public static Response readUser(String userName) {
		
		String getUrl = getUrl().getString("GET_URL");
		
		Response response = given()
				.pathParam("username", userName)
		.when()
		.get(getUrl);
		
		return response;
		
	}

	
//	public static Response readAllUser() {
//		
//		Response response = given()
//		.when()
//		.get(Routes.GET_ALL_URL);
//		
//		return response;
//		
//	}
	
	
	public static Response updateUser(User payLoad, String userName) {
		
		String putUrl = getUrl().getString("PUT_URL");
		
		
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", userName)
				.body(payLoad)
				
		.when()
		.put(putUrl);
		
		return response;
		
	}

	
	
	public static Response deleteUser(String userName) {
		
		String deleteUrl = getUrl().getString("DELETE_URL");
		Response response = given()
				.pathParam("username", userName)
				
		.when()
		.delete(deleteUrl);
		
		return response;
		
	}

}
