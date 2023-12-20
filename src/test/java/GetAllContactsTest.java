import com.google.gson.Gson;
import dto.ContactDto;
import dto.ContactListDTO;
import helper.BaseHelper;
import helper.LoginHelper;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class GetAllContactsTest extends LoginHelper {

    final MediaType JSON = MediaType.get("application/json; charset=utf-8");
    Gson gson = new Gson();
    OkHttpClient client = new OkHttpClient();
    BaseHelper baseHelper = new BaseHelper();

    @Test
    public void PositiveToGetAllContactTest() throws IOException {

        Response response = client.newCall(baseHelper.GetStart("contacts")).execute();
        if (response.isSuccessful()) {
            ContactListDTO contactDTO = gson.fromJson(response.body().string(), ContactListDTO.class);
            for (ContactDto listcontact : contactDTO.getContacts()) {
                System.out.println(listcontact.getId());
                System.out.println("/////////////////////////////////////////");
                System.out.println(listcontact.getName());
                System.out.println(listcontact.getLastName());
                System.out.println(listcontact.getPhone());
                System.out.println("/////////////////////////////////////////");
                Assert.assertTrue(response.code() == 200);


            }
        } else {
            System.out.println(response.code());
        }


    }

}
