package uz.nursoft.nurbek.makhmudov.kurs.bestblogtest.shp;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Nurbek Makhmudov on 29.07.2019
 */
public class ShP {

    private static SharedPreferences PREF;
    private static SharedPreferences.Editor EDITOR;
    private static Context CONTEXT;

    private static final String SHP = "SHP";

    private static final String FIRST_TIME_LAUNCH = "FIRST_TIME_LAUNCH";
    private static final String LANG = "LANG";

    private static final String SERVER_REG = "SERVER_REG";

    //when fragment no need to back exit application
    private static final String BACK_PRESSED = "BACK_PRESSED";

    private static ShP INSTANCE;

    public static ShP getInstance(Context nCONTEXT) {
        if (INSTANCE == null) INSTANCE = new ShP(nCONTEXT);
        return INSTANCE;
    }

    public ShP(Context nCONTEXT) {
        this.CONTEXT = nCONTEXT;
        PREF = CONTEXT.getSharedPreferences(SHP, Context.MODE_PRIVATE);
        EDITOR = PREF.edit();
    }

    /*************************************************************************************************************
     *  REG
     */
    public void setServerReg(boolean isReg){
        EDITOR.putBoolean(SERVER_REG, isReg).commit();
    }

    public boolean isServerReg(){
        return PREF.getBoolean(SERVER_REG, false);
    }


    /*************************************************************************************************************
     * App Lang
     */
    public void setLang(String sLang) {
        EDITOR.putString(LANG, sLang).commit();
    }

    public String getLang() {
        return PREF.getString(LANG, "");
    }

    /*************************************************************************************************************
     *  First Time Launch
     */
    public void setFirstTimeLaunch(boolean isFirstTime) {
        EDITOR.putBoolean(FIRST_TIME_LAUNCH, isFirstTime).commit();
    }

    public boolean isFirstTimeLaunch() {
        return PREF.getBoolean(FIRST_TIME_LAUNCH, true);
    }

    /*************************************************************************************************************
     * when fragment no need to back exit application
     */
    public void setBackPressed(boolean isBackPressed) {
        EDITOR.putBoolean(BACK_PRESSED, isBackPressed).commit();
    }

    public boolean isBackPressed() {
        return PREF.getBoolean(BACK_PRESSED, true);
    }


}
