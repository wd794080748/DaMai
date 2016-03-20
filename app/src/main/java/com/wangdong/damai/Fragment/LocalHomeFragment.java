package com.wangdong.damai.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;
import com.wangdong.damai.Adapter.HomeLocalListViewAdapter;
import com.wangdong.damai.Adapter.HomeRecyclerViewAdapter;
import com.wangdong.damai.Constant.ButtonTitleList;
import com.wangdong.damai.Constant.ConstantUrl;
import com.wangdong.damai.R;
import com.wangdong.damai.bean.HomeLocalBanner;
import com.wangdong.damai.bean.HomeLocalListViewObj1;
import com.wangdong.damai.bean.HomeRecyclerView;
import com.wangdong.damai.http.IOkCallBack;
import com.wangdong.damai.http.OkHttpTool;
import com.wangdong.damai.httpResult.HttpUtils;
import com.wangdong.damai.httpResult.HttpUtils2;
import com.wangdong.damai.httpResult.RequestCallBack;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by wd794 on 2016/3/5 0005.
 */
public class LocalHomeFragment extends BaseFragment {
    private View contentView;
    private RecyclerView mRecyclerView;
    private OkHttpTool okHttpTool;
    private View bannerInflate;
    private ConvenientBanner convenientBanner;
    private List<HomeLocalBanner> homeLocalBannerList;
    private ArrayList<String> StringList;
    private HomeRecyclerView homeObject;
    private TextView tvNew;
    private TextView tvLike;
    private TextView tvPay;
    private ImageView imageViewOne;
    private ImageView imageViewTwo;
    private ListView lvRecon;
    private ListView lvLike;
    private HomeLocalListViewAdapter homeLocalListViewAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (contentView == null) {
            contentView = inflater.inflate(R.layout.frg_home_local, null);
        }
        okHttpTool=OkHttpTool.newInstance(getActivity());
        initView();
        initData();
        setUpBanner();
        setListView();
        return contentView;
    }

    private void setListView() {
        //设置推荐Listview数据
        okHttpTool.okGet(ConstantUrl.HOME_LOCAL_LISTVIEW1_URL, HomeLocalListViewObj1.class,
                new IOkCallBack<HomeLocalListViewObj1>() {

                    @Override
                    public void onSucess(HomeLocalListViewObj1 resultInfo) {
                        Log.i("wangdong23", "onSucess: "+resultInfo.getList().size());
                        homeLocalListViewAdapter=
                                new HomeLocalListViewAdapter(resultInfo.getList(),getActivity());
                        lvRecon.setAdapter(homeLocalListViewAdapter);

                    }
                },140);
        //设置猜你喜欢ListView数据
        HttpUtils2.requestGet(ConstantUrl.HOME_LOCAL_LISTVIEW2_URL, new RequestCallBack() {
            List<HomeLocalListViewObj1.ListEntity> entityList = new ArrayList<HomeLocalListViewObj1.ListEntity>();

            @Override
            public void onSuccess(String result, int requestCode) {
                try {
                    JSONArray jsonArray = new JSONArray(result);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        HomeLocalListViewObj1.ListEntity listEntity = new HomeLocalListViewObj1.ListEntity();
                        listEntity.setCityname(jsonObject.getString("city_name"));
                        listEntity.setIsXuanZuo(0);
                        listEntity.setPriceName(jsonObject.getString("price"));
                        listEntity.setName(jsonObject.getString("name"));
                        listEntity.setShowTime(jsonObject.getString("show_time"));
                        listEntity.setSiteStatus(jsonObject.getInt("status"));
                        listEntity.setProjectID(jsonObject.getInt("id"));
                        listEntity.setVenName(jsonObject.getString("venue_name"));
                        entityList.add(listEntity);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                homeLocalListViewAdapter =
                        new HomeLocalListViewAdapter(entityList, getActivity());
                lvLike.setAdapter(homeLocalListViewAdapter);

            }

            @Override
            public void onFailure(String error) {

            }

            @Override
            public void error(Exception ex) {

            }
        }, 150);
    }

    private void setUpBanner() {
        //获取banner图片,并给homeLocalBannerList赋值
        HttpUtils.requestGet(ConstantUrl.HOME_LOCAL_BANNER_URL, new RequestCallBack() {
            @Override
            public void onSuccess(String result, int requestCode) {
                Log.i("wangdong15", "onSuccess: " + Thread.currentThread().getName());
                try {
                    JSONArray jsonArray = new JSONArray(result);
                    StringList = new ArrayList<String>();
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        HomeLocalBanner homeLocalBanner = new HomeLocalBanner();
                        homeLocalBanner.setName(jsonObject.getString("Name"));
                        homeLocalBanner.setProjectID(jsonObject.getInt("ProjectID"));
                        String url = jsonObject.getString("Pic");
                        homeLocalBanner.setPic(url);
                        Log.i("wangdong7", "onSuccess: " + url);
                        homeLocalBannerList.add(homeLocalBanner);
                        StringList.add(url);
                    }
                    Log.i("wangdong7", "onSuccess: " + StringList.size());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Log.i("wangdong12", "onSuccess: " + convenientBanner.toString());

                convenientBanner.setPages(new CBViewHolderCreator() {
                    @Override
                    public Object createHolder() {
                        return new HomeLocalImageHolderView();
                    }
                }, StringList);
                Log.i("wangdong12", "onSuccess: " + StringList.size());
                convenientBanner.setPageIndicator(new int[]{R.drawable.mt_add_star_dot_normal, R.drawable.mt_add_star_dot_press});
                Log.i("wangdong8", "onSuccess: " + StringList.size());

            }

            @Override
            public void onFailure(String error) {

            }

            @Override
            public void error(Exception ex) {

            }
        }, 140);

    }

    class HomeLocalImageHolderView implements Holder<String> {
        public HomeLocalImageHolderView() {
            Log.i("wangdong19", "LocalImageHolderView: ");
        }

        private ImageView imageView;

        @Override
        public View createView(Context context) {
            Log.i("wangdong19", "createView: ");
            imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
//            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            return imageView;
        }

        @Override
        public void UpdateUI(Context context, int position, String data) {
            Picasso.with(getActivity()).load(data).into(imageView);
        }
    }

    private void initData() {
        //获取HomeFragment中传递过来的对象
        Bundle arguments = getArguments();
        homeObject = (HomeRecyclerView) arguments.getSerializable("homeObject");
        Log.i("wangdong24", "initData: " + homeObject.toString());
        //new 一个存放HomeLocalBannerList的集合，以便作为convenientBanner监听的数据
        homeLocalBannerList = new ArrayList<>();
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL));
        List<String> imgUrlList = homeObject.getButtonImgs();
        HomeRecyclerViewAdapter homeRecyclerViewAdapter = new HomeRecyclerViewAdapter(getActivity(),
                imgUrlList, ButtonTitleList.getList());
        mRecyclerView.setAdapter(homeRecyclerViewAdapter);
        tvPay.setText(homeObject.getList().get(0).getTitle());
        tvNew.setText(homeObject.getList().get(2).getTitle());
        tvLike.setText(homeObject.getList().get(3).getTitle());
        Picasso.with(getActivity()).load(homeObject.getList().get(0).getList().get(0).getPicUrl()).into(imageViewOne);
        Picasso.with(getActivity()).load(homeObject.getList().get(1).getList().get(0).getPicUrl()).into(imageViewTwo);

    }

    private void initView() {
        tvNew = (TextView) contentView.findViewById(R.id.tv_home_local_new);
        tvLike = (TextView) contentView.findViewById(R.id.tv_home_local_like);
        tvPay = (TextView) contentView.findViewById(R.id.tv_home_local_pay);
        imageViewOne = (ImageView) contentView.findViewById(R.id.iv_home_local_jifen1);
        imageViewTwo = (ImageView) contentView.findViewById(R.id.iv_home_local_jifen2);
        lvRecon = (ListView) contentView.findViewById(R.id.lv_home_local_recon);
        lvLike = (ListView) contentView.findViewById(R.id.lv_home_local_like);
        bannerInflate = LayoutInflater.from(getActivity()).inflate(
                R.layout.home_local_convenientbanner, null);
        convenientBanner = (ConvenientBanner) contentView.findViewById(
                R.id.home_local_conBanner);
        mRecyclerView = (RecyclerView) contentView.findViewById(R.id.recyclerview_home_local);
    }

    @Override
    public void onResume() {
        convenientBanner.startTurning(4000);
        super.onResume();
    }

    @Override
    public void onPause() {
        convenientBanner.stopTurning();
        super.onPause();
    }
}
