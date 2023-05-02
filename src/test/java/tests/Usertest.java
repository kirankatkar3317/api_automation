package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
	public Logger log;

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
		
		log = LogManager.getLogger(this.getClass());

	}

	@Test(priority = 1)
	public void testPostUser() {
		
		log.info("________________user created_____________________");
		response = UserendPoints.createUser(userPayload);
		response.then().log().body().toString();
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody().asString());
		log.info("________________user successfully created_____________________");
		
	}

	@Test(priority = 2)
	public void testGetUser() {
		
		response = UserendPoints.readUser(this.userPayload.getUsername());
		log.info("________________user fetching_____________________________");

		response.then().log().all();

		Assert.assertEquals(response.getStatusCode(), 200);
		
		log.info("________________user fetched successfully_____________________");

	}

	 @Test(priority = 3)
	public void testUpdateUser() {
		userPayload.setFirstname(faker.name().firstName());
		userPayload.setEmail(faker.internet().emailAddress());

		response = UserendPoints.updateUser(userPayload, this.userPayload.getUsername());
		log.info(" ----------------update user--------------------- ");

		response.then().log().body().toString();

		Assert.assertEquals(response.getStatusCode(), 200);
		log.info(" ----------------updated user succesfully--------------------- ");

		log.info(" ----------------updated user fetching--------------------- ");

		Response response = UserendPoints.readUser(userPayload.getUsername());
		response.then().log().body();
		
		log.info(" ----------------updated user fetched successfully--------------------- ");
	}

	@Test(priority = 4)
	public void testDeleteUser() {
		
		log.info(" ----------------delete user--------------------- ");

		response = UserendPoints.deleteUser(this.userPayload.getUsername());
		
		response.then().log().body().toString();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		log.info(" ----------------delete user successfully--------------------- ");

	}

}
