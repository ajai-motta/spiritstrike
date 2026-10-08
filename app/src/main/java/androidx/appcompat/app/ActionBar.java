package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SpinnerAdapter;
import androidx.appcompat.R;
import androidx.appcompat.view.ActionMode;
import androidx.fragment.app.FragmentTransaction;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes10.dex */
public abstract class ActionBar {
    public static final int DISPLAY_HOME_AS_UP = 4;
    public static final int DISPLAY_SHOW_CUSTOM = 16;
    public static final int DISPLAY_SHOW_HOME = 2;
    public static final int DISPLAY_SHOW_TITLE = 8;
    public static final int DISPLAY_USE_LOGO = 1;

    @Deprecated
    public static final int NAVIGATION_MODE_LIST = 1;

    @Deprecated
    public static final int NAVIGATION_MODE_STANDARD = 0;

    @Deprecated
    public static final int NAVIGATION_MODE_TABS = 2;

    @Retention(RetentionPolicy.SOURCE)
    public @interface DisplayOptions {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface NavigationMode {
    }

    public interface OnMenuVisibilityListener {
        void onMenuVisibilityChanged(boolean isVisible);
    }

    @Deprecated
    public interface OnNavigationListener {
        boolean onNavigationItemSelected(int itemPosition, long itemId);
    }

    @Deprecated
    public static abstract class Tab {
        public static final int INVALID_POSITION = -1;

        public abstract CharSequence getContentDescription();

        public abstract View getCustomView();

        public abstract Drawable getIcon();

        public abstract int getPosition();

        public abstract Object getTag();

        public abstract CharSequence getText();

        public abstract void select();

        public abstract Tab setContentDescription(int resId);

        public abstract Tab setContentDescription(CharSequence contentDesc);

        public abstract Tab setCustomView(int layoutResId);

        public abstract Tab setCustomView(View view);

        public abstract Tab setIcon(int resId);

        public abstract Tab setIcon(Drawable icon);

        public abstract Tab setTabListener(TabListener listener);

        public abstract Tab setTag(Object obj);

        public abstract Tab setText(int resId);

        public abstract Tab setText(CharSequence text);
    }

    @Deprecated
    public interface TabListener {
        void onTabReselected(Tab tab, FragmentTransaction ft);

        void onTabSelected(Tab tab, FragmentTransaction ft);

        void onTabUnselected(Tab tab, FragmentTransaction ft);
    }

    public abstract void addOnMenuVisibilityListener(OnMenuVisibilityListener listener);

    @Deprecated
    public abstract void addTab(Tab tab);

    @Deprecated
    public abstract void addTab(Tab tab, int position);

    @Deprecated
    public abstract void addTab(Tab tab, int position, boolean setSelected);

    @Deprecated
    public abstract void addTab(Tab tab, boolean setSelected);

    public boolean closeOptionsMenu() {
        return false;
    }

    public boolean collapseActionView() {
        return false;
    }

    public void dispatchMenuVisibilityChanged(boolean visible) {
    }

    public abstract View getCustomView();

    public abstract int getDisplayOptions();

    public float getElevation() {
        return 0.0f;
    }

    public abstract int getHeight();

    public int getHideOffset() {
        return 0;
    }

    @Deprecated
    public abstract int getNavigationItemCount();

    @Deprecated
    public abstract int getNavigationMode();

    @Deprecated
    public abstract int getSelectedNavigationIndex();

    @Deprecated
    public abstract Tab getSelectedTab();

    public abstract CharSequence getSubtitle();

    @Deprecated
    public abstract Tab getTabAt(int index);

    @Deprecated
    public abstract int getTabCount();

    public Context getThemedContext() {
        return null;
    }

    public abstract CharSequence getTitle();

    public abstract void hide();

    public boolean invalidateOptionsMenu() {
        return false;
    }

    public boolean isHideOnContentScrollEnabled() {
        return false;
    }

    public abstract boolean isShowing();

    public boolean isTitleTruncated() {
        return false;
    }

    @Deprecated
    public abstract Tab newTab();

    public void onConfigurationChanged(Configuration config) {
    }

    void onDestroy() {
    }

    public boolean onKeyShortcut(int keyCode, KeyEvent ev) {
        return false;
    }

