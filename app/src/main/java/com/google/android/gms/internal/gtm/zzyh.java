package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzyg;
import com.google.android.gms.internal.gtm.zzyh;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class zzyh<MessageType extends zzyh<MessageType, BuilderType>, BuilderType extends zzyg<MessageType, BuilderType>> implements zzadl {
    protected int zzb = 0;

    protected static void zzS(Iterable iterable, List list) {
        byte[] bArr = zzaco.zzb;
        int size = ((Collection) iterable).size();
        if (list instanceof ArrayList) {
            ((ArrayList) list).ensureCapacity(list.size() + size);
        } else if (list instanceof zzadu) {
            ((zzadu) list).zzf(list.size() + size);
        }
        int size2 = list.size();
        List list2 = (List) iterable;
        int size3 = list2.size();
        for (int i = 0; i < size3; i++) {
            Object obj = list2.get(i);
            if (obj == null) {
                String str = "Element at index " + (list.size() - size2) + " is null.";
                int size4 = list.size();
                while (true) {
                    size4--;
                    if (size4 < size2) {
                        throw new NullPointerException(str);
                    }
                    list.remove(size4);
                }
            } else {
                list.add(obj);
            }
        }
    }

    int zzQ(zzadx zzadxVar) {
        throw null;
    }

    @Override // com.google.android.gms.internal.gtm.zzadl
    public final zzyx zzR() {
        try {
            int iZzY = zzY();
            zzyx zzyxVar = zzyx.zzb;
            byte[] bArr = new byte[iZzY];
            zzze zzzeVar = new zzze(bArr, 0, iZzY);
            zzax(zzzeVar);
            if (zzzeVar.zzb() == 0) {
                return new zzyv(bArr);
            }
            throw new IllegalStateException("Did not write as much data as expected.");
        } catch (IOException e) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a ByteString threw an IOException (should never happen).", e);
        }
    }

    public final void zzT(OutputStream outputStream) throws IOException {
        int iZzY = zzY();
        int i = zzzi.zzf;
        if (iZzY > 4096) {
            iZzY = 4096;
        }
        zzzg zzzgVar = new zzzg(outputStream, iZzY);
        zzax(zzzgVar);
        zzzgVar.zzI();
    }
}
