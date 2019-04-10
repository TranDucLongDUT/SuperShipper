package jp.bap.traning.simplechat.response;
import java.util.List;
import jp.bap.traning.simplechat.model.News;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class NewsResponse extends BaseResponse {
    private List<News> data;
}
