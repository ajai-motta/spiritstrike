package com.hive.iapv4;

import com.hive.core.Network;
import com.hive.core.Request;
import com.hive.logger.LoggerImpl;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* JADX INFO: compiled from: IapV4LogWorker.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/hive/iapv4/IapV4LogWorker;", "", "<init>", "()V", "isIdle", "", "hashCode", "", "work", "", "hive-iapv4-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IapV4LogWorker {
    private boolean isIdle = true;
    private final int hashCode = hashCode();

    public final synchronized void work() {
        if (!this.isIdle) {
            LoggerImpl.INSTANCE.d("[IAPV4LogWorker](" + this.hashCode + ") is working");
            return;
        }
        LoggerImpl.INSTANCE.d("[IAPV4LogWorker](" + this.hashCode + ") work!");
        this.isIdle = false;
        new Thread(new Runnable() { // from class: com.hive.iapv4.IapV4LogWorker$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                IapV4LogWorker.work$lambda$2(this.f$0);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void work$lambda$2(IapV4LogWorker iapV4LogWorker) {
        ArrayList<IapV4LogRequestData> arrayList = new ArrayList<>();
        while (IapV4LogSender.INSTANCE.peek$hive_iapv4_base_release() != null) {
            IapV4LogRequestData iapV4LogRequestDataPoll$hive_iapv4_base_release = IapV4LogSender.INSTANCE.poll$hive_iapv4_base_release();
            if (iapV4LogRequestDataPoll$hive_iapv4_base_release != null) {
                String url = iapV4LogRequestDataPoll$hive_iapv4_base_release.getUrl();
                byte[] bytes = iapV4LogRequestDataPoll$hive_iapv4_base_release.getOriginalJson().getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                try {
                    byte[] content = Network.INSTANCE.sync(new Request(url, bytes)).getContent();
                    if (content == null) {
                        throw new Exception("");
                    }
                    JSONObject jSONObject = new JSONObject(new String(content, Charsets.UTF_8));
                    int i = jSONObject.getInt("result");
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("hiveiap_info");
                    if (!IapV4Network.INSTANCE.sendAnalyticsRevenue$hive_iapv4_base_release(i, jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optInt("detail_code", -1) : -1, iapV4LogRequestDataPoll$hive_iapv4_base_release.getAnalyticsRevenue())) {
                        arrayList.add(iapV4LogRequestDataPoll$hive_iapv4_base_release);
                    }
                    Unit unit = Unit.INSTANCE;
                } catch (Exception unused) {
                    Boolean.valueOf(arrayList.add(iapV4LogRequestDataPoll$hive_iapv4_base_release));
                }
            }
        }
        if (!arrayList.isEmpty()) {
            IapV4LogSender.INSTANCE.offer$hive_iapv4_base_release(arrayList);
        }
        iapV4LogWorker.isIdle = true;
    }
}
