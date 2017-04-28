package Test;

import org.testng.annotations.Test;

import com.alibaba.fastjson.JSONObject;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.xml.XmlPath;
import com.jayway.restassured.response.Response;

public class Test2 {
	String A = "http://localhost:9090/APIpractise2/webapi/messages";

	@Test
	public void f() {
		Response rs = RestAssured.given().pathParam("id", 3).when().get(A+"/{id}");
		Response rs2 = RestAssured.given().when().get(A+"/{id}",1);
		System.out.println(rs.asString()+"  "+rs2.asString());
		//String s = rs.then().contentType(ContentType.JSON).extract().path("id");

	//	System.out.println(s);
	
	}

@Test
public void e(){
	JSONObject post = new JSONObject();
	post.put("author", "sasha");
	post.put("message", "i like it");
	
	Response r=RestAssured.given().contentType(ContentType.JSON).body(post).when().post(A);
	System.out.println(r.asString());
}


}
