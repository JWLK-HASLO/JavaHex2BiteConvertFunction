/* Hex to Bite Buffer Array Convert Example */

import java.util.Arrays;

public class Main {

    // Single(4bit) = 1 Hex Number / Range of Hex Value : 0 ~ F / Range of Decimal Value : 0 ~ 15( 0 ~ 2^4-1 )
    // Byte(8bit) = 2 Hex Numbers  / Range of Hex Value : 0 ~ FF / Range of Decimal Value : 0 ~ 255( 0 ~ 2^8-1 )
    // Short(16bit) = 4 Hex Numbers  / Range of Hex Value : 0 ~ FFFF / Range of Decimal Value : 0 ~ 65535( 0 ~ 2^16-1 )
    // Int(32bit) = 8 Hex Numbers  / Range of Hex Value : 0 ~ FFFFFFFF / Range of Decimal Value : 0 ~ 4,294,967,295( 0 ~ 2^32-1 )
    public static void main(String[] args) {

        int int32hex8 = 0xB102A304;
        short short16hex4_0 = (short) 0xB102;
        short short16hex4_1 = (short) 0xA304;

        byte[] bytesArray4Byte = {0x00, 0x00, 0x00, 0x10};
        byte[] bytesArray = {(byte) 0xB1, 0x02, (byte) 0xA3, 0x04, (byte) 0xFF, 0x11, (byte) 0xEF, 0x4F};

        int intValue = 10;
        String hexString = "9803CDEF9800000343";
        String[] hexStringArray = {"9803CDEF","98000003","96FF3322"};

        /*Convert INT Value to Hex out print result*/
        System.out.println("-------------------------------");
        System.out.println("Origin Data : 10");
        System.out.println("-------------------------------");
        System.out.println("intTo4HexString");

        System.out.printf(String.format("%s", intTo4HexString(10)));


        /*Convert Data System out print result*/
        System.out.println("\n\n-------------------------------");
        System.out.println("Origin Data : 0xB102A304");
        System.out.println("-------------------------------");
        System.out.println("intToByteBuffer");
        for(byte bytes : intToByteBuffer(int32hex8)){
            System.out.printf("0x%02X ", bytes);
        }


        System.out.println("\n\n-------------------------------");
        System.out.println("Origin Data : 0xB102, 0xA304");
        System.out.println("-------------------------------");
        System.out.println("shortToByteBuffer");
        for(byte bytes : shortToByteBuffer(short16hex4_0, short16hex4_1)){
            System.out.printf("0x%02X ", bytes);
        }

        System.out.println("\n\n-------------------------------");
        System.out.println("Origin Data : {0xB1, 0x02, 0xA3, 0x04}");
        System.out.println("-------------------------------");
        System.out.println("byteArrayToInt");
        System.out.println(String.format("%d", byteArrayToInt(bytesArray4Byte)));

        System.out.println("\n\n-------------------------------");
        System.out.println("Origin Data : {0xB1, 0x02, 0xA3, 0x04, 0xFF, 0x11, 0xEF, 0x4F}");
        System.out.println("-------------------------------");
        System.out.println("byteArrayToHexString");
            System.out.println(String.format("0x%s", byteArrayToHexString(bytesArray)));
        System.out.println("-------------------------------");
        System.out.println("byteArrayToHexStringArray");
        for(String strings : byteArrayToHexStringArray(bytesArray)){
            System.out.printf(String.format("0x%s ", strings));
        }


        System.out.println("\n\n-------------------------------");
        System.out.println("Origin Data : 9803CDEF9800000343");
        System.out.println("-------------------------------");
        System.out.println("hexStringToByte8bit2HexArray");
        for(byte bytes : hexStringToByte8bit2HexArray(hexString)){
            System.out.printf("0x%02X ", bytes);
        }
        System.out.println("\n-------------------------------");
        System.out.println("hexStringToShort16bit4HexArray");
        for(short shorts : hexStringToShort16bit4HexArray(hexString)){
            System.out.printf("0x%04X ", shorts);
        }
        System.out.println("\n-------------------------------");
        System.out.println("hexStringToInt32bit8HexArray");
        for(int ints : hexStringToInt32bit8HexArray(hexString)){
            System.out.printf("0x%04X ", ints);
        }


        System.out.println("\n\n-------------------------------");
        System.out.println("Origin Data : {\"9803CDEF\",\"98000003\",\"96FF3322\"}");
        System.out.println("-----------------------------");
        System.out.println("hexStringArrayToByte8bit2HexArray");
        for(byte bytes : hexStringArrayToByte8bit2HexArray(hexStringArray)){
            System.out.printf("0x%02X ", bytes);
        }
        System.out.println("\n-------------------------------");
        System.out.println("hexStringArrayToInt32bit8HexArray");
        for(int ints : hexStringArrayToInt32bit8HexArray(hexStringArray)){
            System.out.printf("0x%04X ", ints);
        }
        System.out.println("\n-------------------------------");
    }


