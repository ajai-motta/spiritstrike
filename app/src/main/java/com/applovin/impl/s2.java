package com.applovin.impl;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class s2 extends BaseAdapter implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Context f593a;
    private List b = new ArrayList();
    private Map c = new HashMap();
    private a d;

    public interface a {
        void a(j2 j2Var, r2 r2Var);
    }

    protected s2(Context context) {
        this.f593a = context.getApplicationContext();
    }

    protected r2 a() {
        return null;
    }

    public void a(a aVar) {
        this.d = aVar;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return false;
    }

    protected abstract int b();

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public r2 getItem(int i) {
        return (r2) this.b.get(i);
    }

    protected abstract List c(int i);

    public void c() {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.s2$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.notifyDataSetChanged();
            }
        });
    }

    protected abstract int d(int i);

    protected abstract r2 e(int i);

    @Override // android.widget.Adapter
    public int getCount() {
        return this.b.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItem(i).m();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        q2 q2Var;
        r2 item = getItem(i);
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(item.j(), viewGroup, false);
            q2Var = new q2();
            q2Var.f578a = (TextView) view.findViewById(R.id.text1);
            q2Var.b = (TextView) view.findViewById(R.id.text2);
            q2Var.c = (ImageView) view.findViewById(com.applovin.sdk.R.id.imageView);
            q2Var.d = (ImageView) view.findViewById(com.applovin.sdk.R.id.detailImageView);
            view.setTag(q2Var);
            view.setOnClickListener(this);
            view.setBackground(a(view));
        } else {
            q2Var = (q2) view.getTag();
        }
        q2Var.a(i);
        q2Var.a(item);
        view.setEnabled(item.o());
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return r2.n();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        return getItem(i).o();
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        int i;
        this.b = new ArrayList();
        int iB = b();
        this.c = new HashMap(iB);
        r2 r2VarA = a();
        if (r2VarA != null) {
            this.b.add(r2VarA);
            i = 1;
        } else {
            i = 0;
        }
        for (int i2 = 0; i2 < iB; i2++) {
            int iD = d(i2);
            if (iD != 0) {
                this.b.add(e(i2));
                this.b.addAll(c(i2));
                this.c.put(Integer.valueOf(i2), Integer.valueOf(i));
                i += iD + 1;
            }
        }
        this.b.add(new w4(""));
        super.notifyDataSetChanged();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        q2 q2Var = (q2) view.getTag();
        r2 r2VarB = q2Var.b();
        j2 j2VarA = a(q2Var.a());
        a aVar = this.d;
        if (aVar == null || j2VarA == null) {
            return;
        }
        aVar.a(j2VarA, r2VarB);
    }

    private j2 a(int i) {
        for (int i2 = 0; i2 < b(); i2++) {
            Integer num = (Integer) this.c.get(Integer.valueOf(i2));
            if (num != null) {
                if (i <= num.intValue() + d(i2)) {
                    return new j2(i2, i - (num.intValue() + 1));
                }
            }
        }
        return null;
    }

    private Drawable a(View view) {
        Drawable background = view.getBackground();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(m0.a(com.applovin.sdk.R.color.applovin_sdk_highlightListItemColor, this.f593a));
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, gradientDrawable);
        stateListDrawable.addState(new int[0], background);
        return stateListDrawable;
    }
}
