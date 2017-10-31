package gov.ca.cwds.cm;

import com.fasterxml.jackson.annotation.JsonProperty;
import gov.ca.cwds.rest.MinimalApiConfiguration;
import io.dropwizard.db.DataSourceFactory;

public class CmApiConfiguration extends MinimalApiConfiguration {

  private DataSourceFactory cmDataSourceFactory;

  private boolean upgardeDbOnStart = false;

  @JsonProperty
  public DataSourceFactory getCmDataSourceFactory() {
    return cmDataSourceFactory;
  }

  public void setCmDataSourceFactory(DataSourceFactory cmDataSourceFactory) {
    this.cmDataSourceFactory = cmDataSourceFactory;
  }

  @JsonProperty
  public boolean isUpgradeDbOnStart() {
    return upgardeDbOnStart;
  }

  public void setUpgardeDbOnStart(boolean upgardeDbOnStart) {
    this.upgardeDbOnStart = upgardeDbOnStart;
  }

}
