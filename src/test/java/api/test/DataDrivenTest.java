package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.userEndPoints;
import api.payloads.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DataDrivenTest {
	
	@Test(priority=1, dataProvider="Data", dataProviderClass=DataProviders.class)
	public void testPostUser(String userID, String UserName, String fname, String lname, String useremail, String pwd, String ph)
	{
		User userPayloads = new User();
		
		userPayloads.setUsername(UserName);
		userPayloads.setId(Integer.parseInt(userID));
		userPayloads.setFirstname(fname);
		userPayloads.setLastname(lname);
		userPayloads.setEmail(useremail);
		userPayloads.setPhone(ph);
		userPayloads.setPassword(pwd);
		
		Response response = userEndPoints.createUser(userPayloads);
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority=3, dataProvider="UserNames", dataProviderClass=DataProviders.class)
	public void testDeleteUser(String userName)
	{
		Response response=userEndPoints.deleteUser(userName);
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	@Test(priority=2, dataProvider="UserNames", dataProviderClass=DataProviders.class)
	public void testGetUser(String userName)
	{
		Response response=userEndPoints.readUser(userName);
		Assert.assertEquals(response.getStatusCode(), 200);
	}
}
