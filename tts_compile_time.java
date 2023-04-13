import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

 class text_to_sppech {
    public static void main(String[] args) {

        System.setProperty("freetts.voices","com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");

    Voice voice = VoiceManager.getInstance().getVoice("kevin16");

    //print all voices
        Voice []voicelist = VoiceManager.getInstance().getVoices();
        for(int i=0; i<voicelist.length; ++i)
        {
            System.out.println("# Voice: "+voicelist[i].getName());
        }

        if(voice != null)
        {
            voice.allocate();
            System.out.println("Voice Rate: "+voice.getRate());
            System.out.println("Voice Pitch: "+voice.getPitch());
            System.out.println("Voice Volume: "+voice.getVolume());
            boolean status = voice.speak("Hello sir ! I am JARVIS, your personal artificial intelligence, speed 1 teraheart, memory 1 setabye. I am here to assist you sir.  Please tell me how may I help you ?");
            System.out.println("Status: "+status);
            voice.deallocate();

        }
        else
            System.out.println("Error in getting Voices");
    }
}
