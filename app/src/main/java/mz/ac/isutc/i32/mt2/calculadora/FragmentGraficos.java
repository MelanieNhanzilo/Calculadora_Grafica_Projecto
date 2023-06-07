package mz.ac.isutc.i32.mt2.calculadora;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;

public class FragmentGraficos extends Fragment{
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_graficos, container, false);
        Button plot=view.findViewById(R.id.bt_plot);
        Button table=view.findViewById(R.id.bt_table);
        ImageButton history=view.findViewById(R.id.bt_historico);
        table.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(),Tabela.class);
                startActivity(i);
            }
        });
        plot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(), Plot.class);
                startActivity(i);
            }
        });
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(), HistoricoGraficos.class);
                startActivity(i);
            }
        });
        return view;

    }
}
