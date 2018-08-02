package download.controller;

import download.model.User;
import download.util.ExcelUtils;
import download.util.OutputDirUtils;
import download.util.UserUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping(value = "${download.pattern.url}")
public class DownloadController {

    private File getTemplateFile() {
        return OutputDirUtils.getUserTemplateFile();
    }

    @RequestMapping(value = "template", produces = "application/vnd.ms-excel")
    public byte[] downloadTemplateFile() throws Exception {
        try {
            File file = getTemplateFile();
            if (file.exists() && file.canRead()) {
                _LOGGER.info("Can access this file");
                InputStream inputStream = new FileInputStream(file);
                return IOUtils.toByteArray(inputStream);
            } else {
                _LOGGER.error("Doesn't exist the file" + file.getAbsolutePath());
                return null;
            }
        } catch (Exception e) {
            _LOGGER.error("Can not download file", e);
            return null;
        }
    }

    @RequestMapping(value = "/user/{num}", produces = "application/vnd.ms-excel")
    public void downloadFile(@PathVariable(value = "num") int num, HttpServletResponse response) throws IOException, Exception {
        try {
            User user = UserUtils.getStaticUserForTest();
            File file = ExcelUtils.writeListValuesToOneRow(UserUtils.getListValues(user), getTemplateFile());
            InputStream inputStream = new FileInputStream(file);
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
            response.setHeader("Content-Length", String.valueOf(file.length()));
            IOUtils.copy(inputStream, response.getOutputStream());
        } catch (IOException e) {
            _LOGGER.error("Can not download file", e);
            throw e;
        }
    }
    
    private final Logger _LOGGER = LoggerFactory.getLogger(DownloadController.class);
}
