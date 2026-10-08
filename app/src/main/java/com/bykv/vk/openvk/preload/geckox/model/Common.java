package com.bykv.vk.openvk.preload.geckox.model;

import android.os.Build;
import com.facebook.internal.NativeProtocol;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class Common {
    public String ac;
    public long aid;
    public String appName;
    public String appVersion;
    public String deviceId;
    public String deviceModel;
    public String devicePlatform;
    public int os = 0;
    public String osVersion;
    public String region;
    public String sdkVersion;
    public String uid;

    public JSONObject toJson() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("aid", this.aid);
            jSONObject.put("app_version", this.appVersion);
            jSONObject.put("os", this.os);
            jSONObject.put("device_id", this.deviceId);
            jSONObject.put(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING, this.appName);
            jSONObject.put("ac", this.ac);
            jSONObject.put("os_version", this.osVersion);
            jSONObject.put("device_model", this.deviceModel);
            jSONObject.put("device_platform", this.devicePlatform);
            jSONObject.put("sdk_version", this.sdkVersion);
            jSONObject.put(TtmlNode.TAG_REGION, this.region);
            jSONObject.put("uid", this.uid);
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public Common() {
        StringBuilder sb = new StringBuilder();
        sb.append(Build.VERSION.SDK_INT);
        this.osVersion = sb.toString();
        this.deviceModel = Build.MODEL;
        this.devicePlatform = "android";
        this.sdkVersion = "2.0.3-rc.9-pangle";
    }

    public Common(long j, String str, String str2, String str3, String str4) {
        StringBuilder sb = new StringBuilder();
        sb.append(Build.VERSION.SDK_INT);
        this.osVersion = sb.toString();
        this.deviceModel = Build.MODEL;
        this.devicePlatform = "android";
        this.sdkVersion = "2.0.3-rc.9-pangle";
        this.aid = j;
        this.appVersion = str;
        this.deviceId = str2;
        this.appName = str3;
        this.ac = str4;
    }

    public Common(long j, String str, String str2, String str3, String str4, String str5, String str6) {
        StringBuilder sb = new StringBuilder();
        sb.append(Build.VERSION.SDK_INT);
        this.osVersion = sb.toString();
        this.deviceModel = Build.MODEL;
        this.devicePlatform = "android";
        this.sdkVersion = "2.0.3-rc.9-pangle";
        this.aid = j;
        this.appVersion = str;
        this.deviceId = str2;
        this.appName = str3;
        this.ac = str4;
        this.uid = str5;
        this.region = str6;
    }
}
