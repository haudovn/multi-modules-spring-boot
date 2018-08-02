package download.util;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.util.List;

public class ExcelUtils {
    private static final Logger _LOGGER = LoggerFactory.getLogger(ExcelUtils.class);

    public static File writeListValuesToOneRow(List<Object> lstObjects, File file) throws Exception {
        if (!file.exists()) {
            Files.createFile(file.toPath());
        }
        FileInputStream inputStream = new FileInputStream(file);

        Workbook workbook = new HSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        int nofColumn = sheet.getRow(0).getPhysicalNumberOfCells();
        int lastRow = sheet.getLastRowNum();
        sheet.createRow(lastRow + 1);
        Row row = sheet.getRow(lastRow + 1);
        Object[] arrayObjects = lstObjects.toArray();
        Cell cell;
        for (int i = 0; i < nofColumn || i < arrayObjects.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(arrayObjects[i].toString());
        }
        inputStream.close();
        File tempFile = File.createTempFile("Result_", String.format("%1$s%2$s", StringPoolUtils.PERIOD, FilenameUtils.getExtension(file.getName())));
        FileOutputStream outputStream = new FileOutputStream(tempFile);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
        return tempFile;
    }
}
