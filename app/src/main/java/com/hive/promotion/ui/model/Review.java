package com.hive.promotion.ui.model;

import androidx.core.app.NotificationCompat;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import io.ktor.http.LinkHeader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Review.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003JE\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000e¨\u0006&"}, d2 = {"Lcom/hive/promotion/ui/model/Review;", "", "title", "", NotificationCompat.CATEGORY_MESSAGE, "ok", "no", LinkHeader.Rel.Next, "url", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "getMsg", "setMsg", "getOk", "setOk", "getNo", "setNo", "getNext", "setNext", "getUrl", "setUrl", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class Review {
    private String msg;
    private String next;
    private String no;
    private String ok;
    private String title;
    private String url;

    public static /* synthetic */ Review copy$default(Review review, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = review.title;
        }
        if ((i & 2) != 0) {
            str2 = review.msg;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = review.ok;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = review.no;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = review.next;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = review.url;
        }
        return review.copy(str, str7, str8, str9, str10, str6);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getMsg() {
        return this.msg;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getOk() {
        return this.ok;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getNo() {
        return this.no;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getNext() {
        return this.next;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public final Review copy(String title, String msg, String ok, String no, String next, String url) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(ok, "ok");
        Intrinsics.checkNotNullParameter(no, "no");
        Intrinsics.checkNotNullParameter(next, "next");
        Intrinsics.checkNotNullParameter(url, "url");
        return new Review(title, msg, ok, no, next, url);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Review)) {
            return false;
        }
        Review review = (Review) other;
        return Intrinsics.areEqual(this.title, review.title) && Intrinsics.areEqual(this.msg, review.msg) && Intrinsics.areEqual(this.ok, review.ok) && Intrinsics.areEqual(this.no, review.no) && Intrinsics.areEqual(this.next, review.next) && Intrinsics.areEqual(this.url, review.url);
    }

    public int hashCode() {
        return (((((((((this.title.hashCode() * 31) + this.msg.hashCode()) * 31) + this.ok.hashCode()) * 31) + this.no.hashCode()) * 31) + this.next.hashCode()) * 31) + this.url.hashCode();
    }

    public String toString() {
        return "Review(title=" + this.title + ", msg=" + this.msg + ", ok=" + this.ok + ", no=" + this.no + ", next=" + this.next + ", url=" + this.url + ')';
    }

    public Review(String title, String msg, String ok, String no, String next, String url) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(ok, "ok");
        Intrinsics.checkNotNullParameter(no, "no");
        Intrinsics.checkNotNullParameter(next, "next");
        Intrinsics.checkNotNullParameter(url, "url");
        this.title = title;
        this.msg = msg;
        this.ok = ok;
        this.no = no;
        this.next = next;
        this.url = url;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final void setMsg(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.msg = str;
    }

    public final String getOk() {
        return this.ok;
    }

    public final void setOk(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ok = str;
    }

    public final String getNo() {
        return this.no;
    }

    public final void setNo(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.no = str;
    }

    public final String getNext() {
        return this.next;
    }

    public final void setNext(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.next = str;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.url = str;
    }
}
