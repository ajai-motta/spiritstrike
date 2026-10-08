package com.hive.userengagement;

import com.hive.base.Android;
import com.hive.core.CommonIdentifierKt;
import com.hive.core.Configuration;
import com.hive.core.HiveKeys;
import com.hive.core.Logger;
import com.hive.core.OauthToken;
import com.hive.core.Platform;
import com.hive.protocol.Protocol;
import com.hive.protocol.ProtocolRequest;
import com.hive.protocol.promotionv2.DeferredMatch;
import com.hive.protocol.userengagement.ConsumeCoupon;
import com.hive.standalone.HiveLifecycle;
import java.lang.reflect.InvocationTargetException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J;\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\nJ9\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00050\n¨\u0006\u0013"}, d2 = {"Lcom/hive/userengagement/UserEngagementNetwork;", "", "<init>", "()V", "consumeCoupon", "", "couponCode", "", "additionalInfo", "callback", "Lkotlin/Function1;", "Lcom/hive/protocol/userengagement/ConsumeCoupon;", "Lkotlin/ParameterName;", "name", "deferredMatch", "cssScreenSizeWidth", "", "cssScreenSizeHeight", "Lcom/hive/protocol/promotionv2/DeferredMatch;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UserEngagementNetwork {
    public static final UserEngagementNetwork INSTANCE = new UserEngagementNetwork();

    private UserEngagementNetwork() {
    }

    public static /* synthetic */ void consumeCoupon$default(UserEngagementNetwork userEngagementNetwork, String str, String str2, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        userEngagementNetwork.consumeCoupon(str, str2, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit consumeCoupon$lambda$1(Function1 function1, ConsumeCoupon it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit deferredMatch$lambda$3(Function1 function1, DeferredMatch it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(it);
        return Unit.INSTANCE;
    }

    public final void consumeCoupon(String couponCode, String additionalInfo, final Function1<? super ConsumeCoupon, Unit> callback) {
        Intrinsics.checkNotNullParameter(couponCode, "couponCode");
        Intrinsics.checkNotNullParameter(additionalInfo, "additionalInfo");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol protocol = new Protocol(new Function0<ConsumeCoupon>() { // from class: com.hive.userengagement.UserEngagementNetwork$consumeCoupon$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.userengagement.ConsumeCoupon] */
            @Override // kotlin.jvm.functions.Function0
            public final ConsumeCoupon invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = ConsumeCoupon.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        try {
            HiveLifecycle hiveLifecycle = HiveLifecycle.INSTANCE;
            String vid = hiveLifecycle.getAccount().getVid();
            if (vid == null) {
                vid = "";
            }
            Long longOrNull = StringsKt.toLongOrNull(vid);
            long jLongValue = longOrNull != null ? longOrNull.longValue() : 0L;
            protocol.setParam(HiveKeys.KEY_language, Platform.INSTANCE.getLanguage());
            HiveKeys hiveKeys = HiveKeys.KEY_appid;
            Configuration configuration = Configuration.INSTANCE;
            protocol.setParam(hiveKeys, configuration.getAppId());
            protocol.setParam(HiveKeys.KEY_server_id, configuration.getServerId());
            protocol.setParam(HiveKeys.KEY_coupon, couponCode);
            protocol.setParam(HiveKeys.KEY_user, Long.valueOf(jLongValue));
            protocol.setParam(HiveKeys.KEY_additionalinfo, additionalInfo);
            OauthToken oauthToken = hiveLifecycle.getAccount().getOauthToken();
            if (oauthToken != null) {
                protocol.setOauthToken(oauthToken);
            }
        } catch (Exception e) {
            Logger.INSTANCE.w("Failed consumeCoupon()\nmessage: " + e.getMessage());
        }
        protocol.request(new Function1() { // from class: com.hive.userengagement.UserEngagementNetwork$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UserEngagementNetwork.consumeCoupon$lambda$1(callback, (ConsumeCoupon) obj);
            }
        });
    }

    public final void deferredMatch(int cssScreenSizeWidth, int cssScreenSizeHeight, final Function1<? super DeferredMatch, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol protocol = new Protocol(new Function0<DeferredMatch>() { // from class: com.hive.userengagement.UserEngagementNetwork$deferredMatch$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.promotionv2.DeferredMatch] */
            @Override // kotlin.jvm.functions.Function0
            public final DeferredMatch invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = DeferredMatch.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        try {
            HiveLifecycle hiveLifecycle = HiveLifecycle.INSTANCE;
            HiveLifecycle.HiveAccount account = hiveLifecycle.getAccount();
            String vid = account.getVid();
            String vid2 = (vid == null || StringsKt.isBlank(vid)) ? "-703" : account.getVid();
            String vidType = account.getVidType();
            String did = hiveLifecycle.getDid();
            JSONObject jSONObjectPutCI = CommonIdentifierKt.putCI(new JSONObject());
            CommonIdentifierKt.put(jSONObjectPutCI, HiveKeys.KEY_vid, vid2);
            CommonIdentifierKt.put(jSONObjectPutCI, HiveKeys.KEY_vid_type, vidType);
            CommonIdentifierKt.put(jSONObjectPutCI, HiveKeys.KEY_uid, account.getUid());
            HiveKeys hiveKeys = HiveKeys.KEY_world;
            Configuration configuration = Configuration.INSTANCE;
            CommonIdentifierKt.put(jSONObjectPutCI, hiveKeys, configuration.getServerId());
            CommonIdentifierKt.put(jSONObjectPutCI, HiveKeys.KEY_did, did);
            CommonIdentifierKt.put(jSONObjectPutCI, HiveKeys.KEY_language, configuration.getGameLanguage());
            HiveKeys hiveKeys2 = HiveKeys.KEY_country;
            Android android2 = Android.INSTANCE;
            CommonIdentifierKt.put(jSONObjectPutCI, hiveKeys2, android2.getCountry());
            CommonIdentifierKt.put(jSONObjectPutCI, HiveKeys.KEY_width, String.valueOf(cssScreenSizeWidth));
            CommonIdentifierKt.put(jSONObjectPutCI, HiveKeys.KEY_height, String.valueOf(cssScreenSizeHeight));
            CommonIdentifierKt.put(jSONObjectPutCI, HiveKeys.KEY_device, android2.getDeviceModel());
            CommonIdentifierKt.put(jSONObjectPutCI, HiveKeys.KEY_os_version, android2.getOSVersion());
            CommonIdentifierKt.put(jSONObjectPutCI, HiveKeys.KEY_advertising_id, android2.getAdvertisingId());
            CommonIdentifierKt.put(jSONObjectPutCI, HiveKeys.KEY_is_limit_ad_tracking, Integer.valueOf(android2.isLimitAdTracking() ? 1 : 0));
            JSONObject jSONObject = new JSONObject();
            CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_appid, configuration.getAppId());
            CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_app_version, android2.getAppVersion());
            CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_lib_version, JSONObject.NULL);
            CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_sdk_version, configuration.getSdkVersion());
            protocol.setParam(HiveKeys.KEY_user, jSONObjectPutCI);
            protocol.setParam(HiveKeys.KEY_game, jSONObject);
            OauthToken oauthToken = hiveLifecycle.getAccount().getOauthToken();
            if (oauthToken != null) {
                protocol.setOauthToken(oauthToken);
            }
        } catch (Exception e) {
            Logger.INSTANCE.w("Failed deferredMatch()\nmessage: " + e.getMessage());
        }
        protocol.request(new Function1() { // from class: com.hive.userengagement.UserEngagementNetwork$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UserEngagementNetwork.deferredMatch$lambda$3(callback, (DeferredMatch) obj);
            }
        });
    }
}
