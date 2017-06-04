package com.summercoder.users;
/**
 * use to get users perference regarding the app
 * @author Jose Gonzalez
 *
 */
public interface IPreferences {

    boolean muteApplication(boolean mute);
    boolean hasFunFact(boolean fact);
    boolean allowCrashInfo(boolean crash);
    boolean autoSendITemScores(boolean score);


}
