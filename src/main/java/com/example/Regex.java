package com.example;

import java.util.regex.Pattern;

public class Regex {
    public static final int f = Pattern.CASE_INSENSITIVE;

    public static final Pattern[] pattern1 = new Pattern[]{
        Pattern.compile(",",f)    ,                     //0     ,
        Pattern.compile("(\\([^\\(|\\)]*\\))",f)  ,     //1     (anything not '(' or ')')
        Pattern.compile(" ",f)                          //2     whitespace
    };
}
