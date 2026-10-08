package io.ktor.client.plugins.cookies;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import io.ktor.client.plugins.cookies.AcceptAllCookiesStorage;
import io.ktor.http.Cookie;
import io.ktor.http.Url;
import io.ktor.util.date.DateJvmKt;
import io.ktor.util.date.GMTDate;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: compiled from: AcceptAllCookiesStorage.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001!B\u0017\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\b\u001a\u00020\u0007H\u0096@¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\nH\u0096@¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u0003*\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0019R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Lio/ktor/client/plugins/cookies/AcceptAllCookiesStorage;", "Lio/ktor/client/plugins/cookies/CookiesStorage;", "Lkotlin/Function0;", "", "clock", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "Lio/ktor/http/Url;", "requestUrl", "", "Lio/ktor/http/Cookie;", "get", "(Lio/ktor/http/Url;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cookie", "", "addCookie", "(Lio/ktor/http/Url;Lio/ktor/http/Cookie;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "close", "()V", "timestamp", "cleanup", "(J)V", "createdAt", "maxAgeOrExpires", "(Lio/ktor/http/Cookie;J)Ljava/lang/Long;", "Lkotlin/jvm/functions/Function0;", "", "Lio/ktor/client/plugins/cookies/AcceptAllCookiesStorage$CookieWithTimestamp;", TtmlNode.RUBY_CONTAINER, "Ljava/util/List;", "Lkotlinx/coroutines/sync/Mutex;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "CookieWithTimestamp", "ktor-client-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AcceptAllCookiesStorage implements CookiesStorage {
    private final Function0<Long> clock;
    private final List<CookieWithTimestamp> container;
    private final Mutex mutex;
    private volatile /* synthetic */ long oldestCookie;

    /* JADX INFO: renamed from: io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$addCookie$1, reason: invalid class name */
    /* JADX INFO: compiled from: AcceptAllCookiesStorage.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cookies.AcceptAllCookiesStorage", f = "AcceptAllCookiesStorage.kt", i = {0, 0, 0}, l = {79}, m = "addCookie", n = {"requestUrl", "cookie", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AcceptAllCookiesStorage.this.addCookie(null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$get$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AcceptAllCookiesStorage.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cookies.AcceptAllCookiesStorage", f = "AcceptAllCookiesStorage.kt", i = {0, 0}, l = {79}, m = "get", n = {"requestUrl", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1"})
    static final class C32541 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C32541(Continuation<? super C32541> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AcceptAllCookiesStorage.this.get(null, this);
        }
    }

    public AcceptAllCookiesStorage() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public AcceptAllCookiesStorage(Function0<Long> clock) {
        Intrinsics.checkNotNullParameter(clock, "clock");
        this.clock = clock;
        this.container = new ArrayList();
        this.oldestCookie = 0L;
        this.mutex = MutexKt.Mutex$default(false, 1, null);
    }

    public /* synthetic */ AcceptAllCookiesStorage(Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Function0() { // from class: io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(DateJvmKt.getTimeMillis());
            }
        } : function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: AcceptAllCookiesStorage.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ$\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u000b¨\u0006\u001c"}, d2 = {"Lio/ktor/client/plugins/cookies/AcceptAllCookiesStorage$CookieWithTimestamp;", "", "Lio/ktor/http/Cookie;", "cookie", "", "createdAt", "<init>", "(Lio/ktor/http/Cookie;J)V", "component1", "()Lio/ktor/http/Cookie;", "component2", "()J", "copy", "(Lio/ktor/http/Cookie;J)Lio/ktor/client/plugins/cookies/AcceptAllCookiesStorage$CookieWithTimestamp;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lio/ktor/http/Cookie;", "getCookie", "J", "getCreatedAt", "ktor-client-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    static final /* data */ class CookieWithTimestamp {
        private final Cookie cookie;
        private final long createdAt;

        public static /* synthetic */ CookieWithTimestamp copy$default(CookieWithTimestamp cookieWithTimestamp, Cookie cookie, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                cookie = cookieWithTimestamp.cookie;
            }
            if ((i & 2) != 0) {
                j = cookieWithTimestamp.createdAt;
            }
            return cookieWithTimestamp.copy(cookie, j);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Cookie getCookie() {
            return this.cookie;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getCreatedAt() {
            return this.createdAt;
        }

        public final CookieWithTimestamp copy(Cookie cookie, long createdAt) {
            Intrinsics.checkNotNullParameter(cookie, "cookie");
            return new CookieWithTimestamp(cookie, createdAt);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CookieWithTimestamp)) {
                return false;
            }
            CookieWithTimestamp cookieWithTimestamp = (CookieWithTimestamp) other;
            return Intrinsics.areEqual(this.cookie, cookieWithTimestamp.cookie) && this.createdAt == cookieWithTimestamp.createdAt;
        }

        public int hashCode() {
            return (this.cookie.hashCode() * 31) + UByte$$ExternalSyntheticBackport0.m(this.createdAt);
        }

        public String toString() {
            return "CookieWithTimestamp(cookie=" + this.cookie + ", createdAt=" + this.createdAt + ')';
        }

        public CookieWithTimestamp(Cookie cookie, long j) {
            Intrinsics.checkNotNullParameter(cookie, "cookie");
            this.cookie = cookie;
            this.createdAt = j;
        }

        public final Cookie getCookie() {
            return this.cookie;
        }

        public final long getCreatedAt() {
            return this.createdAt;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // io.ktor.client.plugins.cookies.CookiesStorage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object get(io.ktor.http.Url r7, kotlin.coroutines.Continuation<? super java.util.List<io.ktor.http.Cookie>> r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof io.ktor.client.plugins.cookies.AcceptAllCookiesStorage.C32541
            if (r0 == 0) goto L14
            r0 = r8
            io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$get$1 r0 = (io.ktor.client.plugins.cookies.AcceptAllCookiesStorage.C32541) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$get$1 r0 = new io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$get$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L3d
            if (r2 != r4) goto L35
            java.lang.Object r7 = r0.L$1
            kotlinx.coroutines.sync.Mutex r7 = (kotlinx.coroutines.sync.Mutex) r7
            java.lang.Object r0 = r0.L$0
            io.ktor.http.Url r0 = (io.ktor.http.Url) r0
            kotlin.ResultKt.throwOnFailure(r8)
            r8 = r7
            r7 = r0
            goto L4f
        L35:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3d:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlinx.coroutines.sync.Mutex r8 = r6.mutex
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r4
            java.lang.Object r0 = r8.lock(r3, r0)
            if (r0 != r1) goto L4f
            return r1
        L4f:
            kotlin.jvm.functions.Function0<java.lang.Long> r0 = r6.clock     // Catch: java.lang.Throwable -> Lbd
            java.lang.Object r0 = r0.invoke()     // Catch: java.lang.Throwable -> Lbd
            java.lang.Number r0 = (java.lang.Number) r0     // Catch: java.lang.Throwable -> Lbd
            long r0 = r0.longValue()     // Catch: java.lang.Throwable -> Lbd
            long r4 = r6.oldestCookie     // Catch: java.lang.Throwable -> Lbd
            int r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r2 < 0) goto L64
            r6.cleanup(r0)     // Catch: java.lang.Throwable -> Lbd
        L64:
            java.util.List<io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$CookieWithTimestamp> r0 = r6.container     // Catch: java.lang.Throwable -> Lbd
            java.lang.Iterable r0 = (java.lang.Iterable) r0     // Catch: java.lang.Throwable -> Lbd
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch: java.lang.Throwable -> Lbd
            r1.<init>()     // Catch: java.lang.Throwable -> Lbd
            java.util.Collection r1 = (java.util.Collection) r1     // Catch: java.lang.Throwable -> Lbd
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> Lbd
        L73:
            boolean r2 = r0.hasNext()     // Catch: java.lang.Throwable -> Lbd
            if (r2 == 0) goto L8e
            java.lang.Object r2 = r0.next()     // Catch: java.lang.Throwable -> Lbd
            r4 = r2
            io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$CookieWithTimestamp r4 = (io.ktor.client.plugins.cookies.AcceptAllCookiesStorage.CookieWithTimestamp) r4     // Catch: java.lang.Throwable -> Lbd
            io.ktor.http.Cookie r4 = r4.getCookie()     // Catch: java.lang.Throwable -> Lbd
            boolean r4 = io.ktor.client.plugins.cookies.CookiesStorageKt.matches(r4, r7)     // Catch: java.lang.Throwable -> Lbd
            if (r4 == 0) goto L73
            r1.add(r2)     // Catch: java.lang.Throwable -> Lbd
            goto L73
        L8e:
            java.util.List r1 = (java.util.List) r1     // Catch: java.lang.Throwable -> Lbd
            java.lang.Iterable r1 = (java.lang.Iterable) r1     // Catch: java.lang.Throwable -> Lbd
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch: java.lang.Throwable -> Lbd
            r0 = 10
            int r0 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r1, r0)     // Catch: java.lang.Throwable -> Lbd
            r7.<init>(r0)     // Catch: java.lang.Throwable -> Lbd
            java.util.Collection r7 = (java.util.Collection) r7     // Catch: java.lang.Throwable -> Lbd
            java.util.Iterator r0 = r1.iterator()     // Catch: java.lang.Throwable -> Lbd
        La3:
            boolean r1 = r0.hasNext()     // Catch: java.lang.Throwable -> Lbd
            if (r1 == 0) goto Lb7
            java.lang.Object r1 = r0.next()     // Catch: java.lang.Throwable -> Lbd
            io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$CookieWithTimestamp r1 = (io.ktor.client.plugins.cookies.AcceptAllCookiesStorage.CookieWithTimestamp) r1     // Catch: java.lang.Throwable -> Lbd
            io.ktor.http.Cookie r1 = r1.getCookie()     // Catch: java.lang.Throwable -> Lbd
            r7.add(r1)     // Catch: java.lang.Throwable -> Lbd
            goto La3
        Lb7:
            java.util.List r7 = (java.util.List) r7     // Catch: java.lang.Throwable -> Lbd
            r8.unlock(r3)
            return r7
        Lbd:
            r7 = move-exception
            r8.unlock(r3)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cookies.AcceptAllCookiesStorage.get(io.ktor.http.Url, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // io.ktor.client.plugins.cookies.CookiesStorage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object addCookie(final io.ktor.http.Url r6, final io.ktor.http.Cookie r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r8 instanceof io.ktor.client.plugins.cookies.AcceptAllCookiesStorage.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r8
            io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$addCookie$1 r0 = (io.ktor.client.plugins.cookies.AcceptAllCookiesStorage.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$addCookie$1 r0 = new io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$addCookie$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L41
            if (r2 != r4) goto L39
            java.lang.Object r6 = r0.L$2
            kotlinx.coroutines.sync.Mutex r6 = (kotlinx.coroutines.sync.Mutex) r6
            java.lang.Object r7 = r0.L$1
            io.ktor.http.Cookie r7 = (io.ktor.http.Cookie) r7
            java.lang.Object r0 = r0.L$0
            io.ktor.http.Url r0 = (io.ktor.http.Url) r0
            kotlin.ResultKt.throwOnFailure(r8)
            r8 = r6
            r6 = r0
            goto L64
        L39:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L41:
            kotlin.ResultKt.throwOnFailure(r8)
            java.lang.String r8 = r7.getName()
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            boolean r8 = kotlin.text.StringsKt.isBlank(r8)
            if (r8 == 0) goto L53
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L53:
            kotlinx.coroutines.sync.Mutex r8 = r5.mutex
            r0.L$0 = r6
            r0.L$1 = r7
            r0.L$2 = r8
            r0.label = r4
            java.lang.Object r0 = r8.lock(r3, r0)
            if (r0 != r1) goto L64
            return r1
        L64:
            java.util.List<io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$CookieWithTimestamp> r0 = r5.container     // Catch: java.lang.Throwable -> La4
            io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$$ExternalSyntheticLambda0 r1 = new io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$$ExternalSyntheticLambda0     // Catch: java.lang.Throwable -> La4
            r1.<init>()     // Catch: java.lang.Throwable -> La4
            kotlin.collections.CollectionsKt.removeAll(r0, r1)     // Catch: java.lang.Throwable -> La4
            kotlin.jvm.functions.Function0<java.lang.Long> r0 = r5.clock     // Catch: java.lang.Throwable -> La4
            java.lang.Object r0 = r0.invoke()     // Catch: java.lang.Throwable -> La4
            java.lang.Number r0 = (java.lang.Number) r0     // Catch: java.lang.Throwable -> La4
            long r0 = r0.longValue()     // Catch: java.lang.Throwable -> La4
            java.util.List<io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$CookieWithTimestamp> r2 = r5.container     // Catch: java.lang.Throwable -> La4
            io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$CookieWithTimestamp r4 = new io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$CookieWithTimestamp     // Catch: java.lang.Throwable -> La4
            io.ktor.http.Cookie r6 = io.ktor.client.plugins.cookies.CookiesStorageKt.fillDefaults(r7, r6)     // Catch: java.lang.Throwable -> La4
            r4.<init>(r6, r0)     // Catch: java.lang.Throwable -> La4
            r2.add(r4)     // Catch: java.lang.Throwable -> La4
            java.lang.Long r6 = r5.maxAgeOrExpires(r7, r0)     // Catch: java.lang.Throwable -> La4
            if (r6 == 0) goto L9e
            java.lang.Number r6 = (java.lang.Number) r6     // Catch: java.lang.Throwable -> La4
            long r6 = r6.longValue()     // Catch: java.lang.Throwable -> La4
            long r0 = r5.oldestCookie     // Catch: java.lang.Throwable -> La4
            int r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r0 <= 0) goto L9c
            r5.oldestCookie = r6     // Catch: java.lang.Throwable -> La4
        L9c:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> La4
        L9e:
            r8.unlock(r3)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        La4:
            r6 = move-exception
            r8.unlock(r3)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cookies.AcceptAllCookiesStorage.addCookie(io.ktor.http.Url, io.ktor.http.Cookie, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean addCookie$lambda$7$lambda$5(Cookie cookie, Url url, CookieWithTimestamp cookieWithTimestamp) {
        Intrinsics.checkNotNullParameter(cookieWithTimestamp, "<destruct>");
        Cookie cookie2 = cookieWithTimestamp.getCookie();
        return Intrinsics.areEqual(cookie2.getName(), cookie.getName()) && CookiesStorageKt.matches(cookie2, url);
    }

    private final void cleanup(final long timestamp) {
        CollectionsKt.removeAll((List) this.container, new Function1() { // from class: io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(AcceptAllCookiesStorage.cleanup$lambda$8(this.f$0, timestamp, (AcceptAllCookiesStorage.CookieWithTimestamp) obj));
            }
        });
        long jMin = Long.MAX_VALUE;
        for (CookieWithTimestamp cookieWithTimestamp : this.container) {
            Long lMaxAgeOrExpires = maxAgeOrExpires(cookieWithTimestamp.getCookie(), cookieWithTimestamp.getCreatedAt());
            if (lMaxAgeOrExpires != null) {
                jMin = Math.min(jMin, lMaxAgeOrExpires.longValue());
            }
        }
        this.oldestCookie = jMin;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean cleanup$lambda$8(AcceptAllCookiesStorage acceptAllCookiesStorage, long j, CookieWithTimestamp cookieWithTimestamp) {
        Intrinsics.checkNotNullParameter(cookieWithTimestamp, "<destruct>");
        Long lMaxAgeOrExpires = acceptAllCookiesStorage.maxAgeOrExpires(cookieWithTimestamp.getCookie(), cookieWithTimestamp.getCreatedAt());
        return lMaxAgeOrExpires != null && lMaxAgeOrExpires.longValue() < j;
    }

    private final Long maxAgeOrExpires(Cookie cookie, long j) {
        Integer maxAgeInt = cookie.getMaxAgeInt();
        if (maxAgeInt != null) {
            return Long.valueOf(j + (((long) maxAgeInt.intValue()) * 1000));
        }
        GMTDate expires = cookie.getExpires();
        if (expires != null) {
            return Long.valueOf(expires.getTimestamp());
        }
        return null;
    }
}
