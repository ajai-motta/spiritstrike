package androidx.emoji2.text;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import androidx.core.graphics.TypefaceCompatUtil;
import androidx.core.os.TraceCompat;
import androidx.core.provider.FontRequest;
import androidx.core.provider.FontsContractCompat;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.EmojiCompat;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public class FontRequestEmojiCompatConfig extends EmojiCompat.Config {
    private static final FontProviderHelper DEFAULT_FONTS_CONTRACT = new FontProviderHelper();

    public static abstract class RetryPolicy {
        public abstract long getRetryDelay();
    }

    public static class ExponentialBackoffRetryPolicy extends RetryPolicy {
        private long mRetryOrigin;
        private final long mTotalMs;

        public ExponentialBackoffRetryPolicy(long totalMs) {
            this.mTotalMs = totalMs;
        }

        @Override // androidx.emoji2.text.FontRequestEmojiCompatConfig.RetryPolicy
        public long getRetryDelay() {
            if (this.mRetryOrigin == 0) {
                this.mRetryOrigin = SystemClock.uptimeMillis();
                return 0L;
            }
            long jUptimeMillis = SystemClock.uptimeMillis() - this.mRetryOrigin;
            if (jUptimeMillis > this.mTotalMs) {
                return -1L;
            }
            return Math.min(Math.max(jUptimeMillis, 1000L), this.mTotalMs - jUptimeMillis);
        }
    }

    public FontRequestEmojiCompatConfig(Context context, FontRequest request) {
        super(new FontRequestMetadataLoader(context, request, DEFAULT_FONTS_CONTRACT));
    }

    public FontRequestEmojiCompatConfig(Context context, FontRequest request, FontProviderHelper fontProviderHelper) {
        super(new FontRequestMetadataLoader(context, request, fontProviderHelper));
    }

    public FontRequestEmojiCompatConfig setHandler(Handler handler) {
        ((FontRequestMetadataLoader) getMetadataRepoLoader()).setHandler(handler);
        return this;
    }

    public FontRequestEmojiCompatConfig setRetryPolicy(RetryPolicy policy) {
        ((FontRequestMetadataLoader) getMetadataRepoLoader()).setRetryPolicy(policy);
        return this;
    }

    private static class FontRequestMetadataLoader implements EmojiCompat.MetadataRepoLoader {
        private static final String S_TRACE_BUILD_TYPEFACE = "EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface";
        private static final String S_TRACE_THREAD_CREATION = "EmojiCompat.FontRequestEmojiCompatConfig.threadCreation";
        EmojiCompat.MetadataRepoLoaderCallback mCallback;
        private final Context mContext;
        private final FontProviderHelper mFontProviderHelper;
        private Runnable mHandleMetadataCreationRunner;
        private Handler mHandler;
        private final Object mLock = new Object();
        private ContentObserver mObserver;
        private final FontRequest mRequest;
        private RetryPolicy mRetryPolicy;
        private HandlerThread mThread;

        FontRequestMetadataLoader(Context context, FontRequest request, FontProviderHelper fontProviderHelper) {
            Preconditions.checkNotNull(context, "Context cannot be null");
            Preconditions.checkNotNull(request, "FontRequest cannot be null");
            this.mContext = context.getApplicationContext();
            this.mRequest = request;
            this.mFontProviderHelper = fontProviderHelper;
        }

        public void setHandler(Handler handler) {
            synchronized (this.mLock) {
                this.mHandler = handler;
            }
        }

        public void setRetryPolicy(RetryPolicy policy) {
            synchronized (this.mLock) {
                this.mRetryPolicy = policy;
            }
        }

        @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoader
        public void load(final EmojiCompat.MetadataRepoLoaderCallback loaderCallback) {
            Preconditions.checkNotNull(loaderCallback, "LoaderCallback cannot be null");
            synchronized (this.mLock) {
                try {
                    TraceCompat.beginSection(S_TRACE_THREAD_CREATION);
                    if (this.mHandler == null) {
                        HandlerThread handlerThread = new HandlerThread("emojiCompat", 10);
                        this.mThread = handlerThread;
                        handlerThread.start();
                        this.mHandler = new Handler(this.mThread.getLooper());
                    }
                    TraceCompat.endSection();
                    this.mHandler.post(new Runnable() { // from class: androidx.emoji2.text.FontRequestEmojiCompatConfig.FontRequestMetadataLoader.1
                        @Override // java.lang.Runnable
                        public void run() {
                            FontRequestMetadataLoader.this.mCallback = loaderCallback;
                            FontRequestMetadataLoader.this.createMetadata();
                        }
                    });
                } catch (Throwable th) {
                    TraceCompat.endSection();
                    throw th;
                }
            }
        }

        private FontsContractCompat.FontInfo retrieveFontInfo() {
            try {
                FontsContractCompat.FontFamilyResult fontFamilyResultFetchFonts = this.mFontProviderHelper.fetchFonts(this.mContext, this.mRequest);
                if (fontFamilyResultFetchFonts.getStatusCode() != 0) {
                    throw new RuntimeException("fetchFonts failed (" + fontFamilyResultFetchFonts.getStatusCode() + ")");
                }
                FontsContractCompat.FontInfo[] fonts = fontFamilyResultFetchFonts.getFonts();
                if (fonts == null || fonts.length == 0) {
                    throw new RuntimeException("fetchFonts failed (empty result)");
                }
                return fonts[0];
            } catch (PackageManager.NameNotFoundException e) {
                throw new RuntimeException("provider not found", e);
            }
        }

        private void scheduleRetry(Uri uri, long waitMs) {
            synchronized (this.mLock) {
                if (this.mObserver == null) {
                    ContentObserver contentObserver = new ContentObserver(this.mHandler) { // from class: androidx.emoji2.text.FontRequestEmojiCompatConfig.FontRequestMetadataLoader.2
                        @Override // android.database.ContentObserver
                        public void onChange(boolean selfChange, Uri uri2) {
                            FontRequestMetadataLoader.this.createMetadata();
                        }
                    };
                    this.mObserver = contentObserver;
                    this.mFontProviderHelper.registerObserver(this.mContext, uri, contentObserver);
                }
                if (this.mHandleMetadataCreationRunner == null) {
                    this.mHandleMetadataCreationRunner = new Runnable() { // from class: androidx.emoji2.text.FontRequestEmojiCompatConfig.FontRequestMetadataLoader.3
                        @Override // java.lang.Runnable
                        public void run() {
                            FontRequestMetadataLoader.this.createMetadata();
                        }
                    };
                }
                this.mHandler.postDelayed(this.mHandleMetadataCreationRunner, waitMs);
            }
        }

        private void cleanUp() {
            this.mCallback = null;
            ContentObserver contentObserver = this.mObserver;
            if (contentObserver != null) {
                this.mFontProviderHelper.unregisterObserver(this.mContext, contentObserver);
                this.mObserver = null;
            }
            synchronized (this.mLock) {
                this.mHandler.removeCallbacks(this.mHandleMetadataCreationRunner);
                HandlerThread handlerThread = this.mThread;
                if (handlerThread != null) {
                    handlerThread.quit();
                }
                this.mHandler = null;
                this.mThread = null;
            }
        }

        void createMetadata() {
            if (this.mCallback == null) {
                return;
            }
            try {
                FontsContractCompat.FontInfo fontInfoRetrieveFontInfo = retrieveFontInfo();
                int resultCode = fontInfoRetrieveFontInfo.getResultCode();
                if (resultCode == 2) {
                    synchronized (this.mLock) {
                        RetryPolicy retryPolicy = this.mRetryPolicy;
                        if (retryPolicy != null) {
                            long retryDelay = retryPolicy.getRetryDelay();
                            if (retryDelay >= 0) {
                                scheduleRetry(fontInfoRetrieveFontInfo.getUri(), retryDelay);
                                return;
                            }
                        }
                    }
                }
                if (resultCode != 0) {
                    throw new RuntimeException("fetchFonts result is not OK. (" + resultCode + ")");
                }
                try {
                    TraceCompat.beginSection(S_TRACE_BUILD_TYPEFACE);
                    Typeface typefaceBuildTypeface = this.mFontProviderHelper.buildTypeface(this.mContext, fontInfoRetrieveFontInfo);
                    ByteBuffer byteBufferMmap = TypefaceCompatUtil.mmap(this.mContext, null, fontInfoRetrieveFontInfo.getUri());
                    if (byteBufferMmap == null) {
                        throw new RuntimeException("Unable to open file.");
                    }
                    MetadataRepo metadataRepoCreate = MetadataRepo.create(typefaceBuildTypeface, byteBufferMmap);
                    TraceCompat.endSection();
                    this.mCallback.onLoaded(metadataRepoCreate);
                    cleanUp();
                } catch (Throwable th) {
                    TraceCompat.endSection();
                    throw th;
                }
            } catch (Throwable th2) {
                this.mCallback.onFailed(th2);
                cleanUp();
            }
        }
    }

    public static class FontProviderHelper {
        public FontsContractCompat.FontFamilyResult fetchFonts(Context context, FontRequest request) throws PackageManager.NameNotFoundException {
            return FontsContractCompat.fetchFonts(context, null, request);
        }

        public Typeface buildTypeface(Context context, FontsContractCompat.FontInfo font) throws PackageManager.NameNotFoundException {
            return FontsContractCompat.buildTypeface(context, null, new FontsContractCompat.FontInfo[]{font});
        }

        public void registerObserver(Context context, Uri uri, ContentObserver observer) {
            context.getContentResolver().registerContentObserver(uri, false, observer);
        }

        public void unregisterObserver(Context context, ContentObserver observer) {
            context.getContentResolver().unregisterContentObserver(observer);
        }
    }
}
