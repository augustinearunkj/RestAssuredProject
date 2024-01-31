package api.endpoints;

/* base url : https://petstore.swagger.io/
 * https://petstore.swagger.io/v2/user -- post
		https://petstore.swagger.io/v2/user/{username} -- get
			https://petstore.swagger.io/v2/user/{username} -- put
				https://petstore.swagger.io/v2/user/{username} -- delete
 */
public class Routes {
	
	public static String base_url = "https://petstore.swagger.io/v2";
	
	
	//userModule
	
	public static String post_url = base_url +"/user";
	public static String get_url = base_url+"/user/{username}";
	public static String put_url = base_url+"/user/{username}";
	public static String delete_url = base_url+"/user/{username}";
		

}
