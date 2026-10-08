package com.gomfactory.adpie.sdk.controller;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.adjust.sdk.Constants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.gomfactory.adpie.sdk.AdPieSDK;
import com.gomfactory.adpie.sdk.TargetingData;
import com.gomfactory.adpie.sdk.common.AdData;
import com.gomfactory.adpie.sdk.common.AdRequest;
import com.gomfactory.adpie.sdk.common.AdResponse;
import com.gomfactory.adpie.sdk.common.DataKeys;
import com.gomfactory.adpie.sdk.event.AdEventListener;
import com.gomfactory.adpie.sdk.nativeads.NativeAdData;
import com.gomfactory.adpie.sdk.network.NetworkServiceManager;
import com.gomfactory.adpie.sdk.pref.Preference;
import com.gomfactory.adpie.sdk.util.AdPieLog;
import com.gomfactory.adpie.sdk.videoads.EndCardData;
import com.gomfactory.adpie.sdk.videoads.VideoAdData;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.unity3d.services.ads.adunit.AdUnitActivity;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class AdController {
    public static final String TAG = "AdController";
    private static final int WAIT_INTERVAL_MILLI_TIME = 100;
    private static final int WAIT_MAXIMUM_MILLI_TIME = 2000;
    private AdEventListener mAdEventListener;
    private AdRequest mAdRequest;
    private Context mContext;
    private Handler mHandler;
    private boolean mIsLoading;
    private HashMap<String, String> mQueryMap;
    private String mSlotId;
    private TargetingData mTargetingData;
    private int waitTime;

    static /* synthetic */ int access$012(AdController adController, int i) {
        int i2 = adController.waitTime + i;
        adController.waitTime = i2;
        return i2;
    }

    public AdController(Context context, AdEventListener adEventListener) {
        this.waitTime = 0;
        if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
            AdPieLog.d(TAG, "AdController instance is created.");
        }
        this.mContext = context;
        this.mAdEventListener = adEventListener;
        this.waitTime = 0;
    }

    public void setSlotID(String str) {
        this.mSlotId = str;
    }

    public void destroy() {
        AdPieLog.d(TAG, this.mSlotId + ":::destroy");
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacks(null);
            this.mHandler = null;
        }
        this.mAdRequest = null;
        this.mAdEventListener = null;
    }

    public void loadAd(HashMap<String, String> map) {
        this.mQueryMap = map;
        loadAd();
    }

    public void loadAd() {
        if (this.mContext == null) {
            AdPieLog.e(TAG, new Exception("Context cannot be null."));
            AdEventListener adEventListener = this.mAdEventListener;
            if (adEventListener != null) {
                adEventListener.notifyAdFailedToLoad(104);
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(this.mSlotId)) {
            AdPieLog.e(TAG, new Exception("Slot ID cannot be null."));
            AdEventListener adEventListener2 = this.mAdEventListener;
            if (adEventListener2 != null) {
                adEventListener2.notifyAdFailedToLoad(101);
                return;
            }
            return;
        }
        try {
            if (!Preference.getBooleanValue(this.mContext, DataKeys.getKeyWithMedia("SSP_ENABLE", AdPieSDK.getInstance().getAppId()), true)) {
                AdPieLog.e(TAG, new Exception("This app was blocked. (" + AdPieSDK.getInstance().getAppId() + ")"));
                AdEventListener adEventListener3 = this.mAdEventListener;
                if (adEventListener3 != null) {
                    adEventListener3.notifyAdFailedToLoad(101);
                    return;
                }
                return;
            }
        } catch (Exception unused) {
        }
        if (!TextUtils.isEmpty(AdPieSDK.getInstance().getAppId())) {
            if (!AdPieSDK.getInstance().isInitialized()) {
                if (this.waitTime < 2000) {
                    Handler handler = this.mHandler;
                    if (handler != null) {
                        handler.removeCallbacks(null);
                        this.mHandler = null;
                    }
                    Handler handler2 = new Handler(Looper.getMainLooper());
                    this.mHandler = handler2;
                    handler2.postDelayed(new Runnable() { // from class: com.gomfactory.adpie.sdk.controller.AdController.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AdController.access$012(AdController.this, 100);
                            if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                                AdPieLog.d(AdController.TAG, "waiting : " + AdController.this.waitTime);
                            }
                            AdController.this.loadAd();
                        }
                    }, 100L);
                    return;
                }
                AdPieLog.d(TAG, "AdPie SDK must be initialized before ads loading.");
                AdEventListener adEventListener4 = this.mAdEventListener;
                if (adEventListener4 != null) {
                    adEventListener4.notifyAdFailedToLoad(105);
                    return;
                }
                return;
            }
            if (this.mIsLoading) {
                AdPieLog.d(TAG, "AdPie (" + this.mSlotId + ") is already loading an ad. Wait for previous load to finish.");
                AdEventListener adEventListener5 = this.mAdEventListener;
                if (adEventListener5 != null) {
                    adEventListener5.notifyAdFailedToLoad(106);
                    return;
                }
                return;
            }
            int networkConnectionType = AdPieSDK.getInstance().getNetworkConnectionType();
            if (networkConnectionType == 0) {
                AdEventListener adEventListener6 = this.mAdEventListener;
                if (adEventListener6 != null) {
                    adEventListener6.notifyAdFailedToLoad(103);
                    return;
                }
                return;
            }
            long longValue = Preference.getLongValue(this.mContext, DataKeys.getKeyWithSlot("REQUEST_TIME", this.mSlotId), 0L);
            long longValue2 = Preference.getLongValue(this.mContext, DataKeys.getKeyWithSlot("REQUEST_LIMIT_INTERVAL", this.mSlotId), 3000L);
            long time = new Date().getTime();
            if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                AdPieLog.d(TAG, "currentTime : " + time + ", preReqTime : " + longValue + ", requestLimit : " + longValue2);
            }
            if (longValue2 > 60000) {
                longValue2 = 60000;
            }
            if (time < longValue + longValue2) {
                AdEventListener adEventListener7 = this.mAdEventListener;
                if (adEventListener7 != null) {
                    adEventListener7.notifyAdFailedToLoad(110);
                    return;
                }
                return;
            }
            Preference.putString(this.mContext, DataKeys.getKeyWithSlot("MEDIA_ID_OF_SLOT", this.mSlotId), AdPieSDK.getInstance().getAppId());
            Preference.putLong(this.mContext, DataKeys.getKeyWithSlot("REQUEST_TIME", this.mSlotId), time);
            getRequest().setConnectionType(networkConnectionType);
            getRequest().setUserAgent(AdPieSDK.getInstance().getUserAgent());
            this.mIsLoading = true;
            fetchAd();
            return;
        }
        String stringValue = Preference.getStringValue(this.mContext, DataKeys.getKeyWithSlot("MEDIA_ID_OF_SLOT", this.mSlotId), null);
        if (!TextUtils.isEmpty(stringValue)) {
            AdPieSDK.getInstance().initialize(this.mContext, stringValue);
        }
        AdPieLog.d(TAG, "AdPie SDK must be initialized before ads loading.");
        AdEventListener adEventListener8 = this.mAdEventListener;
        if (adEventListener8 != null) {
            adEventListener8.notifyAdFailedToLoad(105);
        }
    }

    private void fetchAd() {
        if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
            AdPieLog.d(TAG, "fetchAd : " + getRequest().toString());
        }
        NetworkServiceManager.getInstance().post(getRequest().getRequestURL(), getRequest().toUri().getEncodedQuery(), new Handler(Looper.getMainLooper()) { // from class: com.gomfactory.adpie.sdk.controller.AdController.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 200) {
                    AdController.this.parsing(message.obj);
                } else if (AdController.this.mAdEventListener != null) {
                    AdController.this.mAdEventListener.notifyAdFailedToLoad(102);
                }
                AdController.this.mIsLoading = false;
            }
        });
    }

    private AdRequest getRequest() {
        if (this.mAdRequest == null) {
            this.mAdRequest = (AdRequest) AdPieSDK.getInstance().getCommonHeader().clone();
        }
        try {
            String stringValue = Preference.getStringValue(this.mContext, DataKeys.SSP_REQUEST_URL_KEY, "");
            if (!TextUtils.isEmpty(stringValue)) {
                this.mAdRequest.setRequestURL(stringValue, true);
            } else {
                this.mAdRequest.setRequestURL(AdPieSDK.getInstance().getConfiguration().getAdpieSspUrl(), true);
            }
        } catch (Exception unused) {
            this.mAdRequest.setRequestURL(AdPieSDK.getInstance().getConfiguration().getAdpieSspUrl(), true);
        }
        this.mAdRequest.setAppID(AdPieSDK.getInstance().getAppId());
        this.mAdRequest.setSlotID(this.mSlotId);
        this.mAdRequest.setQueryMap(this.mQueryMap);
        this.mAdRequest.setTargetingData(this.mTargetingData);
        return this.mAdRequest;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void parsing(Object obj) {
        int i;
        long j;
        int i2;
        String str;
        String str2;
        AdResponse adResponse;
        try {
            AdResponse adResponse2 = new AdResponse();
            JSONObject jSONObject = new JSONObject((String) obj);
            int iOptInt = jSONObject.optInt("result", -1);
            adResponse2.setResult(iOptInt);
            adResponse2.setMessage(jSONObject.optString("message"));
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            long j2 = 0;
            if (jSONObjectOptJSONObject != null) {
                long jOptLong = jSONObjectOptJSONObject.optLong("interval");
                long jOptLong2 = jSONObjectOptJSONObject.optLong("limit");
                if (jOptLong2 == 0) {
                    jOptLong2 = 3000;
                }
                Preference.putLong(this.mContext, DataKeys.getKeyWithSlot("REQUEST_LIMIT_INTERVAL", this.mSlotId), jOptLong2);
                if (iOptInt == 0) {
                    int iOptInt2 = jSONObjectOptJSONObject.optInt("count");
                    JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("ad");
                    if (jSONObjectOptJSONObject2 != null) {
                        int iOptInt3 = jSONObjectOptJSONObject2.optInt("ictype");
                        int iOptInt4 = jSONObjectOptJSONObject2.optInt("wv_clk_v2");
                        int iOptInt5 = jSONObjectOptJSONObject2.optInt("back_enable", 1);
                        if (iOptInt3 == 11 || iOptInt3 == 21) {
                            i2 = iOptInt2;
                            j = jOptLong;
                            AdData adData = new AdData();
                            adData.setIcType(iOptInt3);
                            adData.setOrientation(jSONObjectOptJSONObject2.optInt(AdUnitActivity.EXTRA_ORIENTATION));
                            adData.setWebviewLanding(iOptInt4);
                            adData.setBackButtonEnabled(iOptInt5);
                            adData.setAdm(jSONObjectOptJSONObject2.getString("adm"));
                            adData.setAdmImageTag(jSONObjectOptJSONObject2.optString("adm_img_tag"));
                            adData.setContentWidth(jSONObjectOptJSONObject2.optInt(ViewHierarchyConstants.DIMENSION_WIDTH_KEY));
                            adData.setContentHeight(jSONObjectOptJSONObject2.optInt(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY));
                            adData.setBgColor(jSONObjectOptJSONObject2.optString("bgcolor"));
                            adData.setPosition(jSONObjectOptJSONObject2.optInt("position"));
                            adData.setAnimationType(jSONObjectOptJSONObject2.optInt("animation"));
                            adData.setCloseButtonPosition(jSONObjectOptJSONObject2.optInt("xposition"));
                            adData.setCloseButtonDelay(jSONObjectOptJSONObject2.optLong("cbd"));
                            adData.setMonitoring(jSONObjectOptJSONObject2.optInt("act"));
                            adData.setWebviewLoadingSkip(jSONObjectOptJSONObject2.optInt("wvls"));
                            adData.setCheckView(jSONObjectOptJSONObject2.optInt("check_view"));
                            adData.setTrackingImpUrls(convertJSONArrayToArrayList(jSONObjectOptJSONObject2.optJSONArray("imptrackers")));
                            adData.setTrackingClkUrls(convertJSONArrayToArrayList(jSONObjectOptJSONObject2.optJSONArray("clicktrackers")));
                            adData.setEcpm(jSONObjectOptJSONObject2.optDouble("price"));
                            adResponse2.setAdData(adData);
                        } else {
                            i2 = iOptInt2;
                            j = jOptLong;
                            if (iOptInt3 == 31) {
                                JSONObject jSONObject2 = jSONObjectOptJSONObject2.getJSONObject("native");
                                NativeAdData nativeAdData = new NativeAdData();
                                nativeAdData.setIcType(iOptInt3);
                                nativeAdData.setWebviewLanding(iOptInt4);
                                nativeAdData.setAssetTypes(convertJSONArrayToIntArray(jSONObject2.optJSONArray("assettype")));
                                nativeAdData.setTitle(jSONObject2.optString("title"));
                                nativeAdData.setDescription(jSONObject2.optString("desc"));
                                nativeAdData.setIconImageUrl(jSONObject2.optString("img_icon"));
                                nativeAdData.setMainImageUrl(jSONObject2.optString("img_main"));
                                nativeAdData.setMainWidth(jSONObjectOptJSONObject2.optInt(ViewHierarchyConstants.DIMENSION_WIDTH_KEY));
                                nativeAdData.setMainHeight(jSONObjectOptJSONObject2.optInt(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY));
                                nativeAdData.setCallToAction(jSONObject2.optString("cta"));
                                nativeAdData.setRating(jSONObject2.optDouble("rating"));
                                nativeAdData.setLink(jSONObject2.optString("link"));
                                nativeAdData.setTrackingImpUrls(convertJSONArrayToArrayList(jSONObject2.optJSONArray("imptrackers")));
                                nativeAdData.setTrackingClkUrls(convertJSONArrayToArrayList(jSONObject2.optJSONArray("clicktrackers")));
                                nativeAdData.setOptoutImageUrl(jSONObject2.optString("optout_img"));
                                nativeAdData.setOptoutLink(jSONObject2.optString("optout_link"));
                                nativeAdData.setOnlyClickCTA(jSONObject2.optInt("ck_cta"));
                                nativeAdData.setEcpm(jSONObjectOptJSONObject2.optDouble("price"));
                                adResponse = adResponse2;
                                adResponse.setAdData(nativeAdData);
                            } else {
                                String str3 = ViewHierarchyConstants.DIMENSION_HEIGHT_KEY;
                                String str4 = ViewHierarchyConstants.DIMENSION_WIDTH_KEY;
                                if (iOptInt3 == 32) {
                                    JSONObject jSONObject3 = jSONObjectOptJSONObject2.getJSONObject("video");
                                    NativeAdData nativeAdData2 = new NativeAdData();
                                    nativeAdData2.setIcType(iOptInt3);
                                    nativeAdData2.setWebviewLanding(iOptInt4);
                                    nativeAdData2.setAssetTypes(convertJSONArrayToIntArray(jSONObject3.optJSONArray("assettype")));
                                    nativeAdData2.setTitle(jSONObject3.optString("title"));
                                    nativeAdData2.setDescription(jSONObject3.optString("description"));
                                    nativeAdData2.setIconImageUrl(jSONObject3.optString("img_icon"));
                                    nativeAdData2.setCallToAction(jSONObject3.optString("link_text"));
                                    nativeAdData2.setLink(jSONObject3.optString("link"));
                                    nativeAdData2.setOptoutImageUrl(jSONObject3.optString("optout_img"));
                                    nativeAdData2.setOptoutLink(jSONObject3.optString("optout_link"));
                                    nativeAdData2.setOnlyClickCTA(jSONObject3.optInt("ck_cta"));
                                    VideoAdData videoAdData = new VideoAdData();
                                    videoAdData.setIcType(iOptInt3);
                                    videoAdData.setTitle(jSONObject3.optString("title"));
                                    videoAdData.setDescription(jSONObject3.optString("description"));
                                    videoAdData.setDuration(jSONObject3.optInt(TypedValues.TransitionType.S_DURATION));
                                    videoAdData.setLink(jSONObject3.optString("link"));
                                    videoAdData.setLinkText(jSONObject3.optString("link_text"));
                                    videoAdData.setVideoContent(jSONObject3.getString("content"));
                                    videoAdData.setVideoContentType(jSONObject3.optString(FirebaseAnalytics.Param.CONTENT_TYPE));
                                    videoAdData.setDelivery(jSONObject3.optInt("delivery"));
                                    videoAdData.setContentWidth(jSONObject3.optInt("content_width"));
                                    videoAdData.setContentHeight(jSONObject3.optInt("content_height"));
                                    videoAdData.setAutoPlay(jSONObject3.optInt("autoplay") != 0);
                                    JSONObject jSONObjectOptJSONObject3 = jSONObject3.optJSONObject(Constants.ADJUST_PREINSTALL_CONTENT_URI_PATH);
                                    if (jSONObjectOptJSONObject3 != null) {
                                        videoAdData.setTrackingStartUrls(convertJSONArrayToArrayList(jSONObjectOptJSONObject3.optJSONArray(TtmlNode.START)));
                                        videoAdData.setTrackingFirstQuartileUrls(convertJSONArrayToArrayList(jSONObjectOptJSONObject3.optJSONArray("first_quartile")));
                                        videoAdData.setTrackingMidpointUrls(convertJSONArrayToArrayList(jSONObjectOptJSONObject3.optJSONArray("midpoint")));
                                        videoAdData.setTrackingThirdQuartileUrls(convertJSONArrayToArrayList(jSONObjectOptJSONObject3.optJSONArray("third_quartile")));
                                        videoAdData.setTrackingCompleteUrls(convertJSONArrayToArrayList(jSONObjectOptJSONObject3.optJSONArray("complete")));
                                        videoAdData.setTrackingImpUrls(convertJSONArrayToArrayList(jSONObjectOptJSONObject3.optJSONArray("impression")));
                                        nativeAdData2.setTrackingImpUrls(convertJSONArrayToArrayList(jSONObjectOptJSONObject3.optJSONArray("impression")));
                                        videoAdData.setTrackingClkUrls(convertJSONArrayToArrayList(jSONObjectOptJSONObject3.optJSONArray("click")));
                                        nativeAdData2.setTrackingClkUrls(convertJSONArrayToArrayList(jSONObjectOptJSONObject3.optJSONArray("click")));
                                    }
                                    nativeAdData2.setVideoAdData(videoAdData);
                                    nativeAdData2.setEcpm(jSONObjectOptJSONObject2.optDouble("price"));
                                    adResponse = adResponse2;
                                    adResponse.setAdData(nativeAdData2);
                                } else {
                                    if (iOptInt3 != 52 && iOptInt3 != 42 && iOptInt3 != 22) {
                                        AdPieLog.i(TAG, "This icType is not matched. -> " + iOptInt3);
                                        AdEventListener adEventListener = this.mAdEventListener;
                                        if (adEventListener != null) {
                                            adEventListener.notifyAdFailedToLoad(108);
                                            return;
                                        }
                                        return;
                                    }
                                    JSONObject jSONObject4 = jSONObjectOptJSONObject2.getJSONObject("video");
                                    VideoAdData videoAdData2 = new VideoAdData();
                                    videoAdData2.setIcType(iOptInt3);
                                    videoAdData2.setOrientation(jSONObjectOptJSONObject2.optInt(AdUnitActivity.EXTRA_ORIENTATION));
                                    videoAdData2.setWebviewLanding(iOptInt4);
                                    videoAdData2.setBackButtonEnabled(iOptInt5);
                                    videoAdData2.setTitle(jSONObject4.optString("title"));
                                    videoAdData2.setDescription(jSONObject4.optString("description"));
                                    videoAdData2.setSkipOffset(jSONObject4.optInt("skip_offset"));
                                    videoAdData2.setDuration(jSONObject4.optInt(TypedValues.TransitionType.S_DURATION));
                                    videoAdData2.setLink(jSONObject4.optString("link"));
                                    videoAdData2.setLinkText(jSONObject4.optString("link_text"));
                                    videoAdData2.setVideoContent(jSONObject4.getString("content"));
                                    videoAdData2.setVideoContentType(jSONObject4.optString(FirebaseAnalytics.Param.CONTENT_TYPE));
                                    videoAdData2.setDelivery(jSONObject4.optInt("delivery"));
                                    videoAdData2.setContentWidth(jSONObject4.optInt("content_width"));
                                    videoAdData2.setContentHeight(jSONObject4.optInt("content_height"));
                                    videoAdData2.setOptoutImageUrl(jSONObject4.optString("optout_img"));
                                    videoAdData2.setOptoutLink(jSONObject4.optString("optout_link"));
                                    if (iOptInt3 == 52) {
                                        videoAdData2.setSsvUrl(jSONObjectOptJSONObject2.optString("ssv_url"));
                                    }
                                    JSONObject jSONObjectOptJSONObject4 = jSONObject4.optJSONObject(Constants.ADJUST_PREINSTALL_CONTENT_URI_PATH);
                                    if (jSONObjectOptJSONObject4 != null) {
                                        videoAdData2.setTrackingStartUrls(convertJSONArrayToArrayList(jSONObjectOptJSONObject4.optJSONArray(TtmlNode.START)));
                                        videoAdData2.setTrackingFirstQuartileUrls(convertJSONArrayToArrayList(jSONObjectOptJSONObject4.optJSONArray("first_quartile")));
                                        videoAdData2.setTrackingMidpointUrls(convertJSONArrayToArrayList(jSONObjectOptJSONObject4.optJSONArray("midpoint")));
                                        videoAdData2.setTrackingThirdQuartileUrls(convertJSONArrayToArrayList(jSONObjectOptJSONObject4.optJSONArray("third_quartile")));
                                        videoAdData2.setTrackingCompleteUrls(convertJSONArrayToArrayList(jSONObjectOptJSONObject4.optJSONArray("complete")));
                                        videoAdData2.setTrackingImpUrls(convertJSONArrayToArrayList(jSONObjectOptJSONObject4.optJSONArray("impression")));
                                        videoAdData2.setTrackingClkUrls(convertJSONArrayToArrayList(jSONObjectOptJSONObject4.optJSONArray("click")));
                                    }
                                    JSONArray jSONArrayOptJSONArray = jSONObject4.optJSONArray("end_card");
                                    if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                                        ArrayList<EndCardData> arrayList = new ArrayList<>();
                                        int i3 = 0;
                                        while (i3 < jSONArrayOptJSONArray.length()) {
                                            JSONObject jSONObject5 = (JSONObject) jSONArrayOptJSONArray.get(i3);
                                            if (jSONObject5 != null) {
                                                EndCardData endCardData = new EndCardData();
                                                str2 = str4;
                                                endCardData.setWidth(jSONObject5.optInt(str2));
                                                str = str3;
                                                endCardData.setHeight(jSONObject5.optInt(str));
                                                String strOptString = jSONObject5.optString("static_resource");
                                                String strOptString2 = jSONObject5.optString("html_resource");
                                                String strOptString3 = jSONObject5.optString("iframe_resource");
                                                if (!TextUtils.isEmpty(strOptString)) {
                                                    endCardData.setResourceType(0);
                                                    endCardData.setResource(strOptString);
                                                    String strOptString4 = jSONObject5.optString("click_through");
                                                    if (!TextUtils.isEmpty(strOptString4)) {
                                                        endCardData.setClickThrough(strOptString4);
                                                        endCardData.setClickTracking(convertJSONArrayToArrayList(jSONObject5.optJSONArray("click_tracking")));
                                                        endCardData.setCreativeView(convertJSONArrayToArrayList(jSONObject5.optJSONArray("creative_view")));
                                                        arrayList.add(endCardData);
                                                    }
                                                } else if (!TextUtils.isEmpty(strOptString2)) {
                                                    endCardData.setResourceType(1);
                                                    endCardData.setResource(strOptString2);
                                                } else if (!TextUtils.isEmpty(strOptString3)) {
                                                    endCardData.setResourceType(2);
                                                    endCardData.setResource(strOptString3);
                                                }
                                            } else {
                                                str = str3;
                                                str2 = str4;
                                            }
                                            i3++;
                                            str4 = str2;
                                            str3 = str;
                                        }
                                        if (!arrayList.isEmpty()) {
                                            videoAdData2.setEndCardData(arrayList);
                                        }
                                    }
                                    videoAdData2.setEcpm(jSONObjectOptJSONObject2.optDouble("price"));
                                    adResponse2 = adResponse2;
                                    adResponse2.setAdData(videoAdData2);
                                }
                            }
                            adResponse2 = adResponse;
                        }
                    } else {
                        i2 = iOptInt2;
                        j = jOptLong;
                    }
                    i = i2;
                } else {
                    j = jOptLong;
                    i = 0;
                }
                j2 = j;
            } else {
                i = 0;
            }
            adResponse2.setInterval(j2);
            adResponse2.setCount(i);
            AdEventListener adEventListener2 = this.mAdEventListener;
            if (adEventListener2 != null) {
                adEventListener2.receivedResponse(adResponse2);
            }
        } catch (Exception e) {
            if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                AdPieLog.e(TAG, e);
            }
            AdEventListener adEventListener3 = this.mAdEventListener;
            if (adEventListener3 != null) {
                adEventListener3.notifyAdFailedToLoad(104);
            }
        }
    }

    private ArrayList convertJSONArrayToArrayList(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                String strOptString = jSONArray.optString(i);
                if (strOptString != null) {
                    arrayList.add(strOptString);
                }
            }
        }
        return arrayList;
    }

    private int[] convertJSONArrayToIntArray(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        int[] iArr = new int[jSONArray.length()];
        for (int i = 0; i < jSONArray.length(); i++) {
            iArr[i] = jSONArray.optInt(i);
        }
        return iArr;
    }

    public void setTargetingData(TargetingData targetingData) {
        this.mTargetingData = targetingData;
    }
}
