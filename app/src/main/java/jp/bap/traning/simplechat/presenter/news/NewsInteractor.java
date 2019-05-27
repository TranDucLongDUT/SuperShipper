package jp.bap.traning.simplechat.presenter.news;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;

import jp.bap.traning.simplechat.database.NewsDAO;
import jp.bap.traning.simplechat.model.News;
import jp.bap.traning.simplechat.response.NewsResponse;
import jp.bap.traning.simplechat.service.ApiClient;

public class NewsInteractor {

    private NewsDAO mNewsDAO;

    public NewsInteractor() {
        mNewsDAO = new NewsDAO();
    }

    void insertOrUpdateNews(News news) {
        mNewsDAO.insertOrUpdateNews(news);
    }

    void getAllNews(NewsView mNewsView) {
        ArrayList<News> newsArrayList = new ArrayList<>();
        newsArrayList = mNewsDAO.getAllNews();
        if (newsArrayList.size() > 0) {
            mNewsView.getAllNews(newsArrayList);
        } else {
            mNewsView.errorGetAllNews();
        }
    }

    News getOneNewsFromID(long newsID) {
        News mNews = new News();
        mNews = mNewsDAO.getOneNewsFromID(newsID);
        if (mNews.getDescription() == null) {
            return null;
        } else {
            return mNews;
        }
    }

    public void requestAllNews(NewsView mNewsView) {
        Log.d("requestAllNews","");
        Call<NewsResponse> newsResponseCall = ApiClient.getService().getListNews();
        newsResponseCall.enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
//                List<News> news = response.body().getData();
                Log.d("onResponseGetNews","");
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {
                Log.d("onFailure","");
                mNewsView.errorGetAllNews();
            }
        });
    }
}
