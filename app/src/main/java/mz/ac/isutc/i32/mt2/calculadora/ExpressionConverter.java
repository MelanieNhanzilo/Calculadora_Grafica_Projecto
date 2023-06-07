package mz.ac.isutc.i32.mt2.calculadora;

import android.content.Context;
import android.widget.Toast;
import org.mariuszgromada.math.mxparser.*;


public class ExpressionConverter {
    public static String convertExpression(Context context, String inputExpression) {
        VisualizarGrafico.verificarParentesis(inputExpression);
        Expression expression = new Expression(inputExpression);
        if (expression.checkSyntax()) {
            String convertedExpression = expression.getExpressionString();
            return convertedExpression;
        } else {
            Toast.makeText(context, "Expressão inválida!", Toast.LENGTH_SHORT).show();
            return null;
        }
    }
}
