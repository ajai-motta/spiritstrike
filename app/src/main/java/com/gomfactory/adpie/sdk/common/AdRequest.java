package com.gomfactory.adpie.sdk.common;

import android.net.Uri;
import android.text.TextUtils;
import androidx.webkit.ProxyConfig;
import com.facebook.appevents.AppEventsConstants;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.gomfactory.adpie.sdk.AdPieSDK;
import com.gomfactory.adpie.sdk.TargetingData;
import com.gomfactory.adpie.sdk.util.AdPieLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class AdRequest implements Cloneable {
    public static final String TAG = "AdRequest";
    private String accessDate;
    private String appID;
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
    private String slotID;
    private TargetingData targetingData;
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

    public String getAppID() {
        return this.appID;
    }

    public void setAppID(String str) {
        this.appID = str;
    }

    public String getSlotID() {
        return this.slotID;
    }

    public void setSlotID(String str) {
        this.slotID = str;
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

    public TargetingData getTargetingData() {
        return this.targetingData;
    }

    public void setTargetingData(TargetingData targetingData) {
        this.targetingData = targetingData;
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
        int i;
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
        if (!TextUtils.isEmpty(this.appID)) {
            builderBuildUpon.appendQueryParameter("mid", this.appID);
        }
        if (!TextUtils.isEmpty(this.slotID)) {
            builderBuildUpon.appendQueryParameter("sid", this.slotID);
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
            for (int i2 = 0; i2 < strArrSplit.length; i2++) {
                if (strArrSplit[i2].length() == 1) {
                    stringBuffer.append(AppEventsConstants.EVENT_PARAM_VALUE_NO + strArrSplit[i2]);
                } else if (strArrSplit[i2].length() == 2) {
                    stringBuffer.append(strArrSplit[i2]);
                } else if (i2 == strArrSplit.length - 1 && strArrSplit[i2].indexOf("-") > 0) {
                    String str = strArrSplit[i2];
                    if (str.substring(0, str.indexOf("-")).length() == 1) {
                        stringBuffer.append(AppEventsConstants.EVENT_PARAM_VALUE_NO + strArrSplit[i2]);
                    } else {
                        stringBuffer.append(strArrSplit[i2]);
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
                    if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                        AdPieLog.d(TAG, String.format("key : %s, value : %s", str2, str3));
                    }
                }
            } catch (Exception e) {
                if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                    AdPieLog.e(TAG, e);
                }
            }
        }
        builderBuildUpon.appendQueryParameter("secure", "1");
        if (AdPieSDK.getInstance().getConfiguration().isAdpieServerLog()) {
            builderBuildUpon.appendQueryParameter("debug", "1");
        }
        builderBuildUpon.appendQueryParameter("format", "json");
        try {
            TargetingData targetingData = this.targetingData;
            if (targetingData != null) {
                TargetingData.Gender gender = targetingData.getGender();
                if (gender != null) {
                    int i3 = AnonymousClass1.$SwitchMap$com$gomfactory$adpie$sdk$TargetingData$Gender[gender.ordinal()];
                    if (i3 == 1) {
                        builderBuildUpon.appendQueryParameter("gender", "F");
                    } else if (i3 == 2) {
                        builderBuildUpon.appendQueryParameter("gender", "M");
                    } else if (i3 == 3) {
                        builderBuildUpon.appendQueryParameter("gender", "O");
                    }
                }
                int age = this.targetingData.getAge();
                if (age > 0) {
                    builderBuildUpon.appendQueryParameter(InneractiveMediationDefs.KEY_AGE, age + "");
                }
                int yearOfBirthday = this.targetingData.getYearOfBirthday();
                if (yearOfBirthday > 0) {
                    builderBuildUpon.appendQueryParameter("yob", yearOfBirthday + "");
                    if (age == 0 && (i = (Integer.parseInt(new SimpleDateFormat("yyyy").format(new Date())) - yearOfBirthday) + 1) > 0) {
                        builderBuildUpon.appendQueryParameter(InneractiveMediationDefs.KEY_AGE, i + "");
                    }
                }
                JSONObject customTargeting = this.targetingData.getCustomTargeting();
                if (customTargeting != null) {
                    if (customTargeting.toString().length() < 500) {
                        builderBuildUpon.appendQueryParameter("ext", customTargeting.toString());
                    } else {
                        AdPieLog.d(TAG, "Custom data exceeds the limit of 500 characters!");
                    }
                }
            }
        } catch (Exception e2) {
            AdPieLog.e(TAG, e2);
        }
        if (this.isAvailableInAppBrowser) {
            builderBuildUpon.appendQueryParameter("wv_clk_v2", "1");
        } else {
            builderBuildUpon.appendQueryParameter("wv_clk_v2", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
        return builderBuildUpon.build();
    }

    /* JADX INFO: renamed from: com.gomfactory.adpie.sdk.common.AdRequest$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$gomfactory$adpie$sdk$TargetingData$Gender;

        static {
            int[] iArr = new int[TargetingData.Gender.values().length];
            $SwitchMap$com$gomfactory$adpie$sdk$TargetingData$Gender = iArr;
            try {
                iArr[TargetingData.Gender.FEMALE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$gomfactory$adpie$sdk$TargetingData$Gender[TargetingData.Gender.MALE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$gomfactory$adpie$sdk$TargetingData$Gender[TargetingData.Gender.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            if (!AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                return null;
            }
            AdPieLog.e(TAG, e);
            return null;
        }
    }
}
