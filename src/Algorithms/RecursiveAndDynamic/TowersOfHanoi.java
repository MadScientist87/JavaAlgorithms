package Algorithms.RecursiveAndDynamic;

public class TowersOfHanoi {
    public static void tower(int disks, String from, String to, String aux)
    {
        if(disks == 1) {
            System.out.println("moved disk " + disks + " from " + from + " to " + to);
            return;
        }

        tower(disks -1,from,aux,to);
        System.out.println("moved disk " + disks + " from " + from + " to " + to);
        tower(disks-1, aux,to,from);
    }
}
