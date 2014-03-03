package com.polites.android.example;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;

import com.polites.android.GestureImageView;

public class EditorNewActivity extends Activity {
	
	private GestureImageView view;
	private static final int IMAGE_LOAD = 10001;
	private final Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			if(msg.what == IMAGE_LOAD) {
				view.setImageResource(R.drawable.image);
			}
			super.handleMessage(msg);
		}
	};
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_noactionbar_new);

        ViewGroup layout = (ViewGroup) findViewById(R.id.layout);
        if (null != layout) {
            LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);

            view = new GestureImageView(this);
            view.setLayoutParams(params);


            layout.addView(view);

            handler.sendEmptyMessageDelayed(IMAGE_LOAD, 2000);
        }
    }
}