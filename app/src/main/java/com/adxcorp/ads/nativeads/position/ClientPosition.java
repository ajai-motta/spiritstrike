package com.adxcorp.ads.nativeads.position;

import android.os.Handler;
import android.os.Looper;
import com.adxcorp.ads.nativeads.position.NativeAdPosition;
import com.adxcorp.ads.nativeads.position.PositionInterface;

/* JADX INFO: loaded from: classes2.dex */
public class ClientPosition implements PositionInterface {
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final NativeAdPosition.ClientPosition mPositioning;

    public ClientPosition(NativeAdPosition.ClientPosition clientPosition) {
        this.mPositioning = NativeAdPosition.clone(clientPosition);
    }

    @Override // com.adxcorp.ads.nativeads.position.PositionInterface
    public void loadPositions(String str, final PositionInterface.PositionListener positionListener) {
        this.mHandler.post(new Runnable() { // from class: com.adxcorp.ads.nativeads.position.ClientPosition.1
            @Override // java.lang.Runnable
            public void run() {
                positionListener.onLoad(ClientPosition.this.mPositioning);
            }
        });
    }
}
