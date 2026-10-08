package com.hive.module.interfaces;

import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.Promotion;
import com.hive.ResultAPI;
import com.hive.module.HiveModule;
import com.hive.module.HiveModuleName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0003H&J,\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H&J*\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00032\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00182\u0006\u0010\u0014\u001a\u00020\u0015H&J\b\u0010\u001a\u001a\u00020\u000fH&J\u0012\u0010\u001b\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H&J\u0012\u0010\u001c\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H&J\"\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010!H&J\u0012\u0010\"\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010#H&J\"\u0010$\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\b\u0010\u0014\u001a\u0004\u0018\u00010)H&J\"\u0010*\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010)H&J\u0012\u0010+\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010,H&J\u001e\u0010+\u001a\u00020\u000f2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010,H&J\u0012\u0010.\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010/H&J\u0010\u00100\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u0003H&J\u0010\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\fH&J\u0010\u00104\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u000205H&J\b\u00106\u001a\u00020\u000fH&J\b\u00107\u001a\u00020\u000fH&J\u0010\u00108\u001a\u00020\u000f2\u0006\u00109\u001a\u000202H&J\u001a\u0010:\u001a\u00020\u000f2\u0006\u0010;\u001a\u00020\u00032\b\b\u0002\u0010<\u001a\u00020\fH&J$\u0010=\u001a\u00020\u000f2\u0006\u0010>\u001a\u00020?2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020\u000f0@H&J(\u0010A\u001a\u00020\u000f2\u0006\u0010B\u001a\u00020\u00032\u0006\u0010C\u001a\u00020\u00032\u0006\u0010D\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020EH&J.\u0010F\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010G\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H&J\u0012\u0010H\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H&J\b\u0010I\u001a\u00020\fH&J\b\u0010J\u001a\u00020\fH&J\b\u0010K\u001a\u00020\u000fH&R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006L"}, d2 = {"Lcom/hive/module/interfaces/HivePromotion;", "Lcom/hive/module/HiveModule;", "getHiveModuleName", "", "offerwallState", "Lcom/hive/Promotion$OfferwallState;", "getOfferwallState", "()Lcom/hive/Promotion$OfferwallState;", "additionalInfo", "getAdditionalInfo", "()Ljava/lang/String;", "processUri", "", ShareConstants.MEDIA_URI, "showPromotion", "", "promotionViewType", "Lcom/hive/Promotion$PromotionViewType;", "isForced", "menu", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/Promotion$PromotionViewListener;", "showNews", "giftPidList", "Ljava/util/ArrayList;", "", "showNativeReview", "showReview", "showExit", "getViewInfo", "promotionCustomType", "Lcom/hive/Promotion$PromotionCustomType;", "contentKey", "Lcom/hive/Promotion$PromotionViewInfoListener;", "getBadgeInfo", "Lcom/hive/Promotion$PromotionBadgeInfoListener;", "getBannerInfo", "campaignType", "Lcom/hive/Promotion$PromotionCampaignType;", "bannerType", "Lcom/hive/Promotion$PromotionBannerType;", "Lcom/hive/Promotion$PromotionBannerInfoListener;", "getBannerInfoString", "getAppInvitationData", "Lcom/hive/Promotion$AppInvitationDataListener;", "inviteUserInfo", "getAppInvitationSenderInfo", "Lcom/hive/Promotion$AppInvitationSenderInfoListener;", "setAdditionalInfo", "setEngagementReady", "Lcom/hive/ResultAPI;", "bEnabled", "setEngagementListener", "Lcom/hive/Promotion$EngagementListener;", "updatePromotionData", "setAcquisitionAchieved", "needDialogClosed", "resultAPI", "requestDownloadInfo", "authType", "isAgreementDetermineBaseAccount", "requestCompanion", "parameterJson", "Lorg/json/JSONObject;", "Lkotlin/Function1;", "showUAShare", "inviteMessage", "inviteLink", "isIdentifier", "Lcom/hive/Promotion$PromotionShareListener;", "showCustomContents", "isHiveUiActivity", "showOfferwall", "newsV2IsShow", "newsV2ShowOfferwall", "newsV2Finish", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface HivePromotion extends HiveModule {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void getAppInvitationData$default(HivePromotion hivePromotion, String str, Promotion.AppInvitationDataListener appInvitationDataListener, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAppInvitationData");
            }
            if ((i & 1) != 0) {
                str = null;
            }
            hivePromotion.getAppInvitationData(str, appInvitationDataListener);
        }

        public static String getHiveModuleName(HivePromotion hivePromotion) {
            return HiveModuleName.INSTANCE.getPromotion();
        }

        public static /* synthetic */ void requestDownloadInfo$default(HivePromotion hivePromotion, String str, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: requestDownloadInfo");
            }
            if ((i & 2) != 0) {
                z = false;
            }
            hivePromotion.requestDownloadInfo(str, z);
        }

        public static /* synthetic */ void showCustomContents$default(HivePromotion hivePromotion, Promotion.PromotionCustomType promotionCustomType, String str, boolean z, Promotion.PromotionViewListener promotionViewListener, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showCustomContents");
            }
            if ((i & 4) != 0) {
                z = false;
            }
            hivePromotion.showCustomContents(promotionCustomType, str, z, promotionViewListener);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void showNews$default(HivePromotion hivePromotion, String str, ArrayList arrayList, Promotion.PromotionViewListener promotionViewListener, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showNews");
            }
            if ((i & 2) != 0) {
                arrayList = null;
            }
            hivePromotion.showNews(str, arrayList, promotionViewListener);
        }
    }

    String getAdditionalInfo();

    void getAppInvitationData(Promotion.AppInvitationDataListener listener);

    void getAppInvitationData(String inviteUserInfo, Promotion.AppInvitationDataListener listener);

    void getAppInvitationSenderInfo(Promotion.AppInvitationSenderInfoListener listener);

    void getBadgeInfo(Promotion.PromotionBadgeInfoListener listener);

    void getBannerInfo(Promotion.PromotionCampaignType campaignType, Promotion.PromotionBannerType bannerType, Promotion.PromotionBannerInfoListener listener);

    void getBannerInfoString(String campaignType, String bannerType, Promotion.PromotionBannerInfoListener listener);

    @Override // com.hive.module.HiveModule
    String getHiveModuleName();

    Promotion.OfferwallState getOfferwallState();

    void getViewInfo(Promotion.PromotionCustomType promotionCustomType, String contentKey, Promotion.PromotionViewInfoListener listener);

    void needDialogClosed(ResultAPI resultAPI);

    void newsV2Finish();

    boolean newsV2IsShow();

    boolean newsV2ShowOfferwall();

    boolean processUri(String uri);

    void requestCompanion(JSONObject parameterJson, Function1<? super ResultAPI, Unit> listener);

    void requestDownloadInfo(String authType, boolean isAgreementDetermineBaseAccount);

    void setAcquisitionAchieved();

    void setAdditionalInfo(String additionalInfo);

    void setEngagementListener(Promotion.EngagementListener listener);

    ResultAPI setEngagementReady(boolean bEnabled);

    void showCustomContents(Promotion.PromotionCustomType promotionCustomType, String contentKey, boolean isHiveUiActivity, Promotion.PromotionViewListener listener);

    void showExit(Promotion.PromotionViewListener listener);

    void showNativeReview();

    void showNews(String menu, ArrayList<Integer> giftPidList, Promotion.PromotionViewListener listener);

    void showOfferwall(Promotion.PromotionViewListener listener);

    void showPromotion(Promotion.PromotionViewType promotionViewType, boolean isForced, String menu, Promotion.PromotionViewListener listener);

    void showReview(Promotion.PromotionViewListener listener);

    void showUAShare(String inviteMessage, String inviteLink, boolean isIdentifier, Promotion.PromotionShareListener listener);

    void updatePromotionData();
}
