package lesson26_serializable._02_standard_inheritance;

import java.io.Serializable;
import java.util.StringJoiner;

public class Child extends Parent implements Serializable {
    static final long serialVersionUID = 1L;

    int childField;

    public Child(int childField) {
        System.out.println("Inside Child constructor");
        this.childField = childField;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Child.class.getSimpleName() + "[", "]")
                .add("childField=" + childField)
                .add("parentField=" + parentField)
                .toString();
    }
}
