package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.InputEvent;
import android.view.View;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzfxn {
    private final zzfzl zza;
    private final zzgam zzb;
    private final zzghy zzc;
    private final zzgjd zzd;
    private final long zze;
    private final zzifb zzf;
    private final long zzg;
    private final long zzh = System.currentTimeMillis();
    private final boolean zzi;
    private final long zzj;

    zzfxn(zzfzl zzfzlVar, zzgam zzgamVar, zzghy zzghyVar, zzgjd zzgjdVar, zzifb zzifbVar, zzfxt zzfxtVar) {
        this.zza = zzfzlVar;
        this.zzb = zzgamVar;
        this.zzc = zzghyVar;
        this.zzd = zzgjdVar;
        this.zze = zzfxtVar.zzh();
        this.zzf = zzifbVar;
        this.zzg = zzfxtVar.zzg();
        this.zzi = zzfxtVar.zzq();
        this.zzj = zzfxtVar.zzp();
    }

    public final ListenableFuture zza() {
        return this.zza.zza();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String zzb(Context context) {
        String strZza;
        boolean z = false;
        if (this.zzi) {
            if (System.currentTimeMillis() - this.zzh <= this.zzj) {
                z = true;
            }
        }
        zzgjb zzgjbVarZza = this.zzd.zza(3);
        try {
            try {
                try {
                    zzgjbVarZza.zza();
                    strZza = (String) zzgui.zzj(this.zza.zzb(), new zzfxk(this, context), zzguz.zza()).get(z ? this.zzg : this.zze, TimeUnit.MILLISECONDS);
                } catch (TimeoutException e) {
                    zzgjbVarZza.zzb(e);
                    strZza = z ? ((zzgdo) this.zzf.zzb()).zza(true, this.zzh) : Integer.toString(17);
                } catch (Throwable th) {
                    zzgjbVarZza.zzb(th);
                    throw th;
                }
            } catch (InterruptedException e2) {
                Thread.currentThread().interrupt();
                zzgjbVarZza.zzb(e2);
                strZza = "";
            } catch (ExecutionException e3) {
                e = e3;
                Throwable cause = e.getCause();
                if (cause != null) {
                    e = cause;
                }
                zzgjbVarZza.zzb(e);
                strZza = Integer.toString(3);
            }
            zzgjbVarZza.zzc();
            return strZza;
        } catch (Throwable th2) {
            zzgjbVarZza.zzc();
            throw th2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String zzc(Context context, String str, View view, Activity activity) {
        String string;
        zzgjb zzgjbVarZza = this.zzd.zza(4);
        try {
            try {
                try {
                    try {
                        try {
                            zzgjbVarZza.zza();
                            string = (String) zzgui.zzj(this.zza.zzb(), new zzfxl(this, context, null, view, activity), zzguz.zza()).get(this.zze, TimeUnit.MILLISECONDS);
                        } catch (Throwable th) {
                            zzgjbVarZza.zzb(th);
                            throw th;
                        }
                    } catch (ExecutionException e) {
                        e = e;
                        Throwable cause = e.getCause();
                        if (cause != null) {
                            e = cause;
                        }
                        zzgjbVarZza.zzb(e);
                        string = Integer.toString(3);
                    }
                } catch (TimeoutException e2) {
                    zzgjbVarZza.zzb(e2);
                    string = Integer.toString(17);
                }
            } catch (InterruptedException e3) {
                Thread.currentThread().interrupt();
                zzgjbVarZza.zzb(e3);
                string = "";
            }
            zzgjbVarZza.zzc();
            return string;
        } catch (Throwable th2) {
            zzgjbVarZza.zzc();
            throw th2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String zzd(Context context, String str, View view, Activity activity) {
        String string;
        zzgjb zzgjbVarZza = this.zzd.zza(5);
        try {
            try {
                try {
                    try {
                        try {
                            zzgjbVarZza.zza();
                            string = (String) zzgui.zzj(this.zza.zzb(), new zzfxm(this, context, str, view, null), zzguz.zza()).get(this.zze, TimeUnit.MILLISECONDS);
                        } catch (Throwable th) {
                            zzgjbVarZza.zzb(th);
                            throw th;
                        }
                    } catch (ExecutionException e) {
                        e = e;
                        Throwable cause = e.getCause();
                        if (cause != null) {
                            e = cause;
                        }
                        zzgjbVarZza.zzb(e);
                        string = Integer.toString(3);
                    }
                } catch (TimeoutException e2) {
                    zzgjbVarZza.zzb(e2);
                    string = Integer.toString(17);
                }
            } catch (InterruptedException e3) {
                Thread.currentThread().interrupt();
                zzgjbVarZza.zzb(e3);
                string = "";
            }
            zzgjbVarZza.zzc();
            return string;
        } catch (Throwable th2) {
            zzgjbVarZza.zzc();
            throw th2;
        }
    }

    public final void zze(List list) {
        this.zzc.zza(list);
    }

    public final void zzf(InputEvent inputEvent) {
        this.zzb.zze(inputEvent);
    }

    final /* synthetic */ zzgam zzg() {
        return this.zzb;
    }

    public final int zzh() {
        return this.zzb.zzh();
    }
}
