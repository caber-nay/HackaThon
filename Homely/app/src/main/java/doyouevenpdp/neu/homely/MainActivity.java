package doyouevenpdp.neu.homely;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.SimpleTimeZone;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_TYPE = "SignInType";
    private static String signInType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void userSignIn(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        signInType = "user";
        intent.putExtra(EXTRA_TYPE,signInType);
        startActivity(intent);
    }

    public void providerSignIn(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        signInType = "provider";
        intent.putExtra(EXTRA_TYPE,signInType);
        startActivity(intent);
    }
}
