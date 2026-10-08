package com.google.ads.mediation.unity;

import android.app.Activity;
import com.unity3d.ads.IUnityAdsLoadListener;
import com.unity3d.ads.IUnityAdsShowListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.UnityAdsLoadOptions;
import com.unity3d.ads.UnityAdsShowOptions;

/* JADX INFO: loaded from: classes8.dex */
class UnityAdsLoader {
    UnityAdsLoader() {
    }

    public void load(String str, UnityAdsLoadOptions unityAdsLoadOptions, IUnityAdsLoadListener iUnityAdsLoadListener) {
        UnityAds.load(str, unityAdsLoadOptions, iUnityAdsLoadListener);
    }

    public void show(Activity activity, String str, UnityAdsShowOptions unityAdsShowOptions, IUnityAdsShowListener iUnityAdsShowListener) {
        UnityAds.show(activity, str, unityAdsShowOptions, iUnityAdsShowListener);
    }

    public UnityAdsLoadOptions createUnityAdsLoadOptionsWithId(String str) {
        UnityAdsLoadOptions unityAdsLoadOptions = new UnityAdsLoadOptions();
        unityAdsLoadOptions.setObjectId(str);
        return unityAdsLoadOptions;
    }

    public UnityAdsShowOptions createUnityAdsShowOptionsWithId(String str) {
        UnityAdsShowOptions unityAdsShowOptions = new UnityAdsShowOptions();
        unityAdsShowOptions.setObjectId(str);
        return unityAdsShowOptions;
    }
}
