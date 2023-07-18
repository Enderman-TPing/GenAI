package io.github.et.fileManager;

import java.io.*;

public class Converter {
    private String baseFileQ;
    private String baseFileA;
    private String dirFileQ;
    public Converter(String baseFileQ,String baseFileA, String dirFileQ){
        this.baseFileA=baseFileA;
        this.baseFileQ=baseFileQ;
        this.dirFileQ=dirFileQ;
    }
    public File InterpretBaseFile() throws IOException {
        FileInputStream in=new FileInputStream(baseFileQ);
        byte[] all=in.readAllBytes();
        in.close();
        char[] cont=new String(all).toCharArray();
        FileOutputStream out=new FileOutputStream(dirFileQ,true);
        for (int i=0; i<cont.length;i++){
            if(cont[i]=='\n'){
                out.write("\n".getBytes());
            } else if (cont[i+1]=='\n') {
                out.write(String.valueOf((int)cont[i]).getBytes());
            }else{
                out.write((String.valueOf((int)cont[i])+", ").getBytes());
            }
        }
        out.flush();
        out.close();
        return new File(dirFileQ);
    }
}
