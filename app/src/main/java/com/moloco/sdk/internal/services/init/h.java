package com.moloco.sdk.internal.services.init;

import android.content.SharedPreferences;
import android.util.Base64;
import com.facebook.login.LoginLogger;
import com.moloco.sdk.Init;
import com.moloco.sdk.acm.CountEvent;
import com.moloco.sdk.acm.TimerEvent;
import com.moloco.sdk.acm.recorder.MetricsRecorder;
import com.moloco.sdk.internal.MolocoLogger;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes6.dex */
public final class h implements g {
    public static final a d = new a(null);
    public static final int e = 8;
    public static final String f = "InitCacheImpl";
    public final SharedPreferences b;
    public final CoroutineContext c;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.services.init.InitCacheImpl$clearAll$2", f = "InitCache.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2369a;

        public b(Continuation<? super b> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return h.this.new b(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f2369a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            h.this.b.edit().clear().commit();
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.services.init.InitCacheImpl$clearCache$2", f = "InitCache.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2370a;
        public final /* synthetic */ MetricsRecorder b;
        public final /* synthetic */ com.moloco.sdk.internal.services.init.a c;
        public final /* synthetic */ h d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(MetricsRecorder metricsRecorder, com.moloco.sdk.internal.services.init.a aVar, h hVar, Continuation<? super c> continuation) {
            super(2, continuation);
            this.b = metricsRecorder;
            this.c = aVar;
            this.d = hVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new c(this.b, this.c, this.d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f2370a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            TimerEvent timerEventStartTimerEvent = this.b.startTimerEvent("SDKInitCacheClear");
            try {
                MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
                MolocoLogger.info$default(molocoLogger, h.f, "Clearing cache for cacheKey: " + this.c.c(), null, false, 12, null);
                SharedPreferences.Editor editorEdit = this.d.b.edit();
                h hVar = this.d;
                com.moloco.sdk.internal.services.init.a aVar = this.c;
                Intrinsics.checkNotNull(editorEdit);
                hVar.a(aVar, editorEdit);
                editorEdit.remove(this.c.c());
                if (editorEdit.commit()) {
                    MolocoLogger.info$default(molocoLogger, h.f, "Successfully cleared cache for cacheKey: " + this.c.c(), null, false, 12, null);
                    this.b.recordCountEvent(new CountEvent("SDKInitCacheClear").withTag("Result", "success"));
                    this.b.recordTimerEvent(timerEventStartTimerEvent.withTag("Result", "success"));
                } else {
                    MolocoLogger.warn$default(molocoLogger, h.f, "Failed to clear cache for cacheKey: " + this.c.c(), null, false, 12, null);
                    this.b.recordCountEvent(new CountEvent("SDKInitCacheClear").withTag("Result", LoginLogger.EVENT_EXTRAS_FAILURE).withTag("Reason", "commit_failure"));
                    this.b.recordTimerEvent(timerEventStartTimerEvent.withTag("Result", LoginLogger.EVENT_EXTRAS_FAILURE).withTag("Reason", "commit_failure"));
                }
            } catch (Exception e) {
                MolocoLogger.warn$default(MolocoLogger.INSTANCE, h.f, "Failed to clear cache for cacheKey: " + this.c.c() + " with exception", e, false, 8, null);
                MetricsRecorder metricsRecorder = this.b;
                CountEvent countEventWithTag = new CountEvent("SDKInitCacheClear").withTag("Result", LoginLogger.EVENT_EXTRAS_FAILURE);
                String simpleName = e.getClass().getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                metricsRecorder.recordCountEvent(countEventWithTag.withTag("Reason", simpleName));
                MetricsRecorder metricsRecorder2 = this.b;
                TimerEvent timerEventWithTag = timerEventStartTimerEvent.withTag("Result", LoginLogger.EVENT_EXTRAS_FAILURE);
                String simpleName2 = e.getClass().getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName2, "getSimpleName(...)");
                metricsRecorder2.recordTimerEvent(timerEventWithTag.withTag("Reason", simpleName2));
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.services.init.InitCacheImpl$get$2", f = "InitCache.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Init.SDKInitResponse>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2371a;
        public final /* synthetic */ MetricsRecorder b;
        public final /* synthetic */ com.moloco.sdk.internal.services.init.a c;
        public final /* synthetic */ h d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(MetricsRecorder metricsRecorder, com.moloco.sdk.internal.services.init.a aVar, h hVar, Continuation<? super d> continuation) {
            super(2, continuation);
            this.b = metricsRecorder;
            this.c = aVar;
            this.d = hVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Init.SDKInitResponse> continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new d(this.b, this.c, this.d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f2371a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            TimerEvent timerEventStartTimerEvent = this.b.startTimerEvent("SDKInitCacheRead");
            try {
                MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
                MolocoLogger.info$default(molocoLogger, h.f, "Reading cache for cacheKey: " + this.c.c(), null, false, 12, null);
                h hVar = this.d;
                hVar.b(this.c, hVar.b);
                String string = this.d.b.getString(this.c.c(), null);
                Init.SDKInitResponse from = string != null ? Init.SDKInitResponse.parseFrom(Base64.decode(string, 0)) : null;
                if (from != null) {
                    MolocoLogger.info$default(molocoLogger, h.f, "Successfully read cache for cacheKey: " + this.c.c(), null, false, 12, null);
                    this.b.recordTimerEvent(timerEventStartTimerEvent.withTag("Result", "success"));
                    this.b.recordCountEvent(new CountEvent("SDKInitCacheRead").withTag("Result", "success"));
                } else {
                    MolocoLogger.info$default(molocoLogger, h.f, "Failed to read from cache (cache_miss) for cacheKey: " + this.c.c(), null, false, 12, null);
                    this.b.recordTimerEvent(timerEventStartTimerEvent.withTag("Result", LoginLogger.EVENT_EXTRAS_FAILURE).withTag("Reason", "cache_miss"));
                    this.b.recordCountEvent(new CountEvent("SDKInitCacheRead").withTag("Result", LoginLogger.EVENT_EXTRAS_FAILURE).withTag("Reason", "cache_miss"));
                }
                return from;
            } catch (Exception e) {
                MolocoLogger.warn$default(MolocoLogger.INSTANCE, h.f, "Failed to read cache for cacheKey: " + this.c.c() + " with exception", e, false, 8, null);
                MetricsRecorder metricsRecorder = this.b;
                TimerEvent timerEventWithTag = timerEventStartTimerEvent.withTag("Result", LoginLogger.EVENT_EXTRAS_FAILURE);
                String simpleName = e.getClass().getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                metricsRecorder.recordTimerEvent(timerEventWithTag.withTag("Reason", simpleName));
                MetricsRecorder metricsRecorder2 = this.b;
                CountEvent countEventWithTag = new CountEvent("SDKInitCacheRead").withTag("Result", LoginLogger.EVENT_EXTRAS_FAILURE);
                String simpleName2 = e.getClass().getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName2, "getSimpleName(...)");
                metricsRecorder2.recordCountEvent(countEventWithTag.withTag("Reason", simpleName2));
                return null;
            }
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.services.init.InitCacheImpl$updateCache$2", f = "InitCache.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class e extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2372a;
        public final /* synthetic */ MetricsRecorder b;
        public final /* synthetic */ com.moloco.sdk.internal.services.init.a c;
        public final /* synthetic */ Init.SDKInitResponse d;
        public final /* synthetic */ h e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(MetricsRecorder metricsRecorder, com.moloco.sdk.internal.services.init.a aVar, Init.SDKInitResponse sDKInitResponse, h hVar, Continuation<? super e> continuation) {
            super(2, continuation);
            this.b = metricsRecorder;
            this.c = aVar;
            this.d = sDKInitResponse;
            this.e = hVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((e) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new e(this.b, this.c, this.d, this.e, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f2372a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            TimerEvent timerEventStartTimerEvent = this.b.startTimerEvent("SDKInitCacheWrite");
            try {
                MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
                MolocoLogger.info$default(molocoLogger, h.f, "Updating cache for cacheKey: " + this.c.c(), null, false, 12, null);
                boolean z = false;
                String strEncodeToString = Base64.encodeToString(this.d.toByteArray(), 0);
                if (strEncodeToString == null || strEncodeToString.length() == 0) {
                    MolocoLogger.warn$default(molocoLogger, h.f, "Failed to encode SDKInitResponse for cacheKey: " + this.c.c(), null, false, 12, null);
                    z = true;
                }
                if (z || !this.e.b.edit().putString(this.c.c(), strEncodeToString).commit()) {
                    String str = z ? "encoding_failure" : "commit_failure";
                    MolocoLogger.warn$default(molocoLogger, h.f, "Failed to update cache for cacheKey: " + this.c.c() + " with error: " + str, null, false, 12, null);
                    this.b.recordTimerEvent(timerEventStartTimerEvent.withTag("Result", LoginLogger.EVENT_EXTRAS_FAILURE).withTag("Reason", str));
                    this.b.recordCountEvent(new CountEvent("SDKInitCacheWrite").withTag("Result", LoginLogger.EVENT_EXTRAS_FAILURE).withTag("Reason", str));
                } else {
                    MolocoLogger.info$default(molocoLogger, h.f, "Successfully updated cache for cacheKey: " + this.c.c(), null, false, 12, null);
                    this.b.recordTimerEvent(timerEventStartTimerEvent.withTag("Result", "success"));
                    this.b.recordCountEvent(new CountEvent("SDKInitCacheWrite").withTag("Result", "success"));
                }
            } catch (Exception e) {
                MolocoLogger.warn$default(MolocoLogger.INSTANCE, h.f, "Failed to update cache for cacheKey: " + this.c.c() + " with exception", e, false, 8, null);
                MetricsRecorder metricsRecorder = this.b;
                TimerEvent timerEventWithTag = timerEventStartTimerEvent.withTag("Result", LoginLogger.EVENT_EXTRAS_FAILURE);
                String simpleName = e.getClass().getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                metricsRecorder.recordTimerEvent(timerEventWithTag.withTag("Reason", simpleName));
                MetricsRecorder metricsRecorder2 = this.b;
                CountEvent countEventWithTag = new CountEvent("SDKInitCacheWrite").withTag("Result", LoginLogger.EVENT_EXTRAS_FAILURE);
                String simpleName2 = e.getClass().getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName2, "getSimpleName(...)");
                metricsRecorder2.recordCountEvent(countEventWithTag.withTag("Reason", simpleName2));
            }
            return Unit.INSTANCE;
        }
    }

    public h(SharedPreferences sharedPreferences, CoroutineContext ioDispatcherContext) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        Intrinsics.checkNotNullParameter(ioDispatcherContext, "ioDispatcherContext");
        this.b = sharedPreferences;
        this.c = ioDispatcherContext;
    }

    @Override // com.moloco.sdk.internal.services.init.g
    public Object b(com.moloco.sdk.internal.services.init.a aVar, MetricsRecorder metricsRecorder, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(this.c, new c(metricsRecorder, aVar, this, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    public final void b(com.moloco.sdk.internal.services.init.a aVar, SharedPreferences sharedPreferences) {
        MolocoLogger.info$default(MolocoLogger.INSTANCE, f, "Performing migration for cache key: " + aVar.c(), null, false, 12, null);
        a(aVar, sharedPreferences);
    }

    @Override // com.moloco.sdk.internal.services.init.g
    public Object a(com.moloco.sdk.internal.services.init.a aVar, MetricsRecorder metricsRecorder, Init.SDKInitResponse sDKInitResponse, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(this.c, new e(metricsRecorder, aVar, sDKInitResponse, this, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    @Override // com.moloco.sdk.internal.services.init.g
    public Object a(com.moloco.sdk.internal.services.init.a aVar, MetricsRecorder metricsRecorder, Continuation<? super Init.SDKInitResponse> continuation) {
        return BuildersKt.withContext(this.c, new d(metricsRecorder, aVar, this, null), continuation);
    }

    @Override // com.moloco.sdk.internal.services.init.g
    public Object a(Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(this.c, new b(null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    public final void a(com.moloco.sdk.internal.services.init.a aVar, SharedPreferences sharedPreferences) {
        MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
        MolocoLogger.info$default(molocoLogger, f, "Migrating from v0 to v1 for cache key: " + aVar.c(), null, false, 12, null);
        MolocoLogger.info$default(molocoLogger, f, "Total keys in cache: " + sharedPreferences.getAll().size(), null, false, 12, null);
        Map<String, ?> all = sharedPreferences.getAll();
        Intrinsics.checkNotNullExpressionValue(all, "getAll(...)");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            String key = entry.getKey();
            Intrinsics.checkNotNullExpressionValue(key, "<get-key>(...)");
            List listSplit$default = StringsKt.split$default((CharSequence) key, new String[]{"___"}, false, 0, 6, (Object) null);
            if (Intrinsics.areEqual(CollectionsKt.firstOrNull(listSplit$default), aVar.b()) && Intrinsics.areEqual(CollectionsKt.lastOrNull(listSplit$default), "v0")) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        MolocoLogger molocoLogger2 = MolocoLogger.INSTANCE;
        MolocoLogger.info$default(molocoLogger2, f, "Number of existing V0 keys in cache: " + linkedHashMap.size(), null, false, 12, null);
        if (linkedHashMap.isEmpty()) {
            MolocoLogger.info$default(molocoLogger2, f, "No v0 cache keys found for migration for appKey: " + aVar.b(), null, false, 12, null);
            return;
        }
        MolocoLogger.info$default(molocoLogger2, f, "Found v0 cache key: " + ((String) CollectionsKt.first(linkedHashMap.keySet())) + ", migrating to new key: " + aVar.c(), null, false, 12, null);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Intrinsics.checkNotNullExpressionValue(editor, "editor");
        String strC = aVar.c();
        Object objFirst = CollectionsKt.first(linkedHashMap.values());
        editor.putString(strC, objFirst instanceof String ? (String) objFirst : null);
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            editor.remove((String) ((Map.Entry) it.next()).getKey());
        }
        editor.commit();
    }

    public final void a(com.moloco.sdk.internal.services.init.a aVar, SharedPreferences.Editor editor) {
        Iterator<String> it = aVar.d().iterator();
        while (it.hasNext()) {
            editor.remove(it.next());
        }
    }
}
