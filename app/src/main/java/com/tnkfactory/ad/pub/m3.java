package com.tnkfactory.ad.pub;

import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tnkfactory.framework.crypto.DecryptInputStream;
import com.tnkfactory.framework.crypto.EncryptOutputStream;
import com.tnkfactory.framework.crypto.EncryptUtils;
import com.tnkfactory.framework.crypto.RC4Cryptor;
import com.tnkfactory.framework.vo.ValueObject;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: loaded from: classes6.dex */
public final class m3 {
    public static final byte[] c = EncryptUtils.toHexBytes("3339306d3f2d336a666c73");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r0 f3160a;
    public final a0 b;

    public m3(r0 r0Var, a0 a0Var) {
        this.f3160a = r0Var;
        this.b = a0Var;
    }

    public final Object a(String str, String str2, String str3, Object[] objArr) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        try {
            httpURLConnection.setConnectTimeout(2000);
            httpURLConnection.setReadTimeout(3000);
            httpURLConnection.setDoOutput(true);
            if (httpURLConnection instanceof HttpsURLConnection) {
                ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(new j4());
            }
            RC4Cryptor rC4Cryptor = new RC4Cryptor(c);
            DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(new EncryptOutputStream(httpURLConnection.getOutputStream(), rC4Cryptor.init()));
            HashMap map = new HashMap();
            ArrayList arrayList = new ArrayList();
            map.put(TtmlNode.TAG_P, 1);
            map.put("t", str2);
            map.put(InneractiveMediationDefs.GENDER_MALE, str3);
            map.put("a", this.f3160a.f3184a);
            map.put(InneractiveMediationDefs.GENDER_FEMALE, this.f3160a.c);
            map.put("v", this.f3160a.b);
            map.put("s", this.f3160a.d);
            map.put("k", "7.23.85");
            ValueObject valueObjectA = this.f3160a.a();
            a0 a0Var = this.b;
            if (a0Var != null) {
                valueObjectA.set(h1.a("c47105a9e85c85"), a0Var.f3103a);
                valueObjectA.set(h1.a("d66a0895ec6e8572e37a"), a0Var.b);
                if (a0Var.c != null) {
                    valueObjectA.set(h1.a("c36015a9ed50856a"), a0Var.c);
                }
            }
            arrayList.add(valueObjectA);
            if (objArr != null) {
                for (Object obj : objArr) {
                    arrayList.add(obj);
                }
            }
            l3 l3Var = new l3(deflaterOutputStream);
            l3Var.writeShort(3);
            Set setKeySet = map.keySet();
            String[] strArr = (String[]) setKeySet.toArray(new String[setKeySet.size()]);
            int length = strArr.length;
            l3Var.writeShort(length);
            for (int i = 0; i < length; i++) {
                l3Var.writeUTF(strArr[i]);
                l3Var.writeObject(map.get(strArr[i]));
            }
            int size = arrayList.size();
            l3Var.writeShort(size);
            for (int i2 = 0; i2 < size; i2++) {
                l3Var.writeObject(arrayList.get(i2));
            }
            deflaterOutputStream.close();
            InflaterInputStream inflaterInputStream = new InflaterInputStream(new DecryptInputStream(httpURLConnection.getInputStream(), rC4Cryptor.init()));
            HashMap map2 = new HashMap();
            ArrayList arrayList2 = new ArrayList();
            k3 k3Var = new k3(inflaterInputStream);
            int unsignedShort = k3Var.readUnsignedShort();
            if (unsignedShort != 3) {
                throw new IOException("Version mismatched. " + unsignedShort);
            }
            int unsignedShort2 = k3Var.readUnsignedShort();
            for (int i3 = 0; i3 < unsignedShort2; i3++) {
                map2.put(k3Var.readUTF(), k3Var.readObject());
            }
            int unsignedShort3 = k3Var.readUnsignedShort();
            for (int i4 = 0; i4 < unsignedShort3; i4++) {
                arrayList2.add(k3Var.readObject());
            }
            inflaterInputStream.close();
            Object obj2 = map2.get(TtmlNode.TAG_P);
            if (obj2 != null && (obj2 instanceof Number) && ((Number) obj2).intValue() == 11) {
                throw new j3(String.valueOf(arrayList2.size() > 0 ? arrayList2.get(0) : null));
            }
            return arrayList2.size() > 0 ? arrayList2.get(0) : null;
        } finally {
            httpURLConnection.disconnect();
        }
    }
}
