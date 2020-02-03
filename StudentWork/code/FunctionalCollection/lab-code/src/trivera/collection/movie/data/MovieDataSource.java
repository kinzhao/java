package trivera.collection.movie.data;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import trivera.collection.movie.service.Movie;

/**
 * <p>
 * This component and its source code representation are copyright protected and
 * proprietary to Trivera Technologies, LLC, Worldwide D/B/A Trivera
 * Technologies
 *
 * This component and source code may be used for instructional and evaluation
 * purposes only. No part of this component or its source code may be sold,
 * transferred, or publicly posted, nor may it be used in a commercial or
 * production environment, without the express written consent of Trivera
 * Technologies, LLC
 *
 * Copyright (c) 2020 Trivera Technologies, LLC. http://www.triveratech.com
 * </p>
 * 
 * @author Trivera Technologies Tech Team.
 */
public class MovieDataSource {
	private static final SimpleDateFormat DATE_TIME_FORMATTER = new SimpleDateFormat("MM-dd-yyyy");

	private static MovieDataSource currentInstance;

	private Map<String, List<Movie>> moviesByStudio;

	public static MovieDataSource getInstance() {
		if (currentInstance == null) {
			currentInstance = new MovieDataSource();
			currentInstance.readDataFiles();
		}
		return currentInstance;
	}

	public List<Movie> getAllMovies() {
		return moviesByStudio.values().stream().flatMap(lst -> lst.stream()).collect(Collectors.toList());
	}

	public Map<String, List<Movie>> getMoviesByStudio() {
		return moviesByStudio;
	}

	public Set<String> getStudios() {
		return moviesByStudio.keySet();
	}

	private void readDataFiles() {
		List<Movie> movieData = new ArrayList<>();
		try (Stream<String> stream = new BufferedReader(
				new InputStreamReader(getClass().getResourceAsStream("movies.dat"))).lines();) {
			stream.forEach(line -> movieData.add(createObject(line)));
		}

		moviesByStudio = movieData.stream().collect(Collectors.groupingBy(Movie::getStudio));
	}

	private Movie createObject(String data) {
		String[] fields = data.split(";");
		Movie movie = new Movie();
		movie.setId(Integer.parseInt(fields[0]));
		movie.setTitle(fields[1]);
		movie.setStudio(fields[2]);
		movie.setPrice(Double.parseDouble(fields[3]));
		movie.setRating(fields[4]);
		movie.setGenre(fields[5]);

		try {
			movie.setReleaseDate(DATE_TIME_FORMATTER.parse(fields[6]));
		} catch (ParseException e) {
			// ignore
		}

		return movie;

	}

	private MovieDataSource() {
	}
}
