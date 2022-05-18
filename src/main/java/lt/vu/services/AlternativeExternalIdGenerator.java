package lt.vu.services;

import lt.vu.interceptors.LoggedInvocation;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import java.util.Random;

@Alternative
@ApplicationScoped
public class AlternativeExternalIdGenerator implements ExternalIdGenerator {

    @LoggedInvocation
    public Integer generateExternalId() {
        try {
            Thread.sleep(1500); // Simulate intensive work
        } catch (InterruptedException e) {
        }
        return 2500 + new Random().nextInt(500);
    }
}