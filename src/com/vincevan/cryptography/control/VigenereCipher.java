/**
 *
 * @author JC Krisna
 */
package com.vincevan.cryptography.control;
public class VigenereCipher {
    
    private String inputText_;
    private String outputText_;
    private String key_;
    private String encrypted_;
    private String decrypted_;
    
    
    // Constructor
    public VigenereCipher(String input, String key){
        this.inputText_ = input;
        this.outputText_ = "";
        this.key_ = key;
        this.encrypted_ = "";
        this.decrypted_="";
        
        encryptKey();
//        System.out.println("\n");
        this.inputText_ = this.outputText_;
        decryptKey();
    }
            
            
    public char convertAnsiToUnicode(int _value) 
	/* converts certain extended ANSI index into Unicode index */
    {
        char output;
        switch(_value) {
                case 128 : {output = (char)8364;} break;
                case 130 : {output = (char)8218;} break;
                case 131 : {output = (char)402;} break;
                case 132 : {output = (char)8222;} break;		
                case 133 : {output = (char)8230;} break;
                case 134 : {output = (char)8224;} break;
                case 135 : {output = (char)8225;} break;
                case 136 : {output = (char)710;} break;
                case 137 : {output = (char)8240;} break;
                case 138 : {output = (char)352;} break;
                case 139 : {output = (char)8249;} break;
                case 140 : {output = (char)338;} break;
                case 142 : {output = (char)381;} break;
                case 145 : {output = (char)8216;} break;
                case 146 : {output = (char)8217;} break;
                case 147 : {output = (char)8220;} break;
                case 148 : {output = (char)8221;} break;
                case 149 : {output = (char)8226;} break;
                case 150 : {output = (char)8211;} break;		
                case 151 : {output = (char)8212;} break;
                case 152 : {output = (char)732;} break;
                case 153 : {output = (char)8482;} break;
                case 154 : {output = (char)353;} break;
                case 155 : {output = (char)8250;} break;
                case 156 : {output = (char)339;} break;
                case 158 : {output = (char)382;} break;
                case 159 : {output = (char)376;} break;
                default : {output = (char)_value;}
        }
        return output;
    }

    public char convertUnicodeToANSI(int _value) 
    /* converts certain extended Unicode index into ANSI index*/
    {
        char output;
        switch(_value) {
                case 8364 : {output = (char)128;} break;
                case 8218 : {output = (char)130;} break;
                case 402 : {output = (char)131;} break;
                case 8222 : {output = (char)132;} break;		
                case 8230 : {output = (char)133;} break;
                case 8224 : {output = (char)134;} break;
                case 8225 : {output = (char)135;} break;
                case 710 : {output = (char)136;} break;
                case 8240 : {output = (char)137;} break;
                case 352 : {output = (char)138;} break;
                case 8249 : {output = (char)139;} break;
                case 338 : {output = (char)140;} break;
                case 381 : {output = (char)142;} break;
                case 8216 : {output = (char)145;} break;
                case 8217 : {output = (char)146;} break;
                case 8220 : {output = (char)147;} break;
                case 8221 : {output = (char)148;} break;
                case 8226 : {output = (char)149;} break;
                case 8211 : {output = (char)150;} break;		
                case 8212 : {output = (char)151;} break;
                case 732 : {output = (char)152;} break;
                case 8482 : {output = (char)153;} break;
                case 353 : {output = (char)154;} break;
                case 8250 : {output = (char)155;} break;
                case 339 : {output = (char)156;} break;
                case 382 : {output = (char)158;} break;
                case 376 : {output = (char)159;} break;
                default : {output = (char)_value;}
        }
        return output;
    }
    
    public String getRepeatKey()
    /* returns repeated key with length equals plaintext's length */
    {
        String output = "";
        int i = 0;

        while (output.length() != this.inputText_.length()) {		
                output += this.key_.charAt(i);
                i++;
                if (i == this.key_.length()) {
                        i = 0;
                }
        }
        System.out.print("Key becomes : " + output + "\n");
        return output;
    }    
        
    public void encryptKey()
    /* encrypts plaintext using key_ */
    {
        char tempOutput = ' ';
        String keyRepeated = getRepeatKey();

        for (int i=0; i<this.inputText_.length(); i++) {
            tempOutput = convertAnsiToUnicode((((int)inputText_.charAt(i)+(int)keyRepeated.charAt(i))%256));

            encrypted_ += tempOutput;
            this.outputText_ += tempOutput;
            tempOutput = ' ';
        }
    }
    
    public void decryptKey()
	/* decrypts ciphertext using key_ */
    {	
        char tempOutput = ' ';
        String keyRepeated = getRepeatKey();
        String tempInput = this.inputText_;

        for (int i=0; i<tempInput.length(); i++) {
                if (convertUnicodeToANSI((int)tempInput.charAt(i))-(int)convertUnicodeToANSI(keyRepeated.charAt(i)) >= 0) {
                        tempOutput = convertAnsiToUnicode((int)convertUnicodeToANSI((int)tempInput.charAt(i))-(int)convertUnicodeToANSI((int)keyRepeated.charAt(i)));
                } else {
                        tempOutput = convertAnsiToUnicode(convertUnicodeToANSI((int)tempInput.charAt(i))-convertUnicodeToANSI((int)keyRepeated.charAt(i)) +256);
                }

                if ((int)tempOutput < 0) {
                        tempOutput = (char)((int)tempOutput+256);
                }

                this.decrypted_ += tempOutput;
               
                tempOutput = ' ';
        }
        
    }
    
    public String getEncryptedText() {
    	return this.encrypted_;
    }
    public String getDecryptedText() {
    	return this.decrypted_;
    }
    public String getKey() {
    	return this.key_;
    }
 
    public String getOutputText(){
        return this.outputText_;
        
    }
    
//    public static void main(String[] args) {
//        VigenereCipher vig = new VigenereCipher("Hello World", "key");
//        System.out.println(vig.getOutputText());
//    }
}
