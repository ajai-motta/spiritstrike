package com.fyber.inneractive.sdk.click;

import android.net.Uri;

/* JADX INFO: loaded from: classes3.dex */
public final class i implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f919a;
    public final boolean b;
    public boolean c = false;

    public i(boolean z, String str) {
        this.f919a = str;
        this.b = z;
    }

    @Override // com.fyber.inneractive.sdk.click.a
    public final boolean a(Uri uri, r rVar) {
        return !this.c && ("fybernativebrowser".equalsIgnoreCase(uri.getScheme()) || "fybernativebrowser".equalsIgnoreCase(this.f919a) || this.b || uri.toString().contains("FYBER_OPEN_BROWSER"));
    }

    @Override // com.fyber.inneractive.sdk.click.a
    public final void cancel() {
        this.c = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
    @Override // com.fyber.inneractive.sdk.click.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.fyber.inneractive.sdk.click.b a(android.content.Context r10, android.net.Uri r11, java.util.List r12) {
        /*
            Method dump skipped, instruction units count: 288
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.click.i.a(android.content.Context, android.net.Uri, java.util.List):com.fyber.inneractive.sdk.click.b");
    }
}
