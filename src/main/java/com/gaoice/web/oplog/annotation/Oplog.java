package com.gaoice.web.oplog.annotation;

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
