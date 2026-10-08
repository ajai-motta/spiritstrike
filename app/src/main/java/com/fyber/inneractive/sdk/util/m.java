package com.fyber.inneractive.sdk.util;

import android.graphics.Insets;
import android.view.View;
import android.view.WindowInsets;

/* JADX INFO: loaded from: classes3.dex */
public final class m implements View.OnApplyWindowInsetsListener {
    @Override // android.view.View.OnApplyWindowInsetsListener
    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        Insets insets = windowInsets.getInsets(WindowInsets.Type.displayCutout());
        int iB = o.b();
        if (iB == 1) {
            view.setPadding(insets.left, 0, 0, 0);
        } else if (iB == 2) {
            view.setPadding(0, 0, 0, insets.bottom);
        } else if (iB != 3) {
            view.setPadding(0, insets.top, 0, 0);
        } else {
            view.setPadding(0, 0, insets.right, 0);
        }
        return windowInsets;
    }
}
