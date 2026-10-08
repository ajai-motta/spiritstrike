package com.google.protobuf;

/* JADX INFO: loaded from: classes5.dex */
@CheckReturnValue
interface SchemaFactory {
    <T> Schema<T> createSchema(Class<T> messageType);
}
