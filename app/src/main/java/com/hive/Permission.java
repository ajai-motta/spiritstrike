package com.hive;

import androidx.datastore.preferences.protobuf.DescriptorProtos;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.net.HttpHeaders;
import com.hive.logger.LoggerImpl;
import com.hive.permission.PermissionImpl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated(message = "4.16.2, GCPSDK4-906")
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001:\u0004\r\u000e\u000f\u0010B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007R\u0019\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/hive/Permission;", "", "<init>", "()V", "TAG", "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "requestPermissionViewData", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/Permission$PermissionViewDataListener;", "PermissionCategory", "PermissionViewUnitData", "PermissionViewData", "PermissionViewDataListener", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Permission {
    public static final Permission INSTANCE = new Permission();
    private static final String TAG = "Permission";

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/hive/Permission$PermissionCategory;", "", "id", "", "<init>", "(Ljava/lang/String;II)V", "getId", "()I", "Camera", "Contacts", HttpHeaders.LOCATION, "Microphone", "Phone", "Photo", "Push", "Storage", "Common", "Other", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Deprecated(message = "4.16.2, GCPSDK4-906")
    public static final class PermissionCategory {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ PermissionCategory[] $VALUES;
        private final int id;
        public static final PermissionCategory Camera = new PermissionCategory("Camera", 0, 1);
        public static final PermissionCategory Contacts = new PermissionCategory("Contacts", 1, 2);
        public static final PermissionCategory Location = new PermissionCategory(HttpHeaders.LOCATION, 2, 3);
        public static final PermissionCategory Microphone = new PermissionCategory("Microphone", 3, 4);
        public static final PermissionCategory Phone = new PermissionCategory("Phone", 4, 5);
        public static final PermissionCategory Photo = new PermissionCategory("Photo", 5, 6);
        public static final PermissionCategory Push = new PermissionCategory("Push", 6, 7);
        public static final PermissionCategory Storage = new PermissionCategory("Storage", 7, 8);
        public static final PermissionCategory Common = new PermissionCategory("Common", 8, 9);
        public static final PermissionCategory Other = new PermissionCategory("Other", 9, DescriptorProtos.Edition.EDITION_99999_TEST_ONLY_VALUE);

        private static final /* synthetic */ PermissionCategory[] $values() {
            return new PermissionCategory[]{Camera, Contacts, Location, Microphone, Phone, Photo, Push, Storage, Common, Other};
        }

        static {
            PermissionCategory[] permissionCategoryArr$values = $values();
            $VALUES = permissionCategoryArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(permissionCategoryArr$values);
        }

        private PermissionCategory(String str, int i, int i2) {
            this.id = i2;
        }

        public static EnumEntries<PermissionCategory> getEntries() {
            return $ENTRIES;
        }

        public static PermissionCategory valueOf(String str) {
            return (PermissionCategory) Enum.valueOf(PermissionCategory.class, str);
        }

        public static PermissionCategory[] values() {
            return (PermissionCategory[]) $VALUES.clone();
        }

        public final int getId() {
            return this.id;
        }
    }

    @Deprecated(message = "4.16.2, GCPSDK4-906")
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u0012\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0015\u001a\u00020\u0003H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR*\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R*\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/hive/Permission$PermissionViewData;", "", "contents", "", "permissions", "Ljava/util/ArrayList;", "Lcom/hive/Permission$PermissionViewUnitData;", "Lkotlin/collections/ArrayList;", "commons", "<init>", "(Ljava/lang/String;Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "getContents", "()Ljava/lang/String;", "setContents", "(Ljava/lang/String;)V", "getPermissions", "()Ljava/util/ArrayList;", "setPermissions", "(Ljava/util/ArrayList;)V", "getCommons", "setCommons", InAppPurchaseConstants.METHOD_TO_STRING, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PermissionViewData {
        private ArrayList<PermissionViewUnitData> commons;
        private String contents;
        private ArrayList<PermissionViewUnitData> permissions;

        public PermissionViewData(String contents, ArrayList<PermissionViewUnitData> permissions, ArrayList<PermissionViewUnitData> commons) {
            Intrinsics.checkNotNullParameter(contents, "contents");
            Intrinsics.checkNotNullParameter(permissions, "permissions");
            Intrinsics.checkNotNullParameter(commons, "commons");
            this.contents = contents;
            this.permissions = permissions;
            this.commons = commons;
        }

        public final ArrayList<PermissionViewUnitData> getCommons() {
            return this.commons;
        }

        public final String getContents() {
            return this.contents;
        }

        public final ArrayList<PermissionViewUnitData> getPermissions() {
            return this.permissions;
        }

        public final void setCommons(ArrayList<PermissionViewUnitData> arrayList) {
            Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
            this.commons = arrayList;
        }

        public final void setContents(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.contents = str;
        }

        public final void setPermissions(ArrayList<PermissionViewUnitData> arrayList) {
            Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
            this.permissions = arrayList;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("\n==== PermissionViewData ====\n\n");
            sb.append(this.contents);
            sb.append("\n");
            Iterator<PermissionViewUnitData> it = this.permissions.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                PermissionViewUnitData next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                PermissionViewUnitData permissionViewUnitData = next;
                sb.append("\n");
                sb.append(permissionViewUnitData.getTitle());
                sb.append("\n");
                sb.append(permissionViewUnitData.getContents());
                sb.append("\n");
                sb.append(permissionViewUnitData.getNativePermissionName());
                sb.append("\n");
                sb.append(permissionViewUnitData.getPermissionCategory());
                sb.append("\n");
            }
            Iterator<PermissionViewUnitData> it2 = this.commons.iterator();
            Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
            while (it2.hasNext()) {
                PermissionViewUnitData next2 = it2.next();
                Intrinsics.checkNotNullExpressionValue(next2, "next(...)");
                PermissionViewUnitData permissionViewUnitData2 = next2;
                sb.append("\n");
                sb.append(permissionViewUnitData2.getTitle());
                sb.append("\n");
                sb.append(permissionViewUnitData2.getContents());
                sb.append("\n");
                sb.append(permissionViewUnitData2.getNativePermissionName());
                sb.append("\n");
                sb.append(permissionViewUnitData2.getPermissionCategory());
                sb.append("\n");
            }
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }
    }

    @Deprecated(message = "4.16.2, GCPSDK4-906")
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, d2 = {"Lcom/hive/Permission$PermissionViewDataListener;", "", "onPermissionViewData", "", "result", "Lcom/hive/ResultAPI;", "data", "Lcom/hive/Permission$PermissionViewData;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface PermissionViewDataListener {
        void onPermissionViewData(ResultAPI result, PermissionViewData data);
    }

    @Deprecated(message = "4.16.2, GCPSDK4-906")
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/hive/Permission$PermissionViewUnitData;", "", "title", "", "contents", "nativePermissionName", "permissionCategory", "Lcom/hive/Permission$PermissionCategory;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/hive/Permission$PermissionCategory;)V", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "getContents", "setContents", "getNativePermissionName", "setNativePermissionName", "getPermissionCategory", "()Lcom/hive/Permission$PermissionCategory;", "setPermissionCategory", "(Lcom/hive/Permission$PermissionCategory;)V", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PermissionViewUnitData {
        private String contents;
        private String nativePermissionName;
        private PermissionCategory permissionCategory;
        private String title;

        public PermissionViewUnitData(String title, String contents, String nativePermissionName, PermissionCategory permissionCategory) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(contents, "contents");
            Intrinsics.checkNotNullParameter(nativePermissionName, "nativePermissionName");
            Intrinsics.checkNotNullParameter(permissionCategory, "permissionCategory");
            this.title = title;
            this.contents = contents;
            this.nativePermissionName = nativePermissionName;
            this.permissionCategory = permissionCategory;
        }

        public final String getContents() {
            return this.contents;
        }

        public final String getNativePermissionName() {
            return this.nativePermissionName;
        }

        public final PermissionCategory getPermissionCategory() {
            return this.permissionCategory;
        }

        public final String getTitle() {
            return this.title;
        }

        public final void setContents(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.contents = str;
        }

        public final void setNativePermissionName(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.nativePermissionName = str;
        }

        public final void setPermissionCategory(PermissionCategory permissionCategory) {
            Intrinsics.checkNotNullParameter(permissionCategory, "<set-?>");
            this.permissionCategory = permissionCategory;
        }

        public final void setTitle(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.title = str;
        }
    }

    private Permission() {
    }

    public final String getTAG() {
        return TAG;
    }

    @Deprecated(message = "4.16.2, GCPSDK4-906")
    public final void requestPermissionViewData(PermissionViewDataListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("listener = %s", Arrays.copyOf(new Object[]{listener}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        PermissionImpl.INSTANCE.requestPermissionViewData(listener);
        loggerImpl.apiReturnLog(str2, "");
    }
}
