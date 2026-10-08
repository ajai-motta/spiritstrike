package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import android.content.Context;
import android.net.Uri;
import androidx.browser.customtabs.CustomTabsIntent;
import com.moloco.sdk.internal.MolocoLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C3038t {
    public static final boolean b(Context context, String str) {
        try {
            CustomTabsIntent customTabsIntentBuild = new CustomTabsIntent.Builder().setUrlBarHidingEnabled(true).build();
            Intrinsics.checkNotNullExpressionValue(customTabsIntentBuild, "build(...)");
            customTabsIntentBuild.intent.addFlags(268435456);
            customTabsIntentBuild.launchUrl(context, Uri.parse(str));
            return true;
        } catch (Exception e) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, "Xenoss", "tryStartCustomTabs exception", e, false, 8, null);
            return false;
        }
    }
}
