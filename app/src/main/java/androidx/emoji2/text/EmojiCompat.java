package androidx.emoji2.text;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.collection.ArraySet;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.DefaultEmojiCompatConfig;
import androidx.emoji2.text.EmojiProcessor;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes2.dex */
public class EmojiCompat {
    public static final String EDITOR_INFO_METAVERSION_KEY = "android.support.text.emoji.emojiCompat_metadataVersion";
    public static final String EDITOR_INFO_REPLACE_ALL_KEY = "android.support.text.emoji.emojiCompat_replaceAll";
    static final int EMOJI_COUNT_UNLIMITED = Integer.MAX_VALUE;
    public static final int LOAD_STATE_DEFAULT = 3;
    public static final int LOAD_STATE_FAILED = 2;
    public static final int LOAD_STATE_LOADING = 0;
    public static final int LOAD_STATE_SUCCEEDED = 1;
    public static final int LOAD_STRATEGY_DEFAULT = 0;
    public static final int LOAD_STRATEGY_MANUAL = 1;
    public static final int REPLACE_STRATEGY_ALL = 1;
    public static final int REPLACE_STRATEGY_DEFAULT = 0;
    public static final int REPLACE_STRATEGY_NON_EXISTENT = 2;
    private static volatile boolean sHasDoneDefaultConfigLookup;
    private static volatile EmojiCompat sInstance;
    final int[] mEmojiAsDefaultStyleExceptions;
    private final int mEmojiSpanIndicatorColor;
    private final boolean mEmojiSpanIndicatorEnabled;
    private final GlyphChecker mGlyphChecker;
    private final CompatInternal mHelper;
    private final Set<InitCallback> mInitCallbacks;
    private final ReadWriteLock mInitLock = new ReentrantReadWriteLock();
    private volatile int mLoadState = 3;
    private final Handler mMainHandler = new Handler(Looper.getMainLooper());
    private final int mMetadataLoadStrategy;
    final MetadataRepoLoader mMetadataLoader;
    final boolean mReplaceAll;
    final boolean mUseEmojiAsDefaultStyle;
    private static final Object INSTANCE_LOCK = new Object();
    private static final Object CONFIG_LOCK = new Object();

    public interface GlyphChecker {
        boolean hasGlyph(CharSequence charSequence, int start, int end, int sdkAdded);
    }

    public static abstract class InitCallback {
        public void onFailed(Throwable throwable) {
        }

