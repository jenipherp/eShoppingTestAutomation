package api;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserApiTest extends ApiBase{

    @Test
    public void verifyLoginApi(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("email","test@gmail.com");
        requestBody.put("password","test123");

        Response res = postRequest("/login", requestBody.toString());

        Assert.assertEquals(res.getStatusCode(), 200, "Login API failed");
        Assert.assertTrue(res.jsonPath().getString("token").length()>0,"Token missing");
    }

    @Test
    public void verifyProductAPI(){
        Response res = getRequest("/Women");
        Assert.assertEquals(res.statusCode(),200,"Prodcut list API failed");
        Assert.assertTrue(res.jsonPath().getList("$").size()>0, "No products returned");
    }
}
