package com.gaoice.oplog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;

import java.util.HashMap;

/**
 * @author gaoice
 */
public interface OplogService {
    Logger LOGGER = LoggerFactory.getLogger(OplogService.class);

    @Async("oplogExecutor")
    default void log(String summary, HashMap<String, Object> detail, boolean success) {
        LOGGER.debug(summary, detail, success);
        this.saveOplog(new OplogInfo(summary, detail, success));
    }

    void saveOplog(OplogInfo oplog);
}
