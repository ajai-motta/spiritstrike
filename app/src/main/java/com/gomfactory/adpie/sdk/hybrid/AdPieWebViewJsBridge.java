package com.gomfactory.adpie.sdk.hybrid;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import androidx.autofill.HintConstants;
import androidx.core.app.ActivityCompat;
import com.facebook.appevents.AppEventsConstants;
import com.gomfactory.adpie.sdk.AdPieSDK;
import com.gomfactory.adpie.sdk.id.GAID;
import com.gomfactory.adpie.sdk.id.OnGAIDListener;
import com.gomfactory.adpie.sdk.pref.Preference;
import com.gomfactory.adpie.sdk.util.AdPieLog;
import com.gomfactory.adpie.sdk.util.DisplayUtil;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class AdPieWebViewJsBridge {
    public static final String TAG = "AdPieWebViewJsBridge";
    private static AdPieWebViewJsBridge ourInstance = new AdPieWebViewJsBridge();
    private String mAppPackageName;
    private String mAppVersionName;
    private Context mContext;
    private String mCountryCode;
    private int mDeviceHeight;
    private int mDeviceWidth;
    private String mGaid;
    private boolean mIsDoNotTracking;
    private String mLanguage;
    private String mManufacturer;
    private String mModel;
    private String mServiceProvider;
    private String mUdid;
    private String mUdidType;

    public static AdPieWebViewJsBridge getInstance() {
        return ourInstance;
    }

    public void setWebView(WebView webView) {
        try {
            webView.getSettings().setJavaScriptEnabled(true);
            webView.addJavascriptInterface(this, "AdPieSDK");
            this.mContext = webView.getContext();
            getSyncUdid();
            if (TextUtils.isEmpty(this.mUdid)) {
                getAsyncUdid();
            }
        } catch (Exception e) {
            if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                AdPieLog.e(TAG, e);
            }
        }
    }

    private void getSyncUdid() {
        if (AdPieSDK.getInstance().isInitialized()) {
            this.mUdid = AdPieSDK.getInstance().getCommonHeader().getUdid();
            String udidType = AdPieSDK.getInstance().getCommonHeader().getUdidType();
            this.mUdidType = udidType;
            if (TextUtils.isEmpty(udidType) || this.mUdidType != "1") {
                return;
            }
            this.mGaid = this.mUdid;
            return;
        }
        String stringValue = Preference.getStringValue(this.mContext, "UDID_GAID", "");
        boolean booleanValue = Preference.getBooleanValue(this.mContext, "DO_NOT_TRACKING", false);
        if (TextUtils.isEmpty(stringValue)) {
            return;
        }
        this.mUdid = stringValue;
        this.mGaid = stringValue;
        this.mUdidType = "1";
        this.mIsDoNotTracking = booleanValue;
    }

    private void getAsyncUdid() {
        final OnGAIDListener onGAIDListener = new OnGAIDListener() { // from class: com.gomfactory.adpie.sdk.hybrid.AdPieWebViewJsBridge.1
            @Override // com.gomfactory.adpie.sdk.id.OnGAIDListener
            public void onCompleted(String str, boolean z) {
                AdPieWebViewJsBridge.this.mUdid = str;
                AdPieWebViewJsBridge.this.mGaid = str;
                AdPieWebViewJsBridge.this.mUdidType = "1";
                AdPieWebViewJsBridge.this.mIsDoNotTracking = z;
            }

            @Override // com.gomfactory.adpie.sdk.id.OnGAIDListener
            public void onFailed() {
                AdPieWebViewJsBridge.this.mUdid = "";
                AdPieWebViewJsBridge.this.mGaid = "";
                AdPieWebViewJsBridge.this.mUdidType = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                AdPieWebViewJsBridge.this.mIsDoNotTracking = false;
            }
        };
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.gomfactory.adpie.sdk.hybrid.AdPieWebViewJsBridge.2
            @Override // java.lang.Runnable
            public void run() {
                GAID.getInstance().getAdvertisingId(AdPieWebViewJsBridge.this.mContext, onGAIDListener);
            }
        });
    }

    private int getNetworkConnectionType() {
        try {
            if (this.mContext == null) {
                return 0;
            }
            if (!checkPermission("android.permission.INTERNET")) {
                AdPieLog.d(TAG, "android.permission.INTERNET permission must be added in AndroidManifest.xml!");
                return 0;
            }
            if (!checkPermission("android.permission.ACCESS_NETWORK_STATE")) {
                AdPieLog.d(TAG, "android.permission.ACCESS_NETWORK_STATE permission must be added in AndroidManifest.xml!");
                return 0;
            }
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return 0;
            }
            if (activeNetworkInfo.getType() == 1) {
                return 2;
            }
            if (activeNetworkInfo.getType() != 0) {
                return 0;
            }
            if (Build.VERSION.SDK_INT >= 30 && ActivityCompat.checkSelfPermission(this.mContext, "android.permission.READ_PHONE_STATE") != 0) {
                return 3;
            }
            switch (((TelephonyManager) this.mContext.getSystemService(HintConstants.AUTOFILL_HINT_PHONE)).getNetworkType()) {
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    public boolean checkPermission(String str) {
        try {
            return this.mContext.checkCallingOrSelfPermission(str) == 0;
        } catch (Exception e) {
            AdPieLog.e(TAG, e);
            return false;
        }
    }

    @JavascriptInterface
    public String getGAID() {
        if (!TextUtils.isEmpty(this.mGaid)) {
            return this.mGaid;
        }
        getSyncUdid();
        return this.mGaid;
    }

    @JavascriptInterface
    public String getUdid() {
        if (!TextUtils.isEmpty(this.mUdid)) {
            return this.mUdid;
        }
        getSyncUdid();
        return this.mUdid;
    }

    @JavascriptInterface
    public String getUdidType() {
        if (!TextUtils.isEmpty(this.mUdidType)) {
            return this.mUdidType;
        }
        getSyncUdid();
        return this.mUdidType;
    }

    @JavascriptInterface
    public boolean isDoNotTracking() {
        return this.mIsDoNotTracking;
    }

    @JavascriptInterface
    public String getAppPackageName() {
        if (!TextUtils.isEmpty(this.mAppPackageName)) {
            return this.mAppPackageName;
        }
        if (AdPieSDK.getInstance().isInitialized()) {
            this.mAppPackageName = AdPieSDK.getInstance().getCommonHeader().getAppPackageName();
        } else {
            Context context = this.mContext;
            if (context != null) {
                this.mAppPackageName = context.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0).packageName;
            }
        }
        return this.mAppPackageName;
    }

    @JavascriptInterface
    public String getAppVersionName() {
        if (!TextUtils.isEmpty(this.mAppVersionName)) {
            return this.mAppVersionName;
        }
        if (AdPieSDK.getInstance().isInitialized()) {
            this.mAppVersionName = AdPieSDK.getInstance().getCommonHeader().getAppVersionName();
        } else {
            Context context = this.mContext;
            if (context != null) {
                this.mAppVersionName = context.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0).versionName;
            }
        }
        return this.mAppVersionName;
    }

    @JavascriptInterface
    public String getManufacturer() {
        if (!TextUtils.isEmpty(this.mManufacturer)) {
            return this.mManufacturer;
        }
        if (AdPieSDK.getInstance().isInitialized()) {
            this.mManufacturer = AdPieSDK.getInstance().getCommonHeader().getManufacturer();
        } else {
            this.mManufacturer = Build.MANUFACTURER;
        }
        return this.mManufacturer;
    }

    @JavascriptInterface
    public String getModel() {
        if (!TextUtils.isEmpty(this.mModel)) {
            return this.mModel;
        }
        if (AdPieSDK.getInstance().isInitialized()) {
            this.mModel = AdPieSDK.getInstance().getCommonHeader().getModel();
        } else {
            this.mModel = Build.MODEL;
        }
        return this.mModel;
    }

    @JavascriptInterface
    public String getServiceProvider() {
        if (!TextUtils.isEmpty(this.mServiceProvider)) {
            return this.mServiceProvider;
        }
        if (AdPieSDK.getInstance().isInitialized()) {
            this.mServiceProvider = AdPieSDK.getInstance().getCommonHeader().getServiceProvider();
        } else {
            Context context = this.mContext;
            if (context != null) {
                this.mServiceProvider = ((TelephonyManager) context.getSystemService(HintConstants.AUTOFILL_HINT_PHONE)).getNetworkOperatorName();
            }
        }
        return this.mServiceProvider;
    }

    @JavascriptInterface
    public String getCountryCode() {
        if (!TextUtils.isEmpty(this.mCountryCode)) {
            return this.mCountryCode;
        }
        if (AdPieSDK.getInstance().isInitialized()) {
            this.mCountryCode = AdPieSDK.getInstance().getCommonHeader().getCountryCode();
        } else {
            Context context = this.mContext;
            if (context != null) {
                this.mCountryCode = ((TelephonyManager) context.getSystemService(HintConstants.AUTOFILL_HINT_PHONE)).getNetworkCountryIso();
            }
        }
        return this.mCountryCode;
    }

    @JavascriptInterface
    public String getLanguage() {
        Locale locale;
        if (!TextUtils.isEmpty(this.mLanguage)) {
            return this.mLanguage;
        }
        if (AdPieSDK.getInstance().isInitialized()) {
            this.mLanguage = AdPieSDK.getInstance().getCommonHeader().getLanguage();
        } else if (this.mContext != null) {
            if (Build.VERSION.SDK_INT >= 24) {
                locale = this.mContext.getResources().getConfiguration().getLocales().get(0);
            } else {
                locale = this.mContext.getResources().getConfiguration().locale;
            }
            String language = locale.getLanguage();
            if (TextUtils.isEmpty(language)) {
                language = Locale.getDefault().getLanguage();
            }
            this.mLanguage = language;
        }
        return this.mLanguage;
    }

    @JavascriptInterface
    public int getConnectionType() {
        if (AdPieSDK.getInstance().isInitialized()) {
            return AdPieSDK.getInstance().getCommonHeader().getConnectionType();
        }
        return getNetworkConnectionType();
    }

    @JavascriptInterface
    public int getDeviceWidth() {
        try {
            int i = this.mDeviceWidth;
            if (i > 0) {
                return i;
            }
            Context context = this.mContext;
            if (context != null) {
                this.mDeviceWidth = DisplayUtil.getDeviceWidth(context);
            }
        } catch (Exception unused) {
        }
        return this.mDeviceWidth;
    }

    @JavascriptInterface
    public int getDeviceHeight() {
        try {
            int i = this.mDeviceHeight;
            if (i > 0) {
                return i;
            }
            Context context = this.mContext;
            if (context != null) {
                this.mDeviceHeight = DisplayUtil.getDeviceHeight(context);
            }
        } catch (Exception unused) {
        }
        return this.mDeviceHeight;
    }
}
