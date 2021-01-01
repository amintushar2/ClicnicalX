package com.raslab.clicnicalx.pojos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.raslab.clicnicalx.R;

import java.util.List;

public class DoctorListAdapter extends  RecyclerView.Adapter<DoctorListAdapter.DoctorViewHolder> {

    private Context context;
    private List<DoctorListDataSet> docList;

    public DoctorListAdapter(Context context, List<DoctorListDataSet> docList) {
        this.context = context;
        this.docList = docList;
    }

    @NonNull
    @Override
    public DoctorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_row_doclist, parent, false);
        return new DoctorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DoctorViewHolder holder, int position) {

//        holder.docPic.setImageResource(docList.get(position).getDocPicId());
        holder.docName.setText(docList.get(position).getName());
        holder.docTitle.setText(docList.get(position).getDesignation());
        holder.hospitalName.setText(docList.get(position).getSecialityName());
        holder.visitTime.setText(docList.get(position).getHospitalName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }

    @Override
    public int getItemCount() {
        return docList.size();
    }

    public void setDoclist(List<DoctorListDataSet>doctorListDataSetList) {
        this.docList=doctorListDataSetList;
        notifyDataSetChanged();

    }

    public class DoctorViewHolder extends RecyclerView.ViewHolder {
        TextView docName,docTitle,hospitalName,visitTime;
        ImageView docPic;
        CardView cardView;
        Button btn1,btn2;
        LinearLayout lout;



        public DoctorViewHolder(@NonNull View itemView) {
            super(itemView);

            docName = itemView.findViewById(R.id.docName);
            docTitle = itemView.findViewById(R.id.docTitle);
            hospitalName = itemView.findViewById(R.id.hospitalName);
            visitTime = itemView.findViewById(R.id.timeVisit);
            docPic =itemView.findViewById(R.id.horizontal_docPic);
            cardView=itemView.findViewById(R.id.cardviewItem);
            btn1=itemView.findViewById(R.id.profile);
            btn2=itemView.findViewById(R.id.appointment);
            lout=itemView.findViewById(R.id.looout);
        }
    }


}
