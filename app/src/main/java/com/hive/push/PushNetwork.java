package com.hive.push;

import android.os.Bundle;
import com.hive.Configuration;
import com.hive.Push;
import com.hive.base.Android;
import com.hive.base.Property;
import com.hive.configuration.ConfigurationImpl;
import com.hive.core.CommonIdentifierKt;
import com.hive.core.HiveKeys;
import com.hive.core.OauthToken;
import com.hive.logger.LoggerImpl;
import com.hive.protocol.Protocol;
import com.hive.protocol.ProtocolRequest;
import com.hive.protocol.pushv4.AgreementInfo;
import com.hive.protocol.pushv4.FcmInfo;
import com.hive.protocol.pushv4.Opens;
import com.hive.protocol.pushv4.SenderId;
import com.hive.protocol.pushv4.Tokens;
import com.hive.push.PushImpl;
import com.hive.standalone.HiveLifecycle;
import com.moloco.sdk.internal.services.init.i;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JN\u0010\u0004\u001a\u00020\u00052F\u0010\u0006\u001aB\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0004\u0012#\u0012!\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\u000e¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00050\u0007J)\u0010\u000f\u001a\u00020\u00052!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00050\u0010JM\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\f2!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00050\u0010J1\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001e2!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u001f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00050\u0010J5\u0010 \u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110!¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00050\u0010H\u0007¨\u0006\""}, d2 = {"Lcom/hive/push/PushNetwork;", "", "<init>", "()V", "senderId", "", "callback", "Lkotlin/Function2;", "Lcom/hive/protocol/pushv4/SenderId;", "Lkotlin/ParameterName;", "name", "Ljava/util/ArrayList;", "", "senderIds", "Lkotlin/collections/ArrayList;", "fcmInfo", "Lkotlin/Function1;", "Lcom/hive/protocol/pushv4/FcmInfo;", "tokens", "", "hiveAccount", "Lcom/hive/standalone/HiveLifecycle$HiveAccount;", "remotePush", "Lcom/hive/Push$RemotePush;", "remotePushType", "Lcom/hive/push/PushImpl$RemotePushType;", "logMessage", "Lcom/hive/protocol/pushv4/Tokens;", "opens", "data", "Landroid/os/Bundle;", "Lcom/hive/protocol/pushv4/Opens;", "agreementInfo", "Lcom/hive/protocol/pushv4/AgreementInfo;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PushNetwork {
    public static final PushNetwork INSTANCE = new PushNetwork();

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PushImpl.RemotePushType.values().length];
            try {
                iArr[PushImpl.RemotePushType.FCM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PushImpl.RemotePushType.ADM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PushImpl.RemotePushType.FA2U.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private PushNetwork() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit agreementInfo$lambda$11(Function1 function1, AgreementInfo it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit fcmInfo$lambda$3(Function1 function1, FcmInfo it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit opens$lambda$9(Function1 function1, Opens it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit senderId$lambda$0(Function2 function2, SenderId it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function2.invoke(it, it.getResponse().getSenderIds());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit tokens$lambda$6(Function1 function1, Tokens it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(it);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0074 A[Catch: Exception -> 0x008c, TryCatch #0 {Exception -> 0x008c, blocks: (B:4:0x0015, B:5:0x001b, B:7:0x0027, B:11:0x0046, B:13:0x004d, B:15:0x0054, B:16:0x005d, B:18:0x0063, B:20:0x006a, B:21:0x0074, B:23:0x007c, B:25:0x0083, B:8:0x0031, B:10:0x003d), top: B:42:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0027 A[Catch: Exception -> 0x008c, TryCatch #0 {Exception -> 0x008c, blocks: (B:4:0x0015, B:5:0x001b, B:7:0x0027, B:11:0x0046, B:13:0x004d, B:15:0x0054, B:16:0x005d, B:18:0x0063, B:20:0x006a, B:21:0x0074, B:23:0x007c, B:25:0x0083, B:8:0x0031, B:10:0x003d), top: B:42:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0031 A[Catch: Exception -> 0x008c, TryCatch #0 {Exception -> 0x008c, blocks: (B:4:0x0015, B:5:0x001b, B:7:0x0027, B:11:0x0046, B:13:0x004d, B:15:0x0054, B:16:0x005d, B:18:0x0063, B:20:0x006a, B:21:0x0074, B:23:0x007c, B:25:0x0083, B:8:0x0031, B:10:0x003d), top: B:42:0x0015 }] */
    @kotlin.Deprecated(message = "4.14.0")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void agreementInfo(com.hive.standalone.HiveLifecycle.HiveAccount r8, final kotlin.jvm.functions.Function1<? super com.hive.protocol.pushv4.AgreementInfo, kotlin.Unit> r9) {
        /*
            Method dump skipped, instruction units count: 311
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.push.PushNetwork.agreementInfo(com.hive.standalone.HiveLifecycle$HiveAccount, kotlin.jvm.functions.Function1):void");
    }

    public final void fcmInfo(final Function1<? super FcmInfo, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol protocol = new Protocol(new Function0<FcmInfo>() { // from class: com.hive.push.PushNetwork$fcmInfo$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.pushv4.FcmInfo] */
            @Override // kotlin.jvm.functions.Function0
            public final FcmInfo invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = FcmInfo.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        OauthToken oauthToken = HiveLifecycle.INSTANCE.getAccount().getOauthToken();
        if (oauthToken != null) {
            protocol.setOauthToken(oauthToken);
        }
        protocol.request(new Function1() { // from class: com.hive.push.PushNetwork$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PushNetwork.fcmInfo$lambda$3(callback, (FcmInfo) obj);
            }
        });
    }

    public final void opens(Bundle data, final Function1<? super Opens, Unit> callback) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol protocol = new Protocol(new Function0<Opens>() { // from class: com.hive.push.PushNetwork$opens$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.pushv4.Opens] */
            @Override // kotlin.jvm.functions.Function0
            public final Opens invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = Opens.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        try {
            String string = data.getString("open");
            if (string != null) {
                JSONObject jSONObject = new JSONObject(string);
                Iterator<String> itKeys = jSONObject.keys();
                Intrinsics.checkNotNullExpressionValue(itKeys, "keys(...)");
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    Intrinsics.checkNotNull(next);
                    protocol.setParam(next, jSONObject.get(next));
                }
            }
        } catch (Exception e) {
            LoggerImpl.INSTANCE.w(Push.getTAG(), "[PushNetwork] opens Exception: " + e);
        }
        protocol.request(new Function1() { // from class: com.hive.push.PushNetwork$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PushNetwork.opens$lambda$9(callback, (Opens) obj);
            }
        });
    }

    public final void senderId(final Function2<? super SenderId, ? super ArrayList<String>, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol protocol = new Protocol(new Function0<SenderId>() { // from class: com.hive.push.PushNetwork$senderId$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.pushv4.SenderId] */
            @Override // kotlin.jvm.functions.Function0
            public final SenderId invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = SenderId.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        try {
            protocol.setParam(HiveKeys.KEY_appid, ConfigurationImpl.INSTANCE.getAppId());
        } catch (Exception e) {
            LoggerImpl.INSTANCE.w(Push.getTAG(), "[PushNetwork] sender Exception: " + e);
        }
        protocol.request(new Function1() { // from class: com.hive.push.PushNetwork$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PushNetwork.senderId$lambda$0(callback, (SenderId) obj);
            }
        });
    }

    public final boolean tokens(HiveLifecycle.HiveAccount hiveAccount, Push.RemotePush remotePush, PushImpl.RemotePushType remotePushType, String logMessage, final Function1<? super Tokens, Unit> callback) {
        HiveLifecycle.HiveAccount account;
        Push.RemotePush remotePush2;
        Object obj;
        String value;
        String value2;
        String str;
        Object obj2;
        Object obj3;
        Intrinsics.checkNotNullParameter(remotePushType, "remotePushType");
        Intrinsics.checkNotNullParameter(logMessage, "logMessage");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol protocol = new Protocol(new Function0<Tokens>() { // from class: com.hive.push.PushNetwork$tokens$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.pushv4.Tokens] */
            @Override // kotlin.jvm.functions.Function0
            public final Tokens invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = Tokens.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        if (hiveAccount == null) {
            try {
                account = HiveLifecycle.INSTANCE.getAccount();
            } catch (Exception e) {
                LoggerImpl.INSTANCE.w(Push.getTAG(), "[PushNetwork] tokens Exception: " + e);
            }
        } else {
            account = hiveAccount;
        }
        if (remotePush == null) {
            Property.Companion companion2 = Property.INSTANCE;
            Property instance = companion2.getINSTANCE();
            PushKeys pushKeys = PushKeys.INSTANCE;
            remotePush2 = new Push.RemotePush(Boolean.parseBoolean(instance.getValue(pushKeys.getIS_AGREE_NOTICE(), "false")), Boolean.parseBoolean(companion2.getINSTANCE().getValue(pushKeys.getIS_AGREE_NIGHT(), "false")));
        } else {
            remotePush2 = remotePush;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[remotePushType.ordinal()];
        if (i != 1) {
            if (i == 2) {
                obj = "amazon";
                value2 = Property.INSTANCE.getINSTANCE().getValue(PushKeys.INSTANCE.getREGID_AMAZON());
            } else {
                if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                obj = "facebook";
                value2 = Property.INSTANCE.getINSTANCE().getValue(PushKeys.INSTANCE.getREGID_FACEBOOK());
            }
            value = null;
        } else {
            obj = "google";
            Property.Companion companion3 = Property.INSTANCE;
            Property instance2 = companion3.getINSTANCE();
            PushKeys pushKeys2 = PushKeys.INSTANCE;
            String value3 = instance2.getValue(pushKeys2.getREGID_FCM());
            value = companion3.getINSTANCE().getValue(pushKeys2.getFCM_SENDER_ID());
            value2 = value3;
        }
        Object obj4 = obj;
        if (value2 != null && !StringsKt.isBlank(value2)) {
            JSONObject jSONObject = new JSONObject();
            try {
                HiveKeys hiveKeys = HiveKeys.KEY_country;
                Android android2 = Android.INSTANCE;
                str = value;
                try {
                    CommonIdentifierKt.put(jSONObject, hiveKeys, android2.getCountry());
                    CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_language, android2.getLanguage());
                    CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_model, android2.getDeviceModel());
                    obj2 = jSONObject;
                    obj3 = value2;
                } catch (Exception e2) {
                    e = e2;
                    obj2 = jSONObject;
                    obj3 = value2;
                    LoggerImpl.INSTANCE.w(Push.getTAG(), "[PushNetwork] tokens (device) Exception: " + e);
                }
            } catch (Exception e3) {
                e = e3;
                str = value;
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                if (Intrinsics.areEqual(i.f2373a, account.getVidType())) {
                    CommonIdentifierKt.put(jSONObject2, HiveKeys.KEY_vid, account.getVid());
                } else if (Intrinsics.areEqual("v4", account.getVidType())) {
                    CommonIdentifierKt.put(jSONObject2, HiveKeys.KEY_playerId, account.getVid());
                }
                if (account.getUid() != null && (!StringsKt.isBlank(r0))) {
                    CommonIdentifierKt.put(jSONObject2, HiveKeys.KEY_uid, account.getUid());
                }
                if (account.getDid() == null || !(!StringsKt.isBlank(r0))) {
                    String did = HiveLifecycle.INSTANCE.getDid();
                    if (did != null && (!StringsKt.isBlank(did))) {
                        CommonIdentifierKt.put(jSONObject2, HiveKeys.KEY_did, did);
                        account.setDid(did);
                    }
                } else {
                    CommonIdentifierKt.put(jSONObject2, HiveKeys.KEY_did, account.getDid());
                }
            } catch (Exception e4) {
                LoggerImpl.INSTANCE.w(Push.getTAG(), "[PushNetwork] tokens (identifier) Exception: " + e4);
            }
            if (account.getVid() == null && account.getUid() == null && account.getDid() == null) {
                LoggerImpl.INSTANCE.w(Push.getTAG(), "[PushNetwork.tokens] Push (" + remotePushType + ") identifier is empty.");
                return false;
            }
            JSONObject jSONObject3 = new JSONObject();
            try {
                CommonIdentifierKt.put(jSONObject3, HiveKeys.KEY_notice, Integer.valueOf(remotePush2.getIsAgreeNotice() ? 1 : 0));
                CommonIdentifierKt.put(jSONObject3, HiveKeys.KEY_night, Integer.valueOf(remotePush2.getIsAgreeNight() ? 1 : 0));
            } catch (Exception e5) {
                LoggerImpl.INSTANCE.w(Push.getTAG(), "[PushNetwork] tokens (agreement) Exception: " + e5);
            }
            JSONObject jSONObject4 = new JSONObject();
            try {
                HiveKeys hiveKeys2 = HiveKeys.KEY_appid;
                ConfigurationImpl configurationImpl = ConfigurationImpl.INSTANCE;
                CommonIdentifierKt.put(jSONObject4, hiveKeys2, configurationImpl.getAppId());
                HiveKeys hiveKeys3 = HiveKeys.KEY_app_version_display;
                Android android3 = Android.INSTANCE;
                CommonIdentifierKt.put(jSONObject4, hiveKeys3, android3.getAppVersion());
                CommonIdentifierKt.put(jSONObject4, HiveKeys.KEY_version, android3.getAppVersion());
                CommonIdentifierKt.put(jSONObject4, HiveKeys.KEY_sdk_version, Configuration.getHiveSDKVersion());
                CommonIdentifierKt.put(jSONObject4, HiveKeys.KEY_game_language, configurationImpl.getHiveLanguage());
                CommonIdentifierKt.put(jSONObject4, HiveKeys.KEY_server_id, configurationImpl.getServerId());
            } catch (Exception e6) {
                LoggerImpl.INSTANCE.w(Push.getTAG(), "[PushNetwork] tokens (app) Exception: " + e6);
            }
            Object hiveTimeZone = ConfigurationImpl.INSTANCE.getHiveTimeZone();
            JSONObject jSONObject5 = new JSONObject();
            try {
                long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
                CommonIdentifierKt.put(jSONObject5, HiveKeys.KEY_msg, logMessage);
                CommonIdentifierKt.put(jSONObject5, HiveKeys.KEY_timestamp, Long.valueOf(jCurrentTimeMillis));
            } catch (Exception e7) {
                LoggerImpl.INSTANCE.w(Push.getTAG(), "[PushNetwork] tokens (log) Exception: " + e7);
            }
            protocol.setParam(HiveKeys.KEY_os, "android");
            protocol.setParam(HiveKeys.KEY_market, obj4);
            protocol.setParam(HiveKeys.KEY_token, obj3);
            if (str != null && (!StringsKt.isBlank(str))) {
                protocol.setParam(HiveKeys.KEY_senderId, str);
            }
            protocol.setParam(HiveKeys.KEY_device, obj2);
            protocol.setParam(HiveKeys.KEY_identifier, jSONObject2);
            protocol.setParam(HiveKeys.KEY_agreement, jSONObject3);
            protocol.setParam(HiveKeys.KEY_app, jSONObject4);
            protocol.setParam(HiveKeys.KEY_timezone, hiveTimeZone);
            protocol.setParam(HiveKeys.KEY_log, jSONObject5);
            OauthToken oauthToken = HiveLifecycle.INSTANCE.getAccount().getOauthToken();
            if (oauthToken != null) {
                protocol.setOauthToken(oauthToken);
            }
            protocol.request(new Function1() { // from class: com.hive.push.PushNetwork$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj5) {
                    return PushNetwork.tokens$lambda$6(callback, (Tokens) obj5);
                }
            });
            return true;
        }
        LoggerImpl.INSTANCE.w(Push.getTAG(), "[PushNetwork.tokens] Push (" + remotePushType + ") regId is empty.");
        return false;
    }
}
