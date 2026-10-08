package com.hive.authv4.devicemanagement;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.autofill.HintConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.Logger;
import com.hive.ResultAPI;
import com.hive.authv4.devicemanagement.DeviceManagement;
import com.hive.authv4.devicemanagement.serviceflow.C1_DeviceManagementInfo;
import com.hive.authv4.devicemanagement.ui.model.DeviceInfo;
import com.hive.base.Android;
import com.hive.core.Configuration;
import com.hive.core.Crypto;
import com.hive.core.Property;
import com.hive.core.PropertyManager;
import com.hive.core.StringUtil;
import com.hive.module.ModuleCheckName;
import com.hive.module.interfaces.authv4.DeviceManagement;
import com.hive.protocol.authv4.DeviceGet;
import com.hive.standalone.HiveLifecycle;
import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import io.ktor.sse.ServerSentEventKt;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: DeviceManagement.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010%\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JT\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00120\u001dH\u0016J~\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010 \u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00052.\u0010\u001c\u001a*\u0012\u0004\u0012\u00020\u001e\u0012\u0006\u0012\u0004\u0018\u00010\"\u0012\f\u0012\n\u0012\u0004\u0012\u00020$\u0018\u00010#\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00120!H\u0002JC\u0010&\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182!\u0010\u001c\u001a\u001d\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0004\u0012\u00020\u00120\u001dH\u0016J\u0015\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0000¢\u0006\u0002\b.J\r\u0010/\u001a\u00020\u0018H\u0000¢\u0006\u0002\b0J\b\u00101\u001a\u00020\u0005H\u0002J\u0010\u00102\u001a\u00020\u00182\u0006\u00103\u001a\u00020\u0005H\u0002J\b\u00104\u001a\u00020\u0012H\u0002J\u0012\u00105\u001a\u00020\u00182\b\u00106\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u00107\u001a\u00020\u00122\b\u00106\u001a\u0004\u0018\u00010\u0005H\u0002J\u000f\u00108\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0002\u00109J\b\u0010:\u001a\u00020%H\u0002J\u0014\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050<H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\u0010¨\u0006="}, d2 = {"Lcom/hive/authv4/devicemanagement/DeviceManagement;", "Lcom/hive/module/interfaces/authv4/DeviceManagement;", "<init>", "()V", "DEVICE_MGT_SUBSCRIPTION_GUIDE_DONE", "", "DEVICE_MGT_APP_VERSION", "DEVICE_MGT_FLAG", "key", "getKey", "()Ljava/lang/String;", "key$delegate", "Lkotlin/Lazy;", "mySeq", "getMySeq$hive_authv4_device_management_release", "setMySeq$hive_authv4_device_management_release", "(Ljava/lang/String;)V", "checkDevice", "", "activity", "Landroid/app/Activity;", "account", "Lcom/hive/standalone/HiveLifecycle$HiveAccount;", "disableSubscriptionGuide", "", "phoneCode", HintConstants.AUTOFILL_HINT_PHONE_NUMBER, InAppPurchaseMetaData.KEY_SIGNATURE, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function1;", "Lcom/hive/ResultAPI;", "innerCheckDevice", "isShowApi", "Lkotlin/Function4;", "Lcom/hive/protocol/authv4/DeviceGet$DeviceGetResponse;", "", "Lcom/hive/authv4/devicemanagement/ui/model/DeviceInfo;", "", "show", "Lkotlin/ParameterName;", "name", "result", "getHiveLocaleDateFormat", "Ljava/text/DateFormat;", "context", "Landroid/content/Context;", "getHiveLocaleDateFormat$hive_authv4_device_management_release", "hideCustomerSupport", "hideCustomerSupport$hive_authv4_device_management_release", "getDeviceKey", "verifyKey", "oldKey", "removeKey", "isSubscriptionGuideDoneUser", "id", "joinSubscriptionGuideDoneUser", "getMgtFlag", "()Ljava/lang/Boolean;", "getMgtCount", "getVersionInfo", "", "hive-authv4-device-management_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DeviceManagement implements com.hive.module.interfaces.authv4.DeviceManagement {
    private static final String DEVICE_MGT_APP_VERSION = "authv4.device_mgt_app_version";
    private static final String DEVICE_MGT_FLAG = "authv4.device_mgt_flag";
    private static final String DEVICE_MGT_SUBSCRIPTION_GUIDE_DONE = "authv4.device_mgt_subscription_guide_done";
    public static final DeviceManagement INSTANCE = new DeviceManagement();

    /* JADX INFO: renamed from: key$delegate, reason: from kotlin metadata */
    private static final Lazy key = LazyKt.lazy(new Function0() { // from class: com.hive.authv4.devicemanagement.DeviceManagement$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return DeviceManagement.key_delegate$lambda$0();
        }
    });
    private static String mySeq;

    private DeviceManagement() {
    }

    @Override // com.hive.module.interfaces.authv4.DeviceManagement, com.hive.module.HiveModule
    public String getHiveModuleName() {
        return DeviceManagement.DefaultImpls.getHiveModuleName(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String key_delegate$lambda$0() {
        return INSTANCE.getDeviceKey();
    }

    public final String getKey() {
        return (String) key.getValue();
    }

    public final String getMySeq$hive_authv4_device_management_release() {
        return mySeq;
    }

    public final void setMySeq$hive_authv4_device_management_release(String str) {
        mySeq = str;
    }

    @Override // com.hive.module.interfaces.authv4.DeviceManagement
    public void checkDevice(Activity activity, HiveLifecycle.HiveAccount account, boolean disableSubscriptionGuide, String phoneCode, String phoneNumber, String signature, final Function1<? super ResultAPI, Unit> listener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(listener, "listener");
        innerCheckDevice(activity, account, false, disableSubscriptionGuide, phoneCode, phoneNumber, signature, new Function4() { // from class: com.hive.authv4.devicemanagement.DeviceManagement$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return DeviceManagement.checkDevice$lambda$1(listener, (ResultAPI) obj, (DeviceGet.DeviceGetResponse) obj2, (List) obj3, ((Integer) obj4).intValue());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkDevice$lambda$1(Function1 function1, ResultAPI result, DeviceGet.DeviceGetResponse deviceGetResponse, List list, int i) {
        Intrinsics.checkNotNullParameter(result, "result");
        function1.invoke(result);
        return Unit.INSTANCE;
    }

    static /* synthetic */ void innerCheckDevice$default(DeviceManagement deviceManagement, Activity activity, HiveLifecycle.HiveAccount hiveAccount, boolean z, boolean z2, String str, String str2, String str3, Function4 function4, int i, Object obj) {
        deviceManagement.innerCheckDevice(activity, hiveAccount, z, z2, (i & 16) != 0 ? null : str, (i & 32) != 0 ? null : str2, (i & 64) != 0 ? null : str3, function4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void innerCheckDevice(Activity activity, HiveLifecycle.HiveAccount account, boolean isShowApi, boolean disableSubscriptionGuide, String phoneCode, String phoneNumber, String signature, Function4<? super ResultAPI, ? super DeviceGet.DeviceGetResponse, ? super List<DeviceInfo>, ? super Integer, Unit> listener) {
        Logger.i("[DeviceManagement] CheckDevice " + account + "\nsignature: " + signature);
        if ((account != null ? account.getVid() : null) != null && account.getVidSession() != null) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(account, activity, signature, disableSubscriptionGuide, isShowApi, phoneCode, phoneNumber, listener, null), 3, null);
        } else {
            listener.invoke(new ResultAPI(-1, ResultAPI.Code.AuthV4NeedSignIn), null, null, 1);
        }
    }

    /* JADX INFO: renamed from: com.hive.authv4.devicemanagement.DeviceManagement$innerCheckDevice$1, reason: invalid class name */
    /* JADX INFO: compiled from: DeviceManagement.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.authv4.devicemanagement.DeviceManagement$innerCheckDevice$1", f = "DeviceManagement.kt", i = {2}, l = {94, 98, 111, 118, 142}, m = "invokeSuspend", n = {"getAsync"}, s = {"L$0"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ HiveLifecycle.HiveAccount $account;
        final /* synthetic */ Activity $activity;
        final /* synthetic */ boolean $disableSubscriptionGuide;
        final /* synthetic */ boolean $isShowApi;
        final /* synthetic */ Function4<ResultAPI, DeviceGet.DeviceGetResponse, List<DeviceInfo>, Integer, Unit> $listener;
        final /* synthetic */ String $phoneCode;
        final /* synthetic */ String $phoneNumber;
        final /* synthetic */ String $signature;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(HiveLifecycle.HiveAccount hiveAccount, Activity activity, String str, boolean z, boolean z2, String str2, String str3, Function4<? super ResultAPI, ? super DeviceGet.DeviceGetResponse, ? super List<DeviceInfo>, ? super Integer, Unit> function4, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$account = hiveAccount;
            this.$activity = activity;
            this.$signature = str;
            this.$disableSubscriptionGuide = z;
            this.$isShowApi = z2;
            this.$phoneCode = str2;
            this.$phoneNumber = str3;
            this.$listener = function4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$account, this.$activity, this.$signature, this.$disableSubscriptionGuide, this.$isShowApi, this.$phoneCode, this.$phoneNumber, this.$listener, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:38:0x00ec  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x00f1  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x0102 A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r19) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 722
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hive.authv4.devicemanagement.DeviceManagement.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: renamed from: com.hive.authv4.devicemanagement.DeviceManagement$innerCheckDevice$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: DeviceManagement.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.hive.authv4.devicemanagement.DeviceManagement$innerCheckDevice$1$1", f = "DeviceManagement.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C03521 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function4<ResultAPI, DeviceGet.DeviceGetResponse, List<DeviceInfo>, Integer, Unit> $listener;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C03521(Function4<? super ResultAPI, ? super DeviceGet.DeviceGetResponse, ? super List<DeviceInfo>, ? super Integer, Unit> function4, Continuation<? super C03521> continuation) {
                super(2, continuation);
                this.$listener = function4;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C03521(this.$listener, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C03521) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$listener.invoke(new ResultAPI(), null, null, Boxing.boxInt(1));
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: com.hive.authv4.devicemanagement.DeviceManagement$innerCheckDevice$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: DeviceManagement.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.hive.authv4.devicemanagement.DeviceManagement$innerCheckDevice$1$2", f = "DeviceManagement.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function4<ResultAPI, DeviceGet.DeviceGetResponse, List<DeviceInfo>, Integer, Unit> $listener;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass2(Function4<? super ResultAPI, ? super DeviceGet.DeviceGetResponse, ? super List<DeviceInfo>, ? super Integer, Unit> function4, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.$listener = function4;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.$listener, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$listener.invoke(new ResultAPI(-8, ResultAPI.Code.AuthV4ServerResponseError), null, null, Boxing.boxInt(1));
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: com.hive.authv4.devicemanagement.DeviceManagement$innerCheckDevice$1$4, reason: invalid class name */
        /* JADX INFO: compiled from: DeviceManagement.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.hive.authv4.devicemanagement.DeviceManagement$innerCheckDevice$1$4", f = "DeviceManagement.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ List<DeviceInfo> $deviceInfoList;
            final /* synthetic */ Function4<ResultAPI, DeviceGet.DeviceGetResponse, List<DeviceInfo>, Integer, Unit> $listener;
            final /* synthetic */ DeviceGet.DeviceGetResponse $response;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass4(Function4<? super ResultAPI, ? super DeviceGet.DeviceGetResponse, ? super List<DeviceInfo>, ? super Integer, Unit> function4, DeviceGet.DeviceGetResponse deviceGetResponse, List<DeviceInfo> list, Continuation<? super AnonymousClass4> continuation) {
                super(2, continuation);
                this.$listener = function4;
                this.$response = deviceGetResponse;
                this.$deviceInfoList = list;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass4(this.$listener, this.$response, this.$deviceInfoList, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$listener.invoke(new ResultAPI(), this.$response, this.$deviceInfoList, Boxing.boxInt(DeviceManagement.INSTANCE.getMgtCount()));
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$5(Activity activity, HiveLifecycle.HiveAccount hiveAccount, boolean z, boolean z2, final Function4 function4, String str, String str2, String str3, boolean z3, boolean z4) {
            if (!z3) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.authv4.devicemanagement.DeviceManagement$innerCheckDevice$1$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        DeviceManagement.AnonymousClass1.invokeSuspend$lambda$5$lambda$4(function4);
                    }
                });
            } else if (z4) {
                DeviceManagement.INSTANCE.innerCheckDevice(activity, hiveAccount, z, z2, null, null, null, function4);
            } else {
                DeviceManagement.INSTANCE.innerCheckDevice(activity, hiveAccount, z, z2, str, str2, str3, function4);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$5$lambda$4(Function4 function4) {
            function4.invoke(new ResultAPI(-8, ResultAPI.Code.AuthV4NotRegisteredDevice), null, null, 1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$7(final Function4 function4, final boolean z) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.authv4.devicemanagement.DeviceManagement$innerCheckDevice$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    DeviceManagement.AnonymousClass1.invokeSuspend$lambda$7$lambda$6(z, function4);
                }
            });
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$7$lambda$6(boolean z, Function4 function4) {
            if (z) {
                function4.invoke(new ResultAPI(), null, null, 1);
            } else {
                function4.invoke(new ResultAPI(-8, ResultAPI.Code.AuthV4NotRegisteredDevice), null, null, 1);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$9(final Function4 function4) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.authv4.devicemanagement.DeviceManagement$innerCheckDevice$1$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    DeviceManagement.AnonymousClass1.invokeSuspend$lambda$9$lambda$8(function4);
                }
            });
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$9$lambda$8(Function4 function4) {
            function4.invoke(new ResultAPI(), null, null, 1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$10(Function4 function4) {
            function4.invoke(new ResultAPI(), null, null, 1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$11(Function4 function4) {
            function4.invoke(new ResultAPI(), null, null, 1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$13(boolean z, HiveLifecycle.HiveAccount hiveAccount, final Function4 function4, boolean z2) {
            if (z2 && z) {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new DeviceManagement$innerCheckDevice$1$10$1(hiveAccount, function4, null), 3, null);
            } else {
                Boolean.valueOf(new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.authv4.devicemanagement.DeviceManagement$innerCheckDevice$1$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        DeviceManagement.AnonymousClass1.invokeSuspend$lambda$13$lambda$12(function4);
                    }
                }));
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$13$lambda$12(Function4 function4) {
            function4.invoke(new ResultAPI(), null, null, 1);
        }
    }

    @Override // com.hive.module.interfaces.authv4.DeviceManagement
    public void show(final Activity activity, final HiveLifecycle.HiveAccount account, boolean disableSubscriptionGuide, final Function1<? super ResultAPI, Unit> listener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(account, "account");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Logger.i("[DeviceManagement] show " + account);
        innerCheckDevice$default(this, activity, account, true, disableSubscriptionGuide, null, null, null, new Function4() { // from class: com.hive.authv4.devicemanagement.DeviceManagement$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return DeviceManagement.show$lambda$3(activity, account, listener, (ResultAPI) obj, (DeviceGet.DeviceGetResponse) obj2, (List) obj3, ((Integer) obj4).intValue());
            }
        }, 112, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit show$lambda$3(Activity activity, HiveLifecycle.HiveAccount hiveAccount, final Function1 function1, ResultAPI result, DeviceGet.DeviceGetResponse deviceGetResponse, List list, int i) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.isSuccess() && deviceGetResponse != null && list != null && (!list.isEmpty())) {
            Logger.d("[DeviceManagement] show c1 deviceManagementInfo flow");
            new C1_DeviceManagementInfo(activity, hiveAccount, deviceGetResponse.getPhoneCode(), deviceGetResponse.getPhoneNumber(), list, i, new Function2() { // from class: com.hive.authv4.devicemanagement.DeviceManagement$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DeviceManagement.show$lambda$3$lambda$2(function1, ((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue());
                }
            }).start();
        } else {
            function1.invoke(result);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit show$lambda$3$lambda$2(Function1 function1, boolean z, boolean z2) {
        function1.invoke(new ResultAPI());
        return Unit.INSTANCE;
    }

    public final DateFormat getHiveLocaleDateFormat$hive_authv4_device_management_release(Context context) {
        Object objM7415constructorimpl;
        Intrinsics.checkNotNullParameter(context, "context");
        String string = context.getString(R.string.hive_device_management_153_2);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        try {
            Result.Companion companion = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(new SimpleDateFormat(string, Locale.US));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m7421isFailureimpl(objM7415constructorimpl)) {
            objM7415constructorimpl = null;
        }
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) objM7415constructorimpl;
        if (simpleDateFormat != null) {
            return simpleDateFormat;
        }
        return new SimpleDateFormat("MM-dd-yyyy", Locale.US);
    }

    public final boolean hideCustomerSupport$hive_authv4_device_management_release() {
        String hiveCountry = Configuration.INSTANCE.getHiveCountry();
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String upperCase = hiveCountry.toUpperCase(US);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        return Intrinsics.areEqual(upperCase, "CN");
    }

    private final String getDeviceKey() {
        Object objM7415constructorimpl;
        Logger.i("[DeviceManagement] getDeviceKey");
        try {
            Result.Companion companion = Result.INSTANCE;
            Property propertyManager = PropertyManager.INSTANCE.getInstance("hivedevicemgt.dat");
            String string = propertyManager.get("key");
            if (string == null) {
                string = "";
            }
            if (StringsKt.isBlank(string)) {
                string = UUID.randomUUID().toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                propertyManager.set("key", string);
                propertyManager.write();
            }
            byte[] bArr = new byte[32];
            Crypto crypto = Crypto.INSTANCE;
            String FINGERPRINT = Build.FINGERPRINT;
            Intrinsics.checkNotNullExpressionValue(FINGERPRINT, "FINGERPRINT");
            byte[] bytes = FINGERPRINT.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            byte[] bArrSha256 = crypto.sha256(bytes);
            if (bArrSha256 != null) {
                ArraysKt.copyInto(bArrSha256, bArr, 0, 0, 16);
            }
            Crypto crypto2 = Crypto.INSTANCE;
            byte[] bytes2 = string.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
            byte[] bArrSha2562 = crypto2.sha256(bytes2);
            if (bArrSha2562 != null) {
                ArraysKt.copyInto(bArrSha2562, bArr, 16, 16, 32);
            }
            objM7415constructorimpl = Result.m7415constructorimpl(StringUtil.INSTANCE.toHexString(bArr));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
        if (thM7418exceptionOrNullimpl != null) {
            Logger.e("[DeviceManagement] getDeviceKey exception: " + thM7418exceptionOrNullimpl);
        }
        if (Result.m7421isFailureimpl(objM7415constructorimpl)) {
            objM7415constructorimpl = null;
        }
        String str = (String) objM7415constructorimpl;
        Logger.d("[DeviceManagement] getDeviceKey: " + str);
        if (str != null) {
            return str;
        }
        Crypto crypto3 = Crypto.INSTANCE;
        byte[] bytes3 = Configuration.INSTANCE.getAnalyticsId().getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes3, "getBytes(...)");
        byte[] bArrSha2563 = crypto3.sha256(bytes3);
        String hexString = bArrSha2563 != null ? StringUtil.INSTANCE.toHexString(bArrSha2563) : null;
        Logger.d("[DeviceManagement] getDeviceKey 2nd: " + hexString);
        if (hexString != null) {
            return hexString;
        }
        Logger.w("[DeviceManagement] getDeviceKey 3rd: ");
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean verifyKey(String oldKey) {
        try {
            Result.Companion companion = Result.INSTANCE;
            byte[] bArr = new byte[16];
            Crypto crypto = Crypto.INSTANCE;
            String FINGERPRINT = Build.FINGERPRINT;
            Intrinsics.checkNotNullExpressionValue(FINGERPRINT, "FINGERPRINT");
            byte[] bytes = FINGERPRINT.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            byte[] bArrSha256 = crypto.sha256(bytes);
            if (bArrSha256 != null) {
                ArraysKt.copyInto(bArrSha256, bArr, 0, 0, 16);
            }
            String hexString = StringUtil.INSTANCE.toHexString(bArr);
            if (hexString == null) {
                hexString = ServerSentEventKt.SPACE;
            }
            Logger.d("[DeviceManagement] verifyKey srcStr: " + hexString);
            Logger.d("[DeviceManagement] verifyKey oldKey: " + oldKey);
            if (StringsKt.contains$default((CharSequence) oldKey, (CharSequence) hexString, false, 2, (Object) null)) {
                Logger.d("[DeviceManagement] verifyKey true");
                return true;
            }
            Crypto crypto2 = Crypto.INSTANCE;
            byte[] bytes2 = Configuration.INSTANCE.getAnalyticsId().getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
            byte[] bArrSha2562 = crypto2.sha256(bytes2);
            boolean zAreEqual = Intrinsics.areEqual(oldKey, bArrSha2562 != null ? StringUtil.INSTANCE.toHexString(bArrSha2562) : null);
            Logger.d("[DeviceManagement] verifyKey " + zAreEqual);
            return zAreEqual;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(Result.m7415constructorimpl(ResultKt.createFailure(th)));
            if (thM7418exceptionOrNullimpl != null) {
                Logger.e("[DeviceManagement] verifyKey exception: " + thM7418exceptionOrNullimpl);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeKey() {
        Logger.e("[DeviceManagement] removeKey");
        Property propertyManager = PropertyManager.INSTANCE.getInstance("hivedevicemgt.dat");
        propertyManager.remove("key");
        propertyManager.write();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isSubscriptionGuideDoneUser(String id) {
        String value;
        String str = id;
        if (str == null || StringsKt.isBlank(str) || (value = com.hive.base.Property.INSTANCE.getINSTANCE().getValue(DEVICE_MGT_SUBSCRIPTION_GUIDE_DONE)) == null) {
            return false;
        }
        if (!(!StringsKt.isBlank(value))) {
            value = null;
        }
        if (value != null) {
            return StringsKt.contains$default((CharSequence) value, (CharSequence) str, false, 2, (Object) null);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void joinSubscriptionGuideDoneUser(String id) {
        String str = id;
        if (str == null || StringsKt.isBlank(str) || isSubscriptionGuideDoneUser(id)) {
            return;
        }
        com.hive.base.Property instance = com.hive.base.Property.INSTANCE.getINSTANCE();
        String value = instance.getValue(DEVICE_MGT_SUBSCRIPTION_GUIDE_DONE);
        if (value == null) {
            value = "";
        }
        String str2 = value + id + AbstractJsonLexerKt.COMMA;
        Intrinsics.checkNotNullExpressionValue(str2, "toString(...)");
        com.hive.base.Property.setValue$default(instance, DEVICE_MGT_SUBSCRIPTION_GUIDE_DONE, str2, null, 4, null);
        com.hive.base.Property.setValue$default(instance, DEVICE_MGT_APP_VERSION, Android.INSTANCE.getAppVersion(), null, 4, null);
        instance.writeProperties();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0060, code lost:
    
        if (r0.equals("false") == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0069, code lost:
    
        if (r0.equals("FALSE") == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x009a, code lost:
    
        if (r0.equals(com.facebook.appevents.AppEventsConstants.EVENT_PARAM_VALUE_NO) == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:?, code lost:
    
        return false;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Boolean getMgtFlag() {
        /*
            r10 = this;
            com.hive.core.Configuration r0 = com.hive.core.Configuration.INSTANCE
            org.json.JSONObject r0 = r0.getMetaData()
            r1 = 0
            r2 = 1
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r2)
            if (r0 == 0) goto L29
            java.lang.String r4 = "device_mgt_flag"
            java.lang.Object r0 = r0.opt(r4)
            if (r0 == 0) goto L29
            java.lang.String r0 = r0.toString()
            if (r0 == 0) goto L29
            java.lang.String r4 = "null"
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r4)
            r2 = r2 ^ r4
            if (r2 == 0) goto L26
            goto L27
        L26:
            r0 = r1
        L27:
            if (r0 != 0) goto L2b
        L29:
            java.lang.String r0 = ""
        L2b:
            com.hive.base.Property$Companion r2 = com.hive.base.Property.INSTANCE
            com.hive.base.Property r2 = r2.getINSTANCE()
            java.lang.String r4 = "authv4.device_mgt_flag"
            java.lang.String r4 = r2.getValue(r4)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "[DeviceManagement] getMgtFlag: "
            r5.<init>(r6)
            r5.append(r0)
            java.lang.String r6 = ", recent: "
            r5.append(r6)
            r5.append(r4)
            java.lang.String r5 = r5.toString()
            com.hive.Logger.d(r5)
            int r5 = r0.hashCode()
            java.lang.String r6 = "1"
            switch(r5) {
                case 48: goto L94;
                case 49: goto L7e;
                case 2583950: goto L75;
                case 3569038: goto L6c;
                case 66658563: goto L63;
                case 97196323: goto L5a;
                default: goto L59;
            }
        L59:
            goto La3
        L5a:
            java.lang.String r2 = "false"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L9d
            goto La3
        L63:
            java.lang.String r2 = "FALSE"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L9d
            goto La3
        L6c:
            java.lang.String r5 = "true"
            boolean r0 = r0.equals(r5)
            if (r0 != 0) goto L85
            goto La3
        L75:
            java.lang.String r5 = "TRUE"
            boolean r0 = r0.equals(r5)
            if (r0 != 0) goto L85
            goto La3
        L7e:
            boolean r0 = r0.equals(r6)
            if (r0 != 0) goto L85
            goto La3
        L85:
            r8 = 4
            r9 = 0
            java.lang.String r5 = "authv4.device_mgt_flag"
            java.lang.String r6 = "1"
            r7 = 0
            r4 = r2
            com.hive.base.Property.setValue$default(r4, r5, r6, r7, r8, r9)
            r2.writeProperties()
            goto La9
        L94:
            java.lang.String r2 = "0"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L9d
            goto La3
        L9d:
            r0 = 0
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r0)
            goto Laa
        La3:
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r6)
            if (r0 == 0) goto Laa
        La9:
            r1 = r3
        Laa:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.authv4.devicemanagement.DeviceManagement.getMgtFlag():java.lang.Boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int getMgtCount() {
        /*
            r3 = this;
            com.hive.core.Configuration r0 = com.hive.core.Configuration.INSTANCE
            org.json.JSONObject r0 = r0.getMetaData()
            r1 = 1
            if (r0 == 0) goto L24
            java.lang.String r2 = "device_mgt_count"
            java.lang.Object r0 = r0.opt(r2)
            if (r0 == 0) goto L24
            java.lang.String r0 = r0.toString()
            if (r0 == 0) goto L24
            java.lang.String r2 = "null"
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r2)
            r2 = r2 ^ r1
            if (r2 == 0) goto L21
            goto L22
        L21:
            r0 = 0
        L22:
            if (r0 != 0) goto L26
        L24:
            java.lang.String r0 = ""
        L26:
            java.lang.Integer r0 = kotlin.text.StringsKt.toIntOrNull(r0)
            if (r0 == 0) goto L30
            int r1 = r0.intValue()
        L30:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.authv4.devicemanagement.DeviceManagement.getMgtCount():int");
    }

    @Override // com.hive.module.HiveModule
    public Map<String, String> getVersionInfo() {
        HashMap map = new HashMap();
        map.put(ModuleCheckName.INSTANCE.getHive_Authv4_Device_Management(), "26.2.0");
        return map;
    }
}
