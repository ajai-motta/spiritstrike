package com.applovin.impl;

import androidx.compose.animation.core.AnimationConstants;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.sdk.openadsdk.TTAdConstant;

/* JADX INFO: loaded from: classes2.dex */
public enum u7 {
    UNSPECIFIED(-1),
    RESOURCE_REJECTED(1),
    API_FRAMEWORK_OR_LANGUAGE_TYPE_NOT_SUPPORTED(2),
    FAILED_TO_LOAD_RESOURCE(3),
    XML_PARSING(100),
    GENERAL_WRAPPER_ERROR(AnimationConstants.DefaultDurationMillis),
    TIMED_OUT(301),
    WRAPPER_LIMIT_REACHED(302),
    NO_WRAPPER_RESPONSE(303),
    GENERAL_LINEAR_ERROR(400),
    NO_MEDIA_FILE_PROVIDED(401),
    MEDIA_FILE_TIMEOUT(402),
    MEDIA_FILE_ERROR(TTAdConstant.DEEPLINK_FALLBACK_TYPE_CODE),
    GENERAL_COMPANION_AD_ERROR(600),
    UNABLE_TO_FETCH_COMPANION_AD_RESOURCE(TypedValues.MotionType.TYPE_EASING),
    CAN_NOT_FIND_COMPANION_AD_RESOURCE(TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f687a;

    u7(int i) {
        this.f687a = i;
    }

    public int b() {
        return this.f687a;
    }
}
