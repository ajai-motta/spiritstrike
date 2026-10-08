package com.moloco.sdk.internal.services.bidtoken;

import android.os.Build;
import com.moloco.sdk.BuildConfig;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.services.J;
import com.moloco.sdk.service_locator.a;
import io.ktor.client.HttpClient;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes6.dex */
public final class A {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f2294a = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.internal.services.bidtoken.A$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return A.a();
        }
    });

    public static final z a() {
        MolocoLogger.info$default(MolocoLogger.INSTANCE, "ServerBidTokenService", "Creating BidTokenService instance", null, false, 12, null);
        a.e eVar = a.e.f2423a;
        HttpClient httpClientA = com.moloco.sdk.internal.http.a.a(eVar.h().invoke(), eVar.l().invoke());
        j jVar = new j(2800L, 3, 200L);
        String language = Locale.getDefault().getLanguage();
        Intrinsics.checkNotNullExpressionValue(language, "getLanguage(...)");
        String RELEASE = Build.VERSION.RELEASE;
        Intrinsics.checkNotNullExpressionValue(RELEASE, "RELEASE");
        String str = Build.MANUFACTURER;
        String str2 = str == null ? "" : str;
        String str3 = Build.MODEL;
        String str4 = str3 == null ? "" : str3;
        String str5 = Build.HARDWARE;
        return new z(new c(BuildConfig.SDK_VERSION_NAME, httpClientA, jVar, new g(language, RELEASE, str2, str4, str5 == null ? "" : str5)), CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(com.moloco.sdk.internal.scheduling.b.a().getIo())), v.f2330a.a(new com.moloco.sdk.internal.bidtoken.c(), new J()));
    }

    public static final z c() {
        return (z) f2294a.getValue();
    }
}
