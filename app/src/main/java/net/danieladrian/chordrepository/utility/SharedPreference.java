package net.danieladrian.chordrepository.utility;

import android.content.Context;

/**
 * Created by Daniel Adrian on 22/01/2018.
 */

public class SharedPreference {
    private static final String INITIALIZED = "INITIALIZED";
    private static final String DEVELOPMENT = "DEVELOPMENT";
    private static final String ACCESS_TOKEN = "ACCESS_TOKEN";
    private static final String USERID = "USERID";
    private static final String NAME = "NAME";
    private static final String PROFILE_PICTURE = "PROFILE_PICTURE";
    private static final String EMAIL = "EMAIL";

    android.content.SharedPreferences sPref;
    private static final String myPref = "ChordRepo";
    android.content.SharedPreferences.Editor ed;
    Context mContext;

    public SharedPreference(Context mContext) {
        this.mContext = mContext;
        sPref = mContext.getSharedPreferences(myPref, Context.MODE_PRIVATE);
        ed = sPref.edit();
        ed.apply();
    }

    public void defaultConfig() {

    }

    public boolean getInitialized() {
        if (sPref.contains(INITIALIZED)) {
            return true;
        } else {
            return false;
        }
    }

    public void setInitialized() {
        ed.putBoolean(INITIALIZED, true);
        ed.commit();
    }

    public void setAccessToken(String token) {
        ed.putString(ACCESS_TOKEN, token);
        ed.commit();
    }

    public String getAccessToken() {
        return sPref.getString(ACCESS_TOKEN,"");
    }

    public void setUserID(String id) {
        ed.putString(USERID, id);
        ed.commit();
    }

    public String getUserID() {
        return sPref.getString(USERID,"");
    }

    public void setName(String name) {
        ed.putString(NAME, name);
        ed.commit();
    }

    public String getName() {
        return sPref.getString(NAME,"");
    }

    public void setProfilePicture(String url) {
        ed.putString(PROFILE_PICTURE, url);
        ed.commit();
    }

    public String getProfilePicture() {
        return sPref.getString(PROFILE_PICTURE,"");
    }

    public void setEmail(String email) {
        ed.putString(EMAIL, email);
        ed.commit();
    }

    public String getEmail() {
        return sPref.getString(EMAIL,"");
    }

    public boolean getDevelopment() {
        return sPref.getBoolean(DEVELOPMENT,false);
    }

    public void setDevelopment(Boolean b) {
        ed.putBoolean(DEVELOPMENT,b);
        ed.commit();
    }
}
