package com.facebook.ads.redexgen.core;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.google.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.9H, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C9H {
    public static byte[] A0A;
    public static String[] A0B = {"rRI8qFzkORd3qFRWXYKq4VZ7aOLIEK5J", "8iww", "9Fk01UJleHjJYWOvUCOjDovINy", "Tv7H9N81DtUxkF43CmkgrLrGhTLdsXix", "nBkKdwNSwO57UCO3SoKJGDMTXuqjBDbM", "lOXwNuIjFjHmQAdnwK2N8OZR9kPb", "lPFUJhDD1cvxNL1LCxfPRC2f3Pky1Kvn", "6r"};
    public final int A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final int A04;
    public final int A05;
    public final int A06;
    public final C2725qI A07;
    public final boolean A08;
    public final InterfaceC09353k[] A09;

    public static String A06(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0A, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 4);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A07() {
        A0A = new byte[]{5, 36, 39, 32, 52, 45, 53, 0, 52, 37, 40, 46, Ascii.DC2, 40, 47, 42, 40, 63, 35, 38, 46, Ascii.VT, 63, 46, 35, 37, Ascii.RS, 56, 43, 41, 33, 112, 106, 57, 62, 43, 62, 47, 119, 111, 46, 102, 106, 43, 63, 46, 35, 37, Ascii.RS, 56, 43, 41, 33, Ascii.VT, 38, 38, 37, 41, 43, 62, 47, 46, 100, 45, 47, 62, 98, 99, 119, 111, 46};
    }

    static {
        A07();
    }

    public C9H(C2725qI c2725qI, int i, int i2, int i3, int i4, int i5, int i6, int i7, InterfaceC09353k[] interfaceC09353kArr, boolean z) {
        this.A07 = c2725qI;
        this.A01 = i;
        this.A04 = i2;
        this.A05 = i3;
        this.A06 = i4;
        this.A02 = i5;
        this.A03 = i6;
        this.A00 = i7;
        this.A09 = interfaceC09353kArr;
        this.A08 = z;
    }

    public static AudioAttributes A00() {
        return new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build();
    }

    public static AudioAttributes A01(C2731qQ c2731qQ, boolean z) {
        if (z) {
            return A00();
        }
        return c2731qQ.A01().A00;
    }

    private AudioTrack A02(C2731qQ c2731qQ, int i) {
        int iA04 = C5C.A04(c2731qQ.A05);
        if (i != 0) {
            return new AudioTrack(iA04, this.A06, this.A02, this.A03, this.A00, 1, i);
        }
        return new AudioTrack(iA04, this.A06, this.A02, this.A03, this.A00, 1);
    }

    private AudioTrack A03(boolean z, C2731qQ c2731qQ, int i) {
        if (C5C.A02 >= 29) {
            return A05(z, c2731qQ, i);
        }
        if (C5C.A02 >= 21) {
            return A04(z, c2731qQ, i);
        }
        AudioTrack audioTrackA02 = A02(c2731qQ, i);
        String[] strArr = A0B;
        if (strArr[5].length() == strArr[7].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0B;
        strArr2[5] = "QYyaIvQJX9uBRZ92y0XmWMx9BnIt";
        strArr2[7] = "OM";
        return audioTrackA02;
    }

    private AudioTrack A04(boolean z, C2731qQ c2731qQ, int i) {
        return new AudioTrack(A01(c2731qQ, z), C2606oM.A0D(this.A06, this.A02, this.A03), this.A00, 1, i);
    }

    private AudioTrack A05(boolean z, C2731qQ c2731qQ, int i) {
        AudioFormat audioFormatA0D = C2606oM.A0D(this.A06, this.A02, this.A03);
        AudioAttributes audioTrackAttributes = A01(c2731qQ, z);
        AudioTrack.Builder audioFormat = new AudioTrack.Builder().setAudioAttributes(audioTrackAttributes).setAudioFormat(audioFormatA0D);
        boolean z2 = true;
        AudioTrack.Builder sessionId = audioFormat.setTransferMode(1).setBufferSizeInBytes(this.A00).setSessionId(i);
        if (this.A04 != 1) {
            z2 = false;
        }
        AudioTrack audioTrackBuild = sessionId.setOffloadedPlayback(z2).build();
        String[] strArr = A0B;
        if (strArr[4].length() == strArr[2].length()) {
            throw new RuntimeException();
        }
        A0B[1] = "btQ69Jh";
        return audioTrackBuild;
    }

    public final long A08(long j) {
        return (1000000 * j) / ((long) this.A06);
    }

    public final long A09(long j) {
        return (1000000 * j) / ((long) this.A07.A0G);
    }

    @MetaExoPlayerCustomization(type = {"FEATURE_LOGIC"}, value = "D23918943: Monitor the audio track usage through audioTrackAllocated")
    public final AudioTrack A0A(boolean z, C2731qQ c2731qQ, int i) throws C10728t {
        try {
            AudioTrack audioTrackA03 = A03(z, c2731qQ, i);
            C2606oM.A0M().incrementAndGet();
            int state = audioTrackA03.getState();
            if (state == 1) {
                return audioTrackA03;
            }
            try {
                audioTrackA03.release();
                C2606oM.A0M().decrementAndGet();
            } catch (Exception e) {
                AbstractC09574g.A08(A06(0, 16, 69), String.format(A06(16, 55, 78), Integer.valueOf(state), Integer.valueOf(C2606oM.A0M().get())), e);
            }
            throw new C10728t(state, this.A06, this.A02, this.A00, this.A07, A0D(), null, C2606oM.A0M().get());
        } catch (IllegalArgumentException | UnsupportedOperationException e2) {
            throw new C10728t(0, this.A06, this.A02, this.A00, this.A07, A0D(), e2, C2606oM.A0M().get());
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.facebook.ads.redexgen.X.8r] */
    public final C10708r A0B() {
        final int i = this.A03;
        final int i2 = this.A06;
        final int i3 = this.A02;
        final boolean z = this.A08;
        final boolean z2 = this.A04 == 1;
        final int i4 = this.A00;
        return new Object(i, i2, i3, z, z2, i4) { // from class: com.facebook.ads.redexgen.X.8r
            public final int A00;
            public final int A01;
            public final int A02;
            public final int A03;
            public final boolean A04;
            public final boolean A05;

            {
                this.A02 = i;
                this.A03 = i2;
                this.A01 = i3;
                this.A05 = z;
                this.A04 = z2;
                this.A00 = i4;
            }
        };
    }

    public final C9H A0C(int i) {
        return new C9H(this.A07, this.A01, this.A04, this.A05, this.A06, this.A02, this.A03, i, this.A09, this.A08);
    }

    public final boolean A0D() {
        return this.A04 == 1;
    }

    public final boolean A0E(C9H c9h) {
        return c9h.A04 == this.A04 && c9h.A03 == this.A03 && c9h.A06 == this.A06 && c9h.A02 == this.A02 && c9h.A05 == this.A05;
    }
}
