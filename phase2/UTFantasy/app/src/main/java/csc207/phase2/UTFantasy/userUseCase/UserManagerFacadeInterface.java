package csc207.phase2.UTFantasy.userUseCase;

import java.util.List;

import csc207.phase2.UTFantasy.Character.Player;

/**
 * A Facade that include all user use case methods.
 */
public interface UserManagerFacadeInterface {

    /**
     * Login the user by username and password.
     *
     * @param username username typed in.
     * @param password user password typed in
     * @return a User instance if logged in successfully, otherwise null.
     */
    User login(String username, String password);

    /**
     * Register the user by username and password.
     *
     * @param username username typed in.
     * @param password user password typed in
     * @return a User instance.
     */
    User register(String username, String password);

    /**
     * Get a User instance according to username.
     *
     * @param username the requested username
     * @return a User instance according to username, if the user does not exist, return null.
     */
    User getUser(String username);

    /**
     * Save all user data to local file use the activity that create this UserManagerFacade.
     */
    void saveUserData();

    /**
     * Get all user data stored locally from local file use the activity that create this
     * UserManagerFacade.
     */
    void loadUserData();

    /**
     * Check if the User existed according to username.
     *
     * @param username the username requested
     * @return true if existed, false if not.
     */
    boolean isUserExisted(String username);

    /**
     * Get Score Board Player List. The list only contains players that want to show their scores.
     *
     * @return Score Board Player List.
     */
    List<Player> getScoreBoardPlayerList();
}
