package com.solvd.laba.parsers;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateAdapter extends XmlAdapter<String, Date> {

    @Override
    public Date unmarshal(String d) throws Exception {
    return new SimpleDateFormat("yyyy-MM-dd").parse(d);
}
    @Override
    public String marshal(Date d) {
        return new SimpleDateFormat("yyyy-MM-dd").format(d);
    }
}
