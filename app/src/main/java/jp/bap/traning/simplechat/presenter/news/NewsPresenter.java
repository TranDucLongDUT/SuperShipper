package jp.bap.traning.simplechat.presenter.news;

import android.util.Log;

import java.util.ArrayList;

import jp.bap.traning.simplechat.model.News;

public class NewsPresenter {
    private NewsInteractor mNewsInteractor;
    private NewsView mNewsView;

    public NewsPresenter() {
        mNewsInteractor = new NewsInteractor();
    }

    public NewsPresenter(NewsView newsView) {
        mNewsView = newsView;
        mNewsInteractor = new NewsInteractor();
    }

    public void insertOrUpdateNews(News news) {
        mNewsInteractor.insertOrUpdateNews(news);
    }

    public void getAllNews() {
        mNewsInteractor.getAllNews(mNewsView);
    }

    public News getOneNewsFromID(long newsId) {
        return mNewsInteractor.getOneNewsFromID(newsId);
    }

    public void requestAllNews() {
        mNewsInteractor.requestAllNews(new NewsView() {
            @Override
            public void getAllNews(ArrayList<News> news) {
                Log.d("NewsPresenter","getAllNews from API Success"+news);
            }

            @Override
            public void errorGetAllNews() {
                Log.d("","errorGetAllNews from API Success");
            }
        });
    }
}
