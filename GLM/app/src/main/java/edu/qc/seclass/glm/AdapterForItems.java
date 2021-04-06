package edu.qc.seclass.glm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterForItems extends RecyclerView.Adapter<AdapterForItems.ViewHolder> {

    List<ItemsModal> items;
    Context context;
    DBHelpeForCheckboxAndQuantity dbHelpeForCheckboxAndQuantity;

    public AdapterForItems(List<ItemsModal> items, Context context) {
        this.items = items;
        this.context = context;
        dbHelpeForCheckboxAndQuantity = new DBHelpeForCheckboxAndQuantity(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.activity_item_checkbox_quantity,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ItemsModal itemsModal = items.get(position);

        holder.textview_name_item.setText(itemsModal.getItemName());
        holder.textview_amount_item.setText(itemsModal.getAmountOfQuantity());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        CheckBox checkbox_item;
        TextView textview_name_item;
        TextView textview_amount_item;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            checkbox_item = itemView.findViewById(R.id.checkbox_item);
            textview_name_item = itemView.findViewById(R.id.textview_name_item);
            textview_amount_item = itemView.findViewById(R.id.textview_amount_item);

        }
    }
}
