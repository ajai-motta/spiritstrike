package com.applovin.mediation.adapters.adpie;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.adxcorp.util.ADXAsyncTaskUtil;
import com.adxcorp.util.ADXLogUtil;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes2.dex */
public class DrawableDownloadUtil {
    private static final long DRAWABLE_FUTURE_TIMEOUT_MILLISECONDS = 3000;
    public static final String KEY_ICON = "icon_key";
    public static final String KEY_MAIN_IMAGE = "main_image_key";
    public static final String KEY_PRIVACY_ICON = "privacy_icon_key";
    private static final String TAG = "DrawableDownloadUtil";
    private final DrawableDownloadListener mListener;
    private HashMap<String, Drawable> resultMap = null;

    public DrawableDownloadUtil(DrawableDownloadListener drawableDownloadListener) {
        this.mListener = drawableDownloadListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Future<Drawable> getDrawableFuture(final URL url, ExecutorService executorService) {
        return executorService.submit(new Callable<Drawable>() { // from class: com.applovin.mediation.adapters.adpie.DrawableDownloadUtil.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Drawable call() throws Exception {
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(url.openStream());
                bitmapDecodeStream.setDensity(160);
                return new BitmapDrawable(Resources.getSystem(), bitmapDecodeStream);
            }
        });
    }

    public void execute(final HashMap<String, URL> map) {
        new ADXAsyncTaskUtil() { // from class: com.applovin.mediation.adapters.adpie.DrawableDownloadUtil.2
            @Override // com.adxcorp.util.ADXAsyncTaskUtil
            public void doInBackground() {
                ExecutorService executorServiceNewCachedThreadPool = Executors.newCachedThreadPool();
                try {
                    HashMap map2 = new HashMap();
                    if (map.containsKey(DrawableDownloadUtil.KEY_MAIN_IMAGE)) {
                        map2.put(DrawableDownloadUtil.KEY_MAIN_IMAGE, (Drawable) DrawableDownloadUtil.this.getDrawableFuture((URL) map.get(DrawableDownloadUtil.KEY_MAIN_IMAGE), executorServiceNewCachedThreadPool).get(3000L, TimeUnit.MILLISECONDS));
                    }
                    if (map.containsKey(DrawableDownloadUtil.KEY_ICON)) {
                        map2.put(DrawableDownloadUtil.KEY_ICON, (Drawable) DrawableDownloadUtil.this.getDrawableFuture((URL) map.get(DrawableDownloadUtil.KEY_ICON), executorServiceNewCachedThreadPool).get(3000L, TimeUnit.MILLISECONDS));
                    }
                    if (map.containsKey(DrawableDownloadUtil.KEY_PRIVACY_ICON)) {
                        map2.put(DrawableDownloadUtil.KEY_PRIVACY_ICON, (Drawable) DrawableDownloadUtil.this.getDrawableFuture((URL) map.get(DrawableDownloadUtil.KEY_PRIVACY_ICON), executorServiceNewCachedThreadPool).get(3000L, TimeUnit.MILLISECONDS));
                    }
                    DrawableDownloadUtil.this.resultMap = map2;
                } catch (InterruptedException e) {
                    e = e;
                    ADXLogUtil.d(DrawableDownloadUtil.TAG, "Native ad images failed to download. " + e.toString());
                    DrawableDownloadUtil.this.resultMap = null;
                } catch (ExecutionException e2) {
                    e = e2;
                    ADXLogUtil.d(DrawableDownloadUtil.TAG, "Native ad images failed to download. " + e.toString());
                    DrawableDownloadUtil.this.resultMap = null;
                } catch (TimeoutException e3) {
                    e = e3;
                    ADXLogUtil.d(DrawableDownloadUtil.TAG, "Native ad images failed to download. " + e.toString());
                    DrawableDownloadUtil.this.resultMap = null;
                } catch (Exception e4) {
                    ADXLogUtil.d(DrawableDownloadUtil.TAG, "Native ad images failed to download. " + e4.toString());
                    DrawableDownloadUtil.this.resultMap = null;
                }
            }

            @Override // com.adxcorp.util.ADXAsyncTaskUtil
            public void doInUiThread() {
                if (DrawableDownloadUtil.this.resultMap != null) {
                    DrawableDownloadUtil.this.mListener.onDownloadSuccess(DrawableDownloadUtil.this.resultMap);
                } else {
                    DrawableDownloadUtil.this.mListener.onDownloadFailure();
                }
            }
        }.execute();
    }
}
