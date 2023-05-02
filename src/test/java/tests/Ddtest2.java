package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import endpoints.UserendPoints;
import endpoints.UserendPoints1;
import io.restassured.response.Response;
import payload.User;
import utils.DataProviders;

public class Ddtest2 {

	@Test(priority = 1, dataProvider = "getData", dataProviderClass = DataProviders.class)
	public void testPostUser(String userId, String username, String firstname, String lastname, String email,
			String password, String phone) {
		User userPayload = new User();
		userPayload.setId(Integer.parseInt(userId));
		userPayload.setUsername(username);
		userPayload.setFirstname(firstname);
		userPayload.setLastname(lastname);
		userPayload.setEmail(email);
		userPayload.setPassword(password);
		userPayload.setPhone(phone);

		Response res = UserendPoints1.createUser(userPayload);
		res.then().log().body().toString();
		Assert.assertEquals(res.getStatusCode(), 200);
	}

	@Test(priority = 2, dataProvider = "getUsername", dataProviderClass = DataProviders.class)
	public void testGetUser(String username) {
		Response res = UserendPoints1.readUser(username);
		res.then().log().body().toString();
		Assert.assertEquals(res.getStatusCode(), 200);
	}

}
