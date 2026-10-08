package com.hive.userengagement;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.AuthV4;
import com.hive.IAPV4;
import com.hive.Promotion;
import com.hive.ResultAPI;
import com.hive.SocialHive;
import com.hive.SocialV4;
import com.hive.analytics.AnalyticsReferrerSender;
import com.hive.auth.AuthDataInterface;
import com.hive.base.Property;
import com.hive.core.CommonIdentifierKt;
import com.hive.core.HiveKeys;
import com.hive.logger.LoggerImpl;
import com.hive.module.HiveModule;
import com.hive.module.HiveModuleManager;
import com.hive.module.interfaces.HiveAuth;
import com.hive.module.interfaces.HiveAuthV4;
import com.hive.module.interfaces.HiveIapV4;
import com.hive.module.interfaces.HivePromotion;
import com.hive.module.interfaces.HiveSocial;
import com.hive.module.interfaces.HiveSocialV4;
import com.hive.module.interfaces.HiveUserEngagement;
import com.hive.protocol.promotionv2.DeferredMatch;
import com.hive.standalone.HiveLifecycle;
import com.hive.userengagement.UserEngagementCoupon;
import com.hive.userengagement.UserEngagementEvent;
import com.moloco.sdk.internal.services.init.i;
import com.unity3d.services.ads.gmascar.utils.ScarConstants;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000bJ\u001e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020!J\u000e\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u0005J\u0015\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u000bH\u0000¢\u0006\u0002\b&J\r\u0010$\u001a\u00020\u001dH\u0000¢\u0006\u0002\b&J\u0012\u0010'\u001a\u00020\u000b2\b\u0010(\u001a\u0004\u0018\u00010\bH\u0002J\u0018\u0010)\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020+2\u0006\u0010(\u001a\u00020\bH\u0002J\u0018\u0010,\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020+2\u0006\u0010(\u001a\u00020\bH\u0002J\u0018\u0010-\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020+2\u0006\u0010(\u001a\u00020\bH\u0002J\u0018\u0010.\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020+2\u0006\u0010(\u001a\u00020\bH\u0002J\u0018\u0010/\u001a\u00020\u000b2\u0006\u00100\u001a\u00020+2\u0006\u0010(\u001a\u00020\bH\u0002J\u0010\u00101\u001a\u0002022\u0006\u0010(\u001a\u00020\bH\u0002J\u0010\u00103\u001a\u00020\u001d2\u0006\u00104\u001a\u000205H\u0002J\u001a\u00103\u001a\u00020\u001d2\u0006\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u000102H\u0002J\"\u00107\u001a\u00020\u001d2\u0006\u00108\u001a\u00020\u001a2\u0006\u00104\u001a\u0002052\b\u00109\u001a\u0004\u0018\u000102H\u0002J\b\u0010:\u001a\u00020\u001dH\u0002J\n\u0010;\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010<\u001a\u00020\u001dH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u001e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006="}, d2 = {"Lcom/hive/userengagement/UserEngagement;", "", "<init>", "()V", "USED_FIRST_LAUNCH_DIRECTLINK_INFO", "", "userEngagementEvents", "Ljava/util/ArrayList;", "Lcom/hive/userengagement/UserEngagementEvent;", "Lkotlin/collections/ArrayList;", "value", "", "isReadyToProcess", "isReadyToProcess$hive_service_release", "()Z", "isRunningHandleEvent", "isRunningHandleEvent$hive_service_release", "isEventActive", "isEventActive$hive_service_release", "engagementListener", "Lcom/hive/module/interfaces/HiveUserEngagement$UserEngagementListener;", "getEngagementListener", "()Lcom/hive/module/interfaces/HiveUserEngagement$UserEngagementListener;", "setEngagementListener", "(Lcom/hive/module/interfaces/HiveUserEngagement$UserEngagementListener;)V", "setEngagementReady", "Lcom/hive/ResultAPI;", "isReady", "consumeCoupon", "", "couponCode", "additionalInfo", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/userengagement/UserEngagementCoupon$CouponListener;", "processUri", ShareConstants.MEDIA_URI, "handleEvents", "needToRunNextEvent", "handleEvents$hive_service_release", "handleInterwork", "userEngagementEvent", "handleAuth", "api", "Lcom/hive/module/interfaces/HiveUserEngagement$InterworkApi;", "handleSocial", "handlePromotion", "handleUserEngagement", "handleIAP", "interworkApi", "makeEngagementStartCallback", "Lorg/json/JSONObject;", "onEngagementStart", "engagementEventType", "Lcom/hive/module/interfaces/HiveUserEngagement$EventType;", "param", "onEngagementEnd", "result", "resultJsonObject", "processFirstLaunchDirectlinkScheme", "getDirectlinkSchemeFromReferrer", "requestFirstLaunchDirectlinkData", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UserEngagement {
    public static final String USED_FIRST_LAUNCH_DIRECTLINK_INFO = "ue.user_first_launch_directlink_info";
    private static HiveUserEngagement.UserEngagementListener engagementListener;
    private static boolean isEventActive;
    private static boolean isReadyToProcess;
    private static boolean isRunningHandleEvent;
    public static final UserEngagement INSTANCE = new UserEngagement();
    private static final ArrayList<UserEngagementEvent> userEngagementEvents = new ArrayList<>();

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[HiveUserEngagement.InterworkTarget.values().length];
            try {
                iArr[HiveUserEngagement.InterworkTarget.AUTH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[HiveUserEngagement.InterworkTarget.SOCIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[HiveUserEngagement.InterworkTarget.PROMOTION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[HiveUserEngagement.InterworkTarget.USERENGAGEMENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[HiveUserEngagement.InterworkTarget.IAP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[HiveUserEngagement.InterworkApi.values().length];
            try {
                iArr2[HiveUserEngagement.InterworkApi.AUTHLOGIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[HiveUserEngagement.InterworkApi.SOCIALINQUIRY.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[HiveUserEngagement.InterworkApi.SOCIALINQUERY.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[HiveUserEngagement.InterworkApi.SOCIALMYINQUIRY.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[HiveUserEngagement.InterworkApi.SOCIALPROFILE.ordinal()] = 5;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr2[HiveUserEngagement.InterworkApi.COMMUNITYSHOW.ordinal()] = 6;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr2[HiveUserEngagement.InterworkApi.SOCIALCOMMUNITY.ordinal()] = 7;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr2[HiveUserEngagement.InterworkApi.OFFERWALLSHOW.ordinal()] = 8;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr2[HiveUserEngagement.InterworkApi.PROMOTIONOFFERWALL.ordinal()] = 9;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr2[HiveUserEngagement.InterworkApi.PROMOTIONSHOW.ordinal()] = 10;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr2[HiveUserEngagement.InterworkApi.PROMOTIONCOMPANION.ordinal()] = 11;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr2[HiveUserEngagement.InterworkApi.PROMOTIONCOUPON.ordinal()] = 12;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr2[HiveUserEngagement.InterworkApi.IAPPURCHASE.ordinal()] = 13;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr2[HiveUserEngagement.InterworkApi.IAPPROMOTE.ordinal()] = 14;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr2[HiveUserEngagement.InterworkApi.IAPUPDATED.ordinal()] = 15;
            } catch (NoSuchFieldError unused20) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    private UserEngagement() {
    }

    private final String getDirectlinkSchemeFromReferrer() {
        String string;
        String referrer = AnalyticsReferrerSender.INSTANCE.getReferrer();
        if (referrer == null) {
            return null;
        }
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.d("[UserEngagement] getDirectlinkSchemeFromReferrer, find referrer : " + referrer);
        try {
            JSONObject jSONObject = new JSONObject(URLDecoder.decode(referrer, "UTF-8"));
            if (jSONObject.has("scheme") && (string = jSONObject.getString("scheme")) != null && string.length() != 0) {
                loggerImpl.d("[UserEngagement] getDirectlinkSchemeFromReferrer, scheme data from referrer : " + jSONObject.getString("scheme"));
                return jSONObject.getString("scheme");
            }
            Unit unit = Unit.INSTANCE;
            return null;
        } catch (Exception e) {
            LoggerImpl.INSTANCE.w("[UserEngagement] getDirectlinkSchemeFromReferrer exception : " + e);
            Unit unit2 = Unit.INSTANCE;
            return null;
        }
    }

    private final boolean handleAuth(HiveUserEngagement.InterworkApi api, UserEngagementEvent userEngagementEvent) {
        String uid;
        HiveLifecycle hiveLifecycle = HiveLifecycle.INSTANCE;
        HiveLifecycle.HiveAccount account = hiveLifecycle.getAccount();
        JSONObject jSONObjectMakeEngagementStartCallback = makeEngagementStartCallback(userEngagementEvent);
        HashMap<String, String> hashMapQuery = userEngagementEvent.getHashMapQuery();
        final String scheme = userEngagementEvent.getScheme();
        HiveModuleManager hiveModuleManager = HiveModuleManager.INSTANCE;
        String name = HiveAuth.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        HiveModule hiveModule = hiveModuleManager.getHiveModule(name);
        if (!(hiveModule instanceof HiveAuth)) {
            hiveModule = null;
        }
        HiveAuth hiveAuth = (HiveAuth) (hiveModule instanceof HiveAuth ? hiveModule : null);
        if (hiveAuth == null) {
            return false;
        }
        if (WhenMappings.$EnumSwitchMapping$1[api.ordinal()] != 1) {
            LoggerImpl.INSTANCE.d("[Promotion::UserEngagementImpl::handleAuth] default");
            return false;
        }
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.d("[Promotion::UserEngagementImpl::handleAuth] AUTHLOGIN");
        if (!Intrinsics.areEqual(account.getVidType(), i.f2373a)) {
            if (Intrinsics.areEqual(account.getVidType(), "v4")) {
                loggerImpl.d("[Promotion::UserEngagementImpl::handleAuth] AUTHLOGIN : Not Supprot On AuthV4");
                return false;
            }
            loggerImpl.d("[Promotion::UserEngagementImpl::handleAuth] AUTHLOGIN : vidType type is unknown : " + account.getVidType());
            return false;
        }
        if (hiveLifecycle.isSignIn() && (uid = account.getUid()) != null && (!StringsKt.isBlank(uid))) {
            loggerImpl.d("[Promotion::UserEngagementImpl::handleAuth] AUTHLOGIN : Only guest user is acceptable.");
            return false;
        }
        onEngagementStart(HiveUserEngagement.EventType.AUTH_LOGIN_VIEW, jSONObjectMakeEngagementStartCallback);
        UserEngagementEvent.INSTANCE.setQueryParameters(hashMapQuery);
        hiveAuth.login(AuthDataInterface.LoginType.ACCOUNT, new AuthDataInterface.AuthLoginListener() { // from class: com.hive.userengagement.UserEngagement.handleAuth.1
            @Override // com.hive.auth.AuthDataInterface.AuthLoginListener
            public void onAuthLogin(ResultAPI result, AuthDataInterface.LoginType loginType, AuthDataInterface.Account currentAccount, AuthDataInterface.Account usedAccount) throws JSONException {
                String lowerCase;
                String strName;
                Intrinsics.checkNotNullParameter(result, "result");
                JSONObject jSONObject = new JSONObject();
                CommonIdentifierKt.putCheck(jSONObject, "scheme", scheme);
                if (result.isSuccess()) {
                    if (HiveLifecycle.INSTANCE.isInitializeSdkV1()) {
                        if (loginType == null || (strName = loginType.name()) == null) {
                            lowerCase = null;
                        } else {
                            lowerCase = strName.toLowerCase(Locale.ROOT);
                            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                        }
                        CommonIdentifierKt.putCheck(jSONObject, "type", lowerCase);
                        CommonIdentifierKt.putCheck(jSONObject, "currentVid", currentAccount != null ? currentAccount.getVid() : null);
                        CommonIdentifierKt.putCheck(jSONObject, "usedVid", usedAccount != null ? usedAccount.getVid() : null);
                    } else {
                        CommonIdentifierKt.putCheck(jSONObject, "loginType", loginType != null ? loginType.name() : null);
                        CommonIdentifierKt.putCheck(jSONObject, "currentAccount", currentAccount != null ? currentAccount.toJSON() : null);
                        CommonIdentifierKt.putCheck(jSONObject, "usedAccount", usedAccount != null ? usedAccount.toJSON() : null);
                    }
                }
                UserEngagementEvent.INSTANCE.clearQueryParameters();
                UserEngagement userEngagement = UserEngagement.INSTANCE;
                userEngagement.onEngagementEnd(result, HiveUserEngagement.EventType.AUTH_LOGIN_VIEW, jSONObject);
                userEngagement.handleEvents$hive_service_release(true);
            }
        });
        return true;
    }

    private final boolean handleIAP(HiveUserEngagement.InterworkApi interworkApi, UserEngagementEvent userEngagementEvent) throws JSONException {
        String additionalInfo;
        JSONObject jSONObjectMakeEngagementStartCallback = makeEngagementStartCallback(userEngagementEvent);
        HashMap<String, String> hashMapQuery = userEngagementEvent.getHashMapQuery();
        HiveModuleManager hiveModuleManager = HiveModuleManager.INSTANCE;
        String name = HiveIapV4.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        HiveModule hiveModule = hiveModuleManager.getHiveModule(name);
        if (!(hiveModule instanceof HiveIapV4)) {
            hiveModule = null;
        }
        if (!(hiveModule instanceof HiveIapV4)) {
            hiveModule = null;
        }
        HiveIapV4 hiveIapV4 = (HiveIapV4) hiveModule;
        if (hiveIapV4 == null) {
            return false;
        }
        switch (WhenMappings.$EnumSwitchMapping$1[interworkApi.ordinal()]) {
            case 13:
                String str = hashMapQuery.get("marketpid");
                String str2 = hashMapQuery.get("quantity");
                int i = str2 != null ? Integer.parseInt(str2) : 1;
                String name2 = HivePromotion.class.getName();
                Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
                HiveModule hiveModule2 = hiveModuleManager.getHiveModule(name2);
                if (!(hiveModule2 instanceof HivePromotion)) {
                    hiveModule2 = null;
                }
                if (!(hiveModule2 instanceof HivePromotion)) {
                    hiveModule2 = null;
                }
                HivePromotion hivePromotion = (HivePromotion) hiveModule2;
                if (hivePromotion == null || (additionalInfo = hivePromotion.getAdditionalInfo()) == null) {
                    additionalInfo = "";
                }
                HiveUserEngagement.EventType eventType = HiveUserEngagement.EventType.IAP_PURCHASE;
                onEngagementStart(eventType, jSONObjectMakeEngagementStartCallback);
                if (str == null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("iapV4Receipt", (Object) null);
                        onEngagementEnd(new ResultAPI(-1, ResultAPI.Code.UserEngagementEmptyMarketPid, "marketpid is null"), eventType, jSONObject);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    isReadyToProcess = false;
                    handleEvents$hive_service_release(true);
                } else {
                    hiveIapV4.purchase(str, additionalInfo, i, new IAPV4.IAPV4PurchaseListener() { // from class: com.hive.userengagement.UserEngagement.handleIAP.1
                        /* JADX WARN: Removed duplicated region for block: B:7:0x0014 A[Catch: JSONException -> 0x0021, TryCatch #0 {JSONException -> 0x0021, blocks: (B:5:0x000e, B:8:0x0016, B:7:0x0014), top: B:14:0x000e }] */
                        @Override // com.hive.IAPV4.IAPV4PurchaseListener
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct code enable 'Show inconsistent code' option in preferences
                        */
                        public void onIAPV4Purchase(com.hive.ResultAPI r3, com.hive.IAPV4.IAPV4Receipt r4) throws org.json.JSONException {
                            /*
                                r2 = this;
                                java.lang.String r0 = "result"
                                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                                org.json.JSONObject r0 = new org.json.JSONObject
                                r0.<init>()
                                java.lang.String r1 = "iapV4Receipt"
                                if (r4 == 0) goto L14
                                org.json.JSONObject r4 = r4.toJSON()     // Catch: org.json.JSONException -> L21
                                if (r4 != 0) goto L16
                            L14:
                                java.lang.Object r4 = org.json.JSONObject.NULL     // Catch: org.json.JSONException -> L21
                            L16:
                                r0.put(r1, r4)     // Catch: org.json.JSONException -> L21
                                com.hive.userengagement.UserEngagement r4 = com.hive.userengagement.UserEngagement.INSTANCE     // Catch: org.json.JSONException -> L21
                                com.hive.module.interfaces.HiveUserEngagement$EventType r1 = com.hive.module.interfaces.HiveUserEngagement.EventType.IAP_PURCHASE     // Catch: org.json.JSONException -> L21
                                com.hive.userengagement.UserEngagement.access$onEngagementEnd(r4, r3, r1, r0)     // Catch: org.json.JSONException -> L21
                                goto L25
                            L21:
                                r3 = move-exception
                                r3.printStackTrace()
                            L25:
                                r3 = 0
                                com.hive.userengagement.UserEngagement.access$setReadyToProcess$p(r3)
                                com.hive.userengagement.UserEngagement r3 = com.hive.userengagement.UserEngagement.INSTANCE
                                r4 = 1
                                r3.handleEvents$hive_service_release(r4)
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.hive.userengagement.UserEngagement.C29821.onIAPV4Purchase(com.hive.ResultAPI, com.hive.IAPV4$IAPV4Receipt):void");
                        }
                    });
                }
                break;
            case 14:
                String str3 = hashMapQuery.get("marketpid");
                HiveUserEngagement.EventType eventType2 = HiveUserEngagement.EventType.IAP_PROMOTE;
                onEngagementStart(eventType2, jSONObjectMakeEngagementStartCallback);
                if (str3 != null) {
                    hiveIapV4.setPromotePurchaseMarketPid(str3);
                    onEngagementEnd(new ResultAPI(), eventType2, null);
                } else {
                    onEngagementEnd(new ResultAPI(ResultAPI.Code.UserEngagementEmptyMarketPid, "marketpid is null"), eventType2, null);
                }
                handleEvents$hive_service_release(true);
                break;
            case 15:
                HiveUserEngagement.EventType eventType3 = HiveUserEngagement.EventType.IAP_UPDATED;
                onEngagementStart(eventType3);
                onEngagementEnd(new ResultAPI(), eventType3, null);
                handleEvents$hive_service_release(true);
                break;
        }
        return false;
    }

    private final boolean handleInterwork(UserEngagementEvent userEngagementEvent) {
        if (userEngagementEvent == null) {
            return false;
        }
        String path = userEngagementEvent.getPath();
        HiveUserEngagement.InterworkApi interworkApi = path != null ? HiveUserEngagement.InterworkApi.INSTANCE.getInterworkApi(path) : null;
        if (interworkApi == null) {
            return false;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[interworkApi.getInterworkTarget().ordinal()];
        if (i == 1) {
            return handleAuth(interworkApi, userEngagementEvent);
        }
        if (i == 2) {
            return handleSocial(interworkApi, userEngagementEvent);
        }
        if (i == 3) {
            return handlePromotion(interworkApi, userEngagementEvent);
        }
        if (i == 4) {
            return handleUserEngagement(interworkApi, userEngagementEvent);
        }
        if (i != 5) {
            return false;
        }
        return handleIAP(interworkApi, userEngagementEvent);
    }

    private final boolean handlePromotion(HiveUserEngagement.InterworkApi api, UserEngagementEvent userEngagementEvent) throws JSONException {
        JSONObject jSONObjectMakeEngagementStartCallback = makeEngagementStartCallback(userEngagementEvent);
        HashMap<String, String> hashMapQuery = userEngagementEvent.getHashMapQuery();
        final String scheme = userEngagementEvent.getScheme();
        HiveModuleManager hiveModuleManager = HiveModuleManager.INSTANCE;
        String name = HivePromotion.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        HiveModule hiveModule = hiveModuleManager.getHiveModule(name);
        if (!(hiveModule instanceof HivePromotion)) {
            hiveModule = null;
        }
        final HivePromotion hivePromotion = (HivePromotion) (hiveModule instanceof HivePromotion ? hiveModule : null);
        if (hivePromotion == null) {
            return false;
        }
        switch (WhenMappings.$EnumSwitchMapping$1[api.ordinal()]) {
            case 8:
            case 9:
                LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
                loggerImpl.d("[Promotion::UserEngagementImpl::handlePromotion] OFFERWALLSHOW");
                if (hivePromotion.newsV2IsShow()) {
                    if (hivePromotion.newsV2ShowOfferwall()) {
                        loggerImpl.d("[Promotion::UserEngagementImpl::handlePromotion] OFFERWALLSHOW - handle news showOfferwall");
                        handleEvents$hive_service_release(true);
                    } else {
                        hivePromotion.newsV2Finish();
                    }
                }
                onEngagementStart(HiveUserEngagement.EventType.OFFERWALL_VIEW, jSONObjectMakeEngagementStartCallback);
                UserEngagementEvent.INSTANCE.setQueryParameters(hashMapQuery);
                hivePromotion.showOfferwall(new Promotion.PromotionViewListener() { // from class: com.hive.userengagement.UserEngagement.handlePromotion.1

                    /* JADX INFO: renamed from: com.hive.userengagement.UserEngagement$handlePromotion$1$WhenMappings */
                    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                    public /* synthetic */ class WhenMappings {
                        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
                        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

                        static {
                            int[] iArr = new int[Promotion.OfferwallState.values().length];
                            try {
                                iArr[Promotion.OfferwallState.ENABLED.ordinal()] = 1;
                            } catch (NoSuchFieldError unused) {
                            }
                            $EnumSwitchMapping$0 = iArr;
                            int[] iArr2 = new int[Promotion.PromotionViewResultType.values().length];
                            try {
                                iArr2[Promotion.PromotionViewResultType.OPENED.ordinal()] = 1;
                            } catch (NoSuchFieldError unused2) {
                            }
                            try {
                                iArr2[Promotion.PromotionViewResultType.CLOSED.ordinal()] = 2;
                            } catch (NoSuchFieldError unused3) {
                            }
                            $EnumSwitchMapping$1 = iArr2;
                        }
                    }

                    @Override // com.hive.Promotion.PromotionViewListener
                    public void onPromotionView(ResultAPI result, Promotion.PromotionViewResultType promotionEventType) throws JSONException {
                        Intrinsics.checkNotNullParameter(result, "result");
                        Intrinsics.checkNotNullParameter(promotionEventType, "promotionEventType");
                        JSONObject jSONObject = new JSONObject();
                        CommonIdentifierKt.putCheck(jSONObject, "scheme", scheme);
                        int i = WhenMappings.$EnumSwitchMapping$1[promotionEventType.ordinal()];
                        if (i == 1) {
                            if (HiveLifecycle.INSTANCE.isInitializeSdkV1()) {
                                CommonIdentifierKt.putCheck(jSONObject, "state", "open");
                                CommonIdentifierKt.putCheck(jSONObject, "type", "offerwall");
                                UserEngagement.INSTANCE.onEngagementEnd(result, HiveUserEngagement.EventType.OFFERWALL_VIEW, jSONObject);
                                return;
                            }
                            return;
                        }
                        if (i != 2) {
                            return;
                        }
                        UserEngagementEvent.INSTANCE.clearQueryParameters();
                        CommonIdentifierKt.putCheck(jSONObject, "offerwallState", Integer.valueOf(WhenMappings.$EnumSwitchMapping$0[hivePromotion.getOfferwallState().ordinal()] == 1 ? -14 : -15));
                        CommonIdentifierKt.putCheck(jSONObject, "state", "close");
                        CommonIdentifierKt.putCheck(jSONObject, "type", "offerwall");
                        UserEngagement userEngagement = UserEngagement.INSTANCE;
                        userEngagement.onEngagementEnd(result, HiveUserEngagement.EventType.OFFERWALL_VIEW, jSONObject);
                        userEngagement.handleEvents$hive_service_release(true);
                    }
                });
                break;
            case 10:
                LoggerImpl.INSTANCE.d("[Promotion::UserEngagementImpl::handlePromotion] PROMOTIONSHOW");
                String str = hashMapQuery.get("type");
                if (str != null) {
                    hivePromotion.needDialogClosed(new ResultAPI());
                    onEngagementStart(HiveUserEngagement.EventType.PROMOTION_VIEW, jSONObjectMakeEngagementStartCallback);
                    UserEngagementEvent.INSTANCE.setQueryParameters(hashMapQuery);
                    hivePromotion.showCustomContents(Promotion.PromotionCustomType.VIEW, str, true, new Promotion.PromotionViewListener() { // from class: com.hive.userengagement.UserEngagement.handlePromotion.2

                        /* JADX INFO: renamed from: com.hive.userengagement.UserEngagement$handlePromotion$2$WhenMappings */
                        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                        public /* synthetic */ class WhenMappings {
                            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                            static {
                                int[] iArr = new int[Promotion.PromotionViewResultType.values().length];
                                try {
                                    iArr[Promotion.PromotionViewResultType.OPENED.ordinal()] = 1;
                                } catch (NoSuchFieldError unused) {
                                }
                                try {
                                    iArr[Promotion.PromotionViewResultType.CLOSED.ordinal()] = 2;
                                } catch (NoSuchFieldError unused2) {
                                }
                                $EnumSwitchMapping$0 = iArr;
                            }
                        }

                        @Override // com.hive.Promotion.PromotionViewListener
                        public void onPromotionView(ResultAPI result, Promotion.PromotionViewResultType promotionEventType) throws JSONException {
                            Intrinsics.checkNotNullParameter(result, "result");
                            Intrinsics.checkNotNullParameter(promotionEventType, "promotionEventType");
                            JSONObject jSONObject = new JSONObject();
                            CommonIdentifierKt.putCheck(jSONObject, "scheme", scheme);
                            int i = WhenMappings.$EnumSwitchMapping$0[promotionEventType.ordinal()];
                            if (i == 1) {
                                if (HiveLifecycle.INSTANCE.isInitializeSdkV1()) {
                                    CommonIdentifierKt.putCheck(jSONObject, "state", "open");
                                    CommonIdentifierKt.putCheck(jSONObject, "type", "customView");
                                    UserEngagement.INSTANCE.onEngagementEnd(result, HiveUserEngagement.EventType.PROMOTION_VIEW, jSONObject);
                                    return;
                                }
                                return;
                            }
                            if (i != 2) {
                                return;
                            }
                            UserEngagementEvent.INSTANCE.clearQueryParameters();
                            CommonIdentifierKt.putCheck(jSONObject, "state", "close");
                            CommonIdentifierKt.putCheck(jSONObject, "type", "customView");
                            UserEngagement userEngagement = UserEngagement.INSTANCE;
                            userEngagement.onEngagementEnd(result, HiveUserEngagement.EventType.PROMOTION_VIEW, jSONObject);
                            userEngagement.handleEvents$hive_service_release(true);
                        }
                    });
                }
                break;
            case 11:
                final String str2 = hashMapQuery.get("cid");
                String str3 = hashMapQuery.get(ScarConstants.TOKEN_ID_KEY);
                JSONObject jSONObject = new JSONObject();
                CommonIdentifierKt.putCheck(jSONObject, "cid", (str2 == null || !(StringsKt.isBlank(str2) ^ true)) ? "" : str2);
                if (str3 == null || !(!StringsKt.isBlank(str3))) {
                    str3 = "";
                }
                CommonIdentifierKt.putCheck(jSONObject, ScarConstants.TOKEN_ID_KEY, str3);
                onEngagementStart(HiveUserEngagement.EventType.COMPANION, jSONObjectMakeEngagementStartCallback);
                hivePromotion.requestCompanion(jSONObject, new Function1() { // from class: com.hive.userengagement.UserEngagement$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return UserEngagement.handlePromotion$lambda$14(str2, (ResultAPI) obj);
                    }
                });
                break;
            default:
                LoggerImpl.INSTANCE.d("[Promotion::UserEngagementImpl::handlePromotion] default");
                break;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit handlePromotion$lambda$14(String str, ResultAPI resultApi) throws JSONException {
        Intrinsics.checkNotNullParameter(resultApi, "resultApi");
        JSONObject jSONObjectPutCheck = CommonIdentifierKt.putCheck(new JSONObject(), "cid", str);
        UserEngagement userEngagement = INSTANCE;
        userEngagement.onEngagementEnd(resultApi, HiveUserEngagement.EventType.COMPANION, jSONObjectPutCheck);
        userEngagement.handleEvents$hive_service_release(true);
        return Unit.INSTANCE;
    }

    private final boolean handleSocial(HiveUserEngagement.InterworkApi api, UserEngagementEvent userEngagementEvent) {
        Object objM7415constructorimpl;
        JSONObject jSONObjectMakeEngagementStartCallback = makeEngagementStartCallback(userEngagementEvent);
        HashMap<String, String> hashMapQuery = userEngagementEvent.getHashMapQuery();
        final String scheme = userEngagementEvent.getScheme();
        HiveLifecycle hiveLifecycle = HiveLifecycle.INSTANCE;
        HiveLifecycle.HiveAccount account = hiveLifecycle.getAccount();
        UserEngagementEvent.Companion companion = UserEngagementEvent.INSTANCE;
        companion.clearQueryParameters();
        switch (WhenMappings.$EnumSwitchMapping$1[api.ordinal()]) {
            case 2:
            case 3:
                LoggerImpl.INSTANCE.d("[Promotion::UserEngagementImpl::handleSocial] SOCIALINQUERY");
                if (Intrinsics.areEqual(account.getVidType(), i.f2373a)) {
                    String vid = account.getVid();
                    if (vid != null) {
                        if (StringsKt.isBlank(vid)) {
                            vid = null;
                        }
                        if (vid != null) {
                            INSTANCE.onEngagementStart(HiveUserEngagement.EventType.SOCIAL_INQUIRY_VIEW, jSONObjectMakeEngagementStartCallback);
                            companion.setQueryParameters(hashMapQuery);
                            HiveModuleManager hiveModuleManager = HiveModuleManager.INSTANCE;
                            String name = HiveSocial.class.getName();
                            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                            HiveModule hiveModule = hiveModuleManager.getHiveModule(name);
                            if (!(hiveModule instanceof HiveSocial)) {
                                hiveModule = null;
                            }
                            if (!(hiveModule instanceof HiveSocial)) {
                                hiveModule = null;
                            }
                            HiveSocial hiveSocial = (HiveSocial) hiveModule;
                            if (hiveSocial != null) {
                                hiveSocial.showHiveDialog(SocialHive.HiveDialogType.INQUIRY, vid, null, new SocialHive.ShowHiveDialogListener() { // from class: com.hive.userengagement.UserEngagement$handleSocial$2$1
                                    @Override // com.hive.SocialHive.ShowHiveDialogListener
                                    public void onShowHiveDialog(ResultAPI result) throws JSONException {
                                        Intrinsics.checkNotNullParameter(result, "result");
                                        JSONObject jSONObject = new JSONObject();
                                        CommonIdentifierKt.putCheck(jSONObject, "scheme", scheme);
                                        CommonIdentifierKt.putCheck(jSONObject, "type", "inquiry");
                                        UserEngagementEvent.INSTANCE.clearQueryParameters();
                                        UserEngagement userEngagement = UserEngagement.INSTANCE;
                                        userEngagement.onEngagementEnd(result, HiveUserEngagement.EventType.SOCIAL_INQUIRY_VIEW, jSONObject);
                                        userEngagement.handleEvents$hive_service_release(true);
                                    }
                                });
                            }
                        }
                    }
                } else if (Intrinsics.areEqual(account.getVidType(), "v4")) {
                    onEngagementStart(HiveUserEngagement.EventType.SOCIAL_INQUIRY_VIEW, jSONObjectMakeEngagementStartCallback);
                    companion.setQueryParameters(hashMapQuery);
                    HiveModuleManager hiveModuleManager2 = HiveModuleManager.INSTANCE;
                    String name2 = HiveAuthV4.class.getName();
                    Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
                    HiveModule hiveModule2 = hiveModuleManager2.getHiveModule(name2);
                    if (!(hiveModule2 instanceof HiveAuthV4)) {
                        hiveModule2 = null;
                    }
                    HiveAuthV4 hiveAuthV4 = (HiveAuthV4) (hiveModule2 instanceof HiveAuthV4 ? hiveModule2 : null);
                    if (hiveAuthV4 != null) {
                        hiveAuthV4.showInquiry(new AuthV4.AuthV4ShowInquiryListener() { // from class: com.hive.userengagement.UserEngagement.handleSocial.3
                            @Override // com.hive.AuthV4.AuthV4ShowInquiryListener
                            public void onAuthV4ShowInquiry(ResultAPI result) throws JSONException {
                                Intrinsics.checkNotNullParameter(result, "result");
                                UserEngagementEvent.INSTANCE.clearQueryParameters();
                                UserEngagement userEngagement = UserEngagement.INSTANCE;
                                userEngagement.onEngagementEnd(result, HiveUserEngagement.EventType.SOCIAL_INQUIRY_VIEW, null);
                                userEngagement.handleEvents$hive_service_release(true);
                            }
                        });
                    }
                } else if (Intrinsics.areEqual(account.getVidType(), "v0")) {
                    HiveModuleManager hiveModuleManager3 = HiveModuleManager.INSTANCE;
                    String name3 = HiveSocial.class.getName();
                    Intrinsics.checkNotNullExpressionValue(name3, "getName(...)");
                    HiveModule hiveModule3 = hiveModuleManager3.getHiveModule(name3);
                    if (!(hiveModule3 instanceof HiveSocial)) {
                        hiveModule3 = null;
                    }
                    HiveSocial hiveSocial2 = (HiveSocial) (hiveModule3 instanceof HiveSocial ? hiveModule3 : null);
                    if (hiveSocial2 != null) {
                        hiveSocial2.showHiveDialog("inquiry", new SocialHive.ShowHiveDialogDataListener() { // from class: com.hive.userengagement.UserEngagement.handleSocial.4
                            @Override // com.hive.SocialHive.ShowHiveDialogDataListener
                            public void onShowHiveDialogWithData(ResultAPI result, JSONObject jsonData) {
                                Intrinsics.checkNotNullParameter(result, "result");
                            }
                        });
                    }
                }
                break;
            case 4:
                LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
                loggerImpl.i("[Promotion::UserEngagementImpl::handleSocial] SOCIALMYINQUIRY");
                if (!hiveLifecycle.isSignOut()) {
                    String vidType = account.getVidType();
                    if (vidType != null) {
                        int iHashCode = vidType.hashCode();
                        if (iHashCode == 3706) {
                            if (vidType.equals("v0")) {
                                if (account.getUid() != null) {
                                    loggerImpl.i("[Promotion::UserEngagementImpl::handleSocial] SOCIALMYINQUIRY : Call showHiveDialog(\"myinquiry\", ..");
                                    HiveModuleManager hiveModuleManager4 = HiveModuleManager.INSTANCE;
                                    String name4 = HiveSocial.class.getName();
                                    Intrinsics.checkNotNullExpressionValue(name4, "getName(...)");
                                    HiveModule hiveModule4 = hiveModuleManager4.getHiveModule(name4);
                                    if (!(hiveModule4 instanceof HiveSocial)) {
                                        hiveModule4 = null;
                                    }
                                    HiveSocial hiveSocial3 = (HiveSocial) (hiveModule4 instanceof HiveSocial ? hiveModule4 : null);
                                    if (hiveSocial3 != null) {
                                        hiveSocial3.showHiveDialog("myinquiry", new SocialHive.ShowHiveDialogDataListener() { // from class: com.hive.userengagement.UserEngagement$handleSocial$7$1
                                            @Override // com.hive.SocialHive.ShowHiveDialogDataListener
                                            public void onShowHiveDialogWithData(ResultAPI result, JSONObject jsonData) {
                                                Intrinsics.checkNotNullParameter(result, "result");
                                            }
                                        });
                                    }
                                }
                            }
                        } else if (iHashCode == 3707) {
                            if (vidType.equals(i.f2373a)) {
                                onEngagementStart(HiveUserEngagement.EventType.SOCIAL_MYINQUIRY_VIEW, jSONObjectMakeEngagementStartCallback);
                                companion.setQueryParameters(hashMapQuery);
                                String vid2 = account.getVid();
                                if (vid2 != null) {
                                    loggerImpl.i("[Promotion::UserEngagementImpl::handleSocial] SOCIALMYINQUIRY : Call SocialHive.showHiveDialog(SocialDialogType.MYINQUIRY)");
                                    HiveModuleManager hiveModuleManager5 = HiveModuleManager.INSTANCE;
                                    String name5 = HiveSocial.class.getName();
                                    Intrinsics.checkNotNullExpressionValue(name5, "getName(...)");
                                    HiveModule hiveModule5 = hiveModuleManager5.getHiveModule(name5);
                                    if (!(hiveModule5 instanceof HiveSocial)) {
                                        hiveModule5 = null;
                                    }
                                    if (!(hiveModule5 instanceof HiveSocial)) {
                                        hiveModule5 = null;
                                    }
                                    HiveSocial hiveSocial4 = (HiveSocial) hiveModule5;
                                    if (hiveSocial4 != null) {
                                        hiveSocial4.showHiveDialog(SocialHive.HiveDialogType.MYINQUIRY, vid2, null, new SocialHive.ShowHiveDialogListener() { // from class: com.hive.userengagement.UserEngagement$handleSocial$5$1
                                            @Override // com.hive.SocialHive.ShowHiveDialogListener
                                            public void onShowHiveDialog(ResultAPI result) throws JSONException {
                                                Intrinsics.checkNotNullParameter(result, "result");
                                                UserEngagementEvent.INSTANCE.clearQueryParameters();
                                                UserEngagement userEngagement = UserEngagement.INSTANCE;
                                                userEngagement.onEngagementEnd(result, HiveUserEngagement.EventType.SOCIAL_MYINQUIRY_VIEW, null);
                                                userEngagement.handleEvents$hive_service_release(true);
                                            }
                                        });
                                    }
                                }
                            }
                        } else if (iHashCode == 3710 && vidType.equals("v4")) {
                            onEngagementStart(HiveUserEngagement.EventType.SOCIAL_MYINQUIRY_VIEW, jSONObjectMakeEngagementStartCallback);
                            companion.setQueryParameters(hashMapQuery);
                            loggerImpl.i("[Promotion::UserEngagementImpl::handleSocial] SOCIALMYINQUIRY : Call AuthV4.showMyInquiry()");
                            HiveModuleManager hiveModuleManager6 = HiveModuleManager.INSTANCE;
                            String name6 = HiveAuthV4.class.getName();
                            Intrinsics.checkNotNullExpressionValue(name6, "getName(...)");
                            HiveModule hiveModule6 = hiveModuleManager6.getHiveModule(name6);
                            if (!(hiveModule6 instanceof HiveAuthV4)) {
                                hiveModule6 = null;
                            }
                            HiveAuthV4 hiveAuthV42 = (HiveAuthV4) (hiveModule6 instanceof HiveAuthV4 ? hiveModule6 : null);
                            if (hiveAuthV42 != null) {
                                hiveAuthV42.showMyInquiry(new AuthV4.AuthV4ShowMyInquiryListener() { // from class: com.hive.userengagement.UserEngagement.handleSocial.6
                                    @Override // com.hive.AuthV4.AuthV4ShowMyInquiryListener
                                    public void onAuthV4ShowMyInquiry(ResultAPI result) throws JSONException {
                                        Intrinsics.checkNotNullParameter(result, "result");
                                        UserEngagementEvent.INSTANCE.clearQueryParameters();
                                        UserEngagement userEngagement = UserEngagement.INSTANCE;
                                        userEngagement.onEngagementEnd(result, HiveUserEngagement.EventType.SOCIAL_MYINQUIRY_VIEW, null);
                                        userEngagement.handleEvents$hive_service_release(true);
                                    }
                                });
                            }
                        }
                    }
                    loggerImpl.d("[Promotion::UserEngagementImpl::handleSocial] SOCIALMYINQUIRY : vidType type is unknown : " + account.getVidType());
                } else {
                    loggerImpl.d("[Promotion::UserEngagementImpl::handleSocial] SOCIALMYINQUIRY : User is not logged in.");
                }
                break;
            case 5:
                LoggerImpl loggerImpl2 = LoggerImpl.INSTANCE;
                loggerImpl2.i("[Promotion::UserEngagementImpl::handleSocial] SOCIALPROFILE");
                if (!hiveLifecycle.isSignOut()) {
                    String vidType2 = account.getVidType();
                    if (vidType2 != null) {
                        int iHashCode2 = vidType2.hashCode();
                        if (iHashCode2 == 3706) {
                            if (vidType2.equals("v0")) {
                                if (account.getUid() != null) {
                                    loggerImpl2.i("[Promotion::UserEngagementImpl::handleSocial] SOCIALPROFILE : Call SocialHive.showHiveDialog(\"user\", ..)");
                                    HiveModuleManager hiveModuleManager7 = HiveModuleManager.INSTANCE;
                                    String name7 = HiveSocial.class.getName();
                                    Intrinsics.checkNotNullExpressionValue(name7, "getName(...)");
                                    HiveModule hiveModule7 = hiveModuleManager7.getHiveModule(name7);
                                    if (!(hiveModule7 instanceof HiveSocial)) {
                                        hiveModule7 = null;
                                    }
                                    HiveSocial hiveSocial5 = (HiveSocial) (hiveModule7 instanceof HiveSocial ? hiveModule7 : null);
                                    if (hiveSocial5 != null) {
                                        hiveSocial5.showHiveDialog("user", new SocialHive.ShowHiveDialogDataListener() { // from class: com.hive.userengagement.UserEngagement$handleSocial$10$1
                                            @Override // com.hive.SocialHive.ShowHiveDialogDataListener
                                            public void onShowHiveDialogWithData(ResultAPI result, JSONObject jsonData) {
                                                Intrinsics.checkNotNullParameter(result, "result");
                                            }
                                        });
                                    }
                                }
                            }
                            break;
                        } else if (iHashCode2 == 3707) {
                            if (vidType2.equals(i.f2373a)) {
                                HiveModuleManager hiveModuleManager8 = HiveModuleManager.INSTANCE;
                                String name8 = HiveSocial.class.getName();
                                Intrinsics.checkNotNullExpressionValue(name8, "getName(...)");
                                HiveModule hiveModule8 = hiveModuleManager8.getHiveModule(name8);
                                if (!(hiveModule8 instanceof HiveSocial)) {
                                    hiveModule8 = null;
                                }
                                if (!(hiveModule8 instanceof HiveSocial)) {
                                    hiveModule8 = null;
                                }
                                HiveSocial hiveSocial6 = (HiveSocial) hiveModule8;
                                if (hiveSocial6 != null) {
                                    onEngagementStart(HiveUserEngagement.EventType.SOCIAL_PROFILE_VIEW, jSONObjectMakeEngagementStartCallback);
                                    companion.setQueryParameters(hashMapQuery);
                                    String vid3 = account.getVid();
                                    if (vid3 != null) {
                                        loggerImpl2.i("[Promotion::UserEngagementImpl::handleSocial] SOCIALPROFILE : Call SocialHive.showHiveDialog(SocialDialogType.USER)");
                                        hiveSocial6.showHiveDialog(SocialHive.HiveDialogType.USER, vid3, null, new SocialHive.ShowHiveDialogListener() { // from class: com.hive.userengagement.UserEngagement$handleSocial$8$1
                                            @Override // com.hive.SocialHive.ShowHiveDialogListener
                                            public void onShowHiveDialog(ResultAPI result) throws JSONException {
                                                Intrinsics.checkNotNullParameter(result, "result");
                                                UserEngagementEvent.INSTANCE.clearQueryParameters();
                                                UserEngagement userEngagement = UserEngagement.INSTANCE;
                                                userEngagement.onEngagementEnd(result, HiveUserEngagement.EventType.SOCIAL_PROFILE_VIEW, null);
                                                userEngagement.handleEvents$hive_service_release(true);
                                            }
                                        });
                                    }
                                    break;
                                }
                            }
                        } else if (iHashCode2 == 3710 && vidType2.equals("v4")) {
                            HiveModuleManager hiveModuleManager9 = HiveModuleManager.INSTANCE;
                            String name9 = HiveAuthV4.class.getName();
                            Intrinsics.checkNotNullExpressionValue(name9, "getName(...)");
                            HiveModule hiveModule9 = hiveModuleManager9.getHiveModule(name9);
                            if (!(hiveModule9 instanceof HiveAuthV4)) {
                                hiveModule9 = null;
                            }
                            HiveAuthV4 hiveAuthV43 = (HiveAuthV4) (hiveModule9 instanceof HiveAuthV4 ? hiveModule9 : null);
                            if (hiveAuthV43 != null) {
                                onEngagementStart(HiveUserEngagement.EventType.SOCIAL_PROFILE_VIEW, jSONObjectMakeEngagementStartCallback);
                                companion.setQueryParameters(hashMapQuery);
                                String vid4 = account.getVid();
                                if (vid4 != null) {
                                    loggerImpl2.i("[Promotion::UserEngagementImpl::handleSocial] SOCIALPROFILE : Call AuthV4.showProfile()");
                                    try {
                                        Result.Companion companion2 = Result.INSTANCE;
                                        hiveAuthV43.showProfile(Long.parseLong(vid4), new AuthV4.AuthV4ShowProfileListener() { // from class: com.hive.userengagement.UserEngagement$handleSocial$9$1$1
                                            @Override // com.hive.AuthV4.AuthV4ShowProfileListener
                                            public void onAuthV4ShowProfile(ResultAPI result) throws JSONException {
                                                Intrinsics.checkNotNullParameter(result, "result");
                                                UserEngagementEvent.INSTANCE.clearQueryParameters();
                                                UserEngagement userEngagement = UserEngagement.INSTANCE;
                                                userEngagement.onEngagementEnd(result, HiveUserEngagement.EventType.SOCIAL_PROFILE_VIEW, null);
                                                userEngagement.handleEvents$hive_service_release(true);
                                            }
                                        });
                                        objM7415constructorimpl = Result.m7415constructorimpl(Unit.INSTANCE);
                                    } catch (Throwable th) {
                                        Result.Companion companion3 = Result.INSTANCE;
                                        objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
                                    }
                                    Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
                                    if (thM7418exceptionOrNullimpl != null) {
                                        LoggerImpl.INSTANCE.d("[Promotion::UserEngagementImpl::handleSocial] SOCIALPROFILE : Failed call AuthV4.showProfile() \n " + thM7418exceptionOrNullimpl.getMessage());
                                    }
                                    Result.m7414boximpl(objM7415constructorimpl);
                                }
                                break;
                            }
                        }
                    }
                    loggerImpl2.d("[Promotion::UserEngagementImpl::handleSocial] SOCIALPROFILE : vidType type is unknown : " + account.getVidType());
                } else {
                    loggerImpl2.d("[Promotion::UserEngagementImpl::handleSocial] SOCIALPROFILE : User is not logged in.");
                }
                break;
            case 6:
            case 7:
                LoggerImpl loggerImpl3 = LoggerImpl.INSTANCE;
                loggerImpl3.d("[Promotion::UserEngagementImpl::handleSocial] COMMUNITYSHOW");
                String str = hashMapQuery.get("url");
                String str2 = hashMapQuery.get("viewType");
                SocialV4.ViewType viewType = (str2 != null && str2.hashCode() == 97692013 && str2.equals(TypedValues.AttributesType.S_FRAME)) ? SocialV4.ViewType.Frame : SocialV4.ViewType.FullScreen;
                loggerImpl3.d("[Promotion::UserEngagementImpl::handleSocial] COMMUNITYSHOW viewType : " + viewType);
                HiveModuleManager hiveModuleManager10 = HiveModuleManager.INSTANCE;
                String name10 = HiveSocialV4.class.getName();
                Intrinsics.checkNotNullExpressionValue(name10, "getName(...)");
                HiveModule hiveModule10 = hiveModuleManager10.getHiveModule(name10);
                if (!(hiveModule10 instanceof HiveSocialV4)) {
                    hiveModule10 = null;
                }
                HiveSocialV4 hiveSocialV4 = (HiveSocialV4) (hiveModule10 instanceof HiveSocialV4 ? hiveModule10 : null);
                if (hiveSocialV4 != null) {
                    onEngagementStart(HiveUserEngagement.EventType.COMMUNITY_VIEW, jSONObjectMakeEngagementStartCallback);
                    companion.setQueryParameters(hashMapQuery);
                    hiveSocialV4.showCommunity(SocialV4.ProviderType.HIVE, viewType, str, new SocialV4.SocialV4ShowCommunityListener() { // from class: com.hive.userengagement.UserEngagement.handleSocial.11
                        @Override // com.hive.SocialV4.SocialV4ShowCommunityListener
                        public void onShowCommunity(ResultAPI result) throws JSONException {
                            Intrinsics.checkNotNullParameter(result, "result");
                            UserEngagementEvent.INSTANCE.clearQueryParameters();
                            UserEngagement userEngagement = UserEngagement.INSTANCE;
                            userEngagement.onEngagementEnd(result, HiveUserEngagement.EventType.COMMUNITY_VIEW, null);
                            userEngagement.handleEvents$hive_service_release(true);
                        }
                    });
                    break;
                }
                break;
            default:
                LoggerImpl.INSTANCE.d("[Auth::handleSocial] default");
                break;
        }
        return false;
    }

    private final boolean handleUserEngagement(HiveUserEngagement.InterworkApi api, UserEngagementEvent userEngagementEvent) {
        String additionalInfo;
        JSONObject jSONObjectMakeEngagementStartCallback = makeEngagementStartCallback(userEngagementEvent);
        HashMap<String, String> hashMapQuery = userEngagementEvent.getHashMapQuery();
        final String scheme = userEngagementEvent.getScheme();
        if (WhenMappings.$EnumSwitchMapping$1[api.ordinal()] != 12) {
            LoggerImpl.INSTANCE.d("[Promotion::UserEngagementImpl::handleUserEngagement] default");
            return false;
        }
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.d("[Promotion::UserEngagementImpl::handleUserEngagement] PROMOTIONCOUPON");
        String str = hashMapQuery.get("couponid");
        HiveUserEngagement.EventType eventType = HiveUserEngagement.EventType.COUPON;
        onEngagementStart(eventType, jSONObjectMakeEngagementStartCallback);
        if (HiveLifecycle.INSTANCE.isStandAlone()) {
            loggerImpl.d("[Promotion] Can't consume coupon for C2S user.");
            onEngagementEnd(new ResultAPI(), eventType, null);
            return false;
        }
        if (str == null) {
            onEngagementEnd(new ResultAPI(-1, ResultAPI.Code.UserEngagementEmptyCouponId, "couponid is null"), eventType, null);
            return false;
        }
        UserEngagementEvent.INSTANCE.setQueryParameters(hashMapQuery);
        HiveModuleManager hiveModuleManager = HiveModuleManager.INSTANCE;
        String name = HivePromotion.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        HiveModule hiveModule = hiveModuleManager.getHiveModule(name);
        if (!(hiveModule instanceof HivePromotion)) {
            hiveModule = null;
        }
        HivePromotion hivePromotion = (HivePromotion) (hiveModule instanceof HivePromotion ? hiveModule : null);
        if (hivePromotion == null || (additionalInfo = hivePromotion.getAdditionalInfo()) == null) {
            additionalInfo = "";
        }
        consumeCoupon(str, additionalInfo, new UserEngagementCoupon.CouponListener() { // from class: com.hive.userengagement.UserEngagement.handleUserEngagement.1
            @Override // com.hive.userengagement.UserEngagementCoupon.CouponListener
            public void onCouponConsume(ResultAPI result, int resultCode, String resultMessage) throws JSONException {
                Intrinsics.checkNotNullParameter(result, "result");
                Intrinsics.checkNotNullParameter(resultMessage, "resultMessage");
                JSONObject jSONObject = new JSONObject();
                CommonIdentifierKt.putCheck(jSONObject, "scheme", scheme);
                try {
                    jSONObject.put("code", resultCode);
                    jSONObject.put("message", resultMessage);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                UserEngagementEvent.INSTANCE.clearQueryParameters();
                UserEngagement userEngagement = UserEngagement.INSTANCE;
                userEngagement.onEngagementEnd(result, HiveUserEngagement.EventType.COUPON, jSONObject);
                userEngagement.handleEvents$hive_service_release(true);
            }
        });
        return true;
    }

    private final JSONObject makeEngagementStartCallback(UserEngagementEvent userEngagementEvent) {
        Object objM7415constructorimpl;
        Object objPutCheck;
        HashMap<String, String> hashMapQuery = userEngagementEvent.getHashMapQuery();
        String scheme = userEngagementEvent.getScheme();
        String query = userEngagementEvent.getQuery();
        String path = userEngagementEvent.getPath();
        JSONObject jSONObject = new JSONObject();
        try {
            Result.Companion companion = Result.INSTANCE;
            String vidType = HiveLifecycle.INSTANCE.getAccount().getVidType();
            CommonIdentifierKt.putCheck(jSONObject, "scheme", scheme);
            if (Intrinsics.areEqual(vidType, i.f2373a)) {
                for (Map.Entry<String, String> entry : hashMapQuery.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (value != null && value.length() != 0) {
                        CommonIdentifierKt.putCheck(jSONObject, key, value);
                    }
                }
                objPutCheck = Unit.INSTANCE;
            } else {
                CommonIdentifierKt.putCheck(jSONObject, "api", path);
                objPutCheck = CommonIdentifierKt.putCheck(jSONObject, "param", query);
            }
            objM7415constructorimpl = Result.m7415constructorimpl(objPutCheck);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
        if (thM7418exceptionOrNullimpl != null) {
            LoggerImpl.INSTANCE.w("[UserEngagement] makeEngagementStartCallback exception : " + thM7418exceptionOrNullimpl);
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onEngagementEnd(ResultAPI result, HiveUserEngagement.EventType engagementEventType, JSONObject resultJsonObject) {
        HiveUserEngagement.UserEngagementListener userEngagementListener = engagementListener;
        if (userEngagementListener != null) {
            userEngagementListener.onEngagement(result, engagementEventType, HiveUserEngagement.EventState.END, resultJsonObject);
        }
    }

    private final void onEngagementStart(HiveUserEngagement.EventType engagementEventType) {
        HiveUserEngagement.UserEngagementListener userEngagementListener = engagementListener;
        if (userEngagementListener != null) {
            userEngagementListener.onEngagement(new ResultAPI(), engagementEventType, HiveUserEngagement.EventState.START, null);
        }
    }

    private final void processFirstLaunchDirectlinkScheme() {
        LoggerImpl.INSTANCE.d("[UserEngagement] processFirstLaunchDirectlinkScheme");
        if (Intrinsics.areEqual(Property.INSTANCE.getINSTANCE().getValue("FirstInit", ""), "True")) {
            String directlinkSchemeFromReferrer = getDirectlinkSchemeFromReferrer();
            if (directlinkSchemeFromReferrer != null) {
                INSTANCE.processUri(directlinkSchemeFromReferrer);
            } else {
                requestFirstLaunchDirectlinkData();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void processUri$lambda$1$lambda$0() throws JSONException {
        INSTANCE.handleEvents$hive_service_release();
    }

    private final void requestFirstLaunchDirectlinkData() {
        requestFirstLaunchDirectlinkData$getCssScreenSizeWithWebView(new Function2() { // from class: com.hive.userengagement.UserEngagement$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return UserEngagement.requestFirstLaunchDirectlinkData$lambda$25(((Integer) obj).intValue(), ((Integer) obj2).intValue());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair<Integer, Integer> requestFirstLaunchDirectlinkData$getCssScreenSize(Activity activity) {
        LoggerImpl.INSTANCE.d("[UserEngagement] getCssScreenSize");
        activity.getWindowManager().getDefaultDisplay().getRealMetrics(new DisplayMetrics());
        return new Pair<>(Integer.valueOf((int) Math.ceil(r0.widthPixels / r0.density)), Integer.valueOf((int) Math.ceil(r0.heightPixels / r0.density)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object requestFirstLaunchDirectlinkData$getCssScreenSizeWithInvisibleWebView(Continuation<? super Pair<Integer, Integer>> continuation) {
        return BuildersKt.withContext(Dispatchers.getMain(), new UserEngagement$requestFirstLaunchDirectlinkData$getCssScreenSizeWithInvisibleWebView$2(null), continuation);
    }

    private static final void requestFirstLaunchDirectlinkData$getCssScreenSizeWithWebView(Function2<? super Integer, ? super Integer, Unit> function2) {
        LoggerImpl.INSTANCE.d("[UserEngagement] getCssScreenSizeWithWebView");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new UserEngagement$requestFirstLaunchDirectlinkData$getCssScreenSizeWithWebView$1(function2, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestFirstLaunchDirectlinkData$lambda$25(int i, int i2) {
        UserEngagementNetwork.INSTANCE.deferredMatch(i, i2, new Function1() { // from class: com.hive.userengagement.UserEngagement$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UserEngagement.requestFirstLaunchDirectlinkData$lambda$25$lambda$24((DeferredMatch) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestFirstLaunchDirectlinkData$lambda$25$lambda$24(DeferredMatch deferredMatch) {
        Intrinsics.checkNotNullParameter(deferredMatch, "deferredMatch");
        if (deferredMatch.getResponse().getResult().isFailure()) {
            LoggerImpl.INSTANCE.d("[UserEngagement] requestFirstLaunchDirectlinkData, response failed.");
        } else {
            String deeplinkUrl = deferredMatch.getResponse().getDeeplinkUrl();
            if (deeplinkUrl != null) {
                LoggerImpl.INSTANCE.d("[UserEngagement] requestFirstLaunchDirectlinkData, response success. add processUri(" + deeplinkUrl + ')');
                INSTANCE.processUri(deeplinkUrl);
            } else {
                LoggerImpl.INSTANCE.d("[UserEngagement] requestFirstLaunchDirectlinkData, response success. deeplinkUrl is null or empty.");
            }
        }
        return Unit.INSTANCE;
    }

    public final void consumeCoupon(String couponCode, String additionalInfo, UserEngagementCoupon.CouponListener listener) {
        Intrinsics.checkNotNullParameter(couponCode, "couponCode");
        Intrinsics.checkNotNullParameter(additionalInfo, "additionalInfo");
        Intrinsics.checkNotNullParameter(listener, "listener");
        new UserEngagementCoupon(couponCode, listener).consume(additionalInfo);
    }

    public final HiveUserEngagement.UserEngagementListener getEngagementListener() {
        return engagementListener;
    }

    public final void handleEvents$hive_service_release(boolean needToRunNextEvent) throws JSONException {
        LoggerImpl.INSTANCE.d("[Promotion::UserEngagementImpl::handleEvents(needToRunNextEvent:" + needToRunNextEvent + AbstractJsonLexerKt.END_LIST);
        isEventActive = needToRunNextEvent ^ true;
        handleEvents$hive_service_release();
    }

    public final boolean isEventActive$hive_service_release() {
        return isEventActive;
    }

    public final boolean isReadyToProcess$hive_service_release() {
        return isReadyToProcess;
    }

    public final boolean isRunningHandleEvent$hive_service_release() {
        return isRunningHandleEvent;
    }

    public final boolean processUri(String uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        boolean z = false;
        try {
            Result.Companion companion = Result.INSTANCE;
            UserEngagementEvent userEngagementEvent = new UserEngagementEvent(uri);
            LoggerImpl.INSTANCE.v(String.valueOf(userEngagementEvent.toJson()));
            if (userEngagementEvent.getValidationResult() == UserEngagementEvent.ValidationResult.OK) {
                if (Intrinsics.areEqual(userEngagementEvent.getScheme(), "interwork") || Intrinsics.areEqual(userEngagementEvent.getScheme(), "httpsrwork") || Intrinsics.areEqual(userEngagementEvent.getScheme(), "intent")) {
                    userEngagementEvents.add(0, userEngagementEvent);
                } else {
                    userEngagementEvents.add(userEngagementEvent);
                }
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.hive.userengagement.UserEngagement$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() throws JSONException {
                        UserEngagement.processUri$lambda$1$lambda$0();
                    }
                }, 500L);
                z = true;
            }
            Result.m7415constructorimpl(Unit.INSTANCE);
            return z;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m7415constructorimpl(ResultKt.createFailure(th));
            return z;
        }
    }

    public final void setEngagementListener(HiveUserEngagement.UserEngagementListener userEngagementListener) {
        engagementListener = userEngagementListener;
    }

    public final ResultAPI setEngagementReady(boolean isReady) throws JSONException {
        if (!isReady) {
            LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
            loggerImpl.w("[UserEngagement] Try to disable");
            isReadyToProcess = false;
            loggerImpl.w("[UserEngagement] set false");
            return new ResultAPI(ResultAPI.Code.Success, "set false");
        }
        LoggerImpl loggerImpl2 = LoggerImpl.INSTANCE;
        loggerImpl2.w("[UserEngagement] Try to enable");
        if (isReadyToProcess) {
            loggerImpl2.w("[UserEngagement] Already set enabled");
            return new ResultAPI(ResultAPI.Code.UserEngagementAlreadySetReady, "Already set enabled");
        }
        if (!HiveLifecycle.INSTANCE.isSignIn()) {
            loggerImpl2.w("[UserEngagement] NOT logged in.");
            return new ResultAPI(ResultAPI.Code.UserEngagementNotLogined, "NOT logged in");
        }
        loggerImpl2.d("[UserEngagement] Logged in OK.");
        HiveModuleManager hiveModuleManager = HiveModuleManager.INSTANCE;
        String name = HivePromotion.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        HiveModule hiveModule = hiveModuleManager.getHiveModule(name);
        if (!(hiveModule instanceof HivePromotion)) {
            hiveModule = null;
        }
        HivePromotion hivePromotion = (HivePromotion) (hiveModule instanceof HivePromotion ? hiveModule : null);
        if (hivePromotion != null) {
            hivePromotion.setAcquisitionAchieved();
        }
        if (engagementListener == null) {
            loggerImpl2.d("[UserEngagement] listener NOT registered");
            return new ResultAPI(ResultAPI.Code.UserEngagementListenerNotRegistered, "listener NOT registered");
        }
        loggerImpl2.d("[UserEngagement] listener registered OK");
        isReadyToProcess = true;
        processFirstLaunchDirectlinkScheme();
        handleEvents$hive_service_release();
        loggerImpl2.w("[UserEngagement] set true");
        return new ResultAPI(ResultAPI.Code.Success, "set true");
    }

    private final void onEngagementStart(HiveUserEngagement.EventType engagementEventType, JSONObject param) {
        HiveUserEngagement.UserEngagementListener userEngagementListener = engagementListener;
        if (userEngagementListener != null) {
            userEngagementListener.onEngagement(new ResultAPI(), engagementEventType, HiveUserEngagement.EventState.START, param);
        }
    }

    public final void handleEvents$hive_service_release() throws JSONException {
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.d("[Promotion::UserEngagementImpl::handleEvents]");
        if (isReadyToProcess) {
            HiveLifecycle hiveLifecycle = HiveLifecycle.INSTANCE;
            if (hiveLifecycle.isSignIn()) {
                ArrayList<UserEngagementEvent> arrayList = userEngagementEvents;
                if (!arrayList.isEmpty()) {
                    if (!isRunningHandleEvent) {
                        HiveUserEngagement.UserEngagementListener userEngagementListener = engagementListener;
                        if (userEngagementListener != null) {
                            userEngagementListener.onEngagement(new ResultAPI(), HiveUserEngagement.EventType.EVENT_TYPE, HiveUserEngagement.EventState.BEGIN, null);
                        }
                        isRunningHandleEvent = true;
                    }
                    if (isEventActive) {
                        loggerImpl.d("[Promotion::UserEngagementImpl::handleEvents] The prev event is already running. So current event waits in queue.");
                        return;
                    }
                    loggerImpl.d("[Promotion::UserEngagementImpl::handleEvents] The current event is starting.");
                    isEventActive = true;
                    UserEngagementEvent userEngagementEvent = arrayList.get(0);
                    Intrinsics.checkNotNullExpressionValue(userEngagementEvent, "get(...)");
                    UserEngagementEvent userEngagementEvent2 = userEngagementEvent;
                    arrayList.remove(0);
                    loggerImpl.wL("[Promotion::UserEngagementImpl::handleEvents] Event : " + userEngagementEvent2.toJson());
                    String host = userEngagementEvent2.getHost();
                    if (Intrinsics.areEqual(host, "hive")) {
                        if (userEngagementEvent2.getPath() == null || !handleInterwork(userEngagementEvent2)) {
                            handleEvents$hive_service_release(true);
                            return;
                        }
                        return;
                    }
                    if (Intrinsics.areEqual(host, "game")) {
                        String path = userEngagementEvent2.getPath();
                        String host2 = userEngagementEvent2.getHost();
                        String scheme = userEngagementEvent2.getScheme();
                        String path2 = userEngagementEvent2.getPath();
                        String query = userEngagementEvent2.getQuery();
                        String vidType = hiveLifecycle.getAccount().getVidType();
                        JSONObject jSONObject = new JSONObject();
                        CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_api, path);
                        if (Intrinsics.areEqual(vidType, i.f2373a)) {
                            jSONObject.put("host", host2);
                            jSONObject.put("path", path2);
                        }
                        jSONObject.put("scheme", scheme);
                        CommonIdentifierKt.putCheck(jSONObject, "param", query);
                        HiveUserEngagement.UserEngagementListener userEngagementListener2 = engagementListener;
                        if (userEngagementListener2 != null) {
                            userEngagementListener2.onEngagement(new ResultAPI(), HiveUserEngagement.EventType.EVENT, HiveUserEngagement.EventState.START, jSONObject);
                        }
                        HiveUserEngagement.UserEngagementListener userEngagementListener3 = engagementListener;
                        if (userEngagementListener3 != null) {
                            userEngagementListener3.onEngagement(new ResultAPI(), HiveUserEngagement.EventType.EVENT, HiveUserEngagement.EventState.END, jSONObject);
                        }
                        handleEvents$hive_service_release(true);
                        return;
                    }
                    loggerImpl.w("[Promotion::UserEngagementImpl::handleEvents] Unknown host..");
                    handleEvents$hive_service_release(true);
                    return;
                }
                loggerImpl.d("[Promotion::UserEngagementImpl::handleEvents] userEngagementEvents is empty.");
                if (isRunningHandleEvent) {
                    HiveUserEngagement.UserEngagementListener userEngagementListener4 = engagementListener;
                    if (userEngagementListener4 != null) {
                        userEngagementListener4.onEngagement(new ResultAPI(), HiveUserEngagement.EventType.EVENT_TYPE, HiveUserEngagement.EventState.FINISH, null);
                    }
                    isRunningHandleEvent = false;
                    return;
                }
                return;
            }
        }
        if (isReadyToProcess || !HiveLifecycle.INSTANCE.isSignIn()) {
            return;
        }
        loggerImpl.d("[Promotion::UserEngagementImpl::handleEvents] isReadyToProcess is false.");
        if (isRunningHandleEvent) {
            HiveUserEngagement.UserEngagementListener userEngagementListener5 = engagementListener;
            if (userEngagementListener5 != null) {
                userEngagementListener5.onEngagement(new ResultAPI(), HiveUserEngagement.EventType.EVENT_TYPE, HiveUserEngagement.EventState.FINISH, null);
            }
            isRunningHandleEvent = false;
        }
    }
}
