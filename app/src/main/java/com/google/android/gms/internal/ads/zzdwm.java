package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzdwm {
    public final long zza;
    public final int[] zzb;

    private zzdwm(long j, int[] iArr) {
        this.zza = j;
        this.zzb = iArr;
    }

    public static zzgpe zza(JsonReader jsonReader) throws IOException {
        int[] iArr;
        int i = zzgpe.zzd;
        zzgpb zzgpbVar = new zzgpb();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            zzgpe zzgpeVarZzi = zzgpe.zzi();
            jsonReader.beginObject();
            zzdwm zzdwmVar = null;
            Long lValueOf = null;
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                if (Objects.equals(strNextName, "id")) {
                    lValueOf = Long.valueOf(jsonReader.nextLong());
                } else if (Objects.equals(strNextName, "event_types")) {
                    zzgpb zzgpbVar2 = new zzgpb();
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        zzgpbVar2.zzf(Integer.valueOf(jsonReader.nextInt()));
                    }
                    jsonReader.endArray();
                    zzgpeVarZzi = zzgpbVar2.zzi();
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            if (lValueOf != null && !zzgpeVarZzi.isEmpty()) {
                long jLongValue = lValueOf.longValue();
                if (zzgpeVarZzi == null) {
                    iArr = new int[0];
                } else {
                    int[] iArr2 = new int[zzgpeVarZzi.size()];
                    for (int i2 = 0; i2 < zzgpeVarZzi.size(); i2++) {
                        iArr2[i2] = ((Integer) zzgpeVarZzi.get(i2)).intValue();
                    }
                    iArr = iArr2;
                }
                zzdwmVar = new zzdwm(jLongValue, iArr);
            }
            if (zzdwmVar != null) {
                zzgpbVar.zzf(zzdwmVar);
            }
        }
        jsonReader.endArray();
        return zzgpbVar.zzi();
    }
}
