package com.gomfactory.adpie.sdk.common;

/* JADX INFO: loaded from: classes3.dex */
public class DataKeys {
    public static final String CONFIG_ACCESS_DATE_KEY = "CONFIG_ACCESS_DATE";
    public static final String CONFIG_URL_KEY = "CONFIG_URL";
    public static final String CONFIG_UTIME_KEY = "CONFIG_UPDATE_TIME";
    public static final String DO_NOT_TRACKING_KEY = "DO_NOT_TRACKING";
    public static final String GAID_KEY = "UDID_GAID";
    public static final String LOG_ENABLE_KEY = "LOG_ENABLE";
    public static final String MEDIA_ID_OF_SLOT_KEY = "MEDIA_ID_OF_SLOT";
    public static final String REQUEST_LIMIT_INTERVAL_KEY = "REQUEST_LIMIT_INTERVAL";
    public static final String REQUEST_TIME_KEY = "REQUEST_TIME";
    public static final String RESPONSE_INTERVAL_KEY = "RESPONSE_INTERVAL";
    public static final String SSP_ENABLE_KEY = "SSP_ENABLE";
    public static final String SSP_REQUEST_URL_KEY = "SSP_URL";

    public static final String getKeyWithMedia(String str, String str2) {
        return str + ":" + str2;
    }

    public static final String getKeyWithSlot(String str, String str2) {
        return str + "_" + str2;
    }
}
