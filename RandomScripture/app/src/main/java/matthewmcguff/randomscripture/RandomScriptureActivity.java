package matthewmcguff.randomscripture;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.IOException;
import java.util.Random;

public class RandomScriptureActivity extends AppCompatActivity {
    public RandomScriptureActivity() throws IOException {
    }
    private ScriptureRef mScriptureRef = new ScriptureRef();
    private ColorWheel mColorWheel = new ColorWheel();
    // Declare our view variables
    private TextView mScriptureTextView;
    private Button mShowScriptureButton;
    private RelativeLayout mRelativeLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_scripture);

        // Assign Views to create member variables.
        mScriptureTextView = (TextView) findViewById(R.id.scriptureTextView);
        mShowScriptureButton = (Button) findViewById(R.id.showScriptureButton);
        mRelativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String scripture = mScriptureRef.getScripture();
                int color = mColorWheel.getColor();

                //update the screen with our dynamic scripture.
                mScriptureTextView.setText(scripture);
                mRelativeLayout.setBackgroundColor(color);
                mShowScriptureButton.setTextColor(color);
            }
        };
        mShowScriptureButton.setOnClickListener(listener);
    }
}
//Comment test for github -Julian Romero