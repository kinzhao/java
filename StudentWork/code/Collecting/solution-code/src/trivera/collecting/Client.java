package trivera.collecting;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;

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
public class Client {

	public static void main(String[] args) {
		Client client = new Client();
		client.client();

	}

	public void client() {
		MovieService service = new MovieService();

		Map<String, Long> movieCountByGenre = service.getMovieCountByGenre();

		for (String genre : movieCountByGenre.keySet()) {
			String msg = String.format("Genre '%s' contains %d Movies", genre, movieCountByGenre.get(genre));
			System.out.println(msg);
		}

		System.out.println("--------------------------------------------");

		DoubleSummaryStatistics priceStatistics = service.getPriceStatistics();
		System.out.println("Price Information:");
		System.out.println(String.format("%s:   %6.2f", "Average", priceStatistics.getAverage()));
		System.out.println(String.format("%s:   %6.2f", "Minimum", priceStatistics.getMin()));
		System.out.println(String.format("%s:   %6.2f", "Maximum", priceStatistics.getMax()));
		System.out.println(String.format("%s:   %6.2f", "Total Inventory:", priceStatistics.getSum()));

		System.out.println("--------------------------------------------");
		List<MovieInfo> onSaleMovieInfo = service.getOnSaleMovieInfo();

		for (MovieInfo info : onSaleMovieInfo) {
			System.out.println(info);
		}
		System.out.println(onSaleMovieInfo.size());
	}
}
