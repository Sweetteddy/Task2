import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.*;

public class EnumWords {

    private String message;
    private String[] arrMessage;

    public String readJsonField(String filePath, String fieldTarget) { //метод для чтения json
        message = null;
        JsonParser parser = new JsonParser();
        String elements[] = new String[100];
        int i = 0;
        try {
            System.out.println("Читаем файл...");
            JsonArray jArray = (JsonArray) parser.parse(new FileReader(filePath));
            message = "";
            for (Object o : jArray) {
                JsonObject root = (JsonObject) o;
                elements[i] = root.get(fieldTarget).getAsString(); //добавляем все строки по найденным полям в массив
                message = message + elements[i] + "\n"; //пишем в поле message полученную строку из всего содержимого полей greeting
                i++;
            }
            arrMessage = elements;
            return message;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int searchWord(String wordTarget) { //ищем и считаем требуемое слово
        if(message != null) {
            System.out.println(message);
            message = message.toLowerCase();
            wordTarget = wordTarget.toLowerCase(); //приводим обе строки к одному регистру
            int i = message.indexOf(wordTarget);
            int count = 0;
            while (i >= 0) {
                count++;
                i = message.indexOf(wordTarget, i + 1);
            }
            System.out.println("Слово " + wordTarget + " повторяется " + count + " раз");
            return count;
        }else{
            System.out.println("Сообщение не передано!");
            return -1;
        }
    }

    public int searchSimbols() { //ищем все знаки препинания
        if(message != null) {
            char[] c = {'.', ',', '-', ':', ';', '?', '!'};
            int count = 0;
            char[] ch = message.toCharArray();
            for (int i = 0; i < ch.length; i++) {
                for (int j = 0; j < c.length; j++) {
                    if (ch[i] == c[j]) {
                        count++;
                    }
                }
            }
            System.out.println("Количество знаков препинания: " + count);
            return count;
        } else {
            System.out.println("Сообщение не передано!");
            return -1;
        }
    }

    public void compareStrings(int index1, int index2) {
        if(message != null) {
            if(arrMessage[index1] != null && arrMessage[index2] != null) {
                String[] str1 = arrMessage[index1].split(" ");
                String[] str2 = arrMessage[index2].split(" ");
                for (int i = 0; i < str1.length; i++) {
                    int n = 0;
                    for (int k = 0; k < str2.length; k++)
                        if (str1[i].equalsIgnoreCase(str2[k])) n++;
                    if (n == 0) {
                        System.out.println(str1[i]);
                    }
                }
            }else{
                System.out.println("Индексы заданы неверно");
            }
        }
    }




}
