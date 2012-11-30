package refactoring;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class CustomerTest extends TestCase
{
	private Customer customer;
	private Movie movie;
	private Rental rental;
	
	@Before
	public void setUp(){
		movie = new Movie("MovieName", 100);
		
		rental = new Rental(movie, 7);
		
		customer = new Customer("CustomerName");
		
		customer.addRental(rental);
	}
	
	@Test
	public void testStatement()
	{
		assertEquals(
				"Учет аренды для CustomerName\n	MovieName	0.0\nСумма задолженности составляет 0.0\nВы заработали 1 очков за активность",
				customer.statement());
	}
	
	@Test
	public void testRegularMovieStatement()
	{
		movie.setPriceCode(Movie.REGULAR);
		assertEquals(
				"Учет аренды для CustomerName\n	MovieName	9.5\nСумма задолженности составляет 9.5\nВы заработали 1 очков за активность",
				customer.statement());
	}
	
	@Test
	public void testNewReleaseMovieStatement()
	{
		movie.setPriceCode(Movie.NEW_RELEASE);
		assertEquals(
				"Учет аренды для CustomerName\n	MovieName	21.0\nСумма задолженности составляет 21.0\nВы заработали 2 очков за активность",
				customer.statement());
	}

}
