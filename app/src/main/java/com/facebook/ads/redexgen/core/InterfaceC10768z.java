package com.facebook.ads.redexgen.core;

import android.media.AudioDeviceInfo;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.nio.ByteBuffer;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.8z, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public interface InterfaceC10768z {
    void A59(C2725qI c2725qI, int i, int[] iArr) throws C10718s;

    void A5z();

    void A6M();

    void A6T();

    long A7f(boolean z);

    C2704px A8m();

    boolean A9e(ByteBuffer byteBuffer, long j, int i) throws C10758y, C10728t;

    void A9h();

    boolean A9o();

    boolean AAP();

    void AH0();

    void AH2() throws C10758y;

    void AJG(C2731qQ c2731qQ);

    void AJH(int i);

    void AJI(AnonymousClass21 anonymousClass21);

    @MetaExoPlayerCustomization(type = {"NEW_METHOD"}, value = "Enable Retry Audio Track")
    void AJQ(boolean z);

    void AJV(InterfaceC10738v interfaceC10738v);

    void AJd(C2704px c2704px);

    void AJg(C8O c8o);

    void AJi(AudioDeviceInfo audioDeviceInfo);

    void AJo(boolean z);

    boolean AKN(C2725qI c2725qI);

    @MetaExoPlayerCustomization(type = {"TEMPORARY"}, value = "Old API that can be removed when we move to MediaCodecRenderer2")
    boolean AKP(int i, int i2);

    void flush();

    void pause();

    void setVolume(float f);
}
