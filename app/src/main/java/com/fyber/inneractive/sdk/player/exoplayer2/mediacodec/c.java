package com.fyber.inneractive.sdk.player.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.SystemClock;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.fyber.inneractive.sdk.player.exoplayer2.decoder.DecoderCounters;
import com.fyber.inneractive.sdk.player.exoplayer2.o;
import com.fyber.inneractive.sdk.player.exoplayer2.p;
import com.fyber.inneractive.sdk.player.exoplayer2.util.w;
import com.fyber.inneractive.sdk.player.exoplayer2.util.z;
import com.google.android.exoplayer2.C;
import com.google.common.base.Ascii;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c extends com.fyber.inneractive.sdk.player.exoplayer2.a {
    public static final byte[] O;
    public ByteBuffer[] A;
    public long B;
    public int C;
    public int D;
    public boolean E;
    public boolean F;
    public int G;
    public int H;
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public DecoderCounters N;
    public final d h;
    public final com.fyber.inneractive.sdk.player.exoplayer2.decoder.c i;
    public final com.fyber.inneractive.sdk.player.exoplayer2.decoder.c j;
    public final p k;
    public final ArrayList l;
    public final MediaCodec.BufferInfo m;
    public o n;
    public MediaCodec o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public boolean v;
    public boolean w;
    public boolean x;
    public boolean y;
    public ByteBuffer[] z;

    static {
        int i = z.f1480a;
        byte[] bArr = new byte[38];
        for (int i2 = 0; i2 < 38; i2++) {
            int i3 = i2 * 2;
            bArr[i2] = (byte) (Character.digit("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78".charAt(i3 + 1), 16) + (Character.digit("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78".charAt(i3), 16) << 4));
        }
        O = bArr;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(int i, boolean z) {
        super(i);
        d dVar = d.f1396a;
        if (z.f1480a < 16) {
            throw new IllegalStateException();
        }
        this.h = dVar;
        this.i = new com.fyber.inneractive.sdk.player.exoplayer2.decoder.c();
        this.j = new com.fyber.inneractive.sdk.player.exoplayer2.decoder.c();
        this.k = new p();
        this.l = new ArrayList();
        this.m = new MediaCodec.BufferInfo();
        this.G = 0;
        this.H = 0;
    }

    public a a(d dVar, o oVar) {
        String str = oVar.f;
        dVar.getClass();
        return j.a(false, str);
    }

    public abstract void a(MediaCodec mediaCodec, MediaFormat mediaFormat);

    public abstract void a(a aVar, MediaCodec mediaCodec, o oVar);

    public abstract void a(String str, long j, long j2);

    public abstract boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, long j3, boolean z);

    public boolean a(boolean z, o oVar, o oVar2) {
        return false;
    }

    public abstract int b(d dVar, o oVar);

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.a
    public boolean e() {
        return this.L;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.a
    public boolean f() {
        if (this.n != null) {
            if ((this.f ? this.g : this.d.isReady()) || this.D >= 0 || (this.B != C.TIME_UNSET && SystemClock.elapsedRealtime() < this.B)) {
                return true;
            }
        }
        return false;
    }

    public final boolean k() throws com.fyber.inneractive.sdk.player.exoplayer2.d {
        MediaCodec mediaCodec = this.o;
        if (mediaCodec == null || this.H == 2 || this.K) {
            return false;
        }
        if (this.C < 0) {
            int iDequeueInputBuffer = mediaCodec.dequeueInputBuffer(0L);
            this.C = iDequeueInputBuffer;
            if (iDequeueInputBuffer < 0) {
                return false;
            }
            com.fyber.inneractive.sdk.player.exoplayer2.decoder.c cVar = this.i;
            cVar.c = this.z[iDequeueInputBuffer];
            cVar.a();
        }
        if (this.H == 1) {
            if (!this.t) {
                this.J = true;
                this.o.queueInputBuffer(this.C, 0, 0, 0L, 4);
                this.C = -1;
            }
            this.H = 2;
            return false;
        }
        if (this.x) {
            this.x = false;
            ByteBuffer byteBuffer = this.i.c;
            byte[] bArr = O;
            byteBuffer.put(bArr);
            this.o.queueInputBuffer(this.C, 0, bArr.length, 0L, 0);
            this.C = -1;
            this.I = true;
            return true;
        }
        if (this.G == 1) {
            for (int i = 0; i < this.n.h.size(); i++) {
                this.i.c.put((byte[]) this.n.h.get(i));
            }
            this.G = 2;
        }
        int iPosition = this.i.c.position();
        int iA = a(this.k, this.i, false);
        if (iA == -3) {
            return false;
        }
        if (iA == -5) {
            if (this.G == 2) {
                this.i.a();
                this.G = 1;
            }
            a(this.k.f1405a);
            return true;
        }
        if (this.i.b(4)) {
            if (this.G == 2) {
                this.i.a();
                this.G = 1;
            }
            this.K = true;
            if (!this.I) {
                n();
                return false;
            }
            try {
                if (!this.t) {
                    this.J = true;
                    this.o.queueInputBuffer(this.C, 0, 0, 0L, 4);
                    this.C = -1;
                }
                return false;
            } catch (MediaCodec.CryptoException e) {
                throw new com.fyber.inneractive.sdk.player.exoplayer2.d(e);
            }
        }
        if (this.M && !this.i.b(1)) {
            this.i.a();
            if (this.G == 2) {
                this.G = 1;
            }
            return true;
        }
        this.M = false;
        boolean zB = this.i.b(1073741824);
        if (this.q && !zB) {
            ByteBuffer byteBuffer2 = this.i.c;
            int iPosition2 = byteBuffer2.position();
            int i2 = 0;
            int i3 = 0;
            while (true) {
                int i4 = i2 + 1;
                if (i4 >= iPosition2) {
                    byteBuffer2.clear();
                    break;
                }
                int i5 = byteBuffer2.get(i2) & 255;
                if (i3 == 3) {
                    if (i5 == 1 && (byteBuffer2.get(i4) & Ascii.US) == 7) {
                        ByteBuffer byteBufferDuplicate = byteBuffer2.duplicate();
                        byteBufferDuplicate.position(i2 - 3);
                        byteBufferDuplicate.limit(iPosition2);
                        byteBuffer2.position(0);
                        byteBuffer2.put(byteBufferDuplicate);
                        break;
                    }
                } else if (i5 == 0) {
                    i3++;
                }
                if (i5 != 0) {
                    i3 = 0;
                }
                i2 = i4;
            }
            if (this.i.c.position() == 0) {
                return true;
            }
            this.q = false;
        }
        try {
            com.fyber.inneractive.sdk.player.exoplayer2.decoder.c cVar2 = this.i;
            long j = cVar2.d;
            if (cVar2.b(Integer.MIN_VALUE)) {
                this.l.add(Long.valueOf(j));
            }
            this.i.c.flip();
            m();
            if (zB) {
                MediaCodec.CryptoInfo cryptoInfo = this.i.b.d;
                if (iPosition != 0) {
                    if (cryptoInfo.numBytesOfClearData == null) {
                        cryptoInfo.numBytesOfClearData = new int[1];
                    }
                    int[] iArr = cryptoInfo.numBytesOfClearData;
                    iArr[0] = iArr[0] + iPosition;
                }
                this.o.queueSecureInputBuffer(this.C, 0, cryptoInfo, j, 0);
            } else {
                this.o.queueInputBuffer(this.C, 0, this.i.c.limit(), j, 0);
            }
            this.C = -1;
            this.I = true;
            this.G = 0;
            this.N.inputBufferCount++;
            return true;
        } catch (MediaCodec.CryptoException e2) {
            throw new com.fyber.inneractive.sdk.player.exoplayer2.d(e2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void l() throws com.fyber.inneractive.sdk.player.exoplayer2.d {
        /*
            Method dump skipped, instruction units count: 445
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.c.l():void");
    }

    public void m() {
    }

    public final void n() throws com.fyber.inneractive.sdk.player.exoplayer2.d {
        if (this.H == 2) {
            o();
            l();
        } else {
            this.L = true;
            p();
        }
    }

    public final void o() {
        if (this.o != null) {
            this.B = C.TIME_UNSET;
            this.C = -1;
            this.D = -1;
            this.E = false;
            this.l.clear();
            this.z = null;
            this.A = null;
            this.F = false;
            this.I = false;
            this.p = false;
            this.q = false;
            this.r = false;
            this.s = false;
            this.t = false;
            this.u = false;
            this.w = false;
            this.x = false;
            this.y = false;
            this.J = false;
            this.G = 0;
            this.H = 0;
            this.N.decoderReleaseCount++;
            this.i.c = null;
            try {
                this.o.stop();
                try {
                    this.o.release();
                } finally {
                }
            } catch (Throwable th) {
                try {
                    this.o.release();
                    throw th;
                } finally {
                }
            }
        }
    }

    public void p() {
    }

    public boolean q() {
        return this.o == null && this.n != null;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.a
    public void a(boolean z, long j) throws com.fyber.inneractive.sdk.player.exoplayer2.d {
        this.K = false;
        this.L = false;
        if (this.o != null) {
            this.B = C.TIME_UNSET;
            this.C = -1;
            this.D = -1;
            this.M = true;
            this.E = false;
            this.l.clear();
            this.x = false;
            this.y = false;
            if (this.r || ((this.u && this.J) || this.H != 0)) {
                o();
                l();
            } else {
                this.o.flush();
                this.I = false;
            }
            if (!this.F || this.n == null) {
                return;
            }
            this.G = 1;
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.a
    public final void a(long j, long j2) throws com.fyber.inneractive.sdk.player.exoplayer2.d {
        boolean zA;
        boolean z;
        if (this.L) {
            p();
            return;
        }
        if (this.n == null) {
            this.j.a();
            int iA = a(this.k, this.j, true);
            if (iA != -5) {
                if (iA == -4) {
                    if (this.j.b(4)) {
                        this.K = true;
                        n();
                        return;
                    }
                    throw new IllegalStateException();
                }
                return;
            }
            a(this.k.f1405a);
        }
        l();
        if (this.o != null) {
            w.a("drainAndFeed");
            while (true) {
                if (this.D < 0) {
                    if (this.v && this.J) {
                        try {
                            this.D = this.o.dequeueOutputBuffer(this.m, 0L);
                        } catch (IllegalStateException unused) {
                            n();
                            if (this.L) {
                                o();
                            }
                        }
                    } else {
                        this.D = this.o.dequeueOutputBuffer(this.m, 0L);
                    }
                    int i = this.D;
                    if (i >= 0) {
                        if (this.y) {
                            this.y = false;
                            this.o.releaseOutputBuffer(i, false);
                            this.D = -1;
                        } else {
                            MediaCodec.BufferInfo bufferInfo = this.m;
                            if ((bufferInfo.flags & 4) != 0) {
                                n();
                                this.D = -1;
                                break;
                            }
                            ByteBuffer byteBuffer = this.A[i];
                            if (byteBuffer != null) {
                                byteBuffer.position(bufferInfo.offset);
                                MediaCodec.BufferInfo bufferInfo2 = this.m;
                                byteBuffer.limit(bufferInfo2.offset + bufferInfo2.size);
                            }
                            long j3 = this.m.presentationTimeUs;
                            int size = this.l.size();
                            int i2 = 0;
                            while (true) {
                                if (i2 >= size) {
                                    z = false;
                                    break;
                                } else {
                                    if (((Long) this.l.get(i2)).longValue() == j3) {
                                        this.l.remove(i2);
                                        z = true;
                                        break;
                                    }
                                    i2++;
                                }
                            }
                            this.E = z;
                        }
                    } else if (i == -2) {
                        MediaFormat outputFormat = this.o.getOutputFormat();
                        if (this.s && outputFormat.getInteger(ViewHierarchyConstants.DIMENSION_WIDTH_KEY) == 32 && outputFormat.getInteger(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY) == 32) {
                            this.y = true;
                        } else {
                            if (this.w) {
                                outputFormat.setInteger("channel-count", 1);
                            }
                            a(this.o, outputFormat);
                        }
                    } else if (i == -3) {
                        this.A = this.o.getOutputBuffers();
                    } else if (this.t && (this.K || this.H == 2)) {
                        n();
                    }
                }
                if (this.v && this.J) {
                    try {
                        MediaCodec mediaCodec = this.o;
                        ByteBuffer[] byteBufferArr = this.A;
                        int i3 = this.D;
                        ByteBuffer byteBuffer2 = byteBufferArr[i3];
                        MediaCodec.BufferInfo bufferInfo3 = this.m;
                        int i4 = bufferInfo3.flags;
                        zA = a(j, j2, mediaCodec, byteBuffer2, i3, bufferInfo3.presentationTimeUs, this.E);
                    } catch (IllegalStateException unused2) {
                        n();
                        if (this.L) {
                            o();
                        }
                    }
                } else {
                    MediaCodec mediaCodec2 = this.o;
                    ByteBuffer[] byteBufferArr2 = this.A;
                    int i5 = this.D;
                    ByteBuffer byteBuffer3 = byteBufferArr2[i5];
                    MediaCodec.BufferInfo bufferInfo4 = this.m;
                    int i6 = bufferInfo4.flags;
                    zA = a(j, j2, mediaCodec2, byteBuffer3, i5, bufferInfo4.presentationTimeUs, this.E);
                }
                if (!zA) {
                    break;
                }
                long j4 = this.m.presentationTimeUs;
                this.D = -1;
            }
            while (k()) {
            }
            w.a();
        } else {
            this.d.a(j - this.e);
            this.j.a();
            int iA2 = a(this.k, this.j, false);
            if (iA2 == -5) {
                a(this.k.f1405a);
            } else if (iA2 == -4) {
                if (this.j.b(4)) {
                    this.K = true;
                    n();
                } else {
                    throw new IllegalStateException();
                }
            }
        }
        this.N.ensureUpdated();
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.fyber.inneractive.sdk.player.exoplayer2.o r5) throws com.fyber.inneractive.sdk.player.exoplayer2.d {
        /*
            r4 = this;
            com.fyber.inneractive.sdk.player.exoplayer2.o r0 = r4.n
            r4.n = r5
            com.fyber.inneractive.sdk.player.exoplayer2.drm.d r5 = r5.i
            if (r0 != 0) goto La
            r1 = 0
            goto Lc
        La:
            com.fyber.inneractive.sdk.player.exoplayer2.drm.d r1 = r0.i
        Lc:
            boolean r5 = com.fyber.inneractive.sdk.player.exoplayer2.util.z.a(r5, r1)
            r1 = 1
            r5 = r5 ^ r1
            if (r5 == 0) goto L28
            com.fyber.inneractive.sdk.player.exoplayer2.o r5 = r4.n
            com.fyber.inneractive.sdk.player.exoplayer2.drm.d r5 = r5.i
            if (r5 != 0) goto L1b
            goto L28
        L1b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "Media requires a DrmSessionManager"
            r5.<init>(r0)
            com.fyber.inneractive.sdk.player.exoplayer2.d r0 = new com.fyber.inneractive.sdk.player.exoplayer2.d
            r0.<init>(r5)
            throw r0
        L28:
            android.media.MediaCodec r5 = r4.o
            if (r5 == 0) goto L51
            boolean r5 = r4.p
            com.fyber.inneractive.sdk.player.exoplayer2.o r2 = r4.n
            boolean r5 = r4.a(r5, r0, r2)
            if (r5 == 0) goto L51
            r4.F = r1
            r4.G = r1
            boolean r5 = r4.s
            if (r5 == 0) goto L4d
            com.fyber.inneractive.sdk.player.exoplayer2.o r5 = r4.n
            int r2 = r5.j
            int r3 = r0.j
            if (r2 != r3) goto L4d
            int r5 = r5.k
            int r0 = r0.k
            if (r5 != r0) goto L4d
            goto L4e
        L4d:
            r1 = 0
        L4e:
            r4.x = r1
            goto L5e
        L51:
            boolean r5 = r4.I
            if (r5 == 0) goto L58
            r4.H = r1
            goto L5e
        L58:
            r4.o()
            r4.l()
        L5e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.c.a(com.fyber.inneractive.sdk.player.exoplayer2.o):void");
    }
}
