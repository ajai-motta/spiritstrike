package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.r;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.v;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.w;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes6.dex */
public final class k {
    public static final String A = "CustomClick";
    public static final String B = "Icons";
    public static final String C = "Icon";
    public static final String D = "StaticResource";
    public static final String E = "IFrameResource";
    public static final String F = "HTMLResource";
    public static final String G = "IconClicks";
    public static final String H = "IconClickThrough";
    public static final String I = "IconClickTracking";
    public static final String J = "IconViewTracking";
    public static final String K = "AltText";
    public static final String L = "CompanionAds";
    public static final String M = "Companion";
    public static final String N = "CompanionClickThrough";
    public static final String O = "CompanionClickTracking";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f2762a = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return k.a();
        }
    });
    public static final NumberFormat b = NumberFormat.getPercentInstance();
    public static final String c = "Error";
    public static final String d = "Ad";
    public static final String e = "InLine";
    public static final String f = "Wrapper";
    public static final String g = "VASTAdTagURI";
    public static final String h = "AdSystem";
    public static final String i = "AdTitle";
    public static final String j = "Description";
    public static final String k = "Advertiser";
    public static final String l = "Pricing";
    public static final String m = "Survey";
    public static final String n = "Impression";
    public static final String o = "Creatives";
    public static final String p = "Creative";
    public static final String q = "Linear";
    public static final String r = "AdParameters";
    public static final String s = "Duration";
    public static final String t = "MediaFiles";
    public static final String u = "MediaFile";
    public static final String v = "TrackingEvents";
    public static final String w = "Tracking";
    public static final String x = "VideoClicks";
    public static final String y = "ClickThrough";
    public static final String z = "ClickTracking";

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {941}, m = "parseInLineTag", n = {"adSystem", "adTitle", "description", "advertiser", "pricing", "impressions", "errorUrls", "creatives"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7"})
    public static final class A extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2763a;
        public Object b;
        public Object c;
        public Object d;
        public Object e;
        public Object f;
        public Object g;
        public Object h;
        public /* synthetic */ Object i;
        public int j;

        public A(Continuation<? super A> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.i = obj;
            this.j |= Integer.MIN_VALUE;
            return k.K(null, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt$parseLinearTag$$inlined$iterateTag$1", f = "VastParser.kt", i = {0, 1, 2, 3, 4, 5}, l = {124, 125, 126, 127, 128, TsExtractor.TS_STREAM_TYPE_AC3}, m = "invokeSuspend", n = {"initialDepth", "initialDepth", "initialDepth", "initialDepth", "initialDepth", "initialDepth"}, s = {"I$0", "I$0", "I$0", "I$0", "I$0", "I$0"})
    public static final class B extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2764a;
        public int b;
        public /* synthetic */ Object c;
        public final /* synthetic */ XmlPullParser d;
        public final /* synthetic */ Ref.ObjectRef e;
        public final /* synthetic */ Ref.ObjectRef f;
        public final /* synthetic */ Ref.ObjectRef g;
        public final /* synthetic */ List h;
        public final /* synthetic */ List i;
        public final /* synthetic */ Ref.ObjectRef j;
        public final /* synthetic */ boolean k;
        public final /* synthetic */ List l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public B(XmlPullParser xmlPullParser, Continuation continuation, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2, Ref.ObjectRef objectRef3, List list, List list2, Ref.ObjectRef objectRef4, boolean z, List list3) {
            super(2, continuation);
            this.d = xmlPullParser;
            this.e = objectRef;
            this.f = objectRef2;
            this.g = objectRef3;
            this.h = list;
            this.i = list2;
            this.j = objectRef4;
            this.k = z;
            this.l = list3;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((B) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            B b = new B(this.d, continuation, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l);
            b.c = obj;
            return b;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:24:0x008c  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x0152  */
        /* JADX WARN: Removed duplicated region for block: B:74:0x0157  */
        /* JADX WARN: Removed duplicated region for block: B:99:0x01c8  */
        /* JADX WARN: Type inference failed for: r6v19, types: [T, java.lang.Long] */
        /* JADX WARN: Type inference failed for: r6v40, types: [T, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.r] */
        /* JADX WARN: Type inference failed for: r6v44, types: [T, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r6v46, types: [T, java.lang.Object] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0096 -> B:98:0x01c1). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00a0 -> B:98:0x01c1). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00a8 -> B:98:0x01c1). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00ae -> B:98:0x01c1). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00b9 -> B:98:0x01c1). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x00da -> B:98:0x01c1). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x00eb -> B:49:0x00ee). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x00fb -> B:98:0x01c1). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x011c -> B:98:0x01c1). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:66:0x013a -> B:98:0x01c1). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:77:0x0161 -> B:98:0x01c1). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:85:0x0181 -> B:98:0x01c1). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:93:0x01a3 -> B:98:0x01c1). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:95:0x01bc -> B:98:0x01c1). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 512
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.B.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {941}, m = "parseLinearTag", n = {"skipOffset", "adParameters", "durationMillis", "mediaFiles", "trackingList", "videoClicks", "icons", "isInLineParent"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0"})
    public static final class C extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f2765a;
        public Object b;
        public Object c;
        public Object d;
        public Object e;
        public Object f;
        public Object g;
        public Object h;
        public /* synthetic */ Object i;
        public int j;

        public C(Continuation<? super C> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.i = obj;
            this.j |= Integer.MIN_VALUE;
            return k.g(null, false, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt$parseMediaFileTag$$inlined$iterateTag$1", f = "VastParser.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class D extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2766a;
        public int b;
        public /* synthetic */ Object c;
        public final /* synthetic */ XmlPullParser d;
        public final /* synthetic */ Ref.ObjectRef e;
        public final /* synthetic */ Ref.ObjectRef f;
        public final /* synthetic */ Ref.ObjectRef g;
        public final /* synthetic */ Ref.ObjectRef h;
        public final /* synthetic */ Ref.ObjectRef i;
        public final /* synthetic */ Ref.ObjectRef j;
        public final /* synthetic */ Ref.ObjectRef k;
        public final /* synthetic */ Ref.ObjectRef l;
        public final /* synthetic */ Ref.ObjectRef m;
        public final /* synthetic */ Ref.ObjectRef n;
        public final /* synthetic */ Ref.ObjectRef o;
        public final /* synthetic */ Ref.ObjectRef p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public D(XmlPullParser xmlPullParser, Continuation continuation, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2, Ref.ObjectRef objectRef3, Ref.ObjectRef objectRef4, Ref.ObjectRef objectRef5, Ref.ObjectRef objectRef6, Ref.ObjectRef objectRef7, Ref.ObjectRef objectRef8, Ref.ObjectRef objectRef9, Ref.ObjectRef objectRef10, Ref.ObjectRef objectRef11, Ref.ObjectRef objectRef12) {
            super(2, continuation);
            this.d = xmlPullParser;
            this.e = objectRef;
            this.f = objectRef2;
            this.g = objectRef3;
            this.h = objectRef4;
            this.i = objectRef5;
            this.j = objectRef6;
            this.k = objectRef7;
            this.l = objectRef8;
            this.m = objectRef9;
            this.n = objectRef10;
            this.o = objectRef11;
            this.p = objectRef12;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((D) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            D d = new D(this.d, continuation, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p);
            d.c = obj;
            return d;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v20, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r0v22, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r2v17, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r2v5, types: [T, java.lang.Boolean] */
        /* JADX WARN: Type inference failed for: r2v7, types: [T, java.lang.String] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            String text;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            CoroutineScopeKt.ensureActive((CoroutineScope) this.c);
            if (k.j(this.d)) {
                this.d.nextTag();
            }
            if (k.h(this.d)) {
                return Unit.INSTANCE;
            }
            if (!k.k(this.d)) {
                throw new XmlPullParserException("iterateCurrentTagEvents call is allowed only for START_TAG event");
            }
            int depth = this.d.getDepth();
            while (this.d.getDepth() >= depth) {
                int depth2 = this.d.getDepth() - depth;
                if (depth2 != 0) {
                    if (depth2 == 1) {
                        k.k(this.d);
                    }
                } else if (k.k(this.d)) {
                    XmlPullParser xmlPullParser = this.d;
                    this.e.element = k.b(xmlPullParser, "id");
                    this.f.element = Boxing.boxBoolean(Intrinsics.areEqual(k.b(xmlPullParser, "delivery"), "progressive"));
                    this.g.element = k.b(xmlPullParser, "type");
                    Ref.ObjectRef objectRef = this.h;
                    String strB = k.b(xmlPullParser, ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
                    objectRef.element = strB != null ? StringsKt.toIntOrNull(strB) : 0;
                    Ref.ObjectRef objectRef2 = this.i;
                    String strB2 = k.b(xmlPullParser, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
                    objectRef2.element = strB2 != null ? StringsKt.toIntOrNull(strB2) : 0;
                    this.j.element = k.b(xmlPullParser, "codec");
                    Ref.ObjectRef objectRef3 = this.k;
                    String strB3 = k.b(xmlPullParser, "bitrate");
                    objectRef3.element = strB3 != null ? StringsKt.toIntOrNull(strB3) : 0;
                    Ref.ObjectRef objectRef4 = this.l;
                    String strB4 = k.b(xmlPullParser, "minBitrate");
                    objectRef4.element = strB4 != null ? StringsKt.toIntOrNull(strB4) : 0;
                    Ref.ObjectRef objectRef5 = this.m;
                    String strB5 = k.b(xmlPullParser, "maxBitrate");
                    objectRef5.element = strB5 != null ? StringsKt.toIntOrNull(strB5) : 0;
                    Ref.ObjectRef objectRef6 = this.n;
                    String strB6 = k.b(xmlPullParser, "scalable");
                    objectRef6.element = strB6 != null ? Boxing.boxBoolean(Boolean.parseBoolean(strB6)) : 0;
                    this.o.element = k.b(xmlPullParser, "apiFramework");
                } else if (k.l(this.d) && (text = this.d.getText()) != null && !StringsKt.isBlank(text)) {
                    String text2 = this.d.getText();
                    Intrinsics.checkNotNullExpressionValue(text2, "getText(...)");
                    this.p.element = StringsKt.trim((CharSequence) text2).toString();
                } else if (k.i(this.d)) {
                    return Unit.INSTANCE;
                }
                this.d.next();
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {941}, m = "parseMediaFileTag", n = {"mediaFileUrl", "id", "isProgressiveDelivery", "type", "widthPx", "heightPx", "codec", "bitrate", "minBitrate", "maxBitrate", "isScalable", "apiFramework"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11"})
    public static final class E extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2767a;
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
        public /* synthetic */ Object m;
        public int n;

        public E(Continuation<? super E> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.m = obj;
            this.n |= Integer.MIN_VALUE;
            return k.L(null, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt$parseMediaFilesTag$$inlined$iterateTag$1", f = "VastParser.kt", i = {0}, l = {123}, m = "invokeSuspend", n = {"initialDepth"}, s = {"I$0"})
    public static final class F extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2768a;
        public int b;
        public /* synthetic */ Object c;
        public final /* synthetic */ XmlPullParser d;
        public final /* synthetic */ List e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public F(XmlPullParser xmlPullParser, Continuation continuation, List list) {
            super(2, continuation);
            this.d = xmlPullParser;
            this.e = list;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((F) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            F f = new F(this.d, continuation, this.e);
            f.c = obj;
            return f;
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0052  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0083  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x00ce  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x005b -> B:49:0x00c7). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0064 -> B:49:0x00c7). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0072 -> B:49:0x00c7). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x007c -> B:31:0x007f). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x008f -> B:49:0x00c7). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x00a9 -> B:49:0x00c7). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00c2 -> B:49:0x00c7). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 217
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.F.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", i = {0}, l = {941}, m = "parseMediaFilesTag", n = {"mediaFiles"}, s = {"L$0"})
    public static final class G extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2769a;
        public /* synthetic */ Object b;
        public int c;

        public G(Continuation<? super G> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.c |= Integer.MIN_VALUE;
            return k.M(null, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt$parsePricingTag$$inlined$iterateTag$1", f = "VastParser.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class H extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2770a;
        public int b;
        public /* synthetic */ Object c;
        public final /* synthetic */ XmlPullParser d;
        public final /* synthetic */ Ref.ObjectRef e;
        public final /* synthetic */ Ref.ObjectRef f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public H(XmlPullParser xmlPullParser, Continuation continuation, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2) {
            super(2, continuation);
            this.d = xmlPullParser;
            this.e = objectRef;
            this.f = objectRef2;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((H) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            H h = new H(this.d, continuation, this.e, this.f);
            h.c = obj;
            return h;
        }

        /* JADX WARN: Type inference failed for: r0v21, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.String] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            String text;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            CoroutineScopeKt.ensureActive((CoroutineScope) this.c);
            if (k.j(this.d)) {
                this.d.nextTag();
            }
            if (k.h(this.d)) {
                return Unit.INSTANCE;
            }
            if (!k.k(this.d)) {
                throw new XmlPullParserException("iterateCurrentTagEvents call is allowed only for START_TAG event");
            }
            int depth = this.d.getDepth();
            while (this.d.getDepth() >= depth) {
                int depth2 = this.d.getDepth() - depth;
                if (depth2 != 0) {
                    if (depth2 == 1) {
                        k.k(this.d);
                    }
                } else if (k.k(this.d)) {
                    XmlPullParser xmlPullParser = this.d;
                    this.e.element = k.b(xmlPullParser, DeviceRequestsHelper.DEVICE_INFO_MODEL);
                    this.f.element = k.b(xmlPullParser, "currency");
                } else if (k.l(this.d) && (text = this.d.getText()) != null && !StringsKt.isBlank(text)) {
                    String text2 = this.d.getText();
                    Intrinsics.checkNotNullExpressionValue(text2, "getText(...)");
                    StringsKt.trim((CharSequence) text2).toString();
                } else if (k.i(this.d)) {
                    return Unit.INSTANCE;
                }
                this.d.next();
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", i = {0, 0}, l = {941}, m = "parsePricingTag", n = {DeviceRequestsHelper.DEVICE_INFO_MODEL, "currency"}, s = {"L$0", "L$1"})
    public static final class I extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2771a;
        public Object b;
        public /* synthetic */ Object c;
        public int d;

        public I(Continuation<? super I> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.d |= Integer.MIN_VALUE;
            return k.N(null, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt$parseStaticResourceTag$$inlined$iterateTag$1", f = "VastParser.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class J extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2772a;
        public int b;
        public /* synthetic */ Object c;
        public final /* synthetic */ XmlPullParser d;
        public final /* synthetic */ Ref.ObjectRef e;
        public final /* synthetic */ Ref.ObjectRef f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public J(XmlPullParser xmlPullParser, Continuation continuation, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2) {
            super(2, continuation);
            this.d = xmlPullParser;
            this.e = objectRef;
            this.f = objectRef2;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((J) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            J j = new J(this.d, continuation, this.e, this.f);
            j.c = obj;
            return j;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v20, types: [T, java.lang.String] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            String text;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            CoroutineScopeKt.ensureActive((CoroutineScope) this.c);
            if (k.j(this.d)) {
                this.d.nextTag();
            }
            if (k.h(this.d)) {
                return Unit.INSTANCE;
            }
            if (!k.k(this.d)) {
                throw new XmlPullParserException("iterateCurrentTagEvents call is allowed only for START_TAG event");
            }
            int depth = this.d.getDepth();
            while (this.d.getDepth() >= depth) {
                int depth2 = this.d.getDepth() - depth;
                if (depth2 != 0) {
                    if (depth2 == 1) {
                        k.k(this.d);
                    }
                } else if (k.k(this.d)) {
                    XmlPullParser xmlPullParser = this.d;
                    Ref.ObjectRef objectRef = this.e;
                    String strB = k.b(xmlPullParser, "creativeType");
                    objectRef.element = strB != null ? k.e(strB) : 0;
                } else if (k.l(this.d) && (text = this.d.getText()) != null && !StringsKt.isBlank(text)) {
                    String text2 = this.d.getText();
                    Intrinsics.checkNotNullExpressionValue(text2, "getText(...)");
                    this.f.element = StringsKt.trim((CharSequence) text2).toString();
                } else if (k.i(this.d)) {
                    return Unit.INSTANCE;
                }
                this.d.next();
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", i = {0, 0}, l = {941}, m = "parseStaticResourceTag", n = {"resource", "creativeType"}, s = {"L$0", "L$1"})
    public static final class K extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2773a;
        public Object b;
        public /* synthetic */ Object c;
        public int d;

        public K(Continuation<? super K> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.d |= Integer.MIN_VALUE;
            return k.O(null, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt$parseTagsTextOnly$$inlined$iterateTag$1", f = "VastParser.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class L extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2774a;
        public int b;
        public /* synthetic */ Object c;
        public final /* synthetic */ XmlPullParser d;
        public final /* synthetic */ Ref.ObjectRef e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public L(XmlPullParser xmlPullParser, Continuation continuation, Ref.ObjectRef objectRef) {
            super(2, continuation);
            this.d = xmlPullParser;
            this.e = objectRef;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((L) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            L l = new L(this.d, continuation, this.e);
            l.c = obj;
            return l;
        }

        /* JADX WARN: Type inference failed for: r0v20, types: [T, java.lang.String] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            String text;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            CoroutineScopeKt.ensureActive((CoroutineScope) this.c);
            if (k.j(this.d)) {
                this.d.nextTag();
            }
            if (k.h(this.d)) {
                return Unit.INSTANCE;
            }
            if (!k.k(this.d)) {
                throw new XmlPullParserException("iterateCurrentTagEvents call is allowed only for START_TAG event");
            }
            int depth = this.d.getDepth();
            while (this.d.getDepth() >= depth) {
                int depth2 = this.d.getDepth() - depth;
                if (depth2 != 0) {
                    if (depth2 == 1) {
                        k.k(this.d);
                    }
                } else if (k.k(this.d)) {
                    continue;
                } else if (k.l(this.d) && (text = this.d.getText()) != null && !StringsKt.isBlank(text)) {
                    String text2 = this.d.getText();
                    Intrinsics.checkNotNullExpressionValue(text2, "getText(...)");
                    this.e.element = StringsKt.trim((CharSequence) text2).toString();
                } else if (k.i(this.d)) {
                    return Unit.INSTANCE;
                }
                this.d.next();
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", i = {0}, l = {941}, m = "parseTagsTextOnly", n = {"simpleText"}, s = {"L$0"})
    public static final class M extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2775a;
        public /* synthetic */ Object b;
        public int c;

        public M(Continuation<? super M> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.c |= Integer.MIN_VALUE;
            return k.P(null, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt$parseTrackingEventsTag$$inlined$iterateTag$1", f = "VastParser.kt", i = {0}, l = {123}, m = "invokeSuspend", n = {"initialDepth"}, s = {"I$0"})
    public static final class N extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2776a;
        public int b;
        public /* synthetic */ Object c;
        public final /* synthetic */ XmlPullParser d;
        public final /* synthetic */ List e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public N(XmlPullParser xmlPullParser, Continuation continuation, List list) {
            super(2, continuation);
            this.d = xmlPullParser;
            this.e = list;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((N) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            N n = new N(this.d, continuation, this.e);
            n.c = obj;
            return n;
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0052  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0083  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x00ce  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x005b -> B:49:0x00c7). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0064 -> B:49:0x00c7). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0072 -> B:49:0x00c7). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x007c -> B:31:0x007f). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x008f -> B:49:0x00c7). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x00a9 -> B:49:0x00c7). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00c2 -> B:49:0x00c7). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 217
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.N.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", i = {0}, l = {941}, m = "parseTrackingEventsTag", n = {"trackingList"}, s = {"L$0"})
    public static final class O extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2777a;
        public /* synthetic */ Object b;
        public int c;

        public O(Continuation<? super O> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.c |= Integer.MIN_VALUE;
            return k.Q(null, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt$parseTrackingTag$$inlined$iterateTag$1", f = "VastParser.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class P extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2778a;
        public int b;
        public /* synthetic */ Object c;
        public final /* synthetic */ XmlPullParser d;
        public final /* synthetic */ Ref.ObjectRef e;
        public final /* synthetic */ Ref.ObjectRef f;
        public final /* synthetic */ Ref.ObjectRef g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public P(XmlPullParser xmlPullParser, Continuation continuation, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2, Ref.ObjectRef objectRef3) {
            super(2, continuation);
            this.d = xmlPullParser;
            this.e = objectRef;
            this.f = objectRef2;
            this.g = objectRef3;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((P) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            P p = new P(this.d, continuation, this.e, this.f, this.g);
            p.c = obj;
            return p;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v20, types: [T, java.lang.String] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            String text;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            CoroutineScopeKt.ensureActive((CoroutineScope) this.c);
            if (k.j(this.d)) {
                this.d.nextTag();
            }
            if (k.h(this.d)) {
                return Unit.INSTANCE;
            }
            if (!k.k(this.d)) {
                throw new XmlPullParserException("iterateCurrentTagEvents call is allowed only for START_TAG event");
            }
            int depth = this.d.getDepth();
            while (this.d.getDepth() >= depth) {
                int depth2 = this.d.getDepth() - depth;
                if (depth2 != 0) {
                    if (depth2 == 1) {
                        k.k(this.d);
                    }
                } else if (k.k(this.d)) {
                    XmlPullParser xmlPullParser = this.d;
                    Ref.ObjectRef objectRef = this.e;
                    String strB = k.b(xmlPullParser, "event");
                    objectRef.element = strB != null ? k.i(strB) : 0;
                    Ref.ObjectRef objectRef2 = this.f;
                    String strB2 = k.b(xmlPullParser, TypedValues.CycleType.S_WAVE_OFFSET);
                    objectRef2.element = strB2 != null ? k.g(strB2) : 0;
                } else if (k.l(this.d) && (text = this.d.getText()) != null && !StringsKt.isBlank(text)) {
                    String text2 = this.d.getText();
                    Intrinsics.checkNotNullExpressionValue(text2, "getText(...)");
                    this.g.element = StringsKt.trim((CharSequence) text2).toString();
                } else if (k.i(this.d)) {
                    return Unit.INSTANCE;
                }
                this.d.next();
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", i = {0, 0, 0}, l = {941}, m = "parseTrackingTag", n = {"event", "url", TypedValues.CycleType.S_WAVE_OFFSET}, s = {"L$0", "L$1", "L$2"})
    public static final class Q extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2779a;
        public Object b;
        public Object c;
        public /* synthetic */ Object d;
        public int e;

        public Q(Continuation<? super Q> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.e |= Integer.MIN_VALUE;
            return k.R(null, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt$parseVast$2", f = "VastParser.kt", i = {}, l = {TsExtractor.TS_STREAM_TYPE_HDMV_DTS}, m = "invokeSuspend", n = {}, s = {})
    public static final class R extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super w>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2780a;
        public final /* synthetic */ XmlPullParser b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public R(XmlPullParser xmlPullParser, Continuation<? super R> continuation) {
            super(2, continuation);
            this.b = xmlPullParser;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super w> continuation) {
            return ((R) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new R(this.b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f2780a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                XmlPullParser xmlPullParser = this.b;
                this.f2780a = 1;
                obj = k.T(xmlPullParser, this);
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

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt$parseVastTag$$inlined$iterateTag$1", f = "VastParser.kt", i = {0, 1}, l = {124, 125}, m = "invokeSuspend", n = {"initialDepth", "initialDepth"}, s = {"I$0", "I$0"})
    public static final class S extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2781a;
        public int b;
        public /* synthetic */ Object c;
        public final /* synthetic */ XmlPullParser d;
        public final /* synthetic */ Ref.ObjectRef e;
        public final /* synthetic */ Ref.ObjectRef f;
        public final /* synthetic */ List g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public S(XmlPullParser xmlPullParser, Continuation continuation, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2, List list) {
            super(2, continuation);
            this.d = xmlPullParser;
            this.e = objectRef;
            this.f = objectRef2;
            this.g = list;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((S) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            S s = new S(this.d, continuation, this.e, this.f, this.g);
            s.c = obj;
            return s;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0060  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x00af  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x0106  */
        /* JADX WARN: Type inference failed for: r7v34, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r7v39, types: [T, java.lang.Object] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0069 -> B:57:0x00ff). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0073 -> B:57:0x00ff). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x009b -> B:57:0x00ff). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00a8 -> B:39:0x00ab). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x00bd -> B:57:0x00ff). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x00e1 -> B:57:0x00ff). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x00fa -> B:57:0x00ff). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 273
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.S.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", i = {0, 0, 0}, l = {941}, m = "parseVastTag", n = {"ads", "version", "errorUrl"}, s = {"L$0", "L$1", "L$2"})
    public static final class T extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2782a;
        public Object b;
        public Object c;
        public /* synthetic */ Object d;
        public int e;

        public T(Continuation<? super T> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.e |= Integer.MIN_VALUE;
            return k.T(null, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt$parseVideoClickTag$$inlined$iterateTag$1", f = "VastParser.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class U extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2783a;
        public int b;
        public /* synthetic */ Object c;
        public final /* synthetic */ XmlPullParser d;
        public final /* synthetic */ Ref.ObjectRef e;
        public final /* synthetic */ Ref.ObjectRef f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public U(XmlPullParser xmlPullParser, Continuation continuation, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2) {
            super(2, continuation);
            this.d = xmlPullParser;
            this.e = objectRef;
            this.f = objectRef2;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((U) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            U u = new U(this.d, continuation, this.e, this.f);
            u.c = obj;
            return u;
        }

        /* JADX WARN: Type inference failed for: r0v20, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r0v22, types: [T, java.lang.String] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            String text;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            CoroutineScopeKt.ensureActive((CoroutineScope) this.c);
            if (k.j(this.d)) {
                this.d.nextTag();
            }
            if (k.h(this.d)) {
                return Unit.INSTANCE;
            }
            if (!k.k(this.d)) {
                throw new XmlPullParserException("iterateCurrentTagEvents call is allowed only for START_TAG event");
            }
            int depth = this.d.getDepth();
            while (this.d.getDepth() >= depth) {
                int depth2 = this.d.getDepth() - depth;
                if (depth2 != 0) {
                    if (depth2 == 1) {
                        k.k(this.d);
                    }
                } else if (k.k(this.d)) {
                    this.e.element = k.b(this.d, "id");
                } else if (k.l(this.d) && (text = this.d.getText()) != null && !StringsKt.isBlank(text)) {
                    String text2 = this.d.getText();
                    Intrinsics.checkNotNullExpressionValue(text2, "getText(...)");
                    this.f.element = StringsKt.trim((CharSequence) text2).toString();
                } else if (k.i(this.d)) {
                    return Unit.INSTANCE;
                }
                this.d.next();
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", i = {0, 0}, l = {941}, m = "parseVideoClickTag", n = {"id", "url"}, s = {"L$0", "L$1"})
    public static final class V extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2784a;
        public Object b;
        public /* synthetic */ Object c;
        public int d;

        public V(Continuation<? super V> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.d |= Integer.MIN_VALUE;
            return k.U(null, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt$parseVideoClicksTag$$inlined$iterateTag$1", f = "VastParser.kt", i = {0, 1, 2}, l = {123, 124, 126}, m = "invokeSuspend", n = {"initialDepth", "initialDepth", "initialDepth"}, s = {"I$0", "I$0", "I$0"})
    public static final class W extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2785a;
        public int b;
        public /* synthetic */ Object c;
        public final /* synthetic */ XmlPullParser d;
        public final /* synthetic */ Ref.ObjectRef e;
        public final /* synthetic */ List f;
        public final /* synthetic */ List g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public W(XmlPullParser xmlPullParser, Continuation continuation, Ref.ObjectRef objectRef, List list, List list2) {
            super(2, continuation);
            this.d = xmlPullParser;
            this.e = objectRef;
            this.f = list;
            this.g = list2;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((W) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            W w = new W(this.d, continuation, this.e, this.f, this.g);
            w.c = obj;
            return w;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:24:0x006b  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x00b9  */
        /* JADX WARN: Removed duplicated region for block: B:56:0x00db  */
        /* JADX WARN: Removed duplicated region for block: B:80:0x0141  */
        /* JADX WARN: Type inference failed for: r10v38, types: [T, java.lang.Object] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0074 -> B:79:0x013a). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x007e -> B:79:0x013a). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0086 -> B:79:0x013a). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x009a -> B:79:0x013a). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00a4 -> B:79:0x013a). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00b7 -> B:79:0x013a). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x00b9 -> B:79:0x013a). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x00c6 -> B:79:0x013a). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x00d4 -> B:54:0x00d7). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x00e7 -> B:79:0x013a). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:65:0x0102 -> B:79:0x013a). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:74:0x011c -> B:79:0x013a). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:76:0x0135 -> B:79:0x013a). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 332
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.W.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", i = {0, 0, 0, 0}, l = {941}, m = "parseVideoClicksTag", n = {"clickThrough", "clickTrackingList", "customClickList", "isInLineParent"}, s = {"L$0", "L$1", "L$2", "Z$0"})
    public static final class X extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f2786a;
        public Object b;
        public Object c;
        public Object d;
        public /* synthetic */ Object e;
        public int f;

        public X(Continuation<? super X> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.f |= Integer.MIN_VALUE;
            return k.h(null, false, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt$parseWrapperTag$$inlined$iterateTag$1", f = "VastParser.kt", i = {0, 1, 2, 3, 4}, l = {126, 127, 128, TsExtractor.TS_STREAM_TYPE_AC3, TsExtractor.TS_STREAM_TYPE_HDMV_DTS}, m = "invokeSuspend", n = {"initialDepth", "initialDepth", "initialDepth", "initialDepth", "initialDepth"}, s = {"I$0", "I$0", "I$0", "I$0", "I$0"})
    public static final class Y extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2787a;
        public int b;
        public /* synthetic */ Object c;
        public final /* synthetic */ XmlPullParser d;
        public final /* synthetic */ Ref.ObjectRef e;
        public final /* synthetic */ Ref.ObjectRef f;
        public final /* synthetic */ Ref.ObjectRef g;
        public final /* synthetic */ List h;
        public final /* synthetic */ List i;
        public final /* synthetic */ List j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Y(XmlPullParser xmlPullParser, Continuation continuation, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2, Ref.ObjectRef objectRef3, List list, List list2, List list3) {
            super(2, continuation);
            this.d = xmlPullParser;
            this.e = objectRef;
            this.f = objectRef2;
            this.g = objectRef3;
            this.h = list;
            this.i = list2;
            this.j = list3;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((Y) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Y y = new Y(this.d, continuation, this.e, this.f, this.g, this.h, this.i, this.j);
            y.c = obj;
            return y;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:103:0x019b, code lost:
        
            r8.element = null;
         */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0083  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x00c5  */
        /* JADX WARN: Removed duplicated region for block: B:56:0x00e7  */
        /* JADX WARN: Removed duplicated region for block: B:97:0x01a2  */
        /* JADX WARN: Type inference failed for: r11v44, types: [T, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r11v45, types: [T, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r7v4, types: [T, java.lang.Boolean] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x008d -> B:96:0x019b). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x0097 -> B:96:0x019b). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x009f -> B:96:0x019b). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00a5 -> B:96:0x019b). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00b0 -> B:96:0x019b). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00c3 -> B:96:0x019b). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x00c5 -> B:96:0x019b). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x00d2 -> B:96:0x019b). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x00e5 -> B:96:0x019b). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x00e7 -> B:96:0x019b). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x00f4 -> B:96:0x019b). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:65:0x0111 -> B:96:0x019b). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:72:0x012e -> B:96:0x019b). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:75:0x013c -> B:77:0x013f). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:91:0x017d -> B:96:0x019b). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:93:0x0196 -> B:96:0x019b). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 452
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.Y.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", i = {0, 0, 0, 0, 0, 0}, l = {941}, m = "parseWrapperTag", n = {"vastAdTagUrl", "followAdditionalWrappers", "adSystem", "impressions", "errorUrls", "creatives"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
    public static final class Z extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2788a;
        public Object b;
        public Object c;
        public Object d;
        public Object e;
        public Object f;
        public /* synthetic */ Object g;
        public int h;

        public Z(Continuation<? super Z> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.g = obj;
            this.h |= Integer.MIN_VALUE;
            return k.V(null, this);
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$a, reason: case insensitive filesystem */
    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt$iterateTag$2", f = "VastParser.kt", i = {0, 1, 2}, l = {102, 103, 111}, m = "invokeSuspend", n = {"initialDepth", "initialDepth", "initialDepth"}, s = {"I$0", "I$0", "I$0"})
    public static final class C3039a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2789a;
        public int b;
        public /* synthetic */ Object c;
        public final /* synthetic */ XmlPullParser d;
        public final /* synthetic */ Function2<XmlPullParser, Continuation<? super Unit>, Object> e;
        public final /* synthetic */ Function3<XmlPullParser, String, Continuation<? super Unit>, Object> f;
        public final /* synthetic */ Function2<XmlPullParser, Continuation<? super Unit>, Object> g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C3039a(XmlPullParser xmlPullParser, Function2<? super XmlPullParser, ? super Continuation<? super Unit>, ? extends Object> function2, Function3<? super XmlPullParser, ? super String, ? super Continuation<? super Unit>, ? extends Object> function3, Function2<? super XmlPullParser, ? super Continuation<? super Unit>, ? extends Object> function22, Continuation<? super C3039a> continuation) {
            super(2, continuation);
            this.d = xmlPullParser;
            this.e = function2;
            this.f = function3;
            this.g = function22;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C3039a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C3039a c3039a = new C3039a(this.d, this.e, this.f, this.g, continuation);
            c3039a.c = obj;
            return c3039a;
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x005a  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x00dd  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0063 -> B:51:0x00d6). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x006c -> B:51:0x00d6). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x007a -> B:51:0x00d6). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x0091 -> B:51:0x00d6). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00c8 -> B:51:0x00d6). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x00d1 -> B:51:0x00d6). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 232
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.C3039a.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object a(Object obj) throws XmlPullParserException, IOException {
            String text;
            CoroutineScopeKt.ensureActive((CoroutineScope) this.c);
            if (k.j(this.d)) {
                this.d.nextTag();
            }
            if (k.h(this.d)) {
                return Unit.INSTANCE;
            }
            if (!k.k(this.d)) {
                throw new XmlPullParserException("iterateCurrentTagEvents call is allowed only for START_TAG event");
            }
            int depth = this.d.getDepth();
            while (this.d.getDepth() >= depth) {
                int depth2 = this.d.getDepth() - depth;
                if (depth2 != 0) {
                    if (depth2 == 1 && k.k(this.d)) {
                        this.g.invoke(this.d, this);
                    }
                } else if (k.k(this.d)) {
                    this.e.invoke(this.d, this);
                } else if (k.l(this.d) && (text = this.d.getText()) != null && !StringsKt.isBlank(text)) {
                    Function3<XmlPullParser, String, Continuation<? super Unit>, Object> function3 = this.f;
                    XmlPullParser xmlPullParser = this.d;
                    String text2 = xmlPullParser.getText();
                    Intrinsics.checkNotNullExpressionValue(text2, "getText(...)");
                    function3.invoke(xmlPullParser, StringsKt.trim((CharSequence) text2).toString(), this);
                } else if (k.i(this.d)) {
                    return Unit.INSTANCE;
                }
                this.d.next();
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$b, reason: case insensitive filesystem */
    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt$parseAdParametersTag$$inlined$iterateTag$1", f = "VastParser.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C3040b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2790a;
        public int b;
        public /* synthetic */ Object c;
        public final /* synthetic */ XmlPullParser d;
        public final /* synthetic */ Ref.ObjectRef e;
        public final /* synthetic */ Ref.ObjectRef f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C3040b(XmlPullParser xmlPullParser, Continuation continuation, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2) {
            super(2, continuation);
            this.d = xmlPullParser;
            this.e = objectRef;
            this.f = objectRef2;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C3040b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C3040b c3040b = new C3040b(this.d, continuation, this.e, this.f);
            c3040b.c = obj;
            return c3040b;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v20, types: [T, java.lang.String] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            String text;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            CoroutineScopeKt.ensureActive((CoroutineScope) this.c);
            if (k.j(this.d)) {
                this.d.nextTag();
            }
            if (k.h(this.d)) {
                return Unit.INSTANCE;
            }
            if (!k.k(this.d)) {
                throw new XmlPullParserException("iterateCurrentTagEvents call is allowed only for START_TAG event");
            }
            int depth = this.d.getDepth();
            while (this.d.getDepth() >= depth) {
                int depth2 = this.d.getDepth() - depth;
                if (depth2 != 0) {
                    if (depth2 == 1) {
                        k.k(this.d);
                    }
                } else if (k.k(this.d)) {
                    XmlPullParser xmlPullParser = this.d;
                    Ref.ObjectRef objectRef = this.e;
                    String strB = k.b(xmlPullParser, "xmlEncoded");
                    objectRef.element = strB != null ? Boxing.boxBoolean(Boolean.parseBoolean(strB)) : 0;
                } else if (k.l(this.d) && (text = this.d.getText()) != null && !StringsKt.isBlank(text)) {
                    String text2 = this.d.getText();
                    Intrinsics.checkNotNullExpressionValue(text2, "getText(...)");
                    this.f.element = StringsKt.trim((CharSequence) text2).toString();
                } else if (k.i(this.d)) {
                    return Unit.INSTANCE;
                }
                this.d.next();
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$c, reason: case insensitive filesystem */
    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", i = {0, 0}, l = {941}, m = "parseAdParametersTag", n = {"rawText", "isXmlEncoded"}, s = {"L$0", "L$1"})
    public static final class C3041c extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2791a;
        public Object b;
        public /* synthetic */ Object c;
        public int d;

        public C3041c(Continuation<? super C3041c> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.d |= Integer.MIN_VALUE;
            return k.y(null, this);
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$d, reason: case insensitive filesystem */
    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt$parseAdSystemTag$$inlined$iterateTag$1", f = "VastParser.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C3042d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2792a;
        public int b;
        public /* synthetic */ Object c;
        public final /* synthetic */ XmlPullParser d;
        public final /* synthetic */ Ref.ObjectRef e;
        public final /* synthetic */ Ref.ObjectRef f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C3042d(XmlPullParser xmlPullParser, Continuation continuation, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2) {
            super(2, continuation);
            this.d = xmlPullParser;
            this.e = objectRef;
            this.f = objectRef2;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C3042d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C3042d c3042d = new C3042d(this.d, continuation, this.e, this.f);
            c3042d.c = obj;
            return c3042d;
        }

        /* JADX WARN: Type inference failed for: r0v20, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r0v22, types: [T, java.lang.String] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            String text;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            CoroutineScopeKt.ensureActive((CoroutineScope) this.c);
            if (k.j(this.d)) {
                this.d.nextTag();
            }
            if (k.h(this.d)) {
                return Unit.INSTANCE;
            }
            if (!k.k(this.d)) {
                throw new XmlPullParserException("iterateCurrentTagEvents call is allowed only for START_TAG event");
            }
            int depth = this.d.getDepth();
            while (this.d.getDepth() >= depth) {
                int depth2 = this.d.getDepth() - depth;
                if (depth2 != 0) {
                    if (depth2 == 1) {
                        k.k(this.d);
                    }
                } else if (k.k(this.d)) {
                    this.e.element = k.b(this.d, "version");
                } else if (k.l(this.d) && (text = this.d.getText()) != null && !StringsKt.isBlank(text)) {
                    String text2 = this.d.getText();
                    Intrinsics.checkNotNullExpressionValue(text2, "getText(...)");
                    this.f.element = StringsKt.trim((CharSequence) text2).toString();
                } else if (k.i(this.d)) {
                    return Unit.INSTANCE;
                }
                this.d.next();
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$e, reason: case insensitive filesystem */
    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", i = {0, 0}, l = {941}, m = "parseAdSystemTag", n = {"name", "version"}, s = {"L$0", "L$1"})
    public static final class C3043e extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2793a;
        public Object b;
        public /* synthetic */ Object c;
        public int d;

        public C3043e(Continuation<? super C3043e> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.d |= Integer.MIN_VALUE;
            return k.z(null, this);
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$f, reason: case insensitive filesystem */
    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt$parseAdTag$$inlined$iterateTag$1", f = "VastParser.kt", i = {0, 1}, l = {126, 127}, m = "invokeSuspend", n = {"initialDepth", "initialDepth"}, s = {"I$0", "I$0"})
    public static final class C3044f extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2794a;
        public int b;
        public /* synthetic */ Object c;
        public final /* synthetic */ XmlPullParser d;
        public final /* synthetic */ Ref.ObjectRef e;
        public final /* synthetic */ Ref.ObjectRef f;
        public final /* synthetic */ Ref.ObjectRef g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C3044f(XmlPullParser xmlPullParser, Continuation continuation, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2, Ref.ObjectRef objectRef3) {
            super(2, continuation);
            this.d = xmlPullParser;
            this.e = objectRef;
            this.f = objectRef2;
            this.g = objectRef3;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C3044f) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C3044f c3044f = new C3044f(this.d, continuation, this.e, this.f, this.g);
            c3044f.c = obj;
            return c3044f;
        }

        /* JADX WARN: Code restructure failed: missing block: B:67:0x00c3, code lost:
        
            r6 = 0;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0065  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x00bc  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x00c2  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x011f  */
        /* JADX WARN: Type inference failed for: r6v1, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r6v10, types: [com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.b$a] */
        /* JADX WARN: Type inference failed for: r6v5 */
        /* JADX WARN: Type inference failed for: r6v6, types: [com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.b$a] */
        /* JADX WARN: Type inference failed for: r6v8 */
        /* JADX WARN: Type inference failed for: r6v9, types: [com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.b$b] */
        /* JADX WARN: Type inference failed for: r9v34, types: [T, java.lang.Integer] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x006e -> B:61:0x0118). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0078 -> B:61:0x0118). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0080 -> B:61:0x0118). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x00b5 -> B:41:0x00b8). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x00ce -> B:61:0x0118). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x00fa -> B:61:0x0118). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x0113 -> B:61:0x0118). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 298
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.C3044f.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$g, reason: case insensitive filesystem */
    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", i = {0, 0, 0}, l = {941}, m = "parseAdTag", n = {"id", "sequence", "adChild"}, s = {"L$0", "L$1", "L$2"})
    public static final class C3045g extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2795a;
        public Object b;
        public Object c;
        public /* synthetic */ Object d;
        public int e;

        public C3045g(Continuation<? super C3045g> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.e |= Integer.MIN_VALUE;
            return k.A(null, this);
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$h, reason: case insensitive filesystem */
    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt$parseCompanionAdsTag$$inlined$iterateTag$1", f = "VastParser.kt", i = {0}, l = {123}, m = "invokeSuspend", n = {"initialDepth"}, s = {"I$0"})
    public static final class C3046h extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2796a;
        public int b;
        public /* synthetic */ Object c;
        public final /* synthetic */ XmlPullParser d;
        public final /* synthetic */ List e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C3046h(XmlPullParser xmlPullParser, Continuation continuation, List list) {
            super(2, continuation);
            this.d = xmlPullParser;
            this.e = list;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C3046h) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C3046h c3046h = new C3046h(this.d, continuation, this.e);
            c3046h.c = obj;
            return c3046h;
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0052  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0083  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x00ce  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x005b -> B:49:0x00c7). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0064 -> B:49:0x00c7). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0072 -> B:49:0x00c7). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x007c -> B:31:0x007f). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x008f -> B:49:0x00c7). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x00a9 -> B:49:0x00c7). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00c2 -> B:49:0x00c7). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 217
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.C3046h.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$i, reason: case insensitive filesystem */
    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", i = {0}, l = {941}, m = "parseCompanionAdsTag", n = {"companions"}, s = {"L$0"})
    public static final class C3047i extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2797a;
        public /* synthetic */ Object b;
        public int c;

        public C3047i(Continuation<? super C3047i> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.c |= Integer.MIN_VALUE;
            return k.B(null, this);
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$j, reason: case insensitive filesystem */
    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt$parseCompanionTag$$inlined$iterateTag$1", f = "VastParser.kt", i = {0, 1, 2, 3, 4, 5, 6, 7}, l = {128, TsExtractor.TS_STREAM_TYPE_HDMV_DTS, 133, 136, 137, 141, 146, 147}, m = "invokeSuspend", n = {"initialDepth", "initialDepth", "initialDepth", "initialDepth", "initialDepth", "initialDepth", "initialDepth", "initialDepth"}, s = {"I$0", "I$0", "I$0", "I$0", "I$0", "I$0", "I$0", "I$0"})
    public static final class C3048j extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2798a;
        public int b;
        public /* synthetic */ Object c;
        public final /* synthetic */ XmlPullParser d;
        public final /* synthetic */ Ref.ObjectRef e;
        public final /* synthetic */ Ref.ObjectRef f;
        public final /* synthetic */ Ref.ObjectRef g;
        public final /* synthetic */ Ref.ObjectRef h;
        public final /* synthetic */ Ref.ObjectRef i;
        public final /* synthetic */ Ref.ObjectRef j;
        public final /* synthetic */ List k;
        public final /* synthetic */ Ref.ObjectRef l;
        public final /* synthetic */ List m;
        public final /* synthetic */ List n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C3048j(XmlPullParser xmlPullParser, Continuation continuation, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2, Ref.ObjectRef objectRef3, Ref.ObjectRef objectRef4, Ref.ObjectRef objectRef5, Ref.ObjectRef objectRef6, List list, Ref.ObjectRef objectRef7, List list2, List list3) {
            super(2, continuation);
            this.d = xmlPullParser;
            this.e = objectRef;
            this.f = objectRef2;
            this.g = objectRef3;
            this.h = objectRef4;
            this.i = objectRef5;
            this.j = objectRef6;
            this.k = list;
            this.l = objectRef7;
            this.m = list2;
            this.n = list3;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C3048j) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C3048j c3048j = new C3048j(this.d, continuation, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n);
            c3048j.c = obj;
            return c3048j;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:138:0x0268, code lost:
        
            r3.element = null;
            r7.h.element = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.b(r8, "apiFramework");
         */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:100:0x01c8  */
        /* JADX WARN: Removed duplicated region for block: B:131:0x026f  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0092  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x00d6  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x00ff  */
        /* JADX WARN: Removed duplicated region for block: B:71:0x013f  */
        /* JADX WARN: Removed duplicated region for block: B:81:0x0176  */
        /* JADX WARN: Type inference failed for: r2v15, types: [T, java.lang.Integer] */
        /* JADX WARN: Type inference failed for: r4v3, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r8v43, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r8v44, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r8v48, types: [T, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r8v50, types: [T, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r8v53, types: [T, java.lang.Object] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:100:0x01c8 -> B:130:0x0268). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:102:0x01da -> B:130:0x0268). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:125:0x024a -> B:130:0x0268). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:127:0x0263 -> B:130:0x0268). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x009d -> B:130:0x0268). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00a7 -> B:130:0x0268). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00af -> B:130:0x0268). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00b5 -> B:130:0x0268). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x00c0 -> B:130:0x0268). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00d4 -> B:130:0x0268). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00d6 -> B:130:0x0268). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x00e8 -> B:130:0x0268). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x00f8 -> B:53:0x00fb). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x010c -> B:130:0x0268). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:64:0x012a -> B:130:0x0268). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:70:0x013d -> B:130:0x0268). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x013f -> B:130:0x0268). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:73:0x0151 -> B:130:0x0268). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:84:0x0189 -> B:130:0x0268). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:86:0x0194 -> B:130:0x0268). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:93:0x01b2 -> B:130:0x0268). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:99:0x01c6 -> B:130:0x0268). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 690
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.C3048j.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$k, reason: collision with other inner class name */
    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {941}, m = "parseCompanionTag", n = {"id", "widthPx", "heightPx", "altText", "apiFramework", "adParameters", "creativeViewTrackingList", "resources", "clickThroughUrl", "clickTrackingList"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9"})
    public static final class C0487k extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2799a;
        public Object b;
        public Object c;
        public Object d;
        public Object e;
        public Object f;
        public Object g;
        public Object h;
        public Object i;
        public Object j;
        public /* synthetic */ Object k;
        public int l;

        public C0487k(Continuation<? super C0487k> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.k = obj;
            this.l |= Integer.MIN_VALUE;
            return k.C(null, this);
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$l, reason: case insensitive filesystem */
    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt$parseCreativeTag$$inlined$iterateTag$1", f = "VastParser.kt", i = {0, 1}, l = {TsExtractor.TS_STREAM_TYPE_AC3, 133}, m = "invokeSuspend", n = {"initialDepth", "initialDepth"}, s = {"I$0", "I$0"})
    public static final class C3049l extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2800a;
        public int b;
        public /* synthetic */ Object c;
        public final /* synthetic */ XmlPullParser d;
        public final /* synthetic */ Ref.ObjectRef e;
        public final /* synthetic */ Ref.ObjectRef f;
        public final /* synthetic */ Ref.ObjectRef g;
        public final /* synthetic */ Ref.ObjectRef h;
        public final /* synthetic */ Ref.ObjectRef i;
        public final /* synthetic */ boolean j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C3049l(XmlPullParser xmlPullParser, Continuation continuation, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2, Ref.ObjectRef objectRef3, Ref.ObjectRef objectRef4, Ref.ObjectRef objectRef5, boolean z) {
            super(2, continuation);
            this.d = xmlPullParser;
            this.e = objectRef;
            this.f = objectRef2;
            this.g = objectRef3;
            this.h = objectRef4;
            this.i = objectRef5;
            this.j = z;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C3049l) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C3049l c3049l = new C3049l(this.d, continuation, this.e, this.f, this.g, this.h, this.i, this.j);
            c3049l.c = obj;
            return c3049l;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0066  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x00a2  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x00c8  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x00cd  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x00d3 A[PHI: r1 r5
  0x00d3: PHI (r1v2 int) = (r1v3 int), (r1v4 int), (r1v7 int) binds: [B:36:0x00a0, B:39:0x00ae, B:48:0x00cb] A[DONT_GENERATE, DONT_INLINE]
  0x00d3: PHI (r5v0 kotlin.jvm.internal.Ref$ObjectRef) = 
  (r5v1 kotlin.jvm.internal.Ref$ObjectRef)
  (r5v7 kotlin.jvm.internal.Ref$ObjectRef)
  (r5v9 kotlin.jvm.internal.Ref$ObjectRef)
 binds: [B:36:0x00a0, B:39:0x00ae, B:48:0x00cb] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:68:0x0144  */
        /* JADX WARN: Type inference failed for: r6v3, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r6v4, types: [T, java.lang.Integer] */
        /* JADX WARN: Type inference failed for: r6v6, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r9v36, types: [T, java.lang.String] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x006f -> B:67:0x013d). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0079 -> B:67:0x013d). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0081 -> B:67:0x013d). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00a2 -> B:51:0x00d4). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00ba -> B:43:0x00bd). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x00d3 -> B:51:0x00d4). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x00df -> B:67:0x013d). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x011f -> B:67:0x013d). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:64:0x0138 -> B:67:0x013d). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 335
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.C3049l.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$m, reason: case insensitive filesystem */
    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", i = {0, 0, 0, 0, 0}, l = {941}, m = "parseCreativeTag", n = {"id", "sequence", "adId", "apiFramework", "child"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
    public static final class C3050m extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2801a;
        public Object b;
        public Object c;
        public Object d;
        public Object e;
        public /* synthetic */ Object f;
        public int g;

        public C3050m(Continuation<? super C3050m> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f = obj;
            this.g |= Integer.MIN_VALUE;
            return k.e(null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$n, reason: case insensitive filesystem */
    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt$parseCreativesTag$$inlined$iterateTag$1", f = "VastParser.kt", i = {0}, l = {123}, m = "invokeSuspend", n = {"initialDepth"}, s = {"I$0"})
    public static final class C3051n extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2802a;
        public int b;
        public /* synthetic */ Object c;
        public final /* synthetic */ XmlPullParser d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ List f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C3051n(XmlPullParser xmlPullParser, Continuation continuation, boolean z, List list) {
            super(2, continuation);
            this.d = xmlPullParser;
            this.e = z;
            this.f = list;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C3051n) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C3051n c3051n = new C3051n(this.d, continuation, this.e, this.f);
            c3051n.c = obj;
            return c3051n;
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0053  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0086  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x00d1  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x005c -> B:49:0x00ca). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0065 -> B:49:0x00ca). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0073 -> B:49:0x00ca). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x007f -> B:31:0x0082). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x0092 -> B:49:0x00ca). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x00ac -> B:49:0x00ca). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00c5 -> B:49:0x00ca). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 220
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.C3051n.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$o, reason: case insensitive filesystem */
    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", i = {0}, l = {941}, m = "parseCreativesTag", n = {"creatives"}, s = {"L$0"})
    public static final class C3052o extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2803a;
        public /* synthetic */ Object b;
        public int c;

        public C3052o(Continuation<? super C3052o> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.c |= Integer.MIN_VALUE;
            return k.f(null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$p, reason: case insensitive filesystem */
    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", i = {}, l = {799}, m = "parseHtmlResourceTag", n = {}, s = {})
    public static final class C3053p extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f2804a;
        public int b;

        public C3053p(Continuation<? super C3053p> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f2804a = obj;
            this.b |= Integer.MIN_VALUE;
            return k.E(null, this);
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$q, reason: case insensitive filesystem */
    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", i = {}, l = {802}, m = "parseIFrameResourceTag", n = {}, s = {})
    public static final class C3054q extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f2805a;
        public int b;

        public C3054q(Continuation<? super C3054q> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f2805a = obj;
            this.b |= Integer.MIN_VALUE;
            return k.F(null, this);
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$r, reason: case insensitive filesystem */
    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt$parseIconClicksTag$$inlined$iterateTag$1", f = "VastParser.kt", i = {0, 1}, l = {123, 124}, m = "invokeSuspend", n = {"initialDepth", "initialDepth"}, s = {"I$0", "I$0"})
    public static final class C3055r extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2806a;
        public int b;
        public /* synthetic */ Object c;
        public final /* synthetic */ XmlPullParser d;
        public final /* synthetic */ Ref.ObjectRef e;
        public final /* synthetic */ List f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C3055r(XmlPullParser xmlPullParser, Continuation continuation, Ref.ObjectRef objectRef, List list) {
            super(2, continuation);
            this.d = xmlPullParser;
            this.e = objectRef;
            this.f = list;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C3055r) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C3055r c3055r = new C3055r(this.d, continuation, this.e, this.f);
            c3055r.c = obj;
            return c3055r;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0060  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x00af  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x00fa  */
        /* JADX WARN: Type inference failed for: r7v37, types: [T, java.lang.Object] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0069 -> B:57:0x00f3). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0073 -> B:57:0x00f3). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x009b -> B:57:0x00f3). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00a8 -> B:39:0x00ab). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00bb -> B:57:0x00f3). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x00d5 -> B:57:0x00f3). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x00ee -> B:57:0x00f3). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 261
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.C3055r.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$s, reason: case insensitive filesystem */
    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", i = {0, 0}, l = {941}, m = "parseIconClicksTag", n = {"clickThroughUrl", "clickTrackingUrlList"}, s = {"L$0", "L$1"})
    public static final class C3056s extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2807a;
        public Object b;
        public /* synthetic */ Object c;
        public int d;

        public C3056s(Continuation<? super C3056s> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.d |= Integer.MIN_VALUE;
            return k.G(null, this);
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$t, reason: case insensitive filesystem */
    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt$parseIconTag$$inlined$iterateTag$1", f = "VastParser.kt", i = {0, 0, 1, 1, 2, 2, 3, 4}, l = {TsExtractor.TS_STREAM_TYPE_HDMV_DTS, 132, 133, 139, 140}, m = "invokeSuspend", n = {"$this$parseIconTag_u24lambda_u2498", "initialDepth", "$this$parseIconTag_u24lambda_u2498", "initialDepth", "$this$parseIconTag_u24lambda_u2498", "initialDepth", "initialDepth", "initialDepth"}, s = {"L$0", "I$0", "L$0", "I$0", "L$0", "I$0", "I$0", "I$0"})
    public static final class C3057t extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2808a;
        public int b;
        public /* synthetic */ Object c;
        public final /* synthetic */ XmlPullParser d;
        public final /* synthetic */ Ref.ObjectRef e;
        public final /* synthetic */ Ref.ObjectRef f;
        public final /* synthetic */ Ref.ObjectRef g;
        public final /* synthetic */ Ref.ObjectRef h;
        public final /* synthetic */ Ref.ObjectRef i;
        public final /* synthetic */ Ref.ObjectRef j;
        public final /* synthetic */ Ref.ObjectRef k;
        public final /* synthetic */ Ref.ObjectRef l;
        public final /* synthetic */ List m;
        public Object n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C3057t(XmlPullParser xmlPullParser, Continuation continuation, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2, Ref.ObjectRef objectRef3, Ref.ObjectRef objectRef4, Ref.ObjectRef objectRef5, Ref.ObjectRef objectRef6, Ref.ObjectRef objectRef7, Ref.ObjectRef objectRef8, List list) {
            super(2, continuation);
            this.d = xmlPullParser;
            this.e = objectRef;
            this.f = objectRef2;
            this.g = objectRef3;
            this.h = objectRef4;
            this.i = objectRef5;
            this.j = objectRef6;
            this.k = objectRef7;
            this.l = objectRef8;
            this.m = list;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C3057t) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C3057t c3057t = new C3057t(this.d, continuation, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m);
            c3057t.c = obj;
            return c3057t;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:119:0x021d  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0098  */
        /* JADX WARN: Removed duplicated region for block: B:53:0x00eb  */
        /* JADX WARN: Removed duplicated region for block: B:61:0x010c  */
        /* JADX WARN: Removed duplicated region for block: B:70:0x012e  */
        /* JADX WARN: Removed duplicated region for block: B:71:0x0134 A[PHI: r1 r8 r9
  0x0134: PHI (r1v3 int) = (r1v4 int), (r1v5 int), (r1v7 int), (r1v8 int), (r1v8 int), (r1v8 int), (r1v8 int), (r1v8 int) binds: [B:69:0x012c, B:60:0x010a, B:52:0x00e9, B:37:0x00b9, B:63:0x0118, B:55:0x00f7, B:43:0x00cc, B:46:0x00d5] A[DONT_GENERATE, DONT_INLINE]
  0x0134: PHI (r8v4 kotlin.jvm.internal.Ref$ObjectRef) = 
  (r8v5 kotlin.jvm.internal.Ref$ObjectRef)
  (r8v6 kotlin.jvm.internal.Ref$ObjectRef)
  (r8v8 kotlin.jvm.internal.Ref$ObjectRef)
  (r8v16 kotlin.jvm.internal.Ref$ObjectRef)
  (r8v16 kotlin.jvm.internal.Ref$ObjectRef)
  (r8v16 kotlin.jvm.internal.Ref$ObjectRef)
  (r8v16 kotlin.jvm.internal.Ref$ObjectRef)
  (r8v16 kotlin.jvm.internal.Ref$ObjectRef)
 binds: [B:69:0x012c, B:60:0x010a, B:52:0x00e9, B:37:0x00b9, B:63:0x0118, B:55:0x00f7, B:43:0x00cc, B:46:0x00d5] A[DONT_GENERATE, DONT_INLINE]
  0x0134: PHI (r9v1 org.xmlpull.v1.XmlPullParser) = 
  (r9v2 org.xmlpull.v1.XmlPullParser)
  (r9v3 org.xmlpull.v1.XmlPullParser)
  (r9v5 org.xmlpull.v1.XmlPullParser)
  (r9v26 org.xmlpull.v1.XmlPullParser)
  (r9v26 org.xmlpull.v1.XmlPullParser)
  (r9v26 org.xmlpull.v1.XmlPullParser)
  (r9v26 org.xmlpull.v1.XmlPullParser)
  (r9v26 org.xmlpull.v1.XmlPullParser)
 binds: [B:69:0x012c, B:60:0x010a, B:52:0x00e9, B:37:0x00b9, B:63:0x0118, B:55:0x00f7, B:43:0x00cc, B:46:0x00d5] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:75:0x0143  */
        /* JADX WARN: Removed duplicated region for block: B:79:0x0158  */
        /* JADX WARN: Removed duplicated region for block: B:86:0x0173  */
        /* JADX WARN: Type inference failed for: r13v17, types: [T, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r13v46, types: [T, java.lang.Long] */
        /* JADX WARN: Type inference failed for: r9v17, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r9v7, types: [T, java.lang.String] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:113:0x01f8 -> B:118:0x0216). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:115:0x0211 -> B:118:0x0216). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00a1 -> B:118:0x0216). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00ab -> B:118:0x0216). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:80:0x015e -> B:118:0x0216). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:82:0x016c -> B:84:0x016f). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 552
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.C3057t.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$u, reason: case insensitive filesystem */
    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {941}, m = "parseIconTag", n = {"program", "widthPx", "heightPx", "apiFramework", TypedValues.CycleType.S_WAVE_OFFSET, "durationMillis", "clicks", "resource", "viewTrackingUrlList"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8"})
    public static final class C3058u extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2809a;
        public Object b;
        public Object c;
        public Object d;
        public Object e;
        public Object f;
        public Object g;
        public Object h;
        public Object i;
        public /* synthetic */ Object j;
        public int k;

        public C3058u(Continuation<? super C3058u> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.j = obj;
            this.k |= Integer.MIN_VALUE;
            return k.H(null, this);
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$v, reason: case insensitive filesystem */
    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt$parseIconsTag$$inlined$iterateTag$1", f = "VastParser.kt", i = {0}, l = {123}, m = "invokeSuspend", n = {"initialDepth"}, s = {"I$0"})
    public static final class C3059v extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2810a;
        public int b;
        public /* synthetic */ Object c;
        public final /* synthetic */ XmlPullParser d;
        public final /* synthetic */ List e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C3059v(XmlPullParser xmlPullParser, Continuation continuation, List list) {
            super(2, continuation);
            this.d = xmlPullParser;
            this.e = list;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C3059v) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C3059v c3059v = new C3059v(this.d, continuation, this.e);
            c3059v.c = obj;
            return c3059v;
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0052  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0083  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x00ce  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x005b -> B:49:0x00c7). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0064 -> B:49:0x00c7). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0072 -> B:49:0x00c7). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x007c -> B:31:0x007f). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x008f -> B:49:0x00c7). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x00a9 -> B:49:0x00c7). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00c2 -> B:49:0x00c7). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 217
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.C3059v.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$w, reason: case insensitive filesystem */
    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", i = {0}, l = {941}, m = "parseIconsTag", n = {"icons"}, s = {"L$0"})
    public static final class C3060w extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2811a;
        public /* synthetic */ Object b;
        public int c;

        public C3060w(Continuation<? super C3060w> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.c |= Integer.MIN_VALUE;
            return k.I(null, this);
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$x, reason: case insensitive filesystem */
    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt$parseImpressionTag$$inlined$iterateTag$1", f = "VastParser.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C3061x extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2812a;
        public int b;
        public /* synthetic */ Object c;
        public final /* synthetic */ XmlPullParser d;
        public final /* synthetic */ Ref.ObjectRef e;
        public final /* synthetic */ Ref.ObjectRef f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C3061x(XmlPullParser xmlPullParser, Continuation continuation, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2) {
            super(2, continuation);
            this.d = xmlPullParser;
            this.e = objectRef;
            this.f = objectRef2;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C3061x) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C3061x c3061x = new C3061x(this.d, continuation, this.e, this.f);
            c3061x.c = obj;
            return c3061x;
        }

        /* JADX WARN: Type inference failed for: r0v20, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r0v22, types: [T, java.lang.String] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            String text;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            CoroutineScopeKt.ensureActive((CoroutineScope) this.c);
            if (k.j(this.d)) {
                this.d.nextTag();
            }
            if (k.h(this.d)) {
                return Unit.INSTANCE;
            }
            if (!k.k(this.d)) {
                throw new XmlPullParserException("iterateCurrentTagEvents call is allowed only for START_TAG event");
            }
            int depth = this.d.getDepth();
            while (this.d.getDepth() >= depth) {
                int depth2 = this.d.getDepth() - depth;
                if (depth2 != 0) {
                    if (depth2 == 1) {
                        k.k(this.d);
                    }
                } else if (k.k(this.d)) {
                    this.e.element = k.b(this.d, "id");
                } else if (k.l(this.d) && (text = this.d.getText()) != null && !StringsKt.isBlank(text)) {
                    String text2 = this.d.getText();
                    Intrinsics.checkNotNullExpressionValue(text2, "getText(...)");
                    this.f.element = StringsKt.trim((CharSequence) text2).toString();
                } else if (k.i(this.d)) {
                    return Unit.INSTANCE;
                }
                this.d.next();
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$y, reason: case insensitive filesystem */
    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", i = {0, 0}, l = {941}, m = "parseImpressionTag", n = {"id", "impressionUrl"}, s = {"L$0", "L$1"})
    public static final class C3062y extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2813a;
        public Object b;
        public /* synthetic */ Object c;
        public int d;

        public C3062y(Continuation<? super C3062y> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.d |= Integer.MIN_VALUE;
            return k.J(null, this);
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$z, reason: case insensitive filesystem */
    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt$parseInLineTag$$inlined$iterateTag$1", f = "VastParser.kt", i = {0, 1, 2, 3, 4, 5, 6, 7}, l = {123, 124, 125, 126, 127, 128, TsExtractor.TS_STREAM_TYPE_HDMV_DTS, 131}, m = "invokeSuspend", n = {"initialDepth", "initialDepth", "initialDepth", "initialDepth", "initialDepth", "initialDepth", "initialDepth", "initialDepth"}, s = {"I$0", "I$0", "I$0", "I$0", "I$0", "I$0", "I$0", "I$0"})
    public static final class C3063z extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2814a;
        public int b;
        public /* synthetic */ Object c;
        public final /* synthetic */ XmlPullParser d;
        public final /* synthetic */ Ref.ObjectRef e;
        public final /* synthetic */ Ref.ObjectRef f;
        public final /* synthetic */ Ref.ObjectRef g;
        public final /* synthetic */ Ref.ObjectRef h;
        public final /* synthetic */ Ref.ObjectRef i;
        public final /* synthetic */ List j;
        public final /* synthetic */ List k;
        public final /* synthetic */ List l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C3063z(XmlPullParser xmlPullParser, Continuation continuation, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2, Ref.ObjectRef objectRef3, Ref.ObjectRef objectRef4, Ref.ObjectRef objectRef5, List list, List list2, List list3) {
            super(2, continuation);
            this.d = xmlPullParser;
            this.e = objectRef;
            this.f = objectRef2;
            this.g = objectRef3;
            this.h = objectRef4;
            this.i = objectRef5;
            this.j = list;
            this.k = list2;
            this.l = list3;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C3063z) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C3063z c3063z = new C3063z(this.d, continuation, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l);
            c3063z.c = obj;
            return c3063z;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:115:0x01fe  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0096  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x00da  */
        /* JADX WARN: Removed duplicated region for block: B:76:0x0157  */
        /* JADX WARN: Type inference failed for: r7v41, types: [T, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r7v42, types: [T, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r7v44, types: [T, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r7v45, types: [T, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r7v46, types: [T, java.lang.Object] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:100:0x01bf -> B:114:0x01f7). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:109:0x01d9 -> B:114:0x01f7). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:111:0x01f2 -> B:114:0x01f7). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00a0 -> B:114:0x01f7). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00aa -> B:114:0x01f7). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00b2 -> B:114:0x01f7). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00b9 -> B:114:0x01f7). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x00c4 -> B:114:0x01f7). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00d8 -> B:114:0x01f7). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00da -> B:114:0x01f7). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x00e7 -> B:114:0x01f7). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x0105 -> B:114:0x01f7). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x0123 -> B:114:0x01f7). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:69:0x0141 -> B:114:0x01f7). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:75:0x0155 -> B:114:0x01f7). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:76:0x0157 -> B:114:0x01f7). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:78:0x0164 -> B:114:0x01f7). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:85:0x0182 -> B:114:0x01f7). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:93:0x019f -> B:114:0x01f7). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:96:0x01ae -> B:98:0x01b1). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 578
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.C3063z.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object A(org.xmlpull.v1.XmlPullParser r12, kotlin.coroutines.Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.C3064a> r13) throws java.lang.Throwable {
        /*
            boolean r0 = r13 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.C3045g
            if (r0 == 0) goto L13
            r0 = r13
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$g r0 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.C3045g) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$g r0 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$g
            r0.<init>(r13)
        L18:
            java.lang.Object r13 = r0.d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.e
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r12 = r0.c
            kotlin.jvm.internal.Ref$ObjectRef r12 = (kotlin.jvm.internal.Ref.ObjectRef) r12
            java.lang.Object r1 = r0.b
            kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref.ObjectRef) r1
            java.lang.Object r0 = r0.f2795a
            kotlin.jvm.internal.Ref$ObjectRef r0 = (kotlin.jvm.internal.Ref.ObjectRef) r0
            kotlin.ResultKt.throwOnFailure(r13)
            goto L6c
        L35:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L3d:
            kotlin.ResultKt.throwOnFailure(r13)
            kotlin.jvm.internal.Ref$ObjectRef r13 = new kotlin.jvm.internal.Ref$ObjectRef
            r13.<init>()
            kotlin.jvm.internal.Ref$ObjectRef r2 = new kotlin.jvm.internal.Ref$ObjectRef
            r2.<init>()
            kotlin.jvm.internal.Ref$ObjectRef r10 = new kotlin.jvm.internal.Ref$ObjectRef
            r10.<init>()
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$f r11 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$f
            r6 = 0
            r4 = r11
            r5 = r12
            r7 = r13
            r8 = r2
            r9 = r10
            r4.<init>(r5, r6, r7, r8, r9)
            r0.f2795a = r13
            r0.b = r2
            r0.c = r10
            r0.e = r3
            java.lang.Object r12 = kotlinx.coroutines.CoroutineScopeKt.coroutineScope(r11, r0)
            if (r12 != r1) goto L69
            return r1
        L69:
            r0 = r13
            r1 = r2
            r12 = r10
        L6c:
            T r12 = r12.element
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.b r12 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.AbstractC3065b) r12
            if (r12 == 0) goto L80
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.a r13 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.a
            T r0 = r0.element
            java.lang.String r0 = (java.lang.String) r0
            T r1 = r1.element
            java.lang.Integer r1 = (java.lang.Integer) r1
            r13.<init>(r0, r1, r12)
            goto L81
        L80:
            r13 = 0
        L81:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.A(org.xmlpull.v1.XmlPullParser, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object B(org.xmlpull.v1.XmlPullParser r5, kotlin.coroutines.Continuation<? super java.util.List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.e>> r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.C3047i
            if (r0 == 0) goto L13
            r0 = r6
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$i r0 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.C3047i) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$i r0 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$i
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.f2797a
            java.util.List r5 = (java.util.List) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L4f
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            kotlin.ResultKt.throwOnFailure(r6)
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$h r2 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$h
            r4 = 0
            r2.<init>(r5, r4, r6)
            r0.f2797a = r6
            r0.c = r3
            java.lang.Object r5 = kotlinx.coroutines.CoroutineScopeKt.coroutineScope(r2, r0)
            if (r5 != r1) goto L4e
            return r1
        L4e:
            r5 = r6
        L4f:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.B(org.xmlpull.v1.XmlPullParser, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object C(org.xmlpull.v1.XmlPullParser r25, kotlin.coroutines.Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.e> r26) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 310
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.C(org.xmlpull.v1.XmlPullParser, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Object D(XmlPullParser xmlPullParser, Continuation<? super String> continuation) {
        return P(xmlPullParser, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object E(org.xmlpull.v1.XmlPullParser r4, kotlin.coroutines.Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.j> r5) throws java.lang.Throwable {
        /*
            boolean r0 = r5 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.C3053p
            if (r0 == 0) goto L13
            r0 = r5
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$p r0 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.C3053p) r0
            int r1 = r0.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.b = r1
            goto L18
        L13:
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$p r0 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$p
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f2804a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.b
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.throwOnFailure(r5)
            goto L3d
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.ResultKt.throwOnFailure(r5)
            r0.b = r3
            java.lang.Object r5 = P(r4, r0)
            if (r5 != r1) goto L3d
            return r1
        L3d:
            java.lang.String r5 = (java.lang.String) r5
            if (r5 == 0) goto L47
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.j r4 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.j
            r4.<init>(r5)
            goto L48
        L47:
            r4 = 0
        L48:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.E(org.xmlpull.v1.XmlPullParser, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object F(org.xmlpull.v1.XmlPullParser r4, kotlin.coroutines.Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.k> r5) throws java.lang.Throwable {
        /*
            boolean r0 = r5 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.C3054q
            if (r0 == 0) goto L13
            r0 = r5
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$q r0 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.C3054q) r0
            int r1 = r0.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.b = r1
            goto L18
        L13:
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$q r0 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$q
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f2805a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.b
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.throwOnFailure(r5)
            goto L3d
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.ResultKt.throwOnFailure(r5)
            r0.b = r3
            java.lang.Object r5 = P(r4, r0)
            if (r5 != r1) goto L3d
            return r1
        L3d:
            java.lang.String r5 = (java.lang.String) r5
            if (r5 == 0) goto L47
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.k r4 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.k
            r4.<init>(r5)
            goto L48
        L47:
            r4 = 0
        L48:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.F(org.xmlpull.v1.XmlPullParser, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object G(org.xmlpull.v1.XmlPullParser r6, kotlin.coroutines.Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.m> r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.C3056s
            if (r0 == 0) goto L13
            r0 = r7
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$s r0 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.C3056s) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$s r0 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$s
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r6 = r0.b
            java.util.List r6 = (java.util.List) r6
            java.lang.Object r0 = r0.f2807a
            kotlin.jvm.internal.Ref$ObjectRef r0 = (kotlin.jvm.internal.Ref.ObjectRef) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L5b
        L32:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3a:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlin.jvm.internal.Ref$ObjectRef r7 = new kotlin.jvm.internal.Ref$ObjectRef
            r7.<init>()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$r r5 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$r
            r5.<init>(r6, r4, r7, r2)
            r0.f2807a = r7
            r0.b = r2
            r0.d = r3
            java.lang.Object r6 = kotlinx.coroutines.CoroutineScopeKt.coroutineScope(r5, r0)
            if (r6 != r1) goto L59
            return r1
        L59:
            r0 = r7
            r6 = r2
        L5b:
            T r7 = r0.element
            java.lang.String r7 = (java.lang.String) r7
            if (r7 == 0) goto L66
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.m r4 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.m
            r4.<init>(r7, r6)
        L66:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.G(org.xmlpull.v1.XmlPullParser, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object H(org.xmlpull.v1.XmlPullParser r24, kotlin.coroutines.Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.l> r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 286
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.H(org.xmlpull.v1.XmlPullParser, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object I(org.xmlpull.v1.XmlPullParser r5, kotlin.coroutines.Continuation<? super java.util.List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.l>> r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.C3060w
            if (r0 == 0) goto L13
            r0 = r6
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$w r0 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.C3060w) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$w r0 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$w
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.f2811a
            java.util.List r5 = (java.util.List) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L4f
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            kotlin.ResultKt.throwOnFailure(r6)
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$v r2 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$v
            r4 = 0
            r2.<init>(r5, r4, r6)
            r0.f2811a = r6
            r0.c = r3
            java.lang.Object r5 = kotlinx.coroutines.CoroutineScopeKt.coroutineScope(r2, r0)
            if (r5 != r1) goto L4e
            return r1
        L4e:
            r5 = r6
        L4f:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.I(org.xmlpull.v1.XmlPullParser, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object J(org.xmlpull.v1.XmlPullParser r6, kotlin.coroutines.Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.n> r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.C3062y
            if (r0 == 0) goto L13
            r0 = r7
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$y r0 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.C3062y) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$y r0 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$y
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r6 = r0.b
            kotlin.jvm.internal.Ref$ObjectRef r6 = (kotlin.jvm.internal.Ref.ObjectRef) r6
            java.lang.Object r0 = r0.f2813a
            kotlin.jvm.internal.Ref$ObjectRef r0 = (kotlin.jvm.internal.Ref.ObjectRef) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L5b
        L32:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3a:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlin.jvm.internal.Ref$ObjectRef r7 = new kotlin.jvm.internal.Ref$ObjectRef
            r7.<init>()
            kotlin.jvm.internal.Ref$ObjectRef r2 = new kotlin.jvm.internal.Ref$ObjectRef
            r2.<init>()
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$x r5 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$x
            r5.<init>(r6, r4, r7, r2)
            r0.f2813a = r7
            r0.b = r2
            r0.d = r3
            java.lang.Object r6 = kotlinx.coroutines.CoroutineScopeKt.coroutineScope(r5, r0)
            if (r6 != r1) goto L59
            return r1
        L59:
            r0 = r7
            r6 = r2
        L5b:
            T r6 = r6.element
            java.lang.String r6 = (java.lang.String) r6
            if (r6 == 0) goto L6a
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.n r4 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.n
            T r7 = r0.element
            java.lang.String r7 = (java.lang.String) r7
            r4.<init>(r7, r6)
        L6a:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.J(org.xmlpull.v1.XmlPullParser, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object K(org.xmlpull.v1.XmlPullParser r20, kotlin.coroutines.Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.o> r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 243
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.K(org.xmlpull.v1.XmlPullParser, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object L(org.xmlpull.v1.XmlPullParser r31, kotlin.coroutines.Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.q> r32) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 391
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.L(org.xmlpull.v1.XmlPullParser, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object M(org.xmlpull.v1.XmlPullParser r5, kotlin.coroutines.Continuation<? super java.util.List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.q>> r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.G
            if (r0 == 0) goto L13
            r0 = r6
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$G r0 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.G) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$G r0 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$G
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.f2769a
            java.util.List r5 = (java.util.List) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L4f
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            kotlin.ResultKt.throwOnFailure(r6)
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$F r2 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$F
            r4 = 0
            r2.<init>(r5, r4, r6)
            r0.f2769a = r6
            r0.c = r3
            java.lang.Object r5 = kotlinx.coroutines.CoroutineScopeKt.coroutineScope(r2, r0)
            if (r5 != r1) goto L4e
            return r1
        L4e:
            r5 = r6
        L4f:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.M(org.xmlpull.v1.XmlPullParser, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object N(org.xmlpull.v1.XmlPullParser r6, kotlin.coroutines.Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.s> r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.I
            if (r0 == 0) goto L13
            r0 = r7
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$I r0 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.I) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$I r0 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$I
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r6 = r0.b
            kotlin.jvm.internal.Ref$ObjectRef r6 = (kotlin.jvm.internal.Ref.ObjectRef) r6
            java.lang.Object r0 = r0.f2771a
            kotlin.jvm.internal.Ref$ObjectRef r0 = (kotlin.jvm.internal.Ref.ObjectRef) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L5b
        L32:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3a:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlin.jvm.internal.Ref$ObjectRef r7 = new kotlin.jvm.internal.Ref$ObjectRef
            r7.<init>()
            kotlin.jvm.internal.Ref$ObjectRef r2 = new kotlin.jvm.internal.Ref$ObjectRef
            r2.<init>()
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$H r5 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$H
            r5.<init>(r6, r4, r7, r2)
            r0.f2771a = r7
            r0.b = r2
            r0.d = r3
            java.lang.Object r6 = kotlinx.coroutines.CoroutineScopeKt.coroutineScope(r5, r0)
            if (r6 != r1) goto L59
            return r1
        L59:
            r0 = r7
            r6 = r2
        L5b:
            T r7 = r0.element
            if (r7 != 0) goto L64
            T r7 = r6.element
            if (r7 != 0) goto L64
            goto L71
        L64:
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.s r4 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.s
            T r7 = r0.element
            java.lang.String r7 = (java.lang.String) r7
            T r6 = r6.element
            java.lang.String r6 = (java.lang.String) r6
            r4.<init>(r7, r6)
        L71:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.N(org.xmlpull.v1.XmlPullParser, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object O(org.xmlpull.v1.XmlPullParser r6, kotlin.coroutines.Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.t> r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.K
            if (r0 == 0) goto L13
            r0 = r7
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$K r0 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.K) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$K r0 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$K
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r6 = r0.b
            kotlin.jvm.internal.Ref$ObjectRef r6 = (kotlin.jvm.internal.Ref.ObjectRef) r6
            java.lang.Object r0 = r0.f2773a
            kotlin.jvm.internal.Ref$ObjectRef r0 = (kotlin.jvm.internal.Ref.ObjectRef) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L5b
        L32:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3a:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlin.jvm.internal.Ref$ObjectRef r7 = new kotlin.jvm.internal.Ref$ObjectRef
            r7.<init>()
            kotlin.jvm.internal.Ref$ObjectRef r2 = new kotlin.jvm.internal.Ref$ObjectRef
            r2.<init>()
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$J r5 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$J
            r5.<init>(r6, r4, r2, r7)
            r0.f2773a = r7
            r0.b = r2
            r0.d = r3
            java.lang.Object r6 = kotlinx.coroutines.CoroutineScopeKt.coroutineScope(r5, r0)
            if (r6 != r1) goto L59
            return r1
        L59:
            r0 = r7
            r6 = r2
        L5b:
            T r7 = r0.element
            if (r7 == 0) goto L77
            T r7 = r6.element
            if (r7 != 0) goto L64
            goto L77
        L64:
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.t r4 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.t
            T r7 = r0.element
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            java.lang.String r7 = (java.lang.String) r7
            T r6 = r6.element
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.i r6 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.i) r6
            r4.<init>(r7, r6)
        L77:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.O(org.xmlpull.v1.XmlPullParser, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object P(org.xmlpull.v1.XmlPullParser r5, kotlin.coroutines.Continuation<? super java.lang.String> r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.M
            if (r0 == 0) goto L13
            r0 = r6
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$M r0 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.M) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$M r0 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$M
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.f2775a
            kotlin.jvm.internal.Ref$ObjectRef r5 = (kotlin.jvm.internal.Ref.ObjectRef) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L4f
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.jvm.internal.Ref$ObjectRef r6 = new kotlin.jvm.internal.Ref$ObjectRef
            r6.<init>()
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$L r2 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$L
            r4 = 0
            r2.<init>(r5, r4, r6)
            r0.f2775a = r6
            r0.c = r3
            java.lang.Object r5 = kotlinx.coroutines.CoroutineScopeKt.coroutineScope(r2, r0)
            if (r5 != r1) goto L4e
            return r1
        L4e:
            r5 = r6
        L4f:
            T r5 = r5.element
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.P(org.xmlpull.v1.XmlPullParser, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object Q(org.xmlpull.v1.XmlPullParser r5, kotlin.coroutines.Continuation<? super java.util.List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.u>> r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.O
            if (r0 == 0) goto L13
            r0 = r6
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$O r0 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.O) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$O r0 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$O
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.f2777a
            java.util.List r5 = (java.util.List) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L4f
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            kotlin.ResultKt.throwOnFailure(r6)
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$N r2 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$N
            r4 = 0
            r2.<init>(r5, r4, r6)
            r0.f2777a = r6
            r0.c = r3
            java.lang.Object r5 = kotlinx.coroutines.CoroutineScopeKt.coroutineScope(r2, r0)
            if (r5 != r1) goto L4e
            return r1
        L4e:
            r5 = r6
        L4f:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.Q(org.xmlpull.v1.XmlPullParser, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object R(org.xmlpull.v1.XmlPullParser r12, kotlin.coroutines.Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.u> r13) throws java.lang.Throwable {
        /*
            boolean r0 = r13 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.Q
            if (r0 == 0) goto L13
            r0 = r13
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$Q r0 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.Q) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$Q r0 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$Q
            r0.<init>(r13)
        L18:
            java.lang.Object r13 = r0.d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.e
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r12 = r0.c
            kotlin.jvm.internal.Ref$ObjectRef r12 = (kotlin.jvm.internal.Ref.ObjectRef) r12
            java.lang.Object r1 = r0.b
            kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref.ObjectRef) r1
            java.lang.Object r0 = r0.f2779a
            kotlin.jvm.internal.Ref$ObjectRef r0 = (kotlin.jvm.internal.Ref.ObjectRef) r0
            kotlin.ResultKt.throwOnFailure(r13)
            goto L6c
        L35:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L3d:
            kotlin.ResultKt.throwOnFailure(r13)
            kotlin.jvm.internal.Ref$ObjectRef r13 = new kotlin.jvm.internal.Ref$ObjectRef
            r13.<init>()
            kotlin.jvm.internal.Ref$ObjectRef r2 = new kotlin.jvm.internal.Ref$ObjectRef
            r2.<init>()
            kotlin.jvm.internal.Ref$ObjectRef r10 = new kotlin.jvm.internal.Ref$ObjectRef
            r10.<init>()
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$P r11 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$P
            r6 = 0
            r4 = r11
            r5 = r12
            r7 = r13
            r8 = r10
            r9 = r2
            r4.<init>(r5, r6, r7, r8, r9)
            r0.f2779a = r13
            r0.b = r2
            r0.c = r10
            r0.e = r3
            java.lang.Object r12 = kotlinx.coroutines.CoroutineScopeKt.coroutineScope(r11, r0)
            if (r12 != r1) goto L69
            return r1
        L69:
            r0 = r13
            r1 = r2
            r12 = r10
        L6c:
            T r13 = r0.element
            if (r13 == 0) goto L95
            T r2 = r1.element
            if (r2 == 0) goto L95
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.v r2 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.v.n
            if (r13 != r2) goto L7d
            T r13 = r12.element
            if (r13 != 0) goto L7d
            goto L95
        L7d:
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.u r13 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.u
            T r0 = r0.element
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.v r0 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.v) r0
            T r1 = r1.element
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            java.lang.String r1 = (java.lang.String) r1
            T r12 = r12.element
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.r r12 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.r) r12
            r13.<init>(r0, r1, r12)
            goto L96
        L95:
            r13 = 0
        L96:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.R(org.xmlpull.v1.XmlPullParser, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Object S(XmlPullParser xmlPullParser, Continuation<? super w> continuation) {
        return BuildersKt.withContext(com.moloco.sdk.internal.scheduling.b.a().getIo(), new R(xmlPullParser, null), continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object T(org.xmlpull.v1.XmlPullParser r12, kotlin.coroutines.Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.w> r13) throws java.lang.Throwable {
        /*
            boolean r0 = r13 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.T
            if (r0 == 0) goto L13
            r0 = r13
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$T r0 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.T) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$T r0 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$T
            r0.<init>(r13)
        L18:
            java.lang.Object r13 = r0.d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.e
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r12 = r0.c
            kotlin.jvm.internal.Ref$ObjectRef r12 = (kotlin.jvm.internal.Ref.ObjectRef) r12
            java.lang.Object r1 = r0.b
            kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref.ObjectRef) r1
            java.lang.Object r0 = r0.f2782a
            java.util.List r0 = (java.util.List) r0
            kotlin.ResultKt.throwOnFailure(r13)
            goto L6c
        L35:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L3d:
            kotlin.ResultKt.throwOnFailure(r13)
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            kotlin.jvm.internal.Ref$ObjectRef r2 = new kotlin.jvm.internal.Ref$ObjectRef
            r2.<init>()
            kotlin.jvm.internal.Ref$ObjectRef r10 = new kotlin.jvm.internal.Ref$ObjectRef
            r10.<init>()
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$S r11 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$S
            r6 = 0
            r4 = r11
            r5 = r12
            r7 = r2
            r8 = r10
            r9 = r13
            r4.<init>(r5, r6, r7, r8, r9)
            r0.f2782a = r13
            r0.b = r2
            r0.c = r10
            r0.e = r3
            java.lang.Object r12 = kotlinx.coroutines.CoroutineScopeKt.coroutineScope(r11, r0)
            if (r12 != r1) goto L69
            return r1
        L69:
            r0 = r13
            r1 = r2
            r12 = r10
        L6c:
            boolean r13 = r0.isEmpty()
            if (r13 == 0) goto L78
            T r13 = r12.element
            if (r13 != 0) goto L78
            r12 = 0
            goto L86
        L78:
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.w r13 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.w
            T r12 = r12.element
            java.lang.String r12 = (java.lang.String) r12
            T r1 = r1.element
            java.lang.String r1 = (java.lang.String) r1
            r13.<init>(r0, r12, r1)
            r12 = r13
        L86:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.T(org.xmlpull.v1.XmlPullParser, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object U(org.xmlpull.v1.XmlPullParser r6, kotlin.coroutines.Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.z> r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.V
            if (r0 == 0) goto L13
            r0 = r7
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$V r0 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.V) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$V r0 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$V
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r6 = r0.b
            kotlin.jvm.internal.Ref$ObjectRef r6 = (kotlin.jvm.internal.Ref.ObjectRef) r6
            java.lang.Object r0 = r0.f2784a
            kotlin.jvm.internal.Ref$ObjectRef r0 = (kotlin.jvm.internal.Ref.ObjectRef) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L5b
        L32:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3a:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlin.jvm.internal.Ref$ObjectRef r7 = new kotlin.jvm.internal.Ref$ObjectRef
            r7.<init>()
            kotlin.jvm.internal.Ref$ObjectRef r2 = new kotlin.jvm.internal.Ref$ObjectRef
            r2.<init>()
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$U r5 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$U
            r5.<init>(r6, r4, r7, r2)
            r0.f2784a = r7
            r0.b = r2
            r0.d = r3
            java.lang.Object r6 = kotlinx.coroutines.CoroutineScopeKt.coroutineScope(r5, r0)
            if (r6 != r1) goto L59
            return r1
        L59:
            r0 = r7
            r6 = r2
        L5b:
            T r6 = r6.element
            java.lang.String r6 = (java.lang.String) r6
            if (r6 == 0) goto L6a
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.z r4 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.z
            T r7 = r0.element
            java.lang.String r7 = (java.lang.String) r7
            r4.<init>(r7, r6)
        L6a:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.U(org.xmlpull.v1.XmlPullParser, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object V(org.xmlpull.v1.XmlPullParser r17, kotlin.coroutines.Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.B> r18) throws java.lang.Throwable {
        /*
            r0 = r18
            boolean r1 = r0 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.Z
            if (r1 == 0) goto L15
            r1 = r0
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$Z r1 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.Z) r1
            int r2 = r1.h
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.h = r2
            goto L1a
        L15:
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$Z r1 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$Z
            r1.<init>(r0)
        L1a:
            java.lang.Object r0 = r1.g
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.h
            r4 = 1
            if (r3 == 0) goto L4e
            if (r3 != r4) goto L46
            java.lang.Object r2 = r1.f
            java.util.List r2 = (java.util.List) r2
            java.lang.Object r3 = r1.e
            java.util.List r3 = (java.util.List) r3
            java.lang.Object r4 = r1.d
            java.util.List r4 = (java.util.List) r4
            java.lang.Object r5 = r1.c
            kotlin.jvm.internal.Ref$ObjectRef r5 = (kotlin.jvm.internal.Ref.ObjectRef) r5
            java.lang.Object r6 = r1.b
            kotlin.jvm.internal.Ref$ObjectRef r6 = (kotlin.jvm.internal.Ref.ObjectRef) r6
            java.lang.Object r1 = r1.f2788a
            kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref.ObjectRef) r1
            kotlin.ResultKt.throwOnFailure(r0)
            r8 = r2
            r7 = r3
            r15 = r4
            goto La3
        L46:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L4e:
            kotlin.ResultKt.throwOnFailure(r0)
            kotlin.jvm.internal.Ref$ObjectRef r0 = new kotlin.jvm.internal.Ref$ObjectRef
            r0.<init>()
            kotlin.jvm.internal.Ref$ObjectRef r3 = new kotlin.jvm.internal.Ref$ObjectRef
            r3.<init>()
            kotlin.jvm.internal.Ref$ObjectRef r14 = new kotlin.jvm.internal.Ref$ObjectRef
            r14.<init>()
            java.util.ArrayList r15 = new java.util.ArrayList
            r15.<init>()
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$Y r11 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$Y
            r7 = 0
            r5 = r11
            r6 = r17
            r8 = r3
            r9 = r0
            r10 = r14
            r16 = r11
            r11 = r15
            r17 = r12
            r12 = r13
            r4 = r13
            r13 = r17
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13)
            r1.f2788a = r0
            r1.b = r3
            r1.c = r14
            r1.d = r15
            r1.e = r4
            r5 = r17
            r1.f = r5
            r6 = 1
            r1.h = r6
            r6 = r16
            java.lang.Object r1 = kotlinx.coroutines.CoroutineScopeKt.coroutineScope(r6, r1)
            if (r1 != r2) goto L9e
            return r2
        L9e:
            r1 = r0
            r6 = r3
            r7 = r4
            r8 = r5
            r5 = r14
        La3:
            T r0 = r1.element
            r3 = r0
            java.lang.String r3 = (java.lang.String) r3
            if (r3 == 0) goto Lbc
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.B r0 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.B
            T r1 = r6.element
            r4 = r1
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            T r1 = r5.element
            r5 = r1
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.d r5 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.d) r5
            r2 = r0
            r6 = r15
            r2.<init>(r3, r4, r5, r6, r7, r8)
            goto Lbd
        Lbc:
            r0 = 0
        Lbd:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.V(org.xmlpull.v1.XmlPullParser, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ void d() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object y(org.xmlpull.v1.XmlPullParser r6, kotlin.coroutines.Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.c> r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.C3041c
            if (r0 == 0) goto L13
            r0 = r7
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$c r0 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.C3041c) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$c r0 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$c
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r6 = r0.b
            kotlin.jvm.internal.Ref$ObjectRef r6 = (kotlin.jvm.internal.Ref.ObjectRef) r6
            java.lang.Object r0 = r0.f2791a
            kotlin.jvm.internal.Ref$ObjectRef r0 = (kotlin.jvm.internal.Ref.ObjectRef) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L5b
        L32:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3a:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlin.jvm.internal.Ref$ObjectRef r7 = new kotlin.jvm.internal.Ref$ObjectRef
            r7.<init>()
            kotlin.jvm.internal.Ref$ObjectRef r2 = new kotlin.jvm.internal.Ref$ObjectRef
            r2.<init>()
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$b r5 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$b
            r5.<init>(r6, r4, r2, r7)
            r0.f2791a = r7
            r0.b = r2
            r0.d = r3
            java.lang.Object r6 = kotlinx.coroutines.CoroutineScopeKt.coroutineScope(r5, r0)
            if (r6 != r1) goto L59
            return r1
        L59:
            r0 = r7
            r6 = r2
        L5b:
            T r7 = r0.element
            java.lang.String r7 = (java.lang.String) r7
            if (r7 == 0) goto L6a
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.c r4 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.c
            T r6 = r6.element
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            r4.<init>(r7, r6)
        L6a:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.y(org.xmlpull.v1.XmlPullParser, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object z(org.xmlpull.v1.XmlPullParser r6, kotlin.coroutines.Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.d> r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.C3043e
            if (r0 == 0) goto L13
            r0 = r7
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$e r0 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.C3043e) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$e r0 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$e
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r6 = r0.b
            kotlin.jvm.internal.Ref$ObjectRef r6 = (kotlin.jvm.internal.Ref.ObjectRef) r6
            java.lang.Object r0 = r0.f2793a
            kotlin.jvm.internal.Ref$ObjectRef r0 = (kotlin.jvm.internal.Ref.ObjectRef) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L5b
        L32:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3a:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlin.jvm.internal.Ref$ObjectRef r7 = new kotlin.jvm.internal.Ref$ObjectRef
            r7.<init>()
            kotlin.jvm.internal.Ref$ObjectRef r2 = new kotlin.jvm.internal.Ref$ObjectRef
            r2.<init>()
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$d r5 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$d
            r5.<init>(r6, r4, r2, r7)
            r0.f2793a = r7
            r0.b = r2
            r0.d = r3
            java.lang.Object r6 = kotlinx.coroutines.CoroutineScopeKt.coroutineScope(r5, r0)
            if (r6 != r1) goto L59
            return r1
        L59:
            r0 = r7
            r6 = r2
        L5b:
            T r7 = r0.element
            if (r7 != 0) goto L64
            T r7 = r6.element
            if (r7 != 0) goto L64
            goto L71
        L64:
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.d r4 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.d
            T r7 = r0.element
            java.lang.String r7 = (java.lang.String) r7
            T r6 = r6.element
            java.lang.String r6 = (java.lang.String) r6
            r4.<init>(r7, r6)
        L71:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.z(org.xmlpull.v1.XmlPullParser, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final boolean h(XmlPullParser xmlPullParser) {
        return xmlPullParser.getEventType() == 1;
    }

    public static final boolean i(XmlPullParser xmlPullParser) {
        return xmlPullParser.getEventType() == 3;
    }

    public static final boolean j(XmlPullParser xmlPullParser) {
        return xmlPullParser.getEventType() == 0;
    }

    public static final boolean k(XmlPullParser xmlPullParser) {
        return xmlPullParser.getEventType() == 2;
    }

    public static final boolean l(XmlPullParser xmlPullParser) {
        return xmlPullParser.getEventType() == 4;
    }

    public static final Integer m(XmlPullParser xmlPullParser) {
        String strB = b(xmlPullParser, "sequence");
        if (strB == null) {
            return null;
        }
        Integer intOrNull = StringsKt.toIntOrNull(strB);
        return Integer.valueOf(intOrNull != null ? intOrNull.intValue() : 999);
    }

    public static final r n(XmlPullParser xmlPullParser) {
        String strB = b(xmlPullParser, "skipoffset");
        if (strB != null) {
            return g(strB);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object e(org.xmlpull.v1.XmlPullParser r17, boolean r18, kotlin.coroutines.Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.g> r19) throws java.lang.Throwable {
        /*
            r0 = r19
            boolean r1 = r0 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.C3050m
            if (r1 == 0) goto L15
            r1 = r0
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$m r1 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.C3050m) r1
            int r2 = r1.g
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.g = r2
            goto L1a
        L15:
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$m r1 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$m
            r1.<init>(r0)
        L1a:
            java.lang.Object r0 = r1.f
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.g
            r4 = 1
            if (r3 == 0) goto L47
            if (r3 != r4) goto L3f
            java.lang.Object r2 = r1.e
            kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref.ObjectRef) r2
            java.lang.Object r3 = r1.d
            kotlin.jvm.internal.Ref$ObjectRef r3 = (kotlin.jvm.internal.Ref.ObjectRef) r3
            java.lang.Object r4 = r1.c
            kotlin.jvm.internal.Ref$ObjectRef r4 = (kotlin.jvm.internal.Ref.ObjectRef) r4
            java.lang.Object r5 = r1.b
            kotlin.jvm.internal.Ref$ObjectRef r5 = (kotlin.jvm.internal.Ref.ObjectRef) r5
            java.lang.Object r1 = r1.f2801a
            kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref.ObjectRef) r1
            kotlin.ResultKt.throwOnFailure(r0)
            goto L91
        L3f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L47:
            kotlin.ResultKt.throwOnFailure(r0)
            kotlin.jvm.internal.Ref$ObjectRef r0 = new kotlin.jvm.internal.Ref$ObjectRef
            r0.<init>()
            kotlin.jvm.internal.Ref$ObjectRef r3 = new kotlin.jvm.internal.Ref$ObjectRef
            r3.<init>()
            kotlin.jvm.internal.Ref$ObjectRef r14 = new kotlin.jvm.internal.Ref$ObjectRef
            r14.<init>()
            kotlin.jvm.internal.Ref$ObjectRef r15 = new kotlin.jvm.internal.Ref$ObjectRef
            r15.<init>()
            kotlin.jvm.internal.Ref$ObjectRef r13 = new kotlin.jvm.internal.Ref$ObjectRef
            r13.<init>()
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$l r12 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$l
            r7 = 0
            r5 = r12
            r6 = r17
            r8 = r0
            r9 = r3
            r10 = r14
            r11 = r15
            r16 = r12
            r12 = r13
            r4 = r13
            r13 = r18
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13)
            r1.f2801a = r0
            r1.b = r3
            r1.c = r14
            r1.d = r15
            r1.e = r4
            r5 = 1
            r1.g = r5
            r5 = r16
            java.lang.Object r1 = kotlinx.coroutines.CoroutineScopeKt.coroutineScope(r5, r1)
            if (r1 != r2) goto L8c
            return r2
        L8c:
            r1 = r0
            r5 = r3
            r2 = r4
            r4 = r14
            r3 = r15
        L91:
            T r0 = r2.element
            r11 = r0
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.h r11 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.h) r11
            if (r11 == 0) goto Lb3
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.g r0 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.g
            T r1 = r1.element
            r7 = r1
            java.lang.String r7 = (java.lang.String) r7
            T r1 = r5.element
            r8 = r1
            java.lang.Integer r8 = (java.lang.Integer) r8
            T r1 = r4.element
            r9 = r1
            java.lang.String r9 = (java.lang.String) r9
            T r1 = r3.element
            r10 = r1
            java.lang.String r10 = (java.lang.String) r10
            r6 = r0
            r6.<init>(r7, r8, r9, r10, r11)
            goto Lb4
        Lb3:
            r0 = 0
        Lb4:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.e(org.xmlpull.v1.XmlPullParser, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object f(org.xmlpull.v1.XmlPullParser r5, boolean r6, kotlin.coroutines.Continuation<? super java.util.List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.g>> r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.C3052o
            if (r0 == 0) goto L13
            r0 = r7
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$o r0 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.C3052o) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$o r0 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$o
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.f2803a
            java.util.List r5 = (java.util.List) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L4f
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            kotlin.ResultKt.throwOnFailure(r7)
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$n r2 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$n
            r4 = 0
            r2.<init>(r5, r4, r6, r7)
            r0.f2803a = r7
            r0.c = r3
            java.lang.Object r5 = kotlinx.coroutines.CoroutineScopeKt.coroutineScope(r2, r0)
            if (r5 != r1) goto L4e
            return r1
        L4e:
            r5 = r7
        L4f:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.f(org.xmlpull.v1.XmlPullParser, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object g(org.xmlpull.v1.XmlPullParser r19, boolean r20, kotlin.coroutines.Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.p> r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 240
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.g(org.xmlpull.v1.XmlPullParser, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Integer h(String str) {
        Object objM7415constructorimpl;
        Integer numValueOf;
        int iIntValue;
        try {
            Result.Companion companion = Result.INSTANCE;
            Number number = b.parse(str);
            if (number == null || (iIntValue = (numValueOf = Integer.valueOf((int) (number.floatValue() * 100))).intValue()) < 0 || iIntValue >= 101) {
                numValueOf = null;
            }
            objM7415constructorimpl = Result.m7415constructorimpl(numValueOf);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        return (Integer) (Result.m7421isFailureimpl(objM7415constructorimpl) ? null : objM7415constructorimpl);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final v i(String str) {
        switch (str.hashCode()) {
            case -1638835128:
                if (str.equals("midpoint")) {
                    return v.d;
                }
                return null;
            case -1337830390:
                if (str.equals("thirdQuartile")) {
                    return v.e;
                }
                return null;
            case -1001078227:
                if (str.equals("progress")) {
                    return v.n;
                }
                return null;
            case -934426579:
                if (str.equals("resume")) {
                    return v.k;
                }
                return null;
            case -934318917:
                if (str.equals("rewind")) {
                    return v.j;
                }
                return null;
            case -840405966:
                if (str.equals("unmute")) {
                    return v.h;
                }
                return null;
            case -599445191:
                if (str.equals("complete")) {
                    return v.f;
                }
                return null;
            case -37683395:
                if (str.equals("closeLinear")) {
                    return v.l;
                }
                return null;
            case 3363353:
                if (str.equals("mute")) {
                    return v.g;
                }
                return null;
            case 3532159:
                if (str.equals("skip")) {
                    return v.m;
                }
                return null;
            case 106440182:
                if (str.equals("pause")) {
                    return v.i;
                }
                return null;
            case 109757538:
                if (str.equals(TtmlNode.START)) {
                    return v.b;
                }
                return null;
            case 560220243:
                if (str.equals("firstQuartile")) {
                    return v.c;
                }
                return null;
            case 1778167540:
                if (str.equals("creativeView")) {
                    return v.f2840a;
                }
                return null;
            default:
                return null;
        }
    }

    public static final i b() {
        return c();
    }

    public static final j c() {
        return (j) f2762a.getValue();
    }

    public static final j a() {
        return new j();
    }

    public static final String b(XmlPullParser xmlPullParser, String str) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        if (attributeValue == null || !(!StringsKt.isBlank(attributeValue))) {
            return null;
        }
        return attributeValue;
    }

    public static final Object a(XmlPullParser xmlPullParser, Function2<? super XmlPullParser, ? super Continuation<? super Unit>, ? extends Object> function2, Function3<? super XmlPullParser, ? super String, ? super Continuation<? super Unit>, ? extends Object> function3, Function2<? super XmlPullParser, ? super Continuation<? super Unit>, ? extends Object> function22, Continuation<? super Unit> continuation) {
        C3039a c3039a = new C3039a(xmlPullParser, function2, function3, function22, null);
        InlineMarker.mark(0);
        CoroutineScopeKt.coroutineScope(c3039a, continuation);
        InlineMarker.mark(1);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object h(org.xmlpull.v1.XmlPullParser r12, boolean r13, kotlin.coroutines.Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.A> r14) throws java.lang.Throwable {
        /*
            boolean r0 = r14 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.X
            if (r0 == 0) goto L13
            r0 = r14
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$X r0 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.X) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f = r1
            goto L18
        L13:
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$X r0 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$X
            r0.<init>(r14)
        L18:
            java.lang.Object r14 = r0.e
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f
            r3 = 1
            if (r2 == 0) goto L3f
            if (r2 != r3) goto L37
            boolean r13 = r0.f2786a
            java.lang.Object r12 = r0.d
            java.util.List r12 = (java.util.List) r12
            java.lang.Object r1 = r0.c
            java.util.List r1 = (java.util.List) r1
            java.lang.Object r0 = r0.b
            kotlin.jvm.internal.Ref$ObjectRef r0 = (kotlin.jvm.internal.Ref.ObjectRef) r0
            kotlin.ResultKt.throwOnFailure(r14)
            goto L70
        L37:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L3f:
            kotlin.ResultKt.throwOnFailure(r14)
            kotlin.jvm.internal.Ref$ObjectRef r14 = new kotlin.jvm.internal.Ref$ObjectRef
            r14.<init>()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$W r11 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k$W
            r6 = 0
            r4 = r11
            r5 = r12
            r7 = r14
            r8 = r2
            r9 = r10
            r4.<init>(r5, r6, r7, r8, r9)
            r0.b = r14
            r0.c = r2
            r0.d = r10
            r0.f2786a = r13
            r0.f = r3
            java.lang.Object r12 = kotlinx.coroutines.CoroutineScopeKt.coroutineScope(r11, r0)
            if (r12 != r1) goto L6d
            return r1
        L6d:
            r0 = r14
            r1 = r2
            r12 = r10
        L70:
            if (r13 == 0) goto L78
            T r13 = r0.element
            if (r13 != 0) goto L78
            r12 = 0
            goto L82
        L78:
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.A r13 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.A
            T r14 = r0.element
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.z r14 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.z) r14
            r13.<init>(r14, r1, r12)
            r12 = r13
        L82:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.h(org.xmlpull.v1.XmlPullParser, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final r g(String str) {
        Long lF = f(str);
        if (lF != null) {
            return new r.b(lF.longValue());
        }
        Integer numH = h(str);
        if (numH != null) {
            return new r.a(numH.intValue());
        }
        return null;
    }

    public static final SimpleDateFormat e() {
        return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.J.a("HH:mm:ss.SSS");
    }

    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.i e(String str) {
        if (StringsKt.startsWith(str, "image/", true)) {
            return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.i.f2827a;
        }
        if (StringsKt.contains((CharSequence) str, (CharSequence) "javascript", true)) {
            return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.i.b;
        }
        return null;
    }

    public static final Long f(String str) {
        Object objM7415constructorimpl;
        Object objM7415constructorimpl2;
        try {
            Result.Companion companion = Result.INSTANCE;
            Date date = e().parse(str);
            objM7415constructorimpl = Result.m7415constructorimpl(date != null ? Long.valueOf(date.getTime()) : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m7421isFailureimpl(objM7415constructorimpl)) {
            objM7415constructorimpl = null;
        }
        Long l2 = (Long) objM7415constructorimpl;
        if (l2 != null) {
            return l2;
        }
        try {
            Result.Companion companion3 = Result.INSTANCE;
            Date date2 = f().parse(str);
            objM7415constructorimpl2 = Result.m7415constructorimpl(date2 != null ? Long.valueOf(date2.getTime()) : null);
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.INSTANCE;
            objM7415constructorimpl2 = Result.m7415constructorimpl(ResultKt.createFailure(th2));
        }
        return (Long) (Result.m7421isFailureimpl(objM7415constructorimpl2) ? null : objM7415constructorimpl2);
    }

    public static final SimpleDateFormat f() {
        return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.J.a("HH:mm:ss");
    }
}
