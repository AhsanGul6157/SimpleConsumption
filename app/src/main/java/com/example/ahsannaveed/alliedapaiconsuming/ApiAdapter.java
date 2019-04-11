package com.example.ahsannaveed.alliedapaiconsuming;

import android.content.Context;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

public class ApiAdapter extends RecyclerView.Adapter<ApiAdapter.ApiviewHolder> {
    private List<ApiModel> dataList;

    private Context context;

    public ApiAdapter(List<ApiModel> dataList) {
        this.dataList=dataList;

    }

    @NonNull
    @Override
    public ApiviewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        context=viewGroup.getContext();
        LayoutInflater inflater=LayoutInflater.from(viewGroup.getContext());

        //Creating  view using inflater class
        View view=inflater.inflate(R.layout.card_view, viewGroup, false);

        return new ApiviewHolder(view);
    }

    @RequiresApi(api=Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void onBindViewHolder(@NonNull ApiviewHolder apiviewHolder, int i) {
//        apiviewHolder.textView.setText(dataList.get(i).getId());
//        apiviewHolder.textView1.setText(dataList.get(i).getAbbreviation());
        apiviewHolder.textView2.setText(dataList.get(i).getFullName());

        if (dataList.get(i).getFullName().equals("English")) {
            apiviewHolder.imageView.setImageResource(R.drawable.ic_subject_english);
        }
        if (dataList.get(i).getFullName().equals("Urdu")) {
            apiviewHolder.imageView.setImageResource(R.drawable.ic_subject_urdu);
        }
        if (dataList.get(i).getFullName().equals("Physics")) {
            apiviewHolder.imageView.setImageResource(R.drawable.ic_subject_physics);
        }
        if (dataList.get(i).getFullName().equals("Islamic Studies")) {
            apiviewHolder.imageView.setImageResource(R.drawable.ic_subject_islamiyat);
        }
        if (dataList.get(i).getFullName().equals("Chemistry")) {
            apiviewHolder.imageView.setImageResource(R.drawable.ic_subject_chemistry);
        }
        if (dataList.get(i).getFullName().equals("Computer Science")) {
            apiviewHolder.imageView.setImageResource(R.drawable.ic_subject_computer);
        }
        if (dataList.get(i).getFullName().equals("Mathematics")) {
            apiviewHolder.imageView.setImageResource(R.drawable.ic_subject_math);
        }
        if (dataList.get(i).getFullName().equals("Biology")) {
            apiviewHolder.imageView.setImageResource(R.drawable.ic_subject_bio);
        }
        if (dataList.get(i).getFullName().equals("Pakistan Studies")) {
            apiviewHolder.imageView.setImageResource(R.drawable.ic_subject_pak);
        }

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ApiviewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        TextView textView1;
        TextView textView2;
        ImageView imageView;

        public ApiviewHolder(@NonNull View itemView) {
            super(itemView);
            textView2=itemView.findViewById(R.id.Card_view_text_view2);
            imageView=itemView.findViewById(R.id.image);
        }
    }
}
