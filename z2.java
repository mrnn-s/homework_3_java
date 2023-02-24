import java.io.IOException;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
/**
 * Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
 */
public class z2 {    
        private static Logger logger = Logger.getLogger(z2.class.getTypeName()); //сначала логгер
        public static void main(String[] args) throws IOException {
            int[] array = {1, 2, 3, 5,7, 8, 6, 5, 9};
            System.out.println(Arrays.toString(array));
            bubbleSort (array);
            System.out.println(Arrays.toString(array));
        }
    
        private static void bubbleSort (int[] array) throws IOException {
            FileHandler fh = new FileHandler("/Users/mariannasarkisan/Desktop/homework_2_java/log.txt");
            logger.addHandler(fh);
            SimpleFormatter sFormat = new SimpleFormatter();
            fh.setFormatter(sFormat);
            for (int ceiling = array.length; ceiling >= 0; ceiling--) {
                for (int i = 0; i < ceiling && i + 1 < ceiling; i++){
                    if (array[i] > array[i + 1]) {
                        int temp = array[i];
                        array[i] = array[i + 1];
                        array[i + 1] = temp;
                        logger.log (Level.INFO, String.format ("%d <-> %d, %s", array[i], array[i + 1], Arrays.toString(array)));
                    }
                }
            }
        }
    }

