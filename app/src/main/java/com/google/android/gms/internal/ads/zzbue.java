package com.google.android.gms.internal.ads;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.provider.CalendarContract;
import android.text.TextUtils;
import com.google.android.gms.ads.impl.R;
import com.google.common.net.HttpHeaders;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzbue extends zzbun {
    private final Map zza;
    private final Context zzb;
    private final String zzc;
    private final long zzd;
    private final long zze;
    private final String zzf;
    private final String zzg;

    public zzbue(zzcgy zzcgyVar, Map map) {
        super(zzcgyVar, "createCalendarEvent");
        this.zza = map;
        this.zzb = zzcgyVar.zzj();
        this.zzc = zzd("description");
        this.zzf = zzd("summary");
        this.zzd = zze("start_ticks");
        this.zze = zze("end_ticks");
        this.zzg = zzd(FirebaseAnalytics.Param.LOCATION);
    }

    private final String zzd(String str) {
        Map map = this.zza;
        return TextUtils.isEmpty((CharSequence) map.get(str)) ? "" : (String) map.get(str);
    }

    private final long zze(String str) {
        String str2 = (String) this.zza.get(str);
        if (str2 == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str2);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public final void zza() {
        Context context = this.zzb;
        if (context == null) {
            zzg("Activity context is not available.");
            return;
        }
        com.google.android.gms.ads.internal.zzt.zzc();
        if (!new zzbeb(context).zzb()) {
            zzg("This feature is not available on the device.");
            return;
        }
        com.google.android.gms.ads.internal.zzt.zzc();
        AlertDialog.Builder builderZzO = com.google.android.gms.ads.internal.util.zzs.zzO(context);
        Resources resourcesZzf = com.google.android.gms.ads.internal.zzt.zzh().zzf();
        builderZzO.setTitle(resourcesZzf != null ? resourcesZzf.getString(R.string.s5) : "Create calendar event");
        builderZzO.setMessage(resourcesZzf != null ? resourcesZzf.getString(R.string.s6) : "Allow Ad to create a calendar event?");
        builderZzO.setPositiveButton(resourcesZzf != null ? resourcesZzf.getString(R.string.s3) : HttpHeaders.ACCEPT, new zzbuc(this));
        builderZzO.setNegativeButton(resourcesZzf != null ? resourcesZzf.getString(R.string.s4) : "Decline", new zzbud(this));
        builderZzO.create().show();
    }

    final Intent zzb() {
        Intent data = new Intent("android.intent.action.EDIT").setData(CalendarContract.Events.CONTENT_URI);
        data.putExtra("title", this.zzc);
        data.putExtra("eventLocation", this.zzg);
        data.putExtra("description", this.zzf);
        long j = this.zzd;
        if (j > -1) {
            data.putExtra("beginTime", j);
        }
        long j2 = this.zze;
        if (j2 > -1) {
            data.putExtra("endTime", j2);
        }
        data.setFlags(268435456);
        return data;
    }

    final /* synthetic */ Context zzc() {
        return this.zzb;
    }
}
