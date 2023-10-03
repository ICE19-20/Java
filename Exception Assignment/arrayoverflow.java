public class arrayoverflow {
    public static void main(String[] args) {
        int[] array = new int[5];
        try {
            try {
                array[5] = 100;
                // System.out.println(array[3]);
            } catch (Exception e) {
                // System.out.println("");
                // System.out.println(e);
                throw new Exception("sorry array was wrong, forgive that");

            }
        } catch (Exception er) {
            System.out.println(er);
        }
        // finally {
        // System.out.println("Not worked");
        // }
    }
}
