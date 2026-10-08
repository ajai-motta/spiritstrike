package com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4;

import android.util.Pair;
import com.adjust.sdk.Constants;
import com.fyber.inneractive.sdk.player.exoplayer2.util.z;
import com.google.android.exoplayer2.C;

/* JADX INFO: loaded from: classes3.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f1328a = z.a("vide");
    public static final int b = z.a("soun");
    public static final int c = z.a("text");
    public static final int d = z.a("sbtl");
    public static final int e = z.a("subt");
    public static final int f = z.a("clcp");
    public static final int g = z.a(C.CENC_TYPE_cenc);
    public static final int h = z.a(Constants.REFERRER_API_META);

    /* JADX WARN: Removed duplicated region for block: B:280:0x04dd  */
    /* JADX WARN: Removed duplicated region for block: B:432:0x0507 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.s a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a r44, com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.b r45, long r46, com.fyber.inneractive.sdk.player.exoplayer2.drm.d r48, boolean r49) throws com.fyber.inneractive.sdk.player.exoplayer2.r {
        /*
            Method dump skipped, instruction units count: 2019
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.i.a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a, com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.b, long, com.fyber.inneractive.sdk.player.exoplayer2.drm.d, boolean):com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.s");
    }

    public static int a(com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar, int i, int i2, f fVar, int i3) {
        int i4 = nVar.b;
        while (true) {
            if (i4 - i >= i2) {
                return 0;
            }
            nVar.e(i4);
            int iB = nVar.b();
            com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(iB > 0, "childAtomSize should be positive");
            if (nVar.b() == c.W) {
                int i5 = i4 + 8;
                Pair pairCreate = null;
                boolean z = false;
                Integer numValueOf = null;
                t tVar = null;
                while (i5 - i4 < iB) {
                    nVar.e(i5);
                    int iB2 = nVar.b();
                    int iB3 = nVar.b();
                    if (iB3 == c.c0) {
                        numValueOf = Integer.valueOf(nVar.b());
                    } else if (iB3 == c.X) {
                        nVar.e(nVar.b + 4);
                        z = nVar.b() == g;
                    } else if (iB3 == c.Y) {
                        int i6 = i5 + 8;
                        while (true) {
                            if (i6 - i5 >= iB2) {
                                tVar = null;
                                break;
                            }
                            nVar.e(i6);
                            int iB4 = nVar.b();
                            if (nVar.b() == c.Z) {
                                nVar.e(nVar.b + 6);
                                nVar.j();
                                int iJ = nVar.j();
                                byte[] bArr = new byte[16];
                                nVar.a(bArr, 0, 16);
                                tVar = new t(iJ, bArr);
                                break;
                            }
                            i6 += iB4;
                        }
                    }
                    i5 += iB2;
                }
                if (z) {
                    com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(numValueOf != null, "frma atom is mandatory");
                    com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(tVar != null, "schi->tenc atom is mandatory");
                    pairCreate = Pair.create(numValueOf, tVar);
                }
                if (pairCreate != null) {
                    fVar.f1325a[i3] = (t) pairCreate.second;
                    return ((Integer) pairCreate.first).intValue();
                }
            }
            i4 += iB;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.util.Pair a(int r3, com.fyber.inneractive.sdk.player.exoplayer2.util.n r4) {
        /*
            Method dump skipped, instruction units count: 204
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.i.a(int, com.fyber.inneractive.sdk.player.exoplayer2.util.n):android.util.Pair");
    }

    public static int a(com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar) {
        int iJ = nVar.j();
        int i = iJ & 127;
        while ((iJ & 128) == 128) {
            iJ = nVar.j();
            i = (i << 7) | (iJ & 127);
        }
        return i;
    }
}
