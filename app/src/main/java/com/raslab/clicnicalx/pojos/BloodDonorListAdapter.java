package com.raslab.clicnicalx.pojos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.raslab.clicnicalx.R;

import java.util.List;

public class BloodDonorListAdapter extends RecyclerView.Adapter<BloodDonorListAdapter.BloodDonorListViewHolder> {
    private  Context context;
    private  List<BloodDonorListDataSet>bloodDonorListDataSetList;

    public BloodDonorListAdapter(Context context, List<BloodDonorListDataSet> bloodDonorListDataSetList) {
        this.context = context;
        this.bloodDonorListDataSetList = bloodDonorListDataSetList;
    }

    @NonNull
    @Override
    public BloodDonorListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.bllod_donor_single_raw,parent,false);
        return new BloodDonorListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BloodDonorListViewHolder holder, int position) {
            holder.donorName.setText(bloodDonorListDataSetList.get(position).getName());
            holder.donorGroup.setText(bloodDonorListDataSetList.get(position).getBloodGroupName());
            holder.donorLocation.setText(bloodDonorListDataSetList.get(position).getDistrictName());
    }

    @Override
    public int getItemCount() {
        return bloodDonorListDataSetList.size();
    }



    public void setHospitalListDataSetList(List<BloodDonorListDataSet> bloodDonorListDataSetList) {

        this.bloodDonorListDataSetList = bloodDonorListDataSetList;
        notifyDataSetChanged();
    }

    class BloodDonorListViewHolder extends RecyclerView.ViewHolder {
        TextView donorName,donorGroup,donorLocation,donorLastDonating;

        public BloodDonorListViewHolder(@NonNull View itemView) {
            super(itemView);
            donorName = itemView.findViewById(R.id.donorName);
            donorGroup=itemView.findViewById(R.id.bloodGroup);
            donorLastDonating= itemView.findViewById(R.id.donorLastDonating);
            donorLocation = itemView.findViewById(R.id.donorLocation);
        }
    }
}
