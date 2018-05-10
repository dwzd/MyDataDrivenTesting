package com.da.exercise;

public class ReverseString {
    public static void main(String[] args) {
        String enter = "the white dog is eating a hotdog";
        String output = reverse(enter);
        System.out.println(output);
    }
    private static String reverse(String input){
        String reverse = "";
        if(input.isEmpty() || input == null){
            System.out.println("Can not enter the null string!!!");
        }
        if(input.length() <= 1){
            reverse = input;
        }else {
            //先把字符串转换成数组 \s 表示空格，+ 为多个
            String[] inputArray = input.split("\\s+");
            for(String item: inputArray)
                reverse = item + " " + reverse;
        }
        //trim() 可去除字符串前后空格
        return reverse.trim();
    }
}
