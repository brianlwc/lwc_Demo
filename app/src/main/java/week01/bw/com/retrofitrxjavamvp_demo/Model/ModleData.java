package week01.bw.com.retrofitrxjavamvp_demo.Model;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import week01.bw.com.retrofitrxjavamvp_demo.Bean.MenuBean;

public class ModleData {
    List<MenuBean.DataBean> data = new ArrayList();
    ModelInterface modelInterface;
    RetrofitInterface retrofitInterface;
    private String baseUrl = "http://www.qubaobei.com/ios/cf/";
    private String url = "http://www.qubaobei.com/ios/cf/dish_list.php?stage_id=1&limit=20&page=1";

    public ModleData(ModelInterface modelInterface) {
        this.modelInterface = modelInterface;
    }

    public void getData(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        retrofitInterface = retrofit.create(RetrofitInterface.class);
        retrofitInterface.getDataUrl(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MenuBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MenuBean menuBean) {
                        modelInterface.LoadSuccess(menuBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        modelInterface.LoadFailed();
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
