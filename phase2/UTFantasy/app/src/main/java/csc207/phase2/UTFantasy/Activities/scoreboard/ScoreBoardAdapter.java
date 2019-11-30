package csc207.phase2.UTFantasy.Activities.scoreboard;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import csc207.phase2.UTFantasy.Character.Player;
import csc207.phase2.UTFantasy.R;

class ScoreBoardAdapter extends BaseAdapter {
  /** the lsit of player */
  private List<Player> playerList;
  /** the inflater */
  private LayoutInflater inflater;

  ScoreBoardAdapter(Activity activity, List<Player> playerList) {
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

  @SuppressLint("SetTextI18n")
  @Override
  public View getView(int position, View view, ViewGroup viewGroup) {
    //set up the view of the view list
    ViewHolder holder;
    if (view == null) {
      view = inflater.inflate(R.layout.scoreboard_layout, viewGroup, false);
      holder = new ViewHolder();

      holder.rank = view.findViewById(R.id.rank);
      holder.playerName = view.findViewById(R.id.playerName);
      holder.pokemonNum = view.findViewById(R.id.pokemonNum);
      holder.pokemonLV = view.findViewById(R.id.pokemonLV);

      view.setTag(holder);
    } else holder = (ViewHolder) view.getTag();

    Player player = playerList.get(position);
    holder.rank.setText(position + 1 + ". ");
    holder.playerName.setText(player.getName() + " (" + player.getGender() + ")");
    holder.pokemonNum.setText(player.getPokemonList().size() + "");
    holder.pokemonLV.setText(player.getPlayerPokemonMaxLV() + "");

    return view;
  }

  class ViewHolder {
    TextView playerName;
    TextView pokemonNum;
    TextView pokemonLV;
    TextView rank;
  }
}
