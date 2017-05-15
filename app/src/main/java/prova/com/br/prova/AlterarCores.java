package prova.com.br.prova;

import android.app.Activity;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class AlterarCores extends AppCompatActivity {
    SeekBar sb = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar_cores);


        sb = (SeekBar) findViewById(R.id.seekBar);
        sb.setMax(100);

        final Button button1 = (Button) findViewById(R.id.but1);
        final Button button2 = (Button) findViewById(R.id.but2);
        final Button button3 = (Button) findViewById(R.id.but3);
        final Button button4 = (Button) findViewById(R.id.but4);
        final Button button5 = (Button) findViewById(R.id.but5);

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            int progChange = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                //inicia valores das cores
                int[] redArray = {255, 0, 0};
                int[] blueArray = {0, 0, 255};
                int[] yellowArray = {255, 255, 0};

                progChange = progress;

                //Altera as cores no array de acordo com o prograsso do seekBar
                redArray[0] = redArray[0] - (255 / 100) * progChange;
                redArray[1] = redArray[1] + (229 / 100) * progChange;
                redArray[2] = redArray[2] + (238 / 100) * progChange;
                blueArray[0] = blueArray[0] + (255 / 100) * progChange;
                blueArray[1] = blueArray[1] + (102 / 100) * progChange;
                blueArray[2] = blueArray[2] - (255 / 100) * progChange;
                yellowArray[0] = yellowArray[0] - (125 / 100) * progChange;
                yellowArray[1] = yellowArray[1] - (255 / 100) * progChange;
                yellowArray[2] = yellowArray[2] + (130 / 100) * progChange;

                //Seta as cores alteradas nos componentes
                button1.setBackgroundColor(Color.rgb(redArray[0], redArray[1], redArray[2]));
                button2.setBackgroundColor(Color.rgb(blueArray[0], blueArray[1], blueArray[2]));
                button3.setBackgroundColor(Color.rgb(yellowArray[0],yellowArray[1],yellowArray[2]));
                button4.setBackgroundColor(Color.rgb(yellowArray[2],yellowArray[1],yellowArray[0]));
                button5.setBackgroundColor(Color.rgb(yellowArray[1],yellowArray[0],yellowArray[2]));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}