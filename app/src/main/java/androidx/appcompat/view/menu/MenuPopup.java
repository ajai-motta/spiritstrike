package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes10.dex */
public abstract class MenuPopup implements ShowableListMenu, MenuPresenter, AdapterView.OnItemClickListener {
    private Rect mEpicenterBounds;

    public abstract void addMenu(MenuBuilder menu);

    protected boolean closeMenuOnSubMenuOpened() {
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean collapseItemActionView(MenuBuilder menu, MenuItemImpl item) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean expandItemActionView(MenuBuilder menu, MenuItemImpl item) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public int getId() {
        return 0;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void initForMenu(Context context, MenuBuilder menu) {
    }

    public abstract void setAnchorView(View anchor);

    public abstract void setForceShowIcon(boolean forceShow);

    public abstract void setGravity(int dropDownGravity);

    public abstract void setHorizontalOffset(int x);

    public abstract void setOnDismissListener(PopupWindow.OnDismissListener listener);

    public abstract void setShowTitle(boolean showTitle);

    public abstract void setVerticalOffset(int y);

    MenuPopup() {
    }

    public void setEpicenterBounds(Rect bounds) {
        this.mEpicenterBounds = bounds;
    }

    public Rect getEpicenterBounds() {
        return this.mEpicenterBounds;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public MenuView getMenuView(ViewGroup root) {
        throw new UnsupportedOperationException("MenuPopups manage their own views");
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ListAdapter listAdapter = (ListAdapter) parent.getAdapter();
        toMenuAdapter(listAdapter).mAdapterMenu.performItemAction((MenuItem) listAdapter.getItem(position), this, closeMenuOnSubMenuOpened() ? 0 : 4);
    }

    protected static int measureIndividualMenuWidth(ListAdapter adapter, ViewGroup parent, Context context, int maxAllowedWidth) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = adapter.getCount();
        int i = 0;
        int i2 = 0;
        View view = null;
        for (int i3 = 0; i3 < count; i3++) {
            int itemViewType = adapter.getItemViewType(i3);
            if (itemViewType != i2) {
                view = null;
                i2 = itemViewType;
            }
            if (parent == null) {
                parent = new FrameLayout(context);
            }
            view = adapter.getView(i3, view, parent);
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth >= maxAllowedWidth) {
                return maxAllowedWidth;
            }
            if (measuredWidth > i) {
                i = measuredWidth;
            }
        }
        return i;
    }

    protected static MenuAdapter toMenuAdapter(ListAdapter adapter) {
        if (adapter instanceof HeaderViewListAdapter) {
            return (MenuAdapter) ((HeaderViewListAdapter) adapter).getWrappedAdapter();
        }
        return (MenuAdapter) adapter;
    }

    protected static boolean shouldPreserveIconSpacing(MenuBuilder menu) {
        int size = menu.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = menu.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                return true;
            }
        }
        return false;
    }
}
