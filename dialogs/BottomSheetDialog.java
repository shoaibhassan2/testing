package pk.gov.nadra.dialogs;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.camera.video.AudioStats;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import pk.gov.nadra.rahbar.android.R;
import pk.gov.nadra.rahbar.android.activity.CenterDetailActivity;
import pk.gov.nadra.rahbar.android.data.NrcDataRDB;
import pk.gov.nadra.rahbar.android.util.Constants;
import pk.gov.nadra.rahbar.android.util.Util;

/* loaded from: classes5.dex */
public class BottomSheetDialog extends BottomSheetDialogFragment implements View.OnClickListener {
    private BottomSheetCommunicator communicator;
    ConstraintLayout constraintLayoutCancel;
    ConstraintLayout constraintLayoutParent;
    ConstraintLayout constraintLayoutViewMore;
    ImageView imageViewGoTo;
    NrcDataRDB nrcDataRDB;
    TextView textViewApproxTime;
    TextView textViewCenterName;
    TextView textViewWaiting;

    public interface BottomSheetCommunicator {
        void onBottomSheetDismissed();

        void onBottomSheetShown(int height);
    }

    static /* synthetic */ void lambda$onCreateView$0(DialogInterface dialogInterface) {
    }

    public BottomSheetDialog(NrcDataRDB nrcDataRDB, BottomSheetCommunicator communicator) {
        this.nrcDataRDB = nrcDataRDB;
        this.communicator = communicator;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        getDialog().getWindow().clearFlags(2);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View viewInflate = inflater.inflate(R.layout.bottom_sheet_dialog, container, false);
        this.textViewCenterName = (TextView) viewInflate.findViewById(R.id.textViewCenterName);
        this.textViewWaiting = (TextView) viewInflate.findViewById(R.id.textViewWaiting);
        this.textViewApproxTime = (TextView) viewInflate.findViewById(R.id.textViewApproxTime);
        this.constraintLayoutCancel = (ConstraintLayout) viewInflate.findViewById(R.id.constraintLayoutCancel);
        this.constraintLayoutViewMore = (ConstraintLayout) viewInflate.findViewById(R.id.constraintLayoutViewMore);
        this.constraintLayoutCancel.setOnClickListener(new View.OnClickListener() { // from class: pk.gov.nadra.dialogs.BottomSheetDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.onClick(view);
            }
        });
        this.constraintLayoutViewMore.setOnClickListener(new View.OnClickListener() { // from class: pk.gov.nadra.dialogs.BottomSheetDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.onClick(view);
            }
        });
        this.constraintLayoutParent = (ConstraintLayout) viewInflate.findViewById(R.id.constraintLayoutParent);
        getDialog().setOnShowListener(new DialogInterface.OnShowListener() { // from class: pk.gov.nadra.dialogs.BottomSheetDialog$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                BottomSheetDialog.lambda$onCreateView$0(dialogInterface);
            }
        });
        populateViews();
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private void populateViews() {
        if (this.nrcDataRDB != null) {
            this.textViewCenterName.setText(getUpdatedLocationName(Util.isValid(getActivity(), this.nrcDataRDB.getLocationName())));
            this.textViewApproxTime.setText(getAverageTime(this.nrcDataRDB) + " minutes");
            this.textViewWaiting.setText(getQueueLength(this.nrcDataRDB) + "");
        }
    }

    private double getAverageTime(NrcDataRDB nrcDataRDB) {
        if (nrcDataRDB != null && nrcDataRDB.getAvgTime() != null && !nrcDataRDB.getAvgTime().isEmpty()) {
            try {
                return Double.parseDouble(nrcDataRDB.getAvgTime());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    private int getQueueLength(NrcDataRDB nrcDataRDB) {
        if (nrcDataRDB != null && nrcDataRDB.getQlen() != null && !nrcDataRDB.getQlen().isEmpty()) {
            try {
                return Integer.parseInt(nrcDataRDB.getQlen());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.constraintLayoutCancel) {
            performGotoClickAction();
            dismiss();
        } else if (id == R.id.constraintLayoutViewMore) {
            performViewDetails();
            dismiss();
        }
    }

    private void performViewDetails() {
        NrcDataRDB nrcDataRDB = this.nrcDataRDB;
        if (nrcDataRDB == null || nrcDataRDB.getLocationCode() == null || this.nrcDataRDB.getLocationCode().isEmpty()) {
            return;
        }
        Intent intent = new Intent(getActivity(), (Class<?>) CenterDetailActivity.class);
        intent.putExtra(CenterDetailActivity.PARENT_ACTIVITY_CLASS_KEY, getActivity().getClass());
        intent.putExtra(Constants.CENTER_ID_KEY2, this.nrcDataRDB.getLocationCode());
        startActivity(intent);
    }

    private void performGotoClickAction() {
        NrcDataRDB nrcDataRDB = this.nrcDataRDB;
        if (nrcDataRDB == null || nrcDataRDB.getLatitude() == null || this.nrcDataRDB.getLatitude().isEmpty() || this.nrcDataRDB.getLongitude() == null || this.nrcDataRDB.getLongitude().isEmpty()) {
            return;
        }
        getActivity().startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://maps.google.com/maps?saddr=&daddr=" + this.nrcDataRDB.getLatitude() + "," + this.nrcDataRDB.getLongitude() + "&mode=d")));
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
    }

    private String getUpdatedLocationName(String strLocationName) throws NumberFormatException {
        boolean zIsCenterOpen = Util.isCenterOpen(this.nrcDataRDB);
        boolean zIsSaturdayOpen = Util.isSaturdayOpen(this.nrcDataRDB);
        boolean zIsTodayIsSaturday = Util.isTodayIsSaturday(this.nrcDataRDB);
        boolean zIsTodayIsSunday = Util.isTodayIsSunday(this.nrcDataRDB);
        boolean zIsCenterThreeShift = Util.isCenterThreeShift(this.nrcDataRDB);
        if (zIsCenterOpen) {
            return zIsTodayIsSaturday ? !zIsSaturdayOpen ? strLocationName + "(Closed)" : strLocationName : (!zIsTodayIsSunday || zIsCenterThreeShift) ? strLocationName : strLocationName + "(Closed)";
        }
        return strLocationName + "(Closed)";
    }

    private void dismissWithDelay() {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: pk.gov.nadra.dialogs.BottomSheetDialog$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m9007lambda$dismissWithDelay$1$pkgovnadradialogsBottomSheetDialog();
            }
        }, 1000L);
    }

    /* renamed from: lambda$dismissWithDelay$1$pk-gov-nadra-dialogs-BottomSheetDialog, reason: not valid java name */
    /* synthetic */ void m9007lambda$dismissWithDelay$1$pkgovnadradialogsBottomSheetDialog() {
        dismiss();
    }
}