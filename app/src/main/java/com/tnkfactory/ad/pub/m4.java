package com.tnkfactory.ad.pub;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes6.dex */
public final class m4 {
    public static m4 b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f3161a;

    public m4(Context context) {
        this.f3161a = context.getApplicationContext();
    }

    public static m4 a(Context context) {
        if (b == null) {
            b = new m4(context);
        }
        return b;
    }

    public final void b(int i) {
        SharedPreferences.Editor editorEdit = this.f3161a.getSharedPreferences("__tnk_pub__", 0).edit();
        editorEdit.putInt("__tnk_0002_", i);
        editorEdit.apply();
        r0 r0Var = r0.x;
        if (r0Var != null) {
            r0Var.r = i;
        }
    }

    public final void c(String str) {
        SharedPreferences.Editor editorEdit = this.f3161a.getSharedPreferences("__tnk_pub__", 0).edit();
        editorEdit.putString("__tnk_202301_", str);
        editorEdit.apply();
        r0 r0Var = r0.x;
        if (r0Var != null) {
            r0Var.f3184a = str;
        }
    }

    public final void a(int i) {
        SharedPreferences.Editor editorEdit = this.f3161a.getSharedPreferences("__tnk_pub__", 0).edit();
        editorEdit.putInt("__tnk_0001_", i);
        editorEdit.apply();
        r0 r0Var = r0.x;
        if (r0Var != null) {
            r0Var.q = i;
        }
    }

    public final void b(String str) {
        SharedPreferences.Editor editorEdit = this.f3161a.getSharedPreferences("__tnk_pub__", 0).edit();
        editorEdit.putLong("__tnk_0004_" + str, System.currentTimeMillis());
        editorEdit.apply();
    }

    public final void a() {
        SharedPreferences.Editor editorEdit = this.f3161a.getSharedPreferences("__tnk_pub__", 0).edit();
        editorEdit.putLong("__tnk_0007_", System.currentTimeMillis());
        editorEdit.apply();
    }

    public final void a(String str) {
        SharedPreferences.Editor editorEdit = this.f3161a.getSharedPreferences("__tnk_pub__", 0).edit();
        editorEdit.putString("__tnk_202301_", str);
        editorEdit.apply();
    }
}
