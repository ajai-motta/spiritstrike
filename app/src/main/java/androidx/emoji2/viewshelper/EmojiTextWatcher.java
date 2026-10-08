package androidx.emoji2.viewshelper;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.emoji2.text.EmojiCompat;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
final class EmojiTextWatcher implements TextWatcher {
    private final EditText mEditText;
    private final boolean mExpectInitializedEmojiCompat;
    private EmojiCompat.InitCallback mInitCallback;
    private int mMaxEmojiCount = Integer.MAX_VALUE;
    private int mEmojiReplaceStrategy = 0;
    private boolean mEnabled = true;

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable s) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    EmojiTextWatcher(EditText editText, boolean expectInitializedEmojiCompat) {
        this.mEditText = editText;
        this.mExpectInitializedEmojiCompat = expectInitializedEmojiCompat;
    }

    void setMaxEmojiCount(int maxEmojiCount) {
        this.mMaxEmojiCount = maxEmojiCount;
    }

    int getMaxEmojiCount() {
        return this.mMaxEmojiCount;
    }

    int getEmojiReplaceStrategy() {
        return this.mEmojiReplaceStrategy;
    }

    void setEmojiReplaceStrategy(int replaceStrategy) {
        this.mEmojiReplaceStrategy = replaceStrategy;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, final int start, final int before, final int after) {
        if (this.mEditText.isInEditMode() || shouldSkipForDisabledOrNotConfigured() || before > after || !(charSequence instanceof Spannable)) {
            return;
        }
        int loadState = EmojiCompat.get().getLoadState();
        if (loadState != 0) {
            if (loadState == 1) {
                EmojiCompat.get().process((Spannable) charSequence, start, start + after, this.mMaxEmojiCount, this.mEmojiReplaceStrategy);
                return;
            } else if (loadState != 3) {
                return;
            }
        }
        EmojiCompat.get().registerInitCallback(getInitCallback());
    }

    private boolean shouldSkipForDisabledOrNotConfigured() {
        return (this.mEnabled && (this.mExpectInitializedEmojiCompat || EmojiCompat.isConfigured())) ? false : true;
    }

    private EmojiCompat.InitCallback getInitCallback() {
        if (this.mInitCallback == null) {
            this.mInitCallback = new InitCallbackImpl(this.mEditText);
        }
        return this.mInitCallback;
    }

    public boolean isEnabled() {
        return this.mEnabled;
    }

    public void setEnabled(boolean isEnabled) {
        if (this.mEnabled != isEnabled) {
            if (this.mInitCallback != null) {
                EmojiCompat.get().unregisterInitCallback(this.mInitCallback);
            }
            this.mEnabled = isEnabled;
            if (isEnabled) {
                processTextOnEnablingEvent(this.mEditText, EmojiCompat.get().getLoadState());
            }
        }
    }

    private static class InitCallbackImpl extends EmojiCompat.InitCallback {
        private final Reference<EditText> mViewRef;

        InitCallbackImpl(EditText editText) {
            this.mViewRef = new WeakReference(editText);
        }

        @Override // androidx.emoji2.text.EmojiCompat.InitCallback
        public void onInitialized() {
            super.onInitialized();
            EmojiTextWatcher.processTextOnEnablingEvent(this.mViewRef.get(), 1);
        }
    }

    static void processTextOnEnablingEvent(EditText editText, int currentLoadState) {
        if (currentLoadState == 1 && editText != null && editText.isAttachedToWindow()) {
            Editable editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            EmojiCompat.get().process(editableText);
            EmojiInputFilter.updateSelection(editableText, selectionStart, selectionEnd);
        }
    }
}
