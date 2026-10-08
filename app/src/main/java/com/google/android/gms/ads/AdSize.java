package com.google.android.gms.ads;

import android.content.Context;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import androidx.compose.animation.core.AnimationConstants;
import com.google.android.gms.ads.internal.client.zzbb;
import com.google.android.gms.ads.internal.client.zzr;
import com.google.android.gms.ads.internal.util.client.zzo;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class AdSize {
    public static final int AUTO_HEIGHT = -2;
    public static final int FULL_WIDTH = -1;
    private final int zzb;
    private final int zzc;
    private final String zzd;
    private boolean zze;
    private boolean zzf;
    private int zzg;
    private boolean zzh;
    private int zzi;
    public static final AdSize BANNER = new AdSize(320, 50, "320x50_mb");
    public static final AdSize FULL_BANNER = new AdSize(468, 60, "468x60_as");
    public static final AdSize LARGE_BANNER = new AdSize(320, 100, "320x100_as");
    public static final AdSize LEADERBOARD = new AdSize(728, 90, "728x90_as");
    public static final AdSize MEDIUM_RECTANGLE = new AdSize(AnimationConstants.DefaultDurationMillis, 250, "300x250_as");
    public static final AdSize WIDE_SKYSCRAPER = new AdSize(160, 600, "160x600_as");

    @Deprecated
    public static final AdSize SMART_BANNER = new AdSize(-1, -2, "smart_banner");
    public static final AdSize FLUID = new AdSize(-3, -4, "fluid");
    public static final AdSize INVALID = new AdSize(0, 0, "invalid");
    public static final AdSize zza = new AdSize(50, 50, "50x50_mb");

    static {
        new AdSize(-3, 0, "search_v2");
    }

    public static AdSize getCurrentOrientationAnchoredAdaptiveBannerAdSize(Context context, int i) {
        AdSize adSizeZzj = com.google.android.gms.ads.internal.util.client.zzf.zzj(context, i, 50, 0);
        adSizeZzj.zze = true;
        return adSizeZzj;
    }

    public static AdSize getCurrentOrientationInlineAdaptiveBannerAdSize(Context context, int i) {
        int iZzp = com.google.android.gms.ads.internal.util.client.zzf.zzp(context, 0);
        if (iZzp == -1) {
            return INVALID;
        }
        AdSize adSize = new AdSize(i, 0);
        adSize.zzg = iZzp;
        adSize.zzf = true;
        return adSize;
    }

    public static AdSize getInlineAdaptiveBannerAdSize(int i, int i2) {
        AdSize adSize = new AdSize(i, 0);
        adSize.zzg = i2;
        adSize.zzf = true;
        if (i2 < 32) {
            StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 118);
            sb.append("The maximum height set for the inline adaptive ad size was ");
            sb.append(i2);
            sb.append(" dp, which is below the minimum recommended value of 32 dp.");
            zzo.zzi(sb.toString());
        }
        return adSize;
    }

    public static AdSize getLandscapeAnchoredAdaptiveBannerAdSize(Context context, int i) {
        AdSize adSizeZzj = com.google.android.gms.ads.internal.util.client.zzf.zzj(context, i, 50, 2);
        adSizeZzj.zze = true;
        return adSizeZzj;
    }

    public static AdSize getLandscapeInlineAdaptiveBannerAdSize(Context context, int i) {
        int iZzp = com.google.android.gms.ads.internal.util.client.zzf.zzp(context, 2);
        AdSize adSize = new AdSize(i, 0);
        if (iZzp == -1) {
            return INVALID;
        }
        adSize.zzg = iZzp;
        adSize.zzf = true;
        return adSize;
    }

    public static AdSize getPortraitAnchoredAdaptiveBannerAdSize(Context context, int i) {
        AdSize adSizeZzj = com.google.android.gms.ads.internal.util.client.zzf.zzj(context, i, 50, 1);
        adSizeZzj.zze = true;
        return adSizeZzj;
    }

    public static AdSize getPortraitInlineAdaptiveBannerAdSize(Context context, int i) {
        int iZzp = com.google.android.gms.ads.internal.util.client.zzf.zzp(context, 1);
        AdSize adSize = new AdSize(i, 0);
        if (iZzp == -1) {
            return INVALID;
        }
        adSize.zzg = iZzp;
        adSize.zzf = true;
        return adSize;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdSize)) {
            return false;
        }
        AdSize adSize = (AdSize) obj;
        return this.zzb == adSize.zzb && this.zzc == adSize.zzc && this.zzd.equals(adSize.zzd);
    }

    public int getHeight() {
        return this.zzc;
    }

    public int getWidth() {
        return this.zzb;
    }

    public int hashCode() {
        return this.zzd.hashCode();
    }

    public boolean isAutoHeight() {
        return this.zzc == -2;
    }

    public boolean isFluid() {
        return this.zzb == -3 && this.zzc == -4;
    }

    public boolean isFullWidth() {
        return this.zzb == -1;
    }

    public String toString() {
        return this.zzd;
    }

    final boolean zza() {
        return this.zze;
    }

    final boolean zzb() {
        return this.zzf;
    }

    final void zzc(boolean z) {
        this.zzf = true;
    }

    final void zzd(int i) {
        this.zzg = i;
    }

    final int zze() {
        return this.zzg;
    }

    final boolean zzf() {
        return this.zzh;
    }

    final void zzg(boolean z) {
        this.zzh = true;
    }

    final int zzh() {
        return this.zzi;
    }

    final void zzi(int i) {
        this.zzi = i;
    }

    public AdSize(int i, int i2) {
        String strValueOf = i == -1 ? "FULL" : String.valueOf(i);
        String strValueOf2 = i2 == -2 ? "AUTO" : String.valueOf(i2);
        StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 1 + String.valueOf(strValueOf2).length() + 3);
        sb.append(strValueOf);
        sb.append("x");
        sb.append(strValueOf2);
        sb.append("_as");
        this(i, i2, sb.toString());
    }

    public int getHeightInPixels(Context context) {
        int i = this.zzc;
        if (i == -4 || i == -3) {
            return -1;
        }
        if (i == -2) {
            return zzr.zza(context.getResources().getDisplayMetrics());
        }
        zzbb.zza();
        return com.google.android.gms.ads.internal.util.client.zzf.zzC(context, i);
    }

    public int getWidthInPixels(Context context) {
        int i = this.zzb;
        if (i == -3) {
            return -1;
        }
        if (i != -1) {
            zzbb.zza();
            return com.google.android.gms.ads.internal.util.client.zzf.zzC(context, i);
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        Parcelable.Creator<zzr> creator = zzr.CREATOR;
        return displayMetrics.widthPixels;
    }

    AdSize(int i, int i2, String str) {
        if (i < 0 && i != -1 && i != -3) {
            StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 26);
            sb.append("Invalid width for AdSize: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        }
        if (i2 < 0 && i2 != -2 && i2 != -4) {
            StringBuilder sb2 = new StringBuilder(String.valueOf(i2).length() + 27);
            sb2.append("Invalid height for AdSize: ");
            sb2.append(i2);
            throw new IllegalArgumentException(sb2.toString());
        }
        this.zzb = i;
        this.zzc = i2;
        this.zzd = str;
    }
}
