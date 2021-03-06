package Test;

import org.testng.annotations.Test;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.*;

public class ApiTrial {

	String a = "http://samples.openweathermap.org/data/2.5/find";
	String s4 = "https://spasit1.yrcw.com/webapps/yrc-equipstatus/api/v1/validations/trailer/12345";
	String aut = "YRC eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpZCI6InV5cjI3YjAiLCJzaG9ydElkIjoidXlyMjdiMCIsImxvY2F0aW9uIjoiOTAzIiwibmFtZSI6IlpoYW5nLCBCZXJ0IiwiZW1haWwiOiJCZXJ0LlpoYW5nQFlSQ0ZyZWlnaHQuY29tIiwiZ3JvdXBzIjpbIkRvbWFpbiBVc2VycyIsIktDR08gVXNlcnMiLCJQQ0ludmVudG9yeSIsInlzaGxwZGtfcmVzdCIsIllUX0N1c3RvbWVyX1N2cyIsIllUX0N1c3RvbWVyX1N1cHBvcnQiLCJZVF9Vc2VycyIsIllUX1RlY2hfU2VydmljZXMiLCJZVEFMTFVTUiIsIllSVF9UZWNoX0luZnJhc3RydWN0dXJlX1N2Y3MiLCJZUlRfSVRfU3VwcG9ydF9TZXJ2aWNlcyIsIllUX0VuZF9Vc2VyX1NlcnZpY2VzIiwiWVRfVGVjaF9JbmZyYXN0cnVjdHVyZV9TdmNzIiwiUk9MRS1CSVpPQkotQWRtaW4iLCJST0xFLVRyYWluaW5nLVVzZXIiLCJST0xFLVlSVEVDSCIsIkluZlNlYyBDUyBMaXN0IiwiVVNGSExQREsiLCJZVEFMTFVTUl9LR08iLCJXMEltZ1VzZXJFbnRyeSIsIlcwQWRob2NFbnRyeSIsIkhEX0tub3dsZWRnZUdyb3VwIiwiVlBORVhDUF9ZVF9LR08iLCJDbGFyaXR5X1VzZXJzIiwiTE9DUmlza1Jlc2NTdnMiLCJXMEN1c3RTZXJ2TWFpbnRUcm1QcmludCIsIkxPQ1Jpc2tSZXNjU3ZzX0hlbHBEZXNrIiwiWVNITFBES19Td2l0Y2hib2FyZF9VcGRhdGUiLCJZU0hMUERLX0hvbWVEaXIiLCJYZW5BcHBfUmVtb3RlQWNjZXNzIiwiWVJUX0V4Y2hhbmdlXzIwMTBfVXNlcnMiLCJDdWx0dXJlQ2x1Yl9BdXRob3JzIiwiVXNyX1lSQ19QQV9HbG9iYWxQIiwiR1BPX0NSTV9Qcm9kIiwiREJfQWNjZXNzX1NRQV9TdGciLCJZUkNXX1lSQ0YgLSBDb2RlIG9mIENvbmR1Y3QiLCJEb2NrIENvbW1hbmQgQ2VudGVyIiwiWVRBTExfRUMiLCJEQl9BY2Nlc3NfRXF1aXBtZW50IiwiRXF1aXBTdGF0VXBkYXRlIiwiREJfQWNjZXNzX0VudEluZ3JhdGlvbiJdLCJlbXBsb3llZUlkIjoiMjUwNDI3MDA3IiwibWFpbmZyYW1lSWQiOiJ1eXIyN2IwIiwiaWF0IjoxNDg5MDk1Mzk1LCJleHAiOjE0ODkxMDEyMTQsImlzcyI6IllSQyJ9.gtxZ3y1uh4nN27XJ_5wlPZYpvBsaKO8JB3a7htP8x327Uz2_5L3dmzHNP97XompaOcPmRAhl7EA2sOAeJkUMWpmtpTWAv0LCZROnvWzXYsOfCQ8q45frwjzxZgIVx5uLcle1Vb3QOtZDRuqb9KYBP4AJQeHKBdxNh35eutdbeOcJUgCypzZgkBj94O-Mmxv_ChJDqM-L4vGWtdwpr1K1PSjtIUV8P060Hpah8moi8DR-T9tXrDUdZWtmRpws_QhRSr0AqspgRUB6T4HktO4oryuCxrXLhVuVA0BsYMeZRSbJ3a1-njc9zY1143XFtTfO3ifi2a6nGaZTYTQskYbswA";

	@Test
	public void f() {
		Response res = given().param("q", "london").param("units", "metric")
				.param("appid", "b1b15e88fa797225412429c1c50c122a1").when().get(a);

		int returncode = res.getStatusCode();
		System.out.println(returncode);
		res.then().assertThat().statusCode(200);
		System.out.println(res.asString());
		String result = res.then().contentType(ContentType.JSON).extract().path("list[0].weather[1].main");
		res.then().contentType(ContentType.JSON).extract().path("list[0].weather[*].main");

		System.out.println(result + "   ");
	}

	@Test
	public void e() {
		// Response res = given().header("X-Authorization", aut).when().get(s4);
		// Response res2 = given().auth().certificate("X-Authorization",
		// aut).when().get(s4);
		// Response res3 =
		// given().authentication().certificate("X-Authorization",
		// aut).when().get(s4);
		// Response res4 = given().auth(). preemptive().basic("X-Authorization", aut).when().get(s4);
		Response res5 =given().auth().form("X-Authorization", aut).when().get(s4);
	//	given().auth().basic(username, password).when().get("/secured").then().statusCode(200);
		 //System.out.println(res.asString());
	}

}
