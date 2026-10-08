package com.google.android.recaptcha.internal;

import com.google.android.recaptcha.internal.zzpv;
import com.google.android.recaptcha.internal.zzpw;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzpw<MessageType extends zzpw<MessageType, BuilderType>, BuilderType extends zzpv<MessageType, BuilderType>> implements zzts {
    protected int zza = 0;

    protected static void zzc(Iterable iterable, List list) {
        zzpv.zzd(iterable, list);
    }

    int zza(zzug zzugVar) {
        throw null;
    }

    @Override // com.google.android.recaptcha.internal.zzts
    public final zzqm zzb() {
        try {
            int iZzo = zzo();
            zzqm zzqmVar = zzqm.zzb;
            byte[] bArr = new byte[iZzo];
            int i = zzqv.zzb;
            zzqs zzqsVar = new zzqs(bArr, 0, iZzo);
            zze(zzqsVar);
            zzqsVar.zzC();
            return new zzqk(bArr);
        } catch (IOException e) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a ByteString threw an IOException (should never happen).", e);
        }
    }

    public final byte[] zzd() {
        try {
            int iZzo = zzo();
            byte[] bArr = new byte[iZzo];
            int i = zzqv.zzb;
            zzqs zzqsVar = new zzqs(bArr, 0, iZzo);
            zze(zzqsVar);
            zzqsVar.zzC();
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a byte array threw an IOException (should never happen).", e);
        }
    }
}
