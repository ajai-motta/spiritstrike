package com.unity3d.player;

import android.os.Handler;
import android.os.Looper;
import com.google.android.play.core.assetpacks.AssetPackState;
import com.google.android.play.core.assetpacks.AssetPackStateUpdateListener;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: renamed from: com.unity3d.player.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
final class C3193h implements AssetPackStateUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HashSet f3311a;
    private Looper b;
    final /* synthetic */ C3205n c;

    public C3193h(C3205n c3205n, IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback, Looper looper) {
        this.c = c3205n;
        HashSet hashSet = new HashSet();
        this.f3311a = hashSet;
        hashSet.add(iAssetPackManagerDownloadStatusCallback);
        this.b = looper;
    }

    public final synchronized void a(IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback) {
        this.f3311a.add(iAssetPackManagerDownloadStatusCallback);
    }

    public final void onStateUpdate(Object obj) {
        AssetPackState assetPackState = (AssetPackState) obj;
        synchronized (this) {
            if (assetPackState.status() == 4 || assetPackState.status() == 5 || assetPackState.status() == 0) {
                synchronized (C3205n.d) {
                    this.c.b.remove(assetPackState.name());
                    if (this.c.b.isEmpty()) {
                        C3205n c3205n = this.c;
                        c3205n.a(c3205n.c);
                        this.c.c = null;
                    }
                }
            }
            if (this.f3311a.size() == 0) {
                return;
            }
            new Handler(this.b).post(new RunnableC3191g((Set) this.f3311a.clone(), assetPackState.name(), assetPackState.status(), assetPackState.totalBytesToDownload(), assetPackState.bytesDownloaded(), assetPackState.transferProgressPercentage(), assetPackState.errorCode()));
        }
    }
}
