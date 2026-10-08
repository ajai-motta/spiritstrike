package com.adxcorp.ads.mediation;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebSettings;
import androidx.autofill.HintConstants;
import com.adxcorp.ads.mediation.common.AdRequest;
import com.adxcorp.ads.mediation.common.Configuration;
import com.adxcorp.ads.mediation.id.GAID;
import com.adxcorp.ads.mediation.id.OnGAIDListener;
import com.adxcorp.ads.mediation.network.NetworkServiceManager;
import com.adxcorp.ads.mediation.pref.Preference;
import com.adxcorp.ads.mediation.util.ClickThroughUtil;
import com.adxcorp.ads.mediation.util.DisplayUtil;
import com.adxcorp.gdpr.ADXGDPR;
import com.adxcorp.util.ADXLogUtil;
import com.facebook.appevents.AppEventsConstants;
import java.util.Locale;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public class MediationSDK {
    public static final String TAG = "MediationSDK";
    private static Configuration configuration = new Configuration();
    private static MediationSDK ourInstance = new MediationSDK();
    private String mAppID;
    private String mCacheDir;
    private AdRequest mCommonHeader;
    private Context mContext;
    private OnInitializedListener mInitializedListener;
    private boolean mIsInitialized;
    private boolean mIsLiteSdk;
    private String mRandomId;
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

    private MediationSDK() {
        ADXLogUtil.d(TAG, "AdSDK instance is created.");
    }

    public static MediationSDK getInstance() {
        return ourInstance;
    }

    public boolean isInitialized() {
        return this.mIsInitialized;
    }

    public boolean isLiteSdk() {
        return this.mIsLiteSdk;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public synchronized void initialize(Context context, String str) {
        String str2 = TAG;
        ADXLogUtil.d(str2, "AdSDK is starting initialization.");
        if (context == null) {
            ADXLogUtil.e(str2, new Exception("Context cannot be null."));
            OnInitializedListener onInitializedListener = this.mInitializedListener;
            if (onInitializedListener != null) {
                onInitializedListener.onCompleted(false);
            }
            return;
        }
        if (TextUtils.isEmpty(str)) {
            ADXLogUtil.e(str2, new Exception("Media ID cannot be null."));
            OnInitializedListener onInitializedListener2 = this.mInitializedListener;
            if (onInitializedListener2 != null) {
                onInitializedListener2.onCompleted(false);
            }
            return;
        }
        this.mContext = context;
        this.mAppID = str;
        new Thread(new Runnable() { // from class: com.adxcorp.ads.mediation.MediationSDK.1
            @Override // java.lang.Runnable
            public void run() {
                MediationSDK.this.checkLogging();
                MediationSDK.this.getCommonHeader();
                final OnGAIDListener onGAIDListener = new OnGAIDListener() { // from class: com.adxcorp.ads.mediation.MediationSDK.1.1
                    @Override // com.adxcorp.ads.mediation.id.OnGAIDListener
                    public void onCompleted(String str3, boolean z) {
                        Log.d(MediationSDK.TAG, "AdSDK SDK got advertising id : " + str3);
                        MediationSDK.this.getCommonHeader().setUdid(str3);
                        MediationSDK.this.getCommonHeader().setUdidType("1");
                        if (z) {
                            MediationSDK.this.getCommonHeader().setDoNotTracking("1");
                        } else {
                            MediationSDK.this.getCommonHeader().setDoNotTracking(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                        }
                        if (!TextUtils.isEmpty(str3) && (str3.equals("4c984808-8f09-4ee3-af6f-10ca1ad1abe1") || str3.equals("f7550f98-080b-4a30-b078-10ca1ad1abe1") || str3.equals("e7a96ec1-de96-4aa4-bc42-10ca1ad1abe1") || str3.equals("1455ba1f-e871-4174-bae3-e6eddb28dde0"))) {
                            MediationSDK.this.getConfiguration().setSdkLog(true);
                            ADXLogUtil.setLogEnable(true);
                            ADXLogUtil.setLogLevel(3);
                        }
                        MediationSDK.this.mIsInitialized = true;
                        Log.d(MediationSDK.TAG, "Mediation SDK initialization is completed.");
                        if (MediationSDK.this.mInitializedListener != null) {
                            MediationSDK.this.mInitializedListener.onCompleted(true);
                        }
                    }

                    @Override // com.adxcorp.ads.mediation.id.OnGAIDListener
                    public void onFailed() {
                        MediationSDK.this.getCommonHeader().setUdid("");
                        MediationSDK.this.getCommonHeader().setUdidType(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                        MediationSDK.this.getCommonHeader().setDoNotTracking(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                        MediationSDK.this.mIsInitialized = true;
                        Log.d(MediationSDK.TAG, "Mediation initialization is completed.");
                        if (MediationSDK.this.mInitializedListener != null) {
                            MediationSDK.this.mInitializedListener.onCompleted(true);
                        }
                    }
                };
                MediationSDK mediationSDK = MediationSDK.this;
                mediationSDK.mCacheDir = mediationSDK.mContext.getCacheDir().getAbsolutePath();
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.adxcorp.ads.mediation.MediationSDK.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        GAID.getInstance().getAdvertisingId(MediationSDK.this.mContext, onGAIDListener);
                    }
                });
            }
        }).start();
    }

    public synchronized void initialize(Context context, String str, OnInitializedListener onInitializedListener) {
        this.mInitializedListener = onInitializedListener;
        initialize(context, str);
    }

    public String getAppId() {
        return this.mAppID;
    }

    public AdRequest getCommonHeader() {
        Locale locale;
        if (this.mCommonHeader == null) {
            AdRequest adRequest = new AdRequest();
            this.mCommonHeader = adRequest;
            boolean z = false;
            try {
                adRequest.setDeviceType(Integer.toString(2));
                this.mCommonHeader.setOsType(Integer.toString(1));
                this.mCommonHeader.setSdkVersion(ADXGDPR.ADX_SDK_VERSION);
                this.mCommonHeader.setOsVersion(Build.VERSION.RELEASE);
                this.mCommonHeader.setAvailableVideo(true);
                try {
                    try {
                        PackageInfo packageInfo = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0);
                        this.mCommonHeader.setAppPackageName(packageInfo.packageName);
                        this.mCommonHeader.setAppVersionName(packageInfo.versionName);
                        if (getConfiguration().isSdkLog()) {
                            String str = TAG;
                            ADXLogUtil.d(str, "packageName:" + packageInfo.packageName);
                            ADXLogUtil.d(str, "versionName:" + packageInfo.versionName);
                            ADXLogUtil.d(str, "versionCode:" + packageInfo.versionCode);
                        }
                    } catch (Exception e) {
                        if (getConfiguration().isSdkLog()) {
                            ADXLogUtil.e(TAG, e);
                        }
                    }
                } catch (PackageManager.NameNotFoundException e2) {
                    if (getConfiguration().isSdkLog()) {
                        ADXLogUtil.e(TAG, e2);
                    }
                }
                try {
                    if (TextUtils.isEmpty(this.mCommonHeader.getUserAgent())) {
                        this.mCommonHeader.setUserAgent(System.getProperty("http.agent"));
                    }
                } catch (Exception e3) {
                    if (getConfiguration().isSdkLog()) {
                        ADXLogUtil.e(TAG, e3);
                    }
                }
                this.mCommonHeader.setManufacturer(Build.MANUFACTURER);
                this.mCommonHeader.setModel(Build.MODEL);
                if (getConfiguration().isSdkLog()) {
                    String str2 = TAG;
                    ADXLogUtil.d(str2, "BRAND:" + Build.BRAND);
                    ADXLogUtil.d(str2, "MANUFACTURER:" + Build.MANUFACTURER);
                    ADXLogUtil.d(str2, "MODEL:" + Build.MODEL);
                }
                try {
                    TelephonyManager telephonyManager = (TelephonyManager) this.mContext.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
                    if (getConfiguration().isSdkLog()) {
                        ADXLogUtil.d(TAG, "operationName:" + telephonyManager.getNetworkOperatorName());
                    }
                    this.mCommonHeader.setServiceProvider(telephonyManager.getNetworkOperatorName());
                    if (getConfiguration().isSdkLog()) {
                        String str3 = TAG;
                        ADXLogUtil.d(str3, "getNETWORKCountryIso:" + telephonyManager.getNetworkCountryIso());
                        ADXLogUtil.d(str3, "getSimCountryIso:" + telephonyManager.getSimCountryIso());
                    }
                    this.mCommonHeader.setCountryCode(telephonyManager.getNetworkCountryIso());
                } catch (Exception e4) {
                    if (getConfiguration().isSdkLog()) {
                        ADXLogUtil.e(TAG, e4);
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
                    if (getConfiguration().isSdkLog()) {
                        ADXLogUtil.e(TAG, e5);
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
                    if (getConfiguration().isSdkLog()) {
                        ADXLogUtil.e(TAG, e6);
                    }
                }
                try {
                    try {
                        if (getConfiguration().isSdkLog()) {
                            ADXLogUtil.d(TAG, "InAppBrowser Name : " + InAppBrowser.class.getName());
                        }
                        ActivityInfo[] activityInfoArr = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 1).activities;
                        if (activityInfoArr != null && activityInfoArr.length > 0) {
                            for (ActivityInfo activityInfo : activityInfoArr) {
                                if (getConfiguration().isSdkLog()) {
                                    ADXLogUtil.d(TAG, "Activity Name:" + activityInfo.name);
                                }
                                if (activityInfo.name.contains(InAppBrowser.class.getName())) {
                                    if (getConfiguration().isSdkLog()) {
                                        ADXLogUtil.d(TAG, "Available InAppBrowser!");
                                    }
                                    this.mCommonHeader.setAvailableInAppBrowser(true);
                                }
                            }
                        }
                    } catch (PackageManager.NameNotFoundException e7) {
                        if (getConfiguration().isSdkLog()) {
                            ADXLogUtil.e(TAG, e7);
                        }
                    }
                } catch (Exception e8) {
                    if (getConfiguration().isSdkLog()) {
                        ADXLogUtil.e(TAG, e8);
                    }
                }
            } catch (Exception e9) {
                if (getConfiguration().isSdkLog()) {
                    ADXLogUtil.e(TAG, e9);
                }
            }
            try {
                Bundle bundle = this.mContext.getPackageManager().getApplicationInfo(this.mContext.getPackageName(), 128).metaData;
                String string = bundle.getString("com.adxcorp.ads.sdk.type");
                String string2 = bundle.getString("com.adxcorp.ads.sdk.http");
                Log.d(TAG, "ADX Ads Type : " + string + ", Http Module : " + string2);
                if (!TextUtils.isEmpty(string) && string.equals("lite")) {
                    this.mIsLiteSdk = true;
                }
                NetworkServiceManager networkServiceManager = NetworkServiceManager.getInstance();
                if (!TextUtils.isEmpty(string2) && string2.equals("retrofit")) {
                    z = true;
                }
                networkServiceManager.setUseRetrofit(z);
            } catch (Exception e10) {
                if (getConfiguration().isSdkLog()) {
                    ADXLogUtil.e(TAG, e10);
                }
            }
            if (this.mIsLiteSdk) {
                this.mCommonHeader.setRequestURL("https://in.api.mediation.adxcorp.kr/v1/mediations", true);
            } else {
                this.mCommonHeader.setRequestURL("https://api.mediation.adxcorp.kr/v1/mediations", true);
            }
        }
        return this.mCommonHeader;
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
        throw new UnsupportedOperationException("Method not decompiled: com.adxcorp.ads.mediation.MediationSDK.getNetworkConnectionType():int");
    }

    public boolean checkPermission(String str) {
        try {
            return this.mContext.checkCallingOrSelfPermission(str) == 0;
        } catch (Exception e) {
            ADXLogUtil.e(TAG, e);
            return false;
        }
    }

    public String getVersion() {
        return ADXGDPR.ADX_SDK_VERSION;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkLogging() {
        try {
            if (Preference.getBooleanValue(this.mContext, "LOG_ENABLE", false)) {
                configuration.setSdkLog(true);
                ADXLogUtil.setLogEnable(true);
                ADXLogUtil.setLogLevel(3);
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
                    ADXLogUtil.e(TAG, e);
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

    public String getRandomId() {
        try {
            if (TextUtils.isEmpty(this.mRandomId)) {
                String stringValue = Preference.getStringValue(this.mContext, "randomID", "");
                this.mRandomId = stringValue;
                if (TextUtils.isEmpty(stringValue)) {
                    String string = UUID.randomUUID().toString();
                    this.mRandomId = string;
                    Preference.putString(this.mContext, "randomID", string);
                }
            }
        } catch (Exception unused) {
        }
        return this.mRandomId;
    }
}
