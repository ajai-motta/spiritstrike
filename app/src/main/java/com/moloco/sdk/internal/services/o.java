package com.moloco.sdk.internal.services;

import android.content.Context;
import android.media.AudioManager;
import androidx.core.content.ContextCompat;
import com.moloco.sdk.internal.MolocoLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class o implements n {
    public static final int b = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AudioManager f2386a;

    public o(Context context) {
        AudioManager audioManager;
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            audioManager = (AudioManager) ContextCompat.getSystemService(context.getApplicationContext(), AudioManager.class);
        } catch (Exception e) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, p.f2387a, "couldn't get android.media.AudioManager service", e, false, 8, null);
            audioManager = null;
        }
        this.f2386a = audioManager;
    }

    @Override // com.moloco.sdk.internal.services.n
    public z a() {
        AudioManager audioManager = this.f2386a;
        Integer numValueOf = audioManager != null ? Integer.valueOf(audioManager.getRingerMode()) : null;
        return (numValueOf != null && numValueOf.intValue() == 0) ? z.f2402a : (numValueOf != null && numValueOf.intValue() == 1) ? z.b : (numValueOf != null && numValueOf.intValue() == 2) ? z.c : z.c;
    }

    @Override // com.moloco.sdk.internal.services.n
    public int b() {
        AudioManager audioManager = this.f2386a;
        if (audioManager != null) {
            return audioManager.getStreamVolume(3);
        }
        return 0;
    }

    @Override // com.moloco.sdk.internal.services.n
    public boolean c() {
        AudioManager audioManager = this.f2386a;
        if (audioManager == null) {
            return false;
        }
        return audioManager.isStreamMute(3);
    }
}
