package com.unity3d.player;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.tasks.OnSuccessListener;

/* JADX INFO: renamed from: com.unity3d.player.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
final class C3197j implements OnSuccessListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IAssetPackManagerMobileDataConfirmationCallback f3316a;
    private Looper b = Looper.myLooper();

    public C3197j(IAssetPackManagerMobileDataConfirmationCallback iAssetPackManagerMobileDataConfirmationCallback) {
        this.f3316a = iAssetPackManagerMobileDataConfirmationCallback;
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final void onSuccess(Object obj) {
        Integer num = (Integer) obj;
        if (this.f3316a != null) {
            new Handler(this.b).post(new RunnableC3195i(this.f3316a, num.intValue() == -1));
        }
    }
}