    public boolean onMenuKeyEvent(KeyEvent event) {
        return false;
    }

    public boolean openOptionsMenu() {
        return false;
    }

    @Deprecated
    public abstract void removeAllTabs();

    public abstract void removeOnMenuVisibilityListener(OnMenuVisibilityListener listener);

    @Deprecated
    public abstract void removeTab(Tab tab);

    @Deprecated
    public abstract void removeTabAt(int position);

    boolean requestFocus() {
        return false;
    }

    @Deprecated
    public abstract void selectTab(Tab tab);

    public abstract void setBackgroundDrawable(Drawable d);

    public abstract void setCustomView(int resId);

    public abstract void setCustomView(View view);

    public abstract void setCustomView(View view, LayoutParams layoutParams);

    public void setDefaultDisplayHomeAsUpEnabled(boolean enabled) {
    }

    public abstract void setDisplayHomeAsUpEnabled(boolean showHomeAsUp);

    public abstract void setDisplayOptions(int options);

    public abstract void setDisplayOptions(int options, int mask);

    public abstract void setDisplayShowCustomEnabled(boolean showCustom);

    public abstract void setDisplayShowHomeEnabled(boolean showHome);

    public abstract void setDisplayShowTitleEnabled(boolean showTitle);

    public abstract void setDisplayUseLogoEnabled(boolean useLogo);

    public void setHomeActionContentDescription(int resId) {
    }

    public void setHomeActionContentDescription(CharSequence description) {
    }

    public void setHomeAsUpIndicator(int resId) {
    }

    public void setHomeAsUpIndicator(Drawable indicator) {
    }

    public void setHomeButtonEnabled(boolean enabled) {
    }

    public abstract void setIcon(int resId);

    public abstract void setIcon(Drawable icon);

    @Deprecated
    public abstract void setListNavigationCallbacks(SpinnerAdapter adapter, OnNavigationListener callback);

    public abstract void setLogo(int resId);

    public abstract void setLogo(Drawable logo);

    @Deprecated
    public abstract void setNavigationMode(int mode);

    @Deprecated
    public abstract void setSelectedNavigationItem(int position);

    public void setShowHideAnimationEnabled(boolean enabled) {
    }

    public void setSplitBackgroundDrawable(Drawable d) {
    }

    public void setStackedBackgroundDrawable(Drawable d) {
    }

    public abstract void setSubtitle(int resId);

    public abstract void setSubtitle(CharSequence subtitle);

    public abstract void setTitle(int resId);

    public abstract void setTitle(CharSequence title);

    public void setWindowTitle(CharSequence title) {
    }

    public abstract void show();

    public ActionMode startActionMode(ActionMode.Callback callback) {
        return null;
    }

    public void setHideOnContentScrollEnabled(boolean hideOnContentScroll) {
        if (hideOnContentScroll) {
            throw new UnsupportedOperationException("Hide on content scroll is not supported in this action bar configuration.");
        }
    }

    public void setHideOffset(int offset) {
        if (offset != 0) {
            throw new UnsupportedOperationException("Setting an explicit action bar hide offset is not supported in this action bar configuration.");
        }
    }

    public void setElevation(float elevation) {
        if (elevation != 0.0f) {
            throw new UnsupportedOperationException("Setting a non-zero elevation is not supported in this action bar configuration.");
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public int gravity;

        public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            this.gravity = 0;
            TypedArray typedArrayObtainStyledAttributes = c.obtainStyledAttributes(attrs, R.styleable.ActionBarLayout);
            this.gravity = typedArrayObtainStyledAttributes.getInt(R.styleable.ActionBarLayout_android_layout_gravity, 0);
            typedArrayObtainStyledAttributes.recycle();
        }

        public LayoutParams(int width, int height) {
            super(width, height);
            this.gravity = 8388627;
        }

        public LayoutParams(int width, int height, int gravity) {
            super(width, height);
            this.gravity = gravity;
        }

        public LayoutParams(int gravity) {
            this(-2, -1, gravity);
        }

        public LayoutParams(LayoutParams source) {
            super((ViewGroup.MarginLayoutParams) source);
            this.gravity = 0;
            this.gravity = source.gravity;
        }

        public LayoutParams(ViewGroup.LayoutParams source) {
            super(source);
            this.gravity = 0;
        }
    }
}
