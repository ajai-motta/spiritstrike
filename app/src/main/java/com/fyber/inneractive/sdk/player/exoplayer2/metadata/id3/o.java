package com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3;

import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public abstract class o implements Parcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1403a;

    public o(String str) {
        str.getClass();
        this.f1403a = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }
}
