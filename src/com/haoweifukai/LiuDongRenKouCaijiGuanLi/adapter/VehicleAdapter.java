/**
 * @author LuYongXing
 * @date 2014.09.28
 * @filename VehicleAdapter.java
 */

package com.haoweifukai.LiuDongRenKouCaijiGuanLi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.haoweifukai.LiuDongRenKouCaijiGuanLi.R;
import com.haoweifukai.LiuDongRenKouCaijiGuanLi.data.VehicleData;

import java.util.ArrayList;

/**
 * 流动人口适配器
 */
public class VehicleAdapter extends ArrayAdapter<VehicleData> {

    private ArrayList<VehicleData> mValues;
    private LayoutInflater mLayoutInflater;

    public VehicleAdapter(Context context, ArrayList<VehicleData> values) {
        super(context, R.layout.list_vehicle_item, values);

        mValues = values;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View rowView = convertView;

        if (rowView == null) {
            ViewHolder viewHolder = new ViewHolder();
            rowView = mLayoutInflater.inflate(R.layout.list_vehicle_item, parent, false);

            if (rowView == null) {
                throw new IllegalArgumentException("Can not inflate using R.layout.list_rent_room_item");
            }

            viewHolder.textNo = (TextView) rowView.findViewById(R.id.text_no);
            viewHolder.textNumber = (TextView) rowView.findViewById(R.id.text_number);
            viewHolder.textColor = (TextView) rowView.findViewById(R.id.text_color);
            viewHolder.textType = (TextView) rowView.findViewById(R.id.text_type);
            viewHolder.textAddress = (TextView) rowView.findViewById(R.id.text_address);

            rowView.setTag(viewHolder);
        }

        ViewHolder viewHolder = (ViewHolder) rowView.getTag();
        VehicleData data = mValues.get(position);

        // 序号
        viewHolder.textNo.setText(String.valueOf(data.no));
        // 车牌照
        viewHolder.textNumber.setText(data.number);
        // 车身颜色
        viewHolder.textColor.setText(data.color);
        // 车辆类型
        viewHolder.textType.setText(data.type);
        // 现住地详细地址
        viewHolder.textAddress.setText(data.address);

        return rowView;
    }

    private class ViewHolder {
        public TextView textNo;
        public TextView textNumber;
        public TextView textColor;
        public TextView textType;
        public TextView textAddress;
    }

}
