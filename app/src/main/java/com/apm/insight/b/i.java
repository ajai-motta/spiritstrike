package com.apm.insight.b;

import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.util.Printer;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f148a = 5;
    private static b b;
    private static boolean c;
    private static Printer d;

    public interface a {
    }

    static /* synthetic */ a b() {
        return null;
    }

    static class b implements Printer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        List<Printer> f149a = new ArrayList();
        private List<Printer> d = new ArrayList();
        List<Printer> b = new ArrayList();
        private boolean e = false;
        boolean c = false;

        b() {
        }

        @Override // android.util.Printer
        public final void println(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            i.b();
            if (str.charAt(0) == '>' && this.c) {
                for (Printer printer : this.b) {
                    if (!this.f149a.contains(printer)) {
                        this.f149a.add(printer);
                    }
                }
                this.b.clear();
                this.c = false;
            }
            if (this.f149a.size() > i.f148a) {
                Log.e("LooperPrinterUtils", "wrapper contains too many printer,please check if the useless printer have been removed");
            }
            for (Printer printer2 : this.f149a) {
                if (printer2 != null) {
                    printer2.println(str);
                }
            }
            str.charAt(0);
            i.b();
        }
    }

    public static void a() {
        if (c) {
            return;
        }
        c = true;
        b = new b();
        Printer printerD = d();
        d = printerD;
        if (printerD != null) {
            b.f149a.add(d);
        }
        if (com.apm.insight.e.s()) {
            Looper.getMainLooper().setMessageLogging(b);
        }
    }

    public static void a(Printer printer) {
        if (printer == null || b.b.contains(printer)) {
            return;
        }
        b.b.add(printer);
        b.c = true;
    }

    private static Printer d() {
        try {
            Field declaredField = Class.forName("android.os.Looper").getDeclaredField("mLogging");
            declaredField.setAccessible(true);
            return (Printer) declaredField.get(Looper.getMainLooper());
        } catch (Exception unused) {
            return null;
        }
    }
}
