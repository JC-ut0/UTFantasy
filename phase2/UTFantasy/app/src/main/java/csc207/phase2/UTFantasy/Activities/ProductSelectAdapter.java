package csc207.phase2.UTFantasy.Activities;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import csc207.phase2.UTFantasy.Products.Product;
import csc207.phase2.UTFantasy.R;

public class ProductSelectAdapter extends BaseAdapter {
  /** the product list */
  private List<Product> productList = new ArrayList<>();
  /** the selected list of product */
  private List<Product> selectedList = new ArrayList<>();
  /** the hashmap of the product */
  private HashMap<Product, Integer> productHashMap;
  /** the inflater of the product */
  private LayoutInflater inflater;

  ProductSelectAdapter(Activity activity, HashMap<Product, Integer> productHashMap) {
    this.productHashMap = productHashMap;
    productList.addAll(productHashMap.keySet());
    inflater = activity.getLayoutInflater();
  }

  @Override
  public int getCount() {
    return productList.size();
  }

  @Override
  public Object getItem(int position) {
    return position;
  }

  @Override
  public long getItemId(int position) {
    return position;
  }

  @Override
  public View getView(int position, View view, ViewGroup viewGroup) {
    ViewHolder holder = null;
    // set up the view of the listview
    if (view == null) {
      view = inflater.inflate(R.layout.productselect_layout, viewGroup, false);
      holder = new ViewHolder();

      holder.potionname = view.findViewById(R.id.productName2);
      holder.checkimage = view.findViewById(R.id.checkbox);
      holder.potionImage = view.findViewById(R.id.productImage2);
      holder.level = view.findViewById(R.id.level);

      view.setTag(holder);
    } else holder = (ViewHolder) view.getTag();
    Product product = productList.get(position);

    holder.potionname.setText(product.getName());
    holder.level.setText("NUM: " + productHashMap.get(product));
    holder.potionImage.setImageResource(product.getProfile_id());

    if (selectedList.contains(product)) holder.checkimage.setBackgroundResource(R.drawable.checked);
    else holder.checkimage.setBackgroundResource(R.drawable.check);
    return view;
  }

  /**
   * Update the new selected list after each select by the player
   *
   * @param productList the product list
   * @param selectedList the new selected list of the player
   */
  void updateRecords(List<Product> productList, List<Product> selectedList) {
    this.productList = productList;
    this.selectedList = selectedList;
    notifyDataSetChanged();
  }

  class ViewHolder {
    TextView level;
    TextView potionname;
    ImageView checkimage;
    ImageView potionImage;
  }
}
