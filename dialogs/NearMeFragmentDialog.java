package pk.gov.nadra.dialogs;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import java.util.concurrent.TimeUnit;
import pk.gov.nadra.rahbar.android.R;

/* loaded from: classes5.dex */
public class NearMeFragmentDialog extends DialogFragment implements View.OnClickListener {
    Button buttonOk;
    INearMeFragmentDialog iNearMeFragmentDialog;
    int language = 0;
    String message;
    String okButtonText;
    TextView textViewAlertMessage;
    TextView textViewAlertTitle;
    String title;

    public interface INearMeFragmentDialog {
        void okay();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.buttonOk) {
            dismiss();
            INearMeFragmentDialog iNearMeFragmentDialog = this.iNearMeFragmentDialog;
            if (iNearMeFragmentDialog != null) {
                iNearMeFragmentDialog.okay();
            }
        }
    }

    public NearMeFragmentDialog() {
    }

    public NearMeFragmentDialog(String title, String message, String okButtonText, INearMeFragmentDialog callback) {
        this.title = title;
        this.message = message;
        this.okButtonText = okButtonText;
        this.iNearMeFragmentDialog = callback;
    }

    public NearMeFragmentDialog(String title, String message, String okButtonText) {
        this.title = title;
        this.message = message;
        this.okButtonText = okButtonText;
    }

    public void setCallBack(INearMeFragmentDialog callback) {
        this.iNearMeFragmentDialog = callback;
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
            viewInflate = inflater.inflate(R.layout.layout_near_me_dialog_urdu, container, false);
        } else {
            viewInflate = inflater.inflate(R.layout.layout_near_me_dialog, container, false);
        }
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
        if (savedInstanceState == null) {
            populateViews();
        } else {
            populateViewsWithSavedValues(savedInstanceState);
        }
        setUpTime();
    }

    private void populateViews() {
        this.textViewAlertTitle.setText(this.title);
        this.textViewAlertMessage.setText(this.message);
        this.buttonOk.setText(this.okButtonText);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("title", this.textViewAlertTitle.getText().toString());
        savedInstanceState.putString("message", this.textViewAlertMessage.getText().toString());
        savedInstanceState.putString("okButtonText", this.buttonOk.getText().toString());
    }

    private void populateViewsWithSavedValues(Bundle savedInstanceState) {
        this.textViewAlertTitle.setText(savedInstanceState.getString("title"));
        this.textViewAlertMessage.setText(savedInstanceState.getString("message"));
        this.buttonOk.setText(savedInstanceState.getString("okButtonText"));
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    private void setUpTime() {
        new Handler().postDelayed(new Runnable() { // from class: pk.gov.nadra.dialogs.NearMeFragmentDialog$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m9008lambda$setUpTime$0$pkgovnadradialogsNearMeFragmentDialog();
            }
        }, TimeUnit.SECONDS.toMillis(4L));
    }

    /* renamed from: lambda$setUpTime$0$pk-gov-nadra-dialogs-NearMeFragmentDialog, reason: not valid java name */
    /* synthetic */ void m9008lambda$setUpTime$0$pkgovnadradialogsNearMeFragmentDialog() {
        dismissAllowingStateLoss();
        INearMeFragmentDialog iNearMeFragmentDialog = this.iNearMeFragmentDialog;
        if (iNearMeFragmentDialog != null) {
            iNearMeFragmentDialog.okay();
        }
    }

    public void setLanguage(int language) {
        this.language = language;
    }
}