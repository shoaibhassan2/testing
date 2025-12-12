package pk.gov.nadra.pakid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import pk.gov.nadra.pakid.R;

/* loaded from: classes6.dex */
public final class DeepConsentFragmenttBinding implements ViewBinding {
    public final MaterialButton allowButtonLayout;
    public final TextView consentAppNameTitle;
    public final TextView consentDescText;
    public final TextView consentDetailInfo;
    public final TextView consentHeaderTitleTextView;
    public final TextView consentLearnMoreTv;
    public final TextView consentNotYouTv;
    public final ImageView consentTopImageView;
    public final TextView consentUserDataValue1;
    public final TextView consentUserDataValue2;
    public final TextView consentUserDataValue3;
    public final TextView consentUserDataValue4;
    public final TextView consentUserDataValue5;
    public final MaterialButton denyButtonLayout;
    public final ConstraintLayout loginLayout;
    private final ConstraintLayout rootView;

    private DeepConsentFragmenttBinding(ConstraintLayout constraintLayout, MaterialButton materialButton, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, ImageView imageView, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, MaterialButton materialButton2, ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.allowButtonLayout = materialButton;
        this.consentAppNameTitle = textView;
        this.consentDescText = textView2;
        this.consentDetailInfo = textView3;
        this.consentHeaderTitleTextView = textView4;
        this.consentLearnMoreTv = textView5;
        this.consentNotYouTv = textView6;
        this.consentTopImageView = imageView;
        this.consentUserDataValue1 = textView7;
        this.consentUserDataValue2 = textView8;
        this.consentUserDataValue3 = textView9;
        this.consentUserDataValue4 = textView10;
        this.consentUserDataValue5 = textView11;
        this.denyButtonLayout = materialButton2;
        this.loginLayout = constraintLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static DeepConsentFragmenttBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DeepConsentFragmenttBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.deep_consent_fragmentt, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DeepConsentFragmenttBinding bind(View view) {
        int i = R.id.allow_button_layout;
        MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
        if (materialButton != null) {
            i = R.id.consent_app_name_title;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.consent_desc_text;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.consent_detail_info;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView3 != null) {
                        i = R.id.consent_header_title_textView;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView4 != null) {
                            i = R.id.consent_learn_more_tv;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView5 != null) {
                                i = R.id.consent_not_you_tv;
                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView6 != null) {
                                    i = R.id.consent_top_imageView;
                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                    if (imageView != null) {
                                        i = R.id.consent_user_data_value1;
                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView7 != null) {
                                            i = R.id.consent_user_data_value2;
                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView8 != null) {
                                                i = R.id.consent_user_data_value3;
                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView9 != null) {
                                                    i = R.id.consent_user_data_value4;
                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView10 != null) {
                                                        i = R.id.consent_user_data_value5;
                                                        TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView11 != null) {
                                                            i = R.id.deny_button_layout;
                                                            MaterialButton materialButton2 = (MaterialButton) ViewBindings.findChildViewById(view, i);
                                                            if (materialButton2 != null) {
                                                                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                                                return new DeepConsentFragmenttBinding(constraintLayout, materialButton, textView, textView2, textView3, textView4, textView5, textView6, imageView, textView7, textView8, textView9, textView10, textView11, materialButton2, constraintLayout);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}