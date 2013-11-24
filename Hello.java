
public class Hello {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		perm("ABC");

	}
	
	public static String perm(String str) {
		if (str.length() == 0) {
			return "";
		}
		StringBuilder builder = new StringBuilder();
		String result = null;
		for (int i=0; i < str.length(); i++) {
			String subString = str.substring(0, i) + str.substring(i+1, str.length());
			System.out.println("String being worked on is " + str);
			result = str.charAt(i) + perm(subString);
			if (subString.length() == 1) {
				builder.append(result).append("\n");
			}	
		}
		if (str.length() == 3) {
			System.out.println(builder);
		}
		else {
			
			return result;
		}
		return null;
	}

}
