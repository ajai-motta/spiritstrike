package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Parcelable;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes10.dex */
public interface MenuPresenter {

    public interface Callback {
        void onCloseMenu(MenuBuilder menu, boolean allMenusAreClosing);

        boolean onOpenSubMenu(MenuBuilder subMenu);
    }

    boolean collapseItemActionView(MenuBuilder menu, MenuItemImpl item);

    boolean expandItemActionView(MenuBuilder menu, MenuItemImpl item);

    boolean flagActionItems();

    int getId();

    MenuView getMenuView(ViewGroup root);

    void initForMenu(Context context, MenuBuilder menu);

    void onCloseMenu(MenuBuilder menu, boolean allMenusAreClosing);

    void onRestoreInstanceState(Parcelable state);

    Parcelable onSaveInstanceState();

    boolean onSubMenuSelected(SubMenuBuilder subMenu);

    void setCallback(Callback cb);

    void updateMenuView(boolean cleared);
}
