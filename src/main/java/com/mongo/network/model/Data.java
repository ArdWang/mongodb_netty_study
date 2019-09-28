package com.mongo.network.model;


import com.mongo.utils.DataFormatUtil;

import java.nio.charset.Charset;

public class Data {
    private static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");
    private final byte[] data;

    Data(byte[] data) {
        super();
        this.data = data;
    }

    @Override
    public String toString() {
        String result = new String(data, DEFAULT_CHARSET);
        return result;
    }

    private String toHexString() {
        return DataFormatUtil.bytesToHex(data);
    }



}
