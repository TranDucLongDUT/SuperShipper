package jp.bap.traning.simplechat.presenter.comment;

import android.util.Log;

import jp.bap.traning.simplechat.response.CommentResponse;
import jp.bap.traning.simplechat.service.ApiClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import java.util.ArrayList;
import java.util.List;

import jp.bap.traning.simplechat.database.CommentDAO;
import jp.bap.traning.simplechat.model.Comment;

public class CommentInteractor {
    private CommentDAO mCommentDAO;

    CommentInteractor() {
        mCommentDAO = new CommentDAO();
    }

    void requestAllComment() {
        ArrayList<Comment> commentArrayList = new ArrayList<>();
        Call<CommentResponse> commentResponseCall = ApiClient.getService().getListComment();
        commentResponseCall.enqueue(new Callback<CommentResponse>() {
            @Override
            public void onResponse(Call<CommentResponse> call, Response<CommentResponse> response) {
                if (response.isSuccessful() && response.body().getData() != null) {
                    Log.d("onResponseGetComment","");
                    List<Comment> comments = response.body().getData();
                    for (Comment n : comments) {
                        mCommentDAO.insertOrUpdateComment(n);
                    }
                }
            }

            @Override
            public void onFailure(Call<CommentResponse> call, Throwable t) {
                Log.d("onFailure","error get all comment");
            }
        });


    }

    void insertOrUpdate(Comment mComment) {
        mCommentDAO.insertOrUpdateComment(mComment);
    }

    void getAllComment(long newsId, CommentView mCommentView) {
        ArrayList<Comment> comments = new ArrayList<>();
        comments = mCommentDAO.getAllComment(newsId);
        if (comments.size() > 0) {
            mCommentView.getAllComment(comments);
        } else {
            mCommentView.errorGetAllComment(newsId);
        }
    }
}
