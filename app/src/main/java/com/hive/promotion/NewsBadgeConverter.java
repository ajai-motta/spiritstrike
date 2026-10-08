package com.hive.promotion;

import com.hive.Logger;
import com.hive.base.Property;
import com.hive.core.CommonIdentifierKt;
import com.hive.core.HiveKeys;
import com.hive.promotion.PromotionNetwork;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: NewsBadgeConverter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\n\u001a\u00020\u000bR!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/hive/promotion/NewsBadgeConverter;", "", "menuList", "Ljava/util/ArrayList;", "Lcom/hive/promotion/PromotionNetwork$Menu;", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/util/ArrayList;)V", "getMenuList", "()Ljava/util/ArrayList;", "migration", "", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NewsBadgeConverter {
    private final ArrayList<PromotionNetwork.Menu> menuList;

    public NewsBadgeConverter(ArrayList<PromotionNetwork.Menu> menuList) {
        Intrinsics.checkNotNullParameter(menuList, "menuList");
        this.menuList = menuList;
    }

    public final ArrayList<PromotionNetwork.Menu> getMenuList() {
        return this.menuList;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void migration() throws JSONException {
        Logger.i("[NewsBadgeConverter] migration()");
        String value = Property.INSTANCE.getINSTANCE().getValue(PromotionKeys.NEWS_MENU_CLICKED_TIME);
        if (value == null) {
            Logger.d("[NewsBadgeConverter] data is null.");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(value);
            JSONObject jSONObject2 = new JSONObject();
            for (PromotionNetwork.Menu menu : this.menuList) {
                String strValueOf = String.valueOf(menu.getId());
                if (jSONObject.has(strValueOf)) {
                    int iOptInt = jSONObject.optInt(strValueOf);
                    String str = Intrinsics.areEqual(menu.getPromotionType(), "fixed_notice") ? "notice" : "news";
                    JSONObject jSONObject3 = new JSONObject();
                    CommonIdentifierKt.put(jSONObject3, HiveKeys.KEY_click_time, Integer.valueOf(iOptInt));
                    CommonIdentifierKt.put(jSONObject3, HiveKeys.KEY_type_webview, str);
                    jSONObject2.put(strValueOf, jSONObject3);
                }
            }
            PromotionBadgeManager.INSTANCE.memorizeContentsRequest(jSONObject2);
            Property.INSTANCE.getINSTANCE().removeValue(PromotionKeys.NEWS_MENU_CLICKED_TIME);
        } catch (Exception e) {
            Logger.w("[NewsBadgeConverter] e: " + e.getMessage());
        }
    }
}
