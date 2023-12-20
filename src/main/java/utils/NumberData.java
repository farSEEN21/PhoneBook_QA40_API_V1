package utils;

import java.util.Random;

public class NumberData {




    public static int RAND_Number(){
        int number = (int) (Math.random() * 10);
        return number;
    }

public static  String RandomPsw(int leght){

    char[] source = "0123456789qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM".toCharArray();
    char[] pass = new char[leght];
    Random random = new Random();
    String stringPass = "";
    while (!(stringPass.matches(".*\\d.*")
            && stringPass.matches(".*[a-z].*")
            && stringPass.matches(".*[A-Z].*"))){
        for (int i = 0; i < leght; i++) {
            pass[i] = source[random.nextInt(source.length)];
        }
        stringPass = new String(pass);
        System.out.println(stringPass);
    }


        return stringPass;


    }

}
