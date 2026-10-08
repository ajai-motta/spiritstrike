package com.fyber.inneractive.sdk.web;

import android.media.MediaScannerConnection;
import android.net.Uri;

/* JADX INFO: loaded from: classes3.dex */
public final class a0 implements MediaScannerConnection.MediaScannerConnectionClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1682a;
    public MediaScannerConnection b;

    public a0(String str) {
        this.f1682a = str;
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public final void onMediaScannerConnected() {
        MediaScannerConnection mediaScannerConnection = this.b;
        if (mediaScannerConnection != null) {
            mediaScannerConnection.scanFile(this.f1682a, null);
        }
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public final void onScanCompleted(String str, Uri uri) {
        MediaScannerConnection mediaScannerConnection = this.b;
        if (mediaScannerConnection != null) {
            mediaScannerConnection.disconnect();
        }
    }
}
