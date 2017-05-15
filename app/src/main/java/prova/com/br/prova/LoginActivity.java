package prova.com.br.prova;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
    }

    public void doClickLogin(View view) {
        Intent menu = new Intent(this, MenuActivity.class);
        startActivity(menu);
    }
}
