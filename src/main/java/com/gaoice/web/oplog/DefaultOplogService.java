package com.gaoice.web.oplog;

import com.gaoice.web.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

@Slf4j
public class DefaultOplogService implements OplogService {

    @Override
    public void log(String operation, HashMap<String, Object> params, boolean success) {
        log.info("[operation:{}，params:{}，success:{}]", operation, JsonUtils.toJson(params), success);
    }
}
