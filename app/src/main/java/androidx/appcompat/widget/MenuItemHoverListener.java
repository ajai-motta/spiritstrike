package androidx.appcompat.widget;

import android.view.MenuItem;
import androidx.appcompat.view.menu.MenuBuilder;

/* JADX INFO: loaded from: classes10.dex */
public interface MenuItemHoverListener {
    void onItemHoverEnter(MenuBuilder menu, MenuItem item);

    void onItemHoverExit(MenuBuilder menu, MenuItem item);
}
