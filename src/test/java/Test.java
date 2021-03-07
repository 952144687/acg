import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

public class Test {

    public  static void mora(String arg){
        Random random = new Random();
        int i = random.nextInt(3);
        String value = "";
        switch (i){
            case 0:
                value ="剪刀";
                break;
            case 1:
                value ="石头";
                break;
            case 2:
                value ="布";
                break;
        }
        int f =-1;
        switch (arg){
            case "剪刀":
                f = 0;
                break;
            case "石头":
                f = 1;
                break;
            case "布":
                f = 2;
                break;
        }
        if (i==f){
            System.out.println(i);
            System.out.println("平手，都为"+arg);
        }else if ((f-i)==1){
            System.out.println(i);
            System.out.println("胜，电脑出的位为"+value);
        }else {
            System.out.println(i);
            System.out.println("败，电脑出的"+value);
        }

    }
    public static void main(String[] args) {
        mora("石头");
    }
}
