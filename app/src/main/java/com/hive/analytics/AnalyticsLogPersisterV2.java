package com.hive.analytics;

import android.content.Context;
import android.text.format.Time;
import android.util.Log;
import com.hive.base.Crypto;
import com.hive.core.Crypto;
import com.hive.core.HiveCoreInitializer;
import com.hive.ui.Resource;
import java.io.File;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u00011B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u001c\u001a\u00020\u0003J\u0019\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u001e2\u0006\u0010\u001f\u001a\u00020\n¢\u0006\u0002\u0010 J\u000e\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$J\b\u0010%\u001a\u0004\u0018\u00010\u000eJ\u000e\u0010&\u001a\u00020$2\u0006\u0010'\u001a\u00020\u000eJ\u000e\u0010(\u001a\u00020$2\u0006\u0010'\u001a\u00020\u000eJ\u000e\u0010)\u001a\u00020$2\u0006\u0010#\u001a\u00020$J\u000e\u0010*\u001a\u00020$2\u0006\u0010+\u001a\u00020\u0003J\u000e\u0010,\u001a\u00020\"2\u0006\u0010-\u001a\u00020\u0003J\u0012\u0010.\u001a\u00060/R\u00020\u00002\u0006\u00100\u001a\u00020\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R\u000e\u0010\t\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R&\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0014X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u00062"}, d2 = {"Lcom/hive/analytics/AnalyticsLogPersisterV2;", "", "logPath", "", "<init>", "(Ljava/lang/String;)V", "getLogPath", "()Ljava/lang/String;", "setLogPath", "LOG_MAX_COUNT", "", "tickCounter", "logDeque", "Ljava/util/Deque;", "Lorg/json/JSONObject;", "getLogDeque", "()Ljava/util/Deque;", "setLogDeque", "(Ljava/util/Deque;)V", "transactions", "Ljava/util/HashMap;", "getTransactions$hive_service_release", "()Ljava/util/HashMap;", "setTransactions$hive_service_release", "(Ljava/util/HashMap;)V", "logCount", "getLogCount", "()I", "generateLogFileName", "getSavedLogFileList", "", "maxCount", "(I)[Ljava/lang/String;", "loadLogFile", "", "isCrypt", "", "popLogs", "pushBackLogs", "jsonLogData", "pushFrontLogs", "saveLogFile", "deleteLogFile", "filePath", "removeTransaction", "transactionId", "getLogTransaction", "Lcom/hive/analytics/AnalyticsLogPersisterV2$HiveLogTransaction;", "maxLog", "HiveLogTransaction", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AnalyticsLogPersisterV2 {
    private final int LOG_MAX_COUNT;
    private Deque<JSONObject> logDeque;
    private String logPath;
    private volatile int tickCounter;
    private HashMap<String, Object> transactions;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ\u0006\u0010\u0016\u001a\u00020\u0014J\u0006\u0010\u0017\u001a\u00020\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0018"}, d2 = {"Lcom/hive/analytics/AnalyticsLogPersisterV2$HiveLogTransaction;", "", "mLogPersister", "Lcom/hive/analytics/AnalyticsLogPersisterV2;", "key", "", "<init>", "(Lcom/hive/analytics/AnalyticsLogPersisterV2;Lcom/hive/analytics/AnalyticsLogPersisterV2;Ljava/lang/String;)V", "getKey$hive_service_release", "()Ljava/lang/String;", "setKey$hive_service_release", "(Ljava/lang/String;)V", "logs", "Ljava/util/Deque;", "Lorg/json/JSONObject;", "getLogs", "()Ljava/util/Deque;", "setLogs", "(Ljava/util/Deque;)V", "setLogDeque", "", "argDeque", "rollback", "commit", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class HiveLogTransaction {
        private String key;
        private Deque<JSONObject> logs;
        private AnalyticsLogPersisterV2 mLogPersister;
        final /* synthetic */ AnalyticsLogPersisterV2 this$0;

        public HiveLogTransaction(AnalyticsLogPersisterV2 analyticsLogPersisterV2, AnalyticsLogPersisterV2 mLogPersister, String key) {
            Intrinsics.checkNotNullParameter(mLogPersister, "mLogPersister");
            Intrinsics.checkNotNullParameter(key, "key");
            this.this$0 = analyticsLogPersisterV2;
            this.mLogPersister = mLogPersister;
            this.key = key;
            this.logs = new LinkedList();
        }

        public final void commit() {
            this.mLogPersister.removeTransaction(this.key);
        }

        /* JADX INFO: renamed from: getKey$hive_service_release, reason: from getter */
        public final String getKey() {
            return this.key;
        }

        public final Deque<JSONObject> getLogs() {
            return this.logs;
        }

        public final void rollback() {
            Iterator<JSONObject> it = this.logs.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                JSONObject next = it.next();
                AnalyticsLogPersisterV2 analyticsLogPersisterV2 = this.mLogPersister;
                Intrinsics.checkNotNull(next);
                analyticsLogPersisterV2.pushFrontLogs(next);
            }
        }

        public final void setKey$hive_service_release(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.key = str;
        }

        public final void setLogDeque(Deque<JSONObject> argDeque) {
            Intrinsics.checkNotNullParameter(argDeque, "argDeque");
            this.logs = argDeque;
        }

        public final void setLogs(Deque<JSONObject> deque) {
            Intrinsics.checkNotNullParameter(deque, "<set-?>");
            this.logs = deque;
        }
    }

    public AnalyticsLogPersisterV2(String logPath) {
        Intrinsics.checkNotNullParameter(logPath, "logPath");
        this.logPath = logPath;
        this.LOG_MAX_COUNT = 1000;
        this.logDeque = new LinkedList();
        File file = new File(HiveCoreInitializer.INSTANCE.getInitContext().getFilesDir(), this.logPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.tickCounter = 0;
        this.transactions = new HashMap<>();
    }

    public final synchronized boolean deleteLogFile(String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Context initContext = HiveCoreInitializer.INSTANCE.getInitContext();
        if (!Resource.INSTANCE.isExistFile(initContext, filePath)) {
            return false;
        }
        return new File(initContext.getFilesDir(), filePath).delete();
    }

    public final synchronized String generateLogFileName() {
        long millis;
        Time time = new Time();
        time.setToNow();
        millis = time.toMillis(false);
        this.tickCounter++;
        if (this.tickCounter > 99) {
            this.tickCounter = 0;
        }
        return "" + millis + this.tickCounter;
    }

    public final synchronized int getLogCount() {
        return this.logDeque.size();
    }

    public final Deque<JSONObject> getLogDeque() {
        return this.logDeque;
    }

    public final String getLogPath() {
        return this.logPath;
    }

    public final synchronized HiveLogTransaction getLogTransaction(int maxLog) {
        HiveLogTransaction hiveLogTransaction;
        String strGenerateLogFileName = generateLogFileName();
        hiveLogTransaction = new HiveLogTransaction(this, this, strGenerateLogFileName);
        this.transactions.put(strGenerateLogFileName, hiveLogTransaction);
        LinkedList linkedList = new LinkedList();
        if (maxLog >= getLogCount()) {
            maxLog = getLogCount();
        }
        for (int i = 0; i < maxLog; i++) {
            JSONObject jSONObjectPopLogs = popLogs();
            if (jSONObjectPopLogs != null) {
                linkedList.add(jSONObjectPopLogs);
            }
        }
        hiveLogTransaction.setLogDeque(linkedList);
        return hiveLogTransaction;
    }

    public final String[] getSavedLogFileList(int maxCount) {
        File file = new File(HiveCoreInitializer.INSTANCE.getInitContext().getFilesDir(), this.logPath);
        if (!file.exists()) {
            return new String[0];
        }
        String[] list = file.list();
        if (list == null) {
            return new String[0];
        }
        Arrays.sort(list);
        if (list.length <= maxCount) {
            return list;
        }
        Object[] objArrCopyOf = Arrays.copyOf(list, maxCount);
        Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
        return (String[]) objArrCopyOf;
    }

    public final HashMap<String, Object> getTransactions$hive_service_release() {
        return this.transactions;
    }

    public final synchronized void loadLogFile(boolean isCrypt) {
        byte[] file;
        Log.w("ANALYTICSLOG", " loadLogFile Called ");
        for (String str : getSavedLogFileList(this.LOG_MAX_COUNT)) {
            String str2 = this.logPath + str;
            Context initContext = HiveCoreInitializer.INSTANCE.getInitContext();
            Resource resource = Resource.INSTANCE;
            if (!resource.isExistFile(initContext, str2)) {
                break;
            }
            try {
                file = resource.readFile(new File(initContext.getFilesDir(), str2));
            } catch (Exception e) {
                e.printStackTrace();
                Unit unit = Unit.INSTANCE;
            }
            if (file == null) {
                break;
            }
            Charset charset = Charsets.UTF_8;
            String str3 = new String(file, charset);
            if (isCrypt) {
                Crypto crypto = Crypto.INSTANCE;
                Crypto.HashType hashType = Crypto.HashType.MD5;
                byte[] bytes = str.getBytes(charset);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                str3 = crypto.decryptAES(hashType, crypto.createHash(hashType, bytes), str3);
            }
            JSONArray jSONArray = new JSONArray(str3);
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                this.logDeque.add(jSONArray.getJSONObject(i));
            }
            deleteLogFile(str2);
        }
    }

    public final synchronized JSONObject popLogs() {
        try {
        } catch (Exception unused) {
            return null;
        }
        return this.logDeque.pop();
    }

    public final synchronized boolean pushBackLogs(JSONObject jsonLogData) {
        Intrinsics.checkNotNullParameter(jsonLogData, "jsonLogData");
        this.logDeque.addLast(jsonLogData);
        return true;
    }

    public final synchronized boolean pushFrontLogs(JSONObject jsonLogData) {
        Intrinsics.checkNotNullParameter(jsonLogData, "jsonLogData");
        this.logDeque.addFirst(jsonLogData);
        return true;
    }

    public final synchronized void removeTransaction(String transactionId) {
        Intrinsics.checkNotNullParameter(transactionId, "transactionId");
        this.transactions.remove(transactionId);
    }

    public final synchronized boolean saveLogFile(boolean isCrypt) {
        boolean z;
        String strGenerateLogFileName = generateLogFileName();
        Context initContext = HiveCoreInitializer.INSTANCE.getInitContext();
        String str = this.logPath + strGenerateLogFileName;
        z = false;
        try {
            JSONArray jSONArray = new JSONArray((Collection) this.logDeque);
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                jSONArray.getJSONObject(i);
            }
            String string = jSONArray.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            if (isCrypt) {
                com.hive.base.Crypto crypto = com.hive.base.Crypto.INSTANCE;
                Crypto.HashType hashType = Crypto.HashType.MD5;
                byte[] bytes = strGenerateLogFileName.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                string = crypto.encryptAES(hashType, crypto.createHash(hashType, bytes), string);
            }
            Resource.INSTANCE.writeFile(new File(initContext.getFilesDir(), str), string);
            z = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (z) {
            this.logDeque.clear();
        }
        return z;
    }

    public final void setLogDeque(Deque<JSONObject> deque) {
        Intrinsics.checkNotNullParameter(deque, "<set-?>");
        this.logDeque = deque;
    }

    public final void setLogPath(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.logPath = str;
    }

    public final void setTransactions$hive_service_release(HashMap<String, Object> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.transactions = map;
    }
}
