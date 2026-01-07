package com.snapjoke.api.controller;

import com.snapjoke.api.model.Joke;
import com.snapjoke.api.repository.JokeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JokeController {
        private final JokeRepository jokeRepository;

        public JokeController(JokeRepository jokeRepository)
        {
            this.jokeRepository=jokeRepository;
        }

        @GetMapping("joke")
        public Joke getRandomJoke() {
            return jokeRepository.findRandomJoke();
        }

}
