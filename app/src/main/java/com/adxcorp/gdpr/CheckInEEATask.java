package com.adxcorp.gdpr;

import android.util.Log;
import com.adxcorp.gdpr.ADXGDPR;
import com.adxcorp.util.ADXAsyncTaskUtil;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class CheckInEEATask {
    private static final String CHECKING_SERVER_URL = "https://adservice.google.com/getconfig/pubvendors";
    private static final String KEY_EEA_OR_UNKNOWN = "is_request_in_eea_or_unknown";
    private static final String TAG = "CheckInEEATask";
    private ADXGDPR.ADXLocate info;
    private CheckInEEAListener mCheckInEEAListener;

    public interface CheckInEEAListener {
        void onResult(ADXGDPR.ADXLocate aDXLocate);
    }

    public CheckInEEATask(CheckInEEAListener checkInEEAListener) {
        this.mCheckInEEAListener = checkInEEAListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String readStream(InputStream inputStream) {
        byte[] bArr = new byte[1024];
        StringBuilder sb = new StringBuilder();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        while (true) {
            try {
                try {
                    int i = bufferedInputStream.read(bArr);
                    if (i != -1) {
                        sb.append(new String(bArr, 0, i));
                    } else {
                        try {
                            break;
                        } catch (IOException e) {
                        }
                    }
                } catch (IOException e2) {
                    Log.e(TAG, e2.getLocalizedMessage());
                    try {
                        bufferedInputStream.close();
                        return null;
                    } catch (IOException e3) {
                        Log.e(TAG, e3.getLocalizedMessage());
                        return null;
                    }
                }
            } finally {
                try {
                    bufferedInputStream.close();
                } catch (IOException e4) {
                    Log.e(TAG, e4.getLocalizedMessage());
                }
            }
        }
        return sb.toString();
    }

    public void execute() {
        new ADXAsyncTaskUtil() { // from class: com.adxcorp.gdpr.CheckInEEATask.1
            @Override // com.adxcorp.util.ADXAsyncTaskUtil
            public void doInBackground() {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(CheckInEEATask.CHECKING_SERVER_URL).openConnection();
                    httpURLConnection.setConnectTimeout(15000);
                    httpURLConnection.setReadTimeout(15000);
                    if (httpURLConnection.getResponseCode() == 200) {
                        String stream = CheckInEEATask.this.readStream(httpURLConnection.getInputStream());
                        httpURLConnection.disconnect();
                        if (new JSONObject(stream).getBoolean(CheckInEEATask.KEY_EEA_OR_UNKNOWN)) {
                            CheckInEEATask.this.info = ADXGDPR.ADXLocate.ADXLocateInEEAorUnknown;
                        } else {
                            CheckInEEATask.this.info = ADXGDPR.ADXLocate.ADXLocateNotEEA;
                        }
                    } else {
                        CheckInEEATask.this.info = ADXGDPR.ADXLocate.ADXLocateCheckFail;
                    }
                } catch (Exception unused) {
                    CheckInEEATask.this.info = ADXGDPR.ADXLocate.ADXLocateCheckFail;
                }
            }

            @Override // com.adxcorp.util.ADXAsyncTaskUtil
            public void doInUiThread() {
                if (CheckInEEATask.this.mCheckInEEAListener != null) {
                    CheckInEEATask.this.mCheckInEEAListener.onResult(CheckInEEATask.this.info);
                }
            }
        }.execute();
    }
}
