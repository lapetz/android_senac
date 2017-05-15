package prova.com.br.prova;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import prova.com.br.prova.bd.EmpresaRepository;
import prova.com.br.prova.domain.Empresa;

public class form_itens_menu extends AppCompatActivity {

    private EditText editNome;
    private EditText editEmail;
    private EditText editFaturamento;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_itens_menu);

        editNome = (EditText) findViewById(R.id.nome);
        editEmail = (EditText) findViewById(R.id.email);
        editFaturamento = (EditText) findViewById(R.id.faturamento);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            id = bundle.getInt("id");
            editNome.setText(bundle.getString("nome"));
            editEmail.setText(bundle.getString("email"));
            editFaturamento.setText(bundle.getString("faturamento"));
        }
    }

    public void salvar(View view) {

        Empresa empresa = new Empresa();
        empresa.setNome(editNome.getText().toString());
        empresa.setEmail(editEmail.getText().toString());
        empresa.setFaturamento(editFaturamento.getText().toString());

        EmpresaRepository repository = new EmpresaRepository(this);

        try {
            long registros = repository.salvar(empresa);
            Toast.makeText(this, "Registros gravadas: " +
                    registros, Toast.LENGTH_SHORT).show();
        } finally {
            repository.close();
        }

    }
}
