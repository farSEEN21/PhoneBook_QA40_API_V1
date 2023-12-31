package helper;

import dto.AuthRequestDTO;
import dto.ContactDto;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import utils.NumberData;

public class RestAssuredHelper {
    public AuthRequestDTO loginBody = AuthRequestDTO.builder().username("abc@def.com").password("$Abcdef12345").build();
   public String contacts_URI= "https://contactapp-telran-backend.herokuapp.com/v1/contacts";
   public String url = "https://contactapp-telran-backend.herokuapp.com/v1/user/login/usernamepassword";
    public  ContactDto contactDTO = ContactDto.builder()
            .name("Aq39.")
            .lastName("auth")
            .email("qa38" + NumberData.RAND_Number() + "@gmail.com")
            .phone("342342343" + NumberData.RAND_Number())
            .address("regove")
            .description("St")
            .build();


    public  String BASE_URI = "https://contactapp-telran-backend.herokuapp.com";
    public String PATH = "v1";

    public String authHeader = "Authorization";
    public String getToken(){

        AuthRequestDTO loginBody = AuthRequestDTO.builder()
                .username("abc@def.com")
                .password("$Abcdef12345")
                .build();

        String login_url = "https://contactapp-telran-backend.herokuapp.com/v1/user/login/usernamepassword";
        String token = RestAssured
                .given()
                .log().all()
                .when()
                .contentType(ContentType.JSON)
                .body(loginBody)
                .post(login_url)
                .then()
                .log().all()
                .statusCode(200)
                .extract().response().jsonPath().getString("token");
        return token;

    }




}