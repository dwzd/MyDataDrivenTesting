package com.da.exercise;

import java.util.Scanner;

public class ReverseChar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a sentence:");
        //获得用户输入的数据
        String inputText = scanner.nextLine();
        while (inputText.isEmpty() || inputText == null){
            System.out.println("You can not enter a null string!!!");
            inputText = scanner.nextLine();
        }
        scanner.close();
        ReverseChar reverseChar = new ReverseChar();
        String rev =  reverseChar.reverseCharacters(inputText);
        System.out.println(rev
        );
    }
    private String reverseCharacters (String originalString){
        String reverse = "";
        for(int i = originalString.length()-1; i >= 0; i--){
            reverse = reverse + originalString.charAt(i);
        }
        return reverse;
    }
}
