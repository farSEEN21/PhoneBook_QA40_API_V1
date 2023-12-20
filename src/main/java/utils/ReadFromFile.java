package utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadFromFile {
    static Properties properties = new Properties();

    public static String getProperty(String param) {
        if(properties.toString().equals("{}")){
            initProperty();
        }
        return properties.getProperty(param);
    }
    private static void initProperty() {
        try (FileReader fileReader = new FileReader("C://Users//bluvg//Documents//GitHub//PhoneBook_QA40_API_V1//src//main//resources//1.property")) {
            properties.load(fileReader);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
