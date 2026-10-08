package androidx.compose.ui.text.input;

import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;

/* JADX INFO: compiled from: EditingBuffer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a%\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0006"}, d2 = {"updateRangeAfterDelete", "Landroidx/compose/ui/text/TextRange;", TypedValues.AttributesType.S_TARGET, "deleted", "updateRangeAfterDelete-pWDy79M", "(JJ)J", "ui-text_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class EditingBufferKt {
    /* JADX INFO: renamed from: updateRangeAfterDelete-pWDy79M, reason: not valid java name */
    public static final long m3644updateRangeAfterDeletepWDy79M(long j, long j2) {
        int iM3515getLengthimpl;
        int iM3517getMinimpl = TextRange.m3517getMinimpl(j);
        int iM3516getMaximpl = TextRange.m3516getMaximpl(j);
        if (TextRange.m3521intersects5zctL8(j2, j)) {
            if (TextRange.m3509contains5zctL8(j2, j)) {
                iM3517getMinimpl = TextRange.m3517getMinimpl(j2);
                iM3516getMaximpl = iM3517getMinimpl;
            } else {
                if (TextRange.m3509contains5zctL8(j, j2)) {
                    iM3515getLengthimpl = TextRange.m3515getLengthimpl(j2);
                } else if (TextRange.m3510containsimpl(j2, iM3517getMinimpl)) {
                    iM3517getMinimpl = TextRange.m3517getMinimpl(j2);
                    iM3515getLengthimpl = TextRange.m3515getLengthimpl(j2);
                } else {
                    iM3516getMaximpl = TextRange.m3517getMinimpl(j2);
                }
                iM3516getMaximpl -= iM3515getLengthimpl;
            }
        } else if (iM3516getMaximpl > TextRange.m3517getMinimpl(j2)) {
            iM3517getMinimpl -= TextRange.m3515getLengthimpl(j2);
            iM3515getLengthimpl = TextRange.m3515getLengthimpl(j2);
            iM3516getMaximpl -= iM3515getLengthimpl;
        }
        return TextRangeKt.TextRange(iM3517getMinimpl, iM3516getMaximpl);
    }
}
