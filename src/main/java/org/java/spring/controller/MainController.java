package org.java.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.java.spring.pojo.Movie;
import org.java.spring.pojo.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String routeHome(Model model) {
		
		String dev = "FrancescoB.";
		
		model.addAttribute("dev", dev);
		
		return "Home";
	}
	
	@GetMapping("/movie")
	public String routeMovie(Model model) {
		
		List<Movie>bestMovies = getBestMovies();
		
//		String strBestMovies = "";
//		
//		for(int x = 0; x < bestMovies.size();x++) {
//			
//			if(x>0) {
//				strBestMovies+=", ";
//			}
//			
//			strBestMovies += bestMovies.get(x).getTitle();
//			
//		}
//		
//		model.addAttribute("movies", strBestMovies);
		
		model.addAttribute("movies", getBestMovies());
		
		return "MoviesPage";
	}
	
	@GetMapping("/movie/{id}")
	public String routeSingleMovie(Model model, @PathVariable int id) throws Exception {
		
		model.addAttribute("movie", getBestMovies(id));
		
		return "SingleMoviePage";
	}

	@GetMapping("/song")
	public String routeSong(Model model) {
		
		List<Song>bestSongs = getBestSongs();
		
//		String strBestSongs ="" ;
//		for(int x = 0; x < bestSongs.size();x++) {
//			
//			if(x>0) {
//				strBestSongs+=", ";
//			}
//			
//			strBestSongs+=bestSongs.get(x).getTitle();
//			
//		}
//		
//		model.addAttribute("songs", strBestSongs);
		model.addAttribute("songs", getBestSongs());
		
		return "SongsPage";
	}
	
	
	@GetMapping("/song/{id}")
	public String routeSingleSong(Model model, @PathVariable int id) throws Exception {
		
		model.addAttribute("song", getBestSongs(id));
		
		return "SingleSongPage";
	}
	

	
	
	
	private List<Movie> getBestMovies() {
		
		List<Movie> bestMovies = new ArrayList<Movie>();
		
		Movie movie1=new Movie(1,"Lorem");
		Movie movie2=new Movie(2,"Ipsum");
		Movie movie3=new Movie(3,"Dolor");
		Movie movie4=new Movie(4,"Sit");

		bestMovies.add(movie1);
		bestMovies.add(movie2);
		bestMovies.add(movie3);
		bestMovies.add(movie4);
		return bestMovies;
	}
	
	private Movie getBestMovies(int id) throws Exception {
		
		List<Movie> bestMovies=getBestMovies();
		
		Movie singleBestMovie = null;
		for(Movie m : bestMovies) {
			
			if(m.getId()==id) {
				singleBestMovie= m;
			}
			
		}
		
		if(singleBestMovie != null) return singleBestMovie;
		else throw new Exception("error 404: no movie found");
		
	}
	
	private	List<Song> getBestSongs() {
		
		List<Song> bestSongs = new ArrayList<Song>();
		
		Song song1=new Song(1,"Amet");
		Song song2=new Song(2,"Persecutur");
		Song song3=new Song(3,"Pippo");
		Song song4=new Song(4,"Franco");

		bestSongs.add(song1);
		bestSongs.add(song2);
		bestSongs.add(song3);
		bestSongs.add(song4);
		
		return bestSongs;
	}
	
	private Song getBestSongs(int id) throws Exception {
		
		List<Song> bestSongs=getBestSongs();
		
		Song singleBestSong = null;
		for(Song s : bestSongs) {
			
			if(s.getId()==id) {
				singleBestSong= s;
			}
			
		}
		
		if(singleBestSong != null) return singleBestSong;
		else throw new Exception("error 404: no song found");
		
	}

}
