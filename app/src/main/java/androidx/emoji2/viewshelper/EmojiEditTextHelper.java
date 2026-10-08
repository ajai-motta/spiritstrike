package androidx.emoji2.viewshelper;

import android.text.method.KeyListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: classes2.dex */
public final class EmojiEditTextHelper {
    private int mEmojiReplaceStrategy;
    private final HelperInternal mHelper;
    private int mMaxEmojiCount;

    public EmojiEditTextHelper(final EditText editText) {
        this(editText, true);
    }

    public EmojiEditTextHelper(EditText editText, boolean expectInitializedEmojiCompat) {
        this.mMaxEmojiCount = Integer.MAX_VALUE;
        this.mEmojiReplaceStrategy = 0;
        Preconditions.checkNotNull(editText, "editText cannot be null");
        this.mHelper = new HelperInternal19(editText, expectInitializedEmojiCompat);
    }

    public void setMaxEmojiCount(int maxEmojiCount) {
        Preconditions.checkArgumentNonnegative(maxEmojiCount, "maxEmojiCount should be greater than 0");
        this.mMaxEmojiCount = maxEmojiCount;
        this.mHelper.setMaxEmojiCount(maxEmojiCount);
    }

    public int getMaxEmojiCount() {
        return this.mMaxEmojiCount;
    }

    public KeyListener getKeyListener(final KeyListener keyListener) {
        Preconditions.checkNotNull(keyListener, "keyListener cannot be null");
        return this.mHelper.getKeyListener(keyListener);
    }

    public InputConnection onCreateInputConnection(final InputConnection inputConnection, final EditorInfo outAttrs) {
        if (inputConnection == null) {
            return null;
        }
        return this.mHelper.onCreateInputConnection(inputConnection, outAttrs);
    }

    public void setEmojiReplaceStrategy(int replaceStrategy) {
        this.mEmojiReplaceStrategy = replaceStrategy;
        this.mHelper.setEmojiReplaceStrategy(replaceStrategy);
    }

    public int getEmojiReplaceStrategy() {
        return this.mEmojiReplaceStrategy;
    }

    public boolean isEnabled() {
        return this.mHelper.isEnabled();
    }

    public void setEnabled(boolean isEnabled) {
        this.mHelper.setEnabled(isEnabled);
    }

    static class HelperInternal {
        KeyListener getKeyListener(KeyListener keyListener) {
            return keyListener;
        }

        boolean isEnabled() {
            return false;
        }

        InputConnection onCreateInputConnection(InputConnection inputConnection, EditorInfo outAttrs) {
            return inputConnection;
        }

        void setEmojiReplaceStrategy(int replaceStrategy) {
        }

        void setEnabled(boolean isEnabled) {
        }

        void setMaxEmojiCount(int maxEmojiCount) {
        }

        HelperInternal() {
        }
    }

    private static class HelperInternal19 extends HelperInternal {
        private final EditText mEditText;
        private final EmojiTextWatcher mTextWatcher;

        HelperInternal19(EditText editText, boolean expectInitializedEmojiCompat) {
            this.mEditText = editText;
            EmojiTextWatcher emojiTextWatcher = new EmojiTextWatcher(editText, expectInitializedEmojiCompat);
            this.mTextWatcher = emojiTextWatcher;
            editText.addTextChangedListener(emojiTextWatcher);
            editText.setEditableFactory(EmojiEditableFactory.getInstance());
        }

        @Override // androidx.emoji2.viewshelper.EmojiEditTextHelper.HelperInternal
        void setMaxEmojiCount(int maxEmojiCount) {
            this.mTextWatcher.setMaxEmojiCount(maxEmojiCount);
        }

        @Override // androidx.emoji2.viewshelper.EmojiEditTextHelper.HelperInternal
        void setEmojiReplaceStrategy(int replaceStrategy) {
            this.mTextWatcher.setEmojiReplaceStrategy(replaceStrategy);
        }

        @Override // androidx.emoji2.viewshelper.EmojiEditTextHelper.HelperInternal
        KeyListener getKeyListener(final KeyListener keyListener) {
            return keyListener instanceof EmojiKeyListener ? keyListener : new EmojiKeyListener(keyListener);
        }

        @Override // androidx.emoji2.viewshelper.EmojiEditTextHelper.HelperInternal
        InputConnection onCreateInputConnection(final InputConnection inputConnection, final EditorInfo outAttrs) {
            return inputConnection instanceof EmojiInputConnection ? inputConnection : new EmojiInputConnection(this.mEditText, inputConnection, outAttrs);
        }

        @Override // androidx.emoji2.viewshelper.EmojiEditTextHelper.HelperInternal
        void setEnabled(boolean isEnabled) {
            this.mTextWatcher.setEnabled(isEnabled);
        }

        @Override // androidx.emoji2.viewshelper.EmojiEditTextHelper.HelperInternal
        boolean isEnabled() {
            return this.mTextWatcher.isEnabled();
        }
    }
}
