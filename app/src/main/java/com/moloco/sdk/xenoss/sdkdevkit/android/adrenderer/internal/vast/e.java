package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast;

import com.google.android.exoplayer2.util.MimeTypes;
import com.moloco.sdk.common_adapter_internal.ScreenData;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.services.u;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.l;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.A;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.B;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.C3064a;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.h;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.v;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.w;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.x;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.y;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.z;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.q;
import io.ktor.client.HttpClient;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.io.files.FileSystemKt;

/* JADX INFO: loaded from: classes6.dex */
public final class e implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d {
    public static final c i = new c(null);
    public static final long j = 5000;
    public static final int k = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.i f2740a;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.l b;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i c;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.l d;
    public final u e;
    public final HttpClient f;
    public final q g;
    public final String h;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.n> f2741a;
        public final List<String> b;
        public final List<List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.g>> c;

        /* JADX WARN: Multi-variable type inference failed */
        public a(List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.n> impressions, List<String> errorUrls, List<? extends List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.g>> creativesPerWrapper) {
            Intrinsics.checkNotNullParameter(impressions, "impressions");
            Intrinsics.checkNotNullParameter(errorUrls, "errorUrls");
            Intrinsics.checkNotNullParameter(creativesPerWrapper, "creativesPerWrapper");
            this.f2741a = impressions;
            this.b = errorUrls;
            this.c = creativesPerWrapper;
        }

        public final List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.n> a() {
            return this.f2741a;
        }

        public final List<String> b() {
            return this.b;
        }

        public final List<List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.g>> c() {
            return this.c;
        }

        public final List<List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.g>> d() {
            return this.c;
        }

