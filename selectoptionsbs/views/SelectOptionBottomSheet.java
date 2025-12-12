package pk.gov.nadra.selectoptionsbs.views;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.internal.view.SupportMenu;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import pk.gov.nadra.selectoptionsbs.adapters.OptionAdapter;
import pk.gov.nadra.selectoptionsbs.databinding.FragmentBottomSheetBinding;
import pk.gov.nadra.selectoptionsbs.model.ItemData;

/* compiled from: SelectOptionBottomSheet.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 )2\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J/\u0010\u001d\u001a\u00020\u00122'\u0010\u001e\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\n0\t¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\u000eJ\u0018\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\u0014H\u0002J\b\u0010\"\u001a\u00020\u0012H\u0002J \u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\b\b\u0002\u0010(\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R1\u0010\r\u001a%\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\n0\t¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lpk/gov/nadra/selectoptionsbs/views/SelectOptionBottomSheet;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "binding", "Lpk/gov/nadra/selectoptionsbs/databinding/FragmentBottomSheetBinding;", "adapter", "Lpk/gov/nadra/selectoptionsbs/adapters/OptionAdapter;", "optionsList", "", "Lpk/gov/nadra/selectoptionsbs/model/ItemData;", "isMultipleSelection", "", "onItemSelectedListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "selectedItems", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", Promotion.ACTION_VIEW, "setOnItemSelectedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "applyLayoutDirection", "isRtl", "rootView", "applyActivityLayoutDirection", "setEnglishTextSpan", "Landroid/text/SpannableString;", "englishText", "", "urduText", "isMandatory", "Companion", "OptionPickerBS_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class SelectOptionBottomSheet extends BottomSheetDialogFragment {
    public static final String ARG_DATA_LABEL = "sheet_data_label";
    public static final String ARG_DATA_URDU_LABEL = "sheet_data_urdu_label";
    public static final String ARG_OPTIONS = "options_list";
    public static final String ARG_SELECTION_MODE = "selection_mode";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private OptionAdapter adapter;
    private FragmentBottomSheetBinding binding;
    private boolean isMultipleSelection;
    private Function1<? super List<ItemData>, Unit> onItemSelectedListener;
    private List<ItemData> optionsList;

    /* compiled from: SelectOptionBottomSheet.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lpk/gov/nadra/selectoptionsbs/views/SelectOptionBottomSheet$Companion;", "", "<init>", "()V", "ARG_OPTIONS", "", "ARG_SELECTION_MODE", "ARG_DATA_LABEL", "ARG_DATA_URDU_LABEL", "newInstance", "Lpk/gov/nadra/selectoptionsbs/views/SelectOptionBottomSheet;", "options", "", "Lpk/gov/nadra/selectoptionsbs/model/ItemData;", "sheetDataLabel", "sheetDataUrduLabel", "isMultipleSelection", "", "OptionPickerBS_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SelectOptionBottomSheet newInstance(List<ItemData> options, String sheetDataLabel, String sheetDataUrduLabel, boolean isMultipleSelection) {
            Intrinsics.checkNotNullParameter(options, "options");
            Intrinsics.checkNotNullParameter(sheetDataLabel, "sheetDataLabel");
            Intrinsics.checkNotNullParameter(sheetDataUrduLabel, "sheetDataUrduLabel");
            SelectOptionBottomSheet selectOptionBottomSheet = new SelectOptionBottomSheet();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList(SelectOptionBottomSheet.ARG_OPTIONS, new ArrayList<>(options));
            bundle.putString(SelectOptionBottomSheet.ARG_DATA_LABEL, sheetDataLabel);
            bundle.putString(SelectOptionBottomSheet.ARG_DATA_URDU_LABEL, sheetDataUrduLabel);
            bundle.putBoolean(SelectOptionBottomSheet.ARG_SELECTION_MODE, isMultipleSelection);
            selectOptionBottomSheet.setArguments(bundle);
            return selectOptionBottomSheet;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentBottomSheetBinding fragmentBottomSheetBindingInflate = FragmentBottomSheetBinding.inflate(inflater, container, false);
        this.binding = fragmentBottomSheetBindingInflate;
        if (fragmentBottomSheetBindingInflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentBottomSheetBindingInflate = null;
        }
        ConstraintLayout root = fragmentBottomSheetBindingInflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        ArrayList arrayList;
        String string;
        String string2;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        applyActivityLayoutDirection();
        Object parent = view.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
        View view2 = (View) parent;
        view2.setBackgroundTintMode(PorterDuff.Mode.CLEAR);
        view2.setBackgroundTintList(ColorStateList.valueOf(0));
        view2.setBackgroundColor(0);
        Bundle arguments = getArguments();
        if (arguments == null || (arrayList = arguments.getParcelableArrayList(ARG_OPTIONS)) == null) {
            arrayList = new ArrayList();
        }
        this.optionsList = arrayList;
        Bundle arguments2 = getArguments();
        this.isMultipleSelection = arguments2 != null ? arguments2.getBoolean(ARG_SELECTION_MODE) : false;
        Bundle arguments3 = getArguments();
        if (arguments3 == null || (string = arguments3.getString(ARG_DATA_LABEL)) == null) {
            string = "Choose Option";
        }
        Bundle arguments4 = getArguments();
        if (arguments4 == null || (string2 = arguments4.getString(ARG_DATA_URDU_LABEL)) == null) {
            string2 = "";
        }
        FragmentBottomSheetBinding fragmentBottomSheetBinding = this.binding;
        FragmentBottomSheetBinding fragmentBottomSheetBinding2 = null;
        if (fragmentBottomSheetBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentBottomSheetBinding = null;
        }
        fragmentBottomSheetBinding.bottomSheetDataLabelTextView.setText(string);
        String str = string2;
        if (str.length() > 0) {
            FragmentBottomSheetBinding fragmentBottomSheetBinding3 = this.binding;
            if (fragmentBottomSheetBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentBottomSheetBinding3 = null;
            }
            fragmentBottomSheetBinding3.bottomSheetDataUrduLabelTextView.setText(str);
        } else {
            FragmentBottomSheetBinding fragmentBottomSheetBinding4 = this.binding;
            if (fragmentBottomSheetBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentBottomSheetBinding4 = null;
            }
            fragmentBottomSheetBinding4.bottomSheetDataUrduLabelTextView.setVisibility(8);
        }
        FragmentBottomSheetBinding fragmentBottomSheetBinding5 = this.binding;
        if (fragmentBottomSheetBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentBottomSheetBinding5 = null;
        }
        fragmentBottomSheetBinding5.closeBottomSheetImageView.setOnClickListener(new View.OnClickListener() { // from class: pk.gov.nadra.selectoptionsbs.views.SelectOptionBottomSheet$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                SelectOptionBottomSheet.onViewCreated$lambda$0(this.f$0, view3);
            }
        });
        ColorStateList colorStateList = new ColorStateList(new int[][]{new int[]{-16842910}, new int[]{R.attr.state_enabled}}, new int[]{ContextCompat.getColor(requireContext(), pk.gov.nadra.selectoptionsbs.R.color.disable_button_color), ContextCompat.getColor(requireContext(), pk.gov.nadra.selectoptionsbs.R.color.blue_button)});
        FragmentBottomSheetBinding fragmentBottomSheetBinding6 = this.binding;
        if (fragmentBottomSheetBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentBottomSheetBinding6 = null;
        }
        fragmentBottomSheetBinding6.btnConfirm.setBackgroundTintList(colorStateList);
        FragmentBottomSheetBinding fragmentBottomSheetBinding7 = this.binding;
        if (fragmentBottomSheetBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentBottomSheetBinding7 = null;
        }
        fragmentBottomSheetBinding7.searchView.setQueryHint(setEnglishTextSpan$default(this, "Search", " (تلاش) ", false, 4, null));
        FragmentBottomSheetBinding fragmentBottomSheetBinding8 = this.binding;
        if (fragmentBottomSheetBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentBottomSheetBinding8 = null;
        }
        fragmentBottomSheetBinding8.searchView.setIconified(false);
        FragmentBottomSheetBinding fragmentBottomSheetBinding9 = this.binding;
        if (fragmentBottomSheetBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentBottomSheetBinding9 = null;
        }
        fragmentBottomSheetBinding9.searchView.clearFocus();
        List<ItemData> list = this.optionsList;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("optionsList");
            list = null;
        }
        this.adapter = new OptionAdapter(list, this.isMultipleSelection, new Function1() { // from class: pk.gov.nadra.selectoptionsbs.views.SelectOptionBottomSheet$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SelectOptionBottomSheet.onViewCreated$lambda$1(this.f$0, ((Integer) obj).intValue());
            }
        });
        FragmentBottomSheetBinding fragmentBottomSheetBinding10 = this.binding;
        if (fragmentBottomSheetBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentBottomSheetBinding10 = null;
        }
        fragmentBottomSheetBinding10.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        FragmentBottomSheetBinding fragmentBottomSheetBinding11 = this.binding;
        if (fragmentBottomSheetBinding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentBottomSheetBinding11 = null;
        }
        RecyclerView recyclerView = fragmentBottomSheetBinding11.recyclerView;
        OptionAdapter optionAdapter = this.adapter;
        if (optionAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            optionAdapter = null;
        }
        recyclerView.setAdapter(optionAdapter);
        FragmentBottomSheetBinding fragmentBottomSheetBinding12 = this.binding;
        if (fragmentBottomSheetBinding12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentBottomSheetBinding12 = null;
        }
        fragmentBottomSheetBinding12.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() { // from class: pk.gov.nadra.selectoptionsbs.views.SelectOptionBottomSheet.onViewCreated.3
            @Override // android.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override // android.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextChange(String newText) {
                OptionAdapter optionAdapter2 = SelectOptionBottomSheet.this.adapter;
                if (optionAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    optionAdapter2 = null;
                }
                optionAdapter2.getFilter().filter(newText);
                return true;
            }
        });
        FragmentBottomSheetBinding fragmentBottomSheetBinding13 = this.binding;
        if (fragmentBottomSheetBinding13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentBottomSheetBinding13 = null;
        }
        fragmentBottomSheetBinding13.btnConfirm.setText(setEnglishTextSpan$default(this, "Confirm Selection", "\n(انتخاب کی تصدیق کریں)", false, 4, null));
        FragmentBottomSheetBinding fragmentBottomSheetBinding14 = this.binding;
        if (fragmentBottomSheetBinding14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentBottomSheetBinding2 = fragmentBottomSheetBinding14;
        }
        fragmentBottomSheetBinding2.btnConfirm.setOnClickListener(new View.OnClickListener() { // from class: pk.gov.nadra.selectoptionsbs.views.SelectOptionBottomSheet$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                SelectOptionBottomSheet.onViewCreated$lambda$2(this.f$0, view3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(SelectOptionBottomSheet this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$1(SelectOptionBottomSheet this$0, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentBottomSheetBinding fragmentBottomSheetBinding = this$0.binding;
        if (fragmentBottomSheetBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentBottomSheetBinding = null;
        }
        fragmentBottomSheetBinding.btnConfirm.setEnabled(i > 0);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$2(SelectOptionBottomSheet this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        OptionAdapter optionAdapter = this$0.adapter;
        if (optionAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            optionAdapter = null;
        }
        List<ItemData> selectedItems = optionAdapter.getSelectedItems();
        Function1<? super List<ItemData>, Unit> function1 = this$0.onItemSelectedListener;
        if (function1 != null) {
            function1.invoke(selectedItems);
        }
        this$0.dismiss();
    }

    public final void setOnItemSelectedListener(Function1<? super List<ItemData>, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onItemSelectedListener = listener;
    }

    private final void applyLayoutDirection(boolean isRtl, View rootView) {
        if (rootView != null) {
            rootView.setLayoutDirection(isRtl ? 1 : 0);
        }
    }

    private final void applyActivityLayoutDirection() {
        FragmentBottomSheetBinding fragmentBottomSheetBinding = this.binding;
        if (fragmentBottomSheetBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentBottomSheetBinding = null;
        }
        ConstraintLayout root = fragmentBottomSheetBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        applyLayoutDirection(false, root);
    }

    public static /* synthetic */ SpannableString setEnglishTextSpan$default(SelectOptionBottomSheet selectOptionBottomSheet, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return selectOptionBottomSheet.setEnglishTextSpan(str, str2, z);
    }

    public final SpannableString setEnglishTextSpan(String englishText, String urduText, boolean isMandatory) throws Resources.NotFoundException {
        StringBuilder sb;
        StringBuilder sbAppend;
        Intrinsics.checkNotNullParameter(englishText, "englishText");
        Intrinsics.checkNotNullParameter(urduText, "urduText");
        Typeface font = ResourcesCompat.getFont(requireContext(), pk.gov.nadra.selectoptionsbs.R.font.option_bs_roboto_medium);
        Typeface font2 = ResourcesCompat.getFont(requireContext(), pk.gov.nadra.selectoptionsbs.R.font.option_bs_nadra_nastaleeq);
        if (isMandatory) {
            sb = new StringBuilder();
            sbAppend = sb.append(englishText).append(urduText).append(" *");
        } else {
            sb = new StringBuilder();
            sbAppend = sb.append(englishText).append(urduText);
        }
        String string = sbAppend.toString();
        SpannableString spannableString = new SpannableString(string);
        int length = (string.length() - urduText.length()) - (isMandatory ? 2 : 0);
        if (font != null) {
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            spannableString.setSpan(new CustomFontSizeSpan(contextRequireContext, font, null, 4, null), 0, englishText.length(), 33);
        }
        if (font2 != null) {
            Context contextRequireContext2 = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
            spannableString.setSpan(new CustomFontSizeSpan(contextRequireContext2, font2, null, 4, null), length + 1, string.length(), 33);
        }
        if (isMandatory) {
            spannableString.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), string.length() - 1, string.length(), 33);
        }
        return spannableString;
    }
}