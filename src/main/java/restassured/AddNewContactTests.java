package restassured;

import dto.ContactDto;
import dto.ContactListDTO;
import helper.RestAssuredHelper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import manager.DataProviderCSV;
import org.testng.annotations.Test;
import utils.NumberData;

import java.io.IOException;

import static org.hamcrest.Matchers.startsWith;

public class AddNewContactTests extends RestAssuredHelper {

    @Test
    public void addNewContactPositive(){

        RestAssured
                .given()
                .when().contentType(ContentType.JSON).log().all().header("authorization", getToken())
                .body(contactDTO)
                .post(contacts_URI)
                .then().log().all().statusCode(200).assertThat().body("message",startsWith("Contact")).extract().as(ContactListDTO.class);
    }

    @Test(dataProvider = "DataForCreateContact", dataProviderClass = DataProviderCSV.class)
    public void addNewContactPositive(ContactDto contactDto) throws IOException {

        RestAssured .given().when().contentType(ContentType.JSON)
                .header("authorization", getToken())
                .body(contactDto).post(contacts_URI)
                .then().statusCode(200)
                .assertThat().body("message",startsWith("Contact"))
                .extract().as(ContactListDTO.class);

    }



}
