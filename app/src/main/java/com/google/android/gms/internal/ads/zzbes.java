package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.ConditionVariable;
import com.applovin.impl.sdk.utils.JsonUtils;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
@ParametersAreNonnullByDefault
public final class zzbes implements SharedPreferences.OnSharedPreferenceChangeListener {
    private Context zzg;
    private final Object zzb = new Object();
    private final ConditionVariable zzc = new ConditionVariable();
    private volatile boolean zzd = false;
    volatile boolean zza = false;
    private SharedPreferences zze = null;
    private Bundle zzf = new Bundle();
    private JSONObject zzh = new JSONObject();
    private boolean zzi = false;
    private boolean zzj = false;

    private final void zzg(final SharedPreferences sharedPreferences) {
        if (sharedPreferences != null) {
            try {
                this.zzh = new JSONObject((String) zzbew.zza(new zzgmv() { // from class: com.google.android.gms.internal.ads.zzbep
                    @Override // com.google.android.gms.internal.ads.zzgmv
                    public final /* synthetic */ Object zza() {
                        return sharedPreferences.getString("flag_configuration", JsonUtils.EMPTY_JSON);
                    }
                }));
            } catch (JSONException unused) {
            }
        }
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if ("flag_configuration".equals(str)) {
            zzg(sharedPreferences);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x0119 A[Catch: all -> 0x0174, DONT_GENERATE, TRY_ENTER, TryCatch #0 {, blocks: (B:7:0x0008, B:9:0x000c, B:11:0x000e, B:13:0x0013, B:14:0x0015, B:16:0x0027, B:17:0x002b, B:18:0x002d, B:38:0x0097, B:39:0x009e, B:48:0x00cd, B:49:0x00d4, B:63:0x0119, B:64:0x0120, B:77:0x0162, B:78:0x0169, B:81:0x016c, B:82:0x0173, B:20:0x0042, B:23:0x004c, B:27:0x0055, B:30:0x0060, B:31:0x0068, B:33:0x006e, B:35:0x007e, B:37:0x0093, B:41:0x00a0, B:43:0x00a4, B:45:0x00b4, B:47:0x00c9, B:51:0x00d6, B:61:0x0115, B:66:0x0122, B:68:0x012f, B:70:0x013d, B:71:0x0146, B:73:0x0154, B:75:0x0158, B:76:0x015b, B:54:0x00e7, B:56:0x00f5, B:58:0x00fd, B:59:0x0108), top: B:88:0x0008, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0122 A[Catch: all -> 0x016b, TRY_ENTER, TryCatch #3 {all -> 0x016b, blocks: (B:20:0x0042, B:23:0x004c, B:27:0x0055, B:30:0x0060, B:31:0x0068, B:33:0x006e, B:35:0x007e, B:37:0x0093, B:41:0x00a0, B:43:0x00a4, B:45:0x00b4, B:47:0x00c9, B:51:0x00d6, B:61:0x0115, B:66:0x0122, B:68:0x012f, B:70:0x013d, B:71:0x0146, B:73:0x0154, B:75:0x0158, B:76:0x015b, B:54:0x00e7, B:56:0x00f5, B:58:0x00fd, B:59:0x0108), top: B:93:0x0042, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza(android.content.Context r11) {
        /*
            Method dump skipped, instruction units count: 375
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbes.zza(android.content.Context):void");
    }

    final boolean zzb() {
        return this.zzi;
    }

    public final boolean zzc() {
        return this.zzj;
    }

    public final Object zzd(final zzbel zzbelVar) {
        if (!this.zzc.block(5000L)) {
            synchronized (this.zzb) {
                if (!this.zza) {
                    throw new IllegalStateException("Flags.initialize() was not called!");
                }
            }
        }
        if (!this.zzd || this.zze == null || this.zzj) {
            synchronized (this.zzb) {
                if (this.zzd && this.zze != null && !this.zzj) {
                }
                return zzbelVar.zzf();
            }
        }
        if (zzbelVar.zzm() != 2) {
            return (zzbelVar.zzm() == 1 && this.zzh.has(zzbelVar.zze())) ? zzbelVar.zzc(this.zzh) : zzbew.zza(new zzgmv() { // from class: com.google.android.gms.internal.ads.zzber
                @Override // com.google.android.gms.internal.ads.zzgmv
                public final /* synthetic */ Object zza() {
                    return this.zza.zzf(zzbelVar);
                }
            });
        }
        Bundle bundle = this.zzf;
        return bundle == null ? zzbelVar.zzf() : zzbelVar.zza(bundle);
    }

    final /* synthetic */ Object zzf(zzbel zzbelVar) {
        return zzbelVar.zzd(this.zze);
    }

    public final Object zze(zzbel zzbelVar) {
        return (this.zzd || this.zza) ? zzd(zzbelVar) : zzbelVar.zzf();
    }
}
