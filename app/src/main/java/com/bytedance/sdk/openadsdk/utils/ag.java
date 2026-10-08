package com.bytedance.sdk.openadsdk.utils;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.bytedance.sdk.openadsdk.ApmHelper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ag {

    public interface ud {
        void qdl();

        void qdl(View view, boolean z);

        void qdl(boolean z);

        void ud();
    }

    public static void qdl(final ViewGroup viewGroup, boolean z, int i, final boolean z2, ud udVar, List<ViewGroup> list) {
        viewGroup.setTag(520093765, udVar);
        viewGroup.setTag(520093766, Integer.valueOf(i));
        if (viewGroup.getTag(520093764) == Boolean.TRUE) {
            return;
        }
        final qdl qdlVar = new qdl(viewGroup, z2);
        if (list != null && list.size() > 0) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                list.get(i2).setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: com.bytedance.sdk.openadsdk.utils.ag.1
                    @Override // android.view.ViewGroup.OnHierarchyChangeListener
                    public void onChildViewAdded(View view, View view2) {
                        qdlVar.qdl = view2;
                    }

                    @Override // android.view.ViewGroup.OnHierarchyChangeListener
                    public void onChildViewRemoved(View view, View view2) {
                        qdlVar.qdl = null;
                    }
                });
            }
        }
        viewGroup.getViewTreeObserver().addOnGlobalLayoutListener(qdlVar);
        if (z) {
            viewGroup.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.bytedance.sdk.openadsdk.utils.ag.2
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public void onScrollChanged() {
                    try {
                        ud udVar2 = (ud) viewGroup.getTag(520093765);
                        ViewGroup viewGroup2 = viewGroup;
                        ag.ud(viewGroup2, udVar2, (Integer) viewGroup2.getTag(520093766), z2);
                    } catch (Exception e) {
                        ApmHelper.reportCustomError("onScrollChanged exception " + viewGroup.getTag(520093765), "ViewUtils", e);
                    }
                }
            });
        }
        viewGroup.getViewTreeObserver().addOnWindowFocusChangeListener(new ViewTreeObserver.OnWindowFocusChangeListener() { // from class: com.bytedance.sdk.openadsdk.utils.ag.3
            @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
            public void onWindowFocusChanged(boolean z3) {
                try {
                    ud udVar2 = (ud) viewGroup.getTag(520093765);
                    if (udVar2 != null) {
                        udVar2.qdl(z3);
                        ViewGroup viewGroup2 = viewGroup;
                        ag.ud(viewGroup2, udVar2, (Integer) viewGroup2.getTag(520093766), z2);
                    }
                } catch (Exception e) {
                    ApmHelper.reportCustomError("onWindowFocusChanged exception " + viewGroup.getTag(520093765), "ViewUtils", e);
                }
            }
        });
        viewGroup.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.bytedance.sdk.openadsdk.utils.ag.4
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                ud udVar2 = (ud) viewGroup.getTag(520093765);
                if (udVar2 != null) {
                    udVar2.qdl();
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                ud udVar2 = (ud) viewGroup.getTag(520093765);
                if (udVar2 != null) {
                    udVar2.ud();
                }
            }
        });
        viewGroup.setTag(520093764, Boolean.TRUE);
    }

    class qdl implements ViewTreeObserver.OnGlobalLayoutListener {
        final /* synthetic */ boolean lnr;
        View qdl = null;
        final /* synthetic */ ViewGroup ud;

        qdl(ViewGroup viewGroup, boolean z) {
            this.ud = viewGroup;
            this.lnr = z;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            try {
                ud udVar = (ud) this.ud.getTag(520093765);
                if (this.qdl != null) {
                    Rect rect = new Rect();
                    this.qdl.getGlobalVisibleRect(rect);
                    Rect rect2 = new Rect();
                    this.ud.getGlobalVisibleRect(rect2);
                    if (rect.contains(rect2)) {
                        if (udVar != null) {
                            udVar.qdl(this.ud, false);
                        }
                        this.ud.setTag(520093763, Boolean.FALSE);
                        return;
                    } else {
                        if (udVar != null) {
                            udVar.qdl(this.ud, true);
                        }
                        this.ud.setTag(520093763, Boolean.TRUE);
                        return;
                    }
                }
                ViewGroup viewGroup = this.ud;
                ag.ud(viewGroup, udVar, (Integer) viewGroup.getTag(520093766), this.lnr);
            } catch (Exception e) {
                ApmHelper.reportCustomError("onGlobalLayout exception " + this.ud.getTag(520093765), "ViewUtils", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ud(View view, ud udVar, Integer num, boolean z) {
        if (udVar == null) {
            return;
        }
        if (num == null) {
            num = 0;
        }
        udVar.qdl(view, qdl(view, num.intValue(), z));
    }

    private static boolean qdl(View view, int i, boolean z) {
        return com.bytedance.sdk.openadsdk.core.hzv.qdl(view, 20, i, z);
    }

    public static ArrayList<View> qdl(View view, int i) {
        ArrayList<View> arrayList = new ArrayList<>();
        if (view != null && i > 0) {
            Object parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) parent;
                for (int iIndexOfChild = viewGroup.indexOfChild(view) + 1; iIndexOfChild < viewGroup.getChildCount(); iIndexOfChild++) {
                    arrayList.add(viewGroup.getChildAt(iIndexOfChild));
                }
            }
            if (i > 1 && parent != null) {
                arrayList.addAll(qdl((View) parent, i - 1));
            }
        }
        return arrayList;
    }

    public static View qdl(View view, Class<? extends View> cls) {
        Object parent;
        if (view == null || cls == null || (parent = view.getParent()) == null) {
            return null;
        }
        if (cls.isInstance(parent)) {
            return (View) parent;
        }
        return qdl((View) parent, cls);
    }
}
