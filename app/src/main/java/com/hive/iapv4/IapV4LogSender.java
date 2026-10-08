package com.hive.iapv4;

import com.hive.Analytics;
import com.hive.base.Android;
import com.hive.base.Property;
import com.hive.logger.LoggerImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: compiled from: IapV4LogSender.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u001b\u0010\u000b\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0014H\u0000¢\u0006\u0002\b\u0015J\u000f\u0010\u0016\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0002\b\u0017J\u000f\u0010\u0018\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0002\b\u0019J\b\u0010\u001a\u001a\u00020\u0012H\u0002J\b\u0010\u001b\u001a\u00020\u0012H\u0002J\u0006\u0010\u001c\u001a\u00020\u0012J\u0006\u0010\u001d\u001a\u00020\u0012R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/hive/iapv4/IapV4LogSender;", "", "<init>", "()V", "taskQueue", "Ljava/util/LinkedList;", "Lcom/hive/iapv4/IapV4LogRequestData;", "worker", "Lcom/hive/iapv4/IapV4LogWorker;", "property", "Lcom/hive/base/Property;", "offer", "", "url", "", "originalJson", "analyticsRevenue", "Lcom/hive/Analytics$AnalyticsRevenue;", "", "list", "Ljava/util/ArrayList;", "offer$hive_iapv4_base_release", "peek", "peek$hive_iapv4_base_release", "poll", "poll$hive_iapv4_base_release", "writeFile", "readFile", "doWork", "reset", "hive-iapv4-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IapV4LogSender {
    public static final IapV4LogSender INSTANCE;
    private static final Property property;
    private static final LinkedList<IapV4LogRequestData> taskQueue;
    private static final IapV4LogWorker worker;

    private IapV4LogSender() {
    }

    static {
        IapV4LogSender iapV4LogSender = new IapV4LogSender();
        INSTANCE = iapV4LogSender;
        taskQueue = new LinkedList<>();
        LoggerImpl.INSTANCE.d("[IAPV4LogSender] create IAPV4LogSender");
        worker = new IapV4LogWorker();
        Property property2 = new Property("hiveiapv4log.dat");
        property = property2;
        property2.setPrefixFileName(false);
        iapV4LogSender.readFile();
    }

    public static /* synthetic */ boolean offer$default(IapV4LogSender iapV4LogSender, String str, String str2, Analytics.AnalyticsRevenue analyticsRevenue, int i, Object obj) {
        if ((i & 4) != 0) {
            analyticsRevenue = null;
        }
        return iapV4LogSender.offer(str, str2, analyticsRevenue);
    }

    public final boolean offer(String url, String originalJson, Analytics.AnalyticsRevenue analyticsRevenue) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(originalJson, "originalJson");
        LoggerImpl.INSTANCE.d("[IAPV4LogSender] offerTaskQueue url : " + url);
        if (StringsKt.isBlank(url)) {
            LoggerImpl.INSTANCE.w("[IAPV4LogSender] offerTaskQueue url is empty");
            return false;
        }
        if (StringsKt.isBlank(originalJson)) {
            LoggerImpl.INSTANCE.w("[IAPV4LogSender] offerTaskQueue originalJson is empty");
            return false;
        }
        LinkedList<IapV4LogRequestData> linkedList = taskQueue;
        synchronized (linkedList) {
            try {
                JSONObject jSONObject = new JSONObject(originalJson);
                LoggerImpl.INSTANCE.dL("[IAPV4LogSender] offerTaskQueue originalJson : \n" + jSONObject.toString(4));
                LoggerImpl.INSTANCE.dR("[IAPV4LogSender] offerTaskQueue originalJson : \n");
                linkedList.offer(new IapV4LogRequestData(url, originalJson, analyticsRevenue));
                INSTANCE.writeFile();
                Unit unit = Unit.INSTANCE;
            } catch (Exception unused) {
                return false;
            }
        }
        doWork();
        return true;
    }

    public final void offer$hive_iapv4_base_release(ArrayList<IapV4LogRequestData> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        LoggerImpl.INSTANCE.d("[IAPV4LogSender] offer list");
        synchronized (taskQueue) {
            Iterator<IapV4LogRequestData> it = list.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                IapV4LogRequestData next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                taskQueue.offer(next);
            }
            INSTANCE.writeFile();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final IapV4LogRequestData peek$hive_iapv4_base_release() {
        IapV4LogRequestData iapV4LogRequestDataPeek;
        LoggerImpl.INSTANCE.d("[IAPV4LogSender] peekTaskQueue");
        LinkedList<IapV4LogRequestData> linkedList = taskQueue;
        synchronized (linkedList) {
            iapV4LogRequestDataPeek = linkedList.peek();
        }
        return iapV4LogRequestDataPeek;
    }

    public final IapV4LogRequestData poll$hive_iapv4_base_release() {
        IapV4LogRequestData iapV4LogRequestDataPoll;
        LoggerImpl.INSTANCE.d("[IAPV4LogSender] pollTaskQueue");
        LinkedList<IapV4LogRequestData> linkedList = taskQueue;
        synchronized (linkedList) {
            iapV4LogRequestDataPoll = linkedList.poll();
            INSTANCE.writeFile();
        }
        return iapV4LogRequestDataPoll;
    }

    private final void writeFile() {
        LoggerImpl.INSTANCE.d("[IAPV4LogSender] writeFile");
        LinkedList<IapV4LogRequestData> linkedList = taskQueue;
        synchronized (linkedList) {
            String strSerialize = Android.INSTANCE.serialize(linkedList);
            if (strSerialize != null && (!StringsKt.isBlank(strSerialize))) {
                Property property2 = property;
                Property.setValue$default(property2, IapV4Keys.PURCHASE_LOG_PROPERTY, strSerialize, null, 4, null);
                property2.writeProperties();
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void readFile() {
        LoggerImpl.INSTANCE.d("[IAPV4LogSender] readFile");
        String value = property.getValue(IapV4Keys.PURCHASE_LOG_PROPERTY);
        if (value == null || !(!StringsKt.isBlank(value))) {
            return;
        }
        try {
            Object objDeserialize = Android.INSTANCE.deserialize(value);
            LinkedList linkedList = objDeserialize instanceof LinkedList ? (LinkedList) objDeserialize : null;
            if (linkedList != null) {
                LinkedList<IapV4LogRequestData> linkedList2 = taskQueue;
                synchronized (linkedList2) {
                    linkedList2.clear();
                    Iterator it = linkedList.iterator();
                    Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                    while (it.hasNext()) {
                        Object next = it.next();
                        Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                        taskQueue.add((IapV4LogRequestData) next);
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void doWork() {
        worker.work();
    }

    public final void reset() {
        LoggerImpl.INSTANCE.d("[IAPV4LogSender] reset");
        LinkedList<IapV4LogRequestData> linkedList = taskQueue;
        synchronized (linkedList) {
            linkedList.clear();
            property.deletePropertyFile();
        }
    }
}
