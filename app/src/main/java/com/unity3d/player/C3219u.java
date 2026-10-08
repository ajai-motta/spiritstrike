package com.unity3d.player;

import android.media.Image;
import android.media.ImageReader;

/* JADX INFO: renamed from: com.unity3d.player.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
final class C3219u implements ImageReader.OnImageAvailableListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ C3223w f3337a;

    C3219u(C3223w c3223w) {
        this.f3337a = c3223w;
    }

    @Override // android.media.ImageReader.OnImageAvailableListener
    public final void onImageAvailable(ImageReader imageReader) {
        if (C3223w.D.tryAcquire()) {
            Image imageAcquireNextImage = imageReader.acquireNextImage();
            if (imageAcquireNextImage != null) {
                Image.Plane[] planes = imageAcquireNextImage.getPlanes();
                if (imageAcquireNextImage.getFormat() == 35 && planes != null && planes.length == 3) {
                    ((Camera2Wrapper) this.f3337a.f3340a).a(planes[0].getBuffer(), planes[1].getBuffer(), planes[2].getBuffer(), planes[0].getRowStride(), planes[1].getRowStride(), planes[1].getPixelStride());
                } else {
                    AbstractC3229z.Log(6, "Camera2: Wrong image format.");
                }
                Image image = this.f3337a.p;
                if (image != null) {
                    image.close();
                }
                this.f3337a.p = imageAcquireNextImage;
            }
            C3223w.D.release();
        }
    }
}
