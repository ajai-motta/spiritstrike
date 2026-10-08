package com.fyber.inneractive.sdk.measurement.tracker;

import android.webkit.WebView;
import com.fyber.inneractive.sdk.web.m;
import com.iab.omid.library.fyber.adsession.AdEvents;
import com.iab.omid.library.fyber.adsession.AdSession;
import com.iab.omid.library.fyber.adsession.AdSessionConfiguration;
import com.iab.omid.library.fyber.adsession.AdSessionContext;
import com.iab.omid.library.fyber.adsession.Partner;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AdSession f1151a;
    public AdEvents b;
    public boolean c = false;
    public final Partner d;
    public WebView e;

    public e(Partner partner, m mVar) {
        this.d = partner;
        this.e = mVar;
    }

    public abstract void a();

    public void a(m mVar) {
        AdSessionContext adSessionContextCreateHtmlAdSessionContext;
        try {
            AdSessionConfiguration adSessionConfigurationB = b();
            try {
                adSessionContextCreateHtmlAdSessionContext = AdSessionContext.createHtmlAdSessionContext(this.d, mVar, "", "");
            } catch (Throwable unused) {
                adSessionContextCreateHtmlAdSessionContext = null;
            }
            AdSession adSessionCreateAdSession = AdSession.createAdSession(adSessionConfigurationB, adSessionContextCreateHtmlAdSessionContext);
            this.f1151a = adSessionCreateAdSession;
            adSessionCreateAdSession.registerAdView(mVar);
            this.f1151a.start();
        } catch (Throwable unused2) {
        }
    }

    public abstract AdSessionConfiguration b();

    public abstract void c();
}
