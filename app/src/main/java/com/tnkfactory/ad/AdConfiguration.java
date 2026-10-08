package com.tnkfactory.ad;

import android.content.Context;
import com.tnkfactory.ad.pub.m4;
import com.tnkfactory.ad.pub.r0;

/* JADX INFO: loaded from: classes6.dex */
public class AdConfiguration {
    public static void enableLogging(boolean z) {
        Logger.enableLogging(z);
    }

    public static String getAdid() {
        return r0.x.c;
    }

    public static void setCOPPA(Context context, boolean z) {
        m4.a(context).a(z ? 1 : 0);
    }

    public static void setContentRating(Context context, int i) {
    }

    public static void setGDPRConsent(Context context, boolean z) {
        m4.a(context).b(z ? 1 : 0);
    }

    public static void setPublisherId(Context context, String str) {
        m4.a(context).c(str.replaceAll("-", "").trim());
    }
}
