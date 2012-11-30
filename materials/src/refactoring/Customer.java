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
			double thisAmount = 0;
			Rental each = (Rental) rentals.nextElement();
			thisAmount = amountFor(each);

			// добавить очки дл€ активного арендатора
			frequentRenterPoints++;
			// бонус за аренду новинки на два дн€
			if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE)
					&& each.getDaysRented() > 1)
				frequentRenterPoints++;
			// показать результаты дл€ этой аренды
			result += "\t" + each.getMovie().getTitle() + "\t"
					+ String.valueOf(thisAmount) + "\n";
			totalAmount += thisAmount;
		}
		// добавить нижний колонтитул
		result += "—умма задолженности составл€ет "
				+ String.valueOf(totalAmount) + "\n";
		result += "¬ы заработали " + String.valueOf(frequentRenterPoints)
				+ " очков за активность";
		return result;
	}

	private double amountFor(Rental aRental)
	{
		double result = 0;
		switch (aRental.getMovie().getPriceCode())
		{
			case Movie.REGULAR:
				result += 2;
				if (aRental.getDaysRented() > 2)
					result += (aRental.getDaysRented() - 2) * 1.5;
				break;
			case Movie.NEW_RELEASE:
				result += aRental.getDaysRented() * 3;
				break;
			case Movie.CHILDRENS:
				result += 1.5;
				if (aRental.getDaysRented() > 3)
					result += (aRental.getDaysRented() - 3) * 1.5;
				break;
		}
		return result;
	}

	public String getName()
	{
		return _name;
	}
}
