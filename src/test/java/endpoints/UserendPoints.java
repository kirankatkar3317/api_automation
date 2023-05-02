package endpoints;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payload.User;

public class UserendPoints {

	
	public static Response createUser(User payLoad) {
		
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payLoad)
				
		.when()
		.post(Routes.POST_URL);
		
		return response;
		
	}

	
	
	public static Response readUser(String userName) {
		
		Response response = given()
				.pathParam("username", userName)
		.when()
		.get(Routes.GET_URL);
		
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
		
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", userName)
				.body(payLoad)
				
		.when()
		.put(Routes.PUT_URL);
		
		return response;
		
	}

	
	
	public static Response deleteUser(String userName) {
		
		Response response = given()
				.pathParam("username", userName)
				
		.when()
		.delete(Routes.DELETE_URL);
		
		return response;
		
	}

}
