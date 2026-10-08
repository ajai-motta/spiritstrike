package com.hive.base;

import android.content.Context;
import android.util.Log;
import androidx.startup.Initializer;
import com.hive.HiveActivity;
import com.hive.HiveSdkLifecycle;
import com.hive.analytics.AnalyticsReferrerSender;
import com.hive.auth.AuthImpl;
import com.hive.authv4.AuthV4Impl;
import com.hive.base.HiveInitializer;
import com.hive.base.Property;
import com.hive.core.HiveCoreInitializer;
import com.hive.module.HiveModuleManager;
import com.hive.social.SocialHiveImpl;
import com.hive.socialv4.SocialV4Impl;
import com.hive.standalone.HiveLifecycle;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00010\f0\u000bH\u0016R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/hive/base/HiveInitializer;", "Landroidx/startup/Initializer;", "<init>", "()V", "TAG", "", "kotlin.jvm.PlatformType", "create", "context", "Landroid/content/Context;", "dependencies", "", "Ljava/lang/Class;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HiveInitializer implements Initializer<HiveInitializer> {
    private final String TAG = "HiveInitializer";

    /* JADX INFO: renamed from: com.hive.base.HiveInitializer$create$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.base.HiveInitializer$create$1", f = "HiveInitializer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        int label;
        final /* synthetic */ HiveInitializer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Context context, HiveInitializer hiveInitializer, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$context = context;
            this.this$0 = hiveInitializer;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$0(HiveInitializer hiveInitializer, String str) {
            if (str != null && !StringsKt.isBlank(str)) {
                Log.d(hiveInitializer.TAG, "Save referrer.");
                Property.Companion companion = Property.INSTANCE;
                Property.setValue$default(companion.getINSTANCE(), PropertyKeys.INSTALL_REFERRER, str, null, 4, null);
                Property.setValue$default(companion.getINSTANCE(), PropertyKeys.IS_SENT_REFERRER, "false", null, 4, null);
                Property.setValue$default(companion.getINSTANCE(), PropertyKeys.IS_SENT_REFERRER_TO_THIRD_PARTY, "false", null, 4, null);
                companion.getINSTANCE().writeProperties();
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$context, this.this$0, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            AnalyticsReferrerSender analyticsReferrerSender = AnalyticsReferrerSender.INSTANCE;
            Context context = this.$context;
            final HiveInitializer hiveInitializer = this.this$0;
            analyticsReferrerSender.playServiceReferrerStart(context, new Function1() { // from class: com.hive.base.HiveInitializer$create$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return HiveInitializer.AnonymousClass1.invokeSuspend$lambda$0(hiveInitializer, (String) obj2);
                }
            });
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Override // androidx.startup.Initializer
    public List<Class<? extends Initializer<?>>> dependencies() {
        return CollectionsKt.listOf(HiveCoreInitializer.class);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.startup.Initializer
    public HiveInitializer create(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        HiveSdkLifecycle hiveSdkLifecycle = HiveSdkLifecycle.INSTANCE;
        HiveActivity.registerHiveActivityLifecycleListeners(hiveSdkLifecycle);
        HiveLifecycle.registerHiveLifecycleListeners(hiveSdkLifecycle);
        HiveModuleManager hiveModuleManager = HiveModuleManager.INSTANCE;
        hiveModuleManager.discover(AuthImpl.INSTANCE);
        hiveModuleManager.discover(AuthV4Impl.INSTANCE);
        hiveModuleManager.discover(SocialHiveImpl.INSTANCE);
        hiveModuleManager.discover(SocialV4Impl.INSTANCE);
        Log.i(this.TAG, this.TAG + "  initialization successful");
        String value = Property.INSTANCE.getINSTANCE().getValue(PropertyKeys.INSTALL_REFERRER);
        if (value != null && !StringsKt.isBlank(value)) {
            Log.d(this.TAG, "Already have referrer.");
            return this;
        }
        Log.d(this.TAG, "No referrer yet. Call playServiceReferrerStart()");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new AnonymousClass1(context, this, null), 3, null);
        return this;
    }
}
