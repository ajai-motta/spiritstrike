package com.fyber.inneractive.sdk.model.vast;

import com.fyber.inneractive.sdk.util.IAlog;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1161a;
    public final String b;
    public int c;
    public final int d;

    /* JADX WARN: Removed duplicated region for block: B:22:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x009a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public e(java.lang.String r7, java.lang.String r8) {
        /*
            Method dump skipped, instruction units count: 220
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.model.vast.e.<init>(java.lang.String, java.lang.String):void");
    }

    public static ArrayList a(String str) {
        ArrayList arrayList = new ArrayList();
        if (str == null) {
            return arrayList;
        }
        String[] strArrSplit = str.split(":");
        if (strArrSplit.length != 3) {
            return arrayList;
        }
        String str2 = strArrSplit[0];
        String str3 = strArrSplit[1];
        String[] strArrSplit2 = strArrSplit[2].split("\\.");
        String str4 = strArrSplit2[0];
        String str5 = strArrSplit2.length > 1 ? strArrSplit2[1] : "000";
        try {
            arrayList.add(Integer.valueOf(Integer.parseInt(str2)));
            arrayList.add(Integer.valueOf(Integer.parseInt(str3)));
            arrayList.add(Integer.valueOf(Integer.parseInt(str4)));
            arrayList.add(Integer.valueOf(Integer.parseInt(str5)));
            return arrayList;
        } catch (NumberFormatException e) {
            IAlog.f("ProgressTrackingEvent: failed convertOffsetToTimeList with %s", e.getMessage());
            return new ArrayList();
        }
    }
}
