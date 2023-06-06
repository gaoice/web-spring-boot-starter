package com.gaoice.web.oplog;

import org.springframework.scheduling.annotation.Async;

import java.util.HashMap;

/**
 * @author gaoice
 */
public interface OplogService {

    @Async("oplogExecutor")
    void log(String operation, HashMap<String, Object> params, boolean success);

}
