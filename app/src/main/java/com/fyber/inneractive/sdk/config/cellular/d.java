package com.fyber.inneractive.sdk.config.cellular;

import android.content.Context;
import android.net.ConnectivityManager;
import android.telephony.TelephonyManager;
import androidx.autofill.HintConstants;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.z0;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TelephonyManager f933a;
    public final ConnectivityManager b;
    public CopyOnWriteArrayList c = new CopyOnWriteArrayList();

    public d(Context context) {
        this.f933a = (TelephonyManager) context.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
        this.b = (ConnectivityManager) context.getSystemService("connectivity");
    }

    public abstract void a();

    public abstract void a(a aVar);

    public abstract void a(h hVar);

    @Override // com.fyber.inneractive.sdk.config.cellular.h
    public final void a(z0 z0Var) {
        CopyOnWriteArrayList<h> copyOnWriteArrayList = this.c;
        if (copyOnWriteArrayList == null) {
            IAlog.a("NetworkDetector: onNetworkUpdated: no update listeners", new Object[0]);
            return;
        }
        for (h hVar : copyOnWriteArrayList) {
            if (hVar != null) {
                hVar.a(z0Var);
            }
        }
    }
}
