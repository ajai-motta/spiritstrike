package com.hive.iapv4;

import kotlin.Metadata;

/* JADX INFO: compiled from: IapV4Keys.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/hive/iapv4/IapV4Keys;", "", "<init>", "()V", "SELECTED_MARKET_PROPERTY", "", "PURCHASE_TRANSACTION_INFO_PROPERTY", "PURCHASE_LOG_PROPERTY", "hive-iapv4-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IapV4Keys {
    public static final IapV4Keys INSTANCE = new IapV4Keys();
    public static final String PURCHASE_LOG_PROPERTY = "iapv4.purchase_log_data";
    public static final String PURCHASE_TRANSACTION_INFO_PROPERTY = "iapv4.purchase_transaction_info";
    public static final String SELECTED_MARKET_PROPERTY = "iapv4.selected_market";

    private IapV4Keys() {
    }
}
