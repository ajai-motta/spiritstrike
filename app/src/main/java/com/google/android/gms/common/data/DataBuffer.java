package com.google.android.gms.common.data;

import android.os.Bundle;
import com.google.android.gms.common.api.Releasable;
import java.io.Closeable;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.10.0 */
/* JADX INFO: loaded from: classes9.dex */
public interface DataBuffer<T> extends Iterable<T>, Releasable, Closeable {

    /* JADX INFO: renamed from: com.google.android.gms.common.data.DataBuffer$-CC, reason: invalid class name */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.10.0 */
    public final /* synthetic */ class CC {
    }

    void close();

    T get(int i);

    int getCount();

    Bundle getMetadata();

    @Deprecated
    boolean isClosed();

    @Override // java.lang.Iterable
    Iterator<T> iterator();

    void release();

    Iterator<T> singleRefIterator();
}
