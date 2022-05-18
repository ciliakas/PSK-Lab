package lt.vu.services;

import javax.enterprise.context.ApplicationScoped;
import java.util.Random;
import javax.enterprise.inject.Default;

@Default
@ApplicationScoped
public class StandardExternalIdGenerator implements ExternalIdGenerator {

    public Integer generateExternalId() {
        try {
            Thread.sleep(1500); // Simulate intensive work
        } catch (InterruptedException e) {
        }
        return 100 + new Random().nextInt(100);
    }
}