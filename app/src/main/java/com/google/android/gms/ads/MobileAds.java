package com.google.android.gms.ads;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import android.webkit.WebView;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsSession;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.internal.client.zzex;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import com.google.android.gms.ads.preload.PreloadCallback;
import com.google.android.gms.ads.preload.PreloadConfiguration;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbvz;
import com.google.android.gms.internal.ads.zzcas;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public class MobileAds {
    public static final String ERROR_DOMAIN = "com.google.android.gms.ads";

    private MobileAds() {
    }

    public static void disableMediationAdapterInitialization(Context context) {
        zzex.zzb().zzl(context);
    }

    public static InitializationStatus getInitializationStatus() {
        return zzex.zzb().zzk();
    }

    private static String getInternalVersion() {
        return zzex.zzb().zzn();
    }

    public static RequestConfiguration getRequestConfiguration() {
        return zzex.zzb().zzo();
    }

    public static VersionInfo getVersion() {
        zzex.zzb();
        String[] strArrSplit = TextUtils.split("24.7.0", "\\.");
        if (strArrSplit.length != 3) {
            return new VersionInfo(0, 0, 0);
        }
        try {
            return new VersionInfo(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]), Integer.parseInt(strArrSplit[2]));
        } catch (NumberFormatException unused) {
            return new VersionInfo(0, 0, 0);
        }
    }

    public static void initialize(Context context) {
        zzex.zzb().zzc(context, null, null);
    }

    public static void openAdInspector(Context context, OnAdInspectorClosedListener onAdInspectorClosedListener) {
        zzex.zzb().zzm(context, onAdInspectorClosedListener);
    }

    public static void openDebugMenu(Context context, String str) {
        zzex.zzb().zzi(context, str);
    }

    public static boolean putPublisherFirstPartyIdEnabled(boolean z) {
        return zzex.zzb().zzq(z);
    }

    public static CustomTabsSession registerCustomTabsSession(Context context, CustomTabsClient customTabsClient, String str, CustomTabsCallback customTabsCallback) {
        zzex.zzb();
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzcas zzcasVarZza = zzbvz.zza(context);
        if (zzcasVarZza == null) {
            zzo.zzf("Internal error, query info generator is null.");
            return null;
        }
        try {
            return (CustomTabsSession) ObjectWrapper.unwrap(zzcasVarZza.zzm(ObjectWrapper.wrap(context), ObjectWrapper.wrap(customTabsClient), str, ObjectWrapper.wrap(customTabsCallback)));
        } catch (RemoteException | IllegalArgumentException e) {
            zzo.zzg("Unable to register custom tabs session. Error: ", e);
            return null;
        }
    }

    public static void registerRtbAdapter(Class<? extends RtbAdapter> cls) {
        zzex.zzb().zzj(cls);
    }

    public static void registerWebView(WebView webView) {
        zzex.zzb();
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (webView == null) {
            zzo.zzf("The webview to be registered cannot be null.");
            return;
        }
        zzcas zzcasVarZza = zzbvz.zza(webView.getContext());
        if (zzcasVarZza == null) {
            zzo.zzf("Internal error, query info generator is null.");
            return;
        }
        try {
            zzcasVarZza.zzj(ObjectWrapper.wrap(webView));
        } catch (RemoteException e) {
            zzo.zzg("", e);
        }
    }

    public static void setAppMuted(boolean z) {
        zzex.zzb().zzg(z);
    }

    public static void setAppVolume(float f) {
        zzex.zzb().zze(f);
    }

    private static void setPlugin(String str) {
        zzex.zzb().zzr(str);
    }

    public static void setRequestConfiguration(RequestConfiguration requestConfiguration) {
        zzex.zzb().zzp(requestConfiguration);
    }

    @Deprecated
    public static void startPreload(Context context, List<PreloadConfiguration> list, PreloadCallback preloadCallback) {
        zzex.zzb().zzd(context, list, preloadCallback);
    }

    public static void initialize(Context context, OnInitializationCompleteListener onInitializationCompleteListener) {
        zzex.zzb().zzc(context, null, onInitializationCompleteListener);
    }
}
