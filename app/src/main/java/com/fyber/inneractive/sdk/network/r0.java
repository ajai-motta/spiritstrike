package com.fyber.inneractive.sdk.network;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashMap f1215a;

    public r0(InneractiveAdRequest inneractiveAdRequest, com.fyber.inneractive.sdk.serverapi.d dVar) {
    }

    public final void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.f1215a.put(str, str2);
    }
}
