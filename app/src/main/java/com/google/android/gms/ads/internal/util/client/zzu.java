package com.google.android.gms.ads.internal.util.client;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.internal.ads.zzbeu;
import com.google.android.gms.internal.ads.zzbwf;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzu implements zze {
    private final Context zza;
    private final String zzb;
    private String zzc;

    public zzu(Context context, String str) {
        this.zza = context;
        this.zzb = str;
    }

    private final URL zzd(String str) throws MalformedURLException {
        URL urlZze = null;
        try {
            urlZze = new URI(str).toURL();
        } catch (IllegalArgumentException e) {
            e = e;
            zzf(str, e);
        } catch (MalformedURLException e2) {
            e = e2;
            zzf(str, e);
        } catch (URISyntaxException e3) {
            zzf(str, e3);
            if (((Boolean) zzbd.zzc().zzd(zzbeu.zze)).booleanValue()) {
                urlZze = zze(str);
            }
        }
        if (urlZze != null) {
            return urlZze;
        }
        StringBuilder sb = new StringBuilder(str.length() + 47);
        sb.append("Falling back to direct new URL(\"");
        sb.append(str);
        sb.append("\") constructor.");
        zzo.zzd(sb.toString());
        return new URL(str);
    }

    private final URL zze(String str) {
        URL url;
        URI uri;
        try {
            zzo.zzd("Attempting to parse components, encode, and reconstruct URI.");
            URL url2 = new URL(str);
            uri = new URI(url2.getProtocol(), url2.getUserInfo(), url2.getHost(), url2.getPort(), url2.getPath(), url2.getQuery(), url2.getRef());
            url = uri.toURL();
        } catch (IllegalArgumentException | MalformedURLException | URISyntaxException e) {
            e = e;
            url = null;
        }
        try {
            String string = uri.toString();
            StringBuilder sb = new StringBuilder(str.length() + 114 + string.length());
            sb.append("Successfully constructed URL after component encoding via new URI(parts).toURL() for original: \"");
            sb.append(str);
            sb.append("\" -> encoded URI: ");
            sb.append(string);
            zzo.zzd(sb.toString());
        } catch (IllegalArgumentException e2) {
            e = e2;
            zzf(str, e);
        } catch (MalformedURLException e3) {
            e = e3;
            zzf(str, e);
        } catch (URISyntaxException e4) {
            e = e4;
            zzf(str, e);
        }
        return url;
    }

    private final void zzf(String str, Throwable th) {
        String message = th.getMessage();
        StringBuilder sb = new StringBuilder(str.length() + 32 + String.valueOf(message).length());
        sb.append("Error while parsing ping URL: ");
        sb.append(str);
        sb.append(". ");
        sb.append(message);
        zzo.zzi(sb.toString());
        zzbwf.zza(this.zza).zzi(th, "HttpUrlPinger.pingUrl", ((Integer) zzbd.zzc().zzd(zzbeu.zznL)).intValue() / 100.0f);
    }

    @Override // com.google.android.gms.ads.internal.util.client.zze
    public final zzt zza(String str) {
        return zzc(str, null);
    }

    public final String zzb() {
        return this.zzc;
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x0152 A[DONT_GENERATE, PHI: r0
  0x0152: PHI (r0v5 com.google.android.gms.ads.internal.util.client.zzt) = 
  (r0v0 com.google.android.gms.ads.internal.util.client.zzt)
  (r0v4 com.google.android.gms.ads.internal.util.client.zzt)
  (r0v7 com.google.android.gms.ads.internal.util.client.zzt)
 binds: [B:57:0x0150, B:53:0x0146, B:37:0x0104] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.ads.internal.util.client.zzt zzc(java.lang.String r10, java.util.Map r11) {
        /*
            Method dump skipped, instruction units count: 355
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.client.zzu.zzc(java.lang.String, java.util.Map):com.google.android.gms.ads.internal.util.client.zzt");
    }
}
