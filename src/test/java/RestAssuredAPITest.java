import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.ArrayList;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
public class RestAssuredAPITest {

	public static void main(String[] args) {
		RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books"; 
		// Get the RequestSpecification of the request to be sent to the server. 
		RequestSpecification httpRequest = RestAssured.given(); 
		// specify the method type (GET) and the parameters if any. 
		//In this case the request does not take any parameters 
		Response response = httpRequest.request(Method.GET, "");
		// Print the status and message body of the response received from the server 
		//System.out.println("Status received => " + response.getStatusLine()); 
		//System.out.println("Response=>" + response.prettyPrint());
		
		JsonPath jsonPathEvaluator = response.jsonPath();

//		System.out.println("Book Title Response=> " + jsonPathEvaluator.get("books"));
//		ArrayList<JSONObject> books= jsonPathEvaluator.get("books");
//		System.out.println("Books Array        =>" + books.get(0).get("title"));

		String jsonString = response.asString() ; //assign your JSON String here
		JsonObject jsonObject = new JsonParser().parse(jsonString).getAsJsonObject();
		//String pageName = jsonObject.getAsJsonObject("pageInfo").getString("pageName");

//		JsonArray arr = jsonObject.getAsJsonArray("books");
//		for (int i = 0; i < arr.size(); i++)
//		{
//		    System.out.println("TITLE : " + i + " " + arr.get(i).getAsJsonObject().get("title").getAsString());
//		}
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

//        JsonArray arr = jsonObject.getAsJsonArray("student");
//        for (int i = 0; i < arr.size(); i++) {
//            String classdetails = arr.get(i).getAsJsonObject().get("class6").getAsString();
//            System.out.println(classdetails);
//        }
	}

}
