package pk.gov.nadra.selectoptionsbs.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import pk.gov.nadra.selectoptionsbs.adapters.OptionAdapter;
import pk.gov.nadra.selectoptionsbs.databinding.ItemOptionBinding;
import pk.gov.nadra.selectoptionsbs.model.ItemData;

/* compiled from: OptionAdapter.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u00012\u00020\u0003:\u0001\u001dB1\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0011\u001a\u00020\fH\u0002J\u001c\u0010\u0012\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000bH\u0016J\u001c\u0010\u0016\u001a\u00020\f2\n\u0010\u0017\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u000bH\u0016J\b\u0010\u0019\u001a\u00020\u000bH\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lpk/gov/nadra/selectoptionsbs/adapters/OptionAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lpk/gov/nadra/selectoptionsbs/adapters/OptionAdapter$OptionViewHolder;", "Landroid/widget/Filterable;", "originalList", "", "Lpk/gov/nadra/selectoptionsbs/model/ItemData;", "isMultipleSelection", "", "onItemsSelected", "Lkotlin/Function1;", "", "", "<init>", "(Ljava/util/List;ZLkotlin/jvm/functions/Function1;)V", "filteredList", "selectedItems", "updateSelectedItems", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemCount", "getFilter", "Landroid/widget/Filter;", "getSelectedItems", "OptionViewHolder", "OptionPickerBS_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class OptionAdapter extends RecyclerView.Adapter<OptionViewHolder> implements Filterable {
    private List<ItemData> filteredList;
    private final boolean isMultipleSelection;
    private final Function1<Integer, Unit> onItemsSelected;
    private final List<ItemData> originalList;
    private final List<ItemData> selectedItems;

    /* JADX WARN: Multi-variable type inference failed */
    public OptionAdapter(List<ItemData> originalList, boolean z, Function1<? super Integer, Unit> onItemsSelected) {
        Intrinsics.checkNotNullParameter(originalList, "originalList");
        Intrinsics.checkNotNullParameter(onItemsSelected, "onItemsSelected");
        this.originalList = originalList;
        this.isMultipleSelection = z;
        this.onItemsSelected = onItemsSelected;
        this.filteredList = originalList;
        this.selectedItems = new ArrayList();
        updateSelectedItems();
    }

    private final void updateSelectedItems() {
        this.selectedItems.clear();
        List<ItemData> list = this.selectedItems;
        List<ItemData> list2 = this.filteredList;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list2) {
            if (((ItemData) obj).isSelected()) {
                arrayList.add(obj);
            }
        }
        list.addAll(arrayList);
        this.onItemsSelected.invoke(Integer.valueOf(this.selectedItems.size()));
    }

    /* compiled from: OptionAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lpk/gov/nadra/selectoptionsbs/adapters/OptionAdapter$OptionViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lpk/gov/nadra/selectoptionsbs/databinding/ItemOptionBinding;", "<init>", "(Lpk/gov/nadra/selectoptionsbs/adapters/OptionAdapter;Lpk/gov/nadra/selectoptionsbs/databinding/ItemOptionBinding;)V", "bindItem", "", "itemData", "Lpk/gov/nadra/selectoptionsbs/model/ItemData;", "OptionPickerBS_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class OptionViewHolder extends RecyclerView.ViewHolder {
        private ItemOptionBinding binding;
        final /* synthetic */ OptionAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OptionViewHolder(OptionAdapter optionAdapter, ItemOptionBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = optionAdapter;
            this.binding = binding;
        }

        public final void bindItem(final ItemData itemData) {
            Intrinsics.checkNotNullParameter(itemData, "itemData");
            final ItemOptionBinding itemOptionBinding = this.binding;
            final OptionAdapter optionAdapter = this.this$0;
            itemOptionBinding.textView.setText(itemData.getName());
            itemOptionBinding.checkbox.setChecked(itemData.isSelected());
            itemOptionBinding.checkbox.setClickable(false);
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: pk.gov.nadra.selectoptionsbs.adapters.OptionAdapter$OptionViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    OptionAdapter.OptionViewHolder.bindItem$lambda$2$lambda$1(optionAdapter, itemData, itemOptionBinding, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bindItem$lambda$2$lambda$1(OptionAdapter this$0, ItemData itemData, ItemOptionBinding this_apply, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(itemData, "$itemData");
            Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
            if (this$0.isMultipleSelection) {
                if (this$0.selectedItems.contains(itemData)) {
                    this$0.selectedItems.remove(itemData);
                    this_apply.checkbox.setChecked(false);
                    itemData.setSelected(false);
                } else {
                    this$0.selectedItems.add(itemData);
                    this_apply.checkbox.setChecked(true);
                    itemData.setSelected(true);
                }
            } else if (!this$0.selectedItems.contains(itemData)) {
                Iterator it = this$0.selectedItems.iterator();
                while (it.hasNext()) {
                    ((ItemData) it.next()).setSelected(false);
                }
                this$0.selectedItems.clear();
                itemData.setSelected(true);
                this$0.selectedItems.add(itemData);
                this$0.notifyDataSetChanged();
            }
            this$0.onItemsSelected.invoke(Integer.valueOf(this$0.selectedItems.size()));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public OptionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemOptionBinding itemOptionBindingInflate = ItemOptionBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(itemOptionBindingInflate, "inflate(...)");
        return new OptionViewHolder(this, itemOptionBindingInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(OptionViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bindItem(this.filteredList.get(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.filteredList.size();
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        return new Filter() { // from class: pk.gov.nadra.selectoptionsbs.adapters.OptionAdapter.getFilter.1
            /* JADX WARN: Removed duplicated region for block: B:9:0x0021  */
            @Override // android.widget.Filter
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            protected android.widget.Filter.FilterResults performFiltering(java.lang.CharSequence r9) {
                /*
                    r8 = this;
                    java.lang.String r0 = "toLowerCase(...)"
                    r1 = 0
                    if (r9 == 0) goto L21
                    java.lang.String r9 = r9.toString()
                    if (r9 == 0) goto L21
                    java.util.Locale r2 = java.util.Locale.ROOT
                    java.lang.String r9 = r9.toLowerCase(r2)
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r0)
                    if (r9 == 0) goto L21
                    java.lang.CharSequence r9 = (java.lang.CharSequence) r9
                    java.lang.CharSequence r9 = kotlin.text.StringsKt.trim(r9)
                    java.lang.String r9 = r9.toString()
                    goto L22
                L21:
                    r9 = r1
                L22:
                    java.lang.CharSequence r9 = (java.lang.CharSequence) r9
                    if (r9 == 0) goto L6b
                    int r2 = r9.length()
                    if (r2 != 0) goto L2d
                    goto L6b
                L2d:
                    pk.gov.nadra.selectoptionsbs.adapters.OptionAdapter r2 = pk.gov.nadra.selectoptionsbs.adapters.OptionAdapter.this
                    java.util.List r2 = pk.gov.nadra.selectoptionsbs.adapters.OptionAdapter.access$getOriginalList$p(r2)
                    java.lang.Iterable r2 = (java.lang.Iterable) r2
                    java.util.ArrayList r3 = new java.util.ArrayList
                    r3.<init>()
                    java.util.Collection r3 = (java.util.Collection) r3
                    java.util.Iterator r2 = r2.iterator()
                L40:
                    boolean r4 = r2.hasNext()
                    if (r4 == 0) goto L68
                    java.lang.Object r4 = r2.next()
                    r5 = r4
                    pk.gov.nadra.selectoptionsbs.model.ItemData r5 = (pk.gov.nadra.selectoptionsbs.model.ItemData) r5
                    java.lang.String r5 = r5.getName()
                    java.util.Locale r6 = java.util.Locale.ROOT
                    java.lang.String r5 = r5.toLowerCase(r6)
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
                    java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                    r6 = 0
                    r7 = 2
                    boolean r5 = kotlin.text.StringsKt.contains$default(r5, r9, r6, r7, r1)
                    if (r5 == 0) goto L40
                    r3.add(r4)
                    goto L40
                L68:
                    java.util.List r3 = (java.util.List) r3
                    goto L71
                L6b:
                    pk.gov.nadra.selectoptionsbs.adapters.OptionAdapter r9 = pk.gov.nadra.selectoptionsbs.adapters.OptionAdapter.this
                    java.util.List r3 = pk.gov.nadra.selectoptionsbs.adapters.OptionAdapter.access$getOriginalList$p(r9)
                L71:
                    android.widget.Filter$FilterResults r9 = new android.widget.Filter$FilterResults
                    r9.<init>()
                    r9.values = r3
                    return r9
                */
                throw new UnsupportedOperationException("Method not decompiled: pk.gov.nadra.selectoptionsbs.adapters.OptionAdapter.AnonymousClass1.performFiltering(java.lang.CharSequence):android.widget.Filter$FilterResults");
            }

            @Override // android.widget.Filter
            protected void publishResults(CharSequence constraint, Filter.FilterResults results) {
                OptionAdapter optionAdapter = OptionAdapter.this;
                Object obj = results != null ? results.values : null;
                ArrayList arrayList = TypeIntrinsics.isMutableList(obj) ? (List) obj : null;
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                optionAdapter.filteredList = arrayList;
                OptionAdapter.this.notifyDataSetChanged();
            }
        };
    }

    public final List<ItemData> getSelectedItems() {
        return this.selectedItems;
    }
}