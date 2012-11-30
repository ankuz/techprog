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
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Enumeration rentals = _rentals.elements();
		String result = "”чет аренды дл€ " + getName() + "\n";
		while (rentals.hasMoreElements())
		{
			Rental each = (Rental) rentals.nextElement();

			// добавить очки дл€ активного арендатора
			frequentRenterPoints++;
			// бонус за аренду новинки на два дн€
			if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE)
					&& each.getDaysRented() > 1)
				frequentRenterPoints++;
			// показать результаты дл€ этой аренды
			result += "\t" + each.getMovie().getTitle() + "\t"
					+ String.valueOf(each.getCharge()) + "\n";
			totalAmount += each.getCharge();
		}
		// добавить нижний колонтитул
		result += "—умма задолженности составл€ет "
				+ String.valueOf(totalAmount) + "\n";
		result += "¬ы заработали " + String.valueOf(frequentRenterPoints)
				+ " очков за активность";
		return result;
	}

	public String getName()
	{
		return _name;
	}
}
