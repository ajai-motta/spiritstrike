package androidx.appcompat.widget;

import android.graphics.Rect;

/* JADX INFO: loaded from: classes10.dex */
public interface FitWindowsViewGroup {

    public interface OnFitSystemWindowsListener {
        void onFitSystemWindows(Rect insets);
    }

    void setOnFitSystemWindowsListener(OnFitSystemWindowsListener listener);
}
