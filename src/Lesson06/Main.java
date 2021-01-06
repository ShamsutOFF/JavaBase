/*    Домашка Java. Уровень 1. Урок 6
        1.Создать 2 текстовых файла, примерно по 50-100 символов в каждом (особого значения не имеет);
2. Написать программу, «склеивающую» эти файлы, то есть вначале идет текст из первого файла, потом текст из второго.
        3. * Написать программу, которая проверяет присутствует ли указанное пользователем слово в файле.
        4. ** Написать метод, проверяющий, есть ли указанное слово в папке

*/
package Lesson06;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        String searchWord = "the";   // Искомое слово
//        try {
//            FileOutputStream fos = new FileOutputStream ("src/Lesson06/Test_01en.txt");
//            byte[] str = "As has been repeatedly mentioned, the direct participants of technological progress are made public.".getBytes ();
//            try {
//                fos.write (str);
//            } catch (IOException e) {
//                e.printStackTrace ( );
//            }
//            try {
//                fos.close ();
//            } catch (IOException e) {
//                e.printStackTrace ( );
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace ( );
//        }


        //--- Поиск фалов с расширением .txt в указанной папке ---//

        File dir = new File("src/Lesson06");
        File[] matches = dir.listFiles(new FilenameFilter()
        {
            public boolean accept(File dir, String name)
            {
                return name.endsWith(".txt");
            }
        });
        //---------------------------------------------------------//

        //--- Сначала реализовал поиск только в конкретном файле. Потом немного апгрейдил. Так что два задания (3 и 4) в одном.
        for (File match : matches) {
            try {
                FileInputStream fis = new FileInputStream (match);
                byte[] content = new byte[fis.available ( )];
                fis.read (content);
                fis.close ( );
                String[] lines = new String (content).split ("\n");
                int i = 1;
                int s = 0;
                for (String line : lines) {
                    String[] words = line.split (" ");
                    int j = 1;
                    for (String word : words) {
                        if (word.equalsIgnoreCase (searchWord)) {
                            System.out.println ("Найдено в файле " + match + " в " + i + "-й строке, " + j + "-е слово ");
                            s++;
                        }
                        j++;
                    }
                    i++;
                }
                if (s == 0) System.out.println ("В файле " + match + " Такого слова нет");
            } catch (IOException e) {
                e.printStackTrace ( );
            }
        }


        //--- задача по объединению 2х файлов в третий ---//

        try {
            FileInputStream fis = new FileInputStream ("src/Lesson06/Test_01en.txt");
            FileInputStream fis2 = new FileInputStream ("src/Lesson06/Test_02en.txt");
            FileOutputStream fos = new FileOutputStream ("src/Lesson06/Test_011.txt");
            int a;
            int b;
    //        StringBuilder builder = new StringBuilder ();
            while ((a = fis2.read()) != -1){
                while ((b = fis.read()) != -1){
                    fos.write ((char) b);
    //                builder.append ((char) b);
//                    System.out.print ((char) b);
                }
                fos.write ((char) a);
//                System.out.print ((char) a);
    //            builder.append ((char) a);
            }
    //        System.out.print (builder);
        } catch (IOException e) {
            e.printStackTrace ( );
        }
    }
}



