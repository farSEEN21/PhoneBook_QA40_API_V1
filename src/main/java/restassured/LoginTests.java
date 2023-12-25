package restassured;

import dto.AuthRequestDTO;
import helper.RestAssuredHelper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.anything;

public class LoginTests extends RestAssuredHelper {
    @Test
            public void PositiveLogin() {
//        String loginBody="{\n"+"   \"username\": \"abs@def.com\", \n" +
//                "   \"password\": \"$Abcdef12345\", \n" + "}";



        RestAssured
                .given().log().all()
                .when()
                .contentType(ContentType.JSON)
                .body(loginBody).post(url)
                .then().log().all().statusCode(200).assertThat().body("token",anything());





    }
}
