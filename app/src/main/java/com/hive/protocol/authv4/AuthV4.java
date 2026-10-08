package com.hive.protocol.authv4;

import android.R;
import com.hive.core.HiveCoreInitializer;
import com.hive.core.Logger;
import com.hive.core.Response;
import com.hive.protocol.ProtocolRequest;
import com.hive.protocol.ProtocolResponse;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: compiled from: AuthV4.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001:\u0001\fB\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001a\u00020\u0005H\u0010¢\u0006\u0002\b\u0006J\u0015\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0010¢\u0006\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/hive/protocol/authv4/AuthV4;", "Lcom/hive/protocol/ProtocolRequest;", "<init>", "()V", "toCoreRequest", "Lcom/hive/core/Request;", "toCoreRequest$hive_protocol_release", "toResponse", "", "coreResponse", "Lcom/hive/core/Response;", "toResponse$hive_protocol_release", "AuthV4Response", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class AuthV4 extends ProtocolRequest {
    @Override // com.hive.protocol.ProtocolRequest
    public void toResponse$hive_protocol_release(Response coreResponse) {
        Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00b9  */
    @Override // com.hive.protocol.ProtocolRequest
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.hive.core.Request toCoreRequest$hive_protocol_release() throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 230
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.protocol.authv4.AuthV4.toCoreRequest$hive_protocol_release():com.hive.core.Request");
    }

    /* JADX INFO: compiled from: AuthV4.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b#\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u00102\u001a\u000201H\u0016J\u0006\u00103\u001a\u000201R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001a\u0010\u0018\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011R\u001a\u0010\u001b\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R\u001a\u0010\u001e\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\t\"\u0004\b \u0010\u000bR\u001a\u0010!\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\t\"\u0004\b#\u0010\u000bR\u001a\u0010$\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u000f\"\u0004\b&\u0010\u0011R\u001a\u0010'\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u000f\"\u0004\b)\u0010\u0011R\u001a\u0010*\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u000f\"\u0004\b,\u0010\u0011R\u001a\u0010-\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u000f\"\u0004\b/\u0010\u0011R\u000e\u00100\u001a\u000201X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/hive/protocol/authv4/AuthV4$AuthV4Response;", "Lcom/hive/protocol/ProtocolResponse;", "coreResponse", "Lcom/hive/core/Response;", "<init>", "(Lcom/hive/core/Response;)V", "resultCode", "", "getResultCode", "()I", "setResultCode", "(I)V", "resultMsg", "", "getResultMsg", "()Ljava/lang/String;", "setResultMsg", "(Ljava/lang/String;)V", "blockTitle", "getBlockTitle", "setBlockTitle", "blockMsg", "getBlockMsg", "setBlockMsg", "blockHtmlMsg", "getBlockHtmlMsg", "setBlockHtmlMsg", "blockUrl", "getBlockUrl", "setBlockUrl", "blockAction", "getBlockAction", "setBlockAction", "remainingTime", "getRemainingTime", "setRemainingTime", "remainingTimeMsg", "getRemainingTimeMsg", "setRemainingTimeMsg", "blockButton", "getBlockButton", "setBlockButton", "blockCustomerButton", "getBlockCustomerButton", "setBlockCustomerButton", "blockCustomerLink", "getBlockCustomerLink", "setBlockCustomerLink", "isSetBlacklistData", "", "isSuccess", "setBlacklistData", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static class AuthV4Response extends ProtocolResponse {
        private int blockAction;
        private String blockButton;
        private String blockCustomerButton;
        private String blockCustomerLink;
        private String blockHtmlMsg;
        private String blockMsg;
        private String blockTitle;
        private String blockUrl;
        private boolean isSetBlacklistData;
        private int remainingTime;
        private String remainingTimeMsg;
        private int resultCode;
        private String resultMsg;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Removed duplicated region for block: B:12:0x0048 A[Catch: Exception -> 0x012a, TryCatch #0 {Exception -> 0x012a, blocks: (B:3:0x0024, B:5:0x002a, B:7:0x003a, B:13:0x0054, B:15:0x0062, B:21:0x007d, B:24:0x0083, B:26:0x008e, B:28:0x0095, B:30:0x009d, B:32:0x00aa, B:34:0x00b6, B:36:0x00bc, B:38:0x00c5, B:40:0x00d4, B:42:0x00dc, B:43:0x00e2, B:45:0x00e8, B:47:0x0102, B:49:0x010c, B:46:0x00f3, B:20:0x0070, B:12:0x0048), top: B:54:0x0024 }] */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0070 A[Catch: Exception -> 0x012a, TryCatch #0 {Exception -> 0x012a, blocks: (B:3:0x0024, B:5:0x002a, B:7:0x003a, B:13:0x0054, B:15:0x0062, B:21:0x007d, B:24:0x0083, B:26:0x008e, B:28:0x0095, B:30:0x009d, B:32:0x00aa, B:34:0x00b6, B:36:0x00bc, B:38:0x00c5, B:40:0x00d4, B:42:0x00dc, B:43:0x00e2, B:45:0x00e8, B:47:0x0102, B:49:0x010c, B:46:0x00f3, B:20:0x0070, B:12:0x0048), top: B:54:0x0024 }] */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00b5  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x00f3 A[Catch: Exception -> 0x012a, TryCatch #0 {Exception -> 0x012a, blocks: (B:3:0x0024, B:5:0x002a, B:7:0x003a, B:13:0x0054, B:15:0x0062, B:21:0x007d, B:24:0x0083, B:26:0x008e, B:28:0x0095, B:30:0x009d, B:32:0x00aa, B:34:0x00b6, B:36:0x00bc, B:38:0x00c5, B:40:0x00d4, B:42:0x00dc, B:43:0x00e2, B:45:0x00e8, B:47:0x0102, B:49:0x010c, B:46:0x00f3, B:20:0x0070, B:12:0x0048), top: B:54:0x0024 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public AuthV4Response(com.hive.core.Response r15) {
            /*
                Method dump skipped, instruction units count: 329
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hive.protocol.authv4.AuthV4.AuthV4Response.<init>(com.hive.core.Response):void");
        }

        public final int getResultCode() {
            return this.resultCode;
        }

        public final void setResultCode(int i) {
            this.resultCode = i;
        }

        public final String getResultMsg() {
            return this.resultMsg;
        }

        public final void setResultMsg(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.resultMsg = str;
        }

        public final String getBlockTitle() {
            return this.blockTitle;
        }

        public final void setBlockTitle(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.blockTitle = str;
        }

        public final String getBlockMsg() {
            return this.blockMsg;
        }

        public final void setBlockMsg(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.blockMsg = str;
        }

        public final String getBlockHtmlMsg() {
            return this.blockHtmlMsg;
        }

        public final void setBlockHtmlMsg(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.blockHtmlMsg = str;
        }

        public final String getBlockUrl() {
            return this.blockUrl;
        }

        public final void setBlockUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.blockUrl = str;
        }

        public final int getBlockAction() {
            return this.blockAction;
        }

        public final void setBlockAction(int i) {
            this.blockAction = i;
        }

        public final int getRemainingTime() {
            return this.remainingTime;
        }

        public final void setRemainingTime(int i) {
            this.remainingTime = i;
        }

        public final String getRemainingTimeMsg() {
            return this.remainingTimeMsg;
        }

        public final void setRemainingTimeMsg(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.remainingTimeMsg = str;
        }

        public final String getBlockButton() {
            return this.blockButton;
        }

        public final void setBlockButton(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.blockButton = str;
        }

        public final String getBlockCustomerButton() {
            return this.blockCustomerButton;
        }

        public final void setBlockCustomerButton(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.blockCustomerButton = str;
        }

        public final String getBlockCustomerLink() {
            return this.blockCustomerLink;
        }

        public final void setBlockCustomerLink(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.blockCustomerLink = str;
        }

        @Override // com.hive.core.Response
        public boolean isSuccess() {
            int i = this.resultCode;
            return i == 0 || i == 2100 || i == 2300;
        }

        public final boolean setBlacklistData() {
            String upperCase;
            if (this.isSetBlacklistData) {
                return true;
            }
            if (getContentJSONObject().isNull("data")) {
                this.isSetBlacklistData = false;
                return false;
            }
            try {
                JSONObject jSONObject = getContentJSONObject().getJSONObject("data");
                String strOptString = jSONObject.optString("block_category_title");
                Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                this.blockTitle = strOptString;
                String strOptString2 = jSONObject.optString("block_msg");
                Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
                this.blockMsg = strOptString2;
                String strOptString3 = jSONObject.optString("block_html_msg");
                Intrinsics.checkNotNullExpressionValue(strOptString3, "optString(...)");
                this.blockHtmlMsg = strOptString3;
                String strOptString4 = jSONObject.optString("block_category_url");
                Intrinsics.checkNotNullExpressionValue(strOptString4, "optString(...)");
                this.blockUrl = strOptString4;
                this.blockAction = jSONObject.optInt("block_category_action", 2);
                this.remainingTime = jSONObject.optInt("remaining_time", -1);
                String strOptString5 = jSONObject.optString("remaining_time_msg", "");
                Intrinsics.checkNotNullExpressionValue(strOptString5, "optString(...)");
                this.remainingTimeMsg = strOptString5;
                String strOptString6 = jSONObject.optString("block_button");
                Intrinsics.checkNotNullExpressionValue(strOptString6, "optString(...)");
                this.blockButton = strOptString6;
                String strOptString7 = jSONObject.optString("customerButton");
                Intrinsics.checkNotNullExpressionValue(strOptString7, "optString(...)");
                this.blockCustomerButton = strOptString7;
                String strOptString8 = jSONObject.optString("customerLink");
                Intrinsics.checkNotNullExpressionValue(strOptString8, "optString(...)");
                this.blockCustomerLink = strOptString8;
                if (StringsKt.isBlank(this.blockButton)) {
                    String string = HiveCoreInitializer.INSTANCE.getInitContext().getResources().getString(R.string.ok);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    if (StringsKt.isBlank(string)) {
                        upperCase = "OK";
                    } else {
                        Locale US = Locale.US;
                        Intrinsics.checkNotNullExpressionValue(US, "US");
                        upperCase = string.toUpperCase(US);
                        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                    }
                    this.blockButton = upperCase;
                }
                if (StringsKt.isBlank(this.blockMsg)) {
                    String strOptString9 = jSONObject.optString("block_msg");
                    Intrinsics.checkNotNullExpressionValue(strOptString9, "optString(...)");
                    this.blockMsg = strOptString9;
                    this.blockMsg = StringsKt.replace$default(strOptString9, "\n", "<br>", false, 4, (Object) null);
                }
                this.isSetBlacklistData = true;
                return true;
            } catch (Exception e) {
                Logger.INSTANCE.protocolLog("invalid blacklist data: " + e, Logger.LogType.Warning);
                this.isSetBlacklistData = false;
                return true;
            }
        }
    }
}
