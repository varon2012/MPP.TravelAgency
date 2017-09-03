package com.bsuir.agency.utils;

public class HelpUtils {
    public static boolean isNullOrEmpty(String value){
        if(value == null || value.isEmpty())
            return true;
        return false;
    }
}
