package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.handlers;

import com.facebook.share.internal.ShareConstants;
import com.moloco.sdk.internal.MolocoLogger;
import java.util.Set;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public final class g implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.a {
    public static final int d = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f2666a;
    public final MutableSharedFlow<a> b;
    public final MutableSharedFlow<a> c;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class a {
        public static final C0465a b;
        public static final a c = new a(ShareConstants.VIDEO_URL, 0, "videoContainer");
        public static final a d = new a("MRAID", 1, "mraidContainer");
        public static final a e = new a("STATIC", 2, "staticContainer");
        public static final /* synthetic */ a[] f;
        public static final /* synthetic */ EnumEntries g;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f2667a;

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.handlers.g$a$a, reason: collision with other inner class name */
        public static final class C0465a {
            public /* synthetic */ C0465a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final a a(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                for (a aVar : a.values()) {
                    if (Intrinsics.areEqual(aVar.c(), value)) {
                        return aVar;
                    }
                }
                return null;
            }

            public C0465a() {
            }
        }

        static {
            a[] aVarArrA = a();
            f = aVarArrA;
            g = EnumEntriesKt.enumEntries(aVarArrA);
            b = new C0465a(null);
        }

        public a(String str, int i, String str2) {
            this.f2667a = str2;
        }

        public static final /* synthetic */ a[] a() {
            return new a[]{c, d, e};
        }

        public static EnumEntries<a> b() {
            return g;
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) f.clone();
        }

        public final String c() {
            return this.f2667a;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.handlers.PlayListItemDisplayingEventHandler$handleEvent$1", f = "PlayListItemDisplayingEventHandler.kt", i = {}, l = {34}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2668a;
        public final /* synthetic */ a c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a aVar, Continuation<? super b> continuation) {
            super(2, continuation);
            this.c = aVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return g.this.new b(this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f2668a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MutableSharedFlow mutableSharedFlow = g.this.b;
                a aVar = this.c;
                this.f2668a = 1;
                if (mutableSharedFlow.emit(aVar, this) == coroutine_suspended) {
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

    public g() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.a
    public String b() {
        return "PlayListItemDisplayingEventHandler";
    }

    public final MutableSharedFlow<a> c() {
        return this.c;
    }

    public g(CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.f2666a = scope;
        MutableSharedFlow<a> mutableSharedFlowMutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.b = mutableSharedFlowMutableSharedFlow$default;
        this.c = mutableSharedFlowMutableSharedFlow$default;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.a
    public Set<String> a() {
        return SetsKt.setOf("playlistItemDisplaying");
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.a
    public void a(JSONObject event) throws JSONException {
        Intrinsics.checkNotNullParameter(event, "event");
        MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
        MolocoLogger.debug$default(molocoLogger, b(), event + " displaying.", false, 4, null);
        if (!Intrinsics.areEqual(event.getString("event"), CollectionsKt.first(a()))) {
            MolocoLogger.debug$default(molocoLogger, b(), "Event not supported: " + event.getString("event"), false, 4, null);
            return;
        }
        String string = event.getString("creativeType");
        a.C0465a c0465a = a.b;
        Intrinsics.checkNotNull(string);
        a aVarA = c0465a.a(string);
        MolocoLogger.debug$default(molocoLogger, b(), aVarA + " displaying.", false, 4, null);
        if (aVarA != null) {
            BuildersKt__Builders_commonKt.launch$default(this.f2666a, null, null, new b(aVarA, null), 3, null);
        }
    }

    public /* synthetic */ g(CoroutineScope coroutineScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()) : coroutineScope);
    }
}
