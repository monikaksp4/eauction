package com.ebidingapp.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ebidingapp.entity.ReplyTweetMessage;
import com.ebidingapp.entity.TweetMessage;
import com.ebidingapp.entity.UserRegistration;
import com.ebidingapp.exceptionHandler.GlobalExceptionHandlerController;
import com.ebidingapp.service.RegistrationService;
import com.ebidingapp.service.TweetMessageService;

@RestController()
@CrossOrigin(origins="http://localhost:3000")
public class TweetAppController {
	@Autowired
	RegistrationService registrationService;
	@Autowired
	TweetMessageService tweetMessage;
	@PostMapping(value ="/register")
	public String saveUserRegistration(@RequestBody UserRegistration registration) throws Exception {
		return registrationService.saveUserRegistration(registration);
		
	}
	@GetMapping(value ="/users/all")
	public List<UserRegistration> getUserRegistration() {
		return registrationService.getAllUser();
		
	}
	@GetMapping(value ="/user/search/{username}")
	public UserRegistration getUser(@PathVariable String username) {
		return registrationService.getUser(username);
		
	}
	@PutMapping(value ="/{username}/resetPassword/{oldPassword}/{newPassword}")
	public String updatePassword(@PathVariable String username,@PathVariable String oldPassword,@PathVariable String newPassword) throws Exception  {
		return registrationService.updatePassword(username, oldPassword, newPassword);
		
	}
	@PutMapping(value ="/{username}/forgetPassword/{newPassword}")
	public String forgetPassword(@PathVariable String username,@PathVariable String newPassword) throws Exception  {
		return registrationService.forgetPassword(username, newPassword);
		
	}
	@GetMapping(value ="/login")
	public String login() {
		return "LoggedIn";
		
	}
	@GetMapping(value ="/all")
	public List<TweetMessage> getAllTweet() {
		return tweetMessage.getAllTweet();
	}
	
	//API to save products
	@PostMapping(value="/seller/add-product")
	public String saveProduct(@NotNull @RequestBody TweetMessage tweet) {
		return tweetMessage.postProduct(tweet);
	}
	@PostMapping(value ="/seller/{username}/add-product")
	public String saveTweetMessage(@PathVariable String username,@RequestBody TweetMessage tweet)  {
		return tweetMessage.postTweet(tweet, username);
		
	}
	@GetMapping(value ="/{username}")
	public List<TweetMessage> getUserTweet(@PathVariable String username) {
		return tweetMessage.getUserTweet(username);
		
	}
	@GetMapping(value="/seller/show-bids/{id}")
		public Optional<TweetMessage> showBids(@PathVariable String id){
		return tweetMessage.showBids(id);
	}
	@PutMapping(value ="/seller/{username}/update/{id}")
	public String updateTweetMessage(@PathVariable String username,@PathVariable String id,@RequestBody TweetMessage tweet)  {
		return tweetMessage.updateTweetMessage(username, id, tweet);
		
	}
	@DeleteMapping(value ="/seller/{username}/delete/{id}")
	public String deleteTweetMessage(@PathVariable String username,@PathVariable String id)  {
		return tweetMessage.deleteTweetMessage(username, id);
	}
	@GetMapping(value ="/seller/{username}/product/{id}")
	public Optional<TweetMessage> getProductDetails(@PathVariable String id)  {
		System.out.println(tweetMessage.getProductDetails(id));
		return tweetMessage.getProductDetails(id);
		
	}
	@PostMapping(value ="/buyer/place-bid")
	public String saveReplyTweetMessage(@RequestBody ReplyTweetMessage replyTweetMessage)  {
		return tweetMessage.postReplyTweet(replyTweetMessage);
	}
	@PostMapping(value ="/buyer/place-bid1/{productId}")
	public String placeBids(@RequestBody TweetMessage tweet, @PathVariable String productId)  {
		return tweetMessage.placeBids(tweet,productId);
	}
	
	@PutMapping(value="/buyer/update-bid/{productId}/{buyerEmailld}/{newBidAmount}")
	public String updateBids(@PathVariable String buyerEmailld, @PathVariable String productId, @PathVariable String newBidAmount) {
//		return tweetMessage.updateBidAmount(buyerEmailld, productId, newBidAmount);
		return tweetMessage.updateBids(productId, buyerEmailld, newBidAmount);
	}
	
	@PutMapping(value ="/{username}/like/{id}")
	public String updateLike(@PathVariable String username,@PathVariable String id)  {
		return tweetMessage.updateLike(username, id);
		
	}
	@GetMapping(value ="/buyer/show-bid/{tweetMessageId}")
	public List<ReplyTweetMessage> getReplyTweet(@PathVariable String tweetMessageId) {
		return tweetMessage.getReplyTweet(tweetMessageId);
		
	}
	
}
