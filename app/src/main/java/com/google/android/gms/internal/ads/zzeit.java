package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzeit implements zzehq {
    private final Context zza;
    private final zzcsl zzb;
    private View zzc;
    private zzbrs zzd;

    public zzeit(Context context, zzcsl zzcslVar) {
        this.zza = context;
        this.zzb = zzcslVar;
    }

    @Override // com.google.android.gms.internal.ads.zzehq
    public final void zza(zzfgf zzfgfVar, zzffu zzffuVar, zzehn zzehnVar) throws zzfgu {
        try {
            zzbti zzbtiVar = (zzbti) zzehnVar.zzb;
            zzbtiVar.zzo(zzffuVar.zzZ);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zziI)).booleanValue() && zzffuVar.zzag) {
                String str = zzffuVar.zzU;
                String string = zzffuVar.zzv.toString();
                zzfgn zzfgnVar = zzfgfVar.zza.zza;
                zzbtiVar.zzq(str, string, zzfgnVar.zzd, ObjectWrapper.wrap(this.zza), new zzeis(this, zzehnVar, null), (zzbrp) zzehnVar.zzc, zzfgnVar.zzf);
                return;
            }
            String str2 = zzffuVar.zzU;
            String string2 = zzffuVar.zzv.toString();
            zzfgn zzfgnVar2 = zzfgfVar.zza.zza;
            zzbtiVar.zzi(str2, string2, zzfgnVar2.zzd, ObjectWrapper.wrap(this.zza), new zzeis(this, zzehnVar, null), (zzbrp) zzehnVar.zzc, zzfgnVar2.zzf);
        } catch (RemoteException e) {
            throw new zzfgu(e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzehq
    public final /* bridge */ /* synthetic */ Object zzb(zzfgf zzfgfVar, final zzffu zzffuVar, final zzehn zzehnVar) throws zzfgu, zzekz {
        final View view;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zziI)).booleanValue() && zzffuVar.zzag) {
            try {
                view = (View) ObjectWrapper.unwrap(this.zzd.zze());
                boolean zZzf = this.zzd.zzf();
                if (view == null) {
                    throw new zzfgu(new Exception("BannerRtbAdapterWrapper interscrollerView should not be null"));
                }
                if (zZzf) {
                    try {
                        view = (View) zzgui.zzj(zzgui.zza(null), new zzgtq() { // from class: com.google.android.gms.internal.ads.zzeiq
                            @Override // com.google.android.gms.internal.ads.zzgtq
                            public final /* synthetic */ ListenableFuture zza(Object obj) {
                                return this.zza.zzc(view, zzffuVar, obj);
                            }
                        }, zzcbv.zzf).get();
                    } catch (InterruptedException | ExecutionException e) {
                        throw new zzfgu(e);
                    }
                }
            } catch (RemoteException e2) {
                throw new zzfgu(e2);
            }
        } else {
            view = this.zzc;
        }
        zzcrh zzcrhVarZzf = this.zzb.zzf(new zzcue(zzfgfVar, zzffuVar, zzehnVar.zza), new zzcrn(view, null, new zzctm() { // from class: com.google.android.gms.internal.ads.zzeir
            @Override // com.google.android.gms.internal.ads.zzctm
            public final /* synthetic */ com.google.android.gms.ads.internal.client.zzed zza() throws zzfgu {
                try {
                    return ((zzbti) zzehnVar.zzb).zzh();
                } catch (RemoteException e3) {
                    throw new zzfgu(e3);
                }
            }
        }, (zzffv) zzffuVar.zzu.get(0)));
        zzcrhVarZzf.zzk().zza(view);
        ((zzeiz) zzehnVar.zzc).zzc(zzcrhVarZzf.zzg());
        return zzcrhVarZzf.zzi();
    }

    final /* synthetic */ ListenableFuture zzc(View view, zzffu zzffuVar, Object obj) {
        return zzgui.zza(zzcta.zza(this.zza, view, zzffuVar));
    }

    final /* synthetic */ void zzd(View view) {
        this.zzc = view;
    }

    final /* synthetic */ void zze(zzbrs zzbrsVar) {
        this.zzd = zzbrsVar;
    }
}
