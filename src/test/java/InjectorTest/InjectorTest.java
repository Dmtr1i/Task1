package InjectorTest;

import CSVWorker.CSVWorker;
import Contracts.Contract;
import Injector.Injector;
import org.junit.Test;
import static org.junit.Assert.*;

public class InjectorTest {
    @Test
    public void inject() throws Exception {
        Injector injector = new Injector();
        CSVWorker<Contract> csv = injector.inject(new CSVWorker<Contract>());
        assertEquals("CSVWorker", csv.getClass().getSimpleName());
    }
}
