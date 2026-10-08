package com.facebook.ads.redexgen.core;

import com.facebook.ads.androidx.media3.common.Timeline;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.nR, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C2550nR implements InterfaceC1204Em {
    public static String[] A0B = {"ziZaTeBfSFNnIBcgtlZExnB4uOVj2q5B", "5IZt5NWgPCitKNTqtiA", "aLHVXVzU6ljMUMq9dZgrDfQ8JzHl8MF", "mvLcqO7QF6VGSUKAdCZC8bhhp8aLucng", "FQUZNhR4lN6thgMMBkcdaTgoY6ZzypcM", "72R8UBsha86AOqtb805OpiOBiH7oe8El", "AjNBccUrYW9zDFgtuo7TyJwkSvkBJU7y", "GkSBWsvGG5dBFRJxqtw9GV4lDtiTWOM"};
    public final float A00;
    public final float A01;
    public final int A02;
    public final int A03;
    public final int A04;
    public final int A05;
    public final int A06;
    public final long A07;
    public final AnonymousClass45 A08;

    @MetaExoPlayerCustomization("This is no longer set in the constructor")
    public final F6 A09;
    public final int A0A;

    public C2550nR() {
        this(10000, 25000, 25000, 0.75f);
    }

    public C2550nR(int i, int i2, int i3, float f) {
        this(null, -1, i, i2, i3, AdaptiveTrackSelection.DEFAULT_MAX_WIDTH_TO_DISCARD, AdaptiveTrackSelection.DEFAULT_MAX_HEIGHT_TO_DISCARD, f, 0.75f, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS, AnonymousClass45.A00);
    }

    public C2550nR(F6 f6) {
        this(f6, -1, 10000, 25000, 25000, AdaptiveTrackSelection.DEFAULT_MAX_WIDTH_TO_DISCARD, AdaptiveTrackSelection.DEFAULT_MAX_HEIGHT_TO_DISCARD, 0.75f, 0.75f, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS, AnonymousClass45.A00);
    }

    public C2550nR(@MetaExoPlayerCustomization("No longer set through factory") F6 f6, @MetaExoPlayerCustomization("Non standard variable; used in oculus") int i, @MetaExoPlayerCustomization("Removed from upstream") int i2, int i3, int i4, int i5, int i6, float f, float f2, long j, AnonymousClass45 anonymousClass45) {
        this.A09 = f6;
        this.A0A = i;
        this.A05 = i2;
        this.A02 = i3;
        this.A06 = i4;
        this.A04 = i5;
        this.A03 = i6;
        this.A00 = f;
        this.A01 = f2;
        this.A07 = j;
        this.A08 = anonymousClass45;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.BP != com.google.common.collect.ImmutableList<com.facebook.ads.androidx.media3.exoplayer.trackselection.AdaptiveTrackSelection$AdaptationCheckpoint> */
    private final C08771a A00(C2688pg c2688pg, int[] iArr, int i, F6 f6, BP<EU> bp) {
        return new C08771a(c2688pg, iArr, i, f6, this.A0A, this.A05, this.A02, this.A06, this.A04, this.A03, this.A00, this.A01, this.A07, bp, this.A08);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.BP != com.google.common.collect.ImmutableList<com.google.common.collect.ImmutableList<com.facebook.ads.androidx.media3.exoplayer.trackselection.AdaptiveTrackSelection$AdaptationCheckpoint>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.ads.redexgen.core.InterfaceC1204Em
    public final InterfaceC2537nE[] A5b(C1203El[] c1203ElArr, F6 f6, C2573no c2573no, Timeline timeline) {
        InterfaceC2537nE interfaceC2537nEA00;
        BP bpA00 = C08771a.A00(c1203ElArr);
        InterfaceC2537nE[] interfaceC2537nEArr = new InterfaceC2537nE[c1203ElArr.length];
        for (int i = 0; i < c1203ElArr.length; i++) {
            C1203El c1203El = c1203ElArr[i];
            if (c1203El != null && c1203El.A02.length != 0) {
                int length = c1203El.A02.length;
                if (A0B[3].length() != 32) {
                    throw new RuntimeException();
                }
                A0B[1] = "4JDRhnBkti3";
                if (length == 1) {
                    interfaceC2537nEA00 = new C1Z(c1203El.A01, c1203El.A02[0], c1203El.A00);
                } else {
                    interfaceC2537nEA00 = A00(c1203El.A01, c1203El.A02, c1203El.A00, f6, (BP) bpA00.get(i));
                }
                interfaceC2537nEArr[i] = interfaceC2537nEA00;
            }
        }
        return interfaceC2537nEArr;
    }
}
