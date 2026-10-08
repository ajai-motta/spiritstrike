package com.tnkfactory.ad.pub;

import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.tnkfactory.framework.vo.ValueObject;
import java.lang.reflect.Method;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public abstract class o2 {
    public static void a(ValueObject valueObject, Object obj) {
        Class<?> cls = obj.getClass();
        for (Map<String, Object> map : valueObject) {
            try {
                for (String str : map.keySet()) {
                    if (!str.equals("icon_click_tracking_url") && !str.equals("icon_view_tracking_url")) {
                        Method method = cls.getMethod(ProductAction.ACTION_ADD + str, String.class);
                        if (method != null) {
                            method.invoke(obj, map.get(str));
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
    }
}
