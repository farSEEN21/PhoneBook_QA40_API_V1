import com.google.gson.Gson;
import dto.ContactDto;
import dto.ContactListDTO;
import dto.ContactResponseDTO;
import helper.BaseHelper;
import helper.RestAssuredHelper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import manager.DataProviderCSV;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ReadFromFile;

import java.io.IOException;

import static org.hamcrest.Matchers.startsWith;


public class AddNewContactTest extends RestAssuredHelper {

    Gson gson = new Gson();
    OkHttpClient client = new OkHttpClient();
    BaseHelper baseHelper = new BaseHelper();

    @Test
    public void addNewContactPositive() throws IOException {


        Response response = client.newCall(baseHelper.PostStart("/v1/contacts", contactDTO)).execute();

        if (response.isSuccessful()) {
            ContactResponseDTO authResponceDTO = gson.fromJson(response.body().string(), ContactResponseDTO.class);
            System.out.println(authResponceDTO.getMessage());
            Assert.assertTrue(authResponceDTO.getMessage().toLowerCase().contains(ReadFromFile.getProperty("ContactAdd")));

        }

    }



    }
