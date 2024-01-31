package api.endpoints;

/*implementation of endPoints.*/

import static io.restassured.RestAssured.given;

import api.payloads.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class userEndPoints {
	
	public static Response createUser(User payload)
	{
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
			.when()
			.post(Routes.post_url);
		
		return response;
	}
	
	public static Response readUser(String userName)
	{
		Response response = given()
				.pathParam("username", userName)
			.when()
			.get(Routes.get_url);
		
		return response;
	}
	
	public static Response updateUser(User payload, String userName)
	{
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.pathParam("username", userName)
			.when()
			.put(Routes.put_url);
		
		return response;
	}
	public static Response deleteUser(String userName)
	{
		Response response = given()
				.pathParam("username", userName)
			.when()
			.delete(Routes.delete_url);
		
		return response;
	}
	

}
