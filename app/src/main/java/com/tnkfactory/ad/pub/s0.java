package com.tnkfactory.ad.pub;

import android.content.Context;
import com.tnkfactory.ad.Logger;
import com.tnkfactory.framework.vo.ValueObject;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public final class s0 extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f3190a;
    public final String b;
    public final String c;
    public final String d;
    public final Object[] e;
    public final a0 f;
    public a g;
    public ArrayList i;
    public boolean h = false;
    public w j = null;

    public s0(Context context, String str, String str2, String str3, Object[] objArr, a0 a0Var) {
        this.f3190a = context;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = objArr;
        this.f = a0Var;
    }

    public final void a(Object obj) {
        a aVar = this.g;
        if (aVar != null) {
            if (this.h) {
                this.g.sendMessage(aVar.obtainMessage(1, obj));
                return;
            }
            try {
                if (obj instanceof Throwable) {
                    aVar.f3102a.a((Throwable) obj);
                } else {
                    aVar.f3102a.a(obj);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        r0 r0VarA;
        Exception exc = null;
        try {
            r0VarA = r0.a(this.f3190a);
            try {
                if (r0VarA == null) {
                    Logger.e(h1.a("f55c2ad6e75e852bfa716d5737f839b990df0758"));
                    exc = new Exception(h1.a("f55c2ad6e75e852bfa716d5737f839b990df0758"));
                } else if (r0VarA.c == null) {
                    Logger.e(h1.a("e77c1793fb459878fa71630317fd75be85ce431f2b50c68d51"));
                    exc = new Exception("Advertising Id not found!");
                }
            } catch (Exception e) {
                e = e;
                exc = e;
            }
        } catch (Exception e2) {
            e = e2;
            r0VarA = null;
        }
        if (exc != null) {
            a(exc);
            return;
        }
        System.currentTimeMillis();
        try {
            try {
                try {
                    th = new m3(r0VarA, this.f).a(this.b, this.c, this.d, this.e);
                } catch (Exception e3) {
                    Logger.e("error #f001 : " + e3.toString());
                    throw new j3(e3);
                }
            } catch (j3 e4) {
                throw e4;
            }
        } catch (Throwable th) {
            th = th;
        }
        w wVar = this.j;
        if (wVar != null && th != null && !(th instanceof Throwable)) {
            th = new c(wVar.f3211a.b, (ValueObject) th);
        }
        a(th);
        ArrayList arrayList = this.i;
        if (arrayList != null) {
            new o4(arrayList).run();
        }
    }
}
