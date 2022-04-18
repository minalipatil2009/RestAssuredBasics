import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Assignment2 {

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
				+ "    {\r\n"
				+ "    \"rollNum\":38,\r\n"
				+ "    \"Name\":\"soham\",\r\n"
				+ "    \"age\": 10,\r\n"
				+ "    \"class\": 6,\r\n"
				+ "    \"address\":{\r\n"
				+ "	      	    \"addressLine1\":\"A1102\",\r\n"
				+ "	      	    \"addressLine2\":\"SKyHights\",\r\n"
				+ "	      	    \"landMark\":\"Near Data Mandir\",\r\n"
				+ "	      	    \"locality\":\"Aundh\",\r\n"
				+ "	      	    \"city\":\"Pune\",\r\n"
				+ "	      	    \"pin\":411057\r\n"
				+ "              }	\r\n"
				+ "    }\r\n"
				+ "}";
		JsonObject jsonObject1 = new JsonParser().parse(student).getAsJsonObject();

        String studLocality = jsonObject1.getAsJsonObject("student").getAsJsonObject("address").get("locality").getAsString();
        System.out.println("Student locality :"+ studLocality);

	}

}
