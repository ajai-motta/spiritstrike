package com.google.ads.mediation;

import com.google.android.gms.ads.AdError;

/* JADX INFO: loaded from: classes8.dex */
public class AdErrorUtil {
    public static final int ERROR_AD_NOT_READY = 103;
    public static final int ERROR_CONTEXT_NOT_ACTIVITY = 102;
    public static final int ERROR_INTERNAL_SDK = 105;
    public static final int ERROR_INVALID_SERVER_PARAMETERS = 101;
    public static final int ERROR_NO_FILL = 106;
    public static final int ERROR_SDK_INITIALIZATION = 104;

    public static AdError createSDKError(int i, String str, String str2) {
        return new AdError(i, str, str2);
    }
}
