package com.gaoice.oplog;

import lombok.Data;

import java.util.HashMap;

/**
 * @author gaoice
 */
@Data
public class OplogInfo {

    private String oplog;

    private HashMap<String, Object> oplogDetail;

    private boolean success;

    public OplogInfo(String oplog, HashMap<String, Object> oplogDetail, boolean success) {
        this.oplog = oplog;
        this.oplogDetail = oplogDetail;
        this.success = success;
    }
}
