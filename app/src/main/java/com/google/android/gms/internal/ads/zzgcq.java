package com.google.android.gms.internal.ads;

import androidx.exifinterface.media.ExifInterface;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzgcq extends zzgdh {
    zzgcq(zzauc zzaucVar, zzgcd zzgcdVar, zzgjd zzgjdVar) {
        super("dFQH+5qiD2PRdi0XHMSOoNm+a3fekCOGUzmH+eYRmk9bJvOb468Cs8O4aRQ5LdYP", "cV7R50f2/HQumOgCDB4L1ZcSwVOfPPdtbjhx11w36hE=", zzaucVar, zzgcdVar, zzgjdVar.zza(114));
    }

    @Override // com.google.android.gms.internal.ads.zzgdh
    protected final void zza(Method method, zzauc zzaucVar) throws IllegalAccessException, InvocationTargetException {
        synchronized (zzaucVar) {
            zzaucVar.zza(ExifInterface.LONGITUDE_EAST);
            zzaucVar.zzB(0L);
            zzaucVar.zzV("D");
        }
        Object[] objArr = (Object[]) method.invoke("", new Object[0]);
        objArr.getClass();
        Object[] objArr2 = objArr;
        synchronized (zzaucVar) {
            zzaucVar.zza((String) objArr2[0]);
            zzaucVar.zzB(((Long) objArr2[1]).longValue());
            zzaucVar.zzV((String) objArr2[2]);
        }
    }
}
