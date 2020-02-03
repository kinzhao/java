package trivera.collection.movie.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import trivera.collection.movie.service.Movie;
import trivera.collection.movie.service.MovieService;

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
public class MovieServiceTest {
	public static final String DREAMWORKS_STUDIO_NAME = "DreamWorks Animated";

	private MovieService movieService = new MovieService();

	@Test
	public void testGetMoviesByStudio() {
		List<Movie> dreamWorksMovies = movieService.getMoviesByStudio(DREAMWORKS_STUDIO_NAME);
		List<Movie> doesNotExist = movieService.getMoviesByStudio("Does not exist");
		List<Movie> doesNotExist2 = movieService.getMoviesByStudio("Does not exist");

		assertThat(dreamWorksMovies.size(), is(43));
		assertThat(doesNotExist.size(), is(0));
		assertThat(doesNotExist2.size(), is(0));

	}

	@Test
	public void addStudioIfAbsent() {
		List<Movie> dreamWorksMovies = movieService.addStudioIfAbsent(DREAMWORKS_STUDIO_NAME);
		List<Movie> doesNotExist = movieService.addStudioIfAbsent("New Studio");
		List<Movie> doesNotExist2 = movieService.addStudioIfAbsent("New Studio");

		assertThat(dreamWorksMovies.size(), is(43));
		assertThat(doesNotExist.size(), is(0));
		assertThat(doesNotExist2, sameInstance(doesNotExist));

	}

	@Test
	public void testGetAllMovies() {
		List<Movie> allMovies = movieService.getAllMovies();
		assertThat(allMovies.size(), is(38012));
	}

	@Test
	public void testMoviesSortedByStudioOrder() {
		List<Movie> allMovies = movieService.getAllMovies();
		String currentStudio = "";

		for (Movie movie : allMovies) {
			String movieStudio = movie.getStudio();
			if (!movieStudio.equals(currentStudio)) {

				if (movie.getStudio().compareTo(currentStudio) < 0) {
					Assert.fail("Movies not sorted by Studio");
				}
				currentStudio = movie.getStudio();
			}
		}
	}

	@Test
	public void testMoviesSortedByTitleOrder() {
		List<Movie> allMovies = movieService.getAllMovies();
		String currentStudio = "";
		String movieTitle = "";

		for (Movie movie : allMovies) {
			String movieStudio = movie.getStudio();
			if (!movieStudio.equals(currentStudio)) {
				currentStudio = movie.getStudio();
				movieTitle = "";
			}
			if (movie.getTitle().compareTo(movieTitle) < 0) {
				Assert.fail("Movies not sorted by Title");
			}
			movieTitle = movie.getTitle();
		}
	}

	@Test
	public void testNumberOfMoviesByStudio() {
		Map<String, Integer> map = movieService.getNumberOfMoviesByStudio();

		assertThat(map.get("DreamWorks"), is(762));
		assertThat(map.get("Universal"), is(4892));
		assertThat(map.get("DreamWorks Animated"), is(43));
		assertThat(map.get("Lions Gate"), is(2336));
		assertThat(map.get("Warner Brothers"), is(8694));
		assertThat(map.get("Columbia/Tri-Star"), is(2724));
		assertThat(map.get("MGM/UA"), is(3131));
		assertThat(map.get("Paramount"), is(6928));
		assertThat(map.get("Miramax Lions Gate"), is(293));
		assertThat(map.get("Sony Pictures"), is(2408));
		assertThat(map.get("Fox"), is(5801));

	}
}
