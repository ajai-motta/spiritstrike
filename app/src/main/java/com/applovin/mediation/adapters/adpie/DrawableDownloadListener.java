package com.applovin.mediation.adapters.adpie;

import android.graphics.drawable.Drawable;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public interface DrawableDownloadListener {
    void onDownloadFailure();

    void onDownloadSuccess(HashMap<String, Drawable> map);
}
