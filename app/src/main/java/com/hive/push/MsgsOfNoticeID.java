package com.hive.push;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.hive.logger.LoggerImpl;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\n0\b2\u0006\u0010\u000b\u001a\u00020\fH\u0002J*\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\f2\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\n0\bH\u0002J)\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0005¢\u0006\u0002\u0010\u0013J\u0016\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\tJ\u000e\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/hive/push/MsgsOfNoticeID;", "", "<init>", "()V", "fileName", "", "TAG", "loadingMsgsData", "Ljava/util/LinkedHashMap;", "", "", "context", "Landroid/content/Context;", "savingMsgsData", "", "msgsMap", "addMsg", "noticeID", NotificationCompat.CATEGORY_MESSAGE, "(Landroid/content/Context;ILjava/lang/String;)[Ljava/lang/String;", "clearMsgs", "clearAllMsgs", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MsgsOfNoticeID {
    public static final MsgsOfNoticeID INSTANCE = new MsgsOfNoticeID();
    private static final String TAG = "MsgsOfNoticeID";
    private static final String fileName = "msgsMap.dat";

    private MsgsOfNoticeID() {
    }

    private final synchronized LinkedHashMap<Integer, String[]> loadingMsgsData(Context context) {
        ObjectInputStream objectInputStream;
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.d(TAG, "loading msgs data");
        new LinkedHashMap();
        ObjectInputStream objectInputStream2 = null;
        try {
            try {
                objectInputStream = new ObjectInputStream(context.openFileInput(fileName));
                try {
                    Object object = objectInputStream.readObject();
                    Intrinsics.checkNotNull(object, "null cannot be cast to non-null type java.util.LinkedHashMap<kotlin.Int, kotlin.Array<kotlin.String>>");
                    LinkedHashMap<Integer, String[]> linkedHashMap = (LinkedHashMap) object;
                    loggerImpl.d(TAG, "loading msgsMap data success");
                    try {
                        objectInputStream.close();
                        return linkedHashMap;
                    } catch (Exception e) {
                        LoggerImpl.INSTANCE.w(TAG, e.toString());
                        return linkedHashMap;
                    }
                } catch (Exception e2) {
                    e = e2;
                    objectInputStream2 = objectInputStream;
                    LoggerImpl loggerImpl2 = LoggerImpl.INSTANCE;
                    loggerImpl2.w(TAG, e.toString());
                    LinkedHashMap<Integer, String[]> linkedHashMap2 = new LinkedHashMap<>();
                    loggerImpl2.w(TAG, "loading msgsMap data fail");
                    if (objectInputStream2 != null) {
                        try {
                            objectInputStream2.close();
                        } catch (Exception e3) {
                            LoggerImpl.INSTANCE.w(TAG, e3.toString());
                        }
                    }
                    return linkedHashMap2;
                } catch (Throwable th) {
                    th = th;
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (Exception e4) {
                            LoggerImpl.INSTANCE.w(TAG, e4.toString());
                        }
                    }
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
            }
        } catch (Throwable th2) {
            th = th2;
            objectInputStream = objectInputStream2;
        }
    }

    private final synchronized boolean savingMsgsData(Context context, LinkedHashMap<Integer, String[]> msgsMap) {
        ObjectOutputStream objectOutputStream;
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.d(TAG, "saving msgs Data");
        ObjectOutputStream objectOutputStream2 = null;
        try {
            try {
                objectOutputStream = new ObjectOutputStream(context.openFileOutput(fileName, 0));
                try {
                    objectOutputStream.writeObject(msgsMap);
                    loggerImpl.d(TAG, "savingMsgsData is true");
                    try {
                        objectOutputStream.close();
                        return true;
                    } catch (Exception e) {
                        LoggerImpl.INSTANCE.w(TAG, e.toString());
                        return true;
                    }
                } catch (Exception unused) {
                    objectOutputStream2 = objectOutputStream;
                    LoggerImpl.INSTANCE.w(TAG, "savingMsgsData is false");
                    if (objectOutputStream2 != null) {
                        try {
                            objectOutputStream2.close();
                        } catch (Exception e2) {
                            LoggerImpl.INSTANCE.w(TAG, e2.toString());
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (Exception e3) {
                            LoggerImpl.INSTANCE.w(TAG, e3.toString());
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                objectOutputStream = objectOutputStream2;
            }
        } catch (Exception unused2) {
        }
    }

    public final synchronized String[] addMsg(Context context, int noticeID, String msg) {
        String[] strArr;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msg, "msg");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.d(TAG, "add Msgs Data");
        LinkedHashMap<Integer, String[]> linkedHashMapLoadingMsgsData = loadingMsgsData(context);
        try {
            String[] strArr2 = linkedHashMapLoadingMsgsData.containsKey(Integer.valueOf(noticeID)) ? linkedHashMapLoadingMsgsData.get(Integer.valueOf(noticeID)) : null;
            if (strArr2 != null) {
                int length = strArr2.length + 1;
                strArr = new String[length];
                for (int i = 0; i < length; i++) {
                    strArr[i] = "";
                }
                int length2 = strArr2.length;
                for (int i2 = 0; i2 < length2; i2++) {
                    strArr[i2] = strArr2[i2];
                    LoggerImpl.INSTANCE.d(TAG, "newSeqArray[" + i2 + "] : " + strArr[i2]);
                }
                strArr[strArr2.length] = msg;
                LoggerImpl.INSTANCE.d(TAG, "newSeqArray[" + strArr2.length + "] : " + strArr[strArr2.length]);
            } else {
                loggerImpl.d(TAG, "oldSeqArray is null");
                strArr = new String[]{msg};
            }
            if (linkedHashMapLoadingMsgsData.containsKey(Integer.valueOf(noticeID))) {
                linkedHashMapLoadingMsgsData.remove(Integer.valueOf(noticeID));
            }
            linkedHashMapLoadingMsgsData.put(Integer.valueOf(noticeID), strArr);
            savingMsgsData(context, linkedHashMapLoadingMsgsData);
        } catch (Exception e) {
            LoggerImpl.INSTANCE.w(TAG, e.toString());
            return new String[]{""};
        }
        return strArr;
    }

    public final synchronized boolean clearAllMsgs(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        LoggerImpl.INSTANCE.d(TAG, "clear all Msgs Data");
        try {
        } catch (Exception e) {
            LoggerImpl.INSTANCE.w(TAG, e.toString());
            return false;
        }
        return context.deleteFile(fileName);
    }

    public final synchronized boolean clearMsgs(Context context, int noticeID) {
        Intrinsics.checkNotNullParameter(context, "context");
        LoggerImpl.INSTANCE.d(TAG, "clear Msgs Data");
        LinkedHashMap<Integer, String[]> linkedHashMapLoadingMsgsData = loadingMsgsData(context);
        try {
            if ((linkedHashMapLoadingMsgsData.containsKey(Integer.valueOf(noticeID)) ? linkedHashMapLoadingMsgsData.get(Integer.valueOf(noticeID)) : null) == null) {
                return true;
            }
            linkedHashMapLoadingMsgsData.remove(Integer.valueOf(noticeID));
            return savingMsgsData(context, linkedHashMapLoadingMsgsData);
        } catch (Exception e) {
            LoggerImpl.INSTANCE.w(TAG, e.toString());
            return false;
        }
    }
}
