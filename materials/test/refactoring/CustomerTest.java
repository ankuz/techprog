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
	
	@Test
	public void testHTMLStatement()
	{
		assertEquals(
				"<H1>Операции аренды для <EM>CustomerName</EM></H1><P>\nMovieName: 0.0<BR>\n<P>Ваша задолженность составляет <EM>0.0</EM><P>\nНа этой аренде вы заработали <EM>1</EM> очков за активность<P>",
				customer.htmlStatement());
	}
	
	@Test
	public void testRegularMovieHTMLStatement()
	{
		movie.setPriceCode(Movie.REGULAR);
		assertEquals(
				"<H1>Операции аренды для <EM>CustomerName</EM></H1><P>\nMovieName: 9.5<BR>\n<P>Ваша задолженность составляет <EM>9.5</EM><P>\nНа этой аренде вы заработали <EM>1</EM> очков за активность<P>",
				customer.htmlStatement());
	}
	
	@Test
	public void testNewReleaseMovieHTMLStatement()
	{
		movie.setPriceCode(Movie.NEW_RELEASE);
		assertEquals(
				"<H1>Операции аренды для <EM>CustomerName</EM></H1><P>\nMovieName: 21.0<BR>\n<P>Ваша задолженность составляет <EM>21.0</EM><P>\nНа этой аренде вы заработали <EM>2</EM> очков за активность<P>",
				customer.htmlStatement());
	}

}
