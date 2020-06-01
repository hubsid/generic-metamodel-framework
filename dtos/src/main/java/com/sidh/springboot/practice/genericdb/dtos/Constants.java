package com.sidh.springboot.practice.genericdb.dtos;

public class Constants {
    public static final String AOT_JOIN_TABLE = "ATTRIBUTE_OBJECT_TYPES";
    public static final String AOT_JOIN_TABLE_ATTR = "ATTRIBUTE_ID";
    public static final String AOT_JOIN_TABLE_OT = "OBJECT_TYPE_ID";
    public static final String ROOT_OT_NAME = "root";
    public static final int ROOT_OT_ID = 0;

    public enum ListTypes {
        STRING, INT, DOUBLE, LIST, REF
    }
}
