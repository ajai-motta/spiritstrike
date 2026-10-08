package com.google.android.gms.ads.nonagon.signalgeneration;

import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.internal.ads.zzbeu;
import com.google.android.gms.internal.ads.zzbgn;
import com.google.android.gms.internal.ads.zzcap;
import com.google.android.gms.internal.ads.zzcaw;
import com.google.android.gms.internal.ads.zzflc;
import com.google.android.gms.internal.ads.zzflm;
import com.google.android.gms.internal.ads.zzguf;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzad implements zzguf {
    final /* synthetic */ ListenableFuture zza;
    final /* synthetic */ zzcaw zzb;
    final /* synthetic */ zzcap zzc;
    final /* synthetic */ zzflc zzd;
    final /* synthetic */ zzau zze;

    zzad(zzau zzauVar, ListenableFuture listenableFuture, zzcaw zzcawVar, zzcap zzcapVar, zzflc zzflcVar) {
        this.zza = listenableFuture;
        this.zzb = zzcawVar;
        this.zzc = zzcapVar;
        this.zzd = zzflcVar;
        Objects.requireNonNull(zzauVar);
        this.zze = zzauVar;
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final void zza(Throwable th) {
        String message = th.getMessage();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zziq)).booleanValue()) {
            com.google.android.gms.ads.internal.zzt.zzh().zzh(th, "SignalGeneratorImpl.generateSignals");
        } else {
            com.google.android.gms.ads.internal.zzt.zzh().zzg(th, "SignalGeneratorImpl.generateSignals");
        }
        zzflm zzflmVarZzy = zzau.zzy(this.zza, this.zzb);
        if (((Boolean) zzbgn.zze.zze()).booleanValue() && zzflmVarZzy != null) {
            zzflc zzflcVar = this.zzd;
            zzflcVar.zzj(th);
            zzflcVar.zzd(false);
            zzflmVarZzy.zza(zzflcVar);
            zzflmVarZzy.zzh();
        }
        zzcap zzcapVar = this.zzc;
        if (zzcapVar == null) {
            return;
        }
        try {
            if (!"Unknown format is no longer supported.".equals(message)) {
                StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 16);
                sb.append("Internal error. ");
                sb.append(message);
                message = sb.toString();
            }
            zzcapVar.zzb(message);
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        ListenableFuture listenableFuture = this.zza;
        AtomicBoolean atomicBooleanZzN = this.zze.zzN();
        zzbj zzbjVar = (zzbj) obj;
        zzflm zzflmVarZzy = zzau.zzy(listenableFuture, this.zzb);
        atomicBooleanZzN.set(true);
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzik)).booleanValue()) {
            try {
                zzcap zzcapVar = this.zzc;
                if (zzcapVar != null) {
                    zzcapVar.zzb("QueryInfo generation has been disabled.");
                }
            } catch (RemoteException e) {
                String strConcat = "QueryInfo generation has been disabled.".concat(e.toString());
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzf(strConcat);
            }
            if (!((Boolean) zzbgn.zze.zze()).booleanValue() || zzflmVarZzy == null) {
                return;
            }
            zzflc zzflcVar = this.zzd;
            zzflcVar.zzk("QueryInfo generation has been disabled.");
            zzflcVar.zzd(false);
            zzflmVarZzy.zza(zzflcVar);
            zzflmVarZzy.zzh();
            return;
        }
        try {
            try {
                if (zzbjVar == null) {
                    zzcap zzcapVar2 = this.zzc;
                    if (zzcapVar2 != null) {
                        zzcapVar2.zzc(null, null, null);
                    }
                    zzflc zzflcVar2 = this.zzd;
                    zzflcVar2.zzd(true);
                    if (!((Boolean) zzbgn.zze.zze()).booleanValue() || zzflmVarZzy == null) {
                        return;
                    }
                    zzflmVarZzy.zza(zzflcVar2);
                    zzflmVarZzy.zzh();
                    return;
                }
                try {
                    if (TextUtils.isEmpty((!TextUtils.isEmpty(zzbjVar.zzc) ? new JSONObject(zzbjVar.zzc) : new JSONObject(zzbjVar.zzb)).optString("request_id", ""))) {
                        int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                        com.google.android.gms.ads.internal.util.client.zzo.zzi("The request ID is empty in request JSON.");
                        zzcap zzcapVar3 = this.zzc;
                        if (zzcapVar3 != null) {
                            zzcapVar3.zzb("Internal error: request ID is empty in request JSON.");
                        }
                        zzflc zzflcVar3 = this.zzd;
                        zzflcVar3.zzk("Request ID empty");
                        zzflcVar3.zzd(false);
                        if (!((Boolean) zzbgn.zze.zze()).booleanValue() || zzflmVarZzy == null) {
                            return;
                        }
                        zzflmVarZzy.zza(zzflcVar3);
                        zzflmVarZzy.zzh();
                        return;
                    }
                    Bundle bundle = zzbjVar.zzf;
                    zzau zzauVar = this.zze;
                    if (zzauVar.zzF() && bundle != null && bundle.getInt(zzauVar.zzH(), -1) == -1) {
                        bundle.putInt(zzauVar.zzH(), zzauVar.zzI().get());
                    }
                    if (zzauVar.zzE() && bundle != null && TextUtils.isEmpty(bundle.getString(zzauVar.zzG()))) {
                        if (TextUtils.isEmpty(zzauVar.zzK())) {
                            zzauVar.zzL(com.google.android.gms.ads.internal.zzt.zzc().zze(zzauVar.zzz(), zzauVar.zzJ().afmaVersion));
                        }
                        bundle.putString(zzauVar.zzG(), zzauVar.zzK());
                    }
                    zzcap zzcapVar4 = this.zzc;
                    if (zzcapVar4 != null) {
                        if (TextUtils.isEmpty(zzbjVar.zzc)) {
                            zzcapVar4.zzc(zzbjVar.zza, zzbjVar.zzb, bundle);
                        } else {
                            zzcapVar4.zzc(zzbjVar.zza, zzbjVar.zzc, bundle);
                        }
                    }
                    this.zzd.zzd(true);
                    if (!((Boolean) zzbgn.zze.zze()).booleanValue() || zzflmVarZzy == null) {
                        return;
                    }
                    zzflmVarZzy.zza(this.zzd);
                    zzflmVarZzy.zzh();
                } catch (JSONException e2) {
                    int i3 = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzi("Failed to create JSON object from the request string.");
                    zzcap zzcapVar5 = this.zzc;
                    if (zzcapVar5 != null) {
                        String string = e2.toString();
                        StringBuilder sb = new StringBuilder(string.length() + 33);
                        sb.append("Internal error for request JSON: ");
                        sb.append(string);
                        zzcapVar5.zzb(sb.toString());
                    }
                    zzflc zzflcVar4 = this.zzd;
                    zzflcVar4.zzj(e2);
                    zzflcVar4.zzd(false);
                    com.google.android.gms.ads.internal.zzt.zzh().zzg(e2, "SignalGeneratorImpl.generateSignals.onSuccess");
                    if (!((Boolean) zzbgn.zze.zze()).booleanValue() || zzflmVarZzy == null) {
                        return;
                    }
                    zzflmVarZzy.zza(zzflcVar4);
                    zzflmVarZzy.zzh();
                }
            } catch (Throwable th) {
                if (((Boolean) zzbgn.zze.zze()).booleanValue() && zzflmVarZzy != null) {
                    zzflmVarZzy.zza(this.zzd);
                    zzflmVarZzy.zzh();
                }
                throw th;
            }
        } catch (RemoteException e3) {
            zzflc zzflcVar5 = this.zzd;
            zzflcVar5.zzj(e3);
            zzflcVar5.zzd(false);
            int i4 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("", e3);
            com.google.android.gms.ads.internal.zzt.zzh().zzg(e3, "SignalGeneratorImpl.generateSignals.onSuccess");
            if (!((Boolean) zzbgn.zze.zze()).booleanValue() || zzflmVarZzy == null) {
                return;
            }
            zzflmVarZzy.zza(this.zzd);
            zzflmVarZzy.zzh();
        }
    }
}
