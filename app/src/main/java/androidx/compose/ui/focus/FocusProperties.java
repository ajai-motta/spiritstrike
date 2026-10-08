package androidx.compose.ui.focus;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import io.ktor.http.LinkHeader;
import kotlin.Metadata;

/* JADX INFO: compiled from: FocusProperties.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001b\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u000f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR$\u0010\u0012\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR$\u0010\u0015\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR$\u0010\u0018\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR$\u0010\u001b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000eR$\u0010\u001e\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000eR$\u0010!\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\"\u0010\f\"\u0004\b#\u0010\u000eø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006$À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/focus/FocusProperties;", "", "canFocus", "", "getCanFocus", "()Z", "setCanFocus", "(Z)V", "<anonymous parameter 0>", "Landroidx/compose/ui/focus/FocusRequester;", "down", "getDown", "()Landroidx/compose/ui/focus/FocusRequester;", "setDown", "(Landroidx/compose/ui/focus/FocusRequester;)V", TtmlNode.END, "getEnd", "setEnd", "left", "getLeft", "setLeft", LinkHeader.Rel.Next, "getNext", "setNext", "previous", "getPrevious", "setPrevious", TtmlNode.RIGHT, "getRight", "setRight", TtmlNode.START, "getStart", "setStart", "up", "getUp", "setUp", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface FocusProperties {
    boolean getCanFocus();

    FocusRequester getDown();

    FocusRequester getEnd();

    FocusRequester getLeft();

    FocusRequester getNext();

    FocusRequester getPrevious();

    FocusRequester getRight();

    FocusRequester getStart();

    FocusRequester getUp();

    void setCanFocus(boolean z);

    void setDown(FocusRequester focusRequester);

    void setEnd(FocusRequester focusRequester);

    void setLeft(FocusRequester focusRequester);

    void setNext(FocusRequester focusRequester);

    void setPrevious(FocusRequester focusRequester);

    void setRight(FocusRequester focusRequester);

    void setStart(FocusRequester focusRequester);

    void setUp(FocusRequester focusRequester);

    /* JADX INFO: renamed from: androidx.compose.ui.focus.FocusProperties$-CC, reason: invalid class name */
    /* JADX INFO: compiled from: FocusProperties.kt */
    public final /* synthetic */ class CC {
    }
}
