package mz.ac.isutc.i32.mt2.calculadora;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import mz.ac.isutc.i32.mt2.calculadora.databinding.ActivityCalculoAritmeticoBinding;

public class CalculoAritmetico extends AppCompatActivity {


    private ActivityCalculoAritmeticoBinding bindingcalculoaritmetico;
    static boolean shiftActivo = false;
    static String op = "";
    static String ope = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindingcalculoaritmetico = ActivityCalculoAritmeticoBinding.inflate(getLayoutInflater());
        setContentView(bindingcalculoaritmetico.getRoot());

        bindingcalculoaritmetico.btShift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bindingcalculoaritmetico.btCos.setText("arcos(");
                bindingcalculoaritmetico.btSin.setText("asen(");
                bindingcalculoaritmetico.btTan.setText("arTan(");
                //bindingcalculoaritmetico.btCos.setText("arcos(");
            }
        });
        bindingcalculoaritmetico.btHistorico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> arrayhistorico = Gestor.ler(getApplicationContext(), HistoricoCalculos.LOCAL_CALCULOS);

                Intent historicocalculo = new Intent(CalculoAritmetico.this, HistoricoCalculos.class);
                historicocalculo.putStringArrayListExtra("array", arrayhistorico);
                startActivity(historicocalculo);

            }
        });


        bindingcalculoaritmetico.bt0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bindingcalculoaritmetico.textCalculo.setText(bindingcalculoaritmetico.textCalculo.getText() + "0");
            }
        });
        bindingcalculoaritmetico.bt1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                bindingcalculoaritmetico.textCalculo.setText(bindingcalculoaritmetico.textCalculo.getText() + "1");
            }
        });
        bindingcalculoaritmetico.bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bindingcalculoaritmetico.textCalculo.setText(bindingcalculoaritmetico.textCalculo.getText() + "2");
            }
        });
        bindingcalculoaritmetico.bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bindingcalculoaritmetico.textCalculo.setText(bindingcalculoaritmetico.textCalculo.getText() + "3");
            }
        });

        bindingcalculoaritmetico.bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bindingcalculoaritmetico.textCalculo.setText(bindingcalculoaritmetico.textCalculo.getText() + "4");
            }
        });
        bindingcalculoaritmetico.bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bindingcalculoaritmetico.textCalculo.setText(bindingcalculoaritmetico.textCalculo.getText() + "5");
            }
        });
        bindingcalculoaritmetico.bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bindingcalculoaritmetico.textCalculo.setText(bindingcalculoaritmetico.textCalculo.getText() + "6");
            }
        });
        bindingcalculoaritmetico.bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bindingcalculoaritmetico.textCalculo.setText(bindingcalculoaritmetico.textCalculo.getText() + "7");
            }
        });
        bindingcalculoaritmetico.bt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bindingcalculoaritmetico.textCalculo.setText(bindingcalculoaritmetico.textCalculo.getText() + "8");
            }
        });
        bindingcalculoaritmetico.bt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bindingcalculoaritmetico.textCalculo.setText(bindingcalculoaritmetico.textCalculo.getText() + "9");
            }
        });
        bindingcalculoaritmetico.btSoma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bindingcalculoaritmetico.textCalculo.setText(bindingcalculoaritmetico.textCalculo.getText() + "+");
            }
        });
        bindingcalculoaritmetico.btSubtraccao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bindingcalculoaritmetico.textCalculo.setText(bindingcalculoaritmetico.textCalculo.getText() + "-");
            }
        });

        bindingcalculoaritmetico.bt10x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               double valor=Double.parseDouble(bindingcalculoaritmetico.textCalculo.getText().toString());
                bindingcalculoaritmetico.textCalculo.setText("10^"+bindingcalculoaritmetico.textCalculo.getText() );

                double m=Math.pow(10,valor);
                bindingcalculoaritmetico.textResultado.setText(""+m);

            }
        });

        bindingcalculoaritmetico.btPotencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double valor=Double.parseDouble(bindingcalculoaritmetico.textCalculo.getText().toString());
                double valor1=Double.parseDouble(bindingcalculoaritmetico.textCalculo.getText().toString());
                bindingcalculoaritmetico.textCalculo.setText("x^"+bindingcalculoaritmetico.textCalculo.getText() );
                double m=Math.pow(valor,valor1);
                bindingcalculoaritmetico.textResultado.setText(""+m);
            }
        });
        bindingcalculoaritmetico.btSin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bindingcalculoaritmetico.textCalculo.setText(bindingcalculoaritmetico.textCalculo.getText() + "sin");
