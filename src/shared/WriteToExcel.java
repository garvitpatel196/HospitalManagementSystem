/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared;
import java.io.File;
import jxl.Cell;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 *
 * @author NIAR Tech
 */
public class WriteToExcel {
    public void writeData(String fileName, String[] labels,String[] data) throws Exception{
        String path = CommonVariables.directoryPath+fileName;
        int noOfFields = labels.length;
        int rowCount = 0;
        File file = new File(path);
        WritableWorkbook wb;
        WritableSheet sht;
        if(file.exists()){
            Workbook existingWb = Workbook.getWorkbook(new File(file.getAbsolutePath()));
            wb = Workbook.createWorkbook(new File(path), existingWb);
        }else {
          wb = Workbook.createWorkbook(file);
          sht = wb.createSheet("data", 0);
          for (int i = 0; i<noOfFields; i++){
              sht.addCell(new Label (i, 0, labels[i]));
          }
        }
        sht = wb.getSheet(0);
        rowCount = sht.getRows();
        
        for (int colNum = 0; colNum <noOfFields; colNum++){
        sht.addCell(new Label (colNum,rowCount,data[colNum]));
        }
        
        

  
//  Label ll = new Label(0, 0, "Result");
//  sht.addCell(ll);
//  sht.addCell(new Label(1, 1, "Pass"));
//  sht.addCell(new Label(2, 2, "Fail"));
  
  wb.write();
  wb.close();
  System.out.println("Workbook is created");
    }
}
