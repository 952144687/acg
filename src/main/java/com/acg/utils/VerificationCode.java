package com.acg.utils;

import java.util.Random;

public class VerificationCode {
    //Random类
    Random random=new Random();//随机生成器
    //范围在26个大小写字母，与10个数字之间
    char[] chars = new char[]{'a','b','c','d','e' ,'f','g','h','i','j','k' ,'m','n','p','q','r','s' ,'t','u','v','w','x','y' ,'z',
            'A','B','C','D','E' ,'F','G','H','I','J','K' ,'M','N','P','Q','R','S' ,'T','U','V','W','X','Y' ,'Z','2','3','4','5','6','7','8','9'};

    public String Code(){
        String code ="";
        for(int i=0;i<4;i++)
        {
            int index=random.nextInt(chars.length);//每次遍历生成数组长度范围内的随机整数
            //System.out.println(index);
            //生成数组中的随机整数作为下标得到对应的字符值，字符串加字符结果为字符串
            code+=chars[index];

        }
        return code;
    }
}
