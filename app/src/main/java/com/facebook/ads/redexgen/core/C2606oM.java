package com.facebook.ads.redexgen.core;

import android.media.AudioAttributes;
import android.media.AudioDeviceInfo;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.media.PlaybackParams;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import androidx.compose.runtime.ComposerKt;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.google.android.exoplayer2.C;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.io.encoding.Base64;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.oM, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C2606oM implements InterfaceC10768z {
    public static boolean A0v;
    public static int A0w;
    public static ExecutorService A0x;
    public static byte[] A0y;
    public static String[] A0z = {"a2KSouRkY2EeYPYlRPuQP1BMARpp6f9O", "Gy", "Dq9VRycV95bIzONst7U9W8VcH5OAT2ac", "T381mgHUGlQbTRbVURm4ZuRF6EOi2D8f", "KkGB0jhfpK5IC", "ogTnlK5ViGnrQ4kTUDUA61bIZynBq2mv", "CJ3ZuNqxaIjwSiQAD7ytgom2H57haWJk", "spWmv2H5WGO5MG6CASCqBbohd0yqIF8X"};
    public static final Object A10;

    @MetaExoPlayerCustomization(type = {"NEW_CLASS_ARG"}, value = "D23918943: Monitor the audio track usage")
    public static final AtomicInteger A11;
    public float A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public int A06;
    public long A07;
    public long A08;
    public long A09;
    public long A0A;
    public long A0B;
    public long A0C;
    public AudioTrack A0D;
    public C2731qQ A0E;
    public AnonymousClass21 A0F;
    public C2704px A0G;
    public C8O A0H;
    public InterfaceC10738v A0I;
    public C9E A0J;
    public C9H A0K;
    public C9H A0L;
    public C9J A0M;
    public C9J A0N;
    public C9P A0O;
    public ByteBuffer A0P;
    public ByteBuffer A0Q;
    public ByteBuffer A0R;

    @MetaExoPlayerCustomization(type = {"NEW_CLASS_ARG"}, value = "D45157249: Retry Audio Track Init failure with less Audio track allocation sizes")
    public boolean A0S;
    public boolean A0T;
    public boolean A0U;
    public boolean A0V;
    public boolean A0W;
    public boolean A0X;
    public boolean A0Y;
    public boolean A0Z;
    public boolean A0a;
    public boolean A0b;
    public byte[] A0c;
    public InterfaceC09353k[] A0d;
    public ByteBuffer[] A0e;
    public final int A0f;
    public final InterfaceC09363l A0g;
    public final AnonymousClass48 A0h;
    public final C6W A0i;
    public final C8R A0j;
    public final AnonymousClass95 A0k;
    public final A7 A0l;
    public final C9F A0m;
    public final C9M<C10728t> A0n;
    public final C9M<C10758y> A0o;
    public final C9x A0p;
    public final ArrayDeque<C9J> A0q;
    public final boolean A0r;
    public final boolean A0s;
    public final InterfaceC09353k[] A0t;
    public final InterfaceC09353k[] A0u;

    public static String A0L(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0y, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 56);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0T() {
        A0y = new byte[]{99, 106, 44, 37, 56, 112, 106, 107, 74, 73, 78, 90, 67, 91, 110, 90, 75, 70, SignedBytes.MAX_POWER_OF_TWO, 124, 70, 65, 68, 104, 85, 66, 125, 65, 76, 84, 72, 95, Ascii.ETB, 108, 88, 73, 68, 66, 121, 95, 76, 78, 70, 127, 72, 65, 72, 76, 94, 72, 121, 69, 95, 72, 76, 73, 39, 0, 8, Ascii.CR, 4, 5, 65, Ascii.NAK, Ascii.SO, 65, Ascii.DC2, 4, Ascii.NAK, 65, 17, Ascii.CR, 0, Ascii.CAN, 3, 0, 2, 10, 65, 17, 0, 19, 0, Ascii.FF, Ascii.DC2, 121, 94, 70, 81, 92, 89, 84, Ascii.DLE, 96, 115, 125, Ascii.DLE, 85, 94, 83, 95, 84, 89, 94, 87, 10, Ascii.DLE, 73, 110, 118, 97, 108, 105, 100, 32, 111, 117, 116, 112, 117, 116, 32, 99, 104, 97, 110, 110, 101, 108, 32, 99, 111, 110, 102, 105, 103, 32, 40, 109, 111, 100, 101, Base64.padSymbol, 57, Ascii.RS, 6, 17, Ascii.FS, Ascii.EM, Ascii.DC4, 80, Ascii.US, 5, 4, 0, 5, 4, 80, Ascii.NAK, Ascii.RS, 19, Ascii.US, Ascii.DC4, Ascii.EM, Ascii.RS, Ascii.ETB, 80, 88, Ascii.GS, Ascii.US, Ascii.DC4, Ascii.NAK, 77, 33, Ascii.CAN, 9, Ascii.DC4, Ascii.GS, 104, 95, 73, 95, 78, 78, 83, 84, 93, Ascii.SUB, 73, 78, 91, 86, 86, 95, 94, Ascii.SUB, 91, 79, 94, 83, 85, Ascii.SUB, 78, 72, 91, 89, 81, 117, 78, 65, 66, 76, 69, 0, 84, 79, 0, 67, 79, 78, 70, 73, 71, 85, 82, 69, 0, 80, 65, 83, 83, 84, 72, 82, 79, 85, 71, 72, 0, 70, 79, 82, Ascii.SUB, 0, 124, 71, 76, 81, 89, 76, 74, 93, 76, 77, 9, 72, 92, 77, SignedBytes.MAX_POWER_OF_TWO, 70, 9, 76, 71, 74, 70, 77, SignedBytes.MAX_POWER_OF_TWO, 71, 78, 19, 9, Ascii.US, Ascii.VT, Ascii.SUB, Ascii.ETB, 17, 81, Ascii.FF, Ascii.US, 9};
    }

    static {
        A0T();
        A0v = false;
        A10 = new Object();
        A11 = new AtomicInteger(0);
    }

    @Deprecated
    public C2606oM(C8R c8r, InterfaceC09353k[] interfaceC09353kArr) {
        this(new C9G().A06((C8R) AbstractC2388ka.A00(c8r, C8R.A04)).A07(interfaceC09353kArr));
    }

    @RequiresNonNull({"#1.audioProcessorChain"})
    public C2606oM(C9G c9g) {
        int i;
        this.A0j = c9g.A03;
        this.A0g = c9g.A02;
        this.A0s = C5C.A02 >= 21 && c9g.A05;
        this.A0r = C5C.A02 >= 23 && c9g.A04;
        if (C5C.A02 >= 29) {
            i = c9g.A01;
        } else {
            i = 0;
        }
        this.A0f = i;
        this.A0m = c9g.A00;
        this.A0h = new AnonymousClass48(AnonymousClass45.A00);
        this.A0h.A04();
        this.A0k = new AnonymousClass95(new C2609oP(this));
        this.A0l = new A7();
        this.A0p = new C9x();
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, new AbstractC2610oQ() { // from class: com.facebook.ads.redexgen.X.9z
            public static String[] A00 = {"xDq4aPrtB4VOa6dWWLPhCvkNe2Vl9lis", "EsfqB3zUW", "UtEiT2kwdPvCqjHQhdRb9TlQndFxkub5", "Wgbe7hD6UIy", "xb", "RmqoPGkQn7vPyUpVU7ZkSehlX2jVBNRl", "20c7QZBscERNsZTH", "LeRFFk0E0DkpEnw35dU8lGRVd8w5nI17"};

            @Override // com.facebook.ads.redexgen.core.AbstractC2610oQ
            public final C09333i A09(C09333i c09333i) throws C09343j {
                int i2 = c09333i.A02;
                if (i2 != 3 && i2 != 2) {
                    if (A00[2].charAt(30) != 'b') {
                        throw new RuntimeException();
                    }
                    A00[3] = "ty1ASCrQyl5";
                    if (i2 != 268435456 && i2 != 536870912 && i2 != 805306368 && i2 != 4) {
                        throw new C09343j(c09333i);
                    }
                }
                if (i2 != 2) {
                    return new C09333i(c09333i.A03, c09333i.A01, 2);
                }
                return C09333i.A05;
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            /* JADX WARN: Removed duplicated region for block: B:25:0x00c2  */
            /* JADX WARN: Removed duplicated region for block: B:27:0x00c8  */
            @Override // com.facebook.ads.redexgen.core.InterfaceC09353k
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void AHH(java.nio.ByteBuffer r7) {
                /*
                    Method dump skipped, instruction units count: 258
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C9z.AHH(java.nio.ByteBuffer):void");
            }
        }, this.A0l, this.A0p);
        Collections.addAll(arrayList, this.A0g.A6z());
        this.A0u = (InterfaceC09353k[]) arrayList.toArray(new InterfaceC09353k[0]);
        this.A0t = new InterfaceC09353k[]{new A0()};
        this.A00 = 1.0f;
        this.A0E = C2731qQ.A07;
        this.A01 = 0;
        this.A0F = new AnonymousClass21(0, 0.0f);
        this.A0N = new C9J(C2704px.A06, false, 0L, 0L);
        this.A0G = C2704px.A06;
        this.A03 = -1;
        this.A0d = new InterfaceC09353k[0];
        this.A0e = new ByteBuffer[0];
        this.A0q = new ArrayDeque<>();
        this.A0n = new C9M<>(100L);
        this.A0o = new C9M<>(100L);
        this.A0i = null;
    }

    @MetaExoPlayerCustomization(type = {"MERGED"}, value = "D58560720: customized audio track retry logic. Feature is available upstream already")
    private int A00() {
        if (MetaExoPlayerUpgradeConfig.A03(EnumC2325jX.A1m)) {
            return A01(this.A0K.A06, this.A0K.A02, this.A0K.A03);
        }
        return 1000000;
    }

    public static int A01(int i, int i2, int i3) {
        int minBufferSize = AudioTrack.getMinBufferSize(i, i2, i3);
        AbstractC09493y.A08(minBufferSize != -2);
        return minBufferSize;
    }

    public static int A02(int i, ByteBuffer byteBuffer) {
        switch (i) {
            case 5:
            case 6:
            case 18:
                return AbstractC1260Gr.A03(byteBuffer);
            case 7:
            case 8:
                int headerDataInBigEndian = H7.A00(byteBuffer);
                return headerDataInBigEndian;
            case 9:
                int headerDataInBigEndian2 = C5C.A0F(byteBuffer, byteBuffer.position());
                int headerDataInBigEndian3 = HO.A01(headerDataInBigEndian2);
                if (headerDataInBigEndian3 != -1) {
                    return headerDataInBigEndian3;
                }
                throw new IllegalArgumentException();
            case 10:
                return 1024;
            case 11:
            case 12:
                return 2048;
            case 13:
            case 19:
            default:
                throw new IllegalStateException(A0L(244, 27, 17) + i);
            case 14:
                int syncframeOffset = AbstractC1260Gr.A02(byteBuffer);
                if (syncframeOffset == -1) {
                    return 0;
                }
                return AbstractC1260Gr.A04(byteBuffer, syncframeOffset) * 16;
            case 15:
                return 512;
            case 16:
                return 1024;
            case 17:
                return AbstractC1263Gu.A01(byteBuffer);
            case 20:
                return HT.A00(byteBuffer);
        }
    }

    private int A03(AudioFormat audioFormat, AudioAttributes audioAttributes) {
        if (C5C.A02 >= 31) {
            return AudioManager.getPlaybackOffloadSupport(audioFormat, audioAttributes);
        }
        if (!AudioManager.isOffloadedPlaybackSupported(audioFormat, audioAttributes)) {
            return 0;
        }
        if (C5C.A02 != 30) {
            return 1;
        }
        String str = C5C.A06;
        String[] strArr = A0z;
        if (strArr[2].charAt(24) != strArr[6].charAt(24)) {
            throw new RuntimeException();
        }
        A0z[7] = "3tkRuQxdBcZlCTwsgu7cjpWlPYr81dQa";
        if (!str.startsWith(A0L(TTAdConstant.IMAGE_MODE_VERTICAL_IMG_173, 5, 73))) {
            return 1;
        }
        if (A0z[7].length() != 32) {
            return 2;
        }
        A0z[7] = "7yaDe65lYY86qlvGhmsANLPH6jvNYU2p";
        return 2;
    }

    public static int A04(AudioTrack audioTrack, ByteBuffer byteBuffer, int i) {
        return audioTrack.write(byteBuffer, i, 1);
    }

    private int A05(AudioTrack audioTrack, ByteBuffer byteBuffer, int i, long j) {
        if (C5C.A02 >= 26) {
            return audioTrack.write(byteBuffer, i, 1, j * 1000);
        }
        if (this.A0P == null) {
            this.A0P = ByteBuffer.allocate(16);
            this.A0P.order(ByteOrder.BIG_ENDIAN);
            this.A0P.putInt(1431633921);
        }
        if (this.A02 == 0) {
            this.A0P.putInt(4, i);
            this.A0P.putLong(8, 1000 * j);
            this.A0P.position(0);
            this.A02 = i;
        }
        int result = this.A0P.remaining();
        if (result > 0) {
            int avSyncHeaderBytesRemaining = audioTrack.write(this.A0P, result, 1);
            if (avSyncHeaderBytesRemaining < 0) {
                this.A02 = 0;
                return avSyncHeaderBytesRemaining;
            }
            if (avSyncHeaderBytesRemaining < result) {
                return 0;
            }
        }
        int iA04 = A04(audioTrack, byteBuffer, i);
        if (iA04 < 0) {
            this.A02 = 0;
            return iA04;
        }
        int i2 = this.A02 - iA04;
        String[] strArr = A0z;
        if (strArr[0].charAt(31) == strArr[3].charAt(31)) {
            throw new RuntimeException();
        }
        A0z[7] = "dZEIQVBMkpJ01dOsE3P3AYpi9pP3UgAn";
        this.A02 = i2;
        return iA04;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long A06() {
        if (this.A0K.A04 == 0) {
            long j = this.A0A;
            if (A0z[1].length() != 2) {
                throw new RuntimeException();
            }
            String[] strArr = A0z;
            strArr[2] = "fKroUyDCoriQZ27MdWvBeynNHxXh31S0";
            strArr[6] = "V2Tsqcz9Ivj1DWTn2T33JaE9HhmQCs1A";
            return j / ((long) this.A0K.A01);
        }
        return this.A09;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long A07() {
        if (this.A0K.A04 == 0) {
            return this.A0C / ((long) this.A0K.A05);
        }
        return this.A0B;
    }

    private long A08(long j) {
        while (!this.A0q.isEmpty() && j >= this.A0q.getFirst().A00) {
            C9J c9jRemove = this.A0q.remove();
            String[] strArr = A0z;
            if (strArr[0].charAt(31) == strArr[3].charAt(31)) {
                throw new RuntimeException();
            }
            A0z[7] = "uS5QwbhdMNBXkjn1i9eeeV7Jy2FKd79B";
            this.A0N = c9jRemove;
        }
        long j2 = j - this.A0N.A00;
        if (this.A0N.A02.equals(C2704px.A06)) {
            return this.A0N.A01 + j2;
        }
        if (this.A0q.isEmpty()) {
            long mediaDurationSinceLastCheckpointUs = this.A0g.A8U(j2);
            long playoutDurationSinceLastCheckpointUs = this.A0N.A01;
            return playoutDurationSinceLastCheckpointUs + mediaDurationSinceLastCheckpointUs;
        }
        C9J first = this.A0q.getFirst();
        long jA0Q = C5C.A0Q(first.A00 - j, this.A0N.A02.A01);
        long playoutDurationSinceLastCheckpointUs2 = first.A01;
        return playoutDurationSinceLastCheckpointUs2 - jA0Q;
    }

    private long A09(long j) {
        return this.A0K.A08(this.A0g.A98()) + j;
    }

    public static AudioFormat A0D(int i, int i2, int i3) {
        return new AudioFormat.Builder().setSampleRate(i).setChannelMask(i2).setEncoding(i3).build();
    }

    private AudioTrack A0F() throws C10728t {
        try {
            return A0G((C9H) AbstractC09493y.A01(this.A0K));
        } catch (C10728t e) {
            int retryBufferSize = A00();
            if (this.A0K.A00 > retryBufferSize) {
                C9H c9hA0C = this.A0K.A0C(retryBufferSize);
                try {
                    AudioTrack audioTrackA0G = A0G(c9hA0C);
                    this.A0K = c9hA0C;
                    return audioTrackA0G;
                } catch (C10728t initialFailure) {
                    e.addSuppressed(initialFailure);
                    A0O();
                    throw e;
                }
            }
            A0O();
            throw e;
        }
    }

    private AudioTrack A0G(C9H c9h) throws C10728t {
        try {
            AudioTrack audioTrackA0A = c9h.A0A(this.A0b, this.A0E, this.A01);
            if (0 != 0) {
                A0l(audioTrackA0A);
            }
            return audioTrackA0A;
        } catch (C10728t e) {
            if (this.A0I != null) {
                this.A0I.AD6(e);
            }
            throw e;
        }
    }

    private C2704px A0I() {
        return A0K().A02;
    }

    private C9J A0K() {
        if (this.A0M != null) {
            return this.A0M;
        }
        if (!this.A0q.isEmpty()) {
            return this.A0q.getLast();
        }
        return this.A0N;
    }

    public static /* synthetic */ AtomicInteger A0M() {
        AtomicInteger atomicInteger = A11;
        if (A0z[4].length() == 6) {
            throw new RuntimeException();
        }
        A0z[7] = "bxvwh9PGR3JBxYGaTMYcQ8NcsphLXH3B";
        return atomicInteger;
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0004 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0N() {
        /*
            r3 = this;
            r2 = 0
        L1:
            com.facebook.ads.redexgen.X.3k[] r0 = r3.A0d
            int r0 = r0.length
            if (r2 >= r0) goto L18
            com.facebook.ads.redexgen.X.3k[] r0 = r3.A0d
            r0 = r0[r2]
            r0.flush()
            java.nio.ByteBuffer[] r1 = r3.A0e
            java.nio.ByteBuffer r0 = r0.A8d()
            r1[r2] = r0
            int r2 = r2 + 1
            goto L1
        L18:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C2606oM.A0N():void");
    }

    private void A0O() {
        if (this.A0K.A0D()) {
            if (A0z[1].length() != 2) {
                throw new RuntimeException();
            }
            A0z[5] = "ac1bNzRzCepoXog5xkGE2UP5sVZPG6ZN";
            this.A0W = true;
        }
    }

    private void A0P() {
        if (!this.A0a) {
            this.A0a = true;
            this.A0k.A0H(A07());
            this.A0D.stop();
            this.A02 = 0;
        }
    }

    private void A0Q() {
        this.A0A = 0L;
        this.A09 = 0L;
        this.A0C = 0L;
        this.A0B = 0L;
        this.A0V = false;
        this.A04 = 0;
        this.A0N = new C9J(A0I(), A0p(), 0L, 0L);
        this.A08 = 0L;
        this.A0M = null;
        this.A0q.clear();
        this.A0Q = null;
        this.A05 = 0;
        this.A0R = null;
        this.A0a = false;
        this.A0U = false;
        this.A03 = -1;
        this.A0P = null;
        this.A02 = 0;
        this.A0p.A0D();
        A0N();
    }

    private void A0R() {
        if (!A0h()) {
            return;
        }
        if (C5C.A02 >= 21) {
            A0X(this.A0D, this.A00);
        } else {
            A0Y(this.A0D, this.A00);
        }
    }

    private void A0S() {
        InterfaceC09353k[] interfaceC09353kArr = this.A0K.A09;
        ArrayList arrayList = new ArrayList();
        for (InterfaceC09353k interfaceC09353k : interfaceC09353kArr) {
            if (interfaceC09353k.AAL()) {
                arrayList.add(interfaceC09353k);
            } else {
                interfaceC09353k.flush();
            }
        }
        int size = arrayList.size();
        InterfaceC09353k[] audioProcessors = new InterfaceC09353k[size];
        this.A0d = (InterfaceC09353k[]) arrayList.toArray(audioProcessors);
        this.A0e = new ByteBuffer[size];
        A0N();
    }

    private void A0U(long j) {
        C2704px c2704pxA4F;
        boolean zA4G;
        if (A0i()) {
            c2704pxA4F = this.A0g.A4F(A0I());
        } else {
            c2704pxA4F = C2704px.A06;
            if (A0z[7].length() != 32) {
                throw new RuntimeException();
            }
            String[] strArr = A0z;
            strArr[0] = "I2oaxDVd9h4oXXSjJqrHfFArwnmkYbuU";
            strArr[3] = "djNSsSrQ9W3py9jFqud3MNGsNXIKPv6H";
        }
        if (A0i()) {
            zA4G = this.A0g.A4G(A0p());
        } else {
            zA4G = false;
        }
        this.A0q.add(new C9J(c2704pxA4F, zA4G, Math.max(0L, j), this.A0K.A08(A07())));
        A0S();
        if (this.A0I != null) {
            this.A0I.AFy(zA4G);
        }
    }

    private void A0V(long j) throws Exception {
        ByteBuffer byteBuffer;
        int length = this.A0d.length;
        int i = length;
        while (i >= 0) {
            if (i > 0) {
                ByteBuffer[] byteBufferArr = this.A0e;
                int i2 = i - 1;
                String[] strArr = A0z;
                String str = strArr[0];
                String str2 = strArr[3];
                int index = str.charAt(31);
                int count = str2.charAt(31);
                if (index == count) {
                    throw new RuntimeException();
                }
                A0z[1] = "0P";
                byteBuffer = byteBufferArr[i2];
            } else {
                byteBuffer = this.A0Q != null ? this.A0Q : InterfaceC09353k.A00;
            }
            if (i == length) {
                A0e(byteBuffer, j);
            } else {
                InterfaceC09353k interfaceC09353k = this.A0d[i];
                int index2 = this.A03;
                if (i > index2) {
                    interfaceC09353k.AHH(byteBuffer);
                }
                ByteBuffer byteBufferA8d = interfaceC09353k.A8d();
                this.A0e[i] = byteBufferA8d;
                if (byteBufferA8d.hasRemaining()) {
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

    private void A0W(AudioTrack audioTrack) {
        if (this.A0O == null) {
            this.A0O = new C9P(this);
        }
        C9P c9p = this.A0O;
        String[] strArr = A0z;
        if (strArr[2].charAt(24) != strArr[6].charAt(24)) {
            throw new RuntimeException();
        }
        A0z[7] = "8t8nFWsxRl9HTQxqXeO3m9pm7diLrI9Q";
        c9p.A00(audioTrack);
    }

    public static void A0X(AudioTrack audioTrack, float f) {
        audioTrack.setVolume(f);
    }

    public static void A0Y(AudioTrack audioTrack, float f) {
        audioTrack.setStereoVolume(f, f);
    }

    private void A0Z(final AudioTrack audioTrack, final AnonymousClass48 anonymousClass48, final InterfaceC10738v interfaceC10738v, final C10708r c10708r) {
        anonymousClass48.A02();
        final Handler handler = new Handler(Looper.myLooper());
        synchronized (A10) {
            if (A0x == null) {
                A0x = C5C.A0u(A0L(23, 33, 21));
            }
            A0w++;
            A0x.execute(new Runnable() { // from class: com.facebook.ads.redexgen.X.9A
                @Override // java.lang.Runnable
                public final void run() {
                    C2606oM.A0a(audioTrack, interfaceC10738v, handler, c10708r, anonymousClass48);
                }
            });
        }
    }

    public static /* synthetic */ void A0a(AudioTrack audioTrack, final InterfaceC10738v interfaceC10738v, Handler handler, final C10708r c10708r, AnonymousClass48 anonymousClass48) {
        try {
            audioTrack.flush();
            audioTrack.release();
            if (interfaceC10738v != null && handler.getLooper().getThread().isAlive()) {
                handler.post(new Runnable() { // from class: com.facebook.ads.redexgen.X.99
                    @Override // java.lang.Runnable
                    public final void run() {
                        interfaceC10738v.AD8(c10708r);
                    }
                });
            }
            anonymousClass48.A04();
            synchronized (A10) {
                A0w--;
                if (A0w == 0) {
                    A0x.shutdown();
                    A0x = null;
                }
            }
        } catch (Throwable th) {
            if (interfaceC10738v != null && handler.getLooper().getThread().isAlive()) {
                handler.post(new Runnable() { // from class: com.facebook.ads.redexgen.X.99
                    @Override // java.lang.Runnable
                    public final void run() {
                        interfaceC10738v.AD8(c10708r);
                    }
                });
            }
            anonymousClass48.A04();
            synchronized (A10) {
                A0w--;
                if (A0w == 0) {
                    A0x.shutdown();
                    A0x = null;
                }
                throw th;
            }
        }
    }

    private void A0b(C2704px c2704px) {
        if (A0h()) {
            try {
                this.A0D.setPlaybackParams(new PlaybackParams().allowDefaults().setSpeed(c2704px.A01).setPitch(c2704px.A00).setAudioFallbackMode(2));
            } catch (IllegalArgumentException e) {
                AbstractC09574g.A0A(A0L(7, 16, 23), A0L(56, 29, 89), e);
            }
            PlaybackParams playbackParams = this.A0D.getPlaybackParams();
            float speed = playbackParams.getSpeed();
            PlaybackParams playbackParams2 = this.A0D.getPlaybackParams();
            c2704px = new C2704px(speed, playbackParams2.getPitch());
            this.A0k.A0G(c2704px.A01);
        }
        this.A0G = c2704px;
    }

    private void A0c(C2704px c2704px, boolean z) {
        C9J c9jA0K = A0K();
        if (!c2704px.equals(c9jA0K.A02) || z != c9jA0K.A03) {
            C9J mediaPositionParameters = new C9J(c2704px, z, C.TIME_UNSET, C.TIME_UNSET);
            if (A0h()) {
                this.A0M = mediaPositionParameters;
            } else {
                this.A0N = mediaPositionParameters;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00ea  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0e(java.nio.ByteBuffer r13, long r14) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 346
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C2606oM.A0e(java.nio.ByteBuffer, long):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0078, code lost:
    
        if (r8.A0R != null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x007a, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0084, code lost:
    
        if (r8.A0R != null) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean A0f() throws java.lang.Exception {
        /*
            r8 = this;
            r7 = 0
            int r0 = r8.A03
            r4 = 0
            r3 = -1
            if (r0 != r3) goto La
            r8.A03 = r4
            r7 = 1
        La:
            int r5 = r8.A03
            com.facebook.ads.redexgen.X.3k[] r0 = r8.A0d
            int r0 = r0.length
            r1 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r6 = 1
            if (r5 >= r0) goto L59
            com.facebook.ads.redexgen.X.3k[] r5 = r8.A0d
            int r0 = r8.A03
            r0 = r5[r0]
            if (r7 == 0) goto L22
            r0.AHG()
        L22:
            r8.A0V(r1)
            boolean r5 = r0.AAP()
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C2606oM.A0z
            r0 = 0
            r1 = r2[r0]
            r0 = 3
            r2 = r2[r0]
            r0 = 31
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto L53
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C2606oM.A0z
            java.lang.String r1 = "SZlzkFrjT9RrDQln4ds2mG9At4QQTsjU"
            r0 = 0
            r2[r0] = r1
            java.lang.String r1 = "7YjBVNvSPjH845plY2W9SI0PPB4m8Pgz"
            r0 = 3
            r2[r0] = r1
            if (r5 != 0) goto L4c
            return r4
        L4c:
            r7 = 1
            int r0 = r8.A03
            int r0 = r0 + r6
            r8.A03 = r0
            goto La
        L53:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L59:
            java.nio.ByteBuffer r0 = r8.A0R
            if (r0 == 0) goto L87
            java.nio.ByteBuffer r0 = r8.A0R
            r8.A0e(r0, r1)
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C2606oM.A0z
            r0 = 2
            r1 = r2[r0]
            r0 = 6
            r2 = r2[r0]
            r0 = 24
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto L7b
            java.nio.ByteBuffer r0 = r8.A0R
            if (r0 == 0) goto L87
        L7a:
            return r4
        L7b:
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C2606oM.A0z
            java.lang.String r1 = "ih"
            r0 = 1
            r2[r0] = r1
            java.nio.ByteBuffer r0 = r8.A0R
            if (r0 == 0) goto L87
            goto L7a
        L87:
            r8.A03 = r3
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C2606oM.A0f():boolean");
    }

    @MetaExoPlayerCustomization(type = {"MERGED"}, value = "D45157249: Retry Audio Track Init failure with less Audio track allocation sizes; Upstream has this feature")
    private boolean A0g() throws C10728t {
        if (!this.A0h.A03()) {
            return false;
        }
        this.A0D = this.A0S ? A0F() : A0G(this.A0K);
        String[] strArr = A0z;
        if (strArr[2].charAt(24) != strArr[6].charAt(24)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0z;
        strArr2[2] = "dWhjJD4ryPYmrGCHimoCOlqhHDAwt6Vc";
        strArr2[6] = "fifoJCnFOIc3PbrGHGLYECSFH4AKcCFA";
        if (A0l(this.A0D)) {
            A0W(this.A0D);
            if (this.A0f != 3) {
                this.A0D.setOffloadDelayPadding(this.A0K.A07.A08, this.A0K.A07.A09);
            }
        }
        if (C5C.A02 >= 31 && this.A0H != null) {
            C9D.A00(this.A0D, this.A0H);
        }
        this.A01 = this.A0D.getAudioSessionId();
        this.A0k.A0I(this.A0D, this.A0K.A04 == 2, this.A0K.A03, this.A0K.A05, this.A0K.A00);
        A0R();
        if (this.A0F.A01 != 0) {
            this.A0D.attachAuxEffect(this.A0F.A01);
            AudioTrack audioTrack = this.A0D;
            AnonymousClass21 anonymousClass21 = this.A0F;
            if (A0z[7].length() != 32) {
                audioTrack.setAuxEffectSendLevel(anonymousClass21.A00);
            } else {
                A0z[7] = "RIRRfrrRSIs4t73WNQ17weV6jTByi7uZ";
                audioTrack.setAuxEffectSendLevel(anonymousClass21.A00);
            }
        }
        if (this.A0J != null && C5C.A02 >= 23) {
            C9C.A00(this.A0D, this.A0J);
        }
        this.A0Y = true;
        if (this.A0I != null) {
            this.A0I.AD7(this.A0K.A0B());
        }
        return true;
    }

    private boolean A0h() {
        return this.A0D != null;
    }

    private boolean A0i() {
        if (!this.A0b) {
            if (A0L(271, 9, 70).equals(this.A0K.A07.A0W) && !A0j(this.A0K.A07.A0C)) {
                return true;
            }
        }
        return false;
    }

    private boolean A0j(int i) {
        return this.A0s && C5C.A14(i);
    }

    public static boolean A0k(int i) {
        return (C5C.A02 >= 24 && i == -6) || i == -32;
    }

    public static boolean A0l(AudioTrack audioTrack) {
        return C5C.A02 >= 29 && audioTrack.isOffloadedPlayback();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean A0m(com.facebook.ads.redexgen.core.C2725qI r5, com.facebook.ads.redexgen.core.C2731qQ r6) {
        /*
            r4 = this;
            int r1 = com.facebook.ads.redexgen.core.C5C.A02
            r0 = 29
            r3 = 0
            if (r1 < r0) goto Lb
            int r0 = r4.A0f
            if (r0 != 0) goto Lc
        Lb:
            return r3
        Lc:
            java.lang.String r0 = r5.A0W
            java.lang.Object r1 = com.facebook.ads.redexgen.core.AbstractC09493y.A01(r0)
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r0 = r5.A0R
            int r2 = com.facebook.ads.redexgen.core.C3J.A03(r1, r0)
            if (r2 != 0) goto L1d
            return r3
        L1d:
            int r0 = r5.A06
            int r1 = com.facebook.ads.redexgen.core.C5C.A01(r0)
            if (r1 != 0) goto L26
            return r3
        L26:
            int r0 = r5.A0G
            android.media.AudioFormat r1 = A0D(r0, r1, r2)
            com.facebook.ads.redexgen.X.1z r0 = r6.A01()
            android.media.AudioAttributes r0 = r0.A00
            int r0 = r4.A03(r1, r0)
            r2 = 1
            switch(r0) {
                case 0: goto L59;
                case 1: goto L41;
                case 2: goto L40;
                default: goto L3a;
            }
        L3a:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>()
            throw r0
        L40:
            return r2
        L41:
            int r0 = r5.A08
            if (r0 != 0) goto L49
            int r0 = r5.A09
            if (r0 == 0) goto L57
        L49:
            r1 = 1
        L4a:
            int r0 = r4.A0f
            if (r0 != r2) goto L55
            r0 = 1
        L4f:
            if (r1 == 0) goto L53
            if (r0 != 0) goto L54
        L53:
            r3 = 1
        L54:
            return r3
        L55:
            r0 = 0
            goto L4f
        L57:
            r1 = 0
            goto L4a
        L59:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C2606oM.A0m(com.facebook.ads.redexgen.X.qI, com.facebook.ads.redexgen.X.qQ):boolean");
    }

    public final int A0o(C2725qI c2725qI) {
        if (!A0L(271, 9, 70).equals(c2725qI.A0W)) {
            return ((this.A0W || !A0m(c2725qI, this.A0E)) && !this.A0j.A0B(c2725qI)) ? 0 : 2;
        }
        if (!C5C.A15(c2725qI.A0C)) {
            AbstractC09574g.A07(A0L(7, 16, 23), A0L(85, 22, 8) + c2725qI.A0C);
            return 0;
        }
        int i = c2725qI.A0C;
        if (A0z[7].length() != 32) {
            throw new RuntimeException();
        }
        A0z[1] = "pL";
        return (i == 2 || (this.A0s && c2725qI.A0C == 4)) ? 2 : 1;
    }

    public final boolean A0p() {
        return A0K().A03;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC10768z
    public final void A59(C2725qI c2725qI, int i, int[] iArr) throws C10718s {
        int outputSampleRate;
        InterfaceC09353k[] interfaceC09353kArr;
        int outputSampleRate2;
        int outputPcmFrameSize;
        int outputChannelConfig;
        int iIntValue;
        int outputEncoding;
        int outputMode = i;
        int[] iArr2 = iArr;
        if (A0L(271, 9, 70).equals(c2725qI.A0W)) {
            AbstractC09493y.A07(C5C.A15(c2725qI.A0C));
            outputSampleRate = C5C.A06(c2725qI.A0C, c2725qI.A06);
            if (A0j(c2725qI.A0C)) {
                interfaceC09353kArr = this.A0t;
            } else {
                interfaceC09353kArr = this.A0u;
            }
            C9x c9x = this.A0p;
            int inputPcmFrameSize = c2725qI.A08;
            c9x.A0E(inputPcmFrameSize, c2725qI.A09);
            int inputPcmFrameSize2 = C5C.A02;
            if (inputPcmFrameSize2 < 21) {
                int inputPcmFrameSize3 = c2725qI.A06;
                if (inputPcmFrameSize3 == 8 && iArr2 == null) {
                    iArr2 = new int[6];
                    for (int inputPcmFrameSize4 = 0; inputPcmFrameSize4 < iArr2.length; inputPcmFrameSize4++) {
                        iArr2[inputPcmFrameSize4] = inputPcmFrameSize4;
                    }
                }
            }
            this.A0l.A0C(iArr2);
            int i2 = c2725qI.A0G;
            int inputPcmFrameSize5 = c2725qI.A06;
            C09333i c09333i = new C09333i(i2, inputPcmFrameSize5, c2725qI.A0C);
            for (InterfaceC09353k interfaceC09353k : interfaceC09353kArr) {
                try {
                    C09333i c09333iA57 = interfaceC09353k.A57(c09333i);
                    if (interfaceC09353k.AAL()) {
                        c09333i = c09333iA57;
                    }
                } catch (C09343j e) {
                    throw new C10718s(e, c2725qI);
                }
            }
            outputChannelConfig = 0;
            iIntValue = c09333i.A02;
            outputSampleRate2 = c09333i.A03;
            outputEncoding = C5C.A01(c09333i.A01);
            outputPcmFrameSize = C5C.A06(iIntValue, c09333i.A01);
        } else {
            outputSampleRate = -1;
            interfaceC09353kArr = new InterfaceC09353k[0];
            outputSampleRate2 = c2725qI.A0G;
            outputPcmFrameSize = -1;
            if (A0m(c2725qI, this.A0E)) {
                outputChannelConfig = 1;
                iIntValue = C3J.A03((String) AbstractC09493y.A01(c2725qI.A0W), c2725qI.A0R);
                outputEncoding = C5C.A01(c2725qI.A06);
            } else {
                outputChannelConfig = 2;
                if (A0z[1].length() == 2) {
                    A0z[5] = "lAbqtU1Up8pAGeHbeXVy9OX5EzAUCGx9";
                    Pair<Integer, Integer> pairA09 = this.A0j.A09(c2725qI);
                    if (pairA09 != null) {
                        iIntValue = ((Integer) pairA09.first).intValue();
                        outputEncoding = ((Integer) pairA09.second).intValue();
                        if (A0z[7].length() == 32) {
                            A0z[1] = "Lw";
                        }
                    } else {
                        throw new C10718s(A0L(ComposerKt.reuseKey, 37, 24) + c2725qI, c2725qI);
                    }
                }
                throw new RuntimeException();
            }
        }
        String strA0L = A0L(0, 7, 114);
        if (iIntValue != 0) {
            if (outputEncoding != 0) {
                if (outputMode == 0) {
                    C9F c9f = this.A0m;
                    int iA01 = A01(outputSampleRate2, outputEncoding, iIntValue);
                    int outputChannelConfig2 = outputPcmFrameSize != -1 ? outputPcmFrameSize : 1;
                    outputMode = c9f.A75(iA01, iIntValue, outputChannelConfig, outputChannelConfig2, outputSampleRate2, c2725qI.A05, this.A0r ? 8.0d : 1.0d);
                }
                this.A0W = false;
                C9H c9h = new C9H(c2725qI, outputSampleRate, outputChannelConfig, outputPcmFrameSize, outputSampleRate2, outputEncoding, iIntValue, outputMode, interfaceC09353kArr, this.A0b);
                if (A0h()) {
                    this.A0L = c9h;
                    return;
                } else {
                    this.A0K = c9h;
                    return;
                }
            }
            throw new C10718s(A0L(107, 36, 56) + outputChannelConfig + strA0L + c2725qI, c2725qI);
        }
        throw new C10718s(A0L(143, 30, 72) + outputChannelConfig + strA0L + c2725qI, c2725qI);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC10768z
    public final void A5z() {
        if (this.A0b) {
            this.A0b = false;
            flush();
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC10768z
    public final void A6M() {
        AbstractC09493y.A08(C5C.A02 >= 21);
        AbstractC09493y.A08(this.A0T);
        if (!this.A0b) {
            this.A0b = true;
            flush();
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC10768z
    public final void A6T() {
        if (C5C.A02 < 25) {
            flush();
            return;
        }
        this.A0o.A00();
        this.A0n.A00();
        if (!A0h()) {
            return;
        }
        A0Q();
        if (this.A0k.A0J()) {
            this.A0D.pause();
        }
        this.A0D.flush();
        this.A0k.A0E();
        this.A0k.A0I(this.A0D, this.A0K.A04 == 2, this.A0K.A03, this.A0K.A05, this.A0K.A00);
        this.A0Y = true;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC10768z
    public final long A7f(boolean z) {
        if (!A0h() || this.A0Y) {
            return Long.MIN_VALUE;
        }
        long jA0D = this.A0k.A0D(z);
        C9H c9h = this.A0K;
        long positionUs = A07();
        return A09(A08(Math.min(jA0D, c9h.A08(positionUs))));
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC10768z
    public final C2704px A8m() {
        if (this.A0r) {
            return this.A0G;
        }
        return A0I();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC10768z
    public final boolean A9e(ByteBuffer byteBuffer, final long adjustmentUs, int i) throws Exception {
        AbstractC09493y.A07(this.A0Q == null || byteBuffer == this.A0Q);
        if (this.A0L != null) {
            if (!A0f()) {
                return false;
            }
            if (this.A0L.A0E(this.A0K)) {
                this.A0K = this.A0L;
                this.A0L = null;
                if (A0l(this.A0D) && this.A0f != 3) {
                    if (this.A0D.getPlayState() == 3) {
                        this.A0D.setOffloadEndOfStream();
                    }
                    AudioTrack audioTrack = this.A0D;
                    int i2 = this.A0K.A07.A08;
                    String[] strArr = A0z;
                    if (strArr[0].charAt(31) != strArr[3].charAt(31)) {
                        String[] strArr2 = A0z;
                        strArr2[0] = "jzTmuhmcT6oYK5lhq8C6QOSyUXF7wdwQ";
                        strArr2[3] = "cWMrj79Gd0zdSeVIzQJ8siz7G3nSjdgD";
                        audioTrack.setOffloadDelayPadding(i2, this.A0K.A07.A09);
                        this.A0V = true;
                    } else {
                        throw new RuntimeException();
                    }
                }
            } else {
                A0P();
                if (A9o()) {
                    return false;
                }
                flush();
            }
            A0U(adjustmentUs);
        }
        if (!A0h()) {
            try {
                if (!A0g()) {
                    return false;
                }
            } catch (C10728t e) {
                if (!e.A02) {
                    this.A0n.A01(e);
                    return false;
                }
                throw e;
            }
        }
        this.A0n.A00();
        if (this.A0Y) {
            this.A08 = Math.max(0L, adjustmentUs);
            this.A0Z = false;
            this.A0Y = false;
            if (this.A0r && C5C.A02 >= 23) {
                A0b(this.A0G);
            }
            A0U(adjustmentUs);
            if (this.A0X) {
                AH0();
            }
        }
        if (!this.A0k.A0N(A07())) {
            return false;
        }
        if (this.A0Q == null) {
            AbstractC09493y.A07(byteBuffer.order() == ByteOrder.LITTLE_ENDIAN);
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            if (this.A0K.A04 != 0 && this.A04 == 0) {
                this.A04 = A02(this.A0K.A03, byteBuffer);
                if (this.A04 == 0) {
                    return true;
                }
            }
            if (this.A0M != null) {
                if (!A0f()) {
                    return false;
                }
                A0U(adjustmentUs);
                this.A0M = null;
            }
            final long jA09 = this.A08 + this.A0K.A09(A06() - this.A0p.A0C());
            if (!this.A0Z && Math.abs(jA09 - adjustmentUs) > 200000) {
                if (this.A0I != null) {
                    this.A0I.AD6(new Exception(adjustmentUs, jA09) { // from class: com.facebook.ads.redexgen.X.8x
                        public static byte[] A02;
                        public final long A00;
                        public final long A01;

                        static {
                            A01();
                        }

                        public static String A00(int i3, int i4, int i5) {
                            byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i3, i3 + i4);
                            for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
                                bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 106);
                            }
                            return new String(bArrCopyOfRange);
                        }

                        public static void A01() {
                            A02 = new byte[]{-20, -32, 39, 47, 52, -32, Ascii.GS, 54, 45, SignedBytes.MAX_POWER_OF_TWO, 56, 45, 43, 60, 45, 44, -24, 41, Base64.padSymbol, 44, 49, 55, -24, 60, 58, 41, 43, 51, -24, 60, 49, 53, 45, 59, 60, 41, 53, 56, -24, 44, 49, 59, 43, 55, 54, 60, 49, 54, Base64.padSymbol, 49, 60, 65, 2, -24, 45, SignedBytes.MAX_POWER_OF_TWO, 56, 45, 43, 60, 45, 44, -24};
                        }

                        {
                            super(A00(6, 57, 94) + jA09 + A00(0, 6, 86) + adjustmentUs);
                            this.A00 = adjustmentUs;
                            this.A01 = jA09;
                        }
                    });
                }
                this.A0Z = true;
            }
            if (this.A0Z) {
                if (!A0f()) {
                    return false;
                }
                long j = adjustmentUs - jA09;
                this.A08 += j;
                this.A0Z = false;
                A0U(adjustmentUs);
                if (this.A0I != null && j != 0) {
                    this.A0I.AFO();
                }
            }
            if (this.A0K.A04 == 0) {
                this.A0A += (long) byteBuffer.remaining();
            } else {
                this.A09 += ((long) this.A04) * ((long) i);
            }
            this.A0Q = byteBuffer;
            this.A05 = i;
        }
        A0V(adjustmentUs);
        if (!this.A0Q.hasRemaining()) {
            this.A0Q = null;
            this.A05 = 0;
            return true;
        }
        if (this.A0k.A0M(A07())) {
            AbstractC09574g.A07(A0L(7, 16, 23), A0L(178, 29, 2));
            flush();
            return true;
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC10768z
    public final void A9h() {
        this.A0Z = true;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC10768z
    public final boolean A9o() {
        return A0h() && this.A0k.A0L(A07());
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC10768z
    public final boolean AAP() {
        return !A0h() || (this.A0U && !A9o());
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC10768z
    public final void AH0() {
        this.A0X = true;
        if (A0h()) {
            this.A0k.A0F();
            this.A0D.play();
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC10768z
    public final void AH2() throws C10758y {
        if (!this.A0U && A0h() && A0f()) {
            A0P();
            this.A0U = true;
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC10768z
    public final void AJG(C2731qQ c2731qQ) {
        if (this.A0E.equals(c2731qQ)) {
            return;
        }
        this.A0E = c2731qQ;
        if (this.A0b) {
            return;
        }
        flush();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC10768z
    public final void AJH(int i) {
        if (this.A01 != i) {
            this.A01 = i;
            this.A0T = i != 0;
            flush();
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC10768z
    public final void AJI(AnonymousClass21 anonymousClass21) {
        if (this.A0F.equals(anonymousClass21)) {
            return;
        }
        int i = anonymousClass21.A01;
        float f = anonymousClass21.A00;
        if (this.A0D != null) {
            int effectId = this.A0F.A01;
            if (effectId != i) {
                AudioTrack audioTrack = this.A0D;
                if (A0z[7].length() != 32) {
                    throw new RuntimeException();
                }
                String[] strArr = A0z;
                strArr[0] = "ejzMDVkCKjmiTtIYDMlHFxA2dL6L7Th4";
                strArr[3] = "3op87oKeQBz5MvPCbX5N1e1cWqib6LOP";
                audioTrack.attachAuxEffect(i);
            }
            if (i != 0) {
                this.A0D.setAuxEffectSendLevel(f);
            }
        }
        this.A0F = anonymousClass21;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC10768z
    @MetaExoPlayerCustomization(type = {"NEW_METHOD"}, value = "D45157249: Retry Audio Track Init failure with less Audio track allocation sizes")
    public final void AJQ(boolean z) {
        this.A0S = z;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC10768z
    public final void AJV(InterfaceC10738v interfaceC10738v) {
        this.A0I = interfaceC10738v;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC10768z
    public final void AJd(C2704px c2704px) {
        C2704px c2704px2 = new C2704px(C5C.A00(c2704px.A01, 0.1f, 8.0f), C5C.A00(c2704px.A00, 0.1f, 8.0f));
        if (this.A0r) {
            int i = C5C.A02;
            String[] strArr = A0z;
            if (strArr[2].charAt(24) != strArr[6].charAt(24)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0z;
            strArr2[0] = "mNkMATimN2JlCwGmoqKrFKrIOPJhoNaC";
            strArr2[3] = "5L3Fdp27ixuu2nNAlcGmWXwucnCjA2b5";
            if (i >= 23) {
                A0b(c2704px2);
                return;
            }
        }
        A0c(c2704px2, A0p());
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC10768z
    public final void AJg(C8O c8o) {
        this.A0H = c8o;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC10768z
    public final void AJi(AudioDeviceInfo audioDeviceInfo) {
        this.A0J = audioDeviceInfo == null ? null : new C9E(audioDeviceInfo);
        String[] strArr = A0z;
        if (strArr[2].charAt(24) != strArr[6].charAt(24)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0z;
        strArr2[0] = "fdceU7wc4F7eltehFDuXboaWNHZsjBbo";
        strArr2[3] = "ndF9ePFUZlaV1XmuWN8y5PTJytJgMa2t";
        if (this.A0D != null) {
            C9C.A00(this.A0D, this.A0J);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC10768z
    public final void AJo(boolean z) {
        A0c(A0I(), z);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC10768z
    public final boolean AKN(C2725qI c2725qI) {
        return A0o(c2725qI) != 0;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC10768z
    @MetaExoPlayerCustomization(type = {"TEMPORARY"}, value = "Old API that can be removed when we move to MediaCodecRenderer2")
    public final boolean AKP(int i, int i2) {
        return C5C.A15(i2) ? i2 != 4 || C5C.A02 >= 21 : this.A0j != null && this.A0j.A0A(i2) && (i == -1 || i <= this.A0j.A08());
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC10768z
    public final void flush() {
        if (A0h()) {
            A0Q();
            if (this.A0k.A0J()) {
                this.A0D.pause();
            }
            boolean zA0l = A0l(this.A0D);
            if (A0z[4].length() == 6) {
                throw new RuntimeException();
            }
            A0z[5] = "i9Rinuw5ztOihCbMK36CN4CjOXT3DfRT";
            if (zA0l) {
                C9P c9p = this.A0O;
                if (A0z[7].length() != 32) {
                    throw new RuntimeException();
                }
                A0z[7] = "H3Tn5qbfAuT8Q6Ln8VWJEFxZf5lTeqqt";
                ((C9P) AbstractC09493y.A01(c9p)).A01(this.A0D);
            }
            if (C5C.A02 < 21 && !this.A0T) {
                this.A01 = 0;
            }
            C10708r c10708rA0B = this.A0K.A0B();
            if (this.A0L != null) {
                this.A0K = this.A0L;
                this.A0L = null;
            }
            this.A0k.A0E();
            A0Z(this.A0D, this.A0h, this.A0I, c10708rA0B);
            this.A0D = null;
        }
        this.A0o.A00();
        this.A0n.A00();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC10768z
    public final void pause() {
        this.A0X = false;
        if (A0h() && this.A0k.A0K()) {
            this.A0D.pause();
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC10768z
    public final void setVolume(float f) {
        if (this.A00 != f) {
            this.A00 = f;
            String[] strArr = A0z;
            if (strArr[0].charAt(31) == strArr[3].charAt(31)) {
                throw new RuntimeException();
            }
            A0z[5] = "E1Te023wTVVNappUuQixsG3bphOCE2I8";
            A0R();
        }
    }
}
