package com.tnkfactory.ad;

import android.content.Context;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tnkfactory.ad.pub.c1;
import com.tnkfactory.ad.pub.l;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u001d\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u0019\u0010\u0011\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0013\u0010\u0010J\u0011\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\tJ#\u0010\u0018\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001f\u0010\u001eJ\u000f\u0010 \u001a\u00020\u001cH\u0016¢\u0006\u0004\b \u0010\u001eR\u0018\u0010\"\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010$¨\u0006%"}, d2 = {"Lcom/tnkfactory/ad/RewardVideoAdItem;", "Lcom/tnkfactory/ad/AdItem;", "Landroid/content/Context;", "context", "", HandleInvocationsFromAdViewer.KEY_PLACEMENT_ID, "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "getTransactionId", "()Ljava/lang/String;", "Lcom/tnkfactory/ad/AdListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", InAppPurchaseConstants.METHOD_SET_LISTENER, "(Lcom/tnkfactory/ad/AdListener;)V", "load", "()V", "show", "(Landroid/content/Context;)V", "close", "getPlacementId", "key", "", "value", "setValue", "(Ljava/lang/String;Ljava/lang/Object;)V", "getValue", "(Ljava/lang/String;)Ljava/lang/Object;", "", "isEmpty", "()Z", "isLoaded", "isInvalidated", "Lcom/tnkfactory/ad/pub/c1;", "implObj", "Lcom/tnkfactory/ad/pub/c1;", "Landroid/content/Context;", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RewardVideoAdItem implements AdItem {
    private Context context;
    private c1 implObj;

    public RewardVideoAdItem(Context context, String str) {
        this.context = context;
        this.implObj = l.a(this).a(str);
    }

    @Override // com.tnkfactory.ad.AdItem
    public void close() {
        c1 c1Var = this.implObj;
        Intrinsics.checkNotNull(c1Var);
        c1Var.b();
    }

    @Override // com.tnkfactory.ad.AdItem
    public String getPlacementId() {
        c1 c1Var = this.implObj;
        if (c1Var == null || c1Var == null) {
            return null;
        }
        return c1Var.f3115a;
    }

    @Override // com.tnkfactory.ad.AdItem
    public String getTransactionId() {
        String strD;
        c1 c1Var = this.implObj;
        if (c1Var != null) {
            return (c1Var == null || (strD = c1Var.d()) == null) ? "" : strD;
        }
        return null;
    }

    @Override // com.tnkfactory.ad.AdItem
    public Object getValue(String key) {
        c1 c1Var = this.implObj;
        if (c1Var != null) {
            return c1Var.c.get(key);
        }
        return null;
    }

    @Override // com.tnkfactory.ad.AdItem
    public boolean isEmpty() {
        c1 c1Var = this.implObj;
        return c1Var == null || c1Var.d == 0;
    }

    @Override // com.tnkfactory.ad.AdItem
    public boolean isInvalidated() {
        c1 c1Var = this.implObj;
        if (c1Var == null || c1Var == null) {
            return true;
        }
        return c1Var.f();
    }

    @Override // com.tnkfactory.ad.AdItem
    public boolean isLoaded() {
        c1 c1Var = this.implObj;
        if (c1Var == null || c1Var == null) {
            return false;
        }
        return c1Var.g();
    }

    @Override // com.tnkfactory.ad.AdItem
    public void load() {
        c1 c1Var = this.implObj;
        if (c1Var == null || c1Var == null) {
            return;
        }
        c1Var.a(this.context, true);
    }

    @Override // com.tnkfactory.ad.AdItem
    public void setListener(AdListener listener) {
        if (!(listener instanceof RewardVideoAdListener)) {
            if (listener != null) {
                listener.onError(null, AdError.FAIL_MUST_SET_REWARD_VIDEO_LISTENER);
            }
        } else {
            c1 c1Var = this.implObj;
            if (c1Var == null || c1Var == null) {
                return;
            }
            c1Var.b = listener;
        }
    }

    @Override // com.tnkfactory.ad.AdItem
    public void setValue(String key, Object value) {
        c1 c1Var = this.implObj;
        if (c1Var != null) {
            c1Var.c.put(key, value);
        }
    }

    @Override // com.tnkfactory.ad.AdItem
    public void show() {
        c1 c1Var = this.implObj;
        if (c1Var == null || c1Var == null) {
            return;
        }
        c1Var.d(this.context);
    }

    @Override // com.tnkfactory.ad.AdItem
    public void show(Context context) {
        c1 c1Var = this.implObj;
        if (c1Var == null || c1Var == null) {
            return;
        }
        c1Var.d(context);
    }
}
