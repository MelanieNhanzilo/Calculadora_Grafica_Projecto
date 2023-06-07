package mz.ac.isutc.i32.mt2.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

import mz.ac.isutc.i32.mt2.calculadora.databinding.ActivityHistoricoBinding;
import mz.ac.isutc.i32.mt2.calculadora.databinding.ActivityVisualizarGraficoBinding;

public class HistoricoGraficos extends AppCompatActivity {
    ActivityHistoricoBinding b;
    ActivityVisualizarGraficoBinding binding;
    ArrayList<String> funcoes;
    final static String LOCAL_HISTORICO="HistoricoGraficos.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b=ActivityHistoricoBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());
        funcoes=Gestor.ler(this,LOCAL_HISTORICO);
        if(funcoes==null){
            Toast.makeText(this, "Vazio", Toast.LENGTH_SHORT).show();
        }else {
            ArrayAdapter<String> adapter = new ArrayAdapter<>(HistoricoGraficos.this, android.R.layout.simple_list_item_1, funcoes);
            b.listView.setAdapter(adapter);
        }
        b.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String x=b.listView.getSelectedItem().toString();
                binding.txFuncao.setText(x);
                VisualizarGrafico.ope=x;
                finish();
            }
        });
        b.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        b.btErase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Gestor.apagarHistorico(getApplicationContext(),LOCAL_HISTORICO);
                    ArrayList<String> empty=new ArrayList<>();
                    ArrayAdapter<String> adapter=new ArrayAdapter<>(HistoricoGraficos.this, android.R.layout.simple_list_item_1,empty);
                    b.listView.setAdapter(adapter);
                } catch (IOException e) {
                    Toast.makeText(HistoricoGraficos.this, "Falha ao apagar!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}