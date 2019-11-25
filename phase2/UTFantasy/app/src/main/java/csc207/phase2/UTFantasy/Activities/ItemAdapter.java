package csc207.phase2.UTFantasy.Activities;

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
  String type;
  Activity activity;
  List<Pokemon> pokemonList;
  List<Product> productList = new ArrayList<>();
  HashMap<Product, Integer> productHashMap;
  LayoutInflater inflater;

  public ItemAdapter(Activity activity, List<Pokemon> pokemonList) {
    this.activity = activity;
    this.pokemonList = pokemonList;
    this.type = "pokemon";
    inflater = activity.getLayoutInflater();
  }

  public ItemAdapter(Activity activity, HashMap<Product, Integer> productList) {
    this.productHashMap = productList;
    this.activity = activity;
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

  @Override
  public View getView(int position, View view, ViewGroup viewGroup) {

    ViewHolder holder = null;
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

  class ViewHolder {
    ImageView imageView;
    TextView pokeName;
    TextView pokeInfo;
  }
}