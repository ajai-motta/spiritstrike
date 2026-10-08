package com.google.android.recaptcha.internal;

import java.net.HttpURLConnection;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhm {
    private final zzii zza;

    public zzhm() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public /* synthetic */ zzhm(zzii zziiVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this.zza = new zzii();
    }

    public final zzhl zza(String str) throws zzcg {
        try {
            HttpURLConnection httpURLConnectionZza = this.zza.zza(str);
            httpURLConnectionZza.setRequestMethod("POST");
            httpURLConnectionZza.setDoOutput(true);
            httpURLConnectionZza.setRequestProperty("Content-Type", "application/x-protobuffer");
            return new zzhl(httpURLConnectionZza);
        } catch (zzcg e) {
            throw e;
        } catch (Exception e2) {
            throw new zzcg(zzce.zzc, zzcd.zzai, e2.getMessage(), null, 8, null);
        }
    }
}
