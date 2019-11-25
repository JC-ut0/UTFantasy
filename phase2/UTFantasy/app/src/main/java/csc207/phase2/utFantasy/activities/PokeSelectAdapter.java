package csc207.phase2.utFantasy.activities;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import csc207.phase2.utFantasy.pet.Pokemon;
import csc207.phase2.utFantasy.R;

public class PokeSelectAdapter extends BaseAdapter {
  Activity activity;
  List<Pokemon> pokemonList;
  List<Pokemon> selectedPokemon = new ArrayList<>();
  LayoutInflater inflater;

  public PokeSelectAdapter(Activity activity, List<Pokemon> pokemonList) {
    this.activity = activity;
    this.pokemonList = pokemonList;
    inflater = activity.getLayoutInflater();
  }

  @Override
  public int getCount() {
    return pokemonList.size();
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
      view = inflater.inflate(R.layout.pokeselect_layout, viewGroup, false);
      holder = new ViewHolder();

      holder.pokemonname = view.findViewById(R.id.pokemonname2);
      holder.checkimage = view.findViewById(R.id.checkbox);
      holder.pokemonImage = view.findViewById(R.id.pokemonimage2);
      holder.level = view.findViewById(R.id.level);

      view.setTag(holder);
    } else holder = (ViewHolder) view.getTag();
    Pokemon pokemon = pokemonList.get(position);

    holder.pokemonname.setText(pokemon.getPokemonName());
    holder.level.setText(String.valueOf(pokemon.getLevel()) + "LV");
    holder.pokemonImage.setImageResource(pokemon.getProfileID());

    if (selectedPokemon.contains(pokemon))
      holder.checkimage.setBackgroundResource(R.drawable.checked);
    else holder.checkimage.setBackgroundResource(R.drawable.check);
    return view;
  }

  public void updateRecords(List<Pokemon> pokemonList, List<Pokemon> selectedPokemon) {
    this.pokemonList = pokemonList;
    this.selectedPokemon = selectedPokemon;
    notifyDataSetChanged();
  }

  class ViewHolder {
    TextView level;
    TextView pokemonname;
    TextView hp;
    ImageView checkimage;
    ImageView pokemonImage;
  }
}
