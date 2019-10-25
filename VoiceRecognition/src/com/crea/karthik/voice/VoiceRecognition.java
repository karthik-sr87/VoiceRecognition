package com.crea.karthik.voice;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;

public class VoiceRecognition {

	public static void main(String[] args) throws Exception {
		StartBrowser browser = new StartBrowser();
        //Configuration Object
        Configuration configuration = new Configuration();
 
        // Set path to the acoustic model.
        configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
        // Set path to the dictionary.
        configuration.setDictionaryPath("resource:/0342.dic");
        // Set path to the language model.
        configuration.setLanguageModelPath("resource:/0342.lm");
 
        //Recognizer object, Pass the Configuration object
        LiveSpeechRecognizer recognize = new LiveSpeechRecognizer(configuration);
 
        //Start Recognition Process (The bool parameter clears the previous cache if true)
        recognize.startRecognition(true);
 
        //Creating SpeechResult object
        SpeechResult result;
 
        //Check if recognizer recognized the speech
        while ((result = recognize.getResult()) != null) {
 
            //Get the recognized speech
            String command = result.getHypothesis();
            //Match recognized speech with our commands
            if (command.equalsIgnoreCase("hi cathy")) {
                System.out.println("Yes. How can i help you?");
            } else if (command.equalsIgnoreCase("open justperform")) {
                System.out.println("open justperform");
                browser.openUrl("https://live.justperform.com");
            } else if (command.equalsIgnoreCase("go to initiate") || command.equalsIgnoreCase("open initiate")) {
                System.out.println("go to initiate");
                browser.openUrl("https://live.justperform.com/JustPerform/process/processList.htm");
            } else if (command.equalsIgnoreCase("go to modelling") || command.equalsIgnoreCase("open modelling")) {
                System.out.println("go to modelling");
                browser.openUrl("https://live.justperform.com/JustPerform/dimension/loadModelling.htm");
            } else if (command.equalsIgnoreCase("go to deploy") || command.equalsIgnoreCase("open deploy")) {
                System.out.println("go to deploy");
                browser.openUrl("https://live.justperform.com/JustPerform/deploy/deployWizard.htm");
            } else if (command.equalsIgnoreCase("go to process discovery") || command.equalsIgnoreCase("open process discovery")) {
                System.out.println("go to process discovery");
                browser.openUrl("https://live.justperform.com/JustPerform/response/loadPageList.htm?pageType=1&processType=1");
            }
        }
    }
}
