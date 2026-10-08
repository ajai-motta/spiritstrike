package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.internal.measurement.zzabw;
import com.google.android.gms.internal.measurement.zzabx;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzof {
    static final ImmutableList zza = ImmutableList.of("Version", "GoogleConsent", "VendorConsent", "VendorLegitimateInterest", "gdprApplies", "EnableAdvertiserConsentMode", "PolicyVersion", "PurposeConsents", "PurposeOneTreatment", "Purpose1", "Purpose3", "Purpose4", "Purpose7", "CmpSdkID", "PublisherCC", "PublisherRestrictions1", "PublisherRestrictions3", "PublisherRestrictions4", "PublisherRestrictions7", "AuthorizePurpose1", "AuthorizePurpose3", "AuthorizePurpose4", "AuthorizePurpose7", "PurposeDiagnostics");
    public static final /* synthetic */ int zzb = 0;

    static String zza(SharedPreferences sharedPreferences, String str) {
        try {
            return sharedPreferences.getString(str, "");
        } catch (ClassCastException unused) {
            return "";
        }
    }

    static int zzb(SharedPreferences sharedPreferences, String str) {
        try {
            return sharedPreferences.getInt(str, -1);
        } catch (ClassCastException unused) {
            return -1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0200  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static final boolean zzc(com.google.android.gms.internal.measurement.zzabw r21, com.google.common.collect.ImmutableMap r22, com.google.common.collect.ImmutableMap r23, com.google.common.collect.ImmutableSet r24, char[] r25, int r26, int r27, int r28, int r29, int r30, java.lang.String r31, java.lang.String r32, java.lang.String r33, boolean r34, boolean r35, boolean r36) {
        /*
            Method dump skipped, instruction units count: 601
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzof.zzc(com.google.android.gms.internal.measurement.zzabw, com.google.common.collect.ImmutableMap, com.google.common.collect.ImmutableMap, com.google.common.collect.ImmutableSet, char[], int, int, int, int, int, java.lang.String, java.lang.String, java.lang.String, boolean, boolean, boolean):boolean");
    }

    public static final Map zzd(ImmutableMap immutableMap, ImmutableMap immutableMap2, ImmutableSet immutableSet, char[] cArr, int i, int i2, int i3, int i4, int i5, String str, String str2, String str3, boolean z, boolean z2, boolean z3) {
        if (!z3) {
            return ImmutableMap.of();
        }
        zzabw zzabwVar = zzabw.IAB_TCF_PURPOSE_STORE_AND_ACCESS_INFORMATION_ON_A_DEVICE;
        zzabx zzabxVar = (zzabx) immutableMap2.get(zzabwVar);
        zzabw zzabwVar2 = zzabw.IAB_TCF_PURPOSE_CREATE_A_PERSONALISED_ADS_PROFILE;
        zzabx zzabxVar2 = (zzabx) immutableMap2.get(zzabwVar2);
        zzabw zzabwVar3 = zzabw.IAB_TCF_PURPOSE_SELECT_PERSONALISED_ADS;
        zzabx zzabxVar3 = (zzabx) immutableMap2.get(zzabwVar3);
        zzabw zzabwVar4 = zzabw.IAB_TCF_PURPOSE_MEASURE_AD_PERFORMANCE;
        zzabx zzabxVar4 = (zzabx) immutableMap2.get(zzabwVar4);
        return ImmutableMap.builder().put("Version", "2").put("VendorConsent", true != z ? AppEventsConstants.EVENT_PARAM_VALUE_NO : "1").put("VendorLegitimateInterest", true != z2 ? AppEventsConstants.EVENT_PARAM_VALUE_NO : "1").put("gdprApplies", i3 != 1 ? AppEventsConstants.EVENT_PARAM_VALUE_NO : "1").put("EnableAdvertiserConsentMode", i2 != 1 ? AppEventsConstants.EVENT_PARAM_VALUE_NO : "1").put("PolicyVersion", String.valueOf(i4)).put("CmpSdkID", String.valueOf(i)).put("PurposeOneTreatment", i5 != 1 ? AppEventsConstants.EVENT_PARAM_VALUE_NO : "1").put("PublisherCC", str).put("PublisherRestrictions1", String.valueOf(zzabxVar != null ? zzabxVar.zza() : zzabx.PURPOSE_RESTRICTION_UNDEFINED.zza())).put("PublisherRestrictions3", String.valueOf(zzabxVar2 != null ? zzabxVar2.zza() : zzabx.PURPOSE_RESTRICTION_UNDEFINED.zza())).put("PublisherRestrictions4", String.valueOf(zzabxVar3 != null ? zzabxVar3.zza() : zzabx.PURPOSE_RESTRICTION_UNDEFINED.zza())).put("PublisherRestrictions7", String.valueOf(zzabxVar4 != null ? zzabxVar4.zza() : zzabx.PURPOSE_RESTRICTION_UNDEFINED.zza())).putAll(ImmutableMap.of("Purpose1", zzf(zzabwVar, immutableMap, immutableMap2, immutableSet, cArr, i, i2, i3, i4, i5, str, str2, str3, z, z2, true), "Purpose3", zzf(zzabwVar2, immutableMap, immutableMap2, immutableSet, cArr, i, i2, i3, i4, i5, str, str2, str3, z, z2, true), "Purpose4", zzf(zzabwVar3, immutableMap, immutableMap2, immutableSet, cArr, i, i2, i3, i4, i5, str, str2, str3, z, z2, true), "Purpose7", zzf(zzabwVar4, immutableMap, immutableMap2, immutableSet, cArr, i, i2, i3, i4, i5, str, str2, str3, z, z2, true))).putAll(ImmutableMap.of("AuthorizePurpose1", (String) (true != zzc(zzabwVar, immutableMap, immutableMap2, immutableSet, cArr, i, i2, i3, i4, i5, str, str2, str3, z, z2, true) ? AppEventsConstants.EVENT_PARAM_VALUE_NO : "1"), "AuthorizePurpose3", (String) (true != zzc(zzabwVar2, immutableMap, immutableMap2, immutableSet, cArr, i, i2, i3, i4, i5, str, str2, str3, z, z2, true) ? AppEventsConstants.EVENT_PARAM_VALUE_NO : "1"), "AuthorizePurpose4", (String) (true != zzc(zzabwVar3, immutableMap, immutableMap2, immutableSet, cArr, i, i2, i3, i4, i5, str, str2, str3, z, z2, true) ? AppEventsConstants.EVENT_PARAM_VALUE_NO : "1"), "AuthorizePurpose7", true != zzc(zzabwVar4, immutableMap, immutableMap2, immutableSet, cArr, i, i2, i3, i4, i5, str, str2, str3, z, z2, true) ? AppEventsConstants.EVENT_PARAM_VALUE_NO : "1", "PurposeDiagnostics", new String(cArr))).buildOrThrow();
    }

    private static final int zze(zzabw zzabwVar, ImmutableMap immutableMap, ImmutableMap immutableMap2, ImmutableSet immutableSet, char[] cArr, int i, int i2, int i3, int i4, int i5, String str, String str2, String str3, boolean z, boolean z2, boolean z3) {
        if (zzabwVar == zzabw.IAB_TCF_PURPOSE_STORE_AND_ACCESS_INFORMATION_ON_A_DEVICE) {
            return 1;
        }
        if (zzabwVar == zzabw.IAB_TCF_PURPOSE_CREATE_A_PERSONALISED_ADS_PROFILE) {
            return 2;
        }
        if (zzabwVar == zzabw.IAB_TCF_PURPOSE_SELECT_PERSONALISED_ADS) {
            return 3;
        }
        return zzabwVar == zzabw.IAB_TCF_PURPOSE_MEASURE_AD_PERFORMANCE ? 4 : -1;
    }

    private static final String zzf(zzabw zzabwVar, ImmutableMap immutableMap, ImmutableMap immutableMap2, ImmutableSet immutableSet, char[] cArr, int i, int i2, int i3, int i4, int i5, String str, String str2, String str3, boolean z, boolean z2, boolean z3) {
        boolean zIsEmpty = TextUtils.isEmpty(str2);
        String strValueOf = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        String strValueOf2 = (zIsEmpty || str2.length() < zzabwVar.zza()) ? AppEventsConstants.EVENT_PARAM_VALUE_NO : String.valueOf(str2.charAt(zzabwVar.zza() - 1));
        if (!TextUtils.isEmpty(str3) && str3.length() >= zzabwVar.zza()) {
            strValueOf = String.valueOf(str3.charAt(zzabwVar.zza() - 1));
        }
        String.valueOf(strValueOf2);
        String.valueOf(strValueOf);
        return String.valueOf(strValueOf2).concat(String.valueOf(strValueOf));
    }

    private static final boolean zzg(zzabw zzabwVar, ImmutableMap immutableMap, ImmutableMap immutableMap2, ImmutableSet immutableSet, char[] cArr, int i, int i2, int i3, int i4, int i5, String str, String str2, String str3, boolean z, boolean z2, boolean z3) {
        char c;
        int iZze = zze(zzabwVar, immutableMap, immutableMap2, immutableSet, cArr, i, i2, i3, i4, i5, str, str2, str3, z, z2, true);
        if (!z) {
            c = '4';
        } else {
            if (str2.length() >= zzabwVar.zza()) {
                char cCharAt = str2.charAt(zzabwVar.zza() - 1);
                boolean z4 = cCharAt == '1';
                if (iZze > 0 && cArr[iZze] != '2') {
                    cArr[iZze] = cCharAt != '1' ? '6' : '1';
                }
                return z4;
            }
            c = '0';
        }
        if (iZze > 0 && cArr[iZze] != '2') {
            cArr[iZze] = c;
        }
        return false;
    }

    private static final boolean zzh(zzabw zzabwVar, ImmutableMap immutableMap, ImmutableMap immutableMap2, ImmutableSet immutableSet, char[] cArr, int i, int i2, int i3, int i4, int i5, String str, String str2, String str3, boolean z, boolean z2, boolean z3) {
        char c;
        int iZze = zze(zzabwVar, immutableMap, immutableMap2, immutableSet, cArr, i, i2, i3, i4, i5, str, str2, str3, z, z2, true);
        if (!z2) {
            c = '5';
        } else {
            if (str3.length() >= zzabwVar.zza()) {
                char cCharAt = str3.charAt(zzabwVar.zza() - 1);
                boolean z4 = cCharAt == '1';
                if (iZze > 0 && cArr[iZze] != '2') {
                    cArr[iZze] = cCharAt != '1' ? '7' : '1';
                }
                return z4;
            }
            c = '0';
        }
        if (iZze > 0 && cArr[iZze] != '2') {
            cArr[iZze] = c;
        }
        return false;
    }

    private static final zzabx zzi(zzabw zzabwVar, ImmutableMap immutableMap, ImmutableMap immutableMap2, ImmutableSet immutableSet, char[] cArr, int i, int i2, int i3, int i4, int i5, String str, String str2, String str3, boolean z, boolean z2, boolean z3) {
        return (zzabx) immutableMap2.getOrDefault(zzabwVar, zzabx.PURPOSE_RESTRICTION_UNDEFINED);
    }
}
