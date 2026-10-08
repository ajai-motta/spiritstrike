package com.hive;

import androidx.core.app.NotificationCompat;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.hive.base.DataModel;
import com.hive.logger.LoggerImpl;
import com.hive.push.PushImpl;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001:\u0006#$%&'(B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0012H\u0007J\u001a\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\f\u001a\u00020\u0012H\u0007J\u0018\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\f\u001a\u00020\u0019H\u0007J\u0010\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J$\u0010\u001d\u001a\u00020\u000b2\u001a\u0010\u001e\u001a\u0016\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001fj\n\u0012\u0004\u0012\u00020\u001c\u0018\u0001` H\u0007J\b\u0010!\u001a\u00020\u000bH\u0007J\b\u0010\"\u001a\u00020\u000bH\u0007R$\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\t¨\u0006)"}, d2 = {"Lcom/hive/Push;", "", "<init>", "()V", "TAG", "", "kotlin.jvm.PlatformType", "getTAG$annotations", "getTAG", "()Ljava/lang/String;", "getForegroundPush", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/Push$PushSettingListener;", "setForegroundPush", "pushSetting", "Lcom/hive/Push$PushSetting;", "getRemotePush", "Lcom/hive/Push$RemotePushListener;", "setRemotePush", "remotePush", "Lcom/hive/Push$RemotePush;", "registerLocalPush", "localPush", "Lcom/hive/Push$LocalPush;", "Lcom/hive/Push$LocalPushListener;", "unregisterLocalPush", "noticeID", "", "unregisterLocalPushes", "noticeIDs", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "unregisterAllLocalPushes", "requestPushPermission", "PushSettingListener", "RemotePushListener", "LocalPushListener", "RemotePush", "PushSetting", "LocalPush", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Push {
    public static final Push INSTANCE = new Push();
    private static final String TAG = "Push";

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, d2 = {"Lcom/hive/Push$LocalPushListener;", "", "onRegisterLocalPush", "", "result", "Lcom/hive/ResultAPI;", "localPush", "Lcom/hive/Push$LocalPush;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface LocalPushListener {
        void onRegisterLocalPush(ResultAPI result, LocalPush localPush);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0007R\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/hive/Push$PushSetting;", "Lcom/hive/base/DataModel;", "<init>", "()V", "remotePushEnabledWhileRunning", "", "localPushEnabledWhileRunning", "(ZZ)V", "isLocalPushEnabledWhileRunning", "()Z", "setLocalPushEnabledWhileRunning", "(Z)V", "isRemotePushEnabledWhileRunning", "setRemotePushEnabledWhileRunning", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PushSetting extends DataModel {
        private boolean isLocalPushEnabledWhileRunning;
        private boolean isRemotePushEnabledWhileRunning;

        public PushSetting() {
        }

        /* JADX INFO: renamed from: isLocalPushEnabledWhileRunning, reason: from getter */
        public final boolean getIsLocalPushEnabledWhileRunning() {
            return this.isLocalPushEnabledWhileRunning;
        }

        /* JADX INFO: renamed from: isRemotePushEnabledWhileRunning, reason: from getter */
        public final boolean getIsRemotePushEnabledWhileRunning() {
            return this.isRemotePushEnabledWhileRunning;
        }

        public final void setLocalPushEnabledWhileRunning(boolean z) {
            this.isLocalPushEnabledWhileRunning = z;
        }

        public final void setRemotePushEnabledWhileRunning(boolean z) {
            this.isRemotePushEnabledWhileRunning = z;
        }

        public PushSetting(boolean z, boolean z2) {
            this.isLocalPushEnabledWhileRunning = z2;
            this.isRemotePushEnabledWhileRunning = z;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, d2 = {"Lcom/hive/Push$PushSettingListener;", "", "onPushSetting", "", "result", "Lcom/hive/ResultAPI;", "pushSetting", "Lcom/hive/Push$PushSetting;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface PushSettingListener {
        void onPushSetting(ResultAPI result, PushSetting pushSetting);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, d2 = {"Lcom/hive/Push$RemotePushListener;", "", "onPushToken", "", "result", "Lcom/hive/ResultAPI;", "remotePush", "Lcom/hive/Push$RemotePush;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface RemotePushListener {
        void onPushToken(ResultAPI result, RemotePush remotePush);
    }

    private Push() {
    }

    @JvmStatic
    public static final void getForegroundPush(PushSettingListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("listener = %s", Arrays.copyOf(new Object[]{listener}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        PushImpl.INSTANCE.getForegroundPush(listener);
        loggerImpl.apiReturnLog(str2, "");
    }

    @JvmStatic
    public static final void getRemotePush(RemotePushListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("listener = %s", Arrays.copyOf(new Object[]{listener}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        PushImpl.INSTANCE.getRemotePush(listener);
        loggerImpl.apiReturnLog(str2, "");
    }

    public static final String getTAG() {
        return TAG;
    }

    @JvmStatic
    public static /* synthetic */ void getTAG$annotations() {
    }

    @JvmStatic
    public static final void registerLocalPush(LocalPush localPush, LocalPushListener listener) {
        Intrinsics.checkNotNullParameter(localPush, "localPush");
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("localPush = %s, listener = %s", Arrays.copyOf(new Object[]{localPush.toString(), listener}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        PushImpl.INSTANCE.registerLocalPush(localPush, listener);
        loggerImpl.apiReturnLog(str2, "");
    }

    @JvmStatic
    public static final void requestPushPermission() {
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str = TAG;
        loggerImpl.apiCalledLog(str, "");
        PushImpl.INSTANCE.requestPushPermission();
        loggerImpl.apiReturnLog(str, "");
    }

    @JvmStatic
    public static final void setForegroundPush(PushSetting pushSetting, PushSettingListener listener) {
        Intrinsics.checkNotNullParameter(pushSetting, "pushSetting");
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("pushSetting = %s, listener = %s", Arrays.copyOf(new Object[]{pushSetting.toString(), listener}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        PushImpl.INSTANCE.setForegroundPush(pushSetting, listener);
        loggerImpl.apiReturnLog(str2, "");
    }

    @JvmStatic
    public static final void setRemotePush(RemotePush remotePush, RemotePushListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("pushToken = %s, listener = %s", Arrays.copyOf(new Object[]{remotePush != null ? remotePush.toString() : null, listener}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        PushImpl.INSTANCE.setRemotePush(remotePush, listener);
        loggerImpl.apiReturnLog(str2, "");
    }

    @JvmStatic
    public static final void unregisterAllLocalPushes() {
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str = TAG;
        loggerImpl.apiCalledLog(str, "");
        PushImpl.INSTANCE.unregisterAllLocalPush();
        loggerImpl.apiReturnLog(str, "");
    }

    @JvmStatic
    public static final void unregisterLocalPush(int noticeID) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("localPush = %s", Arrays.copyOf(new Object[]{Integer.valueOf(noticeID)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        PushImpl.INSTANCE.unregisterLocalPush(noticeID);
        loggerImpl.apiReturnLog(str2, "");
    }

    @JvmStatic
    public static final void unregisterLocalPushes(ArrayList<Integer> noticeIDs) {
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str = TAG;
        loggerImpl.apiCalledLog(str, "");
        PushImpl.INSTANCE.unregisterLocalPushes(noticeIDs);
        loggerImpl.apiReturnLog(str, "");
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0007R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\b\"\u0004\b\u000b\u0010\n¨\u0006\f"}, d2 = {"Lcom/hive/Push$RemotePush;", "Lcom/hive/base/DataModel;", "<init>", "()V", "isAgreeNotice", "", "isAgreeNight", "(ZZ)V", "()Z", "setAgreeNotice", "(Z)V", "setAgreeNight", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class RemotePush extends DataModel {
        private boolean isAgreeNight;
        private boolean isAgreeNotice;

        public RemotePush() {
            this.isAgreeNotice = true;
        }

        /* JADX INFO: renamed from: isAgreeNight, reason: from getter */
        public final boolean getIsAgreeNight() {
            return this.isAgreeNight;
        }

        /* JADX INFO: renamed from: isAgreeNotice, reason: from getter */
        public final boolean getIsAgreeNotice() {
            return this.isAgreeNotice;
        }

        public final void setAgreeNight(boolean z) {
            this.isAgreeNight = z;
        }

        public final void setAgreeNotice(boolean z) {
            this.isAgreeNotice = z;
        }

        public RemotePush(boolean z, boolean z2) {
            this.isAgreeNotice = z;
            this.isAgreeNight = z2;
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b)\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 C2\u00020\u00012\u00020\u0002:\u0001CB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\u0000J\u000e\u0010>\u001a\u00020?2\u0006\u0010A\u001a\u00020BR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R\u001a\u0010\u001d\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000e\"\u0004\b\u001f\u0010\u0010R\u001a\u0010 \u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u000e\"\u0004\b\"\u0010\u0010R\u001a\u0010#\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u000e\"\u0004\b%\u0010\u0010R\u001a\u0010&\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u000e\"\u0004\b(\u0010\u0010R\u001a\u0010)\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u000e\"\u0004\b+\u0010\u0010R\u001a\u0010,\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u000e\"\u0004\b.\u0010\u0010R\u001a\u0010/\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u000e\"\u0004\b1\u0010\u0010R\u001a\u00102\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\b\"\u0004\b4\u0010\nR\u001a\u00105\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\b\"\u0004\b7\u0010\nR\u001a\u00108\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u000e\"\u0004\b:\u0010\u0010R\u001a\u0010;\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u000e\"\u0004\b=\u0010\u0010¨\u0006D"}, d2 = {"Lcom/hive/Push$LocalPush;", "Lcom/hive/base/DataModel;", "Ljava/io/Serializable;", "<init>", "()V", "noticeID", "", "getNoticeID", "()I", "setNoticeID", "(I)V", "title", "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", NotificationCompat.CATEGORY_MESSAGE, "getMsg", "setMsg", TtmlNode.ANNOTATION_POSITION_AFTER, "", "getAfter", "()J", "setAfter", "(J)V", "groupId", "getGroupId", "setGroupId", "bigmsg", "getBigmsg", "setBigmsg", "ticker", "getTicker", "setTicker", "type", "getType", "setType", "icon", "getIcon", "setIcon", "sound", "getSound", "setSound", AppMeasurementSdk.ConditionalUserProperty.ACTIVE, "getActive", "setActive", "broadcastAction", "getBroadcastAction", "setBroadcastAction", "buckettype", "getBuckettype", "setBuckettype", "bucketsize", "getBucketsize", "setBucketsize", "bigpicture", "getBigpicture", "setBigpicture", "icon_color", "getIcon_color", "setIcon_color", "setData", "", "localPush", "jsonPushData", "Lorg/json/JSONObject;", k.M, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static class LocalPush extends DataModel implements Serializable {
        private static final long serialVersionUID = 6567070215768967L;
        private long after;
        private int buckettype;
        private int noticeID;
        private String title = "";
        private String msg = "";
        private String groupId = "";
        private String bigmsg = "";
        private String ticker = "";
        private String type = "";
        private String icon = "";
        private String sound = "";
        private String active = "";
        private String broadcastAction = "";
        private int bucketsize = 6;
        private String bigpicture = "";
        private String icon_color = "";

        public final String getActive() {
            return this.active;
        }

        public final long getAfter() {
            return this.after;
        }

        public final String getBigmsg() {
            return this.bigmsg;
        }

        public final String getBigpicture() {
            return this.bigpicture;
        }

        public final String getBroadcastAction() {
            return this.broadcastAction;
        }

        public final int getBucketsize() {
            return this.bucketsize;
        }

        public final int getBuckettype() {
            return this.buckettype;
        }

        public final String getGroupId() {
            return this.groupId;
        }

        public final String getIcon() {
            return this.icon;
        }

        public final String getIcon_color() {
            return this.icon_color;
        }

        public final String getMsg() {
            return this.msg;
        }

        public final int getNoticeID() {
            return this.noticeID;
        }

        public final String getSound() {
            return this.sound;
        }

        public final String getTicker() {
            return this.ticker;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getType() {
            return this.type;
        }

        public final void setActive(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.active = str;
        }

        public final void setAfter(long j) {
            this.after = j;
        }

        public final void setBigmsg(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.bigmsg = str;
        }

        public final void setBigpicture(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.bigpicture = str;
        }

        public final void setBroadcastAction(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.broadcastAction = str;
        }

        public final void setBucketsize(int i) {
            this.bucketsize = i;
        }

        public final void setBuckettype(int i) {
            this.buckettype = i;
        }

        public final void setData(LocalPush localPush) {
            Intrinsics.checkNotNullParameter(localPush, "localPush");
            this.noticeID = localPush.noticeID;
            this.title = localPush.title;
            this.msg = localPush.msg;
            this.after = localPush.after;
            this.groupId = localPush.groupId;
            this.bigmsg = localPush.bigmsg;
            this.ticker = localPush.ticker;
            this.type = localPush.type;
            this.icon = localPush.icon;
            this.sound = localPush.sound;
            this.active = localPush.active;
            this.broadcastAction = localPush.broadcastAction;
            this.buckettype = localPush.buckettype;
            this.bucketsize = localPush.bucketsize;
            this.bigpicture = localPush.bigpicture;
            this.icon_color = localPush.icon_color;
        }

        public final void setGroupId(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.groupId = str;
        }

        public final void setIcon(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.icon = str;
        }

        public final void setIcon_color(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.icon_color = str;
        }

        public final void setMsg(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.msg = str;
        }

        public final void setNoticeID(int i) {
            this.noticeID = i;
        }

        public final void setSound(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.sound = str;
        }

        public final void setTicker(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.ticker = str;
        }

        public final void setTitle(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.title = str;
        }

        public final void setType(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.type = str;
        }

        public final void setData(JSONObject jsonPushData) {
            Intrinsics.checkNotNullParameter(jsonPushData, "jsonPushData");
            this.noticeID = jsonPushData.optInt("noticeID");
            String strOptString = jsonPushData.optString("title");
            Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
            this.title = strOptString;
            String strOptString2 = jsonPushData.optString(NotificationCompat.CATEGORY_MESSAGE);
            Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
            this.msg = strOptString2;
            this.after = jsonPushData.optLong(TtmlNode.ANNOTATION_POSITION_AFTER, 0L);
            String strOptString3 = jsonPushData.optString("groupId");
            Intrinsics.checkNotNullExpressionValue(strOptString3, "optString(...)");
            this.groupId = strOptString3;
            String strOptString4 = jsonPushData.optString("bigmsg");
            Intrinsics.checkNotNullExpressionValue(strOptString4, "optString(...)");
            this.bigmsg = strOptString4;
            String strOptString5 = jsonPushData.optString("ticker");
            Intrinsics.checkNotNullExpressionValue(strOptString5, "optString(...)");
            this.ticker = strOptString5;
            String strOptString6 = jsonPushData.optString("type");
            Intrinsics.checkNotNullExpressionValue(strOptString6, "optString(...)");
            this.type = strOptString6;
            String strOptString7 = jsonPushData.optString("icon");
            Intrinsics.checkNotNullExpressionValue(strOptString7, "optString(...)");
            this.icon = strOptString7;
            String strOptString8 = jsonPushData.optString("sound");
            Intrinsics.checkNotNullExpressionValue(strOptString8, "optString(...)");
            this.sound = strOptString8;
            String strOptString9 = jsonPushData.optString(AppMeasurementSdk.ConditionalUserProperty.ACTIVE);
            Intrinsics.checkNotNullExpressionValue(strOptString9, "optString(...)");
            this.active = strOptString9;
            String strOptString10 = jsonPushData.optString("broadcastAction");
            Intrinsics.checkNotNullExpressionValue(strOptString10, "optString(...)");
            this.broadcastAction = strOptString10;
            this.buckettype = jsonPushData.optInt("buckettype", 0);
            this.bucketsize = jsonPushData.optInt("bucketsize", 6);
            String strOptString11 = jsonPushData.optString("bigpicture");
            Intrinsics.checkNotNullExpressionValue(strOptString11, "optString(...)");
            this.bigpicture = strOptString11;
            String strOptString12 = jsonPushData.optString("icon_color");
            Intrinsics.checkNotNullExpressionValue(strOptString12, "optString(...)");
            this.icon_color = strOptString12;
        }
    }
}
