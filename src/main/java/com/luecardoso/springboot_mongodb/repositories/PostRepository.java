package com.luecardoso.springboot_mongodb.repositories;

import com.luecardoso.springboot_mongodb.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    // Realizando pesquisa por título com expressão regular
    // i = insensitive 
    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    List<Post> searchTitle(String text);

    List<Post> findByTitleContainingIgnoreCase(String text);

    // Busca um post com os comentários e o autor em um período específico
    // 0 = text, 1 = minDate, 2 = maxDate
    @Query("{ $and: [ { date: {$gte: ?1} }, { date: { $lte: ?2} } ," +
            " { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, " +
            "{ 'body': { $regex: ?0, $options: 'i' } }," +
            " { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
    List<Post> fullSearch(String text, Date minDate, Date maxDate);
}
