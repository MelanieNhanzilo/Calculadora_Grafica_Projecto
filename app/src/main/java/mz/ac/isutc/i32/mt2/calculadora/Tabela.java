package mz.ac.isutc.i32.mt2.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.github.mikephil.charting.data.Entry;

import java.util.ArrayList;
import java.util.List;

import mz.ac.isutc.i32.mt2.calculadora.databinding.ActivityTabelaBinding;

public class Tabela extends AppCompatActivity {
    static ActivityTabelaBinding b;
    static List<Entry> entries=new ArrayList<>();
    static ArrayList<Double> y=new ArrayList<>();
    static ArrayList<Double> x=new ArrayList<Double>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b=ActivityTabelaBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());
        Toast.makeText(this, "Input the vaules of x and y to plot the graphic", Toast.LENGTH_LONG).show();
        b.btPlot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    for (int i = 1; i <= 7; i++) {
                        int xEditTextId = getResources().getIdentifier("tv_x" + i, "id", getPackageName());
                        int yEditTextId = getResources().getIdentifier("tv_y" + i, "id", getPackageName());

                        EditText xEditText = findViewById(xEditTextId);
                        EditText yEditText = findViewById(yEditTextId);

                        String xT = xEditText.getText().toString();
                        String yT = yEditText.getText().toString();

                        float x = Float.parseFloat(xT);
                        float y = Float.parseFloat(yT);
                        entries.add(new Entry(x, y));
                    }
                    Intent intent=new Intent(Tabela.this,Plot_Table.class);
                    startActivity(intent);
                }catch (Exception e){
                    Toast.makeText(Tabela.this, "Inválido!", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }


}