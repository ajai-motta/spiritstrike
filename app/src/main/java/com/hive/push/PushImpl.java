package com.hive.push;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.adjust.sdk.Constants;
import com.adxcorp.util.ADXLogUtil;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.messaging.FirebaseMessaging;
import com.hive.HiveActivity;
import com.hive.Push;
import com.hive.ResultAPI;
import com.hive.base.Android;
import com.hive.base.Property;
import com.hive.configuration.ConfigurationImpl;
import com.hive.logger.LoggerImpl;
import com.hive.push.local.provider.LocalPushProviderAdapter;
import com.hive.standalone.HiveLifecycle;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridgeBase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001d\bÆ\u0002\u0018\u00002\u00020\u0001:\u0005cdefgB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0000¢\u0006\u0002\b\u0016J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0006J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\u001b\u001a\u00020\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ\u001d\u0010\u001e\u001a\u00020\u00182\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010 H\u0007¢\u0006\u0002\u0010!J\u0006\u0010\"\u001a\u00020\u0018J\u0006\u0010#\u001a\u00020\u0018J\u0006\u0010$\u001a\u00020\u0018J\u0006\u0010%\u001a\u00020\u0018J\u0018\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*J\u0018\u0010+\u001a\u00020\u00182\u0006\u0010'\u001a\u00020(2\b\u0010,\u001a\u0004\u0018\u00010-J\u000e\u0010.\u001a\u00020\u00182\u0006\u0010'\u001a\u00020(J\u000e\u0010/\u001a\u00020\u00182\u0006\u0010'\u001a\u00020(J\u000e\u00100\u001a\u00020\u00182\u0006\u0010'\u001a\u00020(J\u000e\u00101\u001a\u00020\u00182\u0006\u0010'\u001a\u00020(J\u000e\u00102\u001a\u00020\u00182\u0006\u0010'\u001a\u00020(J\u0018\u00103\u001a\u00020\u00182\u0006\u00104\u001a\u0002052\b\u0010\u0019\u001a\u0004\u0018\u000106J\u0010\u00107\u001a\u00020\u00182\b\u00108\u001a\u0004\u0018\u000109J\u000e\u00107\u001a\u0002052\u0006\u0010:\u001a\u00020;J\u001a\u0010<\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u0001062\b\u00108\u001a\u0004\u0018\u000109J\u001a\u0010=\u001a\u00020\u00182\b\u0010>\u001a\u0004\u0018\u0001062\u0006\u0010?\u001a\u00020\u0013H\u0002J\u0010\u0010@\u001a\u00020\u00182\b\u00108\u001a\u0004\u0018\u00010AJ\u0018\u0010B\u001a\u00020\u00182\u0006\u0010C\u001a\u00020D2\b\u00108\u001a\u0004\u0018\u00010AJ\u001a\u0010E\u001a\u00020\u00182\b\u0010F\u001a\u0004\u0018\u00010G2\b\u00108\u001a\u0004\u0018\u00010HJ\u000e\u0010I\u001a\u00020\u00182\u0006\u0010J\u001a\u00020KJ\"\u0010L\u001a\u00020\u00182\u001a\u0010M\u001a\u0016\u0012\u0004\u0012\u00020K\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020K\u0018\u0001`\u0007J\u0006\u0010N\u001a\u00020\u0018J\u0006\u0010O\u001a\u00020\u0018J\b\u0010P\u001a\u0004\u0018\u00010\u0013J\u000e\u0010Q\u001a\u00020\u00182\u0006\u0010R\u001a\u00020KJ\u0006\u0010S\u001a\u00020KJ\u000e\u0010T\u001a\u00020\u00182\u0006\u0010U\u001a\u00020KJ\u0006\u0010V\u001a\u00020KJ\u000e\u0010W\u001a\u00020\u00182\u0006\u0010X\u001a\u00020KJ\u0006\u0010Y\u001a\u00020KJ\u0010\u0010Z\u001a\u00020\u00182\b\u0010[\u001a\u0004\u0018\u00010\tJ\u000e\u0010\\\u001a\u00020\u00182\u0006\u0010]\u001a\u000205J\u000e\u0010^\u001a\u00020\u00182\u0006\u0010]\u001a\u000205J\u000e\u0010_\u001a\u00020\u00182\u0006\u0010]\u001a\u000205J\u0006\u0010`\u001a\u00020KJ\u0006\u0010a\u001a\u00020KJ\u0010\u0010b\u001a\u00020\u00182\b\u0010[\u001a\u0004\u0018\u00010\tR\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006h"}, d2 = {"Lcom/hive/push/PushImpl;", "", "<init>", "()V", "remotePushList", "Ljava/util/ArrayList;", "Lcom/hive/push/BaseRemotePush;", "Lkotlin/collections/ArrayList;", "c2sPushCallback", "Lcom/hive/push/PushImpl$PushCallback;", "getC2sPushCallback", "()Lcom/hive/push/PushImpl$PushCallback;", "setC2sPushCallback", "(Lcom/hive/push/PushImpl$PushCallback;)V", "supervisorJob", "Lkotlinx/coroutines/CompletableJob;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getRegisterdId", "", "remotePushType", "Lcom/hive/push/PushImpl$RemotePushType;", "getRegisterdId$hive_service_release", "addRemotePushInstance", "", "remotePush", "getRemotePushInstance", MobileAdsBridgeBase.initializeMethodName, "cachedAccount", "Lcom/hive/standalone/HiveLifecycle$HiveAccount;", "setSenderIDs", "userSenderIDs", "", "([Ljava/lang/String;)V", "onLogin", "onLogout", "onUpdateGameLanguage", "onUpdateServerId", "onCreate", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "Landroid/content/Intent;", "onStart", "onResume", "onPause", "onStop", "onDestroy", "onAgreement", "showed", "", "Lcom/hive/Push$RemotePush;", "getRemotePush", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/Push$RemotePushListener;", "infoType", "Lcom/hive/push/PushImpl$RemotePushInfoType;", "setRemotePush", "innerSetRemotePush", "remotePushSetting", "logMessage", "getForegroundPush", "Lcom/hive/Push$PushSettingListener;", "setForegroundPush", "pushSetting", "Lcom/hive/Push$PushSetting;", "registerLocalPush", "localPush", "Lcom/hive/Push$LocalPush;", "Lcom/hive/Push$LocalPushListener;", "unregisterLocalPush", "noticeID", "", "unregisterLocalPushes", "noticeIDs", "unregisterAllLocalPush", "requestPushPermission", "getRegistrationId", "setPush", Constants.PUSH, "getPush", "setSound", "sound", "getSound", "setVib", "vib", "getVib", "sendPushCallback", "pushCallback", "setOperationOnRunning", "isOn", "setOperationLocalPushOnRunning", "setOperationRemotePushOnRunning", "getOperationLocalPushOnRunning", "getOperationRemotePushOnRunning", "setC2SPushCallback", "LocalPushType", "RemotePushType", "RemotePushInfoType", "UsePushType", "PushCallback", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PushImpl {
    private static PushCallback c2sPushCallback;
    private static final CoroutineScope scope;
    private static final CompletableJob supervisorJob;
    public static final PushImpl INSTANCE = new PushImpl();
    private static final ArrayList<BaseRemotePush> remotePushList = new ArrayList<>();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/hive/push/PushImpl$LocalPushType;", "", "<init>", "(Ljava/lang/String;I)V", "ANDROID_DEFAULT", "FACEBOOK_APP2USER", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LocalPushType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ LocalPushType[] $VALUES;
        public static final LocalPushType ANDROID_DEFAULT = new LocalPushType("ANDROID_DEFAULT", 0);
        public static final LocalPushType FACEBOOK_APP2USER = new LocalPushType("FACEBOOK_APP2USER", 1);

        private static final /* synthetic */ LocalPushType[] $values() {
            return new LocalPushType[]{ANDROID_DEFAULT, FACEBOOK_APP2USER};
        }

        static {
            LocalPushType[] localPushTypeArr$values = $values();
            $VALUES = localPushTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(localPushTypeArr$values);
        }

        private LocalPushType(String str, int i) {
        }

        public static EnumEntries<LocalPushType> getEntries() {
            return $ENTRIES;
        }

        public static LocalPushType valueOf(String str) {
            return (LocalPushType) Enum.valueOf(LocalPushType.class, str);
        }

        public static LocalPushType[] values() {
            return (LocalPushType[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\b"}, d2 = {"Lcom/hive/push/PushImpl$PushCallback;", "", "onReceivedGCMPush", "", "pushID", "", "remainPushCallback", "onReceivedLocalPush", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface PushCallback {
        void onReceivedGCMPush(int pushID, int remainPushCallback);

        void onReceivedLocalPush(int pushID, int remainPushCallback);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/hive/push/PushImpl$RemotePushInfoType;", "", "<init>", "(Ljava/lang/String;I)V", "Notice", "Night", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class RemotePushInfoType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ RemotePushInfoType[] $VALUES;
        public static final RemotePushInfoType Notice = new RemotePushInfoType("Notice", 0);
        public static final RemotePushInfoType Night = new RemotePushInfoType("Night", 1);

        private static final /* synthetic */ RemotePushInfoType[] $values() {
            return new RemotePushInfoType[]{Notice, Night};
        }

        static {
            RemotePushInfoType[] remotePushInfoTypeArr$values = $values();
            $VALUES = remotePushInfoTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(remotePushInfoTypeArr$values);
        }

        private RemotePushInfoType(String str, int i) {
        }

        public static EnumEntries<RemotePushInfoType> getEntries() {
            return $ENTRIES;
        }

        public static RemotePushInfoType valueOf(String str) {
            return (RemotePushInfoType) Enum.valueOf(RemotePushInfoType.class, str);
        }

        public static RemotePushInfoType[] values() {
            return (RemotePushInfoType[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/hive/push/PushImpl$RemotePushType;", "", "<init>", "(Ljava/lang/String;I)V", FirebaseMessaging.INSTANCE_ID_SCOPE, "ADM", "FA2U", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class RemotePushType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ RemotePushType[] $VALUES;
        public static final RemotePushType FCM = new RemotePushType(FirebaseMessaging.INSTANCE_ID_SCOPE, 0);
        public static final RemotePushType ADM = new RemotePushType("ADM", 1);
        public static final RemotePushType FA2U = new RemotePushType("FA2U", 2);

        private static final /* synthetic */ RemotePushType[] $values() {
            return new RemotePushType[]{FCM, ADM, FA2U};
        }

        static {
            RemotePushType[] remotePushTypeArr$values = $values();
            $VALUES = remotePushTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(remotePushTypeArr$values);
        }

        private RemotePushType(String str, int i) {
        }

        public static EnumEntries<RemotePushType> getEntries() {
            return $ENTRIES;
        }

        public static RemotePushType valueOf(String str) {
            return (RemotePushType) Enum.valueOf(RemotePushType.class, str);
        }

        public static RemotePushType[] values() {
            return (RemotePushType[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/hive/push/PushImpl$UsePushType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "USE_FALSE", "USE_TRUE", "USE_FALSE_FROM_C2S", "USE_TRUE_FROM_C2S", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class UsePushType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ UsePushType[] $VALUES;
        private final int value;
        public static final UsePushType USE_FALSE = new UsePushType("USE_FALSE", 0, 0);
        public static final UsePushType USE_TRUE = new UsePushType("USE_TRUE", 1, 1);
        public static final UsePushType USE_FALSE_FROM_C2S = new UsePushType("USE_FALSE_FROM_C2S", 2, 2);
        public static final UsePushType USE_TRUE_FROM_C2S = new UsePushType("USE_TRUE_FROM_C2S", 3, 3);

        private static final /* synthetic */ UsePushType[] $values() {
            return new UsePushType[]{USE_FALSE, USE_TRUE, USE_FALSE_FROM_C2S, USE_TRUE_FROM_C2S};
        }

        static {
            UsePushType[] usePushTypeArr$values = $values();
            $VALUES = usePushTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(usePushTypeArr$values);
        }

        private UsePushType(String str, int i, int i2) {
            this.value = i2;
        }

        public static EnumEntries<UsePushType> getEntries() {
            return $ENTRIES;
        }

        public static UsePushType valueOf(String str) {
            return (UsePushType) Enum.valueOf(UsePushType.class, str);
        }

        public static UsePushType[] values() {
            return (UsePushType[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[RemotePushType.values().length];
            try {
                iArr[RemotePushType.FCM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RemotePushType.ADM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RemotePushType.FA2U.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[RemotePushInfoType.values().length];
            try {
                iArr2[RemotePushInfoType.Notice.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[RemotePushInfoType.Night.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX INFO: renamed from: com.hive.push.PushImpl$registerLocalPush$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.push.PushImpl$registerLocalPush$1", f = "PushImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Push.LocalPushListener $listener;
        final /* synthetic */ Push.LocalPush $localPush;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Push.LocalPushListener localPushListener, Push.LocalPush localPush, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$listener = localPushListener;
            this.$localPush = localPush;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$listener, this.$localPush, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            String callMethodName = LoggerImpl.getCallMethodName(2);
            if (ConfigurationImpl.INSTANCE.getAgeGateU13(Android.HW_IDS_DEVICE_TOKEN)) {
                LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
                loggerImpl.i(Push.getTAG(), "[registerLocalPush] Push can't use because of age gate under 13 rule.");
                ResultAPI resultAPI = new ResultAPI(-7, ResultAPI.Code.PushAgeGateUnder13, "[registerLocalPush] Push can't use because of age gate under 13 rule.");
                loggerImpl.apiCallbackLog(Push.getTAG(), callMethodName, resultAPI.toString());
                Push.LocalPushListener localPushListener = this.$listener;
                if (localPushListener != null) {
                    localPushListener.onRegisterLocalPush(resultAPI, null);
                }
                return Unit.INSTANCE;
            }
            if (!HiveLifecycle.INSTANCE.isSdkSetup()) {
                Push.LocalPushListener localPushListener2 = this.$listener;
                if (localPushListener2 != null) {
                    localPushListener2.onRegisterLocalPush(new ResultAPI(-7, ResultAPI.Code.PushNotInitialized, ""), null);
                }
                return Unit.INSTANCE;
            }
            if (this.$localPush != null) {
                LocalPushProviderAdapter.INSTANCE.getInstance().registerLocalPush(this.$localPush, this.$listener);
                LoggerImpl.INSTANCE.apiCallbackLog(Push.getTAG(), callMethodName, new ResultAPI().toString());
                return Unit.INSTANCE;
            }
            LoggerImpl loggerImpl2 = LoggerImpl.INSTANCE;
            loggerImpl2.i(Push.getTAG(), "No LocalPush Data");
            ResultAPI resultAPI2 = new ResultAPI(-1, ResultAPI.Code.PushInvalidParamLocalPush, "No LocalPush Data");
            loggerImpl2.apiCallbackLog(Push.getTAG(), callMethodName, resultAPI2.toString());
            Push.LocalPushListener localPushListener3 = this.$listener;
            if (localPushListener3 != null) {
                localPushListener3.onRegisterLocalPush(resultAPI2, null);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.hive.push.PushImpl$unregisterAllLocalPush$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.push.PushImpl$unregisterAllLocalPush$1", f = "PushImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C29481 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public C29481(Continuation<? super C29481> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C29481(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
            loggerImpl.i(Push.getTAG(), "[unregisterAllLocalPush]");
            if (ConfigurationImpl.INSTANCE.getAgeGateU13(Android.HW_IDS_DEVICE_TOKEN)) {
                loggerImpl.i(Push.getTAG(), "[unregisterAllLocalPush] Push can't use because of age gate under 13 rule.");
                return Unit.INSTANCE;
            }
            LocalPushProviderAdapter.INSTANCE.getInstance().unregisterAllLocalPush();
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C29481) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.hive.push.PushImpl$unregisterLocalPush$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.push.PushImpl$unregisterLocalPush$1", f = "PushImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C29491 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $noticeID;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C29491(int i, Continuation<? super C29491> continuation) {
            super(2, continuation);
            this.$noticeID = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C29491(this.$noticeID, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
            loggerImpl.i(Push.getTAG(), "[unregisterLocalPush]");
            if (ConfigurationImpl.INSTANCE.getAgeGateU13(Android.HW_IDS_DEVICE_TOKEN)) {
                loggerImpl.i(Push.getTAG(), "[unregisterLocalPush] Push can't use because of age gate under 13 rule.");
                return Unit.INSTANCE;
            }
            LocalPushProviderAdapter.INSTANCE.getInstance().unregisterLocalPush(this.$noticeID);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C29491) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.hive.push.PushImpl$unregisterLocalPushes$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.push.PushImpl$unregisterLocalPushes$1", f = "PushImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C29501 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ArrayList<Integer> $noticeIDs;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C29501(ArrayList<Integer> arrayList, Continuation<? super C29501> continuation) {
            super(2, continuation);
            this.$noticeIDs = arrayList;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C29501(this.$noticeIDs, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
            loggerImpl.i(Push.getTAG(), "[unregisterLocalPushs]");
            if (ConfigurationImpl.INSTANCE.getAgeGateU13(Android.HW_IDS_DEVICE_TOKEN)) {
                loggerImpl.i(Push.getTAG(), "[unregisterLocalPushs] Push can't use because of age gate under 13 rule.");
                return Unit.INSTANCE;
            }
            LocalPushProviderAdapter.INSTANCE.getInstance().unregisterLocalPushes(this.$noticeIDs);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C29501) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    static {
        CompletableJob completableJobSupervisorJob$default = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null);
        supervisorJob = completableJobSupervisorJob$default;
        scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault().plus(completableJobSupervisorJob$default));
    }

    private PushImpl() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getRemotePush$lambda$1(Push.RemotePushListener remotePushListener, Push.RemotePush remotePush) {
        if (remotePushListener != null) {
            remotePushListener.onPushToken(new ResultAPI(), remotePush);
        }
    }

    private final void innerSetRemotePush(Push.RemotePush remotePushSetting, String logMessage) {
        if (remotePushSetting == null) {
            return;
        }
        Property.Companion companion = Property.INSTANCE;
        Property instance = companion.getINSTANCE();
        PushKeys pushKeys = PushKeys.INSTANCE;
        Property.setValue$default(instance, pushKeys.getIS_AGREE_NOTICE(), remotePushSetting.getIsAgreeNotice() ? "true" : "false", null, 4, null);
        Property.setValue$default(companion.getINSTANCE(), pushKeys.getIS_AGREE_NIGHT(), remotePushSetting.getIsAgreeNight() ? "true" : "false", null, 4, null);
        companion.getINSTANCE().writeProperties();
        Iterator<BaseRemotePush> it = remotePushList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            BaseRemotePush next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            next.registerToken(remotePushSetting, logMessage);
        }
    }

    public final void addRemotePushInstance(BaseRemotePush remotePush) {
        Intrinsics.checkNotNullParameter(remotePush, "remotePush");
        remotePushList.add(remotePush);
    }

    public final PushCallback getC2sPushCallback() {
        return c2sPushCallback;
    }

    public final void getForegroundPush(Push.PushSettingListener listener) {
        String callMethodName = LoggerImpl.getCallMethodName(2);
        if (ConfigurationImpl.INSTANCE.getAgeGateU13(Android.HW_IDS_DEVICE_TOKEN)) {
            LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
            loggerImpl.i(Push.getTAG(), "[getForegroundPush] Push can't use because of age gate under 13 rule.");
            ResultAPI resultAPI = new ResultAPI(-7, ResultAPI.Code.PushAgeGateUnder13, "[getForegroundPush] Push can't use because of age gate under 13 rule.");
            loggerImpl.apiCallbackLog(Push.getTAG(), callMethodName, resultAPI.toString());
            if (listener != null) {
                listener.onPushSetting(resultAPI, null);
                return;
            }
            return;
        }
        if (!HiveLifecycle.INSTANCE.isSdkSetup()) {
            if (listener != null) {
                listener.onPushSetting(new ResultAPI(-7, ResultAPI.Code.PushNotInitialized, ""), null);
                return;
            }
            return;
        }
        Property.Companion companion = Property.INSTANCE;
        Property instance = companion.getINSTANCE();
        PushKeys pushKeys = PushKeys.INSTANCE;
        Boolean boolValueOf = Boolean.valueOf(instance.getValue(pushKeys.getIS_REMOTE_ENABLED_ON_RUNNING(), "true"));
        Boolean boolValueOf2 = Boolean.valueOf(companion.getINSTANCE().getValue(pushKeys.getIS_LOCAL_ENABLED_ON_RUNNING(), "true"));
        Intrinsics.checkNotNull(boolValueOf);
        boolean zBooleanValue = boolValueOf.booleanValue();
        Intrinsics.checkNotNull(boolValueOf2);
        Push.PushSetting pushSetting = new Push.PushSetting(zBooleanValue, boolValueOf2.booleanValue());
        if (listener != null) {
            listener.onPushSetting(new ResultAPI(), pushSetting);
        }
    }

    public final int getOperationLocalPushOnRunning() {
        LoggerImpl.INSTANCE.i(Push.getTAG(), "[getOperationLocalPushOnRunning]");
        Property.Companion companion = Property.INSTANCE;
        Property instance = companion.getINSTANCE();
        PushKeys pushKeys = PushKeys.INSTANCE;
        String value = instance.getValue(pushKeys.getIS_LOCAL_ENABLED_ON_RUNNING());
        return (value == null || value.length() == 0 || StringsKt.equals$default(companion.getINSTANCE().getValue(pushKeys.getIS_LOCAL_ENABLED_ON_RUNNING()), "true", false, 2, null)) ? 1 : 0;
    }

    public final int getOperationRemotePushOnRunning() {
        LoggerImpl.INSTANCE.i(Push.getTAG(), "[getOperationRemotePushOnRunning]");
        Property.Companion companion = Property.INSTANCE;
        Property instance = companion.getINSTANCE();
        PushKeys pushKeys = PushKeys.INSTANCE;
        String value = instance.getValue(pushKeys.getIS_REMOTE_ENABLED_ON_RUNNING());
        return (value == null || value.length() == 0 || StringsKt.equals$default(companion.getINSTANCE().getValue(pushKeys.getIS_REMOTE_ENABLED_ON_RUNNING()), "true", false, 2, null)) ? 1 : 0;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final int getPush() {
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.i(Push.getTAG(), "[getPush]");
        Property.Companion companion = Property.INSTANCE;
        Property instance = companion.getINSTANCE();
        PushKeys pushKeys = PushKeys.INSTANCE;
        String value = instance.getValue(pushKeys.getUSE_PUSH());
        if (value == null || value.length() == 0) {
            return 1;
        }
        if (value != null) {
            switch (value.hashCode()) {
                case 48:
                    if (value.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                        loggerImpl.i(Push.getTAG(), "[getPush] save 0");
                        return UsePushType.USE_FALSE.getValue();
                    }
                    break;
                case 49:
                    if (value.equals("1")) {
                        loggerImpl.i(Push.getTAG(), "[getPush] save 1");
                        return UsePushType.USE_TRUE.getValue();
                    }
                    break;
                case 50:
                    if (value.equals("2")) {
                        loggerImpl.i(Push.getTAG(), "[getPush] save 0 (convert 2 to 0)");
                        Property instance2 = companion.getINSTANCE();
                        String use_push = pushKeys.getUSE_PUSH();
                        UsePushType usePushType = UsePushType.USE_FALSE;
                        Property.setValue$default(instance2, use_push, Integer.toString(usePushType.getValue()), null, 4, null);
                        companion.getINSTANCE().writeProperties();
                        return usePushType.getValue();
                    }
                    break;
            }
        }
        loggerImpl.i(Push.getTAG(), "[getPush] save 1 (convert other to 1)");
        Property instance3 = companion.getINSTANCE();
        String use_push2 = pushKeys.getUSE_PUSH();
        UsePushType usePushType2 = UsePushType.USE_TRUE;
        Property.setValue$default(instance3, use_push2, Integer.toString(usePushType2.getValue()), null, 4, null);
        companion.getINSTANCE().writeProperties();
        return usePushType2.getValue();
    }

    public final String getRegisterdId$hive_service_release(RemotePushType remotePushType) {
        Intrinsics.checkNotNullParameter(remotePushType, "remotePushType");
        int i = WhenMappings.$EnumSwitchMapping$0[remotePushType.ordinal()];
        if (i == 1) {
            return Property.INSTANCE.getINSTANCE().getValue(PushKeys.INSTANCE.getREGID_FCM(), "");
        }
        if (i == 2) {
            return Property.INSTANCE.getINSTANCE().getValue(PushKeys.INSTANCE.getREGID_AMAZON(), "");
        }
        if (i == 3) {
            return Property.INSTANCE.getINSTANCE().getValue(PushKeys.INSTANCE.getREGID_FACEBOOK(), "");
        }
        throw new NoWhenBranchMatchedException();
    }

    public final String getRegistrationId() {
        LoggerImpl.INSTANCE.i(Push.getTAG(), "[getRegistrationId]");
        return Property.INSTANCE.getINSTANCE().getValue(PushKeys.INSTANCE.getREGID_FCM());
    }

    public final void getRemotePush(final Push.RemotePushListener listener) {
        String callMethodName = LoggerImpl.getCallMethodName(2);
        if (ConfigurationImpl.INSTANCE.getAgeGateU13(Android.HW_IDS_DEVICE_TOKEN)) {
            LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
            loggerImpl.i(Push.getTAG(), "[getRemotePush] Push can't use because of age gate under 13 rule.");
            ResultAPI resultAPI = new ResultAPI(-7, ResultAPI.Code.PushAgeGateUnder13, "[getRemotePush] Push can't use because of age gate under 13 rule.");
            loggerImpl.apiCallbackLog(Push.getTAG(), callMethodName, resultAPI.toString());
            if (listener != null) {
                listener.onPushToken(resultAPI, null);
                return;
            }
            return;
        }
        if (!HiveLifecycle.INSTANCE.isSdkSetup()) {
            LoggerImpl loggerImpl2 = LoggerImpl.INSTANCE;
            loggerImpl2.i(Push.getTAG(), "[getRemotePush] Need to initialize or setup the SDK first.");
            ResultAPI resultAPI2 = new ResultAPI(-7, ResultAPI.Code.PushNotInitialized, "");
            loggerImpl2.apiCallbackLog(Push.getTAG(), callMethodName, resultAPI2.toString());
            if (listener != null) {
                listener.onPushToken(resultAPI2, null);
                return;
            }
            return;
        }
        Property.Companion companion = Property.INSTANCE;
        Property instance = companion.getINSTANCE();
        PushKeys pushKeys = PushKeys.INSTANCE;
        Boolean boolValueOf = Boolean.valueOf(instance.getValue(pushKeys.getIS_AGREE_NOTICE(), "false"));
        Boolean boolValueOf2 = Boolean.valueOf(companion.getINSTANCE().getValue(pushKeys.getIS_AGREE_NIGHT(), "false"));
        Intrinsics.checkNotNull(boolValueOf);
        boolean zBooleanValue = boolValueOf.booleanValue();
        Intrinsics.checkNotNull(boolValueOf2);
        final Push.RemotePush remotePush = new Push.RemotePush(zBooleanValue, boolValueOf2.booleanValue());
        LoggerImpl.INSTANCE.apiCallbackLog(Push.getTAG(), callMethodName, new ResultAPI().toString());
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.push.PushImpl$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                PushImpl.getRemotePush$lambda$1(listener, remotePush);
            }
        });
        Iterator<BaseRemotePush> it = remotePushList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            BaseRemotePush next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            BaseRemotePush baseRemotePush = next;
            if (baseRemotePush.getIsRequireSendToken()) {
                baseRemotePush.registerToken(null, "getPush");
            }
        }
    }

    public final BaseRemotePush getRemotePushInstance(RemotePushType remotePushType) {
        Object next;
        Intrinsics.checkNotNullParameter(remotePushType, "remotePushType");
        Iterator<T> it = remotePushList.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((BaseRemotePush) next).getRemotePushType() == remotePushType) {
                break;
            }
        }
        return (BaseRemotePush) next;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final int getSound() {
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.i(Push.getTAG(), "[getSound]");
        Property.Companion companion = Property.INSTANCE;
        Property instance = companion.getINSTANCE();
        PushKeys pushKeys = PushKeys.INSTANCE;
        String value = instance.getValue(pushKeys.getUSE_SOUND());
        if (value == null || value.length() == 0) {
            return 1;
        }
        if (value != null) {
            switch (value.hashCode()) {
                case 48:
                    if (value.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                        loggerImpl.i(Push.getTAG(), "[getSound] save 0");
                        return UsePushType.USE_FALSE.getValue();
                    }
                    break;
                case 49:
                    if (value.equals("1")) {
                        loggerImpl.i(Push.getTAG(), "[getSound] save 1");
                        return UsePushType.USE_TRUE.getValue();
                    }
                    break;
                case 50:
                    if (value.equals("2")) {
                        loggerImpl.i(Push.getTAG(), "[getSound] save 0 (convert 2 to 0)");
                        Property instance2 = companion.getINSTANCE();
                        String use_sound = pushKeys.getUSE_SOUND();
                        UsePushType usePushType = UsePushType.USE_FALSE;
                        Property.setValue$default(instance2, use_sound, Integer.toString(usePushType.getValue()), null, 4, null);
                        companion.getINSTANCE().writeProperties();
                        return usePushType.getValue();
                    }
                    break;
            }
        }
        loggerImpl.i(Push.getTAG(), "[getSound] save 1 (convert other to 1)");
        Property instance3 = companion.getINSTANCE();
        String use_sound2 = pushKeys.getUSE_SOUND();
        UsePushType usePushType2 = UsePushType.USE_TRUE;
        Property.setValue$default(instance3, use_sound2, Integer.toString(usePushType2.getValue()), null, 4, null);
        companion.getINSTANCE().writeProperties();
        return usePushType2.getValue();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final int getVib() {
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.i(Push.getTAG(), "[getVib]");
        Property.Companion companion = Property.INSTANCE;
        Property instance = companion.getINSTANCE();
        PushKeys pushKeys = PushKeys.INSTANCE;
        String value = instance.getValue(pushKeys.getUSE_VIB());
        if (value == null || value.length() == 0) {
            return 1;
        }
        if (value != null) {
            switch (value.hashCode()) {
                case 48:
                    if (value.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                        loggerImpl.i(Push.getTAG(), "[getVib] save 0");
                        return UsePushType.USE_FALSE.getValue();
                    }
                    break;
                case 49:
                    if (value.equals("1")) {
                        loggerImpl.i(Push.getTAG(), "[getVib] save 1");
                        return UsePushType.USE_TRUE.getValue();
                    }
                    break;
                case 50:
                    if (value.equals("2")) {
                        loggerImpl.i(Push.getTAG(), "[getVib] save 0 (convert 2 to 0)");
                        Property instance2 = companion.getINSTANCE();
                        String use_vib = pushKeys.getUSE_VIB();
                        UsePushType usePushType = UsePushType.USE_FALSE;
                        Property.setValue$default(instance2, use_vib, String.valueOf(usePushType.getValue()), null, 4, null);
                        companion.getINSTANCE().writeProperties();
                        return usePushType.getValue();
                    }
                    break;
            }
        }
        loggerImpl.i(Push.getTAG(), "[getVib] save 1 (convert other to 1)");
        Property instance3 = companion.getINSTANCE();
        String use_vib2 = pushKeys.getUSE_VIB();
        UsePushType usePushType2 = UsePushType.USE_TRUE;
        Property.setValue$default(instance3, use_vib2, String.valueOf(usePushType2.getValue()), null, 4, null);
        companion.getINSTANCE().writeProperties();
        return usePushType2.getValue();
    }

    public final void initialize(HiveLifecycle.HiveAccount cachedAccount) {
        LoggerImpl.INSTANCE.dL(Push.getTAG(), "[PushImpl::initialize] cachedAccount : " + cachedAccount);
        String callMethodName = LoggerImpl.getCallMethodName(2);
        NotificationRegister.createNotificationChannel$hive_service_release$default(NotificationRegister.INSTANCE, HiveActivity.INSTANCE.getRecentActivity(), null, null, null, 14, null);
        Iterator<BaseRemotePush> it = remotePushList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            BaseRemotePush next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            next.initialize(cachedAccount);
        }
        LoggerImpl.INSTANCE.apiCallbackLog(Push.getTAG(), callMethodName, ADXLogUtil.EVENT_LOAD_SUCCESS);
    }

    public final void onAgreement(boolean showed, Push.RemotePush remotePush) {
        LoggerImpl.INSTANCE.i(Push.getTAG(), "[onAgreement] showed : " + showed + ", remotePush : " + remotePush);
        if (remotePush == null) {
            return;
        }
        if (showed) {
            innerSetRemotePush(remotePush, "agreement");
        } else if (Intrinsics.areEqual(Property.INSTANCE.getINSTANCE().getValue(PushKeys.INSTANCE.getIS_AGREE_NOTICE(), "notFoundKey"), "notFoundKey")) {
            innerSetRemotePush(remotePush, "agreement");
        }
    }

    public final void onCreate(Activity activity, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Iterator<BaseRemotePush> it = remotePushList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            BaseRemotePush next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            next.onCreate(activity, savedInstanceState);
        }
    }

    public final void onDestroy(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Iterator<BaseRemotePush> it = remotePushList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            BaseRemotePush next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            next.onDestroy();
        }
    }

    public final void onLogin() {
        Iterator<BaseRemotePush> it = remotePushList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            BaseRemotePush next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            next.onLogin();
        }
    }

    public final void onLogout() {
        Iterator<BaseRemotePush> it = remotePushList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            BaseRemotePush next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            next.onLogout();
        }
    }

    public final void onNewIntent(Activity activity, Intent intent) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Iterator<BaseRemotePush> it = remotePushList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            BaseRemotePush next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            next.onNewIntent(activity, intent);
        }
    }

    public final void onPause(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Iterator<BaseRemotePush> it = remotePushList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            BaseRemotePush next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            next.onPause(activity);
        }
    }

    public final void onResume(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        PushConfig.INSTANCE.clearBadge(activity);
        Iterator<BaseRemotePush> it = remotePushList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            BaseRemotePush next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            next.onResume(activity);
        }
    }

    public final void onStart(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Iterator<BaseRemotePush> it = remotePushList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            BaseRemotePush next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            next.onStart(activity);
        }
    }

    public final void onStop(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Iterator<BaseRemotePush> it = remotePushList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            BaseRemotePush next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            next.onStop(activity);
        }
    }

    public final void onUpdateGameLanguage() {
        Iterator<BaseRemotePush> it = remotePushList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            BaseRemotePush next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            next.registerToken(null, "updateGameLanguage");
        }
    }

    public final void onUpdateServerId() {
        Iterator<BaseRemotePush> it = remotePushList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            BaseRemotePush next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            next.registerToken(null, "updateServerId");
        }
    }

    public final void registerLocalPush(Push.LocalPush localPush, Push.LocalPushListener listener) {
        BuildersKt__Builders_commonKt.launch$default(scope, null, null, new AnonymousClass1(listener, localPush, null), 3, null);
    }

    public final void requestPushPermission() {
        Object objM7415constructorimpl;
        if (Build.VERSION.SDK_INT >= 33) {
            HiveActivity hiveActivity = HiveActivity.INSTANCE;
            if (hiveActivity.getRecentActivity().getApplicationInfo().targetSdkVersion >= 33) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    hiveActivity.getRecentActivity().requestPermissions(new String[]{"android.permission.POST_NOTIFICATIONS"}, new Random().nextInt(65500));
                    objM7415constructorimpl = Result.m7415constructorimpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
                }
                Result.m7414boximpl(objM7415constructorimpl);
                return;
            }
        }
        NotificationRegister.createNotificationChannel$hive_service_release$default(NotificationRegister.INSTANCE, HiveActivity.INSTANCE.getRecentActivity(), null, null, null, 14, null);
    }

    public final void sendPushCallback(PushCallback pushCallback) {
        LoggerImpl.INSTANCE.i(Push.getTAG(), "[sendPushCallback]");
        PushConfig.INSTANCE.sendReceivedPushWithCallback$hive_service_release(pushCallback);
    }

    public final void setC2SPushCallback(PushCallback pushCallback) {
        LoggerImpl.INSTANCE.i(Push.getTAG(), "[setC2SPushCallback]");
        c2sPushCallback = pushCallback;
    }

    public final void setC2sPushCallback(PushCallback pushCallback) {
        c2sPushCallback = pushCallback;
    }

    public final void setForegroundPush(Push.PushSetting pushSetting, Push.PushSettingListener listener) {
        Intrinsics.checkNotNullParameter(pushSetting, "pushSetting");
        String callMethodName = LoggerImpl.getCallMethodName(2);
        if (ConfigurationImpl.INSTANCE.getAgeGateU13(Android.HW_IDS_DEVICE_TOKEN)) {
            LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
            loggerImpl.i(Push.getTAG(), "[setForegroundPush] Push can't use because of age gate under 13 rule.");
            ResultAPI resultAPI = new ResultAPI(-7, ResultAPI.Code.PushAgeGateUnder13, "[setForegroundPush] Push can't use because of age gate under 13 rule.");
            loggerImpl.apiCallbackLog(Push.getTAG(), callMethodName, resultAPI.toString());
            if (listener != null) {
                listener.onPushSetting(resultAPI, null);
                return;
            }
            return;
        }
        if (!HiveLifecycle.INSTANCE.isSdkSetup()) {
            if (listener != null) {
                listener.onPushSetting(new ResultAPI(-7, ResultAPI.Code.PushNotInitialized, ""), null);
                return;
            }
            return;
        }
        Property.Companion companion = Property.INSTANCE;
        Property instance = companion.getINSTANCE();
        PushKeys pushKeys = PushKeys.INSTANCE;
        Property.setValue$default(instance, pushKeys.getIS_REMOTE_ENABLED_ON_RUNNING(), Boolean.toString(pushSetting.getIsRemotePushEnabledWhileRunning()), null, 4, null);
        Property.setValue$default(companion.getINSTANCE(), pushKeys.getIS_LOCAL_ENABLED_ON_RUNNING(), Boolean.toString(pushSetting.getIsLocalPushEnabledWhileRunning()), null, 4, null);
        companion.getINSTANCE().writeProperties();
        getForegroundPush(listener);
    }

    public final void setOperationLocalPushOnRunning(boolean isOn) {
        LoggerImpl.INSTANCE.i(Push.getTAG(), "[setOperationLocalPushOnRunning] set value : " + isOn);
        if (isOn) {
            Property.setValue$default(Property.INSTANCE.getINSTANCE(), PushKeys.INSTANCE.getIS_LOCAL_ENABLED_ON_RUNNING(), "true", null, 4, null);
        } else {
            Property.setValue$default(Property.INSTANCE.getINSTANCE(), PushKeys.INSTANCE.getIS_LOCAL_ENABLED_ON_RUNNING(), "false", null, 4, null);
        }
    }

    public final void setOperationOnRunning(boolean isOn) {
        LoggerImpl.INSTANCE.i(Push.getTAG(), "[setOperationOnRunning] set value : " + isOn);
        if (isOn) {
            Property.Companion companion = Property.INSTANCE;
            Property instance = companion.getINSTANCE();
            PushKeys pushKeys = PushKeys.INSTANCE;
            Property.setValue$default(instance, pushKeys.getIS_REMOTE_ENABLED_ON_RUNNING(), "true", null, 4, null);
            Property.setValue$default(companion.getINSTANCE(), pushKeys.getIS_LOCAL_ENABLED_ON_RUNNING(), "true", null, 4, null);
            return;
        }
        Property.Companion companion2 = Property.INSTANCE;
        Property instance2 = companion2.getINSTANCE();
        PushKeys pushKeys2 = PushKeys.INSTANCE;
        Property.setValue$default(instance2, pushKeys2.getIS_REMOTE_ENABLED_ON_RUNNING(), "false", null, 4, null);
        Property.setValue$default(companion2.getINSTANCE(), pushKeys2.getIS_LOCAL_ENABLED_ON_RUNNING(), "false", null, 4, null);
    }

    public final void setOperationRemotePushOnRunning(boolean isOn) {
        LoggerImpl.INSTANCE.i(Push.getTAG(), "[setOperationRemotePushOnRunning] set value : " + isOn);
        if (isOn) {
            Property.setValue$default(Property.INSTANCE.getINSTANCE(), PushKeys.INSTANCE.getIS_REMOTE_ENABLED_ON_RUNNING(), "true", null, 4, null);
        } else {
            Property.setValue$default(Property.INSTANCE.getINSTANCE(), PushKeys.INSTANCE.getIS_REMOTE_ENABLED_ON_RUNNING(), "false", null, 4, null);
        }
    }

    public final void setPush(int push) {
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.i(Push.getTAG(), "[setPush] set value : " + push);
        UsePushType usePushType = UsePushType.USE_FALSE;
        if (push == usePushType.getValue() || push == UsePushType.USE_FALSE_FROM_C2S.getValue()) {
            loggerImpl.i(Push.getTAG(), "[setPush] set value, convert to 0");
            Property.setValue$default(Property.INSTANCE.getINSTANCE(), PushKeys.INSTANCE.getUSE_PUSH(), Integer.toString(usePushType.getValue()), null, 4, null);
        } else {
            loggerImpl.i(Push.getTAG(), "[setPush] set value, convert to 1");
            Property.setValue$default(Property.INSTANCE.getINSTANCE(), PushKeys.INSTANCE.getUSE_PUSH(), Integer.toString(UsePushType.USE_TRUE.getValue()), null, 4, null);
        }
        Property.INSTANCE.getINSTANCE().writeProperties();
    }

    public final void setRemotePush(Push.RemotePush remotePush, Push.RemotePushListener listener) {
        String callMethodName = LoggerImpl.getCallMethodName(2);
        if (ConfigurationImpl.INSTANCE.getAgeGateU13(Android.HW_IDS_DEVICE_TOKEN)) {
            LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
            loggerImpl.i(Push.getTAG(), "[setRemotePush] Push can't use because of age gate under 13 rule.");
            ResultAPI resultAPI = new ResultAPI(-7, ResultAPI.Code.PushAgeGateUnder13, "[setRemotePush] Push can't use because of age gate under 13 rule.");
            if (listener != null) {
                loggerImpl.apiCallbackLog(Push.getTAG(), callMethodName, resultAPI.toString());
                listener.onPushToken(resultAPI, null);
                return;
            }
            return;
        }
        if (!HiveLifecycle.INSTANCE.isSdkSetup()) {
            LoggerImpl loggerImpl2 = LoggerImpl.INSTANCE;
            loggerImpl2.i(Push.getTAG(), "[setRemotePush] Need to initialize or setup the SDK first.");
            ResultAPI resultAPI2 = new ResultAPI(-7, ResultAPI.Code.PushNotInitialized, "");
            if (listener != null) {
                loggerImpl2.apiCallbackLog(Push.getTAG(), callMethodName, resultAPI2.toString());
                listener.onPushToken(resultAPI2, null);
                return;
            }
            return;
        }
        if (remotePush != null) {
            innerSetRemotePush(remotePush, "setPush");
            if (listener != null) {
                listener.onPushToken(new ResultAPI(), remotePush);
                return;
            }
            return;
        }
        LoggerImpl loggerImpl3 = LoggerImpl.INSTANCE;
        loggerImpl3.i(Push.getTAG(), "[setRemotePush] No pushToken");
        ResultAPI resultAPI3 = new ResultAPI(-1, ResultAPI.Code.PushInvalidParamRemotePush, "Invalid Param (RemotePush)");
        if (listener != null) {
            loggerImpl3.apiCallbackLog(Push.getTAG(), callMethodName, resultAPI3.toString());
            listener.onPushToken(resultAPI3, remotePush);
        }
    }

    @Deprecated(message = "22.0.0")
    public final void setSenderIDs(String[] userSenderIDs) {
        LoggerImpl.INSTANCE.w(Push.getTAG(), "[setSenderIDs]");
    }

    public final void setSound(int sound) {
        LoggerImpl.INSTANCE.i(Push.getTAG(), "[setSound] set value : " + sound);
        if (sound == 0 || sound == 2) {
            Property.setValue$default(Property.INSTANCE.getINSTANCE(), PushKeys.INSTANCE.getUSE_SOUND(), String.valueOf(UsePushType.USE_FALSE.getValue()), null, 4, null);
        } else {
            Property.setValue$default(Property.INSTANCE.getINSTANCE(), PushKeys.INSTANCE.getUSE_SOUND(), String.valueOf(UsePushType.USE_TRUE.getValue()), null, 4, null);
        }
        Property.INSTANCE.getINSTANCE().writeProperties();
    }

    public final void setVib(int vib) {
        LoggerImpl.INSTANCE.i(Push.getTAG(), "[setVib] set value : " + vib);
        if (vib == 0 || vib == 2) {
            Property.setValue$default(Property.INSTANCE.getINSTANCE(), PushKeys.INSTANCE.getUSE_VIB(), String.valueOf(UsePushType.USE_FALSE.getValue()), null, 4, null);
        } else {
            Property.setValue$default(Property.INSTANCE.getINSTANCE(), PushKeys.INSTANCE.getUSE_VIB(), String.valueOf(UsePushType.USE_TRUE.getValue()), null, 4, null);
        }
        Property.INSTANCE.getINSTANCE().writeProperties();
    }

    public final void unregisterAllLocalPush() {
        BuildersKt__Builders_commonKt.launch$default(scope, null, null, new C29481(null), 3, null);
    }

    public final void unregisterLocalPush(int noticeID) {
        BuildersKt__Builders_commonKt.launch$default(scope, null, null, new C29491(noticeID, null), 3, null);
    }

    public final void unregisterLocalPushes(ArrayList<Integer> noticeIDs) {
        BuildersKt__Builders_commonKt.launch$default(scope, null, null, new C29501(noticeIDs, null), 3, null);
    }

    public final boolean getRemotePush(RemotePushInfoType infoType) {
        Intrinsics.checkNotNullParameter(infoType, "infoType");
        if (ConfigurationImpl.INSTANCE.getAgeGateU13(Android.HW_IDS_DEVICE_TOKEN)) {
            LoggerImpl.INSTANCE.i(Push.getTAG(), "[getRemotePush] Push can't use because of age gate under 13 rule.");
            return false;
        }
        if (!HiveLifecycle.INSTANCE.isSdkSetup()) {
            LoggerImpl.INSTANCE.i(Push.getTAG(), "[getRemotePush] Need to initialize or setup the SDK first.");
            return false;
        }
        Iterator<BaseRemotePush> it = remotePushList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            BaseRemotePush next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            BaseRemotePush baseRemotePush = next;
            if (baseRemotePush.getIsRequireSendToken()) {
                baseRemotePush.registerToken(null, "getPush");
            }
        }
        int i = WhenMappings.$EnumSwitchMapping$1[infoType.ordinal()];
        if (i == 1) {
            return Boolean.parseBoolean(Property.INSTANCE.getINSTANCE().getValue(PushKeys.INSTANCE.getIS_AGREE_NOTICE(), "false"));
        }
        if (i == 2) {
            return Boolean.parseBoolean(Property.INSTANCE.getINSTANCE().getValue(PushKeys.INSTANCE.getIS_AGREE_NIGHT(), "false"));
        }
        throw new NoWhenBranchMatchedException();
    }
}
