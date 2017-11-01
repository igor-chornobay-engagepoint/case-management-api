package gov.ca.cwds.cm.inject;

import com.google.common.collect.ImmutableList;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import gov.ca.cwds.cm.CmApiConfiguration;
import gov.ca.cwds.inject.CmsHibernateBundle;
import gov.ca.cwds.inject.CmsSessionFactory;
import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.hibernate.SessionFactoryFactory;
import io.dropwizard.setup.Bootstrap;
import org.hibernate.SessionFactory;

import static gov.ca.cwds.cm.Constants.UnitOfWork.CMS;
import static gov.ca.cwds.cm.Constants.UnitOfWork.XA_CMS;

/** @author CWDS TPT-3 Team */
public class DataAccessModule extends AbstractModule {

  private final ImmutableList<Class<?>> cmsEntities = ImmutableList.<Class<?>>builder().add(
//      Client.class
  ).build();


  private final HibernateBundle<CmApiConfiguration> cmsHibernateBundle =
      new HibernateBundle<CmApiConfiguration>(cmsEntities, new SessionFactoryFactory()) {
        @Override
        public PooledDataSourceFactory getDataSourceFactory(CmApiConfiguration configuration) {
          return configuration.getCmsDataSourceFactory();
        }

        @Override
        public String name() {
          return CMS;
        }
      };

//  private final HibernateBundle<CmApiConfiguration> xaCmsHibernateBundle =
//      new HibernateBundle<CmApiConfiguration>(cmsEntities, new SessionFactoryFactory()) {
//        @Override
//        public PooledDataSourceFactory getDataSourceFactory(CmApiConfiguration configuration) {
//          return configuration.getXaCmsDataSourceFactory();
//        }
//
//        @Override
//        public String name() {
//          return XA_CMS;
//        }
//      };


  public DataAccessModule(Bootstrap<? extends CmApiConfiguration> bootstrap) {
    bootstrap.addBundle(cmsHibernateBundle);
//    bootstrap.addBundle(xaCmsHibernateBundle);
  }

  @Override
  protected void configure() {
    //do nothing
  }

  @Provides
  @CmsSessionFactory
  SessionFactory cmsSessionFactory() {
    return cmsHibernateBundle.getSessionFactory();
  }

//  @Provides
//  @XaCmsSessionFactory
//  SessionFactory xaCmsSessionFactory() {
//    return xaCmsHibernateBundle.getSessionFactory();
//  }


  @Provides
  @CmsHibernateBundle
  public HibernateBundle<CmApiConfiguration> getCmsHibernateBundle() {
    return cmsHibernateBundle;
  }

//  @Provides
//  @XaCmsHibernateBundle
//  public HibernateBundle<CmApiConfiguration> getXaCmsHibernateBundle() {
//    return xaCmsHibernateBundle;
//  }

}
