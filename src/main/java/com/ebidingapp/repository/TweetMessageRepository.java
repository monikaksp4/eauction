
package com.ebidingapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ebidingapp.entity.TweetMessage;
import com.ebidingapp.entity.UserRegistration;

@Repository
public interface TweetMessageRepository extends MongoRepository<TweetMessage, String>{
List<TweetMessage> findByLoginId(String username);
Optional<TweetMessage> findById(String id);
TweetMessage findByIdAndLoginId(String id,String LoginId);
TweetMessage findProductById(String id);
void deleteByIdAndLoginId(String id,String LoginId);
@Query(value = "{'ReplyTweetMessage.loginId': ?0}", fields = "{'bids' : 0}")
TweetMessage findbyBuyer( String buyerEmailId);

}
