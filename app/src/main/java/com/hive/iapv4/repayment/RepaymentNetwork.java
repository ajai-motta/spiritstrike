package com.hive.iapv4.repayment;

import com.hive.IAPV4;
import com.hive.base.Android;
import com.hive.core.Configuration;
import com.hive.core.HiveKeys;
import com.hive.core.HiveTime;
import com.hive.core.OauthToken;
import com.hive.core.Platform;
import com.hive.core.configuration.HiveZoneType;
import com.hive.iapv4.repayment.ui.model.RepaymentItem;
import com.hive.protocol.Protocol;
import com.hive.protocol.ProtocolRequest;
import com.hive.protocol.iapv4.RefundInfo;
import com.hive.protocol.iapv4verify.VerifyRepayment;
import com.hive.standalone.HiveLifecycle;
import java.lang.reflect.InvocationTargetException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RepaymentNetwork.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\bJ&\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/hive/iapv4/repayment/RepaymentNetwork;", "", "<init>", "()V", "refundInfo", "Lcom/hive/protocol/iapv4/RefundInfo$RefundInfoResponse;", "hiveAccount", "Lcom/hive/standalone/HiveLifecycle$HiveAccount;", "(Lcom/hive/standalone/HiveLifecycle$HiveAccount;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "verifyRepayment", "Lcom/hive/protocol/iapv4verify/VerifyRepayment$VerifyRepaymentResponse;", "item", "Lcom/hive/iapv4/repayment/ui/model/RepaymentItem;", "iapV4Receipt", "Lcom/hive/IAPV4$IAPV4Receipt;", "(Lcom/hive/standalone/HiveLifecycle$HiveAccount;Lcom/hive/iapv4/repayment/ui/model/RepaymentItem;Lcom/hive/IAPV4$IAPV4Receipt;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hive-iapv4-repayment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RepaymentNetwork {
    public static final RepaymentNetwork INSTANCE = new RepaymentNetwork();

    private RepaymentNetwork() {
    }

    public final Object refundInfo(HiveLifecycle.HiveAccount hiveAccount, Continuation<? super RefundInfo.RefundInfoResponse> continuation) {
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol protocol = new Protocol(new Function0<RefundInfo>() { // from class: com.hive.iapv4.repayment.RepaymentNetwork$refundInfo$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.iapv4.RefundInfo] */
            @Override // kotlin.jvm.functions.Function0
            public final RefundInfo invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = RefundInfo.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        protocol.setParam(HiveKeys.KEY_appid, Configuration.INSTANCE.getAppId());
        protocol.setParam(HiveKeys.KEY_vid_type, hiveAccount.getVidType());
        protocol.setParam(HiveKeys.KEY_uid, hiveAccount.getUid());
        protocol.setParam(HiveKeys.KEY_vid, hiveAccount.getVid());
        protocol.setParam(HiveKeys.KEY_game_language, Configuration.INSTANCE.getGameLanguage());
        protocol.setParam(HiveKeys.KEY_language, Platform.INSTANCE.getLanguage());
        OauthToken oauthToken = hiveAccount.getOauthToken();
        if (oauthToken != null) {
            protocol.setOauthToken(oauthToken);
        }
        return ((RefundInfo) protocol.request()).getResponse();
    }

    public final Object verifyRepayment(HiveLifecycle.HiveAccount hiveAccount, RepaymentItem repaymentItem, IAPV4.IAPV4Receipt iAPV4Receipt, Continuation<? super VerifyRepayment.VerifyRepaymentResponse> continuation) {
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol protocol = new Protocol(new Function0<VerifyRepayment>() { // from class: com.hive.iapv4.repayment.RepaymentNetwork$verifyRepayment$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.iapv4verify.VerifyRepayment] */
            @Override // kotlin.jvm.functions.Function0
            public final VerifyRepayment invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = VerifyRepayment.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        protocol.setParam(HiveKeys.KEY_market_id, Boxing.boxInt(iAPV4Receipt.getType().getValue()));
        protocol.setParam(HiveKeys.KEY_appid, Configuration.INSTANCE.getAppId());
        protocol.setParam(HiveKeys.KEY_appversion, Android.INSTANCE.getAppVersion());
        protocol.setParam(HiveKeys.KEY_app_version_display, Android.INSTANCE.getAppVersion());
        protocol.setParam(HiveKeys.KEY_did, hiveAccount.getDid());
        protocol.setParam(HiveKeys.KEY_hive_country, Configuration.INSTANCE.getHiveCountry());
        protocol.setParam(HiveKeys.KEY_country, Android.INSTANCE.getCountry());
        protocol.setParam(HiveKeys.KEY_language, Android.INSTANCE.getLanguage());
        protocol.setParam(HiveKeys.KEY_game_language, Configuration.INSTANCE.getGameLanguage());
        protocol.setParam(HiveKeys.KEY_vid, hiveAccount.getVid());
        protocol.setParam(HiveKeys.KEY_vid_type, hiveAccount.getVidType());
        protocol.setParam(HiveKeys.KEY_uid, hiveAccount.getUid());
        protocol.setParam(HiveKeys.KEY_server_id, Configuration.INSTANCE.getServerId());
        protocol.setParam(HiveKeys.KEY_device_model, Android.INSTANCE.getDeviceModel());
        protocol.setParam(HiveKeys.KEY_os_version, Android.INSTANCE.getOSVersion());
        protocol.setParam(HiveKeys.KEY_os_api_level, Boxing.boxInt(Android.INSTANCE.getOSVersionCode()));
        protocol.setParam(HiveKeys.KEY_sdk_version, Configuration.INSTANCE.getSdkVersion());
        protocol.setParam(HiveKeys.KEY_price, Boxing.boxDouble(iAPV4Receipt.getProduct().getPrice()));
        protocol.setParam(HiveKeys.KEY_original_price, Boxing.boxDouble(iAPV4Receipt.getProduct().getOriginalPrice()));
        protocol.setParam(HiveKeys.KEY_currency, iAPV4Receipt.getProduct().getCurrency());
        protocol.setParam(HiveKeys.KEY_market_pid, iAPV4Receipt.getProduct().getMarketPid());
        protocol.setParam(HiveKeys.KEY_hiveiap_receipt, iAPV4Receipt.getHiveiapReceipt());
        protocol.setParam(HiveKeys.KEY_receipt_level, Boxing.boxInt(iAPV4Receipt.getReceiptLevel()));
        protocol.setParam(HiveKeys.KEY_hive_timezone, Configuration.INSTANCE.getTimezone());
        protocol.setParam(HiveKeys.KEY_request_type, Boxing.boxInt(iAPV4Receipt.getIsRestore() ? 2 : 1));
        protocol.setParam(HiveKeys.KEY_refund_idx, Boxing.boxInt(repaymentItem.getRefundIndex()));
        protocol.setParam(HiveKeys.KEY_quantity, Boxing.boxInt(iAPV4Receipt.getQuantity()));
        protocol.setParam(HiveKeys.KEY_revenue, Boxing.boxDouble(iAPV4Receipt.getRevenue()));
        protocol.setParam(HiveKeys.KEY_request_time_ms, Boxing.boxLong(HiveTime.INSTANCE.getHiveTimeTimestamp().getTime()));
        protocol.setParam(HiveKeys.KEY_is_sandbox, Boxing.boxBoolean(Configuration.INSTANCE.getZone() != HiveZoneType.REAL));
        if (iAPV4Receipt.getType() == IAPV4.IAPV4Type.HIVESTORE) {
            protocol.setParam(HiveKeys.KEY_order_id, iAPV4Receipt.getUniqueId());
        }
        OauthToken oauthToken = hiveAccount.getOauthToken();
        if (oauthToken != null) {
            protocol.setOauthToken(oauthToken);
        }
        return ((VerifyRepayment) protocol.request()).getResponse();
    }
}
