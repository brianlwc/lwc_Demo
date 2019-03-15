package week01.bw.com.retrofitrxjavamvp_demo.Presenter;

import java.util.List;

import week01.bw.com.retrofitrxjavamvp_demo.Bean.MenuBean;
import week01.bw.com.retrofitrxjavamvp_demo.Model.ModelInterface;
import week01.bw.com.retrofitrxjavamvp_demo.Model.ModleData;
import week01.bw.com.retrofitrxjavamvp_demo.View.MvpView;

public class MyPresenter implements ModelInterface {
    private MvpView mvpView;
    ModleData modleData = new ModleData(this);

    public MyPresenter(MvpView mvpView) {
        this.mvpView = mvpView;
    }

    public void handlerdata(){
        modleData.getData();
    }

    public void onItemClick(int possition){
        mvpView.showMessage(possition+"");
    }

    @Override
    public void LoadSuccess(MenuBean menuBean) {
        mvpView.setListItem(menuBean);
    }

    @Override
    public void LoadFailed() {
        mvpView.failed();
    }


}
