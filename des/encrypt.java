package Alogorithms.des;
import java.util.Arrays;
import java.util.Scanner;

public class encrypt {

    /**
     *
     * @param message
     * @param key
     * @param operation
     * @return
     */
    public byte[] crypt(byte[] message, byte[] key, String operation) {
        common com = new common();
        int length = message.length;
        int n = (length + 7)/8 * 8;
        byte[] cipher = new byte[n];
        int i = 0;
        int k = 0;
        byte[] feedback = new byte[8];

        feedback = com.getInitializationVectorCFB();

        while (i < length) {
            byte[] block = new byte[8];
            byte[] result = new byte[8];
            int j = 0;
            for (; j < 8 && i < length; j++, i++) {
                block[j] = message[i];
            }
            while (j < 8) {
            /* pad with white spaces */
                block[j++] = 0x20;
            }

            //System.out.println("BLOCK: ");
            //printBytes(block);
            if (operation.equals("encrypt")) {
                result = com.cryptText(feedback, key, operation);
                byte[] resultPart = Arrays.copyOfRange(result, 0, 4);
                byte[] blockPart = Arrays.copyOfRange(block, 0, 4);
                byte[] temp1 = com.XORBytes(resultPart, blockPart);
                feedback = com.mergeBytes(Arrays.copyOfRange(result, 4, 8), temp1);
                resultPart = Arrays.copyOfRange(result, 4, 8);
                blockPart = Arrays.copyOfRange(block, 4, 8);
                result = com.cryptText(feedback, key, operation);
                byte[] temp2 = com.XORBytes(resultPart, blockPart);
                feedback = com.mergeBytes(Arrays.copyOfRange(result, 4, 8), temp2);
                result = com.mergeBytes(temp1, temp2);
            } else if (operation.equals("decrypt")) {
                result = com.cryptText(feedback, key, "encrypt");
                byte[] resultPart = Arrays.copyOfRange(result, 0, 4);
                byte[] blockPart = Arrays.copyOfRange(block, 0, 4);
                byte[] temp1 = com.XORBytes(resultPart, blockPart);
                feedback = com.mergeBytes(Arrays.copyOfRange(result, 4, 8), blockPart);
                resultPart = Arrays.copyOfRange(result, 4, 8);
                blockPart = Arrays.copyOfRange(block, 4, 8);
                result = com.cryptText(feedback, key, "encrypt");
                byte[] temp2 = com.XORBytes(resultPart, blockPart);
                feedback = com.mergeBytes(Arrays.copyOfRange(result, 4, 8), blockPart);
                result = com.mergeBytes(temp1, temp2);
            }
            //System.out.println("RESULT: ");
            //printBytes(result);
            for (j = 0 ; j < 8 && k < cipher.length; j++, k++) {
                cipher[k] = result[j];
            }
        }
        return cipher;
    }

    public static void main(String args[]) {
        common com = new common();
        Scanner input = new Scanner(System.in);
        System.out.print("Key: ");
        byte[] key = com.hexStringToByteArray(input.next());
        System.out.print("Message: ");
        byte[] message = com.hexStringToByteArray(input.next());
        System.out.print("Method: ");
        String method = input.next();
        encrypt crypt = new encrypt();
        byte[] one = crypt.crypt(message, key, method);
        System.out.print(com.getString(one));

//        byte[] key = com.hexStringToByteArray("0B3CB15919F19714");
//        byte[] message = com.hexStringToByteArray("0B3CB15919F19713");
//        byte[] pass = com.hexStringToByteArray("DFAE8EEA76946A3C");
//        encrypt crypt = new encrypt();
//        byte[] one = crypt.crypt(message, key, "encrypt");
//        byte[] two = crypt.crypt(pass, key, "decrypt");
//        System.out.println(com.getString(one));
//        System.out.println(com.getString(two));
    }
}
