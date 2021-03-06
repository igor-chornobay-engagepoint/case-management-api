package gov.ca.cwds.cm.inject;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;
import io.dropwizard.hibernate.UnitOfWorkAwareProxyFactory;

/**
 * @author CWDS TPT-3 Team
 */

public abstract class AbstractInjectProvider<T> implements Provider<T> {

  private final UnitOfWorkAwareProxyFactory unitOfWorkAwareProxyFactory;
  private Injector injector;

  @Inject
  public AbstractInjectProvider(Injector injector,
      UnitOfWorkAwareProxyFactory unitOfWorkAwareProxyFactory) {
    this.injector = injector;
    this.unitOfWorkAwareProxyFactory = unitOfWorkAwareProxyFactory;
  }

  public abstract Class<T> getServiceClass();

  @Override
  public T get() {
    T service = unitOfWorkAwareProxyFactory.create(getServiceClass());
    injector.injectMembers(service);
    return service;
  }
}

