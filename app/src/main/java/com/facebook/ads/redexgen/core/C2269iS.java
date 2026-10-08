package com.facebook.ads.redexgen.core;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.common.base.Ascii;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.iS, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/facebook/video/framebasedlogging/FrameBasedLogger;", "", "videoId", "", "<init>", "(Ljava/lang/String;)V", "getVideoId", "()Ljava/lang/String;", "videoFrameBuffer", "Ljava/util/concurrent/BlockingDeque;", "Lcom/facebook/video/framebasedlogging/VideoFrameInfo;", "getVideoFrameBuffer$annotations", "()V", "addVideoFrameToBuffer", "", TypedValues.AttributesType.S_FRAME, "videoFramesAndEmptyBuffer", "", "getVideoFramesAndEmptyBuffer", "()Ljava/util/List;", k.M, "fbandroid.java.com.facebook.video.framebasedlogging.framebasedlogging_an"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class C2269iS {
    public static byte[] A02;
    public static String[] A03 = {"nvoCYT5lXV50ozFrdUrQJCA6z0GvB", "", "jdLKha1Na7nbzs0Nk4YLOHAcdwecuvvy", "x", "dSWVRlyTiHf7svvh2WPzEDVR9b7sv5FM", "fWYFOffN0cZPNc3vcPN7ReiBLy1A48b", "e5JjNsryHusTZGAVeTKu2QwvoQvLupoE", "SBHDzKPIpiPnF71bMjezo2z0"};
    public static final C2268iR A04;
    public final String A00;
    public final BlockingDeque<C2270iT> A01 = new LinkedBlockingDeque();

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 86);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{Ascii.US, Ascii.VT, Ascii.CAN, Ascii.DC4, Ascii.FS};
    }

    static {
        A02();
        A04 = new C2268iR(null);
    }

    public C2269iS(String str) {
        this.A00 = str;
    }

    @JvmStatic
    public static final String A01(List<C2270iT> list) {
        return A04.A0A(list);
    }

    public final List<C2270iT> A03() {
        List frames = new ArrayList();
        this.A01.drainTo(frames);
        return frames;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A04(com.facebook.ads.redexgen.core.C2270iT r8) {
        /*
            r7 = this;
            r2 = 0
            r1 = 5
            r0 = 47
            java.lang.String r0 = A00(r2, r1, r0)
            com.facebook.ads.redexgen.core.C2739qY.A09(r8, r0)
            java.util.concurrent.BlockingDeque<com.facebook.ads.redexgen.X.iT> r0 = r7.A01
            java.lang.Object r4 = r0.peekLast()
            com.facebook.ads.redexgen.X.iT r4 = (com.facebook.ads.redexgen.core.C2270iT) r4
            if (r4 == 0) goto L4a
            long r5 = r4.getA03()
            long r0 = r8.getA03()
            int r3 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            java.lang.String[] r1 = com.facebook.ads.redexgen.core.C2269iS.A03
            r0 = 4
            r1 = r1[r0]
            r0 = 10
            char r1 = r1.charAt(r0)
            r0 = 102(0x66, float:1.43E-43)
            if (r1 == r0) goto L34
        L2e:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L34:
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C2269iS.A03
            java.lang.String r1 = ""
            r0 = 1
            r2[r0] = r1
            if (r3 != 0) goto L4a
            long r3 = r4.getA01()
            long r1 = r8.getA01()
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 != 0) goto L4a
            return
        L4a:
            java.util.concurrent.BlockingDeque<com.facebook.ads.redexgen.X.iT> r0 = r7.A01
            r0.add(r8)
            java.lang.String[] r1 = com.facebook.ads.redexgen.core.C2269iS.A03
            r0 = 4
            r1 = r1[r0]
            r0 = 10
            char r1 = r1.charAt(r0)
            r0 = 102(0x66, float:1.43E-43)
            if (r1 == r0) goto L5f
            goto L2e
        L5f:
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C2269iS.A03
            java.lang.String r1 = "kleFc3GTYdmSeGzzaJMmIvt997RVj"
            r0 = 0
            r2[r0] = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C2269iS.A04(com.facebook.ads.redexgen.X.iT):void");
    }
}
