package com.hive.module.googlebase;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.security.ProviderInstaller;
import com.hive.HiveActivity;
import com.hive.base.Android;
import com.hive.core.Logger;
import com.hive.module.ModuleCheckName;
import com.hive.module.interfaces.GoogleBase;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HiveModuleGoogleBase.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007JL\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072:\u0010\n\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0015\u0012\u0013\u0018\u00010\u0010¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00050\u000bH\u0017J \u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0014\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u0017H\u0016¨\u0006\u0018"}, d2 = {"Lcom/hive/module/googlebase/HiveModuleGoogleBase;", "Lcom/hive/module/interfaces/GoogleBase;", "<init>", "()V", "installProvider", "", "context", "Landroid/content/Context;", "getAdvertisingClientInfo", "Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$Info;", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", Android.HW_IDS_ADVERTISING_ID, "", Android.HW_IDS_IS_LIMIT_AD_TRACKING, "isGooglePlayServicesAvailable", "show", "minApkVersion", "", "getVersionInfo", "", "hive-service-google-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HiveModuleGoogleBase implements GoogleBase {
    @Override // com.hive.module.interfaces.GoogleBase, com.hive.module.HiveModule
    public String getHiveModuleName() {
        return GoogleBase.DefaultImpls.getHiveModuleName(this);
    }

    @Override // com.hive.module.interfaces.GoogleBase
    public void installProvider(Context context) {
        Object objM7415constructorimpl;
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Result.Companion companion = Result.INSTANCE;
            ProviderInstaller.installIfNeeded(context);
            objM7415constructorimpl = Result.m7415constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
        if (thM7418exceptionOrNullimpl != null) {
            Logger.INSTANCE.w("GoogleBase, ProviderInstaller exception : " + thM7418exceptionOrNullimpl);
        }
    }

    public final AdvertisingIdClient.Info getAdvertisingClientInfo(Context context) throws Exception {
        Intrinsics.checkNotNullParameter(context, "context");
        AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
        Intrinsics.checkNotNullExpressionValue(advertisingIdInfo, "getAdvertisingIdInfo(...)");
        return advertisingIdInfo;
    }

    @Override // com.hive.module.interfaces.GoogleBase
    public void getAdvertisingClientInfo(final Context context, final Function2<? super String, ? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        try {
            Result.Companion companion = Result.INSTANCE;
            new Thread(new Runnable() { // from class: com.hive.module.googlebase.HiveModuleGoogleBase$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    HiveModuleGoogleBase.getAdvertisingClientInfo$lambda$6$lambda$5(this.f$0, context, callback);
                }
            }).start();
            Result.m7415constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getAdvertisingClientInfo$lambda$6$lambda$5(HiveModuleGoogleBase hiveModuleGoogleBase, Context context, Function2 function2) {
        Object objM7415constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(hiveModuleGoogleBase.getAdvertisingClientInfo(context));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m7422isSuccessimpl(objM7415constructorimpl)) {
            AdvertisingIdClient.Info info = (AdvertisingIdClient.Info) objM7415constructorimpl;
            function2.invoke(info.getId(), Boolean.valueOf(info.isLimitAdTrackingEnabled()));
        }
        Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
        if (thM7418exceptionOrNullimpl != null) {
            Logger.INSTANCE.w("GoogleBase, getAdvertisingIdInfo exception : " + thM7418exceptionOrNullimpl);
        }
    }

    @Override // com.hive.module.interfaces.GoogleBase
    public boolean isGooglePlayServicesAvailable(Context context, boolean show, int minApkVersion) {
        final int iIsGooglePlayServicesAvailable;
        final Activity recentActivity;
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            final GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
            Intrinsics.checkNotNullExpressionValue(googleApiAvailability, "getInstance(...)");
            if (minApkVersion == 0) {
                iIsGooglePlayServicesAvailable = googleApiAvailability.isGooglePlayServicesAvailable(context);
            } else {
                iIsGooglePlayServicesAvailable = googleApiAvailability.isGooglePlayServicesAvailable(context, minApkVersion);
            }
            String errorString = googleApiAvailability.getErrorString(iIsGooglePlayServicesAvailable);
            Intrinsics.checkNotNullExpressionValue(errorString, "getErrorString(...)");
            Logger.INSTANCE.d("[isGooglePlayServicesAvailable] isGooglePlayServicesAvailable : " + errorString);
            if (iIsGooglePlayServicesAvailable == 0) {
                return true;
            }
            if ((iIsGooglePlayServicesAvailable != 1 && iIsGooglePlayServicesAvailable != 2 && iIsGooglePlayServicesAvailable != 3 && iIsGooglePlayServicesAvailable != 9 && iIsGooglePlayServicesAvailable != 18) || !show) {
                return false;
            }
            if (context instanceof Activity) {
                recentActivity = (Activity) context;
            } else {
                recentActivity = HiveActivity.isActivityInitialized() ? HiveActivity.INSTANCE.getRecentActivity() : null;
            }
            if (recentActivity == null) {
                return false;
            }
            final int i = 11442;
            recentActivity.runOnUiThread(new Runnable() { // from class: com.hive.module.googlebase.HiveModuleGoogleBase$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    HiveModuleGoogleBase.isGooglePlayServicesAvailable$lambda$8$lambda$7(googleApiAvailability, recentActivity, iIsGooglePlayServicesAvailable, i);
                }
            });
            return false;
        } catch (Exception e) {
            Logger.INSTANCE.w("[isGooglePlayServicesAvailable] isGooglePlayServicesAvailable Exception: " + e.getMessage());
            return false;
        } catch (NoClassDefFoundError e2) {
            Logger.INSTANCE.w("[isGooglePlayServicesAvailable] isGooglePlayServicesAvailable NoClassDefFoundError: " + e2.getMessage());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void isGooglePlayServicesAvailable$lambda$8$lambda$7(GoogleApiAvailability googleApiAvailability, Activity activity, int i, int i2) {
        Dialog errorDialog = googleApiAvailability.getErrorDialog(activity, i, i2);
        if (errorDialog != null) {
            errorDialog.show();
        }
    }

    @Override // com.hive.module.HiveModule
    public Map<String, String> getVersionInfo() {
        HashMap map = new HashMap();
        try {
            Result.Companion companion = Result.INSTANCE;
            Properties properties = new Properties();
            properties.load(HiveActivity.INSTANCE.getRecentActivity().getClassLoader().getResourceAsStream("play-services-ads-identifier.properties"));
            map.put(ModuleCheckName.INSTANCE.getPlay_Services_Ads_Identifier(), properties.getProperty("version"));
            Result.m7415constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        try {
            Result.Companion companion3 = Result.INSTANCE;
            Properties properties2 = new Properties();
            properties2.load(HiveActivity.INSTANCE.getRecentActivity().getClassLoader().getResourceAsStream("play-services-analytics.properties"));
            map.put(ModuleCheckName.INSTANCE.getPlay_Services_Analytics(), properties2.getProperty("version"));
            Result.m7415constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.INSTANCE;
            Result.m7415constructorimpl(ResultKt.createFailure(th2));
        }
        return map;
    }
}
