import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Assignment1 {

	public static void main(String[] args) {
		RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books"; 
		// Get the RequestSpecification of the request to be sent to the server. 
		RequestSpecification httpRequest = RestAssured.given(); 
		// specify the method type (GET) and the parameters if any. 
		//In this case the request does not take any parameters 
		Response response = httpRequest.request(Method.GET, "");
		String jsonString = response.asString() ; //assign your JSON String here
		String student= "{\r\n"
				+ "\"student\":\r\n"
				+ "{\r\n"
				+ "   \r\n"
				+ "\"rollNum\":38,\r\n"
				+ "\"Name\":\"soham\",\r\n"
				+ "\"age\": 10,\r\n"
				+ "\"class\": 6\r\n"
				+ "    \r\n"
				+ "\r\n"
				+ "}\r\n"
				+ "}";
		JsonObject jsonObject1 = new JsonParser().parse(student).getAsJsonObject();

        String studName = jsonObject1.getAsJsonObject("student").get("Name").getAsString();
        System.out.println(studName);

	}

}

