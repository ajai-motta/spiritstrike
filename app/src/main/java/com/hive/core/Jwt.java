package com.hive.core;

import android.util.Base64;
import com.facebook.AuthenticationTokenClaims;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.hive.core.Logger;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.json.JSONObject;

/* JADX INFO: compiled from: Jwt.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0003H\u0002R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/hive/core/Jwt;", "", "jwtEncoded", "", "<init>", "(Ljava/lang/String;)V", "header", "Lorg/json/JSONObject;", "getHeader", "()Lorg/json/JSONObject;", TtmlNode.TAG_BODY, "getBody", "isExpire", "", "margin", "", "getJson", "strEncoded", "hive-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Jwt {
    private final JSONObject body;
    private final JSONObject header;

    public Jwt(String jwtEncoded) {
        List listEmptyList;
        Intrinsics.checkNotNullParameter(jwtEncoded, "jwtEncoded");
        List<String> listSplit = new Regex("\\.").split(jwtEncoded, 0);
        if (!listSplit.isEmpty()) {
            ListIterator<String> listIterator = listSplit.listIterator(listSplit.size());
            while (listIterator.hasPrevious()) {
                if (listIterator.previous().length() != 0) {
                    listEmptyList = CollectionsKt.take(listSplit, listIterator.nextIndex() + 1);
                    break;
                }
            }
            listEmptyList = CollectionsKt.emptyList();
        } else {
            listEmptyList = CollectionsKt.emptyList();
        }
        String[] strArr = (String[]) listEmptyList.toArray(new String[0]);
        this.header = new JSONObject(getJson(strArr[0]));
        this.body = new JSONObject(getJson(strArr[1]));
    }

    public final JSONObject getHeader() {
        return this.header;
    }

    public final JSONObject getBody() {
        return this.body;
    }

    public static /* synthetic */ boolean isExpire$default(Jwt jwt, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return jwt.isExpire(i);
    }

    public final boolean isExpire(int margin) {
        boolean z = ((this.body.getLong(AuthenticationTokenClaims.JSON_KEY_EXP) * 1000) - HiveTime.INSTANCE.getHiveTimeTimestamp().getTime()) - (((long) margin) * 1000) < 0;
        if (z) {
            Logger.INSTANCE.coreLog$hive_core_release("Jwt Expired.", Logger.LogType.Warning);
        }
        return z;
    }

    private final String getJson(String strEncoded) throws UnsupportedEncodingException {
        byte[] bArrDecode = Base64.decode(strEncoded, 8);
        Intrinsics.checkNotNullExpressionValue(bArrDecode, "decode(...)");
        Charset charsetForName = Charset.forName("UTF-8");
        Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(...)");
        return new String(bArrDecode, charsetForName);
    }
}
