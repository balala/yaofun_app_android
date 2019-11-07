package com.balala.yaofun.activity;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.balala.yaofun.R;
import com.balala.yaofun.adapter.SortAdapter;
import com.balala.yaofun.base.BaseActivity;
import com.balala.yaofun.bean.BaseBean;
import com.balala.yaofun.bean.MailListBean;
import com.balala.yaofun.bean.MailListUserBean;
import com.balala.yaofun.bean.UserBean;
import com.balala.yaofun.presenter.MailListPresenter;
import com.balala.yaofun.util.ForLog;
import com.balala.yaofun.util.PinyinUtils;
import com.balala.yaofun.view.ContactSortModel;
import com.balala.yaofun.view.EditTextWithDel;
import com.balala.yaofun.view.MailListView;
import com.balala.yaofun.view.SideBar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static com.balala.yaofun.httpUtils.MyApp.INTERACTIVE_ASSISTANT;
import static com.balala.yaofun.httpUtils.MyApp.SERVICE_ASSISTANT;

public class MailListActivity extends BaseActivity<MailListPresenter, MailListView> implements MailListView{

    private ListView sortListView;
    private SideBar sideBar;
    private TextView dialog, mTvTitle;
    private SortAdapter adapter;
    private EditTextWithDel mEtSearchName;
    private List<MailListUserBean> SourceDateList=new ArrayList<>();
    @Override
    protected void initView() {
//        ImmersionBar.with(this)
//                .statusBarColor(R.color.black) //导航栏背景色
//                .statusBarDarkFont(true)   //状态栏字体是深色，不写默认为亮色
//                .flymeOSStatusBarFontColor(R.color.colorAccent)
//                .init();

        findViewById(R.id.back).setOnClickListener(v->{
            finish();
        });
        ((TextView)findViewById(R.id.title)).setText(R.string.maillist);
        mEtSearchName = (EditTextWithDel) findViewById(R.id.et_search);
        sideBar = (SideBar) findViewById(R.id.sidrbar);
        dialog = (TextView) findViewById(R.id.dialog);
        mTvTitle = (TextView) findViewById(R.id.tv_title);
        sortListView = (ListView) findViewById(R.id.lv_contact);
        initDatas();
        initEvents();
        basePresenter.mail_list_user(null);
    }
    /**
     * 根据输入框中的值来过滤数据并更新ListView
     *
     * @param filterStr
     */
    private void filterData(String filterStr) {
//        List<ContactSortModel> mSortList = new ArrayList<>();
//        if (TextUtils.isEmpty(filterStr)) {
//            mSortList = SourceDateList;
//        } else {
//            mSortList.clear();
//            for (ContactSortModel sortModel : SourceDateList) {
//                String name = sortModel.getName();
//                if (name.toUpperCase().indexOf(filterStr.toString().toUpperCase()) != -1 ||
//                        PinyinUtils.getPingYin(name).toUpperCase().startsWith(filterStr.toString().toUpperCase())) {
//                    mSortList.add(sortModel);
//                }
//            }
//        }
//        // 根据a-z进行排序
//        Collections.sort(mSortList, new PinyinComparator());
//        adapter.updateListView(mSortList);
    }



    private void initEvents() {
        //设置右侧触摸监听
        sideBar.setOnTouchingLetterChangedListener(new SideBar.OnTouchingLetterChangedListener() {
            @Override
            public void onTouchingLetterChanged(String s) {
                //该字母首次出现的位置
                int position = adapter.getPositionForSection(s.charAt(0));
                if (position != -1) {
                    sortListView.setSelection(position + 1);
                }
            }
        });

        //ListView的点击事件
        sortListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                mTvTitle.setText(((ContactSortModel) adapter.getItem(position - 1)).getName());
                Toast.makeText(getApplication(), ((ContactSortModel) adapter.getItem(position)).getName(), Toast.LENGTH_SHORT).show();
            }
        });

        //根据输入框输入值的改变来过滤搜索
        mEtSearchName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //当输入框里面的值为空，更新为原来的列表，否则为过滤数据列表
                filterData(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void initDatas() {
        sideBar.setTextView(dialog);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initData2() {

    }

    @Override
    protected int getlayout() {
        return R.layout.activity_mail_list;
    }

    @Override
    protected MailListPresenter initPresenter() {
        return new MailListPresenter();
    }

    @Override
    public void mail_list_userSuccess(BaseBean<List<MailListBean>> bean) {
        ForLog.e("请求的通讯录："+bean);
        for(int i=0;i<bean.getData().size();i++){
            String zimu=bean.getData().get(i).getZimu();
            for(int j=0;j<bean.getData().get(i).getUser_list().size();j++){
                MailListUserBean mb=bean.getData().get(i).getUser_list().get(j);
                mb.setZimu(zimu);
                if(SERVICE_ASSISTANT.equals(mb.getObject_id()) ||
                        INTERACTIVE_ASSISTANT.equals(mb.getObject_id())){

                }else{
                    SourceDateList.add(mb);
                }
            }
        }
        adapter = new SortAdapter(this, SourceDateList);
        sortListView.setAdapter(adapter);

    }

    private List<UserBean> filledData(List<UserBean> date) {
        ArrayList<String> indexString = new ArrayList<>();

        for (int i = 0; i < date.size(); i++) {
//            ContactSortModel sortModel = new ContactSortModel();
//            sortModel.setName(date[i]);
            String pinyin = PinyinUtils.getPingYin(date.get(i).getNick_name());
            String sortString = pinyin.substring(0, 1).toUpperCase();
            if (sortString.matches("[A-Z]")) {
                date.get(i).setSortLetters(sortString.toUpperCase());
                if (!indexString.contains(sortString)) {
                    indexString.add(sortString);
                }
            }
        }
        Collections.sort(indexString);
        sideBar.setIndexText(indexString);
        return date;
    }

    @Override
    public void mail_list_userFail(String msg) {

    }
}
