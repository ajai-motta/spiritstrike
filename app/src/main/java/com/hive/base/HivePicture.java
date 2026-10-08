package com.hive.base;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcelable;
import android.provider.DocumentsContract;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.widget.Toast;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.PickVisualMediaRequestKt;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.share.internal.ShareConstants;
import com.facebook.share.internal.ShareInternalUtility;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.HiveActivity;
import com.hive.ResultAPI;
import com.hive.base.HivePicture;
import com.hive.logger.LoggerImpl;
import com.hive.ui.HiveUiActivity;
import com.hive.ui.OnActivityLifecycle;
import com.hive.ui.Resource;
import com.unity3d.services.ads.adunit.AdUnitActivity;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u001e\u001fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0007J&\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u000fJ&\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fJ0\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0002J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0007H\u0002J$\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0002J\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001d\u001a\u00020\u0007H\u0002¨\u0006 "}, d2 = {"Lcom/hive/base/HivePicture;", "", "<init>", "()V", "getPictureFromGallery", "", "maxLongSize", "", "outputFileType", "", "quality", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/base/HivePicture$HivePictureResultListener;", "getPictureFromCamera", "getPictureFromChooser", "Lcom/hive/base/HivePicture$ChooserResultListener;", "getPictureFromPhotoPicker", "getPictureCallback", "activity", "Landroid/app/Activity;", ShareConstants.MEDIA_URI, "Landroid/net/Uri;", "getDegreeFromOrientation", "exifOrientation", "getByteArrFromBitmap", "", "bitmap", "Landroid/graphics/Bitmap;", "getRotatedBitmap", "degrees", "HivePictureResultListener", "ChooserResultListener", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HivePicture {
    public static final HivePicture INSTANCE = new HivePicture();

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, d2 = {"Lcom/hive/base/HivePicture$ChooserResultListener;", "", "onChooserResult", "", "result", "Lcom/hive/ResultAPI;", ShareConstants.MEDIA_URI, "Landroid/net/Uri;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface ChooserResultListener {
        void onChooserResult(ResultAPI result, Uri uri);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, d2 = {"Lcom/hive/base/HivePicture$HivePictureResultListener;", "", "onHivePictureResult", "", "result", "Lcom/hive/ResultAPI;", "base64encodeString", "", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface HivePictureResultListener {
        void onHivePictureResult(ResultAPI result, String base64encodeString);
    }

    /* JADX INFO: renamed from: com.hive.base.HivePicture$getPictureFromPhotoPicker$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"com/hive/base/HivePicture$getPictureFromPhotoPicker$1", "Lcom/hive/ui/OnActivityLifecycle;", "isInProgress", "", "onCreate", "", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class C28991 extends OnActivityLifecycle {
        final /* synthetic */ HivePictureResultListener $listener;
        final /* synthetic */ int $maxLongSize;
        final /* synthetic */ String $outputFileType;
        final /* synthetic */ int $quality;
        private boolean isInProgress = true;

        public C28991(HivePictureResultListener hivePictureResultListener, int i, String str, int i2) {
            this.$listener = hivePictureResultListener;
            this.$maxLongSize = i;
            this.$outputFileType = str;
            this.$quality = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onCreate$lambda$2(C28991 c28991, HivePictureResultListener hivePictureResultListener, Activity activity, int i, String str, int i2, Uri uri) {
            Object objM7415constructorimpl;
            c28991.isInProgress = false;
            if (uri != null) {
                LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
                loggerImpl.d("[HivePicture] PhotoPicker - Selected URI: " + uri);
                loggerImpl.d("[HivePicture] ALBUM ExternalStorageState : " + Environment.getExternalStorageState());
                StringBuilder sb = new StringBuilder();
                try {
                    Result.Companion companion = Result.INSTANCE;
                    sb.append(HivePicture.INSTANCE.getPictureCallback(activity, uri, i, str, i2));
                    hivePictureResultListener.onHivePictureResult(new ResultAPI(), sb.toString());
                    objM7415constructorimpl = Result.m7415constructorimpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
                }
                Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
                if (thM7418exceptionOrNullimpl != null) {
                    LoggerImpl.INSTANCE.w("[HivePicture] ALBUM Failed : " + thM7418exceptionOrNullimpl.getLocalizedMessage());
                    hivePictureResultListener.onHivePictureResult(new ResultAPI(-99, ResultAPI.Code.SocialHIVEResponseFailGetPictureFromGallery, thM7418exceptionOrNullimpl.getLocalizedMessage()), null);
                }
                Result.m7414boximpl(objM7415constructorimpl);
            } else {
                LoggerImpl.INSTANCE.d("[HivePicture] PhotoPicker - No media selected");
                hivePictureResultListener.onHivePictureResult(new ResultAPI(-6, ResultAPI.Code.SocialHIVEResponseFailGetPictureFromGallery), null);
            }
            activity.finish();
        }

        @Override // com.hive.ui.OnActivityLifecycle
        public void onCreate(final Activity activity, Bundle savedInstanceState) {
            Object objM7415constructorimpl;
            Intrinsics.checkNotNullParameter(activity, "activity");
            super.onCreate(activity, savedInstanceState);
            ActivityResultContracts.PickVisualMedia pickVisualMedia = new ActivityResultContracts.PickVisualMedia();
            final HivePictureResultListener hivePictureResultListener = this.$listener;
            final int i = this.$maxLongSize;
            final String str = this.$outputFileType;
            final int i2 = this.$quality;
            ActivityResultLauncher activityResultLauncherRegisterForActivityResult = ((AppCompatActivity) activity).registerForActivityResult(pickVisualMedia, new ActivityResultCallback() { // from class: com.hive.base.HivePicture$getPictureFromPhotoPicker$1$$ExternalSyntheticLambda0
                @Override // androidx.activity.result.ActivityResultCallback
                public final void onActivityResult(Object obj) {
                    HivePicture.C28991.onCreate$lambda$2(this.f$0, hivePictureResultListener, activity, i, str, i2, (Uri) obj);
                }
            });
            try {
                Result.Companion companion = Result.INSTANCE;
                activityResultLauncherRegisterForActivityResult.launch(PickVisualMediaRequestKt.PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly.INSTANCE));
                objM7415constructorimpl = Result.m7415constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
            }
            HivePictureResultListener hivePictureResultListener2 = this.$listener;
            Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
            if (thM7418exceptionOrNullimpl != null) {
                this.isInProgress = false;
                thM7418exceptionOrNullimpl.printStackTrace();
                Toast.makeText(activity, Resource.INSTANCE.getString("hive_social_allow_camera_album"), 0).show();
                hivePictureResultListener2.onHivePictureResult(new ResultAPI(-99, ResultAPI.Code.SocialHIVEResponseFailGetPictureFromGallery, thM7418exceptionOrNullimpl.getLocalizedMessage()), null);
                activity.finish();
            }
        }

        @Override // com.hive.ui.OnActivityLifecycle
        public void onDestroy(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            if (this.isInProgress) {
                this.$listener.onHivePictureResult(new ResultAPI(-99, ResultAPI.Code.SocialHIVEResponseFailGetPictureFromGallery, "HiveUiActivity destroy"), null);
            }
            super.onDestroy(activity);
        }
    }

    private HivePicture() {
    }

    private final byte[] getByteArrFromBitmap(Bitmap bitmap, String outputFileType, int quality) {
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] byteArray;
        Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
        if (!StringsKt.isBlank(outputFileType)) {
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String upperCase = outputFileType.toUpperCase(US);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            int iHashCode = upperCase.hashCode();
            if (iHashCode == 73665) {
                upperCase.equals("JPG");
            } else if (iHashCode != 79369) {
                if (iHashCode == 2283624) {
                    upperCase.equals("JPEG");
                } else if (iHashCode == 2660252 && upperCase.equals("WEBP")) {
                    compressFormat = Bitmap.CompressFormat.WEBP;
                }
            } else if (upperCase.equals("PNG")) {
                compressFormat = Bitmap.CompressFormat.PNG;
            }
        }
        if (quality > 100) {
            quality = 100;
        } else if (quality < 0) {
            quality = 0;
        }
        byte[] bArr = null;
        if (bitmap == null) {
            return null;
        }
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    bitmap.compress(compressFormat, quality, byteArrayOutputStream);
                    byteArray = byteArrayOutputStream.toByteArray();
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception unused) {
                return new byte[0];
            }
        } catch (IOException e) {
            e = e;
        }
        try {
            Unit unit = Unit.INSTANCE;
            try {
                CloseableKt.closeFinally(byteArrayOutputStream, null);
                return byteArray;
            } catch (IOException e2) {
                e = e2;
                bArr = byteArray;
                e.printStackTrace();
                return bArr;
            }
        } catch (Throwable th2) {
            th = th2;
            bArr = byteArray;
            try {
                throw th;
            } finally {
            }
        }
    }

    private final int getDegreeFromOrientation(int exifOrientation) {
        if (exifOrientation == 3) {
            return 180;
        }
        if (exifOrientation != 6) {
            return exifOrientation != 8 ? 0 : 270;
        }
        return 90;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getPictureCallback(Activity activity, Uri uri, int maxLongSize, String outputFileType, int quality) throws Exception {
        int degreeFromOrientation;
        InputStream inputStreamOpenInputStream;
        LoggerImpl.INSTANCE.d(uri.toString());
        BitmapFactory.Options options = new BitmapFactory.Options();
        String scheme = uri.getScheme();
        if (scheme != null && StringsKt.contains$default((CharSequence) scheme, (CharSequence) "content", false, 2, (Object) null)) {
            String[] strArr = {"_data", "_size", "_display_name", "title", "mime_type", AdUnitActivity.EXTRA_ORIENTATION, ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY};
            try {
                Result.Companion companion = Result.INSTANCE;
                activity.getContentResolver().takePersistableUriPermission(uri, 1);
                Result.m7415constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m7415constructorimpl(ResultKt.createFailure(th));
            }
            Cursor cursorQuery = activity.getContentResolver().query(uri, strArr, null, null, null);
            if (cursorQuery == null) {
                throw new Exception("not found image.");
            }
            try {
                cursorQuery.moveToFirst();
                cursorQuery.getLong(cursorQuery.getColumnIndexOrThrow("_size"));
                cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("mime_type"));
                degreeFromOrientation = cursorQuery.getInt(cursorQuery.getColumnIndexOrThrow(AdUnitActivity.EXTRA_ORIENTATION));
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(cursorQuery, null);
                if ((options.outWidth == 0 || options.outHeight == 0) && (inputStreamOpenInputStream = activity.getContentResolver().openInputStream(uri)) != null) {
                    try {
                        options.inJustDecodeBounds = true;
                        BitmapFactory.decodeStream(inputStreamOpenInputStream, null, options);
                        CloseableKt.closeFinally(inputStreamOpenInputStream, null);
                    } finally {
                    }
                }
            } finally {
            }
        } else {
            if (scheme == null || !StringsKt.contains$default((CharSequence) scheme, (CharSequence) ShareInternalUtility.STAGING_PARAM, false, 2, (Object) null)) {
                throw new Exception("unknown uri scheme." + uri);
            }
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(uri.getPath(), options);
            String path = uri.getPath();
            if (path != null) {
                ExifInterface exifInterface = new ExifInterface(path);
                degreeFromOrientation = INSTANCE.getDegreeFromOrientation(exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION, 1));
                int attributeInt = exifInterface.getAttributeInt(ExifInterface.TAG_IMAGE_WIDTH, 0);
                int attributeInt2 = exifInterface.getAttributeInt(ExifInterface.TAG_IMAGE_LENGTH, 0);
                if (options.outWidth == -1) {
                    options.outWidth = attributeInt;
                }
                if (options.outHeight == -1) {
                    options.outHeight = attributeInt2;
                }
            } else {
                degreeFromOrientation = 0;
            }
        }
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.d("Bitmap original w : " + options.outWidth + " h :" + options.outHeight);
        float fCoerceAtLeast = (float) RangesKt.coerceAtLeast(RangesKt.coerceAtMost(maxLongSize, 8192), 1);
        float fCoerceAtMost = RangesKt.coerceAtMost(fCoerceAtLeast / ((float) options.outWidth), fCoerceAtLeast / ((float) options.outHeight));
        if (fCoerceAtMost < 1.0f) {
            options.inDensity = 10000;
            options.inTargetDensity = (int) (10000 * fCoerceAtMost);
        }
        options.inJustDecodeBounds = false;
        InputStream inputStreamOpenInputStream2 = activity.getContentResolver().openInputStream(uri);
        Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenInputStream2, null, options);
        if (inputStreamOpenInputStream2 != null) {
            inputStreamOpenInputStream2.close();
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        if (bitmapDecodeStream == null) {
            throw new Exception("invalid bitmap.");
        }
        bitmapDecodeStream.setDensity(displayMetrics.densityDpi);
        loggerImpl.d("Bitmap (w:" + bitmapDecodeStream.getWidth() + ", h:" + bitmapDecodeStream.getHeight() + ") " + (bitmapDecodeStream.getRowBytes() * bitmapDecodeStream.getHeight()) + " bytes, Density : " + bitmapDecodeStream.getDensity() + " Picture Orientation is " + degreeFromOrientation);
        if (degreeFromOrientation != 0) {
            bitmapDecodeStream = getRotatedBitmap(bitmapDecodeStream, degreeFromOrientation);
        }
        byte[] bArrEncode = Base64.encode(getByteArrFromBitmap(bitmapDecodeStream, outputFileType, quality), 2);
        Intrinsics.checkNotNullExpressionValue(bArrEncode, "encode(...)");
        return new String(bArrEncode, Charsets.UTF_8);
    }

    private final Bitmap getRotatedBitmap(Bitmap bitmap, int degrees) {
        if (degrees != 0 && bitmap != null) {
            Matrix matrix = new Matrix();
            float f = 2;
            matrix.setRotate(degrees, bitmap.getWidth() / f, bitmap.getHeight() / f);
            try {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
                if (!Intrinsics.areEqual(bitmap, bitmapCreateBitmap)) {
                    bitmap.recycle();
                    return bitmapCreateBitmap;
                }
            } catch (OutOfMemoryError unused) {
                LoggerImpl.INSTANCE.w("getRotatedBitmap Failed. out if Memory");
            }
        }
        return bitmap;
    }

    public final void getPictureFromCamera(final int maxLongSize, final String outputFileType, final int quality, final HivePictureResultListener listener) {
        Intrinsics.checkNotNullParameter(outputFileType, "outputFileType");
        Intrinsics.checkNotNullParameter(listener, "listener");
        HiveUiActivity.INSTANCE.launch(HiveActivity.INSTANCE.getRecentActivity(), new OnActivityLifecycle() { // from class: com.hive.base.HivePicture.getPictureFromCamera.1
            public File imageTemp;
            public Uri mImageCaptureUri;
            private final int REQUEST_CODE_PICK_FROM_CAMERA = 51712;
            private boolean isInProgress = true;

            public final File getImageTemp() {
                File file = this.imageTemp;
                if (file != null) {
                    return file;
                }
                Intrinsics.throwUninitializedPropertyAccessException("imageTemp");
                return null;
            }

            public final Uri getMImageCaptureUri() {
                Uri uri = this.mImageCaptureUri;
                if (uri != null) {
                    return uri;
                }
                Intrinsics.throwUninitializedPropertyAccessException("mImageCaptureUri");
                return null;
            }

            @Override // com.hive.ui.OnActivityLifecycle
            public void onActivityResult(Activity activity, int requestCode, int resultCode, Intent data) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                this.isInProgress = false;
                StringBuilder sb = new StringBuilder();
                setMImageCaptureUri(Uri.fromFile(getImageTemp()));
                if (resultCode == -1) {
                    try {
                        sb.append(HivePicture.INSTANCE.getPictureCallback(activity, getMImageCaptureUri(), maxLongSize, outputFileType, quality));
                        listener.onHivePictureResult(new ResultAPI(), sb.toString());
                    } catch (Exception e) {
                        LoggerImpl.INSTANCE.w("Camera Capture Failed : " + e.getLocalizedMessage());
                        listener.onHivePictureResult(new ResultAPI(-99, ResultAPI.Code.SocialHIVEResponseFailGetPictureFromCamera, e.getLocalizedMessage()), null);
                    }
                } else {
                    LoggerImpl.INSTANCE.d(null, "Camera Capture Canceled : ");
                    listener.onHivePictureResult(new ResultAPI(-6, ResultAPI.Code.SocialHIVEResponseFailGetPictureFromCamera), null);
                }
                String path = getMImageCaptureUri().getPath();
                if (path != null) {
                    File file = new File(path);
                    LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
                    loggerImpl.d("file.exists() : " + file.exists());
                    loggerImpl.d("file.delete() : " + file.delete());
                }
                activity.finish();
            }

            @Override // com.hive.ui.OnActivityLifecycle
            public void onCreate(Activity activity, Bundle savedInstanceState) {
                Uri uriFromFile;
                Intrinsics.checkNotNullParameter(activity, "activity");
                super.onCreate(activity, savedInstanceState);
                try {
                    setImageTemp(File.createTempFile("tmp_", ".jpeg", activity.getExternalFilesDir(null)));
                    if (Build.VERSION.SDK_INT >= 24) {
                        uriFromFile = androidx.core.content.FileProvider.getUriForFile(activity, activity.getApplicationContext().getPackageName() + ".provider", getImageTemp());
                    } else {
                        uriFromFile = Uri.fromFile(getImageTemp());
                    }
                    setMImageCaptureUri(uriFromFile);
                    getImageTemp().deleteOnExit();
                    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                    intent.putExtra("output", getMImageCaptureUri());
                    activity.startActivityForResult(intent, this.REQUEST_CODE_PICK_FROM_CAMERA);
                } catch (Exception e) {
                    this.isInProgress = false;
                    e.printStackTrace();
                    Toast.makeText(activity, Resource.INSTANCE.getString("hive_social_allow_camera_album"), 0).show();
                    listener.onHivePictureResult(new ResultAPI(-99, ResultAPI.Code.SocialHIVEResponseFailGetPictureFromCamera, e.getLocalizedMessage()), null);
                    activity.finish();
                }
            }

            @Override // com.hive.ui.OnActivityLifecycle
            public void onDestroy(Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                if (this.isInProgress) {
                    listener.onHivePictureResult(new ResultAPI(-99, ResultAPI.Code.SocialHIVEResponseFailGetPictureFromCamera, "HiveUiActivity destroy"), null);
                }
                super.onDestroy(activity);
            }

            public final void setImageTemp(File file) {
                Intrinsics.checkNotNullParameter(file, "<set-?>");
                this.imageTemp = file;
            }

            public final void setMImageCaptureUri(Uri uri) {
                Intrinsics.checkNotNullParameter(uri, "<set-?>");
                this.mImageCaptureUri = uri;
            }
        });
    }

    public final void getPictureFromChooser(final ChooserResultListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        HiveUiActivity.INSTANCE.launch(HiveActivity.INSTANCE.getRecentActivity(), new OnActivityLifecycle() { // from class: com.hive.base.HivePicture.getPictureFromChooser.1
            private Uri mImageCaptureUri;
            private final int REQUEST_CODE_PICK_FROM_CHOOSER = 47616;
            private final String IMAGE_TYPE = "image/*";
            private boolean isInProgress = true;

            private final Uri convertDocumentUriToContentUri(Activity activity, Uri documentUri) {
                File fileCreateTempFile;
                FileOutputStream fileOutputStream;
                Uri uriFromFile;
                if (documentUri == null) {
                    LoggerImpl.INSTANCE.d("[HivePicture] convertDocumentUriToContentUri param's documentUri is null");
                    return null;
                }
                try {
                    InputStream inputStreamOpenInputStream = activity.getContentResolver().openInputStream(documentUri);
                    if (inputStreamOpenInputStream != null) {
                        try {
                            fileCreateTempFile = File.createTempFile("tmp_", ".jpeg");
                            fileOutputStream = new FileOutputStream(fileCreateTempFile);
                        } finally {
                        }
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int i = inputStreamOpenInputStream.read(bArr);
                                if (i <= 0) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, i);
                            }
                            Unit unit = Unit.INSTANCE;
                            CloseableKt.closeFinally(fileOutputStream, null);
                            if (Build.VERSION.SDK_INT >= 24) {
                                uriFromFile = androidx.core.content.FileProvider.getUriForFile(activity, activity.getApplicationContext().getPackageName() + ".provider", fileCreateTempFile);
                            } else {
                                uriFromFile = Uri.fromFile(fileCreateTempFile);
                            }
                            CloseableKt.closeFinally(inputStreamOpenInputStream, null);
                            if (uriFromFile != null) {
                                return uriFromFile;
                            }
                        } finally {
                        }
                    }
                    LoggerImpl.INSTANCE.w("[HivePicture] convertDocumentUriToContentUri is null");
                    return null;
                } catch (Exception e) {
                    LoggerImpl.INSTANCE.w("[HivePicture] convertDocumentUriToContentUri exception: " + e.getMessage());
                    return null;
                }
            }

            public final Uri getMImageCaptureUri() {
                return this.mImageCaptureUri;
            }

            @Override // com.hive.ui.OnActivityLifecycle
            public void onActivityResult(Activity activity, int requestCode, int resultCode, Intent data) {
                String path;
                Uri data2;
                Uri data3;
                Intrinsics.checkNotNullParameter(activity, "activity");
                this.isInProgress = false;
                if (resultCode == -1) {
                    if (data != null) {
                        try {
                            data2 = data.getData();
                        } catch (Exception e) {
                            LoggerImpl.INSTANCE.w("Chooser Failed : " + e.getLocalizedMessage());
                            listener.onChooserResult(new ResultAPI(-99, ResultAPI.Code.SocialHIVEResponseFailGetPictureFromChooser, e.getLocalizedMessage()), null);
                        }
                    } else {
                        data2 = null;
                    }
                    if (data2 == null || !DocumentsContract.isDocumentUri(activity, data.getData())) {
                        if ((data != null ? data.getData() : null) != null && !DocumentsContract.isDocumentUri(activity, data.getData())) {
                            LoggerImpl.INSTANCE.d("[HivePicture] getPictureFromChooser return data.data");
                            data3 = data.getData();
                        } else if (this.mImageCaptureUri != null) {
                            LoggerImpl.INSTANCE.d("[HivePicture] getPictureFromChooser return mImageCaptureUri");
                            data3 = this.mImageCaptureUri;
                        } else {
                            LoggerImpl.INSTANCE.d("[HivePicture] getPictureFromChooser return null");
                            data3 = null;
                        }
                    } else {
                        LoggerImpl.INSTANCE.d("[HivePicture] getPictureFromChooser return newUri");
                        data3 = convertDocumentUriToContentUri(activity, data.getData());
                    }
                    listener.onChooserResult(new ResultAPI(), data3);
                } else {
                    LoggerImpl.INSTANCE.d(null, "Chooser Canceled : ");
                    listener.onChooserResult(new ResultAPI(-6, ResultAPI.Code.SocialHIVEResponseFailGetPictureFromChooser), null);
                }
                Uri uri = this.mImageCaptureUri;
                if (uri != null && (path = uri.getPath()) != null) {
                    File file = new File(path);
                    LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
                    loggerImpl.d("file.exists() : " + file.exists());
                    loggerImpl.d("file.delete() : " + file.delete());
                }
                activity.finish();
            }

            @Override // com.hive.ui.OnActivityLifecycle
            public void onCreate(Activity activity, Bundle savedInstanceState) {
                Uri uriFromFile;
                Intrinsics.checkNotNullParameter(activity, "activity");
                super.onCreate(activity, savedInstanceState);
                try {
                    ArrayList arrayList = new ArrayList();
                    File fileCreateTempFile = File.createTempFile("tmp_", ".jpeg", activity.getExternalFilesDir(null));
                    if (Build.VERSION.SDK_INT >= 24) {
                        uriFromFile = androidx.core.content.FileProvider.getUriForFile(activity, activity.getApplicationContext().getPackageName() + ".provider", fileCreateTempFile);
                    } else {
                        uriFromFile = Uri.fromFile(fileCreateTempFile);
                    }
                    this.mImageCaptureUri = uriFromFile;
                    fileCreateTempFile.deleteOnExit();
                    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                    intent.putExtra("output", this.mImageCaptureUri);
                    arrayList.add(intent);
                    Intent intent2 = new Intent("android.intent.action.GET_CONTENT");
                    intent2.addCategory("android.intent.category.OPENABLE");
                    intent2.setType(this.IMAGE_TYPE);
                    Intent intent3 = new Intent("android.intent.action.CHOOSER");
                    intent3.putExtra("android.intent.extra.INTENT", intent2);
                    intent3.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) arrayList.toArray(new Parcelable[0]));
                    activity.startActivityForResult(intent3, this.REQUEST_CODE_PICK_FROM_CHOOSER);
                } catch (Exception e) {
                    this.isInProgress = false;
                    e.printStackTrace();
                    Toast.makeText(activity, Resource.INSTANCE.getString("hive_social_allow_camera_album"), 0).show();
                    listener.onChooserResult(new ResultAPI(-99, ResultAPI.Code.SocialHIVEResponseFailGetPictureFromChooser, e.getLocalizedMessage()), null);
                    activity.finish();
                }
            }

            @Override // com.hive.ui.OnActivityLifecycle
            public void onDestroy(Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                if (this.isInProgress) {
                    listener.onChooserResult(new ResultAPI(-99, ResultAPI.Code.SocialHIVEResponseFailGetPictureFromChooser, "HiveUiActivity destroy"), null);
                }
                super.onDestroy(activity);
            }

            public final void setMImageCaptureUri(Uri uri) {
                this.mImageCaptureUri = uri;
            }
        });
    }

    @Deprecated(message = "Override function", replaceWith = @ReplaceWith(expression = "getPictureFromPhotoPicker", imports = {}))
    public final void getPictureFromGallery(final int maxLongSize, final String outputFileType, final int quality, final HivePictureResultListener listener) {
        Intrinsics.checkNotNullParameter(outputFileType, "outputFileType");
        Intrinsics.checkNotNullParameter(listener, "listener");
        HiveUiActivity.INSTANCE.launch(HiveActivity.INSTANCE.getRecentActivity(), new OnActivityLifecycle() { // from class: com.hive.base.HivePicture.getPictureFromGallery.1
            private final int REQUEST_CODE_PICK_FROM_ALBUM = 41392;
            private boolean isInProgress = true;

            @Override // com.hive.ui.OnActivityLifecycle
            public void onActivityResult(Activity activity, int requestCode, int resultCode, Intent data) {
                Uri data2;
                Intrinsics.checkNotNullParameter(activity, "activity");
                this.isInProgress = false;
                LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
                loggerImpl.d("ALBUM ExternalStorageState : " + Environment.getExternalStorageState());
                StringBuilder sb = new StringBuilder();
                if (resultCode == -1) {
                    if (data != null) {
                        try {
                            data2 = data.getData();
                        } catch (Exception e) {
                            LoggerImpl.INSTANCE.w("ALBUM Failed : " + e.getLocalizedMessage());
                            listener.onHivePictureResult(new ResultAPI(-99, ResultAPI.Code.SocialHIVEResponseFailGetPictureFromGallery, e.getLocalizedMessage()), null);
                        }
                    } else {
                        data2 = null;
                    }
                    if (data == null || data2 == null) {
                        throw new Exception("ALBUM Intent data is null");
                    }
                    sb.append(HivePicture.INSTANCE.getPictureCallback(activity, data2, maxLongSize, outputFileType, quality));
                    listener.onHivePictureResult(new ResultAPI(), sb.toString());
                } else {
                    loggerImpl.d(null, "ALBUM Canceled : ");
                    listener.onHivePictureResult(new ResultAPI(-6, ResultAPI.Code.SocialHIVEResponseFailGetPictureFromGallery), null);
                }
                activity.finish();
            }

            @Override // com.hive.ui.OnActivityLifecycle
            public void onCreate(Activity activity, Bundle savedInstanceState) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                super.onCreate(activity, savedInstanceState);
                Intent intent = new Intent("android.intent.action.PICK");
                intent.setType("vnd.android.cursor.dir/image");
                intent.addFlags(1);
                try {
                    activity.startActivityForResult(intent, this.REQUEST_CODE_PICK_FROM_ALBUM);
                } catch (Exception e) {
                    this.isInProgress = false;
                    e.printStackTrace();
                    Toast.makeText(activity, Resource.INSTANCE.getString("hive_social_allow_camera_album"), 0).show();
                    listener.onHivePictureResult(new ResultAPI(-99, ResultAPI.Code.SocialHIVEResponseFailGetPictureFromGallery, e.getLocalizedMessage()), null);
                    activity.finish();
                }
            }

            @Override // com.hive.ui.OnActivityLifecycle
            public void onDestroy(Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                if (this.isInProgress) {
                    listener.onHivePictureResult(new ResultAPI(-99, ResultAPI.Code.SocialHIVEResponseFailGetPictureFromGallery, "HiveUiActivity destroy"), null);
                }
                super.onDestroy(activity);
            }
        });
    }

    public final void getPictureFromPhotoPicker(int maxLongSize, String outputFileType, int quality, HivePictureResultListener listener) {
        Intrinsics.checkNotNullParameter(outputFileType, "outputFileType");
        Intrinsics.checkNotNullParameter(listener, "listener");
        HiveUiActivity.INSTANCE.launch(HiveActivity.INSTANCE.getRecentActivity(), new C28991(listener, maxLongSize, outputFileType, quality));
    }
}
