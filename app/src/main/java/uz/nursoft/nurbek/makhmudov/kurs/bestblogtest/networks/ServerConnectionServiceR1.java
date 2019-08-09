package uz.nursoft.nurbek.makhmudov.kurs.bestblogtest.networks;

import retrofit.RestAdapter;
import uz.nursoft.nurbek.makhmudov.kurs.bestblogtest.iface.ServerApiR1;

/**
 * Created by Nurbek Makhmudov on 29.07.2019
 */

public class ServerConnectionServiceR1 {

    private static ServerConnectionServiceR1 instance;

    private static final String BASE_URL = "http://nurbek.zzz.com.ua/";

    private RestAdapter restAdapter;

    public static ServerConnectionServiceR1 getInstance() {
        if (instance == null) {
            instance = new ServerConnectionServiceR1();
        }
        return instance;
    }

    public ServerConnectionServiceR1() {
        if (restAdapter == null) {
            restAdapter = new RestAdapter.Builder()
                    .setEndpoint(BASE_URL)
                    .build();
        }
    }

    public ServerApiR1 getServerApiR1() {
        return restAdapter.create(ServerApiR1.class);
    }

}
