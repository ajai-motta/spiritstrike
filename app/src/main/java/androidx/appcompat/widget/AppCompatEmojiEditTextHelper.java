package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.appcompat.R;
import androidx.emoji2.viewshelper.EmojiEditTextHelper;

/* JADX INFO: loaded from: classes10.dex */
class AppCompatEmojiEditTextHelper {
    private final EmojiEditTextHelper mEmojiEditTextHelper;
    private final EditText mView;

    AppCompatEmojiEditTextHelper(EditText view) {
        this.mView = view;
        this.mEmojiEditTextHelper = new EmojiEditTextHelper(view, false);
    }

    void loadFromAttributes(AttributeSet attrs, int defStyleAttr) {
        TypedArray typedArrayObtainStyledAttributes = this.mView.getContext().obtainStyledAttributes(attrs, R.styleable.AppCompatTextView, defStyleAttr, 0);
        try {
            boolean z = typedArrayObtainStyledAttributes.hasValue(R.styleable.AppCompatTextView_emojiCompatEnabled) ? typedArrayObtainStyledAttributes.getBoolean(R.styleable.AppCompatTextView_emojiCompatEnabled, true) : true;
            typedArrayObtainStyledAttributes.recycle();
            EditText editText = this.mView;
            editText.setKeyListener(this.mEmojiEditTextHelper.getKeyListener(editText.getKeyListener()));
            setEnabled(z);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    void initKeyListener() {
        EditText editText = this.mView;
        editText.setKeyListener(editText.getKeyListener());
    }

    void setEnabled(boolean enabled) {
        this.mEmojiEditTextHelper.setEnabled(enabled);
    }

    boolean isEnabled() {
        return this.mEmojiEditTextHelper.isEnabled();
    }

    KeyListener getKeyListener(KeyListener keyListener) {
        return this.mEmojiEditTextHelper.getKeyListener(keyListener);
    }

    InputConnection onCreateInputConnection(InputConnection inputConnection, EditorInfo outAttrs) {
        return this.mEmojiEditTextHelper.onCreateInputConnection(inputConnection, outAttrs);
    }
}
