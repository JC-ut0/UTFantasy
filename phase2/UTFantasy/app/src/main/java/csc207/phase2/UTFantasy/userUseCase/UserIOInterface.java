package csc207.phase2.UTFantasy.userUseCase;

import android.content.Context;

/** A Singleton class to manage UserData. Will be initialized in the StartUp activity. */
public interface UserIOInterface {

  /**
   * return UserData.
   *
   * @return UserData.
   */
  UserData getUserData();

  /**
   * Save UserData to local.
   *
   * @param context the Activity(Context) that calls this method.
   */
  void saveUserData(Context context);

  /**
   * Load UserData from local.
   *
   * @param context the Activity(Context) that calls this method.
   */
  void loadUserData(Context context);
}
