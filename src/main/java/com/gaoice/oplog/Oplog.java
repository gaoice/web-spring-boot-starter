package com.gaoice.oplog;

import java.lang.annotation.*;

/**
 * @author gaoice
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Oplog {

    String value() default "";
}
