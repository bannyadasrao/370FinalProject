package edu.qc.seclass.glm;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterForItems extends RecyclerView.Adapter<AdapterForItems.ViewHolder> {

    List<ItemsModal> items;
    Context context;
    DBHelpeForCheckboxAndQuantity dbHelpeForCheckboxAndQuantity;

    private static  final String TAG = "AdapterForItems";

    public AdapterForItems(List<ItemsModal> items, Context context) {
        this.items = items;
        this.context = context;
        dbHelpeForCheckboxAndQuantity = new DBHelpeForCheckboxAndQuantity(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_item_checkbox_quantity,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final ItemsModal itemsModal = items.get(position);
        holder.textview_name_item.setText(itemsModal.getItemName());
        holder.textview_amount_item.setText(itemsModal.getAmountOfQuantity());

        holder.editQuantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(context,itemsModal.getItemName()+ " will be update" ,Toast.LENGTH_SHORT).show();
//                Log.d(TAG,"clicked" + itemsModal.getItemName());

                Intent update = new Intent(context, UpdateQuantity.class);
                update.putExtra("QUANTITY",itemsModal);
                context.startActivity(update);

            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        CheckBox checkbox_item;
        TextView textview_name_item;
        TextView textview_amount_item;
        ImageButton editQuantity;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            checkbox_item = itemView.findViewById(R.id.checkbox_item);
            textview_name_item = itemView.findViewById(R.id.textview_name_item);
            textview_amount_item = itemView.findViewById(R.id.textview_amount_item);

            editQuantity = itemView.findViewById(R.id.editQuantity);
        }
    }
}
