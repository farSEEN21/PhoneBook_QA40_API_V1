package restassured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestGoogle {


    @Test
    public void makeSureThatGooGleISUp(){
        RestAssured
                .given().contentType(ContentType.JSON)
                .when().get("http://google.com")
                .then().log().all().statusCode(200);

    }
}
