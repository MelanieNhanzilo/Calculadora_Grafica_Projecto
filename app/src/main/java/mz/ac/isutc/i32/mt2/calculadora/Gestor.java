package mz.ac.isutc.i32.mt2.calculadora;

import android.content.Context;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Gestor {

    public static void salvar(Context context, String operacao, String local) {
        try {
            FileOutputStream fileOutputStream=context.openFileOutput(local,Context.MODE_APPEND);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
            bufferedWriter.write(operacao);
            bufferedWriter.newLine();
            bufferedWriter.close();
        }catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(context, "falha ao adicionar uma nova operação", Toast.LENGTH_SHORT).show();
        }
    }
    public static ArrayList<String> ler(Context context, String local) {
        ArrayList<String> historico = null;
        try {
            File file = new File(context.getFilesDir(),local);
            if (file.exists() && file.length() > 0) {
                FileInputStream fileInputStream = context.openFileInput(local);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                String line;
                StringBuilder historicoBuilder = new StringBuilder();
                while ((line = bufferedReader.readLine()) != null) {
                    historicoBuilder.append(line).append("\n");
                }
                bufferedReader.close();
                historico = new ArrayList<>(Arrays.asList(historicoBuilder.toString().split("\n")));
                Collections.reverse(historico);
            }else{
                return null;
            }

        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(context, "Erro ao ler historico", Toast.LENGTH_SHORT).show();
        }
        return historico;
    }
    public static void apagarHistorico(Context context, String local) throws IOException {
        File file = new File(context.getFilesDir(), local);
        if (file.exists()) {
            boolean deleted = file.delete();
            if (deleted) {
                Toast.makeText(context, "Apagado com sucesso!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "Erro ao apagar o histórico", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(context, "O arquivo não existe", Toast.LENGTH_SHORT).show();
        }
    }
}
