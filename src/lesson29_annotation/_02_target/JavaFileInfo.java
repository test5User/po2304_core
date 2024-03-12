package lesson29_annotation._02_target;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface JavaFileInfo {
    String name() default "Vasia Pupkin";
    String value() default "0.0";
}
