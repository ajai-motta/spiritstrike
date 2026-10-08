package com.hive.push.local;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.hive.core.HiveCoreInitializer;
import com.hive.logger.LoggerImpl;
import com.hive.push.PushConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/hive/push/local/LocalPushReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "TAG", "", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LocalPushReceiver extends BroadcastReceiver {
    private final String TAG = "LocalPushReceiver";

    /* JADX INFO: renamed from: com.hive.push.local.LocalPushReceiver$onReceive$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.push.local.LocalPushReceiver$onReceive$2", f = "LocalPushReceiver.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Intent $intent;
        final /* synthetic */ Context $localContext;
        int label;
        final /* synthetic */ LocalPushReceiver this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Intent intent, Context context, LocalPushReceiver localPushReceiver, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$intent = intent;
            this.$localContext = context;
            this.this$0 = localPushReceiver;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$intent, this.$localContext, this.this$0, continuation);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [T, android.content.Intent] */
        /* JADX WARN: Type inference failed for: r1v2, types: [T, android.content.Intent] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            Object objClone = this.$intent.clone();
            Intrinsics.checkNotNull(objClone, "null cannot be cast to non-null type android.content.Intent");
            ?? r0 = (Intent) objClone;
            objectRef.element = r0;
            if (r0 != 0) {
                r0.putExtra("isRemotePush", false);
            }
            PushConfig pushConfig = PushConfig.INSTANCE;
            Context context = this.$localContext;
            Intrinsics.checkNotNull(context);
            ?? receiveData = pushConfig.setReceiveData(context, (Intent) objectRef.element);
            objectRef.element = receiveData;
            if (receiveData == 0) {
                LoggerImpl.INSTANCE.w(this.this$0.TAG, "Push intent is null");
                return Unit.INSTANCE;
            }
            if (!receiveData.getBooleanExtra("isLocalPushOperation", true)) {
                return Unit.INSTANCE;
            }
            LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
            loggerImpl.i(this.this$0.TAG, "setPushType");
            Context context2 = this.$localContext;
            Intrinsics.checkNotNull(context2);
            pushConfig.setPushType(context2, (Intent) objectRef.element);
            String stringExtra = ((Intent) objectRef.element).getStringExtra("broadcastAction");
            if (stringExtra != null) {
                LocalPushReceiver localPushReceiver = this.this$0;
                Context context3 = this.$localContext;
                if (!StringsKt.isBlank(stringExtra)) {
                    loggerImpl.i(localPushReceiver.TAG, "start broadcasting");
                    Intent intent = new Intent(stringExtra);
                    intent.putExtras((Intent) objectRef.element);
                    loggerImpl.i(localPushReceiver.TAG, "context.getPackageName() : " + context3.getPackageName());
                    context3.sendBroadcast(intent);
                }
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Context applicationContext;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        HiveCoreInitializer.Companion companion = HiveCoreInitializer.INSTANCE;
        if (companion.isInitContextInitialized()) {
            applicationContext = companion.getInitContext();
        } else {
            applicationContext = context.getApplicationContext();
            companion.setInitContext(applicationContext);
        }
        LoggerImpl.INSTANCE.i(this.TAG, "Local RECEIVE Receive");
        Bundle extras = intent.getExtras();
        if (extras != null) {
            int i = extras.getInt("noticeID");
            PushResourceHandler pushResourceHandler = PushResourceHandler.INSTANCE;
            Intrinsics.checkNotNull(applicationContext);
            pushResourceHandler.remove(applicationContext, i);
        }
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new AnonymousClass2(intent, applicationContext, this, null), 3, null);
    }
}
