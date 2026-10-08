package com.fyber.inneractive.sdk.flow.nativead.trackers;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.fyber.inneractive.sdk.network.z;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.web.m;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends WebViewClient implements Handler.Callback {
    public static final String e = IAlog.a(b.class);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentLinkedQueue f1088a;
    public c b;
    public m c;
    public Handler d = new Handler(Looper.getMainLooper(), this);

    public b(ArrayList arrayList, c cVar) {
        this.f1088a = new ConcurrentLinkedQueue(arrayList);
        this.b = cVar;
        m mVar = new m();
        mVar.setWebViewClient(this);
        mVar.setVisibility(8);
        mVar.getSettings().setJavaScriptEnabled(true);
        this.c = mVar;
    }

    public final void a() {
        String str;
        Handler handler = this.d;
        if (handler != null) {
            handler.removeMessages(13);
        }
        if (this.f1088a.isEmpty() || this.d == null || this.c == null || (str = (String) this.f1088a.poll()) == null) {
            Handler handler2 = this.d;
            if (handler2 != null) {
                handler2.sendEmptyMessage(12);
                return;
            }
            return;
        }
        if (this.d != null) {
            Message messageObtain = Message.obtain();
            messageObtain.what = 14;
            messageObtain.obj = str;
            this.d.sendMessage(messageObtain);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        switch (message.what) {
            case 12:
                c cVar = this.b;
                if (cVar != null) {
                    cVar.b();
                }
                return true;
            case 13:
                Object obj = message.obj;
                IAlog.b("%sTimeout reached for tracker: %s", e, obj != null ? obj.toString() : "unknown");
                a();
                return true;
            case 14:
                Object obj2 = message.obj;
                if (obj2 != null) {
                    String str = e;
                    IAlog.a("%sLoading tracker %s", str, obj2);
                    String string = message.obj.toString();
                    Handler handler = this.d;
                    if (handler == null || this.c == null) {
                        IAlog.b("%sWas destroyed. Unable to load JS tracker %s", str, string);
                    } else {
                        if (handler != null) {
                            Message messageObtain = Message.obtain();
                            messageObtain.what = 13;
                            messageObtain.obj = string;
                            this.d.sendMessageDelayed(messageObtain, 5000L);
                        }
                        this.c.loadDataWithBaseURL(null, string, "text/html", "UTF-8", null);
                    }
                }
                return true;
            default:
                return true;
        }
    }

    @Override // android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        z.a("WebViewRendererProcessGone", "Encountered WebViewRendererProcessGone while executing native JS tracking", null, null);
        Handler handler = this.d;
        if (handler == null) {
            return true;
        }
        handler.sendEmptyMessage(12);
        return true;
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (TextUtils.isEmpty(str) || !str.contains("iaadfinishedloading")) {
            return super.shouldOverrideUrlLoading(webView, str);
        }
        IAlog.a("%sTracker finished", e);
        a();
        return true;
    }
}
