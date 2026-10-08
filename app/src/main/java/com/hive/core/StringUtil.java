package com.hive.core;

import android.util.Base64;
import com.hive.core.Logger;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: StringUtil.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\b\u001a\u0004\u0018\u00010\u0005*\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007J\f\u0010\t\u001a\u0004\u0018\u00010\n*\u00020\u0005J\f\u0010\u000b\u001a\u0004\u0018\u00010\u0005*\u00020\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\nJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u000f\u001a\u00020\u00102\b\u0010\r\u001a\u0004\u0018\u00010\n¨\u0006\u0011"}, d2 = {"Lcom/hive/core/StringUtil;", "", "<init>", "()V", "toBase64Encode", "", "base64Flag", "", "toBase64Decode", "toHexString", "", "toHexByteArray", "urlEncode", "value", "urlDecode", "isEmptyString", "", "hive-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StringUtil {
    public static final StringUtil INSTANCE = new StringUtil();

    private StringUtil() {
    }

    public static /* synthetic */ byte[] toBase64Encode$default(StringUtil stringUtil, byte[] bArr, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 2;
        }
        return stringUtil.toBase64Encode(bArr, i);
    }

    public final byte[] toBase64Encode(byte[] bArr, int i) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        try {
            return Base64.encode(bArr, i);
        } catch (Exception e) {
            Logger.INSTANCE.coreLog$hive_core_release("[StringUtil] toBase64Encode() e: " + e.getMessage(), Logger.LogType.Warning);
            return null;
        }
    }

    public static /* synthetic */ byte[] toBase64Decode$default(StringUtil stringUtil, byte[] bArr, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 2;
        }
        return stringUtil.toBase64Decode(bArr, i);
    }

    public final byte[] toBase64Decode(byte[] bArr, int i) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        try {
            return Base64.decode(bArr, i);
        } catch (Exception e) {
            Logger.INSTANCE.coreLog$hive_core_release("[StringUtil] toBase64Encode() e: " + e.getMessage(), Logger.LogType.Warning);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence toHexString$lambda$0(byte b) {
        String str = String.format("%02x", Arrays.copyOf(new Object[]{Integer.valueOf(b & 255)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public final String toHexString(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return ArraysKt.joinToString$default(bArr, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.hive.core.StringUtil$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StringUtil.toHexString$lambda$0(((Byte) obj).byteValue());
            }
        }, 30, (Object) null);
    }

    public final byte[] toHexByteArray(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            List<String> listChunked = StringsKt.chunked(str, 2);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listChunked, 10));
            Iterator<T> it = listChunked.iterator();
            while (it.hasNext()) {
                String upperCase = ((String) it.next()).toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                arrayList.add(Byte.valueOf((byte) Integer.parseInt(upperCase, CharsKt.checkRadix(16))));
            }
            return CollectionsKt.toByteArray(arrayList);
        } catch (Exception e) {
            Logger.INSTANCE.coreLog$hive_core_release("[StringUtil] toHexByteArray() e: " + e.getMessage(), Logger.LogType.Warning);
            return null;
        }
    }

    public final String urlEncode(String value) {
        try {
            return URLEncoder.encode(value, Charsets.UTF_8.name());
        } catch (Exception e) {
            Logger.INSTANCE.coreLog$hive_core_release("[StringUtil] urlEncode() e: " + e.getMessage(), Logger.LogType.Warning);
            return null;
        }
    }

    public final String urlDecode(String value) {
        try {
            return URLDecoder.decode(value, Charsets.UTF_8.name());
        } catch (Exception e) {
            Logger.INSTANCE.coreLog$hive_core_release("[StringUtil] urlDecode() e: " + e.getMessage(), Logger.LogType.Warning);
            return null;
        }
    }

    public final boolean isEmptyString(String value) {
        String str = value;
        return str == null || StringsKt.isBlank(str);
    }
}
