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
    default void log(String oplog, HashMap<String, Object> detail, boolean success) {
        LOGGER.debug(oplog, detail, success);
        this.saveOplog(new OplogWrapper(oplog, detail, success));
    }

    void saveOplog(OplogWrapper oplog);
}
