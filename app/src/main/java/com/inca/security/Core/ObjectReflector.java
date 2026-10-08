package com.inca.security.Core;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/* JADX INFO: compiled from: dc */
/* JADX INFO: loaded from: classes.dex */
public class ObjectReflector {
    private /* synthetic */ Field field;
    private /* synthetic */ String fieldName;
    private /* synthetic */ boolean inited;
    private /* synthetic */ Object obj;

    public static Object invokeStaticMethod(Class cls, String str, Class[] clsArr, Object[] objArr) throws IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
        return findMethod(cls, str, clsArr).invoke(null, objArr);
    }

    public static Class findInnerClass(Object obj, String str) {
        for (Class<?> superclass = obj.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
            for (Class<?> cls : superclass.getDeclaredClasses()) {
                if (cls.getName().equals(str)) {
                    return cls;
                }
            }
        }
        return null;
    }

    public Object get() throws Exception {
        prepare();
        Field field = this.field;
        if (field == null) {
            throw new NoSuchFieldException();
        }
        return field.get(this.obj);
    }

    public static void expandFieldArray(Object obj, String str, Object[] objArr) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        Field fieldFindField = findField(obj, str);
        Object[] objArr2 = (Object[]) fieldFindField.get(obj);
        Object[] objArr3 = (Object[]) Array.newInstance(objArr2.getClass().getComponentType(), objArr2.length + objArr.length);
        System.arraycopy(objArr2, 0, objArr3, 0, objArr2.length);
        System.arraycopy(objArr, 0, objArr3, objArr2.length, objArr.length);
        fieldFindField.set(obj, objArr3);
    }

    public static Method findMethod(Object obj, String str, Class... clsArr) throws NoSuchMethodException {
        for (Class<?> superclass = obj.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
            try {
                Method declaredMethod = superclass.getDeclaredMethod(str, clsArr);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                return declaredMethod;
            } catch (NoSuchMethodException unused) {
            }
        }
        StringBuilder sbInsert = new StringBuilder().insert(0, "Method ");
        sbInsert.append(str);
        sbInsert.append(" with parameters ");
        sbInsert.append(Arrays.asList(clsArr));
        sbInsert.append(" not found in ");
        sbInsert.append(obj.getClass());
        throw new NoSuchMethodException(sbInsert.toString());
    }

    public ObjectReflector(Object obj, String str) {
        this.obj = obj;
        this.fieldName = str;
    }

    public static Method findMethod(Class cls, String str, Class... clsArr) throws NoSuchMethodException {
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
            if (!declaredMethod.isAccessible()) {
                declaredMethod.setAccessible(true);
            }
            return declaredMethod;
        } catch (NoSuchMethodException unused) {
            StringBuilder sbInsert = new StringBuilder().insert(0, "Method ");
            sbInsert.append(str);
            sbInsert.append(" with parameters ");
            sbInsert.append(Arrays.asList(clsArr));
            sbInsert.append(" not found in ");
            sbInsert.append(cls);
            throw new NoSuchMethodException(sbInsert.toString());
        }
    }

    private /* synthetic */ void prepare() {
        if (this.inited) {
            return;
        }
        this.inited = true;
        Class<?> superclass = this.obj.getClass();
        while (superclass != null) {
            try {
                Field declaredField = superclass.getDeclaredField(this.fieldName);
                declaredField.setAccessible(true);
                this.field = declaredField;
                return;
            } catch (Exception unused) {
            } finally {
                superclass.getSuperclass();
            }
        }
    }

    public void set(Object obj) throws Exception {
        prepare();
        Field field = this.field;
        if (field == null) {
            throw new NoSuchFieldException();
        }
        field.set(this.obj, obj);
    }

    public static Field findField(Object obj, String str) throws NoSuchFieldException {
        for (Class<?> superclass = obj.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
            try {
                Field declaredField = superclass.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException unused) {
            }
        }
        StringBuilder sbInsert = new StringBuilder().insert(0, "Field ");
        sbInsert.append(str);
        sbInsert.append(" not found in ");
        sbInsert.append(obj.getClass());
        throw new NoSuchFieldException(sbInsert.toString());
    }
}
