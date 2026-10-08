package com.applovin.impl;

import android.view.View;
import com.iab.omid.library.applovin.adsession.FriendlyObstructionPurpose;

/* JADX INFO: loaded from: classes2.dex */
public class h4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f403a;
    private final FriendlyObstructionPurpose b;
    private final String c;

    public h4(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, String str) {
        this.f403a = view;
        this.b = friendlyObstructionPurpose;
        this.c = str;
    }

    public String a() {
        return this.c;
    }

    public FriendlyObstructionPurpose b() {
        return this.b;
    }

    public View c() {
        return this.f403a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        h4 h4Var = (h4) obj;
        View view = this.f403a;
        if (view == null ? h4Var.f403a != null : !view.equals(h4Var.f403a)) {
            return false;
        }
        if (this.b != h4Var.b) {
            return false;
        }
        String str = this.c;
        String str2 = h4Var.c;
        return str != null ? str.equals(str2) : str2 == null;
    }

    public int hashCode() {
        View view = this.f403a;
        int iHashCode = (view != null ? view.hashCode() : 0) * 31;
        FriendlyObstructionPurpose friendlyObstructionPurpose = this.b;
        int iHashCode2 = (iHashCode + (friendlyObstructionPurpose != null ? friendlyObstructionPurpose.hashCode() : 0)) * 31;
        String str = this.c;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }
}
