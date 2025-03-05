package DataDrivenTesting;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class APIDataDriven {


	@Test
	public void postDataXML() throws IOException
	{
		
		datadriven d = new datadriven();
		ArrayList data = d.getData("RestAddBook", "RestAssured");
		
		
		HashMap<String, Object> jsonAsMap = new HashMap<>();
		jsonAsMap.put("name", data.get(1));
		jsonAsMap.put("isbn", data.get(2));
		jsonAsMap.put("aisle", data.get(3));
		jsonAsMap.put("author", data.get(4));
		
		RestAssured.baseURI =  "http://216.10.245.166";
		
		String response = given().log().all().header("Content-Type","application/json").
				body(jsonAsMap)
				.when()
				.post("Library/Addbook.php")
				.then().log().all().assertThat().statusCode(200).extract().asString();
		
		System.out.println(response);
		
		
		JsonPath js1= resuableMethods.rawToJson(response);

		   String id=js1.get("ID");

		   System.out.println(id);
		
	
		
	}
}
