package com.google.android.gms.tagmanager;

import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tagmanager.ContainerHolder;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.1.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzx implements ContainerHolder {
    private final Looper zza;
    private Container zzb;
    private Container zzc;
    private final Status zzd;
    private zzw zze;
    private zzv zzf;
    private boolean zzg;
    private TagManager zzh;

    public zzx(Status status) {
        this.zzd = status;
        this.zza = null;
    }

    public zzx(TagManager tagManager, Looper looper, Container container, zzv zzvVar) {
        this.zzh = tagManager;
        this.zza = looper == null ? Looper.getMainLooper() : looper;
        this.zzb = container;
        this.zzf = zzvVar;
        this.zzd = Status.RESULT_SUCCESS;
        tagManager.zza(this);
    }

    private final void zzf() {
        zzw zzwVar = this.zze;
        if (zzwVar != null) {
            zzwVar.sendMessage(zzwVar.obtainMessage(1, this.zzc.zzc()));
        }
    }

    @Override // com.google.android.gms.tagmanager.ContainerHolder
    public final synchronized Container getContainer() {
        if (this.zzg) {
            Log.e("GoogleTagManager", "ContainerHolder is released.");
            return null;
        }
        Container container = this.zzc;
        if (container != null) {
            this.zzb = container;
            this.zzc = null;
        }
        return this.zzb;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zzd;
    }

    @Override // com.google.android.gms.tagmanager.ContainerHolder
    public final synchronized void refresh() {
        if (this.zzg) {
            Log.e("GoogleTagManager", "Refreshing a released ContainerHolder.");
        } else {
            this.zzf.zzb();
        }
    }

    @Override // com.google.android.gms.common.api.Releasable
    public final synchronized void release() {
        if (this.zzg) {
            Log.e("GoogleTagManager", "Releasing a released ContainerHolder.");
            return;
        }
        this.zzg = true;
        this.zzh.zzc(this);
        this.zzb.zze();
        this.zzb = null;
        this.zzc = null;
        this.zzf = null;
        this.zze = null;
    }

    @Override // com.google.android.gms.tagmanager.ContainerHolder
    public final synchronized void setContainerAvailableListener(ContainerHolder.ContainerAvailableListener containerAvailableListener) {
        if (this.zzg) {
            Log.e("GoogleTagManager", "ContainerHolder is released.");
            return;
        }
        if (containerAvailableListener == null) {
            this.zze = null;
            return;
        }
        this.zze = new zzw(this, containerAvailableListener, this.zza);
        if (this.zzc != null) {
            zzf();
        }
    }

    final String zza() {
        if (!this.zzg) {
            return this.zzb.getContainerId();
        }
        Log.e("GoogleTagManager", "getContainerId called on a released ContainerHolder.");
        return "";
    }

    final String zzb() {
        if (!this.zzg) {
            return this.zzf.zza();
        }
        Log.e("GoogleTagManager", "setCtfeUrlPathAndQuery called on a released ContainerHolder.");
        return "";
    }

    public final synchronized void zzc(Container container) {
        if (this.zzg) {
            return;
        }
        this.zzc = container;
        zzf();
    }

    public final synchronized void zzd(String str) {
        if (this.zzg) {
            return;
        }
        this.zzb.zzd(str);
    }

    final void zze(String str) {
        if (this.zzg) {
            Log.e("GoogleTagManager", "setCtfeUrlPathAndQuery called on a released ContainerHolder.");
        } else {
            this.zzf.zzc(str);
        }
    }
}
