package com.raslab.clicnicalx.pojos;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
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

import com.raslab.clicnicalx.DoctorProfile;
import com.raslab.clicnicalx.MainActivity;
import com.raslab.clicnicalx.R;

import java.util.List;

public class DoctorListHorizontalAdapter extends  RecyclerView.Adapter<DoctorListHorizontalAdapter.DoctorViewHolder> {

    private Context context;
    private List<DoctorListDataSet> docList;

    public DoctorListHorizontalAdapter(Context context, List<DoctorListDataSet> docList) {
        this.context = context;
        this.docList = docList;
    }

    @NonNull
    @Override
    public DoctorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_row_horizontal_doclist, parent, false);
        return new DoctorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DoctorViewHolder holder, int position) {

        holder.docPic.setImageResource(docList.get(position).getDocPicId());
        holder.docName.setText(docList.get(position).docName);
//        holder.docTitle.setText(docList.get(position).docTitle);
//        holder.hospitalName.setText(docList.get(position).hospitalName);
//        holder.visitTime.setText(docList.get(position).docHours);
       holder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(context, DoctorProfile.class);
               context.startActivity(intent);

           }
       });
    }

    @Override
    public int getItemCount() {
        Log.d("amin", String.valueOf(docList.size()));
        return docList.size();
    }

    public class DoctorViewHolder extends RecyclerView.ViewHolder {
        TextView docName,docTitle,hospitalName,visitTime;
        ImageView docPic;
        CardView cardView;
        Button btn1,btn2;
        LinearLayout lout;



        public DoctorViewHolder(@NonNull View itemView) {
            super(itemView);

            docName = itemView.findViewById(R.id.doc_horizontal_name);
//            docTitle = itemView.findViewById(R.id.docTitle);
//            hospitalName = itemView.findViewById(R.id.hospitalName);
//            visitTime = itemView.findViewById(R.id.timeVisit);
            docPic =itemView.findViewById(R.id.horizontal_docPic);
//            cardView=itemView.findViewById(R.id.cardviewItem);
//            btn1=itemView.findViewById(R.id.profile);
//            btn2=itemView.findViewById(R.id.appointment);
//            lout=itemView.findViewById(R.id.looout);
        }
    }


}
