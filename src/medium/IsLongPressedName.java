package medium;

/***
 * Worst piece of code I've ever written. Does the job.
 */
public class IsLongPressedName {
    public static void main(String[] args) {
//        System.out.println(isLongPressedName("alex", "aleex"));
//        System.out.println(isLongPressedName("saeed", "ssaaedd"));
//        System.out.println(isLongPressedName("leelee", "lleeelee"));
//        System.out.println(isLongPressedName("laiden", "laiden"));
        System.out.println(isLongPressedName("pyplrz", "ppyypllr"));
    }

    public static boolean isLongPressedName(String name, String typed) {
        if(typed.length() < name.length())
            return false;

        int j = 0, i = 0, nameCount = 0, typedCount = 0;
        boolean check = false, check2 = false;
        for(; i < name.length() && j < typed.length(); i++, j++) {

            check = false; check2 = false;
            nameCount = 0; typedCount = 0;

            while(i < name.length() - 1 && name.charAt(i) == name.charAt(i + 1)) {
                nameCount += 1;
                i++;
                check = true;
            }

            while(j < typed.length() - 1 && typed.charAt(j) == typed.charAt(j + 1)) {
                typedCount += 1;
                check2 = true;
                j++;
            }

            if(check2) {
                j--;
            }

            if(name.charAt(i) == typed.charAt(j) && nameCount <= typedCount) {
                if(check2)
                    j++;
                continue;
            } else {
                return false;
            }
        }

        if(i < name.length() && j == typed.length()) {
            return false;
        }

        return true;
    }
}