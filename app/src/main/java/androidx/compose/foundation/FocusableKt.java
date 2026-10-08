package androidx.compose.foundation;

import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.lazy.layout.PinnableParent;
import androidx.compose.foundation.relocation.BringIntoViewRequester;
import androidx.compose.foundation.relocation.BringIntoViewRequesterKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusChangedModifierKt;
import androidx.compose.ui.focus.FocusModifierKt;
import androidx.compose.ui.focus.FocusProperties;
import androidx.compose.ui.focus.FocusPropertiesKt;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.input.InputMode;
import androidx.compose.ui.input.InputModeManager;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectableModifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* JADX INFO: compiled from: Focusable.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u001a\f\u0010\u0002\u001a\u00020\u0003*\u00020\u0003H\u0007\u001a \u0010\u0004\u001a\u00020\u0003*\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u001a\u001e\u0010\t\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0000\u001a\"\u0010\n\u001a\u00020\u0003*\u00020\u00032\u0014\u0010\n\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\r0\u000bH\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"focusGroupInspectorInfo", "Landroidx/compose/ui/platform/InspectableModifier;", "focusGroup", "Landroidx/compose/ui/Modifier;", "focusable", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "focusableInNonTouchMode", "onPinnableParentAvailable", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/layout/PinnableParent;", "", "foundation_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class FocusableKt {
    private static final InspectableModifier focusGroupInspectorInfo;

    public static /* synthetic */ Modifier focusable$default(Modifier modifier, boolean z, MutableInteractionSource mutableInteractionSource, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            mutableInteractionSource = null;
        }
        return focusable(modifier, z, mutableInteractionSource);
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.FocusableKt$focusable$2, reason: invalid class name */
    /* JADX INFO: compiled from: Focusable.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class AnonymousClass2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ MutableInteractionSource $interactionSource;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(MutableInteractionSource mutableInteractionSource, boolean z) {
            super(3);
            this.$interactionSource = mutableInteractionSource;
            this.$enabled = z;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
            return invoke(modifier, composer, num.intValue());
        }

        public final Modifier invoke(Modifier composed, Composer composer, int i) {
            Modifier.Companion companionFocusTarget;
            Modifier.Companion companion;
            Intrinsics.checkNotNullParameter(composed, "$this$composed");
            composer.startReplaceableGroup(1871352361);
            ComposerKt.sourceInformation(composer, "C73@3129L24,74@3183L58,75@3268L50,76@3340L34,77@3400L29,89@4173L37,90@4215L316,99@4536L390,114@5011L36:Focusable.kt#71ulvw");
            composer.startReplaceableGroup(773894976);
            ComposerKt.sourceInformation(composer, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
            composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composer, "C(remember):Composables.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer));
                composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                objRememberedValue = compositionScopedCoroutineScopeCanceller;
            }
            composer.endReplaceableGroup();
            final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
            composer.endReplaceableGroup();
            composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composer, "C(remember):Composables.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composer.updateRememberedValue(objRememberedValue2);
            }
            composer.endReplaceableGroup();
            final MutableState mutableState = (MutableState) objRememberedValue2;
            composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composer, "C(remember):Composables.kt#9igjgp");
            Object objRememberedValue3 = composer.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composer.updateRememberedValue(objRememberedValue3);
            }
            composer.endReplaceableGroup();
            final MutableState mutableState2 = (MutableState) objRememberedValue3;
            composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composer, "C(remember):Composables.kt#9igjgp");
            Object objRememberedValue4 = composer.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composer.updateRememberedValue(objRememberedValue4);
            }
            composer.endReplaceableGroup();
            final MutableState mutableState3 = (MutableState) objRememberedValue4;
            composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composer, "C(remember):Composables.kt#9igjgp");
            Object objRememberedValue5 = composer.rememberedValue();
            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = new FocusRequester();
                composer.updateRememberedValue(objRememberedValue5);
            }
            composer.endReplaceableGroup();
            final FocusRequester focusRequester = (FocusRequester) objRememberedValue5;
            composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composer, "C(remember):Composables.kt#9igjgp");
            Object objRememberedValue6 = composer.rememberedValue();
            if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue6 = BringIntoViewRequesterKt.BringIntoViewRequester();
                composer.updateRememberedValue(objRememberedValue6);
            }
            composer.endReplaceableGroup();
            final BringIntoViewRequester bringIntoViewRequester = (BringIntoViewRequester) objRememberedValue6;
            MutableInteractionSource mutableInteractionSource = this.$interactionSource;
            final MutableInteractionSource mutableInteractionSource2 = this.$interactionSource;
            EffectsKt.DisposableEffect(mutableInteractionSource, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.FocusableKt.focusable.2.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                    Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                    final MutableState<FocusInteraction.Focus> mutableState4 = mutableState;
                    final MutableInteractionSource mutableInteractionSource3 = mutableInteractionSource2;
                    return new DisposableEffectResult() { // from class: androidx.compose.foundation.FocusableKt$focusable$2$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            FocusInteraction.Focus focus = (FocusInteraction.Focus) mutableState4.getValue();
                            if (focus != null) {
                                FocusInteraction.Unfocus unfocus = new FocusInteraction.Unfocus(focus);
                                MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource3;
                                if (mutableInteractionSource4 != null) {
                                    mutableInteractionSource4.tryEmit(unfocus);
                                }
                                mutableState4.setValue(null);
                            }
                        }
                    };
                }
            }, composer, 0);
            Boolean boolValueOf = Boolean.valueOf(this.$enabled);
            final boolean z = this.$enabled;
            final MutableInteractionSource mutableInteractionSource3 = this.$interactionSource;
            EffectsKt.DisposableEffect(boolValueOf, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.FocusableKt.focusable.2.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                    Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                    if (!z) {
                        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(mutableState, mutableInteractionSource3, null), 3, null);
                    }
                    return new DisposableEffectResult() { // from class: androidx.compose.foundation.FocusableKt$focusable$2$2$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                        }
                    };
                }

                /* JADX INFO: renamed from: androidx.compose.foundation.FocusableKt$focusable$2$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: Focusable.kt */
                @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                @DebugMetadata(c = "androidx.compose.foundation.FocusableKt$focusable$2$2$1", f = "Focusable.kt", i = {}, l = {105}, m = "invokeSuspend", n = {}, s = {})
                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ MutableState<FocusInteraction.Focus> $focusedInteraction;
                    final /* synthetic */ MutableInteractionSource $interactionSource;
                    Object L$0;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(MutableState<FocusInteraction.Focus> mutableState, MutableInteractionSource mutableInteractionSource, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.$focusedInteraction = mutableState;
                        this.$interactionSource = mutableInteractionSource;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass1(this.$focusedInteraction, this.$interactionSource, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) throws Throwable {
                        MutableState<FocusInteraction.Focus> mutableState;
                        MutableState<FocusInteraction.Focus> mutableState2;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            FocusInteraction.Focus value = this.$focusedInteraction.getValue();
                            if (value != null) {
                                MutableInteractionSource mutableInteractionSource = this.$interactionSource;
                                mutableState = this.$focusedInteraction;
                                FocusInteraction.Unfocus unfocus = new FocusInteraction.Unfocus(value);
                                if (mutableInteractionSource != null) {
                                    this.L$0 = mutableState;
                                    this.label = 1;
                                    if (mutableInteractionSource.emit(unfocus, this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    mutableState2 = mutableState;
                                }
                                mutableState.setValue(null);
                            }
                            return Unit.INSTANCE;
                        }
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        mutableState2 = (MutableState) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        mutableState = mutableState2;
                        mutableState.setValue(null);
                        return Unit.INSTANCE;
                    }
                }
            }, composer, 0);
            if (this.$enabled) {
                if (m217invoke$lambda5(mutableState3)) {
                    composer.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composer, "C(remember):Composables.kt#9igjgp");
                    Object objRememberedValue7 = composer.rememberedValue();
                    if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue7 = new FocusedBoundsModifier();
                        composer.updateRememberedValue(objRememberedValue7);
                    }
                    composer.endReplaceableGroup();
                    companion = (Modifier) objRememberedValue7;
                } else {
                    companion = Modifier.INSTANCE;
                }
                Modifier modifierThen = FocusRequesterModifierKt.focusRequester(BringIntoViewRequesterKt.bringIntoViewRequester(FocusableKt.onPinnableParentAvailable(SemanticsModifierKt.semantics$default(Modifier.INSTANCE, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.FocusableKt.focusable.2.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver semantics) {
                        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                        SemanticsPropertiesKt.setFocused(semantics, AnonymousClass2.m217invoke$lambda5(mutableState3));
                        final FocusRequester focusRequester2 = focusRequester;
                        final MutableState<Boolean> mutableState4 = mutableState3;
                        SemanticsPropertiesKt.requestFocus$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.FocusableKt.focusable.2.3.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Boolean invoke() {
                                focusRequester2.requestFocus();
                                return Boolean.valueOf(AnonymousClass2.m217invoke$lambda5(mutableState4));
                            }
                        }, 1, null);
                    }
                }, 1, null), new Function1<PinnableParent, Unit>() { // from class: androidx.compose.foundation.FocusableKt.focusable.2.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(PinnableParent pinnableParent) {
                        invoke2(pinnableParent);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(PinnableParent pinnableParent) {
                        AnonymousClass2.m216invoke$lambda3(mutableState2, pinnableParent);
                    }
                }), bringIntoViewRequester), focusRequester).then(companion);
                final MutableInteractionSource mutableInteractionSource4 = this.$interactionSource;
                companionFocusTarget = FocusModifierKt.focusTarget(FocusChangedModifierKt.onFocusChanged(modifierThen, new Function1<FocusState, Unit>() { // from class: androidx.compose.foundation.FocusableKt.focusable.2.5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(FocusState focusState) {
                        invoke2(focusState);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(FocusState it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        AnonymousClass2.m218invoke$lambda6(mutableState3, it.isFocused());
                        if (AnonymousClass2.m217invoke$lambda5(mutableState3)) {
                            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, CoroutineStart.UNDISPATCHED, new AnonymousClass1(bringIntoViewRequester, mutableState2, null), 1, null);
                            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C00032(mutableState, mutableInteractionSource4, null), 3, null);
                        } else {
                            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass3(mutableState, mutableInteractionSource4, null), 3, null);
                        }
                    }

                    /* JADX INFO: renamed from: androidx.compose.foundation.FocusableKt$focusable$2$5$1, reason: invalid class name */
                    /* JADX INFO: compiled from: Focusable.kt */
                    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                    @DebugMetadata(c = "androidx.compose.foundation.FocusableKt$focusable$2$5$1", f = "Focusable.kt", i = {0}, l = {144}, m = "invokeSuspend", n = {"pinnedItemsHandle"}, s = {"L$0"})
                    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ BringIntoViewRequester $bringIntoViewRequester;
                        final /* synthetic */ MutableState<PinnableParent> $pinnableParent$delegate;
                        Object L$0;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass1(BringIntoViewRequester bringIntoViewRequester, MutableState<PinnableParent> mutableState, Continuation<? super AnonymousClass1> continuation) {
                            super(2, continuation);
                            this.$bringIntoViewRequester = bringIntoViewRequester;
                            this.$pinnableParent$delegate = mutableState;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new AnonymousClass1(this.$bringIntoViewRequester, this.$pinnableParent$delegate, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        /* JADX WARN: Removed duplicated region for block: B:23:0x0042  */
                        /* JADX WARN: Removed duplicated region for block: B:31:0x0051  */
                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct code enable 'Show inconsistent code' option in preferences
                        */
                        public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
                            /*
                                r6 = this;
                                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                                int r1 = r6.label
                                r2 = 1
                                if (r1 == 0) goto L1d
                                if (r1 != r2) goto L15
                                java.lang.Object r0 = r6.L$0
                                androidx.compose.foundation.lazy.layout.PinnableParent$PinnedItemsHandle r0 = (androidx.compose.foundation.lazy.layout.PinnableParent.PinnedItemsHandle) r0
                                kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Throwable -> L13
                                goto L40
                            L13:
                                r7 = move-exception
                                goto L4f
                            L15:
                                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                                r7.<init>(r0)
                                throw r7
                            L1d:
                                kotlin.ResultKt.throwOnFailure(r7)
                                r7 = 0
                                androidx.compose.runtime.MutableState<androidx.compose.foundation.lazy.layout.PinnableParent> r1 = r6.$pinnableParent$delegate     // Catch: java.lang.Throwable -> L4b
                                androidx.compose.foundation.lazy.layout.PinnableParent r1 = androidx.compose.foundation.FocusableKt.AnonymousClass2.m211access$invoke$lambda2(r1)     // Catch: java.lang.Throwable -> L4b
                                if (r1 == 0) goto L2e
                                androidx.compose.foundation.lazy.layout.PinnableParent$PinnedItemsHandle r1 = r1.pinItems()     // Catch: java.lang.Throwable -> L4b
                                goto L2f
                            L2e:
                                r1 = r7
                            L2f:
                                androidx.compose.foundation.relocation.BringIntoViewRequester r3 = r6.$bringIntoViewRequester     // Catch: java.lang.Throwable -> L48
                                r4 = r6
                                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4     // Catch: java.lang.Throwable -> L48
                                r6.L$0 = r1     // Catch: java.lang.Throwable -> L48
                                r6.label = r2     // Catch: java.lang.Throwable -> L48
                                java.lang.Object r7 = androidx.compose.foundation.relocation.BringIntoViewRequester.CC.bringIntoView$default(r3, r7, r4, r2, r7)     // Catch: java.lang.Throwable -> L48
                                if (r7 != r0) goto L3f
                                return r0
                            L3f:
                                r0 = r1
                            L40:
                                if (r0 == 0) goto L45
                                r0.unpin()
                            L45:
                                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                                return r7
                            L48:
                                r7 = move-exception
                                r0 = r1
                                goto L4f
                            L4b:
                                r0 = move-exception
                                r5 = r0
                                r0 = r7
                                r7 = r5
                            L4f:
                                if (r0 == 0) goto L54
                                r0.unpin()
                            L54:
                                throw r7
                            */
                            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.FocusableKt.AnonymousClass2.AnonymousClass5.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
                        }
                    }

                    /* JADX INFO: renamed from: androidx.compose.foundation.FocusableKt$focusable$2$5$2, reason: invalid class name and collision with other inner class name */
                    /* JADX INFO: compiled from: Focusable.kt */
                    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                    @DebugMetadata(c = "androidx.compose.foundation.FocusableKt$focusable$2$5$2", f = "Focusable.kt", i = {1}, l = {152, 156}, m = "invokeSuspend", n = {"interaction"}, s = {"L$0"})
                    static final class C00032 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ MutableState<FocusInteraction.Focus> $focusedInteraction;
                        final /* synthetic */ MutableInteractionSource $interactionSource;
                        Object L$0;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C00032(MutableState<FocusInteraction.Focus> mutableState, MutableInteractionSource mutableInteractionSource, Continuation<? super C00032> continuation) {
                            super(2, continuation);
                            this.$focusedInteraction = mutableState;
                            this.$interactionSource = mutableInteractionSource;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new C00032(this.$focusedInteraction, this.$interactionSource, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((C00032) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        /* JADX WARN: Removed duplicated region for block: B:22:0x005a  */
                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct code enable 'Show inconsistent code' option in preferences
                        */
                        public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
                            /*
                                r6 = this;
                                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                                int r1 = r6.label
                                r2 = 2
                                r3 = 1
                                if (r1 == 0) goto L26
                                if (r1 == r3) goto L1e
                                if (r1 != r2) goto L16
                                java.lang.Object r0 = r6.L$0
                                androidx.compose.foundation.interaction.FocusInteraction$Focus r0 = (androidx.compose.foundation.interaction.FocusInteraction.Focus) r0
                                kotlin.ResultKt.throwOnFailure(r7)
                                goto L6c
                            L16:
                                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                                r7.<init>(r0)
                                throw r7
                            L1e:
                                java.lang.Object r1 = r6.L$0
                                androidx.compose.runtime.MutableState r1 = (androidx.compose.runtime.MutableState) r1
                                kotlin.ResultKt.throwOnFailure(r7)
                                goto L4c
                            L26:
                                kotlin.ResultKt.throwOnFailure(r7)
                                androidx.compose.runtime.MutableState<androidx.compose.foundation.interaction.FocusInteraction$Focus> r7 = r6.$focusedInteraction
                                java.lang.Object r7 = r7.getValue()
                                androidx.compose.foundation.interaction.FocusInteraction$Focus r7 = (androidx.compose.foundation.interaction.FocusInteraction.Focus) r7
                                if (r7 == 0) goto L51
                                androidx.compose.foundation.interaction.MutableInteractionSource r1 = r6.$interactionSource
                                androidx.compose.runtime.MutableState<androidx.compose.foundation.interaction.FocusInteraction$Focus> r4 = r6.$focusedInteraction
                                androidx.compose.foundation.interaction.FocusInteraction$Unfocus r5 = new androidx.compose.foundation.interaction.FocusInteraction$Unfocus
                                r5.<init>(r7)
                                if (r1 == 0) goto L4d
                                androidx.compose.foundation.interaction.Interaction r5 = (androidx.compose.foundation.interaction.Interaction) r5
                                r6.L$0 = r4
                                r6.label = r3
                                java.lang.Object r7 = r1.emit(r5, r6)
                                if (r7 != r0) goto L4b
                                return r0
                            L4b:
                                r1 = r4
                            L4c:
                                r4 = r1
                            L4d:
                                r7 = 0
                                r4.setValue(r7)
                            L51:
                                androidx.compose.foundation.interaction.FocusInteraction$Focus r7 = new androidx.compose.foundation.interaction.FocusInteraction$Focus
                                r7.<init>()
                                androidx.compose.foundation.interaction.MutableInteractionSource r1 = r6.$interactionSource
                                if (r1 == 0) goto L6d
                                r3 = r7
                                androidx.compose.foundation.interaction.Interaction r3 = (androidx.compose.foundation.interaction.Interaction) r3
                                r4 = r6
                                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                                r6.L$0 = r7
                                r6.label = r2
                                java.lang.Object r1 = r1.emit(r3, r4)
                                if (r1 != r0) goto L6b
                                return r0
                            L6b:
                                r0 = r7
                            L6c:
                                r7 = r0
                            L6d:
                                androidx.compose.runtime.MutableState<androidx.compose.foundation.interaction.FocusInteraction$Focus> r0 = r6.$focusedInteraction
                                r0.setValue(r7)
                                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                                return r7
                            */
                            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.FocusableKt.AnonymousClass2.AnonymousClass5.C00032.invokeSuspend(java.lang.Object):java.lang.Object");
                        }
                    }

                    /* JADX INFO: renamed from: androidx.compose.foundation.FocusableKt$focusable$2$5$3, reason: invalid class name */
                    /* JADX INFO: compiled from: Focusable.kt */
                    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                    @DebugMetadata(c = "androidx.compose.foundation.FocusableKt$focusable$2$5$3", f = "Focusable.kt", i = {}, l = {163}, m = "invokeSuspend", n = {}, s = {})
                    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ MutableState<FocusInteraction.Focus> $focusedInteraction;
                        final /* synthetic */ MutableInteractionSource $interactionSource;
                        Object L$0;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass3(MutableState<FocusInteraction.Focus> mutableState, MutableInteractionSource mutableInteractionSource, Continuation<? super AnonymousClass3> continuation) {
                            super(2, continuation);
                            this.$focusedInteraction = mutableState;
                            this.$interactionSource = mutableInteractionSource;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new AnonymousClass3(this.$focusedInteraction, this.$interactionSource, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) throws Throwable {
                            MutableState<FocusInteraction.Focus> mutableState;
                            MutableState<FocusInteraction.Focus> mutableState2;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                FocusInteraction.Focus value = this.$focusedInteraction.getValue();
                                if (value != null) {
                                    MutableInteractionSource mutableInteractionSource = this.$interactionSource;
                                    mutableState = this.$focusedInteraction;
                                    FocusInteraction.Unfocus unfocus = new FocusInteraction.Unfocus(value);
                                    if (mutableInteractionSource != null) {
                                        this.L$0 = mutableState;
                                        this.label = 1;
                                        if (mutableInteractionSource.emit(unfocus, this) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        mutableState2 = mutableState;
                                    }
                                    mutableState.setValue(null);
                                }
                                return Unit.INSTANCE;
                            }
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            mutableState2 = (MutableState) this.L$0;
                            ResultKt.throwOnFailure(obj);
                            mutableState = mutableState2;
                            mutableState.setValue(null);
                            return Unit.INSTANCE;
                        }
                    }
                }));
            } else {
                companionFocusTarget = Modifier.INSTANCE;
            }
            composer.endReplaceableGroup();
            return companionFocusTarget;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: invoke$lambda-2, reason: not valid java name */
        public static final PinnableParent m215invoke$lambda2(MutableState<PinnableParent> mutableState) {
            return mutableState.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: invoke$lambda-5, reason: not valid java name */
        public static final boolean m217invoke$lambda5(MutableState<Boolean> mutableState) {
            return mutableState.getValue().booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: invoke$lambda-6, reason: not valid java name */
        public static final void m218invoke$lambda6(MutableState<Boolean> mutableState, boolean z) {
            mutableState.setValue(Boolean.valueOf(z));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: invoke$lambda-3, reason: not valid java name */
        public static final void m216invoke$lambda3(MutableState<PinnableParent> mutableState, PinnableParent pinnableParent) {
            mutableState.setValue(pinnableParent);
        }
    }

    @ExperimentalFoundationApi
    public static final Modifier focusGroup(Modifier modifier) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        return FocusModifierKt.focusTarget(FocusPropertiesKt.focusProperties(modifier.then(focusGroupInspectorInfo), new Function1<FocusProperties, Unit>() { // from class: androidx.compose.foundation.FocusableKt.focusGroup.1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FocusProperties focusProperties) {
                invoke2(focusProperties);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FocusProperties focusProperties) {
                Intrinsics.checkNotNullParameter(focusProperties, "$this$focusProperties");
                focusProperties.setCanFocus(false);
            }
        }));
    }

    static {
        focusGroupInspectorInfo = new InspectableModifier(InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.FocusableKt$special$$inlined$debugInspectorInfo$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo inspectorInfo) {
                Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
                inspectorInfo.setName("focusGroup");
            }
        } : InspectableValueKt.getNoInspectorInfo());
    }

    public static final Modifier focusable(Modifier modifier, final boolean z, final MutableInteractionSource mutableInteractionSource) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.FocusableKt$focusable$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo inspectorInfo) {
                Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
                inspectorInfo.setName("focusable");
                inspectorInfo.getProperties().set("enabled", Boolean.valueOf(z));
                inspectorInfo.getProperties().set("interactionSource", mutableInteractionSource);
            }
        } : InspectableValueKt.getNoInspectorInfo(), new AnonymousClass2(mutableInteractionSource, z));
    }

    public static final Modifier focusableInNonTouchMode(Modifier modifier, final boolean z, final MutableInteractionSource mutableInteractionSource) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.FocusableKt$focusableInNonTouchMode$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo inspectorInfo) {
                Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
                inspectorInfo.setName("focusableInNonTouchMode");
                inspectorInfo.getProperties().set("enabled", Boolean.valueOf(z));
                inspectorInfo.getProperties().set("interactionSource", mutableInteractionSource);
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.FocusableKt.focusableInNonTouchMode.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier2, Composer composer, Integer num) {
                return invoke(modifier2, composer, num.intValue());
            }

            public final Modifier invoke(Modifier composed, Composer composer, int i) {
                Intrinsics.checkNotNullParameter(composed, "$this$composed");
                composer.startReplaceableGroup(-618949501);
                ComposerKt.sourceInformation(composer, "C218@9526L7:Focusable.kt#71ulvw");
                ProvidableCompositionLocal<InputModeManager> localInputModeManager = CompositionLocalsKt.getLocalInputModeManager();
                ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume = composer.consume(localInputModeManager);
                ComposerKt.sourceInformationMarkerEnd(composer);
                final InputModeManager inputModeManager = (InputModeManager) objConsume;
                Modifier modifierFocusable = FocusableKt.focusable(FocusPropertiesKt.focusProperties(Modifier.INSTANCE, new Function1<FocusProperties, Unit>() { // from class: androidx.compose.foundation.FocusableKt.focusableInNonTouchMode.2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(FocusProperties focusProperties) {
                        invoke2(focusProperties);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(FocusProperties focusProperties) {
                        Intrinsics.checkNotNullParameter(focusProperties, "$this$focusProperties");
                        focusProperties.setCanFocus(!InputMode.m2280equalsimpl0(inputModeManager.mo2286getInputModeaOaMEAU(), InputMode.INSTANCE.m2285getTouchaOaMEAU()));
                    }
                }), z, mutableInteractionSource);
                composer.endReplaceableGroup();
                return modifierFocusable;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ExperimentalFoundationApi
    public static final Modifier onPinnableParentAvailable(Modifier modifier, final Function1<? super PinnableParent, Unit> function1) {
        return InspectableValueKt.inspectableWrapper(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.FocusableKt$onPinnableParentAvailable$$inlined$debugInspectorInfo$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo inspectorInfo) {
                Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
                inspectorInfo.setName("onPinnableParentAvailable");
                inspectorInfo.getProperties().set("onPinnableParentAvailable", function1);
            }
        } : InspectableValueKt.getNoInspectorInfo(), Modifier.INSTANCE.then(new PinnableParentConsumer(function1)));
    }
}
