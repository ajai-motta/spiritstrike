package com.unity3d.player;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;

/* JADX INFO: loaded from: classes6.dex */
final class P extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Button f3273a;
    protected EditText b;
    protected Context c;
    protected Rect d;
    protected Rect e;

    public P(Context context, EditText editText) {
        super(context);
        this.b = editText;
        this.c = context;
        this.d = new Rect(16, 16, 16, 16);
        this.e = new Rect(0, 0, 0, 0);
        createUI();
        setBackgroundColor(-1);
    }

    protected void createUI() {
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        Button button = new Button(this.c);
        this.f3273a = button;
        button.setId(View.generateViewId());
        this.f3273a.setText(this.c.getResources().getIdentifier("ok", TypedValues.Custom.S_STRING, "android"));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(11);
        this.f3273a.setLayoutParams(layoutParams);
        this.f3273a.setBackgroundColor(0);
        addView(this.f3273a);
        this.b.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(15);
        layoutParams2.addRule(0, this.f3273a.getId());
        this.b.setLayoutParams(layoutParams2);
        addView(this.b);
        Rect rect = this.d;
        setPadding(rect.left, rect.top, rect.right, rect.bottom);
    }

    @Override // android.view.View
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.f3273a.setOnClickListener(onClickListener);
    }
}
