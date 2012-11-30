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
		String result = "���� ������ ��� " + getName() + "\n";
		while (rentals.hasMoreElements())
		{
			Rental each = (Rental) rentals.nextElement();

			// �������� ���������� ��� ���� ������
			result += "\t" + each.getMovie().getTitle() + "\t"
					+ String.valueOf(each.getCharge()) + "\n";
		}
		// �������� ������ ����������
		result += "����� ������������� ���������� " + getTotalCharge() + "\n";
		result += "�� ���������� " + getTotalFrequentRenterPoints()
				+ " ����� �� ����������";
		return result;
	}

	public String htmlStatement()
	{
		Enumeration rentals = _rentals.elements();
		String result = "<H1>�������� ������ ��� <EM>" + getName()
				+ "</EM></H1><P>\n";
		while (rentals.hasMoreElements())
		{
			Rental each = (Rental) rentals.nextElement();
			// �������� ���������� �� ������ ������
			result += each.getMovie().getTitle() + ": "
					+ String.valueOf(each.getCharge()) + "<BR>\n";
		}
		// �������� ������ ����������
		result += "<P>���� ������������� ���������� <EM>"
				+ String.valueOf(getTotalCharge()) + "</EM><P>\n";
		result += "�� ���� ������ �� ���������� <EM>"
				+ String.valueOf(getTotalFrequentRenterPoints())
				+ "</EM> ����� �� ����������<P>";
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
