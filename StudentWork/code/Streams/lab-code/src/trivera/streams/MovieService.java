package trivera.streams;

import static trivera.streams.data.MovieDataSource.getAllMovies;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * <p>
 * This component and its source code representation are copyright protected and
 * proprietary to Trivera Technologies, LLC, Worldwide D/B/A Trivera
 * Technologies
 *
 * This component and source code may be used for instructional and evaluation
 * purposes only. No part of this component or its source code may be sold,
 * transferred, or publicly posted, nor may it be used in a commercial or
 * production environment, without the express written consent of the Trivera
 * Group, Inc.
 *
 * Copyright (c) 2020 Trivera Technologies, LLC. http://www.triveratech.com
 * 
 * </p>
 * 
 * @author Trivera Technologies Tech Team.
 */
public class MovieService {

	/**
	 * Return the number of Movies in the entire stream
	 * 
	 * @return the number of movies
	 */
	public long getMovieCount() {
		Stream<Movie> movies = getAllMovies();

		return 0;
	}

	/**
	 * Filter out just the Movies that were produced by the given studio
	 * 
	 * @param studio
	 *            The studio
	 * @return A list of 0 or more Movies
	 */
	public List<Movie> getMoviesByStudio(String studio) {
		Stream<Movie> movies = getAllMovies();

		return Collections.EMPTY_LIST;
	}

	/**
	 * Get a SORTED list of all available genres (no duplicates!)
	 * 
	 * @return A list of 0 or more genres
	 * 
	 */
	public List<String> getGenres() {
		Stream<Movie> movies = getAllMovies();

		return Collections.EMPTY_LIST;
	}

	/**
	 * Get the minimum Movie price
	 * 
	 * @return a price
	 */
	public double getMinimumPrice() {
		Stream<Movie> movies = getAllMovies();

		return 0.0;
	}

	/**
	 * Find a Movie that contains the given searchValue in the title
	 * 
	 * @param searchValue
	 *            the value to search for
	 * @return Optionally a Movie
	 */
	public Optional<Movie> findMovieByTitle(String searchValue) {
		Stream<Movie> movies = getAllMovies();

		return Optional.empty();
	}
}
