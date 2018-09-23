package com.hojong.meokgol.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.hojong.meokgol.R;
import com.hojong.meokgol.activity.ShopActivity;
import com.hojong.meokgol.data_model.Shop;

import java.util.ArrayList;
import java.util.List;

public class ShopListAdapter extends BaseAdapter implements AdapterView.OnItemClickListener
{
	private List<Shop> shopDataList = new ArrayList<>();


	@Override
	public int getCount() {
		return shopDataList.size() ;
	}

	@Override
	public View getView(int position, View shopView, ViewGroup parent) {
		final Context context = parent.getContext();

		// "listview_item" Layout을 inflate하여 convertView 참조 획득.
		if (shopView == null) {
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			shopView = inflater.inflate(R.layout.layout_shop_list_item, parent, false);
		}

		Shop shop = shopDataList.get(position);

		// shop bmp
		ImageView shopImageView = shopView.findViewById(R.id.shop_img);
		shopImageView.setImageBitmap(shop.bmp);
		// shop name
		TextView shopNameView = shopView.findViewById(R.id.shop_name);
		shopNameView.setText(shop.shop_name);
		// TODO : shop score (lazy)
        // TODO : review count (lazy)
		// click listener
		ImageButton shopFavoriteBtn = shopView.findViewById(R.id.favorite_btn);
		shopFavoriteBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Log.d(this.toString(), "onClick");
			}
		});

		return shopView;
	}

	@Override
	public long getItemId(int position) {
		return position ;
	}
	
	@Override
	public Object getItem(int position) {
		return shopDataList.get(position) ;
	}

	public void addItem(Shop shop) {
		shopDataList.add(shop);
	}

	public void clear()
    {
        shopDataList.clear();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Context context = adapterView.getContext();
        Intent intent = new Intent(context, ShopActivity.class);
        Shop shop = shopDataList.get(i);
        intent.putExtra("shopIdx", shop.shop_idx);
        intent.putExtra("shopImg", shop.shop_img);
        intent.putExtra("shopInfo", shop.shop_info);
        context.startActivity(intent);
    }
}
