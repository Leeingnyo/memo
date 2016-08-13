package me.leeingnyo.memo;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MemoAdapter extends RecyclerView.Adapter<MemoAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Memo> list;

    public MemoAdapter(Context context){
        this.context = context;
        this.list = new ArrayList<>();
    }
    public void setData(ArrayList<Memo> list){
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_memo, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Memo memo = list.get(position);
        final String memoTitle = memo.getTitle();
        final String memoDate = memo.getDate();
        final String info = memoTitle + " " + memoDate;
        SpannableString spannableString = new SpannableString(info);
        spannableString.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), 0, memoTitle.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new RelativeSizeSpan(0.8f), memoTitle.length() + 1, info.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        holder.titleView.setText(spannableString);
        // fixme on click whole view
        holder.titleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ViewActivity.class);
                intent.putExtra("memo", (Parcelable)memo);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleView;

        public ViewHolder(View itemView) {
            super(itemView);

            titleView = (TextView)itemView.findViewById(R.id.memo);
        }
    }
}
