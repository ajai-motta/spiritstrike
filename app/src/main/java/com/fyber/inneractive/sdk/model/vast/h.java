package com.fyber.inneractive.sdk.model.vast;

import android.text.TextUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Integer f1164a;
    public Integer b;
    public String c;
    public l d;
    public String e;
    public String f;
    public String g;
    public com.fyber.inneractive.sdk.flow.vast.b i;
    public final ArrayList h = new ArrayList();
    public final ArrayList j = new ArrayList();

    public final boolean a() {
        return (TextUtils.isEmpty(this.f) && TextUtils.isEmpty(this.e) && this.d == null) ? false : true;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Companion:  w:");
        sb.append(this.f1164a);
        sb.append(" h:");
        sb.append(this.b);
        sb.append(" ctr:");
        sb.append(this.g);
        sb.append(" clt:");
        sb.append(this.h);
        if (!TextUtils.isEmpty(this.f)) {
            sb.append(" html:");
            sb.append(this.f);
        }
        if (this.d != null) {
            sb.append(" static:");
            sb.append(this.d.b);
            sb.append("creative:");
            sb.append(this.d.f1166a);
        }
        if (!TextUtils.isEmpty(this.e)) {
            sb.append(" iframe:");
            sb.append(this.e);
        }
        sb.append(" events:");
        sb.append(this.j);
        if (this.i != null) {
            sb.append(" reason:");
            sb.append(this.i.f1121a);
            sb.append(" exception:");
            sb.append(this.i.getMessage());
        }
        return sb.toString();
    }
}
