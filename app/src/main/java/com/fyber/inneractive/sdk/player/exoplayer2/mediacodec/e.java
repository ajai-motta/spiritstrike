package com.fyber.inneractive.sdk.player.exoplayer2.mediacodec;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1397a;
    public final boolean b;

    public e(boolean z, String str) {
        this.f1397a = str;
        this.b = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != e.class) {
            return false;
        }
        e eVar = (e) obj;
        return TextUtils.equals(this.f1397a, eVar.f1397a) && this.b == eVar.b;
    }

    public final int hashCode() {
        String str = this.f1397a;
        return (((str == null ? 0 : str.hashCode()) + 31) * 31) + (this.b ? 1231 : 1237);
    }
}
