package com.google.android.gms.internal.measurement;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzjo extends AbstractSafeParcelable implements Comparable<zzjo> {
    public static final Parcelable.Creator<zzjo> CREATOR = new zzjp();
    public final String zza;
    final long zzb;
    final boolean zzc;
    final double zzd;

    @Nullable
    final String zze;

    @Nullable
    final byte[] zzf;
    public final int zzg;
    public final int zzh;
    private final int zzi;

    zzjo(String str, long j, boolean z, double d, @Nullable String str2, @Nullable byte[] bArr, int i, int i2, int i3) {
        this.zza = str;
        this.zzb = j;
        this.zzc = z;
        this.zzd = d;
        this.zze = str2;
        this.zzf = bArr;
        this.zzg = i;
        this.zzh = i2;
        this.zzi = i3;
    }

    private static int zzg(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i != i2 ? 1 : 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x0096, code lost:
    
        if (r0 != false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00a3, code lost:
    
        if (r4 == r6) goto L45;
     */
    @Override // java.lang.Comparable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* bridge */ /* synthetic */ int compareTo(com.google.android.gms.internal.measurement.zzjo r9) {
        /*
            r8 = this;
            com.google.android.gms.internal.measurement.zzjo r9 = (com.google.android.gms.internal.measurement.zzjo) r9
            java.lang.String r0 = r9.zza
            java.lang.String r1 = r8.zza
            int r0 = r1.compareTo(r0)
            if (r0 == 0) goto Le
            goto La7
        Le:
            int r0 = r8.zzg
            int r1 = r9.zzg
            int r1 = zzg(r0, r1)
            if (r1 == 0) goto L1b
        L18:
            r0 = r1
            goto La7
        L1b:
            r1 = -1
            r2 = 0
            r3 = 1
            if (r0 == r3) goto L99
            r4 = 2
            if (r0 == r4) goto L8e
            r4 = 3
            if (r0 == r4) goto L85
            r4 = 4
            if (r0 == r4) goto L73
            r4 = 5
            if (r0 != r4) goto L52
            byte[] r0 = r8.zzf
            byte[] r9 = r9.zzf
            if (r0 != r9) goto L33
            goto L79
        L33:
            if (r0 != 0) goto L36
            goto L18
        L36:
            if (r9 != 0) goto L3a
            goto La6
        L3a:
            int r1 = r9.length
            int r3 = r0.length
            int r4 = java.lang.Math.min(r3, r1)
            if (r2 >= r4) goto L4d
            r1 = r0[r2]
            r3 = r9[r2]
            int r1 = r1 - r3
            if (r1 == 0) goto L4a
            goto L18
        L4a:
            int r2 = r2 + 1
            goto L3a
        L4d:
            int r0 = zzg(r3, r1)
            goto La7
        L52:
            java.lang.AssertionError r9 = new java.lang.AssertionError
            java.lang.String r1 = java.lang.String.valueOf(r0)
            int r1 = r1.length()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            int r1 = r1 + 20
            r2.<init>(r1)
            java.lang.String r1 = "Invalid enum value: "
            r2.append(r1)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r9.<init>(r0)
            throw r9
        L73:
            java.lang.String r0 = r8.zze
            java.lang.String r9 = r9.zze
            if (r0 != r9) goto L7a
        L79:
            goto L94
        L7a:
            if (r0 != 0) goto L7d
            goto L18
        L7d:
            if (r9 != 0) goto L80
            goto L98
        L80:
            int r0 = r0.compareTo(r9)
            goto La7
        L85:
            double r0 = r8.zzd
            double r2 = r9.zzd
            int r0 = java.lang.Double.compare(r0, r2)
            goto La7
        L8e:
            boolean r0 = r8.zzc
            boolean r9 = r9.zzc
            if (r0 != r9) goto L96
        L94:
            r0 = r2
            goto La7
        L96:
            if (r0 == 0) goto L18
        L98:
            goto La6
        L99:
            long r4 = r8.zzb
            long r6 = r9.zzb
            int r9 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r9 >= 0) goto La3
            goto L18
        La3:
            if (r9 != 0) goto La6
            goto L79
        La6:
            r0 = r3
        La7:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjo.compareTo(java.lang.Object):int");
    }

    public final boolean equals(@Nullable Object obj) {
        int i;
        if (obj instanceof zzjo) {
            zzjo zzjoVar = (zzjo) obj;
            if (zzkl.zza(this.zza, zzjoVar.zza) && (i = this.zzg) == zzjoVar.zzg && this.zzh == zzjoVar.zzh && this.zzi == zzjoVar.zzi) {
                if (i == 1) {
                    return this.zzb == zzjoVar.zzb;
                }
                if (i == 2) {
                    return this.zzc == zzjoVar.zzc;
                }
                if (i == 3) {
                    return this.zzd == zzjoVar.zzd;
                }
                if (i == 4) {
                    return zzkl.zza(this.zze, zzjoVar.zze);
                }
                if (i == 5) {
                    return Arrays.equals(this.zzf, zzjoVar.zzf);
                }
                StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 20);
                sb.append("Invalid enum value: ");
                sb.append(i);
                throw new AssertionError(sb.toString());
            }
        }
        return false;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        zzf(sb);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        String str = this.zza;
        boolean zZzb = zzjp.zzb(str);
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        if (!zZzb) {
            SafeParcelWriter.writeString(parcel, 2, str, false);
        }
        long j = this.zzb;
        if (j != 0) {
            SafeParcelWriter.writeLong(parcel, 3, j);
        }
        if (this.zzc) {
            SafeParcelWriter.writeBoolean(parcel, 4, true);
        }
        double d = this.zzd;
        if (d != 0.0d) {
            SafeParcelWriter.writeDouble(parcel, 5, d);
        }
        String str2 = this.zze;
        if (!zzjp.zzb(str2)) {
            SafeParcelWriter.writeString(parcel, 6, str2, false);
        }
        byte[] bArr = this.zzf;
        if (!zzjp.zzb(bArr)) {
            SafeParcelWriter.writeByteArray(parcel, 7, bArr, false);
        }
        int i2 = this.zzg;
        if (!zzjp.zza(i2)) {
            SafeParcelWriter.writeInt(parcel, 8, i2);
        }
        int i3 = this.zzh;
        if (!zzjp.zza(i3)) {
            SafeParcelWriter.writeInt(parcel, 9, i3);
        }
        int i4 = this.zzi;
        if (!zzjp.zza(i4)) {
            SafeParcelWriter.writeInt(parcel, 10, i4);
        }
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final long zza() {
        if (this.zzg == 1) {
            return this.zzb;
        }
        throw new IllegalArgumentException("Not a long type");
    }

    public final boolean zzb() {
        if (this.zzg == 2) {
            return this.zzc;
        }
        throw new IllegalArgumentException("Not a boolean type");
    }

    public final double zzc() {
        if (this.zzg == 3) {
            return this.zzd;
        }
        throw new IllegalArgumentException("Not a double type");
    }

    public final String zzd() {
        if (this.zzg == 4) {
            return (String) Preconditions.checkNotNull(this.zze);
        }
        throw new IllegalArgumentException("Not a String type");
    }

    public final byte[] zze() {
        if (this.zzg == 5) {
            return (byte[]) Preconditions.checkNotNull(this.zzf);
        }
        throw new IllegalArgumentException("Not a bytes type");
    }

    final void zzf(StringBuilder sb) {
        sb.append("Flag(");
        String str = this.zza;
        sb.append(str);
        sb.append(", ");
        int i = this.zzg;
        if (i == 1) {
            sb.append(this.zzb);
        } else if (i == 2) {
            sb.append(this.zzc);
        } else if (i == 3) {
            sb.append(this.zzd);
        } else if (i == 4) {
            sb.append("'");
            sb.append((String) Preconditions.checkNotNull(this.zze));
            sb.append("'");
        } else {
            if (i != 5) {
                StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 16 + String.valueOf(i).length());
                sb2.append("Invalid type: ");
                sb2.append(str);
                sb2.append(", ");
                sb2.append(i);
                throw new AssertionError(sb2.toString());
            }
            sb.append("'");
            sb.append(Base64.encodeToString((byte[]) Preconditions.checkNotNull(this.zzf), 3));
            sb.append("'");
        }
        sb.append(", ");
        sb.append(i);
        sb.append(", ");
        sb.append(this.zzh);
        sb.append(", ");
        sb.append(this.zzi);
        sb.append(")");
    }
}
