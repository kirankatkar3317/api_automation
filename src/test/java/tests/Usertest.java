package tests;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import endpoints.UserendPoints;
import io.restassured.response.Response;
import payload.User;

public class Usertest {
	public Response response;
	public Faker faker;
	public User userPayload;

	@BeforeClass
	public void payloadData() {
		faker = new Faker();
		userPayload = new User();

		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstname(faker.name().firstName());
		userPayload.setLastname(faker.name().lastName());
		userPayload.setEmail(faker.internet().emailAddress());
		userPayload.setPassword(faker.internet().password());
		userPayload.setPhone(faker.phoneNumber().cellPhone());

	}

	@Test(priority = 1)
	public void testPostUser() {

		response = UserendPoints.createUser(userPayload);
		response.then().log().body().toString();
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody().asString());
	}

	@Test(priority = 2)
	public void testGetUser() {
		response = UserendPoints.readUser(this.userPayload.getUsername());
		System.out.println(" ----------------getuser--------------------- ");
		response.then().log().all();

		Assert.assertEquals(response.getStatusCode(), 200);
		
		System.out.println(" ----------------getuser--------------------- ");
	}

	 @Test(priority = 3)
	public void testUpdateUser() {
		userPayload.setFirstname(faker.name().firstName());
		userPayload.setEmail(faker.internet().emailAddress());

		response = UserendPoints.updateUser(userPayload, this.userPayload.getUsername());
		System.out.println(" ----------------updateuser--------------------- ");

		response.then().log().body().toString();

		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println(" ----------------updateuser--------------------- ");
		
		Response response = UserendPoints.readUser(userPayload.getUsername());
		response.then().log().body();
	}

	@Test(priority = 4)
	public void testDeleteUser() {
		response = UserendPoints.deleteUser(this.userPayload.getUsername());
		
		response.then().log().body().toString();
		
		Assert.assertEquals(response.getStatusCode(), 200);

	}

}
