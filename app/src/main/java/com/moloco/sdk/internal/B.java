package com.moloco.sdk.internal;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class B implements A, LifecycleOwner, SavedStateRegistryOwner {
    public static final a c = new a(null);
    public static final int d = 8;
    public static final String e = "ViewLifecycleOwner";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LifecycleRegistry f2020a = new LifecycleRegistry(this);
    public final SavedStateRegistryController b = SavedStateRegistryController.INSTANCE.create(this);

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }
    }

    public static final class b implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f2021a;
        public final /* synthetic */ B b;
        public final /* synthetic */ View c;

        public b(View view, B b, View view2) {
            this.f2021a = view;
            this.b = b;
            this.c = view2;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.f2021a.removeOnAttachStateChangeListener(this);
            this.b.f(this.c);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
        }
    }

    @Override // com.moloco.sdk.internal.A
    public void b(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        View rootView = view.getRootView();
        if (rootView == null) {
            MolocoLogger.warn$default(MolocoLogger.INSTANCE, e, "RootView is absent, skipping", null, false, 12, null);
            return;
        }
        if (Intrinsics.areEqual(ViewTreeSavedStateRegistryOwner.get(rootView), this)) {
            MolocoLogger.info$default(MolocoLogger.INSTANCE, e, "Removing ViewTreeSavedStateRegistryOwner", null, false, 12, null);
            ViewTreeSavedStateRegistryOwner.set(rootView, null);
        }
        if (e(rootView)) {
            MolocoLogger.info$default(MolocoLogger.INSTANCE, e, "Removing ViewTreeLifecycleOwner", null, false, 12, null);
            ViewTreeLifecycleOwner.set(rootView, null);
        }
    }

    @Override // com.moloco.sdk.internal.A
    public void c(View view) {
        Object objM7415constructorimpl;
        Intrinsics.checkNotNullParameter(view, "view");
        View rootView = view.getRootView();
        Intrinsics.checkNotNull(rootView);
        if (e(rootView)) {
            try {
                Result.Companion companion = Result.INSTANCE;
                this.f2020a.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
                objM7415constructorimpl = Result.m7415constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
            }
            MolocoLogger.info$default(MolocoLogger.INSTANCE, e, "lifecycle pause success " + Result.m7422isSuccessimpl(objM7415constructorimpl), Result.m7418exceptionOrNullimpl(objM7415constructorimpl), false, 8, null);
        }
    }

    @Override // com.moloco.sdk.internal.A
    public void d(View view) {
        Object objM7415constructorimpl;
        Intrinsics.checkNotNullParameter(view, "view");
        View rootView = view.getRootView();
        Intrinsics.checkNotNull(rootView);
        if (e(rootView)) {
            try {
                Result.Companion companion = Result.INSTANCE;
                this.f2020a.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
                objM7415constructorimpl = Result.m7415constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m7422isSuccessimpl(objM7415constructorimpl)) {
                MolocoLogger.info$default(MolocoLogger.INSTANCE, e, "lifecycle resume success", null, false, 12, null);
            }
            Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
            if (thM7418exceptionOrNullimpl != null) {
                MolocoLogger.warn$default(MolocoLogger.INSTANCE, e, "lifecycle resume failure", thM7418exceptionOrNullimpl, false, 8, null);
            }
        }
    }

    public final boolean e(View view) {
        return Intrinsics.areEqual(ViewTreeLifecycleOwner.get(view), this);
    }

    public final void f(View view) {
        View rootView = view.getRootView();
        if (rootView == null) {
            MolocoLogger.warn$default(MolocoLogger.INSTANCE, e, "RootView is absent, skipping", null, false, 12, null);
            return;
        }
        if (ViewTreeSavedStateRegistryOwner.get(rootView) == null) {
            ViewTreeSavedStateRegistryOwner.set(rootView, this);
            try {
                Result.Companion companion = Result.INSTANCE;
                this.b.performRestore(null);
                Result.m7415constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m7415constructorimpl(ResultKt.createFailure(th));
            }
            MolocoLogger.info$default(MolocoLogger.INSTANCE, e, "ViewTreeSavedStateRegistryOwner is absent, setting custom one", null, false, 12, null);
        }
        if (ViewTreeLifecycleOwner.get(rootView) == null) {
            ViewTreeLifecycleOwner.set(rootView, this);
            this.f2020a.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
            this.f2020a.handleLifecycleEvent(Lifecycle.Event.ON_START);
            this.f2020a.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
            MolocoLogger.info$default(MolocoLogger.INSTANCE, e, "ViewTreeLifecycleOwner is absent, setting custom one", null, false, 12, null);
        }
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.f2020a;
    }

    @Override // androidx.savedstate.SavedStateRegistryOwner
    public SavedStateRegistry getSavedStateRegistry() {
        return this.b.getSavedStateRegistry();
    }

    @Override // com.moloco.sdk.internal.A
    public void a(final View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        com.moloco.sdk.internal.scheduling.d.a(new Function0() { // from class: com.moloco.sdk.internal.B$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return B.a(view, this);
            }
        });
    }

    public static final Unit a(View view, B b2) {
        if (ViewCompat.isAttachedToWindow(view)) {
            b2.f(view);
        } else {
            view.addOnAttachStateChangeListener(new b(view, b2, view));
        }
        return Unit.INSTANCE;
    }
}
