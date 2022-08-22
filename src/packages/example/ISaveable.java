package packages.example;

import java.util.List;

/**
 * interface defines what needs to be done
 * doesn't define how it's done
 * cannot instantiate interface
 */
public interface ISaveable {
    List<String> write();//abstracted don't force only one use any type of list

    void read(List<String> list);
}
