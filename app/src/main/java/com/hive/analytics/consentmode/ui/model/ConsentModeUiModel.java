package com.hive.analytics.consentmode.ui.model;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.hive.analytics.consentmode.ui.model.ConsentFormUiModel;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConsentModeUiModel.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0012\u001a\u00020\u0010J\u0006\u0010\u0013\u001a\u00020\u0010J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u000e2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/hive/analytics/consentmode/ui/model/ConsentModeUiModel;", "", "title", "", "formList", "", "Lcom/hive/analytics/consentmode/ui/model/ConsentFormUiModel;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getTitle", "()Ljava/lang/String;", "getFormList", "()Ljava/util/List;", "isAllChecked", "", "checkAll", "", "enableAll", "uncheckAll", "disableAll", "component1", "component2", "copy", "equals", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "hive-analytics-consent-mode_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class ConsentModeUiModel {
    private final List<ConsentFormUiModel> formList;
    private final String title;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ConsentModeUiModel copy$default(ConsentModeUiModel consentModeUiModel, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = consentModeUiModel.title;
        }
        if ((i & 2) != 0) {
            list = consentModeUiModel.formList;
        }
        return consentModeUiModel.copy(str, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public final List<ConsentFormUiModel> component2() {
        return this.formList;
    }

    public final ConsentModeUiModel copy(String title, List<ConsentFormUiModel> formList) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(formList, "formList");
        return new ConsentModeUiModel(title, formList);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConsentModeUiModel)) {
            return false;
        }
        ConsentModeUiModel consentModeUiModel = (ConsentModeUiModel) other;
        return Intrinsics.areEqual(this.title, consentModeUiModel.title) && Intrinsics.areEqual(this.formList, consentModeUiModel.formList);
    }

    public int hashCode() {
        return (this.title.hashCode() * 31) + this.formList.hashCode();
    }

    public String toString() {
        return "ConsentModeUiModel(title=" + this.title + ", formList=" + this.formList + ')';
    }

    public ConsentModeUiModel(String title, List<ConsentFormUiModel> formList) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(formList, "formList");
        this.title = title;
        this.formList = formList;
    }

    public final String getTitle() {
        return this.title;
    }

    public final List<ConsentFormUiModel> getFormList() {
        return this.formList;
    }

    public final boolean isAllChecked() {
        List<ConsentFormUiModel> list = this.formList;
        if ((list instanceof Collection) && list.isEmpty()) {
            return true;
        }
        for (ConsentFormUiModel consentFormUiModel : list) {
            if (!(consentFormUiModel instanceof ConsentFormUiModel.Item)) {
                if (!(consentFormUiModel instanceof ConsentFormUiModel.Group)) {
                    throw new NoWhenBranchMatchedException();
                }
                ConsentFormUiModel.Group group = (ConsentFormUiModel.Group) consentFormUiModel;
                if (group.getIsChecked()) {
                    List<ConsentFormUiModel.Item> subItems = group.getSubItems();
                    if (!(subItems instanceof Collection) || !subItems.isEmpty()) {
                        Iterator<T> it = subItems.iterator();
                        while (it.hasNext()) {
                            if (!((ConsentFormUiModel.Item) it.next()).getIsChecked()) {
                            }
                        }
                    }
                }
                return false;
            }
            if (!((ConsentFormUiModel.Item) consentFormUiModel).getIsChecked()) {
                return false;
            }
        }
        return true;
    }

    public final void checkAll() {
        for (ConsentFormUiModel consentFormUiModel : this.formList) {
            consentFormUiModel.setChecked(true);
            if (consentFormUiModel instanceof ConsentFormUiModel.Group) {
                ((ConsentFormUiModel.Group) consentFormUiModel).checkSubItems();
            }
        }
    }

    public final void enableAll() {
        for (ConsentFormUiModel consentFormUiModel : this.formList) {
            consentFormUiModel.setEnabled(true);
            if (consentFormUiModel instanceof ConsentFormUiModel.Group) {
                ((ConsentFormUiModel.Group) consentFormUiModel).enableSubItems();
            }
        }
    }

    public final void uncheckAll() {
        for (ConsentFormUiModel consentFormUiModel : this.formList) {
            consentFormUiModel.setChecked(false);
            if (consentFormUiModel instanceof ConsentFormUiModel.Group) {
                ((ConsentFormUiModel.Group) consentFormUiModel).uncheckSubItems();
            }
        }
    }

    public final void disableAll() {
        for (ConsentFormUiModel consentFormUiModel : this.formList) {
            consentFormUiModel.setEnabled(false);
            if (consentFormUiModel instanceof ConsentFormUiModel.Group) {
                ((ConsentFormUiModel.Group) consentFormUiModel).disableSubItems();
            }
        }
    }
}
