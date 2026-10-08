package com.bytedance.sdk.component.ud.qdl.ud;

import android.support.v4.media.session.PlaybackStateCompat;

/* JADX INFO: loaded from: classes3.dex */
final class mo {
    static mzz qdl;
    static long ud;

    private mo() {
    }

    static mzz qdl() {
        synchronized (mo.class) {
            mzz mzzVar = qdl;
            if (mzzVar != null) {
                qdl = mzzVar.mo;
                mzzVar.mo = null;
                ud -= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                return mzzVar;
            }
            return new mzz();
        }
    }

    static void qdl(mzz mzzVar) {
        if (mzzVar.mo != null || mzzVar.wd != null) {
            throw new IllegalArgumentException();
        }
        if (mzzVar.mml) {
            return;
        }
        synchronized (mo.class) {
            long j = ud;
            if (j + PlaybackStateCompat.ACTION_PLAY_FROM_URI > PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                return;
            }
            ud = j + PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            mzzVar.mo = qdl;
            mzzVar.lnr = 0;
            mzzVar.ud = 0;
            qdl = mzzVar;
        }
    }
}
