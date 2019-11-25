package csc207.phase2.UTFantasy.Activities;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import csc207.phase2.UTFantasy.Character.Player;
import csc207.phase2.UTFantasy.R;

public class ScoreBoardAdapter extends BaseAdapter {
  Activity activity;
  private List<Player> playerList;
  private LayoutInflater inflater;

  public ScoreBoardAdapter(Activity activity, List<Player> playerList) {
    this.activity = activity;
    this.playerList = playerList;
    inflater = activity.getLayoutInflater();
  }

  @Override
  public int getCount() {
    return playerList.size();
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
    ScoreBoardAdapter.ViewHolder holder = null;
    if (view == null) {
      view = inflater.inflate(R.layout.productselect_layout, viewGroup, false);
      holder = new ScoreBoardAdapter.ViewHolder();

      holder.rank = view.findViewById(R.id.rank);
      holder.playerName = view.findViewById(R.id.playerName);
      holder.pokemonNum = view.findViewById(R.id.pokemonNum);
      holder.pokemonLV = view.findViewById(R.id.pokemonLV);

      view.setTag(holder);
    } else holder = (ScoreBoardAdapter.ViewHolder) view.getTag();
    Player player = playerList.get(position);

    holder.rank.setText(position);
    holder.playerName.setText(player.getName() + " " + player.getGender());
    holder.pokemonNum.setText(player.getPokemonList().size());
    holder.pokemonLV.setText(player.getPlayerPokemonLV());

    return view;
  }

  class ViewHolder {
    TextView playerName;
    TextView pokemonNum;
    TextView pokemonLV;
    TextView rank;
  }
}
