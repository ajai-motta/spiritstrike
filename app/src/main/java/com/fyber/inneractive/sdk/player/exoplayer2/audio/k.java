package com.fyber.inneractive.sdk.player.exoplayer2.audio;

import android.media.AudioTrack;
import android.os.SystemClock;
import com.google.android.exoplayer2.C;

/* JADX INFO: loaded from: classes3.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AudioTrack f1271a;
    public boolean b;
    public int c;
    public long d;
    public long e;
    public long f;
    public long g;
    public long h;
    public long i;

    public void a(AudioTrack audioTrack, boolean z) {
        this.f1271a = audioTrack;
        this.b = z;
        this.g = C.TIME_UNSET;
        this.d = 0L;
        this.e = 0L;
        this.f = 0L;
        if (audioTrack != null) {
            this.c = audioTrack.getSampleRate();
        }
    }

    public long b() {
        throw new UnsupportedOperationException();
    }

    public long c() {
        throw new UnsupportedOperationException();
    }

    public final void d() {
        if (this.g != C.TIME_UNSET) {
            return;
        }
        this.f1271a.pause();
    }

    public boolean e() {
        return false;
    }

    public final void a(long j) {
        this.h = a();
        this.g = SystemClock.elapsedRealtime() * 1000;
        this.i = j;
        this.f1271a.stop();
    }

    public final long a() {
        if (this.g != C.TIME_UNSET) {
            return Math.min(this.i, this.h + ((((SystemClock.elapsedRealtime() * 1000) - this.g) * ((long) this.c)) / 1000000));
        }
        int playState = this.f1271a.getPlayState();
        if (playState == 1) {
            return 0L;
        }
        long playbackHeadPosition = ((long) this.f1271a.getPlaybackHeadPosition()) & 4294967295L;
        if (this.b) {
            if (playState == 2 && playbackHeadPosition == 0) {
                this.f = this.d;
            }
            playbackHeadPosition += this.f;
        }
        if (this.d > playbackHeadPosition) {
            this.e++;
        }
        this.d = playbackHeadPosition;
        return playbackHeadPosition + (this.e << 32);
    }
}
