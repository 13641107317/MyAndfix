package base.xiyun.com.myandfix;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private Button mBt;
    private Button mNewbt;

    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBt = (Button) findViewById(R.id.bt);
        mNewbt = (Button) findViewById(R.id.newbt);
        mNewbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"修复成功!!",Toast.LENGTH_LONG).show();
                Log.i(TAG, "onClick:修复成功 ");

            }
        });
        mBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Toast.makeText(MainActivity.this,"修复成功!!",Toast.LENGTH_LONG).show();
//                Log.i(TAG, "onClick:修复成功 ");

                try {
                    MyApplication.getPatchManager().addPatch(
                            Environment.getExternalStorageDirectory()
                                    .getAbsolutePath() + "/new_apk.apatch");
                } catch (IOException e) {
                    e.printStackTrace();
                }
//                mNewbt.setVisibility(View.VISIBLE);
            }
        });
    }
}
