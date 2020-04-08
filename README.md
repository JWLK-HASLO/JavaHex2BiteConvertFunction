JavaHex2BiteConvertFunction
===
#### Convert Hex number between byte, short, int, string
+ #### Single Value <=> Array Value
+ #### Converted based on 32-bit number.
+ #### If the number exceeds 32 bits, the excess number is discarded.

<br>


### 1. int 32bit 8hex or short 16bit 4hex  => byte Array

#### 1.1 byte[] intToByteBuffer(int intValue) 
+ #####Origin Data : (int) 0xB102A304
> Result : 0xB1 0x02 0xA3 0x04 
#### 1.2 byte[] shortToByteBuffer(short addr, short data)
+ #####Origin Data : (short) 0xB102, (short) 0xA304
> Result : 0xB1 0x02 0xA3 0x04 

<br>

### 2. byte Array => String or String Array
+ #####Origin Data : byte[] {0xB1, 0x02, 0xA3, 0x04, 0xFF, 0x11, 0xEF, 0x4F}
#### 2.1 String byteArrayToHexString(byte[] bytes)
> Result : 0xB102A304FF11EF4F
#### 2.2 String[] byteArrayToHexStringArray(byte[] bytes)
> Result : 0xB102A304 0xFF11EF4F  

<br>

### 3. String => byte Array or short Array or int Array
+ #####Origin Data : (String) "9803CDEF9800000343"
#### 3.1 byte[] hexStringToByte8bit2HexArray(String s) 
> Result : 0x98 0x03 0xCD 0xEF 0x98 0x00 0x00 0x03 0x43 
#### 3.2 short[] hexStringToShort16bit4HexArray(String s) 
> Result : 0x9803 0xCDEF 0x9800 0x0003 
#### 3.3 int[] hexStringToInt32bit8HexArray(String s)
> Result : 0x9803CDEF 0x98000003 

<br> 

### 4. String Array => byte Array or int Array
+ #####Origin Data : String[] {"9803CDEF","98000003","96FF3322"}
#### 4.1 byte[] hexStringArrayToByte8bit2HexArray(String[] sArray)
> Result : 0x98 0x03 0xCD 0xEF 0x98 0x00 0x00 0x03 0x43 
#### 4.2 int[] hexStringArrayToInt32bit8HexArray(String[] sArray)
> Result : 0x9803CDEF 0x98000003 0x96FF3322 

<br> 

<br> 

<br> 

<br> 

<br> 

<br> 
