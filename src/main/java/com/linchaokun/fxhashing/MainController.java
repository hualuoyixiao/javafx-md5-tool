package com.linchaokun.fxhashing;

import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;

/**
 * Created by linchaokun on 2018/6/20.
 */
public class MainController {
    /**
     * MD5Hash值文本框
     */
    public TextField txtMd5Hash;

    /**
     * 要转md5的文本
     */
    public TextArea txtTextContent;

    /**
     * 文件信息
     */
    public Label lblFileInfo;


    /**
     * 界面初始化后,该方法会被自动调用
     */
    public void initialize(){
        //文本框内容改变计算md5值
        txtTextContent.textProperty().addListener((ob,old,value) -> txtMd5Hash.setText(calculateMd5(value)));

    }

    /**
     * 计算MD5值
     * @param value
     * @return
     */
    private String calculateMd5(String value) {
        HashFunction hashFunction = Hashing.md5();
        HashCode hashCode = hashFunction.hashString(value, Charset.forName("UTF-8"));
        return hashCode.toString();

    }

    /**
     * 打开文件
     */
    public void openFile() throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("."));
        fileChooser.setTitle("选择文件");
        File file = fileChooser.showOpenDialog(FxHashingApplication.getPrimaryStage());
        if(file!=null){
            lblFileInfo.setText("文件路径:"+file.getAbsolutePath()+"文件大小:"+file.length()+"KB");
            txtMd5Hash.setText(calculateMd5(file));
        }
    }

    /**
     * 计算文件HASH值
     * @param file
     * @return
     */
    private String calculateMd5(File file) throws IOException {
        byte[] bytes = Files.readAllBytes(file.toPath());
        HashFunction hashFunction = Hashing.md5();
        HashCode hashCode = hashFunction.hashBytes(bytes);
        return hashCode.toString();
    }
}
