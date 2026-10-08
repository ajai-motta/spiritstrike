package android.adservices.common;

import java.lang.Throwable;

/* JADX INFO: loaded from: classes10.dex */
public interface AdServicesOutcomeReceiver<R, E extends Throwable> {

    /* JADX INFO: renamed from: android.adservices.common.AdServicesOutcomeReceiver$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onError(AdServicesOutcomeReceiver _this, Throwable error) {
        }
    }

    void onError(E error);

    void onResult(R result);
}
