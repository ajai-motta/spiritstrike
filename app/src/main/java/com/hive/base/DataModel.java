package com.hive.base;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007J\b\u0010\t\u001a\u00020\bH\u0016¨\u0006\n"}, d2 = {"Lcom/hive/base/DataModel;", "", "<init>", "()V", "toJSON", "Lorg/json/JSONObject;", "toMap", "", "", InAppPurchaseConstants.METHOD_TO_STRING, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class DataModel {
    public JSONObject toJSON() {
        return Android.INSTANCE.fieldToJSON(this);
    }

    public final Map<String, Object> toMap() {
        return Android.INSTANCE.fieldToMap(this);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(getClass().getSimpleName()).append(" =\n");
        try {
            stringBuffer.append(toJSON().toString(4));
        } catch (Exception unused) {
            stringBuffer.append(toJSON().toString());
        }
        stringBuffer.append("\n");
        String string = stringBuffer.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
