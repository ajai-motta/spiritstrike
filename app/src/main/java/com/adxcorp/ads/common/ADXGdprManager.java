package com.adxcorp.ads.common;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.Log;
import com.adxcorp.gdpr.ADXConstants;
import com.adxcorp.gdpr.ADXGDPR;
import com.adxcorp.gdpr.ADXGDPRDialog;
import com.adxcorp.gdpr.AdvertisingInfoTask;
import com.adxcorp.gdpr.CheckInEEATask;
import com.adxcorp.gdpr.SendSDKVersionTask;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;

/* JADX INFO: loaded from: classes2.dex */
public class ADXGdprManager {
    private static final String ADX_RESULT_GDPR = "adx_result_gdpr";
    private static final String ADX_RESULT_MIGRATE_SHAREDPREF = "adx_result_migrate_sharedpref";
    private static final String TAG = "ADXGdprManager";
    private static boolean isLimitTracking;
    private static AdvertisingIdClient.Info mAdvertisingInfo;
    private static Context mContext;

    public interface ADXConsentListener {
        void onResult(ADXGDPR.ADXConsentState aDXConsentState);
    }

    public interface ADXLocateListener {
        void onResult(ADXGDPR.ADXLocate aDXLocate);
    }

    public static void initWithShowAdxConsent(Activity activity, boolean z, ADXGDPR.ADXConsentListener aDXConsentListener) {
        String str = TAG;
        Log.d(str, "ADXLibrary Android ver - " + ADXGDPR.ADX_SDK_VERSION);
        Log.d(str, "Call initWithShowAdxConsent");
        if (activity != null) {
            mContext = activity.getApplicationContext();
            showAdxConsent(activity, z, aDXConsentListener);
        } else {
            Log.e(str, "<CAUTION!> Context should not be null");
            aDXConsentListener.onResult(ADXGDPR.ADXConsentState.ADXConsentStateUnknown);
        }
        sendVersionInformation();
    }

    public static void initWithSaveGDPRState(Context context, final ADXGDPR.ADXConsentState aDXConsentState, final ADXGDPR.ADXConsentListener aDXConsentListener) {
        String str = TAG;
        Log.d(str, "ADXLibrary Android ver - " + ADXGDPR.ADX_SDK_VERSION);
        Log.d(str, "Call initWithShowAdxConsent");
        if (context != null) {
            mContext = context.getApplicationContext();
            new AdvertisingInfoTask(new AdvertisingInfoTask.AdvertisingInfoListener() { // from class: com.adxcorp.ads.common.ADXGdprManager.1
                @Override // com.adxcorp.gdpr.AdvertisingInfoTask.AdvertisingInfoListener
                public void onInfoReceived(AdvertisingIdClient.Info info) {
                    AdvertisingIdClient.Info unused = ADXGdprManager.mAdvertisingInfo = info;
                    boolean unused2 = ADXGdprManager.isLimitTracking = ADXGdprManager.mAdvertisingInfo == null || ADXGdprManager.mAdvertisingInfo.isLimitAdTrackingEnabled();
                    ADXGdprManager.saveResultGDPR(ADXGdprManager.mContext, aDXConsentState);
                    aDXConsentListener.onResult(aDXConsentState);
                }
            }).execute(mContext);
        } else {
            Log.e(str, "<CAUTION!> Context should not be null");
            aDXConsentListener.onResult(ADXGDPR.ADXConsentState.ADXConsentStateUnknown);
        }
        sendVersionInformation();
    }

    /* JADX INFO: renamed from: com.adxcorp.ads.common.ADXGdprManager$2, reason: invalid class name */
    class AnonymousClass2 implements AdvertisingInfoTask.AdvertisingInfoListener {
        final /* synthetic */ Activity val$activity;
        final /* synthetic */ ADXGDPR.ADXConsentListener val$gdprListener;
        final /* synthetic */ boolean val$isDebug;

        AnonymousClass2(Activity activity, boolean z, ADXGDPR.ADXConsentListener aDXConsentListener) {
            this.val$activity = activity;
            this.val$isDebug = z;
            this.val$gdprListener = aDXConsentListener;
        }

