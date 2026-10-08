package androidx.emoji2.text;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextPaint;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import androidx.core.graphics.PaintCompat;
import androidx.emoji2.text.EmojiCompat;
import androidx.emoji2.text.MetadataRepo;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
final class EmojiProcessor {
    private static final int ACTION_ADVANCE_BOTH = 1;
    private static final int ACTION_ADVANCE_END = 2;
    private static final int ACTION_FLUSH = 3;
    private final int[] mEmojiAsDefaultStyleExceptions;
    private EmojiCompat.GlyphChecker mGlyphChecker;
    private final MetadataRepo mMetadataRepo;
    private final EmojiCompat.SpanFactory mSpanFactory;
    private final boolean mUseEmojiAsDefaultStyle;

    private static boolean hasInvalidSelection(final int start, final int end) {
        return start == -1 || end == -1 || start != end;
    }

    EmojiProcessor(final MetadataRepo metadataRepo, final EmojiCompat.SpanFactory spanFactory, final EmojiCompat.GlyphChecker glyphChecker, final boolean useEmojiAsDefaultStyle, final int[] emojiAsDefaultStyleExceptions) {
        this.mSpanFactory = spanFactory;
        this.mMetadataRepo = metadataRepo;
        this.mGlyphChecker = glyphChecker;
        this.mUseEmojiAsDefaultStyle = useEmojiAsDefaultStyle;
        this.mEmojiAsDefaultStyleExceptions = emojiAsDefaultStyleExceptions;
    }

