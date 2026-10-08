package com.fyber.inneractive.sdk.protobuf;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes3.dex */
public abstract class f2 {
    public static void a(d2 d2Var, StringBuilder sb, int i) {
        boolean zEquals;
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        TreeSet<String> treeSet = new TreeSet();
        for (Method method : d2Var.getClass().getDeclaredMethods()) {
            map2.put(method.getName(), method);
            if (method.getParameterTypes().length == 0) {
                map.put(method.getName(), method);
                if (method.getName().startsWith("get")) {
                    treeSet.add(method.getName());
                }
            }
        }
        for (String str : treeSet) {
            String strSubstring = str.startsWith("get") ? str.substring(3) : str;
            if (strSubstring.endsWith("List") && !strSubstring.endsWith("OrBuilderList") && !strSubstring.equals("List")) {
                String str2 = strSubstring.substring(0, 1).toLowerCase() + strSubstring.substring(1, strSubstring.length() - 4);
                Method method2 = (Method) map.get(str);
                if (method2 != null && method2.getReturnType().equals(List.class)) {
                    a(sb, i, a(str2), z0.invokeOrDie(method2, d2Var, new Object[0]));
                }
            }
            if (strSubstring.endsWith("Map") && !strSubstring.equals("Map")) {
                String str3 = strSubstring.substring(0, 1).toLowerCase() + strSubstring.substring(1, strSubstring.length() - 3);
                Method method3 = (Method) map.get(str);
                if (method3 != null && method3.getReturnType().equals(Map.class) && !method3.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method3.getModifiers())) {
                    a(sb, i, a(str3), z0.invokeOrDie(method3, d2Var, new Object[0]));
                }
            }
            if (((Method) map2.get("set".concat(strSubstring))) != null) {
                if (strSubstring.endsWith("Bytes")) {
                    if (map.containsKey("get" + strSubstring.substring(0, strSubstring.length() - 5))) {
                    }
                }
                String str4 = strSubstring.substring(0, 1).toLowerCase() + strSubstring.substring(1);
                Method method4 = (Method) map.get("get".concat(strSubstring));
                Method method5 = (Method) map.get("has".concat(strSubstring));
                if (method4 != null) {
                    Object objInvokeOrDie = z0.invokeOrDie(method4, d2Var, new Object[0]);
                    if (method5 == null) {
                        if (objInvokeOrDie instanceof Boolean) {
                            zEquals = !((Boolean) objInvokeOrDie).booleanValue();
                        } else if (objInvokeOrDie instanceof Integer) {
                            if (((Integer) objInvokeOrDie).intValue() != 0) {
                                a(sb, i, a(str4), objInvokeOrDie);
                            }
                        } else if (objInvokeOrDie instanceof Float) {
                            if (((Float) objInvokeOrDie).floatValue() != 0.0f) {
                                a(sb, i, a(str4), objInvokeOrDie);
                            }
                        } else if (objInvokeOrDie instanceof Double) {
                            if (((Double) objInvokeOrDie).doubleValue() != 0.0d) {
                                a(sb, i, a(str4), objInvokeOrDie);
                            }
                        } else if (objInvokeOrDie instanceof String) {
                            zEquals = objInvokeOrDie.equals("");
                        } else if (objInvokeOrDie instanceof s) {
                            zEquals = objInvokeOrDie.equals(s.b);
                        } else if (objInvokeOrDie instanceof d2) {
                            if (objInvokeOrDie != ((d2) objInvokeOrDie).getDefaultInstanceForType()) {
                                a(sb, i, a(str4), objInvokeOrDie);
                            }
                        } else if (!(objInvokeOrDie instanceof Enum) || ((Enum) objInvokeOrDie).ordinal() != 0) {
                            a(sb, i, a(str4), objInvokeOrDie);
                        }
                        if (!zEquals) {
                            a(sb, i, a(str4), objInvokeOrDie);
                        }
                    } else if (((Boolean) z0.invokeOrDie(method5, d2Var, new Object[0])).booleanValue()) {
                        a(sb, i, a(str4), objInvokeOrDie);
                    }
                }
            }
        }
        if (d2Var instanceof GeneratedMessageLite$ExtendableMessage) {
            Iterator itD = ((GeneratedMessageLite$ExtendableMessage) d2Var).extensions.d();
            while (itD.hasNext()) {
                Map.Entry entry = (Map.Entry) itD.next();
                a(sb, i, "[" + ((w0) entry.getKey()).b + "]", entry.getValue());
            }
        }
        n3 n3Var = ((z0) d2Var).unknownFields;
        if (n3Var != null) {
            for (int i2 = 0; i2 < n3Var.f1570a; i2++) {
                a(sb, i, String.valueOf(n3Var.b[i2] >>> 3), n3Var.c[i2]);
            }
        }
    }

    public static final void a(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                a(sb, i, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                a(sb, i, str, (Map.Entry) it2.next());
            }
            return;
        }
        sb.append('\n');
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            sb.append(' ');
        }
        sb.append(str);
        if (obj instanceof String) {
            sb.append(": \"");
            sb.append(h3.a(s.a((String) obj)));
            sb.append('\"');
            return;
        }
        if (obj instanceof s) {
            sb.append(": \"");
            sb.append(h3.a((s) obj));
            sb.append('\"');
            return;
        }
        if (obj instanceof z0) {
            sb.append(" {");
            a((z0) obj, sb, i + 2);
            sb.append("\n");
            while (i2 < i) {
                sb.append(' ');
                i2++;
            }
            sb.append("}");
            return;
        }
        if (obj instanceof Map.Entry) {
            sb.append(" {");
            Map.Entry entry = (Map.Entry) obj;
            int i4 = i + 2;
            a(sb, i4, "key", entry.getKey());
            a(sb, i4, "value", entry.getValue());
            sb.append("\n");
            while (i2 < i) {
                sb.append(' ');
                i2++;
            }
            sb.append("}");
            return;
        }
        sb.append(": ");
        sb.append(obj.toString());
    }

    public static final String a(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (Character.isUpperCase(cCharAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(cCharAt));
        }
        return sb.toString();
    }
}
