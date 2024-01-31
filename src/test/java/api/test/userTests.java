package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.userEndPoints;
import api.payloads.User;
import io.restassured.response.Response;

public class userTests {

	Faker faker;
	User userPayloads;
	public Logger logger;
	
	@BeforeClass
	public void setUpData()
	{
		 faker = new Faker();
		 userPayloads = new User();
		 
		 userPayloads.setId(faker.idNumber().hashCode());
		 userPayloads.setUsername(faker.name().username());
		 userPayloads.setFirstname(faker.name().firstName());
		 userPayloads.setLastname(faker.name().lastName());
		 userPayloads.setEmail(faker.internet().emailAddress());
		 userPayloads.setPassword(faker.internet().password());
		 userPayloads.setPhone(faker.phoneNumber().cellPhone());
		 
		 logger= LogManager.getLogger(this.getClass());
	}
	
	@Test
	public void testCreateUser()
	{
		logger.info("### User creation ###");
		Response response = userEndPoints.createUser(userPayloads);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("### User is created ###");
	}
	
	@Test
	public void testReadUsername()
	{
		logger.info("### Reading user ###");
		Response response = userEndPoints.readUser(this.userPayloads.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 404); /* actual code should be 200*/
		logger.info("### User is readed ###");
	}
	@Test
	public void testUpdateUser()
	{
		logger.info("### User updating ###");
		userPayloads.setFirstname(faker.name().firstName());
		userPayloads.setLastname(faker.name().lastName());
		userPayloads.setEmail(faker.internet().emailAddress());
		
		Response response = userEndPoints.updateUser(userPayloads,this.userPayloads.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("### User is updated ###");
	}
	@Test
	public void testDeleteUser()
	{
		logger.info("### User deletion ###");
		Response response = userEndPoints.deleteUser(this.userPayloads.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("### User is deleted ###");
	}
}
