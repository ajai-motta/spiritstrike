package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzfsp {
    public static boolean zza(zzbaa zzbaaVar) {
        int iOrdinal = zzbaaVar.ordinal();
        return iOrdinal == 1 || iOrdinal == 2 || iOrdinal == 3 || iOrdinal == 4 || iOrdinal == 5;
    }

    public static final zzbaa zzb(Context context, zzfrs zzfrsVar) {
        zzbaa zzbaaVar;
        FileInputStream fileInputStream;
        byte[] bArr;
        File file = new File(new File(context.getApplicationInfo().dataDir), "lib");
        if (file.exists()) {
            File[] fileArrListFiles = file.listFiles(new zzgsh(Pattern.compile(".*\\.so$", 2)));
            if (fileArrListFiles == null || fileArrListFiles.length == 0) {
                if (zzfrsVar != null) {
                    zzfrsVar.zze(5017, "No .so");
                } else {
                    zzfrsVar = null;
                }
                zzbaaVar = zzbaa.UNKNOWN;
            } else {
                try {
                    fileInputStream = new FileInputStream(fileArrListFiles[0]);
                    try {
                        bArr = new byte[20];
                    } finally {
                    }
                } catch (IOException e) {
                    zzc(null, e.toString(), context, zzfrsVar);
                }
                if (fileInputStream.read(bArr) == 20) {
                    byte[] bArr2 = {0, 0};
                    if (bArr[5] == 2) {
                        zzc(bArr, null, context, zzfrsVar);
                        zzbaaVar = zzbaa.UNSUPPORTED;
                    } else {
                        bArr2[0] = bArr[19];
                        bArr2[1] = bArr[18];
                        short s = ByteBuffer.wrap(bArr2).getShort();
                        if (s == 3) {
                            zzbaaVar = zzbaa.X86;
                        } else if (s == 40) {
                            zzbaaVar = zzbaa.ARM7;
                        } else if (s == 62) {
                            zzbaaVar = zzbaa.X86_64;
                        } else if (s == 183) {
                            zzbaaVar = zzbaa.ARM64;
                        } else if (s != 243) {
                            zzc(bArr, null, context, zzfrsVar);
                            zzbaaVar = zzbaa.UNSUPPORTED;
                        } else {
                            zzbaaVar = zzbaa.RISCV64;
                        }
                    }
                    fileInputStream.close();
                } else {
                    fileInputStream.close();
                    zzbaaVar = zzbaa.UNSUPPORTED;
                }
            }
        } else {
            if (zzfrsVar != null) {
                zzfrsVar.zze(5017, "No lib/");
            } else {
                zzfrsVar = null;
            }
            zzbaaVar = zzbaa.UNKNOWN;
        }
        if (zzbaaVar == zzbaa.UNKNOWN) {
            String strZzd = zzd(context, zzfrsVar);
            if (TextUtils.isEmpty(strZzd)) {
                zzc(null, "Empty dev arch", context, zzfrsVar);
                zzbaaVar = zzbaa.UNSUPPORTED;
            } else if (strZzd.equalsIgnoreCase("i686") || strZzd.equalsIgnoreCase("x86")) {
                zzbaaVar = zzbaa.X86;
            } else if (strZzd.equalsIgnoreCase("x86_64")) {
                zzbaaVar = zzbaa.X86_64;
            } else if (strZzd.equalsIgnoreCase("arm64-v8a")) {
                zzbaaVar = zzbaa.ARM64;
            } else if (strZzd.equalsIgnoreCase("armeabi-v7a") || strZzd.equalsIgnoreCase("armv71")) {
                zzbaaVar = zzbaa.ARM7;
            } else if (strZzd.equalsIgnoreCase("riscv64")) {
                zzbaaVar = zzbaa.RISCV64;
            } else {
                zzc(null, strZzd, context, zzfrsVar);
                zzbaaVar = zzbaa.UNSUPPORTED;
            }
        }
        if (zzfrsVar != null) {
            zzfrsVar.zze(5018, zzbaaVar.name());
        }
        return zzbaaVar;
    }

    private static final void zzc(byte[] bArr, String str, Context context, zzfrs zzfrsVar) {
        if (zzfrsVar == null) {
            return;
        }
        StringBuilder sb = new StringBuilder("os.arch:");
        sb.append(zzgmt.OS_ARCH.zza());
        sb.append(";");
        try {
            String[] strArr = (String[]) Build.class.getField("SUPPORTED_ABIS").get(null);
            if (strArr != null) {
                sb.append("supported_abis:");
                sb.append(Arrays.toString(strArr));
                sb.append(";");
            }
        } catch (IllegalAccessException | NoSuchFieldException unused) {
        }
        sb.append("CPU_ABI:");
        sb.append(Build.CPU_ABI);
        sb.append(";CPU_ABI2:");
        sb.append(Build.CPU_ABI2);
        sb.append(";");
        if (bArr != null) {
            sb.append("ELF:");
            sb.append(Arrays.toString(bArr));
            sb.append(";");
        }
        if (str != null) {
            sb.append("dbg:");
            sb.append(str);
            sb.append(";");
        }
        zzfrsVar.zze(4007, sb.toString());
    }

    private static final String zzd(Context context, zzfrs zzfrsVar) {
        HashSet hashSet = new HashSet(Arrays.asList("i686", "armv71"));
        String strZza = zzgmt.OS_ARCH.zza();
        if (!TextUtils.isEmpty(strZza) && hashSet.contains(strZza)) {
            return strZza;
        }
        try {
            String[] strArr = (String[]) Build.class.getField("SUPPORTED_ABIS").get(null);
            if (strArr != null && strArr.length > 0) {
                return strArr[0];
            }
        } catch (IllegalAccessException e) {
            if (zzfrsVar != null) {
                zzfrsVar.zzc(2024, 0L, e);
            }
        } catch (NoSuchFieldException e2) {
            if (zzfrsVar != null) {
                zzfrsVar.zzc(2024, 0L, e2);
            }
        }
        return Build.CPU_ABI != null ? Build.CPU_ABI : Build.CPU_ABI2;
    }
}
