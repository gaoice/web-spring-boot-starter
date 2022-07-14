package com.gaoice.oplog;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author gaoice
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({OplogAspect.class, OplogConfig.class})
public @interface EnableOplog {
}
