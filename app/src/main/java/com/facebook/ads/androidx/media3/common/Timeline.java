package com.facebook.ads.androidx.media3.common;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Pair;
import com.facebook.ads.androidx.media3.common.Timeline;
import com.facebook.ads.redexgen.core.AR;
import com.facebook.ads.redexgen.core.AS;
import com.facebook.ads.redexgen.core.AbstractC09493y;
import com.facebook.ads.redexgen.core.AnonymousClass22;
import com.facebook.ads.redexgen.core.AnonymousClass23;
import com.facebook.ads.redexgen.core.AnonymousClass24;
import com.facebook.ads.redexgen.core.AnonymousClass43;
import com.facebook.ads.redexgen.core.BP;
import com.facebook.ads.redexgen.core.C2690pj;
import com.facebook.ads.redexgen.core.C2692pl;
import com.facebook.ads.redexgen.core.C2K;
import com.facebook.ads.redexgen.core.C5C;
import com.google.android.exoplayer2.C;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class Timeline implements AnonymousClass24 {
    public static String[] A00 = {"u1TV1j0aFj13GJQ9ixTagHG8KyMgbnog", "4GMeFBxldVuonExwkIPaDDi9I59L728Z", "hqD1wOYcZTmehOTQOtlNc0UQ2KV4ETaI", "yejsGunEYiKaKfUzobCfCtheJf3zEEcL", "wYd9LRHFlTpJXE3VqmNr3ySXFdmyeGzN", "VCegaKN739XbWKUaP5Uwy30Zmvr6QTeK", "Cr3igiuAIuu", "x89DN52UD2fFRZn9rQXfWzGYhaiJYHE1"};
    public static final Timeline A02 = new AS();
    public static final String A05 = C5C.A0h(0);
    public static final String A03 = C5C.A0h(1);
    public static final String A04 = C5C.A0h(2);
    public static final AnonymousClass23<Timeline> A01 = new AnonymousClass23() { // from class: com.facebook.ads.redexgen.X.pq
        @Override // com.facebook.ads.redexgen.core.AnonymousClass23
        public final AnonymousClass24 A6f(Bundle bundle) {
            return Timeline.A02(bundle);
        }
    };

    public abstract int A06();

    public abstract int A07();

    public abstract int A0A(Object obj);

    public abstract C2692pl A0I(int i, C2692pl c2692pl, boolean z);

    public abstract C2690pj A0L(int i, C2690pj c2690pj, long j);

    public abstract Object A0M(int i);

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.BP != com.google.common.collect.ImmutableList<com.facebook.ads.androidx.media3.common.Timeline$Period> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.BP != com.google.common.collect.ImmutableList<com.facebook.ads.androidx.media3.common.Timeline$Window> */
    public static AR A02(Bundle bundle) {
        BP bpA04 = A04(C2690pj.A0J, AnonymousClass43.A00(bundle, A05));
        BP bpA042 = A04(C2692pl.A08, AnonymousClass43.A00(bundle, A03));
        int[] intArray = bundle.getIntArray(A04);
        if (intArray == null) {
            intArray = A05(bpA04.size());
        }
        return new AR(bpA04, bpA042, intArray);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.23 != com.facebook.ads.androidx.media3.common.Bundleable$Creator<T extends com.facebook.ads.redexgen.X.24> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2K != com.google.common.collect.ImmutableList$Builder<T extends com.facebook.ads.redexgen.X.24> */
    public static <T extends AnonymousClass24> BP<T> A04(AnonymousClass23<T> anonymousClass23, IBinder iBinder) {
        if (iBinder == null) {
            return BP.A03();
        }
        C2K c2k = new C2K();
        BP<Bundle> bpA00 = AnonymousClass22.A00(iBinder);
        for (int i = 0; i < bpA00.size(); i++) {
            c2k.A04(anonymousClass23.A6f(bpA00.get(i)));
        }
        return c2k.A05();
    }

    public static int[] A05(int i) {
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = i2;
            int i3 = A00[1].charAt(20);
            if (i3 == 50) {
                throw new RuntimeException();
            }
            String[] strArr = A00;
            strArr[2] = "bm1hpxiL8T70YPoy7qoC4X3DFFhRRvrI";
            strArr[4] = "ZU2doOYnXTdq2XyitRV5O0BVNSu1NLTL";
        }
        return iArr;
    }

    public int A08(int i, int i2, boolean z) {
        switch (i2) {
            case 0:
                if (i == A0C(z)) {
                    return -1;
                }
                return i + 1;
            case 1:
                return i;
            case 2:
                int iA0C = A0C(z);
                String[] strArr = A00;
                if (strArr[3].charAt(14) != strArr[5].charAt(14)) {
                    throw new RuntimeException();
                }
                A00[1] = "R0HEAX03GiDQUcMP0CiDD2yYG3qNGv8H";
                if (i == iA0C) {
                    return A0B(z);
                }
                return i + 1;
            default:
                throw new IllegalStateException();
        }
    }

    public final int A09(int i, C2692pl c2692pl, C2690pj c2690pj, int i2, boolean z) {
        int i3 = A0H(i, c2692pl).A00;
        int windowIndex = A0K(i3, c2690pj).A01;
        if (windowIndex == i) {
            int nextWindowIndex = A08(i3, i2, z);
            if (nextWindowIndex == -1) {
                return -1;
            }
            int windowIndex2 = A0K(nextWindowIndex, c2690pj).A00;
            return windowIndex2;
        }
        int windowIndex3 = i + 1;
        return windowIndex3;
    }

    public int A0B(boolean z) {
        return A0N() ? -1 : 0;
    }

    public int A0C(boolean z) {
        if (A0N()) {
            return -1;
        }
        return A07() - 1;
    }

    @Deprecated
    public final Pair<Object, Long> A0D(C2690pj c2690pj, C2692pl c2692pl, int i, long j) {
        return A0E(c2690pj, c2692pl, i, j);
    }

    public final Pair<Object, Long> A0E(C2690pj c2690pj, C2692pl c2692pl, int i, long j) {
        return (Pair) AbstractC09493y.A01(A0G(c2690pj, c2692pl, i, j, 0L));
    }

    @Deprecated
    public final Pair<Object, Long> A0F(C2690pj c2690pj, C2692pl c2692pl, int i, long j, long j2) {
        return A0G(c2690pj, c2692pl, i, j, j2);
    }

    public final Pair<Object, Long> A0G(C2690pj c2690pj, C2692pl c2692pl, int i, long j, long j2) {
        AbstractC09493y.A00(i, 0, A07());
        A0L(i, c2690pj, j2);
        if (j == C.TIME_UNSET) {
            j = c2690pj.A05();
            if (j == C.TIME_UNSET) {
                return null;
            }
        }
        int i2 = c2690pj.A00;
        A0H(i2, c2692pl);
        while (i2 < c2690pj.A01 && c2692pl.A02 != j && A0H(i2 + 1, c2692pl).A02 <= j) {
            i2++;
        }
        A0I(i2, c2692pl, true);
        long jMin = j - c2692pl.A02;
        if (c2692pl.A01 != C.TIME_UNSET) {
            long j3 = c2692pl.A01;
            if (A00[1].charAt(20) == '2') {
                throw new RuntimeException();
            }
            A00[1] = "slEcDLMOMSnRw8lzrIQwxe9jf9tcgTic";
            jMin = Math.min(jMin, j3 - 1);
        }
        return Pair.create(AbstractC09493y.A01(c2692pl.A04), Long.valueOf(Math.max(0L, jMin)));
    }

    public final C2692pl A0H(int i, C2692pl c2692pl) {
        return A0I(i, c2692pl, false);
    }

    public C2692pl A0J(Object obj, C2692pl c2692pl) {
        return A0I(A0A(obj), c2692pl, true);
    }

    public final C2690pj A0K(int i, C2690pj c2690pj) {
        return A0L(i, c2690pj, 0L);
    }

    public final boolean A0N() {
        return A07() == 0;
    }

    public final boolean A0O(int i, C2692pl c2692pl, C2690pj c2690pj, int i2, boolean z) {
        return A09(i, c2692pl, c2690pj, i2, z) == -1;
    }

    public final boolean equals(Object obj) {
        int iA0C;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Timeline)) {
            return false;
        }
        Timeline timeline = (Timeline) obj;
        if (timeline.A07() != A07() || timeline.A06() != A06()) {
            return false;
        }
        C2690pj c2690pj = new C2690pj();
        C2692pl c2692pl = new C2692pl();
        C2690pj window = new C2690pj();
        C2692pl otherPeriod = new C2692pl();
        for (int i = 0; i < A07(); i++) {
            if (!A0K(i, c2690pj).equals(timeline.A0K(i, window))) {
                return false;
            }
        }
        for (int i2 = 0; i2 < A06(); i2++) {
            boolean zEquals = A0I(i2, c2692pl, true).equals(timeline.A0I(i2, otherPeriod, true));
            if (A00[6].length() != 11) {
                throw new RuntimeException();
            }
            String[] strArr = A00;
            strArr[7] = "LCXdoHEXleHtD1UyLVprjOGqC7qnADXU";
            strArr[0] = "np8LEsRhRemsbbWWIjAQc1GjKbBRdfRS";
            if (!zEquals) {
                return false;
            }
        }
        int iA0B = A0B(true);
        if (iA0B != timeline.A0B(true) || (iA0C = A0C(true)) != timeline.A0C(true)) {
            return false;
        }
        while (iA0B != iA0C) {
            int iA08 = A08(iA0B, 0, true);
            if (iA08 != timeline.A08(iA0B, 0, true)) {
                return false;
            }
            iA0B = iA08;
        }
        return true;
    }

    public final int hashCode() {
        C2690pj c2690pj = new C2690pj();
        C2692pl c2692pl = new C2692pl();
        int result = 7 * 31;
        int i = result + A07();
        for (int i2 = 0; i2 < A07(); i2++) {
            C2690pj window = A0K(i2, c2690pj);
            i = (i * 31) + window.hashCode();
        }
        int result2 = i * 31;
        int i3 = result2 + A06();
        for (int i4 = 0; i4 < A06(); i4++) {
            i3 = (i3 * 31) + A0I(i4, c2692pl, true).hashCode();
        }
        int iA0B = A0B(true);
        while (iA0B != -1) {
            int windowIndex = i3 * 31;
            i3 = windowIndex + iA0B;
            iA0B = A08(iA0B, 0, true);
        }
        return i3;
    }
}
