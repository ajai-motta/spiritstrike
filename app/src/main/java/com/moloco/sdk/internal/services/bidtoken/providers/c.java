package com.moloco.sdk.internal.services.bidtoken.providers;

import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.services.AbstractC3002c;
import com.moloco.sdk.internal.services.InterfaceC3003d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class c implements j<AbstractC3002c> {
    public static final a d = new a(null);
    public static final int e = 8;
    public static final String f = "AdvertisingSignalProvider";
    public final InterfaceC3003d b;
    public AbstractC3002c c;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }
    }

    public c(InterfaceC3003d advertisingService) {
        Intrinsics.checkNotNullParameter(advertisingService, "advertisingService");
        this.b = advertisingService;
        this.c = e();
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    public void a() {
        this.c = e();
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    public boolean b() {
        boolean z = !Intrinsics.areEqual(this.c, e());
        MolocoLogger.debugBuildLog$default(MolocoLogger.INSTANCE, f, "[CBT][ASP]: needsRefresh: " + z, false, 4, null);
        return z;
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    public String c() {
        return f;
    }

    public final AbstractC3002c e() {
        AbstractC3002c abstractC3002cA = this.b.a();
        MolocoLogger.debugBuildLog$default(MolocoLogger.INSTANCE, f, "[CBT][ASP]: adData: " + abstractC3002cA, false, 4, null);
        return abstractC3002cA;
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public AbstractC3002c d() {
        return e();
    }
}
