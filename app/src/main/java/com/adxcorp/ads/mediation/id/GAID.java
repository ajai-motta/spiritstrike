package com.adxcorp.ads.mediation.id;

import android.content.Context;
import android.text.TextUtils;
import com.adxcorp.ads.mediation.pref.Preference;
import com.adxcorp.ads.mediation.util.AsyncTaskUtil;
import com.adxcorp.util.ADXLogUtil;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class GAID {
    public static final String TAG = "GAID";
    private static GAID ourInstance = new GAID();
    private String mId;
    private boolean mIsDoNotTracking;
    private boolean mIsInitialized;

    public static GAID getInstance() {
        return ourInstance;
    }

    public boolean isInitialized() {
        return this.mIsInitialized;
    }

    public void getAdvertisingId(final Context context, final OnGAIDListener onGAIDListener) {
        this.mIsInitialized = false;
        try {
            String stringValue = Preference.getStringValue(context, "UDID_GAID", "");
            boolean booleanValue = Preference.getBooleanValue(context, "DO_NOT_TRACKING", false);
            if (!TextUtils.isEmpty(stringValue)) {
                this.mId = stringValue;
                this.mIsDoNotTracking = booleanValue;
                String str = TAG;
                ADXLogUtil.d(str, "saved gaid:" + this.mId);
                ADXLogUtil.d(str, "saved IsDoNotTracking:" + this.mIsDoNotTracking);
                this.mIsInitialized = true;
                if (onGAIDListener != null) {
                    onGAIDListener.onCompleted(this.mId, this.mIsDoNotTracking);
                }
            }
        } catch (Exception e) {
            ADXLogUtil.e(TAG, e);
        }
        new AsyncTaskUtil() { // from class: com.adxcorp.ads.mediation.id.GAID.1
            @Override // com.adxcorp.ads.mediation.util.AsyncTaskUtil
            public void doInBackground() {
                String str2 = null;
                boolean zBooleanValue = false;
                try {
                    Object objInvoke = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient").getDeclaredMethod("getAdvertisingIdInfo", Context.class).invoke(null, context.getApplicationContext());
                    if (objInvoke != null) {
                        Method declaredMethod = objInvoke.getClass().getDeclaredMethod("getId", new Class[0]);
                        Method declaredMethod2 = objInvoke.getClass().getDeclaredMethod("isLimitAdTrackingEnabled", new Class[0]);
                        String str3 = (String) declaredMethod.invoke(objInvoke, new Object[0]);
                        try {
                            zBooleanValue = ((Boolean) declaredMethod2.invoke(objInvoke, new Object[0])).booleanValue();
                            Preference.putString(context, "UDID_GAID", str3);
                            Preference.putBoolean(context, "DO_NOT_TRACKING", zBooleanValue);
                            ADXLogUtil.d(GAID.TAG, "gaid:" + str3);
                            ADXLogUtil.d(GAID.TAG, "IsDoNotTracking:" + zBooleanValue);
                            str2 = str3;
                        } catch (ClassNotFoundException e2) {
                            e = e2;
                            str2 = str3;
                            ADXLogUtil.e(GAID.TAG, e);
                        } catch (IllegalAccessException e3) {
                            e = e3;
                            str2 = str3;
                            ADXLogUtil.e(GAID.TAG, e);
                        } catch (NoSuchMethodException e4) {
                            e = e4;
                            str2 = str3;
                            ADXLogUtil.e(GAID.TAG, e);
                        } catch (InvocationTargetException e5) {
                            e = e5;
                            str2 = str3;
                            ADXLogUtil.e(GAID.TAG, e);
                        } catch (Exception e6) {
                            e = e6;
                            str2 = str3;
                            ADXLogUtil.e(GAID.TAG, e);
                        }
                    }
                } catch (ClassNotFoundException e7) {
                    e = e7;
                } catch (IllegalAccessException e8) {
                    e = e8;
                } catch (NoSuchMethodException e9) {
                    e = e9;
                } catch (InvocationTargetException e10) {
                    e = e10;
                } catch (Exception e11) {
                    e = e11;
                }
                if (GAID.this.mIsInitialized) {
                    return;
                }
                GAID.this.mIsInitialized = true;
                if (!TextUtils.isEmpty(str2)) {
                    GAID.this.mId = str2;
                    GAID.this.mIsDoNotTracking = zBooleanValue;
                    OnGAIDListener onGAIDListener2 = onGAIDListener;
                    if (onGAIDListener2 != null) {
                        onGAIDListener2.onCompleted(GAID.this.mId, GAID.this.mIsDoNotTracking);
                        return;
                    }
                    return;
                }
                OnGAIDListener onGAIDListener3 = onGAIDListener;
                if (onGAIDListener3 != null) {
                    onGAIDListener3.onFailed();
                }
            }
        }.execute();
    }

    public String getId() {
        return this.mId;
    }

    public boolean isIsDoNotTracking() {
        return this.mIsDoNotTracking;
    }
}
