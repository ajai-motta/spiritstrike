package com.unity3d.ads.core.data.repository;

import android.content.Context;
import com.unity3d.ads.core.data.datasource.CacheDataSource;
import com.unity3d.ads.core.data.model.CacheResult;
import com.unity3d.ads.core.data.model.CachedFile;
import com.unity3d.ads.core.domain.CreateFile;
import com.unity3d.ads.core.domain.GetCacheDirectory;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import com.unity3d.ads.core.domain.work.DownloadPriorityQueue;
import com.unity3d.ads.core.extensions.StringExtensionsKt;
import com.unity3d.services.UnityAdsConstants;
import com.unity3d.services.core.network.domain.CleanupDirectory;
import gatewayprotocol.v1.NativeConfigurationOuterClass;
import io.ktor.http.ContentDisposition;
import java.io.File;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.NonCancellable;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.json.JSONArray;

/* JADX INFO: compiled from: AndroidCacheRepository.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J\u0011\u0010\u0019\u001a\u00020\u001aH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010 J\u0011\u0010!\u001a\u00020\"H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ+\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001f2\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020)H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010*J3\u0010+\u001a\u00020$2\u0006\u0010,\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u001f2\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020)H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010-J\u000e\u0010.\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020\u001fJ!\u0010/\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001f2\u0006\u00100\u001a\u00020\u001fH\u0096@ø\u0001\u0000¢\u0006\u0002\u00101J\u0010\u00102\u001a\u00020\u00152\u0006\u00103\u001a\u00020\u001fH\u0002J\u0010\u00104\u001a\u00020\u001d2\u0006\u00105\u001a\u000206H\u0016J\u0019\u00107\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u001fH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010 R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u00068"}, d2 = {"Lcom/unity3d/ads/core/data/repository/AndroidCacheRepository;", "Lcom/unity3d/ads/core/data/repository/CacheRepository;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "getCacheDirectory", "Lcom/unity3d/ads/core/domain/GetCacheDirectory;", "localCacheDataSource", "Lcom/unity3d/ads/core/data/datasource/CacheDataSource;", "remoteCacheDataSource", "context", "Landroid/content/Context;", "sessionRepository", "Lcom/unity3d/ads/core/data/repository/SessionRepository;", "cleanupDirectory", "Lcom/unity3d/services/core/network/domain/CleanupDirectory;", "downloadPriorityQueue", "Lcom/unity3d/ads/core/domain/work/DownloadPriorityQueue;", "createFile", "Lcom/unity3d/ads/core/domain/CreateFile;", "(Lkotlinx/coroutines/CoroutineDispatcher;Lcom/unity3d/ads/core/domain/GetCacheDirectory;Lcom/unity3d/ads/core/data/datasource/CacheDataSource;Lcom/unity3d/ads/core/data/datasource/CacheDataSource;Landroid/content/Context;Lcom/unity3d/ads/core/data/repository/SessionRepository;Lcom/unity3d/services/core/network/domain/CleanupDirectory;Lcom/unity3d/ads/core/domain/work/DownloadPriorityQueue;Lcom/unity3d/ads/core/domain/CreateFile;)V", "cacheDir", "Ljava/io/File;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "webviewCacheDir", "clearCache", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doesFileExist", "", "fileName", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCacheSize", "", "getFile", "Lcom/unity3d/ads/core/data/model/CacheResult;", "url", "headers", "Lorg/json/JSONArray;", HandleInvocationsFromAdViewer.KEY_DOWNLOAD_PRIORITY, "", "(Ljava/lang/String;Lorg/json/JSONArray;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFileInternal", "cacheDirectory", "(Ljava/io/File;Ljava/lang/String;Lorg/json/JSONArray;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFilename", "getWebviewFile", "type", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initCacheDir", "dirName", "removeFile", "cachedFile", "Lcom/unity3d/ads/core/data/model/CachedFile;", "retrieveFile", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AndroidCacheRepository implements CacheRepository {
    private final File cacheDir;
    private final CleanupDirectory cleanupDirectory;
    private final Context context;
    private final CreateFile createFile;
    private final DownloadPriorityQueue downloadPriorityQueue;
    private final GetCacheDirectory getCacheDirectory;
    private final CacheDataSource localCacheDataSource;
    private final CacheDataSource remoteCacheDataSource;
    private final CoroutineScope scope;
    private final SessionRepository sessionRepository;
    private final File webviewCacheDir;

    /* JADX INFO: renamed from: com.unity3d.ads.core.data.repository.AndroidCacheRepository$doesFileExist$1, reason: invalid class name */
    /* JADX INFO: compiled from: AndroidCacheRepository.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.unity3d.ads.core.data.repository.AndroidCacheRepository", f = "AndroidCacheRepository.kt", i = {}, l = {100}, m = "doesFileExist", n = {}, s = {})
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AndroidCacheRepository.this.doesFileExist(null, this);
        }
    }

    public AndroidCacheRepository(CoroutineDispatcher ioDispatcher, GetCacheDirectory getCacheDirectory, CacheDataSource localCacheDataSource, CacheDataSource remoteCacheDataSource, Context context, SessionRepository sessionRepository, CleanupDirectory cleanupDirectory, DownloadPriorityQueue downloadPriorityQueue, CreateFile createFile) {
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        Intrinsics.checkNotNullParameter(getCacheDirectory, "getCacheDirectory");
        Intrinsics.checkNotNullParameter(localCacheDataSource, "localCacheDataSource");
        Intrinsics.checkNotNullParameter(remoteCacheDataSource, "remoteCacheDataSource");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sessionRepository, "sessionRepository");
        Intrinsics.checkNotNullParameter(cleanupDirectory, "cleanupDirectory");
        Intrinsics.checkNotNullParameter(downloadPriorityQueue, "downloadPriorityQueue");
        Intrinsics.checkNotNullParameter(createFile, "createFile");
        this.getCacheDirectory = getCacheDirectory;
        this.localCacheDataSource = localCacheDataSource;
        this.remoteCacheDataSource = remoteCacheDataSource;
        this.context = context;
        this.sessionRepository = sessionRepository;
        this.cleanupDirectory = cleanupDirectory;
        this.downloadPriorityQueue = downloadPriorityQueue;
        this.createFile = createFile;
        this.scope = CoroutineScopeKt.plus(CoroutineScopeKt.plus(CoroutineScopeKt.CoroutineScope(ioDispatcher), new CoroutineName("CacheRepository")), NonCancellable.INSTANCE);
        this.cacheDir = initCacheDir(UnityAdsConstants.DefaultUrls.CACHE_DIR_NAME);
        this.webviewCacheDir = initCacheDir(UnityAdsConstants.DefaultUrls.CACHE_WEBVIEW_DIR_NAME);
    }

    @Override // com.unity3d.ads.core.data.repository.CacheRepository
    public Object getFile(String str, JSONArray jSONArray, int i, Continuation<? super CacheResult> continuation) {
        return getFileInternal(this.cacheDir, str, jSONArray, i, continuation);
    }

    @Override // com.unity3d.ads.core.data.repository.CacheRepository
    public Object getWebviewFile(String str, String str2, Continuation<? super CacheResult> continuation) {
        File fileInvoke = this.createFile.invoke(this.webviewCacheDir, str2);
        fileInvoke.mkdirs();
        return getFileInternal(fileInvoke, str, null, 0, continuation);
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.data.repository.AndroidCacheRepository$getFileInternal$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AndroidCacheRepository.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/unity3d/ads/core/data/model/CacheResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.unity3d.ads.core.data.repository.AndroidCacheRepository$getFileInternal$2", f = "AndroidCacheRepository.kt", i = {0, 1}, l = {70, 77, 89}, m = "invokeSuspend", n = {ContentDisposition.Parameters.FileName, "fileResult"}, s = {"L$0", "L$0"})
    static final class C31092 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super CacheResult>, Object> {
        final /* synthetic */ File $cacheDirectory;
        final /* synthetic */ int $priority;
        final /* synthetic */ String $url;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C31092(String str, File file, int i, Continuation<? super C31092> continuation) {
            super(2, continuation);
            this.$url = str;
            this.$cacheDirectory = file;
            this.$priority = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AndroidCacheRepository.this.new C31092(this.$url, this.$cacheDirectory, this.$priority, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super CacheResult> continuation) {
            return ((C31092) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x00a9 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r18) throws java.lang.Throwable {
            /*
                r17 = this;
                r0 = r17
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 0
                r4 = 3
                r5 = 2
                r6 = 1
                if (r2 == 0) goto L35
                if (r2 == r6) goto L2b
                if (r2 == r5) goto L23
                if (r2 != r4) goto L1b
                kotlin.ResultKt.throwOnFailure(r18)
                r2 = r18
                goto Laa
            L1b:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L23:
                java.lang.Object r2 = r0.L$0
                kotlinx.coroutines.flow.MutableStateFlow r2 = (kotlinx.coroutines.flow.MutableStateFlow) r2
                kotlin.ResultKt.throwOnFailure(r18)
                goto L96
            L2b:
                java.lang.Object r2 = r0.L$0
                java.lang.String r2 = (java.lang.String) r2
                kotlin.ResultKt.throwOnFailure(r18)
                r6 = r18
                goto L5f
            L35:
                kotlin.ResultKt.throwOnFailure(r18)
                com.unity3d.ads.core.data.repository.AndroidCacheRepository r2 = com.unity3d.ads.core.data.repository.AndroidCacheRepository.this
                java.lang.String r7 = r0.$url
                java.lang.String r2 = r2.getFilename(r7)
                com.unity3d.ads.core.data.repository.AndroidCacheRepository r7 = com.unity3d.ads.core.data.repository.AndroidCacheRepository.this
                com.unity3d.ads.core.data.datasource.CacheDataSource r8 = com.unity3d.ads.core.data.repository.AndroidCacheRepository.access$getLocalCacheDataSource$p(r7)
                java.io.File r9 = r0.$cacheDirectory
                java.lang.String r11 = r0.$url
                int r7 = r0.$priority
                java.lang.Integer r12 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r7)
                r13 = r0
                kotlin.coroutines.Continuation r13 = (kotlin.coroutines.Continuation) r13
                r0.L$0 = r2
                r0.label = r6
                r10 = r2
                java.lang.Object r6 = r8.getFile(r9, r10, r11, r12, r13)
                if (r6 != r1) goto L5f
                return r1
            L5f:
                r10 = r2
                com.unity3d.ads.core.data.model.CacheResult r6 = (com.unity3d.ads.core.data.model.CacheResult) r6
                boolean r2 = r6 instanceof com.unity3d.ads.core.data.model.CacheResult.Success
                if (r2 == 0) goto L67
                return r6
            L67:
                kotlinx.coroutines.flow.MutableStateFlow r2 = kotlinx.coroutines.flow.StateFlowKt.MutableStateFlow(r3)
                com.unity3d.ads.core.data.repository.AndroidCacheRepository r6 = com.unity3d.ads.core.data.repository.AndroidCacheRepository.this
                com.unity3d.ads.core.domain.work.DownloadPriorityQueue r6 = com.unity3d.ads.core.data.repository.AndroidCacheRepository.access$getDownloadPriorityQueue$p(r6)
                int r15 = r0.$priority
                com.unity3d.ads.core.data.repository.AndroidCacheRepository$getFileInternal$2$1 r16 = new com.unity3d.ads.core.data.repository.AndroidCacheRepository$getFileInternal$2$1
                com.unity3d.ads.core.data.repository.AndroidCacheRepository r8 = com.unity3d.ads.core.data.repository.AndroidCacheRepository.this
                java.io.File r9 = r0.$cacheDirectory
                java.lang.String r11 = r0.$url
                int r12 = r0.$priority
                r14 = 0
                r7 = r16
                r13 = r2
                r7.<init>(r8, r9, r10, r11, r12, r13, r14)
                r7 = r16
                kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
                r8 = r0
                kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
                r0.L$0 = r2
                r0.label = r5
                java.lang.Object r5 = r6.invoke(r15, r7, r8)
                if (r5 != r1) goto L96
                return r1
            L96:
                kotlinx.coroutines.flow.Flow r2 = (kotlinx.coroutines.flow.Flow) r2
                kotlinx.coroutines.flow.Flow r2 = kotlinx.coroutines.flow.FlowKt.filterNotNull(r2)
                r5 = r0
                kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
                r0.L$0 = r3
                r0.label = r4
                java.lang.Object r2 = kotlinx.coroutines.flow.FlowKt.first(r2, r5)
                if (r2 != r1) goto Laa
                return r1
            Laa:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.data.repository.AndroidCacheRepository.C31092.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: renamed from: com.unity3d.ads.core.data.repository.AndroidCacheRepository$getFileInternal$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: AndroidCacheRepository.kt */
        @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "com.unity3d.ads.core.data.repository.AndroidCacheRepository$getFileInternal$2$1", f = "AndroidCacheRepository.kt", i = {}, l = {79, 85}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
            final /* synthetic */ File $cacheDirectory;
            final /* synthetic */ MutableStateFlow<CacheResult> $fileResult;
            final /* synthetic */ String $filename;
            final /* synthetic */ int $priority;
            final /* synthetic */ String $url;
            int label;
            final /* synthetic */ AndroidCacheRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(AndroidCacheRepository androidCacheRepository, File file, String str, String str2, int i, MutableStateFlow<CacheResult> mutableStateFlow, Continuation<? super AnonymousClass1> continuation) {
                super(1, continuation);
                this.this$0 = androidCacheRepository;
                this.$cacheDirectory = file;
                this.$filename = str;
                this.$url = str2;
                this.$priority = i;
                this.$fileResult = mutableStateFlow;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, this.$cacheDirectory, this.$filename, this.$url, this.$priority, this.$fileResult, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Removed duplicated region for block: B:29:? A[LOOP:0: B:24:0x0079->B:29:?, LOOP_END, SYNTHETIC] */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
                /*
                    r10 = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r1 = r10.label
                    r2 = 2
                    r3 = 1
                    if (r1 == 0) goto L1e
                    if (r1 == r3) goto L1a
                    if (r1 != r2) goto L12
                    kotlin.ResultKt.throwOnFailure(r11)
                    goto L75
                L12:
                    java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r11.<init>(r0)
                    throw r11
                L1a:
                    kotlin.ResultKt.throwOnFailure(r11)
                    goto L3f
                L1e:
                    kotlin.ResultKt.throwOnFailure(r11)
                    com.unity3d.ads.core.data.repository.AndroidCacheRepository r11 = r10.this$0
                    com.unity3d.ads.core.data.datasource.CacheDataSource r4 = com.unity3d.ads.core.data.repository.AndroidCacheRepository.access$getLocalCacheDataSource$p(r11)
                    java.io.File r5 = r10.$cacheDirectory
                    java.lang.String r6 = r10.$filename
                    java.lang.String r7 = r10.$url
                    int r11 = r10.$priority
                    java.lang.Integer r8 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r11)
                    r9 = r10
                    kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
                    r10.label = r3
                    java.lang.Object r11 = r4.getFile(r5, r6, r7, r8, r9)
                    if (r11 != r0) goto L3f
                    return r0
                L3f:
                    com.unity3d.ads.core.data.model.CacheResult r11 = (com.unity3d.ads.core.data.model.CacheResult) r11
                    boolean r1 = r11 instanceof com.unity3d.ads.core.data.model.CacheResult.Success
                    if (r1 == 0) goto L57
                    kotlinx.coroutines.flow.MutableStateFlow<com.unity3d.ads.core.data.model.CacheResult> r1 = r10.$fileResult
                L47:
                    java.lang.Object r0 = r1.getValue()
                    r2 = r0
                    com.unity3d.ads.core.data.model.CacheResult r2 = (com.unity3d.ads.core.data.model.CacheResult) r2
                    boolean r0 = r1.compareAndSet(r0, r11)
                    if (r0 == 0) goto L47
                    kotlin.Unit r11 = kotlin.Unit.INSTANCE
                    return r11
                L57:
                    com.unity3d.ads.core.data.repository.AndroidCacheRepository r11 = r10.this$0
                    com.unity3d.ads.core.data.datasource.CacheDataSource r3 = com.unity3d.ads.core.data.repository.AndroidCacheRepository.access$getRemoteCacheDataSource$p(r11)
                    java.io.File r4 = r10.$cacheDirectory
                    java.lang.String r5 = r10.$filename
                    java.lang.String r6 = r10.$url
                    int r11 = r10.$priority
                    java.lang.Integer r7 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r11)
                    r8 = r10
                    kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
                    r10.label = r2
                    java.lang.Object r11 = r3.getFile(r4, r5, r6, r7, r8)
                    if (r11 != r0) goto L75
                    return r0
                L75:
                    com.unity3d.ads.core.data.model.CacheResult r11 = (com.unity3d.ads.core.data.model.CacheResult) r11
                    kotlinx.coroutines.flow.MutableStateFlow<com.unity3d.ads.core.data.model.CacheResult> r0 = r10.$fileResult
                L79:
                    java.lang.Object r1 = r0.getValue()
                    r2 = r1
                    com.unity3d.ads.core.data.model.CacheResult r2 = (com.unity3d.ads.core.data.model.CacheResult) r2
                    boolean r1 = r0.compareAndSet(r1, r11)
                    if (r1 == 0) goto L79
                    kotlin.Unit r11 = kotlin.Unit.INSTANCE
                    return r11
                */
                throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.data.repository.AndroidCacheRepository.C31092.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getFileInternal(File file, String str, JSONArray jSONArray, int i, Continuation<? super CacheResult> continuation) {
        return BuildersKt.withContext(this.scope.getCoroutineContext(), new C31092(str, file, i, null), continuation);
    }

    @Override // com.unity3d.ads.core.data.repository.CacheRepository
    public Object retrieveFile(String str, Continuation<? super CacheResult> continuation) {
        return CacheDataSource.DefaultImpls.getFile$default(this.localCacheDataSource, this.cacheDir, str, null, null, continuation, 12, null);
    }

    @Override // com.unity3d.ads.core.data.repository.CacheRepository
    public boolean removeFile(CachedFile cachedFile) {
        Intrinsics.checkNotNullParameter(cachedFile, "cachedFile");
        File file = cachedFile.getFile();
        if (file != null) {
            if (!file.exists()) {
                file = null;
            }
            if (file != null) {
                return file.delete();
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // com.unity3d.ads.core.data.repository.CacheRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object doesFileExist(java.lang.String r5, kotlin.coroutines.Continuation<? super java.lang.Boolean> r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.unity3d.ads.core.data.repository.AndroidCacheRepository.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r6
            com.unity3d.ads.core.data.repository.AndroidCacheRepository$doesFileExist$1 r0 = (com.unity3d.ads.core.data.repository.AndroidCacheRepository.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            com.unity3d.ads.core.data.repository.AndroidCacheRepository$doesFileExist$1 r0 = new com.unity3d.ads.core.data.repository.AndroidCacheRepository$doesFileExist$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L3e
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L32:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.label = r3
            java.lang.Object r6 = r4.retrieveFile(r5, r0)
            if (r6 != r1) goto L3e
            return r1
        L3e:
            boolean r5 = r6 instanceof com.unity3d.ads.core.data.model.CacheResult.Success
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.data.repository.AndroidCacheRepository.doesFileExist(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final String getFilename(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return StringExtensionsKt.getSHA256Hash(url) + '.' + StringsKt.substringAfterLast$default(url, '.', (String) null, 2, (Object) null);
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.data.repository.AndroidCacheRepository$clearCache$2, reason: invalid class name */
    /* JADX INFO: compiled from: AndroidCacheRepository.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.unity3d.ads.core.data.repository.AndroidCacheRepository$clearCache$2", f = "AndroidCacheRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AndroidCacheRepository.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                int i = 0;
                if (!AndroidCacheRepository.this.sessionRepository.getNativeConfiguration().hasCachedAssetsConfiguration()) {
                    File[] fileArrListFiles = AndroidCacheRepository.this.cacheDir.listFiles();
                    if (fileArrListFiles == null) {
                        return null;
                    }
                    int length = fileArrListFiles.length;
                    while (i < length) {
                        fileArrListFiles[i].delete();
                        i++;
                    }
                    return Unit.INSTANCE;
                }
                NativeConfigurationOuterClass.CachedAssetsConfiguration cachedAssetsConfiguration = AndroidCacheRepository.this.sessionRepository.getNativeConfiguration().getCachedAssetsConfiguration();
                AndroidCacheRepository.this.cleanupDirectory.invoke(AndroidCacheRepository.this.cacheDir, cachedAssetsConfiguration.getMaxCachedAssetSizeMb(), cachedAssetsConfiguration.getMaxCachedAssetAgeMs());
                if (!AndroidCacheRepository.this.sessionRepository.getNativeConfiguration().hasCachedWebviewFilesConfiguration()) {
                    File[] fileArrListFiles2 = AndroidCacheRepository.this.webviewCacheDir.listFiles();
                    if (fileArrListFiles2 == null) {
                        return null;
                    }
                    int length2 = fileArrListFiles2.length;
                    while (i < length2) {
                        fileArrListFiles2[i].delete();
                        i++;
                    }
                    return Unit.INSTANCE;
                }
                NativeConfigurationOuterClass.CachedAssetsConfiguration cachedWebviewFilesConfiguration = AndroidCacheRepository.this.sessionRepository.getNativeConfiguration().getCachedWebviewFilesConfiguration();
                AndroidCacheRepository.this.cleanupDirectory.invoke(AndroidCacheRepository.this.webviewCacheDir, cachedWebviewFilesConfiguration.getMaxCachedAssetSizeMb(), cachedWebviewFilesConfiguration.getMaxCachedAssetAgeMs());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.unity3d.ads.core.data.repository.CacheRepository
    public Object clearCache(Continuation<? super Unit> continuation) {
        return BuildersKt.withContext(this.scope.getCoroutineContext(), new AnonymousClass2(null), continuation);
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.data.repository.AndroidCacheRepository$getCacheSize$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AndroidCacheRepository.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.unity3d.ads.core.data.repository.AndroidCacheRepository$getCacheSize$2", f = "AndroidCacheRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C31082 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Long>, Object> {
        int label;

        C31082(Continuation<? super C31082> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AndroidCacheRepository.this.new C31082(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Long> continuation) {
            return ((C31082) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.unity3d.ads.core.data.repository.AndroidCacheRepository$getCacheSize$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: AndroidCacheRepository.kt */
        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<File, Boolean> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            AnonymousClass1() {
                super(1, File.class, "isFile", "isFile()Z", 0);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(File p0) {
                Intrinsics.checkNotNullParameter(p0, "p0");
                return Boolean.valueOf(p0.isFile());
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                Iterator it = SequencesKt.filter(FilesKt.walk$default(AndroidCacheRepository.this.cacheDir, null, 1, null), AnonymousClass1.INSTANCE).iterator();
                long length = 0;
                while (it.hasNext()) {
                    length += ((File) it.next()).length();
                }
                return Boxing.boxLong(length);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.unity3d.ads.core.data.repository.CacheRepository
    public Object getCacheSize(Continuation<? super Long> continuation) {
        return BuildersKt.withContext(this.scope.getCoroutineContext(), new C31082(null), continuation);
    }

    private final File initCacheDir(String dirName) {
        GetCacheDirectory getCacheDirectory = this.getCacheDirectory;
        File cacheDir = this.context.getCacheDir();
        Intrinsics.checkNotNullExpressionValue(cacheDir, "context.cacheDir");
        File fileInvoke = getCacheDirectory.invoke(cacheDir, dirName);
        fileInvoke.mkdirs();
        return fileInvoke;
    }
}
