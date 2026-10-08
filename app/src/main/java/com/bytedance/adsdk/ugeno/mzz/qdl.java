package com.bytedance.adsdk.ugeno.mzz;

import android.view.View;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
interface qdl {
    int getAlignContent();

    int getAlignItems();

    int getFlexDirection();

    int getFlexItemCount();

    List<lnr> getFlexLinesInternal();

    int getFlexWrap();

    int getLargestMainSize();

    int getMaxLine();

    int getPaddingBottom();

    int getPaddingEnd();

    int getPaddingLeft();

    int getPaddingRight();

    int getPaddingStart();

    int getPaddingTop();

    int getSumOfCrossSize();

    int qdl(int i, int i2, int i3);

    int qdl(View view);

    int qdl(View view, int i, int i2);

    View qdl(int i);

    void qdl(View view, int i, int i2, lnr lnrVar);

    void qdl(lnr lnrVar);

    boolean qdl();

    void setFlexLines(List<lnr> list);

    int ud(int i, int i2, int i3);

    View ud(int i);
}
