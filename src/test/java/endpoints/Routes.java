package endpoints;

public class Routes {

	//post -:http://restapi.adequateshop.com/api/Customer
	//get -:http://restapi.adequateshop.com/api/Customer
	//get by id -:http://restapi.adequateshop.com/api/Customer/0
	//delete -: http://restapi.adequateshop.com/api/Customer/0
	//put -: http://restapi.adequateshop.com/api/Customer/1
	
	public static final String BASE_URL = "https://petstore.swagger.io/v2";
	public static final String POST_URL = BASE_URL+"/user";
	//public static final String GET_ALL_URL = BASE_URL+"Customer";
	public static final String GET_URL = BASE_URL+"/user/{username}";
	public static final String DELETE_URL = BASE_URL+"/user/{username}";
	public static final String PUT_URL = BASE_URL+"/user/{username}";
	
	
}
