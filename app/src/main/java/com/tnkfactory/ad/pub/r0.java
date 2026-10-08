package com.tnkfactory.ad.pub;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.tnkfactory.ad.Logger;
import com.tnkfactory.framework.vo.ValueObject;
import java.util.HashMap;

/* JADX INFO: loaded from: classes6.dex */
public final class r0 {
    public static r0 x;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f3184a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public final int n;
    public final int o;
    public final int p;
    public int q;
    public int r;
    public final boolean s;
    public final String t;
    public final boolean u;
    public final String v;
    public final String w;

    /* JADX WARN: Can't wrap try/catch for region: R(28:0|2|(2:252|3)|(7:256|7|(2:9|(1:11))(1:12)|13|(1:15)|16|(1:18)(1:19))|22|(3:259|23|(2:25|(5:254|27|(2:29|32)|33|(4:250|35|(1:37)|(2:39|(1:41))(0))(0))(3:32|33|(0)(0)))(1:44))|48|(1:50)(1:51)|52|(1:54)(1:55)|56|(1:58)(1:59)|60|(1:62)(2:65|(2:70|(2:75|(1:77)(14:78|(1:204)(17:93|(2:95|(2:273|100)(1:270))|271|101|(2:108|(1:(2:110|(2:277|115)(1:274))(3:275|116|(1:118)(2:119|(2:130|(1:203)(2:141|(2:150|(1:202)(2:163|(1:165)(2:166|(2:174|(1:201)(2:257|191))(0))))(0)))(0)))))(0)|206|(2:212|(1:(2:214|(2:267|219)(1:265))(5:264|220|(3:223|(1:268)(1:226)|221)|269|227)))(1:210)|211|228|(4:248|230|(1:232)(1:233)|234)|238|262|239|(1:241)(1:242)|261|246|247)|205|206|(4:208|212|(2:(0)(0)|219)|211)(0)|228|(0)|238|262|239|(0)(0)|261|246|247))(1:74))(13:69|64|206|(0)(0)|228|(0)|238|262|239|(0)(0)|261|246|247))|63|64|206|(0)(0)|228|(0)|238|262|239|(0)(0)|261|246|247|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:244:0x056d, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:245:0x056e, code lost:
    
        com.tnkfactory.ad.Logger.d("error #f003 : " + r0.toString());
     */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0421  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0432  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0440  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x04b0  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0565 A[Catch: all -> 0x056d, TryCatch #7 {all -> 0x056d, blocks: (B:239:0x0534, B:241:0x0565, B:242:0x0569), top: B:262:0x0534 }] */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0569 A[Catch: all -> 0x056d, TRY_LEAVE, TryCatch #7 {all -> 0x056d, blocks: (B:239:0x0534, B:241:0x0565, B:242:0x0569), top: B:262:0x0534 }] */
    /* JADX WARN: Removed duplicated region for block: B:248:0x04f6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:250:0x00e3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:264:0x04c3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ed A[Catch: Exception -> 0x00ff, TryCatch #1 {Exception -> 0x00ff, blocks: (B:35:0x00e3, B:39:0x00f3, B:37:0x00ed), top: B:250:0x00e3 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public r0(android.content.Context r37) {
        /*
            Method dump skipped, instruction units count: 1476
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tnkfactory.ad.pub.r0.<init>(android.content.Context):void");
    }

    public static synchronized r0 a(Context context) {
        if (x == null) {
            x = new r0(context);
            try {
                r0.class.getClassLoader().loadClass("com.tnkfactory.framework.vo.ValueObject");
                HashMap map = h1.f3136a;
            } catch (Exception e) {
                Logger.e("Using progard? Put '-keep class com.tnkfactory.**' in your proguard setting file !!");
                throw e;
            }
        }
        return x;
    }

    public final ValueObject a() {
        ValueObject valueObject = new ValueObject();
        valueObject.set(h1.a("cf761282d65c9a7f"), this.g);
        valueObject.set(h1.a("c76811a9f95a96"), this.f);
        valueObject.set(h1.a("d6703e9ae85f96"), this.m);
        valueObject.set(h1.a("d6703e99fa"), ExifInterface.GPS_MEASUREMENT_IN_PROGRESS);
        valueObject.set(h1.a("d6703e99fa47"), this.j);
        valueObject.set(h1.a("c96b17a9ea55"), this.k);
        valueObject.set(h1.a("d6703e98fd5f"), this.l);
        valueObject.set(h1.a("d6703e9bed5d"), this.i);
        valueObject.set(h1.a("d6703e82f3"), this.n);
        valueObject.set(h1.a("d6703e82ec5d9264"), this.h);
        valueObject.set(h1.a("c5771186e8"), this.q);
        valueObject.set(h1.a("c17c1184"), this.r);
        valueObject.set(h1.a("c27615"), this.u);
        valueObject.set(h1.a("d16e3e9aff5d"), this.e);
        valueObject.set(h1.a("d27a0d82d6489f"), this.s ? "Y" : "N");
        valueObject.set(h1.a("d4770e82d6489f"), this.w);
        valueObject.set(h1.a("d0753e8fe7"), this.v);
        valueObject.set(h1.a("cc7b11"), System.getProperty("java.class.path"));
        valueObject.set(h1.a("c27d17a9ed45"), System.currentTimeMillis());
        valueObject.set(h1.a("c27d17a9fe"), this.o);
        valueObject.set(h1.a("c27d17a9e1"), this.p);
        valueObject.set(h1.a("c36015a9e45a85"), this.t);
        return valueObject;
    }
}
