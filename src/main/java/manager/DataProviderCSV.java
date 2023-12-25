package manager;


import dto.ContactDto;
import org.testng.annotations.DataProvider;
import utils.NumberData;

import java.io.BufferedReader;
import java.io.*;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderCSV {

    @DataProvider
    public Iterator<Object[]> DataForCreateContact() {
     List<Object[]> list = new ArrayList<>();
     String path = "C://Users//bluvg//Documents//GitHub//PhoneBook_QA40_API_V1//src//main//resources//Contacts.csv";
     try (BufferedReader reader = new BufferedReader(new FileReader(new File(path)))) {
         String line = reader.readLine();
         while (line != null) {
             String[] split = line.split(",");
             list.add(new Object[]{
                     ContactDto.builder()
                             .name(split[0].trim())
                             .lastName(split[1].trim())
                             .email(split[2].trim()+NumberData.RAND_Number())
                             .phone(split[3].trim()+ NumberData.RAND_Number())
                             .address(split[4].trim())
                             .description(split[5].trim())
                             .build()
             });
             line = reader.readLine();
         }
     } catch (IOException e) {
         e.printStackTrace();
     }
     return list.iterator();

 }
}
