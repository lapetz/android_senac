package prova.com.br.prova;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListaDetalheActivity extends Activity {

    private List<Map<String,Object>> funcionario;
    private String departamentoAnterior = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_funcio);
        ListView lista = (ListView)findViewById(R.id.funcionario);
        String[] de ={"departamento","nome","salario"};
        int[]para={R.id.departamento,R.id.nome,R.id.salario};

        SimpleAdapter adapter = new SimpleAdapter(this, getFuncionario(),R.layout.layout_detalhe,de,para);
        adapter.setViewBinder(new DepartamentoViewBinder());
        lista.setAdapter(adapter);


    }
    private List<Map<String,Object>> getFuncionario(){
        funcionario = new ArrayList<>();
        Map<String,Object> item = new HashMap<>();
        item.put("departamento","financeiro");
        item.put("nome","Maria");
        item.put("salario","R$ 1.000,00");
        funcionario.add(item);

        item = new HashMap<>();
        item.put("departamento","financeiro");
        item.put("nome","Pedro");
        item.put("salario","R$ 900,00");
        funcionario.add(item);


        item = new HashMap<>();
        item.put("departamento","Produção");
        item.put("nome","Maria 2");
        item.put("salario","R$ 2.000,00");
        funcionario.add(item);


        item = new HashMap<>();
        item.put("departamento","Produção");
        item.put("nome","Maria");
        item.put("salario","R$ 3.000,00");
        funcionario.add(item);

        return  funcionario;
    }

    private class DepartamentoViewBinder implements  SimpleAdapter.ViewBinder {

        @Override
        public boolean setViewValue(View view, Object data, String textRepresentation) {

            if (view.getId() == R.id.departamento) {
                if (!departamentoAnterior.equals(data.toString())) {
                    TextView text = (TextView) view;
                    text.setText(textRepresentation);
                    text.setVisibility(View.VISIBLE);
                    departamentoAnterior = textRepresentation;
                } else {
                    view.setVisibility(View.GONE);

                }
                return true;
            }

            return false;
        }
    }
}
