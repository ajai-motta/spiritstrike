package androidx.emoji2.viewshelper;

import android.text.InputFilter;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.widget.TextView;
import androidx.emoji2.text.EmojiCompat;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
final class EmojiInputFilter implements InputFilter {
    private EmojiCompat.InitCallback mInitCallback;
    private final TextView mTextView;

    EmojiInputFilter(final TextView textView) {
        this.mTextView = textView;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(final CharSequence source, final int sourceStart, final int sourceEnd, final Spanned dest, final int destStart, final int destEnd) {
        if (this.mTextView.isInEditMode()) {
            return source;
        }
        int loadState = EmojiCompat.get().getLoadState();
        if (loadState != 0) {
            if (loadState == 1) {
                if ((destEnd == 0 && destStart == 0 && dest.length() == 0 && source == this.mTextView.getText()) || source == null) {
                    return source;
                }
                if (sourceStart != 0 || sourceEnd != source.length()) {
                    source = source.subSequence(sourceStart, sourceEnd);
                }
                return EmojiCompat.get().process(source, 0, source.length());
            }
            if (loadState != 3) {
                return source;
            }
        }
        EmojiCompat.get().registerInitCallback(getInitCallback());
        return source;
    }

    private EmojiCompat.InitCallback getInitCallback() {
        if (this.mInitCallback == null) {
            this.mInitCallback = new InitCallbackImpl(this.mTextView);
        }
        return this.mInitCallback;
    }

    private static class InitCallbackImpl extends EmojiCompat.InitCallback {
        private final Reference<TextView> mViewRef;

        InitCallbackImpl(TextView textView) {
            this.mViewRef = new WeakReference(textView);
        }

        @Override // androidx.emoji2.text.EmojiCompat.InitCallback
        public void onInitialized() {
            super.onInitialized();
            TextView textView = this.mViewRef.get();
            if (textView == null || !textView.isAttachedToWindow()) {
                return;
            }
            CharSequence charSequenceProcess = EmojiCompat.get().process(textView.getText());
            int selectionStart = Selection.getSelectionStart(charSequenceProcess);
            int selectionEnd = Selection.getSelectionEnd(charSequenceProcess);
            textView.setText(charSequenceProcess);
            if (charSequenceProcess instanceof Spannable) {
                EmojiInputFilter.updateSelection((Spannable) charSequenceProcess, selectionStart, selectionEnd);
            }
        }
    }

    static void updateSelection(Spannable spannable, final int start, final int end) {
        if (start >= 0 && end >= 0) {
            Selection.setSelection(spannable, start, end);
        } else if (start >= 0) {
            Selection.setSelection(spannable, start);
        } else if (end >= 0) {
            Selection.setSelection(spannable, end);
        }
    }
}
