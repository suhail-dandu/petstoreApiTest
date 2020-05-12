package supportFiles;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAPIOperations {
	
	private String url; 
	RequestSpecification request = RestAssured.given();
	Response response;
	
	public RestAPIOperations(String url) {		
		this.url = url;
	}
	public void setDefaultRequestHeader(){
		this.request.header("Content-Type","application/json");
		
	}
	public void setRequestBody(JSONObject body) {
		this.request.body(body.toJSONString());
		
	}
	
	public Response makeRequest(Method method, String index) {
		RestAssured.baseURI = this.url;
		this.response = this.request.request(method, index);
		return this.response;
	}
}
