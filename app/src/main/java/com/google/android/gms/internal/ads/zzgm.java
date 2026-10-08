package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.webkit.ProxyConfig;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzgm extends zzft implements zzgu {
    private final boolean zza;
    private final int zzb;
    private final int zzc;
    private final String zzd;
    private final zzgt zze;
    private final zzgt zzf;
    private zzgf zzg;
    private HttpURLConnection zzh;
    private InputStream zzi;
    private boolean zzj;
    private int zzk;
    private long zzl;
    private long zzm;

    /* synthetic */ zzgm(String str, int i, int i2, boolean z, boolean z2, zzgt zzgtVar, zzgme zzgmeVar, boolean z3, byte[] bArr) {
        super(true);
        this.zzd = str;
        this.zzb = i;
        this.zzc = i2;
        this.zza = z;
        this.zze = zzgtVar;
        this.zzf = new zzgt();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.net.HttpURLConnection zzk(java.net.URL r3, int r4, byte[] r5, long r6, long r8, boolean r10, boolean r11, java.util.Map r12) throws java.io.IOException {
        /*
            r2 = this;
            java.net.URLConnection r3 = r3.openConnection()
            java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3
            int r4 = r2.zzb
            r3.setConnectTimeout(r4)
            int r4 = r2.zzc
            r3.setReadTimeout(r4)
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            com.google.android.gms.internal.ads.zzgt r5 = r2.zze
            java.util.Map r5 = r5.zza()
            r4.putAll(r5)
            com.google.android.gms.internal.ads.zzgt r5 = r2.zzf
            java.util.Map r5 = r5.zza()
            r4.putAll(r5)
            r4.putAll(r12)
            java.util.Set r4 = r4.entrySet()
            java.util.Iterator r4 = r4.iterator()
        L32:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L4e
            java.lang.Object r5 = r4.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            java.lang.Object r12 = r5.getKey()
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r5 = r5.getValue()
            java.lang.String r5 = (java.lang.String) r5
            r3.setRequestProperty(r12, r5)
            goto L32
        L4e:
            r4 = 0
            int r12 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            r0 = -1
            if (r12 != 0) goto L5d
            int r6 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r6 != 0) goto L5c
            r4 = 0
            goto L79
        L5c:
            r6 = r4
        L5d:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "bytes="
            r4.<init>(r5)
            r4.append(r6)
            java.lang.String r5 = "-"
            r4.append(r5)
            int r5 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r5 == 0) goto L75
            long r6 = r6 + r8
            long r6 = r6 + r0
            r4.append(r6)
        L75:
            java.lang.String r4 = r4.toString()
        L79:
            if (r4 == 0) goto L80
            java.lang.String r5 = "Range"
            r3.setRequestProperty(r5, r4)
        L80:
            java.lang.String r4 = r2.zzd
            if (r4 == 0) goto L89
            java.lang.String r5 = "User-Agent"
            r3.setRequestProperty(r5, r4)
        L89:
            r4 = 1
            if (r4 == r10) goto L8f
            java.lang.String r4 = "identity"
            goto L91
        L8f:
            java.lang.String r4 = "gzip"
        L91:
            java.lang.String r5 = "Accept-Encoding"
            r3.setRequestProperty(r5, r4)
            r3.setInstanceFollowRedirects(r11)
            r4 = 0
            r3.setDoOutput(r4)
            int r4 = com.google.android.gms.internal.ads.zzgf.zzh
            java.lang.String r4 = "GET"
            r3.setRequestMethod(r4)
            r3.connect()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgm.zzk(java.net.URL, int, byte[], long, long, boolean, boolean, java.util.Map):java.net.HttpURLConnection");
    }

    private final URL zzl(URL url, String str, zzgf zzgfVar) throws zzgq {
        if (str == null) {
            throw new zzgq("Null location redirect", zzgfVar, 2001, 1);
        }
        try {
            URL url2 = new URL(url, str);
            String protocol = url2.getProtocol();
            if (!"https".equals(protocol) && !ProxyConfig.MATCH_HTTP.equals(protocol)) {
                String.valueOf(protocol);
                throw new zzgq("Unsupported protocol redirect: ".concat(String.valueOf(protocol)), zzgfVar, 2001, 1);
            }
            if (this.zza || protocol.equals(url.getProtocol())) {
                return url2;
            }
            String protocol2 = url.getProtocol();
            StringBuilder sb = new StringBuilder(String.valueOf(protocol2).length() + 40 + String.valueOf(protocol).length() + 1);
            sb.append("Disallowed cross-protocol redirect (");
            sb.append(protocol2);
            sb.append(" to ");
            sb.append(protocol);
            sb.append(")");
            throw new zzgq(sb.toString(), zzgfVar, 2001, 1);
        } catch (MalformedURLException e) {
            throw new zzgq(e, zzgfVar, 2001, 1);
        }
    }

    private final void zzm() {
        HttpURLConnection httpURLConnection = this.zzh;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
                zzdt.zzf("DefaultHttpDataSource", "Unexpected error while disconnecting", e);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x002c A[Catch: IOException -> 0x0036, TRY_LEAVE, TryCatch #0 {IOException -> 0x0036, blocks: (B:4:0x0004, B:6:0x000d, B:9:0x0018, B:10:0x001e, B:13:0x002c), top: B:18:0x0004 }] */
    @Override // com.google.android.gms.internal.ads.zzj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zza(byte[] r7, int r8, int r9) throws com.google.android.gms.internal.ads.zzgq {
        /*
            r6 = this;
            if (r9 != 0) goto L4
            r7 = 0
            goto L35
        L4:
            long r0 = r6.zzl     // Catch: java.io.IOException -> L36
            r2 = -1
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r3 = -1
            if (r2 == 0) goto L1e
            long r4 = r6.zzm     // Catch: java.io.IOException -> L36
            long r0 = r0 - r4
            r4 = 0
            int r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r2 != 0) goto L18
        L16:
            r7 = r3
            goto L35
        L18:
            long r4 = (long) r9     // Catch: java.io.IOException -> L36
            long r0 = java.lang.Math.min(r4, r0)     // Catch: java.io.IOException -> L36
            int r9 = (int) r0     // Catch: java.io.IOException -> L36
        L1e:
            java.io.InputStream r0 = r6.zzi     // Catch: java.io.IOException -> L36
            java.lang.String r1 = com.google.android.gms.internal.ads.zzep.zza     // Catch: java.io.IOException -> L36
            r1 = r0
            java.io.InputStream r1 = (java.io.InputStream) r1     // Catch: java.io.IOException -> L36
            int r7 = r0.read(r7, r8, r9)     // Catch: java.io.IOException -> L36
            if (r7 != r3) goto L2c
            goto L16
        L2c:
            long r8 = r6.zzm     // Catch: java.io.IOException -> L36
            long r0 = (long) r7     // Catch: java.io.IOException -> L36
            long r8 = r8 + r0
            r6.zzm = r8     // Catch: java.io.IOException -> L36
            r6.zzh(r7)     // Catch: java.io.IOException -> L36
        L35:
            return r7
        L36:
            r7 = move-exception
            com.google.android.gms.internal.ads.zzgf r8 = r6.zzg
            java.lang.String r9 = com.google.android.gms.internal.ads.zzep.zza
            r9 = r8
            com.google.android.gms.internal.ads.zzgf r9 = (com.google.android.gms.internal.ads.zzgf) r9
            r9 = 2
            com.google.android.gms.internal.ads.zzgq r7 = com.google.android.gms.internal.ads.zzgq.zza(r7, r8, r9)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgm.zza(byte[], int, int):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00bb  */
    @Override // com.google.android.gms.internal.ads.zzgb
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long zzb(com.google.android.gms.internal.ads.zzgf r26) throws com.google.android.gms.internal.ads.zzgq {
        /*
            Method dump skipped, instruction units count: 523
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgm.zzb(com.google.android.gms.internal.ads.zzgf):long");
    }

    @Override // com.google.android.gms.internal.ads.zzgb
    public final Uri zzc() {
        HttpURLConnection httpURLConnection = this.zzh;
        if (httpURLConnection != null) {
            return Uri.parse(httpURLConnection.getURL().toString());
        }
        zzgf zzgfVar = this.zzg;
        if (zzgfVar != null) {
            return zzgfVar.zza;
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzgb
    public final void zzd() throws zzgq {
        try {
            InputStream inputStream = this.zzi;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    zzgf zzgfVar = this.zzg;
                    String str = zzep.zza;
                    throw new zzgq(e, zzgfVar, 2000, 3);
                }
            }
        } finally {
            this.zzi = null;
            zzm();
            if (this.zzj) {
                this.zzj = false;
                zzi();
            }
            this.zzh = null;
            this.zzg = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzft, com.google.android.gms.internal.ads.zzgb
    public final Map zzj() {
        HttpURLConnection httpURLConnection = this.zzh;
        return httpURLConnection == null ? zzgph.zza() : new zzgl(httpURLConnection.getHeaderFields());
    }
}
