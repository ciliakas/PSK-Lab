package lt.vu.services;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

@Decorator
public abstract class LocalExternalIdGeneratorDecorator implements ExternalIdGenerator {

    @Inject
    @Delegate
    @Any
    ExternalIdGenerator isbnGenerator;

    public Integer generateExternalId() {
        Integer externalId = isbnGenerator.generateExternalId();
        return 30000 + externalId;
    }
}