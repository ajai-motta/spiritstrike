package com.moloco.sdk.acm.eventprocessing;

import android.content.Context;
import androidx.work.CoroutineWorker;
import androidx.work.WorkerParameters;
import com.facebook.internal.NativeProtocol;
import com.moloco.sdk.acm.db.MetricsDb;
import io.ktor.http.HeadersBuilder;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bH\u0096@¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\rR'\u0010\u0019\u001a\u0015\u0012\u0004\u0012\u00020\u000b\u0012\u000b\u0012\t\u0018\u00010\u000b¢\u0006\u0002\b\u00160\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R(\u0010!\u001a\u0013\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u001a¢\u0006\u0002\b\u001d8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\f\u0010 ¨\u0006\""}, d2 = {"Lcom/moloco/sdk/acm/eventprocessing/DBRequestWorker;", "Landroidx/work/CoroutineWorker;", "Landroid/content/Context;", "context", "Landroidx/work/WorkerParameters;", NativeProtocol.WEB_DIALOG_PARAMS, "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "Landroidx/work/ListenableWorker$Result;", "doWork", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "a", "Ljava/lang/String;", "TAG", "Lcom/moloco/sdk/acm/db/d;", "b", "Lcom/moloco/sdk/acm/db/d;", "metricsDAO", "c", "url", "", "Lkotlin/jvm/internal/EnhancedNullability;", "d", "Ljava/util/Map;", "clientOptions", "Lkotlin/Function1;", "Lio/ktor/http/HeadersBuilder;", "", "Lkotlin/ExtensionFunctionType;", "e", "Lkotlin/jvm/functions/Function1;", "()Lkotlin/jvm/functions/Function1;", "headers", "moloco-android-client-metrics_release"}, k = 1, mv = {2, 0, 0})
public final class DBRequestWorker extends CoroutineWorker {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String TAG;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final com.moloco.sdk.acm.db.d metricsDAO;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final String url;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final Map<String, String> clientOptions;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final Function1<HeadersBuilder, Unit> headers;

