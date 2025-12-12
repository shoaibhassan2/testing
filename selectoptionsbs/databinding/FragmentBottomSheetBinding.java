package pk.gov.nadra.selectoptionsbs.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import pk.gov.nadra.selectoptionsbs.R;

/* loaded from: classes6.dex */
public final class FragmentBottomSheetBinding implements ViewBinding {
    public final TextView bottomSheetDataLabelTextView;
    public final TextView bottomSheetDataUrduLabelTextView;
    public final MaterialButton btnConfirm;
    public final ImageView closeBottomSheetImageView;
    public final RecyclerView recyclerView;
    private final ConstraintLayout rootView;
    public final SearchView searchView;

    private FragmentBottomSheetBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, MaterialButton materialButton, ImageView imageView, RecyclerView recyclerView, SearchView searchView) {
        this.rootView = constraintLayout;
        this.bottomSheetDataLabelTextView = textView;
        this.bottomSheetDataUrduLabelTextView = textView2;
        this.btnConfirm = materialButton;
        this.closeBottomSheetImageView = imageView;
        this.recyclerView = recyclerView;
        this.searchView = searchView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentBottomSheetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentBottomSheetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_bottom_sheet, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentBottomSheetBinding bind(View view) {
        int i = R.id.bottom_sheet_data_label_textView;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.bottom_sheet_data_urdu_label_textView;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.btn_confirm;
                MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
                if (materialButton != null) {
                    i = R.id.close_bottom_sheet_imageView;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView != null) {
                        i = R.id.recycler_view;
                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                        if (recyclerView != null) {
                            i = R.id.search_view;
                            SearchView searchView = (SearchView) ViewBindings.findChildViewById(view, i);
                            if (searchView != null) {
                                return new FragmentBottomSheetBinding((ConstraintLayout) view, textView, textView2, materialButton, imageView, recyclerView, searchView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}