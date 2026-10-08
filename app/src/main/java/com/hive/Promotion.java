package com.hive;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.adjust.sdk.Constants;
import com.adxcorp.ads.mediation.util.ReportUtil;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.share.internal.ShareConstants;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hive.ResultAPI;
import com.hive.analytics.provider.adjust.AnalyticsProviderAdjust;
import com.hive.base.DataModel;
import com.hive.core.StringUtil;
import com.hive.logger.LoggerImpl;
import com.hive.module.HiveModule;
import com.hive.module.HiveModuleManager;
import com.hive.module.interfaces.HivePromotion;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\bÆ\u0002\u0018\u00002\u00020\u0001:\u001aHIJKLMNOPQRSTUVWXYZ[\\]^_`aB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0007J \u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J*\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00052\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c2\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J \u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J \u0010\"\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\u0010\u0010(\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\b\u0010)\u001a\u00020\u0013H\u0007J\u0010\u0010*\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\u0010\u0010+\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J \u0010,\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010-\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020.H\u0007J\u0010\u0010/\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u000200H\u0007J \u00101\u001a\u00020\u00132\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\u0006\u0010\u0017\u001a\u000206H\u0007J \u00107\u001a\u00020\u00132\u0006\u00102\u001a\u00020\u00052\u0006\u00104\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u000206H\u0007J\u0010\u00108\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u000209H\u0007J\u0010\u0010:\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020;H\u0007J \u0010<\u001a\u00020\u00132\u0006\u0010=\u001a\u00020\u00052\u0006\u0010>\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020?H\u0007J\u0010\u0010@\u001a\u00020\u00132\u0006\u0010A\u001a\u00020\u0005H\u0007J\u0010\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\u0010H\u0007J\u0010\u0010E\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020FH\u0007J\b\u0010G\u001a\u00020\u0013H\u0007R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010#\u001a\u00020$8FX\u0087\u0004¢\u0006\f\u0012\u0004\b%\u0010\u0003\u001a\u0004\b&\u0010'¨\u0006b"}, d2 = {"Lcom/hive/Promotion;", "", "<init>", "()V", "TAG", "", "getTAG$annotations", "getTAG", "()Ljava/lang/String;", "hivePromotion", "Lcom/hive/module/interfaces/HivePromotion;", "TIME_REQUESTED_NEWS", "TIME_REQUESTED_NOTICE", "TIME_REQUESTED_CUSTOMVIEW", "TIME_REQUESTED_CUSTOMBOARD", "processURI", "", ShareConstants.MEDIA_URI, "showPromotion", "", "promotionType", "Lcom/hive/Promotion$PromotionViewType;", "isForced", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/Promotion$PromotionViewListener;", "showNews", "menu", "giftPidList", "Ljava/util/ArrayList;", "", "showCustomContents", "promotionCustomType", "Lcom/hive/Promotion$PromotionCustomType;", "contentsKey", "showCustomContentsOnGameWindow", "offerwallState", "Lcom/hive/Promotion$OfferwallState;", "getOfferwallState$annotations", "getOfferwallState", "()Lcom/hive/Promotion$OfferwallState;", "showOfferwall", "showNativeReview", "showReview", "showExit", "getViewInfo", "contentKey", "Lcom/hive/Promotion$PromotionViewInfoListener;", "getBadgeInfo", "Lcom/hive/Promotion$PromotionBadgeInfoListener;", "getBannerInfo", "campaignType", "Lcom/hive/Promotion$PromotionCampaignType;", "bannerType", "Lcom/hive/Promotion$PromotionBannerType;", "Lcom/hive/Promotion$PromotionBannerInfoListener;", "getBannerInfoString", "getAppInvitationData", "Lcom/hive/Promotion$AppInvitationDataListener;", "getAppInvitationSenderInfo", "Lcom/hive/Promotion$AppInvitationSenderInfoListener;", "showUAShare", "inviteMessage", "inviteLink", "Lcom/hive/Promotion$PromotionShareListener;", "setAdditionalInfo", "additionalInfo", "setEngagementReady", "Lcom/hive/ResultAPI;", "bReady", "setEngagementListener", "Lcom/hive/Promotion$EngagementListener;", "updatePromotionData", "PromotionViewListener", "PromotionViewInfoListener", "PromotionViewInfoWithJSONListener", "PromotionBadgeInfoListener", "PromotionBannerInfoListener", "AppInvitationDataListener", "AppInvitationSenderInfoListener", "PromotionShareListener", "PromotionViewResultType", "PromotionViewType", "PromotionCustomType", "PromotionBadgeTarget", "PromotionWebviewType", "PromotionCampaignType", "PromotionBannerType", "OfferwallState", "PromotionViewInfo", "PromotionBadge", "PromotionBanner", "AppInvitationData", "AppInvitationSenderInfo", "AppInvitationCampaign", "AppInvitationCampaignStage", "EngagementEventType", "EngagementEventState", "EngagementListener", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Promotion {
    public static final Promotion INSTANCE = new Promotion();
    private static final String TAG;
    private static final String TIME_REQUESTED_CUSTOMBOARD = "promotion.time_requested_customboard";
    private static final String TIME_REQUESTED_CUSTOMVIEW = "promotion.time_requested_customview";
    private static final String TIME_REQUESTED_NEWS = "promotion.time_requested_new";
    private static final String TIME_REQUESTED_NOTICE = "promotion.time_requested_notice";
    private static final HivePromotion hivePromotion;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, d2 = {"Lcom/hive/Promotion$AppInvitationDataListener;", "", "onAppInvitationData", "", "result", "Lcom/hive/ResultAPI;", "appInvitationData", "Lcom/hive/Promotion$AppInvitationData;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface AppInvitationDataListener {
        void onAppInvitationData(ResultAPI result, AppInvitationData appInvitationData);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, d2 = {"Lcom/hive/Promotion$AppInvitationSenderInfoListener;", "", "onAppInvitationSenderInfo", "", "result", "Lcom/hive/ResultAPI;", "appInvitationSenderInfo", "Lcom/hive/Promotion$AppInvitationSenderInfo;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface AppInvitationSenderInfoListener {
        void onAppInvitationSenderInfo(ResultAPI result, AppInvitationSenderInfo appInvitationSenderInfo);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/hive/Promotion$EngagementEventState;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "BEGIN", "FINISH", "START", "END", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class EngagementEventState {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ EngagementEventState[] $VALUES;
        private final String value;
        public static final EngagementEventState BEGIN = new EngagementEventState("BEGIN", 0, "engagement_begin");
        public static final EngagementEventState FINISH = new EngagementEventState("FINISH", 1, "engagement_finish");
        public static final EngagementEventState START = new EngagementEventState("START", 2, "engagement_start");
        public static final EngagementEventState END = new EngagementEventState("END", 3, "engagement_end");

        private static final /* synthetic */ EngagementEventState[] $values() {
            return new EngagementEventState[]{BEGIN, FINISH, START, END};
        }

        static {
            EngagementEventState[] engagementEventStateArr$values = $values();
            $VALUES = engagementEventStateArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(engagementEventStateArr$values);
        }

        private EngagementEventState(String str, int i, String str2) {
            this.value = str2;
        }

        public static EnumEntries<EngagementEventState> getEntries() {
            return $ENTRIES;
        }

        public static EngagementEventState valueOf(String str) {
            return (EngagementEventState) Enum.valueOf(EngagementEventState.class, str);
        }

        public static EngagementEventState[] values() {
            return (EngagementEventState[]) $VALUES.clone();
        }

        public final String getValue() {
            return this.value;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u0018"}, d2 = {"Lcom/hive/Promotion$EngagementEventType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "EVENT_TYPE", "PROMOTION_VIEW", "OFFERWALL_VIEW", "USERACQUISTION", "COUPON", "AUTH_LOGIN_VIEW", "SOCIAL_INQUIRY_VIEW", "SOCIAL_MYINQUIRY_VIEW", "SOCIAL_PROFILE_VIEW", "EVENT", "IAP_UPDATED", "IAP_PURCHASE", "IAP_PROMOTE", "COMPANION", "COMMUNITY_VIEW", "APPUPDATE_DOWNLOADED", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class EngagementEventType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ EngagementEventType[] $VALUES;
        private final String value;
        public static final EngagementEventType EVENT_TYPE = new EngagementEventType("EVENT_TYPE", 0, "engagement");
        public static final EngagementEventType PROMOTION_VIEW = new EngagementEventType("PROMOTION_VIEW", 1, "engagement_promotion_view");
        public static final EngagementEventType OFFERWALL_VIEW = new EngagementEventType("OFFERWALL_VIEW", 2, "engagement_offerwall_view");
        public static final EngagementEventType USERACQUISTION = new EngagementEventType("USERACQUISTION", 3, "engagement_useracquistion");
        public static final EngagementEventType COUPON = new EngagementEventType("COUPON", 4, "engagement_coupon");
        public static final EngagementEventType AUTH_LOGIN_VIEW = new EngagementEventType("AUTH_LOGIN_VIEW", 5, "engagement_login");
        public static final EngagementEventType SOCIAL_INQUIRY_VIEW = new EngagementEventType("SOCIAL_INQUIRY_VIEW", 6, "engagement_social_inquiry");
        public static final EngagementEventType SOCIAL_MYINQUIRY_VIEW = new EngagementEventType("SOCIAL_MYINQUIRY_VIEW", 7, "engagement_social_myinquiry");
        public static final EngagementEventType SOCIAL_PROFILE_VIEW = new EngagementEventType("SOCIAL_PROFILE_VIEW", 8, "engagement_social_profile");
        public static final EngagementEventType EVENT = new EngagementEventType("EVENT", 9, "engagement_event");
        public static final EngagementEventType IAP_UPDATED = new EngagementEventType("IAP_UPDATED", 10, "engagement_iapupdated");
        public static final EngagementEventType IAP_PURCHASE = new EngagementEventType("IAP_PURCHASE", 11, "engagement_iappurchase");
        public static final EngagementEventType IAP_PROMOTE = new EngagementEventType("IAP_PROMOTE", 12, "engagement_iappromote");
        public static final EngagementEventType COMPANION = new EngagementEventType("COMPANION", 13, "engagement_companion");
        public static final EngagementEventType COMMUNITY_VIEW = new EngagementEventType("COMMUNITY_VIEW", 14, "engagement_community_view");
        public static final EngagementEventType APPUPDATE_DOWNLOADED = new EngagementEventType("APPUPDATE_DOWNLOADED", 15, "engagement_appupdate_downloaded");

        private static final /* synthetic */ EngagementEventType[] $values() {
            return new EngagementEventType[]{EVENT_TYPE, PROMOTION_VIEW, OFFERWALL_VIEW, USERACQUISTION, COUPON, AUTH_LOGIN_VIEW, SOCIAL_INQUIRY_VIEW, SOCIAL_MYINQUIRY_VIEW, SOCIAL_PROFILE_VIEW, EVENT, IAP_UPDATED, IAP_PURCHASE, IAP_PROMOTE, COMPANION, COMMUNITY_VIEW, APPUPDATE_DOWNLOADED};
        }

        static {
            EngagementEventType[] engagementEventTypeArr$values = $values();
            $VALUES = engagementEventTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(engagementEventTypeArr$values);
        }

        private EngagementEventType(String str, int i, String str2) {
            this.value = str2;
        }

        public static EnumEntries<EngagementEventType> getEntries() {
            return $ENTRIES;
        }

        public static EngagementEventType valueOf(String str) {
            return (EngagementEventType) Enum.valueOf(EngagementEventType.class, str);
        }

        public static EngagementEventType[] values() {
            return (EngagementEventType[]) $VALUES.clone();
        }

        public final String getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&¨\u0006\f"}, d2 = {"Lcom/hive/Promotion$EngagementListener;", "", "onEngagement", "", "result", "Lcom/hive/ResultAPI;", "engagementEventType", "Lcom/hive/Promotion$EngagementEventType;", "engagementEventState", "Lcom/hive/Promotion$EngagementEventState;", "param", "Lorg/json/JSONObject;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface EngagementListener {
        void onEngagement(ResultAPI result, EngagementEventType engagementEventType, EngagementEventState engagementEventState, JSONObject param);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/hive/Promotion$OfferwallState;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "ENABLED", "DISABLED", com.hive.core.Configuration.HIVE_COUNTRY_DEFAULT, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class OfferwallState {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ OfferwallState[] $VALUES;
        private final String value;
        public static final OfferwallState ENABLED = new OfferwallState("ENABLED", 0, "enabled");
        public static final OfferwallState DISABLED = new OfferwallState("DISABLED", 1, "disabled");
        public static final OfferwallState UNKNOWN = new OfferwallState(com.hive.core.Configuration.HIVE_COUNTRY_DEFAULT, 2, "unknown");

        private static final /* synthetic */ OfferwallState[] $values() {
            return new OfferwallState[]{ENABLED, DISABLED, UNKNOWN};
        }

        static {
            OfferwallState[] offerwallStateArr$values = $values();
            $VALUES = offerwallStateArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(offerwallStateArr$values);
        }

        private OfferwallState(String str, int i, String str2) {
            this.value = str2;
        }

        public static EnumEntries<OfferwallState> getEntries() {
            return $ENTRIES;
        }

        public static OfferwallState valueOf(String str) {
            return (OfferwallState) Enum.valueOf(OfferwallState.class, str);
        }

        public static OfferwallState[] values() {
            return (OfferwallState[]) $VALUES.clone();
        }

        public final String getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/hive/Promotion$PromotionBadge;", "Lcom/hive/base/DataModel;", TypedValues.AttributesType.S_TARGET, "Lcom/hive/Promotion$PromotionBadgeTarget;", "contentsKey", "", "badgeType", "<init>", "(Lcom/hive/Promotion$PromotionBadgeTarget;Ljava/lang/String;Ljava/lang/String;)V", "getTarget", "()Lcom/hive/Promotion$PromotionBadgeTarget;", "setTarget", "(Lcom/hive/Promotion$PromotionBadgeTarget;)V", "getContentsKey", "()Ljava/lang/String;", "setContentsKey", "(Ljava/lang/String;)V", "getBadgeType", "setBadgeType", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PromotionBadge extends DataModel {
        private String badgeType;
        private String contentsKey;
        private PromotionBadgeTarget target;

        public PromotionBadge(PromotionBadgeTarget target, String contentsKey, String badgeType) {
            Intrinsics.checkNotNullParameter(target, "target");
            Intrinsics.checkNotNullParameter(contentsKey, "contentsKey");
            Intrinsics.checkNotNullParameter(badgeType, "badgeType");
            this.target = target;
            this.contentsKey = contentsKey;
            this.badgeType = badgeType;
        }

        public final String getBadgeType() {
            return this.badgeType;
        }

        public final String getContentsKey() {
            return this.contentsKey;
        }

        public final PromotionBadgeTarget getTarget() {
            return this.target;
        }

        public final void setBadgeType(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.badgeType = str;
        }

        public final void setContentsKey(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.contentsKey = str;
        }

        public final void setTarget(PromotionBadgeTarget promotionBadgeTarget) {
            Intrinsics.checkNotNullParameter(promotionBadgeTarget, "<set-?>");
            this.target = promotionBadgeTarget;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H&¨\u0006\t"}, d2 = {"Lcom/hive/Promotion$PromotionBadgeInfoListener;", "", "onReceiveInfo", "", "result", "Lcom/hive/ResultAPI;", "badgeInfoList", "Ljava/util/ArrayList;", "Lcom/hive/Promotion$PromotionBadge;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface PromotionBadgeInfoListener {
        void onReceiveInfo(ResultAPI result, ArrayList<PromotionBadge> badgeInfoList);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/hive/Promotion$PromotionBadgeTarget;", "", "value", "", "promotionKey", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "getPromotionKey", "NEWS", "NOTICE", "CUSTOMVIEW", "CUSTOMBOARD", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PromotionBadgeTarget {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ PromotionBadgeTarget[] $VALUES;
        private final String promotionKey;
        private final String value;
        public static final PromotionBadgeTarget NEWS = new PromotionBadgeTarget("NEWS", 0, "news", Promotion.TIME_REQUESTED_NEWS);
        public static final PromotionBadgeTarget NOTICE = new PromotionBadgeTarget("NOTICE", 1, "notice", Promotion.TIME_REQUESTED_NOTICE);
        public static final PromotionBadgeTarget CUSTOMVIEW = new PromotionBadgeTarget("CUSTOMVIEW", 2, "customview", Promotion.TIME_REQUESTED_CUSTOMVIEW);
        public static final PromotionBadgeTarget CUSTOMBOARD = new PromotionBadgeTarget("CUSTOMBOARD", 3, "customboard", Promotion.TIME_REQUESTED_CUSTOMBOARD);

        private static final /* synthetic */ PromotionBadgeTarget[] $values() {
            return new PromotionBadgeTarget[]{NEWS, NOTICE, CUSTOMVIEW, CUSTOMBOARD};
        }

        static {
            PromotionBadgeTarget[] promotionBadgeTargetArr$values = $values();
            $VALUES = promotionBadgeTargetArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(promotionBadgeTargetArr$values);
        }

        private PromotionBadgeTarget(String str, int i, String str2, String str3) {
            this.value = str2;
            this.promotionKey = str3;
        }

        public static EnumEntries<PromotionBadgeTarget> getEntries() {
            return $ENTRIES;
        }

        public static PromotionBadgeTarget valueOf(String str) {
            return (PromotionBadgeTarget) Enum.valueOf(PromotionBadgeTarget.class, str);
        }

        public static PromotionBadgeTarget[] values() {
            return (PromotionBadgeTarget[]) $VALUES.clone();
        }

        public final String getPromotionKey() {
            return this.promotionKey;
        }

        public final String getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H&¨\u0006\t"}, d2 = {"Lcom/hive/Promotion$PromotionBannerInfoListener;", "", "onReceiveInfo", "", "result", "Lcom/hive/ResultAPI;", "bannerInfoList", "Ljava/util/ArrayList;", "Lcom/hive/Promotion$PromotionBanner;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface PromotionBannerInfoListener {
        void onReceiveInfo(ResultAPI result, ArrayList<PromotionBanner> bannerInfoList);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/hive/Promotion$PromotionBannerType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "GREAT", "SMALL", "ROLLING", k.M, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PromotionBannerType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ PromotionBannerType[] $VALUES;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        private final String value;
        public static final PromotionBannerType GREAT = new PromotionBannerType("GREAT", 0, "great");
        public static final PromotionBannerType SMALL = new PromotionBannerType("SMALL", 1, Constants.SMALL);
        public static final PromotionBannerType ROLLING = new PromotionBannerType("ROLLING", 2, "rolling");

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0086\u0002¨\u0006\b"}, d2 = {"Lcom/hive/Promotion$PromotionBannerType$Companion;", "", "<init>", "()V", "get", "Lcom/hive/Promotion$PromotionBannerType;", "value", "", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final PromotionBannerType get(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                for (PromotionBannerType promotionBannerType : PromotionBannerType.values()) {
                    if (Intrinsics.areEqual(value, promotionBannerType.getValue())) {
                        return promotionBannerType;
                    }
                }
                return null;
            }

            private Companion() {
            }
        }

        private static final /* synthetic */ PromotionBannerType[] $values() {
            return new PromotionBannerType[]{GREAT, SMALL, ROLLING};
        }

        static {
            PromotionBannerType[] promotionBannerTypeArr$values = $values();
            $VALUES = promotionBannerTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(promotionBannerTypeArr$values);
            INSTANCE = new Companion(null);
        }

        private PromotionBannerType(String str, int i, String str2) {
            this.value = str2;
        }

        public static EnumEntries<PromotionBannerType> getEntries() {
            return $ENTRIES;
        }

        public static PromotionBannerType valueOf(String str) {
            return (PromotionBannerType) Enum.valueOf(PromotionBannerType.class, str);
        }

        public static PromotionBannerType[] values() {
            return (PromotionBannerType[]) $VALUES.clone();
        }

        public final String getValue() {
            return this.value;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/hive/Promotion$PromotionCampaignType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "EVENT", "NOTICE", "ALL", "CROSS", k.M, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PromotionCampaignType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ PromotionCampaignType[] $VALUES;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        private final String value;
        public static final PromotionCampaignType EVENT = new PromotionCampaignType("EVENT", 0, "event");
        public static final PromotionCampaignType NOTICE = new PromotionCampaignType("NOTICE", 1, "notice");
        public static final PromotionCampaignType ALL = new PromotionCampaignType("ALL", 2, TtmlNode.COMBINE_ALL);
        public static final PromotionCampaignType CROSS = new PromotionCampaignType("CROSS", 3, "cross");

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0086\u0002¨\u0006\b"}, d2 = {"Lcom/hive/Promotion$PromotionCampaignType$Companion;", "", "<init>", "()V", "get", "Lcom/hive/Promotion$PromotionCampaignType;", "value", "", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final PromotionCampaignType get(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                for (PromotionCampaignType promotionCampaignType : PromotionCampaignType.values()) {
                    if (Intrinsics.areEqual(value, promotionCampaignType.getValue())) {
                        return promotionCampaignType;
                    }
                }
                return null;
            }

            private Companion() {
            }
        }

        private static final /* synthetic */ PromotionCampaignType[] $values() {
            return new PromotionCampaignType[]{EVENT, NOTICE, ALL, CROSS};
        }

        static {
            PromotionCampaignType[] promotionCampaignTypeArr$values = $values();
            $VALUES = promotionCampaignTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(promotionCampaignTypeArr$values);
            INSTANCE = new Companion(null);
        }

        private PromotionCampaignType(String str, int i, String str2) {
            this.value = str2;
        }

        public static EnumEntries<PromotionCampaignType> getEntries() {
            return $ENTRIES;
        }

        public static PromotionCampaignType valueOf(String str) {
            return (PromotionCampaignType) Enum.valueOf(PromotionCampaignType.class, str);
        }

        public static PromotionCampaignType[] values() {
            return (PromotionCampaignType[]) $VALUES.clone();
        }

        public final String getValue() {
            return this.value;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/hive/Promotion$PromotionCustomType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "VIEW", "BOARD", "SPOT", "DIRECT", k.M, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PromotionCustomType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ PromotionCustomType[] $VALUES;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        private final String value;
        public static final PromotionCustomType VIEW = new PromotionCustomType("VIEW", 0, "view");
        public static final PromotionCustomType BOARD = new PromotionCustomType("BOARD", 1, "board");
        public static final PromotionCustomType SPOT = new PromotionCustomType("SPOT", 2, "spot");
        public static final PromotionCustomType DIRECT = new PromotionCustomType("DIRECT", 3, DevicePublicKeyStringDef.DIRECT);

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0086\u0002¨\u0006\b"}, d2 = {"Lcom/hive/Promotion$PromotionCustomType$Companion;", "", "<init>", "()V", "get", "Lcom/hive/Promotion$PromotionCustomType;", "value", "", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final PromotionCustomType get(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                for (PromotionCustomType promotionCustomType : PromotionCustomType.values()) {
                    if (Intrinsics.areEqual(value, promotionCustomType.getValue())) {
                        return promotionCustomType;
                    }
                }
                return null;
            }

            private Companion() {
            }
        }

        private static final /* synthetic */ PromotionCustomType[] $values() {
            return new PromotionCustomType[]{VIEW, BOARD, SPOT, DIRECT};
        }

        static {
            PromotionCustomType[] promotionCustomTypeArr$values = $values();
            $VALUES = promotionCustomTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(promotionCustomTypeArr$values);
            INSTANCE = new Companion(null);
        }

        private PromotionCustomType(String str, int i, String str2) {
            this.value = str2;
        }

        public static EnumEntries<PromotionCustomType> getEntries() {
            return $ENTRIES;
        }

        public static PromotionCustomType valueOf(String str) {
            return (PromotionCustomType) Enum.valueOf(PromotionCustomType.class, str);
        }

        public static PromotionCustomType[] values() {
            return (PromotionCustomType[]) $VALUES.clone();
        }

        public final String getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/hive/Promotion$PromotionShareListener;", "", "onPromotionShare", "", "result", "Lcom/hive/ResultAPI;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface PromotionShareListener {
        void onPromotionShare(ResultAPI result);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\r"}, d2 = {"Lcom/hive/Promotion$PromotionViewInfo;", "Lcom/hive/base/DataModel;", "url", "", "postString", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "getPostString", "setPostString", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PromotionViewInfo extends DataModel {
        private String postString;
        private String url;

        public PromotionViewInfo(String url, String postString) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(postString, "postString");
            this.url = url;
            this.postString = postString;
        }

        public final String getPostString() {
            return this.postString;
        }

        public final String getUrl() {
            return this.url;
        }

        public final void setPostString(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.postString = str;
        }

        public final void setUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.url = str;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H&¨\u0006\t"}, d2 = {"Lcom/hive/Promotion$PromotionViewInfoListener;", "", "onReceiveInfo", "", "result", "Lcom/hive/ResultAPI;", "viewInfo", "Ljava/util/ArrayList;", "Lcom/hive/Promotion$PromotionViewInfo;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface PromotionViewInfoListener {
        void onReceiveInfo(ResultAPI result, ArrayList<PromotionViewInfo> viewInfo);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, d2 = {"Lcom/hive/Promotion$PromotionViewInfoWithJSONListener;", "", "onReceiveInfo", "", "result", "Lcom/hive/ResultAPI;", "viewData", "Lorg/json/JSONObject;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface PromotionViewInfoWithJSONListener {
        void onReceiveInfo(ResultAPI result, JSONObject viewData);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/hive/Promotion$PromotionViewListener;", "", "onPromotionView", "", "result", "Lcom/hive/ResultAPI;", "promotionEventType", "Lcom/hive/Promotion$PromotionViewResultType;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface PromotionViewListener {
        void onPromotionView(ResultAPI result, PromotionViewResultType promotionEventType);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/hive/Promotion$PromotionViewResultType;", "", "<init>", "(Ljava/lang/String;I)V", "OPENED", "CLOSED", "START_PLAYBACK", "FINISH_PLAYBACK", "NEED_TO_EXIT", "GOBACK", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PromotionViewResultType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ PromotionViewResultType[] $VALUES;
        public static final PromotionViewResultType OPENED = new PromotionViewResultType("OPENED", 0);
        public static final PromotionViewResultType CLOSED = new PromotionViewResultType("CLOSED", 1);
        public static final PromotionViewResultType START_PLAYBACK = new PromotionViewResultType("START_PLAYBACK", 2);
        public static final PromotionViewResultType FINISH_PLAYBACK = new PromotionViewResultType("FINISH_PLAYBACK", 3);
        public static final PromotionViewResultType NEED_TO_EXIT = new PromotionViewResultType("NEED_TO_EXIT", 4);
        public static final PromotionViewResultType GOBACK = new PromotionViewResultType("GOBACK", 5);

        private static final /* synthetic */ PromotionViewResultType[] $values() {
            return new PromotionViewResultType[]{OPENED, CLOSED, START_PLAYBACK, FINISH_PLAYBACK, NEED_TO_EXIT, GOBACK};
        }

        static {
            PromotionViewResultType[] promotionViewResultTypeArr$values = $values();
            $VALUES = promotionViewResultTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(promotionViewResultTypeArr$values);
        }

        private PromotionViewResultType(String str, int i) {
        }

        public static EnumEntries<PromotionViewResultType> getEntries() {
            return $ENTRIES;
        }

        public static PromotionViewResultType valueOf(String str) {
            return (PromotionViewResultType) Enum.valueOf(PromotionViewResultType.class, str);
        }

        public static PromotionViewResultType[] values() {
            return (PromotionViewResultType[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/hive/Promotion$PromotionViewType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "BANNERLEGACY", "BANNER", "NEWS", "NOTICE", k.M, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PromotionViewType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ PromotionViewType[] $VALUES;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        private final String value;
        public static final PromotionViewType BANNERLEGACY = new PromotionViewType("BANNERLEGACY", 0, "bannerlegacy");
        public static final PromotionViewType BANNER = new PromotionViewType("BANNER", 1, ReportUtil.INVENTORY_TYPE_BANNER);
        public static final PromotionViewType NEWS = new PromotionViewType("NEWS", 2, "news");
        public static final PromotionViewType NOTICE = new PromotionViewType("NOTICE", 3, "notice");

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0086\u0002¨\u0006\b"}, d2 = {"Lcom/hive/Promotion$PromotionViewType$Companion;", "", "<init>", "()V", "get", "Lcom/hive/Promotion$PromotionViewType;", "value", "", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final PromotionViewType get(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                for (PromotionViewType promotionViewType : PromotionViewType.values()) {
                    if (Intrinsics.areEqual(value, promotionViewType.getValue())) {
                        return promotionViewType;
                    }
                }
                return null;
            }

            private Companion() {
            }
        }

        private static final /* synthetic */ PromotionViewType[] $values() {
            return new PromotionViewType[]{BANNERLEGACY, BANNER, NEWS, NOTICE};
        }

        static {
            PromotionViewType[] promotionViewTypeArr$values = $values();
            $VALUES = promotionViewTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(promotionViewTypeArr$values);
            INSTANCE = new Companion(null);
        }

        private PromotionViewType(String str, int i, String str2) {
            this.value = str2;
        }

        public static EnumEntries<PromotionViewType> getEntries() {
            return $ENTRIES;
        }

        public static PromotionViewType valueOf(String str) {
            return (PromotionViewType) Enum.valueOf(PromotionViewType.class, str);
        }

        public static PromotionViewType[] values() {
            return (PromotionViewType[]) $VALUES.clone();
        }

        public final String getValue() {
            return this.value;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0081\u0002\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0014B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0015"}, d2 = {"Lcom/hive/Promotion$PromotionWebviewType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "ALL", "NEWS", "NOTICE", "BANNER", "SPOT", "CUSTOM_BOARD", "CUSTOM_VIEW", "OFFERWALL", "UA", "DIRECT", "COMPANION", "BANNER_DETAIL", k.M, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PromotionWebviewType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ PromotionWebviewType[] $VALUES;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        private final String value;
        public static final PromotionWebviewType ALL = new PromotionWebviewType("ALL", 0, TtmlNode.COMBINE_ALL);
        public static final PromotionWebviewType NEWS = new PromotionWebviewType("NEWS", 1, "news");
        public static final PromotionWebviewType NOTICE = new PromotionWebviewType("NOTICE", 2, "notice");
        public static final PromotionWebviewType BANNER = new PromotionWebviewType("BANNER", 3, ReportUtil.INVENTORY_TYPE_BANNER);
        public static final PromotionWebviewType SPOT = new PromotionWebviewType("SPOT", 4, "spot");
        public static final PromotionWebviewType CUSTOM_BOARD = new PromotionWebviewType("CUSTOM_BOARD", 5, "custom_board");
        public static final PromotionWebviewType CUSTOM_VIEW = new PromotionWebviewType("CUSTOM_VIEW", 6, "custom_view");
        public static final PromotionWebviewType OFFERWALL = new PromotionWebviewType("OFFERWALL", 7, "offerwall");
        public static final PromotionWebviewType UA = new PromotionWebviewType("UA", 8, "ua");
        public static final PromotionWebviewType DIRECT = new PromotionWebviewType("DIRECT", 9, DevicePublicKeyStringDef.DIRECT);
        public static final PromotionWebviewType COMPANION = new PromotionWebviewType("COMPANION", 10, "companion");
        public static final PromotionWebviewType BANNER_DETAIL = new PromotionWebviewType("BANNER_DETAIL", 11, "banner_detail");

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0086\u0002¨\u0006\b"}, d2 = {"Lcom/hive/Promotion$PromotionWebviewType$Companion;", "", "<init>", "()V", "get", "Lcom/hive/Promotion$PromotionWebviewType;", "value", "", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final PromotionWebviewType get(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                for (PromotionWebviewType promotionWebviewType : PromotionWebviewType.values()) {
                    if (Intrinsics.areEqual(value, promotionWebviewType.getValue())) {
                        return promotionWebviewType;
                    }
                }
                return null;
            }

            private Companion() {
            }
        }

        private static final /* synthetic */ PromotionWebviewType[] $values() {
            return new PromotionWebviewType[]{ALL, NEWS, NOTICE, BANNER, SPOT, CUSTOM_BOARD, CUSTOM_VIEW, OFFERWALL, UA, DIRECT, COMPANION, BANNER_DETAIL};
        }

        static {
            PromotionWebviewType[] promotionWebviewTypeArr$values = $values();
            $VALUES = promotionWebviewTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(promotionWebviewTypeArr$values);
            INSTANCE = new Companion(null);
        }

        private PromotionWebviewType(String str, int i, String str2) {
            this.value = str2;
        }

        public static EnumEntries<PromotionWebviewType> getEntries() {
            return $ENTRIES;
        }

        public static PromotionWebviewType valueOf(String str) {
            return (PromotionWebviewType) Enum.valueOf(PromotionWebviewType.class, str);
        }

        public static PromotionWebviewType[] values() {
            return (PromotionWebviewType[]) $VALUES.clone();
        }

        public final String getValue() {
            return this.value;
        }
    }

    static {
        Intrinsics.checkNotNullExpressionValue("Promotion", "getSimpleName(...)");
        TAG = "Promotion";
        HiveModuleManager hiveModuleManager = HiveModuleManager.INSTANCE;
        String name = HivePromotion.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        HiveModule hiveModule = hiveModuleManager.getHiveModule(name);
        if (!(hiveModule instanceof HivePromotion)) {
            hiveModule = null;
        }
        hivePromotion = (HivePromotion) (hiveModule instanceof HivePromotion ? hiveModule : null);
    }

    private Promotion() {
    }

    @JvmStatic
    public static final void getAppInvitationData(AppInvitationDataListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("listener = %s", Arrays.copyOf(new Object[]{listener}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        HivePromotion hivePromotion2 = hivePromotion;
        if (hivePromotion2 != null) {
            hivePromotion2.getAppInvitationData(listener);
        } else {
            listener.onAppInvitationData(new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, "HivePromotion"), null);
        }
        loggerImpl.apiReturnLog(str2, "");
    }

    @JvmStatic
    public static final void getAppInvitationSenderInfo(AppInvitationSenderInfoListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("listener = %s", Arrays.copyOf(new Object[]{listener}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        HivePromotion hivePromotion2 = hivePromotion;
        if (hivePromotion2 != null) {
            hivePromotion2.getAppInvitationSenderInfo(listener);
        } else {
            listener.onAppInvitationSenderInfo(new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, "HivePromotion"), null);
        }
        loggerImpl.apiReturnLog(str2, "");
    }

    @JvmStatic
    public static final void getBadgeInfo(PromotionBadgeInfoListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("listener = %s", Arrays.copyOf(new Object[]{listener}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        HivePromotion hivePromotion2 = hivePromotion;
        if (hivePromotion2 != null) {
            hivePromotion2.getBadgeInfo(listener);
        } else {
            listener.onReceiveInfo(new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, "HivePromotion"), null);
        }
        loggerImpl.apiReturnLog(str2, "");
    }

    @JvmStatic
    public static final void getBannerInfo(PromotionCampaignType campaignType, PromotionBannerType bannerType, PromotionBannerInfoListener listener) {
        Intrinsics.checkNotNullParameter(campaignType, "campaignType");
        Intrinsics.checkNotNullParameter(bannerType, "bannerType");
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("listener = %s", Arrays.copyOf(new Object[]{listener}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        HivePromotion hivePromotion2 = hivePromotion;
        if (hivePromotion2 != null) {
            hivePromotion2.getBannerInfo(campaignType, bannerType, listener);
        } else {
            listener.onReceiveInfo(new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, "HivePromotion"), null);
        }
        loggerImpl.apiReturnLog(str2, "");
    }

    @JvmStatic
    public static final void getBannerInfoString(String campaignType, String bannerType, PromotionBannerInfoListener listener) {
        Intrinsics.checkNotNullParameter(campaignType, "campaignType");
        Intrinsics.checkNotNullParameter(bannerType, "bannerType");
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("listener = %s", Arrays.copyOf(new Object[]{listener}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        HivePromotion hivePromotion2 = hivePromotion;
        if (hivePromotion2 != null) {
            hivePromotion2.getBannerInfoString(campaignType, bannerType, listener);
        } else {
            listener.onReceiveInfo(new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, "HivePromotion"), null);
        }
        loggerImpl.apiReturnLog(str2, "");
    }

    public static final OfferwallState getOfferwallState() {
        OfferwallState offerwallState;
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str = TAG;
        loggerImpl.apiCalledLog(str, "");
        HivePromotion hivePromotion2 = hivePromotion;
        if (hivePromotion2 == null || (offerwallState = hivePromotion2.getOfferwallState()) == null) {
            offerwallState = OfferwallState.UNKNOWN;
        }
        loggerImpl.apiReturnLog(str, offerwallState.getValue());
        return offerwallState;
    }

    @JvmStatic
    public static /* synthetic */ void getOfferwallState$annotations() {
    }

    public static final String getTAG() {
        return TAG;
    }

    @JvmStatic
    public static /* synthetic */ void getTAG$annotations() {
    }

    @JvmStatic
    public static final void getViewInfo(PromotionCustomType promotionCustomType, String contentKey, PromotionViewInfoListener listener) {
        Intrinsics.checkNotNullParameter(promotionCustomType, "promotionCustomType");
        Intrinsics.checkNotNullParameter(contentKey, "contentKey");
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("listener = %s", Arrays.copyOf(new Object[]{listener}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        HivePromotion hivePromotion2 = hivePromotion;
        if (hivePromotion2 != null) {
            hivePromotion2.getViewInfo(promotionCustomType, contentKey, listener);
        } else {
            listener.onReceiveInfo(new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, "HivePromotion"), null);
        }
        loggerImpl.apiReturnLog(str2, "");
    }

    @JvmStatic
    public static final boolean processURI(String uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("uri = %s", Arrays.copyOf(new Object[]{uri}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        HivePromotion hivePromotion2 = hivePromotion;
        boolean zProcessUri = hivePromotion2 != null ? hivePromotion2.processUri(uri) : false;
        loggerImpl.apiReturnLog(str2, "return : " + zProcessUri);
        return zProcessUri;
    }

    @JvmStatic
    public static final void setAdditionalInfo(String additionalInfo) {
        Intrinsics.checkNotNullParameter(additionalInfo, "additionalInfo");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("", Arrays.copyOf(new Object[0], 0));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        HivePromotion hivePromotion2 = hivePromotion;
        if (hivePromotion2 != null) {
            hivePromotion2.setAdditionalInfo(additionalInfo);
        } else {
            loggerImpl.w("Promotion Library Missing.");
        }
        loggerImpl.apiReturnLog(str2, "");
    }

    @JvmStatic
    public static final void setEngagementListener(EngagementListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("listener = %s", Arrays.copyOf(new Object[]{listener}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.apiCalledLog(TAG, str);
        HivePromotion hivePromotion2 = hivePromotion;
        if (hivePromotion2 != null) {
            hivePromotion2.setEngagementListener(listener);
        } else {
            loggerImpl.w("Promotion Library Missing.");
        }
    }

    @JvmStatic
    public static final ResultAPI setEngagementReady(boolean bReady) {
        ResultAPI resultAPI;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("bReady = %s", Arrays.copyOf(new Object[]{Boolean.valueOf(bReady)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        HivePromotion hivePromotion2 = hivePromotion;
        if (hivePromotion2 == null || (resultAPI = hivePromotion2.setEngagementReady(bReady)) == null) {
            resultAPI = new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, "HivePromotion");
        }
        loggerImpl.apiReturnLog(str2, "result : " + resultAPI);
        return resultAPI;
    }

    @JvmStatic
    public static final void showCustomContents(PromotionCustomType promotionCustomType, String contentsKey, PromotionViewListener listener) {
        Intrinsics.checkNotNullParameter(promotionCustomType, "promotionCustomType");
        Intrinsics.checkNotNullParameter(contentsKey, "contentsKey");
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("listener = %s", Arrays.copyOf(new Object[]{listener}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        HivePromotion hivePromotion2 = hivePromotion;
        if (hivePromotion2 != null) {
            hivePromotion2.showCustomContents(promotionCustomType, contentsKey, true, listener);
        } else {
            listener.onPromotionView(new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, "HivePromotion"), PromotionViewResultType.CLOSED);
        }
        loggerImpl.apiReturnLog(str2, "");
    }

    @JvmStatic
    public static final void showCustomContentsOnGameWindow(PromotionCustomType promotionCustomType, String contentsKey, PromotionViewListener listener) {
        Intrinsics.checkNotNullParameter(promotionCustomType, "promotionCustomType");
        Intrinsics.checkNotNullParameter(contentsKey, "contentsKey");
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("listener = %s", Arrays.copyOf(new Object[]{listener}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        HivePromotion hivePromotion2 = hivePromotion;
        if (hivePromotion2 != null) {
            hivePromotion2.showCustomContents(promotionCustomType, contentsKey, false, listener);
        } else {
            listener.onPromotionView(new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, "HivePromotion"), PromotionViewResultType.CLOSED);
        }
        loggerImpl.apiReturnLog(str2, "");
    }

    @JvmStatic
    public static final void showExit(PromotionViewListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("listener = %s", Arrays.copyOf(new Object[]{listener}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        HivePromotion hivePromotion2 = hivePromotion;
        if (hivePromotion2 != null) {
            hivePromotion2.showExit(listener);
        } else {
            listener.onPromotionView(new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, "HivePromotion"), PromotionViewResultType.CLOSED);
        }
        loggerImpl.apiReturnLog(str2, "");
    }

    @JvmStatic
    public static final void showNativeReview() {
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str = TAG;
        loggerImpl.apiCalledLog(str, "");
        HivePromotion hivePromotion2 = hivePromotion;
        if (hivePromotion2 != null) {
            hivePromotion2.showNativeReview();
        } else {
            loggerImpl.w("Promotion Library Missing.");
        }
        loggerImpl.apiReturnLog(str, "");
    }

    @JvmStatic
    public static final void showNews(String menu, ArrayList<Integer> giftPidList, PromotionViewListener listener) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("menu = " + menu + ", listener = %s", Arrays.copyOf(new Object[]{listener}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        HivePromotion hivePromotion2 = hivePromotion;
        if (hivePromotion2 != null) {
            hivePromotion2.showNews(menu, giftPidList, listener);
        } else {
            listener.onPromotionView(new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, "HivePromotion"), PromotionViewResultType.CLOSED);
        }
        loggerImpl.apiReturnLog(str2, "");
    }

    public static /* synthetic */ void showNews$default(String str, ArrayList arrayList, PromotionViewListener promotionViewListener, int i, Object obj) {
        if ((i & 2) != 0) {
            arrayList = null;
        }
        showNews(str, arrayList, promotionViewListener);
    }

    @JvmStatic
    public static final void showOfferwall(PromotionViewListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("listener = %s", Arrays.copyOf(new Object[]{listener}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        HivePromotion hivePromotion2 = hivePromotion;
        if (hivePromotion2 != null) {
            hivePromotion2.showOfferwall(listener);
        } else {
            listener.onPromotionView(new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, "HivePromotion"), PromotionViewResultType.CLOSED);
        }
        loggerImpl.apiReturnLog(str2, "");
    }

    @JvmStatic
    public static final void showPromotion(PromotionViewType promotionType, boolean isForced, PromotionViewListener listener) {
        Intrinsics.checkNotNullParameter(promotionType, "promotionType");
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("listener = %s", Arrays.copyOf(new Object[]{listener}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        HivePromotion hivePromotion2 = hivePromotion;
        if (hivePromotion2 != null) {
            hivePromotion2.showPromotion(promotionType, isForced, null, listener);
        } else {
            listener.onPromotionView(new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, "HivePromotion"), PromotionViewResultType.CLOSED);
        }
        loggerImpl.apiReturnLog(str2, "");
    }

    @JvmStatic
    public static final void showReview(PromotionViewListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str = TAG;
        loggerImpl.apiCalledLog(str, "");
        HivePromotion hivePromotion2 = hivePromotion;
        if (hivePromotion2 != null) {
            hivePromotion2.showReview(listener);
        } else {
            listener.onPromotionView(new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, "HivePromotion"), PromotionViewResultType.CLOSED);
        }
        loggerImpl.apiReturnLog(str, "");
    }

    @JvmStatic
    public static final void showUAShare(String inviteMessage, String inviteLink, PromotionShareListener listener) {
        Intrinsics.checkNotNullParameter(inviteMessage, "inviteMessage");
        Intrinsics.checkNotNullParameter(inviteLink, "inviteLink");
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("listener = %s", Arrays.copyOf(new Object[]{listener}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        HivePromotion hivePromotion2 = hivePromotion;
        if (hivePromotion2 != null) {
            hivePromotion2.showUAShare(inviteMessage, inviteLink, true, listener);
        } else {
            listener.onPromotionShare(new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, "HivePromotion"));
        }
        loggerImpl.apiReturnLog(str2, "");
    }

    @JvmStatic
    public static final void updatePromotionData() {
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str = TAG;
        loggerImpl.apiCalledLog(str, "");
        HivePromotion hivePromotion2 = hivePromotion;
        if (hivePromotion2 != null) {
            hivePromotion2.updatePromotionData();
        } else {
            loggerImpl.w("Promotion Library Missing.");
        }
        loggerImpl.apiReturnLog(str, "");
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u0001BY\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\u0010B\u0011\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0003¢\u0006\u0004\b\u000f\u0010\u0012J\b\u0010\u0019\u001a\u00020\tH\u0016R\u001a\u0010\r\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u000e\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/hive/Promotion$AppInvitationCampaignStage;", "Lcom/hive/Promotion$AppInvitationCampaign;", "title", "", "description", "imageUrl", "order", "", "item", "Lorg/json/JSONObject;", "count", "limit", "campaignId", "goalCount", "goalTotal", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILorg/json/JSONObject;IILjava/lang/String;II)V", "jsonCampaignInfo", "(Ljava/lang/String;)V", "getGoalCount", "()I", "setGoalCount", "(I)V", "getGoalTotal", "setGoalTotal", "toJson", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AppInvitationCampaignStage extends AppInvitationCampaign {
        private int goalCount;
        private int goalTotal;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AppInvitationCampaignStage(String title, String description, String imageUrl, int i, JSONObject item, int i2, int i3, String campaignId, int i4, int i5) {
            super(title, description, imageUrl, i, item, i2, i3, campaignId);
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(description, "description");
            Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(campaignId, "campaignId");
            this.goalCount = i4;
            this.goalTotal = i5;
        }

        public final int getGoalCount() {
            return this.goalCount;
        }

        public final int getGoalTotal() {
            return this.goalTotal;
        }

        public final void setGoalCount(int i) {
            this.goalCount = i;
        }

        public final void setGoalTotal(int i) {
            this.goalTotal = i;
        }

        @Override // com.hive.Promotion.AppInvitationCampaign
        public JSONObject toJson() {
            JSONObject json = super.toJson();
            try {
                json.put("goalCount", this.goalCount);
                json.put("goalTotal", this.goalTotal);
                return json;
            } catch (JSONException e) {
                e.printStackTrace();
                return json;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AppInvitationCampaignStage(String jsonCampaignInfo) throws JSONException {
            super(jsonCampaignInfo);
            Intrinsics.checkNotNullParameter(jsonCampaignInfo, "jsonCampaignInfo");
            JSONObject jSONObject = new JSONObject(jsonCampaignInfo).getJSONObject("goal");
            this.goalCount = jSONObject.getInt("count");
            this.goalTotal = jSONObject.getInt("total");
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\bJ\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u0012\u001a\u00020\u0005H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/hive/Promotion$AppInvitationSenderInfo;", "", "resultStatus", "", "senderVid", "", "<init>", "(ILjava/lang/String;)V", "(I)V", "getResultStatus", "()I", "setResultStatus", "getSenderVid", "()Ljava/lang/String;", "setSenderVid", "(Ljava/lang/String;)V", "toJson", "Lorg/json/JSONObject;", InAppPurchaseConstants.METHOD_TO_STRING, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AppInvitationSenderInfo {
        private int resultStatus;
        private String senderVid;

        public AppInvitationSenderInfo(int i, String senderVid) {
            Intrinsics.checkNotNullParameter(senderVid, "senderVid");
            this.resultStatus = i;
            this.senderVid = senderVid;
        }

        public final int getResultStatus() {
            return this.resultStatus;
        }

        public final String getSenderVid() {
            return this.senderVid;
        }

        public final void setResultStatus(int i) {
            this.resultStatus = i;
        }

        public final void setSenderVid(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.senderVid = str;
        }

        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("resultStatus", this.resultStatus);
                jSONObject.put("senderVid", this.senderVid);
                return jSONObject;
            } catch (JSONException e) {
                e.printStackTrace();
                return jSONObject;
            }
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer("AppInvitationSenderInfo ");
            stringBuffer.append(toJson().toString()).append("\n");
            String string = stringBuffer.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }

        public AppInvitationSenderInfo(int i) {
            this.resultStatus = i;
            this.senderVid = "";
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\b\u0016\u0018\u00002\u00020\u0001BI\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eB\u0011\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u0010J\b\u0010&\u001a\u00020\tH\u0016J\b\u0010'\u001a\u00020\u0003H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0012\"\u0004\b\u0015\u0010\u0010R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\n\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR\u001a\u0010\u000b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0019\"\u0004\b#\u0010\u001bR\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0012\"\u0004\b%\u0010\u0010¨\u0006("}, d2 = {"Lcom/hive/Promotion$AppInvitationCampaign;", "", "title", "", "description", "imageUrl", "order", "", "item", "Lorg/json/JSONObject;", "count", "limit", "campaignId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILorg/json/JSONObject;IILjava/lang/String;)V", "jsonCampaignInfo", "(Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "setTitle", "getDescription", "setDescription", "getImageUrl", "setImageUrl", "getOrder", "()I", "setOrder", "(I)V", "getItem", "()Lorg/json/JSONObject;", "setItem", "(Lorg/json/JSONObject;)V", "getCount", "setCount", "getLimit", "setLimit", "getCampaignId", "setCampaignId", "toJson", InAppPurchaseConstants.METHOD_TO_STRING, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static class AppInvitationCampaign {
        private String campaignId;
        private int count;
        private String description;
        private String imageUrl;
        private JSONObject item;
        private int limit;
        private int order;
        private String title;

        public AppInvitationCampaign(String title, String description, String imageUrl, int i, JSONObject item, int i2, int i3, String campaignId) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(description, "description");
            Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(campaignId, "campaignId");
            this.title = title;
            this.description = description;
            this.imageUrl = imageUrl;
            this.order = i;
            this.item = item;
            this.count = i2;
            this.limit = i3;
            this.campaignId = campaignId;
        }

        public final String getCampaignId() {
            return this.campaignId;
        }

        public final int getCount() {
            return this.count;
        }

        public final String getDescription() {
            return this.description;
        }

        public final String getImageUrl() {
            return this.imageUrl;
        }

        public final JSONObject getItem() {
            return this.item;
        }

        public final int getLimit() {
            return this.limit;
        }

        public final int getOrder() {
            return this.order;
        }

        public final String getTitle() {
            return this.title;
        }

        public final void setCampaignId(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.campaignId = str;
        }

        public final void setCount(int i) {
            this.count = i;
        }

        public final void setDescription(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.description = str;
        }

        public final void setImageUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.imageUrl = str;
        }

        public final void setItem(JSONObject jSONObject) {
            this.item = jSONObject;
        }

        public final void setLimit(int i) {
            this.limit = i;
        }

        public final void setOrder(int i) {
            this.order = i;
        }

        public final void setTitle(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.title = str;
        }

        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("title", this.title);
                jSONObject.put("description", this.description);
                jSONObject.put("imageUrl", this.imageUrl);
                jSONObject.put("order", this.order);
                jSONObject.put("item", this.item);
                jSONObject.put("count", this.count);
                jSONObject.put("limit", this.limit);
                jSONObject.put("campaignId", this.campaignId);
                return jSONObject;
            } catch (JSONException e) {
                e.printStackTrace();
                return jSONObject;
            }
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer("Campaign ");
            stringBuffer.append(toJson().toString()).append("\n");
            String string = stringBuffer.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }

        public AppInvitationCampaign(String jsonCampaignInfo) throws JSONException {
            Intrinsics.checkNotNullParameter(jsonCampaignInfo, "jsonCampaignInfo");
            if (!StringsKt.isBlank(jsonCampaignInfo)) {
                JSONObject jSONObject = new JSONObject(jsonCampaignInfo);
                String strOptString = jSONObject.optString("title");
                Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                this.title = strOptString;
                String strOptString2 = jSONObject.optString("description");
                Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
                this.description = strOptString2;
                String strOptString3 = jSONObject.optString("img");
                Intrinsics.checkNotNullExpressionValue(strOptString3, "optString(...)");
                this.imageUrl = strOptString3;
                this.order = jSONObject.optInt("order");
                this.item = jSONObject.optJSONObject("item");
                this.count = jSONObject.optInt("count");
                this.limit = jSONObject.optInt("limit");
                String strOptString4 = jSONObject.optString(FirebaseAnalytics.Param.CAMPAIGN_ID);
                Intrinsics.checkNotNullExpressionValue(strOptString4, "optString(...)");
                this.campaignId = strOptString4;
                return;
            }
            throw new JSONException("jsonCampaignInfo is blank");
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001BM\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\n¢\u0006\u0004\b\u000e\u0010\u000fB\u0011\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u0011J\u001d\u0010&\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\u0010'\u001a\u0004\u0018\u00010(H\u0000¢\u0006\u0002\b)J\u001d\u0010*\u001a\b\u0012\u0004\u0012\u00020\r0\n2\b\u0010'\u001a\u0004\u0018\u00010(H\u0000¢\u0006\u0002\b+J\u0006\u0010,\u001a\u00020-J\b\u0010.\u001a\u00020\u0003H\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0018\"\u0004\b\u001b\u0010\u0011R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u0011R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R \u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001f\"\u0004\b#\u0010!R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0018\"\u0004\b%\u0010\u0011¨\u0006/"}, d2 = {"Lcom/hive/Promotion$AppInvitationData;", "", "inviteCommonlink", "", "inviteHivemsgLink", "inviteFacebookLink", "inviteMessage", "qrcode", "", "eachCampaignList", "Ljava/util/ArrayList;", "Lcom/hive/Promotion$AppInvitationCampaign;", "stageCampaignList", "Lcom/hive/Promotion$AppInvitationCampaignStage;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BLjava/util/ArrayList;Ljava/util/ArrayList;)V", "jsonUaDataInfo", "(Ljava/lang/String;)V", "getQrcode", "()[B", "setQrcode", "([B)V", "inviteCommonLink", "getInviteCommonLink", "()Ljava/lang/String;", "setInviteCommonLink", "getInviteHivemsgLink", "setInviteHivemsgLink", "getInviteFacebookLink", "setInviteFacebookLink", "getEachCampaignList", "()Ljava/util/ArrayList;", "setEachCampaignList", "(Ljava/util/ArrayList;)V", "getStageCampaignList", "setStageCampaignList", "getInviteMessage", "setInviteMessage", "createCampaignList", "array", "Lorg/json/JSONArray;", "createCampaignList$hive_service_release", "createCampaignStageList", "createCampaignStageList$hive_service_release", "toJson", "Lorg/json/JSONObject;", InAppPurchaseConstants.METHOD_TO_STRING, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AppInvitationData {
        private ArrayList<AppInvitationCampaign> eachCampaignList;
        private String inviteCommonLink;
        private String inviteFacebookLink;
        private String inviteHivemsgLink;
        private String inviteMessage;
        private byte[] qrcode;
        private ArrayList<AppInvitationCampaignStage> stageCampaignList;

        public AppInvitationData(String inviteCommonlink, String inviteHivemsgLink, String inviteFacebookLink, String inviteMessage, byte[] qrcode, ArrayList<AppInvitationCampaign> eachCampaignList, ArrayList<AppInvitationCampaignStage> stageCampaignList) {
            Intrinsics.checkNotNullParameter(inviteCommonlink, "inviteCommonlink");
            Intrinsics.checkNotNullParameter(inviteHivemsgLink, "inviteHivemsgLink");
            Intrinsics.checkNotNullParameter(inviteFacebookLink, "inviteFacebookLink");
            Intrinsics.checkNotNullParameter(inviteMessage, "inviteMessage");
            Intrinsics.checkNotNullParameter(qrcode, "qrcode");
            Intrinsics.checkNotNullParameter(eachCampaignList, "eachCampaignList");
            Intrinsics.checkNotNullParameter(stageCampaignList, "stageCampaignList");
            this.qrcode = qrcode;
            this.inviteCommonLink = inviteCommonlink;
            this.inviteHivemsgLink = inviteHivemsgLink;
            this.inviteFacebookLink = inviteFacebookLink;
            this.inviteMessage = inviteMessage;
            this.eachCampaignList = eachCampaignList;
            this.stageCampaignList = stageCampaignList;
        }

        public final ArrayList<AppInvitationCampaign> createCampaignList$hive_service_release(JSONArray array) throws JSONException {
            if (array == null) {
                throw new JSONException("Invalid campaign list");
            }
            ArrayList<AppInvitationCampaign> arrayList = new ArrayList<>();
            int length = array.length();
            for (int i = 0; i < length; i++) {
                String string = array.getJSONObject(i).toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                arrayList.add(new AppInvitationCampaign(string));
            }
            return arrayList;
        }

        public final ArrayList<AppInvitationCampaignStage> createCampaignStageList$hive_service_release(JSONArray array) throws JSONException {
            if (array == null) {
                throw new JSONException("Invalid campaign stage list");
            }
            ArrayList<AppInvitationCampaignStage> arrayList = new ArrayList<>();
            int length = array.length();
            for (int i = 0; i < length; i++) {
                String string = array.getJSONObject(i).toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                arrayList.add(new AppInvitationCampaignStage(string));
            }
            return arrayList;
        }

        public final ArrayList<AppInvitationCampaign> getEachCampaignList() {
            return this.eachCampaignList;
        }

        public final String getInviteCommonLink() {
            return this.inviteCommonLink;
        }

        public final String getInviteFacebookLink() {
            return this.inviteFacebookLink;
        }

        public final String getInviteHivemsgLink() {
            return this.inviteHivemsgLink;
        }

        public final String getInviteMessage() {
            return this.inviteMessage;
        }

        public final byte[] getQrcode() {
            return this.qrcode;
        }

        public final ArrayList<AppInvitationCampaignStage> getStageCampaignList() {
            return this.stageCampaignList;
        }

        public final void setEachCampaignList(ArrayList<AppInvitationCampaign> arrayList) {
            Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
            this.eachCampaignList = arrayList;
        }

        public final void setInviteCommonLink(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.inviteCommonLink = str;
        }

        public final void setInviteFacebookLink(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.inviteFacebookLink = str;
        }

        public final void setInviteHivemsgLink(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.inviteHivemsgLink = str;
        }

        public final void setInviteMessage(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.inviteMessage = str;
        }

        public final void setQrcode(byte[] bArr) {
            this.qrcode = bArr;
        }

        public final void setStageCampaignList(ArrayList<AppInvitationCampaignStage> arrayList) {
            Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
            this.stageCampaignList = arrayList;
        }

        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("inviteMessage", this.inviteMessage);
                jSONObject.put("inviteCommonLink", this.inviteCommonLink);
                jSONObject.put("inviteHivemsgLink", this.inviteHivemsgLink);
                jSONObject.put("inviteFacebookLink", this.inviteFacebookLink);
                byte[] bArr = this.qrcode;
                jSONObject.put("qrcode", bArr != null ? StringUtil.INSTANCE.toHexString(bArr) : null);
                JSONArray jSONArray = new JSONArray();
                if (this.eachCampaignList.size() > 0) {
                    Iterator<AppInvitationCampaign> it = this.eachCampaignList.iterator();
                    Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                    while (it.hasNext()) {
                        AppInvitationCampaign next = it.next();
                        Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                        jSONArray.put(next);
                    }
                }
                jSONObject.put("eachCampaignList", jSONArray);
                JSONArray jSONArray2 = new JSONArray();
                if (this.stageCampaignList.size() > 0) {
                    Iterator<AppInvitationCampaignStage> it2 = this.stageCampaignList.iterator();
                    Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
                    while (it2.hasNext()) {
                        AppInvitationCampaignStage next2 = it2.next();
                        Intrinsics.checkNotNullExpressionValue(next2, "next(...)");
                        jSONArray2.put(next2);
                    }
                }
                jSONObject.put("stageCampaignList", jSONArray2);
                return jSONObject;
            } catch (JSONException e) {
                e.printStackTrace();
                return jSONObject;
            } catch (Exception e2) {
                e2.printStackTrace();
                return jSONObject;
            }
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer("AppInvitationData ");
            stringBuffer.append(toJson().toString()).append("\n");
            String string = stringBuffer.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }

        public AppInvitationData(String jsonUaDataInfo) throws JSONException {
            Intrinsics.checkNotNullParameter(jsonUaDataInfo, "jsonUaDataInfo");
            if (!StringsKt.isBlank(jsonUaDataInfo)) {
                JSONObject jSONObject = new JSONObject(jsonUaDataInfo);
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("invite_link");
                if (jSONObjectOptJSONObject != null) {
                    String strOptString = jSONObject.optString("invite_message");
                    Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                    this.inviteMessage = strOptString;
                    StringUtil stringUtil = StringUtil.INSTANCE;
                    String strOptString2 = jSONObjectOptJSONObject.optString("qrcode");
                    Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
                    this.qrcode = stringUtil.toHexByteArray(strOptString2);
                    String strOptString3 = jSONObjectOptJSONObject.optString("common");
                    Intrinsics.checkNotNullExpressionValue(strOptString3, "optString(...)");
                    this.inviteCommonLink = strOptString3;
                    String strOptString4 = jSONObjectOptJSONObject.optString("hivemsg");
                    Intrinsics.checkNotNullExpressionValue(strOptString4, "optString(...)");
                    this.inviteHivemsgLink = strOptString4;
                    String strOptString5 = jSONObjectOptJSONObject.optString("facebook");
                    Intrinsics.checkNotNullExpressionValue(strOptString5, "optString(...)");
                    this.inviteFacebookLink = strOptString5;
                    JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("campaigns");
                    if (jSONObjectOptJSONObject2 != null) {
                        this.eachCampaignList = createCampaignList$hive_service_release(jSONObjectOptJSONObject2.optJSONArray("each"));
                        this.stageCampaignList = createCampaignStageList$hive_service_release(jSONObjectOptJSONObject2.optJSONArray("stage"));
                        return;
                    }
                    throw new JSONException("Invalid campaigns");
                }
                throw new JSONException("Invalid invite_link");
            }
            throw new JSONException("jsonCampaignInfo is null");
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0018\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0016\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001a\u0010\u0019\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012R\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R\u001a\u0010%\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0010\"\u0004\b'\u0010\u0012R\u001a\u0010(\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0010\"\u0004\b*\u0010\u0012R\u001a\u0010+\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0010\"\u0004\b-\u0010\u0012R\u001a\u0010.\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0010\"\u0004\b0\u0010\u0012R\u001c\u00101\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u0010\u0006¨\u00065"}, d2 = {"Lcom/hive/Promotion$PromotionBanner;", "Lcom/hive/base/DataModel;", "<init>", "()V", "bannerJsonObj", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", AnalyticsProviderAdjust.EventKeys.pid, "", "getPid", "()I", "setPid", "(I)V", "imageUrl", "", "getImageUrl", "()Ljava/lang/String;", "setImageUrl", "(Ljava/lang/String;)V", "linkUrl", "getLinkUrl", "setLinkUrl", "displayStartDate", "getDisplayStartDate", "setDisplayStartDate", "displayEndDate", "getDisplayEndDate", "setDisplayEndDate", "utcStartDate", "", "getUtcStartDate", "()J", "setUtcStartDate", "(J)V", "utcEndDate", "getUtcEndDate", "setUtcEndDate", "typeLink", "getTypeLink", "setTypeLink", "typeBanner", "getTypeBanner", "setTypeBanner", "typeCampaign", "getTypeCampaign", "setTypeCampaign", "interworkData", "getInterworkData", "setInterworkData", "originBannerJsonObj", "getOriginBannerJsonObj", "()Lorg/json/JSONObject;", "setOriginBannerJsonObj", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PromotionBanner extends DataModel {
        private String displayEndDate;
        private String displayStartDate;
        private String imageUrl;
        private String interworkData;
        private String linkUrl;
        private JSONObject originBannerJsonObj;
        private int pid;
        private String typeBanner;
        private String typeCampaign;
        private String typeLink;
        private long utcEndDate;
        private long utcStartDate;

        public PromotionBanner() {
            this.imageUrl = "";
            this.linkUrl = "";
            this.displayStartDate = "";
            this.displayEndDate = "";
            this.typeLink = "";
            this.typeBanner = "";
            this.typeCampaign = "";
            this.interworkData = "";
        }

        public final String getDisplayEndDate() {
            return this.displayEndDate;
        }

        public final String getDisplayStartDate() {
            return this.displayStartDate;
        }

        public final String getImageUrl() {
            return this.imageUrl;
        }

        public final String getInterworkData() {
            return this.interworkData;
        }

        public final String getLinkUrl() {
            return this.linkUrl;
        }

        public final JSONObject getOriginBannerJsonObj() {
            return this.originBannerJsonObj;
        }

        public final int getPid() {
            return this.pid;
        }

        public final String getTypeBanner() {
            return this.typeBanner;
        }

        public final String getTypeCampaign() {
            return this.typeCampaign;
        }

        public final String getTypeLink() {
            return this.typeLink;
        }

        public final long getUtcEndDate() {
            return this.utcEndDate;
        }

        public final long getUtcStartDate() {
            return this.utcStartDate;
        }

        public final void setDisplayEndDate(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.displayEndDate = str;
        }

        public final void setDisplayStartDate(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.displayStartDate = str;
        }

        public final void setImageUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.imageUrl = str;
        }

        public final void setInterworkData(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.interworkData = str;
        }

        public final void setLinkUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.linkUrl = str;
        }

        public final void setOriginBannerJsonObj(JSONObject jSONObject) {
            this.originBannerJsonObj = jSONObject;
        }

        public final void setPid(int i) {
            this.pid = i;
        }

        public final void setTypeBanner(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.typeBanner = str;
        }

        public final void setTypeCampaign(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.typeCampaign = str;
        }

        public final void setTypeLink(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.typeLink = str;
        }

        public final void setUtcEndDate(long j) {
            this.utcEndDate = j;
        }

        public final void setUtcStartDate(long j) {
            this.utcStartDate = j;
        }

        public PromotionBanner(JSONObject bannerJsonObj) {
            Intrinsics.checkNotNullParameter(bannerJsonObj, "bannerJsonObj");
            this.imageUrl = "";
            this.linkUrl = "";
            this.displayStartDate = "";
            this.displayEndDate = "";
            this.typeLink = "";
            this.typeBanner = "";
            this.typeCampaign = "";
            this.interworkData = "";
            this.pid = bannerJsonObj.optInt(AnalyticsProviderAdjust.EventKeys.pid, 0);
            String strOptString = bannerJsonObj.optString("image");
            Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
            this.imageUrl = strOptString;
            String strOptString2 = bannerJsonObj.optString("link");
            Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
            this.linkUrl = strOptString2;
            String strOptString3 = bannerJsonObj.optString("start_date");
            Intrinsics.checkNotNullExpressionValue(strOptString3, "optString(...)");
            this.displayStartDate = strOptString3;
            String strOptString4 = bannerJsonObj.optString("end_date");
            Intrinsics.checkNotNullExpressionValue(strOptString4, "optString(...)");
            this.displayEndDate = strOptString4;
            Long lValueOf = Long.valueOf(bannerJsonObj.optLong("start_unixtimestamp"));
            lValueOf = lValueOf.longValue() == 0 ? null : lValueOf;
            this.utcStartDate = lValueOf != null ? lValueOf.longValue() : bannerJsonObj.optLong("start_unixtimstamp");
            Long lValueOf2 = Long.valueOf(bannerJsonObj.optLong("end_unixtimestamp"));
            Long l = lValueOf2.longValue() != 0 ? lValueOf2 : null;
            this.utcEndDate = l != null ? l.longValue() : bannerJsonObj.optLong("end_unixtimstamp");
            String strOptString5 = bannerJsonObj.optString("type_link");
            Intrinsics.checkNotNullExpressionValue(strOptString5, "optString(...)");
            this.typeLink = strOptString5;
            String strOptString6 = bannerJsonObj.optString("type_banner");
            Intrinsics.checkNotNullExpressionValue(strOptString6, "optString(...)");
            this.typeBanner = strOptString6;
            String strOptString7 = bannerJsonObj.optString("type_camp");
            Intrinsics.checkNotNullExpressionValue(strOptString7, "optString(...)");
            this.typeCampaign = strOptString7;
            String strOptString8 = bannerJsonObj.optString("interwork_data");
            Intrinsics.checkNotNullExpressionValue(strOptString8, "optString(...)");
            this.interworkData = strOptString8;
            this.originBannerJsonObj = bannerJsonObj;
        }
    }
}
