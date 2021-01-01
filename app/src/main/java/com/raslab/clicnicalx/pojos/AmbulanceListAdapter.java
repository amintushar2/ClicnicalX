package com.raslab.clicnicalx.pojos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.raslab.clicnicalx.R;

import java.util.List;

public class AmbulanceListAdapter extends RecyclerView.Adapter<AmbulanceListAdapter.AmbulanceListViewHolder> {
Context context;
private  List<AmbulanceListDataSet>ambulanceListDataSetList;

    public AmbulanceListAdapter(Context context, List<AmbulanceListDataSet> ambulanceListDataSetList) {
        this.context = context;
        this.ambulanceListDataSetList = ambulanceListDataSetList;
    }

    @NonNull
    @Override
    public AmbulanceListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.ambulance_single_raw,parent,false);
        return new AmbulanceListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AmbulanceListViewHolder holder, int position) {
        holder.ambulanceDriverName.setText(ambulanceListDataSetList.get(position).getDriverName());
        holder.ambulanceCarNumber.setText(ambulanceListDataSetList.get(position).getAmbuNo());
       holder.ambulanceDriverLocation.setText(ambulanceListDataSetList.get(position).getDistrictName());
        holder.ambulanceRent.setText("Price : "+ambulanceListDataSetList.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        Toast.makeText(context, ""+ambulanceListDataSetList.size(), Toast.LENGTH_SHORT).show();
        return ambulanceListDataSetList.size();
    }

    public void setHospitalListDataSetList(List<AmbulanceListDataSet> ambulanceListDataSetList) {
        this.ambulanceListDataSetList=ambulanceListDataSetList;
        notifyDataSetChanged();
    }


    class  AmbulanceListViewHolder extends RecyclerView.ViewHolder{
        TextView ambulanceDriverName,ambulanceDriverLocation,ambulanceRent,ambulanceCarNumber;
        public AmbulanceListViewHolder(@NonNull View itemView) {
            super(itemView);
            ambulanceDriverName=itemView.findViewById(R.id.driverName);
            ambulanceDriverLocation=itemView.findViewById(R.id.ambulanceLocation);
            ambulanceCarNumber=itemView.findViewById(R.id.ambulanceNumber);
            ambulanceRent=itemView.findViewById(R.id.ambulanceRent);
        }
    }
}
