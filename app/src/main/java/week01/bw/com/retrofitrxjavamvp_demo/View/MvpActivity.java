package week01.bw.com.retrofitrxjavamvp_demo.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import week01.bw.com.retrofitrxjavamvp_demo.Bean.MenuBean;
import week01.bw.com.retrofitrxjavamvp_demo.MyAdapter;
import week01.bw.com.retrofitrxjavamvp_demo.Presenter.MyPresenter;
import week01.bw.com.retrofitrxjavamvp_demo.R;

public class MvpActivity extends AppCompatActivity implements MvpView{
    private RecyclerView mRv;
    private MyPresenter myPresenter;
    private MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
        mRv = findViewById(R.id.my_rv);



    }

    @Override
    public void setListItem(MenuBean menuBean) {
        adapter = new MyAdapter();

    }

    @Override
    public void failed() {

    }

    @Override
    public void showMessage(String message) {

    }
}
