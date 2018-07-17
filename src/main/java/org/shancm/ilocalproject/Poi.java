package org.shancm.ilocalproject;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author shancm
 * @pachage org.shancm.ilocalproject
 * @description:
 * @date 2018/5/18
 */
public class Poi {

    public static void main(String[] args) throws IOException {
        InputStream isOrigin = null;
        try {


//            File file = new File("C:\\Users\\shancm\\Desktop\\3456.xlsx");
//            file.createNewFile();
            isOrigin = new FileInputStream("C:\\Users\\shancm\\Desktop\\呼叫成功模板.csv");
//            isOrigin = new FileInputStream(file);
            POIFSFileSystem fileSystem = new POIFSFileSystem(isOrigin);
            HSSFWorkbook wb = new HSSFWorkbook(fileSystem);

            //获取excel表的第一个sheet
            HSSFSheet sheet = wb.getSheetAt(0);
            if (sheet == null) {
                return;
            }

            //遍历该sheet的行
            for (int rowNum = 0; rowNum <= sheet.getLastRowNum(); rowNum++) {
                HSSFRow row = sheet.getRow(rowNum);
                if (row == null) {
                    continue;
                }

                //再遍历改行的所有列
                for(int ColNum = 0; ColNum <= row.getLastCellNum(); ColNum++) {
                    HSSFCell cell = row.getCell(ColNum);
                    if (cell == null) {
                        continue;
                    }


                    String strVal=cell.getStringCellValue();
                    System.out.print(" " + strVal);
                    //System.out.print(" " + readCellFirstMethod(cell));
                    //System.out.print(" " + readCellSecondMethod(cell));
                }
                System.out.println();
            }
        }catch (Exception e){
            System.out.println(ExceptionUtils.getStackTrace(e));
        }finally {
            isOrigin.close();
        }
    }
}
