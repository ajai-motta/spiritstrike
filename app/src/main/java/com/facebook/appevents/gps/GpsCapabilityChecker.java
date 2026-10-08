package com.facebook.appevents.gps;

import android.os.Build;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: compiled from: GpsCapabilityChecker.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/facebook/appevents/gps/GpsCapabilityChecker;", "", "()V", "useOutcomeReceiver", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class GpsCapabilityChecker {
    public static final GpsCapabilityChecker INSTANCE = new GpsCapabilityChecker();

    private GpsCapabilityChecker() {
    }

    @JvmStatic
    public static final boolean useOutcomeReceiver() {
        return Build.VERSION.SDK_INT >= 31;
    }
}
