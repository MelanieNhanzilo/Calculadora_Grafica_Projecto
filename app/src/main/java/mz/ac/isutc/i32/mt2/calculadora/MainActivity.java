package mz.ac.isutc.i32.mt2.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import mz.ac.isutc.i32.mt2.calculadora.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.cardCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent calculoaritmetico=new Intent(MainActivity.this,CalculoAritmetico.class);
                startActivity(calculoaritmetico);
            }
        });
        binding.cardGraphics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent visualizargrafico=new Intent(MainActivity.this,VisualizarGrafico.class);
                startActivity(visualizargrafico);
            }
        });




    }
}