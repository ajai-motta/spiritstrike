package com.hive.analytics;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.Analytics;
import com.hive.HiveActivity;
import com.hive.ResultAPI;
import com.hive.analytics.provider.AnalyticsProviderAdapter;
import com.hive.analytics.provider.adjust.AnalyticsProviderAdjust;
import com.hive.authv4.AuthV4Keys;
import com.hive.base.Android;
import com.hive.base.Property;
import com.hive.core.Configuration;
import com.hive.core.HiveCoreInitializer;
import com.hive.core.HiveKeys;
import com.hive.core.Logger;
import com.hive.core.Platform;
import com.hive.core.Response;
import com.hive.core.StringUtil;
import com.hive.logger.LoggerImpl;
import com.hive.module.HiveModule;
import com.hive.module.HiveModuleManager;
import com.hive.module.interfaces.HiveAnalytics;
import com.hive.module.interfaces.analytics.ConsentMode;
import com.hive.standalone.HiveLifecycle;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridgeBase;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002z{B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u001e\u001a\u00020\u00162\b\u0010\u001f\u001a\u0004\u0018\u00010\u001d2\b\u0010 \u001a\u0004\u0018\u00010\u001dJ\u001a\u0010!\u001a\u00020\u001a2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020$0#J\u000e\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020%J\u0006\u0010&\u001a\u00020\u0016J\u000e\u0010'\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020%J\u0016\u0010(\u001a\u00020\u00162\u0006\u0010)\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020\u001aJ\u0006\u0010+\u001a\u00020\u0016J\u0006\u0010,\u001a\u00020\u0016J\u000e\u0010-\u001a\u00020\u00162\u0006\u0010.\u001a\u00020\u001dJ\u0016\u0010/\u001a\u00020\u00162\u0006\u0010.\u001a\u00020\u001d2\u0006\u00100\u001a\u00020%J\u000e\u00101\u001a\u00020\u00162\u0006\u00102\u001a\u000203J\u0018\u00101\u001a\u00020\u00162\u0006\u00102\u001a\u00020\u001d2\b\u00104\u001a\u0004\u0018\u00010\u001dJ\u000e\u00105\u001a\u00020\u00162\u0006\u00106\u001a\u000207J\u0016\u00105\u001a\u00020\u00162\u0006\u0010.\u001a\u00020\u001d2\u0006\u00106\u001a\u000207J\u000e\u00108\u001a\u00020\u00162\u0006\u00109\u001a\u00020:J\u000e\u0010;\u001a\u00020\u00162\u0006\u0010<\u001a\u00020%J&\u0010=\u001a\u00020\u00162\u0006\u0010>\u001a\u00020?2\u0016\b\u0002\u00100\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020$\u0018\u00010#J\u0016\u0010@\u001a\u00020\u00162\u0006\u0010>\u001a\u00020?2\u0006\u0010A\u001a\u000207J\b\u0010B\u001a\u00020\u0016H\u0002J\u000e\u0010C\u001a\u00020\u00162\u0006\u0010D\u001a\u00020\u001dJ\u0016\u0010E\u001a\u00020\u00162\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020GJ\u0006\u0010I\u001a\u00020\u0016J\u0016\u0010J\u001a\u00020\u00162\u0006\u0010K\u001a\u00020\u001d2\u0006\u0010L\u001a\u00020\u001dJ\u000e\u0010M\u001a\u00020\u00162\u0006\u0010N\u001a\u00020\u0015J\u0006\u0010O\u001a\u00020\u0016J$\u0010P\u001a\u00020\u00162\b\b\u0002\u0010Q\u001a\u00020G2\b\b\u0002\u0010R\u001a\u00020\u00052\b\b\u0002\u0010S\u001a\u00020\u0005J\u0010\u0010T\u001a\u00020\u00162\b\u0010U\u001a\u0004\u0018\u00010\u001dJ\u0010\u0010V\u001a\u00020\u00162\b\u0010W\u001a\u0004\u0018\u00010XJ\u0006\u0010Y\u001a\u00020\u0005J\u000e\u0010Z\u001a\u00020\u00162\u0006\u0010[\u001a\u00020\\J\u0010\u0010]\u001a\u00020\u00162\u0006\u0010[\u001a\u00020\\H\u0016J\u0018\u0010^\u001a\u00020\u00162\u0006\u0010[\u001a\u00020\\2\b\u0010W\u001a\u0004\u0018\u00010XJ\u0016\u0010_\u001a\u00020\u00162\u0006\u0010`\u001a\u00020\u001d2\u0006\u0010a\u001a\u00020\u001dJ\u0016\u0010b\u001a\u00020\u00162\u0006\u0010c\u001a\u00020d2\u0006\u0010W\u001a\u00020XJ\u000e\u0010e\u001a\u00020\u00162\u0006\u0010f\u001a\u00020\u001aJ\"\u0010g\u001a\u00020\u00162\u0006\u0010h\u001a\u00020\u001d2\u0012\u0010i\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d0jJ\b\u0010k\u001a\u00020\u0016H\u0002J\u001a\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d0j2\u0006\u0010h\u001a\u00020\u001dJ(\u0010m\u001a\u00020\u001a2\u0012\u0010i\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d0j2\n\b\u0002\u0010h\u001a\u0004\u0018\u00010\u001dH\u0002J \u0010n\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d0j2\n\b\u0002\u0010h\u001a\u0004\u0018\u00010\u001dH\u0002J\"\u0010o\u001a\u00020\u00162\b\b\u0002\u0010p\u001a\u00020\u001a2\b\u0010q\u001a\u0004\u0018\u00010r2\u0006\u0010s\u001a\u00020tJ\u0018\u0010u\u001a\u00020\u00162\b\u0010q\u001a\u0004\u0018\u00010r2\u0006\u0010s\u001a\u00020tJ\u0016\u0010v\u001a\u00020\u00162\f\u0010w\u001a\b\u0012\u0004\u0012\u00020y0xH\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006|"}, d2 = {"Lcom/hive/analytics/AnalyticsImpl;", "Lcom/hive/module/interfaces/HiveAnalytics;", "<init>", "()V", "analyticsSendLimit", "", "getAnalyticsSendLimit", "()I", "setAnalyticsSendLimit", "(I)V", "analyticsQueueLimit", "getAnalyticsQueueLimit", "setAnalyticsQueueLimit", "analyticsSendCycleSeconds", "", "getAnalyticsSendCycleSeconds", "()F", "setAnalyticsSendCycleSeconds", "(F)V", "networkResponseObserver", "Lkotlin/Function1;", "Lcom/hive/core/Response;", "", "getNetworkResponseObserver", "()Lkotlin/jvm/functions/Function1;", "isInitialize", "", "usedFunnelStrings", "Ljava/util/HashSet;", "", MobileAdsBridgeBase.initializeMethodName, "did", "analyticsId", "sendAnalyticsLog", "logData", "", "", "Lorg/json/JSONObject;", "setAgeGateU13", "sendAnalyticsHiveLog", "setEnableProvider", "name", "isEnable", "activateConCurrentUserLog", "deactivateConcurrentUserLog", "sendEvent", "eventName", "sendEventWithAttributes", "attributes", "sendUserEntryFunnelsLogs", "funnelTrack", "Lcom/hive/analytics/AnalyticsImpl$FunnelsTrack;", "optionTag", "sendRevenueEvent", "analyticsRevenue", "Lcom/hive/Analytics$AnalyticsRevenue;", "sendAdRevenueEvent", "analyticsAdRevenue", "Lcom/hive/Analytics$AnalyticsAdRevenue;", "sendAdStandardEvent", HandleInvocationsFromAdViewer.KEY_AD_DATA, "sendStandardEvent", "standardEventType", "Lcom/hive/analytics/provider/AnalyticsProviderAdapter$StandardEventType;", "sendStandardRevenueEvent", AnalyticsProviderAdjust.EventKeys.revenue, "sendInstallOrUpdate", "sendReviewClick", "buttonType", "sendSessionTimespan", "startSec", "", "lengthSec", "sendLoginServerSelectLog", "sendClientEmulatorBaseDataLog", "emulator", "baseData", "sendNetworkResponseLog", "response", "sendDeviceInfoLog", "sendPromotionImageDownloadLog", "downloadTime", "totalCount", "successCount", "setCustomUserId", "vid", "onCreate", "intent", "Landroid/content/Intent;", "remainAnalyticsLogCount", "onResume", "activity", "Landroid/app/Activity;", "onPause", "onNewIntent", "onChangeProperty", "key", "value", "onReferrerReceive", "context", "Landroid/content/Context;", "setTransferReadyState", "readyFlag", "setConsent", "providerName", "settings", "", "setConsentToProviders", "getConsent", "writeConsentSettings", "loadConsentSettings", "showConsentModeIfRequire", "checkCmp", "consentMode", "Lcom/hive/Analytics$ConsentMode;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/Analytics$ConsentModeListener;", "showConsentMode", "consentTrackingTool", "statusList", "", "Lcom/hive/Analytics$ConsentMode$ConsentStatus;", "AnalyticsDefineEvent", "FunnelsTrack", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AnalyticsImpl implements HiveAnalytics {
    private static boolean isInitialize;
    public static final AnalyticsImpl INSTANCE = new AnalyticsImpl();
    private static int analyticsSendLimit = 5;
    private static int analyticsQueueLimit = 50;
    private static float analyticsSendCycleSeconds = 1.0f;
    private static final Function1<Response, Unit> networkResponseObserver = new Function1() { // from class: com.hive.analytics.AnalyticsImpl$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return AnalyticsImpl.networkResponseObserver$lambda$0((Response) obj);
        }
    };
    private static final HashSet<String> usedFunnelStrings = new HashSet<>();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/hive/analytics/AnalyticsImpl$AnalyticsDefineEvent;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "OPEN", "LOGIN", "INSTALL", "UPDATE", ViewHierarchyConstants.PURCHASE, "TUTORIAL_COMPLETE", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AnalyticsDefineEvent {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ AnalyticsDefineEvent[] $VALUES;
        private final String value;
        public static final AnalyticsDefineEvent OPEN = new AnalyticsDefineEvent("OPEN", 0, "Open");
        public static final AnalyticsDefineEvent LOGIN = new AnalyticsDefineEvent("LOGIN", 1, "Login");
        public static final AnalyticsDefineEvent INSTALL = new AnalyticsDefineEvent("INSTALL", 2, "Install");
        public static final AnalyticsDefineEvent UPDATE = new AnalyticsDefineEvent("UPDATE", 3, "Update");
        public static final AnalyticsDefineEvent PURCHASE = new AnalyticsDefineEvent(ViewHierarchyConstants.PURCHASE, 4, "Purchase");
        public static final AnalyticsDefineEvent TUTORIAL_COMPLETE = new AnalyticsDefineEvent("TUTORIAL_COMPLETE", 5, "TutorialComplete");

        private static final /* synthetic */ AnalyticsDefineEvent[] $values() {
            return new AnalyticsDefineEvent[]{OPEN, LOGIN, INSTALL, UPDATE, PURCHASE, TUTORIAL_COMPLETE};
        }

        static {
            AnalyticsDefineEvent[] analyticsDefineEventArr$values = $values();
            $VALUES = analyticsDefineEventArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(analyticsDefineEventArr$values);
        }

        private AnalyticsDefineEvent(String str, int i, String str2) {
            this.value = str2;
        }

        public static EnumEntries<AnalyticsDefineEvent> getEntries() {
            return $ENTRIES;
        }

        public static AnalyticsDefineEvent valueOf(String str) {
            return (AnalyticsDefineEvent) Enum.valueOf(AnalyticsDefineEvent.class, str);
        }

        public static AnalyticsDefineEvent[] values() {
            return (AnalyticsDefineEvent[]) $VALUES.clone();
        }

        public final String getValue() {
            return this.value;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/hive/analytics/AnalyticsImpl$FunnelsTrack;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "NEW_INSTALL", "SDK_BEGIN", "PERMISSION_POPUP", "NOTICE_POPUP", "AGREEMENT_POPUP", "SELECT_SERVER", "SERVER_MAINTENANCE_POPUP", "ADDITIONAL_DOWNLOAD", "ADDITIONAL_DOWNLOAD_COMPLETE", "LOGIN", "PROMOTION_BANNER", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class FunnelsTrack {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ FunnelsTrack[] $VALUES;
        private final int value;
        public static final FunnelsTrack NEW_INSTALL = new FunnelsTrack("NEW_INSTALL", 0, 400);
        public static final FunnelsTrack SDK_BEGIN = new FunnelsTrack("SDK_BEGIN", 1, 401);
        public static final FunnelsTrack PERMISSION_POPUP = new FunnelsTrack("PERMISSION_POPUP", 2, TTAdConstant.IMAGE_LIST_SIZE_CODE);
        public static final FunnelsTrack NOTICE_POPUP = new FunnelsTrack("NOTICE_POPUP", 3, TypedValues.CycleType.TYPE_EASING);
        public static final FunnelsTrack AGREEMENT_POPUP = new FunnelsTrack("AGREEMENT_POPUP", 4, 430);
        public static final FunnelsTrack SELECT_SERVER = new FunnelsTrack("SELECT_SERVER", 5, 500);
        public static final FunnelsTrack SERVER_MAINTENANCE_POPUP = new FunnelsTrack("SERVER_MAINTENANCE_POPUP", 6, 600);
        public static final FunnelsTrack ADDITIONAL_DOWNLOAD = new FunnelsTrack("ADDITIONAL_DOWNLOAD", 7, TypedValues.TransitionType.TYPE_DURATION);
        public static final FunnelsTrack ADDITIONAL_DOWNLOAD_COMPLETE = new FunnelsTrack("ADDITIONAL_DOWNLOAD_COMPLETE", 8, 800);
        public static final FunnelsTrack LOGIN = new FunnelsTrack("LOGIN", 9, 900);
        public static final FunnelsTrack PROMOTION_BANNER = new FunnelsTrack("PROMOTION_BANNER", 10, 1000);

        private static final /* synthetic */ FunnelsTrack[] $values() {
            return new FunnelsTrack[]{NEW_INSTALL, SDK_BEGIN, PERMISSION_POPUP, NOTICE_POPUP, AGREEMENT_POPUP, SELECT_SERVER, SERVER_MAINTENANCE_POPUP, ADDITIONAL_DOWNLOAD, ADDITIONAL_DOWNLOAD_COMPLETE, LOGIN, PROMOTION_BANNER};
        }

        static {
            FunnelsTrack[] funnelsTrackArr$values = $values();
            $VALUES = funnelsTrackArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(funnelsTrackArr$values);
        }

        private FunnelsTrack(String str, int i, int i2) {
            this.value = i2;
        }

        public static EnumEntries<FunnelsTrack> getEntries() {
            return $ENTRIES;
        }

        public static FunnelsTrack valueOf(String str) {
            return (FunnelsTrack) Enum.valueOf(FunnelsTrack.class, str);
        }

        public static FunnelsTrack[] values() {
            return (FunnelsTrack[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }
    }

    /* JADX INFO: renamed from: com.hive.analytics.AnalyticsImpl$sendDeviceInfoLog$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.analytics.AnalyticsImpl$sendDeviceInfoLog$1", f = "AnalyticsImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objM7415constructorimpl;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            try {
                Result.Companion companion = Result.INSTANCE;
                JSONObject jSONObject = new JSONObject();
                HiveCoreInitializer.Companion companion2 = HiveCoreInitializer.INSTANCE;
                int i = companion2.getInitContext().getResources().getDisplayMetrics().densityDpi;
                float f = companion2.getInitContext().getResources().getDisplayMetrics().density;
                Android android2 = Android.INSTANCE;
                HiveActivity hiveActivity = HiveActivity.INSTANCE;
                int i2 = android2.getRealDisplaySize(hiveActivity.getRecentActivity()).x;
                int i3 = android2.getRealDisplaySize(hiveActivity.getRecentActivity()).y;
                jSONObject.put(HiveKeys.KEY_category.getValue(), "pub_device_info");
                jSONObject.put(HiveKeys.KEY_playerId.getValue(), HiveLifecycle.INSTANCE.getAccount().getVid());
                jSONObject.put(HiveKeys.KEY_emulator.getValue(), android2.isEmulator());
                jSONObject.put(HiveKeys.KEY_sessionId.getValue(), Configuration.INSTANCE.getSessionId());
                String value = HiveKeys.KEY_memSize.getValue();
                Platform platform = Platform.INSTANCE;
                jSONObject.put(value, Boxing.boxFloat(platform.getDeviceMemorySize()));
                jSONObject.put(HiveKeys.KEY_storageSize.getValue(), Boxing.boxFloat(platform.getDeviceDiskSpace()));
                jSONObject.put(HiveKeys.KEY_resW.getValue(), i2);
                jSONObject.put(HiveKeys.KEY_resH.getValue(), i3);
                jSONObject.put(HiveKeys.KEY_graphicsEngine.getValue(), platform.getDeviceGlVersion());
                jSONObject.put(HiveKeys.KEY_dpW.getValue(), (int) (i2 / f));
                jSONObject.put(HiveKeys.KEY_dpH.getValue(), (int) (i3 / f));
                jSONObject.put(HiveKeys.KEY_dpi.getValue(), i);
                objM7415constructorimpl = Result.m7415constructorimpl(jSONObject);
            } catch (Throwable th) {
                Result.Companion companion3 = Result.INSTANCE;
                objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m7422isSuccessimpl(objM7415constructorimpl)) {
                AnalyticsImpl.INSTANCE.sendAnalyticsHiveLog((JSONObject) objM7415constructorimpl);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    static {
        new AnalyticsLifeCycle();
    }

    private AnalyticsImpl() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void consentTrackingTool(List<Analytics.ConsentMode.ConsentStatus> statusList) {
        Map mapMutableMapOf = MapsKt.mutableMapOf(TuplesKt.to(Analytics.CONSENT_TYPE_AD_STORAGE, Analytics.CONSENT_GRANTED), TuplesKt.to(Analytics.CONSENT_TYPE_AD_USER_DATA, Analytics.CONSENT_DENIED), TuplesKt.to(Analytics.CONSENT_TYPE_AD_PERSONALIZATION, Analytics.CONSENT_DENIED), TuplesKt.to(Analytics.CONSENT_TYPE_ANALYTICS_STORAGE, Analytics.CONSENT_DENIED));
        boolean zConsentTrackingTool$isConsentGranted = consentTrackingTool$isConsentGranted(statusList, Analytics.CONSENT_TYPE_AD_USER_DATA);
        boolean zConsentTrackingTool$isConsentGranted2 = consentTrackingTool$isConsentGranted(statusList, Analytics.CONSENT_TYPE_AD_PERSONALIZATION);
        boolean zConsentTrackingTool$isConsentGranted3 = consentTrackingTool$isConsentGranted(statusList, Analytics.CONSENT_TYPE_ANALYTICS_STORAGE);
        if (zConsentTrackingTool$isConsentGranted) {
            mapMutableMapOf.put(Analytics.CONSENT_TYPE_AD_USER_DATA, Analytics.CONSENT_GRANTED);
        }
        for (Analytics.ConsentMode.ConsentStatus consentStatus : statusList) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.putAll(mapMutableMapOf);
            String lowerCase = consentStatus.getId().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            switch (lowerCase.hashCode()) {
                case -1892076242:
                    if (lowerCase.equals("appsflyer")) {
                        consentTrackingTool$lambda$24$applyPersonalizationIfGranted(consentStatus, zConsentTrackingTool$isConsentGranted2, linkedHashMap);
                        INSTANCE.setConsent(AnalyticsProviderAdapter.AnalyticsProviderType.APPSFLYER.getValue(), linkedHashMap);
                    }
                    break;
                case -1422313585:
                    if (lowerCase.equals("adjust")) {
                        consentTrackingTool$lambda$24$applyPersonalizationIfGranted(consentStatus, zConsentTrackingTool$isConsentGranted2, linkedHashMap);
                        INSTANCE.setConsent(AnalyticsProviderAdapter.AnalyticsProviderType.ADJUST.getValue(), linkedHashMap);
                    }
                    break;
                case -1240244679:
                    if (lowerCase.equals("google")) {
                        consentTrackingTool$lambda$24$applyPersonalizationIfGranted(consentStatus, zConsentTrackingTool$isConsentGranted2, linkedHashMap);
                        if (zConsentTrackingTool$isConsentGranted3) {
                            linkedHashMap.put(Analytics.CONSENT_TYPE_ANALYTICS_STORAGE, Analytics.CONSENT_GRANTED);
                        }
                        INSTANCE.setConsent(AnalyticsProviderAdapter.AnalyticsProviderType.FIREBASE.getValue(), linkedHashMap);
                    }
                    break;
                case 92437843:
                    if (lowerCase.equals("airbridge")) {
                        consentTrackingTool$lambda$24$applyPersonalizationIfGranted(consentStatus, zConsentTrackingTool$isConsentGranted2, linkedHashMap);
                        INSTANCE.setConsent(AnalyticsProviderAdapter.AnalyticsProviderType.AIRBRIDGE.getValue(), linkedHashMap);
                    }
                    break;
                case 506253335:
                    if (lowerCase.equals("singular")) {
                        consentTrackingTool$lambda$24$applyPersonalizationIfGranted(consentStatus, zConsentTrackingTool$isConsentGranted2, linkedHashMap);
                        INSTANCE.setConsent(AnalyticsProviderAdapter.AnalyticsProviderType.SINGULAR.getValue(), linkedHashMap);
                    }
                    break;
            }
        }
    }

    private static final boolean consentTrackingTool$isConsentGranted(List<Analytics.ConsentMode.ConsentStatus> list, String str) {
        Object next;
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (Intrinsics.areEqual(((Analytics.ConsentMode.ConsentStatus) next).getId(), str)) {
                break;
            }
        }
        Analytics.ConsentMode.ConsentStatus consentStatus = (Analytics.ConsentMode.ConsentStatus) next;
        return consentStatus != null && consentStatus.isGranted();
    }

    private static final void consentTrackingTool$lambda$24$applyPersonalizationIfGranted(Analytics.ConsentMode.ConsentStatus consentStatus, boolean z, Map<String, String> map) {
        if (consentStatus.isGranted() && z) {
            map.put(Analytics.CONSENT_TYPE_AD_PERSONALIZATION, Analytics.CONSENT_GRANTED);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0052 A[Catch: all -> 0x005c, TryCatch #0 {all -> 0x005c, blocks: (B:3:0x0002, B:5:0x0006, B:8:0x000d, B:10:0x001c, B:12:0x0028, B:14:0x0030, B:16:0x0039, B:19:0x0057, B:18:0x0052), top: B:31:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.util.Map<java.lang.String, java.lang.String> loadConsentSettings(java.lang.String r5) {
        /*
            r4 = this;
            java.lang.String r0 = "analytics.consent_settings."
            kotlin.Result$Companion r1 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L5c
            if (r5 == 0) goto L1a
            boolean r1 = kotlin.text.StringsKt.isBlank(r5)     // Catch: java.lang.Throwable -> L5c
            if (r1 == 0) goto Ld
            goto L1a
        Ld:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5c
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L5c
            r1.append(r5)     // Catch: java.lang.Throwable -> L5c
            java.lang.String r5 = r1.toString()     // Catch: java.lang.Throwable -> L5c
            goto L1c
        L1a:
            java.lang.String r5 = "analytics.consent_settings"
        L1c:
            com.hive.base.Property$Companion r0 = com.hive.base.Property.INSTANCE     // Catch: java.lang.Throwable -> L5c
            com.hive.base.Property r0 = r0.getINSTANCE()     // Catch: java.lang.Throwable -> L5c
            java.lang.String r5 = r0.getValue(r5)     // Catch: java.lang.Throwable -> L5c
            if (r5 == 0) goto L52
            com.hive.core.StringUtil r0 = com.hive.core.StringUtil.INSTANCE     // Catch: java.lang.Throwable -> L5c
            byte[] r5 = r0.toHexByteArray(r5)     // Catch: java.lang.Throwable -> L5c
            if (r5 == 0) goto L52
            r1 = 1
            r2 = 0
            r3 = 0
            byte[] r5 = com.hive.core.StringUtil.toBase64Decode$default(r0, r5, r3, r1, r2)     // Catch: java.lang.Throwable -> L5c
            if (r5 == 0) goto L52
            java.io.ByteArrayInputStream r0 = new java.io.ByteArrayInputStream     // Catch: java.lang.Throwable -> L5c
            r0.<init>(r5)     // Catch: java.lang.Throwable -> L5c
            java.io.ObjectInputStream r5 = new java.io.ObjectInputStream     // Catch: java.lang.Throwable -> L5c
            r5.<init>(r0)     // Catch: java.lang.Throwable -> L5c
            java.lang.Object r5 = r5.readObject()     // Catch: java.lang.Throwable -> L5c
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.String>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5, r0)     // Catch: java.lang.Throwable -> L5c
            java.util.Map r5 = kotlin.jvm.internal.TypeIntrinsics.asMutableMap(r5)     // Catch: java.lang.Throwable -> L5c
            if (r5 != 0) goto L57
        L52:
            java.util.LinkedHashMap r5 = new java.util.LinkedHashMap     // Catch: java.lang.Throwable -> L5c
            r5.<init>()     // Catch: java.lang.Throwable -> L5c
        L57:
            java.lang.Object r5 = kotlin.Result.m7415constructorimpl(r5)     // Catch: java.lang.Throwable -> L5c
            goto L67
        L5c:
            r5 = move-exception
            kotlin.Result$Companion r0 = kotlin.Result.INSTANCE
            java.lang.Object r5 = kotlin.ResultKt.createFailure(r5)
            java.lang.Object r5 = kotlin.Result.m7415constructorimpl(r5)
        L67:
            java.lang.Throwable r0 = kotlin.Result.m7418exceptionOrNullimpl(r5)
            if (r0 == 0) goto L80
            com.hive.logger.LoggerImpl r1 = com.hive.logger.LoggerImpl.INSTANCE
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "[Analytics] loadConsentSettings failure : "
            r2.<init>(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.w(r0)
        L80:
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
            r0.<init>()
            boolean r1 = kotlin.Result.m7421isFailureimpl(r5)
            if (r1 == 0) goto L8c
            r5 = r0
        L8c:
            java.util.Map r5 = (java.util.Map) r5
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.analytics.AnalyticsImpl.loadConsentSettings(java.lang.String):java.util.Map");
    }

    public static /* synthetic */ Map loadConsentSettings$default(AnalyticsImpl analyticsImpl, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return analyticsImpl.loadConsentSettings(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit networkResponseObserver$lambda$0(Response it) {
        Intrinsics.checkNotNullParameter(it, "it");
        INSTANCE.sendNetworkResponseLog(it);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void sendInstallOrUpdate() {
        /*
            r9 = this;
            com.hive.base.Property r6 = new com.hive.base.Property
            java.lang.String r0 = "getSimpleName(...)"
            java.lang.String r1 = "AnalyticsImpl"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r6.<init>(r1)
            com.hive.analytics.AnalyticsImpl$AnalyticsDefineEvent r0 = com.hive.analytics.AnalyticsImpl.AnalyticsDefineEvent.OPEN
            com.hive.core.HiveKeys r1 = com.hive.core.HiveKeys.KEY_appVer
            java.lang.String r1 = r1.getValue()
            java.lang.String r2 = ""
            java.lang.String r1 = r6.getValue(r1, r2)
            int r3 = r1.length()
            if (r3 != 0) goto L24
            com.hive.analytics.AnalyticsImpl$AnalyticsDefineEvent r1 = com.hive.analytics.AnalyticsImpl.AnalyticsDefineEvent.INSTALL
        L22:
            r7 = r1
            goto L34
        L24:
            com.hive.base.Android r3 = com.hive.base.Android.INSTANCE
            java.lang.String r3 = r3.getAppVersion()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r3)
            if (r1 != 0) goto L33
            com.hive.analytics.AnalyticsImpl$AnalyticsDefineEvent r1 = com.hive.analytics.AnalyticsImpl.AnalyticsDefineEvent.UPDATE
            goto L22
        L33:
            r7 = r0
        L34:
            if (r7 == r0) goto Lb1
            java.lang.String r0 = r7.getValue()
            r9.sendEvent(r0)
            kotlin.Result$Companion r0 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L68
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat     // Catch: java.lang.Throwable -> L68
            java.lang.String r1 = "yyyy-MM-dd HH:mm:ss.SSS"
            java.util.Locale r3 = java.util.Locale.US     // Catch: java.lang.Throwable -> L68
            r0.<init>(r1, r3)     // Catch: java.lang.Throwable -> L68
            java.lang.String r1 = "GMT"
            java.util.TimeZone r1 = java.util.TimeZone.getTimeZone(r1)     // Catch: java.lang.Throwable -> L68
            java.util.Calendar r1 = java.util.Calendar.getInstance(r1, r3)     // Catch: java.lang.Throwable -> L68
            java.util.Date r1 = r1.getTime()     // Catch: java.lang.Throwable -> L68
            java.lang.String r0 = r0.format(r1)     // Catch: java.lang.Throwable -> L68
            java.lang.String r1 = "format(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)     // Catch: java.lang.Throwable -> L68
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L66
            java.lang.Object r1 = kotlin.Result.m7415constructorimpl(r1)     // Catch: java.lang.Throwable -> L66
            goto L75
        L66:
            r1 = move-exception
            goto L6b
        L68:
            r0 = move-exception
            r1 = r0
            r0 = r2
        L6b:
            kotlin.Result$Companion r3 = kotlin.Result.INSTANCE
            java.lang.Object r1 = kotlin.ResultKt.createFailure(r1)
            java.lang.Object r1 = kotlin.Result.m7415constructorimpl(r1)
        L75:
            java.lang.Throwable r1 = kotlin.Result.m7418exceptionOrNullimpl(r1)
            if (r1 == 0) goto L7d
            r8 = r2
            goto L7e
        L7d:
            r8 = r0
        L7e:
            com.hive.core.HiveKeys r0 = com.hive.core.HiveKeys.KEY_appVer
            java.lang.String r1 = r0.getValue()
            com.hive.base.Android r0 = com.hive.base.Android.INSTANCE
            java.lang.String r0 = r0.getAppVersion()
            if (r0 != 0) goto L8d
            goto L8e
        L8d:
            r2 = r0
        L8e:
            r4 = 4
            r5 = 0
            r3 = 0
            r0 = r6
            com.hive.base.Property.setValue$default(r0, r1, r2, r3, r4, r5)
            com.hive.core.HiveKeys r0 = com.hive.core.HiveKeys.KEY_recentlySentType
            java.lang.String r1 = r0.getValue()
            java.lang.String r2 = r7.getValue()
            r0 = r6
            com.hive.base.Property.setValue$default(r0, r1, r2, r3, r4, r5)
            com.hive.core.HiveKeys r0 = com.hive.core.HiveKeys.KEY_sentTime
            java.lang.String r1 = r0.getValue()
            r0 = r6
            r2 = r8
            com.hive.base.Property.setValue$default(r0, r1, r2, r3, r4, r5)
            r6.writeProperties()
        Lb1:
            com.hive.analytics.AnalyticsReferrerSender r0 = com.hive.analytics.AnalyticsReferrerSender.INSTANCE
            com.hive.core.HiveCoreInitializer$Companion r1 = com.hive.core.HiveCoreInitializer.INSTANCE
            android.content.Context r1 = r1.getInitContext()
            r0.sendToThirdParty$hive_service_release(r1)
            com.hive.analytics.AnalyticsImpl$AnalyticsDefineEvent r0 = com.hive.analytics.AnalyticsImpl.AnalyticsDefineEvent.OPEN
            java.lang.String r0 = r0.getValue()
            r9.sendEvent(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.analytics.AnalyticsImpl.sendInstallOrUpdate():void");
    }

    public static /* synthetic */ void sendPromotionImageDownloadLog$default(AnalyticsImpl analyticsImpl, long j, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j = 0;
        }
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        analyticsImpl.sendPromotionImageDownloadLog(j, i, i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void sendStandardEvent$default(AnalyticsImpl analyticsImpl, AnalyticsProviderAdapter.StandardEventType standardEventType, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            map = null;
        }
        analyticsImpl.sendStandardEvent(standardEventType, map);
    }

    private final void setConsentToProviders() {
        String lowerCase;
        for (AnalyticsProviderAdapter.AnalyticsProviderType analyticsProviderType : AnalyticsProviderAdapter.AnalyticsProviderType.values()) {
            if (Intrinsics.areEqual(analyticsProviderType.getValue(), "Firebase")) {
                lowerCase = "google";
            } else {
                lowerCase = analyticsProviderType.getValue().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            }
            AnalyticsProviderAdapter.INSTANCE.setConsent(analyticsProviderType.getValue(), INSTANCE.getConsent(lowerCase));
        }
    }

    public static /* synthetic */ void showConsentModeIfRequire$default(AnalyticsImpl analyticsImpl, boolean z, Analytics.ConsentMode consentMode, Analytics.ConsentModeListener consentModeListener, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        analyticsImpl.showConsentModeIfRequire(z, consentMode, consentModeListener);
    }

    private final boolean writeConsentSettings(Map<String, String> settings, String providerName) {
        Object objM7415constructorimpl;
        String str;
        String hexString;
        try {
            Result.Companion companion = Result.INSTANCE;
            if (providerName == null || StringsKt.isBlank(providerName)) {
                str = AnalyticsKeys.CONSENT_SETTINGS;
            } else {
                str = "analytics.consent_settings." + providerName;
            }
            String str2 = str;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new ObjectOutputStream(byteArrayOutputStream).writeObject(settings);
            StringUtil stringUtil = StringUtil.INSTANCE;
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
            boolean zWriteProperties = false;
            byte[] base64Encode$default = StringUtil.toBase64Encode$default(stringUtil, byteArray, 0, 1, null);
            if (base64Encode$default != null && (hexString = stringUtil.toHexString(base64Encode$default)) != null) {
                Property.Companion companion2 = Property.INSTANCE;
                Property.setValue$default(companion2.getINSTANCE(), str2, hexString, null, 4, null);
                zWriteProperties = companion2.getINSTANCE().writeProperties();
            }
            objM7415constructorimpl = Result.m7415constructorimpl(Boolean.valueOf(zWriteProperties));
        } catch (Throwable th) {
            Result.Companion companion3 = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
        if (thM7418exceptionOrNullimpl != null) {
            LoggerImpl.INSTANCE.w("[Analytics] writeConsentSettings failure : " + thM7418exceptionOrNullimpl);
        }
        Boolean bool = Boolean.FALSE;
        if (Result.m7421isFailureimpl(objM7415constructorimpl)) {
            objM7415constructorimpl = bool;
        }
        return ((Boolean) objM7415constructorimpl).booleanValue();
    }

    public static /* synthetic */ boolean writeConsentSettings$default(AnalyticsImpl analyticsImpl, Map map, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        return analyticsImpl.writeConsentSettings(map, str);
    }

    public final void activateConCurrentUserLog() {
        String uid;
        HiveLifecycle hiveLifecycle = HiveLifecycle.INSTANCE;
        String vid = hiveLifecycle.getAccount().getVid();
        if (((vid == null || vid.length() == 0) && ((uid = hiveLifecycle.getAccount().getUid()) == null || uid.length() == 0)) || Configuration.INSTANCE.isCcuDeactivate()) {
            return;
        }
        AnalyticsCCUSender.INSTANCE.onStart();
    }

    public final void deactivateConcurrentUserLog() {
        AnalyticsCCUSender.INSTANCE.onStop();
    }

    public final int getAnalyticsQueueLimit() {
        return analyticsQueueLimit;
    }

    public final float getAnalyticsSendCycleSeconds() {
        return analyticsSendCycleSeconds;
    }

    public final int getAnalyticsSendLimit() {
        return analyticsSendLimit;
    }

    public final Map<String, String> getConsent(String providerName) {
        Intrinsics.checkNotNullParameter(providerName, "providerName");
        return loadConsentSettings(providerName);
    }

    @Override // com.hive.module.interfaces.HiveAnalytics, com.hive.module.HiveModule
    public String getHiveModuleName() {
        return HiveAnalytics.DefaultImpls.getHiveModuleName(this);
    }

    public final Function1<Response, Unit> getNetworkResponseObserver() {
        return networkResponseObserver;
    }

    @Override // com.hive.module.interfaces.HiveAnalytics, com.hive.module.HiveModule
    public Map<String, String> getVersionInfo() {
        return HiveAnalytics.DefaultImpls.getVersionInfo(this);
    }

    public final void initialize(String did, String analyticsId) {
        if (isInitialize) {
            return;
        }
        AnalyticsLogTransfer.INSTANCE.initialize();
        if (!Configuration.INSTANCE.getAgeGateU13()) {
            AnalyticsProviderAdapter.INSTANCE.initializeProviders(did, analyticsId);
        }
        sendInstallOrUpdate();
        isInitialize = true;
    }

    public final void onChangeProperty(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        AnalyticsProviderAdapter.INSTANCE.onChangeProperty(key, value);
    }

    public final void onCreate(Intent intent) {
        AnalyticsProviderAdapter.INSTANCE.onCreate(intent);
    }

    public final void onNewIntent(Activity activity, Intent intent) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        AnalyticsProviderAdapter.INSTANCE.onNewIntent(intent);
    }

    @Override // com.hive.module.interfaces.HiveAnalytics
    public void onPause(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        AnalyticsProviderAdapter.INSTANCE.onPaused();
        AnalyticsLogTransfer.INSTANCE.saveAndClearLog();
    }

    public final void onReferrerReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        AnalyticsProviderAdapter.INSTANCE.onReferrerReceives(context, intent);
    }

    public final void onResume(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        AnalyticsProviderAdapter.INSTANCE.onResumed();
        AnalyticsLogTransfer.INSTANCE.loadSavedLog();
    }

    public final int remainAnalyticsLogCount() {
        return AnalyticsLogTransfer.INSTANCE.remainLogCount();
    }

    public final void sendAdRevenueEvent(Analytics.AnalyticsAdRevenue analyticsAdRevenue) {
        Intrinsics.checkNotNullParameter(analyticsAdRevenue, "analyticsAdRevenue");
        AnalyticsProviderAdapter.INSTANCE.sendAdRevenueEvents(analyticsAdRevenue);
    }

    public final void sendAdStandardEvent(JSONObject adData) {
        Intrinsics.checkNotNullParameter(adData, "adData");
        AnalyticsProviderAdapter.INSTANCE.sendAdStandardEvents(adData);
    }

    public final boolean sendAnalyticsHiveLog(JSONObject logData) {
        Intrinsics.checkNotNullParameter(logData, "logData");
        return AnalyticsLogTransfer.INSTANCE.sendAnalyticsHiveLog(logData);
    }

    public final boolean sendAnalyticsLog(Map<String, ? extends Object> logData) {
        Intrinsics.checkNotNullParameter(logData, "logData");
        return AnalyticsLogTransfer.INSTANCE.sendAnalyticsLog(logData);
    }

    public final void sendClientEmulatorBaseDataLog(String emulator, String baseData) {
        Intrinsics.checkNotNullParameter(emulator, "emulator");
        Intrinsics.checkNotNullParameter(baseData, "baseData");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(HiveKeys.KEY_category.getValue(), "hive_client_emulator_base_data_log");
            jSONObject.put(HiveKeys.KEY_emulator.getValue(), emulator);
            jSONObject.put(HiveKeys.KEY_baseData.getValue(), baseData);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        sendAnalyticsHiveLog(jSONObject);
    }

    public final void sendDeviceInfoLog() {
        if (HiveLifecycle.INSTANCE.isSdkSetup()) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new AnonymousClass1(null), 3, null);
        }
    }

    public final void sendEvent(String eventName) {
        String str;
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        AnalyticsProviderAdapter.INSTANCE.sendEvents(eventName);
        if (Intrinsics.areEqual(eventName, AnalyticsDefineEvent.INSTALL.getValue())) {
            str = "install";
        } else if (!Intrinsics.areEqual(eventName, AnalyticsDefineEvent.UPDATE.getValue())) {
            return;
        } else {
            str = "update";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(HiveKeys.KEY_category.getValue(), "hive_first_open");
            jSONObject.put(HiveKeys.KEY_referrer.getValue(), AnalyticsReferrerSender.INSTANCE.getReferrer());
            jSONObject.put(HiveKeys.KEY_adid.getValue(), Android.INSTANCE.getAdvertisingId());
            jSONObject.put(HiveKeys.KEY_installType.getValue(), str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        sendAnalyticsHiveLog(jSONObject);
    }

    public final void sendEventWithAttributes(String eventName, JSONObject attributes) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        AnalyticsProviderAdapter.INSTANCE.sendEventWithAttributes(eventName, attributes);
    }

    public final void sendLoginServerSelectLog() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(HiveKeys.KEY_category.getValue(), "hive_login_server_select_log");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        sendAnalyticsHiveLog(jSONObject);
    }

    public final void sendNetworkResponseLog(Response response) {
        Object objM7415constructorimpl;
        Intrinsics.checkNotNullParameter(response, "response");
        try {
            Result.Companion companion = Result.INSTANCE;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(HiveKeys.KEY_category.getValue(), "hive_network_response");
            jSONObject.put(HiveKeys.KEY_apiUrl.getValue(), response.getRequest().getUrl());
            jSONObject.put(HiveKeys.KEY_isSuccess.getValue(), response.isSuccess() ? 1 : 0);
            jSONObject.put(HiveKeys.KEY_responseCode.getValue(), response.getHttpStatusCode());
            jSONObject.put(HiveKeys.KEY_connectLatency.getValue(), response.getConnectLatency());
            jSONObject.put(HiveKeys.KEY_transportLatency.getValue(), response.getTransportLatency());
            jSONObject.put(HiveKeys.KEY_responseLatency.getValue(), response.getResponseLatency());
            jSONObject.put(HiveKeys.KEY_networkType.getValue(), response.getNetworkType());
            jSONObject.put(HiveKeys.KEY_sendBytes.getValue(), response.getRequest().getBody().length);
            String value = HiveKeys.KEY_recvBytes.getValue();
            byte[] content = response.getContent();
            jSONObject.put(value, content != null ? content.length : 0);
            jSONObject.put(HiveKeys.KEY_sessionGuid.getValue(), response.getSessionGuid());
            jSONObject.put(HiveKeys.KEY_sessionIndex.getValue(), response.getSessionIndex());
            jSONObject.put(HiveKeys.KEY_dnsIp.getValue(), response.getDnsIp());
            jSONObject.put(HiveKeys.KEY_tlsProtocol.getValue(), response.getTlsProtocol());
            jSONObject.put(HiveKeys.KEY_tlsNote.getValue(), response.getTlsNote());
            objM7415constructorimpl = Result.m7415constructorimpl(jSONObject);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m7422isSuccessimpl(objM7415constructorimpl)) {
            INSTANCE.sendAnalyticsHiveLog((JSONObject) objM7415constructorimpl);
        }
    }

    public final void sendPromotionImageDownloadLog(long downloadTime, int totalCount, int successCount) {
        Object objM7415constructorimpl;
        if (HiveLifecycle.INSTANCE.isSdkSetup()) {
            try {
                Result.Companion companion = Result.INSTANCE;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(HiveKeys.KEY_category.getValue(), "hive_promotion_image_download_log");
                jSONObject.put(HiveKeys.KEY_networkType.getValue(), Platform.readNetworkType$default(Platform.INSTANCE, null, 1, null));
                jSONObject.put(HiveKeys.KEY_download_time.getValue(), downloadTime);
                jSONObject.put(HiveKeys.KEY_total_image_count.getValue(), totalCount);
                jSONObject.put(HiveKeys.KEY_success_image_count.getValue(), successCount);
                objM7415constructorimpl = Result.m7415constructorimpl(jSONObject);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m7422isSuccessimpl(objM7415constructorimpl)) {
                INSTANCE.sendAnalyticsHiveLog((JSONObject) objM7415constructorimpl);
            }
        }
    }

    public final void sendRevenueEvent(Analytics.AnalyticsRevenue analyticsRevenue) {
        Intrinsics.checkNotNullParameter(analyticsRevenue, "analyticsRevenue");
        sendRevenueEvent(AnalyticsDefineEvent.PURCHASE.getValue(), analyticsRevenue);
    }

    public final void sendReviewClick(String buttonType) {
        Intrinsics.checkNotNullParameter(buttonType, "buttonType");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(HiveKeys.KEY_category.getValue(), "hive_review_click");
            String value = HiveKeys.KEY_buttontype.getValue();
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            Object lowerCase = buttonType.toLowerCase(US);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            jSONObject.put(value, lowerCase);
            jSONObject.put("orient", HiveActivity.INSTANCE.getRecentActivity().getResources().getConfiguration().orientation == 1 ? "1" : "2");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        sendStandardEvent(AnalyticsProviderAdapter.StandardEventType.REVIEW, Android.INSTANCE.jsonToMap(jSONObject));
        sendAnalyticsHiveLog(jSONObject);
    }

    public final void sendSessionTimespan(long startSec, long lengthSec) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(HiveKeys.KEY_category.getValue(), "hive_session_timespan");
            jSONObject.put(HiveKeys.KEY_session_start.getValue(), startSec);
            jSONObject.put(HiveKeys.KEY_session_length.getValue(), lengthSec);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        sendAnalyticsHiveLog(jSONObject);
    }

    public final void sendStandardEvent(AnalyticsProviderAdapter.StandardEventType standardEventType, Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(standardEventType, "standardEventType");
        AnalyticsProviderAdapter.INSTANCE.sendStandardEvents(standardEventType, attributes);
    }

    public final void sendStandardRevenueEvent(AnalyticsProviderAdapter.StandardEventType standardEventType, Analytics.AnalyticsRevenue revenue) {
        Intrinsics.checkNotNullParameter(standardEventType, "standardEventType");
        Intrinsics.checkNotNullParameter(revenue, "revenue");
        AnalyticsProviderAdapter.INSTANCE.sendStandardRevenueEvents(standardEventType, revenue);
    }

    public final void sendUserEntryFunnelsLogs(FunnelsTrack funnelTrack) {
        Intrinsics.checkNotNullParameter(funnelTrack, "funnelTrack");
        sendUserEntryFunnelsLogs(String.valueOf(funnelTrack.getValue()), null);
    }

    public final void setAgeGateU13() {
        AnalyticsProviderAdapter.INSTANCE.setAgeGateUnder13();
    }

    public final void setAnalyticsQueueLimit(int i) {
        analyticsQueueLimit = i;
    }

    public final void setAnalyticsSendCycleSeconds(float f) {
        analyticsSendCycleSeconds = f;
    }

    public final void setAnalyticsSendLimit(int i) {
        analyticsSendLimit = i;
    }

    public final void setConsent(String providerName, Map<String, String> settings) {
        Object objM7415constructorimpl;
        Intrinsics.checkNotNullParameter(providerName, "providerName");
        Intrinsics.checkNotNullParameter(settings, "settings");
        LoggerImpl.INSTANCE.d("[Analytics] " + providerName + " setConsent : " + settings);
        try {
            Result.Companion companion = Result.INSTANCE;
            INSTANCE.writeConsentSettings(settings, providerName);
            if (isInitialize) {
                AnalyticsProviderAdapter.INSTANCE.setConsent(providerName, settings);
            }
            objM7415constructorimpl = Result.m7415constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
        if (thM7418exceptionOrNullimpl != null) {
            LoggerImpl.INSTANCE.w("[Analytics] " + providerName + " setConsent failure : " + thM7418exceptionOrNullimpl);
        }
    }

    public final void setCustomUserId(String vid) {
        AnalyticsProviderAdapter.INSTANCE.setCustomUserId(vid);
    }

    public final void setEnableProvider(String name, boolean isEnable) {
        Intrinsics.checkNotNullParameter(name, "name");
        AnalyticsProviderAdapter.INSTANCE.setEnableProvider(name, isEnable);
    }

    public final void setTransferReadyState(boolean readyFlag) {
        if (isInitialize) {
            AnalyticsLogTransfer.INSTANCE.setSenderReadyState(readyFlag);
        }
    }

    public final void showConsentMode(Analytics.ConsentMode consentMode, final Analytics.ConsentModeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        HiveModuleManager hiveModuleManager = HiveModuleManager.INSTANCE;
        String name = ConsentMode.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        HiveModule hiveModule = hiveModuleManager.getHiveModule(name);
        if (!(hiveModule instanceof ConsentMode)) {
            hiveModule = null;
        }
        if (!(hiveModule instanceof ConsentMode)) {
            hiveModule = null;
        }
        ConsentMode consentMode2 = (ConsentMode) hiveModule;
        if (consentMode2 != null) {
            String value = Property.INSTANCE.getINSTANCE().getValue(AuthV4Keys.AGREEMENT_REVIEW_URL);
            if (value == null) {
                value = null;
            }
            if (value == null) {
                value = "";
            }
            consentMode2.setDefaultPrivacyPolicyUrl(value);
        }
        String name2 = ConsentMode.class.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
        HiveModule hiveModule2 = hiveModuleManager.getHiveModule(name2);
        if (!(hiveModule2 instanceof ConsentMode)) {
            hiveModule2 = null;
        }
        ConsentMode consentMode3 = (ConsentMode) (hiveModule2 instanceof ConsentMode ? hiveModule2 : null);
        if (consentMode3 != null) {
            consentMode3.showConsentMode(HiveActivity.INSTANCE.getRecentActivity(), consentMode, new Analytics.ConsentModeListener() { // from class: com.hive.analytics.AnalyticsImpl.showConsentMode.2
                @Override // com.hive.Analytics.ConsentModeListener
                public void onConsentModeDismissed(ResultAPI result, List<Analytics.ConsentMode.ConsentStatus> statusList) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    Intrinsics.checkNotNullParameter(statusList, "statusList");
                    AnalyticsImpl.INSTANCE.consentTrackingTool(statusList);
                    listener.onConsentModeDismissed(result, statusList);
                }
            });
        } else {
            listener.onConsentModeDismissed(new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, "ConsentMode library missing."), new ArrayList());
        }
    }

    public final void showConsentModeIfRequire(boolean checkCmp, Analytics.ConsentMode consentMode, final Analytics.ConsentModeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        HiveModuleManager hiveModuleManager = HiveModuleManager.INSTANCE;
        String name = ConsentMode.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        HiveModule hiveModule = hiveModuleManager.getHiveModule(name);
        if (!(hiveModule instanceof ConsentMode)) {
            hiveModule = null;
        }
        if (!(hiveModule instanceof ConsentMode)) {
            hiveModule = null;
        }
        ConsentMode consentMode2 = (ConsentMode) hiveModule;
        if (consentMode2 != null) {
            String value = Property.INSTANCE.getINSTANCE().getValue(AuthV4Keys.AGREEMENT_REVIEW_URL);
            if (value == null) {
                value = null;
            }
            if (value == null) {
                value = "";
            }
            consentMode2.setDefaultPrivacyPolicyUrl(value);
        }
        String name2 = ConsentMode.class.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
        HiveModule hiveModule2 = hiveModuleManager.getHiveModule(name2);
        if (!(hiveModule2 instanceof ConsentMode)) {
            hiveModule2 = null;
        }
        ConsentMode consentMode3 = (ConsentMode) (hiveModule2 instanceof ConsentMode ? hiveModule2 : null);
        if (consentMode3 != null) {
            consentMode3.showConsentModeIfRequire(HiveActivity.INSTANCE.getRecentActivity(), checkCmp, consentMode, new Analytics.ConsentModeListener() { // from class: com.hive.analytics.AnalyticsImpl.showConsentModeIfRequire.2
                @Override // com.hive.Analytics.ConsentModeListener
                public void onConsentModeDismissed(ResultAPI result, List<Analytics.ConsentMode.ConsentStatus> statusList) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    Intrinsics.checkNotNullParameter(statusList, "statusList");
                    AnalyticsImpl.INSTANCE.consentTrackingTool(statusList);
                    listener.onConsentModeDismissed(result, statusList);
                }
            });
        } else {
            listener.onConsentModeDismissed(new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, "ConsentMode library missing."), new ArrayList());
        }
    }

    public final boolean sendAnalyticsLog(JSONObject logData) {
        Intrinsics.checkNotNullParameter(logData, "logData");
        return AnalyticsLogTransfer.INSTANCE.sendAnalyticsLog(logData);
    }

    public final void sendRevenueEvent(String eventName, Analytics.AnalyticsRevenue analyticsRevenue) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(analyticsRevenue, "analyticsRevenue");
        AnalyticsProviderAdapter.INSTANCE.sendRevenueEvents(eventName, analyticsRevenue);
    }

    public final void sendUserEntryFunnelsLogs(String funnelTrack, String optionTag) {
        Intrinsics.checkNotNullParameter(funnelTrack, "funnelTrack");
        if (StringsKt.isBlank(funnelTrack)) {
            return;
        }
        HashSet<String> hashSet = usedFunnelStrings;
        if (hashSet.contains(funnelTrack)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(HiveKeys.KEY_category.getValue(), "hive_user_entry_log");
            String value = HiveKeys.KEY_sectionId.getValue();
            Integer numValueOf = Integer.valueOf(funnelTrack);
            Intrinsics.checkNotNullExpressionValue(numValueOf, "valueOf(...)");
            jSONObject.put(value, numValueOf.intValue());
            if (optionTag != null && (!StringsKt.isBlank(optionTag))) {
                jSONObject.put(HiveKeys.KEY_tag3.getValue(), optionTag);
            }
            sendAnalyticsHiveLog(jSONObject);
            hashSet.add(funnelTrack);
        } catch (NumberFormatException e) {
            if (Logger.INSTANCE.getLogEnable()) {
                e.printStackTrace();
            }
        } catch (JSONException e2) {
            if (Logger.INSTANCE.getLogEnable()) {
                e2.printStackTrace();
            }
        }
    }
}
