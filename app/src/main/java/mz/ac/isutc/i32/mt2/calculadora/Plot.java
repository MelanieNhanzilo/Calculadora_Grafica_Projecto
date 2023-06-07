package mz.ac.isutc.i32.mt2.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import java.util.ArrayList;
import java.util.List;
import mz.ac.isutc.i32.mt2.calculadora.databinding.ActivityPlotBinding;
import mz.ac.isutc.i32.mt2.calculadora.databinding.ActivityVisualizarGraficoBinding;
import org.mariuszgromada.math.mxparser.Argument;
import org.mariuszgromada.math.mxparser.Expression;

public class Plot extends AppCompatActivity {
    ActivityPlotBinding b;
    ActivityVisualizarGraficoBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b=ActivityPlotBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());
        try{
            String expressao=VisualizarGrafico.op;
            System.out.println(expressao);
            List<Entry> entries = new ArrayList<>();
            if(VisualizarGrafico.ope=="asin(x)" || VisualizarGrafico.ope=="atan(x)" || VisualizarGrafico.ope=="acos(x)"){
                for (float x = -1f; x <= 1f; x += 0.001f) {
                    Expression expression=new Expression();
                    expression.setExpressionString(expressao);
                    if(x!=0f){
                        expression.addArguments(new Argument("x",x));
                    }
                    float y = escolherFunction(VisualizarGrafico.op,x);
                    entries.add(new Entry(x, y));
                }
            }
           else if(VisualizarGrafico.ope.contains("ln(")){
                for (float x = 0f; x <= 10f; x += 0.1f) {
                    Expression expression=new Expression();
                    expression.setExpressionString(expressao);
                    expression.addArguments(new Argument("x",x));
                    float y = (float) expression.calculate();
                    entries.add(new Entry(y, x));
                }
            }else if(VisualizarGrafico.ope.contains("log(")) {
               expressao=expressao.replace("log10(","10^(");
               System.out.println(expressao);
                for (float x = 0f; x <= 10f; x += 0.1f) {
                    Expression expression = new Expression();
                    expression.setExpressionString(expressao);
                    expression.addArguments(new Argument("x", x));
                    float y = (float) expression.calculate();
                    entries.add(new Entry(y, x));
                }
            }else if(VisualizarGrafico.ope.contains("sinc(")) {
                expressao="sin("+expressao.substring(5,expressao.length())+"/("+expressao.substring(5,expressao.length());

                for (float x = -10f; x <= 10f; x += 0.1f) {
                    Expression expression = new Expression();
                    expression.setExpressionString(expressao);
                    if(x!=0f){
                        expression.addArguments(new Argument("x", x));
                    }
                    float y = (float) expression.calculate();
                    entries.add(new Entry(x,y));
                }
            }
           else{
               if(expressao.contains("sqrt(")){
                   for (float x = 0f; x <= 10f; x += 0.1f) {
                       Expression expression = new Expression();
                       expression.setExpressionString(expressao);
                       expression.addArguments(new Argument("x", x));
                       float y = (float) expression.calculate();
                       entries.add(new Entry(x, y));
                   }
               }else {
                   for (float x = -10f; x <= 10f; x += 0.1f) {
                       Expression expression = new Expression();
                       expression.setExpressionString(expressao);
                       expression.addArguments(new Argument("x", x));
                       float y = (float) expression.calculate();
                       entries.add(new Entry(x, y));
                   }
               }
            }

            LineDataSet dataSet = new LineDataSet(entries, VisualizarGrafico.ope);
            dataSet.setDrawCircles(false);
            dataSet.setColor(Color.BLACK);
            LineData lineData = new LineData(dataSet);
            b.chart.setData(lineData);
            b.chart.animateX(2000);
            b.chart.invalidate();
        }catch(Exception e){
            Toast.makeText(this, "Expressão inválida!", Toast.LENGTH_SHORT).show();
        }
        b.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    public static float escolherFunction(String f, float x) {
        if (f == "acos(x)") {
            return (float) Math.acos(x);
        } else if (f == "asin(x)") {
            return (float) Math.asin(x);
        } else {
            return (float) Math.atan(x);
        }
    }

}