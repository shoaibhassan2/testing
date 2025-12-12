package pk.gov.nadra.pakid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager.widget.ViewPager;
import pk.gov.nadra.pakid.R;

/* loaded from: classes6.dex */
public final class ActivityOnboardingBinding implements ViewBinding {
    public final TextView btnNext;
    public final TextView btnSkip;
    public final ViewPager onboardingViewPager;
    private final ConstraintLayout rootView;

    private ActivityOnboardingBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, ViewPager viewPager) {
        this.rootView = constraintLayout;
        this.btnNext = textView;
        this.btnSkip = textView2;
        this.onboardingViewPager = viewPager;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityOnboardingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityOnboardingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_onboarding, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityOnboardingBinding bind(View view) {
        int i = R.id.btnNext;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.btnSkip;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.onboardingViewPager;
                ViewPager viewPager = (ViewPager) ViewBindings.findChildViewById(view, i);
                if (viewPager != null) {
                    return new ActivityOnboardingBinding((ConstraintLayout) view, textView, textView2, viewPager);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}