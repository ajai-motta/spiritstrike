package androidx.emoji2.viewshelper;

import android.text.Editable;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.TextView;
import androidx.emoji2.text.EmojiCompat;

/* JADX INFO: loaded from: classes2.dex */
final class EmojiInputConnection extends InputConnectionWrapper {
    private final EmojiCompatDeleteHelper mEmojiCompatDeleteHelper;
    private final TextView mTextView;

    EmojiInputConnection(final TextView textView, final InputConnection inputConnection, final EditorInfo outAttrs) {
        this(textView, inputConnection, outAttrs, new EmojiCompatDeleteHelper());
    }

    EmojiInputConnection(final TextView textView, final InputConnection inputConnection, final EditorInfo outAttrs, final EmojiCompatDeleteHelper emojiCompatDeleteHelper) {
        super(inputConnection, false);
        this.mTextView = textView;
        this.mEmojiCompatDeleteHelper = emojiCompatDeleteHelper;
        emojiCompatDeleteHelper.updateEditorInfoAttrs(outAttrs);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingText(final int beforeLength, final int afterLength) {
        return this.mEmojiCompatDeleteHelper.handleDeleteSurroundingText(this, getEditable(), beforeLength, afterLength, false) || super.deleteSurroundingText(beforeLength, afterLength);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingTextInCodePoints(final int beforeLength, final int afterLength) {
        return this.mEmojiCompatDeleteHelper.handleDeleteSurroundingText(this, getEditable(), beforeLength, afterLength, true) || super.deleteSurroundingTextInCodePoints(beforeLength, afterLength);
    }

    private Editable getEditable() {
        return this.mTextView.getEditableText();
    }

    public static class EmojiCompatDeleteHelper {
        public boolean handleDeleteSurroundingText(final InputConnection inputConnection, final Editable editable, final int beforeLength, final int afterLength, final boolean inCodePoints) {
            return EmojiCompat.handleDeleteSurroundingText(inputConnection, editable, beforeLength, afterLength, inCodePoints);
        }

        public void updateEditorInfoAttrs(final EditorInfo outAttrs) {
            if (EmojiCompat.isConfigured()) {
                EmojiCompat.get().updateEditorInfoAttrs(outAttrs);
            }
        }
    }
}
