package com.ebidingapp.repository;

import java.util.List;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.Query;

import com.ebidingapp.entity.ReplyTweetMessage;
import com.ebidingapp.entity.UserRegistration;


@Repository
public interface ReplyTweetMessageRepository extends MongoRepository<ReplyTweetMessage, String> {

	List<ReplyTweetMessage> findByTweetMessageId(String tweetMessageId);
	ReplyTweetMessage findByIdAndLoginId(String id, String loginId);
	
	@Query("{'UserRegistration.loginId':?0}")
	List<ReplyTweetMessage> findByLoginId(String loginID);


}
