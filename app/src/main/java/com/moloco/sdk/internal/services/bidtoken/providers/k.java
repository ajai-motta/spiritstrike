package com.moloco.sdk.internal.services.bidtoken.providers;

import com.moloco.sdk.internal.services.AbstractC3002c;
import com.moloco.sdk.publisher.privacy.MolocoPrivacy;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class k {
    public static final int l = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f2318a;
    public final MolocoPrivacy.PrivacySettings b;
    public final r c;
    public final d d;
    public final t e;
    public final h f;
    public final AbstractC3002c g;
    public final n h;
    public final f i;
    public final a j;
    public final p k;

    public k(boolean z, MolocoPrivacy.PrivacySettings privacySettings, r memoryInfo, d appDirInfo, t networkInfoSignal, h batteryInfoSignal, AbstractC3002c adDataSignal, n deviceSignal, f audioSignal, a accessibilitySignal, p ilrdSignal) {
        Intrinsics.checkNotNullParameter(privacySettings, "privacySettings");
        Intrinsics.checkNotNullParameter(memoryInfo, "memoryInfo");
        Intrinsics.checkNotNullParameter(appDirInfo, "appDirInfo");
        Intrinsics.checkNotNullParameter(networkInfoSignal, "networkInfoSignal");
        Intrinsics.checkNotNullParameter(batteryInfoSignal, "batteryInfoSignal");
        Intrinsics.checkNotNullParameter(adDataSignal, "adDataSignal");
        Intrinsics.checkNotNullParameter(deviceSignal, "deviceSignal");
        Intrinsics.checkNotNullParameter(audioSignal, "audioSignal");
        Intrinsics.checkNotNullParameter(accessibilitySignal, "accessibilitySignal");
        Intrinsics.checkNotNullParameter(ilrdSignal, "ilrdSignal");
        this.f2318a = z;
        this.b = privacySettings;
        this.c = memoryInfo;
        this.d = appDirInfo;
        this.e = networkInfoSignal;
        this.f = batteryInfoSignal;
        this.g = adDataSignal;
        this.h = deviceSignal;
        this.i = audioSignal;
        this.j = accessibilitySignal;
        this.k = ilrdSignal;
    }

    public final boolean a() {
        return this.f2318a;
    }

    public final a b() {
        return this.j;
    }

    public final p c() {
        return this.k;
    }

    public final MolocoPrivacy.PrivacySettings d() {
        return this.b;
    }

    public final r e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return this.f2318a == kVar.f2318a && Intrinsics.areEqual(this.b, kVar.b) && Intrinsics.areEqual(this.c, kVar.c) && Intrinsics.areEqual(this.d, kVar.d) && Intrinsics.areEqual(this.e, kVar.e) && Intrinsics.areEqual(this.f, kVar.f) && Intrinsics.areEqual(this.g, kVar.g) && Intrinsics.areEqual(this.h, kVar.h) && Intrinsics.areEqual(this.i, kVar.i) && Intrinsics.areEqual(this.j, kVar.j) && Intrinsics.areEqual(this.k, kVar.k);
    }

    public final d f() {
        return this.d;
    }

    public final t g() {
        return this.e;
    }

    public final h h() {
        return this.f;
    }

    public int hashCode() {
        return (((((((((((((((((((UByte$$ExternalSyntheticBackport0.m(this.f2318a) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31) + this.j.hashCode()) * 31) + this.k.hashCode();
    }

    public final AbstractC3002c i() {
        return this.g;
    }

    public final n j() {
        return this.h;
    }

    public final f k() {
        return this.i;
    }

    public final a l() {
        return this.j;
    }

    public final AbstractC3002c m() {
        return this.g;
    }

    public final d n() {
        return this.d;
    }

    public final f o() {
        return this.i;
    }

    public final h p() {
        return this.f;
    }

    public final n q() {
        return this.h;
    }

    public final p r() {
        return this.k;
    }

    public final r s() {
        return this.c;
    }

    public final t t() {
        return this.e;
    }

    public String toString() {
        return "ClientSignals(sdkInitialized=" + this.f2318a + ", privacySettings=" + this.b + ", memoryInfo=" + this.c + ", appDirInfo=" + this.d + ", networkInfoSignal=" + this.e + ", batteryInfoSignal=" + this.f + ", adDataSignal=" + this.g + ", deviceSignal=" + this.h + ", audioSignal=" + this.i + ", accessibilitySignal=" + this.j + ", ilrdSignal=" + this.k + ')';
    }

    public final MolocoPrivacy.PrivacySettings u() {
        return this.b;
    }

    public final boolean v() {
        return this.f2318a;
    }

    public final k a(boolean z, MolocoPrivacy.PrivacySettings privacySettings, r memoryInfo, d appDirInfo, t networkInfoSignal, h batteryInfoSignal, AbstractC3002c adDataSignal, n deviceSignal, f audioSignal, a accessibilitySignal, p ilrdSignal) {
        Intrinsics.checkNotNullParameter(privacySettings, "privacySettings");
        Intrinsics.checkNotNullParameter(memoryInfo, "memoryInfo");
        Intrinsics.checkNotNullParameter(appDirInfo, "appDirInfo");
        Intrinsics.checkNotNullParameter(networkInfoSignal, "networkInfoSignal");
        Intrinsics.checkNotNullParameter(batteryInfoSignal, "batteryInfoSignal");
        Intrinsics.checkNotNullParameter(adDataSignal, "adDataSignal");
        Intrinsics.checkNotNullParameter(deviceSignal, "deviceSignal");
        Intrinsics.checkNotNullParameter(audioSignal, "audioSignal");
        Intrinsics.checkNotNullParameter(accessibilitySignal, "accessibilitySignal");
        Intrinsics.checkNotNullParameter(ilrdSignal, "ilrdSignal");
        return new k(z, privacySettings, memoryInfo, appDirInfo, networkInfoSignal, batteryInfoSignal, adDataSignal, deviceSignal, audioSignal, accessibilitySignal, ilrdSignal);
    }
}
