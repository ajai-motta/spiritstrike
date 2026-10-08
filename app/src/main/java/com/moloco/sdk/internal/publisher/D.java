package com.moloco.sdk.internal.publisher;

import com.moloco.sdk.publisher.AdLoad;
import com.moloco.sdk.publisher.FullscreenAd;
import com.moloco.sdk.publisher.InterstitialAd;
import com.moloco.sdk.publisher.InterstitialAdShowListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class D implements InterstitialAd, r, FullscreenAd<InterstitialAdShowListener> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u<InterstitialAdShowListener> f2155a;

    /* JADX WARN: Multi-variable type inference failed */
    public D(u<? super InterstitialAdShowListener> fullscreenAd) {
        Intrinsics.checkNotNullParameter(fullscreenAd, "fullscreenAd");
        this.f2155a = fullscreenAd;
    }

    @Override // com.moloco.sdk.publisher.Destroyable
    public void destroy() {
        this.f2155a.destroy();
    }

    @Override // com.moloco.sdk.internal.publisher.r
    public long getCreateAdObjectStartTime() {
        return this.f2155a.getCreateAdObjectStartTime();
    }

    @Override // com.moloco.sdk.publisher.AdLoad
    public boolean isLoaded() {
        return this.f2155a.isLoaded();
    }

    @Override // com.moloco.sdk.publisher.AdLoad
    public void load(String bidResponseJson, AdLoad.Listener listener) {
        Intrinsics.checkNotNullParameter(bidResponseJson, "bidResponseJson");
        this.f2155a.load(bidResponseJson, listener);
    }

    @Override // com.moloco.sdk.internal.publisher.r
    public void setCreateAdObjectStartTime(long j) {
        this.f2155a.setCreateAdObjectStartTime(j);
    }

    @Override // com.moloco.sdk.publisher.FullscreenAd
    public void show(InterstitialAdShowListener interstitialAdShowListener) {
        this.f2155a.show(E.a(interstitialAdShowListener));
    }
}
