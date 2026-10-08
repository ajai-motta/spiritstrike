package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzfrc implements zzfqd {
    private static final zzfrc zza = new zzfrc();
    private static final Handler zzb = new Handler(Looper.getMainLooper());
    private static Handler zzc = null;
    private static final Runnable zzk = new zzfqy();
    private static final Runnable zzl = new zzfqz();
    private int zze;
    private long zzj;
    private final List zzd = new ArrayList();
    private final List zzf = new ArrayList();
    private final zzfqv zzh = new zzfqv();
    private final zzfqf zzg = new zzfqf();
    private final zzfqw zzi = new zzfqw(new zzfrf());

    zzfrc() {
    }

    public static zzfrc zzb() {
        return zza;
    }

    private final void zzk(View view, zzfqe zzfqeVar, JSONObject jSONObject, int i, boolean z) {
        zzfqeVar.zzb(view, jSONObject, this, i == 1, z);
    }

    private static final void zzl() {
        Handler handler = zzc;
        if (handler != null) {
            handler.removeCallbacks(zzl);
            zzc = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfqd
    public final void zza(View view, zzfqe zzfqeVar, JSONObject jSONObject, boolean z) {
        zzfqv zzfqvVar;
        int iZzl;
        boolean z2;
        if (zzfqt.zza(view) != null || (iZzl = (zzfqvVar = this.zzh).zzl(view)) == 3) {
            return;
        }
        JSONObject jSONObjectZza = zzfqeVar.zza(view);
        zzfqo.zze(jSONObject, jSONObjectZza);
        String strZzg = zzfqvVar.zzg(view);
        if (strZzg != null) {
            zzfqo.zzd(jSONObjectZza, strZzg);
            try {
                jSONObjectZza.put("hasWindowFocus", Boolean.valueOf(this.zzh.zzj(view)));
            } catch (JSONException e) {
                zzfqp.zza("Error with setting has window focus", e);
            }
            boolean zZzk = this.zzh.zzk(strZzg);
            Object objValueOf = Boolean.valueOf(zZzk);
            objValueOf.getClass();
            if (zZzk) {
                try {
                    jSONObjectZza.put("isPipActive", objValueOf);
                } catch (JSONException e2) {
                    zzfqp.zza("Error with setting is picture-in-picture active", e2);
                }
            }
            this.zzh.zzf();
        } else {
            zzfqu zzfquVarZzi = zzfqvVar.zzi(view);
            if (zzfquVarZzi != null) {
                zzfpv zzfpvVarZzb = zzfquVarZzi.zzb();
                JSONArray jSONArray = new JSONArray();
                ArrayList arrayListZzc = zzfquVarZzi.zzc();
                int size = arrayListZzc.size();
                for (int i = 0; i < size; i++) {
                    jSONArray.put((String) arrayListZzc.get(i));
                }
                try {
                    jSONObjectZza.put("isFriendlyObstructionFor", jSONArray);
                    jSONObjectZza.put("friendlyObstructionClass", zzfpvVarZzb.zzb());
                    jSONObjectZza.put("friendlyObstructionPurpose", zzfpvVarZzb.zzc());
                    jSONObjectZza.put("friendlyObstructionReason", zzfpvVarZzb.zzd());
                } catch (JSONException e3) {
                    zzfqp.zza("Error with setting friendly obstruction", e3);
                }
                z2 = true;
            } else {
                z2 = false;
            }
            zzk(view, zzfqeVar, jSONObjectZza, iZzl, z || z2);
        }
        this.zze++;
    }

    public final void zzc() {
        if (zzc == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            zzc = handler;
            handler.post(zzk);
            zzc.postDelayed(zzl, 200L);
        }
    }

    public final void zzd() {
        zzl();
        this.zzd.clear();
        zzb.post(new zzfqx(this));
    }

    public final void zze() {
        zzl();
    }

    final /* synthetic */ void zzf() {
        this.zze = 0;
        this.zzf.clear();
        for (zzfoy zzfoyVar : zzfps.zza().zzf()) {
        }
        this.zzj = System.nanoTime();
        zzfqv zzfqvVar = this.zzh;
        zzfqvVar.zzd();
        zzfqf zzfqfVar = this.zzg;
        long jNanoTime = System.nanoTime();
        zzfqe zzfqeVarZza = zzfqfVar.zza();
        if (zzfqvVar.zzb().size() > 0) {
            for (String str : zzfqvVar.zzb()) {
                JSONObject jSONObjectZza = zzfqeVarZza.zza(null);
                View viewZzh = zzfqvVar.zzh(str);
                zzfqe zzfqeVarZzb = zzfqfVar.zzb();
                String strZzc = zzfqvVar.zzc(str);
                if (strZzc != null) {
                    JSONObject jSONObjectZza2 = zzfqeVarZzb.zza(viewZzh);
                    zzfqo.zzd(jSONObjectZza2, str);
                    try {
                        jSONObjectZza2.put("notVisibleReason", strZzc);
                    } catch (JSONException e) {
                        zzfqp.zza("Error with setting not visible reason", e);
                    }
                    zzfqo.zze(jSONObjectZza, jSONObjectZza2);
                }
                zzfqo.zzf(jSONObjectZza);
                HashSet hashSet = new HashSet();
                hashSet.add(str);
                this.zzi.zzb(jSONObjectZza, hashSet, jNanoTime);
            }
        }
        zzfqv zzfqvVar2 = this.zzh;
        if (zzfqvVar2.zza().size() > 0) {
            JSONObject jSONObjectZza3 = zzfqeVarZza.zza(null);
            zzk(null, zzfqeVarZza, jSONObjectZza3, 1, false);
            zzfqo.zzf(jSONObjectZza3);
            this.zzi.zza(jSONObjectZza3, zzfqvVar2.zza(), jNanoTime);
        } else {
            this.zzi.zzc();
        }
        zzfqvVar2.zze();
        long jNanoTime2 = System.nanoTime() - this.zzj;
        List<zzfrb> list = this.zzd;
        if (list.size() > 0) {
            for (zzfrb zzfrbVar : list) {
                TimeUnit.NANOSECONDS.toMillis(jNanoTime2);
                zzfrbVar.zzb();
                if (zzfrbVar instanceof zzfra) {
                    ((zzfra) zzfrbVar).zza();
                }
            }
        }
        zzfqc.zza().zzc();
    }

    final /* synthetic */ zzfqw zzh() {
        return this.zzi;
    }
}
