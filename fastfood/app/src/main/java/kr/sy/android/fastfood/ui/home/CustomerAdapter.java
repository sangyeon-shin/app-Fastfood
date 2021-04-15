package kr.sy.android.fastfood.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import kr.sy.android.fastfood.R;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.ViewHolder> implements onItemClickListener{

    Context context;
    ArrayList<Company> items = new ArrayList<Company>();
    onItemClickListener listener;

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
        View itemView = inflater.inflate(R.layout.customzied_listview, parent, false);
        return new ViewHolder(itemView,this);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Company item = items.get(position);
        holder.setItem(item);
    }

    public void addItem(Company item){
        items.add(item);
    }

    public Company getItem(int position){
        return items.get(position);
    }

    public void setOnItemClicklistener(onItemClickListener listener){ this.listener = listener; }

    @Override
    public void onItemClick(ViewHolder holder, View view, int position) {
        if(listener != null){
            listener.onItemClick(holder,view,position);
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView company_name;

        public ViewHolder(@NonNull View itemView,onItemClickListener listener) {
            super(itemView);

            company_name = itemView.findViewById(R.id.listViewCompanyName);

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

        public void setItem(Company item){
            company_name.setText(item.getCompany_name());
        }
    }

}
