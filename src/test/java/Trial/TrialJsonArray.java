package Trial;

import org.testng.annotations.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class TrialJsonArray {
	@Test
	public void f() {
		JSONObject post = new JSONObject();
		post.put("id", 1);
		post.put("title", "json-server");
		post.put("author", "typicode");
		JSONObject post2 = new JSONObject();
		post2.put("id", 2);
		post2.put("title", "dummytitle");
		post2.put("author", "vabihav");
		JSONObject info = new JSONObject();
		info.put("name", "bert");
		info.put("phone", "223333");
		JSONObject post3 = new JSONObject();
		post3.put("id", 3);
		post3.put("title", "book");
		post3.put("author", "bobo");
		post3.put("info", info);
		JSONArray posts=new JSONArray();
		posts.add(post);
		posts.add(post2);
		posts.add(post3);
		JSONObject profile= new JSONObject();
		profile.put("version", "1.2.0");
		JSONObject object= new JSONObject();
		object.put("posts", posts);
		object.put("profile", profile);
		
		System.out.println(JSON.toJSONString(object));
		
		
	}
}
