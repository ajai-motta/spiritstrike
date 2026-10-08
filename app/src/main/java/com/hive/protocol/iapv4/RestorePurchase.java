package com.hive.protocol.iapv4;

import com.applovin.sdk.AppLovinEventParameters;
import com.hive.analytics.provider.adjust.AnalyticsProviderAdjust;
import com.hive.core.CommonIdentifierKt;
import com.hive.core.HiveKeys;
import com.hive.core.Logger;
import com.hive.core.Request;
import com.hive.core.Response;
import com.hive.protocol.UrlManager;
import com.hive.protocol.iapv4.IapV4;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: RestorePurchase.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\t\u001a\u00020\nH\u0010¢\u0006\u0002\b\u000bJ\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0010¢\u0006\u0002\b\u0010R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/hive/protocol/iapv4/RestorePurchase;", "Lcom/hive/protocol/iapv4/IapV4;", "<init>", "()V", "value", "Lcom/hive/protocol/iapv4/RestorePurchase$RestorePurchaseResponse;", "response", "getResponse", "()Lcom/hive/protocol/iapv4/RestorePurchase$RestorePurchaseResponse;", "toCoreRequest", "Lcom/hive/core/Request;", "toCoreRequest$hive_protocol_release", "toResponse", "", "coreResponse", "Lcom/hive/core/Response;", "toResponse$hive_protocol_release", "RestorePurchaseResponse", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RestorePurchase extends IapV4 {
    private RestorePurchaseResponse response;

    public RestorePurchase() {
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_is_sandbox);
    }

    public final RestorePurchaseResponse getResponse() {
        RestorePurchaseResponse restorePurchaseResponse = this.response;
        if (restorePurchaseResponse != null) {
            return restorePurchaseResponse;
        }
        Intrinsics.throwUninitializedPropertyAccessException("response");
        return null;
    }

    @Override // com.hive.protocol.iapv4.IapV4, com.hive.protocol.ProtocolRequest
    public Request toCoreRequest$hive_protocol_release() {
        getCoreRequest().setUrl(UrlManager.IapV4.INSTANCE.getRestorePurchase());
        return super.toCoreRequest$hive_protocol_release();
    }

    @Override // com.hive.protocol.iapv4.IapV4, com.hive.protocol.ProtocolRequest
    public void toResponse$hive_protocol_release(Response coreResponse) {
        Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
        super.toResponse$hive_protocol_release(coreResponse);
        this.response = new RestorePurchaseResponse(coreResponse);
    }

    /* JADX INFO: compiled from: RestorePurchase.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u000bB\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001b\u0010\u0006\u001a\f\u0012\b\u0012\u00060\bR\u00020\u00000\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/hive/protocol/iapv4/RestorePurchase$RestorePurchaseResponse;", "Lcom/hive/protocol/iapv4/IapV4$IapV4Response;", "coreResponse", "Lcom/hive/core/Response;", "<init>", "(Lcom/hive/core/Response;)V", "pgReceiptList", "", "Lcom/hive/protocol/iapv4/RestorePurchase$RestorePurchaseResponse$PgReceipt;", "getPgReceiptList", "()Ljava/util/List;", "PgReceipt", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class RestorePurchaseResponse extends IapV4.IapV4Response {
        private final List<PgReceipt> pgReceiptList;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RestorePurchaseResponse(Response coreResponse) {
            RestorePurchaseResponse restorePurchaseResponse;
            Object objM7415constructorimpl;
            int i;
            int i2;
            JSONArray jSONArray;
            String str;
            String str2;
            Object objM7415constructorimpl2;
            PgReceipt pgReceipt;
            super(coreResponse);
            String str3 = "";
            String str4 = "optString(...)";
            Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
            this.pgReceiptList = new ArrayList();
            if (isSuccess()) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    JSONArray jSONArrayOptJSONArray = getContentJSONObject().optJSONArray("restore_lists");
                    Unit unit = null;
                    if (jSONArrayOptJSONArray != null) {
                        int length = jSONArrayOptJSONArray.length();
                        if (length >= 0) {
                            int i3 = 0;
                            while (true) {
                                try {
                                    Result.Companion companion2 = Result.INSTANCE;
                                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i3);
                                    if (jSONObjectOptJSONObject != null) {
                                        String strOptString = jSONObjectOptJSONObject.optString("market_pid");
                                        Intrinsics.checkNotNullExpressionValue(strOptString, str4);
                                        String strOptString2 = jSONObjectOptJSONObject.optString(AnalyticsProviderAdjust.EventKeys.orderId);
                                        Intrinsics.checkNotNullExpressionValue(strOptString2, str4);
                                        String strOptString3 = jSONObjectOptJSONObject.optString("server_id");
                                        Intrinsics.checkNotNullExpressionValue(strOptString3, str4);
                                        String strOptString4 = jSONObjectOptJSONObject.optString("vid");
                                        Intrinsics.checkNotNullExpressionValue(strOptString4, str4);
                                        String strOptString5 = jSONObjectOptJSONObject.optString("uid");
                                        Intrinsics.checkNotNullExpressionValue(strOptString5, str4);
                                        String strOptString6 = jSONObjectOptJSONObject.optString(AppLovinEventParameters.REVENUE_AMOUNT);
                                        Intrinsics.checkNotNullExpressionValue(strOptString6, str4);
                                        String strOptString7 = jSONObjectOptJSONObject.optString("currency");
                                        Intrinsics.checkNotNullExpressionValue(strOptString7, str4);
                                        String strOptString8 = jSONObjectOptJSONObject.optString("started_datetime");
                                        Intrinsics.checkNotNullExpressionValue(strOptString8, str4);
                                        int iOptInt = jSONObjectOptJSONObject.optInt("started_datetime_ms");
                                        String strOptString9 = jSONObjectOptJSONObject.optString("paid_datetime");
                                        Intrinsics.checkNotNullExpressionValue(strOptString9, str4);
                                        int iOptInt2 = jSONObjectOptJSONObject.optInt("paid_datetime_ms");
                                        int iOptInt3 = jSONObjectOptJSONObject.optInt("quantity", 1);
                                        String strOptString10 = jSONObjectOptJSONObject.optString("market_id");
                                        Intrinsics.checkNotNullExpressionValue(strOptString10, str4);
                                        String strOptString11 = jSONObjectOptJSONObject.optString("hiveiap_receipt");
                                        Intrinsics.checkNotNullExpressionValue(strOptString11, str4);
                                        String strOptString12 = jSONObjectOptJSONObject.optString("purchase_bypass_info");
                                        Intrinsics.checkNotNullExpressionValue(strOptString12, str4);
                                        String strOptString13 = jSONObjectOptJSONObject.optString("additionalInfo", str3);
                                        if (!(!Intrinsics.areEqual(strOptString13, AbstractJsonLexerKt.NULL))) {
                                            strOptString13 = null;
                                        }
                                        i = i3;
                                        i2 = length;
                                        jSONArray = jSONArrayOptJSONArray;
                                        str = str4;
                                        str2 = str3;
                                        try {
                                            pgReceipt = new PgReceipt(this, strOptString, strOptString2, strOptString3, strOptString4, strOptString5, strOptString6, strOptString7, strOptString8, iOptInt, strOptString9, iOptInt2, iOptInt3, strOptString10, strOptString11, strOptString12, strOptString13 == null ? str3 : strOptString13);
                                        } catch (Throwable th) {
                                            th = th;
                                            Result.Companion companion3 = Result.INSTANCE;
                                            objM7415constructorimpl2 = Result.m7415constructorimpl(ResultKt.createFailure(th));
                                        }
                                    } else {
                                        i = i3;
                                        i2 = length;
                                        jSONArray = jSONArrayOptJSONArray;
                                        str = str4;
                                        str2 = str3;
                                        pgReceipt = null;
                                    }
                                    objM7415constructorimpl2 = Result.m7415constructorimpl(pgReceipt);
                                } catch (Throwable th2) {
                                    th = th2;
                                    i = i3;
                                    i2 = length;
                                    jSONArray = jSONArrayOptJSONArray;
                                    str = str4;
                                    str2 = str3;
                                }
                                try {
                                    PgReceipt pgReceipt2 = (PgReceipt) (Result.m7421isFailureimpl(objM7415constructorimpl2) ? null : objM7415constructorimpl2);
                                    if (pgReceipt2 != null) {
                                        restorePurchaseResponse = this;
                                        try {
                                            restorePurchaseResponse.pgReceiptList.add(pgReceipt2);
                                        } catch (Throwable th3) {
                                            th = th3;
                                            Result.Companion companion4 = Result.INSTANCE;
                                            objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
                                        }
                                    } else {
                                        restorePurchaseResponse = this;
                                    }
                                    int i4 = i;
                                    int i5 = i2;
                                    if (i4 == i5) {
                                        break;
                                    }
                                    i3 = i4 + 1;
                                    length = i5;
                                    str4 = str;
                                    jSONArrayOptJSONArray = jSONArray;
                                    str3 = str2;
                                } catch (Throwable th4) {
                                    th = th4;
                                    restorePurchaseResponse = this;
                                    Result.Companion companion42 = Result.INSTANCE;
                                    objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
                                }
                            }
                        } else {
                            restorePurchaseResponse = this;
                        }
                        unit = Unit.INSTANCE;
                    } else {
                        restorePurchaseResponse = this;
                    }
                    objM7415constructorimpl = Result.m7415constructorimpl(unit);
                } catch (Throwable th5) {
                    th = th5;
                    restorePurchaseResponse = this;
                }
                Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
                if (thM7418exceptionOrNullimpl != null) {
                    Logger.INSTANCE.protocolLog(thM7418exceptionOrNullimpl.toString(), Logger.LogType.Warning);
                    restorePurchaseResponse.setIapV4Result(-1);
                    restorePurchaseResponse.setIapV4ResultMsg("[Exception] " + thM7418exceptionOrNullimpl);
                }
            }
        }

        public final List<PgReceipt> getPgReceiptList() {
            return this.pgReceiptList;
        }

        /* JADX INFO: compiled from: RestorePurchase.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u001c\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u0011\u0010\u000e\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010 R\u0011\u0010\u000f\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b#\u0010 R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0017R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0017R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0017R\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0017¨\u0006("}, d2 = {"Lcom/hive/protocol/iapv4/RestorePurchase$RestorePurchaseResponse$PgReceipt;", "", "marketPid", "", "orderId", "serverId", "vid", "uid", AppLovinEventParameters.REVENUE_AMOUNT, "currency", "startedDatetime", "startedDatetimeMs", "", "paidDatetime", "paidDatetimeMs", "quantity", "marketId", "hiveiapReceipt", "bypassInfo", "iapPayload", "<init>", "(Lcom/hive/protocol/iapv4/RestorePurchase$RestorePurchaseResponse;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMarketPid", "()Ljava/lang/String;", "getOrderId", "getServerId", "getVid", "getUid", "getAmount", "getCurrency", "getStartedDatetime", "getStartedDatetimeMs", "()I", "getPaidDatetime", "getPaidDatetimeMs", "getQuantity", "getMarketId", "getHiveiapReceipt", "getBypassInfo", "getIapPayload", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public final class PgReceipt {
            private final String amount;
            private final String bypassInfo;
            private final String currency;
            private final String hiveiapReceipt;
            private final String iapPayload;
            private final String marketId;
            private final String marketPid;
            private final String orderId;
            private final String paidDatetime;
            private final int paidDatetimeMs;
            private final int quantity;
            private final String serverId;
            private final String startedDatetime;
            private final int startedDatetimeMs;
            final /* synthetic */ RestorePurchaseResponse this$0;
            private final String uid;
            private final String vid;

            public PgReceipt(RestorePurchaseResponse restorePurchaseResponse, String marketPid, String orderId, String serverId, String vid, String uid, String amount, String currency, String startedDatetime, int i, String paidDatetime, int i2, int i3, String marketId, String hiveiapReceipt, String bypassInfo, String iapPayload) {
                Intrinsics.checkNotNullParameter(marketPid, "marketPid");
                Intrinsics.checkNotNullParameter(orderId, "orderId");
                Intrinsics.checkNotNullParameter(serverId, "serverId");
                Intrinsics.checkNotNullParameter(vid, "vid");
                Intrinsics.checkNotNullParameter(uid, "uid");
                Intrinsics.checkNotNullParameter(amount, "amount");
                Intrinsics.checkNotNullParameter(currency, "currency");
                Intrinsics.checkNotNullParameter(startedDatetime, "startedDatetime");
                Intrinsics.checkNotNullParameter(paidDatetime, "paidDatetime");
                Intrinsics.checkNotNullParameter(marketId, "marketId");
                Intrinsics.checkNotNullParameter(hiveiapReceipt, "hiveiapReceipt");
                Intrinsics.checkNotNullParameter(bypassInfo, "bypassInfo");
                Intrinsics.checkNotNullParameter(iapPayload, "iapPayload");
                this.this$0 = restorePurchaseResponse;
                this.marketPid = marketPid;
                this.orderId = orderId;
                this.serverId = serverId;
                this.vid = vid;
                this.uid = uid;
                this.amount = amount;
                this.currency = currency;
                this.startedDatetime = startedDatetime;
                this.startedDatetimeMs = i;
                this.paidDatetime = paidDatetime;
                this.paidDatetimeMs = i2;
                this.quantity = i3;
                this.marketId = marketId;
                this.hiveiapReceipt = hiveiapReceipt;
                this.bypassInfo = bypassInfo;
                this.iapPayload = iapPayload;
            }

            public final String getMarketPid() {
                return this.marketPid;
            }

            public final String getOrderId() {
                return this.orderId;
            }

            public final String getServerId() {
                return this.serverId;
            }

            public final String getVid() {
                return this.vid;
            }

            public final String getUid() {
                return this.uid;
            }

            public final String getAmount() {
                return this.amount;
            }

            public final String getCurrency() {
                return this.currency;
            }

            public final String getStartedDatetime() {
                return this.startedDatetime;
            }

            public final int getStartedDatetimeMs() {
                return this.startedDatetimeMs;
            }

            public final String getPaidDatetime() {
                return this.paidDatetime;
            }

            public final int getPaidDatetimeMs() {
                return this.paidDatetimeMs;
            }

            public final int getQuantity() {
                return this.quantity;
            }

            public final String getMarketId() {
                return this.marketId;
            }

            public final String getHiveiapReceipt() {
                return this.hiveiapReceipt;
            }

            public final String getBypassInfo() {
                return this.bypassInfo;
            }

            public final String getIapPayload() {
                return this.iapPayload;
            }
        }
    }
}
