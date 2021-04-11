package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {

    public static ImageReader getImageReader(ImageTypes imageReader) {
        if(imageReader==null)throw new IllegalArgumentException("Неизвестный тип картинки");
       ImageReader imageReader1;
       if(imageReader.equals(ImageTypes.JPG))imageReader1 = new JpgReader();
       else if(imageReader.equals(ImageTypes.BMP))imageReader1 = new BmpReader();
       else if(imageReader.equals(ImageTypes.PNG))imageReader1 = new PngReader();
       else throw new IllegalArgumentException("Неизвестный тип картинки");
       return imageReader1;
    }
}
