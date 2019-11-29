package csc207.phase2.UTFantasy.Activities.ShopActivityMVP;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

import csc207.phase2.UTFantasy.Products.Product;
import csc207.phase2.UTFantasy.R;

public class ProductAdapter extends ArrayAdapter<Product> {
  /** resource of layout */
  private int layoutRes;

  private Context context;

  static class ViewHolder {
    TextView name;
    TextView price;
  }

  /**
   * Default constructor for the ProductAdapter.
   *
   * @param context context
   * @param res layout resource of this adaptor
   * @param products ArrayList of Products.
   */
  public ProductAdapter(Context context, int res, ArrayList<Product> products) {
    super(context, res, products);
    this.context = context;
    this.layoutRes = res;
  }

  /** return a view with information */
  @NonNull
  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    String name = getItem(position).getName();
    int price = getItem(position).getPrice();
    ViewHolder holder;

    if (convertView == null) {
      holder = new ViewHolder();
      LayoutInflater inflater = LayoutInflater.from(context);
      convertView = inflater.inflate(layoutRes, parent, false);
      holder.name = convertView.findViewById(R.id.productName);
      holder.price = convertView.findViewById(R.id.productPrice);
      convertView.setTag(holder);
    } else {
      holder = (ViewHolder) convertView.getTag();
    }

    holder.name.setText(name);
    String text = "$ " + price;
    holder.price.setText(text);

    return convertView;
  }
}
