package pk.gov.nadra.android.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.lsjwzh.widget.materialloadingprogressbar.CircleProgressBar;
import pk.gov.nadra.rahbar.android.R;

/* loaded from: classes5.dex */
public class ProgressDialogFragment extends DialogBase {
    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        FragmentActivity activity = getActivity();
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        View viewInflate = activity.getLayoutInflater().inflate(R.layout.progress_dialog, (ViewGroup) null, false);
        CircleProgressBar circleProgressBar = (CircleProgressBar) viewInflate.findViewById(R.id.dialogProgressBar);
        circleProgressBar.setShowProgressText(false);
        circleProgressBar.setColorSchemeColors(ContextCompat.getColor(getContext(), R.color.theme_color));
        builder.setView(viewInflate);
        if (this.mMessage != null) {
            builder.setMessage(this.mMessage);
        }
        if (this.mTitle != null) {
            builder.setTitle(this.mTitle);
        }
        builder.setCancelable(this.mCancelable);
        return builder.create();
    }
}