        public final List<String> e() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.areEqual(this.f2741a, aVar.f2741a) && Intrinsics.areEqual(this.b, aVar.b) && Intrinsics.areEqual(this.c, aVar.c);
        }

        public final List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.n> f() {
            return this.f2741a;
        }

        public int hashCode() {
            return (((this.f2741a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public String toString() {
            return "AggregatedWrapperChainAdData(impressions=" + this.f2741a + ", errorUrls=" + this.b + ", creativesPerWrapper=" + this.c + ')';
        }

        public final a a(List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.n> impressions, List<String> errorUrls, List<? extends List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.g>> creativesPerWrapper) {
            Intrinsics.checkNotNullParameter(impressions, "impressions");
            Intrinsics.checkNotNullParameter(errorUrls, "errorUrls");
            Intrinsics.checkNotNullParameter(creativesPerWrapper, "creativesPerWrapper");
            return new a(impressions, errorUrls, creativesPerWrapper);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ a a(a aVar, List list, List list2, List list3, int i, Object obj) {
            if ((i & 1) != 0) {
                list = aVar.f2741a;
            }
            if ((i & 2) != 0) {
                list2 = aVar.b;
            }
            if ((i & 4) != 0) {
                list3 = aVar.c;
            }
            return aVar.a(list, list2, list3);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.u> f2742a;
        public final A b;
        public final List<List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.l>> c;
        public final List<List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.e>> d;

        /* JADX WARN: Multi-variable type inference failed */
        public b(List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.u> linearTrackingList, A a2, List<? extends List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.l>> iconsPerWrapper, List<? extends List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.e>> companionsPerWrapper) {
            Intrinsics.checkNotNullParameter(linearTrackingList, "linearTrackingList");
            Intrinsics.checkNotNullParameter(iconsPerWrapper, "iconsPerWrapper");
            Intrinsics.checkNotNullParameter(companionsPerWrapper, "companionsPerWrapper");
            this.f2742a = linearTrackingList;
            this.b = a2;
            this.c = iconsPerWrapper;
            this.d = companionsPerWrapper;
        }

        public final List<List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.e>> a() {
            return this.d;
        }

        public final List<List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.l>> b() {
            return this.c;
        }

        public final List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.u> c() {
            return this.f2742a;
        }

        public final A d() {
            return this.b;
        }
    }

    public static final class c {
        public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public c() {
        }

        public final boolean a(String str) {
            String lowerCase = str.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            return Intrinsics.areEqual(lowerCase, MimeTypes.VIDEO_MP4) || Intrinsics.areEqual(lowerCase, MimeTypes.VIDEO_H263) || Intrinsics.areEqual(lowerCase, "video/webm");
        }

        public final List<String> a(Map<v, ? extends List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.u>> map, v vVar) {
            List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.u> list = map.get(vVar);
            if (list != null) {
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.u) it.next()).f());
                }
                return arrayList;
            }
            return CollectionsKt.emptyList();
        }

        public final List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.g> a(Map<v, ? extends List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.u>> map) {
            List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.u> list = map.get(v.n);
            if (list != null) {
                ArrayList arrayList = new ArrayList();
                for (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.u uVar : list) {
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.g gVar = uVar.e() == null ? null : new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.g(uVar.f(), uVar.e());
                    if (gVar != null) {
                        arrayList.add(gVar);
                    }
                }
                return arrayList;
            }
            return CollectionsKt.emptyList();
        }

        public final List<String> a(A a2) {
            List<z> listB;
            if (a2 != null && (listB = a2.b()) != null) {
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listB, 10));
                Iterator<T> it = listB.iterator();
                while (it.hasNext()) {
                    arrayList.add(((z) it.next()).b());
                }
                return arrayList;
            }
            return CollectionsKt.emptyList();
        }

        public final boolean a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.g gVar) {
            String strG = gVar.g();
            return !(strG == null || StringsKt.isBlank(strG));
        }

        public final boolean a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.e eVar) {
            String strC = eVar.c();
            return !(strC == null || StringsKt.isBlank(strC));
        }

        public final boolean a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.q qVar) {
            String strA = qVar.a();
            return !(strA == null || StringsKt.isBlank(strA));
        }

        public final boolean a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.l lVar) {
            String strA = lVar.a();
            return !(strA == null || StringsKt.isBlank(strA));
        }

        public final <T> Set<T> a(Set<? extends T> set, T t) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            if (set != null) {
                CollectionsKt.addAll(linkedHashSet, set);
            }
            if (t != null) {
                linkedHashSet.add(t);
            }
            return linkedHashSet;
        }

        public final <T> List<T> a(List<? extends T> list, List<? extends T> list2) {
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                CollectionsKt.addAll(arrayList, list);
            }
            if (list2 != null) {
                CollectionsKt.addAll(arrayList, list2);
            }
            return arrayList;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final <T> List<T> a(List<? extends T> list, T t) {
            List<T> listA;
            return (t == null || (listA = e.i.a((List) list, (List) CollectionsKt.listOf(t))) == null) ? list == 0 ? CollectionsKt.emptyList() : list : listA;
        }

        public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.h a(List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.u> list, A a2) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj : list) {
                v vVarD = ((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.u) obj).d();
                Object arrayList = linkedHashMap.get(vVarD);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    linkedHashMap.put(vVarD, arrayList);
                }
                ((List) arrayList).add(obj);
            }
            return new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.h(a(a2), a(linkedHashMap, v.f2840a), a(linkedHashMap, v.b), a(linkedHashMap, v.c), a(linkedHashMap, v.d), a(linkedHashMap, v.e), a(linkedHashMap, v.f), a(linkedHashMap, v.g), a(linkedHashMap, v.h), a(linkedHashMap, v.i), a(linkedHashMap, v.k), a(linkedHashMap, v.j), a(linkedHashMap, v.m), a(linkedHashMap, v.l), a(linkedHashMap));
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f2743a;
        public final Set<String> b;
        public final boolean c;
        public final a d;

        public d(int i, Set<String> usedVastAdTagUrls, boolean z, a aggregatedWrapperChainData) {
            Intrinsics.checkNotNullParameter(usedVastAdTagUrls, "usedVastAdTagUrls");
            Intrinsics.checkNotNullParameter(aggregatedWrapperChainData, "aggregatedWrapperChainData");
            this.f2743a = i;
            this.b = usedVastAdTagUrls;
            this.c = z;
            this.d = aggregatedWrapperChainData;
        }

        public final int a() {
            return this.f2743a;
        }

        public final Set<String> b() {
            return this.b;
        }

        public final boolean c() {
            return this.c;
        }

        public final a d() {
            return this.d;
        }

        public final a e() {
            return this.d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return this.f2743a == dVar.f2743a && Intrinsics.areEqual(this.b, dVar.b) && this.c == dVar.c && Intrinsics.areEqual(this.d, dVar.d);
        }

        public final boolean f() {
            return this.c;
        }

        public final Set<String> g() {
            return this.b;
        }

        public final int h() {
            return this.f2743a;
        }

        public int hashCode() {
            return (((((this.f2743a * 31) + this.b.hashCode()) * 31) + UByte$$ExternalSyntheticBackport0.m(this.c)) * 31) + this.d.hashCode();
        }

        public String toString() {
            return "WrapperChainParams(wrapperDepth=" + this.f2743a + ", usedVastAdTagUrls=" + this.b + ", followAdditionalWrappers=" + this.c + ", aggregatedWrapperChainData=" + this.d + ')';
        }

        public final d a(int i, Set<String> usedVastAdTagUrls, boolean z, a aggregatedWrapperChainData) {
            Intrinsics.checkNotNullParameter(usedVastAdTagUrls, "usedVastAdTagUrls");
            Intrinsics.checkNotNullParameter(aggregatedWrapperChainData, "aggregatedWrapperChainData");
            return new d(i, usedVastAdTagUrls, z, aggregatedWrapperChainData);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ d a(d dVar, int i, Set set, boolean z, a aVar, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = dVar.f2743a;
            }
            if ((i2 & 2) != 0) {
                set = dVar.b;
            }
            if ((i2 & 4) != 0) {
                z = dVar.c;
            }
            if ((i2 & 8) != 0) {
                aVar = dVar.d;
            }
            return dVar.a(i, set, z, aVar);
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.e$e, reason: collision with other inner class name */
    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastAdLoaderImpl", f = "VastAdLoader.kt", i = {0, 0, 0}, l = {152, 163}, m = "invoke", n = {"this", "mtid", "isStreamingEnabled"}, s = {"L$0", "L$1", "Z$0"})
    public static final class C0484e extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2744a;
        public Object b;
        public boolean c;
        public /* synthetic */ Object d;
        public int f;

        public C0484e(Continuation<? super C0484e> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= Integer.MIN_VALUE;
            return e.this.a((String) null, (String) null, false, (Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k>>) this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastAdLoaderImpl$invoke$renderAdResult$1", f = "VastAdLoader.kt", i = {}, l = {164}, m = "invokeSuspend", n = {}, s = {})
    public static final class f extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2745a;
        public final /* synthetic */ w c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ String e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(w wVar, boolean z, String str, Continuation<? super f> continuation) {
            super(2, continuation);
            this.c = wVar;
            this.d = z;
            this.e = str;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k>> continuation) {
            return ((f) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return e.this.new f(this.c, this.d, this.e, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f2745a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                e eVar = e.this;
                w wVar = this.c;
                double dB = eVar.b();
                ScreenData screenDataInvoke = e.this.g.invoke();
                boolean z = this.d;
                String str = this.e;
                this.f2745a = 1;
                obj = eVar.a(wVar, (d) null, dB, screenDataInvoke, z, str, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastAdLoaderImpl", f = "VastAdLoader.kt", i = {0, 0, 1, 1, 2, 2}, l = {805, 356, 367}, m = "loadAndParseWrapperVastDocument", n = {"this", "vastErrorUrls", "this", "vastErrorUrls", "this", "vastErrorUrls"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1"})
    public static final class g extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2746a;
        public Object b;
        public /* synthetic */ Object c;
        public int e;

        public g(Continuation<? super g> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return e.this.a((B) null, (List<String>) null, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastAdLoaderImpl", f = "VastAdLoader.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {418}, m = "tryLoadInLineRenderAd", n = {"this", "inline", "aggregatedWrapperChainData", "screenData", "mtid", "aggregatedErrorUrls", "preparedWrapperDataForInline$delegate", "renderLinearNullable", "renderCompanion", "renderLinearError", "creative", "targetLinearFileSizeInMegabytes", "isStreamingEnabled"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$11", "D$0", "Z$0"})
    public static final class h extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2747a;
        public Object b;
        public Object c;
        public Object d;
        public Object e;
        public Object f;
        public Object g;
        public Object h;
        public Object i;
        public Object j;
        public Object k;
        public Object l;
        public double m;
        public boolean n;
        public /* synthetic */ Object o;
        public int q;

        public h(Continuation<? super h> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.o = obj;
            this.q |= Integer.MIN_VALUE;
            return e.this.a((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.o) null, (a) null, 0.0d, (ScreenData) null, false, (String) null, (Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k>>) this);
        }
    }

    public static final class i implements Flow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Flow f2748a;
        public final /* synthetic */ e b;
        public final /* synthetic */ d c;
        public final /* synthetic */ double d;
        public final /* synthetic */ ScreenData e;
        public final /* synthetic */ boolean f;
        public final /* synthetic */ String g;
        public final /* synthetic */ Ref.ObjectRef h;

        public static final class a<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ FlowCollector f2749a;
            public final /* synthetic */ e b;
            public final /* synthetic */ d c;
            public final /* synthetic */ double d;
            public final /* synthetic */ ScreenData e;
            public final /* synthetic */ boolean f;
            public final /* synthetic */ String g;
            public final /* synthetic */ Ref.ObjectRef h;

            /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.e$i$a$a, reason: collision with other inner class name */
            @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastAdLoaderImpl$tryLoadVastRenderAd$$inlined$mapNotNull$1$2", f = "VastAdLoader.kt", i = {0, 0, 1, 1}, l = {54, 65, 86}, m = "emit", n = {"this", "$this$mapNotNull_u24lambda_u246", "this", "$this$mapNotNull_u24lambda_u246"}, s = {"L$0", "L$1", "L$0", "L$1"})
            public static final class C0485a extends ContinuationImpl {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public /* synthetic */ Object f2750a;
                public int b;
                public Object c;
                public Object e;

                public C0485a(Continuation continuation) {
                    super(continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    this.f2750a = obj;
                    this.b |= Integer.MIN_VALUE;
                    return a.this.emit(null, this);
                }
            }

            public a(FlowCollector flowCollector, e eVar, d dVar, double d, ScreenData screenData, boolean z, String str, Ref.ObjectRef objectRef) {
                this.f2749a = flowCollector;
                this.b = eVar;
                this.c = dVar;
                this.d = d;
                this.e = screenData;
                this.f = z;
                this.g = str;
                this.h = objectRef;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
            @Override // kotlinx.coroutines.flow.FlowCollector
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object emit(java.lang.Object r24, kotlin.coroutines.Continuation r25) throws java.lang.Throwable {
                /*
                    Method dump skipped, instruction units count: 348
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.e.i.a.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }

        public i(Flow flow, e eVar, d dVar, double d, ScreenData screenData, boolean z, String str, Ref.ObjectRef objectRef) {
            this.f2748a = flow;
            this.b = eVar;
            this.c = dVar;
            this.d = d;
            this.e = screenData;
            this.f = z;
            this.g = str;
            this.h = objectRef;
        }

        @Override // kotlinx.coroutines.flow.Flow
        public Object collect(FlowCollector<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a> flowCollector, Continuation continuation) {
            Object objCollect = this.f2748a.collect(new a(flowCollector, this.b, this.c, this.d, this.e, this.f, this.g, this.h), continuation);
            return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
        }
    }

    public static final class j<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return ComparisonsKt.compareValues(((C3064a) t).c(), ((C3064a) t2).c());
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastAdLoaderImpl", f = "VastAdLoader.kt", i = {0, 0}, l = {280}, m = "tryLoadVastRenderAd", n = {"this", "adLoadError"}, s = {"L$0", "L$1"})
    public static final class k extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2751a;
        public Object b;
        public /* synthetic */ Object c;
        public int e;

        public k(Continuation<? super k> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return e.this.a((w) null, (d) null, 0.0d, (ScreenData) null, false, (String) null, (Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k>>) this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastAdLoaderImpl", f = "VastAdLoader.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {311, 328}, m = "tryLoadWrapperRenderAd", n = {"this", "wrapper", "wrapperChainParams", "screenData", "mtid", "aggregatedErrorUrls", "targetLinearFileSizeInMegabytes", "isStreamingEnabled", "currentWrapperDepth"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "D$0", "Z$0", "I$0"})
    public static final class l extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2752a;
        public Object b;
        public Object c;
        public Object d;
        public Object e;
        public Object f;
        public double g;
        public boolean h;
        public int i;
        public /* synthetic */ Object j;
        public int l;

        public l(Continuation<? super l> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.j = obj;
            this.l |= Integer.MIN_VALUE;
            return e.this.a((B) null, (d) null, 0.0d, (ScreenData) null, false, (String) null, (Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k>>) this);
        }
    }

    public static final class m implements Flow<Pair<? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.q, ? extends File>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Flow f2753a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ e c;
        public final /* synthetic */ String d;
        public final /* synthetic */ Ref.ObjectRef e;

        public static final class a<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ FlowCollector f2754a;
            public final /* synthetic */ boolean b;
            public final /* synthetic */ e c;
            public final /* synthetic */ String d;
            public final /* synthetic */ Ref.ObjectRef e;

            /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.e$m$a$a, reason: collision with other inner class name */
            @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastAdLoaderImpl$tryPrepareInLineRenderLinear$$inlined$mapNotNull$1$2", f = "VastAdLoader.kt", i = {0, 0, 0, 1, 1, 1}, l = {53, 71, 82}, m = "emit", n = {"this", "$this$mapNotNull_u24lambda_u246", "vastMediaFile", "this", "$this$mapNotNull_u24lambda_u246", "vastMediaFile"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
            public static final class C0486a extends ContinuationImpl {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public /* synthetic */ Object f2755a;
                public int b;
                public Object c;
                public Object e;
                public Object f;

                public C0486a(Continuation continuation) {
                    super(continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    this.f2755a = obj;
                    this.b |= Integer.MIN_VALUE;
                    return a.this.emit(null, this);
                }
            }

            public a(FlowCollector flowCollector, boolean z, e eVar, String str, Ref.ObjectRef objectRef) {
                this.f2754a = flowCollector;
                this.b = z;
                this.c = eVar;
                this.d = str;
                this.e = objectRef;
            }

            /* JADX WARN: Removed duplicated region for block: B:26:0x0087  */
            /* JADX WARN: Removed duplicated region for block: B:27:0x0092  */
            /* JADX WARN: Removed duplicated region for block: B:41:0x00da  */
            /* JADX WARN: Removed duplicated region for block: B:42:0x00e5  */
            /* JADX WARN: Removed duplicated region for block: B:47:0x00f6  */
            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // kotlinx.coroutines.flow.FlowCollector
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object emit(java.lang.Object r9, kotlin.coroutines.Continuation r10) throws java.lang.Throwable {
                /*
                    Method dump skipped, instruction units count: 270
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.e.m.a.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }

        public m(Flow flow, boolean z, e eVar, String str, Ref.ObjectRef objectRef) {
            this.f2753a = flow;
            this.b = z;
            this.c = eVar;
            this.d = str;
            this.e = objectRef;
        }

        @Override // kotlinx.coroutines.flow.Flow
        public Object collect(FlowCollector<? super Pair<? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.q, ? extends File>> flowCollector, Continuation continuation) {
            Object objCollect = this.f2753a.collect(new a(flowCollector, this.b, this.c, this.d, this.e), continuation);
            return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastAdLoaderImpl", f = "VastAdLoader.kt", i = {0, 0, 0, 0, 0}, l = {565}, m = "tryPrepareInLineRenderLinear", n = {"this", "linear", "wrapperLinearTrackingList", "wrapperVideoClicks", "vastError"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
    public static final class n extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2756a;
        public Object b;
        public Object c;
        public Object d;
        public Object e;
        public /* synthetic */ Object f;
        public int h;

        public n(Continuation<? super n> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f = obj;
            this.h |= Integer.MIN_VALUE;
            return e.this.a((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.p) null, (List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.u>) null, (A) null, (List<String>) null, 0.0d, (Long) null, (ScreenData) null, false, (String) null, (Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.f, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k>>) this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastAdLoaderImpl", f = "VastAdLoader.kt", i = {0, 0}, l = {95}, m = "waitForAdLoadToStart-8Mi8wO0", n = {"this", "ad"}, s = {"L$0", "L$1"})
    public static final class o extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2757a;
        public Object b;
        public /* synthetic */ Object c;
        public int e;

        public o(Continuation<? super o> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return e.this.a((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a) null, 0L, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastAdLoaderImpl$waitForAdLoadToStart$streamStatus$1", f = "VastAdLoader.kt", i = {}, l = {97}, m = "invokeSuspend", n = {}, s = {})
    public static final class p extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2758a;
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a c;

        @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastAdLoaderImpl$waitForAdLoadToStart$streamStatus$1$1", f = "VastAdLoader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends SuspendLambda implements Function2<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c, Continuation<? super Boolean>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f2759a;
            public /* synthetic */ Object b;
            public final /* synthetic */ e c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(e eVar, Continuation<? super a> continuation) {
                super(2, continuation);
                this.c = eVar;
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c cVar, Continuation<? super Boolean> continuation) {
                return ((a) create(cVar, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                a aVar = new a(this.c, continuation);
                aVar.b = obj;
                return aVar;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f2759a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c cVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c) this.b;
                if (cVar instanceof c.C0438c) {
                    MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
                    String str = this.c.h;
                    StringBuilder sb = new StringBuilder("Stream status: ");
                    c.C0438c c0438c = (c.C0438c) cVar;
                    sb.append(c0438c.d().c());
                    sb.append(FileSystemKt.UnixPathSeparator);
                    sb.append(c0438c.d().d());
                    sb.append(" bytes downloaded");
                    MolocoLogger.info$default(molocoLogger, str, sb.toString(), null, false, 12, null);
                }
                return Boxing.boxBoolean((cVar instanceof c.a) || (cVar instanceof c.b));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a aVar, Continuation<? super p> continuation) {
            super(2, continuation);
            this.c = aVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c> continuation) {
            return ((p) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return e.this.new p(this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f2758a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c> flowB = e.this.c.b(this.c.j().l());
                a aVar = new a(e.this, null);
                this.f2758a = 1;
                obj = FlowKt.firstOrNull(flowB, aVar, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    public e(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.i parseVast, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.l mediaConfig, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i mediaCacheRepository, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.l vastTracker, u connectivityService, HttpClient httpClient, q screenService) {
        Intrinsics.checkNotNullParameter(parseVast, "parseVast");
        Intrinsics.checkNotNullParameter(mediaConfig, "mediaConfig");
        Intrinsics.checkNotNullParameter(mediaCacheRepository, "mediaCacheRepository");
        Intrinsics.checkNotNullParameter(vastTracker, "vastTracker");
        Intrinsics.checkNotNullParameter(connectivityService, "connectivityService");
        Intrinsics.checkNotNullParameter(httpClient, "httpClient");
        Intrinsics.checkNotNullParameter(screenService, "screenService");
        this.f2740a = parseVast;
        this.b = mediaConfig;
        this.c = mediaCacheRepository;
        this.d = vastTracker;
        this.e = connectivityService;
        this.f = httpClient;
        this.g = screenService;
        this.h = "VastAdLoaderImpl";
    }

    public final double a(long j2, int i2) {
        return (j2 * ((long) 8)) / ((double) (i2 * 1000));
    }

    public final double b() {
        return !this.e.b() ? 10.0d : 2.0d;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a r12, long r13, kotlin.coroutines.Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k>> r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 465
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.e.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object a(java.lang.String r19, java.lang.String r20, boolean r21, kotlin.coroutines.Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k>> r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 239
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.e.a(java.lang.String, java.lang.String, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ void a(e eVar, List list, x xVar, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            xVar = null;
        }
        eVar.a((List<String>) list, xVar);
    }

    public final void a(List<String> list, x xVar) {
        l.a.a(this.d, list, xVar, null, null, 12, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Type inference failed for: r0v1, types: [T, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.w r21, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.e.d r22, double r23, com.moloco.sdk.common_adapter_internal.ScreenData r25, boolean r26, java.lang.String r27, kotlin.coroutines.Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k>> r28) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 351
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.e.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.w, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.e$d, double, com.moloco.sdk.common_adapter_internal.ScreenData, boolean, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.B r25, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.e.d r26, double r27, com.moloco.sdk.common_adapter_internal.ScreenData r29, boolean r30, java.lang.String r31, kotlin.coroutines.Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k>> r32) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 505
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.e.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.B, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.e$d, double, com.moloco.sdk.common_adapter_internal.ScreenData, boolean, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r2v21, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v34 */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.e] */
    /* JADX WARN: Type inference failed for: r5v0, types: [int] */
    /* JADX WARN: Type inference failed for: r5v27 */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7, types: [com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.e] */
    /* JADX WARN: Type inference failed for: r5v9, types: [com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.e] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.B r19, java.util.List<java.lang.String> r20, kotlin.coroutines.Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.w, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k>> r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 359
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.e.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.B, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:72:0x0214, code lost:
    
        r7 = r31;
        r16 = r5;
        r5 = r28;
        r4 = r4;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x018d -> B:39:0x019d). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.o r31, final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.e.a r32, double r33, com.moloco.sdk.common_adapter_internal.ScreenData r35, boolean r36, java.lang.String r37, kotlin.coroutines.Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k>> r38) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 845
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.e.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.o, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.e$a, double, com.moloco.sdk.common_adapter_internal.ScreenData, boolean, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final b a(Lazy<b> lazy) {
        return lazy.getValue();
    }

    public static final b a(e eVar, a aVar) {
        return eVar.a(aVar);
    }

    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.e a(e eVar, List it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return eVar.a((List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.l>) it);
    }

    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.c a(e eVar, ScreenData screenData, List it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return eVar.a((List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.e>) it, screenData);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Type inference failed for: r1v1, types: [T, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.p r19, java.util.List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.u> r20, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.A r21, java.util.List<java.lang.String> r22, double r23, java.lang.Long r25, com.moloco.sdk.common_adapter_internal.ScreenData r26, boolean r27, java.lang.String r28, kotlin.coroutines.Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.f, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k>> r29) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 596
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.e.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.p, java.util.List, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.A, java.util.List, double, java.lang.Long, com.moloco.sdk.common_adapter_internal.ScreenData, boolean, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final b a(a aVar) {
        List<List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.g>> listD;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        if (aVar != null && (listD = aVar.d()) != null) {
            Iterator<T> it = listD.iterator();
            while (it.hasNext()) {
                List list = (List) it.next();
                ArrayList arrayList6 = new ArrayList();
                ArrayList arrayList7 = new ArrayList();
                ArrayList<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.g> arrayList8 = new ArrayList();
                for (Object obj : list) {
                    if (!i.a((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.g) obj)) {
                        arrayList8.add(obj);
                    }
                }
                for (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.g gVar : arrayList8) {
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.h hVarH = gVar.h();
                    if (hVarH instanceof h.b) {
                        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.p pVarA = ((h.b) gVar.h()).a();
                        CollectionsKt.addAll(arrayList, pVarA.f());
                        A aG = pVarA.g();
                        if (aG != null) {
                            CollectionsKt.addAll(arrayList2, aG.b());
                            CollectionsKt.addAll(arrayList3, aG.c());
                        }
                        CollectionsKt.addAll(arrayList6, pVarA.c());
                    } else if (hVarH instanceof h.a) {
                        CollectionsKt.addAll(arrayList7, ((h.a) gVar.h()).a());
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                }
                arrayList4.add(arrayList6);
                arrayList5.add(arrayList7);
            }
        }
        return new b(arrayList, new A(null, arrayList2, arrayList3), arrayList4, arrayList5);
    }

    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.c a(List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.e> list, ScreenData screenData) {
        List<String> listEmptyList;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (!i.a((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.e) obj) && (!r2.h().isEmpty())) {
                arrayList.add(obj);
            }
        }
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.e eVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.e) CollectionsKt.firstOrNull(CollectionsKt.sortedWith(arrayList, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.g.a(Integer.valueOf(screenData.getWidthPx()), Integer.valueOf(screenData.getHeightPx()))));
        if (eVar == null) {
            return null;
        }
        y yVar = (y) CollectionsKt.first(CollectionsKt.sortedWith(eVar.h(), com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.g.b()));
        Integer numI = eVar.i();
        int iIntValue = numI != null ? numI.intValue() : 0;
        Integer numF = eVar.f();
        int iIntValue2 = numF != null ? numF.intValue() : 0;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.f fVarD = eVar.d();
        String strA = fVarD != null ? fVarD.a() : null;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.f fVarD2 = eVar.d();
        if (fVarD2 == null || (listEmptyList = fVarD2.b()) == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        List<String> list2 = listEmptyList;
        List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.u> listE = eVar.e();
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listE, 10));
        Iterator<T> it = listE.iterator();
        while (it.hasNext()) {
            arrayList2.add(((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.u) it.next()).f());
        }
        return new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.c(yVar, iIntValue, iIntValue2, strA, list2, arrayList2);
    }

    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.e a(List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.l> list) {
        List<String> listEmptyList;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (!i.a((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.l) obj)) {
                arrayList.add(obj);
            }
        }
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.l lVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.l) CollectionsKt.firstOrNull(CollectionsKt.sortedWith(arrayList, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.g.a()));
        if (lVar == null) {
            return null;
        }
        y yVarG = lVar.g();
        Integer numI = lVar.i();
        int iIntValue = numI != null ? numI.intValue() : 0;
        Integer numD = lVar.d();
        int iIntValue2 = numD != null ? numD.intValue() : 0;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.m mVarB = lVar.b();
        String strA = mVarB != null ? mVarB.a() : null;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.m mVarB2 = lVar.b();
        if (mVarB2 == null || (listEmptyList = mVarB2.b()) == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        return new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.e(yVarG, iIntValue, iIntValue2, strA, listEmptyList, lVar.h(), lVar.c(), lVar.e());
    }
}
