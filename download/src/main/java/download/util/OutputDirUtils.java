package download.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public final class OutputDirUtils {
    private static final Logger _LOGGER = LoggerFactory.getLogger(OutputDirUtils.class);

    private static final String _ROOT_DIR = System.getProperty("user.dir");

    private static final String _OUTPUT_NAME = "Output";

    private static final String _XLS = "xls";

    private static final String _XLSX = "xlsx";

    private static final String _TEMPLATES = "templates";

    private static final String _FILE_TEMPLATE = "file-templates";

    private static final String _USER_TEMPLATE_FILE_NAME = "user-template.xls";

    public static String getRootDir() {
        return _ROOT_DIR;
    }

    public static String getOutputDir() {
        return String.format("%1$s%2$s%3$s", getRootDir(), File.separator, _OUTPUT_NAME);
    }

    public static String getFileTemplateDir() {
        String temp = String.format("%1$s%2$s%3$s", getOutputDir(), File.separator, _FILE_TEMPLATE);
        _LOGGER.debug(temp);
        return temp;
    }

    public static String getXLSTemplateDir() {
        String temp = String.format("%1$s%2$s%3$s", getFileTemplateDir(), File.separator, _XLS);
        _LOGGER.debug(temp);
        return temp;
    }

    public static String getXLSXTemplateDir() {
        String temp = String.format("%1$s%2$s%3$s", getFileTemplateDir(), File.separator, _XLSX);
        _LOGGER.debug(temp);
        return temp;
    }

    public static File getUserTemplateFile() {
        String temp = String.format("%1$s%2$s%3$s", getXLSTemplateDir(), File.separator, _USER_TEMPLATE_FILE_NAME);
        _LOGGER.debug(temp);
        return new File(temp);
    }
}
