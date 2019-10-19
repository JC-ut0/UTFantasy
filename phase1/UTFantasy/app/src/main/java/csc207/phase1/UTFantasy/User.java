package csc207.phase1.UTFantasy;

import android.os.Parcel;
import android.os.Parcelable;

import csc207.phase1.UTFantasy.Character.Player;

public class User implements Parcelable {

    private String name;
    private String password;
    private Player player;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    private int mData;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(mData);
    }

    public static final Parcelable.Creator<User> CREATOR
            = new Parcelable.Creator<User>() {
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        public User[] newArray(int size) {
            return new User[size];
        }
    };

    private User(Parcel in) {
        mData = in.readInt();
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Player getPlayer() {
        return player;
    }
}
