package com.google.android.gms.internal.ads;

import android.webkit.WebView;
import androidx.webkit.Profile;
import androidx.webkit.ProfileStore;
import androidx.webkit.WebViewCompat;
import androidx.webkit.WebViewFeature;
import com.facebook.internal.NativeProtocol;
import com.unity3d.services.core.fid.Constants;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzcix {
    private Profile zza = null;

    zzcix() {
    }

    public final void zza(WebView webView) {
        if (this.zza != null) {
            try {
                WebViewCompat.setProfile(webView, "GMA_WEBVIEW_PROFILE");
                com.google.android.gms.ads.internal.util.zze.zza("WebViewCompat Profile is defined");
            } catch (IllegalStateException e) {
                String strConcat = "WebViewCompat error: ".concat(e.toString());
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzi(strConcat);
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzoO)).booleanValue()) {
                    com.google.android.gms.ads.internal.zzt.zzh().zzg(e, "WebViewCompat.setProfile");
                }
            }
        }
    }

    final void zzb(zzcjb zzcjbVar) {
        ProfileStore profileStore;
        if (!WebViewFeature.isFeatureSupported("MULTI_PROFILE")) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzd("WebViewFeature.MULTI_PROFILE is not supported");
            return;
        }
        try {
            profileStore = (ProfileStore) zzfve.zza("androidx.webkit.ProfileStore", Constants.GET_INSTANCE, new zzfvd[0]);
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | IllegalStateException | NoSuchMethodException | InvocationTargetException e) {
            String message = e.getMessage();
            String.valueOf(message);
            String strValueOf = String.valueOf(message);
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzd("Unable to get ProfileStore instance: ".concat(strValueOf));
            try {
                profileStore = (ProfileStore) zzfve.zza("androidx.webkit.ProfileStore$-CC", Constants.GET_INSTANCE, new zzfvd[0]);
            } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | IllegalStateException | NoSuchMethodException | InvocationTargetException e2) {
                String message2 = e2.getMessage();
                String.valueOf(message2);
                com.google.android.gms.ads.internal.util.client.zzo.zzd("Unable to get ProfileStore instance: ".concat(String.valueOf(message2)));
                profileStore = null;
            }
        }
        if (profileStore != null) {
            this.zza = profileStore.getOrCreateProfile("GMA_WEBVIEW_PROFILE");
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzoN)).booleanValue()) {
                long jElapsedRealtime = com.google.android.gms.ads.internal.zzt.zzk().elapsedRealtime() - zzcjbVar.zza;
                zzdvh zzdvhVarZza = zzcjbVar.zzb.zzd().zza();
                zzdvhVarZza.zzc(NativeProtocol.WEB_DIALOG_ACTION, "webview_p_l");
                zzdvhVarZza.zzc("webview_p_l", Long.toString(jElapsedRealtime));
                zzdvhVarZza.zzd();
                return;
            }
            return;
        }
        int i3 = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzi("WebViewCompat failure: No instance");
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzoN)).booleanValue()) {
            zzdvh zzdvhVarZza2 = zzcjbVar.zzb.zzd().zza();
            zzdvhVarZza2.zzc(NativeProtocol.WEB_DIALOG_ACTION, "webview_p_f");
            zzdvhVarZza2.zzc("webview_p_f", "No instance");
            zzdvhVarZza2.zzd();
        }
    }
}
