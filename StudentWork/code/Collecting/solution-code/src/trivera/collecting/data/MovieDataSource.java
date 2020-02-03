package trivera.collecting.data;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.util.zip.ZipInputStream;

import trivera.collecting.Movie;

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
public class MovieDataSource {
	private static final SimpleDateFormat DATE_TIME_FORMATTER = new SimpleDateFormat("MM-dd-yyyy");

	private static List<Movie> movieData = null;

	/**
	 * Return a Stream of all available Movie instances
	 * 
	 * @return A Stream of Movies
	 */
	public static final Stream<Movie> getAllMovies() {
		if (movieData == null) {
			movieData = new ArrayList<>();

			try (Stream<String> stream = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(extract())))
					.lines();) {
				stream.forEach(line -> movieData.add(createObject(line)));
			} catch (IOException ioe) {
				throw new RuntimeException(ioe);
			}
		}
		return movieData.stream();
	}

	// Internal use, do NOT Edit

	/**
	 * Create a Movie instance from a single input line
	 * 
	 * @param data
	 *            a semicolon separated list of movie data
	 * @return a Movie instance
	 */
	private static Movie createObject(String data) {
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

	/**
	 * Extract the data file
	 * 
	 * @return The extracted data
	 * @throws IOException
	 */
	private static byte[] extract() throws IOException {
		InputStream source = MovieDataSource.class.getResourceAsStream("movie.data");
		final ZipInputStream zipStream = new ZipInputStream(source);
		zipStream.getNextEntry();
		try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
			byte[] bytesIn = new byte[1024];
			int read = 0;
			while ((read = zipStream.read(bytesIn)) != -1) {
				baos.write(bytesIn, 0, read);
			}
			return baos.toByteArray();
		} catch (IOException ioe) {
			throw new RuntimeException(ioe);
		}

	}

}
