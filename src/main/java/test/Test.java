package test;

import strings.StringFunctions;
import strings.StringUtilKt;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        final ArrayList<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        System.out.println(StringFunctions.joinToString(list,":", "(", ")"));

        char c = StringUtilKt.lastChar("Java");
        System.out.println(c);
    }
}