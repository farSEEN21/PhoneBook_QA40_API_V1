package helper;

import com.google.gson.Gson;
import dto.AuthRequestDTO;
import dto.ContactDto;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class BaseHelper {
    final MediaType JSON = MediaType.get("application/json; charset=utf-8");
    public LoginHelper loginHelper;
    public UserHelp userHelp;
  private   String token = "eyJhbGciOiJIUzI1NiJ9.eyJyb2xlcyI6WyJST0xFX1VTRVIiXSwic3ViIjoiYWJjQGRlZi5jb20iLCJpc3MiOiJSZWd1bGFpdCIsImV4cCI6MTcwMzYxMzgzOSwiaWF0IjoxNzAzMDEzODM5fQ.WThJfwtYCKFKeTPcjw8l3NAOw1KnqqjLKYQKDMTQK_Y";

    public Request PostStart(String msg, String user, String psw) {

        Gson gson = new Gson();

        RequestBody requestBody = RequestBody.create(gson.toJson(UserStock(user, psw)), JSON);
        Request request = new Request.Builder().url("https://contactapp-telran-backend.herokuapp.com" + msg).post(requestBody).build();

        return request;
    }
public Request PostStart(String msg, ContactDto conctactDto) {

        Gson gson = new Gson();

        RequestBody requestBody = RequestBody.create(gson.toJson(conctactDto), JSON);
        Request request = new Request.Builder().url("https://contactapp-telran-backend.herokuapp.com" + msg).addHeader("Authorization", token).post(requestBody).build();

        return request;
    }

    public Request GetStart(String msg) {
        Gson gson = new Gson();


        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("https://contactapp-telran-backend.herokuapp.com/v1/" + msg).addHeader("Authorization", token).build();
        return request;
    }

    public Request PutStart(String msg, Request reques) {
        Gson gson = new Gson();
        OkHttpClient client = new OkHttpClient();

        AuthRequestDTO authRequestDTO = AuthRequestDTO.builder().username("abc@def.com").password("$Abcdef12345").build();
        RequestBody requestBody = RequestBody.create(gson.toJson(authRequestDTO), JSON);
        Request request = new Request.Builder().url("https://contactapp-telran-backend.herokuapp.com/v1/" + msg).put(requestBody).build();

        return request;
    }

    public Request DelStart(String msg, Request reques) {
        Gson gson = new Gson();
        OkHttpClient client = new OkHttpClient();

        AuthRequestDTO authRequestDTO = AuthRequestDTO.builder().username("abc@def.com").password("$Abcdef12345").build();
        RequestBody requestBody = RequestBody.create(gson.toJson(authRequestDTO), JSON);
        Request request = new Request.Builder().url("https://contactapp-telran-backend.herokuapp.com/v1/" + msg).delete(requestBody).build();

        return request;
    }

    public AuthRequestDTO UserStock(String name, String psw) {
        AuthRequestDTO authRequestDTO;
        return authRequestDTO = AuthRequestDTO.builder().username(name).password(psw).build();
    }

}
