package restassured;

import dto.ContactDto;
import dto.ContactListDTO;
import helper.RestAssuredHelper;
import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetALlTest extends RestAssuredHelper {

    @Test
    public void GetAllContatcts() {
        ContactListDTO contactListDTO =
                RestAssured
                        .given()
                        .when().log().all().header("authorization", getToken())
                        .get(contacts_URI)
                        .then().statusCode(200).extract().as(ContactListDTO.class);
        for (ContactDto contact:contactListDTO .getContacts()) {
            System.out.println(contact.getId());
            System.out.println(contact.getName());
            System.out.println(  contactListDTO.getContacts().size());
        }//276

        Assert.assertFalse(contactListDTO.toString().isBlank());
    }

}
