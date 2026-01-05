package com.example.datamahasiswaapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.datamahasiswaapp.R;
import com.example.datamahasiswaapp.model.Mahasiswa;

import java.util.List;

public class MahasiswaAdapter extends RecyclerView.Adapter<MahasiswaAdapter.ViewHolder> {

    private List<Mahasiswa> list;

    public MahasiswaAdapter(List<Mahasiswa> list) {
        this.list = list;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama, tvNim, tvJurusan;

        public ViewHolder(View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tvNama);
            tvNim = itemView.findViewById(R.id.tvNim);
            tvJurusan = itemView.findViewById(R.id.tvJurusan);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_mahasiswa, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Mahasiswa m = list.get(position);
        holder.tvNama.setText(m.getNama());
        holder.tvNim.setText(m.getNim());
        holder.tvJurusan.setText(m.getJurusan());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
