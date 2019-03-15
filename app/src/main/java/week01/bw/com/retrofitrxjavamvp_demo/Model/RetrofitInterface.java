package week01.bw.com.retrofitrxjavamvp_demo.Model;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;
import week01.bw.com.retrofitrxjavamvp_demo.Bean.MenuBean;

public interface RetrofitInterface {
    @GET
    Observable<MenuBean> getDataUrl(@Url String url);
}
