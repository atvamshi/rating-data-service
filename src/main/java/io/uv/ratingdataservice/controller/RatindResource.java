package io.uv.ratingdataservice.controller;

import io.uv.ratingdataservice.models.Rating;
import io.uv.ratingdataservice.models.UserRating;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * Project: rating-data-service
 * Package: io.uv.ratingdataservice.controller
 * <p>
 * User: vamshi
 * Date: 2019-07-21
 * Time: 10:27
 * <p>
 * Created with IntelliJ IDEA
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping("/ratingData")
public class RatindResource implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @GetMapping(path = "/{movieId}")
    public Rating getCatalogFor(@PathVariable String movieId) {
        return new Rating(movieId, 4);
    }

    @GetMapping(path = "users/{userId}")
    public UserRating getListOfRatingsForUserId(@PathVariable String userId) {
        List<Rating> ratingList =  Arrays.asList(
                new Rating("1234", 4),
                new Rating("5678", 3)
        );

        UserRating userRating = applicationContext.getBean(UserRating.class);

        userRating.setUserRating(ratingList);
        return userRating;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
