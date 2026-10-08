package com.tnkfactory.ad.pub;

import com.tnkfactory.framework.crypto.EncryptUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: classes6.dex */
public abstract class h1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap f3136a = new HashMap();

    public static String a(String str) {
        HashMap map = f3136a;
        String str2 = (String) map.get(str);
        if (str2 != null) {
            return str2;
        }
        String strDecryptRC4 = EncryptUtils.decryptRC4(str);
        map.put(str, strDecryptRC4);
        return strDecryptRC4;
    }
}
