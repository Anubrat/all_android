package com.mobile.app.valuefinder2;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Manandhar on 6/20/16.
 */
public class ByPercent extends Fragment {
    RecyclerView recyclerView;
    CustomAdapter adapter;
    List<ListValue> lists;
    EditText years;
    Button value;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.percent, container, false);
        years = (EditText) v.findViewById(R.id.yearsP);
        value = (Button) v.findViewById(R.id.valueP);
        recyclerView = (RecyclerView) v.findViewById(R.id.listP);
        value.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int myval = Integer.parseInt(years.getText().toString());
                if (myval > 60) {
                    Toast.makeText(getContext(), "Please enter below 60 only", Toast.LENGTH_LONG).show();
                } else {
                    adapter = new CustomAdapter(getActivity(), getData());
                    recyclerView.setAdapter(adapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                }
            }
        });
        return v;

    }

    private List<ListValue> getData() {
        double i = Double.parseDouble(years.getText().toString());
        lists = new ArrayList<>();
        for (int n = 1; n <= 60; n++) {
            ListValue value = new ListValue();
            value.percent = n;
            value.value = getPVIF((double) i, n);
            lists.add(value);
        }
        return lists;
    }

    private double getPVIF(double k, double n) {
        double k1 = k / 100;
        k1 += 1;
        double power = getPower(k1, n);
        double power2 = 1 / power;
        return power2;
    }


    public double getPower(double d, double n) {
        double result = 1.0f;
        for (int i = 0; i < n; i++) {
            result *= d;
        }
        return result;
    }


    private class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
        LayoutInflater layouts;
        List<ListValue> values = Collections.emptyList();

        public CustomAdapter(Context context, List<ListValue> data) {
            layouts = LayoutInflater.from(context);
            this.values = data;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = layouts.inflate(R.layout.text_design, parent, false);
            MyViewHolder view = new MyViewHolder(v);
            return view;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            ListValue valu = values.get(position);
            holder.value1.setText(String.valueOf(new DecimalFormat("##.####").format(valu.percent)));
            holder.value2.setText(String.valueOf(new DecimalFormat("##.####").format(valu.value)));
        }

        @Override
        public int getItemCount() {
            return values.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            TextView value1, value2;//value1 = percent and value2 = value

            public MyViewHolder(View itemView) {
                super(itemView);
                value1 = (TextView) itemView.findViewById(R.id.value1);
                value2 = (TextView) itemView.findViewById(R.id.value2);
            }
        }
    }
}
