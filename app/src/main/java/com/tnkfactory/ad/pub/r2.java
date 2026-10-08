package com.tnkfactory.ad.pub;

import java.util.Locale;

/* JADX INFO: loaded from: classes6.dex */
public abstract class r2 {
    public static r2 i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f3186a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;

    public static r2 a() {
        if (i == null) {
            String language = Locale.getDefault().getLanguage();
            if ("ko,en".contains(language)) {
                i = "ko".equals(language) ? new q2() : "en".equals(language) ? new p2() : null;
            }
            if (i == null) {
                i = new p2();
            }
        }
        return i;
    }
}
