package prova.com.br.prova;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void meusEventosOnClick(View view) {
        Intent lista = new Intent(this, ListaActivity.class);
        startActivity(lista);
    }

    public void novoBaileOnClick(View view) {
        Intent novoBaile = new Intent(this, NovoBaile.class);
        startActivity(novoBaile);
    }

    public void onClickAlterarCores(View view) {
        Intent alteraCores = new Intent(this, AlterarCores.class);
        startActivity(alteraCores);
    }

    public void novaBandaOnClick(View view) {
        Intent itensMenu = new Intent(this, ItensMenu.class);
        startActivity(itensMenu);
    }

}
