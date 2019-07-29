package uz.nursoft.nurbek.makhmudov.kurs.bestblogtest.pref;

/**
 * Created by Nurbek Makhmudov on 29.07.2019
 */

public class Pref {

    private static Pref INSTANCE;

    public static Pref getINSTANCE() {
        if (INSTANCE == null) INSTANCE = new Pref();
        return INSTANCE;
    }

    public Pref() {
    }

}
