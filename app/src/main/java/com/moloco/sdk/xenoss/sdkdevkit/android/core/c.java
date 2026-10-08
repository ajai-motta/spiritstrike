package com.moloco.sdk.xenoss.sdkdevkit.android.core;

import com.moloco.sdk.internal.MolocoLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes6.dex */
public final class c implements UserAgentService {
    public static final int c = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3030a = "WebBrowserUserAgentService";
    public final Lazy b = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.core.c$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return c.a(this.f$0);
        }
    });

    public final String a() {
        return (String) this.b.getValue();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.core.UserAgentService
    public String invoke() {
        return a();
    }

    public static final String a(c cVar) {
        try {
            String property = System.getProperty("http.agent");
            return property != null ? StringsKt.isBlank(property) ? "" : property : "";
        } catch (Exception e) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, cVar.f3030a, e.toString(), null, false, 12, null);
            return "";
        }
    }
}
