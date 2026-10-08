package com.fyber.inneractive.sdk.network;

import java.io.FilterInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1205a;
    public final String b;
    public InputStream c;
    public Map d;
    public String e;
    public final ArrayList f = new ArrayList();

    public l() {
    }

    public void a() {
        InputStream inputStream = this.c;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Throwable unused) {
            }
        }
    }

    public l(FilterInputStream filterInputStream, int i, String str, Map map, String str2) {
        this.c = filterInputStream;
        this.f1205a = i;
        this.b = str;
        this.d = map;
        this.e = str2;
    }
}
