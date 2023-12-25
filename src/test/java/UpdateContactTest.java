import dto.ContactDto;
import dto.ContactListDTO;
import helper.RestAssuredHelper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

import static org.hamcrest.Matchers.*;

public class UpdateContactTest extends RestAssuredHelper {


        Random random = new Random();
        int i = random.nextInt(10);
        ContactDto contactDTO;
        ContactDto contactDTO1;
        String id = "8176457b-71bc-4f4a-a83f-5b81217ebd58";
        String endpoint = "contacts";


        @BeforeMethod
        public void precondition(){
            RestAssured.baseURI = BASE_URI;
            RestAssured.basePath = PATH;

            contactDTO = ContactDto.builder()
                    .name("QA38")
                    .lastName("Automation")
                    .email("qa38_" + i + "@mail.com")
                    .phone("12345678" + i+"105")
                    .address("Rehovot")
                    .description("Students")
                    .build();
  contactDTO1 = ContactDto.builder()
                    .name("QA38")
                    .lastName("Automation")
                    .email("qa38_" + i + "@mail.com")
                    .phone("12345678" )
                    .address("Rehovot")
                    .description("Students")
                    .build();

            String message = RestAssured.
                    given()
                    .header("Authorization", "Bearer " + getToken())
                    .body(contactDTO)
                    .contentType(ContentType.JSON)
                    .when()
                    .post(BASE_URI+"/"+PATH+"/"+endpoint)
                    .then()
                    .assertThat().statusCode(200)
                    .extract()
                    .path("message");

            id = message.substring(message.lastIndexOf(' ') + 1);
        }

        @Test
        public void updateContactPositive(){

            contactDTO.setId(id);
            contactDTO.setName("QA_38_Updated");

            RestAssured
                    .given()
                    .log().all()
                    .header("Authorization", "Bearer " + getToken())
                    .body(contactDTO)
                    .contentType(ContentType.JSON)
                    .when()
                    .put(BASE_URI+"/"+PATH+"/"+endpoint)
                    .then()
                    .log().all()
                    .assertThat().statusCode(200)
                    .assertThat().body("message", containsString("Contact was updated"));
        }  @Test
        public void updateContactNegative(){

            contactDTO1.setId(id);
            contactDTO1.setName("QA_38_-V2");

            RestAssured
                    .given()
                    .log().all()
                    .header("Authorization", "Bearer " + getToken())
                    .body(contactDTO1)
                    .contentType(ContentType.JSON)
                    .when()
                    .put(BASE_URI+"/"+PATH+"/"+endpoint)
                    .then()
                    .log().all()
                    .assertThat().statusCode(400)
                    .assertThat().body("message", containsString("<{phone="));
        }

}
