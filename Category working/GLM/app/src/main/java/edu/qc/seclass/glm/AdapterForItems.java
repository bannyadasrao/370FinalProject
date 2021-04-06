package edu.qc.seclass.glm;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterForItems extends RecyclerView.Adapter<AdapterForItems.ItemViewHolder> {

    private Context mContext;
    private Cursor mCursor;

    public AdapterForItems(Context context, Cursor cursor){
        mContext = context;
        mCursor = cursor;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        public TextView nameText;
        public TextView countText;
//        public CheckBox checkbox;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            nameText = itemView.findViewById(R.id.textview_name_item);
            countText = itemView.findViewById(R.id.textview_amount_item);
//            checkbox = itemView.findViewById(R.id.textview_checkbox_item);
        }
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.activity_item_checkbox_quantity,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        if(!mCursor.moveToPosition(position)){
            return;
        }

        String name = mCursor.getString(mCursor.getColumnIndex(GroceryContract.GroceryEntry.COLUMN_NAME));
        int amount = mCursor.getInt(mCursor.getColumnIndex(GroceryContract.GroceryEntry.COLUMN_AMOUNT));

        holder.nameText.setText(name);
        holder.countText.setText(String.valueOf(amount));
    }

    @Override
    public int getItemCount() {
        return mCursor.getCount();
    }

    public void swapCursor(Cursor newCursor){
        if(mCursor != null){
            mCursor.close();
        }

        mCursor = newCursor;
        if(newCursor != null){
            notifyDataSetChanged();
        }
    }

}





















