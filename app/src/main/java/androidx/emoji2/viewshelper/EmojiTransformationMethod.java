package androidx.emoji2.viewshelper;

import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import androidx.emoji2.text.EmojiCompat;

/* JADX INFO: loaded from: classes2.dex */
class EmojiTransformationMethod implements TransformationMethod {
    private final TransformationMethod mTransformationMethod;

    EmojiTransformationMethod(TransformationMethod transformationMethod) {
        this.mTransformationMethod = transformationMethod;
    }

    @Override // android.text.method.TransformationMethod
    public CharSequence getTransformation(CharSequence source, final View view) {
        if (view.isInEditMode()) {
            return source;
        }
        TransformationMethod transformationMethod = this.mTransformationMethod;
        if (transformationMethod != null) {
            source = transformationMethod.getTransformation(source, view);
        }
        return (source == null || EmojiCompat.get().getLoadState() != 1) ? source : EmojiCompat.get().process(source);
    }

    @Override // android.text.method.TransformationMethod
    public void onFocusChanged(final View view, final CharSequence sourceText, final boolean focused, final int direction, final Rect previouslyFocusedRect) {
        TransformationMethod transformationMethod = this.mTransformationMethod;
        if (transformationMethod != null) {
            transformationMethod.onFocusChanged(view, sourceText, focused, direction, previouslyFocusedRect);
        }
    }

    public TransformationMethod getOriginalTransformationMethod() {
        return this.mTransformationMethod;
    }
}
