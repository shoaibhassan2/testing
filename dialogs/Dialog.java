package pk.gov.nadra.dialogs;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import io.github.rupinderjeet.kprogresshud.KProgressHUD;
import pk.gov.nadra.dialogs.ConfirmationFragmentDialog;
import pk.gov.nadra.dialogs.FinishFragmentDialog;
import pk.gov.nadra.dialogs.NearMeFragmentDialog;
import pk.gov.nadra.dialogs.RetryFragmentDialog;
import pk.gov.nadra.rahbar.android.R;

/* loaded from: classes5.dex */
public class Dialog {
    private static Dialog INSTANCE;
    private KProgressHUD kProgressHUD;

    private Dialog() {
    }

    public static Dialog getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Dialog();
        }
        return INSTANCE;
    }

    public void showProgressDialog(Context context) {
        this.kProgressHUD = KProgressHUD.create(context).setStyle(KProgressHUD.Style.SPIN_INDETERMINATE).setBackgroundColor(context.getResources().getColor(R.color.theme_color)).setCancellable(false).setAnimationSpeed(2).setDimAmount(0.7f).show();
    }

    public boolean isShowingProgressDialog() {
        KProgressHUD kProgressHUD = this.kProgressHUD;
        if (kProgressHUD != null) {
            return kProgressHUD.isShowing();
        }
        return false;
    }

    public void showProgressDialog(Context context, String title, String message) {
        this.kProgressHUD = KProgressHUD.create(context).setStyle(KProgressHUD.Style.SPIN_INDETERMINATE).setBackgroundColor(context.getResources().getColor(R.color.colorProgressDialogBackground)).setCancellable(true).setAnimationSpeed(2).setDimAmount(0.7f).setLabel(title).setDetailsLabel(message).show();
    }

    public void hideProgressDialog() {
        KProgressHUD kProgressHUD = this.kProgressHUD;
        if (kProgressHUD != null) {
            kProgressHUD.dismiss();
        }
    }

    public void showAlertDialog(Context context, String iconType, String title, String message, String okButtonText) {
        AlertFragmentDialog alertFragmentDialogNewInstance = AlertFragmentDialog.newInstance(iconType, title, message, okButtonText);
        alertFragmentDialogNewInstance.setCancelable(false);
        FragmentTransaction fragmentTransactionBeginTransaction = ((FragmentActivity) context).getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.add(alertFragmentDialogNewInstance, "ALERT_FRAGMENT_DIALOG");
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }

    public void showConfirmationDialog(Context context, String iconType, String title, String message, String okButtonText, String cancelButtonText, ConfirmationFragmentDialog.IConfirmationFragmentDialog callback) {
        ConfirmationFragmentDialog confirmationFragmentDialog = new ConfirmationFragmentDialog(iconType, title, message, okButtonText, cancelButtonText, callback);
        confirmationFragmentDialog.setCancelable(false);
        FragmentTransaction fragmentTransactionBeginTransaction = ((FragmentActivity) context).getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.add(confirmationFragmentDialog, "CONFIRMATION_FRAGMENT_DIALOG");
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }

    public void showFinishDialog(Context context, String iconType, String title, String message, String okButtonText, FinishFragmentDialog.IFinishFragmentDialog callback) {
        FinishFragmentDialog finishFragmentDialog = new FinishFragmentDialog(iconType, title, message, okButtonText, callback);
        finishFragmentDialog.setCancelable(false);
        FragmentTransaction fragmentTransactionBeginTransaction = ((FragmentActivity) context).getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.add(finishFragmentDialog, "FINISH_FRAGMENT_DIALOG");
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }

    public void showRetryDialog(Context context, String iconType, String title, String message, String okButtonText, String retryButtonText, RetryFragmentDialog.IConfirmationFragmentDialog callback) {
        RetryFragmentDialog retryFragmentDialog = new RetryFragmentDialog(iconType, title, message, okButtonText, retryButtonText, callback);
        retryFragmentDialog.setCancelable(false);
        FragmentTransaction fragmentTransactionBeginTransaction = ((FragmentActivity) context).getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.add(retryFragmentDialog, "RETRY_FRAGMENT_DIALOG");
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }

    public void showNearMeDialog(Context context, String title, String message, String okButtonText, NearMeFragmentDialog.INearMeFragmentDialog callback) {
        NearMeFragmentDialog nearMeFragmentDialog = new NearMeFragmentDialog(title, message, okButtonText, callback);
        nearMeFragmentDialog.setCancelable(false);
        FragmentTransaction fragmentTransactionBeginTransaction = ((FragmentActivity) context).getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.add(nearMeFragmentDialog, "NEAR_ME_FRAGMENT_DIALOG");
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }
}