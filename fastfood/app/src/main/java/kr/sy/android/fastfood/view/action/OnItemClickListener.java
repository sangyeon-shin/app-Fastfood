package kr.sy.android.fastfood.view.action;

import android.view.View;

import kr.sy.android.fastfood.view.adapter.CustomerAdapter;

public interface OnItemClickListener {
    public void onItemClick(CustomerAdapter.ViewHolder holder, View view, int position);
}
