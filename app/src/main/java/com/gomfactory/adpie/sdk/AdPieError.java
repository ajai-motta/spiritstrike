package com.gomfactory.adpie.sdk;

/* JADX INFO: loaded from: classes3.dex */
public class AdPieError {
    public static final int CONTENT_LOAD_ERROR = 107;
    public static final int DUPLICATE_REQUEST = 106;
    public static final int INTERNAL_ERROR = 104;
    public static final int INVALID_LAYOUT = 109;
    public static final int INVALID_REQUEST = 101;
    public static final int LIMIT_REQUEST = 110;
    public static final int NETWORK_ERROR = 102;
    public static final int NO_CONNECTION = 103;
    public static final int NO_FILL = 100;
    public static final int SDK_NOT_INITIALIZE = 105;
    public static final int SERVER_DATA_ERROR = 108;

    public static String getMessage(int i) {
        switch (i) {
            case 100:
                return "(No fill.)";
            case 101:
                return "(Invalid ad request.)";
            case 102:
                return "(A network error occurred.)";
            case 103:
                return "(No internet connection detected.)";
            case 104:
                return "(An internal error occurred.)";
            case 105:
                return "(AdPie SDK must be initialized before ads loading.)";
            case 106:
                return "(Previous ad request is being processed.)";
            case 107:
                return "(An error occurred while loading content.)";
            case 108:
                return "(A server data error occurred.)";
            case 109:
                return "(Invalid ad layout.)";
            case 110:
                return "(Ad request was blocked with minimum time limit.)";
            default:
                return "(An unspecified error occurred.)";
        }
    }
}
