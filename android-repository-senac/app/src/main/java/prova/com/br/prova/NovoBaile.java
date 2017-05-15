package prova.com.br.prova;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import prova.com.br.prova.bd.BailaoRepository;
import prova.com.br.prova.domain.Bailao;
import prova.com.br.prova.domain.Empresa;

@TargetApi(Build.VERSION_CODES.N)
public class NovoBaile extends Activity {

    private static final SimpleDateFormat
            formatador = new SimpleDateFormat("dd/MM/yy");

    private static final SimpleDateFormat
            formatadorHora = new SimpleDateFormat("HH:mm");

    private TextView data;
    private TextView hora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.novo_baile_layout);

        data = (TextView)findViewById(R.id.data);
        hora = (TextView)findViewById(R.id.hora);
        data.setText(formatador.format(new Date()));

        spinnerActivation();
    }

    public void selecionarData(View view) {

        Calendar cal = Calendar.getInstance();


        DatePickerDialog dialog =
                new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(Calendar.YEAR, year);
                        calendar.set(Calendar.MONTH, month);
                        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        data.setText(formatador.format(calendar.getTime()));
                    }
                }, cal.get(Calendar.YEAR),
                        cal.get(Calendar.MONTH),
                        cal.get(Calendar.DAY_OF_MONTH));
        dialog.show();


    }


    public void selecionarHora(View view) {
        Calendar calendar = Calendar.getInstance();

        TimePickerDialog dialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Calendar cal = Calendar.getInstance();
                        cal.set(Calendar.HOUR_OF_DAY, hourOfDay);
                        cal.set(Calendar.MINUTE, minute);
                        hora.setText(
                                formatadorHora.format(cal.getTime()));
                    }
                }, calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE)
                ,  false);
        dialog.show();
    }

    private void spinnerActivation() {
            Spinner spinner = (Spinner) findViewById(R.id.ds_spinner);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.ds_spinner, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
    }

    public void salvar(View view){
        Bailao bailao = new Bailao();

        EditText edTitulo = (EditText) findViewById(R.id.dsTitulo);
        bailao.setTitulo(edTitulo.getText().toString());

        BailaoRepository repository = new BailaoRepository(this);

        try {
            long registros = repository.salvar(bailao);
            Toast.makeText(this, "Registros gravadas: " +
                    registros, Toast.LENGTH_SHORT).show();
        } finally {
            repository.close();
        }
    }

}
