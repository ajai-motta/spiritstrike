package com.hive.analytics.consentmode.ui.model;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConsentFormUiModel.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0018\u0019B1\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0013\u001a\u00020\u0014H&J\b\u0010\u0015\u001a\u00020\u0014H&J\b\u0010\u0016\u001a\u00020\u0014H&J\b\u0010\u0017\u001a\u00020\u0014H&R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0014\u0010\u0005\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\b\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u000f\"\u0004\b\u0012\u0010\u0011\u0082\u0001\u0002\u001a\u001b¨\u0006\u001c"}, d2 = {"Lcom/hive/analytics/consentmode/ui/model/ConsentFormUiModel;", "", "id", "", "title", "description", "isChecked", "", "isEnabled", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V", "getId", "()Ljava/lang/String;", "getTitle", "getDescription", "()Z", "setChecked", "(Z)V", "setEnabled", "check", "", "uncheck", "enable", "disable", "Item", "Group", "Lcom/hive/analytics/consentmode/ui/model/ConsentFormUiModel$Group;", "Lcom/hive/analytics/consentmode/ui/model/ConsentFormUiModel$Item;", "hive-analytics-consent-mode_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class ConsentFormUiModel {
    private final String description;
    private final String id;
    private boolean isChecked;
    private boolean isEnabled;
    private final String title;

    public /* synthetic */ ConsentFormUiModel(String str, String str2, String str3, boolean z, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, z, z2);
    }

    public abstract void check();

    public abstract void disable();

    public abstract void enable();

    public abstract void uncheck();

    private ConsentFormUiModel(String str, String str2, String str3, boolean z, boolean z2) {
        this.id = str;
        this.title = str2;
        this.description = str3;
        this.isChecked = z;
        this.isEnabled = z2;
    }

    public String getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: isChecked, reason: from getter */
    public boolean getIsChecked() {
        return this.isChecked;
    }

    public void setChecked(boolean z) {
        this.isChecked = z;
    }

    /* JADX INFO: renamed from: isEnabled, reason: from getter */
    public boolean getIsEnabled() {
        return this.isEnabled;
    }

    public void setEnabled(boolean z) {
        this.isEnabled = z;
    }

    /* JADX INFO: compiled from: ConsentFormUiModel.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0016\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0014H\u0016J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J;\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0014\u0010\u0005\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\b\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u000f\"\u0004\b\u0012\u0010\u0011¨\u0006$"}, d2 = {"Lcom/hive/analytics/consentmode/ui/model/ConsentFormUiModel$Item;", "Lcom/hive/analytics/consentmode/ui/model/ConsentFormUiModel;", "id", "", "title", "description", "isChecked", "", "isEnabled", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V", "getId", "()Ljava/lang/String;", "getTitle", "getDescription", "()Z", "setChecked", "(Z)V", "setEnabled", "check", "", "uncheck", "enable", "disable", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "hive-analytics-consent-mode_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class Item extends ConsentFormUiModel {
        private final String description;
        private final String id;
        private boolean isChecked;
        private boolean isEnabled;
        private final String title;

        public static /* synthetic */ Item copy$default(Item item, String str, String str2, String str3, boolean z, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = item.id;
            }
            if ((i & 2) != 0) {
                str2 = item.title;
            }
            String str4 = str2;
            if ((i & 4) != 0) {
                str3 = item.description;
            }
            String str5 = str3;
            if ((i & 8) != 0) {
                z = item.isChecked;
            }
            boolean z3 = z;
            if ((i & 16) != 0) {
                z2 = item.isEnabled;
            }
            return item.copy(str, str4, str5, z3, z2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getIsChecked() {
            return this.isChecked;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final boolean getIsEnabled() {
            return this.isEnabled;
        }

        public final Item copy(String id, String title, String description, boolean isChecked, boolean isEnabled) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(description, "description");
            return new Item(id, title, description, isChecked, isEnabled);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Item)) {
                return false;
            }
            Item item = (Item) other;
            return Intrinsics.areEqual(this.id, item.id) && Intrinsics.areEqual(this.title, item.title) && Intrinsics.areEqual(this.description, item.description) && this.isChecked == item.isChecked && this.isEnabled == item.isEnabled;
        }

        public int hashCode() {
            return (((((((this.id.hashCode() * 31) + this.title.hashCode()) * 31) + this.description.hashCode()) * 31) + UByte$$ExternalSyntheticBackport0.m(this.isChecked)) * 31) + UByte$$ExternalSyntheticBackport0.m(this.isEnabled);
        }

        public String toString() {
            return "Item(id=" + this.id + ", title=" + this.title + ", description=" + this.description + ", isChecked=" + this.isChecked + ", isEnabled=" + this.isEnabled + ')';
        }

        public /* synthetic */ Item(String str, String str2, String str3, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, str3, (i & 8) != 0 ? false : z, (i & 16) != 0 ? true : z2);
        }

        @Override // com.hive.analytics.consentmode.ui.model.ConsentFormUiModel
        public String getId() {
            return this.id;
        }

        @Override // com.hive.analytics.consentmode.ui.model.ConsentFormUiModel
        public String getTitle() {
            return this.title;
        }

        @Override // com.hive.analytics.consentmode.ui.model.ConsentFormUiModel
        public String getDescription() {
            return this.description;
        }

        @Override // com.hive.analytics.consentmode.ui.model.ConsentFormUiModel
        /* JADX INFO: renamed from: isChecked */
        public boolean getIsChecked() {
            return this.isChecked;
        }

        @Override // com.hive.analytics.consentmode.ui.model.ConsentFormUiModel
        public void setChecked(boolean z) {
            this.isChecked = z;
        }

        @Override // com.hive.analytics.consentmode.ui.model.ConsentFormUiModel
        /* JADX INFO: renamed from: isEnabled */
        public boolean getIsEnabled() {
            return this.isEnabled;
        }

        @Override // com.hive.analytics.consentmode.ui.model.ConsentFormUiModel
        public void setEnabled(boolean z) {
            this.isEnabled = z;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Item(String id, String title, String description, boolean z, boolean z2) {
            super(id, title, description, z, z2, null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(description, "description");
            this.id = id;
            this.title = title;
            this.description = description;
            this.isChecked = z;
            this.isEnabled = z2;
        }

        @Override // com.hive.analytics.consentmode.ui.model.ConsentFormUiModel
        public void check() {
            setChecked(true);
        }

        @Override // com.hive.analytics.consentmode.ui.model.ConsentFormUiModel
        public void uncheck() {
            setChecked(false);
        }

        @Override // com.hive.analytics.consentmode.ui.model.ConsentFormUiModel
        public void enable() {
            setEnabled(true);
        }

        @Override // com.hive.analytics.consentmode.ui.model.ConsentFormUiModel
        public void disable() {
            setEnabled(false);
        }
    }

    /* JADX INFO: compiled from: ConsentFormUiModel.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\b\u0010\u001b\u001a\u00020\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u0019H\u0016J\u0006\u0010\u001d\u001a\u00020\u0019J\u0006\u0010\u001e\u001a\u00020\u0019J\u0006\u0010\u001f\u001a\u00020\u0019J\u0006\u0010 \u001a\u00020\u0019J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0007HÆ\u0003J\t\u0010%\u001a\u00020\u0007HÆ\u0003J\u000f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003JK\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0001J\u0013\u0010(\u001a\u00020\u00072\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020,HÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0005\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\b\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0012\"\u0004\b\u0015\u0010\u0014R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006."}, d2 = {"Lcom/hive/analytics/consentmode/ui/model/ConsentFormUiModel$Group;", "Lcom/hive/analytics/consentmode/ui/model/ConsentFormUiModel;", "id", "", "title", "description", "isChecked", "", "isEnabled", "subItems", "", "Lcom/hive/analytics/consentmode/ui/model/ConsentFormUiModel$Item;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/util/List;)V", "getId", "()Ljava/lang/String;", "getTitle", "getDescription", "()Z", "setChecked", "(Z)V", "setEnabled", "getSubItems", "()Ljava/util/List;", "check", "", "uncheck", "enable", "disable", "checkSubItems", "uncheckSubItems", "enableSubItems", "disableSubItems", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "hive-analytics-consent-mode_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class Group extends ConsentFormUiModel {
        private final String description;
        private final String id;
        private boolean isChecked;
        private boolean isEnabled;
        private final List<Item> subItems;
        private final String title;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Group copy$default(Group group, String str, String str2, String str3, boolean z, boolean z2, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = group.id;
            }
            if ((i & 2) != 0) {
                str2 = group.title;
            }
            String str4 = str2;
            if ((i & 4) != 0) {
                str3 = group.description;
            }
            String str5 = str3;
            if ((i & 8) != 0) {
                z = group.isChecked;
            }
            boolean z3 = z;
            if ((i & 16) != 0) {
                z2 = group.isEnabled;
            }
            boolean z4 = z2;
            if ((i & 32) != 0) {
                list = group.subItems;
            }
            return group.copy(str, str4, str5, z3, z4, list);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getIsChecked() {
            return this.isChecked;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final boolean getIsEnabled() {
            return this.isEnabled;
        }

        public final List<Item> component6() {
            return this.subItems;
        }

        public final Group copy(String id, String title, String description, boolean isChecked, boolean isEnabled, List<Item> subItems) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(description, "description");
            Intrinsics.checkNotNullParameter(subItems, "subItems");
            return new Group(id, title, description, isChecked, isEnabled, subItems);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Group)) {
                return false;
            }
            Group group = (Group) other;
            return Intrinsics.areEqual(this.id, group.id) && Intrinsics.areEqual(this.title, group.title) && Intrinsics.areEqual(this.description, group.description) && this.isChecked == group.isChecked && this.isEnabled == group.isEnabled && Intrinsics.areEqual(this.subItems, group.subItems);
        }

        public int hashCode() {
            return (((((((((this.id.hashCode() * 31) + this.title.hashCode()) * 31) + this.description.hashCode()) * 31) + UByte$$ExternalSyntheticBackport0.m(this.isChecked)) * 31) + UByte$$ExternalSyntheticBackport0.m(this.isEnabled)) * 31) + this.subItems.hashCode();
        }

        public String toString() {
            return "Group(id=" + this.id + ", title=" + this.title + ", description=" + this.description + ", isChecked=" + this.isChecked + ", isEnabled=" + this.isEnabled + ", subItems=" + this.subItems + ')';
        }

        public /* synthetic */ Group(String str, String str2, String str3, boolean z, boolean z2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, str3, (i & 8) != 0 ? false : z, (i & 16) != 0 ? true : z2, list);
        }

        @Override // com.hive.analytics.consentmode.ui.model.ConsentFormUiModel
        public String getId() {
            return this.id;
        }

        @Override // com.hive.analytics.consentmode.ui.model.ConsentFormUiModel
        public String getTitle() {
            return this.title;
        }

        @Override // com.hive.analytics.consentmode.ui.model.ConsentFormUiModel
        public String getDescription() {
            return this.description;
        }

        @Override // com.hive.analytics.consentmode.ui.model.ConsentFormUiModel
        /* JADX INFO: renamed from: isChecked */
        public boolean getIsChecked() {
            return this.isChecked;
        }

        @Override // com.hive.analytics.consentmode.ui.model.ConsentFormUiModel
        public void setChecked(boolean z) {
            this.isChecked = z;
        }

        @Override // com.hive.analytics.consentmode.ui.model.ConsentFormUiModel
        /* JADX INFO: renamed from: isEnabled */
        public boolean getIsEnabled() {
            return this.isEnabled;
        }

        @Override // com.hive.analytics.consentmode.ui.model.ConsentFormUiModel
        public void setEnabled(boolean z) {
            this.isEnabled = z;
        }

        public final List<Item> getSubItems() {
            return this.subItems;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Group(String id, String title, String description, boolean z, boolean z2, List<Item> subItems) {
            super(id, title, description, z, z2, null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(description, "description");
            Intrinsics.checkNotNullParameter(subItems, "subItems");
            this.id = id;
            this.title = title;
            this.description = description;
            this.isChecked = z;
            this.isEnabled = z2;
            this.subItems = subItems;
        }

        @Override // com.hive.analytics.consentmode.ui.model.ConsentFormUiModel
        public void check() {
            setChecked(true);
            checkSubItems();
        }

        @Override // com.hive.analytics.consentmode.ui.model.ConsentFormUiModel
        public void uncheck() {
            setChecked(false);
            uncheckSubItems();
        }

        @Override // com.hive.analytics.consentmode.ui.model.ConsentFormUiModel
        public void enable() {
            setEnabled(true);
        }

        @Override // com.hive.analytics.consentmode.ui.model.ConsentFormUiModel
        public void disable() {
            setEnabled(false);
            disableSubItems();
        }

        public final void checkSubItems() {
            Iterator<T> it = this.subItems.iterator();
            while (it.hasNext()) {
                ((Item) it.next()).setChecked(true);
            }
        }

        public final void uncheckSubItems() {
            Iterator<T> it = this.subItems.iterator();
            while (it.hasNext()) {
                ((Item) it.next()).setChecked(false);
            }
        }

        public final void enableSubItems() {
            Iterator<T> it = this.subItems.iterator();
            while (it.hasNext()) {
                ((Item) it.next()).setEnabled(true);
            }
        }

        public final void disableSubItems() {
            Iterator<T> it = this.subItems.iterator();
            while (it.hasNext()) {
                ((Item) it.next()).setEnabled(false);
            }
        }
    }
}
