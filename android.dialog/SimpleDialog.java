package pk.gov.nadra.android.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

/* loaded from: classes5.dex */
public class SimpleDialog extends DialogBase {
    private DialogInterface.OnClickListener negativeButtonOnClickListener;
    private String negativeButtonTitle;
    private DialogInterface.OnClickListener positiveButtonOnClickListener;
    private String positiveButtonTitle;

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        if (this.mMessage != null) {
            builder.setMessage(this.mMessage);
        }
        if (this.mTitle != null) {
            builder.setTitle(this.mTitle);
        }
        builder.setCancelable(this.mCancelable);
        String str = this.positiveButtonTitle;
        if (str != null) {
            builder.setPositiveButton(str, this.positiveButtonOnClickListener);
        }
        String str2 = this.negativeButtonTitle;
        if (str2 != null) {
            builder.setNegativeButton(str2, this.negativeButtonOnClickListener);
        }
        return builder.create();
    }

    public DialogInterface.OnClickListener getNegativeButtonOnClickListener() {
        return this.negativeButtonOnClickListener;
    }

    public void setNegativeButtonOnClickListener(DialogInterface.OnClickListener negativeButtonOnClickListener) {
        this.negativeButtonOnClickListener = negativeButtonOnClickListener;
    }

    public String getNegativeButtonTitle() {
        return this.negativeButtonTitle;
    }

    public void setNegativeButtonTitle(String negativeButtonTitle) {
        this.negativeButtonTitle = negativeButtonTitle;
    }

    public DialogInterface.OnClickListener getPositiveButtonOnClickListener() {
        return this.positiveButtonOnClickListener;
    }

    public void setPositiveButtonOnClickListener(DialogInterface.OnClickListener positiveButtonOnClickListener) {
        this.positiveButtonOnClickListener = positiveButtonOnClickListener;
    }

    public String getPositiveButtonTitle() {
        return this.positiveButtonTitle;
    }

    public void setPositiveButtonTitle(String positiveButtonTitle) {
        this.positiveButtonTitle = positiveButtonTitle;
    }
}