    @DebugMetadata(c = "com.moloco.sdk.acm.eventprocessing.DBRequestWorker", f = "DBWorkRequest.kt", i = {0}, l = {110}, m = "doWork", n = {"this"}, s = {"L$0"})
    public static final class a extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f1983a;
        public /* synthetic */ Object b;
        public int d;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return DBRequestWorker.this.doWork(this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DBRequestWorker(Context context, WorkerParameters params) {
        super(context, params);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(params, "params");
        this.TAG = "DBRequestWorker";
        this.metricsDAO = MetricsDb.INSTANCE.b(context).b();
        this.url = getInputData().getString("url");
        Map mapMapOf = MapsKt.mapOf(TuplesKt.to(com.moloco.sdk.acm.b.e, getInputData().getString(com.moloco.sdk.acm.b.e)), TuplesKt.to(com.moloco.sdk.acm.b.f, getInputData().getString(com.moloco.sdk.acm.b.f)), TuplesKt.to(com.moloco.sdk.acm.b.g, getInputData().getString(com.moloco.sdk.acm.b.g)), TuplesKt.to(com.moloco.sdk.acm.b.d, getInputData().getString(com.moloco.sdk.acm.b.d)), TuplesKt.to(com.moloco.sdk.acm.b.c, getInputData().getString(com.moloco.sdk.acm.b.c)), TuplesKt.to(com.moloco.sdk.acm.b.h, getInputData().getString(com.moloco.sdk.acm.b.h)), TuplesKt.to(com.moloco.sdk.acm.b.b, getInputData().getString(com.moloco.sdk.acm.b.b)));
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : mapMapOf.entrySet()) {
            if (((String) entry.getValue()) != null) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        this.clientOptions = linkedHashMap;
        this.headers = new com.moloco.sdk.acm.http.a().a((String) linkedHashMap.get(com.moloco.sdk.acm.b.h), (String) linkedHashMap.get(com.moloco.sdk.acm.b.c), (String) linkedHashMap.get(com.moloco.sdk.acm.b.e), (String) linkedHashMap.get(com.moloco.sdk.acm.b.f), (String) linkedHashMap.get(com.moloco.sdk.acm.b.g), (String) linkedHashMap.get(com.moloco.sdk.acm.b.b));
    }

    public final Function1<HeadersBuilder, Unit> a() {
        return this.headers;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.work.CoroutineWorker
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object doWork(kotlin.coroutines.Continuation<? super androidx.work.ListenableWorker.Result> r10) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r0 = r10 instanceof com.moloco.sdk.acm.eventprocessing.DBRequestWorker.a
            if (r0 == 0) goto L13
            r0 = r10
            com.moloco.sdk.acm.eventprocessing.DBRequestWorker$a r0 = (com.moloco.sdk.acm.eventprocessing.DBRequestWorker.a) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            com.moloco.sdk.acm.eventprocessing.DBRequestWorker$a r0 = new com.moloco.sdk.acm.eventprocessing.DBRequestWorker$a
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r0 = r0.f1983a
            com.moloco.sdk.acm.eventprocessing.DBRequestWorker r0 = (com.moloco.sdk.acm.eventprocessing.DBRequestWorker) r0
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Exception -> L32
            kotlin.Result r10 = (kotlin.Result) r10     // Catch: java.lang.Exception -> L32
            r10.getValue()     // Catch: java.lang.Exception -> L32
            goto L73
        L32:
            r10 = move-exception
            goto L7a
        L34:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L3c:
            kotlin.ResultKt.throwOnFailure(r10)
            java.lang.String r10 = r9.url     // Catch: java.lang.Exception -> L78
            if (r10 == 0) goto L72
            com.moloco.sdk.acm.http.b r10 = com.moloco.sdk.acm.http.b.f2000a     // Catch: java.lang.Exception -> L78
            io.ktor.client.HttpClient r2 = com.moloco.sdk.acm.http.c.c()     // Catch: java.lang.Exception -> L78
            java.lang.String r4 = r9.url     // Catch: java.lang.Exception -> L78
            r10.a(r2, r4)     // Catch: java.lang.Exception -> L78
            com.moloco.sdk.acm.eventprocessing.k r2 = new com.moloco.sdk.acm.eventprocessing.k     // Catch: java.lang.Exception -> L78
            com.moloco.sdk.acm.http.e r10 = r10.a()     // Catch: java.lang.Exception -> L78
            com.moloco.sdk.acm.db.d r4 = r9.metricsDAO     // Catch: java.lang.Exception -> L78
            com.moloco.sdk.acm.eventprocessing.f r5 = new com.moloco.sdk.acm.eventprocessing.f     // Catch: java.lang.Exception -> L78
            com.moloco.sdk.acm.services.h r6 = new com.moloco.sdk.acm.services.h     // Catch: java.lang.Exception -> L78
            r6.<init>()     // Catch: java.lang.Exception -> L78
            r7 = 720(0x2d0, double:3.557E-321)
            r5.<init>(r6, r7)     // Catch: java.lang.Exception -> L78
            kotlin.jvm.functions.Function1<io.ktor.http.HeadersBuilder, kotlin.Unit> r6 = r9.headers     // Catch: java.lang.Exception -> L78
            r2.<init>(r10, r4, r5, r6)     // Catch: java.lang.Exception -> L78
            r0.f1983a = r9     // Catch: java.lang.Exception -> L78
            r0.d = r3     // Catch: java.lang.Exception -> L78
            java.lang.Object r10 = r2.a(r0)     // Catch: java.lang.Exception -> L78
            if (r10 != r1) goto L72
            return r1
        L72:
            r0 = r9
        L73:
            androidx.work.ListenableWorker$Result r10 = androidx.work.ListenableWorker.Result.success()     // Catch: java.lang.Exception -> L32
            goto L9c
        L78:
            r10 = move-exception
            r0 = r9
        L7a:
            com.moloco.sdk.acm.services.e r1 = com.moloco.sdk.acm.services.e.f2014a
            java.lang.String r2 = r0.TAG
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r3 = "Work Manager failure: "
            r0.<init>(r3)
            java.lang.String r10 = r10.getMessage()
            r0.append(r10)
            java.lang.String r3 = r0.toString()
            r6 = 12
            r7 = 0
            r4 = 0
            r5 = 0
            com.moloco.sdk.acm.services.e.a(r1, r2, r3, r4, r5, r6, r7)
            androidx.work.ListenableWorker$Result r10 = androidx.work.ListenableWorker.Result.failure()
        L9c:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.acm.eventprocessing.DBRequestWorker.doWork(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
