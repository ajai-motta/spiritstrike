package com.google.errorprone.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets/audience_network/classes2.dex
  classes5.dex
 */
/* JADX INFO: loaded from: classes5.dex */
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface DoNotMock {
    String value() default "Create a real instance instead";
}
