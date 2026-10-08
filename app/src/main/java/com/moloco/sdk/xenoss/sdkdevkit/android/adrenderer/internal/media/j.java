package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media;

import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.v;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.H;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c;
import java.io.File;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: loaded from: classes6.dex */
public final class j implements i {
    public static final a k = new a(null);
    public static final int l = 8;
    public static final String m = "MediaCacheRepository";
    public static final String n = "TEMP";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f2545a;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.d b;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.a c;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.f d;
    public final CoroutineScope e;
    public final ConcurrentHashMap<String, Mutex> f;
    public final HashSet<String> g;
    public final ConcurrentHashMap<String, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.b> h;
    public final CoroutineScope i;
    public Job j;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }

        public final String a(String str) {
            return str + j.n;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.MediaCacheRepositoryImpl$getMediaFile$2", f = "MediaCacheRepository.kt", i = {0, 1, 1, 1}, l = {373, 161}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv", "dstFile", "tmpFile"}, s = {"L$0", "L$0", "L$2", "L$3"})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super i.a>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2546a;
        public Object b;
        public Object c;
        public Object d;
        public int e;
        public final /* synthetic */ String f;
        public final /* synthetic */ j g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, j jVar, Continuation<? super b> continuation) {
            super(2, continuation);
            this.f = str;
            this.g = jVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super i.a> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new b(this.f, this.g, continuation);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:59:0x019d A[Catch: all -> 0x0034, Exception -> 0x0037, TryCatch #1 {all -> 0x0034, blocks: (B:7:0x002b, B:57:0x0197, B:59:0x019d, B:61:0x01b5, B:64:0x01db, B:76:0x01f4), top: B:82:0x0015 }] */
        /* JADX WARN: Removed duplicated region for block: B:67:0x01e4  */
        /* JADX WARN: Type inference failed for: r11v0 */
        /* JADX WARN: Type inference failed for: r11v1, types: [kotlinx.coroutines.sync.Mutex] */
        /* JADX WARN: Type inference failed for: r11v5, types: [java.lang.Object, kotlinx.coroutines.sync.Mutex] */
        /* JADX WARN: Type inference failed for: r11v8 */
        /* JADX WARN: Type inference failed for: r11v9 */
        /* JADX WARN: Type inference failed for: r6v1 */
        /* JADX WARN: Type inference failed for: r6v2 */
        /* JADX WARN: Type inference failed for: r6v3, types: [kotlinx.coroutines.sync.Mutex] */
        /* JADX WARN: Type inference failed for: r6v4, types: [kotlinx.coroutines.sync.Mutex] */
        /* JADX WARN: Type inference failed for: r6v7 */
        /* JADX WARN: Type inference failed for: r6v8 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r30) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 552
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.j.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.MediaCacheRepositoryImpl$streamMediaFile$2", f = "MediaCacheRepository.kt", i = {0}, l = {373}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
    public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2547a;
        public Object b;
        public Object c;
        public Object d;
        public int e;
        public final /* synthetic */ String f;
        public final /* synthetic */ j g;
        public final /* synthetic */ String h;

        @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.MediaCacheRepositoryImpl$streamMediaFile$2$1$1", f = "MediaCacheRepository.kt", i = {}, l = {228}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f2548a;
            public final /* synthetic */ j b;
            public final /* synthetic */ String c;
            public final /* synthetic */ File d;
            public final /* synthetic */ String e;
            public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.b f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(j jVar, String str, File file, String str2, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.b bVar, Continuation<? super a> continuation) {
                super(2, continuation);
                this.b = jVar;
                this.c = str;
                this.d = file;
                this.e = str2;
                this.f = bVar;
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new a(this.b, this.c, this.d, this.e, this.f, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.f2548a;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.a aVar = this.b.c;
                    String str = this.c;
                    File file = this.d;
                    String str2 = this.e;
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.b bVar = this.f;
                    this.f2548a = 1;
                    if (aVar.a(str, file, str2, bVar, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this.b.g.remove(this.c);
                this.b.h.remove(this.c);
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str, j jVar, String str2, Continuation<? super c> continuation) {
            super(2, continuation);
            this.f = str;
            this.g = jVar;
            this.h = str2;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c> continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new c(this.f, this.g, this.h, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Mutex mutex;
            j jVar;
            String str;
            String str2;
            Object objPutIfAbsent;
            Object objPutIfAbsent2;
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c c0438c;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.e;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MolocoLogger.info$default(MolocoLogger.INSTANCE, j.m, "Streaming media for: " + this.f, null, false, 12, null);
                if (this.f.length() == 0) {
                    return new c.b(i.a.AbstractC0435a.k.c);
                }
                ConcurrentHashMap concurrentHashMap = this.g.f;
                String str3 = this.f;
                Object objMutex$default = concurrentHashMap.get(str3);
                if (objMutex$default == null && (objPutIfAbsent = concurrentHashMap.putIfAbsent(str3, (objMutex$default = MutexKt.Mutex$default(false, 1, null)))) != null) {
                    objMutex$default = objPutIfAbsent;
                }
                mutex = (Mutex) objMutex$default;
                Intrinsics.checkNotNull(mutex);
                j jVar2 = this.g;
                String str4 = this.f;
                String str5 = this.h;
                this.f2547a = mutex;
                this.b = jVar2;
                this.c = str4;
                this.d = str5;
                this.e = 1;
                if (mutex.lock(null, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                jVar = jVar2;
                str = str4;
                str2 = str5;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                String str6 = (String) this.d;
                String str7 = (String) this.c;
                j jVar3 = (j) this.b;
                mutex = (Mutex) this.f2547a;
                ResultKt.throwOnFailure(obj);
                str2 = str6;
                str = str7;
                jVar = jVar3;
            }
            try {
                v vVarC = jVar.c();
                if (vVarC instanceof v.a) {
                    return ((v.a) vVarC).a();
                }
                if (!(vVarC instanceof v.b)) {
                    throw new NoWhenBranchMatchedException();
                }
                File fileA = jVar.a(str, (File) ((v.b) vVarC).a());
                MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
                MolocoLogger.info$default(molocoLogger, j.m, "Going to download the media file to location: " + fileA.getAbsolutePath(), null, false, 12, null);
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.b bVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.b) jVar.h.get(str);
                if (jVar.g.contains(str)) {
                    MolocoLogger.info$default(molocoLogger, j.m, "Media file is already being downloaded, so returning in progress status for url: " + str, null, false, 12, null);
                    if (bVar == null || (c0438c = bVar.a()) == null) {
                        c0438c = new c.C0438c(fileA, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.d.a());
                    }
                    return c0438c;
                }
                if (jVar.c.b(fileA)) {
                    return new c.a(fileA);
                }
                MolocoLogger.info$default(molocoLogger, j.m, "Media file needs to be downloaded: " + str, null, false, 12, null);
                jVar.g.add(str);
                ConcurrentHashMap concurrentHashMap2 = jVar.h;
                Object bVar2 = concurrentHashMap2.get(str);
                if (bVar2 == null && (objPutIfAbsent2 = concurrentHashMap2.putIfAbsent(str, (bVar2 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.b(new c.C0438c(fileA, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.d.a()))))) != null) {
                    bVar2 = objPutIfAbsent2;
                }
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.b bVar3 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.b) bVar2;
                BuildersKt__Builders_commonKt.launch$default(jVar.e, null, null, new a(jVar, str, fileA, str2, bVar3, null), 3, null);
                return bVar3.a();
            } finally {
                mutex.unlock(null);
            }
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.MediaCacheRepositoryImpl$streamMediaFileStatus$1", f = "MediaCacheRepository.kt", i = {}, l = {249}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends SuspendLambda implements Function2<FlowCollector<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c>, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2549a;
        public /* synthetic */ Object b;
        public final /* synthetic */ File c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(File file, Continuation<? super d> continuation) {
            super(2, continuation);
            this.c = file;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(FlowCollector<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c> flowCollector, Continuation<? super Unit> continuation) {
            return ((d) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            d dVar = new d(this.c, continuation);
            dVar.b = obj;
            return dVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f2549a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                FlowCollector flowCollector = (FlowCollector) this.b;
                c.a aVar = new c.a(this.c);
                this.f2549a = 1;
                if (flowCollector.emit(aVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.MediaCacheRepositoryImpl$streamMediaFileStatus$cacheDir$1", f = "MediaCacheRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class e extends SuspendLambda implements Function2<FlowCollector<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c>, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2550a;
        public final /* synthetic */ v<File, c.b> b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(v<File, c.b> vVar, Continuation<? super e> continuation) {
            super(2, continuation);
            this.b = vVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(FlowCollector<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c> flowCollector, Continuation<? super Unit> continuation) {
            return ((e) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new e(this.b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f2550a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ((v.a) this.b).a();
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.MediaCacheRepositoryImpl$tryCleanup$newCleanUpJob$1", f = "MediaCacheRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class f extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2551a;

        public f(Continuation<? super f> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((f) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return j.this.new f(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f2551a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            v<File, com.moloco.sdk.internal.m> vVarA = j.this.d.a();
            if (vVarA instanceof v.b) {
                j.this.a((File) ((v.b) vVarA).a());
            } else {
                if (!(vVarA instanceof v.a)) {
                    throw new NoWhenBranchMatchedException();
                }
                MolocoLogger.error$default(MolocoLogger.INSTANCE, j.m, "Failed to cleanup external cache directory", null, false, 12, null);
            }
            v<File, com.moloco.sdk.internal.m> vVarB = j.this.d.b();
            if (vVarB instanceof v.b) {
                j.this.a((File) ((v.b) vVarB).a());
            } else {
                if (!(vVarB instanceof v.a)) {
                    throw new NoWhenBranchMatchedException();
                }
                MolocoLogger.error$default(MolocoLogger.INSTANCE, j.m, "Failed to cleanup internal cache directory", null, false, 12, null);
            }
            return Unit.INSTANCE;
        }
    }

    public j(l mediaConfig, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.d legacyMediaDownloader, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.a chunkedMediaDownloader, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.f mediaCacheLocationProvider) {
        Intrinsics.checkNotNullParameter(mediaConfig, "mediaConfig");
        Intrinsics.checkNotNullParameter(legacyMediaDownloader, "legacyMediaDownloader");
        Intrinsics.checkNotNullParameter(chunkedMediaDownloader, "chunkedMediaDownloader");
        Intrinsics.checkNotNullParameter(mediaCacheLocationProvider, "mediaCacheLocationProvider");
        this.f2545a = mediaConfig;
        this.b = legacyMediaDownloader;
        this.c = chunkedMediaDownloader;
        this.d = mediaCacheLocationProvider;
        this.e = CoroutineScopeKt.CoroutineScope(com.moloco.sdk.internal.scheduling.b.a().getIo());
        this.f = new ConcurrentHashMap<>();
        this.g = new HashSet<>();
        this.h = new ConcurrentHashMap<>();
        this.i = CoroutineScopeKt.CoroutineScope(com.moloco.sdk.internal.scheduling.b.a().getIo());
    }

    public final v<File, c.b> c() {
        v<File, com.moloco.sdk.internal.m> vVarD = d();
        if (!(vVarD instanceof v.a)) {
            if (vVarD instanceof v.b) {
                return new v.b(((v.b) vVarD).a());
            }
            throw new NoWhenBranchMatchedException();
        }
        MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
        String str = m;
        StringBuilder sb = new StringBuilder("Failed to retrieve storageDir with error code: ");
        v.a aVar = (v.a) vVarD;
        sb.append(((com.moloco.sdk.internal.m) aVar.a()).b());
        MolocoLogger.warn$default(molocoLogger, str, sb.toString(), null, false, 12, null);
        switch (((com.moloco.sdk.internal.m) aVar.a()).b()) {
            case 100:
                return new v.a(new c.b(i.a.AbstractC0435a.c.c));
            case 101:
                return new v.a(new c.b(i.a.AbstractC0435a.b.c));
            case 102:
                return new v.a(new c.b(i.a.AbstractC0435a.C0436a.c));
            default:
                return new v.a(new c.b(i.a.AbstractC0435a.d.c));
        }
    }

    public final v<File, com.moloco.sdk.internal.m> d() {
        v<File, com.moloco.sdk.internal.m> vVarA = this.d.a();
        if (vVarA instanceof v.a) {
            return this.d.b();
        }
        if (vVarA instanceof v.b) {
            return vVarA;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i
    public Flow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c> b(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        v<File, c.b> vVarC = c();
        if (vVarC instanceof v.a) {
            return FlowKt.flow(new e(vVarC, null));
        }
        if (vVarC instanceof v.b) {
            File file = (File) ((v.b) vVarC).a();
            MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
            String str = m;
            MolocoLogger.info$default(molocoLogger, str, "Collecting status for media file: " + url, null, false, 12, null);
            File fileA = a(url, file);
            if (fileA.exists() && this.c.b(fileA)) {
                return FlowKt.flow(new d(fileA, null));
            }
            MolocoLogger.info$default(molocoLogger, str, "Media file needs to be downloaded: " + url, null, false, 12, null);
            ConcurrentHashMap<String, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.b> concurrentHashMap = this.h;
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.b bVar = concurrentHashMap.get(url);
            if (bVar == null) {
                MolocoLogger.info$default(molocoLogger, str, "Download has not yet started for: " + url, null, false, 12, null);
                bVar = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.b(new c.C0438c(fileA, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.d.a()));
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.b bVarPutIfAbsent = concurrentHashMap.putIfAbsent(url, bVar);
                if (bVarPutIfAbsent != null) {
                    bVar = bVarPutIfAbsent;
                }
            }
            return bVar.b();
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i
    public Object a(String str, Continuation<? super i.a> continuation) {
        return BuildersKt.withContext(com.moloco.sdk.internal.scheduling.b.a().getIo(), new b(str, this, null), continuation);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i
    public Object a(String str, String str2, Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c> continuation) {
        return BuildersKt.withContext(com.moloco.sdk.internal.scheduling.b.a().getIo(), new c(str, this, str2, null), continuation);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c a(String url) {
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c cVarA;
        Intrinsics.checkNotNullParameter(url, "url");
        v<File, c.b> vVarC = c();
        if (vVarC instanceof v.a) {
            return (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c) ((v.a) vVarC).a();
        }
        if (vVarC instanceof v.b) {
            File fileA = a(url, (File) ((v.b) vVarC).a());
            if (fileA.exists() && this.c.b(fileA)) {
                return new c.a(fileA);
            }
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.b bVar = this.h.get(url);
            return (bVar == null || (cVarA = bVar.a()) == null) ? new c.C0438c(fileA, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.d.a()) : cVarA;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final File a(String str, File file) {
        return new File(file, H.b(str));
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i
    public Job a() {
        Job job = this.j;
        if (job != null && job.isActive()) {
            return job;
        }
        Job jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(this.i, null, null, new f(null), 3, null);
        this.j = jobLaunch$default;
        return jobLaunch$default;
    }

    public final void a(File file) {
        try {
            if (SequencesKt.sumOfLong(SequencesKt.map(FilesKt.walkTopDown(file), new Function1() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.j$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Long.valueOf(j.b((File) obj));
                }
            })) < this.f2545a.f()) {
                return;
            }
            try {
                FilesKt.deleteRecursively(file);
            } catch (Exception e2) {
                MolocoLogger.error$default(MolocoLogger.INSTANCE, m, e2.toString(), e2, false, 8, null);
            }
        } catch (Exception e3) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, m, e3.toString(), e3, false, 8, null);
        }
    }

    public static final long b(File it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.length();
    }
}
