package com.adxcorp.ads.nativeads.position;

import com.adxcorp.ads.nativeads.position.NativeAdPosition;

/* JADX INFO: loaded from: classes2.dex */
public interface PositionInterface {

    public interface PositionListener {
        void onFailed();

        void onLoad(NativeAdPosition.ClientPosition clientPosition);
    }

    void loadPositions(String str, PositionListener positionListener);
}
