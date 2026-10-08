package com.adxcorp.ads.nativeads.util;

import android.content.Context;
import com.adxcorp.ads.common.CustomEventListener;
import com.adxcorp.ads.nativeads.adapter.NativeCustomEvent;
import java.lang.reflect.Constructor;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ReflectionUtil {
    protected static ReflectionUtil instance = new ReflectionUtil();

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
    public static NativeCustomEvent create(String str) throws Exception {
        if (str != null) {
            return instance.internalCreate(Class.forName(str).asSubclass(NativeCustomEvent.class));
        }
        return new NativeCustomEvent() { // from class: com.adxcorp.ads.nativeads.util.ReflectionUtil.1
            @Override // com.adxcorp.ads.nativeads.adapter.NativeCustomEvent
            public void loadAd(Context context, Map<String, String> map, CustomEventListener customEventListener) {
            }

            @Override // com.adxcorp.ads.nativeads.adapter.NativeCustomEvent
            @Deprecated
            protected void loadNativeAd(Context context, NativeCustomEvent.CustomEventNativeListener customEventNativeListener, Map<String, Object> map, Map<String, String> map2) {
            }
        };
    }

    protected NativeCustomEvent internalCreate(Class<? extends NativeCustomEvent> cls) throws Exception {
        Constructor<? extends NativeCustomEvent> declaredConstructor = cls.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        return declaredConstructor.newInstance(new Object[0]);
    }
}
