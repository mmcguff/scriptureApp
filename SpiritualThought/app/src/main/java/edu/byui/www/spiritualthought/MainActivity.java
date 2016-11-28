package edu.byui.www.spiritualthought;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.IOException;

/**
 * Activity for displaying scripture to user.
 *
 * This activity is used for obtaining a random scripture and displaying to user.
 *
 * @author Matthew McGuff, Daniel Chunn, Mitchell Harvey, Julian Romero
 * @version 2016.1125
 * @since 1.0
 *
 */
public class MainActivity extends AppCompatActivity {
    final String[] scripture = {"Searching..."};

    /**
     * This method simply throws an exception.
     * @throws IOException
     */
    public MainActivity() throws IOException {
    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            String[] text = scripture[0].split("\\n");
            mTitleTextView.setText(text[0]);
            mScriptureTextView.setText(text[1]);
        }
    };

    private ColorWheel mColorWheel = new ColorWheel();
    // Declare our view variables
    private TextView mScriptureTextView;
    private TextView mTitleTextView;
    private Button mShowScriptureButton;
    private RelativeLayout mRelativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Assign Views to create member variables.
        mScriptureTextView = (TextView) findViewById(R.id.scriptureTextView);
        mTitleTextView = (TextView) findViewById(R.id.titleTextView);
        mShowScriptureButton = (Button) findViewById(R.id.showScriptureButton);
        mRelativeLayout = (RelativeLayout) findViewById(R.id.activity_main);

        mScriptureTextView.setMovementMethod(new ScrollingMovementMethod());

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
                            } catch (Exception e) {scripture[0]="Connection Error\nInternet Access Required.";}
                        }
                        handler.sendEmptyMessage(0);
                    }
                };
                Thread getDocThread = new Thread(r);
                getDocThread.start();

                //String scripture = mScriptureRef.getScripture();
                int color = mColorWheel.getColor();

                //update the screen with our dynamic scripture.
                mRelativeLayout.setBackgroundColor(color);
                mShowScriptureButton.setTextColor(color);
            }
        };
        mShowScriptureButton.setOnClickListener(listener);
    }
}
