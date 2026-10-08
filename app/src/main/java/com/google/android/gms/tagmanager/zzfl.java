package com.google.android.gms.tagmanager;

import android.util.Log;
import com.google.android.gms.analytics.Logger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.1.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzfl implements Logger {
    zzfl() {
    }

    @Override // com.google.android.gms.analytics.Logger
    public final void error(Exception exc) {
        Log.e("GoogleTagManager", "", exc);
    }

    @Override // com.google.android.gms.analytics.Logger
    public final int getLogLevel() {
        int i = zzdc.zza;
        if (i == 2) {
            return 0;
        }
        if (i == 3 || i == 4) {
            return 1;
        }
        return i != 5 ? 3 : 2;
    }

    @Override // com.google.android.gms.analytics.Logger
    public final void info(String str) {
        zzdc.zzb.zzb(str);
    }

    @Override // com.google.android.gms.analytics.Logger
    public final void setLogLevel(int i) {
        Log.w("GoogleTagManager", "GA uses GTM logger. Please use TagManager.setLogLevel(int) instead.");
    }

    @Override // com.google.android.gms.analytics.Logger
    public final void verbose(String str) {
        zzdc.zzb.zzd(str);
    }

    @Override // com.google.android.gms.analytics.Logger
    public final void warn(String str) {
        Log.w("GoogleTagManager", str);
    }

    @Override // com.google.android.gms.analytics.Logger
    public final void error(String str) {
        Log.e("GoogleTagManager", str);
    }
}
