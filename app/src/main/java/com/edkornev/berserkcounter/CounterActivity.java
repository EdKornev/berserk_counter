package com.edkornev.berserkcounter;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.edkornev.berserkcounter.utils.RaceEnum;

public class CounterActivity extends AppCompatActivity {

    private RelativeLayout mRLTop, mRLBottom;
    private ImageView mIVTopRace, mIVBottomRace;
    private TextView mTVTopCounter, mTVTopAdd, mTVTopSub, mTVBottomCounter, mTVBottomAdd, mTVBottomSub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);

        // keep device awaking
        this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        // default properties
        SharedPreferences settings = this.getSharedPreferences(this.getString(R.string.key_settings), Context.MODE_PRIVATE);

        mRLTop = (RelativeLayout) findViewById(R.id.rl_top);
        mIVTopRace = (ImageView) findViewById(R.id.iv_top_race);
        mTVTopCounter = (TextView) findViewById(R.id.tv_top_counter);
        mTVTopAdd = (TextView) findViewById(R.id.tv_top_add);
        mTVTopSub = (TextView) findViewById(R.id.tv_top_sub);

        mRLBottom = (RelativeLayout) findViewById(R.id.rl_bottom);
        mIVBottomRace = (ImageView) findViewById(R.id.iv_bottom_race);
        mTVBottomCounter = (TextView) findViewById(R.id.tv_bottom_counter);
        mTVBottomAdd = (TextView) findViewById(R.id.tv_bottom_add);
        mTVBottomSub = (TextView) findViewById(R.id.tv_bottom_sub);

        RaceEnum topRace = RaceEnum.valueOf(settings.getString(this.getString(R.string.key_settings_top_race), RaceEnum.FIELDS.toString()));
        RaceEnum bottomRace = RaceEnum.valueOf(settings.getString(this.getString(R.string.key_settings_bottom_race), RaceEnum.ROCKS.toString()));
        mIVTopRace.setImageDrawable(ContextCompat.getDrawable(this, topRace.getImage()));
        mIVBottomRace.setImageDrawable(ContextCompat.getDrawable(this, bottomRace.getImage()));

        mTVTopAdd.setOnClickListener(clickBtnTopAdd);
        mTVTopSub.setOnClickListener(clickBtnTopSub);

        mTVBottomAdd.setOnClickListener(clickBtnBottomAdd);
        mTVBottomSub.setOnClickListener(clickBtnBottomSub);
    }

    private View.OnClickListener clickBtnTopAdd = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Integer currentValue = Integer.valueOf(mTVTopCounter.getText().toString());
            mTVTopCounter.setText(String.valueOf(++currentValue));
        }
    };

    private View.OnClickListener clickBtnTopSub = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Integer currentValue = Integer.valueOf(mTVTopCounter.getText().toString());
            mTVTopCounter.setText(String.valueOf(--currentValue));
        }
    };

    private View.OnClickListener clickBtnBottomAdd = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Integer currentValue = Integer.valueOf(mTVBottomCounter.getText().toString());
            mTVBottomCounter.setText(String.valueOf(++currentValue));
        }
    };

    private View.OnClickListener clickBtnBottomSub = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Integer currentValue = Integer.valueOf(mTVBottomCounter.getText().toString());
            mTVBottomCounter.setText(String.valueOf(--currentValue));
        }
    };
}
