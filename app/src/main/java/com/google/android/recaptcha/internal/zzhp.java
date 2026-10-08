package com.google.android.recaptcha.internal;

import com.google.common.net.HttpHeaders;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.GZIPInputStream;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhp implements zzhn {
    private final Lazy zza;

    public zzhp() {
        int i = zzby.zza;
        this.zza = LazyKt.lazy(zzho.zza);
    }

    @Override // com.google.android.recaptcha.internal.zzhn
    public final zzxn zza(String str, zzzd zzzdVar) throws zzcg {
        zzcg zzcgVar;
        zzhl zzhlVarZza = null;
        try {
            try {
                zzhlVarZza = ((zzhm) this.zza.getValue()).zza(str);
                zzhlVarZza.zzc();
                zzhlVarZza.zze(zzzdVar.zzd());
                zzts zztsVarZza = zzhlVarZza.zza(zzxn.zzj());
                Intrinsics.checkNotNull(zztsVarZza);
                zzxn zzxnVar = (zzxn) zztsVarZza;
                zzhlVarZza.zzd();
                return zzxnVar;
            } catch (zzcg e) {
                if (zzhlVarZza == null) {
                    throw e;
                }
                if (!Intrinsics.areEqual(e.zza(), zzcd.zzax)) {
                    throw e;
                }
                try {
                    zzcgVar = zzcf.zza(zzzj.zzg(zzhlVarZza.zzb().getErrorStream()).zzi());
                } catch (Exception e2) {
                    zzcgVar = new zzcg(zzce.zzc, zzcd.zzG, e2.getMessage(), null, 8, null);
                }
                throw zzcgVar;
            } catch (Exception e3) {
                throw new zzcg(zzce.zzc, zzcd.zzF, e3.getMessage(), null, 8, null);
            }
        } catch (Throwable th) {
            if (zzhlVarZza != null) {
                zzhlVarZza.zzd();
            }
            throw th;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzhn
    public final String zzb(String str) throws zzcg {
        try {
            try {
                URLConnection uRLConnectionOpenConnection = new URL(str).openConnection();
                Intrinsics.checkNotNull(uRLConnectionOpenConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
                HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT, "application/x-protobuffer");
                httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT_ENCODING, "gzip");
                httpURLConnection.connect();
                if (httpURLConnection.getResponseCode() != 200) {
                    throw new zzcg(zzce.zzc, new zzcd(httpURLConnection.getResponseCode()), null, null, 12, null);
                }
                try {
                    return TextStreamsKt.readText(Intrinsics.areEqual("gzip", httpURLConnection.getContentEncoding()) ? new InputStreamReader(new GZIPInputStream(httpURLConnection.getInputStream())) : new InputStreamReader(httpURLConnection.getInputStream()));
                } catch (Exception unused) {
                    throw new zzcg(zzce.zzc, zzcd.zzP, null, null, 12, null);
                }
            } catch (Exception unused2) {
                throw new zzcg(zzce.zzc, zzcd.zzO, null, null, 12, null);
            }
        } catch (Exception unused3) {
            throw new zzcg(zzce.zzb, zzcd.zzN, null, null, 12, null);
        }
    }
}
