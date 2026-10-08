package androidx.appcompat.app;

import androidx.appcompat.view.ActionMode;

/* JADX INFO: loaded from: classes10.dex */
public interface AppCompatCallback {
    void onSupportActionModeFinished(ActionMode mode);

    void onSupportActionModeStarted(ActionMode mode);

    ActionMode onWindowStartingSupportActionMode(ActionMode.Callback callback);
}
