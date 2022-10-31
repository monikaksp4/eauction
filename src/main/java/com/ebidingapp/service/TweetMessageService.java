package com.ebidingapp.service;


import java.util.Optional;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebidingapp.entity.ReplyTweetMessage;
import com.ebidingapp.entity.TweetMessage;
import com.ebidingapp.entity.UserRegistration;
import com.ebidingapp.exceptionHandler.GlobalExceptionHandlerController;
import com.ebidingapp.repository.ReplyTweetMessageRepository;
import com.ebidingapp.repository.TweetMessageRepository;
import com.ebidingapp.repository.UserRegistrationRepository;


@Service
public class TweetMessageService {
	@Autowired
	TweetMessageRepository tweetMessageRepository;
	@Autowired
	UserRegistrationRepository userRegistrationRepository;
	@Autowired
	ReplyTweetMessageRepository replyTweetMessageRepository;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	public List<TweetMessage> getAllTweet() {
		logger.info("Entered get all tweet method");
		return tweetMessageRepository.findAll();
		
	}
	public String postTweet(TweetMessage tweetMessage,String username) {
		logger.info("Entered post tweet method");
		
		tweetMessage.setLoginId(username);
		tweetMessageRepository.save(tweetMessage);
		return "saved";
	}
	public String postProduct(TweetMessage tweetMessage) {
		logger.info("Product is saved successfully");

		tweetMessageRepository.save(tweetMessage);
		return "Product Saved Successfully";
	}
	public List<TweetMessage> getUserTweet(String username) {
		//tweetMessageRepository.=
		logger.info("Entered get user tweet method");
		return tweetMessageRepository.findByLoginId(username);
		
	}
	public String updateTweetMessage(String username,String id, TweetMessage tweet) {
		logger.info("Entered update tweet method");
		TweetMessage tweetMessage=tweetMessageRepository.findByIdAndLoginId(id, username);
		tweetMessage.setProductName(tweet.getProductName());
	    tweetMessage.setShortDesc(tweet.getShortDesc());
	    tweetMessage.setDetailedDesc(tweet.getDetailedDesc());
	    tweetMessage.setCategory(tweet.getCategory());
	    tweetMessage.setStartingPrice(tweet.getStartingPrice());
	    tweetMessage.setBidEndDate(tweet.getBidEndDate());
		tweetMessageRepository.save(tweetMessage);
				return "updated";
	}
	public String placeBids(TweetMessage tweet,String productId) {
		logger.info("entered bids details");
		TweetMessage tweetMessage=tweetMessageRepository.findProductById(productId);
		List<ReplyTweetMessage> bids=tweet.getBids();
		bids.stream().forEach(b->{
			if(tweetMessage.getBids()!=null) {
				tweetMessage.getBids().add(b);
				postReplyTweet(b);
			}
			else
			{
				tweetMessage.setBids(bids);
				postReplyTweet(b);
			}
			
			
		});
		tweetMessageRepository.save(tweetMessage);
		
		return "Bids Placed Successfully";
	}
	//------------update bids amount----------------------------------------------------
	public String updateBids(String productId,String buyerEmailId,String updatedBidAmount) {
		logger.info("entered bids details");
		TweetMessage product=tweetMessageRepository.findProductById(productId);
		List<ReplyTweetMessage> bids=product.getBids();
		bids.stream().forEach(b->{
			if(b.getLoginId().equals(buyerEmailId)) {
				b.setReplyMessage(updatedBidAmount);
				postReplyTweet(b);
			}
			tweetMessageRepository.save(product);
		});
		return "Bids Updated Successfully";
		
	}
	public String deleteTweetMessage(String username,String id) {
		logger.info("Entered delete tweet method");
		tweetMessageRepository.deleteByIdAndLoginId(id, username);
				return "deleted";
	}
	public Optional<TweetMessage>  getProductDetails(String id) {
		logger.info("Entered product details method");
		return tweetMessageRepository.findById(id);
				
	}
	public Optional<TweetMessage> showBids(String id){
		logger.info("show bids using product id");
		Optional<TweetMessage> tweetMessage=tweetMessageRepository.findById(id);//product
		return tweetMessage;
	}
	public String updateBidAmount(String username, String productId, String newBidAmount){
		logger.info("Entered update bid amount");
		ReplyTweetMessage replyTweetMessage=replyTweetMessageRepository.findByIdAndLoginId(productId, username);
		replyTweetMessage.setReplyMessage(newBidAmount);
		replyTweetMessageRepository.save(replyTweetMessage);
		return "updated";
	}
	public String postReplyTweet(ReplyTweetMessage replyTweetMessage) {
	
	logger.info("Entered post reply tweet method");
		
	replyTweetMessageRepository.save(replyTweetMessage);
		return "saved";
	}
public List<ReplyTweetMessage> getReplyTweet(String tweetMessageId) {
	logger.info("Entered get reply tweet method");
	return replyTweetMessageRepository.findByTweetMessageId(tweetMessageId);
	
}

public String updateLike(String username,String id) {
	logger.info("Entered update  tweet like method");
	
	TweetMessage message=tweetMessageRepository.findByIdAndLoginId(id, username);
	int count=message.getLikeCount()+1;
	message.setLikeCount(count);
	tweetMessageRepository.save(message);
	return "updated";
}
	

}
