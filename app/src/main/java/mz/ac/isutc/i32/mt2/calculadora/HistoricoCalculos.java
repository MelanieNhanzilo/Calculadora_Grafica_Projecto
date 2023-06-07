package mz.ac.isutc.i32.mt2.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

import mz.ac.isutc.i32.mt2.calculadora.databinding.ActivityCalculoAritmeticoBinding;
import mz.ac.isutc.i32.mt2.calculadora.databinding.ActivityHistoricoCalculosBinding;
import mz.ac.isutc.i32.mt2.calculadora.databinding.ActivityVisualizarGraficoBinding;

public class HistoricoCalculos extends AppCompatActivity {
    ActivityHistoricoCalculosBinding b;
    ActivityCalculoAritmeticoBinding binding;
    static final String LOCAL_CALCULOS="historico.txt";
    ArrayList<String> arrayhistorico;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b=ActivityHistoricoCalculosBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());
        b.btErase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Gestor.apagarHistorico(getApplicationContext(),LOCAL_CALCULOS);
                    ArrayList<String> empty=new ArrayList<>();
                    ArrayAdapter<String> adapter=new ArrayAdapter<>(HistoricoCalculos.this, android.R.layout.simple_list_item_1,empty);
                    b.listView.setAdapter(adapter);
                } catch (IOException e) {
                    Toast.makeText(HistoricoCalculos.this, "Falha ao apagar!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        arrayhistorico=Gestor.ler(this,LOCAL_CALCULOS);
        if(arrayhistorico==null){
            Toast.makeText(this, "Vazio", Toast.LENGTH_SHORT).show();
        }else {

            ArrayAdapter<String> adapter = new ArrayAdapter<>(HistoricoCalculos.this, android.R.layout.simple_list_item_1, arrayhistorico);
            b.listView.setAdapter(adapter);
        }
        b.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String x=b.listView.getSelectedItem().toString();
                binding.textCalculo.setText(x);
                finish();
            }
        });
        b.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}