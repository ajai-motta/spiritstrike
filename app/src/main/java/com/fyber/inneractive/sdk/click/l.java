package com.fyber.inneractive.sdk.click;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.webkit.ProxyConfig;
import com.fyber.inneractive.sdk.util.IAlog;
import java.util.List;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes3.dex */
public final class l implements a {
    public static final k b = new k();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f921a = false;

    @Override // com.fyber.inneractive.sdk.click.a
    public final boolean a(Uri uri, r rVar) {
        return !this.f921a;
    }

    @Override // com.fyber.inneractive.sdk.click.a
    public final void cancel() {
        this.f921a = true;
    }

    @Override // com.fyber.inneractive.sdk.click.a
    public final b a(Context context, Uri uri, List list) {
        Intent intent;
        ResolveInfo resolveInfo;
        if (this.f921a) {
            return null;
        }
        if (Build.VERSION.SDK_INT > 29) {
            String scheme = uri.getScheme();
            if (!ProxyConfig.MATCH_HTTP.equalsIgnoreCase(scheme) && !"https".equalsIgnoreCase(scheme)) {
                if (this.f921a) {
                    return null;
                }
                Intent intent2 = new Intent("android.intent.action.VIEW", uri);
                if (!(context instanceof Activity)) {
                    intent2.setFlags(268435456);
                }
                return a(context, intent2, uri, list);
            }
        }
        List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", uri), 32);
        if (listQueryIntentActivities == null || listQueryIntentActivities.size() <= 0) {
            return null;
        }
        List<ResolveInfo> listQueryIntentActivities2 = context.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse("http://www.fyber.com")), 32);
        TreeSet treeSet = new TreeSet(b);
        treeSet.addAll(listQueryIntentActivities2);
        listQueryIntentActivities.removeAll(treeSet);
        if (listQueryIntentActivities.size() <= 0 || (resolveInfo = listQueryIntentActivities.get(0)) == null) {
            intent = null;
        } else {
            intent = new Intent("android.intent.action.VIEW", uri);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent.setClassName(activityInfo.packageName, activityInfo.name);
            if (!(context instanceof Activity)) {
                intent.setFlags(268435456);
            }
        }
        if (intent == null || this.f921a) {
            return null;
        }
        return a(context, intent, uri, list);
    }

    public final b a(Context context, Intent intent, Uri uri, List list) {
        if (this.f921a) {
            return r.a(uri.toString(), "Resolver", "The process was cancelled");
        }
        try {
            context.startActivity(intent);
            if (list != null) {
                list.add(new j(uri.toString(), true, a(intent), null));
            }
            return new b(uri.toString(), a(intent), "Resolver", null);
        } catch (Throwable th) {
            IAlog.a("failed starting activity with error: %s", th.getLocalizedMessage());
            if (list != null) {
                list.add(new j(uri.toString(), false, q.OPEN_IN_EXTERNAL_APPLICATION, null));
            }
            return r.a(uri.toString(), "Resolver", "failed starting resolved activity - " + th.getMessage());
        }
    }

    public static q a(Intent intent) {
        if (intent.getData() != null) {
            String string = intent.getData().toString();
            if (!TextUtils.isEmpty(string)) {
                Uri uri = Uri.parse(string);
                String host = uri.getHost();
                String scheme = uri.getScheme();
                if (((string.startsWith("http:") || string.startsWith("https:")) && ("play.google.com".equalsIgnoreCase(host) || "market.android.com".equalsIgnoreCase(host))) || "market".equalsIgnoreCase(scheme)) {
                    return q.OPEN_GOOGLE_STORE;
                }
            }
        }
        return q.OPEN_IN_EXTERNAL_APPLICATION;
    }
}
