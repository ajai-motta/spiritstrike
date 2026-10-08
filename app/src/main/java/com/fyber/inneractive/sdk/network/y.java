package com.fyber.inneractive.sdk.network;

import android.os.Build;
import android.text.TextUtils;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.google.ads.mediation.pangle.PangleConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1222a;
    public final HashMap b;
    public String c;

    public y(String str, String str2, String str3, Long l, String str4, String str5, String str6, String str7) {
        String str8;
        int i = com.fyber.inneractive.sdk.config.k.f959a;
        String property = System.getProperty("ia.testEnvironmentConfiguration.name");
        if (TextUtils.isEmpty(property)) {
            str8 = "https://" + IAConfigManager.O.i.f;
        } else if (Pattern.compile("^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$").matcher(property).matches()) {
            str8 = "https://" + property + "/simpleM2M/Event";
        } else {
            str8 = "https://" + property + ".inner-active.mobi/simpleM2M/Event";
        }
        this.c = null;
        if (TextUtils.isEmpty(str8)) {
            throw new InvalidParameterException();
        }
        this.b = new HashMap();
        this.f1222a = str8;
        a(str7 == null ? "8.4.0" : str7, "sdkv");
        a(com.fyber.inneractive.sdk.util.o.f1662a.getPackageName(), "pkgn");
        if (IAConfigManager.d()) {
            return;
        }
        a("Android", "osn");
        a(Build.VERSION.RELEASE, com.moloco.sdk.acm.b.c);
        a(com.fyber.inneractive.sdk.util.k.j(), DeviceRequestsHelper.DEVICE_INFO_MODEL);
        a(com.fyber.inneractive.sdk.util.k.l(), "pkgv");
        a(str, PangleConstants.APP_ID);
        a(str2, "session");
        a(str3, "adnt");
        a(l, "adnt_id");
        a(str4, "creative_id");
        a(str5, "adomain");
        a(str6, FirebaseAnalytics.Param.CAMPAIGN_ID);
    }

    public final void a(Object obj, String str) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        this.b.put(str, obj);
    }
}
