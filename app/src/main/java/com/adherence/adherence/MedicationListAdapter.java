package com.adherence.adherence;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MedicationListAdapter extends RecyclerView.Adapter<MedicationListAdapter.ViewHolder>{

    private String[] medicineListHardcode;
    private String[] detailListHardcode;

    public interface OnItemClickListener
    {
        void onItemClick(View view, int position);
        void onItemLongClick(View view, int position);
    }
    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener listener){
        this.mOnItemClickListener=listener;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View listRootView;

        public TextView getMedicineName() {
            return medicineName;
        }
        public TextView getMedicineDetail() {return medicineDetail; }

        private TextView medicineName;
        private TextView medicineDetail;
        public ViewHolder(View v1) {
            super(v1);
            listRootView = v1;
            medicineName = (TextView) v1.findViewById(R.id.medicine_name);
            medicineDetail = (TextView) v1.findViewById(R.id.medicine_detail);
        }
    }

    public MedicationListAdapter(String[] hardCode, String[] detailCode) {
        medicineListHardcode = hardCode;
        detailListHardcode=detailCode;
    }

    @Override
    public MedicationListAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.medication_listitem, viewGroup, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final MedicationListAdapter.ViewHolder vh, final int position) {
        vh.getMedicineName().setText(medicineListHardcode[position]);
        vh.getMedicineDetail().setText(detailListHardcode[position]);
        if(mOnItemClickListener!=null) {
            vh.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    mOnItemClickListener.onItemClick(vh.itemView, position);

                }
            });
            vh.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    mOnItemClickListener.onItemLongClick(vh.itemView,position);
                    return false;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return medicineListHardcode.length;
    }


}
