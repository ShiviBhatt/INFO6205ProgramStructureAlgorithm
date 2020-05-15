package Assignment1Work;

public class RecursionExample1 {
	public String reverse(String s, int index) {
		
		if(index == s.length()) {
			return "" ;
		}
		String temp =  reverse(s, index + 1);
		temp = temp + s.charAt(index);
		return temp;
	}
 
	public static void main(String args[]) {
		RecursionExample1 obj = new RecursionExample1();
		String result = obj.reverse("Shivi", 0);
		System.out.println(result);
	}
}

//Seventh call
//return "" line 10


//Sixth call
//temp = reverse("Shivi", 5)
//temp = "";
//temp = "" + i;
//return temp
//line 13

//Fifth call
//temp = reverse("Shivi", 4)
//temp = "i";
//temp = "i" + "v";
//line 13

//Fourth call
//reverse("Shivi", 3)
//line 13

//Third call
//reverse("Shivi", 2)
//line 13

//Second Call
//reverse("Shivi", 1);
//line 13

//First call
//reverse("Shivi", 0);
//line 13

