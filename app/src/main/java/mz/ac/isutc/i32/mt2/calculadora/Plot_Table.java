package mz.ac.isutc.i32.mt2.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;

import mz.ac.isutc.i32.mt2.calculadora.databinding.ActivityPlotTableBinding;


public class Plot_Table extends AppCompatActivity {
    List<Entry> entries=Tabela.entries;
    ActivityPlotTableBinding b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b=ActivityPlotTableBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());
        LineDataSet dataSet = new LineDataSet(entries, "Dados");
        dataSet.setColor(Color.BLACK);
        dataSet.setCircleColor(Color.RED);
        dataSet.setDrawValues(false);
        LineData lineData = new LineData(dataSet);
        LineChart chart = findViewById(R.id.chartTable); // Substitua "chart" pelo ID correto do seu gráfico
        chart.setData(lineData);
        chart.invalidate();

        b.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}