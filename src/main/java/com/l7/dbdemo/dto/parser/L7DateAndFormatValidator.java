package com.l7.dbdemo.dto.parser;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class L7DateAndFormatValidator implements DateValidator {
    private String dateFormat;

    public L7DateAndFormatValidator(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    @Override
    public boolean isValid(String dateStr) {
        DateFormat sdf = new SimpleDateFormat(this.dateFormat);
        sdf.setLenient(false);
        try {
            sdf.parse(dateStr);
        } catch (ParseException e) {
        	System.out.println(e);
            return false;
        }
        return true;
    }

}