//                String valor = bindingcalculoaritmetico.textCalculo.getText().toString();
//                double r = Math.sin(Double.parseDouble(valor));
//                bindingcalculoaritmetico.textResultado.setText(String.valueOf(r));

            }
        });

        bindingcalculoaritmetico.btPi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double p = Math.PI;
                bindingcalculoaritmetico.textCalculo.setText("" + p);
                //bindingcalculoaritmetico.textCalculo.setText(bindingcalculoaritmetico.textCalculo.getText()+"");

            }
        });

        bindingcalculoaritmetico.btPonto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bindingcalculoaritmetico.textCalculo.setText(bindingcalculoaritmetico.textCalculo.getText() + ".");
            }
        });

        bindingcalculoaritmetico.btParentesisAbrir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bindingcalculoaritmetico.textCalculo.setText(bindingcalculoaritmetico.textCalculo.getText() + "(");
            }
        });

        bindingcalculoaritmetico.btParentesisFechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bindingcalculoaritmetico.textCalculo.setText(bindingcalculoaritmetico.textCalculo.getText() + ")");
            }
        });

        bindingcalculoaritmetico.btMultiplicacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bindingcalculoaritmetico.textCalculo.setText(bindingcalculoaritmetico.textCalculo.getText() + "x");
            }
        });
        bindingcalculoaritmetico.btCos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bindingcalculoaritmetico.textCalculo.setText(bindingcalculoaritmetico.textCalculo.getText() + "cos");
//                String valor = bindingcalculoaritmetico.textCalculo.getText().toString();
//                double r = Math.cos(Double.parseDouble(valor));
//                bindingcalculoaritmetico.textResultado.setText(String.valueOf(r));
            }
        });
        bindingcalculoaritmetico.btLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bindingcalculoaritmetico.textCalculo.setText(bindingcalculoaritmetico.textCalculo.getText() + "log");
//
//                String valor = bindingcalculoaritmetico.textCalculo.getText().toString();
//                double r = Math.log10(Double.parseDouble(valor));
//                bindingcalculoaritmetico.textResultado.setText(String.valueOf(r));
            }
        });

        bindingcalculoaritmetico.btLn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bindingcalculoaritmetico.textCalculo.setText(bindingcalculoaritmetico.textCalculo.getText() + "ln");
