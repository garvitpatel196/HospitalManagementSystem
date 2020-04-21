/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared;

import hospitalmanagementsystem.models.UserRecordModel;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
/**
 *
 * @author NIAR Tech
 */
public class ReadFromExcel {
    Workbook workbook = null;
    ArrayList<String> dataObj = new ArrayList<String>();
    ArrayList<UserRecordModel> userRecorddataList;
    private void readData(String fromClass, String fileName){
        String path = CommonVariables.directoryPath+fileName;
    try {

            workbook = Workbook.getWorkbook(new File(path));
            Sheet sheet = workbook.getSheet(0);
            for (int rowCount=1 ; rowCount < sheet.getRows() ; rowCount++){
                for(int col = 0; col < sheet.getColumns(); col++){
                    dataObj.add(sheet.getCell(col,rowCount).getContents());
                }
                switch(fromClass){
                    case "signup" :
                        userRecorddataList = new ArrayList<UserRecordModel>();
                        UserRecordModel usermodel = new UserRecordModel(dataObj);
                        userRecorddataList.add(usermodel);
                        break;
                }
            }
           

        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        } 
    }
    
    public ArrayList<UserRecordModel> readUserRecord(String fromClass, String fileName){
        readData(fromClass,fileName);
        return userRecorddataList;
    }
    
    
}
