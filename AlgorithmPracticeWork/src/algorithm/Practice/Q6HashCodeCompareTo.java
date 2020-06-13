package algorithm.Practice;

import java.util.Date;

public class Q6HashCodeCompareTo implements Comparable<Q6HashCodeCompareTo> {

	private String name;
	private int id;
	private Date birth;

	public Q6HashCodeCompareTo(String name, int id, Date birth) {
		this.name = name;
		this.id = id;
		this.birth = birth;
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (other == null || (this.getClass() != other.getClass())) {
			return false;
		}

		Q6HashCodeCompareTo guest = (Q6HashCodeCompareTo) other;
		return (this.id == guest.id) && (this.name != null && name.equals(guest.name))
				&& (this.birth != null && birth.equals(guest.birth));
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + id;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (birth != null ? birth.hashCode() : 0);
		return result;
	}

	@Override
	public int compareTo(Q6HashCodeCompareTo o) {
		return this.id - o.id;
	}

	public static void main(String[] args) {
		Date d = new Date(2000, 10, 10);
		Date d1 = new Date(1995, 10, 10);
		Date d2 = new Date(2000, 10, 10);

		Q6HashCodeCompareTo obj = new Q6HashCodeCompareTo("Shivi", 1, d);
		Q6HashCodeCompareTo obj1 = new Q6HashCodeCompareTo("Shivi", 3, d1);
		Q6HashCodeCompareTo obj2 = new Q6HashCodeCompareTo("Shivi", 1, d2);
		Q6HashCodeCompareTo obj3 = new Q6HashCodeCompareTo("Shivi", 1, d);
		System.out.println(obj1.equals(obj2));
		System.out.println(obj.equals(obj2));
		System.out.println(obj1.compareTo(obj2));
		System.out.println(obj.compareTo(obj2));
		System.out.println(obj3.compareTo(obj1));
		System.out.println(obj.hashCode());
		System.out.println(obj1.hashCode());
		System.out.println(obj2.hashCode());
	}

}
