package com.hive.authv4.devicemanagement.ui.model;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.hive.base.Android;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: DeviceInfo.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\b\u0010\fJ\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0011\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u0000H\u0096\u0002J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J;\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0014¨\u0006#"}, d2 = {"Lcom/hive/authv4/devicemanagement/ui/model/DeviceInfo;", "", "seq", "", "os", Android.HW_IDS_DEVICE_MODEL, "deviceName", "addDate", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "jsonObject", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "getSeq", "()Ljava/lang/String;", "getOs", "getDeviceModel", "getDeviceName", "getAddDate", "setAddDate", "(Ljava/lang/String;)V", "equals", "", "other", "", "hashCode", "", "compareTo", "component1", "component2", "component3", "component4", "component5", "copy", InAppPurchaseConstants.METHOD_TO_STRING, "hive-authv4-device-management_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class DeviceInfo implements Comparable<DeviceInfo> {
    private String addDate;
    private final String deviceModel;
    private final String deviceName;
    private final String os;
    private final String seq;

    public static /* synthetic */ DeviceInfo copy$default(DeviceInfo deviceInfo, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = deviceInfo.seq;
        }
        if ((i & 2) != 0) {
            str2 = deviceInfo.os;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = deviceInfo.deviceModel;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = deviceInfo.deviceName;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = deviceInfo.addDate;
        }
        return deviceInfo.copy(str, str6, str7, str8, str5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSeq() {
        return this.seq;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getOs() {
        return this.os;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDeviceModel() {
        return this.deviceModel;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getDeviceName() {
        return this.deviceName;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getAddDate() {
        return this.addDate;
    }

    public final DeviceInfo copy(String seq, String os, String deviceModel, String deviceName, String addDate) {
        Intrinsics.checkNotNullParameter(seq, "seq");
        Intrinsics.checkNotNullParameter(os, "os");
        Intrinsics.checkNotNullParameter(deviceModel, "deviceModel");
        Intrinsics.checkNotNullParameter(deviceName, "deviceName");
        Intrinsics.checkNotNullParameter(addDate, "addDate");
        return new DeviceInfo(seq, os, deviceModel, deviceName, addDate);
    }

    public String toString() {
        return "DeviceInfo(seq=" + this.seq + ", os=" + this.os + ", deviceModel=" + this.deviceModel + ", deviceName=" + this.deviceName + ", addDate=" + this.addDate + ')';
    }

    public DeviceInfo(String seq, String os, String deviceModel, String deviceName, String addDate) {
        Intrinsics.checkNotNullParameter(seq, "seq");
        Intrinsics.checkNotNullParameter(os, "os");
        Intrinsics.checkNotNullParameter(deviceModel, "deviceModel");
        Intrinsics.checkNotNullParameter(deviceName, "deviceName");
        Intrinsics.checkNotNullParameter(addDate, "addDate");
        this.seq = seq;
        this.os = os;
        this.deviceModel = deviceModel;
        this.deviceName = deviceName;
        this.addDate = addDate;
    }

    public final String getSeq() {
        return this.seq;
    }

    public final String getOs() {
        return this.os;
    }

    public final String getDeviceModel() {
        return this.deviceModel;
    }

    public final String getDeviceName() {
        return this.deviceName;
    }

    public final String getAddDate() {
        return this.addDate;
    }

    public final void setAddDate(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.addDate = str;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public DeviceInfo(JSONObject jsonObject) throws JSONException {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        String strOptString = jsonObject.optString("seq");
        Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
        String strOptString2 = jsonObject.optString("os");
        Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
        String strOptString3 = jsonObject.optString("device_model");
        Intrinsics.checkNotNullExpressionValue(strOptString3, "optString(...)");
        String strOptString4 = jsonObject.optString("device_name");
        Intrinsics.checkNotNullExpressionValue(strOptString4, "optString(...)");
        String strOptString5 = jsonObject.optString("add_date");
        Intrinsics.checkNotNullExpressionValue(strOptString5, "optString(...)");
        this(strOptString, strOptString2, strOptString3, strOptString4, strOptString5);
    }

    public boolean equals(Object other) {
        if (other instanceof DeviceInfo) {
            return Intrinsics.areEqual(this.seq, ((DeviceInfo) other).seq);
        }
        return false;
    }

    public int hashCode() {
        return this.seq.hashCode();
    }

    @Override // java.lang.Comparable
    public int compareTo(DeviceInfo other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return this.addDate.compareTo(other.addDate);
    }
}
