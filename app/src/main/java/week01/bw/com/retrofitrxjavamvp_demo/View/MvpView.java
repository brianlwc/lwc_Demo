package week01.bw.com.retrofitrxjavamvp_demo.View;

import java.util.List;

import week01.bw.com.retrofitrxjavamvp_demo.Bean.MenuBean;

public interface MvpView {
    void setListItem(MenuBean menuBean);
    void failed();
    void showMessage(String message);
}
