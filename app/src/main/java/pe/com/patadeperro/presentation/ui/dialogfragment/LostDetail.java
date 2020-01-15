package pe.com.patadeperro.presentation.ui.dialogfragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;

import androidx.fragment.app.DialogFragment;

import com.com.patadeperro.R;

public class LostDetail extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        View view = getActivity().getLayoutInflater().inflate(R.layout.lost_detail, new LinearLayout(getActivity()), false);


        Dialog builder = new Dialog(getActivity());
        builder.requestWindowFeature(Window.FEATURE_NO_TITLE);

        builder.setContentView(view);
        return builder;

    }


    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {

            //numero de pixeles que tendra de ancho
            // int width = 700;
            int width = ViewGroup.LayoutParams.WRAP_CONTENT;

            //la altura se ajustara al contenido
            int height = ViewGroup.LayoutParams.WRAP_CONTENT;

            dialog.getWindow().setLayout(width, height);

        }
    }

    @Override
    public void onDismiss(DialogInterface dialog) {

    }

    @Override
    public void onCancel(DialogInterface dialog) {
        dismiss();
    }





}
