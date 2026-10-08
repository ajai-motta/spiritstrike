package com.google.android.gms.tagmanager;

import android.util.Log;
import com.google.android.gms.internal.gtm.zzrc;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.1.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzeg implements Runnable {
    final /* synthetic */ zzrc zza;
    final /* synthetic */ zzeh zzb;

    zzeg(zzeh zzehVar, zzrc zzrcVar) {
        this.zza = zzrcVar;
        this.zzb = zzehVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FileOutputStream fileOutputStream;
        zzrc zzrcVar = this.zza;
        File fileZze = this.zzb.zze();
        try {
            try {
                fileOutputStream = new FileOutputStream(fileZze);
                try {
                    zzrcVar.zzT(fileOutputStream);
                } catch (IOException unused) {
                    Log.w("GoogleTagManager", "Error writing resource to disk. Removing resource from disk.");
                    fileZze.delete();
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused2) {
                        Log.w("GoogleTagManager", "error closing stream for writing resource to disk");
                    }
                }
            } finally {
                try {
                    fileOutputStream.close();
                } catch (IOException unused3) {
                    Log.w("GoogleTagManager", "error closing stream for writing resource to disk");
                }
            }
        } catch (FileNotFoundException unused4) {
            Log.e("GoogleTagManager", "Error opening resource file for writing");
        }
    }
}
