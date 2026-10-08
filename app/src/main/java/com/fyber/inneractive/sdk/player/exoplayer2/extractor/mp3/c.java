package com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp3;

import com.fyber.inneractive.sdk.player.exoplayer2.extractor.i;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.j;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.m;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.r;
import com.fyber.inneractive.sdk.player.exoplayer2.util.n;
import com.fyber.inneractive.sdk.player.exoplayer2.util.z;
import com.google.android.exoplayer2.C;
import java.io.EOFException;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements i {
    public static final int m = z.a("Xing");
    public static final int n = z.a("Info");
    public static final int o = z.a("VBRI");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f1320a;
    public j e;
    public r f;
    public int g;
    public com.fyber.inneractive.sdk.player.exoplayer2.metadata.b h;
    public b i;
    public long k;
    public int l;
    public final n b = new n(10);
    public final com.fyber.inneractive.sdk.player.exoplayer2.extractor.n c = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.n();
    public final m d = new m();
    public long j = C.TIME_UNSET;

    public c(long j) {
        this.f1320a = j;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final boolean a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar) {
        return a(bVar, true);
    }

    public final a b(com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar) {
        bVar.a(this.b.f1472a, 0, 4, false);
        this.b.e(0);
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.n.a(this.b.b(), this.c);
        return new a(this.c.f, bVar.c, bVar.b);
    }

    public final boolean a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar, boolean z) throws InterruptedException, com.fyber.inneractive.sdk.player.exoplayer2.r, EOFException {
        int i;
        int i2;
        int iA;
        int i3 = z ? 16384 : 131072;
        bVar.e = 0;
        if (bVar.c == 0) {
            int i4 = 0;
            while (true) {
                bVar.a(this.b.f1472a, 0, 10, false);
                this.b.e(0);
                if (this.b.l() != com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.n.b) {
                    break;
                }
                n nVar = this.b;
                nVar.e(nVar.b + 3);
                int i5 = this.b.i();
                int i6 = i5 + 10;
                if (this.h == null) {
                    byte[] bArr = new byte[i6];
                    System.arraycopy(this.b.f1472a, 0, bArr, 0, 10);
                    bVar.a(bArr, 10, i5, false);
                    com.fyber.inneractive.sdk.player.exoplayer2.metadata.b bVarA = new com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.n(null).a(i6, bArr);
                    this.h = bVarA;
                    if (bVarA != null) {
                        this.d.a(bVarA);
                    }
                } else {
                    bVar.a(i5, false);
                }
                i4 += i6;
            }
            bVar.e = 0;
            bVar.a(i4, false);
            i = (int) (bVar.c + ((long) bVar.e));
            if (!z) {
                bVar.a(i);
            }
            i2 = 0;
        } else {
            i = 0;
            i2 = 0;
        }
        int i7 = i2;
        int i8 = i7;
        while (true) {
            if (!bVar.a(this.b.f1472a, 0, 4, i2 > 0)) {
                break;
            }
            this.b.e(0);
            int iB = this.b.b();
            if ((i7 == 0 || ((-128000) & iB) == (((long) i7) & (-128000))) && (iA = com.fyber.inneractive.sdk.player.exoplayer2.extractor.n.a(iB)) != -1) {
                i2++;
                if (i2 != 1) {
                    if (i2 == 4) {
                        break;
                    }
                } else {
                    com.fyber.inneractive.sdk.player.exoplayer2.extractor.n.a(iB, this.c);
                    i7 = iB;
                }
                bVar.a(iA - 4, false);
            } else {
                int i9 = i8 + 1;
                if (i8 == i3) {
                    if (z) {
                        return false;
                    }
                    throw new com.fyber.inneractive.sdk.player.exoplayer2.r("Searched too many bytes.");
                }
                if (z) {
                    bVar.e = 0;
                    bVar.a(i + i9, false);
                } else {
                    bVar.a(1);
                }
                i7 = 0;
                i8 = i9;
                i2 = 0;
            }
        }
        if (z) {
            bVar.a(i + i8);
        } else {
            bVar.e = 0;
        }
        this.g = i7;
        return true;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final void a(j jVar) {
        this.e = jVar;
        this.f = jVar.a(0, 1);
        this.e.b();
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final void a(long j, long j2) {
        this.g = 0;
        this.j = C.TIME_UNSET;
        this.k = 0L;
        this.l = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006a  */
    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.b r40, com.fyber.inneractive.sdk.player.exoplayer2.extractor.o r41) throws java.lang.InterruptedException, com.fyber.inneractive.sdk.player.exoplayer2.r, java.io.EOFException {
        /*
            Method dump skipped, instruction units count: 773
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp3.c.a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.b, com.fyber.inneractive.sdk.player.exoplayer2.extractor.o):int");
    }
}
