package com.bytedance.sdk.component.tvp;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import com.bytedance.sdk.component.utils.koa;
import com.bytedance.sdk.component.utils.rc;
import com.bytedance.sdk.component.utils.tvp;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class qdl extends lnr implements koa.qdl {
    private View.OnTouchListener aaj;
    private String exc;
    private int exu;
    private long fs;
    private float jl;
    private volatile float jpc;
    private boolean jtx;
    private final int lnr;
    private final List<Integer> mml;
    private final Context mo;
    private final int mzz;
    private long rq;
    private final int ud;
    private volatile float wd;
    private float yt;
    private float tvp = -1.0f;
    private float to = -1.0f;
    private final Handler bjy = new koa(tvp.qdl().getLooper(), this);
    InterfaceC0211qdl qdl = new InterfaceC0211qdl() { // from class: com.bytedance.sdk.component.tvp.qdl.1
        @Override // com.bytedance.sdk.component.tvp.qdl.InterfaceC0211qdl
        public void qdl() {
            if (qdl.this.tvp == -1.0f && qdl.this.to == -1.0f && qdl.this.fs == -1) {
                Float.valueOf(qdl.this.tvp);
                Float.valueOf(qdl.this.to);
                qdl qdlVar = qdl.this;
                qdlVar.tvp = qdlVar.wd;
                qdl qdlVar2 = qdl.this;
                qdlVar2.to = qdlVar2.jpc;
                qdl qdlVar3 = qdl.this;
                qdlVar3.fs = qdlVar3.rq;
                qdl.this.jtx = true;
            }
            Float.valueOf(qdl.this.tvp);
            Float.valueOf(qdl.this.to);
        }

        @Override // com.bytedance.sdk.component.tvp.qdl.InterfaceC0211qdl
        public void qdl(int i) {
            qdl.this.exu = i;
            qdl.this.ud();
        }
    };
    private int jyq = -1;
    private final List<Integer> rdp = new ArrayList();

    /* JADX INFO: renamed from: com.bytedance.sdk.component.tvp.qdl$qdl, reason: collision with other inner class name */
    public interface InterfaceC0211qdl {
        void qdl();

        void qdl(int i);
    }

    public qdl(Context context, int i, int i2, List<Integer> list, int i3) {
        this.mo = context;
        if (i == -1) {
            this.ud = rc.qdl(context);
        } else {
            this.ud = rc.qdl(context, i);
        }
        this.lnr = rc.qdl(context, i2);
        this.mml = list;
        this.mzz = i3;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        Integer.valueOf(action);
        Float.valueOf(motionEvent.getX());
        Float.valueOf(motionEvent.getY());
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        this.rq = SystemClock.elapsedRealtime();
        this.wd = x;
        this.jpc = y;
        if (action == 0) {
            this.yt = x;
            this.jl = y;
            Float.valueOf(x);
            Float.valueOf(this.jl);
        } else if (action == 1) {
            Float.valueOf(x);
            Float.valueOf(y);
            if (qdl(x, y, this.yt, this.jl, this.mo)) {
                int iQdl = qdl(this.wd, this.jpc, this.rq);
                boolean zContains = true ^ this.rdp.contains(Integer.valueOf(this.exu));
                qdl(view, motionEvent, iQdl, zContains);
                if (zContains) {
                    this.rdp.add(Integer.valueOf(this.exu));
                }
                if (iQdl == 0) {
                    motionEvent.setAction(3);
                }
            }
        }
        View.OnTouchListener onTouchListener = this.aaj;
        if (onTouchListener != null) {
            return onTouchListener.onTouch(view, motionEvent);
        }
        return false;
    }

    @Override // com.bytedance.sdk.component.tvp.lnr
    public void qdl(View.OnTouchListener onTouchListener) {
        this.aaj = onTouchListener;
    }

    public InterfaceC0211qdl qdl() {
        return this.qdl;
    }

    private void qdl(View view, MotionEvent motionEvent, int i, boolean z) {
        String url;
        JSONObject jSONObject = new JSONObject();
        WebView webView = view instanceof WebView ? (WebView) view : null;
        if (webView != null) {
            try {
                url = webView.getUrl();
            } catch (Throwable unused) {
            }
        } else {
            url = "";
        }
        jSONObject.put("arbi_current_url", url);
        jSONObject.put("click_x", motionEvent.getX());
        jSONObject.put("click_y", motionEvent.getY());
        int i2 = 1;
        if (i != 0) {
            i2 = 0;
        }
        jSONObject.put("is_interceptor", i2);
        jSONObject.put("is_first_click", z ? 1 : 0);
        jSONObject.put("click_timestamp", System.currentTimeMillis());
        jSONObject.put("arbi_interceptor_type", i);
        jSONObject.put("current_url_index", this.exu);
        Message messageObtain = Message.obtain();
        messageObtain.what = 100;
        messageObtain.obj = jSONObject;
        this.bjy.sendMessageDelayed(messageObtain, 200L);
    }

    public void qdl(String str) {
        this.exc = str;
    }

    private int qdl(float f, float f2, long j) {
        if (this.tvp == -1.0f && this.to == -1.0f && this.fs == -1) {
            return 1;
        }
        Integer.valueOf(this.exu);
        if (!this.mml.contains(Integer.valueOf(this.exu))) {
            return 2;
        }
        if (j - this.fs > this.mzz) {
            ud();
            return 3;
        }
        float fAbs = Math.abs(f - this.tvp);
        float fAbs2 = Math.abs(f2 - this.to);
        Float.valueOf(f);
        Float.valueOf(this.tvp);
        Float.valueOf(fAbs);
        Float.valueOf(f2);
        Float.valueOf(this.to);
        Float.valueOf(fAbs2);
        Integer.valueOf(this.ud);
        Integer.valueOf(this.lnr);
        if (fAbs <= this.ud / 2.0f && fAbs2 <= this.lnr / 2.0f) {
            return 0;
        }
        ud();
        return 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ud() {
        this.tvp = -1.0f;
        this.to = -1.0f;
        this.fs = -1L;
    }

    @Override // com.bytedance.sdk.component.utils.koa.qdl
    public void qdl(Message message) {
        int i = message.what;
        Object obj = message.obj;
        JSONObject jSONObject = new JSONObject();
        if (i == 100) {
            if (obj instanceof JSONObject) {
                jSONObject = (JSONObject) obj;
                try {
                    jSONObject.put("is_trigger_jump", this.jtx ? 1 : 0);
                    this.jtx = false;
                } catch (Throwable unused) {
                }
            }
            if (com.bytedance.sdk.component.tvp.qdl.qdl.qdl().ud() != null) {
                com.bytedance.sdk.component.tvp.qdl.qdl.qdl().ud().qdl(this.exc, "arbitrage_click_event", jSONObject);
            }
        }
    }
}
