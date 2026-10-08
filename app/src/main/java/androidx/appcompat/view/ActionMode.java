package androidx.appcompat.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* JADX INFO: loaded from: classes10.dex */
public abstract class ActionMode {
    private Object mTag;
    private boolean mTitleOptionalHint;

    public interface Callback {
        boolean onActionItemClicked(ActionMode mode, MenuItem item);

        boolean onCreateActionMode(ActionMode mode, Menu menu);

        void onDestroyActionMode(ActionMode mode);

        boolean onPrepareActionMode(ActionMode mode, Menu menu);
    }

    public abstract void finish();

    public abstract View getCustomView();

    public abstract Menu getMenu();

    public abstract MenuInflater getMenuInflater();

    public abstract CharSequence getSubtitle();

    public abstract CharSequence getTitle();

    public abstract void invalidate();

    public boolean isTitleOptional() {
        return false;
    }

    public boolean isUiFocusable() {
        return true;
    }

    public abstract void setCustomView(View view);

    public abstract void setSubtitle(int resId);

    public abstract void setSubtitle(CharSequence subtitle);

    public abstract void setTitle(int resId);

    public abstract void setTitle(CharSequence title);

    public void setTag(Object tag) {
        this.mTag = tag;
    }

    public Object getTag() {
        return this.mTag;
    }

    public void setTitleOptionalHint(boolean titleOptional) {
        this.mTitleOptionalHint = titleOptional;
    }

    public boolean getTitleOptionalHint() {
        return this.mTitleOptionalHint;
    }
}
