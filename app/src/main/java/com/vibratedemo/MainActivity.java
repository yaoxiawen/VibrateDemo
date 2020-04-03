package com.vibratedemo;

import android.app.Activity;
import android.app.Service;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.HapticFeedbackConstants;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        //tv_test1，使用Vibrator震动，需要清单文件配置震动权限
        vibratorShow();
        //tv_test2，使用performHapticFeedback自定义触发震动，不需要震动权限
        performHapticFeedbackShow();
        //tv_test3，使用OnLongClickListener震动，内部触发performHapticFeedback震动反馈
        longClickListenerShow();
    }

    private void vibratorShow() {
        TextView textView = findViewById(R.id.tv_test1);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "使用Vibrator震动", Toast.LENGTH_SHORT).show();
                Vibrator vibrator = (Vibrator) getSystemService(Service.VIBRATOR_SERVICE);
                //震动时间，毫秒
                vibrator.vibrate(25L);
                //vibrate(2000);//震动指定时间 ，数据类型long，单位为毫秒，一毫秒为1/1000秒
                //vibrate(new long[]{100,10,100,1000}, -1);//依照指定的模式去震动。
                //数组參数意义：第一个參数为等待指定时间后開始震动，第二个參数为震动时间。后边的參数依次为等待震动和震动的时间。
                //第二个參数为反复次数，-1为不反复。0为一直震动   。
                //取消震动
                //vibrator.cancel();//取消震动，马上停止震动
                //震动为一直震动的话，假设不取消震动。就算退出，也会一直震动
            }
        });
    }

    private void performHapticFeedbackShow() {
        TextView textView = findViewById(R.id.tv_test2);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "使用performHapticFeedback震动", Toast.LENGTH_SHORT)
                        .show();
                //触发震动反馈
                v.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS,
                        HapticFeedbackConstants.FLAG_IGNORE_VIEW_SETTING);
            }
        });
    }

    private void longClickListenerShow() {
        TextView textView = findViewById(R.id.tv_test3);
        textView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(MainActivity.this, "使用OnLongClickListener震动", Toast.LENGTH_SHORT)
                        .show();
                //长按监听，可返回是否触发震动反馈，true，内部触发performHapticFeedback(HapticFeedbackConstants.LONG_PRESS)
                return true;
            }
        });
    }
}
