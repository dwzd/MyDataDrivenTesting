package com.main;

public class Mutiple {
    public static void main(String[] args) {
        simpleMultiple(9);
    }
    public static void simpleMultiple(int num){
        for(int x=1; x<=num; x++){
            for(int y=1; y<=x; y++){
                System.out.print(y + "*" + x + "=" + y*x +"\t");
            }
            System.out.println();
        }
    }


}
