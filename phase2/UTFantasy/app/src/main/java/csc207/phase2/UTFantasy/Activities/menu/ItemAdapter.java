package csc207.phase2.UTFantasy.Activities.menu;

import android.annotation.SuppressLint;
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

import csc207.phase2.UTFantasy.Pet.Pokemon;
import csc207.phase2.UTFantasy.Products.Product;
import csc207.phase2.UTFantasy.R;

public class ItemAdapter extends BaseAdapter {
  /** the type of the adapter */
  private String type;
  /** the list of pokemon */
  private List<Pokemon> pokemonList;
  /** the list of product */
  private List<Product> productList = new ArrayList<>();
  /** the hashmap of the product */
  private HashMap<Product, Integer> productHashMap;
  /** the inflater */
  private LayoutInflater inflater;

  /**
   * The constructor for the pokemon
   *
   * @param activity the activity
   * @param pokemonList the pokemon list of the player
   */
  public ItemAdapter(Activity activity, List<Pokemon> pokemonList) {
    this.pokemonList = pokemonList;
    this.type = "pokemon";
    inflater = activity.getLayoutInflater();
  }

  /**
   * The constructor for the product
   *
   * @param activity the activity
   * @param productList the product list of the player
   */
  public ItemAdapter(Activity activity, HashMap<Product, Integer> productList) {
    this.productHashMap = productList;
    this.type = "potion";
    inflater = activity.getLayoutInflater();
  }

  @Override
  public int getCount() {
    if (this.type.equals("pokemon")) {
      return pokemonList.size();
    } else {
      return productHashMap.size();
    }
  }

  @Override
  public Object getItem(int position) {
    return position;
  }

  @Override
  public long getItemId(int position) {
    return position;
  }

  @SuppressLint("SetTextI18n")
  @Override
  public View getView(int position, View view, ViewGroup viewGroup) {

    ViewHolder holder;
    // set up the list view
    if (view == null) {
      view = inflater.inflate(R.layout.pokemon_layout, viewGroup, false);
      holder = new ViewHolder();

      holder.imageView = view.findViewById(R.id.pokemonimage);
      holder.pokeName = view.findViewById(R.id.pokemonname);
      holder.pokeInfo = view.findViewById(R.id.pokemoninfo);

      view.setTag(holder);
    } else holder = (ViewHolder) view.getTag();

    if (this.type.equals("pokemon")) {
      Pokemon pokemon = pokemonList.get(position);
      holder.imageView.setImageResource(pokemon.getProfileID());
      holder.pokeInfo.setText(pokemon.toString());
      holder.pokeName.setText(pokemon.getPokemonName());
    } else {
      productList.addAll(productHashMap.keySet());
      Product product = productList.get(position);
      holder.imageView.setImageResource(product.getProfile_id());
      holder.pokeInfo.setText(product.toString() + "\n" + "Num: " + productHashMap.get(product));
      holder.pokeName.setText(product.getName());
    }
    return view;
  }

  /**
   * update the pokemon list after each select action
   *
   * @param pokemonList the pokemon list
   */
  void updateRecords(List<Pokemon> pokemonList) {
    this.pokemonList = pokemonList;
    notifyDataSetChanged();
  }

  class ViewHolder {
    ImageView imageView;
    TextView pokeName;
    TextView pokeInfo;
  }
}
