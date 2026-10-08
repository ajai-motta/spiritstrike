package com.adxcorp.ads.mediation.common;

/* JADX INFO: loaded from: classes2.dex */
public class DataKeys {
    public static final String APPLOVIN_DISABLE_PRECACHE = "APPLOVIN_DISABLE_PRECACHE";
    public static final String DO_NOT_TRACKING_KEY = "DO_NOT_TRACKING";
    public static final String GAID_KEY = "UDID_GAID";
    public static final String LOG_ENABLE_KEY = "LOG_ENABLE";
    public static final String MEDIA_ID_OF_SLOT_KEY = "MEDIA_ID_OF_SLOT";
    public static final String REQUEST_LIMIT_INTERVAL_KEY = "REQUEST_LIMIT_INTERVAL";
    public static final String REQUEST_TIME_KEY = "REQUEST_TIME";
    public static final String RESPONSE_INTERVAL_KEY = "RESPONSE_INTERVAL";
    public static final String SSP_ENABLE_KEY = "SSP_ENABLE";

    public static final String getKeyWithMedia(String str, String str2) {
        return str + ":" + str2;
    }

    public static final String getKeyWithSlot(String str, String str2) {
        return str + "_" + str2;
    }
}
