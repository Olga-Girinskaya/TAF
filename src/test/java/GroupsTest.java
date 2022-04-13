import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupsTest {
    @Test (groups = "smoke")
    public void stepb(){
        System.out.println("stepb...");
    }

    @Test  (groups = "regression")
    public void stepa(){
        System.out.println("stepa...");
    }
    @Test (groups = "regression")
    public void stepd(){
        System.out.println("stepd...");
    }

    @Test (groups = {"regression","smoke"})
    public void stepc(){
        System.out.println("stepc...");
    }
}

