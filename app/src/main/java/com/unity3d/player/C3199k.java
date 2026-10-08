package com.unity3d.player;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.assetpacks.AssetPackException;
import com.google.android.play.core.assetpacks.AssetPackState;
import com.google.android.play.core.assetpacks.AssetPackStates;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: renamed from: com.unity3d.player.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
final class C3199k implements OnCompleteListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IAssetPackManagerDownloadStatusCallback f3318a;
    private Looper b = Looper.myLooper();
    private String c;

    public C3199k(String str, IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback) {
        this.f3318a = iAssetPackManagerDownloadStatusCallback;
        this.c = str;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task task) {
        int errorCode;
        try {
            AssetPackStates assetPackStates = (AssetPackStates) task.getResult();
            Map mapPackStates = assetPackStates.packStates();
            if (mapPackStates.size() == 0) {
                return;
            }
            for (AssetPackState assetPackState : mapPackStates.values()) {
                if (assetPackState.errorCode() != 0 || assetPackState.status() == 4 || assetPackState.status() == 5 || assetPackState.status() == 0) {
                    String strName = assetPackState.name();
                    int iStatus = assetPackState.status();
                    int iErrorCode = assetPackState.errorCode();
                    long j = assetPackStates.totalBytes();
                    new Handler(this.b).post(new RunnableC3191g(Collections.singleton(this.f3318a), strName, iStatus, j, iStatus == 4 ? j : 0L, 0, iErrorCode));
                } else {
                    C3205n c3205n = C3205n.d;
                    String strName2 = assetPackState.name();
                    IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback = this.f3318a;
                    Looper looper = this.b;
                    c3205n.getClass();
                    synchronized (C3205n.d) {
                        Object obj = c3205n.c;
                        if (obj == null) {
                            C3193h c3193h = new C3193h(c3205n, iAssetPackManagerDownloadStatusCallback, looper);
                            c3205n.f3324a.registerListener(c3193h);
                            c3205n.c = c3193h;
                        } else {
                            ((C3193h) obj).a(iAssetPackManagerDownloadStatusCallback);
                        }
                        c3205n.b.add(strName2);
                        c3205n.f3324a.fetch(Collections.singletonList(strName2));
                    }
                }
            }
        } catch (RuntimeExecutionException e) {
            e = e;
            String str = this.c;
            while (true) {
                if (e instanceof AssetPackException) {
                    errorCode = e.getErrorCode();
                    break;
                }
                e = e.getCause();
                if (e == null) {
                    errorCode = -100;
                    break;
                }
            }
            new Handler(this.b).post(new RunnableC3191g(Collections.singleton(this.f3318a), str, 0, 0L, 0L, 0, errorCode));
        }
    }
}
