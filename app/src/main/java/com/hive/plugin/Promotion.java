package com.hive.plugin;

import com.facebook.appevents.AppEventsConstants;
import com.hive.HiveActivity;
import com.hive.Promotion;
import com.hive.ResultAPI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class Promotion {
    private ICallEngine callEngine;

    public Promotion(ICallEngine iCallEngine) {
        this.callEngine = iCallEngine;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void promotionViewCallback(String str, JSONObject jSONObject, ResultAPI resultAPI, Promotion.PromotionViewResultType promotionViewResultType) {
        JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
        try {
            switch (AnonymousClass17.$SwitchMap$com$hive$Promotion$PromotionViewResultType[promotionViewResultType.ordinal()]) {
                case 1:
                    jSONObjectCreateResponse.put("promotionEventType", "OPEN");
                    break;
                case 2:
                    jSONObjectCreateResponse.put("promotionEventType", "CLOSE");
                    break;
                case 3:
                    jSONObjectCreateResponse.put("promotionEventType", "START_PLAYBACK");
                    break;
                case 4:
                    jSONObjectCreateResponse.put("promotionEventType", "FINISH_PLAYBACK");
                    break;
                case 5:
                    jSONObjectCreateResponse.put("promotionEventType", "EXIT");
                    break;
                case 6:
                    jSONObjectCreateResponse.put("promotionEventType", "GOBACK");
                    break;
            }
        } catch (Exception unused) {
        }
        this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
    }

    /* JADX INFO: renamed from: com.hive.plugin.Promotion$17, reason: invalid class name */
    static /* synthetic */ class AnonymousClass17 {
        static final /* synthetic */ int[] $SwitchMap$com$hive$Promotion$PromotionViewResultType;

        static {
            int[] iArr = new int[Promotion.PromotionViewResultType.values().length];
            $SwitchMap$com$hive$Promotion$PromotionViewResultType = iArr;
            try {
                iArr[Promotion.PromotionViewResultType.OPENED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$hive$Promotion$PromotionViewResultType[Promotion.PromotionViewResultType.CLOSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$hive$Promotion$PromotionViewResultType[Promotion.PromotionViewResultType.START_PLAYBACK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$hive$Promotion$PromotionViewResultType[Promotion.PromotionViewResultType.FINISH_PLAYBACK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$hive$Promotion$PromotionViewResultType[Promotion.PromotionViewResultType.NEED_TO_EXIT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$hive$Promotion$PromotionViewResultType[Promotion.PromotionViewResultType.GOBACK.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public String showPromotion(final String str, final JSONObject jSONObject) {
        Promotion.PromotionViewType promotionViewTypeValueOf = Promotion.PromotionViewType.valueOf(jSONObject.optString("promotionType").toUpperCase(Locale.US));
        boolean zOptBoolean = jSONObject.optBoolean("isForced");
        Boolean boolValueOf = Boolean.valueOf(zOptBoolean);
        com.hive.Promotion promotion = com.hive.Promotion.INSTANCE;
        boolValueOf.getClass();
        com.hive.Promotion.showPromotion(promotionViewTypeValueOf, zOptBoolean, new Promotion.PromotionViewListener() { // from class: com.hive.plugin.Promotion.1
            @Override // com.hive.Promotion.PromotionViewListener
            public void onPromotionView(ResultAPI resultAPI, Promotion.PromotionViewResultType promotionViewResultType) {
                Promotion.this.promotionViewCallback(str, jSONObject, resultAPI, promotionViewResultType);
            }
        });
        return "";
    }

    public String showNews(final String str, final JSONObject jSONObject) {
        ArrayList arrayList;
        String strOptString = jSONObject.optString("menu");
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("giftPidList");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                arrayList.add(Integer.valueOf(jSONArrayOptJSONArray.optInt(i)));
            }
        }
        com.hive.Promotion promotion = com.hive.Promotion.INSTANCE;
        com.hive.Promotion.showNews(strOptString, arrayList, new Promotion.PromotionViewListener() { // from class: com.hive.plugin.Promotion.2
            @Override // com.hive.Promotion.PromotionViewListener
            public void onPromotionView(ResultAPI resultAPI, Promotion.PromotionViewResultType promotionViewResultType) {
                Promotion.this.promotionViewCallback(str, jSONObject, resultAPI, promotionViewResultType);
            }
        });
        return "";
    }

    public String showCustomContents(final String str, final JSONObject jSONObject) {
        Promotion.PromotionCustomType promotionCustomTypeValueOf = Promotion.PromotionCustomType.valueOf(jSONObject.optString("customType").toUpperCase(Locale.US));
        String strOptString = jSONObject.optString("contentsKey");
        com.hive.Promotion promotion = com.hive.Promotion.INSTANCE;
        com.hive.Promotion.showCustomContents(promotionCustomTypeValueOf, strOptString, new Promotion.PromotionViewListener() { // from class: com.hive.plugin.Promotion.3
            @Override // com.hive.Promotion.PromotionViewListener
            public void onPromotionView(ResultAPI resultAPI, Promotion.PromotionViewResultType promotionViewResultType) {
                Promotion.this.promotionViewCallback(str, jSONObject, resultAPI, promotionViewResultType);
            }
        });
        return "";
    }

    public String showCustomContentsOnGameWindow(final String str, final JSONObject jSONObject) {
        Promotion.PromotionCustomType promotionCustomTypeValueOf = Promotion.PromotionCustomType.valueOf(jSONObject.optString("customType").toUpperCase(Locale.US));
        String strOptString = jSONObject.optString("contentsKey");
        com.hive.Promotion promotion = com.hive.Promotion.INSTANCE;
        com.hive.Promotion.showCustomContentsOnGameWindow(promotionCustomTypeValueOf, strOptString, new Promotion.PromotionViewListener() { // from class: com.hive.plugin.Promotion.4
            @Override // com.hive.Promotion.PromotionViewListener
            public void onPromotionView(ResultAPI resultAPI, Promotion.PromotionViewResultType promotionViewResultType) {
                Promotion.this.promotionViewCallback(str, jSONObject, resultAPI, promotionViewResultType);
            }
        });
        return "";
    }

    public String getOfferwallState(String str, JSONObject jSONObject) {
        JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(null, jSONObject);
        try {
            com.hive.Promotion promotion = com.hive.Promotion.INSTANCE;
            jSONObjectCreateResponse.put("offerwallState", com.hive.Promotion.getOfferwallState().name());
        } catch (Exception unused) {
        }
        return jSONObjectCreateResponse.toString();
    }

    public String showOfferwall(final String str, final JSONObject jSONObject) {
        com.hive.Promotion promotion = com.hive.Promotion.INSTANCE;
        com.hive.Promotion.showOfferwall(new Promotion.PromotionViewListener() { // from class: com.hive.plugin.Promotion.5
            @Override // com.hive.Promotion.PromotionViewListener
            public void onPromotionView(ResultAPI resultAPI, Promotion.PromotionViewResultType promotionViewResultType) {
                Promotion.this.promotionViewCallback(str, jSONObject, resultAPI, promotionViewResultType);
            }
        });
        return "";
    }

    public String showNativeReview(String str, JSONObject jSONObject) {
        com.hive.Promotion promotion = com.hive.Promotion.INSTANCE;
        com.hive.Promotion.showNativeReview();
        return "";
    }

    public String showReview(final String str, final JSONObject jSONObject) {
        com.hive.Promotion promotion = com.hive.Promotion.INSTANCE;
        com.hive.Promotion.showReview(new Promotion.PromotionViewListener() { // from class: com.hive.plugin.Promotion.6
            @Override // com.hive.Promotion.PromotionViewListener
            public void onPromotionView(ResultAPI resultAPI, Promotion.PromotionViewResultType promotionViewResultType) {
                Promotion.this.promotionViewCallback(str, jSONObject, resultAPI, promotionViewResultType);
            }
        });
        return "";
    }

    public String showExit(final String str, final JSONObject jSONObject) {
        com.hive.Promotion promotion = com.hive.Promotion.INSTANCE;
        com.hive.Promotion.showExit(new Promotion.PromotionViewListener() { // from class: com.hive.plugin.Promotion.7
            @Override // com.hive.Promotion.PromotionViewListener
            public void onPromotionView(ResultAPI resultAPI, Promotion.PromotionViewResultType promotionViewResultType) {
                Promotion.this.promotionViewCallback(str, jSONObject, resultAPI, promotionViewResultType);
            }
        });
        return "";
    }

    public String getViewInfo(final String str, final JSONObject jSONObject) {
        Promotion.PromotionCustomType promotionCustomTypeValueOf = Promotion.PromotionCustomType.valueOf(jSONObject.optString("customType").toUpperCase(Locale.US));
        String strOptString = jSONObject.optString("contentsKey");
        com.hive.Promotion promotion = com.hive.Promotion.INSTANCE;
        com.hive.Promotion.getViewInfo(promotionCustomTypeValueOf, strOptString, new Promotion.PromotionViewInfoListener() { // from class: com.hive.plugin.Promotion.8
            @Override // com.hive.Promotion.PromotionViewInfoListener
            public void onReceiveInfo(ResultAPI resultAPI, ArrayList<Promotion.PromotionViewInfo> arrayList) {
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                try {
                    JSONArray jSONArray = new JSONArray();
                    if (arrayList != null) {
                        Iterator<Promotion.PromotionViewInfo> it = arrayList.iterator();
                        while (it.hasNext()) {
                            jSONArray.put(it.next().toJSON());
                        }
                    }
                    jSONObjectCreateResponse.put("viewInfoList", jSONArray);
                } catch (Exception unused) {
                }
                Promotion.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
            }
        });
        return "";
    }

    public String getBadgeInfo(final String str, final JSONObject jSONObject) {
        com.hive.Promotion promotion = com.hive.Promotion.INSTANCE;
        com.hive.Promotion.getBadgeInfo(new Promotion.PromotionBadgeInfoListener() { // from class: com.hive.plugin.Promotion.9
            @Override // com.hive.Promotion.PromotionBadgeInfoListener
            public void onReceiveInfo(ResultAPI resultAPI, ArrayList<Promotion.PromotionBadge> arrayList) {
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                try {
                    JSONArray jSONArray = new JSONArray();
                    if (arrayList != null) {
                        Iterator<Promotion.PromotionBadge> it = arrayList.iterator();
                        while (it.hasNext()) {
                            jSONArray.put(it.next().toJSON());
                        }
                    }
                    jSONObjectCreateResponse.put("badgeInfoList", jSONArray);
                } catch (Exception unused) {
                }
                Promotion.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
            }
        });
        return "";
    }

    public String getBannerInfo(final String str, final JSONObject jSONObject) {
        String strOptString = jSONObject.optString("campaignType");
        String strOptString2 = jSONObject.optString("bannerType");
        Promotion.PromotionCampaignType promotionCampaignType = Promotion.PromotionCampaignType.INSTANCE.get(strOptString);
        if (promotionCampaignType == null) {
            promotionCampaignType = Promotion.PromotionCampaignType.EVENT;
        }
        Promotion.PromotionBannerType promotionBannerType = Promotion.PromotionBannerType.INSTANCE.get(strOptString2);
        if (promotionBannerType == null) {
            promotionBannerType = Promotion.PromotionBannerType.ROLLING;
        }
        com.hive.Promotion promotion = com.hive.Promotion.INSTANCE;
        com.hive.Promotion.getBannerInfo(promotionCampaignType, promotionBannerType, new Promotion.PromotionBannerInfoListener() { // from class: com.hive.plugin.Promotion.10
            @Override // com.hive.Promotion.PromotionBannerInfoListener
            public void onReceiveInfo(ResultAPI resultAPI, ArrayList<Promotion.PromotionBanner> arrayList) {
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                try {
                    JSONArray jSONArray = new JSONArray();
                    if (arrayList != null) {
                        Iterator<Promotion.PromotionBanner> it = arrayList.iterator();
                        while (it.hasNext()) {
                            jSONArray.put(it.next().toJSON());
                        }
                    }
                    jSONObjectCreateResponse.put("bannerInfoList", jSONArray);
                } catch (Exception unused) {
                }
                Promotion.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
            }
        });
        return "";
    }

    public String getBannerInfoString(final String str, final JSONObject jSONObject) {
        String strOptString = jSONObject.optString("campaignType");
        String strOptString2 = jSONObject.optString("bannerType");
        com.hive.Promotion promotion = com.hive.Promotion.INSTANCE;
        com.hive.Promotion.getBannerInfoString(strOptString, strOptString2, new Promotion.PromotionBannerInfoListener() { // from class: com.hive.plugin.Promotion.11
            @Override // com.hive.Promotion.PromotionBannerInfoListener
            public void onReceiveInfo(ResultAPI resultAPI, ArrayList<Promotion.PromotionBanner> arrayList) {
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                try {
                    JSONArray jSONArray = new JSONArray();
                    if (arrayList != null) {
                        Iterator<Promotion.PromotionBanner> it = arrayList.iterator();
                        while (it.hasNext()) {
                            jSONArray.put(it.next().toJSON());
                        }
                    }
                    jSONObjectCreateResponse.put("bannerInfoList", jSONArray);
                } catch (Exception unused) {
                }
                Promotion.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
            }
        });
        return "";
    }

    public String getAppInvitationData(final String str, final JSONObject jSONObject) {
        com.hive.Promotion promotion = com.hive.Promotion.INSTANCE;
        com.hive.Promotion.getAppInvitationData(new Promotion.AppInvitationDataListener() { // from class: com.hive.plugin.Promotion.12
            @Override // com.hive.Promotion.AppInvitationDataListener
            public void onAppInvitationData(ResultAPI resultAPI, Promotion.AppInvitationData appInvitationData) {
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    if (appInvitationData != null) {
                        jSONObject2.put("inviteCommonLink", appInvitationData.getInviteCommonLink());
                        jSONObject2.put("inviteHivemsgLink", appInvitationData.getInviteHivemsgLink());
                        jSONObject2.put("inviteFacebookLink", appInvitationData.getInviteFacebookLink());
                        jSONObject2.put("qrcode", Promotion.this.byteArrayToHex(appInvitationData.getQrcode()));
                        jSONObject2.put("inviteMessage", appInvitationData.getInviteMessage());
                        JSONArray jSONArray = new JSONArray();
                        if (appInvitationData.getEachCampaignList() != null) {
                            Iterator<Promotion.AppInvitationCampaign> it = appInvitationData.getEachCampaignList().iterator();
                            while (it.hasNext()) {
                                jSONArray.put(it.next().toJson());
                            }
                        }
                        jSONObject2.put("eachCampaignList", jSONArray);
                        JSONArray jSONArray2 = new JSONArray();
                        if (appInvitationData.getStageCampaignList() != null) {
                            Iterator<Promotion.AppInvitationCampaignStage> it2 = appInvitationData.getStageCampaignList().iterator();
                            while (it2.hasNext()) {
                                jSONArray2.put(it2.next().toJson());
                            }
                        }
                        jSONObject2.put("stageCampaignList", jSONArray2);
                    }
                    jSONObjectCreateResponse.put("appInvitationData", jSONObject2);
                } catch (Exception unused) {
                }
                Promotion.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
            }
        });
        return "";
    }

    public String showUAShare(final String str, final JSONObject jSONObject) {
        String strOptString = jSONObject.optString("inviteMessage");
        String strOptString2 = jSONObject.optString("inviteLink");
        com.hive.Promotion promotion = com.hive.Promotion.INSTANCE;
        com.hive.Promotion.showUAShare(strOptString, strOptString2, new Promotion.PromotionShareListener() { // from class: com.hive.plugin.Promotion.13
            @Override // com.hive.Promotion.PromotionShareListener
            public void onPromotionShare(ResultAPI resultAPI) {
                Promotion.this.callEngine.callEngine(str, HivePlugin.createResponse(resultAPI, jSONObject).toString());
            }
        });
        return "";
    }

    public String setAdditionalInfo(String str, JSONObject jSONObject) {
        String strOptString = jSONObject.optString("setAdditionalInfo");
        com.hive.Promotion promotion = com.hive.Promotion.INSTANCE;
        com.hive.Promotion.setAdditionalInfo(strOptString);
        return "";
    }

    public String setEngagementReady(String str, JSONObject jSONObject) {
        boolean zOptBoolean = jSONObject.optBoolean("isReady");
        Boolean boolValueOf = Boolean.valueOf(zOptBoolean);
        com.hive.Promotion promotion = com.hive.Promotion.INSTANCE;
        boolValueOf.getClass();
        return HivePlugin.createResponse(com.hive.Promotion.setEngagementReady(zOptBoolean), jSONObject).toString();
    }

    public String setEngagementHandler(final String str, final JSONObject jSONObject) {
        com.hive.Promotion promotion = com.hive.Promotion.INSTANCE;
        com.hive.Promotion.setEngagementListener(new Promotion.EngagementListener() { // from class: com.hive.plugin.Promotion.14
            @Override // com.hive.Promotion.EngagementListener
            public void onEngagement(ResultAPI resultAPI, Promotion.EngagementEventType engagementEventType, Promotion.EngagementEventState engagementEventState, JSONObject jSONObject2) {
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                try {
                    jSONObjectCreateResponse.put("engagementEventType", engagementEventType.name());
                    jSONObjectCreateResponse.put("engagementEventState", engagementEventState.name());
                    jSONObjectCreateResponse.put("param", jSONObject2);
                } catch (JSONException unused) {
                }
                Promotion.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
            }
        });
        return "";
    }

    public String processURI(String str, JSONObject jSONObject) {
        String strOptString = jSONObject.optString("URI");
        com.hive.Promotion promotion = com.hive.Promotion.INSTANCE;
        Boolean boolValueOf = Boolean.valueOf(com.hive.Promotion.processURI(strOptString));
        JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(null, jSONObject);
        try {
            jSONObjectCreateResponse.put("processURI", boolValueOf);
        } catch (Exception unused) {
        }
        return jSONObjectCreateResponse.toString();
    }

    public String getAppInvitationSenderInfo(final String str, final JSONObject jSONObject) {
        com.hive.Promotion promotion = com.hive.Promotion.INSTANCE;
        com.hive.Promotion.getAppInvitationSenderInfo(new Promotion.AppInvitationSenderInfoListener() { // from class: com.hive.plugin.Promotion.15
            @Override // com.hive.Promotion.AppInvitationSenderInfoListener
            public void onAppInvitationSenderInfo(ResultAPI resultAPI, Promotion.AppInvitationSenderInfo appInvitationSenderInfo) {
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("vid", appInvitationSenderInfo.getSenderVid());
                    jSONObjectCreateResponse.put("senderInfo", jSONObject2);
                } catch (Exception unused) {
                }
                Promotion.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
            }
        });
        return "";
    }

    public String updatePromotionData(String str, JSONObject jSONObject) {
        com.hive.Promotion promotion = com.hive.Promotion.INSTANCE;
        com.hive.Promotion.updatePromotionData();
        return "";
    }

    public String executeNative(final String str, final String str2, final JSONObject jSONObject) {
        if ("getOfferwallState".equals(str)) {
            return getOfferwallState(str2, jSONObject);
        }
        if ("setEngagementReady".equals(str)) {
            return setEngagementReady(str2, jSONObject);
        }
        if ("processURI".equals(str)) {
            return processURI(str2, jSONObject);
        }
        if ("updatePromotionData".equals(str)) {
            return updatePromotionData(str2, jSONObject);
        }
        HiveActivity hiveActivity = HiveActivity.INSTANCE;
        if (!HiveActivity.isActivityInitialized()) {
            com.hive.Logger logger = com.hive.Logger.INSTANCE;
            com.hive.Logger.d("Plugin", "HiveActivity.getRecentActivity() == null");
            return "";
        }
        HiveActivity.INSTANCE.getRecentActivity().runOnUiThread(new Runnable() { // from class: com.hive.plugin.Promotion.16
            @Override // java.lang.Runnable
            public void run() {
                if ("showPromotion".equals(str)) {
                    Promotion.this.showPromotion(str2, jSONObject);
                    return;
                }
                if ("showNews".equals(str)) {
                    Promotion.this.showNews(str2, jSONObject);
                    return;
                }
                if ("showCustomContents".equals(str)) {
                    Promotion.this.showCustomContents(str2, jSONObject);
                    return;
                }
                if ("showCustomContentsOnGameWindow".equals(str)) {
                    Promotion.this.showCustomContentsOnGameWindow(str2, jSONObject);
                    return;
                }
                if ("showOfferwall".equals(str)) {
                    Promotion.this.showOfferwall(str2, jSONObject);
                    return;
                }
                if ("showNativeReview".equals(str)) {
                    Promotion.this.showNativeReview(str2, jSONObject);
                    return;
                }
                if ("showReview".equals(str)) {
                    Promotion.this.showReview(str2, jSONObject);
                    return;
                }
                if ("showExit".equals(str)) {
                    Promotion.this.showExit(str2, jSONObject);
                    return;
                }
                if ("getViewInfo".equals(str)) {
                    Promotion.this.getViewInfo(str2, jSONObject);
                    return;
                }
                if ("getBadgeInfo".equals(str)) {
                    Promotion.this.getBadgeInfo(str2, jSONObject);
                    return;
                }
                if ("getBannerInfo".equals(str)) {
                    Promotion.this.getBannerInfo(str2, jSONObject);
                    return;
                }
                if ("getBannerInfoString".equals(str)) {
                    Promotion.this.getBannerInfoString(str2, jSONObject);
                    return;
                }
                if ("getAppInvitationData".equals(str)) {
                    Promotion.this.getAppInvitationData(str2, jSONObject);
                    return;
                }
                if ("showUAShare".equals(str)) {
                    Promotion.this.showUAShare(str2, jSONObject);
                    return;
                }
                if ("setAdditionalInfo".equals(str)) {
                    Promotion.this.setAdditionalInfo(str2, jSONObject);
                } else if ("setEngagementHandler".equals(str)) {
                    Promotion.this.setEngagementHandler(str2, jSONObject);
                } else if ("getAppInvitationSenderInfo".equals(str)) {
                    Promotion.this.getAppInvitationSenderInfo(str2, jSONObject);
                }
            }
        });
        return "";
    }

    String byteArrayToHex(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            try {
                StringBuffer stringBuffer = new StringBuffer();
                for (int i = 0; i < bArr.length; i++) {
                    if ((bArr[i] & 255) < 16) {
                        stringBuffer.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                    }
                    stringBuffer.append(Long.toString(bArr[i] & 255, 16));
                }
                return stringBuffer.toString();
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