    EmojiMetadata getEmojiMetadata(final CharSequence charSequence) {
        ProcessorSm processorSm = new ProcessorSm(this.mMetadataRepo.getRootNode(), this.mUseEmojiAsDefaultStyle, this.mEmojiAsDefaultStyleExceptions);
        int length = charSequence.length();
        int iCharCount = 0;
        while (iCharCount < length) {
            int iCodePointAt = Character.codePointAt(charSequence, iCharCount);
            if (processorSm.check(iCodePointAt) != 2) {
                return null;
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        if (processorSm.isInFlushableState()) {
            return processorSm.getCurrentMetadata();
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x00f4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    java.lang.CharSequence process(java.lang.CharSequence r10, int r11, int r12, int r13, boolean r14) {
        /*
            Method dump skipped, instruction units count: 288
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.EmojiProcessor.process(java.lang.CharSequence, int, int, int, boolean):java.lang.CharSequence");
    }

    static boolean handleOnKeyDown(final Editable editable, final int keyCode, final KeyEvent event) {
        boolean zDelete;
        if (keyCode != 67) {
            if (keyCode == 112) {
                zDelete = delete(editable, event, true);
            }
            return false;
        }
        zDelete = delete(editable, event, false);
        if (zDelete) {
            MetaKeyKeyListener.adjustMetaAfterKeypress(editable);
            return true;
        }
        return false;
    }

    private static boolean delete(final Editable content, final KeyEvent event, final boolean forwardDelete) {
        EmojiSpan[] emojiSpanArr;
        if (hasModifiers(event)) {
            return false;
        }
        int selectionStart = Selection.getSelectionStart(content);
        int selectionEnd = Selection.getSelectionEnd(content);
        if (!hasInvalidSelection(selectionStart, selectionEnd) && (emojiSpanArr = (EmojiSpan[]) content.getSpans(selectionStart, selectionEnd, EmojiSpan.class)) != null && emojiSpanArr.length > 0) {
            for (EmojiSpan emojiSpan : emojiSpanArr) {
                int spanStart = content.getSpanStart(emojiSpan);
                int spanEnd = content.getSpanEnd(emojiSpan);
                if ((forwardDelete && spanStart == selectionStart) || ((!forwardDelete && spanEnd == selectionStart) || (selectionStart > spanStart && selectionStart < spanEnd))) {
                    content.delete(spanStart, spanEnd);
                    return true;
                }
            }
        }
        return false;
    }

    static boolean handleDeleteSurroundingText(final InputConnection inputConnection, final Editable editable, final int beforeLength, final int afterLength, final boolean inCodePoints) {
        int iMax;
        int iMin;
        if (editable != null && inputConnection != null && beforeLength >= 0 && afterLength >= 0) {
            int selectionStart = Selection.getSelectionStart(editable);
            int selectionEnd = Selection.getSelectionEnd(editable);
            if (hasInvalidSelection(selectionStart, selectionEnd)) {
                return false;
            }
            if (inCodePoints) {
                iMax = CodepointIndexFinder.findIndexBackward(editable, selectionStart, Math.max(beforeLength, 0));
                iMin = CodepointIndexFinder.findIndexForward(editable, selectionEnd, Math.max(afterLength, 0));
                if (iMax == -1 || iMin == -1) {
                    return false;
                }
            } else {
                iMax = Math.max(selectionStart - beforeLength, 0);
                iMin = Math.min(selectionEnd + afterLength, editable.length());
            }
            EmojiSpan[] emojiSpanArr = (EmojiSpan[]) editable.getSpans(iMax, iMin, EmojiSpan.class);
            if (emojiSpanArr != null && emojiSpanArr.length > 0) {
                for (EmojiSpan emojiSpan : emojiSpanArr) {
                    int spanStart = editable.getSpanStart(emojiSpan);
                    int spanEnd = editable.getSpanEnd(emojiSpan);
                    iMax = Math.min(spanStart, iMax);
                    iMin = Math.max(spanEnd, iMin);
                }
                int iMax2 = Math.max(iMax, 0);
                int iMin2 = Math.min(iMin, editable.length());
                inputConnection.beginBatchEdit();
                editable.delete(iMax2, iMin2);
                inputConnection.endBatchEdit();
                return true;
            }
        }
        return false;
    }

    private static boolean hasModifiers(KeyEvent event) {
        return !KeyEvent.metaStateHasNoModifiers(event.getMetaState());
    }

    private void addEmoji(final Spannable spannable, final EmojiMetadata metadata, final int start, final int end) {
        spannable.setSpan(this.mSpanFactory.createSpan(metadata), start, end, 33);
    }

    private boolean hasGlyph(final CharSequence charSequence, int start, final int end, final EmojiMetadata metadata) {
        if (metadata.getHasGlyph() == 0) {
            metadata.setHasGlyph(this.mGlyphChecker.hasGlyph(charSequence, start, end, metadata.getSdkAdded()));
        }
        return metadata.getHasGlyph() == 2;
    }

    static final class ProcessorSm {
        private static final int STATE_DEFAULT = 1;
        private static final int STATE_WALKING = 2;
        private int mCurrentDepth;
        private MetadataRepo.Node mCurrentNode;
        private final int[] mEmojiAsDefaultStyleExceptions;
        private MetadataRepo.Node mFlushNode;
        private int mLastCodepoint;
        private final MetadataRepo.Node mRootNode;
        private int mState = 1;
        private final boolean mUseEmojiAsDefaultStyle;

        private static boolean isEmojiStyle(int codePoint) {
            return codePoint == 65039;
        }

        private static boolean isTextStyle(int codePoint) {
            return codePoint == 65038;
        }

        ProcessorSm(MetadataRepo.Node rootNode, boolean useEmojiAsDefaultStyle, int[] emojiAsDefaultStyleExceptions) {
            this.mRootNode = rootNode;
            this.mCurrentNode = rootNode;
            this.mUseEmojiAsDefaultStyle = useEmojiAsDefaultStyle;
            this.mEmojiAsDefaultStyleExceptions = emojiAsDefaultStyleExceptions;
        }

        int check(final int codePoint) {
            MetadataRepo.Node node = this.mCurrentNode.get(codePoint);
            int iReset = 2;
            if (this.mState != 2) {
                if (node == null) {
                    iReset = reset();
                } else {
                    this.mState = 2;
                    this.mCurrentNode = node;
                    this.mCurrentDepth = 1;
                }
            } else if (node != null) {
                this.mCurrentNode = node;
                this.mCurrentDepth++;
            } else if (isTextStyle(codePoint)) {
                iReset = reset();
            } else if (!isEmojiStyle(codePoint)) {
                if (this.mCurrentNode.getData() != null) {
                    iReset = 3;
                    if (this.mCurrentDepth != 1 || shouldUseEmojiPresentationStyleForSingleCodepoint()) {
                        this.mFlushNode = this.mCurrentNode;
                        reset();
                    } else {
                        iReset = reset();
                    }
                } else {
                    iReset = reset();
                }
            }
            this.mLastCodepoint = codePoint;
            return iReset;
        }

        private int reset() {
            this.mState = 1;
            this.mCurrentNode = this.mRootNode;
            this.mCurrentDepth = 0;
            return 1;
        }

        EmojiMetadata getFlushMetadata() {
            return this.mFlushNode.getData();
        }

        EmojiMetadata getCurrentMetadata() {
            return this.mCurrentNode.getData();
        }

        boolean isInFlushableState() {
            return this.mState == 2 && this.mCurrentNode.getData() != null && (this.mCurrentDepth > 1 || shouldUseEmojiPresentationStyleForSingleCodepoint());
        }

        private boolean shouldUseEmojiPresentationStyleForSingleCodepoint() {
            if (this.mCurrentNode.getData().isDefaultEmoji() || isEmojiStyle(this.mLastCodepoint)) {
                return true;
            }
            if (this.mUseEmojiAsDefaultStyle) {
                if (this.mEmojiAsDefaultStyleExceptions == null) {
                    return true;
                }
                if (Arrays.binarySearch(this.mEmojiAsDefaultStyleExceptions, this.mCurrentNode.getData().getCodepointAt(0)) < 0) {
                    return true;
                }
            }
            return false;
        }
    }

    private static final class CodepointIndexFinder {
        private static final int INVALID_INDEX = -1;

        private CodepointIndexFinder() {
        }

        static int findIndexBackward(final CharSequence cs, final int from, final int numCodePoints) {
            int length = cs.length();
            if (from < 0 || length < from || numCodePoints < 0) {
                return -1;
            }
            while (true) {
                boolean z = false;
                while (numCodePoints != 0) {
                    from--;
                    if (from < 0) {
                        return z ? -1 : 0;
                    }
                    char cCharAt = cs.charAt(from);
                    if (z) {
                        if (!Character.isHighSurrogate(cCharAt)) {
                            return -1;
                        }
                        numCodePoints--;
                    } else if (!Character.isSurrogate(cCharAt)) {
                        numCodePoints--;
                    } else {
                        if (Character.isHighSurrogate(cCharAt)) {
                            return -1;
                        }
                        z = true;
                    }
                }
                return from;
            }
        }

        static int findIndexForward(final CharSequence cs, final int from, final int numCodePoints) {
            int length = cs.length();
            if (from < 0 || length < from || numCodePoints < 0) {
                return -1;
            }
            while (true) {
                boolean z = false;
                while (numCodePoints != 0) {
                    if (from >= length) {
                        if (z) {
                            return -1;
                        }
                        return length;
                    }
                    char cCharAt = cs.charAt(from);
                    if (z) {
                        if (!Character.isLowSurrogate(cCharAt)) {
                            return -1;
                        }
                        numCodePoints--;
                        from++;
                    } else if (!Character.isSurrogate(cCharAt)) {
                        numCodePoints--;
                        from++;
                    } else {
                        if (Character.isLowSurrogate(cCharAt)) {
                            return -1;
                        }
                        from++;
                        z = true;
                    }
                }
                return from;
            }
        }
    }

    public static class DefaultGlyphChecker implements EmojiCompat.GlyphChecker {
        private static final int PAINT_TEXT_SIZE = 10;
        private static final ThreadLocal<StringBuilder> sStringBuilder = new ThreadLocal<>();
        private final TextPaint mTextPaint;

        DefaultGlyphChecker() {
            TextPaint textPaint = new TextPaint();
            this.mTextPaint = textPaint;
            textPaint.setTextSize(10.0f);
        }

        @Override // androidx.emoji2.text.EmojiCompat.GlyphChecker
        public boolean hasGlyph(CharSequence charSequence, int start, int end, int sdkAdded) {
            StringBuilder stringBuilder = getStringBuilder();
            stringBuilder.setLength(0);
            while (start < end) {
                stringBuilder.append(charSequence.charAt(start));
                start++;
            }
            return PaintCompat.hasGlyph(this.mTextPaint, stringBuilder.toString());
        }

        private static StringBuilder getStringBuilder() {
            ThreadLocal<StringBuilder> threadLocal = sStringBuilder;
            if (threadLocal.get() == null) {
                threadLocal.set(new StringBuilder());
            }
            return threadLocal.get();
        }
    }
}
