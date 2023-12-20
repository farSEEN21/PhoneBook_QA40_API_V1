package helper;

import com.google.gson.Gson;
import dto.AuthRequestDTO;
import dto.AuthResponceDTO;
import okhttp3.*;
import utils.ReadFromFile;

import java.io.IOException;

public class LoginHelper {
    String token = ReadFromFile.getProperty("1");
    Gson gson = new Gson();
    OkHttpClient client = new OkHttpClient();
    final MediaType JSON = MediaType.get("application/json; charset=utf-8");


    public String init() throws IOException {

        AuthRequestDTO requestDTO = AuthRequestDTO.builder()
                .username("abc@def.com")
                .password("$Abcdef12345")
                .build();

        RequestBody requestBody = RequestBody.create(gson.toJson(requestDTO), JSON);
        Request request = new Request.Builder()
                .url("https://contactapp-telran-backend.herokuapp.com/v1/user/login/usernamepassword")
                .post(requestBody)
                .build();

        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
        AuthResponceDTO responseDTO = gson.fromJson(response.body().string(), AuthResponceDTO.class);

        return token = responseDTO.getToken();}
        else {return token;}

    }
}