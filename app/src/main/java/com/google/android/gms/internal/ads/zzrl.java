package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import com.adjust.sdk.Constants;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.gms.common.Scopes;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzrl extends zzte implements zzko {
    private final Context zzb;
    private final zzpz zzc;
    private final zzqh zzd;
    private final zzsr zze;
    private int zzf;
    private boolean zzg;
    private boolean zzh;
    private zzv zzi;
    private zzv zzj;
    private long zzk;
    private boolean zzl;
    private boolean zzm;
    private boolean zzn;
    private int zzo;
    private boolean zzp;
    private long zzq;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzrl(Context context, zzst zzstVar, zztg zztgVar, boolean z, Handler handler, zzqa zzqaVar, zzqh zzqhVar) {
        super(1, zzstVar, zztgVar, false, 44100.0f);
        byte[] bArr = null;
        zzsr zzsrVar = Build.VERSION.SDK_INT >= 35 ? new zzsr(zzsq.zzb) : null;
        this.zzb = context.getApplicationContext();
        this.zzd = zzqhVar;
        this.zze = zzsrVar;
        this.zzo = -1000;
        this.zzc = new zzpz(handler, zzqaVar);
        this.zzq = C.TIME_UNSET;
        zzqhVar.zza(new zzrk(this, bArr));
    }

    private static List zzbf(zztg zztgVar, zzv zzvVar, boolean z, zzqh zzqhVar) throws zzti {
        zzsy zzsyVarZza;
        return zzvVar.zzo == null ? zzgpe.zzi() : (!zzqhVar.zzd(zzvVar) || (zzsyVarZza = zztq.zza()) == null) ? zztq.zzc(zztgVar, zzvVar, false, false) : zzgpe.zzj(zzsyVarZza);
    }

    private final int zzbg(zzsy zzsyVar, zzv zzvVar) {
        if ("OMX.google.raw.decoder".equals(zzsyVar.zza) && Build.VERSION.SDK_INT == 23 && !zzep.zzN(this.zzb)) {
            return -1;
        }
        return zzvVar.zzp;
    }

    private final void zzbh() {
        long jZzg = this.zzd.zzg(zzZ());
        if (jZzg != Long.MIN_VALUE) {
            if (!this.zzl) {
                jZzg = Math.max(this.zzk, jZzg);
            }
            this.zzk = jZzg;
            this.zzl = false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzte, com.google.android.gms.internal.ads.zzhr
    protected final void zzA(long j, boolean z, boolean z2) throws zzib {
        super.zzA(j, z, z2);
        this.zzd.zzz();
        this.zzk = j;
        this.zzq = C.TIME_UNSET;
        this.zzn = false;
        this.zzl = true;
    }

    @Override // com.google.android.gms.internal.ads.zzhr
    protected final void zzB() {
        this.zzd.zzi();
        this.zzp = true;
    }

    @Override // com.google.android.gms.internal.ads.zzhr
    protected final void zzC() {
        zzbh();
        this.zzp = false;
        this.zzd.zzy();
    }

    @Override // com.google.android.gms.internal.ads.zzte, com.google.android.gms.internal.ads.zzhr
    protected final void zzD() {
        this.zzm = true;
        this.zzi = null;
        this.zzq = C.TIME_UNSET;
        try {
            this.zzd.zzz();
            super.zzD();
        } catch (Throwable th) {
            super.zzD();
            throw th;
        } finally {
            this.zzc.zzg(this.zza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzte, com.google.android.gms.internal.ads.zzhr
    protected final void zzE() {
        this.zzn = false;
        this.zzq = C.TIME_UNSET;
        try {
            super.zzE();
            if (this.zzm) {
                this.zzm = false;
                this.zzd.zzA();
            }
        } catch (Throwable th) {
            if (this.zzm) {
                this.zzm = false;
                this.zzd.zzA();
            }
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhr
    protected final void zzF() {
        zzsr zzsrVar;
        this.zzd.zzB();
        if (Build.VERSION.SDK_INT < 35 || (zzsrVar = this.zze) == null) {
            return;
        }
        zzsrVar.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzln, com.google.android.gms.internal.ads.zzlp
    public final String zzS() {
        return "MediaCodecAudioRenderer";
    }

    @Override // com.google.android.gms.internal.ads.zzte, com.google.android.gms.internal.ads.zzln
    public final boolean zzY() {
        return this.zzd.zzn();
    }

    @Override // com.google.android.gms.internal.ads.zzte, com.google.android.gms.internal.ads.zzln
    public final boolean zzZ() {
        return super.zzZ() && this.zzd.zzm();
    }

    @Override // com.google.android.gms.internal.ads.zzte
    protected final int zzac(zztg zztgVar, zzv zzvVar) throws zzti {
        int i;
        boolean z;
        String str = zzvVar.zzo;
        if (!zzas.zza(str)) {
            return 128;
        }
        int i2 = zzvVar.zzN;
        boolean zZzbd = zzbd(zzvVar);
        int i3 = 1;
        if (!zZzbd || (i2 != 0 && zztq.zza() == null)) {
            i = 0;
        } else {
            zzqh zzqhVar = this.zzd;
            zzpl zzplVarZzf = zzqhVar.zzf(zzvVar);
            if (zzplVarZzf.zzb) {
                i = true != zzplVarZzf.zzc ? 512 : 1536;
                if (zzplVarZzf.zzd) {
                    i |= 2048;
                }
            } else {
                i = 0;
            }
            if (zzqhVar.zzd(zzvVar)) {
                return i | TsExtractor.TS_STREAM_TYPE_AC4;
            }
        }
        if (!MimeTypes.AUDIO_RAW.equals(str) || this.zzd.zzd(zzvVar)) {
            zzqh zzqhVar2 = this.zzd;
            if (zzqhVar2.zzd(zzep.zzy(2, zzvVar.zzG, zzvVar.zzH))) {
                List listZzbf = zzbf(zztgVar, zzvVar, false, zzqhVar2);
                if (!listZzbf.isEmpty()) {
                    if (zZzbd) {
                        zzsy zzsyVar = (zzsy) listZzbf.get(0);
                        boolean zZzc = zzsyVar.zzc(zzvVar);
                        if (zZzc) {
                            z = true;
                        } else {
                            for (int i4 = 1; i4 < listZzbf.size(); i4++) {
                                zzsy zzsyVar2 = (zzsy) listZzbf.get(i4);
                                if (zzsyVar2.zzc(zzvVar)) {
                                    z = false;
                                    zZzc = true;
                                    zzsyVar = zzsyVar2;
                                    break;
                                }
                            }
                            z = true;
                        }
                        int i5 = true != zZzc ? 3 : 4;
                        int i6 = 8;
                        if (zZzc && zzsyVar.zze(zzvVar)) {
                            i6 = 16;
                        }
                        return i5 | i6 | 32 | (true != zzsyVar.zzg ? 0 : 64) | (true != z ? 0 : 128) | i;
                    }
                    i3 = 2;
                }
            }
        }
        return i3 | 128;
    }

    @Override // com.google.android.gms.internal.ads.zzte
    protected final List zzad(zztg zztgVar, zzv zzvVar, boolean z) throws zzti {
        return zztq.zze(zzbf(zztgVar, zzvVar, false, this.zzd), zzvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzte
    protected final boolean zzae(zzv zzvVar) {
        zzJ();
        return this.zzd.zzd(zzvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzte
    protected final zzss zzaf(zzsy zzsyVar, zzv zzvVar, MediaCrypto mediaCrypto, float f) {
        zzv[] zzvVarArrZzI = zzI();
        int length = zzvVarArrZzI.length;
        int iZzbg = zzbg(zzsyVar, zzvVar);
        if (length != 1) {
            for (zzv zzvVar2 : zzvVarArrZzI) {
                if (zzsyVar.zzf(zzvVar, zzvVar2).zzd != 0) {
                    iZzbg = Math.max(iZzbg, zzbg(zzsyVar, zzvVar2));
                }
            }
        }
        this.zzf = iZzbg;
        String str = zzsyVar.zza;
        this.zzg = Build.VERSION.SDK_INT < 24 && "OMX.SEC.aac.dec".equals(str) && Constants.REFERRER_API_SAMSUNG.equals(Build.MANUFACTURER) && (Build.DEVICE.startsWith("zeroflte") || Build.DEVICE.startsWith("herolte") || Build.DEVICE.startsWith("heroqlte"));
        this.zzh = str.equals("OMX.google.opus.decoder") || str.equals("c2.android.opus.decoder") || str.equals("OMX.google.vorbis.decoder") || str.equals("c2.android.vorbis.decoder");
        String str2 = zzsyVar.zzc;
        int i = this.zzf;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str2);
        int i2 = zzvVar.zzG;
        mediaFormat.setInteger("channel-count", i2);
        int i3 = zzvVar.zzH;
        mediaFormat.setInteger("sample-rate", i3);
        zzdw.zza(mediaFormat, zzvVar.zzr);
        zzdw.zzb(mediaFormat, "max-input-size", i);
        mediaFormat.setInteger(HandleInvocationsFromAdViewer.KEY_DOWNLOAD_PRIORITY, 0);
        if (f != -1.0f && (Build.VERSION.SDK_INT != 23 || (!"ZTE B2017G".equals(Build.MODEL) && !"AXON 7 mini".equals(Build.MODEL)))) {
            mediaFormat.setFloat("operating-rate", f);
        }
        String str3 = zzvVar.zzo;
        if (MimeTypes.AUDIO_AC4.equals(str3)) {
            Pair pairZzd = zzdd.zzd(zzvVar);
            if (pairZzd != null) {
                zzdw.zzb(mediaFormat, Scopes.PROFILE, ((Integer) pairZzd.first).intValue());
                zzdw.zzb(mediaFormat, "level", ((Integer) pairZzd.second).intValue());
            }
            if (Build.VERSION.SDK_INT <= 28) {
                mediaFormat.setInteger("ac4-is-sync", 1);
            }
        }
        if (Build.VERSION.SDK_INT >= 24 && this.zzd.zze(zzep.zzy(4, i2, i3)) == 2) {
            mediaFormat.setInteger("pcm-encoding", 4);
        }
        if (Build.VERSION.SDK_INT >= 32) {
            mediaFormat.setInteger("max-output-channel-count", 99);
        }
        if (Build.VERSION.SDK_INT >= 35) {
            mediaFormat.setInteger("importance", Math.max(0, -this.zzo));
        }
        this.zzj = (!MimeTypes.AUDIO_RAW.equals(zzsyVar.zzb) || MimeTypes.AUDIO_RAW.equals(str3)) ? null : zzvVar;
        return zzss.zza(zzsyVar, mediaFormat, zzvVar, null, this.zze);
    }

    @Override // com.google.android.gms.internal.ads.zzte
    protected final zzht zzag(zzsy zzsyVar, zzv zzvVar, zzv zzvVar2) {
        int i;
        int i2;
        zzht zzhtVarZzf = zzsyVar.zzf(zzvVar, zzvVar2);
        int i3 = zzhtVarZzf.zze;
        if (zzaB(zzvVar2)) {
            i3 |= 32768;
        }
        if (zzbg(zzsyVar, zzvVar2) > this.zzf) {
            i3 |= 64;
        }
        String str = zzsyVar.zza;
        if (i3 != 0) {
            i2 = i3;
            i = 0;
        } else {
            i = zzhtVarZzf.zzd;
            i2 = 0;
        }
        return new zzht(str, zzvVar, zzvVar2, i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzte
    protected final long zzah(long j, long j2, boolean z) {
        zzqh zzqhVar = this.zzd;
        boolean z2 = false;
        if (zzqhVar.zzn() && this.zzq != C.TIME_UNSET) {
            z2 = true;
        }
        if (!this.zzp) {
            return (z2 || super.zzZ()) ? 1000000L : 10000L;
        }
        long jZzv = zzqhVar.zzv();
        if (!z2 || jZzv == C.TIME_UNSET) {
            return 10000L;
        }
        return Math.max(10000L, ((long) ((Math.min(jZzv, this.zzq - j) / (zzj() != null ? zzj().zzb : 1.0f)) / 2.0f)) - (zzep.zzq(zzL().zzb()) - j2));
    }

    @Override // com.google.android.gms.internal.ads.zzte
    protected final float zzai(float f, zzv zzvVar, zzv[] zzvVarArr) {
        int iMax = -1;
        for (zzv zzvVar2 : zzvVarArr) {
            int i = zzvVar2.zzH;
            if (i != -1) {
                iMax = Math.max(iMax, i);
            }
        }
        if (iMax == -1) {
            return -1.0f;
        }
        return iMax * f;
    }

    @Override // com.google.android.gms.internal.ads.zzte
    protected final void zzaj(String str, zzss zzssVar, long j, long j2) {
        this.zzc.zzb(str, j, j2);
    }

    @Override // com.google.android.gms.internal.ads.zzte
    protected final void zzak(String str) {
        this.zzc.zzf(str);
    }

    @Override // com.google.android.gms.internal.ads.zzte
    protected final void zzal(Exception exc) {
        zzdt.zzf("MediaCodecAudioRenderer", "Audio codec error", exc);
        this.zzc.zzj(exc);
    }

    protected final void zzao() {
        this.zzl = true;
    }

    @Override // com.google.android.gms.internal.ads.zzte
    protected final void zzap() {
        this.zzd.zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzte
    protected final void zzar() throws zzib {
        try {
            this.zzd.zzl();
            if (zzba() != C.TIME_UNSET) {
                this.zzq = zzba();
            }
        } catch (zzqg e) {
            throw zzN(e, e.zzc, e.zzb, true != zzaD() ? PlaybackException.ERROR_CODE_AUDIO_TRACK_WRITE_FAILED : 5003);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzte
    protected final void zzas(zzhh zzhhVar) {
        zzv zzvVar;
        if (Build.VERSION.SDK_INT < 29 || (zzvVar = zzhhVar.zza) == null || !Objects.equals(zzvVar.zzo, MimeTypes.AUDIO_OPUS) || !zzaD()) {
            return;
        }
        ByteBuffer byteBuffer = zzhhVar.zzf;
        byteBuffer.getClass();
        zzv zzvVar2 = zzhhVar.zza;
        zzvVar2.getClass();
        int i = zzvVar2.zzJ;
        if (byteBuffer.remaining() == 8) {
            this.zzd.zzw(i, (int) ((byteBuffer.order(ByteOrder.LITTLE_ENDIAN).getLong() * 48000) / C.NANOS_PER_SECOND));
        }
    }

    final /* synthetic */ zzpz zzaw() {
        return this.zzc;
    }

    final /* synthetic */ zzsr zzax() {
        return this.zze;
    }

    final /* synthetic */ void zzay(boolean z) {
        this.zzn = true;
    }

    @Override // com.google.android.gms.internal.ads.zzhr, com.google.android.gms.internal.ads.zzln
    public final zzko zzd() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzko
    public final long zzg() {
        if (zze() == 2) {
            zzbh();
        }
        return this.zzk;
    }

    @Override // com.google.android.gms.internal.ads.zzko
    public final boolean zzh() {
        boolean z = this.zzn;
        this.zzn = false;
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzko
    public final void zzi(zzav zzavVar) {
        this.zzd.zzo(zzavVar);
    }

    @Override // com.google.android.gms.internal.ads.zzko
    public final zzav zzj() {
        return this.zzd.zzp();
    }

    @Override // com.google.android.gms.internal.ads.zzte, com.google.android.gms.internal.ads.zzhr
    protected final void zzy(boolean z, boolean z2) throws zzib {
        super.zzy(z, z2);
        this.zzc.zza(this.zza);
        zzJ();
        zzqh zzqhVar = this.zzd;
        zzqhVar.zzb(zzK());
        zzqhVar.zzc(zzL());
    }

    @Override // com.google.android.gms.internal.ads.zzte
    protected final zzht zzam(zzkj zzkjVar) throws zzib {
        zzv zzvVar = zzkjVar.zzb;
        zzvVar.getClass();
        this.zzi = zzvVar;
        zzht zzhtVarZzam = super.zzam(zzkjVar);
        this.zzc.zzc(zzvVar, zzhtVarZzam);
        return zzhtVarZzam;
    }

    @Override // com.google.android.gms.internal.ads.zzte
    protected final boolean zzaq(long j, long j2, zzsv zzsvVar, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, zzv zzvVar) throws zzib {
        byteBuffer.getClass();
        this.zzq = C.TIME_UNSET;
        if (this.zzj != null && (i2 & 2) != 0) {
            zzsvVar.getClass();
            zzsvVar.zzc(i, false);
            return true;
        }
        if (z) {
            if (zzsvVar != null) {
                zzsvVar.zzc(i, false);
            }
            this.zza.zzf += i3;
            this.zzd.zzj();
            return true;
        }
        try {
            if (!this.zzd.zzk(byteBuffer, j3, i3)) {
                this.zzq = j3;
                return false;
            }
            if (zzsvVar != null) {
                zzsvVar.zzc(i, false);
            }
            this.zza.zze += i3;
            return true;
        } catch (zzqd e) {
            zzv zzvVar2 = this.zzi;
            if (zzaD()) {
                zzJ();
            }
            throw zzN(e, zzvVar2, e.zzb, PlaybackException.ERROR_CODE_AUDIO_TRACK_INIT_FAILED);
        } catch (zzqg e2) {
            if (zzaD()) {
                zzJ();
            }
            throw zzN(e2, zzvVar, e2.zzb, PlaybackException.ERROR_CODE_AUDIO_TRACK_WRITE_FAILED);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzte, com.google.android.gms.internal.ads.zzhr, com.google.android.gms.internal.ads.zzli
    public final void zzx(int i, Object obj) throws zzib {
        zzsr zzsrVar;
        if (i == 2) {
            zzqh zzqhVar = this.zzd;
            obj.getClass();
            zzqhVar.zzx(((Float) obj).floatValue());
            return;
        }
        if (i == 3) {
            zzd zzdVar = (zzd) obj;
            zzqh zzqhVar2 = this.zzd;
            zzdVar.getClass();
            zzqhVar2.zzr(zzdVar);
            return;
        }
        if (i == 6) {
            zze zzeVar = (zze) obj;
            zzqh zzqhVar3 = this.zzd;
            zzeVar.getClass();
            zzqhVar3.zzt(zzeVar);
            return;
        }
        if (i == 12) {
            this.zzd.zzu((AudioDeviceInfo) obj);
            return;
        }
        if (i == 16) {
            obj.getClass();
            this.zzo = ((Integer) obj).intValue();
            zzsv zzsvVarZzaE = zzaE();
            if (zzsvVarZzaE == null || Build.VERSION.SDK_INT < 35) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("importance", Math.max(0, -this.zzo));
            zzsvVarZzaE.zzo(bundle);
            return;
        }
        if (i == 9) {
            zzqh zzqhVar4 = this.zzd;
            obj.getClass();
            zzqhVar4.zzq(((Boolean) obj).booleanValue());
        } else {
            if (i != 10) {
                super.zzx(i, obj);
                return;
            }
            obj.getClass();
            int iIntValue = ((Integer) obj).intValue();
            this.zzd.zzs(iIntValue);
            if (Build.VERSION.SDK_INT < 35 || (zzsrVar = this.zze) == null) {
                return;
            }
            zzsrVar.zza(iIntValue);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzte
    protected final void zzan(zzv zzvVar, MediaFormat mediaFormat) throws zzib {
        int[] iArr;
        int i;
        zzv zzvVar2 = this.zzj;
        int[] iArr2 = null;
        boolean z = true;
        if (zzvVar2 != null) {
            zzvVar = zzvVar2;
        } else if (zzaE() != null) {
            mediaFormat.getClass();
            int iZzz = MimeTypes.AUDIO_RAW.equals(zzvVar.zzo) ? zzvVar.zzI : (Build.VERSION.SDK_INT < 24 || !mediaFormat.containsKey("pcm-encoding")) ? mediaFormat.containsKey("v-bits-per-sample") ? zzep.zzz(mediaFormat.getInteger("v-bits-per-sample"), ByteOrder.LITTLE_ENDIAN) : 2 : mediaFormat.getInteger("pcm-encoding");
            zzt zztVar = new zzt();
            zztVar.zzm(MimeTypes.AUDIO_RAW);
            zztVar.zzG(iZzz);
            zztVar.zzH(zzvVar.zzJ);
            zztVar.zzI(zzvVar.zzK);
            zztVar.zzk(zzvVar.zzl);
            Object obj = zzvVar.zzm;
            zztVar.zza(zzvVar.zza);
            zztVar.zzc(zzvVar.zzb);
            zztVar.zzd(zzvVar.zzc);
            zztVar.zze(zzvVar.zzd);
            zztVar.zzf(zzvVar.zze);
            zztVar.zzg(zzvVar.zzf);
            zztVar.zzE(mediaFormat.getInteger("channel-count"));
            zztVar.zzF(mediaFormat.getInteger("sample-rate"));
            zzv zzvVarZzM = zztVar.zzM();
            if (this.zzg && zzvVarZzM.zzG == 6 && (i = zzvVar.zzG) < 6) {
                iArr2 = new int[i];
                for (int i2 = 0; i2 < i; i2++) {
                    iArr2[i2] = i2;
                }
            } else if (this.zzh) {
                int i3 = zzvVarZzM.zzG;
                if (i3 == 3) {
                    iArr = new int[]{0, 2, 1};
                } else if (i3 == 5) {
                    iArr = new int[]{0, 2, 1, 3, 4};
                } else if (i3 == 6) {
                    iArr = new int[]{0, 2, 1, 5, 3, 4};
                } else if (i3 == 7) {
                    iArr = new int[]{0, 2, 1, 6, 5, 3, 4};
                } else if (i3 == 8) {
                    iArr = new int[]{0, 2, 1, 7, 5, 6, 3, 4};
                }
                iArr2 = iArr;
            }
            zzvVar = zzvVarZzM;
        }
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                if (zzaD()) {
                    zzJ();
                }
                if (Build.VERSION.SDK_INT < 29) {
                    z = false;
                }
                zzgmd.zzh(z);
            }
            this.zzd.zzh(zzvVar, 0, iArr2);
        } catch (zzqc e) {
            throw zzN(e, e.zza, false, PlaybackException.ERROR_CODE_AUDIO_TRACK_INIT_FAILED);
        }
    }
}
