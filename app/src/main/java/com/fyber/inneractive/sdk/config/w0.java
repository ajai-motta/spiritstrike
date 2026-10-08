package com.fyber.inneractive.sdk.config;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.appevents.AppEventsConstants;

/* JADX INFO: loaded from: classes3.dex */
public enum w0 {
    NO_CLICK(AppEventsConstants.EVENT_PARAM_VALUE_NO),
    CTA_BUTTON("1"),
    COMPANION("2"),
    VIDEO(ExifInterface.GPS_MEASUREMENT_3D),
    APP_INFO("4"),
    STORE_PROMO("5");

    String value;

    w0(String str) {
        this.value = str;
    }

    public final String a() {
        return this.value;
    }
}
