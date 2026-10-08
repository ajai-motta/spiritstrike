package com.hive.core;

import com.hive.core.Logger;
import java.io.File;
import kotlin.Metadata;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileStorage.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u0007J\u0016\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\tJ\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\u000e"}, d2 = {"Lcom/hive/core/FileStorage;", "", "<init>", "()V", "isExistFile", "", "targetFile", "Ljava/io/File;", "read", "", "sourceFile", "write", "contents", "delete", "hive-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FileStorage {
    public static final FileStorage INSTANCE = new FileStorage();

    private FileStorage() {
    }

    public final synchronized boolean isExistFile(File targetFile) {
        boolean z;
        Intrinsics.checkNotNullParameter(targetFile, "targetFile");
        z = false;
        try {
            if (targetFile.exists()) {
                if (!targetFile.isDirectory()) {
                    z = true;
                }
            }
        } catch (Exception unused) {
        }
        return z;
    }

    public final synchronized byte[] read(File sourceFile) {
        byte[] bytes;
        Intrinsics.checkNotNullParameter(sourceFile, "sourceFile");
        try {
            bytes = FilesKt.readBytes(sourceFile);
        } catch (Exception e) {
            Logger.INSTANCE.coreLog$hive_core_release("[FileStorage] read() e: " + e.getMessage(), Logger.LogType.Error);
            bytes = null;
        }
        return bytes;
    }

    public final synchronized boolean write(File targetFile, byte[] contents) {
        boolean z;
        Intrinsics.checkNotNullParameter(targetFile, "targetFile");
        Intrinsics.checkNotNullParameter(contents, "contents");
        try {
            FilesKt.writeBytes(targetFile, contents);
            z = true;
        } catch (Exception e) {
            Logger.INSTANCE.coreLog$hive_core_release("[FileStorage] read() e: " + e.getMessage(), Logger.LogType.Error);
            z = false;
        }
        return z;
    }

    public final synchronized boolean delete(File targetFile) {
        boolean zDelete;
        Intrinsics.checkNotNullParameter(targetFile, "targetFile");
        try {
            zDelete = targetFile.delete();
        } catch (Exception e) {
            Logger.INSTANCE.coreLog$hive_core_release("[FileStorage] read() e: " + e.getMessage(), Logger.LogType.Error);
            zDelete = false;
        }
        return zDelete;
    }
}
