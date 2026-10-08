package com.facebook.appevents.gps.ara;

import android.adservices.common.AdServicesOutcomeReceiver;
import android.adservices.measurement.MeasurementManager;
import android.content.Context;
import android.net.Uri;
import android.os.OutcomeReceiver;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEvent;
import com.facebook.appevents.gps.GpsCapabilityChecker;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.net.URLEncoder;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.Typography;
import org.json.JSONObject;

/* JADX INFO: compiled from: GpsAraTriggersManager.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0002J\u0018\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0007J\u0016\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/facebook/appevents/gps/ara/GpsAraTriggersManager;", "", "()V", "SERVER_URI", "", "TAG", "enabled", "", "canRegisterTrigger", "enable", "", "getEventParameters", "event", "Lcom/facebook/appevents/AppEvent;", "registerTrigger", "applicationId", "registerTriggerAsync", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class GpsAraTriggersManager {
    public static final GpsAraTriggersManager INSTANCE = new GpsAraTriggersManager();
    private static final String SERVER_URI = "https://www.facebook.com/privacy_sandbox/mobile/register/trigger";
    private static final String TAG;
    private static boolean enabled;

    private GpsAraTriggersManager() {
    }

    public static final /* synthetic */ String access$getTAG$p() {
        if (CrashShieldHandler.isObjectCrashing(GpsAraTriggersManager.class)) {
            return null;
        }
        try {
            return TAG;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, GpsAraTriggersManager.class);
            return null;
        }
    }

    static {
        String string = GpsAraTriggersManager.class.toString();
        Intrinsics.checkNotNullExpressionValue(string, "GpsAraTriggersManager::class.java.toString()");
        TAG = string;
    }

    @JvmStatic
    public static final void enable() {
        if (CrashShieldHandler.isObjectCrashing(GpsAraTriggersManager.class)) {
            return;
        }
        try {
            enabled = true;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, GpsAraTriggersManager.class);
        }
    }

    public final void registerTriggerAsync(final String applicationId, final AppEvent event) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(applicationId, "applicationId");
            Intrinsics.checkNotNullParameter(event, "event");
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            FacebookSdk.getExecutor().execute(new Runnable() { // from class: com.facebook.appevents.gps.ara.GpsAraTriggersManager$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    GpsAraTriggersManager.m4743registerTriggerAsync$lambda0(applicationId, event);
                }
            });
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: registerTriggerAsync$lambda-0, reason: not valid java name */
    public static final void m4743registerTriggerAsync$lambda0(String applicationId, AppEvent event) {
        if (CrashShieldHandler.isObjectCrashing(GpsAraTriggersManager.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(applicationId, "$applicationId");
            Intrinsics.checkNotNullParameter(event, "$event");
            INSTANCE.registerTrigger(applicationId, event);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, GpsAraTriggersManager.class);
        }
    }

    public final void registerTrigger(String applicationId, AppEvent event) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(applicationId, "applicationId");
            Intrinsics.checkNotNullParameter(event, "event");
            if (canRegisterTrigger()) {
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                Context applicationContext = FacebookSdk.getApplicationContext();
                try {
                    MeasurementManager measurementManager = (MeasurementManager) applicationContext.getSystemService(MeasurementManager.class);
                    if (measurementManager == null) {
                        measurementManager = MeasurementManager.get(applicationContext.getApplicationContext());
                    }
                    if (measurementManager == null) {
                        Log.w(TAG, "FAILURE_GET_MEASUREMENT_MANAGER");
                        return;
                    }
                    Uri uri = Uri.parse("https://www.facebook.com/privacy_sandbox/mobile/register/trigger?app_id=" + applicationId + Typography.amp + getEventParameters(event));
                    Intrinsics.checkNotNullExpressionValue(uri, "parse(\"$SERVER_URI?$appIdKey=$applicationId&$params\")");
                    GpsCapabilityChecker gpsCapabilityChecker = GpsCapabilityChecker.INSTANCE;
                    if (GpsCapabilityChecker.useOutcomeReceiver()) {
                        OutcomeReceiver<Object, Exception> outcomeReceiver = new OutcomeReceiver<Object, Exception>() { // from class: com.facebook.appevents.gps.ara.GpsAraTriggersManager$registerTrigger$outcomeReceiver$1
                            @Override // android.os.OutcomeReceiver
                            public void onResult(Object result) {
                                Intrinsics.checkNotNullParameter(result, "result");
                                Log.d(GpsAraTriggersManager.access$getTAG$p(), "OUTCOME_RECEIVER_TRIGGER_SUCCESS");
                            }

                            @Override // android.os.OutcomeReceiver
                            public void onError(Exception error) {
                                Intrinsics.checkNotNullParameter(error, "error");
                                Log.d(GpsAraTriggersManager.access$getTAG$p(), "OUTCOME_RECEIVER_TRIGGER_FAILURE");
                            }
                        };
                        FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
                        measurementManager.registerTrigger(uri, FacebookSdk.getExecutor(), outcomeReceiver);
                    } else {
                        AdServicesOutcomeReceiver<Object, Exception> adServicesOutcomeReceiver = new AdServicesOutcomeReceiver<Object, Exception>() { // from class: com.facebook.appevents.gps.ara.GpsAraTriggersManager$registerTrigger$adServicesOutcomeReceiver$1
                            @Override // android.adservices.common.AdServicesOutcomeReceiver
                            public void onResult(Object result) {
                                Intrinsics.checkNotNullParameter(result, "result");
                                Log.d(GpsAraTriggersManager.access$getTAG$p(), "AD_SERVICE_OUTCOME_RECEIVER_TRIGGER_SUCCESS");
                            }

                            @Override // android.adservices.common.AdServicesOutcomeReceiver
                            public void onError(Exception error) {
                                Intrinsics.checkNotNullParameter(error, "error");
                                Log.d(GpsAraTriggersManager.access$getTAG$p(), "AD_SERVICE_OUTCOME_RECEIVER_TRIGGER_FAILURE");
                            }
                        };
                        FacebookSdk facebookSdk3 = FacebookSdk.INSTANCE;
                        measurementManager.registerTrigger(uri, FacebookSdk.getExecutor(), adServicesOutcomeReceiver);
                    }
                } catch (Exception unused) {
                    Log.w(TAG, "FAILURE_TRIGGER_REGISTRATION_FAILED");
                } catch (NoClassDefFoundError unused2) {
                    Log.w(TAG, "FAILURE_TRIGGER_REGISTRATION_NO_CLASS_FOUND");
                } catch (NoSuchMethodError unused3) {
                    Log.w(TAG, "FAILURE_TRIGGER_REGISTRATION_NO_METHOD_FOUND");
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private final boolean canRegisterTrigger() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            if (!enabled) {
                return false;
            }
            try {
                Class.forName("android.adservices.measurement.MeasurementManager");
                return true;
            } catch (Exception unused) {
                Log.i(TAG, "FAILURE_NO_MEASUREMENT_MANAGER_CLASS");
                return false;
            } catch (NoClassDefFoundError unused2) {
                Log.i(TAG, "FAILURE_NO_MEASUREMENT_MANAGER_CLASS_DEF");
                return false;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    private final String getEventParameters(AppEvent event) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            final JSONObject jsonObject = event.getJsonObject();
            if (jsonObject != null && jsonObject.length() != 0) {
                Iterator<String> itKeys = jsonObject.keys();
                Intrinsics.checkNotNullExpressionValue(itKeys, "params.keys()");
                return SequencesKt.joinToString$default(SequencesKt.mapNotNull(SequencesKt.asSequence(itKeys), new Function1<String, String>() { // from class: com.facebook.appevents.gps.ara.GpsAraTriggersManager.getEventParameters.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final String invoke(String str) {
                        Object objOpt = jsonObject.opt(str);
                        if (objOpt == null) {
                            return null;
                        }
                        try {
                            String strEncode = URLEncoder.encode(str, "UTF-8");
                            String strEncode2 = URLEncoder.encode(objOpt.toString(), "UTF-8");
                            StringBuilder sb = new StringBuilder();
                            sb.append((Object) strEncode);
                            sb.append('=');
                            sb.append((Object) strEncode2);
                            return sb.toString();
                        } catch (Exception unused) {
                            return null;
                        }
                    }
                }), "&", null, null, 0, null, null, 62, null);
            }
            return "";
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }
}
