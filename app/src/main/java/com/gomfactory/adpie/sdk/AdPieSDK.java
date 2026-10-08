package com.gomfactory.adpie.sdk;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.autofill.HintConstants;
import com.facebook.appevents.AppEventsConstants;
import com.gomfactory.adpie.sdk.common.AdRequest;
import com.gomfactory.adpie.sdk.common.Configuration;
import com.gomfactory.adpie.sdk.common.DataKeys;
import com.gomfactory.adpie.sdk.id.GAID;
import com.gomfactory.adpie.sdk.id.OnGAIDListener;
import com.gomfactory.adpie.sdk.network.NetworkServiceManager;
import com.gomfactory.adpie.sdk.pref.Preference;
import com.gomfactory.adpie.sdk.util.AdPieLog;
import com.gomfactory.adpie.sdk.util.ClickThroughUtil;
import com.gomfactory.adpie.sdk.util.DisplayUtil;
import com.unity3d.services.ads.gmascar.utils.ScarConstants;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class AdPieSDK {
    public static final String TAG = "AdPieSDK";
    private static Configuration configuration = new Configuration();
    private static AdPieSDK ourInstance = new AdPieSDK();
    private AdRequest mAdRequest;
    private String mAppID;
    private String mCacheDir;
    private AdRequest mCommonHeader;
    private Context mContext;
    private OnInitializedListener mInitializedListener;
    private boolean mIsInitialized;
    private String mUserAgent;

    public interface OnInitializedListener {
        void onCompleted(boolean z);
    }

    private int getNetworkClass(int i) {
        switch (i) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return 1;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                return 2;
            case 13:
            case 18:
            case 19:
                return 3;
            case 20:
                return 4;
            default:
                return 0;
        }
    }

    private AdPieSDK() {
        AdPieLog.d(TAG, "AdPieSDK instance is created.");
    }

    public static AdPieSDK getInstance() {
        return ourInstance;
    }

    public boolean isInitialized() {
        return this.mIsInitialized;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public synchronized void initialize(Context context, String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            boolean zOptBoolean = jSONObject.optBoolean("adpie_server_log", false);
            String strOptString = jSONObject.optString("adpie_config_url", configuration.getAdpieConfigUrl());
            String strOptString2 = jSONObject.optString("adpie_ssp_url", configuration.getAdpieSspUrl());
            configuration.setAdpieServerLog(zOptBoolean);
            configuration.setAdpieConfigUrl(strOptString);
            configuration.setAdpieSspUrl(strOptString2);
            this.mContext = context;
            try {
                Preference.putString(context, DataKeys.CONFIG_URL_KEY, strOptString);
                Preference.putString(this.mContext, DataKeys.SSP_REQUEST_URL_KEY, strOptString2);
            } catch (Exception e) {
                if (getConfiguration().isAdpieSdkLog()) {
                    AdPieLog.e(TAG, e);
                }
            }
            initialize(context, str);
        } else {
            initialize(context, str);
        }
    }

    public synchronized void initialize(Context context, String str) {
        String str2 = TAG;
        AdPieLog.d(str2, "AdPie SDK is starting initialization.");
        if (context == null) {
            AdPieLog.e(str2, new Exception("Context cannot be null."));
            OnInitializedListener onInitializedListener = this.mInitializedListener;
            if (onInitializedListener != null) {
                onInitializedListener.onCompleted(false);
            }
            return;
        }
        if (TextUtils.isEmpty(str)) {
            AdPieLog.e(str2, new Exception("Media ID cannot be null."));
            OnInitializedListener onInitializedListener2 = this.mInitializedListener;
            if (onInitializedListener2 != null) {
                onInitializedListener2.onCompleted(false);
            }
            return;
        }
        this.mContext = context;
        this.mAppID = str;
        new Thread(new Runnable() { // from class: com.gomfactory.adpie.sdk.AdPieSDK.1
            @Override // java.lang.Runnable
            public void run() {
                AdPieSDK.this.checkLogging();
                AdPieSDK.this.getMetaData();
                AdPieSDK.this.getCommonHeader();
                final OnGAIDListener onGAIDListener = new OnGAIDListener() { // from class: com.gomfactory.adpie.sdk.AdPieSDK.1.1
                    @Override // com.gomfactory.adpie.sdk.id.OnGAIDListener
                    public void onCompleted(String str3, boolean z) {
                        AdPieLog.d(AdPieSDK.TAG, "AdPie SDK got advertising id : " + str3);
                        AdPieSDK.this.getCommonHeader().setUdid(str3);
                        AdPieSDK.this.getCommonHeader().setUdidType("1");
                        if (z) {
                            AdPieSDK.this.getCommonHeader().setDoNotTracking("1");
                        } else {
                            AdPieSDK.this.getCommonHeader().setDoNotTracking(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                        }
                        AdPieSDK.this.mIsInitialized = true;
                        AdPieLog.d(AdPieSDK.TAG, "AdPie SDK initialization is completed.");
                        AdPieSDK.this.requestConfigData(false);
                        if (AdPieSDK.this.mInitializedListener != null) {
                            AdPieSDK.this.mInitializedListener.onCompleted(true);
                        }
                    }

                    @Override // com.gomfactory.adpie.sdk.id.OnGAIDListener
                    public void onFailed() {
                        AdPieSDK.this.getCommonHeader().setUdid("");
                        AdPieSDK.this.getCommonHeader().setUdidType(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                        AdPieSDK.this.getCommonHeader().setDoNotTracking(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                        AdPieSDK.this.mIsInitialized = true;
                        AdPieLog.d(AdPieSDK.TAG, "AdPie SDK initialization is completed.");
                        AdPieSDK.this.requestConfigData(false);
                        if (AdPieSDK.this.mInitializedListener != null) {
                            AdPieSDK.this.mInitializedListener.onCompleted(true);
                        }
                    }
                };
                AdPieSDK adPieSDK = AdPieSDK.this;
                adPieSDK.mCacheDir = adPieSDK.mContext.getCacheDir().getAbsolutePath();
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.gomfactory.adpie.sdk.AdPieSDK.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        GAID.getInstance().getAdvertisingId(AdPieSDK.this.mContext, onGAIDListener);
                    }
                });
            }
        }).start();
    }

    public synchronized void initialize(Context context, String str, OnInitializedListener onInitializedListener) {
        this.mInitializedListener = onInitializedListener;
        initialize(context, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestConfigData(final boolean z) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
            String str = simpleDateFormat.format(new Date(Preference.getLongValue(this.mContext, DataKeys.getKeyWithMedia(DataKeys.CONFIG_UTIME_KEY, this.mAppID), 0L)));
            String str2 = simpleDateFormat.format(new Date());
            if (getConfiguration().isAdpieSdkLog()) {
                AdPieLog.d(TAG, "updateDate : " + str + ", currentDate : " + str2);
            }
            if (str2.equals(str)) {
                if (getConfiguration().isAdpieSdkLog()) {
                    AdPieLog.d(TAG, "AdPie SDK Configuration was already updated!");
                    return;
                }
                return;
            }
        } catch (Exception unused) {
        }
        int networkConnectionType = getNetworkConnectionType();
        if (networkConnectionType == 0) {
            return;
        }
        getRequest(z).setConnectionType(networkConnectionType);
        if (getConfiguration().isAdpieSdkLog()) {
            AdPieLog.d(TAG, "AdPie SDK is preparing to send configuration.".concat(z ? "" : ":)"));
        }
        NetworkServiceManager.getInstance().post(getRequest(z).getRequestURL(), getRequest(z).toUri().getEncodedQuery(), new Handler(Looper.getMainLooper()) { // from class: com.gomfactory.adpie.sdk.AdPieSDK.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                try {
                    if (message.what == 200) {
                        JSONObject jSONObject = new JSONObject((String) message.obj);
                        if (jSONObject.optInt("result", -1) == 0) {
                            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
                            if (jSONObjectOptJSONObject != null) {
                                AdPieSDK.this.updateConfig(jSONObjectOptJSONObject);
                                Preference.putString(AdPieSDK.this.mContext, DataKeys.getKeyWithMedia(DataKeys.CONFIG_ACCESS_DATE_KEY, AdPieSDK.this.mAppID), jSONObjectOptJSONObject.optString("access_date"));
                            }
                        } else if (!z) {
                            AdPieSDK.this.requestConfigData(true);
                        }
                    } else if (message.what == -1 && !z) {
                        AdPieSDK.this.requestConfigData(true);
                    }
                } catch (Exception e) {
                    if (AdPieSDK.this.getConfiguration().isAdpieSdkLog()) {
                        AdPieLog.e(AdPieSDK.TAG, e);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateConfig(JSONObject jSONObject) {
        try {
            Preference.putLong(this.mContext, DataKeys.getKeyWithMedia(DataKeys.CONFIG_UTIME_KEY, this.mAppID), new Date().getTime());
            boolean z = false;
            z = false;
            boolean z2 = jSONObject.optInt("ssp_enable", 1) != 0;
            String strOptString = jSONObject.optString("ssp_req_url");
            Preference.putBoolean(this.mContext, DataKeys.getKeyWithMedia("SSP_ENABLE", this.mAppID), z2);
            Preference.putString(this.mContext, DataKeys.SSP_REQUEST_URL_KEY, strOptString);
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(ScarConstants.TOKEN_ID_KEY);
            String udid = getCommonHeader().getUdid();
            if (jSONArrayOptJSONArray != null && !TextUtils.isEmpty(udid)) {
                boolean z3 = false;
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    if (jSONArrayOptJSONArray.get(i).equals(udid)) {
                        z3 = true;
                    }
                }
                z = z3;
            }
            Preference.putBoolean(this.mContext, "LOG_ENABLE", z);
            checkLogging();
        } catch (Exception e) {
            if (getConfiguration().isAdpieSdkLog()) {
                AdPieLog.e(TAG, e);
            }
        }
    }

    public String getAppId() {
        return this.mAppID;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getMetaData() {
        try {
            Bundle bundle = this.mContext.getPackageManager().getApplicationInfo(this.mContext.getPackageName(), 128).metaData;
            String string = bundle.getString("com.adxcorp.ads.sdk.http");
            String string2 = bundle.getString("adpie.sdk.http");
            if (getConfiguration().isAdpieSdkLog()) {
                AdPieLog.d(TAG, "com.adxcorp.ads.sdk.http : " + string + ", adpie.sdk.http : " + string2);
            }
            NetworkServiceManager.getInstance().setUseRetrofit((!TextUtils.isEmpty(string) && string.equals("retrofit")) || (!TextUtils.isEmpty(string2) && string2.equals("retrofit")));
        } catch (Exception e) {
            if (getConfiguration().isAdpieSdkLog()) {
                AdPieLog.e(TAG, e);
            }
        }
    }

    public AdRequest getCommonHeader() {
        Locale locale;
        if (this.mCommonHeader == null) {
            AdRequest adRequest = new AdRequest();
            this.mCommonHeader = adRequest;
            try {
                adRequest.setDeviceType(Integer.toString(2));
                this.mCommonHeader.setOsType(Integer.toString(1));
                this.mCommonHeader.setSdkVersion(BuildConfig.VERSION_NAME);
                this.mCommonHeader.setOsVersion(Build.VERSION.RELEASE);
                this.mCommonHeader.setAvailableVideo(true);
                try {
                    PackageInfo packageInfo = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0);
                    this.mCommonHeader.setAppPackageName(packageInfo.packageName);
                    this.mCommonHeader.setAppVersionName(packageInfo.versionName);
                    if (getConfiguration().isAdpieSdkLog()) {
                        String str = TAG;
                        AdPieLog.d(str, "packageName:" + packageInfo.packageName);
                        AdPieLog.d(str, "versionName:" + packageInfo.versionName);
                        AdPieLog.d(str, "versionCode:" + packageInfo.versionCode);
                    }
                } catch (PackageManager.NameNotFoundException e) {
                    if (getConfiguration().isAdpieSdkLog()) {
                        AdPieLog.e(TAG, e);
                    }
                } catch (Exception e2) {
                    if (getConfiguration().isAdpieSdkLog()) {
                        AdPieLog.e(TAG, e2);
                    }
                }
                try {
                    this.mCommonHeader.setUserAgent(System.getProperty("http.agent"));
                } catch (Exception e3) {
                    if (getConfiguration().isAdpieSdkLog()) {
                        AdPieLog.e(TAG, e3);
                    }
                }
                this.mCommonHeader.setManufacturer(Build.MANUFACTURER);
                this.mCommonHeader.setModel(Build.MODEL);
                if (getConfiguration().isAdpieSdkLog()) {
                    String str2 = TAG;
                    AdPieLog.d(str2, "BRAND:" + Build.BRAND);
                    AdPieLog.d(str2, "MANUFACTURER:" + Build.MANUFACTURER);
                    AdPieLog.d(str2, "MODEL:" + Build.MODEL);
                }
                try {
                    TelephonyManager telephonyManager = (TelephonyManager) this.mContext.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
                    if (getConfiguration().isAdpieSdkLog()) {
                        AdPieLog.d(TAG, "operationName:" + telephonyManager.getNetworkOperatorName());
                    }
                    this.mCommonHeader.setServiceProvider(telephonyManager.getNetworkOperatorName());
                    if (getConfiguration().isAdpieSdkLog()) {
                        String str3 = TAG;
                        AdPieLog.d(str3, "getNETWORKCountryIso:" + telephonyManager.getNetworkCountryIso());
                        AdPieLog.d(str3, "getSimCountryIso:" + telephonyManager.getSimCountryIso());
                    }
                    this.mCommonHeader.setCountryCode(telephonyManager.getNetworkCountryIso());
                } catch (Exception e4) {
                    if (getConfiguration().isAdpieSdkLog()) {
                        AdPieLog.e(TAG, e4);
                    }
                }
                try {
                    if (this.mContext != null) {
                        if (Build.VERSION.SDK_INT >= 24) {
                            locale = this.mContext.getResources().getConfiguration().getLocales().get(0);
                        } else {
                            locale = this.mContext.getResources().getConfiguration().locale;
                        }
                        String language = locale.getLanguage();
                        if (TextUtils.isEmpty(language)) {
                            language = Locale.getDefault().getLanguage();
                        }
                        this.mCommonHeader.setLanguage(language);
                    }
                } catch (Exception e5) {
                    if (getConfiguration().isAdpieSdkLog()) {
                        AdPieLog.e(TAG, e5);
                    }
                }
                try {
                    Context context = this.mContext;
                    if (context != null) {
                        int deviceWidth = DisplayUtil.getDeviceWidth(context);
                        int deviceHeight = DisplayUtil.getDeviceHeight(this.mContext);
                        if (deviceWidth > 0 && deviceHeight > 0) {
                            this.mCommonHeader.setDeviceWidth(deviceWidth);
                            this.mCommonHeader.setDeviceHeight(deviceHeight);
                        }
                    }
                } catch (Exception e6) {
                    if (getConfiguration().isAdpieSdkLog()) {
                        AdPieLog.e(TAG, e6);
                    }
                }
                try {
                    if (getConfiguration().isAdpieSdkLog()) {
                        AdPieLog.d(TAG, "InAppBrowser Name : " + InAppBrowser.class.getName());
                    }
                    ActivityInfo[] activityInfoArr = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 1).activities;
                    if (activityInfoArr != null && activityInfoArr.length > 0) {
                        for (ActivityInfo activityInfo : activityInfoArr) {
                            if (getConfiguration().isAdpieSdkLog()) {
                                AdPieLog.d(TAG, "Activity Name:" + activityInfo.name);
                            }
                            if (activityInfo.name.contains(InAppBrowser.class.getName())) {
                                if (getConfiguration().isAdpieSdkLog()) {
                                    AdPieLog.d(TAG, "Available InAppBrowser!");
                                }
                                this.mCommonHeader.setAvailableInAppBrowser(true);
                            }
                        }
                    }
                } catch (PackageManager.NameNotFoundException e7) {
                    if (getConfiguration().isAdpieSdkLog()) {
                        AdPieLog.e(TAG, e7);
                    }
                } catch (Exception e8) {
                    if (getConfiguration().isAdpieSdkLog()) {
                        AdPieLog.e(TAG, e8);
                    }
                }
            } catch (Exception e9) {
                if (getConfiguration().isAdpieSdkLog()) {
                    AdPieLog.e(TAG, e9);
                }
            }
        }
        return this.mCommonHeader;
    }

    private AdRequest getRequest(boolean z) {
        if (this.mAdRequest == null) {
            this.mAdRequest = (AdRequest) getCommonHeader().clone();
        }
        try {
            String stringValue = Preference.getStringValue(this.mContext, DataKeys.CONFIG_URL_KEY, "");
            if (!TextUtils.isEmpty(stringValue) && !z) {
                this.mAdRequest.setRequestURL(stringValue, true);
            } else {
                this.mAdRequest.setRequestURL(getConfiguration().getAdpieConfigUrl(), true);
            }
        } catch (Exception unused) {
            this.mAdRequest.setRequestURL(getConfiguration().getAdpieConfigUrl(), true);
        }
        this.mAdRequest.setAppID(getAppId());
        try {
            this.mAdRequest.setAccessDate(Preference.getStringValue(this.mContext, DataKeys.getKeyWithMedia(DataKeys.CONFIG_ACCESS_DATE_KEY, this.mAppID), ""));
        } catch (Exception unused2) {
        }
        return this.mAdRequest;
    }

    /* JADX WARN: Removed duplicated region for block: B:86:0x0144  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int getNetworkConnectionType() {
        /*
            Method dump skipped, instruction units count: 330
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gomfactory.adpie.sdk.AdPieSDK.getNetworkConnectionType():int");
    }

    public boolean checkPermission(String str) {
        try {
            return this.mContext.checkCallingOrSelfPermission(str) == 0;
        } catch (Exception e) {
            AdPieLog.e(TAG, e);
            return false;
        }
    }

    public String getVersion() {
        return BuildConfig.VERSION_NAME;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkLogging() {
        try {
            if (Preference.getBooleanValue(this.mContext, "LOG_ENABLE", false)) {
                configuration.setAdpieSdkLog(true);
                AdPieLog.setLogEnable(true);
                AdPieLog.setLogLevel(3);
            }
        } catch (Exception unused) {
        }
    }

    public String getCacheDir() {
        return this.mCacheDir;
    }

    public void addTargetBrowser(String str) {
        ClickThroughUtil.addTargetBrowser(str);
    }

    public void clearTargetBrowser() {
        ClickThroughUtil.clearTargetBrowser();
    }

    public String getUserAgent() {
        String property;
        if (TextUtils.isEmpty(this.mUserAgent)) {
            try {
                try {
                    property = System.getProperty("http.agent");
                } catch (Exception e) {
                    AdPieLog.e(TAG, e);
                }
            } catch (SecurityException unused) {
                property = null;
            }
            if (Looper.myLooper() != Looper.getMainLooper()) {
                return property;
            }
            this.mUserAgent = WebSettings.getDefaultUserAgent(this.mContext);
        }
        return this.mUserAgent;
    }

    /* JADX INFO: renamed from: com.gomfactory.adpie.sdk.AdPieSDK$3, reason: invalid class name */
    class AnonymousClass3 implements Runnable {
        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            WebView webView = new WebView(AdPieSDK.this.mContext);
            AdPieSDK.this.mUserAgent = webView.getSettings().getUserAgentString();
            webView.destroy();
        }
    }
}
