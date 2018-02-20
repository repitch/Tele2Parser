package com.repitch.tele2parser;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.common.collect.FluentIterable;
import com.repitch.tele2parser.api.entity.NumberItem;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by repitch on 20.02.2018.
 */
public class NumberAdapter extends RecyclerView.Adapter<NumberAdapter.ViewHolder> {

    private List<NumberItem> originNumbers = new ArrayList<>();
    private List<NumberItem> numbers = new ArrayList<>();
    private String query;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_number, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        NumberItem item = numbers.get(position);
        holder.txtNumber.setText(Long.toString(item.getFullNumber()));
    }

    @Override
    public int getItemCount() {
        return numbers.size();
    }

    public void setNumbers(List<NumberItem> numbers) {
        this.originNumbers = numbers;
        filter();
        notifyDataSetChanged();
    }

    public void setSearchQuery(String query) {
        this.query = query;
        filter();
        notifyDataSetChanged();
    }

    private void filter() {
        if (TextUtils.isEmpty(query)) {
            numbers = new ArrayList<>(originNumbers);
        } else {
            numbers = FluentIterable.from(originNumbers)
                    .filter(number -> {
                        String str = Long.toString(number.getFullNumber());
                        return StringUtils.containsIgnoreCase(str, query);
                    }).toList();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final TextView txtNumber;

        public ViewHolder(View itemView) {
            super(itemView);
            txtNumber = itemView.findViewById(R.id.txtNumber);
        }
    }
}
