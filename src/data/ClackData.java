package data;

import java.util.*;

/**
 * Class ClackData is a superclass that represents the data sent between the client and the
 * server. An object of type ClackData consists of the username of the client user, the date
 * and time at which the data was sent and the data itself, which can either be a message
 * (MessageClackData) or the name and contents of a file (FileClackData). Note that ClackData
 * should not be instantiable.
 *
 * @author xinchaosong
 */
public abstract class ClackData {
    /**
     * For giving a listing of all users connected to this session.
     */
    public static final int CONSTANT_LISTUSERS = 0;

    /**
     * For logging out, i.e., close this client's connection.
     */
    public static final int CONSTANT_LOGOUT = 1;

    /**
     * For sending a message.
     */
    public static final int CONSTANT_SENDMESSAGE = 2;

    /**
     * For sending a file.
     */
    public static final int CONSTANT_SENDFILE = 3;

    /**
     * A string representing the name of the client user.
     */
    protected String userName;

    /**
     * An integer representing the kind of data exchanged between the client and the server.
     */
    protected int type;

    /**
     * A Date object representing the date and time when ClackData object is created.
     */
    protected Date date;

    /**
     * The constructor to set up the instance variable username and type.
     * The instance variable date should be created automatically here.
     *
     * @param userName a string representing the name of the client user
     * @param type     an int representing the data type
     */
    public ClackData(String userName, int type) {
        this.userName = userName;
        this.type = type;
        this.date = new Date();
    }

    /**
     * The constructor to create an anonymous user, whose name should be "Anon".
     * This constructor should call another constructor.
     *
     * @param type an int representing the data type
     */
    public ClackData(int type) {
        this("Anon", type);
    }

    /**
     * The default constructor.
     * This constructor should call another constructor.
     * type should get defaulted to CONSTANT_LOGOUT.
     */
    public ClackData() {
        this(CONSTANT_LOGOUT);
    }

    /**
     * Returns the type.
     *
     * @return this.type
     */
    public int getType() {
        return this.type;
    }

    /**
     * Returns the username.
     *
     * @return this.userName
     */
    public String getUserName() {
        return this.userName;
    }

    /**
     * Returns the date.
     *
     * @return this.date
     */
    public Date getDate() {
        return this.date;
    }

    /**
     * The abstract method to return the data contained in this class
     * (contents of instant message or contents of a file).
     *
     * @return data
     */
    public abstract String getData();

    public abstract String getData(String key);

    public String encrypt(String inputStringToEncrypt, String key)
    {
        char[] lower = new char[inputStringToEncrypt.length()];
        char[] opt = new char[inputStringToEncrypt.length()];
        for (int i = 0; i < inputStringToEncrypt.length(); i++) {
            char temp = inputStringToEncrypt.charAt(i);
            if (temp == ' ') {
                lower[i] = ' ';
            } else if (temp >= 'a' && temp <= 'z') {
                lower[i] = 'z';
            }else continue;
        }
        inputStringToEncrypt = inputStringToEncrypt.toUpperCase();
        for (int i = 0, j = 0; i < inputStringToEncrypt.length(); i++)
        {
            char temp = inputStringToEncrypt.charAt(i);
            if (temp == ' '){
                opt[i] += ' ';
                continue;
            }
            if (temp < 'A'  || temp > 'z' )
                continue;
            opt[i] += (char) ((temp + key.charAt(j) - 2 * 'A') % 26 + 'A');
            j = ++j % key.length();
        }
        for(int i = 0, j = 0; i < inputStringToEncrypt.length(); i++){
            if(lower[i] == 'z'){
                opt[i] = Character.toLowerCase(opt[i]);
            }
        }
        String encStr = String.valueOf(opt);
        return encStr;
    }


    public String decrypt(String inputStringToDecrypt, final String key)
    {
        /*String decryStr = "";
        //inputStringToDecrypt = inputStringToDecrypt.toUpperCase();
        for (int i = 0, j = 0; i < inputStringToDecrypt.length(); i++)
        {
            char temp = inputStringToDecrypt.charAt(i);
            if (temp == ' '){
                decryStr += ' ';
            }else if (temp >= 'a' && temp <= 'z') {
                decryStr += Character.toString((char) ((temp - key.charAt(j) + 26) % 26 + 'a'));
                j = ++j % key.length();
                continue;
            }
            if (temp < 'A' || temp > 'z')
                continue;

            decryStr += (char) ((temp - key.charAt(j) + 26) % 26 + 'A');
            j = ++j % key.length();
        }*/
        char[] lower = new char[inputStringToDecrypt.length()];
        char[] opt = new char[inputStringToDecrypt.length()];
        for (int i = 0; i < inputStringToDecrypt.length(); i++) {
            char temp = inputStringToDecrypt.charAt(i);
            if (temp == ' ') {
                lower[i] = ' ';
            } else if (temp >= 'a' && temp <= 'z') {
                lower[i] = 'z';
            }else continue;
        }
        inputStringToDecrypt = inputStringToDecrypt.toUpperCase();
        for (int i = 0, j = 0; i < inputStringToDecrypt.length(); i++)
        {
            char temp = inputStringToDecrypt.charAt(i);
            if (temp == ' '){
                opt[i] += ' ';
                continue;
            }
            if (temp < 'A'  || temp > 'z' )
                continue;
            opt[i] += (char) ((temp - key.charAt(j) + 26) % 26 + 'A');
            j = ++j % key.length();
        }
        for(int i = 0; i < inputStringToDecrypt.length(); i++){
            if(lower[i] == 'z'){
                opt[i] = Character.toLowerCase(opt[i]);
            }
        }
        String decryStr = String.valueOf(opt);
        return decryStr;
    }

}
