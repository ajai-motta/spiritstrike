package com.fyber.inneractive.sdk.web;

import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: loaded from: classes3.dex */
public final class w implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ x f1720a;

    public w(x xVar) {
        this.f1720a = xVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f1720a.f1722a.getClass();
        com.fyber.inneractive.sdk.util.r.b.post(new v("Image failed to download."));
        this.f1720a.f1722a.a(com.fyber.inneractive.sdk.mraid.k.STORE_PICTURE, "Error downloading and saving image file.");
        IAlog.a("failed to download and save the image file.", new Object[0]);
    }
}
