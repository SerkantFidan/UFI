package com.utilities;

public class Singleton {

    private static String str;

    public String get(){

        if(str==null){
            System.out.println("adding value");
            str="gfgdfgdfgdf";
        }

        return str;
    }

}
