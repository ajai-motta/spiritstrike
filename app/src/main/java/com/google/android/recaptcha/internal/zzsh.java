package com.google.android.recaptcha.internal;

import com.google.android.recaptcha.internal.zzsh;
import com.google.android.recaptcha.internal.zzsn;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public class zzsh<MessageType extends zzsn<MessageType, BuilderType>, BuilderType extends zzsh<MessageType, BuilderType>> extends zzpv<MessageType, BuilderType> {
    protected zzsn zza;
    private final zzsn zzb;

    protected zzsh(MessageType messagetype) {
        this.zzb = messagetype;
        if (messagetype.zzL()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.zza = messagetype.zzv();
    }

    private static void zze(Object obj, Object obj2) {
        zzuc.zza().zzb(obj.getClass()).zzg(obj, obj2);
    }

    @Override // com.google.android.recaptcha.internal.zzpv
    protected final /* synthetic */ zzpv zzb(zzpw zzpwVar) {
        zzh((zzsn) zzpwVar);
        return this;
    }

    @Override // com.google.android.recaptcha.internal.zzpv
    /* JADX INFO: renamed from: zzg, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final zzsh zza() {
        zzsh zzshVar = (zzsh) this.zzb.zzh(5, null, null);
        zzshVar.zza = zzl();
        return zzshVar;
    }

    public final zzsh zzh(zzsn zzsnVar) {
        if (!this.zzb.equals(zzsnVar)) {
            if (!this.zza.zzL()) {
                zzo();
            }
            zze(this.zza, zzsnVar);
        }
        return this;
    }

    @Override // com.google.android.recaptcha.internal.zztr
    /* JADX INFO: renamed from: zzi, reason: merged with bridge method [inline-methods] */
    public final MessageType zzk() {
        MessageType messagetype = (MessageType) zzl();
        if (messagetype.zzp()) {
            return messagetype;
        }
        throw new zzuu(messagetype);
    }

    @Override // com.google.android.recaptcha.internal.zztr
    /* JADX INFO: renamed from: zzj, reason: merged with bridge method [inline-methods] */
    public MessageType zzl() {
        if (!this.zza.zzL()) {
            return (MessageType) this.zza;
        }
        this.zza.zzG();
        return (MessageType) this.zza;
    }

    @Override // com.google.android.recaptcha.internal.zztt
    public final /* synthetic */ zzts zzm() {
        return this.zzb;
    }

    protected final void zzn() {
        if (this.zza.zzL()) {
            return;
        }
        zzo();
    }

    protected void zzo() {
        zzsn zzsnVarZzv = this.zzb.zzv();
        zze(zzsnVarZzv, this.zza);
        this.zza = zzsnVarZzv;
    }

    @Override // com.google.android.recaptcha.internal.zztt
    public final boolean zzp() {
        return zzsn.zzj(this.zza, false);
    }
}
