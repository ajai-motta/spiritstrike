package com.fyber.inneractive.sdk.player.exoplayer2.audio;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.os.ConditionVariable;
import android.os.SystemClock;
import android.util.Log;
import com.fyber.inneractive.sdk.player.exoplayer2.util.z;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes3.dex */
public final class r {
    public long A;
    public boolean B;
    public long C;
    public Method D;
    public int E;
    public long F;
    public long G;
    public int H;
    public long I;
    public long J;
    public int K;
    public int L;
    public long M;
    public long N;
    public long O;
    public float P;
    public c[] Q;
    public ByteBuffer[] R;
    public ByteBuffer S;
    public ByteBuffer T;
    public byte[] U;
    public int V;
    public int W;
    public boolean X;
    public boolean Y;
    public int Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s f1273a;
    public boolean a0;
    public final x b;
    public boolean b0;
    public final c[] c;
    public long c0;
    public final o d;
    public final ConditionVariable e = new ConditionVariable(true);
    public final long[] f;
    public final k g;
    public final LinkedList h;
    public AudioTrack i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public boolean o;
    public int p;
    public long q;
    public com.fyber.inneractive.sdk.player.exoplayer2.s r;
    public com.fyber.inneractive.sdk.player.exoplayer2.s s;
    public long t;
    public long u;
    public ByteBuffer v;
    public int w;
    public int x;
    public int y;
    public long z;

