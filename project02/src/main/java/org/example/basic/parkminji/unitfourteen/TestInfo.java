package org.example.basic.parkminji.unitfourteen;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface TestInfo {
    String author();
    String date();
}
