package org.vackapi.mvplearn.mvp2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshRecyclerView;
import org.vackapi.mvplearn.R;
import org.vackapi.mvplearn.mvp2.moudle.CanKingFactory;
import org.vackapi.mvplearn.mvp2.presenter.CanKingPresenter;

public class MVP2Activity extends AppCompatActivity implements CanKingViewOperater{
    private Toolbar toolbar_canKing;
    private PullToRefreshRecyclerView ptrRecyclerView_canKing;
    private CanKingFactory canKingFactory;
    private CanKingPresenter canKingPresenter;
    private CanKingItemAdapter adapter;
    private int currentPage;
    private int screenWidth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp2);
        toolbar_canKing= (Toolbar) findViewById(R.id.toolbar_canKing);
        setSupportActionBar(toolbar_canKing);
        toolbar_canKing.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ptrRecyclerView_canKing= (PullToRefreshRecyclerView) findViewById(R.id.ptrRecyclerView_canKing);
        screenWidth=getResources().getDisplayMetrics().widthPixels;
        ptrRecyclerView_canKing.setMode(PullToRefreshBase.Mode.PULL_FROM_END);
        canKingFactory=new CanKingFactory();
        adapter=new CanKingItemAdapter(this,canKingFactory.getData());
        canKingPresenter=new CanKingPresenter(this,canKingFactory);
        ptrRecyclerView_canKing.getRefreshableView().setLayoutManager(new LinearLayoutManager(this));
        ptrRecyclerView_canKing.getRefreshableView().setAdapter(adapter);
        ptrRecyclerView_canKing.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<RecyclerView>() {
            @Override
            public void onRefresh(PullToRefreshBase<RecyclerView> refreshView) {
                Log.e("onRefresh",(currentPage+1)+"");
                canKingPresenter.addItem(currentPage+1);
            }
        });
        canKingPresenter.addItem(1);

    }

    @Override
    public void onLoading() {
        Toast.makeText(getApplicationContext(),"onLoading",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onItemAdding() {
        Log.e("VACK","onItemAdding");
    }

    @Override
    public void onItemAdded() {
        Log.e("VACK","onItemAdded");
        ptrRecyclerView_canKing.post(new Runnable() {
            @Override
            public void run() {
                adapter.notifyDataSetChanged();
                ptrRecyclerView_canKing.onRefreshComplete();
            }
        });
    }

    @Override
    public void onItemClick(int position) {
        Intent intent=new Intent(getApplicationContext(),CanKingDetailActivity.class);
        intent.putExtra("post_title",canKingFactory.getData().get(position).getPost_title());
        intent.putExtra("post_date",canKingFactory.getData().get(position).getPost_date());
        intent.putExtra("id",canKingFactory.getData().get(position).getId());
        startActivity(intent);
    }

    @Override
    public void onLoadComplete(int currentPage) {
        this.currentPage=currentPage;
        Log.e("VACK","onLoadComplete" +currentPage);
        ptrRecyclerView_canKing.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(),"onLoadComplete",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void showNoMore() {
        Toast.makeText(getApplicationContext(),"NoMore",Toast.LENGTH_LONG).show();
    }

    @Override
    public void showDataError(final Exception e) {
        ptrRecyclerView_canKing.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(),"DataError"+e.toString(),Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public CanKingItemAdapter getAdapter() {
        if(canKingFactory==null){
            canKingFactory=new CanKingFactory();
        }
        if(adapter==null){
            adapter=new CanKingItemAdapter(MVP2Activity.this,canKingFactory.getData());
        }
        return adapter;
    }


}
