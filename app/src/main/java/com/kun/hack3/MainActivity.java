package com.kun.hack3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        tv= (TextView) findViewById(R.id.tv);
//        ViewGroup.LayoutParams params = tv.getLayoutParams();
//        params.width= WindowManager.LayoutParams.MATCH_PARENT;
    }
}