        public void onInitialized() {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface LoadStrategy {
    }

    public interface MetadataRepoLoader {
        void load(MetadataRepoLoaderCallback loaderCallback);
    }

    public static abstract class MetadataRepoLoaderCallback {
        public abstract void onFailed(Throwable throwable);

        public abstract void onLoaded(MetadataRepo metadataRepo);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ReplaceStrategy {
    }

    private EmojiCompat(final Config config) {
        this.mReplaceAll = config.mReplaceAll;
        this.mUseEmojiAsDefaultStyle = config.mUseEmojiAsDefaultStyle;
        this.mEmojiAsDefaultStyleExceptions = config.mEmojiAsDefaultStyleExceptions;
        this.mEmojiSpanIndicatorEnabled = config.mEmojiSpanIndicatorEnabled;
        this.mEmojiSpanIndicatorColor = config.mEmojiSpanIndicatorColor;
        this.mMetadataLoader = config.mMetadataLoader;
        this.mMetadataLoadStrategy = config.mMetadataLoadStrategy;
        this.mGlyphChecker = config.mGlyphChecker;
        ArraySet arraySet = new ArraySet();
        this.mInitCallbacks = arraySet;
        if (config.mInitCallbacks != null && !config.mInitCallbacks.isEmpty()) {
            arraySet.addAll(config.mInitCallbacks);
        }
        this.mHelper = new CompatInternal19(this);
        loadMetadata();
    }

    public static EmojiCompat init(Context context) {
        return init(context, null);
    }

    public static EmojiCompat init(Context context, DefaultEmojiCompatConfig.DefaultEmojiCompatConfigFactory defaultFactory) {
        EmojiCompat emojiCompat;
        if (sHasDoneDefaultConfigLookup) {
            return sInstance;
        }
        if (defaultFactory == null) {
            defaultFactory = new DefaultEmojiCompatConfig.DefaultEmojiCompatConfigFactory(null);
        }
        Config configCreate = defaultFactory.create(context);
        synchronized (CONFIG_LOCK) {
            if (!sHasDoneDefaultConfigLookup) {
                if (configCreate != null) {
                    init(configCreate);
                }
                sHasDoneDefaultConfigLookup = true;
            }
            emojiCompat = sInstance;
        }
        return emojiCompat;
    }

    public static EmojiCompat init(final Config config) {
        EmojiCompat emojiCompat = sInstance;
        if (emojiCompat == null) {
            synchronized (INSTANCE_LOCK) {
                emojiCompat = sInstance;
                if (emojiCompat == null) {
                    emojiCompat = new EmojiCompat(config);
                    sInstance = emojiCompat;
                }
            }
        }
        return emojiCompat;
    }

    public static boolean isConfigured() {
        return sInstance != null;
    }

    public static EmojiCompat reset(final Config config) {
        EmojiCompat emojiCompat;
        synchronized (INSTANCE_LOCK) {
            emojiCompat = new EmojiCompat(config);
            sInstance = emojiCompat;
        }
        return emojiCompat;
    }

    public static EmojiCompat reset(final EmojiCompat emojiCompat) {
        EmojiCompat emojiCompat2;
        synchronized (INSTANCE_LOCK) {
            sInstance = emojiCompat;
            emojiCompat2 = sInstance;
        }
        return emojiCompat2;
    }

    public static void skipDefaultConfigurationLookup(boolean shouldSkip) {
        synchronized (CONFIG_LOCK) {
            sHasDoneDefaultConfigLookup = shouldSkip;
        }
    }

    public static EmojiCompat get() {
        EmojiCompat emojiCompat;
        synchronized (INSTANCE_LOCK) {
            emojiCompat = sInstance;
            Preconditions.checkState(emojiCompat != null, "EmojiCompat is not initialized. Please call EmojiCompat.init() first");
        }
        return emojiCompat;
    }

    public void load() {
        Preconditions.checkState(this.mMetadataLoadStrategy == 1, "Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
        if (isInitialized()) {
            return;
        }
        this.mInitLock.writeLock().lock();
        try {
            if (this.mLoadState == 0) {
                return;
            }
            this.mLoadState = 0;
            this.mInitLock.writeLock().unlock();
            this.mHelper.loadMetadata();
        } finally {
            this.mInitLock.writeLock().unlock();
        }
    }

    private void loadMetadata() {
        this.mInitLock.writeLock().lock();
        try {
            if (this.mMetadataLoadStrategy == 0) {
                this.mLoadState = 0;
            }
            this.mInitLock.writeLock().unlock();
            if (getLoadState() == 0) {
                this.mHelper.loadMetadata();
            }
        } catch (Throwable th) {
            this.mInitLock.writeLock().unlock();
            throw th;
        }
    }

    void onMetadataLoadSuccess() {
        ArrayList arrayList = new ArrayList();
        this.mInitLock.writeLock().lock();
        try {
            this.mLoadState = 1;
            arrayList.addAll(this.mInitCallbacks);
            this.mInitCallbacks.clear();
            this.mInitLock.writeLock().unlock();
            this.mMainHandler.post(new ListenerDispatcher(arrayList, this.mLoadState));
        } catch (Throwable th) {
            this.mInitLock.writeLock().unlock();
            throw th;
        }
    }

    void onMetadataLoadFailed(final Throwable throwable) {
        ArrayList arrayList = new ArrayList();
        this.mInitLock.writeLock().lock();
        try {
            this.mLoadState = 2;
            arrayList.addAll(this.mInitCallbacks);
            this.mInitCallbacks.clear();
            this.mInitLock.writeLock().unlock();
            this.mMainHandler.post(new ListenerDispatcher(arrayList, this.mLoadState, throwable));
        } catch (Throwable th) {
            this.mInitLock.writeLock().unlock();
            throw th;
        }
    }

    public void registerInitCallback(InitCallback initCallback) {
        Preconditions.checkNotNull(initCallback, "initCallback cannot be null");
        this.mInitLock.writeLock().lock();
        try {
            if (this.mLoadState == 1 || this.mLoadState == 2) {
                this.mMainHandler.post(new ListenerDispatcher(initCallback, this.mLoadState));
            } else {
                this.mInitCallbacks.add(initCallback);
            }
        } finally {
            this.mInitLock.writeLock().unlock();
        }
    }

    public void unregisterInitCallback(InitCallback initCallback) {
        Preconditions.checkNotNull(initCallback, "initCallback cannot be null");
        this.mInitLock.writeLock().lock();
        try {
            this.mInitCallbacks.remove(initCallback);
        } finally {
            this.mInitLock.writeLock().unlock();
        }
    }

    public int getLoadState() {
        this.mInitLock.readLock().lock();
        try {
            return this.mLoadState;
        } finally {
            this.mInitLock.readLock().unlock();
        }
    }

    private boolean isInitialized() {
        return getLoadState() == 1;
    }

    public boolean isEmojiSpanIndicatorEnabled() {
        return this.mEmojiSpanIndicatorEnabled;
    }

    public int getEmojiSpanIndicatorColor() {
        return this.mEmojiSpanIndicatorColor;
    }

    public static boolean handleOnKeyDown(final Editable editable, final int keyCode, final KeyEvent event) {
        return EmojiProcessor.handleOnKeyDown(editable, keyCode, event);
    }

    public static boolean handleDeleteSurroundingText(final InputConnection inputConnection, final Editable editable, final int beforeLength, final int afterLength, final boolean inCodePoints) {
        return EmojiProcessor.handleDeleteSurroundingText(inputConnection, editable, beforeLength, afterLength, inCodePoints);
    }

    public boolean hasEmojiGlyph(final CharSequence sequence) {
        Preconditions.checkState(isInitialized(), "Not initialized yet");
        Preconditions.checkNotNull(sequence, "sequence cannot be null");
        return this.mHelper.hasEmojiGlyph(sequence);
    }

    public boolean hasEmojiGlyph(final CharSequence sequence, final int metadataVersion) {
        Preconditions.checkState(isInitialized(), "Not initialized yet");
        Preconditions.checkNotNull(sequence, "sequence cannot be null");
        return this.mHelper.hasEmojiGlyph(sequence, metadataVersion);
    }

    public CharSequence process(final CharSequence charSequence) {
        return process(charSequence, 0, charSequence == null ? 0 : charSequence.length());
    }

    public CharSequence process(final CharSequence charSequence, final int start, final int end) {
        return process(charSequence, start, end, Integer.MAX_VALUE);
    }

    public CharSequence process(final CharSequence charSequence, final int start, final int end, final int maxEmojiCount) {
        return process(charSequence, start, end, maxEmojiCount, 0);
    }

    public CharSequence process(final CharSequence charSequence, final int start, final int end, final int maxEmojiCount, int replaceStrategy) {
        boolean z;
        Preconditions.checkState(isInitialized(), "Not initialized yet");
        Preconditions.checkArgumentNonnegative(start, "start cannot be negative");
        Preconditions.checkArgumentNonnegative(end, "end cannot be negative");
        Preconditions.checkArgumentNonnegative(maxEmojiCount, "maxEmojiCount cannot be negative");
        Preconditions.checkArgument(start <= end, "start should be <= than end");
        if (charSequence == null) {
            return null;
        }
        Preconditions.checkArgument(start <= charSequence.length(), "start should be < than charSequence length");
        Preconditions.checkArgument(end <= charSequence.length(), "end should be < than charSequence length");
        if (charSequence.length() == 0 || start == end) {
            return charSequence;
        }
        if (replaceStrategy != 1) {
            z = replaceStrategy != 2 ? this.mReplaceAll : false;
        } else {
            z = true;
        }
        return this.mHelper.process(charSequence, start, end, maxEmojiCount, z);
    }

    public String getAssetSignature() {
        Preconditions.checkState(isInitialized(), "Not initialized yet");
        return this.mHelper.getAssetSignature();
    }

    public void updateEditorInfoAttrs(final EditorInfo outAttrs) {
        if (!isInitialized() || outAttrs == null || outAttrs.extras == null) {
            return;
        }
        this.mHelper.updateEditorInfoAttrs(outAttrs);
    }

    static class SpanFactory {
        SpanFactory() {
        }

        EmojiSpan createSpan(final EmojiMetadata metadata) {
            return new TypefaceEmojiSpan(metadata);
        }
    }

    public static abstract class Config {
        int[] mEmojiAsDefaultStyleExceptions;
        boolean mEmojiSpanIndicatorEnabled;
        Set<InitCallback> mInitCallbacks;
        final MetadataRepoLoader mMetadataLoader;
        boolean mReplaceAll;
        boolean mUseEmojiAsDefaultStyle;
        int mEmojiSpanIndicatorColor = -16711936;
        int mMetadataLoadStrategy = 0;
        GlyphChecker mGlyphChecker = new EmojiProcessor.DefaultGlyphChecker();

        protected Config(final MetadataRepoLoader metadataLoader) {
            Preconditions.checkNotNull(metadataLoader, "metadataLoader cannot be null.");
            this.mMetadataLoader = metadataLoader;
        }

        public Config registerInitCallback(InitCallback initCallback) {
            Preconditions.checkNotNull(initCallback, "initCallback cannot be null");
            if (this.mInitCallbacks == null) {
                this.mInitCallbacks = new ArraySet();
            }
            this.mInitCallbacks.add(initCallback);
            return this;
        }

        public Config unregisterInitCallback(InitCallback initCallback) {
            Preconditions.checkNotNull(initCallback, "initCallback cannot be null");
            Set<InitCallback> set = this.mInitCallbacks;
            if (set != null) {
                set.remove(initCallback);
            }
            return this;
        }

        public Config setReplaceAll(final boolean replaceAll) {
            this.mReplaceAll = replaceAll;
            return this;
        }

        public Config setUseEmojiAsDefaultStyle(final boolean useEmojiAsDefaultStyle) {
            return setUseEmojiAsDefaultStyle(useEmojiAsDefaultStyle, null);
        }

        public Config setUseEmojiAsDefaultStyle(final boolean useEmojiAsDefaultStyle, final List<Integer> emojiAsDefaultStyleExceptions) {
            this.mUseEmojiAsDefaultStyle = useEmojiAsDefaultStyle;
            if (useEmojiAsDefaultStyle && emojiAsDefaultStyleExceptions != null) {
                this.mEmojiAsDefaultStyleExceptions = new int[emojiAsDefaultStyleExceptions.size()];
                Iterator<Integer> it = emojiAsDefaultStyleExceptions.iterator();
                int i = 0;
                while (it.hasNext()) {
                    this.mEmojiAsDefaultStyleExceptions[i] = it.next().intValue();
                    i++;
                }
                Arrays.sort(this.mEmojiAsDefaultStyleExceptions);
            } else {
                this.mEmojiAsDefaultStyleExceptions = null;
            }
            return this;
        }

        public Config setEmojiSpanIndicatorEnabled(boolean emojiSpanIndicatorEnabled) {
            this.mEmojiSpanIndicatorEnabled = emojiSpanIndicatorEnabled;
            return this;
        }

        public Config setEmojiSpanIndicatorColor(int color) {
            this.mEmojiSpanIndicatorColor = color;
            return this;
        }

        public Config setMetadataLoadStrategy(int strategy) {
            this.mMetadataLoadStrategy = strategy;
            return this;
        }

        public Config setGlyphChecker(GlyphChecker glyphChecker) {
            Preconditions.checkNotNull(glyphChecker, "GlyphChecker cannot be null");
            this.mGlyphChecker = glyphChecker;
            return this;
        }

        protected final MetadataRepoLoader getMetadataRepoLoader() {
            return this.mMetadataLoader;
        }
    }

    private static class ListenerDispatcher implements Runnable {
        private final List<InitCallback> mInitCallbacks;
        private final int mLoadState;
        private final Throwable mThrowable;

        ListenerDispatcher(final InitCallback initCallback, final int loadState) {
            this(Arrays.asList((InitCallback) Preconditions.checkNotNull(initCallback, "initCallback cannot be null")), loadState, null);
        }

        ListenerDispatcher(final Collection<InitCallback> initCallbacks, final int loadState) {
            this(initCallbacks, loadState, null);
        }

        ListenerDispatcher(final Collection<InitCallback> initCallbacks, final int loadState, final Throwable throwable) {
            Preconditions.checkNotNull(initCallbacks, "initCallbacks cannot be null");
            this.mInitCallbacks = new ArrayList(initCallbacks);
            this.mLoadState = loadState;
            this.mThrowable = throwable;
        }

        @Override // java.lang.Runnable
        public void run() {
            int size = this.mInitCallbacks.size();
            int i = 0;
            if (this.mLoadState != 1) {
                while (i < size) {
                    this.mInitCallbacks.get(i).onFailed(this.mThrowable);
                    i++;
                }
            } else {
                while (i < size) {
                    this.mInitCallbacks.get(i).onInitialized();
                    i++;
                }
            }
        }
    }

    private static class CompatInternal {
        final EmojiCompat mEmojiCompat;

        boolean hasEmojiGlyph(final CharSequence sequence) {
            return false;
        }

        boolean hasEmojiGlyph(final CharSequence sequence, final int metadataVersion) {
            return false;
        }

        CharSequence process(final CharSequence charSequence, final int start, final int end, final int maxEmojiCount, boolean replaceAll) {
            return charSequence;
        }

        void updateEditorInfoAttrs(final EditorInfo outAttrs) {
        }

        CompatInternal(EmojiCompat emojiCompat) {
            this.mEmojiCompat = emojiCompat;
        }

        void loadMetadata() {
            this.mEmojiCompat.onMetadataLoadSuccess();
        }

        String getAssetSignature() {
            return "";
        }
    }

    private static final class CompatInternal19 extends CompatInternal {
        private volatile MetadataRepo mMetadataRepo;
        private volatile EmojiProcessor mProcessor;

        CompatInternal19(EmojiCompat emojiCompat) {
            super(emojiCompat);
        }

        @Override // androidx.emoji2.text.EmojiCompat.CompatInternal
        void loadMetadata() {
            try {
                this.mEmojiCompat.mMetadataLoader.load(new MetadataRepoLoaderCallback() { // from class: androidx.emoji2.text.EmojiCompat.CompatInternal19.1
                    @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoaderCallback
                    public void onLoaded(MetadataRepo metadataRepo) {
                        CompatInternal19.this.onMetadataLoadSuccess(metadataRepo);
                    }

                    @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoaderCallback
                    public void onFailed(Throwable throwable) {
                        CompatInternal19.this.mEmojiCompat.onMetadataLoadFailed(throwable);
                    }
                });
            } catch (Throwable th) {
                this.mEmojiCompat.onMetadataLoadFailed(th);
            }
        }

        void onMetadataLoadSuccess(final MetadataRepo metadataRepo) {
            if (metadataRepo == null) {
                this.mEmojiCompat.onMetadataLoadFailed(new IllegalArgumentException("metadataRepo cannot be null"));
                return;
            }
            this.mMetadataRepo = metadataRepo;
            this.mProcessor = new EmojiProcessor(this.mMetadataRepo, new SpanFactory(), this.mEmojiCompat.mGlyphChecker, this.mEmojiCompat.mUseEmojiAsDefaultStyle, this.mEmojiCompat.mEmojiAsDefaultStyleExceptions);
            this.mEmojiCompat.onMetadataLoadSuccess();
        }

        @Override // androidx.emoji2.text.EmojiCompat.CompatInternal
        boolean hasEmojiGlyph(CharSequence sequence) {
            return this.mProcessor.getEmojiMetadata(sequence) != null;
        }

        @Override // androidx.emoji2.text.EmojiCompat.CompatInternal
        boolean hasEmojiGlyph(CharSequence sequence, int metadataVersion) {
            EmojiMetadata emojiMetadata = this.mProcessor.getEmojiMetadata(sequence);
            return emojiMetadata != null && emojiMetadata.getCompatAdded() <= metadataVersion;
        }

        @Override // androidx.emoji2.text.EmojiCompat.CompatInternal
        CharSequence process(CharSequence charSequence, int start, int end, int maxEmojiCount, boolean replaceAll) {
            return this.mProcessor.process(charSequence, start, end, maxEmojiCount, replaceAll);
        }

        @Override // androidx.emoji2.text.EmojiCompat.CompatInternal
        void updateEditorInfoAttrs(EditorInfo outAttrs) {
            outAttrs.extras.putInt(EmojiCompat.EDITOR_INFO_METAVERSION_KEY, this.mMetadataRepo.getMetadataVersion());
            outAttrs.extras.putBoolean(EmojiCompat.EDITOR_INFO_REPLACE_ALL_KEY, this.mEmojiCompat.mReplaceAll);
        }

        @Override // androidx.emoji2.text.EmojiCompat.CompatInternal
        String getAssetSignature() {
            String strSourceSha = this.mMetadataRepo.getMetadataList().sourceSha();
            return strSourceSha == null ? "" : strSourceSha;
        }
    }
}
