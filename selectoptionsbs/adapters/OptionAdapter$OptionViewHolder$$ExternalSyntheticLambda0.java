package pk.gov.nadra.selectoptionsbs.adapters;

import android.view.View;
import pk.gov.nadra.selectoptionsbs.adapters.OptionAdapter;
import pk.gov.nadra.selectoptionsbs.databinding.ItemOptionBinding;
import pk.gov.nadra.selectoptionsbs.model.ItemData;

/* compiled from: D8$$SyntheticClass */
/* loaded from: classes6.dex */
public final /* synthetic */ class OptionAdapter$OptionViewHolder$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ ItemData f$1;
    public final /* synthetic */ ItemOptionBinding f$2;

    public /* synthetic */ OptionAdapter$OptionViewHolder$$ExternalSyntheticLambda0(ItemData itemData, ItemOptionBinding itemOptionBinding) {
        itemData = itemData;
        itemOptionBinding = itemOptionBinding;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        OptionAdapter.OptionViewHolder.bindItem$lambda$2$lambda$1(optionAdapter, itemData, itemOptionBinding, view);
    }
}