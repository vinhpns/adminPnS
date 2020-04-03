/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.tool;

import static com.poly.tool.NewMain.removeAccent;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.regex.Pattern;

import org.springframework.web.multipart.MultipartFile;

public class Utils {

    public static int i = 0;

    Random rand = new Random();
    String code;
    String codeN;

    public static String getToday() {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static Boolean uploadImg(List<String> listNames, List<MultipartFile> listFiles, String link) {
        if (listNames.size() > 0 && !listNames.isEmpty()) {
            for (int i = 0; i < listNames.size(); i++) {
                uploadImageToServer(link, listNames.get(i), listFiles.get(i));
            }
            return true;
        }
        return false;
    }

    public static String randomCodeImg() {
        Random rand = new Random();
        String codeN;
        String codeTotal = "PNS";
        for (int i = 0; i < 16; i++) {
            int n = rand.nextInt(9);
            codeN = String.valueOf(n);
            codeTotal = codeTotal + codeN;
        }
        return codeTotal;
    }

    public static String getDayByIT(int hours) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.HOUR_OF_DAY, hours);
        String newDate = sdf.format(cal.getTime());
        return newDate;
    }

    public static void uploadImageToServer(String folder, String imageName, MultipartFile image) {
        try {
            File pathS = new File(folder + imageName);
            if (pathS.exists()) {
                i++;
                pathS = new File(folder + i + imageName);
                byte[] bytes = image.getBytes();
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(pathS));
                stream.write(bytes);
                stream.close();
            } else {
                pathS = new File(folder + imageName);
                byte[] bytes = image.getBytes();
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(pathS));
                stream.write(bytes);
                stream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Boolean compareDay(int day) {
        int today = Integer.parseInt(getToday());
        if (today > day) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public static String setBidCodeSpecial(int codeBid) {
        String code = String.valueOf(codeBid);
        switch (codeBid) {
            case 999:
                code = String.valueOf(codeBid + 1);
                break;
            case 99:
                code = "0" + String.valueOf(codeBid + 1);
                break;
            case 9:
                code = "00" + String.valueOf(codeBid + 1);
                break;
        }
        return code;
    }

    public static String setBidOrderCode(String orderCode) {
        String code = orderCode.substring(12, 16);
        int first = Integer.parseInt(code.substring(0, 1));
        int second = Integer.parseInt(code.substring(1, 2));
        int third = Integer.parseInt(code.substring(2, 3));
        int last = Integer.parseInt(code.substring(3, 4));
        int codeCheck = Integer.parseInt(orderCode.substring(12, 16));
        if (codeCheck == 999 || codeCheck == 99 || codeCheck == 9) {
            code = setBidCodeSpecial(codeCheck);
            return code;
        }
        if (first > 0) {
            code = String.valueOf(Integer.parseInt(code) + 1);
        }
        if (second > 0) {
            code = "0" + String.valueOf(Integer.parseInt(code) + 1);
        }
        if (third > 0) {
            code = "00" + String.valueOf(Integer.parseInt(code) + 1);
        }
        if (last > 0) {
            code = "000" + String.valueOf(Integer.parseInt(code) + 1);
        }
        return code;
    }

    public static String getOrderCode(String orderCode) {
        String code = "0001";
        if (Objects.equals(compareDay(Integer.parseInt(orderCode.substring(3, 11))), Boolean.FALSE)) {
            code = setBidOrderCode(orderCode);
        }
        return code;
    }

    public static Boolean checkImgType(MultipartFile file) {
        String type = file.getContentType();
        if (type.equalsIgnoreCase("image/png")
                || type.equalsIgnoreCase("image/jpeg")
                || type.equalsIgnoreCase("image/gif")) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public static String createUrl(String url) {
        String sentence = "";
        for (int i = 0; i < url.length(); i++) {
            if (Character.isUpperCase(url.charAt(i)) == true) {
                char ch2 = (char) (url.charAt(i) + 32);
                sentence = sentence + ch2;
            } else {
                sentence = sentence + url.charAt(i);
            }
        }
        return removeAccent(sentence).replaceAll("\\s", "-");
    }

    public static String removeAccent(String s) {
        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(temp).replaceAll("");
    }
}
