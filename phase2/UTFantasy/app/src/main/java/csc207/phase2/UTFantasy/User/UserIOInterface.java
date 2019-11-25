package csc207.phase2.UTFantasy.User;

import android.content.Context;

public interface UserIOInterface {
  void saveUserData(Context context);

  void loadUserData(Context context);

  UserData getUserData();
}
