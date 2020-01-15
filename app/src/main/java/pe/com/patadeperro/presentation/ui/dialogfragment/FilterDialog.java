package pe.com.patadeperro.presentation.ui.dialogfragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.fragment.app.DialogFragment;

import com.com.patadeperro.R;

public class FilterDialog extends DialogFragment {


    ImageView ivClose;
    LinearLayout transparent_linear_filter;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        View view = getActivity().getLayoutInflater().inflate(R.layout.filter_dialog, new LinearLayout(getActivity()), false);

        initUI(view);

        ivClose = (ImageView) view.findViewById(R.id.ivClose);
        transparent_linear_filter = (LinearLayout) view.findViewById(R.id.transparent_linear_filter);

        transparent_linear_filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dismiss();
            }
        });

        ivClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dismiss();

            }
        });

        Dialog builder = new Dialog(getActivity());
        builder.requestWindowFeature(Window.FEATURE_NO_TITLE);

        builder.setContentView(view);
        return builder;

    }


    @Override
    public void onActivityCreated(Bundle arg0) {
        super.onActivityCreated(arg0);
        getDialog().getWindow()
                .getAttributes().windowAnimations = R.style.DialogAnimation;
    }

    @Override
    public void onDismiss(DialogInterface dialog) {

        sendCallback();
    }


    public interface CierraDialogFilter {
        public void onClose_Filter(Boolean close);
    }


    void sendCallback() {
        Activity ahhh = getActivity();
        if (ahhh instanceof CierraDialogFilter) {
            ((CierraDialogFilter) ahhh).onClose_Filter(true);
        }

    }



    void initUI(View view) {

    }


    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {

            //numero de pixeles que tendra de ancho
            // int width = 700;
            int width = ViewGroup.LayoutParams.MATCH_PARENT;

            //la altura se ajustara al contenido
            int height = ViewGroup.LayoutParams.MATCH_PARENT;

            dialog.getWindow().setLayout(width, height);

            //se lo asigno a mi dialogfragment

            //con esto hago que sea invicible
            dialog.getWindow().getAttributes().alpha = 1f;
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
    }


    @Override
    public void onCancel(DialogInterface dialog) {
        dismiss();
    }


}
