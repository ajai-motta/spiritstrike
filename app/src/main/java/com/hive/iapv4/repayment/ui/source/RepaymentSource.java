package com.hive.iapv4.repayment.ui.source;

import com.hive.analytics.provider.adjust.AnalyticsProviderAdjust;
import com.hive.iapv4.repayment.ui.model.RepaymentItem;
import com.hive.iapv4.repayment.ui.model.RepaymentState;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: RepaymentSource.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001BI\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0000J\u000e\u0010%\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0000J\u0010\u0010&\u001a\u0004\u0018\u00010\t2\u0006\u0010'\u001a\u00020\u0005J\u0012\u0010(\u001a\u0004\u0018\u00010\t2\b\u0010)\u001a\u0004\u0018\u00010\tJ\u0016\u0010*\u001a\u00020#2\u0006\u0010)\u001a\u00020\t2\u0006\u0010+\u001a\u00020,J\u0006\u0010-\u001a\u00020\u0003J\u0006\u0010.\u001a\u00020\u0003J\u000e\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u0003J\u0006\u00101\u001a\u000202J\u0006\u00103\u001a\u00020\u0003J\b\u00104\u001a\u00020#H\u0002R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0013\"\u0004\b\u001d\u0010\u0015R\u001a\u0010\u000b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0013\"\u0004\b\u001f\u0010\u0015R\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0019¨\u00065"}, d2 = {"Lcom/hive/iapv4/repayment/ui/source/RepaymentSource;", "", "selectedMarketId", "", "inquiryUrl", "", "csCode", "itemList", "", "Lcom/hive/iapv4/repayment/ui/model/RepaymentItem;", "guideTitle", "guideContent", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getSelectedMarketId", "()I", "setSelectedMarketId", "(I)V", "getInquiryUrl", "()Ljava/lang/String;", "setInquiryUrl", "(Ljava/lang/String;)V", "getCsCode", "setCsCode", "getItemList", "()Ljava/util/List;", "setItemList", "(Ljava/util/List;)V", "getGuideTitle", "setGuideTitle", "getGuideContent", "setGuideContent", "sortedList", "getSortedList", "setTo", "", "source", "mergeTo", "getRequireItem", AnalyticsProviderAdjust.EventKeys.pid, "getItem", "item", "changeItemState", "changeState", "Lcom/hive/iapv4/repayment/ui/model/RepaymentState;", "getFullCount", "getCompleteCount", "getRemainCount", "marketId", "isFullComplete", "", "getMarketCount", "sortData", "hive-iapv4-repayment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RepaymentSource {
    private String csCode;
    private String guideContent;
    private String guideTitle;
    private String inquiryUrl;
    private List<RepaymentItem> itemList;
    private int selectedMarketId;
    private final List<RepaymentItem> sortedList;

    public RepaymentSource() {
        this(0, null, null, null, null, null, 63, null);
    }

    public RepaymentSource(int i, String inquiryUrl, String csCode, List<RepaymentItem> itemList, String guideTitle, String guideContent) {
        Intrinsics.checkNotNullParameter(inquiryUrl, "inquiryUrl");
        Intrinsics.checkNotNullParameter(csCode, "csCode");
        Intrinsics.checkNotNullParameter(itemList, "itemList");
        Intrinsics.checkNotNullParameter(guideTitle, "guideTitle");
        Intrinsics.checkNotNullParameter(guideContent, "guideContent");
        this.selectedMarketId = i;
        this.inquiryUrl = inquiryUrl;
        this.csCode = csCode;
        this.itemList = itemList;
        this.guideTitle = guideTitle;
        this.guideContent = guideContent;
        this.sortedList = new ArrayList();
        sortData();
    }

    public /* synthetic */ RepaymentSource(int i, String str, String str2, ArrayList arrayList, String str3, String str4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? "" : str2, (i2 & 8) != 0 ? new ArrayList() : arrayList, (i2 & 16) != 0 ? "" : str3, (i2 & 32) == 0 ? str4 : "");
    }

    public final int getSelectedMarketId() {
        return this.selectedMarketId;
    }

    public final void setSelectedMarketId(int i) {
        this.selectedMarketId = i;
    }

    public final String getInquiryUrl() {
        return this.inquiryUrl;
    }

    public final void setInquiryUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.inquiryUrl = str;
    }

    public final String getCsCode() {
        return this.csCode;
    }

    public final void setCsCode(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.csCode = str;
    }

    public final List<RepaymentItem> getItemList() {
        return this.itemList;
    }

    public final void setItemList(List<RepaymentItem> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.itemList = list;
    }

    public final String getGuideTitle() {
        return this.guideTitle;
    }

    public final void setGuideTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.guideTitle = str;
    }

    public final String getGuideContent() {
        return this.guideContent;
    }

    public final void setGuideContent(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.guideContent = str;
    }

    public final List<RepaymentItem> getSortedList() {
        return this.sortedList;
    }

    public final void setTo(RepaymentSource source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.selectedMarketId = source.selectedMarketId;
        this.inquiryUrl = source.inquiryUrl;
        this.csCode = source.csCode;
        this.itemList = source.itemList;
        this.guideTitle = source.guideTitle;
        this.guideContent = source.guideContent;
        sortData();
    }

    public final void mergeTo(RepaymentSource source) {
        Object next;
        Intrinsics.checkNotNullParameter(source, "source");
        if (this.selectedMarketId == 0) {
            this.selectedMarketId = source.selectedMarketId;
        }
        if (StringsKt.isBlank(this.inquiryUrl)) {
            this.inquiryUrl = source.inquiryUrl;
        }
        if (StringsKt.isBlank(this.csCode)) {
            this.csCode = source.csCode;
        }
        if (StringsKt.isBlank(this.guideTitle)) {
            this.guideTitle = source.guideTitle;
        }
        if (StringsKt.isBlank(this.guideContent)) {
            this.guideContent = source.guideContent;
        }
        for (RepaymentItem repaymentItem : this.itemList) {
            Iterator<T> it = source.itemList.iterator();
            while (true) {
                if (it.hasNext()) {
                    next = it.next();
                    if (repaymentItem.getRefundIndex() == ((RepaymentItem) next).getRefundIndex()) {
                        break;
                    }
                } else {
                    next = null;
                    break;
                }
            }
            if (((RepaymentItem) next) == null) {
                repaymentItem.setState(RepaymentState.Complete);
                source.itemList.add(repaymentItem);
            }
        }
        this.itemList = source.itemList;
        sortData();
    }

    public final RepaymentItem getRequireItem(String pid) {
        Intrinsics.checkNotNullParameter(pid, "pid");
        for (RepaymentItem repaymentItem : this.itemList) {
            if (this.selectedMarketId == repaymentItem.getMarketId() && Intrinsics.areEqual(pid, repaymentItem.getMarketPid()) && repaymentItem.getState() == RepaymentState.Require) {
                return repaymentItem;
            }
        }
        return null;
    }

    public final RepaymentItem getItem(RepaymentItem item) {
        if (item == null) {
            return null;
        }
        for (RepaymentItem repaymentItem : this.itemList) {
            if (Intrinsics.areEqual(item, repaymentItem)) {
                return repaymentItem;
            }
        }
        return null;
    }

    public final void changeItemState(RepaymentItem item, RepaymentState changeState) {
        Object obj;
        Object next;
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(changeState, "changeState");
        Iterator<T> it = this.itemList.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (((RepaymentItem) next).getRefundIndex() == item.getRefundIndex()) {
                    break;
                }
            }
        }
        RepaymentItem repaymentItem = (RepaymentItem) next;
        if (repaymentItem != null) {
            repaymentItem.setState(changeState);
        }
        Iterator<T> it2 = this.sortedList.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next2 = it2.next();
            if (((RepaymentItem) next2).getRefundIndex() == item.getRefundIndex()) {
                obj = next2;
                break;
            }
        }
        RepaymentItem repaymentItem2 = (RepaymentItem) obj;
        if (repaymentItem2 != null) {
            repaymentItem2.setState(changeState);
        }
    }

    public final int getFullCount() {
        return this.itemList.size();
    }

    public final int getCompleteCount() {
        List<RepaymentItem> list = this.itemList;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((RepaymentItem) obj).getState() == RepaymentState.Complete) {
                arrayList.add(obj);
            }
        }
        return arrayList.size();
    }

    public final int getRemainCount(int marketId) {
        List<RepaymentItem> list = this.itemList;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            RepaymentItem repaymentItem = (RepaymentItem) obj;
            if (repaymentItem.getState() != RepaymentState.Complete && repaymentItem.getMarketId() == marketId) {
                arrayList.add(obj);
            }
        }
        return arrayList.size();
    }

    public final boolean isFullComplete() {
        List<RepaymentItem> list = this.itemList;
        if ((list instanceof Collection) && list.isEmpty()) {
            return true;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (((RepaymentItem) it.next()).getState() != RepaymentState.Complete) {
                return false;
            }
        }
        return true;
    }

    public final int getMarketCount() {
        return CollectionsKt.toSortedSet(this.itemList, new Comparator() { // from class: com.hive.iapv4.repayment.ui.source.RepaymentSource$getMarketCount$$inlined$compareBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Integer.valueOf(((RepaymentItem) t).getMarketId()), Integer.valueOf(((RepaymentItem) t2).getMarketId()));
            }
        }).size();
    }

    private final void sortData() {
        this.sortedList.clear();
        List<RepaymentItem> list = this.sortedList;
        List<RepaymentItem> list2 = this.itemList;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list2) {
            if (((RepaymentItem) obj).getMarketId() == this.selectedMarketId) {
                arrayList.add(obj);
            }
        }
        list.addAll(arrayList);
        Set setMutableSetOf = SetsKt.mutableSetOf(Integer.valueOf(this.selectedMarketId));
        for (RepaymentItem repaymentItem : this.itemList) {
            if (!setMutableSetOf.contains(Integer.valueOf(repaymentItem.getMarketId()))) {
                this.sortedList.add(new RepaymentItem(0, repaymentItem.getMarketId(), repaymentItem.getMarketName(), "", "", "", "", 1, RepaymentState.Require));
                setMutableSetOf.add(Integer.valueOf(repaymentItem.getMarketId()));
            }
        }
    }
}
