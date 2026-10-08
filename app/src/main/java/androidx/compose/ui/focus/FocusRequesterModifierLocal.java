package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.modifier.ModifierLocalReadScope;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FocusRequesterModifier.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\bJ\u0014\u0010\u0016\u001a\u00020\u00142\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\b\u0010\u0018\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u000e\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\bJ\u0014\u0010\u001d\u001a\u00020\u00142\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u0007R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Landroidx/compose/ui/focus/FocusRequesterModifierLocal;", "Landroidx/compose/ui/modifier/ModifierLocalConsumer;", "Landroidx/compose/ui/modifier/ModifierLocalProvider;", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "(Landroidx/compose/ui/focus/FocusRequester;)V", "focusModifiers", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/focus/FocusModifier;", "getFocusRequester", "()Landroidx/compose/ui/focus/FocusRequester;", "key", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "getKey", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "parent", "value", "getValue", "()Landroidx/compose/ui/focus/FocusRequesterModifierLocal;", "addFocusModifier", "", "focusModifier", "addFocusModifiers", "newModifiers", "findFocusNode", "onModifierLocalsUpdated", "scope", "Landroidx/compose/ui/modifier/ModifierLocalReadScope;", "removeFocusModifier", "removeFocusModifiers", "removedModifiers", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FocusRequesterModifierLocal implements ModifierLocalConsumer, ModifierLocalProvider<FocusRequesterModifierLocal> {
    private final MutableVector<FocusModifier> focusModifiers;
    private final FocusRequester focusRequester;
    private FocusRequesterModifierLocal parent;

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ boolean all(Function1 function1) {
        return Modifier.Element.CC.$default$all(this, function1);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ boolean any(Function1 function1) {
        return Modifier.Element.CC.$default$any(this, function1);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ Object foldIn(Object obj, Function2 function2) {
        return Modifier.Element.CC.$default$foldIn(this, obj, function2);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ Object foldOut(Object obj, Function2 function2) {
        return Modifier.Element.CC.$default$foldOut(this, obj, function2);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.compose.ui.modifier.ModifierLocalProvider
    public FocusRequesterModifierLocal getValue() {
        return this;
    }

    @Override // androidx.compose.ui.Modifier
    public /* synthetic */ Modifier then(Modifier modifier) {
        return Modifier.CC.$default$then(this, modifier);
    }

    public FocusRequesterModifierLocal(FocusRequester focusRequester) {
        Intrinsics.checkNotNullParameter(focusRequester, "focusRequester");
        this.focusRequester = focusRequester;
        this.focusModifiers = new MutableVector<>(new FocusModifier[16], 0);
        focusRequester.getFocusRequesterModifierLocals$ui_release().add(this);
    }

    public final FocusRequester getFocusRequester() {
        return this.focusRequester;
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalConsumer
    public void onModifierLocalsUpdated(ModifierLocalReadScope scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        FocusRequesterModifierLocal focusRequesterModifierLocal = (FocusRequesterModifierLocal) scope.getCurrent(FocusRequesterModifierKt.getModifierLocalFocusRequester());
        if (Intrinsics.areEqual(focusRequesterModifierLocal, this.parent)) {
            return;
        }
        FocusRequesterModifierLocal focusRequesterModifierLocal2 = this.parent;
        if (focusRequesterModifierLocal2 != null) {
            focusRequesterModifierLocal2.removeFocusModifiers(this.focusModifiers);
        }
        if (focusRequesterModifierLocal != null) {
            focusRequesterModifierLocal.addFocusModifiers(this.focusModifiers);
        }
        this.parent = focusRequesterModifierLocal;
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalProvider
    public ProvidableModifierLocal<FocusRequesterModifierLocal> getKey() {
        return FocusRequesterModifierKt.getModifierLocalFocusRequester();
    }

    public final void addFocusModifier(FocusModifier focusModifier) {
        Intrinsics.checkNotNullParameter(focusModifier, "focusModifier");
        this.focusModifiers.add(focusModifier);
        FocusRequesterModifierLocal focusRequesterModifierLocal = this.parent;
        if (focusRequesterModifierLocal != null) {
            focusRequesterModifierLocal.addFocusModifier(focusModifier);
        }
    }

    public final void addFocusModifiers(MutableVector<FocusModifier> newModifiers) {
        Intrinsics.checkNotNullParameter(newModifiers, "newModifiers");
        MutableVector<FocusModifier> mutableVector = this.focusModifiers;
        mutableVector.addAll(mutableVector.getSize(), newModifiers);
        FocusRequesterModifierLocal focusRequesterModifierLocal = this.parent;
        if (focusRequesterModifierLocal != null) {
            focusRequesterModifierLocal.addFocusModifiers(newModifiers);
        }
    }

    public final void removeFocusModifier(FocusModifier focusModifier) {
        Intrinsics.checkNotNullParameter(focusModifier, "focusModifier");
        this.focusModifiers.remove(focusModifier);
        FocusRequesterModifierLocal focusRequesterModifierLocal = this.parent;
        if (focusRequesterModifierLocal != null) {
            focusRequesterModifierLocal.removeFocusModifier(focusModifier);
        }
    }

    public final void removeFocusModifiers(MutableVector<FocusModifier> removedModifiers) {
        Intrinsics.checkNotNullParameter(removedModifiers, "removedModifiers");
        this.focusModifiers.removeAll(removedModifiers);
        FocusRequesterModifierLocal focusRequesterModifierLocal = this.parent;
        if (focusRequesterModifierLocal != null) {
            focusRequesterModifierLocal.removeFocusModifiers(removedModifiers);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0088  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final androidx.compose.ui.focus.FocusModifier findFocusNode() {
        /*
            r9 = this;
            androidx.compose.runtime.collection.MutableVector<androidx.compose.ui.focus.FocusModifier> r0 = r9.focusModifiers
            r1 = 0
            r2 = r1
            androidx.compose.ui.focus.FocusModifier r2 = (androidx.compose.ui.focus.FocusModifier) r2
            int r2 = r0.getSize()
            if (r2 <= 0) goto L8d
            java.lang.Object[] r0 = r0.getContent()
            r3 = 0
        L11:
            r4 = r0[r3]
            androidx.compose.ui.focus.FocusModifier r4 = (androidx.compose.ui.focus.FocusModifier) r4
            if (r1 == 0) goto L88
            androidx.compose.ui.node.LayoutNodeWrapper r5 = r1.getLayoutNodeWrapper()
            if (r5 == 0) goto L88
            androidx.compose.ui.node.LayoutNode r5 = r5.getLayoutNode()
            if (r5 != 0) goto L24
            goto L88
        L24:
            androidx.compose.ui.node.LayoutNodeWrapper r6 = r4.getLayoutNodeWrapper()
            if (r6 == 0) goto L89
            androidx.compose.ui.node.LayoutNode r6 = r6.getLayoutNode()
            if (r6 != 0) goto L31
            goto L89
        L31:
            int r7 = r5.getDepth()
            int r8 = r6.getDepth()
            if (r7 <= r8) goto L43
            androidx.compose.ui.node.LayoutNode r5 = r5.getParent$ui_release()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            goto L31
        L43:
            int r7 = r6.getDepth()
            int r8 = r5.getDepth()
            if (r7 <= r8) goto L55
            androidx.compose.ui.node.LayoutNode r6 = r6.getParent$ui_release()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            goto L43
        L55:
            androidx.compose.ui.node.LayoutNode r7 = r5.getParent$ui_release()
            androidx.compose.ui.node.LayoutNode r8 = r6.getParent$ui_release()
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual(r7, r8)
            if (r7 != 0) goto L72
            androidx.compose.ui.node.LayoutNode r5 = r5.getParent$ui_release()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            androidx.compose.ui.node.LayoutNode r6 = r6.getParent$ui_release()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            goto L55
        L72:
            androidx.compose.ui.node.LayoutNode r7 = r5.getParent$ui_release()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            androidx.compose.runtime.collection.MutableVector r7 = r7.get_children$ui_release()
            int r5 = r7.indexOf(r5)
            int r6 = r7.indexOf(r6)
            if (r5 >= r6) goto L88
            goto L89
        L88:
            r1 = r4
        L89:
            int r3 = r3 + 1
            if (r3 < r2) goto L11
        L8d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusRequesterModifierLocal.findFocusNode():androidx.compose.ui.focus.FocusModifier");
    }
}
