package week01.bw.com.retrofitrxjavamvp_demo.Model;

import java.util.List;

import week01.bw.com.retrofitrxjavamvp_demo.Bean.MenuBean;

public interface ModelInterface {
    void LoadSuccess(MenuBean menuBean);
    void LoadFailed();
}
