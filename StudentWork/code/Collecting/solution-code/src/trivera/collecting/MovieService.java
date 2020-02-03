package trivera.collecting;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summarizingDouble;
import static java.util.stream.Collectors.toList;
import static trivera.collecting.data.MovieDataSource.getAllMovies;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
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

	public Map<String, Long> getMovieCountByGenre() {
		Stream<Movie> movies = getAllMovies();

		return movies.collect(groupingBy(Movie::getGenre, counting()));
	}

	public DoubleSummaryStatistics getPriceStatistics() {
		Stream<Movie> movies = getAllMovies();
		DoubleSummaryStatistics statistics = movies.collect(summarizingDouble(Movie::getPrice));
		return statistics;
	}

	public List<MovieInfo> getOnSaleMovieInfo() {
		Stream<Movie> movies = getAllMovies();
		return movies.filter(Movie::isOnSale).map(movie -> new MovieInfo(movie.getTitle(), movie.getPrice()))
				.collect(toList());
	}
}
