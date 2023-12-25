import helper.BaseHelper;
import com.google.gson.Gson;
import dto.AuthResponceDTO;
import dto.ErrorDto;
import okhttp3.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ReadFromFile;

import java.io.IOException;

public class LoginTest {

    Gson gson = new Gson();
    OkHttpClient client = new OkHttpClient();
    BaseHelper baseHelper=new BaseHelper();


    @Test
    public void loginPositive() throws IOException {


         Response response = client.newCall(baseHelper.PostStart("/v1/user/login/usernamepassword", "abc@def.com","$Abcdef12345")).execute();
        if (response.isSuccessful()) {
            AuthResponceDTO authResponceDTO = gson.fromJson(response.body().string(), AuthResponceDTO.class);
            System.out.println(authResponceDTO.getToken());
            System.out.println(response.code());
            Assert.assertTrue(response.isSuccessful());
        } else{
            System.out.println(response.code());
            ErrorDto errorDto = gson.fromJson(response.body().string(), ErrorDto.class);
            System.out.println(errorDto);
            Assert.assertTrue(response.isSuccessful());
        }
    }


@Test// TODO: BUG CODE 401
    public void LoginNegative()throws IOException{

    Response response = client.newCall(baseHelper.PostStart("/v1/user/login/usernamepassword",  "abc@def.com","$Abcde21f12345" )).execute();
    if (!response.isSuccessful()) {
        ErrorDto errorDto = gson.fromJson(response.body().string(), ErrorDto.class);
        System.out.println(errorDto);
        System.out.println(response.code());
        Assert.assertTrue(response.code()==401);
    } else{
        System.out.println(response.code());
        AuthResponceDTO authResponceDTO = gson.fromJson(response.body().string(), AuthResponceDTO.class);
        System.out.println(authResponceDTO);
        Assert.assertTrue(response.isSuccessful(), ReadFromFile.getProperty("NegativeLoginFailed"));

    }
}






}

