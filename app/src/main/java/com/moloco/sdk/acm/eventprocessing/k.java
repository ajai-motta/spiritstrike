package com.moloco.sdk.acm.eventprocessing;

import io.ktor.http.HeadersBuilder;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class k implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.moloco.sdk.acm.http.e f1993a;
    public final com.moloco.sdk.acm.db.d b;
    public final f c;
    public final Function1<HeadersBuilder, Unit> d;
    public final String e;

    @DebugMetadata(c = "com.moloco.sdk.acm.eventprocessing.RequestAndPurgeDBImpl", f = "RequestAndPurgeDB.kt", i = {0, 1}, l = {38, 48}, m = "invoke-IoAF18A", n = {"this", "this"}, s = {"L$0", "L$0"})
    public static final class a extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f1994a;
        public /* synthetic */ Object b;
        public int d;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            Object objA = k.this.a(this);
            return objA == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objA : Result.m7414boximpl(objA);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k(com.moloco.sdk.acm.http.e metricsRequest, com.moloco.sdk.acm.db.d metricsDAO, f dataAgeChecker, Function1<? super HeadersBuilder, Unit> headers) {
        Intrinsics.checkNotNullParameter(metricsRequest, "metricsRequest");
        Intrinsics.checkNotNullParameter(metricsDAO, "metricsDAO");
        Intrinsics.checkNotNullParameter(dataAgeChecker, "dataAgeChecker");
        Intrinsics.checkNotNullParameter(headers, "headers");
        this.f1993a = metricsRequest;
        this.b = metricsDAO;
        this.c = dataAgeChecker;
        this.d = headers;
        this.e = "RequestAndPurgeDB";
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.moloco.sdk.acm.eventprocessing.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object a(kotlin.coroutines.Continuation<? super kotlin.Result<java.lang.String>> r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 235
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.acm.eventprocessing.k.a(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
