package constants;

public class FrameworkConstants {

    private FrameworkConstants(){

    }

    private static final String CHROMEDRIVERPATH= System.getProperty("user.dir")+"/src/test/resources/Executables/chromedriver";

    private static final String OBJECTREPOXMLPATH= System.getProperty("user.dir") +"/src/test/resources/ObjectRepository.xml";
    public static String getChromeDriverPath(){
        return CHROMEDRIVERPATH;
    }

    public static String getObjectRepoXmlPath(){
        return OBJECTREPOXMLPATH;
    }

}
