package com.snapjoke.api.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.snapjoke.api.model.Joke;
import org.springframework.data.jpa.repository.Query;

public interface JokeRepository extends JpaRepository<Joke, Integer> {

    @Query(value = "SELECT * FROM jokes ORDER BY RANDOM() LIMIT 1", nativeQuery = true)
    Joke findRandomJoke();
}