//                String valor = bindingcalculoaritmetico.textCalculo.getText().toString();
//                double r = Math.log(Double.parseDouble(valor));
//                bindingcalculoaritmetico.textResultado.setText(String.valueOf(r));


            }
        });


        bindingcalculoaritmetico.btPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String valor = bindingcalculoaritmetico.textCalculo.getText().toString();

                bindingcalculoaritmetico.textCalculo.setText(bindingcalculoaritmetico.textCalculo.getText() + "%");
                Double valo = Double.parseDouble(valor);
                double res = valo / 100;
                bindingcalculoaritmetico.textResultado.setText("" + res);


            }
        });
        bindingcalculoaritmetico.btMod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double valor = Double.parseDouble(bindingcalculoaritmetico.textCalculo.getText().toString());

                bindingcalculoaritmetico.textCalculo.setText("|" + bindingcalculoaritmetico.textCalculo.getText() + "|");
                if (valor < 0) {
                    valor = valor * (-1);
                }
                bindingcalculoaritmetico.textResultado.setText("" + valor);


            }
        });


        bindingcalculoaritmetico.btTan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bindingcalculoaritmetico.textCalculo.setText(bindingcalculoaritmetico.textCalculo.getText() + "tan(");

            }
        });

        bindingcalculoaritmetico.btDerivada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bindingcalculoaritmetico.textCalculo.setText(bindingcalculoaritmetico.textCalculo.getText() + "d/dx");

            }
        });

        bindingcalculoaritmetico.btDivisor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bindingcalculoaritmetico.textCalculo.setText(bindingcalculoaritmetico.textCalculo.getText() + "/");

            }
        });

        bindingcalculoaritmetico.btDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bindingcalculoaritmetico.textCalculo.setText(bindingcalculoaritmetico.textCalculo.getText() + "");

            }
        });


        bindingcalculoaritmetico.btFactorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int val = Integer.parseInt(bindingcalculoaritmetico.textCalculo.getText().toString());
                int fact = factorial(val);
                bindingcalculoaritmetico.textResultado.setText(String.valueOf(fact));
                bindingcalculoaritmetico.textCalculo.setText(val + "!");

            }
        });

        bindingcalculoaritmetico.btRaiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String valor = bindingcalculoaritmetico.textCalculo.getText().toString();
                double r = Math.sqrt(Double.parseDouble(valor));
                bindingcalculoaritmetico.textResultado.setText(String.valueOf(r));
            }
        });

        bindingcalculoaritmetico.btCubo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int val = Integer.parseInt(bindingcalculoaritmetico.textCalculo.getText().toString());
                int val1 = Integer.parseInt(bindingcalculoaritmetico.textCalculo.getText().toString());
                int exp = expon(val, 3);
                bindingcalculoaritmetico.textResultado.setText(String.valueOf(exp));
                bindingcalculoaritmetico.textCalculo.setText(val + "^3");


            }
        });
        bindingcalculoaritmetico.btEuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double valor = Double.parseDouble(bindingcalculoaritmetico.textCalculo.getText().toString());
                //bindingcalculoaritmetico.textCalculo.setText(bindingcalculoaritmetico.textCalculo.getText() + "");


                double m = Math.pow(2.71, valor);
                bindingcalculoaritmetico.textResultado.setText(String.valueOf(m));


            }
        });

        bindingcalculoaritmetico.btQuadrado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int val = Integer.parseInt(bindingcalculoaritmetico.textCalculo.getText().toString());
                int val1 = Integer.parseInt(bindingcalculoaritmetico.textCalculo.getText().toString());
                int exp = exponQua(val, 2);
                bindingcalculoaritmetico.textResultado.setText(String.valueOf(exp));
                bindingcalculoaritmetico.textCalculo.setText(val + "^2");


            }
        });
        bindingcalculoaritmetico.btAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bindingcalculoaritmetico.textCalculo.setText("");
                bindingcalculoaritmetico.textResultado.setText("");
            }
        });

        bindingcalculoaritmetico.btPotencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int val = Integer.parseInt(bindingcalculoaritmetico.textCalculo.getText().toString());

            }
        });
        bindingcalculoaritmetico.btRaizCubica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double valor = Double.parseDouble(bindingcalculoaritmetico.textCalculo.getText().toString());
                double m = Math.pow(valor, 1 / 3);
                bindingcalculoaritmetico.textResultado.setText("" + m);


            }
        });

        bindingcalculoaritmetico.btEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = bindingcalculoaritmetico.textCalculo.getText().toString();
                String repl = val.replace('+', '+').replace('x', '*');
                double result = eval(repl);// metodo

                bindingcalculoaritmetico.textCalculo.setText(String.valueOf(result));
                bindingcalculoaritmetico.textResultado.setText(val);
                String operacao = bindingcalculoaritmetico.textResultado.getText().toString() +
                        "=" + bindingcalculoaritmetico.textCalculo.getText().toString();
                Gestor.salvar(getApplicationContext(), operacao, HistoricoCalculos.LOCAL_CALCULOS);
            }
        });
    }

    public int factorial(int n) {
        return (n == 1 || n == 0) ? 1 : n * factorial(n - 1);
    }

    public int exponCub(int a, int b) {

        if (b == 0) {
            return 1;
        }
        return a * exponCub(a, b - 1);
    }

    public int exponQua(int a, int b) {
        if (b == 0) {
            return 1;
        }
        return a * exponQua(a, b - 1);
    }

    public int expon(int a, int b) {
        if (b == 0) {
            return 1;
        }
        return a * expon(a, b - 1);
    }

    public double eval(final String str) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char) ch);
                return x;
            }

            // Grammar:
            // expression = term | expression `+` term | expression `-` term
            // term = factor | term `*` factor | term `/` factor
            // factor = `+` factor | `-` factor | `(` expression `)`
            //        | number | functionName factor | factor `^` factor

            double parseExpression() {
                double x = parseTerm();
                for (; ; ) {
                    if (eat('+')) x += parseTerm(); // addition
                    else if (eat('-')) x -= parseTerm(); // subtraction
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (; ; ) {
                    if (eat('*')) x *= parseFactor(); // multiplication
                    else if (eat('/')) x /= parseFactor(); // division
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return parseFactor(); // unary plus
                if (eat('-')) return -parseFactor(); // unary minus

                double x;
                int startPos = this.pos;
                if (eat('(')) { // parentheses
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z') { // functions
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    x = parseFactor();
                    if (func.equals("sqrt")) x = Math.sqrt(x);
                    else if (func.equals("sin")) x = Math.sin(x);
                    else if (func.equals("cos")) x = Math.cos((x));
                    else if (func.equals("tan")) x = Math.tan((x));
                    else if (func.equals("log")) x = Math.log10(x);
                    else if (func.equals("ln")) x = Math.log(x);
                    else throw new RuntimeException("Unknown function: " + func);
                } else {
                    throw new RuntimeException("Unexpected: " + (char) ch);
                }

                if (eat('^')) x = Math.pow(x, parseFactor()); // exponentiation

                return x;
            }
        }.parse();
    }


    public void existe(Context context) {
        File file = new File(context.getFilesDir(), "historico.txt");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(context, "Ocorreu um erro na criação do arquivo", Toast.LENGTH_SHORT).show();
        }
    }
}









