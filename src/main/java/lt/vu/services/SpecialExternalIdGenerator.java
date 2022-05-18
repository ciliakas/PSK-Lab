package lt.vu.services;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Specializes;

@Specializes
@ApplicationScoped
public class SpecialExternalIdGenerator extends StandardExternalIdGenerator{

    @Override
    public Integer generateExternalId() {
        Integer externalId = super.generateExternalId();
        return 400000 + externalId;
    }
}