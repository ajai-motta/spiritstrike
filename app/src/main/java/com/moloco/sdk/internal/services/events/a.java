package com.moloco.sdk.internal.services.events;

import com.moloco.sdk.UserIntent;
import com.moloco.sdk.internal.services.A;
import com.moloco.sdk.internal.services.B;
import com.moloco.sdk.internal.services.C3009j;
import com.moloco.sdk.internal.services.E;
import com.moloco.sdk.internal.services.F;
import com.moloco.sdk.internal.services.InterfaceC3003d;
import com.moloco.sdk.internal.services.InterfaceC3010k;
import com.moloco.sdk.internal.services.usertracker.f;
import com.moloco.sdk.internal.services.x;
import com.moloco.sdk.internal.services.y;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class a implements com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a {
    public static final int j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC3010k f2346a;
    public final B b;
    public final y c;
    public final F d;
    public final f e;
    public final InterfaceC3003d f;
    public final com.moloco.sdk.internal.services.proto.a g;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.core.services.c h;
    public final String i;

    /* JADX INFO: renamed from: com.moloco.sdk.internal.services.events.a$a, reason: collision with other inner class name */
    @DebugMetadata(c = "com.moloco.sdk.internal.services.events.CustomUserEventBuilderServiceImpl", f = "CustomUserEventBuilderServiceImpl.kt", i = {0, 0, 0, 0}, l = {67}, m = "userAdInteractionExt", n = {"this", "interaction", "$this$userAdInteractionExt_u24lambda_u240", "eventTimestamp"}, s = {"L$0", "L$1", "L$3", "J$0"})
    public static final class C0409a extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2347a;
        public Object b;
        public Object c;
        public Object d;
        public Object e;
        public long f;
        public /* synthetic */ Object g;
        public int i;

        public C0409a(Continuation<? super C0409a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.g = obj;
            this.i |= Integer.MIN_VALUE;
            return a.this.a(0L, (a.AbstractC0526a) null, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.services.events.CustomUserEventBuilderServiceImpl", f = "CustomUserEventBuilderServiceImpl.kt", i = {0}, l = {52}, m = "userAdInteractionExtAsQueryParameter", n = {"url"}, s = {"L$0"})
    public static final class b extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2348a;
        public /* synthetic */ Object b;
        public int d;

        public b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return a.this.a(0L, (a.AbstractC0526a) null, (String) null, this);
        }
    }

    public a(InterfaceC3010k appInfoService, B networkInfoService, y deviceInfoService, F screenInfoService, f userIdentifierService, InterfaceC3003d adDataService, com.moloco.sdk.internal.services.proto.a encoderService, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.c userEventConfigService, String sdkVersion) {
        Intrinsics.checkNotNullParameter(appInfoService, "appInfoService");
        Intrinsics.checkNotNullParameter(networkInfoService, "networkInfoService");
        Intrinsics.checkNotNullParameter(deviceInfoService, "deviceInfoService");
        Intrinsics.checkNotNullParameter(screenInfoService, "screenInfoService");
        Intrinsics.checkNotNullParameter(userIdentifierService, "userIdentifierService");
        Intrinsics.checkNotNullParameter(adDataService, "adDataService");
        Intrinsics.checkNotNullParameter(encoderService, "encoderService");
        Intrinsics.checkNotNullParameter(userEventConfigService, "userEventConfigService");
        Intrinsics.checkNotNullParameter(sdkVersion, "sdkVersion");
        this.f2346a = appInfoService;
        this.b = networkInfoService;
        this.c = deviceInfoService;
        this.d = screenInfoService;
        this.e = userIdentifierService;
        this.f = adDataService;
        this.g = encoderService;
        this.h = userEventConfigService;
        this.i = sdkVersion;
    }

    public final InterfaceC3010k b() {
        return this.f2346a;
    }

    public final y c() {
        return this.c;
    }

    public final com.moloco.sdk.internal.services.proto.a d() {
        return this.g;
    }

    public final B e() {
        return this.b;
    }

    public final F f() {
        return this.d;
    }

    public final String g() {
        return this.i;
    }

    public final com.moloco.sdk.xenoss.sdkdevkit.android.core.services.c h() {
        return this.h;
    }

    public final f i() {
        return this.e;
    }

    public final InterfaceC3003d a() {
        return this.f;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object a(long r11, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0526a r13, java.lang.String r14, kotlin.coroutines.Continuation<? super java.lang.String> r15) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r15 instanceof com.moloco.sdk.internal.services.events.a.b
            if (r0 == 0) goto L13
            r0 = r15
            com.moloco.sdk.internal.services.events.a$b r0 = (com.moloco.sdk.internal.services.events.a.b) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            com.moloco.sdk.internal.services.events.a$b r0 = new com.moloco.sdk.internal.services.events.a$b
            r0.<init>(r15)
        L18:
            java.lang.Object r15 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r11 = r0.f2348a
            r14 = r11
            java.lang.String r14 = (java.lang.String) r14
            kotlin.ResultKt.throwOnFailure(r15)
            goto L59
        L2e:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L36:
            kotlin.ResultKt.throwOnFailure(r15)
            com.moloco.sdk.xenoss.sdkdevkit.android.core.services.c r15 = r10.h
            boolean r15 = r15.c()
            if (r15 != 0) goto L4e
            com.moloco.sdk.internal.MolocoLogger r4 = com.moloco.sdk.internal.MolocoLogger.INSTANCE
            r8 = 4
            r9 = 0
            java.lang.String r5 = "CustomUserEventBuilderServiceImpl"
            java.lang.String r6 = "Event reporting config disabled, UserAdInteractionExt not reporting"
            r7 = 0
            com.moloco.sdk.internal.MolocoLogger.debug$default(r4, r5, r6, r7, r8, r9)
            return r14
        L4e:
            r0.f2348a = r14
            r0.d = r3
            java.lang.Object r15 = r10.a(r11, r13, r0)
            if (r15 != r1) goto L59
            return r1
        L59:
            java.lang.String r15 = (java.lang.String) r15
            android.net.Uri r11 = android.net.Uri.parse(r14)
            android.net.Uri$Builder r11 = r11.buildUpon()
            java.lang.String r12 = "user_ad_interaction_ext"
            android.net.Uri$Builder r11 = r11.appendQueryParameter(r12, r15)
            android.net.Uri r11 = r11.build()
            java.lang.String r11 = r11.toString()
            java.lang.String r12 = "toString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r12)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.services.events.a.a(long, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a$a, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(long r8, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0526a r10, kotlin.coroutines.Continuation<? super java.lang.String> r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 264
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.services.events.a.a(long, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a$a, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final UserIntent.UserAdInteractionExt.Builder a(UserIntent.UserAdInteractionExt.Builder builder) {
        UserIntent.UserAdInteractionExt.MolocoSDK.Builder builderNewBuilder = UserIntent.UserAdInteractionExt.MolocoSDK.newBuilder();
        builderNewBuilder.setCoreVer(this.i);
        builder.setSdk(builderNewBuilder.build());
        return builder;
    }

    public final UserIntent.UserAdInteractionExt.Builder a(UserIntent.UserAdInteractionExt.Builder builder, x xVar) {
        UserIntent.UserAdInteractionExt.Device.Builder builderNewBuilder = UserIntent.UserAdInteractionExt.Device.newBuilder();
        builderNewBuilder.setOsVer(xVar.x());
        builderNewBuilder.setModel(xVar.v());
        builderNewBuilder.setOs(UserIntent.UserAdInteractionExt.Device.OsType.ANDROID);
        builderNewBuilder.setScreenScale(xVar.y());
        builder.setDevice(builderNewBuilder.build());
        return builder;
    }

    public final UserIntent.UserAdInteractionExt.Builder a(UserIntent.UserAdInteractionExt.Builder builder, A a2) {
        UserIntent.UserAdInteractionExt.Network.Builder builderNewBuilder = UserIntent.UserAdInteractionExt.Network.newBuilder();
        if (a2 instanceof A.a) {
            builderNewBuilder.setConnectionType(UserIntent.UserAdInteractionExt.Network.ConnectionType.CELLULAR);
            builderNewBuilder.setCarrier(((A.a) a2).a());
        } else if (Intrinsics.areEqual(a2, A.b.b)) {
            builderNewBuilder.setConnectionType(UserIntent.UserAdInteractionExt.Network.ConnectionType.UNKNOWN);
        } else if (Intrinsics.areEqual(a2, A.c.b)) {
            builderNewBuilder.setConnectionType(UserIntent.UserAdInteractionExt.Network.ConnectionType.WIFI);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        builder.setNetwork(builderNewBuilder.build());
        return builder;
    }

    public final UserIntent.UserAdInteractionExt.Builder a(UserIntent.UserAdInteractionExt.Builder builder, C3009j c3009j) {
        UserIntent.UserAdInteractionExt.App.Builder builderNewBuilder = UserIntent.UserAdInteractionExt.App.newBuilder();
        builderNewBuilder.setId(c3009j.b());
        builderNewBuilder.setVer(c3009j.c());
        builder.setApp(builderNewBuilder.build());
        return builder;
    }

    public final UserIntent.UserAdInteractionExt.Builder a(UserIntent.UserAdInteractionExt.Builder builder, a.AbstractC0526a abstractC0526a, E e) {
        if (abstractC0526a instanceof a.AbstractC0526a.e) {
            builder.setImpInteraction(UserIntent.UserAdInteractionExt.ImpressionInteraction.newBuilder().build());
        } else if (abstractC0526a instanceof a.AbstractC0526a.d) {
            UserIntent.UserAdInteractionExt.ClickInteraction.Builder builderNewBuilder = UserIntent.UserAdInteractionExt.ClickInteraction.newBuilder();
            a.AbstractC0526a.d dVar = (a.AbstractC0526a.d) abstractC0526a;
            builderNewBuilder.setClickPos(com.moloco.sdk.internal.services.events.b.a(dVar.b()));
            builderNewBuilder.setScreenSize(com.moloco.sdk.internal.services.events.b.a(e));
            a.AbstractC0526a.g gVarD = dVar.d();
            if (gVarD != null) {
                builderNewBuilder.setViewSize(com.moloco.sdk.internal.services.events.b.a(gVarD));
            }
            a.AbstractC0526a.f fVarC = dVar.c();
            if (fVarC != null) {
                builderNewBuilder.setViewPos(com.moloco.sdk.internal.services.events.b.a(fVarC));
            }
            List<a.AbstractC0526a.c> listA = dVar.a();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listA, 10));
            for (a.AbstractC0526a.c cVar : listA) {
                UserIntent.UserAdInteractionExt.Button.Builder builderNewBuilder2 = UserIntent.UserAdInteractionExt.Button.newBuilder();
                builderNewBuilder2.setType(com.moloco.sdk.internal.services.events.b.a(cVar.d()));
                builderNewBuilder2.setPos(com.moloco.sdk.internal.services.events.b.a(cVar.e()));
                builderNewBuilder2.setSize(com.moloco.sdk.internal.services.events.b.a(cVar.f()));
                arrayList.add(builderNewBuilder2.build());
            }
            builderNewBuilder.addAllButtons(arrayList);
            builder.setClickInteraction((UserIntent.UserAdInteractionExt.ClickInteraction) builderNewBuilder.build());
        } else if (abstractC0526a instanceof a.AbstractC0526a.b) {
            UserIntent.UserAdInteractionExt.AppForegroundingInteraction.Builder builderNewBuilder3 = UserIntent.UserAdInteractionExt.AppForegroundingInteraction.newBuilder();
            builderNewBuilder3.setBgTsMs(((a.AbstractC0526a.b) abstractC0526a).b());
            builder.setAppForegroundingInteraction(builderNewBuilder3.build());
        } else if (abstractC0526a instanceof a.AbstractC0526a.C0527a) {
            builder.setAppBackgroundingInteraction(UserIntent.UserAdInteractionExt.AppBackgroundingInteraction.newBuilder().build());
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return builder;
    }
}
