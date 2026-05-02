package org.example.Utils;

public class Util {
    public static java.sql.Date sqlDate(java.util.Date date){
        return  new java.sql.Date(date.getTime());
    }
}
