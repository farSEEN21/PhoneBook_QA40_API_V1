import helper.BaseHelper;
import com.google.gson.Gson;
import dto.AuthResponceDTO;
import dto.ErrorDto;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.NumberData;

import java.io.IOException;

public class RegistrationTest {

    Gson gson = new Gson();
    OkHttpClient client = new OkHttpClient();
    BaseHelper baseHelper = new BaseHelper();
    NumberData numberData = new NumberData();

    @Test
    public void PositiveRegistation() throws IOException {


        Response response = client.newCall(baseHelper.PostStart("/v1/user/registration/usernamepassword", "ab" + numberData.RAND_Number() + "c12312" + numberData.RAND_Number() + "4@def.com", "$Abcdef12345")).execute();
        if (response.isSuccessful()) {
            AuthResponceDTO authResponceDTO = gson.fromJson(response.body().string(), AuthResponceDTO.class);
            System.out.println(authResponceDTO.getToken());
            System.out.println(response.code());
            System.out.println("Username was " + "ab" + numberData.RAND_Number() + "c12312" + numberData.RAND_Number() + "4@def.com");
            Assert.assertTrue(response.isSuccessful());

        } else {
            System.out.println(response.code());
            ErrorDto errorDto = gson.fromJson(response.body().string(), ErrorDto.class);
            System.out.println("Username was " + "ab" + numberData.RAND_Number() + "c12312" + numberData.RAND_Number() + "4@def.com");
            System.out.println(errorDto);
            Assert.assertTrue(response.isSuccessful());
        }
    }

    @Test
    public void NegativeWrongUserName() throws IOException {


        Response response = client.newCall(baseHelper.PostStart("/v1/user/registration/usernamepassword", "ab c123124@def.com", "$Abcdef12345")).execute();
        if (!response.isSuccessful()) {
            System.out.println(response.code());
            ErrorDto errorDto = gson.fromJson(response.body().string(), ErrorDto.class);
            System.out.println(errorDto);
            Assert.assertTrue(response.code() == 400);

        } else if (!response.isSuccessful()) {
            System.out.println(response.code());
            ErrorDto errorDto = gson.fromJson(response.body().string(), ErrorDto.class);

            System.out.println(errorDto);
            Assert.assertTrue(response.code() == 409);


        } else {
            AuthResponceDTO authResponceDTO = gson.fromJson(response.body().string(), AuthResponceDTO.class);
            System.out.println(authResponceDTO.getToken());
            System.out.println(response.code());

            Assert.assertTrue(response.isSuccessful());

        }


    }

    @Test
    public void NegativeDublicateUser() throws IOException {


        Response response = client.newCall(baseHelper.PostStart("/v1/user/registration/usernamepassword", "abc123@def.com", "$Abcdef12345")).execute();
        if (!response.isSuccessful()) {
            System.out.println(response.code());
            ErrorDto errorDto = gson.fromJson(response.body().string(), ErrorDto.class);
            System.out.println(errorDto);

            Assert.assertTrue(errorDto.toString().contains("User already exists"));

        } else if (!response.isSuccessful()) {
            System.out.println(response.code());
            ErrorDto errorDto = gson.fromJson(response.body().string(), ErrorDto.class);

            System.out.println(errorDto);
            Assert.assertTrue(response.code() == 400);


        } else {
            AuthResponceDTO authResponceDTO = gson.fromJson(response.body().string(), AuthResponceDTO.class);
            System.out.println(authResponceDTO.getToken());
            System.out.println(response.code());

            Assert.assertTrue(response.isSuccessful());

        }


    }

    @Test
    public void NegativeWrongLengthpsw() throws IOException {


        Response response = client.newCall(baseHelper.PostStart("/v1/user/registration/usernamepassword", "ab" + numberData.RAND_Number() + "c12312" + numberData.RAND_Number() + "4@def.com", numberData.RandomPsw(6))).execute();
        if (!response.isSuccessful()) {
            System.out.println(response.code());
            ErrorDto errorDto = gson.fromJson(response.body().string(), ErrorDto.class);
            System.out.println(errorDto);
            Assert.assertTrue(response.code() == 400);

        } else if (!response.isSuccessful()) {
            System.out.println(response.code());
            ErrorDto errorDto = gson.fromJson(response.body().string(), ErrorDto.class);

            System.out.println(errorDto);
            Assert.assertTrue(response.code() == 409);


        } else {
            AuthResponceDTO authResponceDTO = gson.fromJson(response.body().string(), AuthResponceDTO.class);
            System.out.println(authResponceDTO.getToken());
            System.out.println(response.code());

            Assert.assertTrue(response.isSuccessful());

        }


    }


}
