package com.google.android.recaptcha.internal;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgz implements zzgs {
    private static Timer zza;
    private final Context zzb;
    private final zzgo zzc;

    public zzgz(Context context) {
        this.zzb = context;
        zzgn zzgnVar = zzgo.zza;
        zzgo zzgoVar = null;
        try {
            zzgo zzgoVar2 = zzgo.zzd;
            zzgoVar2 = zzgoVar2 == null ? new zzgo(context, null) : zzgoVar2;
            zzgo.zzd = zzgoVar2;
            zzgoVar = zzgoVar2;
        } catch (Exception unused) {
        }
        this.zzc = zzgoVar;
        zzh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzf() {
        zzgo zzgoVar = this.zzc;
        if (zzgoVar != null) {
            Iterator it = CollectionsKt.windowed(zzgoVar.zzd(), 20, 20, true).iterator();
            while (it.hasNext()) {
                zzg((List) it.next());
            }
        }
    }

    private final void zzg(List list) {
        zzgo zzgoVar;
        zzzm zzzmVarZzk;
        int iZzN;
        int i;
        zzwo zzwoVarZzi = zzwq.zzi();
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzgp zzgpVar = (zzgp) it.next();
            try {
                zzzmVarZzk = zzzm.zzk(zzpp.zzg().zzj(zzgpVar.zzc()));
                iZzN = zzzmVarZzk.zzN();
                i = iZzN - 1;
            } catch (Exception unused) {
                zzgo zzgoVar2 = this.zzc;
                if (zzgoVar2 != null) {
                    zzgoVar2.zzf(zzgpVar);
                }
            }
            if (iZzN == 0) {
                throw null;
            }
            if (i == 0) {
                zzwoVarZzi.zzq(zzzmVarZzk.zzf());
            } else if (i == 1) {
                zzwoVarZzi.zzr(zzzmVarZzk.zzg());
            } else {
                if (i != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                Unit unit = Unit.INSTANCE;
            }
            arrayList.add(zzgpVar);
        }
        if (zzwoVarZzi.zze() + zzwoVarZzi.zzf() == 0) {
            return;
        }
        byte[] bArrZzd = ((zzwq) zzwoVarZzi.zzk()).zzd();
        try {
            int i2 = zzby.zza;
            if (!((zzha) LazyKt.lazy(zzgt.zza).getValue()).zza(bArrZzd) || (zzgoVar = this.zzc) == null) {
                return;
            }
            zzgoVar.zza(arrayList);
        } catch (Exception unused2) {
        }
    }

    private final void zzh() {
        if (zza == null) {
            Timer timer = new Timer();
            zza = timer;
            timer.schedule(new zzgu(this), 120000L, 120000L);
        }
    }

    @Override // com.google.android.recaptcha.internal.zzgs
    public final void zza(zzzm zzzmVar) {
        try {
            int i = zzby.zza;
            BuildersKt__Builders_commonKt.launch$default(((zzcr) LazyKt.lazy(zzgx.zza).getValue()).zza(), null, null, new zzgy(this, zzzmVar, null), 3, null);
        } catch (Exception unused) {
        }
        zzh();
    }
}
