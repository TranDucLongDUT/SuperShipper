package jp.bap.traning.simplechat.response;
import java.util.List;

import jp.bap.traning.simplechat.model.Comment;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class CommentResponse {
    private List<Comment> data;
}
