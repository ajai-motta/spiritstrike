package com.google.android.gms.internal.ads;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzcfh extends zzcfe {
    public static final /* synthetic */ int zzd = 0;
    private static final Set zze = Collections.synchronizedSet(new HashSet());
    private static final DecimalFormat zzf = new DecimalFormat("#,###");
    private File zzg;
    private boolean zzh;

    public zzcfh(zzcdr zzcdrVar) {
        super(zzcdrVar);
        File cacheDir = this.zza.getCacheDir();
        if (cacheDir == null) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("Context.getCacheDir() returned null");
            return;
        }
        File file = new File(zzftx.zza().zza(cacheDir, "admobVideoStreams"));
        this.zzg = file;
        if (!file.isDirectory() && !this.zzg.mkdirs()) {
            String absolutePath = this.zzg.getAbsolutePath();
            String.valueOf(absolutePath);
            String strValueOf = String.valueOf(absolutePath);
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("Could not create preload cache directory at ".concat(strValueOf));
            this.zzg = null;
            return;
        }
        if (this.zzg.setReadable(true, false) && this.zzg.setExecutable(true, false)) {
            return;
        }
        String absolutePath2 = this.zzg.getAbsolutePath();
        String.valueOf(absolutePath2);
        String strValueOf2 = String.valueOf(absolutePath2);
        int i3 = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzi("Could not set cache file permissions at ".concat(strValueOf2));
        this.zzg = null;
    }

    private final File zza(File file) {
        zzfty zzftyVarZza = zzftx.zza();
        File file2 = this.zzg;
        String name = file.getName();
        String.valueOf(name);
        return new File(zzftyVarZza.zza(file2, String.valueOf(name).concat(".done")));
    }

    @Override // com.google.android.gms.internal.ads.zzcfe
    public final void zzl() {
        this.zzh = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:130:0x0402, code lost:
    
        r34 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0404, code lost:
    
        r13.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x040c, code lost:
    
        if (com.google.android.gms.ads.internal.util.zze.zzm(3) == false) goto L134;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x040e, code lost:
    
        r0 = r15.format((long) r1);
        r3 = new java.lang.StringBuilder((java.lang.String.valueOf(r0).length() + 22) + java.lang.String.valueOf(r37).length());
        r3.append(r16);
        r3.append(r0);
        r3.append(" bytes from ");
        r3.append(r37);
        com.google.android.gms.ads.internal.util.client.zzo.zzd(r3.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x0440, code lost:
    
        r11.setReadable(true, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x0449, code lost:
    
        if (r0.isFile() == false) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x044b, code lost:
    
        r0.setLastModified(java.lang.System.currentTimeMillis());
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x0457, code lost:
    
        r0.createNewFile();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0490  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x04a2  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x04c6  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x04ef  */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v24, types: [int] */
    /* JADX WARN: Type inference failed for: r1v44 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v46 */
    /* JADX WARN: Type inference failed for: r2v47 */
    /* JADX WARN: Type inference failed for: r36v0, types: [com.google.android.gms.internal.ads.zzcfe, com.google.android.gms.internal.ads.zzcfh] */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v8 */
    @Override // com.google.android.gms.internal.ads.zzcfe
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zze(final java.lang.String r37) {
        /*
            Method dump skipped, instruction units count: 1314
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcfh.zze(java.lang.String):boolean");
    }
}
