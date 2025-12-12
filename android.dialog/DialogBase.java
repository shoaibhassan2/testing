package pk.gov.nadra.android.dialog;

import androidx.fragment.app.DialogFragment;

/* loaded from: classes5.dex */
public class DialogBase extends DialogFragment {
    boolean mCancelable;
    String mMessage;
    String mTitle;

    public String getMessage() {
        return this.mMessage;
    }

    public void setMessage(String message) {
        this.mMessage = message;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    @Override // androidx.fragment.app.DialogFragment
    public boolean isCancelable() {
        return this.mCancelable;
    }

    @Override // androidx.fragment.app.DialogFragment
    public void setCancelable(boolean cancelable) {
        this.mCancelable = cancelable;
    }
}