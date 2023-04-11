package com.guyan.jvm;

import java.io.*;

/**
 * @Author: GuYan
 * @Time: 2023/3/28 21:32
 * @Description: TODO
 **/
public class HeroClassLoader extends ClassLoader {
    private String classpath;

    public HeroClassLoader(String classpath) {
        this.classpath = classpath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] classDate = getData(name);
            if(classDate != null) {
                return defineClass(name, classDate, 0, classDate.length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.findClass(name);
    }

    private byte[] getData(String className) throws IOException {
        String path = classpath + File.separatorChar + className.replace(".", File.separator) + ".class";
        try (InputStream in = new FileInputStream(path); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[2048];
            int len = 0;
            while ((len = in.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
            return out.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
