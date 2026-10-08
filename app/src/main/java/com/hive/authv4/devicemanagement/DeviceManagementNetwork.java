package com.hive.authv4.devicemanagement;

import androidx.autofill.HintConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.base.Android;
import com.hive.core.Configuration;
import com.hive.core.HiveKeys;
import com.hive.core.OauthToken;
import com.hive.core.Platform;
import com.hive.protocol.Protocol;
import com.hive.protocol.ProtocolRequest;
import com.hive.protocol.authv4.DeviceAdd;
import com.hive.protocol.authv4.DeviceDelete;
import com.hive.protocol.authv4.DeviceDeleteUser;
import com.hive.protocol.authv4.DeviceGet;
import com.hive.protocol.authv4.DeviceGetSeq;
import com.hive.protocol.authv4.DeviceModify;
import com.hive.protocol.authv4.DeviceModifyUser;
import com.hive.protocol.authv4.DeviceSetUser;
import com.hive.protocol.authv4.SmsSend;
import com.hive.protocol.authv4.SmsVerify;
import com.hive.standalone.HiveLifecycle;
import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import java.lang.reflect.InvocationTargetException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: DeviceManagementNetwork.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J:\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00050\rJ*\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\t2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00050\rJ*\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00050\rJ\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ2\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00050\rJR\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00050\rJT\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00050\rJ>\u0010 \u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\t2\u0006\u0010!\u001a\u00020\t2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00050\rJ2\u0010#\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010$\u001a\u00020\t2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00050\r¨\u0006&"}, d2 = {"Lcom/hive/authv4/devicemanagement/DeviceManagementNetwork;", "", "<init>", "()V", "deviceAdd", "", "account", "Lcom/hive/standalone/HiveLifecycle$HiveAccount;", InAppPurchaseMetaData.KEY_SIGNATURE, "", "deviceKey", "deviceName", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function1;", "Lcom/hive/protocol/authv4/DeviceAdd$DeviceAddResponse;", "deviceDelete", "seq", "Lcom/hive/protocol/authv4/DeviceDelete$DeviceDeleteResponse;", "deviceDeleteUser", "Lcom/hive/protocol/authv4/DeviceDeleteUser$DeviceDeleteUserResponse;", "deviceGet", "Lcom/hive/protocol/authv4/DeviceGet$DeviceGetResponse;", "deviceGetSeq", "Lcom/hive/protocol/authv4/DeviceGetSeq$DeviceGetSeqResponse;", "deviceModify", "Lcom/hive/protocol/authv4/DeviceModify$DeviceModifyResponse;", "deviceModifyUser", "phoneCode", HintConstants.AUTOFILL_HINT_PHONE_NUMBER, "Lcom/hive/protocol/authv4/DeviceModifyUser$DeviceModifyUserResponse;", "deviceSetUser", "Lcom/hive/protocol/authv4/DeviceSetUser$DeviceSetUserResponse;", "smsSend", "useApi", "Lcom/hive/protocol/authv4/SmsSend$SmsSendResponse;", "smsVerify", "code", "Lcom/hive/protocol/authv4/SmsVerify$SmsVerifyResponse;", "hive-authv4-device-management_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DeviceManagementNetwork {
    public static final DeviceManagementNetwork INSTANCE = new DeviceManagementNetwork();

    private DeviceManagementNetwork() {
    }

    public final void deviceAdd(HiveLifecycle.HiveAccount account, String signature, String deviceKey, String deviceName, final Function1<? super DeviceAdd.DeviceAddResponse, Unit> listener) {
        Intrinsics.checkNotNullParameter(account, "account");
        Intrinsics.checkNotNullParameter(signature, "signature");
        Intrinsics.checkNotNullParameter(deviceKey, "deviceKey");
        Intrinsics.checkNotNullParameter(deviceName, "deviceName");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol protocol = new Protocol(new Function0<DeviceAdd>() { // from class: com.hive.authv4.devicemanagement.DeviceManagementNetwork$deviceAdd$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.authv4.DeviceAdd] */
            @Override // kotlin.jvm.functions.Function0
            public final DeviceAdd invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = DeviceAdd.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        String vidSession = account.getVidSession();
        if (vidSession != null) {
            protocol.setHeader(HiveKeys.KEY_Authorization, vidSession);
            protocol.setParam(HiveKeys.KEY_player_id, account.getVid());
            protocol.setParam(HiveKeys.KEY_vid_type, account.getVidType());
        }
        OauthToken oauthToken = account.getOauthToken();
        if (oauthToken != null) {
            protocol.setOauthToken(oauthToken);
        }
        String did = account.getDid();
        if (did != null) {
            protocol.setParam(HiveKeys.KEY_did, did);
        }
        protocol.setParam(HiveKeys.KEY_appid, Configuration.INSTANCE.getAppId());
        protocol.setParam(HiveKeys.KEY_signature, signature);
        protocol.setParam(HiveKeys.KEY_device_key, deviceKey);
        protocol.setParam(HiveKeys.KEY_os, Platform.INSTANCE.getPlatform());
        protocol.setParam(HiveKeys.KEY_device_model, Android.INSTANCE.getDeviceModel());
        protocol.setParam(HiveKeys.KEY_device_name, deviceName);
        protocol.request(new Function1() { // from class: com.hive.authv4.devicemanagement.DeviceManagementNetwork$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DeviceManagementNetwork.deviceAdd$lambda$4(listener, (DeviceAdd) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit deviceAdd$lambda$4(Function1 function1, DeviceAdd it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(it.getResponse());
        return Unit.INSTANCE;
    }

    public final void deviceDelete(HiveLifecycle.HiveAccount account, String seq, final Function1<? super DeviceDelete.DeviceDeleteResponse, Unit> listener) {
        Intrinsics.checkNotNullParameter(account, "account");
        Intrinsics.checkNotNullParameter(seq, "seq");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol protocol = new Protocol(new Function0<DeviceDelete>() { // from class: com.hive.authv4.devicemanagement.DeviceManagementNetwork$deviceDelete$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.authv4.DeviceDelete] */
            @Override // kotlin.jvm.functions.Function0
            public final DeviceDelete invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = DeviceDelete.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        String vidSession = account.getVidSession();
        if (vidSession != null) {
            protocol.setHeader(HiveKeys.KEY_Authorization, vidSession);
            protocol.setParam(HiveKeys.KEY_player_id, account.getVid());
            protocol.setParam(HiveKeys.KEY_vid_type, account.getVidType());
        }
        OauthToken oauthToken = account.getOauthToken();
        if (oauthToken != null) {
            protocol.setOauthToken(oauthToken);
        }
        String did = account.getDid();
        if (did != null) {
            protocol.setParam(HiveKeys.KEY_did, did);
        }
        protocol.setParam(HiveKeys.KEY_appid, Configuration.INSTANCE.getAppId());
        protocol.setParam(HiveKeys.KEY_seq, seq);
        protocol.request(new Function1() { // from class: com.hive.authv4.devicemanagement.DeviceManagementNetwork$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DeviceManagementNetwork.deviceDelete$lambda$9(listener, (DeviceDelete) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit deviceDelete$lambda$9(Function1 function1, DeviceDelete it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(it.getResponse());
        return Unit.INSTANCE;
    }

    public final void deviceDeleteUser(HiveLifecycle.HiveAccount account, String signature, final Function1<? super DeviceDeleteUser.DeviceDeleteUserResponse, Unit> listener) {
        Intrinsics.checkNotNullParameter(account, "account");
        Intrinsics.checkNotNullParameter(signature, "signature");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol protocol = new Protocol(new Function0<DeviceDeleteUser>() { // from class: com.hive.authv4.devicemanagement.DeviceManagementNetwork$deviceDeleteUser$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.authv4.DeviceDeleteUser] */
            @Override // kotlin.jvm.functions.Function0
            public final DeviceDeleteUser invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = DeviceDeleteUser.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        String vidSession = account.getVidSession();
        if (vidSession != null) {
            protocol.setHeader(HiveKeys.KEY_Authorization, vidSession);
            protocol.setParam(HiveKeys.KEY_player_id, account.getVid());
            protocol.setParam(HiveKeys.KEY_vid_type, account.getVidType());
        }
        OauthToken oauthToken = account.getOauthToken();
        if (oauthToken != null) {
            protocol.setOauthToken(oauthToken);
        }
        String did = account.getDid();
        if (did != null) {
            protocol.setParam(HiveKeys.KEY_did, did);
        }
        protocol.setParam(HiveKeys.KEY_appid, Configuration.INSTANCE.getAppId());
        protocol.setParam(HiveKeys.KEY_signature, signature);
        protocol.request(new Function1() { // from class: com.hive.authv4.devicemanagement.DeviceManagementNetwork$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DeviceManagementNetwork.deviceDeleteUser$lambda$14(listener, (DeviceDeleteUser) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit deviceDeleteUser$lambda$14(Function1 function1, DeviceDeleteUser it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(it.getResponse());
        return Unit.INSTANCE;
    }

    public final DeviceGet.DeviceGetResponse deviceGet(HiveLifecycle.HiveAccount account) {
        Intrinsics.checkNotNullParameter(account, "account");
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol protocol = new Protocol(new Function0<DeviceGet>() { // from class: com.hive.authv4.devicemanagement.DeviceManagementNetwork$deviceGet$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.authv4.DeviceGet] */
            @Override // kotlin.jvm.functions.Function0
            public final DeviceGet invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = DeviceGet.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        String vidSession = account.getVidSession();
        if (vidSession != null) {
            protocol.setHeader(HiveKeys.KEY_Authorization, vidSession);
            protocol.setParam(HiveKeys.KEY_player_id, account.getVid());
            protocol.setParam(HiveKeys.KEY_vid_type, account.getVidType());
        }
        OauthToken oauthToken = account.getOauthToken();
        if (oauthToken != null) {
            protocol.setOauthToken(oauthToken);
        }
        String did = account.getDid();
        if (did != null) {
            protocol.setParam(HiveKeys.KEY_did, did);
        }
        protocol.setParam(HiveKeys.KEY_appid, Configuration.INSTANCE.getAppId());
        return ((DeviceGet) protocol.request()).getResponse();
    }

    public final DeviceGetSeq.DeviceGetSeqResponse deviceGetSeq(HiveLifecycle.HiveAccount account, String deviceKey) {
        Intrinsics.checkNotNullParameter(account, "account");
        Intrinsics.checkNotNullParameter(deviceKey, "deviceKey");
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol protocol = new Protocol(new Function0<DeviceGetSeq>() { // from class: com.hive.authv4.devicemanagement.DeviceManagementNetwork$deviceGetSeq$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.authv4.DeviceGetSeq] */
            @Override // kotlin.jvm.functions.Function0
            public final DeviceGetSeq invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = DeviceGetSeq.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        String vidSession = account.getVidSession();
        if (vidSession != null) {
            protocol.setHeader(HiveKeys.KEY_Authorization, vidSession);
            protocol.setParam(HiveKeys.KEY_player_id, account.getVid());
            protocol.setParam(HiveKeys.KEY_vid_type, account.getVidType());
            protocol.setParam(HiveKeys.KEY_device_key, deviceKey);
        }
        OauthToken oauthToken = account.getOauthToken();
        if (oauthToken != null) {
            protocol.setOauthToken(oauthToken);
        }
        String did = account.getDid();
        if (did != null) {
            protocol.setParam(HiveKeys.KEY_did, did);
        }
        protocol.setParam(HiveKeys.KEY_appid, Configuration.INSTANCE.getAppId());
        return ((DeviceGetSeq) protocol.request()).getResponse();
    }

    public final void deviceModify(HiveLifecycle.HiveAccount account, String seq, String deviceName, final Function1<? super DeviceModify.DeviceModifyResponse, Unit> listener) {
        Intrinsics.checkNotNullParameter(account, "account");
        Intrinsics.checkNotNullParameter(seq, "seq");
        Intrinsics.checkNotNullParameter(deviceName, "deviceName");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol protocol = new Protocol(new Function0<DeviceModify>() { // from class: com.hive.authv4.devicemanagement.DeviceManagementNetwork$deviceModify$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.authv4.DeviceModify] */
            @Override // kotlin.jvm.functions.Function0
            public final DeviceModify invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = DeviceModify.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        String vidSession = account.getVidSession();
        if (vidSession != null) {
            protocol.setHeader(HiveKeys.KEY_Authorization, vidSession);
            protocol.setParam(HiveKeys.KEY_player_id, account.getVid());
            protocol.setParam(HiveKeys.KEY_vid_type, account.getVidType());
            protocol.setParam(HiveKeys.KEY_seq, seq);
            protocol.setParam(HiveKeys.KEY_device_name, deviceName);
        }
        OauthToken oauthToken = account.getOauthToken();
        if (oauthToken != null) {
            protocol.setOauthToken(oauthToken);
        }
        String did = account.getDid();
        if (did != null) {
            protocol.setParam(HiveKeys.KEY_did, did);
        }
        protocol.setParam(HiveKeys.KEY_appid, Configuration.INSTANCE.getAppId());
        protocol.request(new Function1() { // from class: com.hive.authv4.devicemanagement.DeviceManagementNetwork$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DeviceManagementNetwork.deviceModify$lambda$27(listener, (DeviceModify) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit deviceModify$lambda$27(Function1 function1, DeviceModify it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(it.getResponse());
        return Unit.INSTANCE;
    }

    public final void deviceModifyUser(HiveLifecycle.HiveAccount account, String phoneCode, String phoneNumber, String signature, String deviceKey, String deviceName, final Function1<? super DeviceModifyUser.DeviceModifyUserResponse, Unit> listener) {
        Intrinsics.checkNotNullParameter(account, "account");
        Intrinsics.checkNotNullParameter(signature, "signature");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol protocol = new Protocol(new Function0<DeviceModifyUser>() { // from class: com.hive.authv4.devicemanagement.DeviceManagementNetwork$deviceModifyUser$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.authv4.DeviceModifyUser] */
            @Override // kotlin.jvm.functions.Function0
            public final DeviceModifyUser invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = DeviceModifyUser.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        String vidSession = account.getVidSession();
        if (vidSession != null) {
            protocol.setHeader(HiveKeys.KEY_Authorization, vidSession);
            protocol.setParam(HiveKeys.KEY_player_id, account.getVid());
            protocol.setParam(HiveKeys.KEY_vid_type, account.getVidType());
        }
        OauthToken oauthToken = account.getOauthToken();
        if (oauthToken != null) {
            protocol.setOauthToken(oauthToken);
        }
        String did = account.getDid();
        if (did != null) {
            protocol.setParam(HiveKeys.KEY_did, did);
        }
        protocol.setParam(HiveKeys.KEY_appid, Configuration.INSTANCE.getAppId());
        if (phoneCode != null) {
            if (!(!StringsKt.isBlank(phoneCode))) {
                phoneCode = null;
            }
            if (phoneCode != null) {
                protocol.setParam(HiveKeys.KEY_phone_code, phoneCode);
            }
        }
        if (phoneNumber != null) {
            if (!(!StringsKt.isBlank(phoneNumber))) {
                phoneNumber = null;
            }
            if (phoneNumber != null) {
                protocol.setParam(HiveKeys.KEY_phone_number, phoneNumber);
            }
        }
        protocol.setParam(HiveKeys.KEY_signature, signature);
        protocol.setParam(HiveKeys.KEY_device_key, deviceKey);
        protocol.setParam(HiveKeys.KEY_os, Platform.INSTANCE.getPlatform());
        protocol.setParam(HiveKeys.KEY_device_model, Android.INSTANCE.getDeviceModel());
        protocol.setParam(HiveKeys.KEY_device_name, deviceName);
        protocol.request(new Function1() { // from class: com.hive.authv4.devicemanagement.DeviceManagementNetwork$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DeviceManagementNetwork.deviceModifyUser$lambda$36(listener, (DeviceModifyUser) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit deviceModifyUser$lambda$36(Function1 function1, DeviceModifyUser it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(it.getResponse());
        return Unit.INSTANCE;
    }

    public final void deviceSetUser(HiveLifecycle.HiveAccount account, String phoneCode, String phoneNumber, String signature, String deviceKey, String deviceName, final Function1<? super DeviceSetUser.DeviceSetUserResponse, Unit> listener) {
        Intrinsics.checkNotNullParameter(account, "account");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol protocol = new Protocol(new Function0<DeviceSetUser>() { // from class: com.hive.authv4.devicemanagement.DeviceManagementNetwork$deviceSetUser$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.authv4.DeviceSetUser] */
            @Override // kotlin.jvm.functions.Function0
            public final DeviceSetUser invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = DeviceSetUser.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        String vidSession = account.getVidSession();
        if (vidSession != null) {
            protocol.setHeader(HiveKeys.KEY_Authorization, vidSession);
            protocol.setParam(HiveKeys.KEY_player_id, account.getVid());
            protocol.setParam(HiveKeys.KEY_vid_type, account.getVidType());
        }
        OauthToken oauthToken = account.getOauthToken();
        if (oauthToken != null) {
            protocol.setOauthToken(oauthToken);
        }
        String did = account.getDid();
        if (did != null) {
            protocol.setParam(HiveKeys.KEY_did, did);
        }
        protocol.setParam(HiveKeys.KEY_appid, Configuration.INSTANCE.getAppId());
        if (phoneCode != null) {
            if (!(!StringsKt.isBlank(phoneCode))) {
                phoneCode = null;
            }
            if (phoneCode != null) {
                protocol.setParam(HiveKeys.KEY_phone_code, phoneCode);
            }
        }
        if (phoneNumber != null) {
            if (!(!StringsKt.isBlank(phoneNumber))) {
                phoneNumber = null;
            }
            if (phoneNumber != null) {
                protocol.setParam(HiveKeys.KEY_phone_number, phoneNumber);
            }
        }
        protocol.setParam(HiveKeys.KEY_signature, signature);
        protocol.setParam(HiveKeys.KEY_device_key, deviceKey);
        protocol.setParam(HiveKeys.KEY_os, Platform.INSTANCE.getPlatform());
        protocol.setParam(HiveKeys.KEY_device_model, Android.INSTANCE.getDeviceModel());
        protocol.setParam(HiveKeys.KEY_device_name, deviceName);
        protocol.request(new Function1() { // from class: com.hive.authv4.devicemanagement.DeviceManagementNetwork$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DeviceManagementNetwork.deviceSetUser$lambda$45(listener, (DeviceSetUser) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit deviceSetUser$lambda$45(Function1 function1, DeviceSetUser it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(it.getResponse());
        return Unit.INSTANCE;
    }

    public final void smsSend(HiveLifecycle.HiveAccount account, String phoneCode, String phoneNumber, String useApi, final Function1<? super SmsSend.SmsSendResponse, Unit> listener) {
        Intrinsics.checkNotNullParameter(account, "account");
        Intrinsics.checkNotNullParameter(useApi, "useApi");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol protocol = new Protocol(new Function0<SmsSend>() { // from class: com.hive.authv4.devicemanagement.DeviceManagementNetwork$smsSend$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.authv4.SmsSend] */
            @Override // kotlin.jvm.functions.Function0
            public final SmsSend invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = SmsSend.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        String vidSession = account.getVidSession();
        if (vidSession != null) {
            protocol.setHeader(HiveKeys.KEY_Authorization, vidSession);
            protocol.setParam(HiveKeys.KEY_player_id, account.getVid());
            protocol.setParam(HiveKeys.KEY_vid_type, account.getVidType());
        }
        OauthToken oauthToken = account.getOauthToken();
        if (oauthToken != null) {
            protocol.setOauthToken(oauthToken);
        }
        protocol.setParam(HiveKeys.KEY_appid, Configuration.INSTANCE.getAppId());
        if (phoneCode != null) {
            if (!(!StringsKt.isBlank(phoneCode))) {
                phoneCode = null;
            }
            if (phoneCode != null) {
                protocol.setParam(HiveKeys.KEY_phone_code, phoneCode);
            }
        }
        if (phoneNumber != null) {
            if (!(!StringsKt.isBlank(phoneNumber))) {
                phoneNumber = null;
            }
            if (phoneNumber != null) {
                protocol.setParam(HiveKeys.KEY_phone_number, phoneNumber);
            }
        }
        protocol.setParam(HiveKeys.KEY_type, "DEVICE");
        protocol.setParam(HiveKeys.KEY_use_api, useApi);
        protocol.request(new Function1() { // from class: com.hive.authv4.devicemanagement.DeviceManagementNetwork$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DeviceManagementNetwork.smsSend$lambda$53(listener, (SmsSend) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit smsSend$lambda$53(Function1 function1, SmsSend it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(it.getResponse());
        return Unit.INSTANCE;
    }

    public final void smsVerify(HiveLifecycle.HiveAccount account, String signature, String code, final Function1<? super SmsVerify.SmsVerifyResponse, Unit> listener) {
        Intrinsics.checkNotNullParameter(account, "account");
        Intrinsics.checkNotNullParameter(signature, "signature");
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol protocol = new Protocol(new Function0<SmsVerify>() { // from class: com.hive.authv4.devicemanagement.DeviceManagementNetwork$smsVerify$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.authv4.SmsVerify] */
            @Override // kotlin.jvm.functions.Function0
            public final SmsVerify invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = SmsVerify.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        String vidSession = account.getVidSession();
        if (vidSession != null) {
            protocol.setHeader(HiveKeys.KEY_Authorization, vidSession);
            protocol.setParam(HiveKeys.KEY_player_id, account.getVid());
            protocol.setParam(HiveKeys.KEY_vid_type, account.getVidType());
        }
        OauthToken oauthToken = account.getOauthToken();
        if (oauthToken != null) {
            protocol.setOauthToken(oauthToken);
        }
        protocol.setParam(HiveKeys.KEY_appid, Configuration.INSTANCE.getAppId());
        protocol.setParam(HiveKeys.KEY_signature, signature);
        protocol.setParam(HiveKeys.KEY_code, code);
        protocol.request(new Function1() { // from class: com.hive.authv4.devicemanagement.DeviceManagementNetwork$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DeviceManagementNetwork.smsVerify$lambda$57(listener, (SmsVerify) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit smsVerify$lambda$57(Function1 function1, SmsVerify it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(it.getResponse());
        return Unit.INSTANCE;
    }
}
