package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render;

import android.content.Context;
import android.webkit.WebSettings;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.C3023d;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.C3024e;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.y;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class q {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2989a;

        static {
            int[] iArr = new int[com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.i.values().length];
            try {
                iArr[com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.i.f2827a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.i.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f2989a = iArr;
        }
    }

    public static final C3023d a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        C3023d c3023d = new C3023d(context);
        c3023d.setScrollBarStyle(0);
        c3023d.setHorizontalScrollBarEnabled(false);
        c3023d.setVerticalScrollBarEnabled(false);
        WebSettings settings = c3023d.getSettings();
        settings.setSupportZoom(false);
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(false);
        settings.setAllowContentAccess(false);
        c3023d.setBackgroundColor(0);
        return c3023d;
    }

    public static final void a(C3023d c3023d, y vastResource) {
        String strA;
        Intrinsics.checkNotNullParameter(c3023d, "<this>");
        Intrinsics.checkNotNullParameter(vastResource, "vastResource");
        if (vastResource instanceof y.c) {
            y.c cVar = (y.c) vastResource;
            int i = a.f2989a[cVar.a().a().ordinal()];
            if (i == 1) {
                strA = "<html><head></head><body style=\"margin:0;padding:0\"><img src=\"" + cVar.a().b() + "\" width=\"100%\" style=\"max-width:100%;max-height:100%;\" /></body></html>";
            } else if (i == 2) {
                strA = "<script src=\"" + cVar.a().b() + "\"></script>";
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else if (vastResource instanceof y.a) {
            strA = ((y.a) vastResource).a().a();
        } else if (vastResource instanceof y.b) {
            strA = "<iframe frameborder=\"0\" scrolling=\"no\" marginheight=\"0\" marginwidth=\"0\" style=\"border: 0px; margin: 0px;\" width=100% height=100% src=\"" + ((y.b) vastResource).a().a() + "\"></iframe>";
        } else {
            throw new NoWhenBranchMatchedException();
        }
        try {
            C3024e.a(c3023d, c3023d.getHtmlCssFixer().a(strA));
        } catch (Exception e) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, "BaseWebView", e.toString(), e, false, 8, null);
        }
    }
}
