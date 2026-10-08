package com.hive.authv4;

import com.hive.AuthV4;
import com.hive.ResultAPI;
import com.hive.authv4.provider.AuthV4ProviderAdapter;
import com.hive.authv4.provider.AuthV4ProviderGooglePlayGames;
import com.hive.base.Android;
import com.hive.configuration.ConfigurationImpl;
import com.hive.core.Configuration;
import com.hive.core.HiveKeys;
import com.hive.core.Platform;
import com.hive.logger.LoggerImpl;
import com.hive.protocol.Protocol;
import com.hive.protocol.ProtocolRequest;
import com.hive.protocol.authv4.Connect;
import com.hive.standalone.HiveLifecycle;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.hive.authv4.AuthV4Network$connect$1", f = "AuthV4Network.kt", i = {0}, l = {2393}, m = "invokeSuspend", n = {"connect"}, s = {"L$0"})
public final class AuthV4Network$connect$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function3<ResultAPI, Connect, AuthV4.PlayerInfo, Unit> $callback;
    final /* synthetic */ AuthV4.PlayerInfo $playerInfo;
    final /* synthetic */ AuthV4ProviderAdapter $provider;
    Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AuthV4Network$connect$1(AuthV4ProviderAdapter authV4ProviderAdapter, AuthV4.PlayerInfo playerInfo, Function3<? super ResultAPI, ? super Connect, ? super AuthV4.PlayerInfo, Unit> function3, Continuation<? super AuthV4Network$connect$1> continuation) {
        super(2, continuation);
        this.$provider = authV4ProviderAdapter;
        this.$playerInfo = playerInfo;
        this.$callback = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AuthV4Network$connect$1(this.$provider, this.$playerInfo, this.$callback, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v29, types: [T, com.hive.AuthV4$PlayerInfo, com.hive.AuthV4$ProfileInfo] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Protocol protocol;
        Exception e;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Protocol.Companion companion = Protocol.INSTANCE;
            final Protocol protocol2 = new Protocol(new Function0<Connect>() { // from class: com.hive.authv4.AuthV4Network$connect$1$invokeSuspend$$inlined$invoke$1
                /* JADX WARN: Can't rename method to resolve collision */
                /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.authv4.Connect] */
                @Override // kotlin.jvm.functions.Function0
                public final Connect invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                    Object objNewInstance = Connect.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                    return (ProtocolRequest) objNewInstance;
                }
            });
            String did = HiveLifecycle.INSTANCE.getDid();
            try {
                HiveKeys hiveKeys = HiveKeys.KEY_appid;
                ConfigurationImpl configurationImpl = ConfigurationImpl.INSTANCE;
                protocol2.setParam(hiveKeys, configurationImpl.getAppId());
                protocol2.setParam(HiveKeys.KEY_did, did);
                protocol2.setParam(HiveKeys.KEY_sdk_version, "4.26.2.0");
                HiveKeys hiveKeys2 = HiveKeys.KEY_os_version;
                Android android2 = Android.INSTANCE;
                protocol2.setParam(hiveKeys2, android2.getOSVersion());
                protocol2.setParam(HiveKeys.KEY_os_api_level, Boxing.boxInt(android2.getOSVersionCode()));
                protocol2.setParam(HiveKeys.KEY_os, Platform.INSTANCE.getPlatform());
                protocol2.setParam(HiveKeys.KEY_device_model, android2.getDeviceModel());
                protocol2.setParam(HiveKeys.KEY_country, android2.getCountry());
                protocol2.setParam(HiveKeys.KEY_game_language, configurationImpl.getHiveLanguage());
                protocol2.setParam(HiveKeys.KEY_idp_id, this.$provider.getIdpType().getValue());
                protocol2.setParam(HiveKeys.KEY_idp_user_id, this.$provider.getUserId());
                protocol2.setParam(HiveKeys.KEY_idp_token, this.$provider.getUserToken());
                protocol2.setParam(HiveKeys.KEY_idp_code, this.$provider.getUserCode());
                protocol2.setParam(HiveKeys.KEY_player_id, Boxing.boxLong(this.$playerInfo.getPlayerId()));
                protocol2.setParam(HiveKeys.KEY_idp_appid, this.$provider.getIdpAppId());
                protocol2.setHeader(HiveKeys.KEY_Authorization, this.$playerInfo.getPlayerToken());
                protocol2.setOauthToken(AuthV4Account.INSTANCE);
                if (this.$provider.getIdpType() == AuthV4.ProviderType.GOOGLE && Configuration.INSTANCE.getGoogleLegacySupport()) {
                    this.L$0 = protocol2;
                    this.label = 1;
                    final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(this), 1);
                    cancellableContinuationImpl.initCancellability();
                    AuthV4ProviderGooglePlayGames.INSTANCE.getPlayerId(new Function3<ResultAPI, String, String, Unit>() { // from class: com.hive.authv4.AuthV4Network$connect$1$1$1
                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(ResultAPI resultAPI, String str, String str2) {
                            invoke2(resultAPI, str, str2);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(ResultAPI resultAPI, String str, String str2) {
                            Intrinsics.checkNotNullParameter(resultAPI, "<unused var>");
                            if (str != null && (!StringsKt.isBlank(str))) {
                                protocol2.setParam(HiveKeys.KEY_pgs_player_id, str);
                            }
                            if (cancellableContinuationImpl.isActive()) {
                                CancellableContinuation<Boolean> cancellableContinuation = cancellableContinuationImpl;
                                Result.Companion companion2 = Result.INSTANCE;
                                cancellableContinuation.resumeWith(Result.m7415constructorimpl(Boolean.TRUE));
                            }
                        }
                    });
                    Object result = cancellableContinuationImpl.getResult();
                    if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        DebugProbesKt.probeCoroutineSuspended(this);
                    }
                    if (result == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                protocol = protocol2;
            } catch (Exception e2) {
                protocol = protocol2;
                e = e2;
                LoggerImpl.INSTANCE.w("[AuthV4Network] connect Exception: " + e);
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            protocol = (Protocol) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Exception e3) {
                e = e3;
                LoggerImpl.INSTANCE.w("[AuthV4Network] connect Exception: " + e);
            }
        }
        Connect connect = (Connect) protocol.request();
        ResultAPI resultAPI$hive_service_release = AuthV4Network.INSTANCE.toResultAPI$hive_service_release(connect.getResponse());
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (resultAPI$hive_service_release.getCode() == ResultAPI.Code.AuthV4ConflictPlayer) {
            try {
                JSONObject data = connect.getResponse().getData();
                if (data != null) {
                    ?? playerInfo = new AuthV4.PlayerInfo();
                    playerInfo.setPlayerId(data.getLong("player_id"));
                    String string = data.getString("idp_user_id");
                    String string2 = data.getString("idp_id");
                    AuthV4.ProviderType.Companion companion2 = AuthV4.ProviderType.INSTANCE;
                    Intrinsics.checkNotNull(string2);
                    AuthV4.ProviderType providerType = companion2.getProviderType(string2);
                    if (providerType != null) {
                        HashMap<AuthV4.ProviderType, AuthV4.ProviderInfo> providerInfoData = playerInfo.getProviderInfoData();
                        Intrinsics.checkNotNull(string);
                        providerInfoData.put(providerType, new AuthV4.ProviderInfo(providerType, string));
                    } else if (!StringsKt.isBlank(string2)) {
                        HashMap<String, AuthV4.ProviderInfo> customProviderInfoData = playerInfo.getCustomProviderInfoData();
                        Intrinsics.checkNotNull(string);
                        customProviderInfoData.put(string2, new AuthV4.ProviderInfo(string2, string));
                    }
                    objectRef.element = playerInfo;
                }
            } catch (Exception e4) {
                String str = "ResponseAuthConnect Exception: " + e4 + '\n' + connect;
                LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
                loggerImpl.w(str);
                loggerImpl.wR("ResponseAuthConnect Exception: " + e4);
                objectRef.element = null;
                resultAPI$hive_service_release = new ResultAPI(-8, ResultAPI.Code.AuthV4ConflictPlayerHandlingFail, "invalid CONFLICT_PLAYER data: " + str);
            }
        }
        this.$callback.invoke(resultAPI$hive_service_release, connect, objectRef.element);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AuthV4Network$connect$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
