package com.mobile.app.valuefinder2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

/**
 * Created by Manandhar on 6/20/16.
 */
public class ValueFragment extends Fragment implements View.OnClickListener {
    Button pvif, fvif, pvifa, fvifa;
    EditText n, p;
    TextView view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.main_view, container, false);

        pvif = (Button) v.findViewById(R.id.pvif);
        pvifa = (Button) v.findViewById(R.id.pvifa);
        fvif = (Button) v.findViewById(R.id.fvif);
        fvifa = (Button) v.findViewById(R.id.fvifa);
        n = (EditText) v.findViewById(R.id.years);
        p = (EditText) v.findViewById(R.id.percent);
        view = (TextView) v.findViewById(R.id.result);

        try {
            pvif.setOnClickListener(this);
            pvifa.setOnClickListener(this);
            fvif.setOnClickListener(this);
            fvifa.setOnClickListener(this);
        } catch (Exception err) {
            view.setText("Something is wrong !!");
        }
        return v;
    }

    public void onClick(View v) throws NumberFormatException {
        double n1 = 0d, k2 = 0d, k12 = 0d, nA = 0d, k13 = 0d, nB = 0d, k14 = 0d, na = 0d;
        switch (v.getId()) {
            case R.id.pvif:
                try {
                    n1 = Double.parseDouble(n.getText().toString());
                    k2 = Double.parseDouble(p.getText().toString());
                } catch (NumberFormatException err) {
                    Toast.makeText(getContext(), "ERROR", Toast.LENGTH_LONG).show();
                }
                double k1 = k2 / 100;
                double down = 1 + k1;
                double downFull = getPower(down, n1);
                double res2 = 1 / downFull;
                view.setText(String.valueOf(new DecimalFormat("##.####").format(res2)));
                break;

            case R.id.pvifa:
                try {
                    nA = Double.parseDouble(n.getText().toString());
                    k12 = Double.parseDouble(p.getText().toString());
                } catch (NumberFormatException err) {
                    Toast.makeText(getContext(), "ERROR", Toast.LENGTH_LONG).show();
                }
                double kA = k12 / 100;
                double res1 = kA + 1;
                double val = getPower(res1, nA);
                val = 1 / val;
                val = 1 - val;
                double results = val / kA;
                view.setText(String.valueOf(new DecimalFormat("##.####").format(results)));
                break;

            case R.id.fvif:
                try {
                    nB = Double.parseDouble(n.getText().toString());
                    k13 = Double.parseDouble(p.getText().toString());
                } catch (NumberFormatException err) {
                    Toast.makeText(getContext(), "ERROR", Toast.LENGTH_LONG).show();
                }
                double kB = k13 / 100;
                double valA = 1 + kB;
                Double resultss = getPower(valA, nB);
                view.setText(String.valueOf(new DecimalFormat("##.####").format(resultss)));
                break;

            case R.id.fvifa:
                try {
                    na = Double.parseDouble(n.getText().toString());
                    k14 = Double.parseDouble(p.getText().toString());
                } catch (NumberFormatException err) {
                    Toast.makeText(getContext(), "ERROR", Toast.LENGTH_LONG).show();
                }
                double i = k14 / 100;
                double values = 1 + i;
                values = getPower(values, na);
                values = values - 1;
                values = values / i;
                view.setText(String.valueOf(new DecimalFormat("##.####").format(values)));
                break;
        }

    }


    public double getPower(double d, double n) {
        double result = 1.0f;
        for (int i = 0; i < n; i++) {
            result *= d;
        }
        return result;
    }
}