    public r(c[] cVarArr, u uVar) {
        this.d = uVar;
        if (z.f1480a >= 18) {
            try {
                this.D = AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException unused) {
            }
        }
        if (z.f1480a >= 19) {
            this.g = new l();
        } else {
            this.g = new k();
        }
        s sVar = new s();
        this.f1273a = sVar;
        x xVar = new x();
        this.b = xVar;
        c[] cVarArr2 = new c[cVarArr.length + 3];
        this.c = cVarArr2;
        cVarArr2[0] = new v();
        cVarArr2[1] = sVar;
        System.arraycopy(cVarArr, 0, cVarArr2, 2, cVarArr.length);
        cVarArr2[cVarArr.length + 2] = xVar;
        this.f = new long[10];
        this.P = 1.0f;
        this.L = 0;
        this.n = 3;
        this.Z = 0;
        this.s = com.fyber.inneractive.sdk.player.exoplayer2.s.d;
        this.W = -1;
        this.Q = new c[0];
        this.R = new ByteBuffer[0];
        this.h = new LinkedList();
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x009b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(int r9, int r10, int r11, int[] r12) throws com.fyber.inneractive.sdk.player.exoplayer2.audio.m {
        /*
            Method dump skipped, instruction units count: 294
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.audio.r.a(int, int, int, int[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(java.nio.ByteBuffer r8, long r9) throws com.fyber.inneractive.sdk.player.exoplayer2.audio.q {
        /*
            Method dump skipped, instruction units count: 275
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.audio.r.b(java.nio.ByteBuffer, long):void");
    }

    public final boolean c() {
        return d() && (b() > this.g.a() || (e() && this.i.getPlayState() == 2 && this.i.getPlaybackHeadPosition() == 0));
    }

    public final boolean d() {
        return this.i != null;
    }

    public final boolean e() {
        int i;
        return z.f1480a < 23 && ((i = this.m) == 5 || i == 6);
    }

    public final void f() {
        this.Y = true;
        if (d()) {
            this.N = System.nanoTime() / 1000;
            this.i.play();
        }
    }

    public final void g() {
        if (d()) {
            this.F = 0L;
            this.G = 0L;
            this.I = 0L;
            this.J = 0L;
            this.K = 0;
            com.fyber.inneractive.sdk.player.exoplayer2.s sVar = this.r;
            if (sVar != null) {
                this.s = sVar;
                this.r = null;
            } else if (!this.h.isEmpty()) {
                this.s = ((p) this.h.getLast()).f1272a;
            }
            this.h.clear();
            this.t = 0L;
            this.u = 0L;
            this.S = null;
            this.T = null;
            int i = 0;
            while (true) {
                c[] cVarArr = this.Q;
                if (i >= cVarArr.length) {
                    break;
                }
                c cVar = cVarArr[i];
                cVar.flush();
                this.R[i] = cVar.a();
                i++;
            }
            this.X = false;
            this.W = -1;
            this.v = null;
            this.w = 0;
            this.L = 0;
            this.O = 0L;
            this.z = 0L;
            this.y = 0;
            this.x = 0;
            this.A = 0L;
            this.B = false;
            this.C = 0L;
            if (this.i.getPlayState() == 3) {
                this.i.pause();
            }
            AudioTrack audioTrack = this.i;
            this.i = null;
            this.g.a(null, false);
            this.e.close();
            new j(this, audioTrack).start();
        }
    }

    public final void h() {
        ArrayList arrayList = new ArrayList();
        for (c cVar : this.c) {
            if (cVar.d()) {
                arrayList.add(cVar);
            } else {
                cVar.flush();
            }
        }
        int size = arrayList.size();
        this.Q = (c[]) arrayList.toArray(new c[size]);
        this.R = new ByteBuffer[size];
        for (int i = 0; i < size; i++) {
            c cVar2 = this.Q[i];
            cVar2.flush();
            this.R[i] = cVar2.a();
        }
    }

    public final void i() {
        if (d()) {
            if (z.f1480a >= 21) {
                this.i.setVolume(this.P);
                return;
            }
            AudioTrack audioTrack = this.i;
            float f = this.P;
            audioTrack.setStereoVolume(f, f);
        }
    }

    public final long b() {
        return this.o ? this.J : this.I / ((long) this.H);
    }

    public final boolean a(ByteBuffer byteBuffer, long j) throws q, n {
        int i;
        int i2;
        ByteBuffer byteBuffer2 = this.S;
        if (byteBuffer2 != null && byteBuffer != byteBuffer2) {
            throw new IllegalArgumentException();
        }
        if (!d()) {
            this.e.block();
            if (this.a0) {
                this.i = new AudioTrack(new AudioAttributes.Builder().setUsage(1).setContentType(3).setFlags(16).build(), new AudioFormat.Builder().setChannelMask(this.k).setEncoding(this.m).setSampleRate(this.j).build(), this.p, 1, this.Z);
            } else if (this.Z == 0) {
                this.i = new AudioTrack(this.n, this.j, this.k, this.m, this.p, 1);
            } else {
                this.i = new AudioTrack(this.n, this.j, this.k, this.m, this.p, 1, this.Z);
            }
            int state = this.i.getState();
            if (state == 1) {
                int audioSessionId = this.i.getAudioSessionId();
                if (this.Z != audioSessionId) {
                    this.Z = audioSessionId;
                    u uVar = (u) this.d;
                    uVar.f1275a.P.audioSessionId(audioSessionId);
                    uVar.f1275a.getClass();
                }
                this.g.a(this.i, e());
                i();
                this.b0 = false;
                if (this.Y) {
                    f();
                }
            } else {
                try {
                    this.i.release();
                } catch (Exception unused) {
                } catch (Throwable th) {
                    this.i = null;
                    throw th;
                }
                this.i = null;
                throw new n(state, this.j, this.k, this.p);
            }
        }
        if (e()) {
            if (this.i.getPlayState() == 2) {
                this.b0 = false;
                return false;
            }
            if (this.i.getPlayState() == 1 && this.g.a() != 0) {
                return false;
            }
        }
        boolean z = this.b0;
        boolean zC = c();
        this.b0 = zC;
        if (z && !zC && this.i.getPlayState() != 1) {
            long jElapsedRealtime = SystemClock.elapsedRealtime() - this.c0;
            u uVar2 = (u) this.d;
            uVar2.f1275a.P.audioTrackUnderrun(this.p, com.fyber.inneractive.sdk.player.exoplayer2.b.a(this.q), jElapsedRealtime);
            uVar2.f1275a.getClass();
        }
        if (this.S == null) {
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            if (this.o && this.K == 0) {
                int i3 = this.m;
                if (i3 == 7 || i3 == 8) {
                    int iPosition = byteBuffer.position();
                    i2 = ((((byteBuffer.get(iPosition + 5) & 252) >> 2) | ((byteBuffer.get(iPosition + 4) & 1) << 6)) + 1) * 32;
                } else if (i3 == 5) {
                    i2 = 1536;
                } else if (i3 == 6) {
                    i2 = (((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3 ? a.f1262a[(byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4] : 6) * 256;
                } else {
                    throw new IllegalStateException(com.fyber.inneractive.sdk.player.exoplayer2.m.a("Unexpected audio encoding: ", i3));
                }
                this.K = i2;
            }
            if (this.r != null) {
                if (!a()) {
                    return false;
                }
                this.h.add(new p(this.r, Math.max(0L, j), (b() * 1000000) / ((long) this.j)));
                this.r = null;
                h();
            }
            int i4 = this.L;
            if (i4 == 0) {
                this.M = Math.max(0L, j);
                this.L = 1;
            } else {
                long j2 = (((this.o ? this.G : this.F / ((long) this.E)) * 1000000) / ((long) this.j)) + this.M;
                if (i4 != 1 || Math.abs(j2 - j) <= 200000) {
                    i = 2;
                } else {
                    Log.e("AudioTrack", "Discontinuity detected [expected " + j2 + ", got " + j + "]");
                    i = 2;
                    this.L = 2;
                }
                if (this.L == i) {
                    this.M = (j - j2) + this.M;
                    this.L = 1;
                    u uVar3 = (u) this.d;
                    uVar3.f1275a.getClass();
                    uVar3.f1275a.V = true;
                }
            }
            if (this.o) {
                this.G += (long) this.K;
            } else {
                this.F += (long) byteBuffer.remaining();
            }
            this.S = byteBuffer;
        }
        if (this.o) {
            b(this.S, j);
        } else {
            a(j);
        }
        if (this.S.hasRemaining()) {
            return false;
        }
        this.S = null;
        return true;
    }

    public final void a(long j) throws q {
        ByteBuffer byteBuffer;
        int length = this.Q.length;
        int i = length;
        while (i >= 0) {
            if (i > 0) {
                byteBuffer = this.R[i - 1];
            } else {
                byteBuffer = this.S;
                if (byteBuffer == null) {
                    byteBuffer = c.f1263a;
                }
            }
            if (i == length) {
                b(byteBuffer, j);
            } else {
                c cVar = this.Q[i];
                cVar.a(byteBuffer);
                ByteBuffer byteBufferA = cVar.a();
                this.R[i] = byteBufferA;
                if (byteBufferA.hasRemaining()) {
                    i++;
                }
            }
            if (byteBuffer.hasRemaining()) {
                return;
            } else {
                i--;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0038  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0032 -> B:9:0x0012). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a() throws com.fyber.inneractive.sdk.player.exoplayer2.audio.q {
        /*
            r9 = this;
            int r0 = r9.W
            r1 = 1
            r2 = 0
            r3 = -1
            if (r0 != r3) goto L14
            boolean r0 = r9.o
            if (r0 == 0) goto Lf
            com.fyber.inneractive.sdk.player.exoplayer2.audio.c[] r0 = r9.Q
            int r0 = r0.length
            goto L10
        Lf:
            r0 = r2
        L10:
            r9.W = r0
        L12:
            r0 = r1
            goto L15
        L14:
            r0 = r2
        L15:
            int r4 = r9.W
            com.fyber.inneractive.sdk.player.exoplayer2.audio.c[] r5 = r9.Q
            int r6 = r5.length
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 >= r6) goto L38
            r4 = r5[r4]
            if (r0 == 0) goto L28
            r4.b()
        L28:
            r9.a(r7)
            boolean r0 = r4.c()
            if (r0 != 0) goto L32
            return r2
        L32:
            int r0 = r9.W
            int r0 = r0 + r1
            r9.W = r0
            goto L12
        L38:
            java.nio.ByteBuffer r0 = r9.T
            if (r0 == 0) goto L44
            r9.b(r0, r7)
            java.nio.ByteBuffer r0 = r9.T
            if (r0 == 0) goto L44
            return r2
        L44:
            r9.W = r3
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.audio.r.a():boolean");
    }

    public final com.fyber.inneractive.sdk.player.exoplayer2.s a(com.fyber.inneractive.sdk.player.exoplayer2.s sVar) {
        if (this.o) {
            com.fyber.inneractive.sdk.player.exoplayer2.s sVar2 = com.fyber.inneractive.sdk.player.exoplayer2.s.d;
            this.s = sVar2;
            return sVar2;
        }
        x xVar = this.b;
        float f = sVar.f1406a;
        xVar.getClass();
        int i = z.f1480a;
        float fMax = Math.max(0.1f, Math.min(f, 8.0f));
        xVar.e = fMax;
        x xVar2 = this.b;
        float f2 = sVar.b;
        xVar2.getClass();
        xVar2.f = Math.max(0.1f, Math.min(f2, 8.0f));
        com.fyber.inneractive.sdk.player.exoplayer2.s sVar3 = new com.fyber.inneractive.sdk.player.exoplayer2.s(fMax, f2);
        com.fyber.inneractive.sdk.player.exoplayer2.s sVar4 = this.r;
        if (sVar4 == null) {
            if (!this.h.isEmpty()) {
                sVar4 = ((p) this.h.getLast()).f1272a;
            } else {
                sVar4 = this.s;
            }
        }
        if (!sVar3.equals(sVar4)) {
            if (d()) {
                this.r = sVar3;
            } else {
                this.s = sVar3;
            }
        }
        return this.s;
    }

    /* JADX WARN: Removed duplicated region for block: B:78:0x0243  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long a(boolean r23) {
        /*
            Method dump skipped, instruction units count: 598
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.audio.r.a(boolean):long");
    }
}
