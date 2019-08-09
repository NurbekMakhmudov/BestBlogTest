package uz.nursoft.nurbek.makhmudov.kurs.bestblogtest.iface;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Created by Nurbek Makhmudov on 29.07.2019
 */
public interface ServerApiR1 {

    @FormUrlEncoded
    @POST("/test/test.php")
    void test(
            @Field("title") String title,
            @Field("desc") String desc,
            Callback<Response> responseCallback
    );

    /*************************************************************************************************************
     * reg
     */
    @FormUrlEncoded
    @POST("/best-blog/api/registration.php")
    void registration(
            @Field("username") String username,
            @Field("pass") String pass,
            Callback<Response> responseCallback
    );


}