    /*
     * int to 4hex Number : Example 10 => 000A
     */

    public static String intTo4HexString(int intValue) {

        String result;

        if(intValue < 65536 && intValue > 0){
            result  = Integer.toHexString(0x10000 | intValue).substring(1).toUpperCase();
        } else {
            result = "error";
        }


        return result;
    }


    /*
     *  int 32bit 8hex or short 16bit 4hex  => byte Array
     */
    public static byte[] intToByteBuffer(int intValue) {

        byte[] buffer = new byte[4];

        buffer[0] = (byte) ((intValue & 0xff000000) >> 24);
        buffer[1] = (byte) ((intValue & 0x00ff0000) >> 16);
        buffer[2] = (byte) ((intValue & 0x0000ff00) >> 8);
        buffer[3] = (byte) ((intValue & 0x000000ff) >> 0);

        return buffer;
    }

    public static byte[] shortToByteBuffer(short addr, short data) {

        byte[] buffer = new byte[4];

        buffer[0] = (byte) ((addr & 0xff00) >> 8);
        buffer[1] = (byte) (addr & 0x00ff);
        buffer[2] = (byte) ((data & 0xff00) >> 8);
        buffer[3] = (byte) (data & 0x00ff);

        return buffer;
    }

    /*
     * byte Array => int
     */
    public static int byteArrayToInt(byte[] bytes) {
        return bytes[0] << 24 | (bytes[1] & 0xFF) << 16 | (bytes[2] & 0xFF) << 8 | (bytes[3] & 0xFF);
    }

    /*
     *  byte Array => String or String Array
     */
    public static String byteArrayToHexString(byte[] bytes){

        StringBuilder sb = new StringBuilder();

        for(byte b : bytes){

            sb.append(String.format("%02X", b&0xff));
        }

        return sb.toString();
    }

    public static String[] byteArrayToHexStringArray(byte[] bytes){
        int len = bytes.length;
        int stringCounter = 0;
        int byteCounter = 1;
        if(len%4 !=0){
            for(int i = 0 ; i < bytes.length ; i += 4){
                bytes = Arrays.copyOfRange(bytes, i, i+4);
            }
        }
        String[] hexStringArray = new String[len/4];
        StringBuilder sb = new StringBuilder();

        for(byte b : bytes){
            sb.append(String.format("%02X", b&0xff));
            if(byteCounter % 4 == 0) {
                hexStringArray[stringCounter] = sb.toString();
                sb =  new StringBuilder();
                stringCounter++;
            }
            byteCounter++;
        }

        return hexStringArray;
    }

    /*
     *  String or String Array => byte Array or short Array or int Array
     */
    public static byte[] hexStringToByte8bit2HexArray(String s) {
        int len = s.length();
        byte[] dataByte = new byte[len / 2];

        for (int i = 0; i < len; i += 2) {
            dataByte[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i+1), 16));
        }
        return dataByte;
    }

    public static short[] hexStringToShort16bit4HexArray(String s) {
        int len = s.length();
        byte[] dataByte;

        if(len%4 !=0){
            s = s.substring(0,len-(len%4));
        }
        short[] dataShort = new short[len / 4];

        dataByte = hexStringToByte8bit2HexArray(s);

        for (int i = 0, counter = 0 ; i < dataByte.length; i += 2, counter++) {
            dataShort[counter] = (short) ( (dataByte[i] & 0xFF) << 8 | (dataByte[i+1] & 0xFF) ) ;
        }

        return dataShort;
    }

    public static int[] hexStringToInt32bit8HexArray(String s) {
        int len = s.length();
        byte[] dataByte;

        if(len%8 !=0){
            s = s.substring(0,len-(len%8));
        }

        int[] dataInt = new int[len / 8];

        dataByte = hexStringToByte8bit2HexArray(s);

        for (int i = 0, counter = 0 ; i < dataByte.length; i += 4, counter++) {
            dataInt[counter] = (int) ( (dataByte[i] & 0xFF) << 24 | (dataByte[i+1] & 0xFF) << 16 | (dataByte[i+2] & 0xFF) << 8 | (dataByte[i+3] & 0xFF) );
        }

        return dataInt;
    }

    /*
     *  String Array => byte Array or int Array
     */

    public static byte[] hexStringArrayToByte8bit2HexArray(String[] sArray){
        int len = sArray.length;
        byte[] dataByte = new byte[len * 4];

        for(int i = 0; i < sArray.length; i++) {
            for(int j = 0 ; j < sArray[0].length()/2; j++){
                dataByte[i*4 + j] = hexStringToByte8bit2HexArray(sArray[i])[j];
            }
        }

        return dataByte;
    }


    public static int[] hexStringArrayToInt32bit8HexArray(String[] sArray){
        int len = sArray.length;
        int dataInt[] = new int[len];

        for(int i = 0; i < sArray.length; i++) {
            dataInt[i] = hexStringToInt32bit8HexArray(sArray[i])[0];
        }

        return dataInt;
    }


}
