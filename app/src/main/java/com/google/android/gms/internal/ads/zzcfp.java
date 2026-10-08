package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzcfp extends zzft implements zzgu {
    private static final Pattern zza = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private static final AtomicReference zzb = new AtomicReference();
    private final SSLSocketFactory zzc;
    private final int zzd;
    private final int zze;
    private final String zzf;
    private final zzgt zzg;
    private zzgf zzh;
    private HttpURLConnection zzi;
    private InputStream zzj;
    private boolean zzk;
    private int zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private long zzp;
    private int zzq;
    private final Set zzr;

    zzcfp(String str, zzgz zzgzVar, int i, int i2, int i3) {
        super(true);
        this.zzc = new zzcfo(this);
        this.zzr = new HashSet();
        zzcv.zza(str);
        this.zzf = str;
        this.zzg = new zzgt();
        this.zzd = i;
        this.zze = i2;
        this.zzq = i3;
        if (zzgzVar != null) {
            zze(zzgzVar);
        }
    }

    private final void zzn() {
        HttpURLConnection httpURLConnection = this.zzi;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzg("Unexpected error while disconnecting", e);
            }
            this.zzi = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x02da A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:127:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00e6 A[Catch: IOException -> 0x0300, TryCatch #3 {IOException -> 0x0300, blocks: (B:3:0x000e, B:4:0x0027, B:6:0x002d, B:8:0x003d, B:9:0x0045, B:10:0x005d, B:12:0x0063, B:20:0x0093, B:22:0x00b9, B:23:0x00d8, B:24:0x00dd, B:26:0x00e6, B:27:0x00ed, B:40:0x0115, B:94:0x029a, B:96:0x02a7, B:98:0x02b8, B:101:0x02c1, B:102:0x02d1, B:104:0x02da, B:105:0x02e1, B:106:0x02e2, B:107:0x02ff), top: B:117:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x02a7 A[Catch: IOException -> 0x0300, TryCatch #3 {IOException -> 0x0300, blocks: (B:3:0x000e, B:4:0x0027, B:6:0x002d, B:8:0x003d, B:9:0x0045, B:10:0x005d, B:12:0x0063, B:20:0x0093, B:22:0x00b9, B:23:0x00d8, B:24:0x00dd, B:26:0x00e6, B:27:0x00ed, B:40:0x0115, B:94:0x029a, B:96:0x02a7, B:98:0x02b8, B:101:0x02c1, B:102:0x02d1, B:104:0x02da, B:105:0x02e1, B:106:0x02e2, B:107:0x02ff), top: B:117:0x000e }] */
    @Override // com.google.android.gms.internal.ads.zzgb
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long zzb(com.google.android.gms.internal.ads.zzgf r23) throws com.google.android.gms.internal.ads.zzgq {
        /*
            Method dump skipped, instruction units count: 800
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcfp.zzb(com.google.android.gms.internal.ads.zzgf):long");
    }

    @Override // com.google.android.gms.internal.ads.zzgb
    public final Uri zzc() {
        HttpURLConnection httpURLConnection = this.zzi;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    @Override // com.google.android.gms.internal.ads.zzgb
    public final void zzd() throws zzgq {
        try {
            InputStream inputStream = this.zzj;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    throw new zzgq(e, this.zzh, 2000, 3);
                }
            }
        } finally {
            this.zzj = null;
            zzn();
            if (this.zzk) {
                this.zzk = false;
                zzi();
            }
            this.zzr.clear();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzft, com.google.android.gms.internal.ads.zzgb
    public final Map zzj() {
        HttpURLConnection httpURLConnection = this.zzi;
        if (httpURLConnection == null) {
            return null;
        }
        return httpURLConnection.getHeaderFields();
    }

    final void zzk(int i) {
        this.zzq = i;
        for (Socket socket : this.zzr) {
            if (!socket.isClosed()) {
                try {
                    socket.setReceiveBufferSize(this.zzq);
                } catch (SocketException e) {
                    int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzj("Failed to update receive buffer size.", e);
                }
            }
        }
    }

    final /* synthetic */ void zzl(Socket socket) {
        this.zzr.add(socket);
    }

    final /* synthetic */ int zzm() {
        return this.zzq;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0075 A[Catch: IOException -> 0x008c, TryCatch #0 {IOException -> 0x008c, blocks: (B:2:0x0000, B:21:0x0054, B:23:0x005c, B:26:0x0067, B:27:0x006d, B:29:0x0075, B:32:0x007c, B:33:0x0081, B:34:0x0082, B:5:0x000b, B:7:0x0016, B:8:0x001a, B:10:0x0022, B:13:0x0038, B:14:0x0042, B:15:0x0047, B:16:0x0048, B:17:0x004d, B:18:0x004e), top: B:39:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0082 A[Catch: IOException -> 0x008c, TRY_LEAVE, TryCatch #0 {IOException -> 0x008c, blocks: (B:2:0x0000, B:21:0x0054, B:23:0x005c, B:26:0x0067, B:27:0x006d, B:29:0x0075, B:32:0x007c, B:33:0x0081, B:34:0x0082, B:5:0x000b, B:7:0x0016, B:8:0x001a, B:10:0x0022, B:13:0x0038, B:14:0x0042, B:15:0x0047, B:16:0x0048, B:17:0x004d, B:18:0x004e), top: B:39:0x0000 }] */
    @Override // com.google.android.gms.internal.ads.zzj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zza(byte[] r10, int r11, int r12) throws com.google.android.gms.internal.ads.zzgq {
        /*
            r9 = this;
            long r0 = r9.zzo     // Catch: java.io.IOException -> L8c
            long r2 = r9.zzm     // Catch: java.io.IOException -> L8c
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r1 = 0
            r2 = -1
            if (r0 != 0) goto Lb
            goto L51
        Lb:
            java.util.concurrent.atomic.AtomicReference r0 = com.google.android.gms.internal.ads.zzcfp.zzb     // Catch: java.io.IOException -> L8c
            r3 = 0
            java.lang.Object r3 = r0.getAndSet(r3)     // Catch: java.io.IOException -> L8c
            byte[] r3 = (byte[]) r3     // Catch: java.io.IOException -> L8c
            if (r3 != 0) goto L1a
            r3 = 4096(0x1000, float:5.74E-42)
            byte[] r3 = new byte[r3]     // Catch: java.io.IOException -> L8c
        L1a:
            long r4 = r9.zzo     // Catch: java.io.IOException -> L8c
            long r6 = r9.zzm     // Catch: java.io.IOException -> L8c
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L4e
            int r8 = r3.length     // Catch: java.io.IOException -> L8c
            long r6 = r6 - r4
            long r4 = (long) r8     // Catch: java.io.IOException -> L8c
            long r4 = java.lang.Math.min(r6, r4)     // Catch: java.io.IOException -> L8c
            int r4 = (int) r4     // Catch: java.io.IOException -> L8c
            java.io.InputStream r5 = r9.zzj     // Catch: java.io.IOException -> L8c
            int r4 = r5.read(r3, r1, r4)     // Catch: java.io.IOException -> L8c
            boolean r5 = java.lang.Thread.interrupted()     // Catch: java.io.IOException -> L8c
            if (r5 != 0) goto L48
            if (r4 == r2) goto L42
            long r5 = r9.zzo     // Catch: java.io.IOException -> L8c
            long r7 = (long) r4     // Catch: java.io.IOException -> L8c
            long r5 = r5 + r7
            r9.zzo = r5     // Catch: java.io.IOException -> L8c
            r9.zzh(r4)     // Catch: java.io.IOException -> L8c
            goto L1a
        L42:
            java.io.EOFException r10 = new java.io.EOFException     // Catch: java.io.IOException -> L8c
            r10.<init>()     // Catch: java.io.IOException -> L8c
            throw r10     // Catch: java.io.IOException -> L8c
        L48:
            java.io.InterruptedIOException r10 = new java.io.InterruptedIOException     // Catch: java.io.IOException -> L8c
            r10.<init>()     // Catch: java.io.IOException -> L8c
            throw r10     // Catch: java.io.IOException -> L8c
        L4e:
            r0.set(r3)     // Catch: java.io.IOException -> L8c
        L51:
            if (r12 != 0) goto L54
            goto L8b
        L54:
            long r0 = r9.zzn     // Catch: java.io.IOException -> L8c
            r3 = -1
            int r5 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r5 == 0) goto L6d
            long r5 = r9.zzp     // Catch: java.io.IOException -> L8c
            long r0 = r0 - r5
            r5 = 0
            int r5 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r5 != 0) goto L67
        L65:
            r1 = r2
            goto L8b
        L67:
            long r5 = (long) r12     // Catch: java.io.IOException -> L8c
            long r0 = java.lang.Math.min(r5, r0)     // Catch: java.io.IOException -> L8c
            int r12 = (int) r0     // Catch: java.io.IOException -> L8c
        L6d:
            java.io.InputStream r0 = r9.zzj     // Catch: java.io.IOException -> L8c
            int r1 = r0.read(r10, r11, r12)     // Catch: java.io.IOException -> L8c
            if (r1 != r2) goto L82
            long r10 = r9.zzn     // Catch: java.io.IOException -> L8c
            int r10 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r10 != 0) goto L7c
            goto L65
        L7c:
            java.io.EOFException r10 = new java.io.EOFException     // Catch: java.io.IOException -> L8c
            r10.<init>()     // Catch: java.io.IOException -> L8c
            throw r10     // Catch: java.io.IOException -> L8c
        L82:
            long r10 = r9.zzp     // Catch: java.io.IOException -> L8c
            long r2 = (long) r1     // Catch: java.io.IOException -> L8c
            long r10 = r10 + r2
            r9.zzp = r10     // Catch: java.io.IOException -> L8c
            r9.zzh(r1)     // Catch: java.io.IOException -> L8c
        L8b:
            return r1
        L8c:
            r10 = move-exception
            com.google.android.gms.internal.ads.zzgq r11 = new com.google.android.gms.internal.ads.zzgq
            com.google.android.gms.internal.ads.zzgf r12 = r9.zzh
            r0 = 2000(0x7d0, float:2.803E-42)
            r1 = 2
            r11.<init>(r10, r12, r0, r1)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcfp.zza(byte[], int, int):int");
    }
}
