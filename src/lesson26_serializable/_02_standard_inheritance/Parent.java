package lesson26_serializable._02_standard_inheritance;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

public class Parent {
    int parentField;

    public Parent() {
        System.out.println("Inside parent's constructor");
        parentField = 5;
    }
}
