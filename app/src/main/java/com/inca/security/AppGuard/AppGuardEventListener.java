package com.inca.security.AppGuard;

/* JADX INFO: compiled from: q */
/* JADX INFO: loaded from: classes.dex */
public interface AppGuardEventListener {
    void onDetected(int i, byte[] bArr);

    void onError(int i, byte[] bArr);

    void onEvent(int i, byte[] bArr);
}
