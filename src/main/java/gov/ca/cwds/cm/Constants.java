package gov.ca.cwds.cm;

/**
 * @author CWDS TPT-3 Team
 */
public final class Constants {

  public static final String Y = "Y";

  public static final String N = "N";

  public static final String SPACE = " ";

  public static final String SQL_TYPE = "sqlType";

  public static final String RETURNED_CLASS_NAME_PARAM = "returnedClassName";

  private Constants() {
  }

  public static class API {

    public static final String SYSTEM_INFORMATION_PATH = "system-information";

    public static final String TEMPLATE_INSTANCES_PATH = "cm/instances";
    public static final String TEMPLATE_INSTANCE_TAG = "cm-instances";

    private API() {
    }

    public static class PathParams {

      public static final String TEMPLATE_NAME_PARAMETER = "templateName";
      public static final String TEMPLATE_ID_PARAMETER = "templateId";


      private PathParams() {
      }
    }
  }

  public static class ExpectedExceptionMessages {

    private ExpectedExceptionMessages() {
    }

  }

  public static class Validation {

    private Validation() {
    }
  }
}
