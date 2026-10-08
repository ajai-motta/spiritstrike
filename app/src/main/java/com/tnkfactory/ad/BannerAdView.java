package com.tnkfactory.ad;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tnkfactory.ad.pub.R;
import com.tnkfactory.ad.pub.c1;
import com.tnkfactory.ad.pub.l;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bB\u001b\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0007\u0010\u000bJ!\u0010\u0011\u001a\u00020\u00102\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u0011\u0010\u0013\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0017\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J#\u0010\u001c\u001a\u00020\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0010H\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\"\u0010!J\u0019\u0010\"\u001a\u00020\u00102\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0010H\u0016¢\u0006\u0004\b$\u0010!J\u0011\u0010%\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b%\u0010\u0014J\u000f\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020&H\u0016¢\u0006\u0004\b)\u0010(J\u000f\u0010*\u001a\u00020&H\u0016¢\u0006\u0004\b*\u0010(J\u0017\u0010-\u001a\u00020\u00102\u0006\u0010,\u001a\u00020+H\u0016¢\u0006\u0004\b-\u0010.J\u0017\u00100\u001a\u00020\u00102\u0006\u0010/\u001a\u00020&H\u0016¢\u0006\u0004\b0\u00101¨\u00062"}, d2 = {"Lcom/tnkfactory/ad/BannerAdView;", "Landroid/widget/RelativeLayout;", "Lcom/tnkfactory/ad/AdItem;", "Landroid/content/Context;", "context", "", HandleInvocationsFromAdViewer.KEY_PLACEMENT_ID, "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Landroid/view/ViewGroup;", "viewGroup", "Lcom/tnkfactory/ad/NativeViewBinder;", "viewBinder", "", "attach", "(Landroid/view/ViewGroup;Lcom/tnkfactory/ad/NativeViewBinder;)V", "getTransactionId", "()Ljava/lang/String;", "Lcom/tnkfactory/ad/AdListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, InAppPurchaseConstants.METHOD_SET_LISTENER, "(Lcom/tnkfactory/ad/AdListener;)V", "key", "", "value", "setValue", "(Ljava/lang/String;Ljava/lang/Object;)V", "getValue", "(Ljava/lang/String;)Ljava/lang/Object;", "load", "()V", "show", "(Landroid/content/Context;)V", "close", "getPlacementId", "", "isEmpty", "()Z", "isLoaded", "isInvalidated", "", "visibility", "setVisibility", "(I)V", "hasWindowFocus", "onWindowFocusChanged", "(Z)V", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BannerAdView extends RelativeLayout implements AdItem {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c1 f3096a;
    public boolean b;
    public ViewTreeObserver.OnWindowFocusChangeListener c;

    public BannerAdView(Context context, String str) {
        super(context);
        this.f3096a = l.a(this).a(str);
    }

    public final void a() {
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        ViewTreeObserver.OnWindowFocusChangeListener onWindowFocusChangeListener = new ViewTreeObserver.OnWindowFocusChangeListener() { // from class: com.tnkfactory.ad.BannerAdView$$ExternalSyntheticLambda0
            @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
            public final void onWindowFocusChanged(boolean z) {
                BannerAdView.a(this.f$0, z);
            }
        };
        this.c = onWindowFocusChangeListener;
        viewTreeObserver.addOnWindowFocusChangeListener(onWindowFocusChangeListener);
    }

    public final void attach(ViewGroup viewGroup, NativeViewBinder viewBinder) {
        c1 c1Var = this.f3096a;
        Intrinsics.checkNotNull(c1Var);
        c1Var.a(viewGroup, viewBinder);
    }

    @Override // com.tnkfactory.ad.AdItem
    public void close() {
    }

    @Override // com.tnkfactory.ad.AdItem
    public String getPlacementId() {
        c1 c1Var = this.f3096a;
        if (c1Var != null) {
            return c1Var.f3115a;
        }
        return null;
    }

    @Override // com.tnkfactory.ad.AdItem
    public String getTransactionId() {
        c1 c1Var = this.f3096a;
        if (c1Var != null) {
            return c1Var.d();
        }
        return null;
    }

    @Override // com.tnkfactory.ad.AdItem
    public Object getValue(String key) {
        c1 c1Var = this.f3096a;
        if (c1Var != null) {
            return c1Var.c.get(key);
        }
        return null;
    }

    @Override // com.tnkfactory.ad.AdItem
    public boolean isEmpty() {
        c1 c1Var = this.f3096a;
        return c1Var == null || c1Var.d == 0;
    }

    @Override // com.tnkfactory.ad.AdItem
    public boolean isInvalidated() {
        c1 c1Var = this.f3096a;
        if (c1Var != null) {
            return c1Var.f();
        }
        return true;
    }

    @Override // com.tnkfactory.ad.AdItem
    public boolean isLoaded() {
        c1 c1Var = this.f3096a;
        if (c1Var != null) {
            return c1Var.g();
        }
        return false;
    }

    @Override // com.tnkfactory.ad.AdItem
    public void load() {
        c1 c1Var = this.f3096a;
        if (c1Var != null) {
            this.b = true;
            c1Var.a(getContext(), true);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c1 c1Var = this.f3096a;
        if (c1Var != null) {
            c1Var.c();
            if (this.c != null) {
                getViewTreeObserver().removeOnWindowFocusChangeListener(this.c);
            }
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        c1 c1Var = this.f3096a;
        if (c1Var != null) {
            int[] iArrA = c1Var.a(i, i2);
            Intrinsics.checkNotNull(iArrA);
            setMeasuredDimension(iArrA[0], iArrA[1]);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        c1 c1Var = this.f3096a;
        if (c1Var == null) {
            return;
        }
        if (!hasWindowFocus) {
            c1Var.h();
        } else if (getVisibility() == 0 && this.b) {
            this.f3096a.i();
        }
    }

    @Override // com.tnkfactory.ad.AdItem
    public void setListener(AdListener listener) {
        c1 c1Var = this.f3096a;
        if (c1Var != null) {
            c1Var.b = listener;
        }
    }

    @Override // com.tnkfactory.ad.AdItem
    public void setValue(String key, Object value) {
        c1 c1Var = this.f3096a;
        if (c1Var != null) {
            c1Var.c.put(key, value);
        }
    }

    @Override // android.view.View
    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
        if (visibility != 0) {
            c1 c1Var = this.f3096a;
            if (c1Var != null) {
                c1Var.h();
                return;
            }
            return;
        }
        c1 c1Var2 = this.f3096a;
        if (c1Var2 == null || !this.b) {
            return;
        }
        c1Var2.i();
    }

    @Override // com.tnkfactory.ad.AdItem
    public void show() {
    }

    @Override // com.tnkfactory.ad.AdItem
    public void show(Context context) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BannerAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.AdView, 0, 0);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        this.f3096a = l.a(this).a(typedArrayObtainStyledAttributes.getString(R.styleable.AdView_placement_id));
        a();
    }

    public static final void a(BannerAdView bannerAdView, boolean z) {
        c1 c1Var = bannerAdView.f3096a;
        if (c1Var == null) {
            return;
        }
        if (z) {
            if (bannerAdView.getVisibility() == 0 && bannerAdView.b) {
                bannerAdView.f3096a.i();
                return;
            }
            return;
        }
        c1Var.h();
    }
}
