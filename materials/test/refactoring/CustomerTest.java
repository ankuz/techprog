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
				"���� ������ ��� CustomerName\n	MovieName	0.0\n����� ������������� ���������� 0.0\n�� ���������� 1 ����� �� ����������",
				customer.statement());
	}
	
	@Test
	public void testRegularMovieStatement()
	{
		movie.setPriceCode(Movie.REGULAR);
		assertEquals(
				"���� ������ ��� CustomerName\n	MovieName	9.5\n����� ������������� ���������� 9.5\n�� ���������� 1 ����� �� ����������",
				customer.statement());
	}
	
	@Test
	public void testNewReleaseMovieStatement()
	{
		movie.setPriceCode(Movie.NEW_RELEASE);
		assertEquals(
				"���� ������ ��� CustomerName\n	MovieName	21.0\n����� ������������� ���������� 21.0\n�� ���������� 2 ����� �� ����������",
				customer.statement());
	}

}
