package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.ArrayList;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
@ParametersAreNonnullByDefault
public final class zzeyj implements zzexy {
    public final boolean zza;
    public final boolean zzb;
    public final String zzc;
    public final boolean zzd;
    public final boolean zze;
    public final boolean zzf;
    public final String zzg;
    public final String zzh;

    @Nullable
    public final String zzi;
    public final ArrayList zzj;

    @Nullable
    public final String zzk;

    @Nullable
    public final String zzl;
    public final String zzm;
    public final boolean zzn;
    public final String zzo;
    public final long zzp;
    public final boolean zzq;

    @Nullable
    public final String zzr;
    public final int zzs;

    @Nullable
    public final String zzt;

    public zzeyj(boolean z, boolean z2, String str, boolean z3, boolean z4, boolean z5, String str2, ArrayList arrayList, @Nullable String str3, @Nullable String str4, String str5, boolean z6, String str6, long j, boolean z7, @Nullable String str7, int i, String str8, @Nullable String str9, @Nullable String str10) {
        this.zza = z;
        this.zzb = z2;
        this.zzc = str;
        this.zzd = z3;
        this.zze = z4;
        this.zzf = z5;
        this.zzg = str2;
        this.zzh = str8;
        this.zzj = arrayList;
        this.zzk = str3;
        this.zzl = str4;
        this.zzm = str5;
        this.zzn = z6;
        this.zzo = str6;
        this.zzp = j;
        this.zzq = z7;
        this.zzr = str7;
        this.zzs = i;
        this.zzt = str10;
        this.zzi = str9;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0072  */
    @Override // com.google.android.gms.internal.ads.zzexy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* bridge */ /* synthetic */ void zza(java.lang.Object r5) {
        /*
            Method dump skipped, instruction units count: 345
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeyj.zza(java.lang.Object):void");
    }

    @Override // com.google.android.gms.internal.ads.zzexy
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        Bundle bundle = ((zzcxq) obj).zzb;
        bundle.putBoolean("simulator", this.zzd);
        bundle.putInt("build_api_level", this.zzs);
        ArrayList<String> arrayList = this.zzj;
        if (!arrayList.isEmpty()) {
            bundle.putStringArrayList("hl_list", arrayList);
        }
        bundle.putString("submodel", this.zzo);
    }
}
