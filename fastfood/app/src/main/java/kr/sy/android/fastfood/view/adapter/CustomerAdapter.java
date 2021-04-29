package kr.sy.android.fastfood.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import kr.sy.android.fastfood.R;
import kr.sy.android.fastfood.model.Company;
import kr.sy.android.fastfood.view.action.OnItemClickListener;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.ViewHolder> implements OnItemClickListener {

    private Context context;
    private ArrayList<Company> items = new ArrayList<Company>();
    private OnItemClickListener listener;

    public CustomerAdapter(Context context){
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.customized_recyclerview, parent, false);
        return new ViewHolder(itemView,this);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Company company = items.get(position);
        holder.setItem(company);
        holder.setDescription(company);
        holder.setCompanyImage(company);
    }

    public void addItem(Company item){
        items.add(item);
    }

    public Company getItem(int position){
        return items.get(position);
    }

    public void setOnItemClicklistener(OnItemClickListener listener){ this.listener = listener; }

    @Override
    public void onItemClick(ViewHolder holder, View view, int position) {
        if(listener != null){
            listener.onItemClick(holder,view,position);
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView company_name;
        TextView description;
        ImageView company_image;

        public ViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);

            company_name = itemView.findViewById(R.id.recyclerviewCompanyName);
            description = itemView.findViewById(R.id.description);
            company_image = itemView.findViewById(R.id.recyclerviewCompanyImage);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if(listener != null){
                        listener.onItemClick(ViewHolder.this,v,position);
                    }
                }
            });
        }

        public void setItem(Company company){
            company_name.setText(company.getCompany_name());
        }
        public void setDescription(Company company){description.setText(company.getEvent_title());}
        public void setCompanyImage(Company company){
            Glide.with(itemView).load(company.getImage()).into(company_image);
        }

    }

}
