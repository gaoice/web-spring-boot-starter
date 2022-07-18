package com.gaoice.oplog.annotation;

import com.gaoice.oplog.OplogAspect;
import com.gaoice.oplog.OplogConfig;
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
