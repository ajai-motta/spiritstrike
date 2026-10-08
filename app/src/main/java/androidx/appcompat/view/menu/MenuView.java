package androidx.appcompat.view.menu;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes10.dex */
public interface MenuView {

    public interface ItemView {
        MenuItemImpl getItemData();

        void initialize(MenuItemImpl itemData, int menuType);

        boolean prefersCondensedTitle();

        void setCheckable(boolean checkable);

        void setChecked(boolean checked);

        void setEnabled(boolean enabled);

        void setIcon(Drawable icon);

        void setShortcut(boolean showShortcut, char shortcutKey);

        void setTitle(CharSequence title);

        boolean showsIcon();
    }

    int getWindowAnimations();

    void initialize(MenuBuilder menu);
}
