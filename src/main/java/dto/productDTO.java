package dto;

import com.ebidingapp.entity.ReplyTweetMessage;
import java.util.List;
import lombok.Data;
@Data
public class productDTO {
	public String id;
	public String productName;
	public String shortDesc;
	public String detailedDesc;
	public String category;
	public String startingPrice;
	public String bidEndDate;
	public String tweetTime;
	public int likeCount;
	public String loginId;
	public List<bidsDTO> bids;

}
