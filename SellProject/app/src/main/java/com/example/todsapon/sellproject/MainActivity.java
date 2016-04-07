package com.example.todsapon.sellproject;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lv_product;
    private MyDBHelper mHelper;
    private SQLiteDatabase mDb;
    private Cursor mCursor;
    TextView txt_sum, txt_amount;


    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv_product = (ListView) findViewById(R.id.lv_item);
        txt_sum = (TextView) findViewById(R.id.txt_sum);
        txt_amount = (TextView) findViewById(R.id.txt_amount);

        lv_product.setAdapter(new ProductAdapter(getApplicationContext(), ProductItems()));

        ProductAdapter objSumPrice = new ProductAdapter(getApplicationContext());
        objSumPrice.getTextSumPrice(txt_sum);
        objSumPrice.getTextAmount(txt_amount);


    }


    public List<ProductItems> ProductItems() {

        mHelper = new MyDBHelper(getApplicationContext());
        mDb = mHelper.getReadableDatabase();
        mCursor = mDb.rawQuery("SELECT  * FROM " + MyDBHelper.TABLE_PRODUCT + ";", null);
        List<ProductItems> mProductItems = new ArrayList<ProductItems>();
        mCursor.moveToFirst();
        while (!mCursor.isAfterLast()) {
            mProductItems.add(new ProductItems(mCursor.getString(mCursor.getColumnIndex(MyDBHelper.COL_PRODUCT_NAME)),
                    mCursor.getInt(mCursor.getColumnIndex(MyDBHelper.COL_PRICE))));
            mCursor.moveToNext();
        }
        return mProductItems;
    }


    static class ProductAdapter extends BaseAdapter {

        public Context mContext;
        public LayoutInflater mInflater;
        public List<ProductItems> mProductItems;
        static TextView txt_sum_price_in_main, txt_count_in_main;
        int sum_price = 0;

        public ProductAdapter(Context mContext) {
            this.mContext = mContext;
        }

        public ProductAdapter(Context mContext, List<ProductItems> mProductItems) {
            this.mContext = mContext;
            this.mProductItems = mProductItems;
            mInflater = LayoutInflater.from(mContext);
        }


        @Override
        public int getCount() {
            return mProductItems.size();
        }

        @Override
        public Object getItem(int position) {
            return mProductItems.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }


        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            final ViewHolder holder;
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.my_product_item, null);
                holder = new ViewHolder(convertView);
                convertView.setTag(holder);

            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.txt_name_product.setText(mProductItems.get(position).getNameProduct());
            holder.txt_count_in_list.setText(String.valueOf(mProductItems.get(position).getCount()));
            holder.txt_price_in_list.setText(String.valueOf(mProductItems.get(position).getPriceIn()));


            holder.btn_add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /*การนับจำนวน*/

                    int count = Integer.parseInt((String) holder.txt_count_in_list.getText());

                    if (count >= 0) {
                        count++;
                    }

                    mProductItems.get(position).setCount(count);
                    holder.txt_count_in_list.setText(String.valueOf(mProductItems.get(position).getCount()));

                    int count_ = Integer.parseInt((String) txt_count_in_main.getText());
                    count_ = count_ + 1;
                    txt_count_in_main.setText(String.valueOf(count_));

                    /*การคิดราคา*/
                    int price = mProductItems.get(position).getPrice() * mProductItems.get(position).getCount();
                    mProductItems.get(position).setPriceIn(price);
                    holder.txt_price_in_list.setText(String.valueOf(mProductItems.get(position).getPriceIn()));

                 /*   ViewGroup parent = (ViewGroup) v.getParent();
                    TextView txt_count_in_list = (TextView) parent.findViewById(R.id.txt_number_item);
                    TextView txt_price_in_list = (TextView) parent.findViewById(R.id.txt_price);

                    int count = Integer.parseInt((String) txt_count_in_list.getText());
                    count++;
                    txt_count_in_list.setText(String.valueOf(count));
                    String totalAmtString = String.valueOf(mProductItems.get(position).getPrice());
                    int totAmount = Integer.parseInt(totalAmtString);
                    tot_amt = totAmount * count;
                    txt_price_in_list.setText(String.valueOf(tot_amt));

                    int count_ = Integer.parseInt((String) txt_count_in_main.getText());
                    count_ = count_ + 1;
                    txt_count_in_main.setText(String.valueOf(count_));
                    mProductItems.get(position).setCount(count_);

                    int p = Integer.parseInt((String) txt_sum_price_in_main.getText());
                    p = p + mProductItems.get(position).getPrice();
                    mProductItems.get(position).setPrice2(p);
                    txt_sum_price_in_main.setText(String.valueOf(p));*/
                }
            });


            holder.btn_reduce.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /*การนับจำนวน*/
                    int count = Integer.parseInt((String) holder.txt_count_in_list.getText());
                    if (count >= 1) {
                        count--;
                    }
                    mProductItems.get(position).setCount(count);
                    holder.txt_count_in_list.setText(String.valueOf(mProductItems.get(position).getCount()));

                    int count_ = Integer.parseInt((String) txt_count_in_main.getText());
                    if (count_ >= 1) {
                        count_ = count_ - 1;
                    }
                    txt_count_in_main.setText(String.valueOf(count_));
                    /*การคิดราคา*/


                   /* ViewGroup parent = (ViewGroup) v.getParent();
                    TextView txt_count_in_list = (TextView) parent.findViewById(R.id.txt_number_item);
                    TextView txt_price_in_list = (TextView) parent.findViewById(R.id.txt_price);

                    String p = txt_price_in_list.getText().toString();
                    int count = Integer.parseInt((String) txt_count_in_list.getText());
                    if (count != 0) {
                        count--;
                        int price = Integer.parseInt(p);
                        price = price - mProductItems.get(position).getPrice();
                        txt_price_in_list.setText(String.valueOf(price));
                        int count_ = Integer.parseInt((String) txt_count_in_main.getText());

                        count_ = count_ - 1;
                        mProductItems.get(position).setCount(count_);
                        txt_count_in_main.setText(String.valueOf(count_));

                        int p1 = Integer.parseInt((String) txt_sum_price_in_main.getText());
                        p1 = p1 - mProductItems.get(position).getPrice();
                        mProductItems.get(position).setPrice2(p1);
                        txt_sum_price_in_main.setText(String.valueOf(p1));
                    }
                    txt_count_in_list.setText(String.valueOf(count));*/
                }
            });

            return convertView;
        }


        static TextView getTextAmount(TextView textView) {
            txt_count_in_main = textView;
            return txt_count_in_main;
        }

        static TextView getTextSumPrice(TextView textView) {
            txt_sum_price_in_main = textView;
            return txt_sum_price_in_main;
        }


        public class ViewHolder {
            public TextView txt_name_product, txt_count_in_list, txt_price_in_list;
            public Button btn_add, btn_reduce;

            public ViewHolder(View convertView) {
                txt_name_product = (TextView) convertView.findViewById(R.id.txt_name_item);
                btn_add = (Button) convertView.findViewById(R.id.btn_add);
                btn_reduce = (Button) convertView.findViewById(R.id.btn_reduce);

                txt_count_in_list = (TextView) convertView.findViewById(R.id.txt_number_item);
                txt_price_in_list = (TextView) convertView.findViewById(R.id.txt_price);

            }
        }

    }
}
