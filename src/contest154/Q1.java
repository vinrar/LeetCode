package contest154;

public class Q1 {
    public static void main(String[] args) {
        System.out.println(maxNumberOfBalloons("bbaalllloooonn"));
    }

    public static int maxNumberOfBalloons(String text) {

        int bc = 0, ac = 0, nc = 0, lc = 0, oc = 0;

        for(int i = 0; i < text.length(); i++) {
            char inp = text.charAt(i);

            switch(inp) {
                case 'b':
                    bc += 1;
                    break;
                case 'a':
                    ac += 1;
                    break;
                case 'l':
                    lc += 1;
                    break;
                case 'o':
                    oc += 1;
                    break;
                case 'n':
                    nc += 1;
                    break;
            }
        }

        oc = oc / 2;
        lc = lc / 2;

        return Math.min(bc, Math.min(ac, Math.min(lc, Math.min(oc, nc))));
    }
}
