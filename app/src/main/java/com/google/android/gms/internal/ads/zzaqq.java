package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzaqq implements zzape {
    private final zzaqp zzc;
    private final Map zza = new LinkedHashMap(16, 0.75f, true);
    private long zzb = 0;
    private final int zzd = 5242880;

    public zzaqq(zzaqp zzaqpVar, int i) {
        this.zzc = zzaqpVar;
    }

    static byte[] zzg(zzaqo zzaqoVar, long j) throws IOException {
        long jZza = zzaqoVar.zza();
        if (j >= 0 && j <= jZza) {
            int i = (int) j;
            if (i == j) {
                byte[] bArr = new byte[i];
                new DataInputStream(zzaqoVar).readFully(bArr);
                return bArr;
            }
        }
        StringBuilder sb = new StringBuilder(String.valueOf(j).length() + 33 + String.valueOf(jZza).length());
        sb.append("streamToBytes length=");
        sb.append(j);
        sb.append(", maxLength=");
        sb.append(jZza);
        throw new IOException(sb.toString());
    }

    static void zzh(OutputStream outputStream, int i) throws IOException {
        outputStream.write(i & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    static int zzi(InputStream inputStream) throws IOException {
        return (zzp(inputStream) << 24) | zzp(inputStream) | (zzp(inputStream) << 8) | (zzp(inputStream) << 16);
    }

    static void zzj(OutputStream outputStream, long j) throws IOException {
        outputStream.write((byte) j);
        outputStream.write((byte) (j >>> 8));
        outputStream.write((byte) (j >>> 16));
        outputStream.write((byte) (j >>> 24));
        outputStream.write((byte) (j >>> 32));
        outputStream.write((byte) (j >>> 40));
        outputStream.write((byte) (j >>> 48));
        outputStream.write((byte) (j >>> 56));
    }

    static long zzk(InputStream inputStream) throws IOException {
        return (((long) zzp(inputStream)) & 255) | ((((long) zzp(inputStream)) & 255) << 8) | ((((long) zzp(inputStream)) & 255) << 16) | ((((long) zzp(inputStream)) & 255) << 24) | ((((long) zzp(inputStream)) & 255) << 32) | ((((long) zzp(inputStream)) & 255) << 40) | ((((long) zzp(inputStream)) & 255) << 48) | ((((long) zzp(inputStream)) & 255) << 56);
    }

    static void zzl(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        int length = bytes.length;
        zzj(outputStream, length);
        outputStream.write(bytes, 0, length);
    }

    static String zzm(zzaqo zzaqoVar) throws IOException {
        return new String(zzg(zzaqoVar, zzk(zzaqoVar)), "UTF-8");
    }

    private final void zzn(String str, zzaqn zzaqnVar) {
        Map map = this.zza;
        if (map.containsKey(str)) {
            this.zzb += zzaqnVar.zza - ((zzaqn) map.get(str)).zza;
        } else {
            this.zzb += zzaqnVar.zza;
        }
        map.put(str, zzaqnVar);
    }

    private final void zzo(String str) {
        zzaqn zzaqnVar = (zzaqn) this.zza.remove(str);
        if (zzaqnVar != null) {
            this.zzb -= zzaqnVar.zza;
        }
    }

    private static int zzp(InputStream inputStream) throws IOException {
        int i = inputStream.read();
        if (i != -1) {
            return i;
        }
        throw new EOFException();
    }

    private static final String zzq(String str) {
        int length = str.length() / 2;
        String strValueOf = String.valueOf(str.substring(0, length).hashCode());
        String strValueOf2 = String.valueOf(str.substring(length).hashCode());
        String.valueOf(strValueOf);
        String.valueOf(strValueOf2);
        return String.valueOf(strValueOf).concat(String.valueOf(strValueOf2));
    }

    @Override // com.google.android.gms.internal.ads.zzape
    public final synchronized zzapd zza(String str) {
        zzaqn zzaqnVar = (zzaqn) this.zza.get(str);
        if (zzaqnVar == null) {
            return null;
        }
        File fileZzf = zzf(str);
        try {
            zzaqo zzaqoVar = new zzaqo(new BufferedInputStream(new FileInputStream(fileZzf)), fileZzf.length());
            try {
                String str2 = zzaqn.zza(zzaqoVar).zzb;
                if (!TextUtils.equals(str, str2)) {
                    zzaqg.zzb("%s: key=%s, found=%s", fileZzf.getAbsolutePath(), str, str2);
                    zzo(str);
                    return null;
                }
                byte[] bArrZzg = zzg(zzaqoVar, zzaqoVar.zza());
                zzapd zzapdVar = new zzapd();
                zzapdVar.zza = bArrZzg;
                zzapdVar.zzb = zzaqnVar.zzc;
                zzapdVar.zzc = zzaqnVar.zzd;
                zzapdVar.zzd = zzaqnVar.zze;
                zzapdVar.zze = zzaqnVar.zzf;
                zzapdVar.zzf = zzaqnVar.zzg;
                List<zzapm> list = zzaqnVar.zzh;
                TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
                for (zzapm zzapmVar : list) {
                    treeMap.put(zzapmVar.zza(), zzapmVar.zzb());
                }
                zzapdVar.zzg = treeMap;
                zzapdVar.zzh = Collections.unmodifiableList(list);
                return zzapdVar;
            } finally {
                zzaqoVar.close();
            }
        } catch (IOException e) {
            zzaqg.zzb("%s: %s", fileZzf.getAbsolutePath(), e.toString());
            zze(str);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzape
    public final synchronized void zzb(String str, zzapd zzapdVar) {
        long j;
        long j2 = this.zzb;
        int length = zzapdVar.zza.length;
        long j3 = j2 + ((long) length);
        int i = this.zzd;
        if (j3 <= i || length <= i * 0.9f) {
            File fileZzf = zzf(str);
            try {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileZzf));
                zzaqn zzaqnVar = new zzaqn(str, zzapdVar);
                try {
                    zzh(bufferedOutputStream, 538247942);
                    zzl(bufferedOutputStream, zzaqnVar.zzb);
                    String str2 = zzaqnVar.zzc;
                    if (str2 == null) {
                        str2 = "";
                    }
                    zzl(bufferedOutputStream, str2);
                    zzj(bufferedOutputStream, zzaqnVar.zzd);
                    zzj(bufferedOutputStream, zzaqnVar.zze);
                    zzj(bufferedOutputStream, zzaqnVar.zzf);
                    zzj(bufferedOutputStream, zzaqnVar.zzg);
                    List<zzapm> list = zzaqnVar.zzh;
                    if (list != null) {
                        zzh(bufferedOutputStream, list.size());
                        for (zzapm zzapmVar : list) {
                            zzl(bufferedOutputStream, zzapmVar.zza());
                            zzl(bufferedOutputStream, zzapmVar.zzb());
                        }
                    } else {
                        zzh(bufferedOutputStream, 0);
                    }
                    bufferedOutputStream.flush();
                    bufferedOutputStream.write(zzapdVar.zza);
                    bufferedOutputStream.close();
                    zzaqnVar.zza = fileZzf.length();
                    zzn(str, zzaqnVar);
                    long j4 = this.zzb;
                    int i2 = this.zzd;
                    if (j4 >= i2) {
                        boolean z = zzaqg.zzb;
                        if (z) {
                            zzaqg.zza("Pruning old cache entries.", new Object[0]);
                        }
                        long j5 = this.zzb;
                        long jElapsedRealtime = SystemClock.elapsedRealtime();
                        Iterator it = this.zza.entrySet().iterator();
                        int i3 = 0;
                        while (true) {
                            if (!it.hasNext()) {
                                j = j5;
                                break;
                            }
                            zzaqn zzaqnVar2 = (zzaqn) ((Map.Entry) it.next()).getValue();
                            String str3 = zzaqnVar2.zzb;
                            if (zzf(str3).delete()) {
                                j = j5;
                                this.zzb -= zzaqnVar2.zza;
                            } else {
                                j = j5;
                                zzaqg.zzb("Could not delete cache entry for key=%s, filename=%s", str3, zzq(str3));
                            }
                            it.remove();
                            i3++;
                            if (this.zzb < i2 * 0.9f) {
                                break;
                            } else {
                                j5 = j;
                            }
                        }
                        if (z) {
                            zzaqg.zza("pruned %d files, %d bytes, %d ms", Integer.valueOf(i3), Long.valueOf(this.zzb - j), Long.valueOf(SystemClock.elapsedRealtime() - jElapsedRealtime));
                        }
                    }
                } catch (IOException e) {
                    zzaqg.zzb("%s", e.toString());
                    bufferedOutputStream.close();
                    zzaqg.zzb("Failed to write header for %s", fileZzf.getAbsolutePath());
                    throw new IOException();
                }
            } catch (IOException unused) {
                if (!fileZzf.delete()) {
                    zzaqg.zzb("Could not clean up file %s", fileZzf.getAbsolutePath());
                }
                if (!this.zzc.zza().exists()) {
                    zzaqg.zzb("Re-initializing cache after external clearing.", new Object[0]);
                    this.zza.clear();
                    this.zzb = 0L;
                    zzc();
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzape
    public final synchronized void zzc() {
        long length;
        zzaqo zzaqoVar;
        File fileZza = this.zzc.zza();
        if (fileZza.exists()) {
            File[] fileArrListFiles = fileZza.listFiles();
            if (fileArrListFiles != null) {
                for (File file : fileArrListFiles) {
                    try {
                        length = file.length();
                        zzaqoVar = new zzaqo(new BufferedInputStream(new FileInputStream(file)), length);
                    } catch (IOException unused) {
                        file.delete();
                    }
                    try {
                        zzaqn zzaqnVarZza = zzaqn.zza(zzaqoVar);
                        zzaqnVarZza.zza = length;
                        zzn(zzaqnVarZza.zzb, zzaqnVarZza);
                        zzaqoVar.close();
                    } catch (Throwable th) {
                        zzaqoVar.close();
                        throw th;
                    }
                }
            }
        } else if (!fileZza.mkdirs()) {
            zzaqg.zzc("Unable to create cache dir %s", fileZza.getAbsolutePath());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzape
    public final synchronized void zzd(String str, boolean z) {
        zzapd zzapdVarZza = zza(str);
        if (zzapdVarZza != null) {
            zzapdVarZza.zzf = 0L;
            zzapdVarZza.zze = 0L;
            zzb(str, zzapdVarZza);
        }
    }

    public final synchronized void zze(String str) {
        boolean zDelete = zzf(str).delete();
        zzo(str);
        if (zDelete) {
            return;
        }
        zzaqg.zzb("Could not delete cache entry for key=%s, filename=%s", str, zzq(str));
    }

    public final File zzf(String str) {
        return new File(this.zzc.zza(), zzq(str));
    }

    public zzaqq(File file, int i) {
        this.zzc = new zzaqm(this, file);
    }
}
