package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import androidx.collection.SimpleArrayMap;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzdlq {
    private int zza;
    private com.google.android.gms.ads.internal.client.zzed zzb;
    private zzbib zzc;
    private View zzd;
    private List zze;
    private com.google.android.gms.ads.internal.client.zzez zzg;
    private Bundle zzh;
    private zzcgy zzi;
    private zzcgy zzj;
    private zzcgy zzk;
    private zzehf zzl;
    private ListenableFuture zzm;
    private zzcca zzn;
    private View zzo;
    private View zzp;
    private IObjectWrapper zzq;
    private double zzr;
    private zzbii zzs;
    private zzbii zzt;
    private String zzu;
    private float zzx;
    private String zzy;
    private final SimpleArrayMap zzv = new SimpleArrayMap();
    private final SimpleArrayMap zzw = new SimpleArrayMap();
    private List zzf = Collections.emptyList();

    public static zzdlq zzaf(zzbry zzbryVar) {
        try {
            return zzak(zzam(zzbryVar.zzn(), zzbryVar), zzbryVar.zzo(), (View) zzal(zzbryVar.zzp()), zzbryVar.zze(), zzbryVar.zzf(), zzbryVar.zzg(), zzbryVar.zzs(), zzbryVar.zzi(), (View) zzal(zzbryVar.zzq()), zzbryVar.zzr(), zzbryVar.zzl(), zzbryVar.zzm(), zzbryVar.zzk(), zzbryVar.zzh(), zzbryVar.zzj(), zzbryVar.zzz());
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Failed to get native ad assets from unified ad mapper", e);
            return null;
        }
    }

    public static zzdlq zzag(zzbrv zzbrvVar) {
        try {
            zzdlp zzdlpVarZzam = zzam(zzbrvVar.zzs(), null);
            zzbib zzbibVarZzt = zzbrvVar.zzt();
            View view = (View) zzal(zzbrvVar.zzr());
            String strZze = zzbrvVar.zze();
            List listZzf = zzbrvVar.zzf();
            String strZzg = zzbrvVar.zzg();
            Bundle bundleZzp = zzbrvVar.zzp();
            String strZzi = zzbrvVar.zzi();
            View view2 = (View) zzal(zzbrvVar.zzu());
            IObjectWrapper iObjectWrapperZzv = zzbrvVar.zzv();
            String strZzj = zzbrvVar.zzj();
            zzbii zzbiiVarZzh = zzbrvVar.zzh();
            zzdlq zzdlqVar = new zzdlq();
            zzdlqVar.zza = 1;
            zzdlqVar.zzb = zzdlpVarZzam;
            zzdlqVar.zzc = zzbibVarZzt;
            zzdlqVar.zzd = view;
            zzdlqVar.zzs("headline", strZze);
            zzdlqVar.zze = listZzf;
            zzdlqVar.zzs(TtmlNode.TAG_BODY, strZzg);
            zzdlqVar.zzh = bundleZzp;
            zzdlqVar.zzs("call_to_action", strZzi);
            zzdlqVar.zzo = view2;
            zzdlqVar.zzq = iObjectWrapperZzv;
            zzdlqVar.zzs("advertiser", strZzj);
            zzdlqVar.zzt = zzbiiVarZzh;
            return zzdlqVar;
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Failed to get native ad from content ad mapper", e);
            return null;
        }
    }

    public static zzdlq zzah(zzbru zzbruVar) {
        try {
            zzdlp zzdlpVarZzam = zzam(zzbruVar.zzt(), null);
            zzbib zzbibVarZzv = zzbruVar.zzv();
            View view = (View) zzal(zzbruVar.zzu());
            String strZze = zzbruVar.zze();
            List listZzf = zzbruVar.zzf();
            String strZzg = zzbruVar.zzg();
            Bundle bundleZzr = zzbruVar.zzr();
            String strZzi = zzbruVar.zzi();
            View view2 = (View) zzal(zzbruVar.zzw());
            IObjectWrapper iObjectWrapperZzx = zzbruVar.zzx();
            String strZzk = zzbruVar.zzk();
            String strZzl = zzbruVar.zzl();
            double dZzj = zzbruVar.zzj();
            zzbii zzbiiVarZzh = zzbruVar.zzh();
            zzdlq zzdlqVar = new zzdlq();
            zzdlqVar.zza = 2;
            zzdlqVar.zzb = zzdlpVarZzam;
            zzdlqVar.zzc = zzbibVarZzv;
            zzdlqVar.zzd = view;
            zzdlqVar.zzs("headline", strZze);
            zzdlqVar.zze = listZzf;
            zzdlqVar.zzs(TtmlNode.TAG_BODY, strZzg);
            zzdlqVar.zzh = bundleZzr;
            zzdlqVar.zzs("call_to_action", strZzi);
            zzdlqVar.zzo = view2;
            zzdlqVar.zzq = iObjectWrapperZzx;
            zzdlqVar.zzs("store", strZzk);
            zzdlqVar.zzs("price", strZzl);
            zzdlqVar.zzr = dZzj;
            zzdlqVar.zzs = zzbiiVarZzh;
            return zzdlqVar;
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Failed to get native ad from app install ad mapper", e);
            return null;
        }
    }

    public static zzdlq zzai(zzbru zzbruVar) {
        try {
            return zzak(zzam(zzbruVar.zzt(), null), zzbruVar.zzv(), (View) zzal(zzbruVar.zzu()), zzbruVar.zze(), zzbruVar.zzf(), zzbruVar.zzg(), zzbruVar.zzr(), zzbruVar.zzi(), (View) zzal(zzbruVar.zzw()), zzbruVar.zzx(), zzbruVar.zzk(), zzbruVar.zzl(), zzbruVar.zzj(), zzbruVar.zzh(), null, 0.0f);
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Failed to get native ad assets from app install ad mapper", e);
            return null;
        }
    }

    public static zzdlq zzaj(zzbrv zzbrvVar) {
        try {
            return zzak(zzam(zzbrvVar.zzs(), null), zzbrvVar.zzt(), (View) zzal(zzbrvVar.zzr()), zzbrvVar.zze(), zzbrvVar.zzf(), zzbrvVar.zzg(), zzbrvVar.zzp(), zzbrvVar.zzi(), (View) zzal(zzbrvVar.zzu()), zzbrvVar.zzv(), null, null, -1.0d, zzbrvVar.zzh(), zzbrvVar.zzj(), 0.0f);
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Failed to get native ad assets from content ad mapper", e);
            return null;
        }
    }

    private static zzdlq zzak(com.google.android.gms.ads.internal.client.zzed zzedVar, zzbib zzbibVar, View view, String str, List list, String str2, Bundle bundle, String str3, View view2, IObjectWrapper iObjectWrapper, String str4, String str5, double d, zzbii zzbiiVar, String str6, float f) {
        zzdlq zzdlqVar = new zzdlq();
        zzdlqVar.zza = 6;
        zzdlqVar.zzb = zzedVar;
        zzdlqVar.zzc = zzbibVar;
        zzdlqVar.zzd = view;
        zzdlqVar.zzs("headline", str);
        zzdlqVar.zze = list;
        zzdlqVar.zzs(TtmlNode.TAG_BODY, str2);
        zzdlqVar.zzh = bundle;
        zzdlqVar.zzs("call_to_action", str3);
        zzdlqVar.zzo = view2;
        zzdlqVar.zzq = iObjectWrapper;
        zzdlqVar.zzs("store", str4);
        zzdlqVar.zzs("price", str5);
        zzdlqVar.zzr = d;
        zzdlqVar.zzs = zzbiiVar;
        zzdlqVar.zzs("advertiser", str6);
        zzdlqVar.zzu(f);
        return zzdlqVar;
    }

    private static Object zzal(IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper == null) {
            return null;
        }
        return ObjectWrapper.unwrap(iObjectWrapper);
    }

    private static zzdlp zzam(com.google.android.gms.ads.internal.client.zzed zzedVar, zzbry zzbryVar) {
        if (zzedVar == null) {
            return null;
        }
        return new zzdlp(zzedVar, zzbryVar);
    }

    public final synchronized View zzA() {
        return this.zzd;
    }

    public final synchronized String zzB() {
        return zzw("headline");
    }

    public final synchronized List zzC() {
        return this.zze;
    }

    public final zzbii zzD() {
        List list = this.zze;
        if (list == null || list.isEmpty()) {
            return null;
        }
        Object obj = this.zze.get(0);
        if (obj instanceof IBinder) {
            return zzbih.zzh((IBinder) obj);
        }
        return null;
    }

    public final synchronized List zzE() {
        return this.zzf;
    }

    public final synchronized com.google.android.gms.ads.internal.client.zzez zzF() {
        return this.zzg;
    }

    public final synchronized String zzG() {
        return zzw(TtmlNode.TAG_BODY);
    }

    public final synchronized Bundle zzH() {
        if (this.zzh == null) {
            this.zzh = new Bundle();
        }
        return this.zzh;
    }

    public final synchronized String zzI() {
        return zzw("call_to_action");
    }

    public final synchronized View zzJ() {
        return this.zzo;
    }

    public final synchronized View zzK() {
        return this.zzp;
    }

    public final synchronized IObjectWrapper zzL() {
        return this.zzq;
    }

    public final synchronized String zzM() {
        return zzw("store");
    }

    public final synchronized String zzN() {
        return zzw("price");
    }

    public final synchronized double zzO() {
        return this.zzr;
    }

    public final synchronized zzbii zzP() {
        return this.zzs;
    }

    public final synchronized String zzQ() {
        return zzw("advertiser");
    }

    public final synchronized zzbii zzR() {
        return this.zzt;
    }

    public final synchronized String zzS() {
        return this.zzu;
    }

    public final synchronized zzcgy zzT() {
        return this.zzi;
    }

    public final synchronized zzcgy zzU() {
        return this.zzj;
    }

    public final synchronized boolean zzV() {
        return this.zzj != null;
    }

    public final synchronized zzcgy zzW() {
        return this.zzk;
    }

    public final synchronized ListenableFuture zzX() {
        return this.zzm;
    }

    public final synchronized zzcca zzY() {
        return this.zzn;
    }

    public final synchronized zzehf zzZ() {
        return this.zzl;
    }

    public final synchronized void zza(int i) {
        this.zza = i;
    }

    public final synchronized SimpleArrayMap zzaa() {
        return this.zzv;
    }

    public final synchronized float zzab() {
        return this.zzx;
    }

    public final synchronized String zzac() {
        return this.zzy;
    }

    public final synchronized SimpleArrayMap zzad() {
        return this.zzw;
    }

    public final synchronized void zzae() {
        zzcgy zzcgyVar = this.zzi;
        if (zzcgyVar != null) {
            zzcgyVar.destroy();
            this.zzi = null;
        }
        zzcgy zzcgyVar2 = this.zzj;
        if (zzcgyVar2 != null) {
            zzcgyVar2.destroy();
            this.zzj = null;
        }
        zzcgy zzcgyVar3 = this.zzk;
        if (zzcgyVar3 != null) {
            zzcgyVar3.destroy();
            this.zzk = null;
        }
        ListenableFuture listenableFuture = this.zzm;
        if (listenableFuture != null) {
            listenableFuture.cancel(false);
            this.zzm = null;
        }
        zzcca zzccaVar = this.zzn;
        if (zzccaVar != null) {
            zzccaVar.cancel(false);
            this.zzn = null;
        }
        this.zzl = null;
        this.zzv.clear();
        this.zzw.clear();
        this.zzb = null;
        this.zzc = null;
        this.zzd = null;
        this.zze = null;
        this.zzh = null;
        this.zzo = null;
        this.zzp = null;
        this.zzq = null;
        this.zzs = null;
        this.zzt = null;
        this.zzu = null;
    }

    public final synchronized void zzb(com.google.android.gms.ads.internal.client.zzed zzedVar) {
        this.zzb = zzedVar;
    }

    public final synchronized void zzc(zzbib zzbibVar) {
        this.zzc = zzbibVar;
    }

    public final synchronized void zzd(List list) {
        this.zze = list;
    }

    public final synchronized void zze(List list) {
        this.zzf = list;
    }

    public final synchronized void zzf(com.google.android.gms.ads.internal.client.zzez zzezVar) {
        this.zzg = zzezVar;
    }

    public final synchronized void zzg(View view) {
        this.zzo = view;
    }

    public final synchronized void zzh(View view) {
        this.zzp = view;
    }

    public final synchronized void zzi(double d) {
        this.zzr = d;
    }

    public final synchronized void zzj(zzbii zzbiiVar) {
        this.zzs = zzbiiVar;
    }

    public final synchronized void zzk(zzbii zzbiiVar) {
        this.zzt = zzbiiVar;
    }

    public final synchronized void zzl(String str) {
        this.zzu = str;
    }

    public final synchronized void zzm(zzcgy zzcgyVar) {
        this.zzi = zzcgyVar;
    }

    public final synchronized void zzn(zzcgy zzcgyVar) {
        this.zzj = zzcgyVar;
    }

    public final synchronized void zzo(zzcgy zzcgyVar) {
        this.zzk = zzcgyVar;
    }

    public final synchronized void zzp(ListenableFuture listenableFuture) {
        this.zzm = listenableFuture;
    }

    public final synchronized void zzq(zzehf zzehfVar) {
        this.zzl = zzehfVar;
    }

    public final synchronized void zzr(zzcca zzccaVar) {
        this.zzn = zzccaVar;
    }

    public final synchronized void zzs(String str, String str2) {
        if (str2 == null) {
            this.zzw.remove(str);
        } else {
            this.zzw.put(str, str2);
        }
    }

    public final synchronized void zzt(String str, zzbht zzbhtVar) {
        if (zzbhtVar == null) {
            this.zzv.remove(str);
        } else {
            this.zzv.put(str, zzbhtVar);
        }
    }

    public final synchronized void zzu(float f) {
        this.zzx = f;
    }

    public final synchronized void zzv(String str) {
        this.zzy = str;
    }

    public final synchronized String zzw(String str) {
        return (String) this.zzw.get(str);
    }

    public final synchronized int zzx() {
        return this.zza;
    }

    public final synchronized com.google.android.gms.ads.internal.client.zzed zzy() {
        return this.zzb;
    }

    public final synchronized zzbib zzz() {
        return this.zzc;
    }
}
