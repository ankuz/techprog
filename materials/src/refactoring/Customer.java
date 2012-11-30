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
		String result = "���� ������ ��� " + getName() + "\n";
		while (rentals.hasMoreElements())
		{
			Rental each = (Rental) rentals.nextElement();

			frequentRenterPoints += each.getFrequentRenterPoints();
			
			// �������� ���������� ��� ���� ������
			result += "\t" + each.getMovie().getTitle() + "\t"
					+ String.valueOf(each.getCharge()) + "\n";
			totalAmount += each.getCharge();
		}
		// �������� ������ ����������
		result += "����� ������������� ���������� "
				+ String.valueOf(totalAmount) + "\n";
		result += "�� ���������� " + String.valueOf(frequentRenterPoints)
				+ " ����� �� ����������";
		return result;
	}

	public String getName()
	{
		return _name;
	}
}
