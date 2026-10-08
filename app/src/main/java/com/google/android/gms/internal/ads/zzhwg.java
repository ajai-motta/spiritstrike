package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class zzhwg {
    static zzhvy zzb(Class cls) {
        ClassLoader classLoader = zzhwg.class.getClassLoader();
        if (cls.equals(zzhvy.class)) {
            try {
                try {
                    return (zzhvy) cls.cast(((zzhwg) Class.forName("com.google.protobuf.BlazeGeneratedExtensionRegistryLiteLoader", true, classLoader).getConstructor(new Class[0]).newInstance(new Object[0])).zza());
                } catch (ReflectiveOperationException e) {
                    throw new IllegalStateException(e);
                }
            } catch (ClassNotFoundException unused) {
            }
        }
        Iterator it = ServiceLoader.load(zzhwg.class, classLoader).iterator();
        ArrayList arrayList = new ArrayList();
        while (it.hasNext()) {
            try {
                arrayList.add((zzhvy) cls.cast(((zzhwg) it.next()).zza()));
            } catch (ServiceConfigurationError e2) {
                Logger logger = Logger.getLogger(zzhvt.class.getName());
                Level level = Level.SEVERE;
                String simpleName = cls.getSimpleName();
                String.valueOf(simpleName);
                logger.logp(level, "com.google.protobuf.GeneratedExtensionRegistryLoader", "load", "Unable to load ".concat(String.valueOf(simpleName)), (Throwable) e2);
            }
        }
        if (arrayList.size() == 1) {
            return (zzhvy) arrayList.get(0);
        }
        if (arrayList.size() == 0) {
            return null;
        }
        try {
            return (zzhvy) cls.getMethod("combine", Collection.class).invoke(null, arrayList);
        } catch (ReflectiveOperationException e3) {
            throw new IllegalStateException(e3);
        }
    }

    protected abstract zzhvy zza();
}
