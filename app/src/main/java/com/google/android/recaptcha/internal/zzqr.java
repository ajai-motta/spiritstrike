package com.google.android.recaptcha.internal;

import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzqr implements zzuf {
    private final zzqq zza;
    private int zzb;
    private int zzc;
    private int zzd = 0;

    private zzqr(zzqq zzqqVar) {
        byte[] bArr = zzsv.zzb;
        this.zza = zzqqVar;
        zzqqVar.zzd = this;
    }

    private final void zzP(Object obj, zzug zzugVar, zzry zzryVar) throws IOException {
        int i = this.zzc;
        this.zzc = ((this.zzb >>> 3) << 3) | 4;
        try {
            zzugVar.zzh(obj, this, zzryVar);
            if (this.zzb == this.zzc) {
            } else {
                throw new zzsx("Failed to parse the message.");
            }
        } finally {
            this.zzc = i;
        }
    }

    private final void zzQ(Object obj, zzug zzugVar, zzry zzryVar) throws IOException {
        zzqq zzqqVar = this.zza;
        int iZzn = zzqqVar.zzn();
        zzqqVar.zzI();
        int iZze = zzqqVar.zze(iZzn);
        zzqqVar.zza++;
        zzugVar.zzh(obj, this, zzryVar);
        zzqqVar.zzz(0);
        zzqqVar.zza--;
        zzqqVar.zzA(iZze);
    }

    private final void zzR(int i) throws IOException {
        if (this.zza.zzd() != i) {
            throw new zzsx("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }

    private final void zzS(int i) throws IOException {
        if ((this.zzb & 7) != i) {
            throw new zzsw("Protocol message tag had invalid wire type.");
        }
    }

    private static final void zzT(int i) throws IOException {
        if ((i & 3) != 0) {
            throw new zzsx("Failed to parse the message.");
        }
    }

    private static final void zzU(int i) throws IOException {
        if ((i & 7) != 0) {
            throw new zzsx("Failed to parse the message.");
        }
    }

    public static zzqr zzq(zzqq zzqqVar) {
        zzqr zzqrVar = zzqqVar.zzd;
        return zzqrVar != null ? zzqrVar : new zzqr(zzqqVar);
    }

    @Override // com.google.android.recaptcha.internal.zzuf
    public final void zzA(List list) throws IOException {
        int iZzm;
        int iZzm2;
        if (list instanceof zzth) {
            zzth zzthVar = (zzth) list;
            int i = this.zzb & 7;
            if (i != 1) {
                if (i != 2) {
                    throw new zzsw("Protocol message tag had invalid wire type.");
                }
                zzqq zzqqVar = this.zza;
                int iZzn = zzqqVar.zzn();
                zzU(iZzn);
                int iZzd = zzqqVar.zzd() + iZzn;
                do {
                    zzthVar.zzg(zzqqVar.zzo());
                } while (zzqqVar.zzd() < iZzd);
                return;
            }
            do {
                zzqq zzqqVar2 = this.zza;
                zzthVar.zzg(zzqqVar2.zzo());
                if (zzqqVar2.zzC()) {
                    return;
                } else {
                    iZzm2 = zzqqVar2.zzm();
                }
            } while (iZzm2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new zzsw("Protocol message tag had invalid wire type.");
                }
                zzqq zzqqVar3 = this.zza;
                int iZzn2 = zzqqVar3.zzn();
                zzU(iZzn2);
                int iZzd2 = zzqqVar3.zzd() + iZzn2;
                do {
                    list.add(Long.valueOf(zzqqVar3.zzo()));
                } while (zzqqVar3.zzd() < iZzd2);
                return;
            }
            do {
                zzqq zzqqVar4 = this.zza;
                list.add(Long.valueOf(zzqqVar4.zzo()));
                if (zzqqVar4.zzC()) {
                    return;
                } else {
                    iZzm = zzqqVar4.zzm();
                }
            } while (iZzm == this.zzb);
            iZzm2 = iZzm;
        }
        this.zzd = iZzm2;
    }

    @Override // com.google.android.recaptcha.internal.zzuf
    public final void zzB(List list) throws IOException {
        int iZzm;
        int iZzm2;
        if (list instanceof zzsf) {
            zzsf zzsfVar = (zzsf) list;
            int i = this.zzb & 7;
            if (i == 2) {
                zzqq zzqqVar = this.zza;
                int iZzn = zzqqVar.zzn();
                zzT(iZzn);
                int iZzd = zzqqVar.zzd() + iZzn;
                do {
                    zzsfVar.zzf(zzqqVar.zzc());
                } while (zzqqVar.zzd() < iZzd);
                return;
            }
            if (i != 5) {
                throw new zzsw("Protocol message tag had invalid wire type.");
            }
            do {
                zzqq zzqqVar2 = this.zza;
                zzsfVar.zzf(zzqqVar2.zzc());
                if (zzqqVar2.zzC()) {
                    return;
                } else {
                    iZzm2 = zzqqVar2.zzm();
                }
            } while (iZzm2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                zzqq zzqqVar3 = this.zza;
                int iZzn2 = zzqqVar3.zzn();
                zzT(iZzn2);
                int iZzd2 = zzqqVar3.zzd() + iZzn2;
                do {
                    list.add(Float.valueOf(zzqqVar3.zzc()));
                } while (zzqqVar3.zzd() < iZzd2);
                return;
            }
            if (i2 != 5) {
                throw new zzsw("Protocol message tag had invalid wire type.");
            }
            do {
                zzqq zzqqVar4 = this.zza;
                list.add(Float.valueOf(zzqqVar4.zzc()));
                if (zzqqVar4.zzC()) {
                    return;
                } else {
                    iZzm = zzqqVar4.zzm();
                }
            } while (iZzm == this.zzb);
            iZzm2 = iZzm;
        }
        this.zzd = iZzm2;
    }

    @Override // com.google.android.recaptcha.internal.zzuf
    @Deprecated
    public final void zzC(List list, zzug zzugVar, zzry zzryVar) throws IOException {
        int iZzm;
        int i = this.zzb;
        if ((i & 7) != 3) {
            throw new zzsw("Protocol message tag had invalid wire type.");
        }
        do {
            Object objZze = zzugVar.zze();
            zzP(objZze, zzugVar, zzryVar);
            zzugVar.zzf(objZze);
            list.add(objZze);
            zzqq zzqqVar = this.zza;
            if (zzqqVar.zzC() || this.zzd != 0) {
                return;
            } else {
                iZzm = zzqqVar.zzm();
            }
        } while (iZzm == i);
        this.zzd = iZzm;
    }

    @Override // com.google.android.recaptcha.internal.zzuf
    public final void zzD(List list) throws IOException {
        int iZzm;
        int iZzm2;
        if (list instanceof zzso) {
            zzso zzsoVar = (zzso) list;
            int i = this.zzb & 7;
            if (i != 0) {
                if (i != 2) {
                    throw new zzsw("Protocol message tag had invalid wire type.");
                }
                zzqq zzqqVar = this.zza;
                int iZzd = zzqqVar.zzd() + zzqqVar.zzn();
                do {
                    zzsoVar.zzh(zzqqVar.zzh());
                } while (zzqqVar.zzd() < iZzd);
                zzR(iZzd);
                return;
            }
            do {
                zzqq zzqqVar2 = this.zza;
                zzsoVar.zzh(zzqqVar2.zzh());
                if (zzqqVar2.zzC()) {
                    return;
                } else {
                    iZzm2 = zzqqVar2.zzm();
                }
            } while (iZzm2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zzsw("Protocol message tag had invalid wire type.");
                }
                zzqq zzqqVar3 = this.zza;
                int iZzd2 = zzqqVar3.zzd() + zzqqVar3.zzn();
                do {
                    list.add(Integer.valueOf(zzqqVar3.zzh()));
                } while (zzqqVar3.zzd() < iZzd2);
                zzR(iZzd2);
                return;
            }
            do {
                zzqq zzqqVar4 = this.zza;
                list.add(Integer.valueOf(zzqqVar4.zzh()));
                if (zzqqVar4.zzC()) {
                    return;
                } else {
                    iZzm = zzqqVar4.zzm();
                }
            } while (iZzm == this.zzb);
            iZzm2 = iZzm;
        }
        this.zzd = iZzm2;
    }

    @Override // com.google.android.recaptcha.internal.zzuf
    public final void zzE(List list) throws IOException {
        int iZzm;
        int iZzm2;
        if (list instanceof zzth) {
            zzth zzthVar = (zzth) list;
            int i = this.zzb & 7;
            if (i != 0) {
                if (i != 2) {
                    throw new zzsw("Protocol message tag had invalid wire type.");
                }
                zzqq zzqqVar = this.zza;
                int iZzd = zzqqVar.zzd() + zzqqVar.zzn();
                do {
                    zzthVar.zzg(zzqqVar.zzp());
                } while (zzqqVar.zzd() < iZzd);
                zzR(iZzd);
                return;
            }
            do {
                zzqq zzqqVar2 = this.zza;
                zzthVar.zzg(zzqqVar2.zzp());
                if (zzqqVar2.zzC()) {
                    return;
                } else {
                    iZzm2 = zzqqVar2.zzm();
                }
            } while (iZzm2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zzsw("Protocol message tag had invalid wire type.");
                }
                zzqq zzqqVar3 = this.zza;
                int iZzd2 = zzqqVar3.zzd() + zzqqVar3.zzn();
                do {
                    list.add(Long.valueOf(zzqqVar3.zzp()));
                } while (zzqqVar3.zzd() < iZzd2);
                zzR(iZzd2);
                return;
            }
            do {
                zzqq zzqqVar4 = this.zza;
                list.add(Long.valueOf(zzqqVar4.zzp()));
                if (zzqqVar4.zzC()) {
                    return;
                } else {
                    iZzm = zzqqVar4.zzm();
                }
            } while (iZzm == this.zzb);
            iZzm2 = iZzm;
        }
        this.zzd = iZzm2;
    }

    @Override // com.google.android.recaptcha.internal.zzuf
    public final void zzF(List list, zzug zzugVar, zzry zzryVar) throws IOException {
        int iZzm;
        int i = this.zzb;
        if ((i & 7) != 2) {
            throw new zzsw("Protocol message tag had invalid wire type.");
        }
        do {
            Object objZze = zzugVar.zze();
            zzQ(objZze, zzugVar, zzryVar);
            zzugVar.zzf(objZze);
            list.add(objZze);
            zzqq zzqqVar = this.zza;
            if (zzqqVar.zzC() || this.zzd != 0) {
                return;
            } else {
                iZzm = zzqqVar.zzm();
            }
        } while (iZzm == i);
        this.zzd = iZzm;
    }

    @Override // com.google.android.recaptcha.internal.zzuf
    public final void zzG(List list) throws IOException {
        int iZzm;
        int iZzm2;
        if (list instanceof zzso) {
            zzso zzsoVar = (zzso) list;
            int i = this.zzb & 7;
            if (i == 2) {
                zzqq zzqqVar = this.zza;
                int iZzn = zzqqVar.zzn();
                zzT(iZzn);
                int iZzd = zzqqVar.zzd() + iZzn;
                do {
                    zzsoVar.zzh(zzqqVar.zzk());
                } while (zzqqVar.zzd() < iZzd);
                return;
            }
            if (i != 5) {
                throw new zzsw("Protocol message tag had invalid wire type.");
            }
            do {
                zzqq zzqqVar2 = this.zza;
                zzsoVar.zzh(zzqqVar2.zzk());
                if (zzqqVar2.zzC()) {
                    return;
                } else {
                    iZzm2 = zzqqVar2.zzm();
                }
            } while (iZzm2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                zzqq zzqqVar3 = this.zza;
                int iZzn2 = zzqqVar3.zzn();
                zzT(iZzn2);
                int iZzd2 = zzqqVar3.zzd() + iZzn2;
                do {
                    list.add(Integer.valueOf(zzqqVar3.zzk()));
                } while (zzqqVar3.zzd() < iZzd2);
                return;
            }
            if (i2 != 5) {
                throw new zzsw("Protocol message tag had invalid wire type.");
            }
            do {
                zzqq zzqqVar4 = this.zza;
                list.add(Integer.valueOf(zzqqVar4.zzk()));
                if (zzqqVar4.zzC()) {
                    return;
                } else {
                    iZzm = zzqqVar4.zzm();
                }
            } while (iZzm == this.zzb);
            iZzm2 = iZzm;
        }
        this.zzd = iZzm2;
    }

    @Override // com.google.android.recaptcha.internal.zzuf
    public final void zzH(List list) throws IOException {
        int iZzm;
        int iZzm2;
        if (list instanceof zzth) {
            zzth zzthVar = (zzth) list;
            int i = this.zzb & 7;
            if (i != 1) {
                if (i != 2) {
                    throw new zzsw("Protocol message tag had invalid wire type.");
                }
                zzqq zzqqVar = this.zza;
                int iZzn = zzqqVar.zzn();
                zzU(iZzn);
                int iZzd = zzqqVar.zzd() + iZzn;
                do {
                    zzthVar.zzg(zzqqVar.zzt());
                } while (zzqqVar.zzd() < iZzd);
                return;
            }
            do {
                zzqq zzqqVar2 = this.zza;
                zzthVar.zzg(zzqqVar2.zzt());
                if (zzqqVar2.zzC()) {
                    return;
                } else {
                    iZzm2 = zzqqVar2.zzm();
                }
            } while (iZzm2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new zzsw("Protocol message tag had invalid wire type.");
                }
                zzqq zzqqVar3 = this.zza;
                int iZzn2 = zzqqVar3.zzn();
                zzU(iZzn2);
                int iZzd2 = zzqqVar3.zzd() + iZzn2;
                do {
                    list.add(Long.valueOf(zzqqVar3.zzt()));
                } while (zzqqVar3.zzd() < iZzd2);
                return;
            }
            do {
                zzqq zzqqVar4 = this.zza;
                list.add(Long.valueOf(zzqqVar4.zzt()));
                if (zzqqVar4.zzC()) {
                    return;
                } else {
                    iZzm = zzqqVar4.zzm();
                }
            } while (iZzm == this.zzb);
            iZzm2 = iZzm;
        }
        this.zzd = iZzm2;
    }

    @Override // com.google.android.recaptcha.internal.zzuf
    public final void zzI(List list) throws IOException {
        int iZzm;
        int iZzm2;
        if (list instanceof zzso) {
            zzso zzsoVar = (zzso) list;
            int i = this.zzb & 7;
            if (i != 0) {
                if (i != 2) {
                    throw new zzsw("Protocol message tag had invalid wire type.");
                }
                zzqq zzqqVar = this.zza;
                int iZzd = zzqqVar.zzd() + zzqqVar.zzn();
                do {
                    zzsoVar.zzh(zzqqVar.zzl());
                } while (zzqqVar.zzd() < iZzd);
                zzR(iZzd);
                return;
            }
            do {
                zzqq zzqqVar2 = this.zza;
                zzsoVar.zzh(zzqqVar2.zzl());
                if (zzqqVar2.zzC()) {
                    return;
                } else {
                    iZzm2 = zzqqVar2.zzm();
                }
            } while (iZzm2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zzsw("Protocol message tag had invalid wire type.");
                }
                zzqq zzqqVar3 = this.zza;
                int iZzd2 = zzqqVar3.zzd() + zzqqVar3.zzn();
                do {
                    list.add(Integer.valueOf(zzqqVar3.zzl()));
                } while (zzqqVar3.zzd() < iZzd2);
                zzR(iZzd2);
                return;
            }
            do {
                zzqq zzqqVar4 = this.zza;
                list.add(Integer.valueOf(zzqqVar4.zzl()));
                if (zzqqVar4.zzC()) {
                    return;
                } else {
                    iZzm = zzqqVar4.zzm();
                }
            } while (iZzm == this.zzb);
            iZzm2 = iZzm;
        }
        this.zzd = iZzm2;
    }

    @Override // com.google.android.recaptcha.internal.zzuf
    public final void zzJ(List list) throws IOException {
        int iZzm;
        int iZzm2;
        if (list instanceof zzth) {
            zzth zzthVar = (zzth) list;
            int i = this.zzb & 7;
            if (i != 0) {
                if (i != 2) {
                    throw new zzsw("Protocol message tag had invalid wire type.");
                }
                zzqq zzqqVar = this.zza;
                int iZzd = zzqqVar.zzd() + zzqqVar.zzn();
                do {
                    zzthVar.zzg(zzqqVar.zzu());
                } while (zzqqVar.zzd() < iZzd);
                zzR(iZzd);
                return;
            }
            do {
                zzqq zzqqVar2 = this.zza;
                zzthVar.zzg(zzqqVar2.zzu());
                if (zzqqVar2.zzC()) {
                    return;
                } else {
                    iZzm2 = zzqqVar2.zzm();
                }
            } while (iZzm2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zzsw("Protocol message tag had invalid wire type.");
                }
                zzqq zzqqVar3 = this.zza;
                int iZzd2 = zzqqVar3.zzd() + zzqqVar3.zzn();
                do {
                    list.add(Long.valueOf(zzqqVar3.zzu()));
                } while (zzqqVar3.zzd() < iZzd2);
                zzR(iZzd2);
                return;
            }
            do {
                zzqq zzqqVar4 = this.zza;
                list.add(Long.valueOf(zzqqVar4.zzu()));
                if (zzqqVar4.zzC()) {
                    return;
                } else {
                    iZzm = zzqqVar4.zzm();
                }
            } while (iZzm == this.zzb);
            iZzm2 = iZzm;
        }
        this.zzd = iZzm2;
    }

    public final void zzK(List list, boolean z) throws IOException {
        int iZzm;
        int iZzm2;
        if ((this.zzb & 7) != 2) {
            throw new zzsw("Protocol message tag had invalid wire type.");
        }
        if ((list instanceof zzte) && !z) {
            zzte zzteVar = (zzte) list;
            do {
                zzp();
                zzteVar.zzb();
                zzqq zzqqVar = this.zza;
                if (zzqqVar.zzC()) {
                    return;
                } else {
                    iZzm2 = zzqqVar.zzm();
                }
            } while (iZzm2 == this.zzb);
        } else {
            do {
                list.add(z ? zzs() : zzr());
                zzqq zzqqVar2 = this.zza;
                if (zzqqVar2.zzC()) {
                    return;
                } else {
                    iZzm = zzqqVar2.zzm();
                }
            } while (iZzm == this.zzb);
            iZzm2 = iZzm;
        }
        this.zzd = iZzm2;
    }

    @Override // com.google.android.recaptcha.internal.zzuf
    public final void zzL(List list) throws IOException {
        int iZzm;
        int iZzm2;
        if (list instanceof zzso) {
            zzso zzsoVar = (zzso) list;
            int i = this.zzb & 7;
            if (i != 0) {
                if (i != 2) {
                    throw new zzsw("Protocol message tag had invalid wire type.");
                }
                zzqq zzqqVar = this.zza;
                int iZzd = zzqqVar.zzd() + zzqqVar.zzn();
                do {
                    zzsoVar.zzh(zzqqVar.zzn());
                } while (zzqqVar.zzd() < iZzd);
                zzR(iZzd);
                return;
            }
            do {
                zzqq zzqqVar2 = this.zza;
                zzsoVar.zzh(zzqqVar2.zzn());
                if (zzqqVar2.zzC()) {
                    return;
                } else {
                    iZzm2 = zzqqVar2.zzm();
                }
            } while (iZzm2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zzsw("Protocol message tag had invalid wire type.");
                }
                zzqq zzqqVar3 = this.zza;
                int iZzd2 = zzqqVar3.zzd() + zzqqVar3.zzn();
                do {
                    list.add(Integer.valueOf(zzqqVar3.zzn()));
                } while (zzqqVar3.zzd() < iZzd2);
                zzR(iZzd2);
                return;
            }
            do {
                zzqq zzqqVar4 = this.zza;
                list.add(Integer.valueOf(zzqqVar4.zzn()));
                if (zzqqVar4.zzC()) {
                    return;
                } else {
                    iZzm = zzqqVar4.zzm();
                }
            } while (iZzm == this.zzb);
            iZzm2 = iZzm;
        }
        this.zzd = iZzm2;
    }

    @Override // com.google.android.recaptcha.internal.zzuf
    public final void zzM(List list) throws IOException {
        int iZzm;
        int iZzm2;
        if (list instanceof zzth) {
            zzth zzthVar = (zzth) list;
            int i = this.zzb & 7;
            if (i != 0) {
                if (i != 2) {
                    throw new zzsw("Protocol message tag had invalid wire type.");
                }
                zzqq zzqqVar = this.zza;
                int iZzd = zzqqVar.zzd() + zzqqVar.zzn();
                do {
                    zzthVar.zzg(zzqqVar.zzv());
                } while (zzqqVar.zzd() < iZzd);
                zzR(iZzd);
                return;
            }
            do {
                zzqq zzqqVar2 = this.zza;
                zzthVar.zzg(zzqqVar2.zzv());
                if (zzqqVar2.zzC()) {
                    return;
                } else {
                    iZzm2 = zzqqVar2.zzm();
                }
            } while (iZzm2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zzsw("Protocol message tag had invalid wire type.");
                }
                zzqq zzqqVar3 = this.zza;
                int iZzd2 = zzqqVar3.zzd() + zzqqVar3.zzn();
                do {
                    list.add(Long.valueOf(zzqqVar3.zzv()));
                } while (zzqqVar3.zzd() < iZzd2);
                zzR(iZzd2);
                return;
            }
            do {
                zzqq zzqqVar4 = this.zza;
                list.add(Long.valueOf(zzqqVar4.zzv()));
                if (zzqqVar4.zzC()) {
                    return;
                } else {
                    iZzm = zzqqVar4.zzm();
                }
            } while (iZzm == this.zzb);
            iZzm2 = iZzm;
        }
        this.zzd = iZzm2;
    }

    @Override // com.google.android.recaptcha.internal.zzuf
    public final boolean zzN() throws IOException {
        zzS(0);
        return this.zza.zzD();
    }

    @Override // com.google.android.recaptcha.internal.zzuf
    public final boolean zzO() throws IOException {
        int i;
        zzqq zzqqVar = this.zza;
        if (zzqqVar.zzC() || (i = this.zzb) == this.zzc) {
            return false;
        }
        return zzqqVar.zzE(i);
    }

    @Override // com.google.android.recaptcha.internal.zzuf
    public final double zza() throws IOException {
        zzS(1);
        return this.zza.zzb();
    }

    @Override // com.google.android.recaptcha.internal.zzuf
    public final float zzb() throws IOException {
        zzS(5);
        return this.zza.zzc();
    }

    @Override // com.google.android.recaptcha.internal.zzuf
    public final int zzc() throws IOException {
        int iZzm = this.zzd;
        if (iZzm != 0) {
            this.zzb = iZzm;
            this.zzd = 0;
        } else {
            iZzm = this.zza.zzm();
            this.zzb = iZzm;
        }
        if (iZzm == 0 || iZzm == this.zzc) {
            return Integer.MAX_VALUE;
        }
        return iZzm >>> 3;
    }

    @Override // com.google.android.recaptcha.internal.zzuf
    public final int zzd() {
        return this.zzb;
    }

    @Override // com.google.android.recaptcha.internal.zzuf
    public final int zze() throws IOException {
        zzS(0);
        return this.zza.zzf();
    }

    @Override // com.google.android.recaptcha.internal.zzuf
    public final int zzf() throws IOException {
        zzS(5);
        return this.zza.zzg();
    }

    @Override // com.google.android.recaptcha.internal.zzuf
    public final int zzg() throws IOException {
        zzS(0);
        return this.zza.zzh();
    }

    @Override // com.google.android.recaptcha.internal.zzuf
    public final int zzh() throws IOException {
        zzS(5);
        return this.zza.zzk();
    }

    @Override // com.google.android.recaptcha.internal.zzuf
    public final int zzi() throws IOException {
        zzS(0);
        return this.zza.zzl();
    }

    @Override // com.google.android.recaptcha.internal.zzuf
    public final int zzj() throws IOException {
        zzS(0);
        return this.zza.zzn();
    }

    @Override // com.google.android.recaptcha.internal.zzuf
    public final long zzk() throws IOException {
        zzS(1);
        return this.zza.zzo();
    }

    @Override // com.google.android.recaptcha.internal.zzuf
    public final long zzl() throws IOException {
        zzS(0);
        return this.zza.zzp();
    }

    @Override // com.google.android.recaptcha.internal.zzuf
    public final long zzm() throws IOException {
        zzS(1);
        return this.zza.zzt();
    }

    @Override // com.google.android.recaptcha.internal.zzuf
    public final long zzn() throws IOException {
        zzS(0);
        return this.zza.zzu();
    }

    @Override // com.google.android.recaptcha.internal.zzuf
    public final long zzo() throws IOException {
        zzS(0);
        return this.zza.zzv();
    }

    @Override // com.google.android.recaptcha.internal.zzuf
    public final zzqm zzp() throws IOException {
        zzS(2);
        return this.zza.zzw();
    }

    @Override // com.google.android.recaptcha.internal.zzuf
    public final String zzr() throws IOException {
        zzS(2);
        return this.zza.zzx();
    }

    @Override // com.google.android.recaptcha.internal.zzuf
    public final String zzs() throws IOException {
        zzS(2);
        return this.zza.zzy();
    }

    @Override // com.google.android.recaptcha.internal.zzuf
    public final void zzt(Object obj, zzug zzugVar, zzry zzryVar) throws IOException {
        zzS(3);
        zzP(obj, zzugVar, zzryVar);
    }

    @Override // com.google.android.recaptcha.internal.zzuf
    public final void zzu(Object obj, zzug zzugVar, zzry zzryVar) throws IOException {
        zzS(2);
        zzQ(obj, zzugVar, zzryVar);
    }

    @Override // com.google.android.recaptcha.internal.zzuf
    public final void zzv(List list) throws IOException {
        int iZzm;
        int iZzm2;
        if (list instanceof zzqd) {
            zzqd zzqdVar = (zzqd) list;
            int i = this.zzb & 7;
            if (i != 0) {
                if (i != 2) {
                    throw new zzsw("Protocol message tag had invalid wire type.");
                }
                zzqq zzqqVar = this.zza;
                int iZzd = zzqqVar.zzd() + zzqqVar.zzn();
                do {
                    zzqdVar.zze(zzqqVar.zzD());
                } while (zzqqVar.zzd() < iZzd);
                zzR(iZzd);
                return;
            }
            do {
                zzqq zzqqVar2 = this.zza;
                zzqdVar.zze(zzqqVar2.zzD());
                if (zzqqVar2.zzC()) {
                    return;
                } else {
                    iZzm2 = zzqqVar2.zzm();
                }
            } while (iZzm2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zzsw("Protocol message tag had invalid wire type.");
                }
                zzqq zzqqVar3 = this.zza;
                int iZzd2 = zzqqVar3.zzd() + zzqqVar3.zzn();
                do {
                    list.add(Boolean.valueOf(zzqqVar3.zzD()));
                } while (zzqqVar3.zzd() < iZzd2);
                zzR(iZzd2);
                return;
            }
            do {
                zzqq zzqqVar4 = this.zza;
                list.add(Boolean.valueOf(zzqqVar4.zzD()));
                if (zzqqVar4.zzC()) {
                    return;
                } else {
                    iZzm = zzqqVar4.zzm();
                }
            } while (iZzm == this.zzb);
            iZzm2 = iZzm;
        }
        this.zzd = iZzm2;
    }

    @Override // com.google.android.recaptcha.internal.zzuf
    public final void zzw(List list) throws IOException {
        int iZzm;
        if ((this.zzb & 7) != 2) {
            throw new zzsw("Protocol message tag had invalid wire type.");
        }
        do {
            list.add(zzp());
            zzqq zzqqVar = this.zza;
            if (zzqqVar.zzC()) {
                return;
            } else {
                iZzm = zzqqVar.zzm();
            }
        } while (iZzm == this.zzb);
        this.zzd = iZzm;
    }

    @Override // com.google.android.recaptcha.internal.zzuf
    public final void zzx(List list) throws IOException {
        int iZzm;
        int iZzm2;
        if (list instanceof zzrs) {
            zzrs zzrsVar = (zzrs) list;
            int i = this.zzb & 7;
            if (i != 1) {
                if (i != 2) {
                    throw new zzsw("Protocol message tag had invalid wire type.");
                }
                zzqq zzqqVar = this.zza;
                int iZzn = zzqqVar.zzn();
                zzU(iZzn);
                int iZzd = zzqqVar.zzd() + iZzn;
                do {
                    zzrsVar.zzf(zzqqVar.zzb());
                } while (zzqqVar.zzd() < iZzd);
                return;
            }
            do {
                zzqq zzqqVar2 = this.zza;
                zzrsVar.zzf(zzqqVar2.zzb());
                if (zzqqVar2.zzC()) {
                    return;
                } else {
                    iZzm2 = zzqqVar2.zzm();
                }
            } while (iZzm2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new zzsw("Protocol message tag had invalid wire type.");
                }
                zzqq zzqqVar3 = this.zza;
                int iZzn2 = zzqqVar3.zzn();
                zzU(iZzn2);
                int iZzd2 = zzqqVar3.zzd() + iZzn2;
                do {
                    list.add(Double.valueOf(zzqqVar3.zzb()));
                } while (zzqqVar3.zzd() < iZzd2);
                return;
            }
            do {
                zzqq zzqqVar4 = this.zza;
                list.add(Double.valueOf(zzqqVar4.zzb()));
                if (zzqqVar4.zzC()) {
                    return;
                } else {
                    iZzm = zzqqVar4.zzm();
                }
            } while (iZzm == this.zzb);
            iZzm2 = iZzm;
        }
        this.zzd = iZzm2;
    }

    @Override // com.google.android.recaptcha.internal.zzuf
    public final void zzy(List list) throws IOException {
        int iZzm;
        int iZzm2;
        if (list instanceof zzso) {
            zzso zzsoVar = (zzso) list;
            int i = this.zzb & 7;
            if (i != 0) {
                if (i != 2) {
                    throw new zzsw("Protocol message tag had invalid wire type.");
                }
                zzqq zzqqVar = this.zza;
                int iZzd = zzqqVar.zzd() + zzqqVar.zzn();
                do {
                    zzsoVar.zzh(zzqqVar.zzf());
                } while (zzqqVar.zzd() < iZzd);
                zzR(iZzd);
                return;
            }
            do {
                zzqq zzqqVar2 = this.zza;
                zzsoVar.zzh(zzqqVar2.zzf());
                if (zzqqVar2.zzC()) {
                    return;
                } else {
                    iZzm2 = zzqqVar2.zzm();
                }
            } while (iZzm2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zzsw("Protocol message tag had invalid wire type.");
                }
                zzqq zzqqVar3 = this.zza;
                int iZzd2 = zzqqVar3.zzd() + zzqqVar3.zzn();
                do {
                    list.add(Integer.valueOf(zzqqVar3.zzf()));
                } while (zzqqVar3.zzd() < iZzd2);
                zzR(iZzd2);
                return;
            }
            do {
                zzqq zzqqVar4 = this.zza;
                list.add(Integer.valueOf(zzqqVar4.zzf()));
                if (zzqqVar4.zzC()) {
                    return;
                } else {
                    iZzm = zzqqVar4.zzm();
                }
            } while (iZzm == this.zzb);
            iZzm2 = iZzm;
        }
        this.zzd = iZzm2;
    }

    @Override // com.google.android.recaptcha.internal.zzuf
    public final void zzz(List list) throws IOException {
        int iZzm;
        int iZzm2;
        if (list instanceof zzso) {
            zzso zzsoVar = (zzso) list;
            int i = this.zzb & 7;
            if (i == 2) {
                zzqq zzqqVar = this.zza;
                int iZzn = zzqqVar.zzn();
                zzT(iZzn);
                int iZzd = zzqqVar.zzd() + iZzn;
                do {
                    zzsoVar.zzh(zzqqVar.zzg());
                } while (zzqqVar.zzd() < iZzd);
                return;
            }
            if (i != 5) {
                throw new zzsw("Protocol message tag had invalid wire type.");
            }
            do {
                zzqq zzqqVar2 = this.zza;
                zzsoVar.zzh(zzqqVar2.zzg());
                if (zzqqVar2.zzC()) {
                    return;
                } else {
                    iZzm2 = zzqqVar2.zzm();
                }
            } while (iZzm2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                zzqq zzqqVar3 = this.zza;
                int iZzn2 = zzqqVar3.zzn();
                zzT(iZzn2);
                int iZzd2 = zzqqVar3.zzd() + iZzn2;
                do {
                    list.add(Integer.valueOf(zzqqVar3.zzg()));
                } while (zzqqVar3.zzd() < iZzd2);
                return;
            }
            if (i2 != 5) {
                throw new zzsw("Protocol message tag had invalid wire type.");
            }
            do {
                zzqq zzqqVar4 = this.zza;
                list.add(Integer.valueOf(zzqqVar4.zzg()));
                if (zzqqVar4.zzC()) {
                    return;
                } else {
                    iZzm = zzqqVar4.zzm();
                }
            } while (iZzm == this.zzb);
            iZzm2 = iZzm;
        }
        this.zzd = iZzm2;
    }
}
