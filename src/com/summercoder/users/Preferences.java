package com.summercoder.users;

/**
 * Created by elminino on 6/3/17.
 */
public class Preferences implements  IPreferences {
    @Override
    public boolean muteApplication(boolean mute) {
        return false;
    }

    @Override
    public boolean hasFunFact(boolean fact) {
        return false;
    }

    @Override
    public boolean allowCrashInfo(boolean crash) {
        return false;
    }

    @Override
    public boolean autoSendITemScores(boolean score) {
        return false;
    }
}
