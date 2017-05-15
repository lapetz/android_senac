package prova.com.br.prova;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import prova.com.br.prova.bd.EmpresaRepository;
import prova.com.br.prova.domain.Empresa;

public class ItensMenu extends Activity {

    private EmpresaAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itens_menu);

        ListView list = (ListView) findViewById(R.id.listaempresa);
        registerForContextMenu(list);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                getEmpresas());
                list.setAdapter(adapter);

    }

    private List<String> getEmpresas() {
        EmpresaRepository r = new EmpresaRepository(this);
        try {
            return r.findNomeEmpresas();
        } finally {
            r.close();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        switch (item.getItemId()) {
            case R.id.novo:
                return true;
            case R.id.sair:
                finish();
                return true;
        }
        return super.onMenuItemSelected(featureId,item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_empresas, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        ContextMenu.ContextMenuInfo info = item.getMenuInfo();
        AdapterView.AdapterContextMenuInfo adapterInfo = (AdapterView.AdapterContextMenuInfo) info;
        Toast.makeText(this, "Posição: "+ adapterInfo.position, Toast.LENGTH_SHORT).show();

        switch (item.getItemId()) {
            case R.id.alterar:
                Intent forms = new Intent(this, form_itens_menu.class);
                startActivity(forms);
            case R.id.excluir:
        }

        return super.onContextItemSelected(item);
    }

    private void alterar(int position) {
        Empresa empresaSelecioanada = (Empresa) adapter.getItem(position);
        Intent intent = new Intent(this, form_itens_menu.class);
        Bundle b = new Bundle();
        b.putInt("id", empresaSelecioanada.getId());
        b.putString("nome", empresaSelecioanada.getNome());
        b.putString("email", empresaSelecioanada.getEmail());
        b.putString("faturamento", empresaSelecioanada.getFaturamento());
        startActivity(intent);

    }
}
