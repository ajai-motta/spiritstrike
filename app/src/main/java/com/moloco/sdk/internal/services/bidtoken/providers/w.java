package com.moloco.sdk.internal.services.bidtoken.providers;

import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.publisher.Moloco;

/* JADX INFO: loaded from: classes6.dex */
public final class w implements j<Boolean> {
    public static final int d = 8;
    public final String b = "SDKInitStateSignalProvider";
    public boolean c = Moloco.isInitialized();

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    public void a() {
        this.c = Moloco.isInitialized();
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    public boolean b() {
        StringBuilder sb;
        boolean z = this.c;
        boolean zIsInitialized = Moloco.isInitialized();
        boolean z2 = z != zIsInitialized;
        MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
        String str = this.b;
        if (z2) {
            sb = new StringBuilder("[CBT] sdkInitialized updated from ");
            sb.append(z);
            sb.append(" to ");
            sb.append(zIsInitialized);
        } else {
            sb = new StringBuilder("[CBT] sdkInitialized didn't change (before: ");
            sb.append(z);
            sb.append(", after: ");
            sb.append(zIsInitialized);
            sb.append(')');
        }
        MolocoLogger.debugBuildLog$default(molocoLogger, str, sb.toString(), false, 4, null);
        return z2;
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    public String c() {
        return this.b;
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public Boolean d() {
        return Boolean.valueOf(this.c);
    }
}
