package uz.nursoft.nurbek.makhmudov.kurs.bestblogtest.retmet;

import android.content.Context;
import android.net.ConnectivityManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

public class RetMet {

    private static Context context;
    private static RetMet instance;

    public static RetMet getInstance(Context nContext) {
        if (instance == null) instance = new RetMet(nContext);
        return instance;
    }

    public RetMet(Context context) {
        this.context = context;
    }

    /*************************************************************************************************************
     * Replace Fragment
     */
    public void replaceFragment(FragmentManager fragmentManager, Fragment fragment, int container) {
        fragmentManager.beginTransaction().replace(container, fragment)
                .addToBackStack(null).commitAllowingStateLoss();
    }

    /*************************************************************************************************************
     * check internet connection
     */
    public boolean checkInternetConnection() {
        // get Connectivity Manager object to check connection
        ConnectivityManager connect
                = (ConnectivityManager) context.getSystemService(context.CONNECTIVITY_SERVICE);

        // Check for network connections
        if (connect.getNetworkInfo(0).getState() ==
                android.net.NetworkInfo.State.CONNECTED ||
                connect.getNetworkInfo(0).getState() ==
                        android.net.NetworkInfo.State.CONNECTING ||
                connect.getNetworkInfo(1).getState() ==
                        android.net.NetworkInfo.State.CONNECTING ||
                connect.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.CONNECTED) {
            return true;
        } else if (
                connect.getNetworkInfo(0).getState() ==
                        android.net.NetworkInfo.State.DISCONNECTED ||
                        connect.getNetworkInfo(1).getState() ==
                                android.net.NetworkInfo.State.DISCONNECTED) {
            return false;
        }
        return false;
    }

    public AlertDialog.Builder alertDialogBuilder(String sTitleUssd, String sMsgDesc) {
        AlertDialog.Builder nBuilder = new AlertDialog.Builder(context);
        nBuilder.setTitle(sTitleUssd);
        nBuilder.setMessage(sMsgDesc);
        return nBuilder;
    }

    /*************************************************************************************************************
     * Toast
     */
    public void toast(int massageId, int length) {
        if (length == 1)
            Toast.makeText(context, context.getResources().getString(massageId), Toast.LENGTH_SHORT).show();

        if (length == 2)
            Toast.makeText(context, context.getResources().getString(massageId), Toast.LENGTH_LONG).show();
    }


}
