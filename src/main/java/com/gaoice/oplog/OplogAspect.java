package com.gaoice.oplog;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * @author gaoice
 */
@Slf4j
@Aspect
@Component
public class OplogAspect {

    private final OplogService oplogService;

    public OplogAspect(OplogService oplogService) {
        this.oplogService = oplogService;
    }

    @AfterReturning(pointcut = "@annotation(com.gaoice.oplog.Oplog)")
    public void afterReturning(JoinPoint point) {
        try {
            oplogService.log(getAnnotationValue(point), ExtendedOplog.get(), true);
        } catch (Exception e) {
            log.error("OplogAspect error: ", e);
        } finally {
            ExtendedOplog.clear();
        }
    }

    @AfterThrowing(pointcut = "@annotation(com.gaoice.oplog.Oplog)")
    public void afterThrowing(JoinPoint point) {
        try {
            oplogService.log(getAnnotationValue(point), ExtendedOplog.get(), false);
        } catch (Exception e) {
            log.error("OplogAspect error: ", e);
        } finally {
            ExtendedOplog.clear();
        }
    }

    /**
     * 获取注解值
     */
    public String getAnnotationValue(JoinPoint point) {
        MethodSignature methodSignature = (MethodSignature) point.getSignature();
        return methodSignature.getMethod().getAnnotation(Oplog.class).value();
    }
}
