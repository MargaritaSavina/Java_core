package sem1.task;

import sem1.task.output1.OutByPoint;
import sem1.task.output2.OutBySpace;

public class Hello {
    public static void main(String[] args) {
        String str = "Hello, how are you?";
        new OutByPoint().printByPoint(str);
        System.out.println();
        new OutBySpace().printBySpace(str);
    }
}
