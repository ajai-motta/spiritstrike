package com.fyber.inneractive.sdk.config;

import android.content.Context;
import android.text.TextUtils;
import com.fyber.inneractive.sdk.external.InneractiveAdManager;
import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: loaded from: classes3.dex */
public final class m0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f964a;
    public final /* synthetic */ w b;

    public m0(Context context, w wVar) {
        this.f964a = context;
        this.b = wVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (InneractiveAdManager.isCurrentUserAChild()) {
            return;
        }
        try {
            Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
            n0.a(this.f964a, this.b);
            v vVar = u.f982a.b;
            if (TextUtils.isEmpty(vVar != null ? vVar.f984a : null)) {
                n.a(this.f964a, this.b);
            }
        } catch (Throwable th) {
            IAlog.b("SDK internal error: Make sure that Google Play Services for Mobile Ads is added to the compile dependencies of your project" + th.toString(), new Object[0]);
        }
    }
}
