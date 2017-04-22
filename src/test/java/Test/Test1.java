package Test;

import org.testng.annotations.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.xml.XmlPath;
import com.jayway.restassured.response.Response;

public class Test1 {
	String A = "http://123.58.251.183:8080/goods/UserServlet";

	@Test
	public void f() {
		Response rs = RestAssured.given().param("method", "loginMobile").param("loginname", "testfan242")
				.param("loginpass", "test242").when().get(A);
		System.out.println(rs.asString());
		XmlPath s=rs.then().contentType(ContentType.HTML).extract().path("");
		
		System.out.println(s);
	}
}
