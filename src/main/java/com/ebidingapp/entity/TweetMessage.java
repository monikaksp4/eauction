package com.ebidingapp.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "TweetMessage")
public class TweetMessage {
	@Id
	public String id;
	public String productName;
	public String shortDesc;
	public String detailedDesc;
	public String category;
	public double startingPrice;

	public String bidEndDate;
	public String tweetTime;
	public int likeCount;
	public String loginId;
	
	public List<ReplyTweetMessage> bids;
	public UserRegistration user;
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getShortDesc() {
		return shortDesc;
	}
	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}
	public String getDetailedDesc() {
		return detailedDesc;
	}
	public void setDetailedDesc(String detailedDesc) {
		this.detailedDesc = detailedDesc;
	}
	public String getCategory() {
		return category;
	} 
	public void setCategory(String category) {
		this.category = category;
	}
	public double getStartingPrice() {
		return startingPrice;
	}
	public void setStartingPrice(double startingPrice) {
		this.startingPrice = startingPrice;
	}
	public String getBidEndDate() {
		return bidEndDate;
	}
	public void setBidEndDate(String bidEndDate) {
		this.bidEndDate = bidEndDate;
	}
	public String getTweetTime() {
		return tweetTime;
	}
	public void setTweetTime(String tweetTime) {
		this.tweetTime = tweetTime;
	}
	public int getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public List<ReplyTweetMessage> getBids(){
		return bids;
	}
	public void setBids(List<ReplyTweetMessage> bids) {
		this.bids=bids;
	}
//
//	

}
