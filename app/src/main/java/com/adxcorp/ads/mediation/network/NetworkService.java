package com.adxcorp.ads.mediation.network;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.adxcorp.ads.mediation.MediationSDK;
import com.adxcorp.util.ADXLogUtil;
import kotlin.text.Typography;
import kotlinx.io.files.FileSystemKt;

/* JADX INFO: loaded from: classes2.dex */
public class NetworkService implements Runnable {
    public static final String TAG = "NetworkService";
    private String mEncodedParam;
    private Handler mHandler;
    private String mMethod;
    private String mRequestUrl;
    private Thread thread = null;
    private Thread timerThread = null;
    private int responseCode = -1;
    private boolean isSuccessOpenConnection = false;

    public NetworkService(String str, String str2, Handler handler, String str3) {
        this.mRequestUrl = null;
        this.mMethod = null;
        this.mEncodedParam = null;
        this.mHandler = null;
        if (TextUtils.isEmpty(str3)) {
            this.mRequestUrl = null;
        } else if (str3.equalsIgnoreCase("GET")) {
            this.mRequestUrl = appendParameter(str, str2);
        } else if (str3.equalsIgnoreCase("POST")) {
            this.mRequestUrl = str;
            this.mEncodedParam = str2;
        }
        this.mMethod = str3;
        this.mHandler = handler;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x029c A[PHI: r0
  0x029c: PHI (r0v12 java.lang.Thread) = (r0v10 java.lang.Thread), (r0v25 java.lang.Thread) binds: [B:100:0x029a, B:65:0x01de] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x02d9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01d9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x02e3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:147:0x02de A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x028b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01ca A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0286 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0295 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x02d4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01d4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0290 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x02cf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x01cf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:167:0x01c5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0281 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00e7 A[Catch: all -> 0x01e2, Exception -> 0x01eb, TRY_LEAVE, TryCatch #28 {Exception -> 0x01eb, all -> 0x01e2, blocks: (B:25:0x00dd, B:27:0x00e7, B:45:0x015b, B:47:0x0169, B:48:0x0196, B:19:0x00be), top: B:171:0x00be }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x015b A[Catch: all -> 0x01e2, Exception -> 0x01eb, TRY_ENTER, TryCatch #28 {Exception -> 0x01eb, all -> 0x01e2, blocks: (B:25:0x00dd, B:27:0x00e7, B:45:0x015b, B:47:0x0169, B:48:0x0196, B:19:0x00be), top: B:171:0x00be }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x021f A[Catch: all -> 0x02a4, TryCatch #1 {all -> 0x02a4, blocks: (B:81:0x0211, B:83:0x021f, B:84:0x0254), top: B:139:0x0211 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0265  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 754
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adxcorp.ads.mediation.network.NetworkService.run():void");
    }

    private String appendParameter(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        if (str.indexOf(58) + 2 == str.lastIndexOf(47)) {
            sb.append(FileSystemKt.UnixPathSeparator);
        }
        int iIndexOf = str.indexOf(63);
        int length = sb.length() - 1;
        if (iIndexOf == -1) {
            sb.append('?');
        } else if (iIndexOf < length && str.charAt(length) != '&') {
            sb.append(Typography.amp);
        }
        sb.append(str2);
        return sb.toString();
    }

    public void process() {
        if (TextUtils.isEmpty(this.mMethod)) {
            if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                ADXLogUtil.e(TAG, new Exception("Undefined http method."));
            }
            gotFailureMessage();
            NetworkServiceManager.getInstance().didComplete(this);
            return;
        }
        if (!this.mMethod.equalsIgnoreCase("GET") && !this.mMethod.equalsIgnoreCase("POST")) {
            gotFailureMessage();
            NetworkServiceManager.getInstance().didComplete(this);
            return;
        }
        if (TextUtils.isEmpty(this.mRequestUrl)) {
            if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                ADXLogUtil.e(TAG, new Exception("Request url cannot be null."));
            }
            gotFailureMessage();
            NetworkServiceManager.getInstance().didComplete(this);
            return;
        }
        Thread thread = new Thread(this);
        this.thread = thread;
        thread.start();
        Thread thread2 = new Thread(new Runnable() { // from class: com.adxcorp.ads.mediation.network.NetworkService.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                        ADXLogUtil.d(NetworkService.TAG, "[" + NetworkService.this.mMethod + "]<<url>>" + NetworkService.this.mRequestUrl + " -> (start timer)");
                    }
                    Thread.sleep(3000L);
                    if (!NetworkService.this.isSuccessOpenConnection) {
                        if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                            ADXLogUtil.d(NetworkService.TAG, "[" + NetworkService.this.mMethod + "]<<url>>" + NetworkService.this.mRequestUrl + " -> (connection timeout)");
                        }
                        NetworkService.this.gotFailureMessage();
                    }
                } catch (InterruptedException unused) {
                }
                NetworkService.this.timerThread = null;
            }
        });
        this.timerThread = thread2;
        thread2.start();
    }

    public void gotFailureMessage() {
        try {
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.sendMessage(Message.obtain(handler, -1));
            }
            this.mHandler = null;
        } catch (Exception e) {
            if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                ADXLogUtil.e(TAG, e);
            }
        }
    }

    public void gotSuccessMessage(String str) {
        try {
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.sendMessage(Message.obtain(handler, 200, str));
            }
            this.mHandler = null;
        } catch (Exception e) {
            if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                ADXLogUtil.e(TAG, e);
            }
        }
    }
}
