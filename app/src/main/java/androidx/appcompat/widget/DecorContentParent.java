package androidx.appcompat.widget;

import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.Menu;
import android.view.Window;
import androidx.appcompat.view.menu.MenuPresenter;

/* JADX INFO: loaded from: classes10.dex */
public interface DecorContentParent {
    boolean canShowOverflowMenu();

    void dismissPopups();

    CharSequence getTitle();

    boolean hasIcon();

    boolean hasLogo();

    boolean hideOverflowMenu();

    void initFeature(int windowFeature);

    boolean isOverflowMenuShowPending();

    boolean isOverflowMenuShowing();

    void restoreToolbarHierarchyState(SparseArray<Parcelable> toolbarStates);

    void saveToolbarHierarchyState(SparseArray<Parcelable> toolbarStates);

    void setIcon(int resId);

    void setIcon(Drawable d);

    void setLogo(int resId);

    void setMenu(Menu menu, MenuPresenter.Callback cb);

    void setMenuPrepared();

    void setUiOptions(int uiOptions);

    void setWindowCallback(Window.Callback cb);

    void setWindowTitle(CharSequence title);

    boolean showOverflowMenu();
}
