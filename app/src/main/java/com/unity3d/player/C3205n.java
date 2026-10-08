package com.unity3d.player;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import com.google.android.play.core.assetpacks.AssetPackLocation;
import com.google.android.play.core.assetpacks.AssetPackManager;
import com.google.android.play.core.assetpacks.AssetPackManagerFactory;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

/* JADX INFO: renamed from: com.unity3d.player.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
final class C3205n {
    private static C3205n d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AssetPackManager f3324a;
    private HashSet b;
    private Object c;

    private C3205n(Context context) {
        if (d != null) {
            throw new RuntimeException("AssetPackManagerWrapper should be created only once. Use getInstance() instead.");
        }
        this.f3324a = AssetPackManagerFactory.getInstance(context);
        this.b = new HashSet();
    }

    public static C3205n a(Context context) {
        if (d == null) {
            d = new C3205n(context);
        }
        return d;
    }

    public final Object a(IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback) {
        C3193h c3193h = new C3193h(this, iAssetPackManagerDownloadStatusCallback, Looper.myLooper());
        this.f3324a.registerListener(c3193h);
        return c3193h;
    }

    public final String a(String str) {
        AssetPackLocation packLocation = this.f3324a.getPackLocation(str);
        return packLocation == null ? "" : packLocation.assetsPath();
    }

    public final void a(Activity activity, IAssetPackManagerMobileDataConfirmationCallback iAssetPackManagerMobileDataConfirmationCallback) {
        this.f3324a.showCellularDataConfirmation(activity).addOnSuccessListener(new C3197j(iAssetPackManagerMobileDataConfirmationCallback));
    }

    public final void a(Object obj) {
        if (obj instanceof C3193h) {
            this.f3324a.unregisterListener((C3193h) obj);
        }
    }

    public final void a(String[] strArr) {
        this.f3324a.cancel(Arrays.asList(strArr));
    }

    public final void a(String[] strArr, IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback) {
        for (String str : strArr) {
            this.f3324a.getPackStates(Collections.singletonList(str)).addOnCompleteListener(new C3199k(str, iAssetPackManagerDownloadStatusCallback));
        }
    }

    public final void a(String[] strArr, IAssetPackManagerStatusQueryCallback iAssetPackManagerStatusQueryCallback) {
        this.f3324a.getPackStates(Arrays.asList(strArr)).addOnCompleteListener(new C3203m(strArr, iAssetPackManagerStatusQueryCallback));
    }

    public final void b(String str) {
        this.f3324a.removePack(str);
    }
}
