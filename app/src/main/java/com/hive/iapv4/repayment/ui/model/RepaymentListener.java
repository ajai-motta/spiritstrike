package com.hive.iapv4.repayment.ui.model;

import kotlin.Metadata;

/* JADX INFO: compiled from: RepaymentListener.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&¨\u0006\f"}, d2 = {"Lcom/hive/iapv4/repayment/ui/model/RepaymentListener;", "", "onRepayment", "", "item", "Lcom/hive/iapv4/repayment/ui/model/RepaymentItem;", "onRefresh", "onInquiry", "url", "", "onStartGame", "onDestroy", "hive-iapv4-repayment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface RepaymentListener {
    void onDestroy();

    void onInquiry(String url);

    void onRefresh();

    void onRepayment(RepaymentItem item);

    void onStartGame();
}
