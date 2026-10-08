package com.moloco.sdk.internal.services.bidtoken;

import com.moloco.sdk.publisher.privacy.InternalMolocoPrivacySettings;
import com.moloco.sdk.publisher.privacy.MolocoPrivacy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class t implements u {
    public static final int b = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InternalMolocoPrivacySettings f2329a;

    public t(InternalMolocoPrivacySettings internalMolocoPrivacySettings) {
        Intrinsics.checkNotNullParameter(internalMolocoPrivacySettings, "internalMolocoPrivacySettings");
        this.f2329a = internalMolocoPrivacySettings;
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.u
    public MolocoPrivacy.PrivacySettings getPrivacy() {
        return this.f2329a.getUpdatedPrivacySettings(MolocoPrivacy.INSTANCE.getPrivacySettings());
    }
}
