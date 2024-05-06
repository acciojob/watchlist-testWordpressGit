//package com.driver;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("movies")
//public class MovieController {
//    @Autowired
//    MovieService movieService;
//
//    @PostMapping("/add-movie")
//    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
//        // your code here
//        movieService.addMovie(movie);
//        return new ResponseEntity<>("New movie added successfully", HttpStatus.CREATED);
//    }
//
//    @PostMapping("/add-director")
//    public ResponseEntity<String> addDirector(@RequestBody Director director){
//        // your code here
//        movieService.addDirector(director);
//        return new ResponseEntity<>("New director added successfully", HttpStatus.CREATED);
//    }
//
//    @PutMapping("/add-movie-director-pair")
//    public ResponseEntity<String> addMovieDirectorPair(@RequestParam String movie, @RequestParam String director){
//        // your code here
//        movieService.createMovieDirectorPair(movie,director);
//        return new ResponseEntity<>("New movie-director pair added successfully", HttpStatus.CREATED);
//    }
//
//    @GetMapping("/get-movie-by-name/{name}")
//    public ResponseEntity<Movie> getMovieByName(@PathVariable String name){
//        // your code here
//        Movie movie = movieService.findMovie(name);
//        return new ResponseEntity<>(movie, HttpStatus.CREATED);
//    }
//
//    @GetMapping("/get-director-by-name/{name}")
//    public ResponseEntity<Director> getDirectorByName(@PathVariable String name){
//        // your code here
//        Director director=movieService.findDirector(name);
//        return new ResponseEntity<>(director, HttpStatus.CREATED);
//    }
//
//    @GetMapping("/get-movies-by-director-name/{director}")
//    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String director){
//        // your code here
//        List<String> movies = movieService.findMoviesFromDirector(director);
//        return new ResponseEntity<>(movies, HttpStatus.CREATED);
//    }
//
//    @GetMapping("/get-all-movies")
//    public ResponseEntity<List<String>> findAllMovies(){
//        // your code here
//        List<String> movies=movieService.findAllMovies();
//        return new ResponseEntity<>(movies, HttpStatus.CREATED);
//    }
//
//    @DeleteMapping("/delete-director-by-name")
//    public ResponseEntity<String> deleteDirectorByName(@RequestParam String director){
//        // your code here
//        movieService.deleteDirector(director);
//        return new ResponseEntity<>(director + " removed successfully", HttpStatus.CREATED);
//    }
//
//    @DeleteMapping("/delete-all-directors")
//    public ResponseEntity<String> deleteAllDirectors(){
//        // your code here
//        movieService.deleteAllDirectors();
//        return new ResponseEntity<>("All directors deleted successfully", HttpStatus.CREATED);
//    }
//}
//-----------------------------------------------------------------------------------------------------
package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/movies")
public class MovieController {
    @Autowired
    MovieService movieServices;

    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        movieServices.addMovie(movie);
        return new ResponseEntity<>("new movie added successfully", HttpStatus.CREATED);
    }
    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){
        movieServices.addDirector(director);
        return new ResponseEntity<>("new director added successfully", HttpStatus.CREATED);
    }
    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movie")String movie, @RequestParam("director") String director){
        movieServices.addMovieDirectorPair(movie,director);
        return new ResponseEntity<>("new movie-director pair added successfully", HttpStatus.CREATED);
    }
    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("name") String moviename){
        // Movie temp = movieServices.getMovieByName(moviename);
        Movie temp = movieServices.getMovieByName(moviename);
        return new ResponseEntity<>(temp,HttpStatus.FOUND);
    }
    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable("name") String directorname){
        Director temp = movieServices.getDirectorByName(directorname);
        return new ResponseEntity<>(temp,HttpStatus.FOUND);
    }
    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable("director") String directorname){
        List<String> temp = movieServices.getMoviesByDirectorName(directorname);
        return new ResponseEntity<>(temp,HttpStatus.FOUND);
    }
    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
        List<String> temp = movieServices.findAllMovies();
        return new ResponseEntity<>(temp,HttpStatus.FOUND);
    }
    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("name") String director){
        movieServices.deleteDirectorByName(director);
        return new ResponseEntity<>("Director and its movies are deleted", HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        movieServices.deleteAllDirectors();
        return new ResponseEntity<>("All directors and their movies are deleted", HttpStatus.ACCEPTED);
    }


}