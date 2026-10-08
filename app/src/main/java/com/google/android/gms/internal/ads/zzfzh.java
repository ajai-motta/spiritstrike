package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.function.Function;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzfzh extends zzfyz {
    private final ExecutorService zzb;
    private final zzfzg zzc;
    private final Function zzd;

    public zzfzh(File file, ExecutorService executorService, zzfzg zzfzgVar, Function function) {
        super(file);
        this.zzb = executorService;
        this.zzc = zzfzgVar;
        this.zzd = function;
    }

    @Override // com.google.android.gms.internal.ads.zzfyz
    public final ListenableFuture zzb() {
        return zzgui.zzd(new Callable() { // from class: com.google.android.gms.internal.ads.zzfze
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return this.zza.zzd();
            }
        }, this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzfyz
    public final ListenableFuture zzc(final Object obj) {
        return zzgui.zzd(new Callable() { // from class: com.google.android.gms.internal.ads.zzfzd
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                this.zza.zze(obj);
                return null;
            }
        }, this.zzb);
    }

    final /* synthetic */ Object zzd() {
        Object objApply;
        synchronized (this) {
            try {
                FileInputStream fileInputStream = new FileInputStream(this.zza);
                try {
                    objApply = this.zzc.zzb(fileInputStream);
                    fileInputStream.close();
                } catch (Throwable th) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (zzfzc e) {
                objApply = this.zzd.apply(e);
            } catch (FileNotFoundException unused) {
                objApply = this.zzc.zzc();
            } catch (IOException e2) {
                objApply = this.zzd.apply(new zzfzc(e2));
            }
        }
        return objApply;
    }

    final /* synthetic */ Void zze(Object obj) {
        synchronized (this) {
            File file = this.zza;
            zzgsg.zzb(file);
            String parent = file.getParent();
            String name = file.getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 5);
            sb.append(name);
            sb.append(".temp");
            File file2 = new File(parent, sb.toString());
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                try {
                    this.zzc.zza(obj, fileOutputStream);
                    fileOutputStream.close();
                    if (!file2.renameTo(this.zza)) {
                        throw new IOException("Failed to rename file.");
                    }
                } catch (Throwable th) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (IOException e) {
                file2.delete();
                throw e;
            }
        }
        return null;
    }
}
