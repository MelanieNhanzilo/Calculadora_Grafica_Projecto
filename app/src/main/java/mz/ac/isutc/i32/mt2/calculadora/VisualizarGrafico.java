package mz.ac.isutc.i32.mt2.calculadora;

import androidx.appcompat.app.AppCompatActivity;




import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


import mz.ac.isutc.i32.mt2.calculadora.databinding.ActivityVisualizarGraficoBinding;
public class VisualizarGrafico extends AppCompatActivity {
    static ActivityVisualizarGraficoBinding b;
    static boolean shiftActivo=false;
    static String op="";
    static String ope="";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b=ActivityVisualizarGraficoBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());
        b.btTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(VisualizarGrafico.this,Tabela.class);
                startActivity(i);
            }
        });
        b.btPlot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(VisualizarGrafico.this, Plot.class);
                startActivity(i);
                verificarParentesis(op);
                Gestor.salvar(VisualizarGrafico.this,ope,HistoricoGraficos.LOCAL_HISTORICO);
            }
        });

        b.btShift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shiftActivo=!shiftActivo;
                if(shiftActivo){
                    b.btCos.setText("acos");
                    b.btSin.setText("asen");
                    b.btTan.setText("atan");
                    b.btTan.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            op+="atan(";
                            ope+="atan(";
                            b.txFuncao.setText(ope);
                        }
                    });b.btSin.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            op+="asin(";
                            ope+="asin(";
                            b.txFuncao.setText(ope);
                        }
                    });b.btCos.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            op+="acos(";
                            ope+="acos(";
                            b.txFuncao.setText(ope);
                        }
                    });
                }else {
                    b.btCos.setText("cos");
                    b.btSin.setText("sen");
                    b.btTan.setText("tan");
                    b.btTan.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            op+="tan(";
                            ope+="tan(";
                            b.txFuncao.setText(ope);
                        }
                    });b.btSin.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            op+="sin(";
                            ope+="sin(";
                            b.txFuncao.setText(ope);
                        }
                    });b.btCos.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            op+="cos(";
                            ope+="cos(";
                            b.txFuncao.setText(ope);
                        }
                    });
                }
            }
        });
        b.btHistorico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(VisualizarGrafico.this, HistoricoGraficos.class);
                startActivity(i);
            }
        });
        b.btCos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op+="cos(";
                ope+="cos(";
                b.txFuncao.setText(ope);

            }
        });
        b.btX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op+="x";
                ope+="x";
                b.txFuncao.setText(ope);
            }
        });
        b.btLn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op+="exp(";ope+="ln(";
                b.txFuncao.setText(ope);

            }
        });
        b.btSin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op+="sin(";
                ope+="sin(";
                b.txFuncao.setText(ope);

            }
        });
        b.btTan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op+="tan(";
                ope+="tan(";
                b.txFuncao.setText(ope);

            }
        });
        b.btEuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op+="exp(";
                ope+="e^(";
                b.txFuncao.setText(ope);
            }
        });
        b.btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        b.btSinc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op="sinc(";
                ope="sinc(";
                b.txFuncao.setText(ope);
            }
        });
        b.btLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op+="log10(";
                ope+="log(";
                b.txFuncao.setText(ope);
            }
        });
        b.btDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (op.isEmpty()) {
                    Toast.makeText(VisualizarGrafico.this, "Vazio", Toast.LENGTH_SHORT).show();
                } else {
                    op = op.substring(0, op.length() - 1);
                    ope = ope.substring(0, ope.length() - 1);
                    b.txFuncao.setText(ope);
                }
            }
        });
        b.btAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op="";
                ope="";
                b.txFuncao.setText("");
            }
        });
        b.btParentesis1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op+="(";
                ope+="(";
                b.txFuncao.setText(ope);
            }
        });
        b.btParentesis2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op+=")";
                ope+=")";
                b.txFuncao.setText(ope);
            }
        });
        b.bt10x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op+="*10^";
                ope+="*10^";
                b.txFuncao.setText(ope);
            }
        });
        b.btInv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op="1/("+op;
                ope+="inv(";
                b.txFuncao.setText(ope);
            }
        });

    b.btModulo.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            op+="abs(";
            ope+="M+(";
            b.txFuncao.setText(ope);
        }
    });
        b.btPonto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(op==""){
                    op+="0.";
                    ope+="0.";
                }else if(op.charAt(op.length()-1)=='('){
                    op+="0.";
                    ope+="0.";
                } else if (op.charAt(op.length()-1)=='x') {
                    op+="*0.";
                    ope+="*0.";
                } else {
                    op+=".";
                    ope+=".";
                }
                b.txFuncao.setText(ope);
            }
        });
        b.btPi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op+="3.14";
                ope+="π";
                b.txFuncao.setText(ope);
            }
        });
        b.btPotencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op+="^";
                ope+="^";
                b.txFuncao.setText(ope);
            }
        });
        b.btQuadrado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op+="^2";
                ope+="^2";
                b.txFuncao.setText(ope);
            }
        });
        b.bt0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op+="0";
                ope+="0";
                b.txFuncao.setText(ope);
            }
        });
        b.bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op+="1";
                ope+="1";
                b.txFuncao.setText(ope);
            }
        });b.bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op+="2";
                ope+="2";

                b.txFuncao.setText(ope);
            }
        });b.bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op+="3";
                ope+="3";

                b.txFuncao.setText(ope);
            }
        });b.bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op+="4";
                ope+="4";

                b.txFuncao.setText(ope);
            }
        });b.bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op+="5";
                ope+="5";

                b.txFuncao.setText(ope);
            }
        });b.bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op+="6";
                ope+="6";

                b.txFuncao.setText(ope);
            }
        });b.bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op+="7";
                ope+="7";

                b.txFuncao.setText(ope);
            }
        });b.bt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op+="8";
                ope+="8";

                b.txFuncao.setText(ope);
            }
        });b.bt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op+="9";
                ope+="9";

                b.txFuncao.setText(ope);
            }
        });
        b.btMultiplicacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removerSinalDuplicado();
                op+="*";
                ope+="*";
                b.txFuncao.setText(ope);
            }
        });
        b.btDivisor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removerSinalDuplicado();
                op+="/";
                ope+="/";
                b.txFuncao.setText(ope);
            }
        });
        b.btSoma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removerSinalDuplicado();
                op+="+";
                ope+="+";
                b.txFuncao.setText(ope);
            }
        });
        b.btSubtraccao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removerSinalDuplicado();
                op+="-";
                ope+="-";
                b.txFuncao.setText(ope);
            }
        });
        b.btRaiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op+="sqrt(";
                ope+="√(";
                b.txFuncao.setText(ope);
            }
        });
        b.btFx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ope+="f(x)=";
                b.txFuncao.setText(ope);
            }
        });

    }
    public static void removerSinalDuplicado(){
        if(op.charAt(op.length()-1)=='+' || op.charAt(op.length()-1)=='-' || op.charAt(op.length()-1)=='*' || op.charAt(op.length()-1)=='/') {
            op =op.substring(0,op.length()-1);
        }
    }
    public static void verificarParentesis(String x){
        if(!x.contains("(")){
            x=x;
        }
        if(x.contains("(") && x.contains(")")){
            x=x;
        }
        else{
            if(x.contains("(") && x.charAt(x.length()-1)!=')'){
                x+=")";
            }
        }
    }


}