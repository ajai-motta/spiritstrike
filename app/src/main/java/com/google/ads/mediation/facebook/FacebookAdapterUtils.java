package com.google.ads.mediation.facebook;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FacebookAdapterUtils.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/google/ads/mediation/facebook/FacebookAdapterUtils;", "", "<init>", "()V", "adapterVersion", "", "getAdapterVersion$annotations", "getAdapterVersion", "()Ljava/lang/String;", "adx-library-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FacebookAdapterUtils {
    public static final FacebookAdapterUtils INSTANCE = new FacebookAdapterUtils();

    @JvmStatic
    public static /* synthetic */ void getAdapterVersion$annotations() {
    }

    private FacebookAdapterUtils() {
    }

    public static final String getAdapterVersion() {
        String ADAPTER_VERSION = BuildConfig.ADAPTER_VERSION;
        Intrinsics.checkNotNullExpressionValue(ADAPTER_VERSION, "ADAPTER_VERSION");
        return ADAPTER_VERSION;
    }
}
