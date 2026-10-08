package com.adxcorp.ads.mediation.common;

import android.net.Uri;
import android.text.TextUtils;
import androidx.webkit.ProxyConfig;
import com.adxcorp.ads.mediation.MediationSDK;
import com.adxcorp.util.ADXLogUtil;
import com.facebook.appevents.AppEventsConstants;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class AdRequest implements Cloneable {
    public static final String TAG = "AdRequest";
    private String accessDate;
    private String adUnitId;
    private String appId;
    private String appPackageName;
    private String appVersionName;
    private int connectionType;
    private String countryCode;
    private int deviceHeight;
    private String deviceType;
    private int deviceWidth;
    private String doNotTracking;
    private boolean isAvailableInAppBrowser;
    private boolean isAvailableVideo;
    private String language;
    private String manufacturer;
    private String model;
    private String osType;
    private String osVersion;
    private HashMap<String, String> queryMap;
    private String requestURL;
    private String sdkVersion;
    private String serviceProvider;
    private String udid;
    private String udidType;
    private String userAgent;

    public String getRequestURL() {
        return this.requestURL;
    }

    public void setRequestURL(String str, boolean z) {
        if (str != null) {
            if (str.startsWith(ProxyConfig.MATCH_HTTP) || str.startsWith("https")) {
                this.requestURL = str;
                return;
            }
            if (z) {
                this.requestURL = "https://" + str;
                return;
            } else {
                this.requestURL = "http://" + str;
                return;
            }
        }
        this.requestURL = null;
    }

    public String getAppId() {
        return this.appId;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public String getAdUnitId() {
        return this.adUnitId;
    }

    public void setAdUnitId(String str) {
        this.adUnitId = str;
    }

    public String getDeviceType() {
        return this.deviceType;
    }

    public void setDeviceType(String str) {
        this.deviceType = str;
    }

    public String getOsType() {
        return this.osType;
    }

    public void setOsType(String str) {
        this.osType = str;
    }

    public String getUdid() {
        return this.udid;
    }

    public void setUdid(String str) {
        this.udid = str;
    }

    public String getUdidType() {
        return this.udidType;
    }

    public void setUdidType(String str) {
        this.udidType = str;
    }

    public String getDoNotTracking() {
        return this.doNotTracking;
    }

    public void setDoNotTracking(String str) {
        this.doNotTracking = str;
    }

    public String getServiceProvider() {
        return this.serviceProvider;
    }

    public void setServiceProvider(String str) {
        this.serviceProvider = str;
    }

    public int getConnectionType() {
        return this.connectionType;
    }

    public void setConnectionType(int i) {
        this.connectionType = i;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public void setCountryCode(String str) {
        this.countryCode = str;
    }

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(String str) {
        this.language = str;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public void setManufacturer(String str) {
        this.manufacturer = str;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String str) {
        this.model = str;
    }

    public String getOsVersion() {
        return this.osVersion;
    }

    public void setOsVersion(String str) {
        this.osVersion = str;
    }

    public String getSdkVersion() {
        return this.sdkVersion;
    }

    public void setSdkVersion(String str) {
        this.sdkVersion = str;
    }

    public String getUserAgent() {
        return this.userAgent;
    }

    public void setUserAgent(String str) {
        this.userAgent = str;
    }

    public String getAccessDate() {
        return this.accessDate;
    }

    public void setAccessDate(String str) {
        this.accessDate = str;
    }

    public String getAppPackageName() {
        return this.appPackageName;
    }

    public void setAppPackageName(String str) {
        this.appPackageName = str;
    }

    public String getAppVersionName() {
        return this.appVersionName;
    }

    public void setAppVersionName(String str) {
        this.appVersionName = str;
    }

    public int getDeviceWidth() {
        return this.deviceWidth;
    }

    public void setDeviceWidth(int i) {
        this.deviceWidth = i;
    }

    public int getDeviceHeight() {
        return this.deviceHeight;
    }

    public void setDeviceHeight(int i) {
        this.deviceHeight = i;
    }

    public boolean isAvailableVideo() {
        return this.isAvailableVideo;
    }

    public void setAvailableVideo(boolean z) {
        this.isAvailableVideo = z;
    }

    public HashMap<String, String> getQueryMap() {
        return this.queryMap;
    }

    public void setQueryMap(HashMap<String, String> map) {
        this.queryMap = map;
    }

    public boolean isAvailableInAppBrowser() {
        return this.isAvailableInAppBrowser;
    }

    public void setAvailableInAppBrowser(boolean z) {
        this.isAvailableInAppBrowser = z;
    }

    public String toString() {
        return toUri().toString();
    }

    public Uri toUri() {
        Uri.Builder builderBuildUpon = Uri.parse(getRequestURL()).buildUpon();
        if (!TextUtils.isEmpty(this.deviceType)) {
            builderBuildUpon.appendQueryParameter("dtype", this.deviceType);
        }
        if (!TextUtils.isEmpty(this.osType)) {
            builderBuildUpon.appendQueryParameter("ostype", this.osType);
        }
        if (!TextUtils.isEmpty(this.serviceProvider)) {
            builderBuildUpon.appendQueryParameter("carrier", this.serviceProvider);
        }
        if (this.connectionType > 0) {
            builderBuildUpon.appendQueryParameter("connectiontype", this.connectionType + "");
        }
        if (!TextUtils.isEmpty(this.countryCode)) {
            builderBuildUpon.appendQueryParameter("cc", this.countryCode);
        }
        if (!TextUtils.isEmpty(this.language)) {
            builderBuildUpon.appendQueryParameter("lo", this.language);
        }
        if (!TextUtils.isEmpty(this.manufacturer)) {
            builderBuildUpon.appendQueryParameter("make", this.manufacturer);
        }
        if (!TextUtils.isEmpty(this.model)) {
            builderBuildUpon.appendQueryParameter("mo", this.model);
        }
        if (!TextUtils.isEmpty(this.appId)) {
            builderBuildUpon.appendQueryParameter("appId", this.appId);
        }
        if (!TextUtils.isEmpty(this.adUnitId)) {
            builderBuildUpon.appendQueryParameter(HandleInvocationsFromAdViewer.KEY_AD_UNIT_ID, this.adUnitId);
        }
        if (!TextUtils.isEmpty(this.userAgent)) {
            builderBuildUpon.appendQueryParameter("ua", this.userAgent);
        }
        if (!TextUtils.isEmpty(this.udid)) {
            builderBuildUpon.appendQueryParameter("udid", this.udid);
        }
        if (!TextUtils.isEmpty(this.udidType)) {
            builderBuildUpon.appendQueryParameter("udidtype", this.udidType);
        }
        if (!TextUtils.isEmpty(this.doNotTracking)) {
            builderBuildUpon.appendQueryParameter("dnt", this.doNotTracking);
        }
        if (!TextUtils.isEmpty(this.osVersion)) {
            builderBuildUpon.appendQueryParameter("osver", this.osVersion);
        }
        if (!TextUtils.isEmpty(this.sdkVersion)) {
            StringBuffer stringBuffer = new StringBuffer();
            String[] strArrSplit = TextUtils.split(this.sdkVersion, "[.]");
            for (int i = 0; i < strArrSplit.length; i++) {
                if (strArrSplit[i].length() == 1) {
                    stringBuffer.append(AppEventsConstants.EVENT_PARAM_VALUE_NO + strArrSplit[i]);
                } else if (strArrSplit[i].length() == 2) {
                    stringBuffer.append(strArrSplit[i]);
                } else if (i == strArrSplit.length - 1 && strArrSplit[i].indexOf("-") > 0) {
                    String str = strArrSplit[i];
                    if (str.substring(0, str.indexOf("-")).length() == 1) {
                        stringBuffer.append(AppEventsConstants.EVENT_PARAM_VALUE_NO + strArrSplit[i]);
                    } else {
                        stringBuffer.append(strArrSplit[i]);
                    }
                }
            }
            builderBuildUpon.appendQueryParameter("sdkver", stringBuffer.toString());
        }
        if (!TextUtils.isEmpty(this.appPackageName)) {
            builderBuildUpon.appendQueryParameter("bundle", this.appPackageName);
        }
        if (!TextUtils.isEmpty(this.appVersionName)) {
            builderBuildUpon.appendQueryParameter("ver", this.appVersionName);
        }
        if (!TextUtils.isEmpty(this.accessDate)) {
            builderBuildUpon.appendQueryParameter("accessdate", this.accessDate);
        }
        if (this.deviceWidth > 0 && this.deviceHeight > 0) {
            builderBuildUpon.appendQueryParameter("dw", this.deviceWidth + "");
            builderBuildUpon.appendQueryParameter("dh", this.deviceHeight + "");
        }
        if (this.isAvailableVideo) {
            builderBuildUpon.appendQueryParameter("vs", "1");
        } else {
            builderBuildUpon.appendQueryParameter("vs", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
        HashMap<String, String> map = this.queryMap;
        if (map != null) {
            try {
                for (String str2 : map.keySet()) {
                    String str3 = this.queryMap.get(str2);
                    builderBuildUpon.appendQueryParameter(str2, str3);
                    if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                        ADXLogUtil.d(TAG, String.format("key : %s, value : %s", str2, str3));
                    }
                }
            } catch (Exception e) {
                if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                    ADXLogUtil.e(TAG, e);
                }
            }
        }
        builderBuildUpon.appendQueryParameter("secure", "1");
        if (MediationSDK.getInstance().getConfiguration().isServerLog()) {
            builderBuildUpon.appendQueryParameter("debug", "1");
        }
        builderBuildUpon.appendQueryParameter("format", "json");
        if (this.isAvailableInAppBrowser) {
            builderBuildUpon.appendQueryParameter("wv_clk_v2", "1");
        } else {
            builderBuildUpon.appendQueryParameter("wv_clk_v2", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
        String randomId = MediationSDK.getInstance().getRandomId();
        if (!TextUtils.isEmpty(randomId)) {
            builderBuildUpon.appendQueryParameter("uuid", randomId);
        }
        return builderBuildUpon.build();
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            if (!MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                return null;
            }
            ADXLogUtil.e(TAG, e);
            return null;
        }
    }
}
