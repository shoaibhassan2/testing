package pk.gov.nadra.selectoptionsbs.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.checkbox.MaterialCheckBox;
import pk.gov.nadra.selectoptionsbs.R;

/* loaded from: classes6.dex */
public final class ItemOptionBinding implements ViewBinding {
    public final MaterialCheckBox checkbox;
    private final ConstraintLayout rootView;
    public final TextView textView;

    private ItemOptionBinding(ConstraintLayout constraintLayout, MaterialCheckBox materialCheckBox, TextView textView) {
        this.rootView = constraintLayout;
        this.checkbox = materialCheckBox;
        this.textView = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemOptionBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemOptionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_option, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemOptionBinding bind(View view) {
        int i = R.id.checkbox;
        MaterialCheckBox materialCheckBox = (MaterialCheckBox) ViewBindings.findChildViewById(view, i);
        if (materialCheckBox != null) {
            i = R.id.text_view;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                return new ItemOptionBinding((ConstraintLayout) view, materialCheckBox, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}