package com.hive.authv4.devicemanagement;

import com.hive.ResultAPI;
import com.hive.authv4.devicemanagement.ui.model.DeviceInfo;
import com.hive.protocol.authv4.DeviceGet;
import com.hive.standalone.HiveLifecycle;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: DeviceManagement.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.hive.authv4.devicemanagement.DeviceManagement$innerCheckDevice$1$10$1", f = "DeviceManagement.kt", i = {}, l = {242}, m = "invokeSuspend", n = {}, s = {})
final class DeviceManagement$innerCheckDevice$1$10$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ HiveLifecycle.HiveAccount $account;
    final /* synthetic */ Function4<ResultAPI, DeviceGet.DeviceGetResponse, List<DeviceInfo>, Integer, Unit> $listener;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    DeviceManagement$innerCheckDevice$1$10$1(HiveLifecycle.HiveAccount hiveAccount, Function4<? super ResultAPI, ? super DeviceGet.DeviceGetResponse, ? super List<DeviceInfo>, ? super Integer, Unit> function4, Continuation<? super DeviceManagement$innerCheckDevice$1$10$1> continuation) {
        super(2, continuation);
        this.$account = hiveAccount;
        this.$listener = function4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeviceManagement$innerCheckDevice$1$10$1(this.$account, this.$listener, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DeviceManagement$innerCheckDevice$1$10$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objM7415constructorimpl;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            DeviceGet.DeviceGetResponse deviceGetResponseDeviceGet = DeviceManagementNetwork.INSTANCE.deviceGet(this.$account);
            ArrayList arrayList = new ArrayList();
            JSONArray device = deviceGetResponseDeviceGet.getDevice();
            if (device != null) {
                int length = device.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject jSONObjectOptJSONObject = device.optJSONObject(i2);
                    if (jSONObjectOptJSONObject != null) {
                        try {
                            Result.Companion companion = Result.INSTANCE;
                            objM7415constructorimpl = Result.m7415constructorimpl(Boxing.boxBoolean(arrayList.add(new DeviceInfo(jSONObjectOptJSONObject))));
                        } catch (Throwable th) {
                            Result.Companion companion2 = Result.INSTANCE;
                            objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
                        }
                        Result.m7414boximpl(objM7415constructorimpl);
                    }
                }
            }
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass2(this.$listener, deviceGetResponseDeviceGet, arrayList, null), this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.hive.authv4.devicemanagement.DeviceManagement$innerCheckDevice$1$10$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: DeviceManagement.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.authv4.devicemanagement.DeviceManagement$innerCheckDevice$1$10$1$2", f = "DeviceManagement.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<DeviceInfo> $deviceInfoList;
        final /* synthetic */ DeviceGet.DeviceGetResponse $getResponse;
        final /* synthetic */ Function4<ResultAPI, DeviceGet.DeviceGetResponse, List<DeviceInfo>, Integer, Unit> $listener;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Function4<? super ResultAPI, ? super DeviceGet.DeviceGetResponse, ? super List<DeviceInfo>, ? super Integer, Unit> function4, DeviceGet.DeviceGetResponse deviceGetResponse, List<DeviceInfo> list, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$listener = function4;
            this.$getResponse = deviceGetResponse;
            this.$deviceInfoList = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$listener, this.$getResponse, this.$deviceInfoList, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.$listener.invoke(new ResultAPI(), this.$getResponse, this.$deviceInfoList, Boxing.boxInt(DeviceManagement.INSTANCE.getMgtCount()));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
