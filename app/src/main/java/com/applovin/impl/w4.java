package com.applovin.impl;

import android.text.SpannedString;
import com.applovin.impl.r2;

/* JADX INFO: loaded from: classes2.dex */
public class w4 extends r2 {
    public w4(String str) {
        super(r2.c.SECTION);
        this.c = new SpannedString(str);
    }

    public String toString() {
        return "SectionListItemViewModel{text=" + ((Object) this.c) + "}";
    }
}
