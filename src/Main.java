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
        System.out.println("╔══════════════════════════════════════════════════╗");
        System.out.println("║       👋 Welcome to the Typing Speed Test!       ║");
        System.out.println("╠══════════════════════════════════════════════════╣");
        System.out.println("║ ✨ You’ll be shown a sentence to type.           ║");
        System.out.println("║ ⌨️ Try to type it as quickly and accurately      ║");
        System.out.println("║     as possible — punctuation included!          ║");
        System.out.println("║ 🎯 Let’s see how fast those fingers can fly!     ║");
        System.out.println("╚══════════════════════════════════════════════════╝\n");
    }
    public static void start() throws InterruptedException {
        System.out.print("👉 Press Enter when you're ready to begin: ");
        while(true){
            if(sc.hasNextLine())
                break;
        }
        sc.nextLine();
        System.out.println();
        System.out.print("⏳ Get ready! The typing test begins in ");
        for (int i = 3; i >= 1; i--) {
            System.out.print("\r⏳ Get ready! The typing test begins in ⏱️ " + i);
            Thread.sleep(1000);
        }
        System.out.print("\r✅ Go! Start typing the following sentence: \n");
        get_sentence();
        System.out.println("📄 \"" + sentence + "\"");
        start_dur=System.currentTimeMillis();
        user_input = sc.nextLine();
        end_dur=System.currentTimeMillis();
        System.out.println("📝 You typed: \"" + user_input + "\"");
    }
    public static void calculate(){
        int char_count =0;
        int corr_count=0;
        time=time_taken(start_dur,end_dur);
        String[] original_words = sentence.trim().split("\\s+");
        String[] typed_words = user_input.trim().split("\\s+");
        word_count = typed_words.length;
        int len = Math.min(original_words.length,typed_words.length);
        for (int i=0;i<len;i++){
            if(original_words[i].equals(typed_words[i])){
                corr_count++;
            }
        }
        if(time>0) {
            raw_wpm=(int)(word_count/time);
            final_wpm=(int)(corr_count/time);
        }
        else {
            raw_wpm = 0;
            final_wpm = 0;
        }
        for(int i=0;i<len;i++){
            char user = user_input.charAt(i);
            char comp = sentence.charAt(i);
            if(user==comp)
                char_count++;
        }
        accuracy_total=((float) char_count /sentence.length())*100.0f;
        accuracy_total=((int)(accuracy_total *10))/10f;
        accuracy_input=((float) char_count /user_input.length())*100.0f;
        accuracy_input=((int)(accuracy_input *10))/10f;
    }
    public static void display(){
        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━ 📊 RESULTS 📊 ━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("⏱️ Time Taken: "+time*60.0f+"s");
        System.out.println("✍️ Words Typed: " + word_count);
        System.out.println("🚀 Raw Speed (WPM): " + raw_wpm);
        System.out.println("🎯 Accurate Speed (WPM): " + final_wpm);
        System.out.println("📌 Sentence Match Accuracy: " + accuracy_total + "%");
        System.out.println("📌 Typed Input Accuracy:    " + accuracy_input + "%");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        if(final_wpm>=60)
            System.out.println("🔥 Incredible speed! You're a typing wizard!");
        else if(final_wpm>=40)
            System.out.println("💪 Great job! Keep practicing and you'll be even faster.");
        else
            System.out.println("👍 Good start! Keep practicing to improve your accuracy and speed.");
        System.out.println("\n🎉 Thanks for trying the Typing Speed Checker!");
    }
    public static void main(String[] args) throws InterruptedException {
        welcome();
        start();
        calculate();
        display();
    }
}