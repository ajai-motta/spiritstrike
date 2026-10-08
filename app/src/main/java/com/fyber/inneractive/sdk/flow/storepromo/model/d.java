package com.fyber.inneractive.sdk.flow.storepromo.model;

import com.fyber.inneractive.sdk.util.h;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1112a;
    public final String b;
    public final String c;

    public d(String str, String str2, String str3) {
        String str4;
        this.c = "";
        this.f1112a = str;
        this.b = str2;
        h hVar = new h(str3);
        if (hVar.f1653a == null) {
            str4 = "N/A";
        } else {
            double dLongValue = r11.longValue() / 1024.0d;
            double d = dLongValue / 1024.0d;
            double d2 = d / 1024.0d;
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            String str5 = decimalFormat.format(hVar.f1653a) + " bytes";
            if (d > 850.0d) {
                str4 = decimalFormat.format(d2) + " GB";
            } else if (dLongValue > 850.0d) {
                str4 = decimalFormat.format(d) + " MB";
            } else if (hVar.f1653a.longValue() > 850) {
                str4 = decimalFormat.format(dLongValue) + " kB";
            } else {
                str4 = str5;
            }
        }
        this.c = str4;
    }
}
