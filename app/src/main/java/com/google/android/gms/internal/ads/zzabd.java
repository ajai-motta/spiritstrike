package com.google.android.gms.internal.ads;

import android.hardware.display.DisplayManager;
import android.view.Display;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzabd implements DisplayManager.DisplayListener {
    final /* synthetic */ zzabf zza;
    private final DisplayManager zzb;

    public zzabd(zzabf zzabfVar, DisplayManager displayManager) {
        Objects.requireNonNull(zzabfVar);
        this.zza = zzabfVar;
        this.zzb = displayManager;
    }

    private final Display zzc() {
        return this.zzb.getDisplay(0);
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayAdded(int i) {
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayChanged(int i) {
        if (i == 0) {
            this.zza.zzj(zzc());
        }
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayRemoved(int i) {
    }

    public final void zza() {
        this.zzb.registerDisplayListener(this, zzep.zzc(null));
        this.zza.zzj(zzc());
    }

    public final void zzb() {
        this.zzb.unregisterDisplayListener(this);
    }
}
