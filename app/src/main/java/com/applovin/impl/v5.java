package com.applovin.impl;

import android.text.TextUtils;
import android.webkit.URLUtil;
import com.applovin.impl.b0;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class v5 extends j5 {
    private final b g;

    public interface b {
        void a(b0.b bVar);

        void a(String str);
    }

    public v5(com.applovin.impl.sdk.k kVar, b bVar) {
        super("TaskFetchDeveloperUri", kVar);
        this.g = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        String strValueOf = String.valueOf(this.f428a.A().F().get("package_name"));
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Looking up developer URI for package name: " + strValueOf);
        }
        this.f428a.r0().a(new a(com.applovin.impl.sdk.network.a.a(this.f428a).c("GET").b("https://play.google.com/store/apps/details?id=" + strValueOf).a((Object) "").a(false).a(), this.f428a));
    }

    class a extends m6 {
        a(com.applovin.impl.sdk.network.a aVar, com.applovin.impl.sdk.k kVar) {
            super(aVar, kVar);
        }

        @Override // com.applovin.impl.m6, com.applovin.impl.q0.e
        public void a(String str, String str2, int i) {
            if (TextUtils.isEmpty(str2)) {
                if (com.applovin.impl.sdk.o.a()) {
                    this.c.b(this.b, "No developer URI found - response from the Play Store is empty");
                }
                v5.this.g.a(b0.b.APP_DETAILS_NOT_FOUND);
                return;
            }
            Matcher matcher = Pattern.compile("(?<=\"appstore:developer_url\" content=\").*?(?=\">)").matcher(str2);
            if (!matcher.find()) {
                if (com.applovin.impl.sdk.o.a()) {
                    this.c.b(this.b, "No developer URI found - unable to find the developer_url meta tag from the Play Store listing");
                }
                v5.this.g.a(b0.b.INVALID_DEVELOPER_URI);
                return;
            }
            String strGroup = matcher.group();
            if (!URLUtil.isValidUrl(strGroup)) {
                if (com.applovin.impl.sdk.o.a()) {
                    this.c.b(this.b, "Developer URI (" + strGroup + ") is not valid");
                }
                v5.this.g.a(b0.b.INVALID_DEVELOPER_URI);
                return;
            }
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Found developer URI: " + strGroup);
            }
            v5.this.g.a(strGroup);
        }

        @Override // com.applovin.impl.m6, com.applovin.impl.q0.e
        public void a(String str, int i, String str2, String str3) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.b(this.b, "Unable to fetch app details due to: " + str2 + ", and received error code: " + i);
            }
            v5.this.g.a(b0.b.APP_DETAILS_NOT_FOUND);
        }
    }
}
