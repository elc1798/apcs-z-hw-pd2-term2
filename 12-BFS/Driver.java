public class Driver {
    public static void main(String[] args) {
        long startTime , endTime;

        BFSMaze maze1 = new BFSMaze("MAZE1.dat");
        startTime = System.nanoTime();

        maze1.solve();

        endTime = System.nanoTime() - startTime;

        System.out.println("Solved in " + nanoToMillis(endTime) + " milliseconds.");
        maze1.printSolution();
        System.out.println();

        BFSMaze maze2 = new BFSMaze("MAZE2.dat");
        startTime = System.nanoTime();

        maze2.solve();

        endTime = System.nanoTime() - startTime;

        System.out.println("Solved in " + nanoToMillis(endTime) + " milliseconds.");
        maze2.printSolution();
        System.out.println();

        BFSMaze maze3 = new BFSMaze("MAZE3.dat");
        startTime = System.nanoTime();

        maze3.solve();

        endTime = System.nanoTime() - startTime;

        System.out.println("Solved in " + nanoToMillis(endTime) + " milliseconds.");
        maze3.printSolution();
        System.out.println();
    }

    private static String nanoToMillis(long nano) {
        String tmp = Long.toString(nano);
        while (tmp.length() < 6) {
            tmp = "0" + tmp;
        }
        return tmp.substring(0 , tmp.length() - 6) + "." + tmp.substring(tmp.length() - 6);
    }
}
