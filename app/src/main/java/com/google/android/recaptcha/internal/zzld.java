package com.google.android.recaptcha.internal;

import android.webkit.JavascriptInterface;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlinx.coroutines.CompletableDeferred;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzld {
    final /* synthetic */ zzly zza;
    private Long zzb;
    private final zzmf zzc = zzmf.zzb();

    public zzld(zzly zzlyVar) {
        this.zza = zzlyVar;
    }

    private final void zzb() {
        if (this.zzb == null) {
            zzmf zzmfVar = this.zzc;
            zzmfVar.zzf();
            this.zzb = Long.valueOf(zzmfVar.zza(TimeUnit.MILLISECONDS));
        }
    }

    public final Long zza() {
        return this.zzb;
    }

    @JavascriptInterface
    public final void zzlce(String str) throws zzsx {
        zzly zzlyVar = this.zza;
        Long l = zzlyVar.zzr().zzb;
        zzb();
        zzwn zzwnVarZzM = zzwn.zzM(zzdb.zza(str));
        zzzl zzzlVarZzi = zzzm.zzi();
        zzzlVarZzi.zzf(zzwnVarZzM);
        zzly.zzo(zzlyVar).zza((zzzm) zzzlVarZzi.zzk());
    }

    @JavascriptInterface
    public final void zzlsm(String str) {
        zzb();
        zzzl zzzlVarZzi = zzzm.zzi();
        zzzlVarZzi.zzq(zzxc.zzi(zzdb.zza(str)));
        zzly.zzo(this.zza).zza((zzzm) zzzlVarZzi.zzk());
    }

    @JavascriptInterface
    public final void zzoid(String str) throws zzsx {
        zzb();
        zzzh zzzhVarZzg = zzzh.zzg(zzdb.zza(str));
        zzzhVarZzg.zzi().name();
        if (zzzhVarZzg.zzi() == zzzk.JS_CODE_SUCCESS) {
            zzly zzlyVar = this.zza;
            zzlyVar.zzz().hashCode();
            if (zzlyVar.zzz().complete(Unit.INSTANCE)) {
                return;
            }
            zzlyVar.zzz().hashCode();
            return;
        }
        zzzhVarZzg.zzi().name();
        int i = zzcg.zza;
        zzcg zzcgVarZza = zzcf.zza(zzzhVarZzg.zzi());
        zzly zzlyVar2 = this.zza;
        zzlyVar2.zzz().hashCode();
        zzlyVar2.zzz().completeExceptionally(zzcgVarZza);
    }

    @JavascriptInterface
    public final void zzrp(String str) {
        zzb();
        zzik zzikVar = this.zza.zzb;
        if (zzikVar == null) {
            zzikVar = null;
        }
        zzikVar.zza(str);
    }

    @JavascriptInterface
    public final void zzscd(String str) throws zzsx {
        zzb();
        zzxx zzxxVarZzi = zzxx.zzi(zzdb.zza(str));
        zzxxVarZzi.toString();
        CompletableDeferred completableDeferred = (CompletableDeferred) this.zza.zzd.remove(zzxxVarZzi.zzk());
        if (completableDeferred != null) {
            completableDeferred.complete(zzxxVarZzi);
        }
    }
}
