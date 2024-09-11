package com.readysetgo.traveltracker.common.util;

public class ConvertUtil {

    public static Long convertToLong(String id) {
        try {
            return Long.valueOf(id);
        } catch (NumberFormatException e) {
            //Todo 커스텀 exception 수정 필요
            throw new IllegalArgumentException("Invalid ID format: " + id);
        }
    }
}
