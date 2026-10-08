package com.adxcorp.ads.mediation.pref;

import android.content.Context;
import android.content.SharedPreferences;
import com.adxcorp.ads.mediation.MediationSDK;
import com.adxcorp.ads.mediation.common.Constants;
import com.adxcorp.util.ADXLogUtil;

/* JADX INFO: loaded from: classes2.dex */
public class Preference {
    public static final String TAG = "Preference";

    public static void putString(Context context, String str, String str2) {
        try {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences(Constants.PREF_NAME, 0).edit();
            editorEdit.putString(str, str2);
            editorEdit.apply();
        } catch (Exception e) {
            if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                ADXLogUtil.e(TAG, e);
            }
        }
    }

    public static void putBoolean(Context context, String str, boolean z) {
        try {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences(Constants.PREF_NAME, 0).edit();
            editorEdit.putBoolean(str, z);
            editorEdit.apply();
        } catch (Exception e) {
            if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                ADXLogUtil.e(TAG, e);
            }
        }
    }

    public static void putInt(Context context, String str, int i) {
        try {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences(Constants.PREF_NAME, 0).edit();
            editorEdit.putInt(str, i);
            editorEdit.apply();
        } catch (Exception e) {
            if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                ADXLogUtil.e(TAG, e);
            }
        }
    }

    public static void putLong(Context context, String str, long j) {
        try {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences(Constants.PREF_NAME, 0).edit();
            editorEdit.putLong(str, j);
            editorEdit.apply();
        } catch (Exception e) {
            if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                ADXLogUtil.e(TAG, e);
            }
        }
    }

    public static String getStringValue(Context context, String str, String str2) {
        try {
            return context.getSharedPreferences(Constants.PREF_NAME, 0).getString(str, str2);
        } catch (Exception e) {
            if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                ADXLogUtil.e(TAG, e);
            }
            return str2;
        }
    }

    public static int getIntValue(Context context, String str, int i) {
        try {
            return context.getSharedPreferences(Constants.PREF_NAME, 0).getInt(str, i);
        } catch (Exception e) {
            if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                ADXLogUtil.e(TAG, e);
            }
            return i;
        }
    }

    public static long getLongValue(Context context, String str, long j) {
        try {
            return context.getSharedPreferences(Constants.PREF_NAME, 0).getLong(str, j);
        } catch (Exception e) {
            if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                ADXLogUtil.e(TAG, e);
            }
            return j;
        }
    }

    public static boolean getBooleanValue(Context context, String str, boolean z) {
        try {
            return context.getSharedPreferences(Constants.PREF_NAME, 0).getBoolean(str, z);
        } catch (Exception e) {
            if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                ADXLogUtil.e(TAG, e);
            }
            return z;
        }
    }

    public static void clear(Context context) {
        try {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences(Constants.PREF_NAME, 0).edit();
            editorEdit.clear();
            editorEdit.commit();
        } catch (Exception e) {
            if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                ADXLogUtil.e(TAG, e);
            }
        }
    }
}
