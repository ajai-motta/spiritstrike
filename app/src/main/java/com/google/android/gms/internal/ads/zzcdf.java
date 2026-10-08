package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.internal.view.SupportMenu;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.common.internal.Preconditions;
import java.util.HashMap;
import java.util.Objects;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
@ParametersAreNonnullByDefault
public final class zzcdf extends FrameLayout implements zzccw {
    final zzcdt zza;
    private final zzcdr zzb;
    private final FrameLayout zzc;
    private final View zzd;
    private final zzbfj zze;
    private final long zzf;
    private final zzccx zzg;
    private boolean zzh;
    private boolean zzi;
    private boolean zzj;
    private boolean zzk;
    private long zzl;
    private long zzm;
    private String zzn;
    private String[] zzo;
    private Bitmap zzp;
    private final ImageView zzq;
    private boolean zzr;

    public zzcdf(Context context, zzcdr zzcdrVar, int i, boolean z, zzbfj zzbfjVar, zzcdq zzcdqVar, zzdvi zzdviVar) {
        super(context);
        this.zzb = zzcdrVar;
        this.zze = zzbfjVar;
        FrameLayout frameLayout = new FrameLayout(context);
        this.zzc = frameLayout;
        addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
        Preconditions.checkNotNull(zzcdrVar.zzk());
        zzccy zzccyVar = zzcdrVar.zzk().zza;
        zzcds zzcdsVar = new zzcds(context, zzcdrVar.zzs(), zzcdrVar.zzm(), zzbfjVar, zzcdrVar.zzi());
        zzccx zzcgnVar = i == 3 ? new zzcgn(context, zzcdsVar) : i == 2 ? new zzcej(context, zzcdsVar, zzcdrVar, z, zzcdj.zza(zzcdrVar), zzcdqVar, zzdviVar) : new zzccv(context, zzcdrVar, z, zzcdj.zza(zzcdrVar), zzcdqVar, new zzcds(context, zzcdrVar.zzs(), zzcdrVar.zzm(), zzbfjVar, zzcdrVar.zzi()), zzdviVar);
        this.zzg = zzcgnVar;
        View view = new View(context);
        this.zzd = view;
        view.setBackgroundColor(0);
        frameLayout.addView(zzcgnVar, new FrameLayout.LayoutParams(-1, -1, 17));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzaa)).booleanValue()) {
            frameLayout.addView(view, new FrameLayout.LayoutParams(-1, -1));
            frameLayout.bringChildToFront(view);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzX)).booleanValue()) {
            zzD();
        }
        this.zzq = new ImageView(context);
        this.zzf = ((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzac)).longValue();
        boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzZ)).booleanValue();
        this.zzk = zBooleanValue;
        if (zzbfjVar != null) {
            zzbfjVar.zzd("spinner_used", true != zBooleanValue ? AppEventsConstants.EVENT_PARAM_VALUE_NO : "1");
        }
        this.zza = new zzcdt(this);
        zzcgnVar.zzb(this);
    }

    private final boolean zzJ() {
        return this.zzq.getParent() != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzK, reason: merged with bridge method [inline-methods] */
    public final void zzI(String str, String... strArr) {
        HashMap map = new HashMap();
        Integer numZzl = zzl();
        if (numZzl != null) {
            map.put("playerId", numZzl.toString());
        }
        map.put("event", str);
        String str2 = null;
        for (String str3 : strArr) {
            if (str2 == null) {
                str2 = str3;
            } else {
                map.put(str2, str3);
                str2 = null;
            }
        }
        this.zzb.zze("onVideoEvent", map);
    }

    private final void zzL() {
        zzcdr zzcdrVar = this.zzb;
        if (zzcdrVar.zzj() == null || !this.zzi || this.zzj) {
            return;
        }
        zzcdrVar.zzj().getWindow().clearFlags(128);
        this.zzi = false;
    }

    public final void finalize() throws Throwable {
        try {
            this.zza.zza();
            final zzccx zzccxVar = this.zzg;
            if (zzccxVar != null) {
                zzgus zzgusVar = zzcbv.zzf;
                Objects.requireNonNull(zzccxVar);
                zzgusVar.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcdc
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        zzccxVar.zzd();
                    }
                });
            }
        } finally {
            super.finalize();
        }
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(final boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            this.zza.zzb();
        } else {
            this.zza.zza();
            this.zzm = this.zzl;
        }
        com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcde
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzG(z);
            }
        });
    }

    @Override // android.view.View, com.google.android.gms.internal.ads.zzccw
    public final void onWindowVisibilityChanged(int i) {
        boolean z;
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            this.zza.zzb();
            z = true;
        } else {
            this.zza.zza();
            this.zzm = this.zzl;
            z = false;
        }
        com.google.android.gms.ads.internal.util.zzs.zza.post(new zzcdb(this, z));
    }

    public final void zzA(int i) {
        zzccx zzccxVar = this.zzg;
        if (zzccxVar == null) {
            return;
        }
        zzccxVar.zzB(i);
    }

    public final void zzB(int i) {
        zzccx zzccxVar = this.zzg;
        if (zzccxVar == null) {
            return;
        }
        zzccxVar.zzC(i);
    }

    public final void zzC(MotionEvent motionEvent) {
        zzccx zzccxVar = this.zzg;
        if (zzccxVar == null) {
            return;
        }
        zzccxVar.dispatchTouchEvent(motionEvent);
    }

    public final void zzD() {
        zzccx zzccxVar = this.zzg;
        if (zzccxVar == null) {
            return;
        }
        TextView textView = new TextView(zzccxVar.getContext());
        Resources resourcesZzf = com.google.android.gms.ads.internal.zzt.zzh().zzf();
        String string = resourcesZzf == null ? "AdMob - " : resourcesZzf.getString(R.string.watermark_label_prefix);
        String strZza = zzccxVar.zza();
        String.valueOf(string);
        textView.setText(String.valueOf(string).concat(strZza));
        textView.setTextColor(SupportMenu.CATEGORY_MASK);
        textView.setBackgroundColor(-256);
        FrameLayout frameLayout = this.zzc;
        frameLayout.addView(textView, new FrameLayout.LayoutParams(-2, -2, 17));
        frameLayout.bringChildToFront(textView);
    }

    public final void zzE() {
        this.zza.zza();
        zzccx zzccxVar = this.zzg;
        if (zzccxVar != null) {
            zzccxVar.zzd();
        }
        zzL();
    }

    final void zzF() {
        zzccx zzccxVar = this.zzg;
        if (zzccxVar == null) {
            return;
        }
        long jZzh = zzccxVar.zzh();
        if (this.zzl == jZzh || jZzh <= 0) {
            return;
        }
        float f = jZzh / 1000.0f;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzch)).booleanValue()) {
            zzI("timeupdate", "time", String.valueOf(f), "totalBytes", String.valueOf(zzccxVar.zzo()), "qoeCachedBytes", String.valueOf(zzccxVar.zzn()), "qoeLoadedBytes", String.valueOf(zzccxVar.zzm()), "droppedFrames", String.valueOf(zzccxVar.zzp()), "reportTime", String.valueOf(com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis()));
        } else {
            zzI("timeupdate", "time", String.valueOf(f));
        }
        this.zzl = jZzh;
    }

    final /* synthetic */ void zzG(boolean z) {
        zzI("windowFocusChanged", "hasWindowFocus", String.valueOf(z));
    }

    final /* synthetic */ void zzH() {
        zzI("firstFrameRendered", new String[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzccw
    public final void zza() {
        this.zza.zzb();
        com.google.android.gms.ads.internal.util.zzs.zza.post(new zzccz(this));
    }

    @Override // com.google.android.gms.internal.ads.zzccw
    public final void zzb() {
        zzccx zzccxVar = this.zzg;
        if (zzccxVar != null && this.zzm == 0) {
            zzI("canplaythrough", TypedValues.TransitionType.S_DURATION, String.valueOf(zzccxVar.zzg() / 1000.0f), "videoWidth", String.valueOf(zzccxVar.zzk()), "videoHeight", String.valueOf(zzccxVar.zzl()));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccw
    public final void zzc() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzcj)).booleanValue()) {
            this.zza.zzb();
        }
        zzcdr zzcdrVar = this.zzb;
        if (zzcdrVar.zzj() != null && !this.zzi) {
            boolean z = (zzcdrVar.zzj().getWindow().getAttributes().flags & 128) != 0;
            this.zzj = z;
            if (!z) {
                zzcdrVar.zzj().getWindow().addFlags(128);
                this.zzi = true;
            }
        }
        this.zzh = true;
    }

    @Override // com.google.android.gms.internal.ads.zzccw
    public final void zzd() {
        zzI("pause", new String[0]);
        zzL();
        this.zzh = false;
    }

    @Override // com.google.android.gms.internal.ads.zzccw
    public final void zze() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzcj)).booleanValue()) {
            this.zza.zza();
        }
        zzI("ended", new String[0]);
        zzL();
    }

    @Override // com.google.android.gms.internal.ads.zzccw
    public final void zzf(String str, String str2) {
        zzI("error", "what", str, "extra", str2);
    }

    @Override // com.google.android.gms.internal.ads.zzccw
    public final void zzg(String str, String str2) {
        zzI("exception", "what", "ExoPlayerAdapter exception", "extra", str2);
    }

    @Override // com.google.android.gms.internal.ads.zzccw
    public final void zzh() {
        if (this.zzr && this.zzp != null && !zzJ()) {
            ImageView imageView = this.zzq;
            imageView.setImageBitmap(this.zzp);
            imageView.invalidate();
            FrameLayout frameLayout = this.zzc;
            frameLayout.addView(imageView, new FrameLayout.LayoutParams(-1, -1));
            frameLayout.bringChildToFront(imageView);
        }
        this.zza.zza();
        this.zzm = this.zzl;
        com.google.android.gms.ads.internal.util.zzs.zza.post(new zzcda(this));
    }

    @Override // com.google.android.gms.internal.ads.zzccw
    public final void zzi() {
        if (this.zzh && zzJ()) {
            this.zzc.removeView(this.zzq);
        }
        zzccx zzccxVar = this.zzg;
        if (zzccxVar == null || this.zzp == null) {
            return;
        }
        long jElapsedRealtime = com.google.android.gms.ads.internal.zzt.zzk().elapsedRealtime();
        if (zzccxVar.getBitmap(this.zzp) != null) {
            this.zzr = true;
        }
        long jElapsedRealtime2 = com.google.android.gms.ads.internal.zzt.zzk().elapsedRealtime() - jElapsedRealtime;
        if (com.google.android.gms.ads.internal.util.zze.zzc()) {
            StringBuilder sb = new StringBuilder(String.valueOf(jElapsedRealtime2).length() + 26);
            sb.append("Spinner frame grab took ");
            sb.append(jElapsedRealtime2);
            sb.append("ms");
            com.google.android.gms.ads.internal.util.zze.zza(sb.toString());
        }
        if (jElapsedRealtime2 > this.zzf) {
            com.google.android.gms.ads.internal.util.client.zzo.zzi("Spinner frame grab crossed jank threshold! Suspending spinner.");
            this.zzk = false;
            this.zzp = null;
            zzbfj zzbfjVar = this.zze;
            if (zzbfjVar != null) {
                zzbfjVar.zzd("spinner_jank", Long.toString(jElapsedRealtime2));
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccw
    public final void zzj(int i, int i2) {
        if (this.zzk) {
            zzbel zzbelVar = zzbeu.zzab;
            int iMax = Math.max(i / ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbelVar)).intValue(), 1);
            int iMax2 = Math.max(i2 / ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbelVar)).intValue(), 1);
            Bitmap bitmap = this.zzp;
            if (bitmap != null && bitmap.getWidth() == iMax && this.zzp.getHeight() == iMax2) {
                return;
            }
            this.zzp = Bitmap.createBitmap(iMax, iMax2, Bitmap.Config.ARGB_8888);
            this.zzr = false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccw
    public final void zzk() {
        this.zzd.setVisibility(4);
        com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcdd
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzH();
            }
        });
    }

    public final Integer zzl() {
        zzccx zzccxVar = this.zzg;
        if (zzccxVar != null) {
            return zzccxVar.zzw();
        }
        return null;
    }

    public final void zzm(int i) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzaa)).booleanValue()) {
            this.zzc.setBackgroundColor(i);
            this.zzd.setBackgroundColor(i);
        }
    }

    public final void zzn(int i, int i2, int i3, int i4) {
        if (com.google.android.gms.ads.internal.util.zze.zzc()) {
            int length = String.valueOf(i).length();
            StringBuilder sb = new StringBuilder(length + 25 + String.valueOf(i2).length() + 3 + String.valueOf(i3).length() + 3 + String.valueOf(i4).length());
            sb.append("Set video bounds to x:");
            sb.append(i);
            sb.append(";y:");
            sb.append(i2);
            sb.append(";w:");
            sb.append(i3);
            sb.append(";h:");
            sb.append(i4);
            com.google.android.gms.ads.internal.util.zze.zza(sb.toString());
        }
        if (i3 == 0 || i4 == 0) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i4);
        layoutParams.setMargins(i, i2, 0, 0);
        this.zzc.setLayoutParams(layoutParams);
        requestLayout();
    }

    public final void zzo(String str, String[] strArr) {
        this.zzn = str;
        this.zzo = strArr;
    }

    public final void zzp(float f, float f2) {
        zzccx zzccxVar = this.zzg;
        if (zzccxVar != null) {
            zzccxVar.zzj(f, f2);
        }
    }

    public final void zzq(Integer num) {
        zzccx zzccxVar = this.zzg;
        if (zzccxVar == null) {
            return;
        }
        if (TextUtils.isEmpty(this.zzn)) {
            zzI("no_src", new String[0]);
        } else {
            zzccxVar.zzx(this.zzn, this.zzo, num);
        }
    }

    public final void zzr() {
        zzccx zzccxVar = this.zzg;
        if (zzccxVar == null) {
            return;
        }
        zzccxVar.zzf();
    }

    public final void zzs() {
        zzccx zzccxVar = this.zzg;
        if (zzccxVar == null) {
            return;
        }
        zzccxVar.zze();
    }

    public final void zzt(int i) {
        zzccx zzccxVar = this.zzg;
        if (zzccxVar == null) {
            return;
        }
        zzccxVar.zzi(i);
    }

    public final void zzu() {
        zzccx zzccxVar = this.zzg;
        if (zzccxVar == null) {
            return;
        }
        zzccxVar.zzb.zza(true);
        zzccxVar.zzq();
    }

    public final void zzv() {
        zzccx zzccxVar = this.zzg;
        if (zzccxVar == null) {
            return;
        }
        zzccxVar.zzb.zza(false);
        zzccxVar.zzq();
    }

    public final void zzw(float f) {
        zzccx zzccxVar = this.zzg;
        if (zzccxVar == null) {
            return;
        }
        zzccxVar.zzb.zzb(f);
        zzccxVar.zzq();
    }

    public final void zzx(int i) {
        zzccx zzccxVar = this.zzg;
        if (zzccxVar == null) {
            return;
        }
        zzccxVar.zzy(i);
    }

    public final void zzy(int i) {
        zzccx zzccxVar = this.zzg;
        if (zzccxVar == null) {
            return;
        }
        zzccxVar.zzz(i);
    }

    public final void zzz(int i) {
        zzccx zzccxVar = this.zzg;
        if (zzccxVar == null) {
            return;
        }
        zzccxVar.zzA(i);
    }
}
