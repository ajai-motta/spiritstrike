package com.google.android.gms.analytics;

import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.gtm.zzau;
import com.google.android.gms.internal.gtm.zzbh;
import com.google.android.gms.internal.gtm.zzbs;
import com.google.android.gms.internal.gtm.zzbw;
import com.google.android.gms.internal.gtm.zzek;
import com.google.android.gms.internal.gtm.zzff;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzu implements Runnable {
    final /* synthetic */ Map zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ long zzd;
    final /* synthetic */ boolean zze;
    final /* synthetic */ boolean zzf;
    final /* synthetic */ String zzg;
    final /* synthetic */ Tracker zzh;

    zzu(Tracker tracker, Map map, boolean z, String str, long j, boolean z2, boolean z3, String str2) {
        this.zza = map;
        this.zzb = z;
        this.zzc = str;
        this.zzd = j;
        this.zze = z2;
        this.zzf = z3;
        this.zzg = str2;
        this.zzh = tracker;
    }

    @Override // java.lang.Runnable
    public final void run() {
        double d;
        if (this.zzh.zze.zzf()) {
            this.zza.put("sc", TtmlNode.START);
        }
        Map map = this.zza;
        GoogleAnalytics googleAnalyticsZzp = this.zzh.zzp();
        Preconditions.checkNotMainThread("getClientId can not be called from the main thread");
        String strZzb = googleAnalyticsZzp.zzb().zzi().zzb();
        if (strZzb != null && TextUtils.isEmpty((CharSequence) map.get("cid"))) {
            map.put("cid", strZzb);
        }
        String str = (String) this.zza.get("sf");
        if (str != null) {
            try {
                d = Double.parseDouble(str);
            } catch (NumberFormatException unused) {
                d = 100.0d;
            }
            if (zzff.zzj(d, (String) this.zza.get("cid"))) {
                this.zzh.zzF("Sampling enabled. Hit sampled out. sample rate", Double.valueOf(d));
                return;
            }
        }
        Tracker tracker = this.zzh;
        boolean z = this.zzb;
        zzbh zzbhVarZzr = tracker.zzr();
        if (z) {
            Map map2 = this.zza;
            boolean zZzb = zzbhVarZzr.zzb();
            if (!map2.containsKey("ate")) {
                map2.put("ate", true != zZzb ? AppEventsConstants.EVENT_PARAM_VALUE_NO : "1");
            }
            zzff.zzg(this.zza, "adid", zzbhVarZzr.zza());
        } else {
            this.zza.remove("ate");
            this.zza.remove("adid");
        }
        zzau zzauVarZza = this.zzh.zzu().zza();
        zzff.zzg(this.zza, "an", zzauVarZza.zzf());
        zzff.zzg(this.zza, "av", zzauVarZza.zzg());
        zzff.zzg(this.zza, "aid", zzauVarZza.zzd());
        zzff.zzg(this.zza, "aiid", zzauVarZza.zze());
        this.zza.put("v", "1");
        this.zza.put("_v", zzbs.zzb);
        zzff.zzg(this.zza, "ul", this.zzh.zzx().zza().zzd());
        zzff.zzg(this.zza, "sr", this.zzh.zzx().zzb());
        if (!this.zzc.equals("transaction") && !this.zzc.equals("item") && !this.zzh.zzd.zza()) {
            this.zzh.zzz().zzc(this.zza, "Too many hits sent too quickly, rate limiting invoked");
            return;
        }
        long jZza = zzff.zza((String) this.zza.get("ht"));
        if (jZza == 0) {
            jZza = this.zzd;
        }
        long j = jZza;
        if (this.zze) {
            this.zzh.zzz().zzM("Dry run enabled. Would have sent hit", new zzek(this.zzh, this.zza, j, this.zzf));
            return;
        }
        String str2 = (String) this.zza.get("cid");
        HashMap map3 = new HashMap();
        zzff.zzh(map3, "uid", this.zza);
        zzff.zzh(map3, "an", this.zza);
        zzff.zzh(map3, "aid", this.zza);
        zzff.zzh(map3, "av", this.zza);
        zzff.zzh(map3, "aiid", this.zza);
        Preconditions.checkNotNull(str2);
        this.zza.put("_s", String.valueOf(this.zzh.zzs().zza(new zzbw(0L, str2, this.zzg, !TextUtils.isEmpty((CharSequence) this.zza.get("adid")), 0L, map3))));
        this.zzh.zzs().zzh(new zzek(this.zzh, this.zza, j, this.zzf));
    }
}
