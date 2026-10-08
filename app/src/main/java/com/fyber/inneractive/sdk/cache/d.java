package com.fyber.inneractive.sdk.cache;

import android.net.Uri;
import android.text.TextUtils;
import com.fyber.inneractive.sdk.util.IAlog;
import java.io.File;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements a {
    public static final String c = IAlog.a(d.class);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f894a;
    public final String b;

    public d(String str) {
        this.f894a = str;
        Locale locale = Locale.US;
        int iHashCode = str.hashCode();
        StringBuilder sb = new StringBuilder();
        sb.append(iHashCode);
        this.b = sb.toString();
    }

    @Override // com.fyber.inneractive.sdk.cache.a
    public final void a(Object obj) {
        IAlog.c("%s: onCacheCommitted: %s for url: %s", c, (Uri) obj, this.f894a);
    }

    @Override // com.fyber.inneractive.sdk.cache.a
    public final String b() {
        return "";
    }

    @Override // com.fyber.inneractive.sdk.cache.a
    public final String c() {
        return this.b;
    }

    @Override // com.fyber.inneractive.sdk.cache.a
    public final boolean d() {
        return true;
    }

    @Override // com.fyber.inneractive.sdk.cache.a
    public final Object a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return Uri.fromFile(new File(str));
    }

    @Override // com.fyber.inneractive.sdk.cache.a
    public final String a() {
        return this.f894a;
    }
}
