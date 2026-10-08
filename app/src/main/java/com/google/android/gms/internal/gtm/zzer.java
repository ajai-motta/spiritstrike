package com.google.android.gms.internal.gtm;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import com.google.android.gms.common.internal.Preconditions;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Locale;
import java.util.Map;
import kotlin.text.Typography;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzer extends zzbr {
    private static final byte[] zza = "\n".getBytes();
    private final String zzb;
    private final zzfb zzc;

    zzer(zzbu zzbuVar) {
        super(zzbuVar);
        this.zzb = String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", "GoogleAnalytics", zzbs.zza, Build.VERSION.RELEASE, zzff.zzd(Locale.getDefault()), Build.MODEL, Build.ID);
        this.zzc = new zzfb(zzbuVar.zzr());
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0080 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int zzg(java.net.URL r5, byte[] r6, int r7) throws java.lang.Throwable {
        /*
            r4 = this;
            java.lang.String r7 = "Error closing http post connection output stream"
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r5)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r6)
            int r0 = r6.length
            java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
            java.lang.String r2 = "POST bytes, url"
            r4.zzG(r2, r1, r5)
            boolean r1 = zzU()
            if (r1 == 0) goto L22
            java.lang.String r1 = new java.lang.String
            r1.<init>(r6)
            java.lang.String r2 = "Post payload\n"
            r4.zzO(r2, r1)
        L22:
            r1 = 0
            java.net.HttpURLConnection r5 = r4.zzb(r5)     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L5f
            r2 = 1
            r5.setDoOutput(r2)     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
            r5.setFixedLengthStreamingMode(r0)     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
            r5.connect()     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
            java.io.OutputStream r1 = r5.getOutputStream()     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
            r1.write(r6)     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
            r4.zzk(r5)     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
            int r6 = r5.getResponseCode()     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
            r0 = 200(0xc8, float:2.8E-43)
            if (r6 != r0) goto L4b
            com.google.android.gms.internal.gtm.zzbp r6 = r4.zzs()     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
            r6.zzi()     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
            r6 = r0
        L4b:
            java.lang.String r0 = "POST status"
            java.lang.Integer r2 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
            r4.zzF(r0, r2)     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
            goto L6a
        L55:
            r6 = move-exception
            goto L7e
        L57:
            r6 = move-exception
            r3 = r1
            r1 = r5
            r5 = r3
            goto L61
        L5c:
            r6 = move-exception
            r5 = r1
            goto L7e
        L5f:
            r6 = move-exception
            r5 = r1
        L61:
            java.lang.String r0 = "Network POST connection error"
            r4.zzR(r0, r6)     // Catch: java.lang.Throwable -> L7a
            r6 = 0
            r3 = r1
            r1 = r5
            r5 = r3
        L6a:
            if (r1 == 0) goto L74
            r1.close()     // Catch: java.io.IOException -> L70
            goto L74
        L70:
            r0 = move-exception
            r4.zzJ(r7, r0)
        L74:
            if (r5 == 0) goto L79
            r5.disconnect()
        L79:
            return r6
        L7a:
            r6 = move-exception
            r3 = r1
            r1 = r5
            r5 = r3
        L7e:
            if (r1 == 0) goto L88
            r1.close()     // Catch: java.io.IOException -> L84
            goto L88
        L84:
            r0 = move-exception
            r4.zzJ(r7, r0)
        L88:
            if (r5 == 0) goto L8d
            r5.disconnect()
        L8d:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzer.zzg(java.net.URL, byte[], int):int");
    }

    private final URL zzh() {
        zzw();
        String strZzi = zzcs.zzi();
        zzw();
        try {
            return new URL(strZzi.concat((String) zzeh.zzn.zzb()));
        } catch (MalformedURLException e) {
            zzJ("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    private final URL zzi(zzek zzekVar) {
        String strConcat;
        if (zzekVar.zzh()) {
            zzw();
            String strZzi = zzcs.zzi();
            zzw();
            strConcat = strZzi.concat(zzcs.zzj());
        } else {
            zzw();
            String strZzk = zzcs.zzk();
            zzw();
            strConcat = strZzk.concat(zzcs.zzj());
        }
        try {
            return new URL(strConcat);
        } catch (MalformedURLException e) {
            zzJ("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    private final URL zzj(zzek zzekVar, String str) {
        String str2;
        if (zzekVar.zzh()) {
            zzw();
            String strZzi = zzcs.zzi();
            zzw();
            str2 = strZzi + zzcs.zzj() + "?" + str;
        } else {
            zzw();
            String strZzk = zzcs.zzk();
            zzw();
            str2 = strZzk + zzcs.zzj() + "?" + str;
        }
        try {
            return new URL(str2);
        } catch (MalformedURLException e) {
            zzJ("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    private final void zzk(HttpURLConnection httpURLConnection) throws Throwable {
        InputStream inputStream;
        try {
            inputStream = httpURLConnection.getInputStream();
        } catch (Throwable th) {
            th = th;
            inputStream = null;
        }
        try {
            do {
            } while (inputStream.read(new byte[1024]) > 0);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    zzJ("Error closing http connection input stream", e);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    zzJ("Error closing http connection input stream", e2);
                }
            }
            throw th;
        }
    }

    private static final void zzl(StringBuilder sb, String str, String str2) throws UnsupportedEncodingException {
        if (sb.length() != 0) {
            sb.append(Typography.amp);
        }
        sb.append(URLEncoder.encode(str, "UTF-8"));
        sb.append('=');
        sb.append(URLEncoder.encode(str2, "UTF-8"));
    }

    final String zza(zzek zzekVar, boolean z) {
        Preconditions.checkNotNull(zzekVar);
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry entry : zzekVar.zzg().entrySet()) {
                String str = (String) entry.getKey();
                if (!"ht".equals(str) && !"qt".equals(str) && !"AppUID".equals(str) && !"z".equals(str) && !"_gmsv".equals(str)) {
                    zzl(sb, str, (String) entry.getValue());
                }
            }
            zzl(sb, "ht", String.valueOf(zzekVar.zzd()));
            zzl(sb, "qt", String.valueOf(zzC().currentTimeMillis() - zzekVar.zzd()));
            zzw();
            if (z) {
                long jZzc = zzekVar.zzc();
                zzl(sb, "z", jZzc != 0 ? String.valueOf(jZzc) : String.valueOf(zzekVar.zzb()));
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            zzJ("Failed to encode name or value", e);
            return null;
        }
    }

    final HttpURLConnection zzb(URL url) throws IOException {
        URLConnection uRLConnectionOpenConnection = url.openConnection();
        if (!(uRLConnectionOpenConnection instanceof HttpURLConnection)) {
            throw new IOException("Failed to obtain http connection");
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
        httpURLConnection.setDefaultUseCaches(false);
        zzw();
        httpURLConnection.setConnectTimeout(((Integer) zzeh.zzw.zzb()).intValue());
        zzw();
        httpURLConnection.setReadTimeout(((Integer) zzeh.zzx.zzb()).intValue());
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestProperty(HttpHeaders.USER_AGENT, this.zzb);
        httpURLConnection.setDoInput(true);
        return httpURLConnection;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01ce A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01b8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x031e A[EDGE_INSN: B:183:0x031e->B:156:0x031e BREAK  A[LOOP:1: B:107:0x0228->B:187:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:187:? A[LOOP:1: B:107:0x0228->B:187:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:188:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01d9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List zzc(java.util.List r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 799
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzer.zzc(java.util.List):java.util.List");
    }

    @Override // com.google.android.gms.internal.gtm.zzbr
    protected final void zzd() {
        zzO("Network initialized. User agent", this.zzb);
    }

    public final boolean zze() {
        NetworkInfo activeNetworkInfo;
        com.google.android.gms.analytics.zzr.zzh();
        zzV();
        try {
            activeNetworkInfo = ((ConnectivityManager) zzo().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException unused) {
            activeNetworkInfo = null;
        }
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        zzN("No network connectivity");
        return false;
    }
}
