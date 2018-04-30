package edu.gatech.seclass.vcipher;

/*
 * Author: Corey Crooks
 * Email: ccrooks6@gatech.edu
 * Assignment 4: Vigenére Cipher Android Application
 */


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;




public class VCipherActivity extends AppCompatActivity {
    private EditText mytxt;
    private EditText mytxt1;
    private String encryptedString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vcipher);
        encryptedString = "";
        EditText t = (EditText)findViewById(R.id.answer);
        t.setEnabled(false);

    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("TSTAct", "#onPause");
        mytxt.setError(null);
        mytxt1.setError(null);
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("TSTAct", "#onResume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("TSTAct", "#onStart");
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.encryptGroup);
        RadioButton rb = (RadioButton)findViewById(R.id.encrypt);
        rb.setChecked(true);
    }

    public String encrypt(String text, String key) {

        key = key.toLowerCase();
        String output = "";

        for (int i = 0, j = 0; i < text.length(); i++) {
            int cur = (int) text.charAt(i);

            // check for spaces
            if (text.charAt(i) == ' ') {
                output += " ";
            }
            // check for lowercase
            else if (cur >= 'a' && cur <= 'z') {
                output += Character.toString((char) ((cur + key.charAt(j) - 2 * 'a') % 26 + 'a'));
                j = ++j % key.length();
            }
            else if(cur >= 48 && cur <=57 )
            {
                char c = (char)text.charAt(i);
                output += c;
            }
            else if(cur == 46)
            {
                char c = (char)text.charAt(i);
                output += c;
            }
            //  work for uppercase between 'A' and 'Z'
            else {
                output += Character.toString((char) ((cur -'A' + key.charAt(j) - 'a') % 26 + 'A'));
                j = ++j % key.length();
            }
        }
        return output;
    }


    public static String decrypt(String text, String key) {

        key = key.toLowerCase();
        String res = "";

        for (int i = 0, j = 0; i < text.length(); i++) {
            char c = text.charAt(i);


            if (c >= 'a' && c <= 'z'){
                key= key.toLowerCase();
            res += (char)((c - key.charAt(j) + 26) % 26 + 'a');
                j = ++j % key.length();}

            else if(c == 46)
            {
                char ch = (char)text.charAt(i);
                res += ch;
            }

            else if(Character.isDigit(c))
            {
                res += c;
            }
           else  if (text.charAt(i) == ' ') {
                res += " ";
            }

            else{
                //67-
                key = key.toUpperCase();
                res += (char) ((c - key.charAt(j) + 26) % 26 + 'A');
                j = ++j % key.length();
            }

        }
        return res;
    }







    public void sendMessage(View view) {
        boolean showResult = true;
        mytxt = (EditText)findViewById(R.id.text);
        String t = mytxt.getText().toString();
        mytxt.setError(null);

        mytxt1 = (EditText)findViewById(R.id.keyphrase);
        String t2 = mytxt1.getText().toString();
        mytxt1.setError(null);

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.encryptGroup);
        int radioButtonID = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = (RadioButton) radioGroup.findViewById(radioButtonID);

        String selectedtext = (String) radioButton.getText();
        Log.d("Yead",selectedtext);


        if(t.equals("") & t2.equals("")) {
            mytxt1.setError("Keyphrase required");
            showResult = false;
        }


        if(!t2.matches("[a-zA-Z]+")){
            mytxt1.setError("Non-alphabetic character(s) in keyphrase");
            showResult = false;
        }

        if(!t.equals("") && (t2.equals("") || t2 == null)){
            mytxt.setError("Nothing to encode/decode");
            mytxt1.setError("Keyphrase required");
            showResult = false;
        }

        if(t.equals("")&& t2.equals(""))
        {
            mytxt.setError("Nothing to encode/decode");
            mytxt1.setError("Keyphrase required");
            showResult = false;
        }






        // Todo: handle nulls

        if(showResult) {

            if(selectedtext.toLowerCase().contains("encrypt"))
            {


                String repeated = createKey(t,t2);
                encryptedString =  encrypt(t,repeated);
               // encryptedString =  encode(test.toLowerCase(),repeated);
                EditText answer = (EditText) findViewById(R.id.answer);
                answer.setText(encryptedString);
            }else if(selectedtext.toLowerCase().contains("decrypt"))
            {
                if(encryptedString == "")
                    encryptedString = t;

                 String test = t;
                String keyWord = t2;
                String repeated = createKey(test,keyWord);
                String decrypted = decrypt(test,repeated);

                EditText answer = (EditText) findViewById(R.id.answer);
                answer.setText(decrypted);
            }


        }
    }
    //create the repeating key.
    private String createKey(String text, String keyword) {
        text = text.replaceAll("\\s+","");
        StringBuilder key = new StringBuilder();
        for (int i = 0, keywordIndex = 0; i < text.length(); i++,keywordIndex++) {
            if (keywordIndex >= keyword.length()) {
                keywordIndex = 0;
            }
            if(text.charAt(i) != ' ' || Character.isLetter(text.charAt(i)))
            key.append(keyword.charAt(keywordIndex));
            else{
                key.append(' ');

            }
        }
        return key.toString();
    }
}