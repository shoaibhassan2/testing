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
public class AlertFragmentDialog extends DialogFragment implements View.OnClickListener {
    Button buttonOk;
    String iconType;
    ImageView imageViewAlertType;
    String message;
    String okButtonText;
    TextView textViewAlertMessage;
    TextView textViewAlertTitle;
    String title;

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.buttonOk) {
            dismiss();
        }
    }

    public static AlertFragmentDialog newInstance(String iconType, String title, String message, String okButtonText) {
        AlertFragmentDialog alertFragmentDialog = new AlertFragmentDialog();
        Bundle bundle = new Bundle();
        bundle.putString("ICON_TYPE", iconType);
        bundle.putString("TITLE", title);
        bundle.putString("MESSAGE", message);
        bundle.putString("OK_BUTTON_TEXT", okButtonText);
        alertFragmentDialog.setArguments(bundle);
        return alertFragmentDialog;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getDialog().getWindow().requestFeature(1);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0000ffff")));
        View viewInflate = inflater.inflate(R.layout.layout_alert_dialog, container, false);
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
        getArgumentsData();
        populateViews();
    }

    private void getArgumentsData() {
        this.iconType = getArguments().getString("ICON_TYPE");
        this.title = getArguments().getString("TITLE");
        this.message = getArguments().getString("MESSAGE");
        this.okButtonText = getArguments().getString("OK_BUTTON_TEXT");
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