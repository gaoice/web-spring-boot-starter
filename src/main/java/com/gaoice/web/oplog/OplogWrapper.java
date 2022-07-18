package com.gaoice.web.oplog;

import lombok.Data;

import java.util.HashMap;

/**
 * @author gaoice
 */
@Data
public class OplogWrapper {

    private String oplog;

    private HashMap<String, Object> extendedHashMap;

    private boolean success;

    public OplogWrapper(String oplog, HashMap<String, Object> extendedHashMap, boolean success) {
        this.oplog = oplog;
        this.extendedHashMap = extendedHashMap;
        this.success = success;
    }
}
