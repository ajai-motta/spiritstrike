package com.bytedance.adsdk.ud.mml;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: loaded from: classes.dex */
public class ud implements mo {
    @Override // com.bytedance.adsdk.ud.mml.mo
    public mml qdl(String str) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.connect();
        return new qdl(httpURLConnection);
    }
}
