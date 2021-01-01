package com.raslab.clicnicalx.pojos;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.raslab.clicnicalx.R;

import java.util.List;


public class HospitalListAdapter extends RecyclerView.Adapter<HospitalListAdapter.HospitalViewHolder> {
    private Context context;
     List<HospitalDataSet>hospitalListDataSetList ;

    public HospitalListAdapter(Context context, List<HospitalDataSet>hospitalListDataSetList) {
        this.context = context;
        this.hospitalListDataSetList =hospitalListDataSetList;
    }





    @NonNull
    @Override
    public HospitalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view =inflater.inflate(R.layout.hospital_list_single_raw,parent,false);
        return new HospitalViewHolder(view);
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull HospitalViewHolder holder, int position) {

            holder.hospitalName.setText(hospitalListDataSetList.get(position).getName());
            holder.availableSeat.setText("Total Seat"+String.valueOf(hospitalListDataSetList.get(position).getBMaleWard()));
            holder.location.setText(hospitalListDataSetList.get(position).getDistrictName());

    }

    @Override
    public int getItemCount() {

        return hospitalListDataSetList.size();

    }

    class HospitalViewHolder extends RecyclerView.ViewHolder{
        TextView hospitalName,availableSeat,totalSeat,location,generalWord;
        public HospitalViewHolder(@NonNull View itemView) {
            super(itemView);
            hospitalName=itemView.findViewById(R.id.hospital_name);
            availableSeat=itemView.findViewById(R.id.availableSeat);
            location=itemView.findViewById(R.id.location_hospital);

        }


    }
    public void setHospitalListDataSetList(List<HospitalDataSet>hospitalListDataSetList) {
        this.hospitalListDataSetList =hospitalListDataSetList;
        notifyDataSetChanged();
    }

}
