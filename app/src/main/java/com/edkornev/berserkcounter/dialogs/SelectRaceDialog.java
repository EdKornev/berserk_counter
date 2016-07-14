package com.edkornev.berserkcounter.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;

import com.edkornev.berserkcounter.R;

/**
 * Created by Eduard on 14.07.2016.
 */
public class SelectRaceDialog extends Dialog {
    private ImageView mIVRace;

    public SelectRaceDialog(Context context, ImageView ivRace) {
        super(context);

        mIVRace = ivRace;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.setContentView(R.layout.dialog_select_race);

        ViewGroup container = (ViewGroup) findViewById(R.id.rl_container);

        for (int i = 0; i < container.getChildCount(); i++) {
            container.getChildAt(i).setOnClickListener(clickIVRace);
        }
    }

    private View.OnClickListener clickIVRace = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.iv_fields:
                    mIVRace.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.fields));
                    break;
                case R.id.iv_rocks:
                    mIVRace.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.rocks));
                    break;
                case R.id.iv_forests:
                    mIVRace.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.forests));
                    break;
                case R.id.iv_swamps:
                    mIVRace.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.swamps));
                    break;
                case R.id.iv_dark:
                    mIVRace.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.dark));
                    break;
            }

            SelectRaceDialog.this.cancel();
        }
    };
}
