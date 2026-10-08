package androidx.emoji2.text;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import androidx.core.os.TraceCompat;
import androidx.emoji2.text.EmojiCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ProcessLifecycleInitializer;
import androidx.startup.AppInitializer;
import androidx.startup.Initializer;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class EmojiCompatInitializer implements Initializer<Boolean> {
    private static final long STARTUP_THREAD_CREATION_DELAY_MS = 500;
    private static final String S_INITIALIZER_THREAD_NAME = "EmojiCompatInitializer";

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.startup.Initializer
    public Boolean create(Context context) {
        EmojiCompat.init(new BackgroundDefaultConfig(context));
        delayUntilFirstResume(context);
        return true;
    }

    void delayUntilFirstResume(Context context) {
        final Lifecycle lifecycle = ((LifecycleOwner) AppInitializer.getInstance(context).initializeComponent(ProcessLifecycleInitializer.class)).getLifecycle();
        lifecycle.addObserver(new LifecycleObserver() { // from class: androidx.emoji2.text.EmojiCompatInitializer.1
            @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
            public void onResume() {
                EmojiCompatInitializer.this.loadEmojiCompatAfterDelay();
                lifecycle.removeObserver(this);
            }
        });
    }

    void loadEmojiCompatAfterDelay() {
        Handler handler;
        if (Build.VERSION.SDK_INT >= 28) {
            handler = Handler28Impl.createAsync(Looper.getMainLooper());
        } else {
            handler = new Handler(Looper.getMainLooper());
        }
        handler.postDelayed(new LoadEmojiCompatRunnable(), 500L);
    }

    @Override // androidx.startup.Initializer
    public List<Class<? extends Initializer<?>>> dependencies() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }

    static class LoadEmojiCompatRunnable implements Runnable {
        LoadEmojiCompatRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                TraceCompat.beginSection("EmojiCompat.EmojiCompatInitializer.run");
                if (EmojiCompat.isConfigured()) {
                    EmojiCompat.get().load();
                }
            } finally {
                TraceCompat.endSection();
            }
        }
    }

    static class BackgroundDefaultConfig extends EmojiCompat.Config {
        protected BackgroundDefaultConfig(Context context) {
            super(new BackgroundDefaultLoader(context));
            setMetadataLoadStrategy(1);
        }
    }

    static class BackgroundDefaultLoader implements EmojiCompat.MetadataRepoLoader {
        private final Context mContext;
        private HandlerThread mThread;

        BackgroundDefaultLoader(Context context) {
            this.mContext = context.getApplicationContext();
        }

        @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoader
        public void load(final EmojiCompat.MetadataRepoLoaderCallback loaderCallback) {
            final Handler threadHandler = getThreadHandler();
            threadHandler.post(new Runnable() { // from class: androidx.emoji2.text.EmojiCompatInitializer$BackgroundDefaultLoader$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m4191x5cc8028a(loaderCallback, threadHandler);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX INFO: renamed from: doLoad, reason: merged with bridge method [inline-methods] */
        public void m4191x5cc8028a(final EmojiCompat.MetadataRepoLoaderCallback loaderCallback, Handler handler) {
            try {
                FontRequestEmojiCompatConfig fontRequestEmojiCompatConfigCreate = DefaultEmojiCompatConfig.create(this.mContext);
                if (fontRequestEmojiCompatConfigCreate == null) {
                    throw new RuntimeException("EmojiCompat font provider not available on this device.");
                }
                fontRequestEmojiCompatConfigCreate.setHandler(handler);
                fontRequestEmojiCompatConfigCreate.getMetadataRepoLoader().load(new EmojiCompat.MetadataRepoLoaderCallback() { // from class: androidx.emoji2.text.EmojiCompatInitializer.BackgroundDefaultLoader.1
                    @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoaderCallback
                    public void onLoaded(MetadataRepo metadataRepo) {
                        try {
                            loaderCallback.onLoaded(metadataRepo);
                        } finally {
                            BackgroundDefaultLoader.this.quitHandlerThread();
                        }
                    }

                    @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoaderCallback
                    public void onFailed(Throwable throwable) {
                        try {
                            loaderCallback.onFailed(throwable);
                        } finally {
                            BackgroundDefaultLoader.this.quitHandlerThread();
                        }
                    }
                });
            } catch (Throwable th) {
                loaderCallback.onFailed(th);
                quitHandlerThread();
            }
        }

        void quitHandlerThread() {
            HandlerThread handlerThread = this.mThread;
            if (handlerThread != null) {
                handlerThread.quitSafely();
            }
        }

        private Handler getThreadHandler() {
            HandlerThread handlerThread = new HandlerThread(EmojiCompatInitializer.S_INITIALIZER_THREAD_NAME, 10);
            this.mThread = handlerThread;
            handlerThread.start();
            return new Handler(this.mThread.getLooper());
        }
    }

    private static class Handler28Impl {
        private Handler28Impl() {
        }

        public static Handler createAsync(Looper looper) {
            return Handler.createAsync(looper);
        }
    }
}
