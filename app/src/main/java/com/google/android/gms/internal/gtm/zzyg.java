package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzyg;
import com.google.android.gms.internal.gtm.zzyh;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class zzyg<MessageType extends zzyh<MessageType, BuilderType>, BuilderType extends zzyg<MessageType, BuilderType>> implements zzadk {
    @Override // 
    public abstract zzyg zzv();

    protected abstract zzyg zzw(zzyh zzyhVar);

    @Override // com.google.android.gms.internal.gtm.zzadk
    public final /* bridge */ /* synthetic */ zzadk zzx(zzadl zzadlVar) {
        if (zzay().getClass().isInstance(zzadlVar)) {
            return zzw((zzyh) zzadlVar);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }

    @Override // com.google.android.gms.internal.gtm.zzadk
    public /* bridge */ /* synthetic */ zzadk zzy(zzzb zzzbVar, zzabq zzabqVar) throws IOException {
        throw null;
    }
}
