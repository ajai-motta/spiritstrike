package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.emoji2.viewshelper.EmojiTextViewHelper;

/* JADX INFO: loaded from: classes10.dex */
class AppCompatEmojiTextHelper {
    private final EmojiTextViewHelper mEmojiTextViewHelper;
    private final TextView mView;

    AppCompatEmojiTextHelper(TextView view) {
        this.mView = view;
        this.mEmojiTextViewHelper = new EmojiTextViewHelper(view, false);
    }

    void loadFromAttributes(AttributeSet attrs, int defStyleAttr) {
        TypedArray typedArrayObtainStyledAttributes = this.mView.getContext().obtainStyledAttributes(attrs, R.styleable.AppCompatTextView, defStyleAttr, 0);
        try {
            boolean z = typedArrayObtainStyledAttributes.hasValue(R.styleable.AppCompatTextView_emojiCompatEnabled) ? typedArrayObtainStyledAttributes.getBoolean(R.styleable.AppCompatTextView_emojiCompatEnabled, true) : true;
            typedArrayObtainStyledAttributes.recycle();
            setEnabled(z);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    void setEnabled(boolean enabled) {
        this.mEmojiTextViewHelper.setEnabled(enabled);
    }

    public boolean isEnabled() {
        return this.mEmojiTextViewHelper.isEnabled();
    }

    InputFilter[] getFilters(InputFilter[] filters) {
        return this.mEmojiTextViewHelper.getFilters(filters);
    }

    void setAllCaps(boolean allCaps) {
        this.mEmojiTextViewHelper.setAllCaps(allCaps);
    }

    public TransformationMethod wrapTransformationMethod(TransformationMethod transformationMethod) {
        return this.mEmojiTextViewHelper.wrapTransformationMethod(transformationMethod);
    }
}
