package com.cosy.sun.algorithm.cipher;

import org.junit.Test;

public class DES3Test {

    @Test
    public void test() throws Exception {
//        byte[] encode = encode("this is sunzhenhua", getSecretKey(key), alg1, encoding, iv);
//        System.out.println(Base64.encodeBase64String(encode));
//        byte[] decode = decode(Base64.decodeBase64(Base64.encodeBase64String(encode)), getSecretKey(key), alg1, encoding, iv);
//        System.out.println(new String(decode));
//
//        try (FileOutputStream out = new FileOutputStream(new File("E:\\encrypt.txt"));
//             CipherInputStream cis = encrypt(getSecretKey(key), new FileInputStream(new File("E:\\txt.txt")), alg1, iv);) {
//            byte[] buff = new byte[1024];
//            int n = 0;
//            while (-1 != (n = cis.read(buff))) {
//                out.write(buff, 0, n);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        try (FileOutputStream out = new FileOutputStream(new File("E:\\decrypt.txt"));
//             CipherInputStream cis = decrypt(getSecretKey(key), new FileInputStream(new File("E:\\encrypt.txt")), alg1, iv);) {
//            byte[] buff = new byte[1024];
//            int n = 0;
//            while (-1 != (n = cis.read(buff))) {
//                out.write(buff, 0, n);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//        try (InputStream inputStream = new FileInputStream(new File("E:\\txt.txt"));
//             FileOutputStream out = new FileOutputStream(new File("E:\\encrypt.txt"));
//             CipherOutputStream cos = encrypt(getSecretKey(key), out, alg1, iv);
//        ) {
//            byte[] buff = new byte[1024];
//            int n = 0;
//            while (-1 != (n = inputStream.read(buff))) {
//                cos.write(buff, 0, n);
//            }
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//
//        try (FileOutputStream fos = new FileOutputStream(new File("E:\\decrypt.txt"));
//             FileInputStream fis = new FileInputStream(new File("E:\\encrypt.txt"));
//             CipherInputStream cis = decrypt(getSecretKey(key), fis, alg1, iv);
//
//        ) {
//            byte[] b = new byte[1024];
//            int n = 0;
//            while (-1 != (n = cis.read(b))) {
//                fos.write(b, 0, n);
//                fos.flush();
//            }
//        } catch (Exception e) {
//            // TODO: handle exception
//        }
    }

}