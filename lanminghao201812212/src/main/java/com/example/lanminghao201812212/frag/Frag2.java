package com.example.lanminghao201812212.frag;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.bwie.xlistviewlibrary.utils.NetWordUtils;
import com.example.lanminghao201812212.Bean;
import com.example.lanminghao201812212.MyAdapter;
import com.example.lanminghao201812212.R;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

public class Frag2 extends Fragment {
    private PullToRefreshListView review;
    private String urlString = "http://172.17.8.100/movieApi/movie/v1/findReleaseMovieList?page=1&count=10";
    private int a;
    private MyAdapter adapter;
    private List<Bean.ResultBean> list = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag2,container,false);
        review = view.findViewById(R.id.refresh2);
        review.setMode(PullToRefreshBase.Mode.BOTH);
        review.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> pullToRefreshBase) {
                a=0;
                list.clear();
                getData(a);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> pullToRefreshBase) {
                a++;
                getData(a);
            }
        });
        adapter = new MyAdapter(getActivity(),list);
        review.setAdapter(adapter);
        getData(0);

        return view;
    }

    private void getData(int a) {
        new MyStack().execute(urlString);
    }

    private class MyStack extends AsyncTask<String,Void,String> {

        @Override
        protected String doInBackground(String... strings) {
            return NetWordUtils.getNetjson(strings[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Gson gson = new Gson();
            Bean bean = gson.fromJson(s, Bean.class);
            List<Bean.ResultBean> result = bean.getResult();
            list.addAll(result);
            adapter.notifyDataSetChanged();
            review.onRefreshComplete();
        }
    }
}
