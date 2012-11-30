package refactoring;

import java.util.Enumeration;
import java.util.Vector;

class Customer
{
	private String _name;
	private Vector _rentals = new Vector();

	public Customer(String name)
	{
		_name = name;
	};

	public void addRental(Rental arg)
	{
		_rentals.addElement(arg);
	}

	public String statement()
	{
		Enumeration rentals = _rentals.elements();
		String result = "Учет аренды для " + getName() + "\n";
		while (rentals.hasMoreElements())
		{
			Rental each = (Rental) rentals.nextElement();

			// показать результаты для этой аренды
			result += "\t" + each.getMovie().getTitle() + "\t"
					+ String.valueOf(each.getCharge()) + "\n";
		}
		// добавить нижний колонтитул
		result += "Сумма задолженности составляет " + getTotalCharge() + "\n";
		result += "Вы заработали " + getTotalFrequentRenterPoints()
				+ " очков за активность";
		return result;
	}

	private double getTotalCharge()
	{
		double result = 0;
		Enumeration rentals = _rentals.elements();
		while (rentals.hasMoreElements())
		{
			Rental each = (Rental) rentals.nextElement();
			result += each.getCharge();
		}
		return result;
	}

	private int getTotalFrequentRenterPoints()
	{
		int result = 0;
		Enumeration rentals = _rentals.elements();
		while (rentals.hasMoreElements())
		{
			Rental each = (Rental) rentals.nextElement();
			result += each.getFrequentRenterPoints();
		}
		return result;
	}

	public String getName()
	{
		return _name;
	}
}
