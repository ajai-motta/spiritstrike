package com.fyber.inneractive.sdk.click;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.h0;
import java.net.URISyntaxException;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f918a = false;

    @Override // com.fyber.inneractive.sdk.click.a
    public final boolean a(Uri uri, r rVar) {
        return "intent".equalsIgnoreCase(uri.getScheme()) && !this.f918a;
    }

    @Override // com.fyber.inneractive.sdk.click.a
    public final void cancel() {
        this.f918a = true;
    }

    @Override // com.fyber.inneractive.sdk.click.a
    public final b a(Context context, Uri uri, List list) {
        if (a(uri, null)) {
            try {
                Intent uri2 = Intent.parseUri(uri.toString(), 1);
                if (!this.f918a && h0.a(context, uri2)) {
                    int i = IAlog.f1642a;
                    IAlog.d("%s %s", "DEEPLINK", uri.toString());
                    if (list != null) {
                        list.add(new j(uri.toString(), true, q.OPEN_IN_EXTERNAL_APPLICATION, null));
                    }
                    return new b(uri.toString(), q.OPEN_IN_EXTERNAL_APPLICATION, "IntentScheme", null);
                }
                String stringExtra = uri2.getStringExtra("browser_fallback_url");
                if (this.f918a || TextUtils.isEmpty(stringExtra)) {
                    if (list != null) {
                        list.add(new j(uri.toString(), false, q.OPEN_IN_EXTERNAL_APPLICATION, "tryToOpenExternalApp has failed (intent scheme)"));
                    }
                    return r.a(uri.toString(), "IntentScheme", "tryToOpenExternalApp has failed (intent scheme)");
                }
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(stringExtra));
                    if (!(context instanceof Activity)) {
                        intent.setFlags(268435456);
                    }
                    context.startActivity(intent);
                    IAlog.d("%s %s", "Intent opened successfully, url:", stringExtra);
                    if (list != null) {
                        list.add(new j(uri.toString(), false, q.DEEP_LINK, null));
                        list.add(new j(stringExtra, true, q.OPEN_IN_EXTERNAL_APPLICATION, null));
                    }
                    return new b(uri.toString(), q.OPEN_IN_EXTERNAL_APPLICATION, "IntentScheme", null);
                } catch (Throwable unused) {
                    IAlog.d("%s %s", "Intent failed, url:", stringExtra);
                }
            } catch (URISyntaxException e) {
                IAlog.a("failed parsing uri with error: %s", e.getLocalizedMessage());
                if (list != null) {
                    list.add(new j(uri.toString(), false, q.OPEN_IN_EXTERNAL_APPLICATION, null));
                }
                return new b(uri.toString(), q.FAILED, "IntentScheme", e);
            }
        }
        return null;
    }
}
