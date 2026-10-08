package com.hive.core.cache;

import android.os.Handler;
import android.os.Looper;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.LruCache;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.core.Configuration;
import com.hive.core.HiveCoreInitializer;
import com.hive.core.Logger;
import com.hive.core.cache.HiveResourceLoader;
import java.io.File;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.io.files.FileSystemKt;

/* JADX INFO: compiled from: HiveResourceLoader.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0018\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002IJB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020\u000eJ\"\u0010(\u001a\u00020)2\u0006\u0010'\u001a\u00020\u000e2\b\u0010*\u001a\u0004\u0018\u00010+2\b\b\u0002\u0010,\u001a\u00020-J\"\u0010.\u001a\u00020)2\u0006\u0010'\u001a\u00020\u000e2\b\u0010*\u001a\u0004\u0018\u00010+2\b\b\u0002\u0010,\u001a\u00020-J\u0010\u0010/\u001a\u00020)2\b\b\u0002\u00100\u001a\u00020\tJ.\u00101\u001a\u00020)2\b\b\u0002\u00102\u001a\u0002032\u0006\u0010'\u001a\u00020\u000e2\b\u0010*\u001a\u0004\u0018\u00010+2\b\b\u0002\u0010,\u001a\u00020-H\u0002J\u0015\u00101\u001a\u00020)2\u0006\u00104\u001a\u00020\u001aH\u0000¢\u0006\u0002\b5J\u000f\u00106\u001a\u0004\u0018\u00010\u001aH\u0000¢\u0006\u0002\b7J\u000f\u00108\u001a\u0004\u0018\u00010\u001aH\u0000¢\u0006\u0002\b9J\u0017\u0010:\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020\u000eH\u0000¢\u0006\u0002\b;J\u0012\u0010<\u001a\u0004\u0018\u00010&2\u0006\u0010=\u001a\u00020\u000eH\u0002J\u001a\u0010>\u001a\u0004\u0018\u00010&2\u0006\u0010=\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\u000eH\u0002J\u001f\u0010?\u001a\u00020)2\u0006\u0010'\u001a\u00020\u000e2\b\u0010@\u001a\u0004\u0018\u00010&H\u0000¢\u0006\u0002\bAJ\u0018\u0010B\u001a\u00020)2\u0006\u0010=\u001a\u00020\u000e2\u0006\u0010@\u001a\u00020&H\u0002J \u0010C\u001a\u00020)2\u0006\u0010'\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020\u000e2\u0006\u0010@\u001a\u00020&H\u0002J\b\u0010D\u001a\u00020)H\u0002J\u0012\u0010E\u001a\u0004\u0018\u00010\u000e2\u0006\u0010F\u001a\u00020\u000eH\u0002J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010G\u001a\u00020\u0010H\u0002J\b\u0010H\u001a\u00020)H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00050\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017R!\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\"\u001a\u00020!2\u0006\u0010 \u001a\u00020!8@@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u0006K"}, d2 = {"Lcom/hive/core/cache/HiveResourceLoader;", "", "<init>", "()V", "AVAILABLE_THREAD_COUNT", "", "dispatcher", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "MEMORY_CACHE_MAX_SIZE", "", "memoryCache", "Lcom/hive/core/cache/HiveResourceLoader$HiveLruCache;", "DISK_CACHE_MAX_SIZE", "DISK_CACHE_PATH", "", "diskCacheDir", "Ljava/io/File;", "diskCacheAccessCount", "Ljava/util/concurrent/ConcurrentHashMap;", "diskCacheSize", "workers", "", "Lcom/hive/core/cache/HiveResourceWorker;", "[Lcom/hive/core/cache/HiveResourceWorker;", "taskQueue", "Ljava/util/Queue;", "Lcom/hive/core/cache/HiveResourceRequestData;", "getTaskQueue", "()Ljava/util/Queue;", "taskQueue$delegate", "Lkotlin/Lazy;", "delayCount", "value", "", "isDelayed", "isDelayed$hive_core_release", "()Z", "loadResourceImmediately", "", "url", "loadResourceFirst", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/core/cache/HiveResourceLoadingListener;", "handler", "Landroid/os/Handler;", "loadResource", "delayed", "delayMillis", "offerTaskQueue", "offer", "Lcom/hive/core/cache/HiveResourceLoader$Offer;", "requestData", "offerTaskQueue$hive_core_release", "peekTaskQueue", "peekTaskQueue$hive_core_release", "pollTaskQueue", "pollTaskQueue$hive_core_release", "readCache", "readCache$hive_core_release", "readMemoryCache", "hashUrl", "readDiskCache", "writeCache", "data", "writeCache$hive_core_release", "writeMemoryCache", "writeDiskCache", "doWork", "makeToSHA256", "str", "fileDir", "diskCacheRecycle", "Offer", "HiveLruCache", "hive-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HiveResourceLoader {
    private static final int AVAILABLE_THREAD_COUNT;
    private static final long DISK_CACHE_MAX_SIZE = 134217728;
    private static final String DISK_CACHE_PATH;
    public static final HiveResourceLoader INSTANCE = new HiveResourceLoader();
    private static final long MEMORY_CACHE_MAX_SIZE;
    private static int delayCount;
    private static final ConcurrentHashMap<String, Integer> diskCacheAccessCount;
    private static final File diskCacheDir;
    private static long diskCacheSize;
    private static final ExecutorCoroutineDispatcher dispatcher;
    private static boolean isDelayed;
    private static final HiveLruCache memoryCache;

    /* JADX INFO: renamed from: taskQueue$delegate, reason: from kotlin metadata */
    private static final Lazy taskQueue;
    private static final HiveResourceWorker[] workers;

    private HiveResourceLoader() {
    }

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        AVAILABLE_THREAD_COUNT = iAvailableProcessors;
        ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(iAvailableProcessors);
        Intrinsics.checkNotNullExpressionValue(executorServiceNewFixedThreadPool, "newFixedThreadPool(...)");
        dispatcher = ExecutorsKt.from(executorServiceNewFixedThreadPool);
        long jMaxMemory = Runtime.getRuntime().maxMemory() / ((long) 8);
        MEMORY_CACHE_MAX_SIZE = jMaxMemory;
        memoryCache = new HiveLruCache((int) jMaxMemory);
        StringBuilder sb = new StringBuilder();
        sb.append(HiveCoreInitializer.INSTANCE.isInitContextInitialized() ? HiveCoreInitializer.INSTANCE.getInitContext().getCacheDir().getPath() : "");
        sb.append("/hiveresourceloader");
        String string = sb.toString();
        DISK_CACHE_PATH = string;
        diskCacheDir = new File(string);
        diskCacheAccessCount = new ConcurrentHashMap<>();
        HiveResourceWorker[] hiveResourceWorkerArr = new HiveResourceWorker[iAvailableProcessors];
        for (int i = 0; i < iAvailableProcessors; i++) {
            hiveResourceWorkerArr[i] = new HiveResourceWorker(INSTANCE, dispatcher);
        }
        workers = hiveResourceWorkerArr;
        taskQueue = LazyKt.lazy(new Function0() { // from class: com.hive.core.cache.HiveResourceLoader$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HiveResourceLoader.taskQueue_delegate$lambda$0();
            }
        });
        Logger.INSTANCE.d(StringsKt.trimIndent("\n            \n            [HiveResourceLoader] Created.\n            Available Thread Count: " + AVAILABLE_THREAD_COUNT + "\n            / Memory Cache Available: " + (MEMORY_CACHE_MAX_SIZE / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) + " MB\n            \n        "));
        try {
            File file = diskCacheDir;
            if (file.exists()) {
                diskCacheSize = INSTANCE.diskCacheSize(file);
            } else {
                file.mkdirs();
            }
            Logger.INSTANCE.d("[HiveResourceLoader] Make disk cache dir success: " + DISK_CACHE_PATH);
        } catch (Exception e) {
            Logger.INSTANCE.e("[HiveResourceLoader] Make disk cache dir failed: " + e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Queue<HiveResourceRequestData> getTaskQueue() {
        return (Queue) taskQueue.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConcurrentLinkedDeque taskQueue_delegate$lambda$0() {
        return new ConcurrentLinkedDeque();
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: HiveResourceLoader.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/hive/core/cache/HiveResourceLoader$Offer;", "", "<init>", "(Ljava/lang/String;I)V", "First", "OfferWork", "OfferOnly", "hive-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class Offer {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Offer[] $VALUES;
        public static final Offer First = new Offer("First", 0);
        public static final Offer OfferWork = new Offer("OfferWork", 1);
        public static final Offer OfferOnly = new Offer("OfferOnly", 2);

        private static final /* synthetic */ Offer[] $values() {
            return new Offer[]{First, OfferWork, OfferOnly};
        }

        public static EnumEntries<Offer> getEntries() {
            return $ENTRIES;
        }

        static {
            Offer[] offerArr$values = $values();
            $VALUES = offerArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(offerArr$values);
        }

        private Offer(String str, int i) {
        }

        public static Offer valueOf(String str) {
            return (Offer) Enum.valueOf(Offer.class, str);
        }

        public static Offer[] values() {
            return (Offer[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: HiveResourceLoader.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0003H\u0014¨\u0006\u000b"}, d2 = {"Lcom/hive/core/cache/HiveResourceLoader$HiveLruCache;", "Landroid/util/LruCache;", "", "", "maxSize", "", "<init>", "(I)V", "sizeOf", "key", "value", "hive-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class HiveLruCache extends LruCache<String, byte[]> {
        public HiveLruCache(int i) {
            super(i);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        public int sizeOf(String key, byte[] value) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            return value.length;
        }
    }

    public final boolean isDelayed$hive_core_release() {
        return delayCount > 0;
    }

    public final byte[] loadResourceImmediately(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        byte[] cache$hive_core_release = readCache$hive_core_release(url);
        if (cache$hive_core_release == null) {
            offerTaskQueue$default(INSTANCE, Offer.OfferOnly, url, null, null, 8, null);
        }
        return cache$hive_core_release;
    }

    public static /* synthetic */ void loadResourceFirst$default(HiveResourceLoader hiveResourceLoader, String str, HiveResourceLoadingListener hiveResourceLoadingListener, Handler handler, int i, Object obj) {
        if ((i & 4) != 0) {
            handler = new Handler(Looper.getMainLooper());
        }
        hiveResourceLoader.loadResourceFirst(str, hiveResourceLoadingListener, handler);
    }

    public final void loadResourceFirst(String url, HiveResourceLoadingListener listener, Handler handler) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(handler, "handler");
        offerTaskQueue(Offer.First, url, listener, handler);
    }

    public static /* synthetic */ void loadResource$default(HiveResourceLoader hiveResourceLoader, String str, HiveResourceLoadingListener hiveResourceLoadingListener, Handler handler, int i, Object obj) {
        if ((i & 4) != 0) {
            handler = new Handler(Looper.getMainLooper());
        }
        hiveResourceLoader.loadResource(str, hiveResourceLoadingListener, handler);
    }

    public final void loadResource(String url, HiveResourceLoadingListener listener, Handler handler) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(handler, "handler");
        offerTaskQueue(Offer.OfferWork, url, listener, handler);
    }

    public static /* synthetic */ void delayed$default(HiveResourceLoader hiveResourceLoader, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = ((long) Configuration.INSTANCE.getConnectTimeoutSeconds()) * 1000;
        }
        hiveResourceLoader.delayed(j);
    }

    /* JADX INFO: renamed from: com.hive.core.cache.HiveResourceLoader$delayed$1, reason: invalid class name */
    /* JADX INFO: compiled from: HiveResourceLoader.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.core.cache.HiveResourceLoader$delayed$1", f = "HiveResourceLoader.kt", i = {}, l = {137}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $delayMillis;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(long j, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$delayMillis = j;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$delayMillis, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (DelayKt.delay(this.$delayMillis, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Logger logger = Logger.INSTANCE;
            StringBuilder sb = new StringBuilder("[HiveResourceLoader] delay end. / Count: ");
            HiveResourceLoader hiveResourceLoader = HiveResourceLoader.INSTANCE;
            HiveResourceLoader.delayCount--;
            sb.append(HiveResourceLoader.delayCount);
            logger.d(sb.toString());
            if (HiveResourceLoader.delayCount <= 0) {
                HiveResourceLoader.INSTANCE.doWork();
            }
            return Unit.INSTANCE;
        }
    }

    public final void delayed(long delayMillis) {
        Logger logger = Logger.INSTANCE;
        StringBuilder sb = new StringBuilder("[HiveResourceLoader] delayed. (");
        sb.append(delayMillis);
        sb.append(" millis) / Count: ");
        int i = delayCount + 1;
        delayCount = i;
        sb.append(i);
        logger.d(sb.toString());
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(dispatcher), null, null, new AnonymousClass1(delayMillis, null), 3, null);
    }

    /* JADX INFO: renamed from: com.hive.core.cache.HiveResourceLoader$offerTaskQueue$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HiveResourceLoader.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.core.cache.HiveResourceLoader$offerTaskQueue$1", f = "HiveResourceLoader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C29021 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Handler $handler;
        final /* synthetic */ HiveResourceLoadingListener $listener;
        final /* synthetic */ Offer $offer;
        final /* synthetic */ String $url;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C29021(String str, Handler handler, Offer offer, HiveResourceLoadingListener hiveResourceLoadingListener, Continuation<? super C29021> continuation) {
            super(2, continuation);
            this.$url = str;
            this.$handler = handler;
            this.$offer = offer;
            this.$listener = hiveResourceLoadingListener;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C29021(this.$url, this.$handler, this.$offer, this.$listener, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C29021) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (StringsKt.isBlank(this.$url)) {
                Handler handler = this.$handler;
                final HiveResourceLoadingListener hiveResourceLoadingListener = this.$listener;
                final String str = this.$url;
                Boxing.boxBoolean(handler.post(new Runnable() { // from class: com.hive.core.cache.HiveResourceLoader$offerTaskQueue$1$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        HiveResourceLoader.C29021.invokeSuspend$lambda$1(hiveResourceLoadingListener, str);
                    }
                }));
            } else if (this.$offer == Offer.First) {
                if (HiveResourceLoader.INSTANCE.getTaskQueue() instanceof ConcurrentLinkedDeque) {
                    Logger.INSTANCE.d("[HiveResourceLoader] loadImage first: " + this.$url);
                    Queue taskQueue = HiveResourceLoader.INSTANCE.getTaskQueue();
                    Intrinsics.checkNotNull(taskQueue, "null cannot be cast to non-null type java.util.concurrent.ConcurrentLinkedDeque<com.hive.core.cache.HiveResourceRequestData>");
                    ((ConcurrentLinkedDeque) taskQueue).offerFirst(new HiveResourceRequestData(this.$handler, this.$url, this.$listener));
                } else {
                    Logger.INSTANCE.d("[HiveResourceLoader] loadImage: " + this.$url);
                    HiveResourceLoader.INSTANCE.getTaskQueue().offer(new HiveResourceRequestData(this.$handler, this.$url, this.$listener));
                }
                HiveResourceLoader.INSTANCE.doWork();
            } else if (this.$offer == Offer.OfferWork) {
                Logger.INSTANCE.d("[HiveResourceLoader] loadImage: " + this.$url);
                HiveResourceLoader.INSTANCE.offerTaskQueue$hive_core_release(new HiveResourceRequestData(this.$handler, this.$url, this.$listener));
                HiveResourceLoader.INSTANCE.doWork();
            } else {
                Logger.INSTANCE.d("[HiveResourceLoader] loadImage OfferOnly: " + this.$url);
                HiveResourceLoader.INSTANCE.offerTaskQueue$hive_core_release(new HiveResourceRequestData(this.$handler, this.$url, this.$listener));
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$1(HiveResourceLoadingListener hiveResourceLoadingListener, String str) {
            if (hiveResourceLoadingListener != null) {
                hiveResourceLoadingListener.onLoadingFailed(str, "loadImage url is empty");
                Unit unit = Unit.INSTANCE;
            }
            Logger.INSTANCE.w("[HiveResourceLoader] loadImage url is empty");
        }
    }

    static /* synthetic */ void offerTaskQueue$default(HiveResourceLoader hiveResourceLoader, Offer offer, String str, HiveResourceLoadingListener hiveResourceLoadingListener, Handler handler, int i, Object obj) {
        if ((i & 1) != 0) {
            offer = Offer.OfferWork;
        }
        if ((i & 8) != 0) {
            handler = new Handler(Looper.getMainLooper());
        }
        hiveResourceLoader.offerTaskQueue(offer, str, hiveResourceLoadingListener, handler);
    }

    private final void offerTaskQueue(Offer offer, String url, HiveResourceLoadingListener listener, Handler handler) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(dispatcher), null, null, new C29021(url, handler, offer, listener, null), 3, null);
    }

    public final void offerTaskQueue$hive_core_release(HiveResourceRequestData requestData) {
        Intrinsics.checkNotNullParameter(requestData, "requestData");
        getTaskQueue().offer(requestData);
    }

    public final HiveResourceRequestData peekTaskQueue$hive_core_release() {
        return getTaskQueue().peek();
    }

    public final HiveResourceRequestData pollTaskQueue$hive_core_release() {
        return getTaskQueue().poll();
    }

    public final byte[] readCache$hive_core_release(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (StringsKt.isBlank(url)) {
            return null;
        }
        String strMakeToSHA256 = makeToSHA256(url);
        String str = strMakeToSHA256;
        if (str != null && !StringsKt.isBlank(str)) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(dispatcher), null, null, new HiveResourceLoader$readCache$1(strMakeToSHA256, null), 3, null);
            byte[] memoryCache2 = readMemoryCache(strMakeToSHA256);
            return memoryCache2 != null ? memoryCache2 : readDiskCache(strMakeToSHA256, url);
        }
        Logger.INSTANCE.w("[HiveResourceLoader] readDiskCache invalid hash string: " + strMakeToSHA256);
        return null;
    }

    private final byte[] readMemoryCache(String hashUrl) {
        HiveLruCache hiveLruCache = memoryCache;
        if (hiveLruCache.get(hashUrl) != null) {
            return hiveLruCache.get(hashUrl);
        }
        return null;
    }

    private final byte[] readDiskCache(String hashUrl, String url) {
        File file = new File(DISK_CACHE_PATH + FileSystemKt.UnixPathSeparator + hashUrl);
        if (!file.exists()) {
            Logger.INSTANCE.d("[HiveResourceLoader] not found disk cache file (not exception) : " + url);
            return null;
        }
        try {
            byte[] bytes = FilesKt.readBytes(file);
            INSTANCE.writeMemoryCache(hashUrl, bytes);
            return bytes;
        } catch (Exception e) {
            Logger.INSTANCE.w("[HiveResourceLoader] read file failed: " + e);
            return null;
        }
    }

    public final void writeCache$hive_core_release(String url, byte[] data) {
        Intrinsics.checkNotNullParameter(url, "url");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(dispatcher), null, null, new HiveResourceLoader$writeCache$1(url, data, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void writeMemoryCache(String hashUrl, byte[] data) {
        memoryCache.put(hashUrl, data);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void writeDiskCache(String url, String hashUrl, byte[] data) {
        File parentFile;
        File file = new File(DISK_CACHE_PATH + FileSystemKt.UnixPathSeparator + hashUrl);
        try {
            File parentFile2 = file.getParentFile();
            if (parentFile2 != null && !parentFile2.exists() && (parentFile = file.getParentFile()) != null) {
                parentFile.mkdirs();
            }
            if (!file.exists()) {
                file.createNewFile();
            }
            if (diskCacheSize > DISK_CACHE_MAX_SIZE) {
                diskCacheRecycle();
            }
            try {
                FilesKt.writeBytes(file, data);
                diskCacheSize += (long) data.length;
                Logger.INSTANCE.d("[HiveResourceLoader] write file cached: " + url);
            } catch (Exception e) {
                Logger.INSTANCE.w("[HiveResourceLoader] write file failed: " + e);
            }
        } catch (Exception e2) {
            Logger.INSTANCE.w("[HiveResourceLoader] create file failed: " + e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doWork() {
        for (HiveResourceWorker hiveResourceWorker : workers) {
            hiveResourceWorker.work();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String makeToSHA256(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] bytes = str.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            messageDigest.update(bytes);
            byte[] bArrDigest = messageDigest.digest();
            String str2 = new String();
            for (byte b : bArrDigest) {
                StringBuilder sb = new StringBuilder();
                sb.append(str2);
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String str3 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                sb.append(str3);
                str2 = sb.toString();
            }
            return str2;
        } catch (Exception e) {
            Logger.INSTANCE.w("[HiveResourceLoader] makeToSHA256()\ne: " + e.getMessage());
            return null;
        }
    }

    private final long diskCacheSize(File fileDir) {
        long length;
        long j = 0;
        if (fileDir.isDirectory()) {
            try {
                File[] fileArrListFiles = fileDir.listFiles();
                if (fileArrListFiles != null) {
                    Iterator it = ArrayIteratorKt.iterator(fileArrListFiles);
                    while (it.hasNext()) {
                        File file = (File) it.next();
                        if (file.isDirectory()) {
                            Intrinsics.checkNotNull(file);
                            length = diskCacheSize(file);
                        } else {
                            ConcurrentHashMap<String, Integer> concurrentHashMap = diskCacheAccessCount;
                            if (!concurrentHashMap.containsKey(file.getName())) {
                                concurrentHashMap.put(file.getName(), 0);
                            }
                            length = file.length();
                        }
                        j += length;
                    }
                }
            } catch (Exception e) {
                Logger.INSTANCE.e("[HiveResourceLoader] Disk cache size error: " + e);
            }
        }
        Logger.INSTANCE.d("[HiveResourceLoader] Disk cache size: " + j + " (" + (j / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) + " MB)");
        return j;
    }

    private final void diskCacheRecycle() {
        Logger.INSTANCE.d("[HiveResourceLoader] Disk cache size overflow. Now delete cache files.");
        Iterator it = MapsKt.toMap(CollectionsKt.sortedWith(MapsKt.toList(diskCacheAccessCount), new Comparator() { // from class: com.hive.core.cache.HiveResourceLoader$diskCacheRecycle$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Integer.valueOf(((Number) ((Pair) t).component2()).intValue()), Integer.valueOf(((Number) ((Pair) t2).component2()).intValue()));
            }
        })).entrySet().iterator();
        while (it.hasNext()) {
            String str = (String) ((Map.Entry) it.next()).getKey();
            try {
                File file = new File(DISK_CACHE_PATH + FileSystemKt.UnixPathSeparator + str);
                if (file.exists()) {
                    long length = file.length();
                    file.delete();
                    diskCacheAccessCount.put(str, 0);
                    diskCacheSize -= length;
                    Logger.INSTANCE.d("[HiveResourceLoader] Disk cache recycling. : " + length);
                }
            } catch (Exception e) {
                Logger.INSTANCE.w("[HiveResourceLoader] DiskCacheRecycle failed: " + e);
            }
            if (diskCacheSize < 8.05306368E7d) {
                break;
            }
        }
        Logger.INSTANCE.d("[HiveResourceLoader] Disk cache recycled. cache size: " + diskCacheSize + " Byte");
        diskCacheSize = INSTANCE.diskCacheSize(diskCacheDir);
    }
}
