package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.metrics.LogSessionId;
import android.media.metrics.MediaMetricsManager;
import android.media.metrics.NetworkEvent;
import android.media.metrics.PlaybackErrorEvent;
import android.media.metrics.PlaybackMetrics;
import android.media.metrics.PlaybackSession;
import android.media.metrics.PlaybackStateEvent;
import android.media.metrics.TrackChangeEvent;
import android.os.SystemClock;
import android.util.Pair;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.gms.internal.ads.zzml;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.Executor;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzoy implements zzml, zzoz {
    private boolean zzA;
    private final Context zza;
    private final zzpa zzc;
    private final PlaybackSession zzd;
    private String zzj;
    private PlaybackMetrics.Builder zzk;
    private int zzl;
    private zzau zzo;
    private zzox zzp;
    private zzox zzq;
    private zzox zzr;
    private zzv zzs;
    private zzv zzt;
    private zzv zzu;
    private boolean zzv;
    private boolean zzw;
    private int zzx;
    private int zzy;
    private int zzz;
    private final Executor zzb = zzcw.zza();
    private final zzbe zzf = new zzbe();
    private final zzbd zzg = new zzbd();
    private final HashMap zzi = new HashMap();
    private final HashMap zzh = new HashMap();
    private final long zze = SystemClock.elapsedRealtime();
    private int zzm = 0;
    private int zzn = 0;

    private zzoy(Context context, PlaybackSession playbackSession) {
        this.zza = context.getApplicationContext();
        this.zzd = playbackSession;
        zzor zzorVar = new zzor(zzor.zza);
        this.zzc = zzorVar;
        zzorVar.zza(this);
    }

    private final void zzA(int i, long j, zzv zzvVar, int i2) {
        TrackChangeEvent.Builder timeSinceCreatedMillis = new TrackChangeEvent.Builder(i).setTimeSinceCreatedMillis(j - this.zze);
        if (zzvVar != null) {
            timeSinceCreatedMillis.setTrackState(1);
            timeSinceCreatedMillis.setTrackChangeReason(i2 != 1 ? 1 : 2);
            String str = zzvVar.zzn;
            if (str != null) {
                timeSinceCreatedMillis.setContainerMimeType(str);
            }
            String str2 = zzvVar.zzo;
            if (str2 != null) {
                timeSinceCreatedMillis.setSampleMimeType(str2);
            }
            String str3 = zzvVar.zzk;
            if (str3 != null) {
                timeSinceCreatedMillis.setCodecName(str3);
            }
            int i3 = zzvVar.zzj;
            if (i3 != -1) {
                timeSinceCreatedMillis.setBitrate(i3);
            }
            int i4 = zzvVar.zzv;
            if (i4 != -1) {
                timeSinceCreatedMillis.setWidth(i4);
            }
            int i5 = zzvVar.zzw;
            if (i5 != -1) {
                timeSinceCreatedMillis.setHeight(i5);
            }
            int i6 = zzvVar.zzG;
            if (i6 != -1) {
                timeSinceCreatedMillis.setChannelCount(i6);
            }
            int i7 = zzvVar.zzH;
            if (i7 != -1) {
                timeSinceCreatedMillis.setAudioSampleRate(i7);
            }
            String str4 = zzvVar.zzd;
            if (str4 != null) {
                String str5 = zzep.zza;
                String[] strArrSplit = str4.split("-", -1);
                Pair pairCreate = Pair.create(strArrSplit[0], strArrSplit.length >= 2 ? strArrSplit[1] : null);
                timeSinceCreatedMillis.setLanguage((String) pairCreate.first);
                if (pairCreate.second != null) {
                    timeSinceCreatedMillis.setLanguageRegion((String) pairCreate.second);
                }
            }
            float f = zzvVar.zzz;
            if (f != -1.0f) {
                timeSinceCreatedMillis.setVideoFrameRate(f);
            }
        } else {
            timeSinceCreatedMillis.setTrackState(0);
        }
        this.zzA = true;
        final TrackChangeEvent trackChangeEventBuild = timeSinceCreatedMillis.build();
        this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzou
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzu(trackChangeEventBuild);
            }
        });
    }

    @RequiresNonNull({"metricsBuilder"})
    private final void zzB(zzbf zzbfVar, zzuu zzuuVar) {
        int iZze;
        PlaybackMetrics.Builder builder = this.zzk;
        if (zzuuVar == null || (iZze = zzbfVar.zze(zzuuVar.zza)) == -1) {
            return;
        }
        zzbd zzbdVar = this.zzg;
        int i = 0;
        zzbfVar.zzd(iZze, zzbdVar, false);
        zzbe zzbeVar = this.zzf;
        zzbfVar.zzb(zzbdVar.zzc, zzbeVar, 0L);
        zzag zzagVar = zzbeVar.zzd.zzb;
        if (zzagVar != null) {
            int iZzG = zzep.zzG(zzagVar.zza);
            i = iZzG != 0 ? iZzG != 1 ? iZzG != 2 ? 1 : 4 : 5 : 3;
        }
        builder.setStreamType(i);
        long j = zzbeVar.zzm;
        if (j != C.TIME_UNSET && !zzbeVar.zzk && !zzbeVar.zzi && !zzbeVar.zzb()) {
            builder.setMediaDurationMillis(zzep.zzp(j));
        }
        builder.setPlaybackType(true != zzbeVar.zzb() ? 1 : 2);
        this.zzA = true;
    }

    private final void zzC() {
        PlaybackMetrics.Builder builder = this.zzk;
        if (builder != null && this.zzA) {
            builder.setAudioUnderrunCount(this.zzz);
            this.zzk.setVideoFramesDropped(this.zzx);
            this.zzk.setVideoFramesPlayed(this.zzy);
            Long l = (Long) this.zzh.get(this.zzj);
            this.zzk.setNetworkTransferDurationMillis(l == null ? 0L : l.longValue());
            Long l2 = (Long) this.zzi.get(this.zzj);
            this.zzk.setNetworkBytesRead(l2 == null ? 0L : l2.longValue());
            this.zzk.setStreamSource((l2 == null || l2.longValue() <= 0) ? 0 : 1);
            final PlaybackMetrics playbackMetricsBuild = this.zzk.build();
            this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzov
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzv(playbackMetricsBuild);
                }
            });
        }
        this.zzk = null;
        this.zzj = null;
        this.zzz = 0;
        this.zzx = 0;
        this.zzy = 0;
        this.zzs = null;
        this.zzt = null;
        this.zzu = null;
        this.zzA = false;
    }

    private static int zzD(int i) {
        switch (zzep.zzF(i)) {
            case 6002:
                return 24;
            case 6003:
                return 28;
            case PlaybackException.ERROR_CODE_DRM_LICENSE_ACQUISITION_FAILED /* 6004 */:
                return 25;
            case PlaybackException.ERROR_CODE_DRM_DISALLOWED_OPERATION /* 6005 */:
                return 26;
            default:
                return 27;
        }
    }

    public static zzoy zza(Context context) {
        MediaMetricsManager mediaMetricsManager = (MediaMetricsManager) context.getSystemService("media_metrics");
        if (mediaMetricsManager == null) {
            return null;
        }
        return new zzoy(context, mediaMetricsManager.createPlaybackSession());
    }

    @EnsuresNonNullIf(expression = {"#1"}, result = true)
    private final boolean zzw(zzox zzoxVar) {
        if (zzoxVar != null) {
            return zzoxVar.zzc.equals(this.zzc.zzf());
        }
        return false;
    }

    private final void zzx(long j, zzv zzvVar, int i) {
        if (Objects.equals(this.zzs, zzvVar)) {
            return;
        }
        int i2 = this.zzs == null ? 1 : 0;
        this.zzs = zzvVar;
        zzA(1, j, zzvVar, i2);
    }

    private final void zzy(long j, zzv zzvVar, int i) {
        if (Objects.equals(this.zzt, zzvVar)) {
            return;
        }
        int i2 = this.zzt == null ? 1 : 0;
        this.zzt = zzvVar;
        zzA(0, j, zzvVar, i2);
    }

    private final void zzz(long j, zzv zzvVar, int i) {
        if (Objects.equals(this.zzu, zzvVar)) {
            return;
        }
        int i2 = this.zzu == null ? 1 : 0;
        this.zzu = zzvVar;
        zzA(2, j, zzvVar, i2);
    }

    public final LogSessionId zzb() {
        return this.zzd.getSessionId();
    }

    @Override // com.google.android.gms.internal.ads.zzoz
    public final void zzc(zzmj zzmjVar, String str) {
        zzuu zzuuVar = zzmjVar.zzd;
        if (zzuuVar == null || !zzuuVar.zzb()) {
            zzC();
            this.zzj = str;
            this.zzk = new PlaybackMetrics.Builder().setPlayerName("AndroidXMedia3").setPlayerVersion("1.8.0");
            zzB(zzmjVar.zzb, zzuuVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzoz
    public final void zzd(zzmj zzmjVar, String str, boolean z) {
        zzuu zzuuVar = zzmjVar.zzd;
        if ((zzuuVar == null || !zzuuVar.zzb()) && str.equals(this.zzj)) {
            zzC();
        }
        this.zzh.remove(str);
        this.zzi.remove(str);
    }

    @Override // com.google.android.gms.internal.ads.zzml
    public final void zzdj(zzmj zzmjVar, zzba zzbaVar, zzba zzbaVar2, int i) {
        if (i == 1) {
            this.zzv = true;
            i = 1;
        }
        this.zzl = i;
    }

    @Override // com.google.android.gms.internal.ads.zzml
    public final void zzdk(zzmj zzmjVar, zzuq zzuqVar) {
        zzuu zzuuVar = zzmjVar.zzd;
        if (zzuuVar == null) {
            return;
        }
        zzv zzvVar = zzuqVar.zzb;
        zzvVar.getClass();
        zzox zzoxVar = new zzox(zzvVar, 0, this.zzc.zzb(zzmjVar.zzb, zzuuVar));
        int i = zzuqVar.zza;
        if (i != 0) {
            if (i == 1) {
                this.zzq = zzoxVar;
                return;
            } else if (i != 2) {
                if (i != 3) {
                    return;
                }
                this.zzr = zzoxVar;
                return;
            }
        }
        this.zzp = zzoxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzml
    public final void zzdl(zzmj zzmjVar, int i, long j, long j2) {
        zzuu zzuuVar = zzmjVar.zzd;
        if (zzuuVar != null) {
            String strZzb = this.zzc.zzb(zzmjVar.zzb, zzuuVar);
            HashMap map = this.zzi;
            Long l = (Long) map.get(strZzb);
            HashMap map2 = this.zzh;
            Long l2 = (Long) map2.get(strZzb);
            map.put(strZzb, Long.valueOf((l == null ? 0L : l.longValue()) + j));
            map2.put(strZzb, Long.valueOf((l2 != null ? l2.longValue() : 0L) + ((long) i)));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzml
    public final void zzdm(zzmj zzmjVar, zzhs zzhsVar) {
        this.zzx += zzhsVar.zzg;
        this.zzy += zzhsVar.zze;
    }

    /* JADX WARN: Removed duplicated region for block: B:137:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x02a6  */
    @Override // com.google.android.gms.internal.ads.zzml
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzdn(com.google.android.gms.internal.ads.zzbb r21, com.google.android.gms.internal.ads.zzmk r22) {
        /*
            Method dump skipped, instruction units count: 1016
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzoy.zzdn(com.google.android.gms.internal.ads.zzbb, com.google.android.gms.internal.ads.zzmk):void");
    }

    @Override // com.google.android.gms.internal.ads.zzml
    public /* synthetic */ void zze(zzmj zzmjVar, int i) {
        zzml.CC.$default$zze(this, zzmjVar, i);
    }

    @Override // com.google.android.gms.internal.ads.zzml
    public final void zzg(zzmj zzmjVar, zzau zzauVar) {
        this.zzo = zzauVar;
    }

    @Override // com.google.android.gms.internal.ads.zzml
    public final void zzh(zzmj zzmjVar, zzul zzulVar, zzuq zzuqVar, IOException iOException, boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzml
    public /* synthetic */ void zzk(zzmj zzmjVar, zzv zzvVar, zzht zzhtVar) {
        zzml.CC.$default$zzk(this, zzmjVar, zzvVar, zzhtVar);
    }

    @Override // com.google.android.gms.internal.ads.zzml
    public /* synthetic */ void zzl(zzmj zzmjVar, zzv zzvVar, zzht zzhtVar) {
        zzml.CC.$default$zzl(this, zzmjVar, zzvVar, zzhtVar);
    }

    @Override // com.google.android.gms.internal.ads.zzml
    public /* synthetic */ void zzm(zzmj zzmjVar, int i, long j) {
        zzml.CC.$default$zzm(this, zzmjVar, i, j);
    }

    @Override // com.google.android.gms.internal.ads.zzml
    public /* synthetic */ void zzo(zzmj zzmjVar, Object obj, long j) {
        zzml.CC.$default$zzo(this, zzmjVar, obj, j);
    }

    @Override // com.google.android.gms.internal.ads.zzml
    public final void zzp(zzmj zzmjVar, zzbv zzbvVar) {
        zzox zzoxVar = this.zzp;
        if (zzoxVar != null) {
            zzv zzvVar = zzoxVar.zza;
            if (zzvVar.zzw == -1) {
                zzt zztVarZza = zzvVar.zza();
                zztVarZza.zzt(zzbvVar.zzb);
                zztVarZza.zzu(zzbvVar.zzc);
                this.zzp = new zzox(zztVarZza.zzM(), 0, zzoxVar.zzc);
            }
        }
    }

    final /* synthetic */ void zzr(PlaybackErrorEvent playbackErrorEvent) {
        this.zzd.reportPlaybackErrorEvent(playbackErrorEvent);
    }

    final /* synthetic */ void zzs(NetworkEvent networkEvent) {
        this.zzd.reportNetworkEvent(networkEvent);
    }

    final /* synthetic */ void zzt(PlaybackStateEvent playbackStateEvent) {
        this.zzd.reportPlaybackStateEvent(playbackStateEvent);
    }

    final /* synthetic */ void zzu(TrackChangeEvent trackChangeEvent) {
        this.zzd.reportTrackChangeEvent(trackChangeEvent);
    }

    final /* synthetic */ void zzv(PlaybackMetrics playbackMetrics) {
        this.zzd.reportPlaybackMetrics(playbackMetrics);
    }
}
