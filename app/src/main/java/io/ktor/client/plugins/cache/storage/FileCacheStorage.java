package io.ktor.client.plugins.cache.storage;

import androidx.compose.runtime.ComposerKt;
import com.adxcorp.ads.mediation.common.Constants;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import io.ktor.client.plugins.cache.HttpCacheKt;
import io.ktor.http.Url;
import io.ktor.util.CryptoKt;
import io.ktor.util.collections.ConcurrentMap;
import io.ktor.util.logging.LoggerJvmKt;
import io.ktor.utils.io.ByteChannel;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.jvm.javaio.WritingKt;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.util.List;
import java.util.Set;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.slf4j.Logger;

/* JADX INFO: compiled from: FileCacheStorage.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0096@¢\u0006\u0004\b\r\u0010\u000eJ\u001e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\u000f2\u0006\u0010\t\u001a\u00020\bH\u0096@¢\u0006\u0004\b\u0010\u0010\u0011J.\u0010\u0015\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u0012H\u0096@¢\u0006\u0004\b\u0015\u0010\u0016J,\u0010\u0017\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u0012H\u0096@¢\u0006\u0004\b\u0017\u0010\u0016J\u0018\u0010\u0018\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\bH\u0096@¢\u0006\u0004\b\u0018\u0010\u0011J\u0017\u0010\u0019\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u001e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\n0\u000f2\u0006\u0010\u001b\u001a\u00020\u0013H\u0082@¢\u0006\u0004\b\u001c\u0010\u001dJ8\u0010!\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u00132\u001e\u0010 \u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u001f0\u001eH\u0082H¢\u0006\u0004\b!\u0010\"J\u0018\u0010#\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u0013H\u0082@¢\u0006\u0004\b#\u0010\u001dJ&\u0010&\u001a\u00020%2\u0006\u0010\u001b\u001a\u00020\u00132\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\n0\u001fH\u0082@¢\u0006\u0004\b&\u0010'J\u001e\u0010(\u001a\b\u0012\u0004\u0012\u00020\n0\u000f2\u0006\u0010\u001b\u001a\u00020\u0013H\u0082@¢\u0006\u0004\b(\u0010\u001dJ \u0010,\u001a\u00020\f2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\nH\u0082@¢\u0006\u0004\b,\u0010-J\u0018\u0010\u001c\u001a\u00020\n2\u0006\u0010*\u001a\u00020.H\u0082@¢\u0006\u0004\b\u001c\u0010/R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u00100R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u00101R \u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u000203028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105¨\u00066"}, d2 = {"Lio/ktor/client/plugins/cache/storage/FileCacheStorage;", "Lio/ktor/client/plugins/cache/storage/CacheStorage;", "Ljava/io/File;", "directory", "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "<init>", "(Ljava/io/File;Lkotlinx/coroutines/CoroutineDispatcher;)V", "Lio/ktor/http/Url;", "url", "Lio/ktor/client/plugins/cache/storage/CachedResponseData;", "data", "", "store", "(Lio/ktor/http/Url;Lio/ktor/client/plugins/cache/storage/CachedResponseData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "findAll", "(Lio/ktor/http/Url;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "", "varyKeys", "find", "(Lio/ktor/http/Url;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", ProductAction.ACTION_REMOVE, "removeAll", "key", "(Lio/ktor/http/Url;)Ljava/lang/String;", "urlHex", "readCache", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function1;", "", "transform", "updateCache", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteCache", "caches", "", "writeCacheUnsafe", "(Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readCacheUnsafe", "Lio/ktor/utils/io/ByteChannel;", "channel", "cache", "writeCache", "(Lio/ktor/utils/io/ByteChannel;Lio/ktor/client/plugins/cache/storage/CachedResponseData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/utils/io/ByteReadChannel;", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/io/File;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lio/ktor/util/collections/ConcurrentMap;", "Lkotlinx/coroutines/sync/Mutex;", "mutexes", "Lio/ktor/util/collections/ConcurrentMap;", "ktor-client-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class FileCacheStorage implements CacheStorage {
    private final File directory;
    private final CoroutineDispatcher dispatcher;
    private final ConcurrentMap<String, Mutex> mutexes;

    /* JADX INFO: renamed from: io.ktor.client.plugins.cache.storage.FileCacheStorage$deleteCache$1, reason: invalid class name */
    /* JADX INFO: compiled from: FileCacheStorage.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cache.storage.FileCacheStorage", f = "FileCacheStorage.kt", i = {0, 0}, l = {252}, m = "deleteCache", n = {"urlHex", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileCacheStorage.this.deleteCache(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.cache.storage.FileCacheStorage$find$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FileCacheStorage.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cache.storage.FileCacheStorage", f = "FileCacheStorage.kt", i = {0}, l = {96}, m = "find", n = {"varyKeys"}, s = {"L$0"})
    static final class C32471 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C32471(Continuation<? super C32471> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileCacheStorage.this.find(null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.cache.storage.FileCacheStorage$findAll$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FileCacheStorage.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cache.storage.FileCacheStorage", f = "FileCacheStorage.kt", i = {}, l = {92}, m = "findAll", n = {}, s = {})
    static final class C32481 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C32481(Continuation<? super C32481> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileCacheStorage.this.findAll(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.cache.storage.FileCacheStorage$readCache$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FileCacheStorage.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cache.storage.FileCacheStorage", f = "FileCacheStorage.kt", i = {0, 0, 1}, l = {252, 118}, m = "readCache", n = {"urlHex", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$0"})
    static final class C32491 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C32491(Continuation<? super C32491> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileCacheStorage.this.readCache((String) null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.cache.storage.FileCacheStorage$readCache$3, reason: invalid class name */
    /* JADX INFO: compiled from: FileCacheStorage.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cache.storage.FileCacheStorage", f = "FileCacheStorage.kt", i = {0, 1, 1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 13, 13, 14, 14, 14, 14, 14, 14, 14, 14, 14}, l = {209, 210, 210, 211, 212, 215, 216, 219, 220, 221, 222, 225, 226, 230, 232}, m = "readCache", n = {"channel", "channel", "url", "channel", "url", "channel", "url", "status", "channel", "url", "status", "version", "channel", "url", "status", "version", "headers", "headersCount", "j", "channel", "url", "status", "version", "headers", "key", "headersCount", "j", "channel", "url", "status", "version", "headers", "channel", "url", "status", "version", "headers", "requestTime", "channel", "url", "status", "version", "headers", "requestTime", "responseTime", "channel", "url", "status", "version", "headers", "requestTime", "responseTime", "expirationTime", "channel", "url", "status", "version", "headers", "requestTime", "responseTime", "expirationTime", "$this$readCache_u24lambda_u2412", "varyKeysCount", "j", "channel", "url", "status", "version", "headers", "requestTime", "responseTime", "expirationTime", "$this$readCache_u24lambda_u2412", "key", "varyKeysCount", "j", "channel", "url", "status", "version", "headers", "requestTime", "responseTime", "expirationTime", "varyKeys", "url", "status", "version", "headers", "requestTime", "responseTime", "expirationTime", "varyKeys", TtmlNode.TAG_BODY}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$9", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$9", "L$10", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8"})
    static final class AnonymousClass3 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileCacheStorage.this.readCache((ByteReadChannel) null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.cache.storage.FileCacheStorage$readCacheUnsafe$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FileCacheStorage.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cache.storage.FileCacheStorage", f = "FileCacheStorage.kt", i = {0, 1, 1, 1, 1, 2}, l = {171, 174, 176}, m = "readCacheUnsafe", n = {"channel", "channel", "caches", "requestsCount", "i", "caches"}, s = {"L$1", "L$1", "L$2", "I$0", "I$1", "L$1"})
    static final class C32501 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C32501(Continuation<? super C32501> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileCacheStorage.this.readCacheUnsafe(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.cache.storage.FileCacheStorage$remove$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FileCacheStorage.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cache.storage.FileCacheStorage", f = "FileCacheStorage.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2}, l = {254, 257, 258}, m = ProductAction.ACTION_REMOVE, n = {"varyKeys", "urlHex", "this_$iv", "$this$withLock_u24default$iv$iv", "varyKeys", "urlHex", "this_$iv", "$this$withLock_u24default$iv$iv", "$this$withLock_u24default$iv$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0"})
    static final class C32511 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C32511(Continuation<? super C32511> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileCacheStorage.this.remove(null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.cache.storage.FileCacheStorage$writeCache$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FileCacheStorage.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cache.storage.FileCacheStorage", f = "FileCacheStorage.kt", i = {0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10, 10, 11, 11, 11, 12, 12, 13, 13}, l = {186, 187, TsExtractor.TS_PACKET_SIZE, PsExtractor.PRIVATE_STREAM_1, 191, 193, 194, 196, 197, 198, 199, ComposerKt.providerKey, ComposerKt.compositionLocalMapKey, 204, Constants.NEXT_STEP}, m = "writeCache", n = {"channel", "cache", "channel", "cache", "channel", "cache", "channel", "cache", "channel", "cache", "headers", "channel", "cache", "value", "channel", "cache", "channel", "cache", "channel", "cache", "channel", "cache", "channel", "cache", "channel", "cache", "value", "channel", "cache", "channel", "cache"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$3", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$3", "L$0", "L$1", "L$0", "L$1"})
    static final class C32521 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C32521(Continuation<? super C32521> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileCacheStorage.this.writeCache(null, null, this);
        }
    }

    public FileCacheStorage(File directory, CoroutineDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(directory, "directory");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.directory = directory;
        this.dispatcher = dispatcher;
        this.mutexes = new ConcurrentMap<>(0, 1, null);
        directory.mkdirs();
    }

    public /* synthetic */ FileCacheStorage(File file, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(file, (i & 2) != 0 ? Dispatchers.getIO() : coroutineDispatcher);
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.cache.storage.FileCacheStorage$store$2, reason: invalid class name */
    /* JADX INFO: compiled from: FileCacheStorage.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cache.storage.FileCacheStorage$store$2", f = "FileCacheStorage.kt", i = {0, 0, 0, 1, 1, 1, 2}, l = {254, 257, 258}, m = "invokeSuspend", n = {"urlHex", "this_$iv", "$this$withLock_u24default$iv$iv", "urlHex", "this_$iv", "$this$withLock_u24default$iv$iv", "$this$withLock_u24default$iv$iv"}, s = {"L$0", "L$1", "L$3", "L$0", "L$1", "L$3", "L$0"})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CachedResponseData $data;
        final /* synthetic */ Url $url;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Url url, CachedResponseData cachedResponseData, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$url = url;
            this.$data = cachedResponseData;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FileCacheStorage.this.new AnonymousClass2(this.$url, this.$data, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00b2 A[Catch: all -> 0x003a, TryCatch #0 {all -> 0x003a, blocks: (B:15:0x0036, B:28:0x009d, B:29:0x00ac, B:31:0x00b2, B:33:0x00c7, B:34:0x00cb, B:24:0x0087), top: B:42:0x000a }] */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00e3 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:37:0x00e4  */
        /* JADX WARN: Type inference failed for: r0v1 */
        /* JADX WARN: Type inference failed for: r0v2, types: [kotlinx.coroutines.sync.Mutex] */
        /* JADX WARN: Type inference failed for: r0v3 */
        /* JADX WARN: Type inference failed for: r0v4, types: [kotlinx.coroutines.sync.Mutex] */
        /* JADX WARN: Type inference failed for: r0v7, types: [kotlinx.coroutines.sync.Mutex] */
        /* JADX WARN: Type inference failed for: r0v8 */
        /* JADX WARN: Type inference failed for: r1v0, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1 */
        /* JADX WARN: Type inference failed for: r1v11 */
        /* JADX WARN: Type inference failed for: r1v12 */
        /* JADX WARN: Type inference failed for: r1v6, types: [java.lang.Object] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 239
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.storage.FileCacheStorage.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    public Object store(Url url, CachedResponseData cachedResponseData, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(this.dispatcher, new AnonymousClass2(url, cachedResponseData, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object findAll(io.ktor.http.Url r5, kotlin.coroutines.Continuation<? super java.util.Set<io.ktor.client.plugins.cache.storage.CachedResponseData>> r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.client.plugins.cache.storage.FileCacheStorage.C32481
            if (r0 == 0) goto L14
            r0 = r6
            io.ktor.client.plugins.cache.storage.FileCacheStorage$findAll$1 r0 = (io.ktor.client.plugins.cache.storage.FileCacheStorage.C32481) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            io.ktor.client.plugins.cache.storage.FileCacheStorage$findAll$1 r0 = new io.ktor.client.plugins.cache.storage.FileCacheStorage$findAll$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L42
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L32:
            kotlin.ResultKt.throwOnFailure(r6)
            java.lang.String r5 = r4.key(r5)
            r0.label = r3
            java.lang.Object r6 = r4.readCache(r5, r0)
            if (r6 != r1) goto L42
            return r1
        L42:
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Set r5 = kotlin.collections.CollectionsKt.toSet(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.storage.FileCacheStorage.findAll(io.ktor.http.Url, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object find(io.ktor.http.Url r6, java.util.Map<java.lang.String, java.lang.String> r7, kotlin.coroutines.Continuation<? super io.ktor.client.plugins.cache.storage.CachedResponseData> r8) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r8 instanceof io.ktor.client.plugins.cache.storage.FileCacheStorage.C32471
            if (r0 == 0) goto L14
            r0 = r8
            io.ktor.client.plugins.cache.storage.FileCacheStorage$find$1 r0 = (io.ktor.client.plugins.cache.storage.FileCacheStorage.C32471) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            io.ktor.client.plugins.cache.storage.FileCacheStorage$find$1 r0 = new io.ktor.client.plugins.cache.storage.FileCacheStorage$find$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r6 = r0.L$0
            r7 = r6
            java.util.Map r7 = (java.util.Map) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L49
        L2f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L37:
            kotlin.ResultKt.throwOnFailure(r8)
            java.lang.String r6 = r5.key(r6)
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r8 = r5.readCache(r6, r0)
            if (r8 != r1) goto L49
            return r1
        L49:
            java.util.Set r8 = (java.util.Set) r8
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r6 = r8.iterator()
        L51:
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto L94
            java.lang.Object r8 = r6.next()
            r0 = r8
            io.ktor.client.plugins.cache.storage.CachedResponseData r0 = (io.ktor.client.plugins.cache.storage.CachedResponseData) r0
            boolean r1 = r7.isEmpty()
            if (r1 == 0) goto L65
            goto L95
        L65:
            java.util.Set r1 = r7.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L6d:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L95
            java.lang.Object r2 = r1.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getKey()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r2 = r2.getValue()
            java.lang.String r2 = (java.lang.String) r2
            java.util.Map r4 = r0.getVaryKeys()
            java.lang.Object r3 = r4.get(r3)
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r2)
            if (r2 != 0) goto L6d
            goto L51
        L94:
            r8 = 0
        L95:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.storage.FileCacheStorage.find(io.ktor.http.Url, java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ba A[Catch: all -> 0x0052, TryCatch #0 {all -> 0x0052, blocks: (B:14:0x0031, B:19:0x004e, B:32:0x00a5, B:33:0x00b4, B:35:0x00ba, B:37:0x00cb, B:38:0x00cf, B:28:0x0093), top: B:45:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00e1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object remove(io.ktor.http.Url r10, java.util.Map<java.lang.String, java.lang.String> r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 236
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.storage.FileCacheStorage.remove(io.ktor.http.Url, java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    public Object removeAll(Url url, Continuation<? super Unit> continuation) throws Throwable {
        Object objDeleteCache = deleteCache(key(url), continuation);
        return objDeleteCache == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDeleteCache : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String key(Url url) {
        byte[] bArrDigest = MessageDigest.getInstance("SHA-256").digest(StringsKt.encodeToByteArray(url.getUrlString()));
        Intrinsics.checkNotNullExpressionValue(bArrDigest, "digest(...)");
        return CryptoKt.hex(bArrDigest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object readCache(java.lang.String r8, kotlin.coroutines.Continuation<? super java.util.Set<io.ktor.client.plugins.cache.storage.CachedResponseData>> r9) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r9 instanceof io.ktor.client.plugins.cache.storage.FileCacheStorage.C32491
            if (r0 == 0) goto L14
            r0 = r9
            io.ktor.client.plugins.cache.storage.FileCacheStorage$readCache$1 r0 = (io.ktor.client.plugins.cache.storage.FileCacheStorage.C32491) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            io.ktor.client.plugins.cache.storage.FileCacheStorage$readCache$1 r0 = new io.ktor.client.plugins.cache.storage.FileCacheStorage$readCache$1
            r0.<init>(r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L4a
            if (r2 == r4) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r8 = r0.L$0
            kotlinx.coroutines.sync.Mutex r8 = (kotlinx.coroutines.sync.Mutex) r8
            kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Throwable -> L32
            goto L77
        L32:
            r9 = move-exception
            goto L81
        L34:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3c:
            java.lang.Object r8 = r0.L$1
            kotlinx.coroutines.sync.Mutex r8 = (kotlinx.coroutines.sync.Mutex) r8
            java.lang.Object r2 = r0.L$0
            java.lang.String r2 = (java.lang.String) r2
            kotlin.ResultKt.throwOnFailure(r9)
            r9 = r8
            r8 = r2
            goto L67
        L4a:
            kotlin.ResultKt.throwOnFailure(r9)
            io.ktor.util.collections.ConcurrentMap<java.lang.String, kotlinx.coroutines.sync.Mutex> r9 = r7.mutexes
            io.ktor.client.plugins.cache.storage.FileCacheStorage$$ExternalSyntheticLambda0 r2 = new io.ktor.client.plugins.cache.storage.FileCacheStorage$$ExternalSyntheticLambda0
            r2.<init>()
            java.lang.Object r9 = r9.computeIfAbsent(r8, r2)
            kotlinx.coroutines.sync.Mutex r9 = (kotlinx.coroutines.sync.Mutex) r9
            r0.L$0 = r8
            r0.L$1 = r9
            r0.label = r4
            java.lang.Object r2 = r9.lock(r5, r0)
            if (r2 != r1) goto L67
            return r1
        L67:
            r0.L$0 = r9     // Catch: java.lang.Throwable -> L7d
            r0.L$1 = r5     // Catch: java.lang.Throwable -> L7d
            r0.label = r3     // Catch: java.lang.Throwable -> L7d
            java.lang.Object r8 = r7.readCacheUnsafe(r8, r0)     // Catch: java.lang.Throwable -> L7d
            if (r8 != r1) goto L74
            return r1
        L74:
            r6 = r9
            r9 = r8
            r8 = r6
        L77:
            java.util.Set r9 = (java.util.Set) r9     // Catch: java.lang.Throwable -> L32
            r8.unlock(r5)
            return r9
        L7d:
            r8 = move-exception
            r6 = r9
            r9 = r8
            r8 = r6
        L81:
            r8.unlock(r5)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.storage.FileCacheStorage.readCache(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Mutex readCache$lambda$4() {
        return MutexKt.Mutex$default(false, 1, null);
    }

    private final Object updateCache(String str, Function1<? super Set<CachedResponseData>, ? extends List<CachedResponseData>> function1, Continuation<? super Unit> continuation) {
        Mutex mutex = (Mutex) this.mutexes.computeIfAbsent(str, FileCacheStorage$updateCache$mutex$1.INSTANCE);
        InlineMarker.mark(0);
        mutex.lock(null, continuation);
        InlineMarker.mark(1);
        try {
            InlineMarker.mark(3);
            InlineMarker.mark(0);
            Object cacheUnsafe = readCacheUnsafe(str, null);
            InlineMarker.mark(1);
            List<CachedResponseData> listInvoke = function1.invoke((Set) cacheUnsafe);
            InlineMarker.mark(3);
            InlineMarker.mark(0);
            writeCacheUnsafe(str, listInvoke, null);
            InlineMarker.mark(1);
            InlineMarker.finallyStart(1);
            mutex.unlock(null);
            InlineMarker.finallyEnd(1);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            InlineMarker.finallyStart(1);
            mutex.unlock(null);
            InlineMarker.finallyEnd(1);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object deleteCache(java.lang.String r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) throws java.lang.Throwable {
        /*
            r6 = this;
            java.lang.String r0 = "Exception during cache deletion in a file: "
            boolean r1 = r8 instanceof io.ktor.client.plugins.cache.storage.FileCacheStorage.AnonymousClass1
            if (r1 == 0) goto L16
            r1 = r8
            io.ktor.client.plugins.cache.storage.FileCacheStorage$deleteCache$1 r1 = (io.ktor.client.plugins.cache.storage.FileCacheStorage.AnonymousClass1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L16
            int r8 = r1.label
            int r8 = r8 - r3
            r1.label = r8
            goto L1b
        L16:
            io.ktor.client.plugins.cache.storage.FileCacheStorage$deleteCache$1 r1 = new io.ktor.client.plugins.cache.storage.FileCacheStorage$deleteCache$1
            r1.<init>(r8)
        L1b:
            java.lang.Object r8 = r1.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.label
            r4 = 0
            r5 = 1
            if (r3 == 0) goto L3f
            if (r3 != r5) goto L37
            java.lang.Object r7 = r1.L$1
            kotlinx.coroutines.sync.Mutex r7 = (kotlinx.coroutines.sync.Mutex) r7
            java.lang.Object r1 = r1.L$0
            java.lang.String r1 = (java.lang.String) r1
            kotlin.ResultKt.throwOnFailure(r8)
            r8 = r7
            r7 = r1
            goto L5c
        L37:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3f:
            kotlin.ResultKt.throwOnFailure(r8)
            io.ktor.util.collections.ConcurrentMap<java.lang.String, kotlinx.coroutines.sync.Mutex> r8 = r6.mutexes
            io.ktor.client.plugins.cache.storage.FileCacheStorage$$ExternalSyntheticLambda1 r3 = new io.ktor.client.plugins.cache.storage.FileCacheStorage$$ExternalSyntheticLambda1
            r3.<init>()
            java.lang.Object r8 = r8.computeIfAbsent(r7, r3)
            kotlinx.coroutines.sync.Mutex r8 = (kotlinx.coroutines.sync.Mutex) r8
            r1.L$0 = r7
            r1.L$1 = r8
            r1.label = r5
            java.lang.Object r1 = r8.lock(r4, r1)
            if (r1 != r2) goto L5c
            return r2
        L5c:
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L95
            java.io.File r2 = r6.directory     // Catch: java.lang.Throwable -> L95
            r1.<init>(r2, r7)     // Catch: java.lang.Throwable -> L95
            boolean r7 = r1.exists()     // Catch: java.lang.Throwable -> L95
            if (r7 == 0) goto L8d
            r1.delete()     // Catch: java.lang.Exception -> L6d java.lang.Throwable -> L95
            goto L8d
        L6d:
            r7 = move-exception
            org.slf4j.Logger r1 = io.ktor.client.plugins.cache.HttpCacheKt.getLOGGER()     // Catch: java.lang.Throwable -> L95
            boolean r2 = io.ktor.util.logging.LoggerJvmKt.isTraceEnabled(r1)     // Catch: java.lang.Throwable -> L95
            if (r2 == 0) goto L8d
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L95
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L95
            java.lang.Throwable r7 = (java.lang.Throwable) r7     // Catch: java.lang.Throwable -> L95
            java.lang.String r7 = kotlin.ExceptionsKt.stackTraceToString(r7)     // Catch: java.lang.Throwable -> L95
            r2.append(r7)     // Catch: java.lang.Throwable -> L95
            java.lang.String r7 = r2.toString()     // Catch: java.lang.Throwable -> L95
            r1.trace(r7)     // Catch: java.lang.Throwable -> L95
        L8d:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L95
            r8.unlock(r4)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L95:
            r7 = move-exception
            r8.unlock(r4)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.storage.FileCacheStorage.deleteCache(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Mutex deleteCache$lambda$7() {
        return MutexKt.Mutex$default(false, 1, null);
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.cache.storage.FileCacheStorage$writeCacheUnsafe$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FileCacheStorage.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cache.storage.FileCacheStorage$writeCacheUnsafe$2", f = "FileCacheStorage.kt", i = {}, l = {157}, m = "invokeSuspend", n = {}, s = {})
    static final class C32532 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Object>, Object> {
        final /* synthetic */ List<CachedResponseData> $caches;
        final /* synthetic */ String $urlHex;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C32532(String str, List<CachedResponseData> list, Continuation<? super C32532> continuation) {
            super(2, continuation);
            this.$urlHex = str;
            this.$caches = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C32532 c32532 = FileCacheStorage.this.new C32532(this.$urlHex, this.$caches, continuation);
            c32532.L$0 = obj;
            return c32532;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Object> continuation) {
            return invoke2(coroutineScope, (Continuation<Object>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<Object> continuation) {
            return ((C32532) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Closeable closeable;
            ByteChannel byteChannel;
            BufferedOutputStream bufferedOutputStream;
            Object objCopyTo$default;
            Throwable th;
            Closeable closeable2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                    ByteChannel byteChannel2 = new ByteChannel(false, 1, null);
                    OutputStream fileOutputStream = new FileOutputStream(new File(FileCacheStorage.this.directory, this.$urlHex));
                    BufferedOutputStream bufferedOutputStream2 = fileOutputStream instanceof BufferedOutputStream ? (BufferedOutputStream) fileOutputStream : new BufferedOutputStream(fileOutputStream, 8192);
                    try {
                        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new FileCacheStorage$writeCacheUnsafe$2$1$1(byteChannel2, this.$caches, FileCacheStorage.this, null), 3, null);
                        byteChannel = byteChannel2;
                        bufferedOutputStream = bufferedOutputStream2;
                        this.L$0 = bufferedOutputStream2;
                        this.label = 1;
                        closeable = bufferedOutputStream2;
                    } catch (Throwable th2) {
                        th = th2;
                        closeable = bufferedOutputStream2;
                        th = th;
                        closeable2 = closeable;
                        throw th;
                    }
                    try {
                        objCopyTo$default = WritingKt.copyTo$default(byteChannel, bufferedOutputStream, 0L, this, 2, null);
                        if (objCopyTo$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        th = th;
                        closeable2 = closeable;
                        throw th;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    closeable2 = (Closeable) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        closeable = closeable2;
                        objCopyTo$default = obj;
                    } catch (Throwable th4) {
                        th = th4;
                        try {
                            throw th;
                        } catch (Throwable th5) {
                            CloseableKt.closeFinally(closeable2, th);
                            throw th5;
                        }
                    }
                }
                Long lBoxLong = Boxing.boxLong(((Number) objCopyTo$default).longValue());
                CloseableKt.closeFinally(closeable, null);
                return lBoxLong;
            } catch (Exception e) {
                Logger logger = HttpCacheKt.getLOGGER();
                if (LoggerJvmKt.isTraceEnabled(logger)) {
                    logger.trace("Exception during saving a cache to a file: " + ExceptionsKt.stackTraceToString(e));
                }
                return Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object writeCacheUnsafe(String str, List<CachedResponseData> list, Continuation<Object> continuation) {
        return CoroutineScopeKt.coroutineScope(new C32532(str, list, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00e0 A[Catch: all -> 0x003e, TRY_ENTER, TRY_LEAVE, TryCatch #5 {all -> 0x003e, blocks: (B:14:0x0039, B:46:0x00e0, B:52:0x0101), top: B:80:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0101 A[Catch: all -> 0x003e, TRY_ENTER, TRY_LEAVE, TryCatch #5 {all -> 0x003e, blocks: (B:14:0x0039, B:46:0x00e0, B:52:0x0101), top: B:80:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Type inference failed for: r19v0, types: [io.ktor.client.plugins.cache.storage.FileCacheStorage] */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x00f5 -> B:50:0x00f9). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object readCacheUnsafe(java.lang.String r20, kotlin.coroutines.Continuation<? super java.util.Set<io.ktor.client.plugins.cache.storage.CachedResponseData>> r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 335
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.storage.FileCacheStorage.readCacheUnsafe(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:34:0x014a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0175 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0199 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01ba A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0222 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x025e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0276 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0290 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0303 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x033a A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x0223 -> B:46:0x01bf). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:79:0x0304 -> B:70:0x029d). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object writeCache(io.ktor.utils.io.ByteChannel r13, io.ktor.client.plugins.cache.storage.CachedResponseData r14, kotlin.coroutines.Continuation<? super kotlin.Unit> r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 866
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.storage.FileCacheStorage.writeCache(io.ktor.utils.io.ByteChannel, io.ktor.client.plugins.cache.storage.CachedResponseData, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:35:0x026b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x028a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x02ac A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x02ce A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0330 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0331  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0343  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x037e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x039d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x039e  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x03c6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x03dc  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0449 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x044a  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x046d  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x04cf A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x04d0  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x0331 -> B:22:0x01cb). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:82:0x044a -> B:15:0x00dd). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object readCache(io.ktor.utils.io.ByteReadChannel r31, kotlin.coroutines.Continuation<? super io.ktor.client.plugins.cache.storage.CachedResponseData> r32) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1300
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.storage.FileCacheStorage.readCache(io.ktor.utils.io.ByteReadChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
