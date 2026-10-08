package com.hive.authv4.adultconfirm;

import android.app.Activity;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.ResultAPI;
import com.hive.authv4.adultconfirm.AdultConfirm;
import com.hive.base.Android;
import com.hive.configuration.ConfigurationImpl;
import com.hive.core.HiveKeys;
import com.hive.logger.LoggerImpl;
import com.hive.module.ModuleCheckName;
import com.hive.module.interfaces.authv4.AdultConfirm;
import com.hive.module.interfaces.authv4.IdentityVerification;
import com.hive.protocol.Protocol;
import com.hive.protocol.ProtocolRequest;
import com.hive.protocol.UrlManager;
import com.hive.protocol.adultconfirm.AdultCheck;
import com.hive.protocol.adultconfirm.DiHash;
import com.hive.standalone.HiveLifecycle;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: AdultConfirm.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J6\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u001a\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u00050\u000bH\u0016JB\u0010\r\u001a\u00020\u000528\u0010\n\u001a4\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00050\u000bH\u0016J\u0014\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0014H\u0016¨\u0006\u0015"}, d2 = {"Lcom/hive/authv4/adultconfirm/AdultConfirm;", "Lcom/hive/module/interfaces/authv4/AdultConfirm;", "<init>", "()V", "show", "", "activity", "Landroid/app/Activity;", "identity", "Lcom/hive/module/interfaces/authv4/IdentityVerification$Identity;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function2;", "Lcom/hive/ResultAPI;", "getHashedDi", "Lkotlin/ParameterName;", "name", "resultApi", "", "hashedDi", "getVersionInfo", "", "hive-authv4-adult-confirm_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AdultConfirm implements com.hive.module.interfaces.authv4.AdultConfirm {
    public static final AdultConfirm INSTANCE = new AdultConfirm();

    private AdultConfirm() {
    }

    @Override // com.hive.module.interfaces.authv4.AdultConfirm, com.hive.module.HiveModule
    public String getHiveModuleName() {
        return AdultConfirm.DefaultImpls.getHiveModuleName(this);
    }

    @Override // com.hive.module.interfaces.authv4.AdultConfirm
    public void show(Activity activity, IdentityVerification.Identity identity, Function2<? super ResultAPI, ? super IdentityVerification.Identity, Unit> listener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.d("[AdultConfirm] show()");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new C28481(activity, identity, listener, null), 3, null);
    }

    /* JADX INFO: renamed from: com.hive.authv4.adultconfirm.AdultConfirm$show$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AdultConfirm.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.authv4.adultconfirm.AdultConfirm$show$1", f = "AdultConfirm.kt", i = {}, l = {101}, m = "invokeSuspend", n = {}, s = {})
    static final class C28481 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $activity;
        final /* synthetic */ IdentityVerification.Identity $identity;
        final /* synthetic */ Function2<ResultAPI, IdentityVerification.Identity, Unit> $listener;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C28481(Activity activity, IdentityVerification.Identity identity, Function2<? super ResultAPI, ? super IdentityVerification.Identity, Unit> function2, Continuation<? super C28481> continuation) {
            super(2, continuation);
            this.$activity = activity;
            this.$identity = identity;
            this.$listener = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C28481(this.$activity, this.$identity, this.$listener, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C28481) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v1, types: [T, com.hive.ResultAPI] */
        /* JADX WARN: Type inference failed for: r3v15, types: [T, com.hive.ResultAPI] */
        /* JADX WARN: Type inference failed for: r3v24, types: [T, com.hive.ResultAPI] */
        /* JADX WARN: Type inference failed for: r3v7, types: [T, com.hive.ResultAPI] */
        /* JADX WARN: Type inference failed for: r6v34, types: [T, com.hive.ResultAPI] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                objectRef.element = new ResultAPI(-99, ResultAPI.Code.CommonUnknown, "");
                Protocol.Companion companion = Protocol.INSTANCE;
                Protocol protocol = new Protocol(new Function0<AdultCheck>() { // from class: com.hive.authv4.adultconfirm.AdultConfirm$show$1$invokeSuspend$$inlined$invoke$1
                    /* JADX WARN: Can't rename method to resolve collision */
                    /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.adultconfirm.AdultCheck] */
                    @Override // kotlin.jvm.functions.Function0
                    public final AdultCheck invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                        Object objNewInstance = AdultCheck.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                        Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                        return (ProtocolRequest) objNewInstance;
                    }
                });
                IdentityVerification.Identity identity = this.$identity;
                protocol.setParam(HiveKeys.KEY_api, "adult_auth_check");
                protocol.setParam(HiveKeys.KEY_appid, ConfigurationImpl.INSTANCE.getAppId());
                protocol.setParam(HiveKeys.KEY_appversion, Android.INSTANCE.getAppVersion());
                protocol.setParam(HiveKeys.KEY_app_version_display, Android.INSTANCE.getAppVersion());
                protocol.setParam(HiveKeys.KEY_did, HiveLifecycle.INSTANCE.getDid());
                protocol.setParam(HiveKeys.KEY_country, Android.INSTANCE.getCountry());
                protocol.setParam(HiveKeys.KEY_uid, HiveLifecycle.INSTANCE.getAccount().getUid());
                protocol.setParam(HiveKeys.KEY_uid_sessionkey, HiveLifecycle.INSTANCE.getAccount().getUidSession());
                protocol.setParam(HiveKeys.KEY_vid, HiveLifecycle.INSTANCE.getAccount().getVid());
                protocol.setParam(HiveKeys.KEY_vid_sessionkey, HiveLifecycle.INSTANCE.getAccount().getVidSession());
                protocol.setParam(HiveKeys.KEY_vid_type, HiveLifecycle.INSTANCE.getAccount().getVidType());
                protocol.setParam(HiveKeys.KEY_world, ConfigurationImpl.INSTANCE.getServerId());
                protocol.setParam(HiveKeys.KEY_auth_type, "app");
                if (identity != null) {
                    protocol.setParam(HiveKeys.KEY_di_hash, identity.getHashedDi());
                    protocol.setParam(HiveKeys.KEY_birymd, identity.getBirymd());
                    protocol.setParam(HiveKeys.KEY_phone_code, identity.getPhoneCode());
                    protocol.setParam(HiveKeys.KEY_phone_number, identity.getPhoneNumber());
                    protocol.setParam(HiveKeys.KEY_identity_signature, identity.getIdentitySignature());
                }
                AdultCheck.AdultCheckResponse response = ((AdultCheck) protocol.request()).getResponse();
                if (response.getResult().isSuccess()) {
                    int adultCheckResultCode = response.getAdultCheckResultCode();
                    String adultCheckResultMsg = response.getAdultCheckResultMsg();
                    String authUrl = response.getAuthUrl();
                    String str = authUrl;
                    if (str == null || StringsKt.isBlank(str)) {
                        authUrl = null;
                    }
                    if (authUrl == null) {
                        authUrl = UrlManager.AdultConfirm.INSTANCE.getAdultConfirm();
                    }
                    switch (adultCheckResultCode) {
                        case 2000008:
                            objectRef.element = new ResultAPI(-6, ResultAPI.Code.AgeLimit, "[AdultConfirm] Failed due to age restriction.(" + adultCheckResultMsg + ')');
                            break;
                        case 2000018:
                            LoggerImpl.INSTANCE.d("[AdultConfirm] need adult confirm.(" + adultCheckResultMsg + ')');
                            com.hive.authv4.identityverification.IdentityVerification identityVerification = com.hive.authv4.identityverification.IdentityVerification.INSTANCE;
                            Activity activity = this.$activity;
                            final Function2<ResultAPI, IdentityVerification.Identity, Unit> function2 = this.$listener;
                            identityVerification.show(activity, authUrl, new Function2() { // from class: com.hive.authv4.adultconfirm.AdultConfirm$show$1$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj2, Object obj3) {
                                    return AdultConfirm.C28481.invokeSuspend$lambda$3(function2, (ResultAPI) obj2, (IdentityVerification.Identity) obj3);
                                }
                            });
                            break;
                        case 2000019:
                            objectRef.element = new ResultAPI(0, ResultAPI.Code.Success, "[AdultConfirm] adult confirm skip.(" + adultCheckResultMsg + ')');
                            IdentityVerification.Identity identity2 = this.$identity;
                            if (identity2 != null) {
                                identity2.setSignature(response.getSignature());
                            }
                            IdentityVerification.Identity identity3 = this.$identity;
                            if (identity3 != null) {
                                identity3.setSignatureResultCode(response.getSignatureResultCode());
                            }
                            break;
                        default:
                            objectRef.element = new ResultAPI(-8, ResultAPI.Code.AuthV4InvalidServerResponse, "[AdultConfirm] adult check response error.(" + adultCheckResultMsg + ')');
                            break;
                    }
                } else {
                    objectRef.element = new ResultAPI(-5, ResultAPI.Code.AuthV4NetworkError, "[AdultConfirm] adult check network error.(" + response.getResult().getMessage() + ')');
                }
                if (((ResultAPI) objectRef.element).getErrorCode() != -99) {
                    LoggerImpl.INSTANCE.w(((ResultAPI) objectRef.element).toString());
                    this.label = 1;
                    if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass2(this.$listener, objectRef, this.$identity, null), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$3(Function2 function2, ResultAPI resultAPI, IdentityVerification.Identity identity) {
            function2.invoke(resultAPI, identity);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.hive.authv4.adultconfirm.AdultConfirm$show$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: AdultConfirm.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.hive.authv4.adultconfirm.AdultConfirm$show$1$2", f = "AdultConfirm.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ IdentityVerification.Identity $identity;
            final /* synthetic */ Function2<ResultAPI, IdentityVerification.Identity, Unit> $listener;
            final /* synthetic */ Ref.ObjectRef<ResultAPI> $result;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass2(Function2<? super ResultAPI, ? super IdentityVerification.Identity, Unit> function2, Ref.ObjectRef<ResultAPI> objectRef, IdentityVerification.Identity identity, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.$listener = function2;
                this.$result = objectRef;
                this.$identity = identity;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.$listener, this.$result, this.$identity, continuation);
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
                this.$listener.invoke(this.$result.element, this.$identity);
                return Unit.INSTANCE;
            }
        }
    }

    @Override // com.hive.module.interfaces.authv4.AdultConfirm
    public void getHashedDi(Function2<? super ResultAPI, ? super String, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.d("[AdultConfirm] getHashedDi()");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(listener, null), 3, null);
    }

    /* JADX INFO: renamed from: com.hive.authv4.adultconfirm.AdultConfirm$getHashedDi$1, reason: invalid class name */
    /* JADX INFO: compiled from: AdultConfirm.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.authv4.adultconfirm.AdultConfirm$getHashedDi$1", f = "AdultConfirm.kt", i = {}, l = {123}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<ResultAPI, String, Unit> $listener;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Function2<? super ResultAPI, ? super String, Unit> function2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$listener = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$listener, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Protocol.Companion companion = Protocol.INSTANCE;
                Protocol protocol = new Protocol(new Function0<DiHash>() { // from class: com.hive.authv4.adultconfirm.AdultConfirm$getHashedDi$1$invokeSuspend$$inlined$invoke$1
                    /* JADX WARN: Can't rename method to resolve collision */
                    /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.adultconfirm.DiHash] */
                    @Override // kotlin.jvm.functions.Function0
                    public final DiHash invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                        Object objNewInstance = DiHash.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                        Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                        return (ProtocolRequest) objNewInstance;
                    }
                });
                protocol.setParam(HiveKeys.KEY_appid, ConfigurationImpl.INSTANCE.getAppId());
                protocol.setParam(HiveKeys.KEY_vid, HiveLifecycle.INSTANCE.getAccount().getVid());
                protocol.setParam(HiveKeys.KEY_vid_type, HiveLifecycle.INSTANCE.getAccount().getVidType());
                DiHash.AdultCheckResponse response = ((DiHash) protocol.request()).getResponse();
                this.label = 1;
                if (BuildersKt.withContext(Dispatchers.getMain(), new C03511(response, this.$listener, null), this) == coroutine_suspended) {
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

        /* JADX INFO: renamed from: com.hive.authv4.adultconfirm.AdultConfirm$getHashedDi$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: AdultConfirm.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.hive.authv4.adultconfirm.AdultConfirm$getHashedDi$1$1", f = "AdultConfirm.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C03511 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function2<ResultAPI, String, Unit> $listener;
            final /* synthetic */ DiHash.AdultCheckResponse $response;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C03511(DiHash.AdultCheckResponse adultCheckResponse, Function2<? super ResultAPI, ? super String, Unit> function2, Continuation<? super C03511> continuation) {
                super(2, continuation);
                this.$response = adultCheckResponse;
                this.$listener = function2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C03511(this.$response, this.$listener, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C03511) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                String diHash;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                if (this.$response.isSuccess() && (diHash = this.$response.getDiHash()) != null && (!StringsKt.isBlank(diHash))) {
                    LoggerImpl.INSTANCE.d("[AdultConfirm] getHashedDi success: (" + this.$response.getDiHash() + ')');
                    this.$listener.invoke(new ResultAPI(), this.$response.getDiHash());
                } else if (this.$response.getResult().isFailure()) {
                    String str = "[AdultConfirm] getHashedDi network error: " + this.$response.getResult().getMessage() + '(' + this.$response.getHttpStatusCode() + ')';
                    LoggerImpl.INSTANCE.w(str);
                    this.$listener.invoke(new ResultAPI(-5, ResultAPI.Code.AuthV4NetworkError, str), null);
                } else {
                    String str2 = "[AdultConfirm] getHashedDi response error: (" + this.$response.getResultMsg() + ')';
                    LoggerImpl.INSTANCE.w(str2);
                    this.$listener.invoke(new ResultAPI(-8, ResultAPI.Code.AuthV4InvalidServerResponse, str2), null);
                }
                return Unit.INSTANCE;
            }
        }
    }

    @Override // com.hive.module.HiveModule
    public Map<String, String> getVersionInfo() {
        HashMap map = new HashMap();
        map.put(ModuleCheckName.INSTANCE.getHive_Authv4_Adult_Confirm(), "26.2.0");
        return map;
    }
}
