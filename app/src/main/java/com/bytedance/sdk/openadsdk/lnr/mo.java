package com.bytedance.sdk.openadsdk.lnr;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.utils.ax;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class mo extends ScrollView {
    private final to qdl;
    private final com.bytedance.sdk.openadsdk.core.mo.mzz ud;

    public mo(Context context, to toVar) {
        super(context);
        this.qdl = toVar;
        com.bytedance.sdk.openadsdk.core.mo.mzz mzzVar = new com.bytedance.sdk.openadsdk.core.mo.mzz(context);
        this.ud = mzzVar;
        mzzVar.setOrientation(1);
        addView(mzzVar, new FrameLayout.LayoutParams(-1, -2));
        if (toVar.jpc() == 0) {
            qdl();
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.weight = 1.0f;
        setLayoutParams(layoutParams);
        setVerticalScrollBarEnabled(false);
    }

    private void qdl() {
        if (this.qdl.jpc() != 0) {
            return;
        }
        this.qdl.qdl(ax.lnr(getContext()), ax.mzz(getContext()));
    }

    public void qdl(List<FilterWord> list) {
        List<FilterWord> listLnr = lnr(list);
        if (listLnr == null) {
            return;
        }
        ud(listLnr);
    }

    private void ud(List<FilterWord> list) {
        this.ud.removeAllViews();
        for (int i = 0; i < list.size(); i++) {
            FilterWord filterWord = list.get(i);
            if (filterWord != null) {
                this.ud.addView(new wd(getContext(), filterWord, this.qdl));
            }
            if (i < list.size() - 1) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                int iUd = ax.ud(getContext(), this.qdl.tvp() ? 16.0f : 8.0f);
                layoutParams.topMargin = iUd;
                layoutParams.bottomMargin = iUd;
                this.ud.addView(new rq(getContext()), layoutParams);
            }
        }
    }

    private static List<FilterWord> lnr(List<FilterWord> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        int i = 0;
        int i2 = -1;
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (list.get(i3).hasSecondOptions()) {
                i2 = i3;
            }
        }
        if (i2 != -1 && i2 <= list.size()) {
            i = i2;
        }
        FilterWord filterWord = list.get(i);
        Iterator<FilterWord> it = list.iterator();
        while (it.hasNext()) {
            FilterWord next = it.next();
            if (!next.hasSecondOptions()) {
                filterWord.addOption(next);
                it.remove();
            }
        }
        return list;
    }
}
