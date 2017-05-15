package prova.com.br.prova;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListaActivity extends Activity implements AdapterView.OnItemClickListener {

    private List<Map<String,Object>> empresas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista);
        ListView list =(ListView) findViewById(R.id.lista);
        String[] de ={"logo","nome","email"};
        int[]para={R.id.logo,R.id.nome,R.id.email};

        SimpleAdapter adapter = new  SimpleAdapter(this, getEmpresas(),R.layout.layout_lista,de,para);

        // ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_checked,getEmpresas());
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);

    }
    public List<Map<String,Object>>getEmpresas(){
        this.empresas= new ArrayList<>();
        Map<String,Object> item = new HashMap<>();
        item.put("nome","Senai");
        item.put("email","contato@sandrorodrigues.net");
        item.put("logo",R.drawable.senai);
        this.empresas.add(item);

        item = new HashMap<>();
        item.put("nome","senac");
        item.put("email","contato@sandrorodrigues.net");
        item.put("logo",R.drawable.logosena);
        empresas.add(item);
        return empresas;

    }

    /*   private List<String> getEmpresas() {
           List<String> empresas= new ArrayList<>();

           empresas.add("Senac");
           empresas.add("Furb");
           empresas.add("Sebrae");
           empresas.add("Fiesc");
           empresas.add("Sagrada");
           empresas.add("Bom Jesus");
           empresas.add("Machado");

           return empresas;
       }
   */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Map<String, Object> itemSelecionado = this.empresas.get(position);

        Intent intent  = new Intent(this,ListaDetalheActivity.class);
        startActivity(intent);

        // Toast.makeText(this,itemSelecionado.get("nome").toString(), Toast.LENGTH_SHORT).show();
    }
}
