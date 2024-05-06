//package com.driver;
//
//import java.util.*;
//
//import org.springframework.stereotype.Repository;
//
//@Repository
//public class MovieRepository {
//
//    private HashMap<String, Movie> movieMap;
//    private HashMap<String, Director> directorMap;
//    private HashMap<String, List<String>> directorMovieMapping;
//
//    public MovieRepository(){
//        this.movieMap = new HashMap<String, Movie>();
//        this.directorMap = new HashMap<String, Director>();
//        this.directorMovieMapping = new HashMap<String, List<String>>();
//    }
//
//    public void saveMovie(Movie movie){
//        // your code here
//        movieMap.put(movie.getName(),movie);
//    }
//
//    public void saveDirector(Director director){
//        // your code here
//        directorMap.put(director.getName(),director);
//    }
//
//    public void saveMovieDirectorPair(String movie, String director){
//        if(movieMap.containsKey(movie) && directorMap.containsKey(director)){
//            // your code here
//            List<String> temp=directorMovieMapping.get(director);
//            temp.add(movie);
//            directorMovieMapping.put(director,temp);
//        }
//        else{
//            List<String> temp=new ArrayList<>();
//            temp.add(movie);
//            directorMovieMapping.put(director,temp);
//        }
//    }
//
//    public Movie findMovie(String movie){
//        // your code here
//        if(movieMap.containsKey(movie))
//        return movieMap.get(movie);
//        else
//            return new Movie();
//    }
//
//    public Director findDirector(String director){
//        // your code here
//        if(directorMap.containsKey(director))
//        return directorMap.get(director);
//        else
//            return new Director();
//    }
//
//    public List<String> findMoviesFromDirector(String director){
//        // your code here
//        if(directorMovieMapping.containsKey(director))
//        return directorMovieMapping.get(director);
//        return new ArrayList<>();
//    }
//
//    public List<String> findAllMovies(){
//        return new ArrayList<>(movieMap.keySet());
//    }
//
//    public void deleteDirector(String director){
//        // your code here
//        List<String> movielist = directorMovieMapping.get(director);
//        for(String s : movielist){
//            movieMap.remove(s);
//        }
//        directorMap.remove(director);
//        directorMovieMapping.remove(director);
//    }
//
//    public void deleteAllDirector(){
//        // your code here
//        for(String directorName : directorMovieMapping.keySet()){
//            deleteDirector(directorName);
//        }
//    }
//}
//----------------------------------------------------------------------------------------------
package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {
    HashMap<String,Movie> movieMap;
    HashMap<String,Director> directorMap;
    HashMap<String, List<String>> pairMap;

    public MovieRepository() {
        this.movieMap = new HashMap<>();
        this.directorMap = new HashMap<>();
        this.pairMap =new HashMap<>();
    }

    public void addMovie(Movie movie) {
        movieMap.put(movie.getName(), movie);
    }

    public void addDirector(Director director) {
        directorMap.put(director.getName(), director);
    }

    public void addMovieDirectorPair(String movie, String director) {
        if(pairMap.containsKey(director)){
            List<String> temp=pairMap.get(director);
            temp.add(movie);
            pairMap.put(director,temp);
            //OR
            //pairMap.get(director).add(movie);
        }
        else{
            List<String> temp=new ArrayList<>();
            temp.add(movie);
            pairMap.put(director,temp);
        }
    }

    public Movie getMovieByName(String moviename) {
        return movieMap.get(moviename);
    }

    public Director getDirectorByName(String directorname) {
        return directorMap.get(directorname);
    }

    public List<String> getMoviesByDirectorName(String directorname) {
        return pairMap.get(directorname);
    }

    public List<String> findAllMovies() {
        List<String> allMovies = new ArrayList<>();
        for(String m : movieMap.keySet()){
            allMovies.add(movieMap.get(m).getName());
        }
        return allMovies;
    }

    public void deleteDirectorByName(String director) {
        List<String> movielist = pairMap.get(director);
        for(String s : movielist){
            movieMap.remove(s);
        }
        directorMap.remove(director);
        pairMap.remove(director);
    }

    public void deleteAllDirectors() {
        for(String directorName : pairMap.keySet()){
            deleteDirectorByName(directorName);
        }
    }
}