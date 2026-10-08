package com.fyber.inneractive.sdk.ui;

import com.fyber.inneractive.sdk.web.m;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IAmraidWebViewController f1638a;

    public g(IAmraidWebViewController iAmraidWebViewController) {
        this.f1638a = iAmraidWebViewController;
    }

    @Override // java.lang.Runnable
    public final void run() {
        m mVar = this.f1638a.b;
        if (mVar != null) {
            try {
                mVar.invalidate();
            } catch (Throwable unused) {
            }
        }
    }
}
