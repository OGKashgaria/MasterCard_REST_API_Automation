package com.mastercard.RESTUtilis;

import org.apache.commons.lang3.RandomStringUtils;

public class GenerateData {

    public static String info_id(){
        String info_id = ""+ RandomStringUtils.randomNumeric(1);
        return info_id;
    }

    public static String getAdd1(){
        return "Spring Road " + RandomStringUtils.randomAlphabetic(5);
    }
    public static String getAdd2(){
     return "You can skip...";
    }
    public static String getCity(){
        return "St. Louis " + RandomStringUtils.randomAlphabetic(3);
    }
    public static String getState(){
        return "Missouri" + RandomStringUtils.randomAlphabetic(3);
    }
    public static String getZipCode(){
        return "631" + RandomStringUtils.randomNumeric(2);
    }

    public static String getCountry(String countryName){
        String country ="";
        if (countryName.equalsIgnoreCase("usa"))
            return "USA " + RandomStringUtils.randomAlphabetic(3);
        else if(countryName.equalsIgnoreCase("canada"))
            return "Canada " + RandomStringUtils.randomAlphabetic(2);
        else
            return country;
    }
}
