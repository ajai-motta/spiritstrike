package com.hive.module.interfaces;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.ResultAPI;
import com.hive.module.HiveModule;
import com.hive.module.HiveModuleName;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001:\u0006\u001b\u001c\u001d\u001e\u001f J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H&J\"\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0011H&J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0003H&J\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H&J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0003H&J\u0014\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u001aH\u0016¨\u0006!"}, d2 = {"Lcom/hive/module/interfaces/HiveUserEngagement;", "Lcom/hive/module/HiveModule;", "getHiveModuleName", "", "isReadyToProcess", "", "isRunningHandleEvent", "setEngagementListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/module/interfaces/HiveUserEngagement$UserEngagementListener;", "setEngagementReady", "Lcom/hive/ResultAPI;", "isReady", "consumeCoupon", "couponCode", "additionalInfo", "Lcom/hive/module/interfaces/HiveUserEngagement$CouponListener;", "isEventValid", "eventUrl", "appendEventQueryParameters", "Lorg/json/JSONObject;", "jsonObject", "processUri", ShareConstants.MEDIA_URI, "getVersionInfo", "", "InterworkApi", "InterworkTarget", "EventType", "EventState", "UserEngagementListener", "CouponListener", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface HiveUserEngagement extends HiveModule {

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/hive/module/interfaces/HiveUserEngagement$CouponListener;", "", "onCouponConsume", "", "result", "Lcom/hive/ResultAPI;", "resultCode", "", "resultMessage", "", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface CouponListener {
        void onCouponConsume(ResultAPI result, int resultCode, String resultMessage);
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void consumeCoupon$default(HiveUserEngagement hiveUserEngagement, String str, String str2, CouponListener couponListener, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: consumeCoupon");
            }
            if ((i & 2) != 0) {
                str2 = "";
            }
            hiveUserEngagement.consumeCoupon(str, str2, couponListener);
        }

        public static String getHiveModuleName(HiveUserEngagement hiveUserEngagement) {
            return HiveModuleName.INSTANCE.getUserEngagement();
        }

        public static Map<String, String> getVersionInfo(HiveUserEngagement hiveUserEngagement) {
            return new HashMap();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/hive/module/interfaces/HiveUserEngagement$EventState;", "", "<init>", "(Ljava/lang/String;I)V", "BEGIN", "FINISH", "START", "END", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class EventState {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ EventState[] $VALUES;
        public static final EventState BEGIN = new EventState("BEGIN", 0);
        public static final EventState FINISH = new EventState("FINISH", 1);
        public static final EventState START = new EventState("START", 2);
        public static final EventState END = new EventState("END", 3);

        private static final /* synthetic */ EventState[] $values() {
            return new EventState[]{BEGIN, FINISH, START, END};
        }

        static {
            EventState[] eventStateArr$values = $values();
            $VALUES = eventStateArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(eventStateArr$values);
        }

        private EventState(String str, int i) {
        }

        public static EnumEntries<EventState> getEntries() {
            return $ENTRIES;
        }

        public static EventState valueOf(String str) {
            return (EventState) Enum.valueOf(EventState.class, str);
        }

        public static EventState[] values() {
            return (EventState[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0012\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/hive/module/interfaces/HiveUserEngagement$EventType;", "", "<init>", "(Ljava/lang/String;I)V", "EVENT_TYPE", "PROMOTION_VIEW", "OFFERWALL_VIEW", "USERACQUISTION", "COUPON", "AUTH_LOGIN_VIEW", "SOCIAL_INQUIRY_VIEW", "SOCIAL_MYINQUIRY_VIEW", "SOCIAL_PROFILE_VIEW", "EVENT", "IAP_UPDATED", "IAP_PURCHASE", "IAP_PROMOTE", "COMPANION", "COMMUNITY_VIEW", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class EventType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ EventType[] $VALUES;
        public static final EventType EVENT_TYPE = new EventType("EVENT_TYPE", 0);
        public static final EventType PROMOTION_VIEW = new EventType("PROMOTION_VIEW", 1);
        public static final EventType OFFERWALL_VIEW = new EventType("OFFERWALL_VIEW", 2);
        public static final EventType USERACQUISTION = new EventType("USERACQUISTION", 3);
        public static final EventType COUPON = new EventType("COUPON", 4);
        public static final EventType AUTH_LOGIN_VIEW = new EventType("AUTH_LOGIN_VIEW", 5);
        public static final EventType SOCIAL_INQUIRY_VIEW = new EventType("SOCIAL_INQUIRY_VIEW", 6);
        public static final EventType SOCIAL_MYINQUIRY_VIEW = new EventType("SOCIAL_MYINQUIRY_VIEW", 7);
        public static final EventType SOCIAL_PROFILE_VIEW = new EventType("SOCIAL_PROFILE_VIEW", 8);
        public static final EventType EVENT = new EventType("EVENT", 9);
        public static final EventType IAP_UPDATED = new EventType("IAP_UPDATED", 10);
        public static final EventType IAP_PURCHASE = new EventType("IAP_PURCHASE", 11);
        public static final EventType IAP_PROMOTE = new EventType("IAP_PROMOTE", 12);
        public static final EventType COMPANION = new EventType("COMPANION", 13);
        public static final EventType COMMUNITY_VIEW = new EventType("COMMUNITY_VIEW", 14);

        private static final /* synthetic */ EventType[] $values() {
            return new EventType[]{EVENT_TYPE, PROMOTION_VIEW, OFFERWALL_VIEW, USERACQUISTION, COUPON, AUTH_LOGIN_VIEW, SOCIAL_INQUIRY_VIEW, SOCIAL_MYINQUIRY_VIEW, SOCIAL_PROFILE_VIEW, EVENT, IAP_UPDATED, IAP_PURCHASE, IAP_PROMOTE, COMPANION, COMMUNITY_VIEW};
        }

        static {
            EventType[] eventTypeArr$values = $values();
            $VALUES = eventTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(eventTypeArr$values);
        }

        private EventType(String str, int i) {
        }

        public static EnumEntries<EventType> getEntries() {
            return $ENTRIES;
        }

        public static EventType valueOf(String str) {
            return (EventType) Enum.valueOf(EventType.class, str);
        }

        public static EventType[] values() {
            return (EventType[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0086\u0081\u0002\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001bB\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001a¨\u0006\u001c"}, d2 = {"Lcom/hive/module/interfaces/HiveUserEngagement$InterworkApi;", "", "value", "", "interworkTarget", "Lcom/hive/module/interfaces/HiveUserEngagement$InterworkTarget;", "<init>", "(Ljava/lang/String;ILjava/lang/String;Lcom/hive/module/interfaces/HiveUserEngagement$InterworkTarget;)V", "getValue", "()Ljava/lang/String;", "getInterworkTarget", "()Lcom/hive/module/interfaces/HiveUserEngagement$InterworkTarget;", "AUTHLOGIN", "SOCIALINQUIRY", "SOCIALINQUERY", "SOCIALMYINQUIRY", "SOCIALPROFILE", "COMMUNITYSHOW", "SOCIALCOMMUNITY", "PROMOTIONSHOW", "OFFERWALLSHOW", "PROMOTIONOFFERWALL", "PROMOTIONCOUPON", "IAPUPDATED", "IAPPURCHASE", "IAPPROMOTE", "PROMOTIONCOMPANION", k.M, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class InterworkApi {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ InterworkApi[] $VALUES;
        public static final InterworkApi AUTHLOGIN = new InterworkApi("AUTHLOGIN", 0, "/authlogin", InterworkTarget.AUTH);
        public static final InterworkApi COMMUNITYSHOW;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        public static final InterworkApi IAPPROMOTE;
        public static final InterworkApi IAPPURCHASE;
        public static final InterworkApi IAPUPDATED;
        public static final InterworkApi OFFERWALLSHOW;
        public static final InterworkApi PROMOTIONCOMPANION;
        public static final InterworkApi PROMOTIONCOUPON;
        public static final InterworkApi PROMOTIONOFFERWALL;
        public static final InterworkApi PROMOTIONSHOW;
        public static final InterworkApi SOCIALCOMMUNITY;
        public static final InterworkApi SOCIALINQUERY;
        public static final InterworkApi SOCIALINQUIRY;
        public static final InterworkApi SOCIALMYINQUIRY;
        public static final InterworkApi SOCIALPROFILE;
        private static final HashMap<Object, InterworkApi> map;
        private final InterworkTarget interworkTarget;
        private final String value;

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\fR*\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u0005j\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/hive/module/interfaces/HiveUserEngagement$InterworkApi$Companion;", "", "<init>", "()V", "map", "Ljava/util/HashMap;", "Lcom/hive/module/interfaces/HiveUserEngagement$InterworkApi;", "Lkotlin/collections/HashMap;", "getInterworkApi", "key", "", TypedValues.AttributesType.S_TARGET, "Lcom/hive/module/interfaces/HiveUserEngagement$InterworkTarget;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final InterworkApi getInterworkApi(String key) {
                Intrinsics.checkNotNullParameter(key, "key");
                if (StringsKt.startsWith$default(key, DomExceptionUtils.SEPARATOR, false, 2, (Object) null)) {
                    String strReplace = new Regex(DomExceptionUtils.SEPARATOR).replace(key, "");
                    InterworkApi interworkApi = (InterworkApi) InterworkApi.map.get(DomExceptionUtils.SEPARATOR + strReplace);
                    if (interworkApi != null) {
                        return interworkApi;
                    }
                }
                return (InterworkApi) InterworkApi.map.get(key);
            }

            private Companion() {
            }

            public final InterworkApi getInterworkApi(InterworkTarget target) {
                Intrinsics.checkNotNullParameter(target, "target");
                return (InterworkApi) InterworkApi.map.get(target);
            }
        }

        private static final /* synthetic */ InterworkApi[] $values() {
            return new InterworkApi[]{AUTHLOGIN, SOCIALINQUIRY, SOCIALINQUERY, SOCIALMYINQUIRY, SOCIALPROFILE, COMMUNITYSHOW, SOCIALCOMMUNITY, PROMOTIONSHOW, OFFERWALLSHOW, PROMOTIONOFFERWALL, PROMOTIONCOUPON, IAPUPDATED, IAPPURCHASE, IAPPROMOTE, PROMOTIONCOMPANION};
        }

        static {
            InterworkTarget interworkTarget = InterworkTarget.SOCIAL;
            SOCIALINQUIRY = new InterworkApi("SOCIALINQUIRY", 1, "/socialinquiry", interworkTarget);
            SOCIALINQUERY = new InterworkApi("SOCIALINQUERY", 2, "/socialinquery", interworkTarget);
            SOCIALMYINQUIRY = new InterworkApi("SOCIALMYINQUIRY", 3, "/socialmyinquiry", interworkTarget);
            SOCIALPROFILE = new InterworkApi("SOCIALPROFILE", 4, "/socialprofile", interworkTarget);
            COMMUNITYSHOW = new InterworkApi("COMMUNITYSHOW", 5, "/communityshow", interworkTarget);
            SOCIALCOMMUNITY = new InterworkApi("SOCIALCOMMUNITY", 6, "/social/community", interworkTarget);
            InterworkTarget interworkTarget2 = InterworkTarget.PROMOTION;
            PROMOTIONSHOW = new InterworkApi("PROMOTIONSHOW", 7, "/promotionshow", interworkTarget2);
            OFFERWALLSHOW = new InterworkApi("OFFERWALLSHOW", 8, "/offerwallshow", interworkTarget2);
            PROMOTIONOFFERWALL = new InterworkApi("PROMOTIONOFFERWALL", 9, "/promotionofferwall", interworkTarget2);
            PROMOTIONCOUPON = new InterworkApi("PROMOTIONCOUPON", 10, "/promotioncoupon", InterworkTarget.USERENGAGEMENT);
            InterworkTarget interworkTarget3 = InterworkTarget.IAP;
            IAPUPDATED = new InterworkApi("IAPUPDATED", 11, "/iapupdated", interworkTarget3);
            IAPPURCHASE = new InterworkApi("IAPPURCHASE", 12, "/iappurchase", interworkTarget3);
            IAPPROMOTE = new InterworkApi("IAPPROMOTE", 13, "/iappromote", interworkTarget3);
            PROMOTIONCOMPANION = new InterworkApi("PROMOTIONCOMPANION", 14, "/promotion/companion", interworkTarget2);
            InterworkApi[] interworkApiArr$values = $values();
            $VALUES = interworkApiArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(interworkApiArr$values);
            INSTANCE = new Companion(null);
            map = new HashMap<>();
            for (InterworkApi interworkApi : values()) {
                HashMap<Object, InterworkApi> map2 = map;
                map2.put(interworkApi.value, interworkApi);
                map2.put(interworkApi.interworkTarget, interworkApi);
            }
        }

        private InterworkApi(String str, int i, String str2, InterworkTarget interworkTarget) {
            this.value = str2;
            this.interworkTarget = interworkTarget;
        }

        public static EnumEntries<InterworkApi> getEntries() {
            return $ENTRIES;
        }

        public static InterworkApi valueOf(String str) {
            return (InterworkApi) Enum.valueOf(InterworkApi.class, str);
        }

        public static InterworkApi[] values() {
            return (InterworkApi[]) $VALUES.clone();
        }

        public final InterworkTarget getInterworkTarget() {
            return this.interworkTarget;
        }

        public final String getValue() {
            return this.value;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/hive/module/interfaces/HiveUserEngagement$InterworkTarget;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "AUTH", "SOCIAL", "PROMOTION", "USERENGAGEMENT", "GAME", "IAP", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class InterworkTarget {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ InterworkTarget[] $VALUES;
        private final String value;
        public static final InterworkTarget AUTH = new InterworkTarget("AUTH", 0, "/auth");
        public static final InterworkTarget SOCIAL = new InterworkTarget("SOCIAL", 1, "/social");
        public static final InterworkTarget PROMOTION = new InterworkTarget("PROMOTION", 2, "/promotion");
        public static final InterworkTarget USERENGAGEMENT = new InterworkTarget("USERENGAGEMENT", 3, "/userengagement");
        public static final InterworkTarget GAME = new InterworkTarget("GAME", 4, "/game");
        public static final InterworkTarget IAP = new InterworkTarget("IAP", 5, "/iap");

        private static final /* synthetic */ InterworkTarget[] $values() {
            return new InterworkTarget[]{AUTH, SOCIAL, PROMOTION, USERENGAGEMENT, GAME, IAP};
        }

        static {
            InterworkTarget[] interworkTargetArr$values = $values();
            $VALUES = interworkTargetArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(interworkTargetArr$values);
        }

        private InterworkTarget(String str, int i, String str2) {
            this.value = str2;
        }

        public static EnumEntries<InterworkTarget> getEntries() {
            return $ENTRIES;
        }

        public static InterworkTarget valueOf(String str) {
            return (InterworkTarget) Enum.valueOf(InterworkTarget.class, str);
        }

        public static InterworkTarget[] values() {
            return (InterworkTarget[]) $VALUES.clone();
        }

        public final String getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&¨\u0006\f"}, d2 = {"Lcom/hive/module/interfaces/HiveUserEngagement$UserEngagementListener;", "", "onEngagement", "", "result", "Lcom/hive/ResultAPI;", "eventType", "Lcom/hive/module/interfaces/HiveUserEngagement$EventType;", "eventState", "Lcom/hive/module/interfaces/HiveUserEngagement$EventState;", "param", "Lorg/json/JSONObject;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface UserEngagementListener {
        void onEngagement(ResultAPI result, EventType eventType, EventState eventState, JSONObject param);
    }

    JSONObject appendEventQueryParameters(JSONObject jsonObject);

    void consumeCoupon(String couponCode, String additionalInfo, CouponListener listener);

    @Override // com.hive.module.HiveModule
    String getHiveModuleName();

    @Override // com.hive.module.HiveModule
    Map<String, String> getVersionInfo();

    boolean isEventValid(String eventUrl);

    boolean isReadyToProcess();

    boolean isRunningHandleEvent();

    boolean processUri(String uri);

    void setEngagementListener(UserEngagementListener listener);

    ResultAPI setEngagementReady(boolean isReady);
}
