package com.iavariav.kbmonline.ui.atasan.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.iavariav.kbmonline.R;
import com.iavariav.kbmonline.helper.Config;
import com.iavariav.kbmonline.model.AtasanAprovalModel;
import com.iavariav.kbmonline.rest.ApiConfig;
import com.iavariav.kbmonline.rest.ApiService;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AtasanHistoriAprovalAdapter extends RecyclerView.Adapter<AtasanHistoriAprovalAdapter.ViewHolder> {
    private String id;
    private Context context;

    private ArrayList<AtasanAprovalModel> atasanAprovalModels;

    public AtasanHistoriAprovalAdapter(Context context, ArrayList<AtasanAprovalModel> atasanAprovalModels) {
        this.context = context;
        this.atasanAprovalModels = atasanAprovalModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_atasan_histori, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        id = sharedPreferences.getString(Config.SHARED_PREF_ID, "");
        holder.tvRegToken.setText(atasanAprovalModels.get(position).getREGTOKENPEMESANAN());
        holder.tvNama.setText(atasanAprovalModels.get(position).getnAMAPEMESAN());
        holder.tvJenisKeperluan.setText(atasanAprovalModels.get(position).getJENISKEPERLUAN());
        holder.tvJenisPemesanan.setText(atasanAprovalModels.get(position).getJENISPEMESANAN());
        holder.tvKm.setText(atasanAprovalModels.get(position).getJARAKPERKM() + "\n KM");
        holder.tvKeberangkatan.setText(atasanAprovalModels.get(position).getKEBERANGKATANAREAPOOL());
        holder.tvWaktuKeberangkatan.setText(atasanAprovalModels.get(position).getWAKTUKEBERANGKATAN());
        holder.tvTujuan.setText(atasanAprovalModels.get(position).getTUJUANALAMATJEMPUT());
        holder.tvWaktuTujuan.setText(atasanAprovalModels.get(position).getWAKTUKEPULANGAN());
        holder.tvIsiPenumpang.setText(atasanAprovalModels.get(position).getISIPENUMPANG());
        holder.tvKeternangan.setText(atasanAprovalModels.get(position).getKETERANGAN());
        holder.tvStatus.setText(atasanAprovalModels.get(position).getSTATUSPEMESANAN());


        String jarakKm = atasanAprovalModels.get(position).getJARAKPERKM();
        double hitungLiter = Integer.parseInt(jarakKm)/ 11.6;
        double hitugHargaBBM = hitungLiter * Integer.parseInt(atasanAprovalModels.get(position).getBENSINPERLITER());

        holder.tvHargaBbm.setText("RP." + hitugHargaBBM);


    }


    @Override
    public int getItemCount() {
        return atasanAprovalModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvRegToken;
        private TextView tvNama;
        private TextView tvJenisKeperluan;
        private TextView tvJenisPemesanan;
        private TextView tvKm;
        private TextView tvKeberangkatan;
        private TextView tvWaktuKeberangkatan;
        private TextView tvTujuan;
        private TextView tvWaktuTujuan;
        private TextView tvIsiPenumpang;
        private TextView tvKeternangan;
        private TextView tvHargaBbm;
        private TextView tvStatus;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvRegToken = itemView.findViewById(R.id.tv_reg_token);
            tvNama = itemView.findViewById(R.id.tv_nama);
            tvJenisKeperluan = itemView.findViewById(R.id.tv_jenis_keperluan);
            tvJenisPemesanan = itemView.findViewById(R.id.tv_jenis_pemesanan);
            tvKm = itemView.findViewById(R.id.tv_km);
            tvKeberangkatan = itemView.findViewById(R.id.tv_keberangkatan);
            tvWaktuKeberangkatan = itemView.findViewById(R.id.tv_waktu_keberangkatan);
            tvTujuan = itemView.findViewById(R.id.tv_tujuan);
            tvWaktuTujuan = itemView.findViewById(R.id.tv_waktu_tujuan);
            tvIsiPenumpang = itemView.findViewById(R.id.tv_isi_penumpang);
            tvKeternangan = itemView.findViewById(R.id.tv_keternangan);
            tvHargaBbm = itemView.findViewById(R.id.tv_harga_bbm);
            tvStatus = itemView.findViewById(R.id.tv_status);
        }
    }
}
