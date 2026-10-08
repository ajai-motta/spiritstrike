package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;
import io.ktor.http.auth.HttpAuthHeader;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public class zzaqx extends zzapu {
    private final Object zza;
    private final zzapz zzb;

    public zzaqx(int i, String str, zzapz zzapzVar, zzapy zzapyVar) {
        super(i, str, zzapyVar);
        this.zza = new Object();
        this.zzb = zzapzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzapu
    protected final zzaqa zzr(zzapq zzapqVar) {
        String str;
        String str2;
        try {
            byte[] bArr = zzapqVar.zzb;
            Map map = zzapqVar.zzc;
            String str3 = C.ISO88591_NAME;
            if (map != null && (str2 = (String) map.get("Content-Type")) != null) {
                String[] strArrSplit = str2.split(";", 0);
                int i = 1;
                while (true) {
                    if (i >= strArrSplit.length) {
                        break;
                    }
                    String[] strArrSplit2 = strArrSplit[i].trim().split("=", 0);
                    if (strArrSplit2.length == 2 && strArrSplit2[0].equals(HttpAuthHeader.Parameters.Charset)) {
                        str3 = strArrSplit2[1];
                        break;
                    }
                    i++;
                }
            }
            str = new String(bArr, str3);
        } catch (UnsupportedEncodingException unused) {
            str = new String(zzapqVar.zzb);
        }
        return zzaqa.zza(str, zzaqr.zza(zzapqVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzapu
    /* JADX INFO: renamed from: zzz, reason: merged with bridge method [inline-methods] */
    public void zzs(String str) {
        zzapz zzapzVar;
        synchronized (this.zza) {
            zzapzVar = this.zzb;
        }
        zzapzVar.zza(str);
    }
}
