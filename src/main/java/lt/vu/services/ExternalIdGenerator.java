package lt.vu.services;

import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.util.Random;

@ApplicationScoped
public class ExternalIdGenerator implements Serializable {

    public Integer generateExternalId() {
        try {
            Thread.sleep(1500); // Simulate intensive work
        } catch (InterruptedException e) {
        }
        return 100 + new Random().nextInt(900);
    }
}