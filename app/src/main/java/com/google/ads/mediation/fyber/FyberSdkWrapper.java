package com.google.ads.mediation.fyber;

import com.fyber.inneractive.sdk.external.InneractiveAdManager;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FyberSdkWrapper.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R$\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/google/ads/mediation/fyber/FyberSdkWrapper;", "", "<init>", "()V", "delegate", "Lcom/google/ads/mediation/fyber/SdkWrapper;", "getDelegate$annotations", "getDelegate", "()Lcom/google/ads/mediation/fyber/SdkWrapper;", "setDelegate", "(Lcom/google/ads/mediation/fyber/SdkWrapper;)V", "adx-library-fyber_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FyberSdkWrapper {
    public static final FyberSdkWrapper INSTANCE = new FyberSdkWrapper();
    private static SdkWrapper delegate = new SdkWrapper() { // from class: com.google.ads.mediation.fyber.FyberSdkWrapper$delegate$1
        @Override // com.google.ads.mediation.fyber.SdkWrapper
        public boolean isInitialized() {
            return InneractiveAdManager.wasInitialized();
        }
    };

    @JvmStatic
    public static /* synthetic */ void getDelegate$annotations() {
    }

    private FyberSdkWrapper() {
    }

    public static final SdkWrapper getDelegate() {
        return delegate;
    }

    public static final void setDelegate(SdkWrapper sdkWrapper) {
        Intrinsics.checkNotNullParameter(sdkWrapper, "<set-?>");
        delegate = sdkWrapper;
    }
}
