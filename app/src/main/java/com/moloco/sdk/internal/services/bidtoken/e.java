package com.moloco.sdk.internal.services.bidtoken;

import com.moloco.sdk.BidToken;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f2301a;
    public static final k b;

    static {
        f fVar = new f(false);
        f2301a = fVar;
        b = new k("", "", fVar);
    }

    public static final f a() {
        return f2301a;
    }

    public static final k b() {
        return b;
    }

    public static final f a(BidToken.BidTokenResponseV3 bidTokenResponseV3) {
        Intrinsics.checkNotNullParameter(bidTokenResponseV3, "<this>");
        return bidTokenResponseV3.hasClientTokenConfigs() ? new f(bidTokenResponseV3.getClientTokenConfigs().getEnableDbt()) : f2301a;
    }
}