        @Override // com.adxcorp.gdpr.AdvertisingInfoTask.AdvertisingInfoListener
        public void onInfoReceived(AdvertisingIdClient.Info info) {
            AdvertisingIdClient.Info unused = ADXGdprManager.mAdvertisingInfo = info;
            boolean unused2 = ADXGdprManager.isLimitTracking = ADXGdprManager.mAdvertisingInfo == null || ADXGdprManager.mAdvertisingInfo.isLimitAdTrackingEnabled();
            if (ADXGdprManager.wasConsentShowing(this.val$activity)) {
                Log.d(ADXGdprManager.TAG, "Already Showing Consent");
                this.val$gdprListener.onResult(ADXGDPR.ADXConsentState.values()[ADXGdprManager.getResultGDPR(ADXGdprManager.mContext)]);
            } else {
                ADXGdprManager.checkInEEAorUnknown(new ADXGDPR.ADXLocateListener() { // from class: com.adxcorp.ads.common.ADXGdprManager.2.1
                    @Override // com.adxcorp.gdpr.ADXGDPR.ADXLocateListener
                    public void onResult(ADXGDPR.ADXLocate aDXLocate) {
                        if (!AnonymousClass2.this.val$isDebug) {
                            if (aDXLocate == ADXGDPR.ADXLocate.ADXLocateNotEEA) {
                                Log.d(ADXGdprManager.TAG, "Locate Not EEA");
                                ADXGdprManager.saveResultGDPR(ADXGdprManager.mContext, ADXGDPR.ADXConsentState.ADXConsentStateNotRequired);
                                AnonymousClass2.this.val$gdprListener.onResult(ADXGDPR.ADXConsentState.ADXConsentStateNotRequired);
                                return;
                            } else if (aDXLocate == ADXGDPR.ADXLocate.ADXLocateCheckFail) {
                                Log.d(ADXGdprManager.TAG, "Locate Check fail");
                                AnonymousClass2.this.val$gdprListener.onResult(ADXGDPR.ADXConsentState.ADXConsentStateUnknown);
                                return;
                            }
                        }
                        try {
                            Log.d(ADXGdprManager.TAG, "Locate EEA");
                            ADXGDPRDialog aDXGDPRDialog = new ADXGDPRDialog(AnonymousClass2.this.val$activity);
                            aDXGDPRDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.adxcorp.ads.common.ADXGdprManager.2.1.1
                                @Override // android.content.DialogInterface.OnDismissListener
                                public void onDismiss(DialogInterface dialogInterface) {
                                    AnonymousClass2.this.val$gdprListener.onResult(ADXGDPR.ADXConsentState.values()[ADXGdprManager.getResultGDPR(ADXGdprManager.mContext)]);
                                }
                            });
                            aDXGDPRDialog.show();
                        } catch (Exception unused3) {
                            Log.d(ADXGdprManager.TAG, "Fail Showing Consent");
                        }
                    }
                });
            }
        }
    }

    private static void showAdxConsent(Activity activity, boolean z, ADXGDPR.ADXConsentListener aDXConsentListener) {
        new AdvertisingInfoTask(new AnonymousClass2(activity, z, aDXConsentListener)).execute(mContext);
    }

    public static void checkInEEAorUnknown(final ADXGDPR.ADXLocateListener aDXLocateListener) {
        new CheckInEEATask(new CheckInEEATask.CheckInEEAListener() { // from class: com.adxcorp.ads.common.ADXGdprManager.3
            @Override // com.adxcorp.gdpr.CheckInEEATask.CheckInEEAListener
            public void onResult(ADXGDPR.ADXLocate aDXLocate) {
                aDXLocateListener.onResult(aDXLocate);
            }
        }).execute();
    }

    public static boolean wasConsentShowing(Context context) {
        try {
            if (context != null) {
                return getSharedPreferences(context).contains(ADX_RESULT_GDPR);
            }
            Log.e(TAG, "<CAUTION!> Context should not be null");
            return true;
        } catch (Exception unused) {
            return true;
        }
    }

    public static void clearConsentShowing(Context context) {
        try {
            if (context != null) {
                getSharedPreferences(context).edit().remove(ADX_RESULT_GDPR).apply();
            } else {
                Log.e(TAG, "<CAUTION!> Context should not be null");
            }
        } catch (Exception unused) {
        }
    }

    public static int getResultGDPR(Context context) {
        if (context != null) {
            if (isLimitTracking) {
                return ADXGDPR.ADXConsentState.ADXConsentStateDenied.ordinal();
            }
            return getSharedPreferences(context).getInt(ADX_RESULT_GDPR, ADXGDPR.ADXConsentState.ADXConsentStateUnknown.ordinal());
        }
        Log.e(TAG, "<CAUTION!> Context should not be null");
        return ADXGDPR.ADXConsentState.ADXConsentStateNotRequired.ordinal();
    }

    public static void saveResultGDPR(Context context, ADXGDPR.ADXConsentState aDXConsentState) {
        try {
            if (context != null) {
                getSharedPreferences(context).edit().putInt(ADX_RESULT_GDPR, aDXConsentState.ordinal()).apply();
            } else {
                Log.e(TAG, "<CAUTION!> Context should not be null");
            }
        } catch (Exception unused) {
        }
    }

    public static String getPrivacyURL() {
        return ADXConstants.ADX_PRIVACY_INFORMATION_URL;
    }

    private static SharedPreferences getSharedPreferences(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                Context contextCreateDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext();
                SharedPreferences sharedPreferences = contextCreateDeviceProtectedStorageContext.getSharedPreferences("adxcorp", 0);
                if (!sharedPreferences.getBoolean(ADX_RESULT_MIGRATE_SHAREDPREF, false)) {
                    if (contextCreateDeviceProtectedStorageContext.moveSharedPreferencesFrom(context, "adxcorp")) {
                        sharedPreferences.edit().putBoolean(ADX_RESULT_MIGRATE_SHAREDPREF, true).apply();
                    } else {
                        Log.e(TAG, "Failed to migrate shared preferences.");
                    }
                }
                context = contextCreateDeviceProtectedStorageContext;
            }
            return context.getSharedPreferences("adxcorp", 0);
        } catch (Exception unused) {
            return null;
        }
    }

    private static void sendVersionInformation() {
        new SendSDKVersionTask().execute(mContext);
    }
}
