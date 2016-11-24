package edu.byui.www.spiritualthought;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    final String[] scripture = {"Searching..."};

    public MainActivity() throws IOException {
    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            mScriptureTextView.setText(scripture[0]);
        }
    };

    private ColorWheel mColorWheel = new ColorWheel();
    // Declare our view variables
    private TextView mScriptureTextView;
    private Button mShowScriptureButton;
    private RelativeLayout mRelativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Assign Views to create member variables.
        mScriptureTextView = (TextView) findViewById(R.id.scriptureTextView);
        mShowScriptureButton = (Button) findViewById(R.id.showScriptureButton);
        mRelativeLayout = (RelativeLayout) findViewById(R.id.activity_main);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Runnable r = new Runnable() {
                    @Override
                    public void run() {
                        synchronized (this) {
                            try {
                                ScriptureRef mScriptureRef = new ScriptureRef();
                                scripture[0] = mScriptureRef.getScripture();
                            } catch (Exception e) {}
                        }
                        handler.sendEmptyMessage(0);
                    }
                };
                Thread getDocThread = new Thread(r);
                getDocThread.start();

                //String scripture = mScriptureRef.getScripture();
                int color = mColorWheel.getColor();

                //update the screen with our dynamic scripture.
                mScriptureTextView.setText(scripture[0]);
                mRelativeLayout.setBackgroundColor(color);
                mShowScriptureButton.setTextColor(color);
            }
        };
        mShowScriptureButton.setOnClickListener(listener);
    }
}
