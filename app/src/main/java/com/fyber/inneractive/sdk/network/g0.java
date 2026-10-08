package com.fyber.inneractive.sdk.network;

import com.unity3d.services.core.network.core.OkHttp3Client;

/* JADX INFO: loaded from: classes3.dex */
public final class g0 {
    public static final g0 c = new g0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f1199a = new k();
    public p1 b;

    public final h a() {
        String property;
        if (this.b == null) {
            try {
                property = System.getProperty("fyber.marketplace.http_executor_stack_name");
            } catch (Throwable unused) {
                property = "hurl";
            }
            if (property != null && property.equals(OkHttp3Client.NETWORK_CLIENT_OKHTTP)) {
                try {
                    Class.forName("okhttp3.OkHttpClient");
                    this.b = new p1();
                } catch (ClassNotFoundException unused2) {
                }
            }
        }
        p1 p1Var = this.b;
        return p1Var != null ? p1Var : this.f1199a;
    }
}
