import com.google.gson.Gson;
import dto.AuthResponceDTO;
import dto.ContactDto;
import dto.ContactResponseDTO;
import helper.BaseHelper;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.NumberData;
import utils.ReadFromFile;

import java.io.IOException;


@Test
public class AddNewContactTest {

    Gson gson = new Gson();
    OkHttpClient client = new OkHttpClient();
    BaseHelper baseHelper = new BaseHelper();

    public void addNewContactPositive() throws IOException {
        ContactDto contactDTO = ContactDto.builder()
                .name("Aq39.")
                .lastName("auth")
                .email("qa38" + NumberData.RAND_Number() + "@gmail.com")
                .phone("123123123" + NumberData.RAND_Number())
                .address("regove")
                .description("St")
                .build();

        Response response = client.newCall(baseHelper.PostStart("/v1/contacts", contactDTO)).execute();

if (response.isSuccessful()){
    ContactResponseDTO authResponceDTO = gson.fromJson(response.body().string(), ContactResponseDTO.class);
    System.out.println(authResponceDTO.getMessage());
    Assert.assertTrue(authResponceDTO.getMessage().toLowerCase().contains(ReadFromFile.getProperty("ContactAdd")));

}

    }
}