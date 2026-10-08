package com.hive.promotion;

import android.content.Context;
import com.hive.ui.Resource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PromotionWords.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\t"}, d2 = {"Lcom/hive/promotion/PromotionWords;", "", "<init>", "()V", "getProgressDialogText", "", "context", "Landroid/content/Context;", "getTextForCustomSizeView", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PromotionWords {
    public static final PromotionWords INSTANCE = new PromotionWords();

    private PromotionWords() {
    }

    public final String getProgressDialogText(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return Resource.INSTANCE.getString("hive_promotion_in_progress");
    }

    public final String getTextForCustomSizeView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return Resource.INSTANCE.getString("hive_promotion_style_banner");
    }
}
