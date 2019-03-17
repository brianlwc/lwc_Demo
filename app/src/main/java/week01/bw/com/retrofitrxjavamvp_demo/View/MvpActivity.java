package week01.bw.com.retrofitrxjavamvp_demo.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

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
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRv.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        mRv.setLayoutManager(manager);
        myPresenter = new MyPresenter(this);
        myPresenter.handlerdata();

    }

    @Override
    public void setListItem(MenuBean menuBean) {
        adapter = new MyAdapter();
        adapter.refresh(this,menuBean.getData());
        mRv.setAdapter(adapter);
    }

    @Override
    public void failed() {
        Toast.makeText(this, "加载失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
