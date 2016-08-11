package org.vackapi.mvplearn.mvp;

import android.app.ProgressDialog;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.vackapi.mvplearn.R;

public class MVPLearnActivity extends AppCompatActivity implements OperationView {
    private Toolbar toobar_MVP;
    private ListView listView_MVP;

    private PhoneFactory phoneFactory;
    private PhonePresenter phonePresenter;
    private ArrayAdapter<Phone> adapter;
    private ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvplearn);
        toobar_MVP= (Toolbar) findViewById(R.id.toobar_MVP);
        setSupportActionBar(toobar_MVP);
        listView_MVP= (ListView) findViewById(R.id.listView_MVP);
        phoneFactory=new PhoneFactory();
        phoneFactory.createPhone("Nokia1020",2300.0);
        phonePresenter=new PhonePresenter(phoneFactory,this);
        adapter=new ArrayAdapter<Phone>(this,android.R.layout.simple_list_item_1,phoneFactory.getPhoneList());
        listView_MVP.setAdapter(adapter);

        listView_MVP.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                phonePresenter.removePhone(position);
            }
        });

    }


    @Override
    public void showCreatingPhone() {
        if(pd==null){
            pd=new ProgressDialog(MVPLearnActivity.this);
        }
        pd.setMessage("正在生產手機...");
        pd.show();
    }

    @Override
    public void showPhoneCountChange() {
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showNoPhone() {
        Snackbar.make(MVPLearnActivity.this.getWindow().getDecorView(),"no phone",Snackbar.LENGTH_LONG).setAction("Undo", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        }).show();
    }

    @Override
    public void showFactoryBusy() {
        Snackbar.make(MVPLearnActivity.this.getWindow().getDecorView(),"factory busy",Snackbar.LENGTH_LONG).setAction("Undo", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        }).show();
    }

    @Override
    public void showCreatedPhone() {
        pd.dismiss();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_mvp,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.action_MVP_add){
            phonePresenter.addRandomPhone();
        }
        return super.onOptionsItemSelected(item);
    }
}
