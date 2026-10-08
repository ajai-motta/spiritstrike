package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.google.common.util.concurrent.ListenableFuture;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzggp implements zzggf {
    private final Context zza;
    private final ExecutorService zzb;
    private final zzfys zzc;
    private final String zzd;
    private final String zze;
    private final zzgjd zzf;
    private final zzggr zzg;

    zzggp(Context context, ExecutorService executorService, zzfxt zzfxtVar, zzfys zzfysVar, zzgjd zzgjdVar, zzggr zzggrVar) {
        this.zza = context;
        this.zzb = executorService;
        this.zzc = zzfysVar;
        this.zzf = zzgjdVar;
        this.zzg = zzggrVar;
        this.zzd = zzfxtVar.zzb();
        this.zze = zzfxtVar.zzi().zzc();
    }

    private static zzfzy zzc(int i) {
        zzfzx zzfzxVarZzd = zzfzy.zzd();
        zzfzxVarZzd.zze(i);
        return (zzfzy) zzfzxVarZzd.zzbu();
    }

    @Override // com.google.android.gms.internal.ads.zzggf
    public final ListenableFuture zza() {
        int i;
        zzazv zzazvVarZza = zzazw.zza();
        byte[] bArrZza = zzarq.zza();
        zzhvi zzhviVar = zzhvi.zzb;
        zzazvVarZza.zza(zzhvi.zzr(bArrZza, 0, bArrZza.length));
        zzazvVarZza.zzb(Build.VERSION.SDK_INT);
        zzazvVarZza.zzc(Build.MODEL);
        Context context = this.zza;
        zzazvVarZza.zzd(context.getPackageName());
        try {
            i = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            i = -1;
        }
        zzfys zzfysVar = this.zzc;
        zzgjd zzgjdVar = this.zzf;
        zzazvVarZza.zze(i);
        zzazvVarZza.zzf(this.zzd);
        ListenableFuture listenableFutureZzk = zzgui.zzk(zzfysVar.zza(Uri.parse(this.zze).buildUpon().appendQueryParameter("aspq", zzfyo.zza(((zzazw) zzazvVarZza.zzbu()).zzaN(), true)).build().toString()), new zzglu() { // from class: com.google.android.gms.internal.ads.zzggo
            @Override // com.google.android.gms.internal.ads.zzglu
            public final /* synthetic */ Object apply(Object obj) {
                return this.zza.zzb((zzfyr) obj);
            }
        }, this.zzb);
        zzgjdVar.zze(20002, listenableFutureZzk);
        return listenableFutureZzk;
    }

    final /* synthetic */ zzfzy zzb(zzfyr zzfyrVar) {
        zzfzy zzfzyVarZzc;
        if (zzfyrVar.zza() != 200) {
            this.zzf.zzc(20003, new String(zzarq.zza(), StandardCharsets.UTF_8));
            return zzc(7);
        }
        try {
            String strZzb = zzfyrVar.zzb();
            if (TextUtils.isEmpty(strZzb)) {
                this.zzf.zzb(20004);
                zzfzyVarZzc = zzc(8);
            } else {
                zzazy zzazyVarZzb = zzazy.zzb(zzfyo.zzb(strZzb, true), zzhvy.zzb());
                if (!zzazyVarZzb.zza().zzc() || !zzazyVarZzb.zza().zza()) {
                    this.zzf.zzb(20004);
                    zzfzyVarZzc = zzc(8);
                } else if (this.zzg.zza(zzazyVarZzb)) {
                    zzfzx zzfzxVarZzd = zzfzy.zzd();
                    zzfzz zzfzzVarZzd = zzgaa.zzd();
                    zzfzzVarZzd.zzb(zzazyVarZzb.zza().zzb());
                    zzfzxVarZzd.zzb(zzfzzVarZzd);
                    zzfzxVarZzd.zzc(zzazyVarZzb.zza().zzd());
                    zzfzxVarZzd.zze(2);
                    zzfzyVarZzc = (zzfzy) zzfzxVarZzd.zzbu();
                } else {
                    this.zzf.zzb(20006);
                    zzfzyVarZzc = zzc(12);
                }
            }
            return zzfzyVarZzc;
        } catch (Throwable th) {
            this.zzf.zzd(20005, th);
            return zzc(6);
        }
    }
}
