package com.applovin.impl;

import android.os.Bundle;
import android.text.TextUtils;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.e6;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxAdFormat;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridge;
import io.ktor.client.utils.CacheControl;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class j implements AppLovinCommunicatorSubscriber {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.k f421a;
    private final Object b = new Object();
    private final LinkedHashMap c = new a();
    private final Set d = Collections.synchronizedSet(new HashSet());

    class a extends LinkedHashMap {
        a() {
        }

        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry entry) {
            return size() > 16;
        }
    }

    public interface b {
        void onCreativeIdGenerated(String str, String str2);
    }

    public j(com.applovin.impl.sdk.k kVar) {
        this.f421a = kVar;
        if (c()) {
            AppLovinCommunicator.getInstance(com.applovin.impl.sdk.k.o()).subscribe(this, "safedk_ad_info");
        }
    }

    public Bundle a(String str) {
        Bundle bundle;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.b) {
            bundle = (Bundle) this.c.get(str);
        }
        this.f421a.O();
        if (com.applovin.impl.sdk.o.a()) {
            this.f421a.O().a("AdReviewManager", "Retrieved ad info (" + bundle + ") for serve id: " + str);
        }
        return bundle;
    }

    public void b(b bVar) {
        this.d.remove(bVar);
    }

    public void c(String str) {
        this.f421a.O();
        if (com.applovin.impl.sdk.o.a()) {
            this.f421a.O().a("AdReviewManager", "Removing ad info for serve id: " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.b) {
            this.c.remove(str);
        }
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorEntity
    public String getCommunicatorId() {
        return "j";
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorSubscriber
    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        if ("safedk_ad_info".equals(appLovinCommunicatorMessage.getTopic())) {
            Bundle bundle = appLovinCommunicatorMessage.getMessageData().getBundle(CacheControl.PUBLIC);
            if (bundle == null) {
                this.f421a.O();
                if (com.applovin.impl.sdk.o.a()) {
                    this.f421a.O().k("AdReviewManager", "Received SafeDK ad info without public data");
                    return;
                }
                return;
            }
            Bundle bundle2 = appLovinCommunicatorMessage.getMessageData().getBundle(CacheControl.PRIVATE);
            if (bundle2 == null) {
                this.f421a.O();
                if (com.applovin.impl.sdk.o.a()) {
                    this.f421a.O().k("AdReviewManager", "Received SafeDK ad info without private data");
                    return;
                }
                return;
            }
            if (MaxAdFormat.formatFromString(bundle2.getString(FirebaseAnalytics.Param.AD_FORMAT)) == null) {
                this.f421a.O();
                if (com.applovin.impl.sdk.o.a()) {
                    this.f421a.O().k("AdReviewManager", "Received SafeDK ad info without ad format");
                    return;
                }
                return;
            }
            final String string = bundle2.getString("id");
            if (TextUtils.isEmpty(string)) {
                this.f421a.O();
                if (com.applovin.impl.sdk.o.a()) {
                    this.f421a.O().k("AdReviewManager", "Received SafeDK ad info without serve id");
                    return;
                }
                return;
            }
            synchronized (this.b) {
                this.f421a.O();
                if (com.applovin.impl.sdk.o.a()) {
                    this.f421a.O().a("AdReviewManager", "Storing current SafeDK ad info for serve id: " + string + ", public data: " + bundle);
                }
                this.c.put(string, bundle);
            }
            final String string2 = bundle.getString("ad_review_creative_id");
            this.f421a.O();
            if (com.applovin.impl.sdk.o.a()) {
                this.f421a.O().a("AdReviewManager", "Received SafeDK ad info with Ad Review creative id: " + string2);
            }
            if (!StringUtils.isValidString(string2) || this.d.isEmpty()) {
                return;
            }
            HashSet<b> hashSet = new HashSet(this.d);
            this.f421a.O();
            if (com.applovin.impl.sdk.o.a()) {
                this.f421a.O().a("AdReviewManager", "Notifying listeners: " + this.d);
            }
            for (final b bVar : hashSet) {
                this.f421a.r0().a((j5) new s6(this.f421a, "creativeIdGenerated", new Runnable() { // from class: com.applovin.impl.j$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.a(bVar, string, string2);
                    }
                }), e6.b.OTHER);
            }
        }
    }

    public static String b() {
        return b(MobileAdsBridge.versionMethodName);
    }

    private static String b(String str) {
        Class<?> cls;
        try {
            try {
                cls = Class.forName("com.applovin.quality.AppLovinQualityService");
            } catch (Throwable unused) {
                cls = Class.forName("com.safedk.android.SafeDK");
            }
            return (String) cls.getMethod(str, null).invoke(null, null);
        } catch (Throwable unused2) {
            return "";
        }
    }

    public static boolean c() {
        return StringUtils.isValidString(b());
    }

    public void a(b bVar) {
        this.d.add(bVar);
    }

    public static String a() {
        return b("getSdkKey");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(b bVar, String str, String str2) {
        this.f421a.O();
        if (com.applovin.impl.sdk.o.a()) {
            this.f421a.O().a("AdReviewManager", "Notifying Ad Review creative id generated for listener: " + bVar);
        }
        bVar.onCreativeIdGenerated(str, str2);
    }
}
