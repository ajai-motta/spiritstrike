package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.util.Log;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.1.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzfd implements zzbf {
    private final String zza;
    private final Context zzb;
    private final zzfc zzc;

    zzfd(Context context, zzfc zzfcVar) {
        this.zzb = context.getApplicationContext();
        this.zzc = zzfcVar;
        Locale locale = Locale.getDefault();
        String string = null;
        if (locale != null && locale.getLanguage() != null && locale.getLanguage().length() != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(locale.getLanguage().toLowerCase());
            if (locale.getCountry() != null && locale.getCountry().length() != 0) {
                sb.append("-");
                sb.append(locale.getCountry().toLowerCase());
            }
            string = sb.toString();
        }
        this.zza = String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", "GoogleTagManager", "4.00", Build.VERSION.RELEASE, string, Build.MODEL, Build.ID);
    }

    static final URL zzc(zzbv zzbvVar) {
        try {
            return new URL(zzbvVar.zzc());
        } catch (MalformedURLException unused) {
            Log.e("GoogleTagManager", "Error trying to parse the GTM url.");
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0081 A[Catch: all -> 0x00b5, TryCatch #0 {all -> 0x00b5, blocks: (B:14:0x006e, B:16:0x0081, B:17:0x009b), top: B:37:0x006e }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x009b A[Catch: all -> 0x00b5, TRY_LEAVE, TryCatch #0 {all -> 0x00b5, blocks: (B:14:0x006e, B:16:0x0081, B:17:0x009b), top: B:37:0x006e }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00aa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.google.android.gms.tagmanager.zzbf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza(java.util.List r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 236
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzfd.zza(java.util.List):void");
    }

    @Override // com.google.android.gms.tagmanager.zzbf
    public final boolean zzb() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.zzb.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        zzdc.zzb.zzd("...no network connectivity");
        return false;
    }
}
