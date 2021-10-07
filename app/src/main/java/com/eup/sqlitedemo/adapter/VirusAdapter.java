package com.eup.sqlitedemo.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eup.sqlitedemo.R;
import com.eup.sqlitedemo.model.Virus;

import java.util.List;

public class VirusAdapter  extends RecyclerView.Adapter<VirusAdapter.VirusHolder> {
    private LayoutInflater inflater;
    private List<Virus> data;

    public VirusAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }
    public void setData(List<Virus> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public VirusHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VirusHolder(
                inflater.inflate(R.layout.item_virus, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull VirusHolder holder, int position) {
        holder.bindView(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public class VirusHolder extends RecyclerView.ViewHolder {
        private TextView tvName;
        private TextView tvCauTruc;
        private TextView tvNgay;
        private TextView tvVacxin;

        public VirusHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvCauTruc = itemView.findViewById(R.id.tv_cautruc);
            tvNgay = itemView.findViewById(R.id.tv_ngay);
            tvVacxin = itemView.findViewById(R.id.tv_vacxin);
        }

        public void bindView(Virus virus) {
            tvName.setText(virus.getName());
            tvCauTruc.setText(virus.getCauTruc());
            tvNgay.setText(virus.getNgayXuatHien());
            tvVacxin.setText(virus.getVacXin());
        }
    }
}

