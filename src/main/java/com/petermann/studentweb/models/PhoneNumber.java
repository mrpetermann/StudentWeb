package com.petermann.studentweb.models;

public class PhoneNumber {
    private final String number;

    public PhoneNumber(String number) {
        if(number.length() == 10 || number.length() == 0)
            this.number = number;
        else
            this.number = "0000000000";
    }

    public String getNumber() {
        return number;
    }

    public String getNumberFormatted() {
        if(number.equals(""))
            return "";

        return "(" + number.substring(0, 3) + ")" + number.substring(3, 6) +
                "-" + number.substring(6);
    }
}
