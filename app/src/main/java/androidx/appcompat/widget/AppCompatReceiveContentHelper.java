package androidx.appcompat.widget;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Bundle;
import android.text.Selection;
import android.text.Spannable;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.view.inputmethod.InputContentInfo;
import android.widget.TextView;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.inputmethod.InputConnectionCompat;
import androidx.core.view.inputmethod.InputContentInfoCompat;

/* JADX INFO: loaded from: classes10.dex */
final class AppCompatReceiveContentHelper {
    private static final String EXTRA_INPUT_CONTENT_INFO = "androidx.core.view.extra.INPUT_CONTENT_INFO";
    private static final String LOG_TAG = "ReceiveContent";

    private AppCompatReceiveContentHelper() {
    }

    static boolean maybeHandleMenuActionViaPerformReceiveContent(TextView view, int menuItemId) {
        if ((menuItemId != 16908322 && menuItemId != 16908337) || ViewCompat.getOnReceiveContentMimeTypes(view) == null) {
            return false;
        }
        ClipboardManager clipboardManager = (ClipboardManager) view.getContext().getSystemService("clipboard");
        ClipData primaryClip = clipboardManager == null ? null : clipboardManager.getPrimaryClip();
        if (primaryClip != null && primaryClip.getItemCount() > 0) {
            ViewCompat.performReceiveContent(view, new ContentInfoCompat.Builder(primaryClip, 1).setFlags(menuItemId != 16908322 ? 1 : 0).build());
        }
        return true;
    }

    static boolean maybeHandleDragEventViaPerformReceiveContent(View view, DragEvent event) {
        if (Build.VERSION.SDK_INT >= 24 && event.getLocalState() == null && ViewCompat.getOnReceiveContentMimeTypes(view) != null) {
            Activity activityTryGetActivity = tryGetActivity(view);
            if (activityTryGetActivity == null) {
                Log.i(LOG_TAG, "Can't handle drop: no activity: view=" + view);
                return false;
            }
            if (event.getAction() == 1) {
                return !(view instanceof TextView);
            }
            if (event.getAction() == 3) {
                if (view instanceof TextView) {
                    return OnDropApi24Impl.onDropForTextView(event, (TextView) view, activityTryGetActivity);
                }
                return OnDropApi24Impl.onDropForView(event, view, activityTryGetActivity);
            }
        }
        return false;
    }

    private static final class OnDropApi24Impl {
        private OnDropApi24Impl() {
        }

        static boolean onDropForTextView(DragEvent event, TextView view, Activity activity) {
            activity.requestDragAndDropPermissions(event);
            int offsetForPosition = view.getOffsetForPosition(event.getX(), event.getY());
            view.beginBatchEdit();
            try {
                Selection.setSelection((Spannable) view.getText(), offsetForPosition);
                ViewCompat.performReceiveContent(view, new ContentInfoCompat.Builder(event.getClipData(), 3).build());
                view.endBatchEdit();
                return true;
            } catch (Throwable th) {
                view.endBatchEdit();
                throw th;
            }
        }

        static boolean onDropForView(DragEvent event, View view, Activity activity) {
            activity.requestDragAndDropPermissions(event);
            ViewCompat.performReceiveContent(view, new ContentInfoCompat.Builder(event.getClipData(), 3).build());
            return true;
        }
    }

    static Activity tryGetActivity(View view) {
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }

    static InputConnectionCompat.OnCommitContentListener createOnCommitContentListener(final View view) {
        return new InputConnectionCompat.OnCommitContentListener() { // from class: androidx.appcompat.widget.AppCompatReceiveContentHelper.1
            @Override // androidx.core.view.inputmethod.InputConnectionCompat.OnCommitContentListener
            public boolean onCommitContent(InputContentInfoCompat inputContentInfo, int flags, Bundle opts) {
                if (Build.VERSION.SDK_INT >= 25 && (flags & 1) != 0) {
                    try {
                        inputContentInfo.requestPermission();
                        InputContentInfo inputContentInfo2 = (InputContentInfo) inputContentInfo.unwrap();
                        opts = opts == null ? new Bundle() : new Bundle(opts);
                        opts.putParcelable(AppCompatReceiveContentHelper.EXTRA_INPUT_CONTENT_INFO, inputContentInfo2);
                    } catch (Exception e) {
                        Log.w(AppCompatReceiveContentHelper.LOG_TAG, "Can't insert content from IME; requestPermission() failed", e);
                        return false;
                    }
                }
                return ViewCompat.performReceiveContent(view, new ContentInfoCompat.Builder(new ClipData(inputContentInfo.getDescription(), new ClipData.Item(inputContentInfo.getContentUri())), 2).setLinkUri(inputContentInfo.getLinkUri()).setExtras(opts).build()) == null;
            }
        };
    }
}
