package test;

import data.ClackData;
import data.FileClackData;
import data.MessageClackData;

import java.io.*;
import java.util.*;

/**
 * You don't have to have a Javadoc for a test class.
 * You should test all implemented functions in the data classes,
 * whether they are in the superclass or in the subclasses.
 */
public class TestClackData {
    public static void main(String[] args) {
        // MessageClackData (both constructors)
        MessageClackData messageClackData1 = new MessageClackData();
        MessageClackData messageClackData2 =
                new MessageClackData("testUser1", "testMessage", ClackData.CONSTANT_SENDMESSAGE);

        // FileClackData (both constructors)
        FileClackData fileClackData1 = new FileClackData();
        FileClackData fileClackData2 =
                new FileClackData("testUser2", "filename0", ClackData.CONSTANT_SENDFILE);

        // getType()
        System.out.println("messageClackData1 getType(): " + messageClackData1.getType());
        System.out.println("messageClackData2 getType(): " + messageClackData2.getType());
        System.out.println("fileClackData1 getType(): " + fileClackData1.getType());
        System.out.println("fileClackData2 getType(): " + fileClackData2.getType());
        System.out.println();

        // getUserName()
        System.out.println("messageClackData1 getUserName(): " + messageClackData1.getUserName());
        System.out.println("messageClackData2 getUserName(): " + messageClackData2.getUserName());
        System.out.println("fileClackData1 getUserName(): " + fileClackData1.getUserName());
        System.out.println("fileClackData2 getUserName(): " + fileClackData2.getUserName());
        System.out.println();

        // getDate()
        System.out.println("messageClackData1 getDate(): " + messageClackData1.getDate());
        System.out.println("messageClackData2 getDate(): " + messageClackData2.getDate());
        System.out.println("fileClackData1 getDate(): " + fileClackData1.getDate());
        System.out.println("fileClackData2 getDate(): " + fileClackData2.getDate());
        System.out.println();

        // getData()
        System.out.println("messageClackData1 getData(): " + messageClackData1.getData());
        System.out.println("messageClackData2 getData(): " + messageClackData2.getData());
        System.out.println("fileClackData1 getData(): " + fileClackData1.getData());
        System.out.println("fileClackData2 getData(): " + fileClackData2.getData());
        System.out.println();

        // hashCode()
        System.out.println("messageClackData1 hashCode(): " + messageClackData1.hashCode());
        System.out.println("messageClackData2 hashCode(): " + messageClackData2.hashCode());
        System.out.println("fileClackData1 hashCode(): " + fileClackData1.hashCode());
        System.out.println("fileClackData2 hashCode(): " + fileClackData2.hashCode());
        System.out.println();

        // equals()
        System.out.println("messageClackData1 equals null: "
                + messageClackData1.equals(null));
        System.out.println("messageClackData1 equals messageClackData1: "
                + messageClackData1.equals(messageClackData1));
        System.out.println("messageClackData1 equals messageClackData2: "
                + messageClackData1.equals(messageClackData2));
        System.out.println("messageClackData2 equals messageClackData1: "
                + messageClackData2.equals(messageClackData1));
        System.out.println("messageClackData1 equals fileClackData1: "
                + messageClackData1.equals(fileClackData1));
        System.out.println("fileClackData1 equals null: "
                + fileClackData1.equals(null));
        System.out.println("fileClackData1 equals fileClackData1: "
                + fileClackData1.equals(fileClackData1));
        System.out.println("fileClackData1 equals fileClackData2: "
                + fileClackData1.equals(fileClackData2));
        System.out.println("fileClackData2 equals fileClackData1: "
                + fileClackData2.equals(fileClackData1));
        System.out.println("fileClackData1 equals messageClackData1: "
                + fileClackData1.equals(messageClackData1));
        System.out.println();

        // toString()
        System.out.println("messageClackData1:\n" + messageClackData1);
        System.out.println("messageClackData2:\n" + messageClackData2);
        System.out.println("fileClackData1:\n" + fileClackData1);
        System.out.println("fileClackData2:\n" + fileClackData2);
        System.out.println();

        // getFileName
        System.out.println("fileClackData1 getFileName(): " + fileClackData1.getFileName());
        System.out.println("fileClackData2 getFileName(): " + fileClackData2.getFileName());
        System.out.println();

        // setFileName
        String filename1 = "filename1";
        System.out.println("Sets the filename of fileClackData1 to be " + filename1);
        fileClackData1.setFileName(filename1);
        System.out.println("fileClackData1 getFileName(): " + fileClackData1.getFileName());
        System.out.println("fileClackData1 hashCode(): " + fileClackData1.hashCode());
        System.out.println("fileClackData1 equals fileClackData1: " + fileClackData1.equals(fileClackData1));
        System.out.println("fileClackData1 equals fileClackData2: " + fileClackData1.equals(fileClackData2));
        System.out.println("fileClackData1:\n" + fileClackData1);
        System.out.println();

        String filename2 = "filename2";
        System.out.println("Sets the filename of fileClackData2 to be " + filename2);
        fileClackData2.setFileName(filename2);
        System.out.println("fileClackData2 getFileName(): " + fileClackData2.getFileName());
        System.out.println("fileClackData2 hashCode(): " + fileClackData2.hashCode());
        System.out.println("fileClackData2 equals fileClackData2: " + fileClackData2.equals(fileClackData2));
        System.out.println("fileClackData2 equals fileClackData1: " + fileClackData2.equals(fileClackData1));
        System.out.println("fileClackData2:\n" + fileClackData2);

        /* for execution of I/O testing*/

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Message to be Encrypted: ");
        String message = scanner.nextLine();
        System.out.println("Enter Key: ");
        String key = scanner.nextLine();
        System.out.println("encrypt(): " + fileClackData2.encrypt(message, key));

        System.out.println("Enter Message to be Decrypted: ");
        message = scanner.nextLine();
        System.out.println("Enter Key: ");
        key = scanner.nextLine();
        System.out.println("decrypt(): " + fileClackData2.decrypt(message, key));

    }
}
