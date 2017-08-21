package vn.lequan.lienminhsamsoi.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

import vn.lequan.lienminhsamsoi.EndlessRecyclerOnScrollListener;
import vn.lequan.lienminhsamsoi.R;
import vn.lequan.lienminhsamsoi.adapter.NewsAdapter;
import vn.lequan.lienminhsamsoi.models.News;

public class NewsFragment extends Fragment {
    private RecyclerView rclview;
    private NewsAdapter newsAdapter;
    private GridLayoutManager layout;
    ArrayList<News> newsArrayList = new ArrayList<News>();
    private int page = 0, pagesize = 10;
    private int limit = 0;
    private ProgressBar progress_bar;

    @Nullable
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_grid_champions, container, false);
        rclview = v.findViewById(R.id.rclview);
        progress_bar = v.findViewById(R.id.progress_bar);
        layout = new GridLayoutManager(getActivity(), 1, LinearLayoutManager.VERTICAL, false);
        rclview.setLayoutManager(layout);
        rclview.setHasFixedSize(true);
        newsAdapter = new NewsAdapter(getActivity(), new ArrayList<News>(), 1);
        rclview.setAdapter(newsAdapter);
        getWebsite(limit);
        limit = 5;
        getWebsite(limit);
        loadMore();
        return v;
    }

    private void loadMore() {

        rclview.addOnScrollListener(new EndlessRecyclerOnScrollListener(layout, page, pagesize) {
            @Override
            public void onLoadMore(int current_page, int totalItemsCount, RecyclerView view) {

                page = current_page;
                limit = limit + 5;
                getWebsite(limit);
            }
        });
    }

    private void getWebsite(final int size) {
        progress_bar.setVisibility(View.VISIBLE);
        newsArrayList.clear();
        new Thread(new Runnable() {
            @Override
            public void run() {
                final StringBuilder builder = new StringBuilder();
                try {
                    Document doc = Jsoup.connect("https://lienminh.garena.vn/tin-game?limitstart=" + String.valueOf(size)).get();
                    String title = doc.title();
                    Elements links = doc.getElementsByTag("h4");
                    builder.append(title).append("\n");
                    for (Element link : links) {
                        Elements links1 = link.parents().parents().get(0).getElementsByTag("img");
                        String links2 = link.parents().get(0).getElementsByTag("p").text();
                        builder.append("\n").append("Link : ").append(link.getElementsByTag("a").attr("href"))
                                .append("\n").append("Title : ").append(link.text())
                                .append("\n").append("IMG : ").append(links1.attr("src"))
                                .append("\n").append("DES : ").append(links2);
                        newsArrayList.add(new News(link.text(), link.getElementsByTag("a").attr("href"), links1.attr("src"), links2));

                    }
                } catch (IOException e) {
                    builder.append("Error : ").append(e.getMessage()).append("\n");
                }
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        newsAdapter.addAll(newsArrayList);
                        progress_bar.setVisibility(View.GONE);
                    }
                });
            }
        }).start();


    }
}
