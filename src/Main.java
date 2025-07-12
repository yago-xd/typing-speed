import java.util.Scanner;
import java.util.Random;
public class Main {
    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();
    static float time, accuracy_total, accuracy_input;
    static int raw_wpm,final_wpm;
    static String[] sentences = {
            "The quick brown fox jumps over the lazy dog, unaware that it was being watched by a curious cat on the windowsill.",
            "Although it was raining heavily, the children decided to play outside, splashing in puddles and laughing with joy.",
            "Technology has advanced rapidly in the last decade, revolutionizing the way we communicate, work, and live our daily lives.",
            "She opened the old leather-bound book and, with a deep breath, began reading the forgotten stories written by her ancestors.",
            "If you want to achieve greatness, you must first believe in yourself and work diligently, even when success seems far away.",
            "In a world full of distractions and noise, finding a moment of silence can be the most powerful gift you give yourself.",
            "Despite the chaos around them, the two friends remained calm and focused, trusting that everything would work out in the end.",
            "The museum was filled with ancient artifacts, each telling a silent story of civilizations that had long disappeared.",
            "After a long day at work, she sat by the window with a cup of tea, watching the sun slowly dip below the horizon.",
            "His speech, though brief, was incredibly powerful—leaving the audience in thoughtful silence long after he had left the stage."
    };
    static String sentence;
    static String user_input;
    static long start_dur,end_dur;
    static int word_count=0;
    public static void get_sentence(){
        sentence = sentences[rand.nextInt(sentences.length)];
    }
    public static float time_taken(long start, long end){
        long diff=end-start;
        float ts=diff/1000.0f;
        float tm=ts/60.0f;
        return Math.round(tm*10)/10f;
    }
    public static void welcome(){
        System.out.println("Welcome to the Typing Speed Checker!");
        System.out.println("You will be shown a sentence");
        System.out.println("Type it as fast and as accurately as you can (including punctuation)");
        System.out.println("Good luck!");
    }
    public static void start() throws InterruptedException {
        System.out.print("\nPress Enter when ready: ");
        while(true){
            if(sc.hasNextLine())
                break;
        }
        sc.nextLine();
        System.out.println();
        for(int i=3;i>=1;i--){
            System.out.print("\rTyping Test is starting in "+i);
            Thread.sleep(1000);
        }
        System.out.print("\rTyping Test has started");
        System.out.println("\nType this: ");
        get_sentence();
        System.out.println("\""+sentence+"\"");
        start_dur=System.currentTimeMillis();
        user_input = sc.nextLine();
        end_dur=System.currentTimeMillis();
        System.out.println("You typed: \""+user_input+"\"");
    }
    public static void calculate(){
        int accu_count=0;
        time=time_taken(start_dur,end_dur);
        int len = Math.min(sentence.length(),user_input.length());
        word_count = user_input.trim().split("\\s+").length;
        if(time>0)
            raw_wpm =(int)(word_count/time);
        else
            raw_wpm =0;
        for(int i=0;i<len;i++){
            char user = user_input.charAt(i);
            char comp = sentence.charAt(i);
            if(user==comp)
                accu_count++;
        }
        final_wpm=(int)(accu_count/time);
        accuracy_total=((float)accu_count/sentence.length())*100.0f;
        accuracy_total=((int)(accuracy_total *10))/10f;
        accuracy_input=((float)accu_count/user_input.length())*100.0f;
        accuracy_input=((int)(accuracy_input *10))/10f;
    }
    public static void display(){
        System.out.println("\n------------Results------------");
        System.out.println("Time Taken: "+(time*60.0f)+"s");
        System.out.println("Words Typed: "+ word_count);
        System.out.println("Raw WPM: "+ raw_wpm);
        System.out.println("Full Sentence Accuracy: "+ accuracy_total +"%");
        System.out.println("Typed Sentence Accuracy: "+ accuracy_input +"%");
    }
    public static void main(String[] args) throws InterruptedException {
        welcome();
        start();
        calculate();
        display();
    }
}