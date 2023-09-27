package com.example.myapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.translation.Translator
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.mlkit.common.model.DownloadConditions
import com.google.mlkit.nl.languageid.LanguageIdentification
import com.google.mlkit.nl.languageid.LanguageIdentifier
import com.google.mlkit.nl.translate.TranslateLanguage
import com.google.mlkit.nl.translate.Translation
import com.google.mlkit.nl.translate.TranslatorOptions

class Text : AppCompatActivity() {
    lateinit var textInputEditText: EditText
    lateinit var  translatebutton: Button
lateinit var tvresult:TextView
lateinit var translatedtext: TextView
var originaltext : String=""
   // lateinit var englishHindiTranslator : Translator
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text)

        textInputEditText=findViewById(R.id.textinput)
        translatebutton=findViewById(R.id.translatebutton)
         tvresult=findViewById(R.id.result)
        translatedtext=findViewById(R.id.tranlatedtext)
        translatebutton.setOnClickListener{
            originaltext=textInputEditText.text.toString()
            prepareTranslateModel();
            val langText: String=textInputEditText.text.toString()
            if(langText.equals("")){
                Toast.makeText(this@Text, "Please enter text", Toast.LENGTH_SHORT).show()
            }else{
                detectLang(langText)
            }
        }
    }


    private fun prepareTranslateModel(){
        val options : TranslatorOptions = TranslatorOptions.Builder()
            .setSourceLanguage(TranslateLanguage.ENGLISH)
            .setTargetLanguage(TranslateLanguage.HINDI)
            .build()

     val  englishHindiTranslator = Translation.getClient(options)
        var conditions = DownloadConditions.Builder()
            .requireWifi()
            .build()

        englishHindiTranslator.downloadModelIfNeeded(conditions).addOnSuccessListener {
           // translateText()
            englishHindiTranslator.translate(textInputEditText.toString()).addOnSuccessListener {
                translatedtext.text=it  }.addOnFailureListener {
                    translatedtext.text="error"
            }
        }.addOnFailureListener {
            translatedtext.text="error)"
        }
    }

  //  private fun translateText() {
    //    englishHindiTranslator
    //}

    private fun detectLang(langText: String) {
val languageIdentifier : LanguageIdentifier=LanguageIdentification.getClient()
      //  languageIdentifier.identifyLanguage(langText).addOnCanceledListener { (languageCode) ->
         //   if(languageCode.equals("und"))
      //  }
        languageIdentifier.identifyLanguage(langText)
            .addOnSuccessListener { languageCode ->
                if (languageCode == "und") {

                    tvresult.text="can't identify your language make sure your camera is clean";
                } else {

                    tvresult.text= "Language: $languageCode";
                }
            }
            .addOnFailureListener {
                tvresult.text="Exception ${it.message}"
            }
    }
}