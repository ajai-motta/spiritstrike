package com.tnkfactory.ad;

import android.content.Context;

/* JADX INFO: loaded from: classes6.dex */
public interface AdItem {
    void close();

    String getPlacementId();

    String getTransactionId();

    Object getValue(String str);

    boolean isEmpty();

    boolean isInvalidated();

    boolean isLoaded();

    void load();

    void setListener(AdListener adListener);

    void setValue(String str, Object obj);

    void show();

    void show(Context context);
}
