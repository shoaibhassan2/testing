package pk.gov.nadra.dialogs;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.squareup.picasso.Picasso;
import pk.gov.nadra.rahbar.android.R;

/* loaded from: classes5.dex */
public class FinishFragmentDialog extends DialogFragment implements View.OnClickListener {
    Button buttonOk;
    IFinishFragmentDialog iFinishFragmentDialog;
    String iconType;
    ImageView imageViewAlertType;
    String message;
    String okButtonText;
    TextView textViewAlertMessage;
    TextView textViewAlertTitle;
    String title;

    public interface IFinishFragmentDialog {
        void okay();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.buttonOk) {
            dismiss();
            this.iFinishFragmentDialog.okay();
        }
    }

    public FinishFragmentDialog() {
    }

    public FinishFragmentDialog(String iconType, String title, String message, String okButtonText, IFinishFragmentDialog callback) {
        this.iconType = iconType;
        this.title = title;
        this.message = message;
        this.okButtonText = okButtonText;
        this.iFinishFragmentDialog = callback;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getDialog().getWindow().requestFeature(1);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0000ffff")));
        View viewInflate = inflater.inflate(R.layout.layout_finish_dialog, container, false);
        this.imageViewAlertType = (ImageView) viewInflate.findViewById(R.id.imageViewAlertType);
        this.textViewAlertTitle = (TextView) viewInflate.findViewById(R.id.textViewAlertTitle);
        this.textViewAlertMessage = (TextView) viewInflate.findViewById(R.id.textViewAlertMessage);
        Button button = (Button) viewInflate.findViewById(R.id.buttonOk);
        this.buttonOk = button;
        button.setOnClickListener(this);
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        populateViews();
    }

    private void populateViews() {
        this.textViewAlertTitle.setText(this.title);
        this.textViewAlertMessage.setText(this.message);
        this.buttonOk.setText(this.okButtonText);
        setIcon();
    }

    private void setIcon() {
        String lowerCase = this.iconType.toLowerCase();
        lowerCase.hashCode();
        if (lowerCase.equals(FirebaseAnalytics.Param.SUCCESS)) {
            Picasso.get().load(R.drawable.success_icon).into(this.imageViewAlertType);
        } else if (lowerCase.equals("error")) {
            Picasso.get().load(R.drawable.error_icon).into(this.imageViewAlertType);
        }
    }
}