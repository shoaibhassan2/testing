package pk.gov.nadra.dialogs;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import pk.gov.nadra.rahbar.android.R;

/* loaded from: classes5.dex */
public class NearMeConfirmationFragmentDialog extends DialogFragment implements View.OnClickListener {
    Button buttonAverageTimeWise;
    Button buttonDistanceWise;
    INearMeConfirmationFragmentDialog iNearMeConfirmationFragmentDialog;
    ImageView imageViewCloseIcon;
    int language = 0;
    String message;
    TextView textViewAlertMessage;
    TextView textViewAlertTitle;
    String title;

    public interface INearMeConfirmationFragmentDialog {
        void onNearMeConfirmationClicked(NEAR_ME_CONFIRMATION nearMeConfirmation);
    }

    public enum NEAR_ME_CONFIRMATION {
        DISTANCE_WISE,
        AVERAGE_TIME_WISE
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.imageViewCloseIcon) {
            dismiss();
            return;
        }
        if (id == R.id.buttonDistanceWise) {
            dismiss();
            INearMeConfirmationFragmentDialog iNearMeConfirmationFragmentDialog = this.iNearMeConfirmationFragmentDialog;
            if (iNearMeConfirmationFragmentDialog != null) {
                iNearMeConfirmationFragmentDialog.onNearMeConfirmationClicked(NEAR_ME_CONFIRMATION.DISTANCE_WISE);
                return;
            }
            return;
        }
        if (id == R.id.buttonAverageTimeWise) {
            dismiss();
            INearMeConfirmationFragmentDialog iNearMeConfirmationFragmentDialog2 = this.iNearMeConfirmationFragmentDialog;
            if (iNearMeConfirmationFragmentDialog2 != null) {
                iNearMeConfirmationFragmentDialog2.onNearMeConfirmationClicked(NEAR_ME_CONFIRMATION.AVERAGE_TIME_WISE);
            }
        }
    }

    public NearMeConfirmationFragmentDialog() {
    }

    public NearMeConfirmationFragmentDialog(String title, String message) {
        this.title = title;
        this.message = message;
    }

    public void setCallBack(INearMeConfirmationFragmentDialog callback) {
        this.iNearMeConfirmationFragmentDialog = callback;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View viewInflate;
        Window window = getDialog().getWindow();
        window.requestFeature(1);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0000ffff")));
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 80;
        attributes.y = this.language == 1 ? 220 : 200;
        window.setGravity(80);
        if (this.language == 1) {
            viewInflate = inflater.inflate(R.layout.layout_near_me_confirmation_dialog_urdu, container, false);
        } else {
            viewInflate = inflater.inflate(R.layout.layout_near_me_confirmation_dialog, container, false);
        }
        this.textViewAlertTitle = (TextView) viewInflate.findViewById(R.id.textViewAlertTitle);
        this.textViewAlertMessage = (TextView) viewInflate.findViewById(R.id.textViewAlertMessage);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.imageViewCloseIcon);
        this.imageViewCloseIcon = imageView;
        imageView.setOnClickListener(this);
        Button button = (Button) viewInflate.findViewById(R.id.buttonDistanceWise);
        this.buttonDistanceWise = button;
        button.setOnClickListener(this);
        Button button2 = (Button) viewInflate.findViewById(R.id.buttonAverageTimeWise);
        this.buttonAverageTimeWise = button2;
        button2.setOnClickListener(this);
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (savedInstanceState == null) {
            populateViews();
        } else {
            populateViewsWithSavedValues(savedInstanceState);
        }
    }

    private void populateViews() {
        this.textViewAlertTitle.setText(this.title);
        this.textViewAlertMessage.setText(this.message);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("title", this.textViewAlertTitle.getText().toString());
        savedInstanceState.putString("message", this.textViewAlertMessage.getText().toString());
    }

    private void populateViewsWithSavedValues(Bundle savedInstanceState) {
        this.textViewAlertTitle.setText(savedInstanceState.getString("title"));
        this.textViewAlertMessage.setText(savedInstanceState.getString("message"));
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public void setLanguage(int language) {
        this.language = language;
    }
}