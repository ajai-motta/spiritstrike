package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.SpinnerAdapter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.core.view.ViewPropertyAnimatorCompat;

/* JADX INFO: loaded from: classes10.dex */
public interface DecorToolbar {
    void animateToVisibility(int visibility);

    boolean canShowOverflowMenu();

    void collapseActionView();

    void dismissPopupMenus();

    Context getContext();

    View getCustomView();

    int getDisplayOptions();

    int getDropdownItemCount();

    int getDropdownSelectedPosition();

    int getHeight();

    Menu getMenu();

    int getNavigationMode();

    CharSequence getSubtitle();

    CharSequence getTitle();

    ViewGroup getViewGroup();

    int getVisibility();

    boolean hasEmbeddedTabs();

    boolean hasExpandedActionView();

    boolean hasIcon();

    boolean hasLogo();

    boolean hideOverflowMenu();

    void initIndeterminateProgress();

    void initProgress();

    boolean isOverflowMenuShowPending();

    boolean isOverflowMenuShowing();

    boolean isTitleTruncated();

    void restoreHierarchyState(SparseArray<Parcelable> toolbarStates);

    void saveHierarchyState(SparseArray<Parcelable> toolbarStates);

    void setBackgroundDrawable(Drawable d);

    void setCollapsible(boolean collapsible);

    void setCustomView(View view);

    void setDefaultNavigationContentDescription(int defaultNavigationContentDescription);

    void setDefaultNavigationIcon(Drawable icon);

    void setDisplayOptions(int opts);

    void setDropdownParams(SpinnerAdapter adapter, AdapterView.OnItemSelectedListener listener);

    void setDropdownSelectedPosition(int position);

    void setEmbeddedTabView(ScrollingTabContainerView tabView);

    void setHomeButtonEnabled(boolean enable);

    void setIcon(int resId);

    void setIcon(Drawable d);

    void setLogo(int resId);

    void setLogo(Drawable d);

    void setMenu(Menu menu, MenuPresenter.Callback cb);

    void setMenuCallbacks(MenuPresenter.Callback presenterCallback, MenuBuilder.Callback menuBuilderCallback);

    void setMenuPrepared();

    void setNavigationContentDescription(int resId);

    void setNavigationContentDescription(CharSequence description);

    void setNavigationIcon(int resId);

    void setNavigationIcon(Drawable icon);

    void setNavigationMode(int mode);

    void setSubtitle(CharSequence subtitle);

    void setTitle(CharSequence title);

    void setVisibility(int visible);

    void setWindowCallback(Window.Callback cb);

    void setWindowTitle(CharSequence title);

    ViewPropertyAnimatorCompat setupAnimatorToVisibility(int visibility, long duration);

    boolean showOverflowMenu();
}
