### OutputStream
- Java application uses an output stream to write data to a destination; it may be a file, an array, peripheral device or socket.
Writing in a file using FileOutputStream

### InputStream
- Java application uses an input stream to read data from a source; it may be a file, an array, peripheral device or socket.

![image](https://github.com/cyber-sparky/javaNetworking/assets/85377859/fb95bd6a-349e-4cc0-b079-2ff4ad9a177d)

__If you have to write primitive values into a file, use `FileOutputStream` class. You can write byte-oriented as well as character-oriented data through `FileOutputStream` class. But, for character-oriented data, it is preferred to use `FileWriter` than `FileOutputStream`.__

Writing a File using `FileOutputStream` : using Byte
```import java.io.FileOutputStream;  
public class FileOutputStreamExample {  
    public static void main(String args[]){    
           try{    
             FileOutputStream fout=new FileOutputStream("D:\\testout.txt");    
             fout.write(65);    
             fout.close();    
             System.out.println("success...");    
            }catch(Exception e){System.out.println(e);}    
      }    
}
```
Output:
```Success...```
Writing a File using `FileOutPutStream` : using String

```
import java.io.FileOutputStream;  
public class FileOutputStreamExample {  
    public static void main(String args[]){    
           try{    
             FileOutputStream fout=new FileOutputStream("D:\\testout.txt");    
             String s="Learning input/output";    
             byte b[]=s.getBytes();//converting string into byte array    
             fout.write(b);    
             fout.close();    
             System.out.println("success...");    
            }catch(Exception e){System.out.println(e);}    
      }    
} 
```
Output: ```Success...```
File:
`Learning input/output`
