package com.tnkfactory.ad.pub;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public final class d5 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f3122a;
    public final /* synthetic */ i5 b;

    public d5(i5 i5Var, Context context) {
        this.b = i5Var;
        this.f3122a = context;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        i5 i5Var = this.b;
        if (i5Var.b == null || !i5Var.q) {
            return;
        }
        ArrayList arrayList = i5Var.E;
        if (arrayList != null && !arrayList.isEmpty()) {
            k4 k4VarA = k4.a();
            ArrayList arrayList2 = this.b.E;
            k4VarA.getClass();
            k4.a(arrayList2);
        }
        if (TextUtils.isEmpty(this.b.D)) {
            return;
        }
        i5 i5Var2 = this.b;
        Context context = this.f3122a;
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(i5Var2.D));
            intent.addFlags(268435456);
            intent.addCategory("android.intent.category.BROWSABLE");
            intent.putExtra("com.android.browser.application_id", context.getApplicationContext().getPackageName());
            context.startActivity(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        i5 i5Var3 = this.b;
        i5Var3.r = false;
        i5Var3.a();
        this.b.r = true;
    }
}
