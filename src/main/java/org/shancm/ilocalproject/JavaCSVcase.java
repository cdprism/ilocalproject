package org.shancm.ilocalproject;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.*;

/**
 * @author shancm
 * @pachage org.shancm.ilocalproject
 * @description:
 * @date 2018/5/18
 */
public class JavaCSVcase {

    public static void main(String[] args) {
        try {
            File file = new File("C:\\Users\\shancm\\Desktop\\123.csv");
            file.createNewFile();
            CsvWriter write = new CsvWriter("C:\\Users\\shancm\\Desktop\\123.csv", ',', Charset.forName("GBK"));
            //各字段以引号标记
            write.setForceQualifier(true);

            // 用来保存数据
            ArrayList<String[]> originFileList = new ArrayList<String[]>();
            ArrayList<String[]> calledFileList = new ArrayList<String[]>();
            // 定义一个CSV路径
            String originFile = "C:\\Users\\shancm\\Desktop\\呼叫成功模板.csv";
            String calledFile = "C:\\Users\\shancm\\Desktop\\呼叫成功模板 - called.csv";
            // 创建CSV读对象 例如:CsvReader(文件路径，分隔符，编码格式);
            CsvReader originReader = new CsvReader(originFile, ',', Charset.forName("GBK"));
            CsvReader calledReader = new CsvReader(calledFile, ',', Charset.forName("GBK"));
            // 跳过表头 如果需要表头的话，这句可以忽略
            calledReader.readHeaders();
//            String[] header = calledReader.getValues();
//            System.out.println(header+"header");
            // 逐行读入除表头的数据
            while (calledReader.readRecord()) {
                System.out.println(calledReader.getRawRecord());
                calledFileList.add(calledReader.getValues());
            }

            Set<String> calledSet = new HashSet<>();
            // 遍历读取的CSV文件
            for (int row = 0; row < calledFileList.size(); row++) {
//                calledSet.put(calledFileList.get(row)[0], calledFileList.get(row)[4]);
                calledSet.add(calledFileList.get(row)[0]+calledFileList.get(row)[4]);
            }

            calledReader.close();
//            originReader.readHeaders();
            while (originReader.readRecord()) {
//                System.out.println(originReader.getRawRecord());
//                csvFileList.add(originReader.getValues());
                    int size = calledSet.size();
                calledSet.add(originReader.getValues()[0]+originReader.getValues()[4]);
                System.out.println(originReader.getValues()[0]);
                System.out.println(originReader.getValues()[4]);
                    if (size != calledSet.size()){
                        write.writeRecord(originReader.getValues());
                    }
            }

            originReader.close();
            write.close();
           /* //逐条读取记录，直至读完
            String[] header = {};
            while (calledReader.readRecord()) {
                //把头保存起来
                if (calledReader.getCurrentRecord() == 0) {
                    header = calledReader.getValues();
                }
                //获取当前记录位置
                System.out.print(calledReader.getCurrentRecord() + ".");
                //读取一条记录
                System.out.println(calledReader.getRawRecord());
//                String[] tmp = {calledReader.getValues()[0],calledReader.getValues()[1]};
                String[] tmp = calledReader.getValues();
                //修改记录，并只写入第一个字段和第二字段
//                if (!header[1].equals(tmp[1]) && ("".equals(tmp[1])||tmp==null)){
//                    tmp[1]="空";
                write.writeRecord(tmp);
//                }else{
//                    write.writeRecord(new String[]{calledReader.getValues()[0],calledReader.getValues()[1]});
//                }
            }
            calledReader.close();
            write.close();*/
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
