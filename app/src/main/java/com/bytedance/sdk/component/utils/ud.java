package com.bytedance.sdk.component.utils;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.view.View;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes3.dex */
public class ud {
    private static qdl qdl;

    public interface qdl {
        ExecutorService getAsyncStartActivityThreadPool();

        boolean isEnableAsyncStartActivity();

        boolean isStartActivityBySubThread();
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.component.utils.ud$ud, reason: collision with other inner class name */
    public interface InterfaceC0215ud {
        void qdl();

        void qdl(Throwable th);
    }

    public static void qdl(qdl qdlVar) {
        qdl = qdlVar;
    }

    public static void qdl(final Context context, final Intent intent, final InterfaceC0215ud interfaceC0215ud) {
        ExecutorService asyncStartActivityThreadPool;
        qdl qdlVar = qdl;
        if (qdlVar != null && qdlVar.isStartActivityBySubThread() && (asyncStartActivityThreadPool = qdl.getAsyncStartActivityThreadPool()) != null) {
            asyncStartActivityThreadPool.execute(new com.bytedance.sdk.component.jpc.jpc("startAct") { // from class: com.bytedance.sdk.component.utils.ud.1
                @Override // java.lang.Runnable
                public void run() {
                    ud.lnr(context, intent, interfaceC0215ud);
                }
            });
        } else {
            lnr(context, intent, interfaceC0215ud);
        }
    }

    public static boolean qdl(final Context context, final Intent intent, final InterfaceC0215ud interfaceC0215ud, boolean z) {
        qdl qdlVar;
        ExecutorService asyncStartActivityThreadPool;
        if (z && (qdlVar = qdl) != null && qdlVar.isEnableAsyncStartActivity() && (asyncStartActivityThreadPool = qdl.getAsyncStartActivityThreadPool()) != null) {
            asyncStartActivityThreadPool.execute(new com.bytedance.sdk.component.jpc.jpc("startAct") { // from class: com.bytedance.sdk.component.utils.ud.2
                @Override // java.lang.Runnable
                public void run() {
                    ud.lnr(context, intent, interfaceC0215ud);
                }
            });
            return true;
        }
        return lnr(context, intent, interfaceC0215ud);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean lnr(Context context, Intent intent, InterfaceC0215ud interfaceC0215ud) {
        if (context != null && intent != null) {
            try {
                if (!(context instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                context.startActivity(intent);
                if (interfaceC0215ud == null) {
                    return true;
                }
                interfaceC0215ud.qdl();
                return true;
            } catch (Throwable th) {
                if (interfaceC0215ud != null) {
                    interfaceC0215ud.qdl(th);
                }
            }
        }
        return false;
    }

    public static Activity qdl(View view) {
        View viewFindViewById;
        Context context;
        if (view == null) {
            return null;
        }
        Context context2 = view.getContext();
        if (context2 instanceof Activity) {
            return (Activity) context2;
        }
        View rootView = view.getRootView();
        if (rootView == null || (viewFindViewById = rootView.findViewById(R.id.content)) == null || (context = viewFindViewById.getContext()) == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            Context baseContext = ((ContextWrapper) context).getBaseContext();
            if (baseContext instanceof Activity) {
                return (Activity) baseContext;
            }
        }
        return null;
    }

    public static boolean qdl(Activity activity) {
        return activity == null || activity.isFinishing() || activity.isDestroyed();
    }
}
