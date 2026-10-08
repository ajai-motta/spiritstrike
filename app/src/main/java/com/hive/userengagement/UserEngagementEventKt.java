package com.hive.userengagement;

import com.hive.protocol.Protocol;
import com.hive.protocol.ProtocolRequest;
import java.util.HashMap;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a.\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001¨\u0006\u0005"}, d2 = {"appendQueryParameters", "Lcom/hive/protocol/Protocol;", "T", "Lcom/hive/protocol/ProtocolRequest;", "protocol", "hive-service_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class UserEngagementEventKt {
    public static final <T extends ProtocolRequest> Protocol<T> appendQueryParameters(Protocol<T> protocol, Protocol<T> protocol2) {
        Intrinsics.checkNotNullParameter(protocol, "<this>");
        Intrinsics.checkNotNullParameter(protocol2, "protocol");
        HashMap<String, String> queryParametersThenClear = UserEngagementEvent.INSTANCE.getQueryParametersThenClear();
        Set<String> setKeySet = queryParametersThenClear.keySet();
        Intrinsics.checkNotNullExpressionValue(setKeySet, "<get-keys>(...)");
        for (String str : setKeySet) {
            Intrinsics.checkNotNullExpressionValue(str, "next(...)");
            String str2 = str;
            if (!protocol2.hasParam(str2)) {
                try {
                    protocol2.setParam(str2, queryParametersThenClear.get(str2));
                } catch (JSONException e) {
                    e.printStackTrace();
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
        return protocol2;
    }
}
